#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include <mpi.h>

#define MAX_DIM 2048
#define EPSILON 1e-16
#define CHECK(rc, paso) (rc) ? printf("Error %d, paso %d\n", rc, paso) : 0
#define MIN(a, b) (((a) < (b)) ? (a) : (b))
#define VERBOSE

/* Generador de matrices bien condicionadas           */
/* Entrada: Dimension del problema                    */
/* Salida: Puntero a la Matriz Generada               */
/* Notas: Reserva memoria, devuelve NULL ante errores */
double **ppdGenMat(int nN, int nM)
{
  int i;
  double **pdMat = NULL;
  double *pdWorkArea = NULL;

  if ((nN > 0) && (nM > 0) && (nM <= MAX_DIM)) {
    /* Reserva un area contigua para todas las filas */
    pdWorkArea = (double *)malloc(sizeof(double) * nN * nM);
    pdMat = (double **)malloc(sizeof(double *) * nN);
    if (pdWorkArea && pdMat)
      for (i = 0; i < nN; i++)
        pdMat[i] = (pdWorkArea + nM * i);
  }
  return pdMat;
}

/* Rellena los elementos de la matriz                */
/* Es una matriz de Toeplitz diagonalmente dominante */
int nRellenaMat(double **ppdMat, int nN, int nM)
{
  int i, j;

  if (ppdMat) {
    for (i = 0; i < nN; i++)
      for (j = 0; j < nM; j++)
        if (i == j)
          ppdMat[i][j] = nN * nN;
        else
          ppdMat[i][j] = nN - abs(i - j);

    return 0;
  } else {
    return -1;
  }
}

/* Generador del vector de términos independientes    */
/* de forma que la solución del sistema de ecuaciones */
/* sea [1,1,...,1]'                                   */
double *pdGenTI(int nN)
{
  int i, j;
  double *pdVec = NULL;

  if ((nN > 0) && (nN <= MAX_DIM)) {
    pdVec = (double *)malloc(sizeof(double) * nN);
    if (pdVec) {
      for (i = 0; i < nN; i++) {
        pdVec[i] = nN * nN;
        for (j = 0; j < i; j++)
          pdVec[i] += nN - j - 1;
        for (j = i + 1; j < nN; j++)
          pdVec[i] += j;
      }
    }
  }
  return pdVec;
}

/* Impresion de una matriz                                */
/* Entrada: Matriz a imprimir y sus dimensiones           */
/* Salida: Diferentes codigos de error                    */
int nPrintMat(double **ppdMat, int nN, int nM)
{
  int i, j;

  if (ppdMat == NULL)
    return -2;

  if ((nN < 0) || (nN > MAX_DIM) || (nM <= 0) || (nM > MAX_DIM))
    return -3;

  for (i = 0; i < nN; i++) {
    for (j = 0; j < nM; j++)
      printf("%7.3f ", ppdMat[i][j]);
    printf("\n");
  }
  return 0;
}

/* Libera una Matriz y el area apuntada */
int nLiberaMat(double **ppdMat)
{
  if (ppdMat) {
    if (ppdMat[0]) {
      free(ppdMat[0]);
      free(ppdMat);
      return 0;
    }
  }
  return -1;
}

/* Impresion de un vector                                 */
/* Entrada: Vector a imprimir y su dimension              */
/* Salida: Diferentes codigos de error                    */
int nPrintVec(double *ppdVec, int nN)
{
  int i;

  if (ppdVec == NULL)
    return -2;

  if ((nN < 0) || (nN > MAX_DIM))
    return -3;

  for (i = 0; i < nN; i++)
    printf("%7.3f ", ppdVec[i]);
  printf("\n");
  return 0;
}

/* Factorizacion LU                                       */
/* Realiza la descomposicion LU sobre la matriz A         */
/* En el triangulo superior de A deja la U y en el inf.   */
/* deja la L. La diagonal pertenece a la U.               */
/* Entrada: Matriz A y dimension                          */
/* Salida: Matriz L / U                                   */
int nLU(double **ppdMat, int nN, int nId, int nP, int nBloque)
{
  int i, j, k;
  double *pdPivote;

  if (ppdMat == NULL)
    return -2;

  if ((nN <= 0) || (nN > MAX_DIM))
    return -3;

  pdPivote = (double *)malloc(sizeof(double) * nN);

  for (k = 0; k < nN - 1; k++) {
    if (k % nP == nId) {
      if (fabs(ppdMat[k / nP][k]) < EPSILON) return -1;
      memcpy(pdPivote, ppdMat[k / nP], nN * sizeof(double));
    }

    MPI_Bcast(pdPivote, nN, MPI_DOUBLE, k % nP, MPI_COMM_WORLD);

    for (i = k + 1; i < nN; i++) {
      if (i % nP == nId) {
        ppdMat[i / nP][k] = ppdMat[i / nP][k] / pdPivote[k];
        for (j = k + 1; j < nN; j++)
          ppdMat[i / nP][j] -= ppdMat[i / nP][k] * pdPivote[j];
      }
    }
  }
  free(pdPivote);
  return 0;
}

/* Eliminacion Progresiva                                 */
/* Resuelve el sistema Lx = b                             */
/* Asume que la diagonal sea la unidad                    */
/* Entrada: Matriz L, Vector B y Dimension                */
/* Salida: Vector Resultado                               */
/* Nota: Asume que la memoria esta reservada              */
/* Nota: Devuelve la solucion en el vector B              */
int nElimProg(double **ppdL, double *pdB, int nN, int nId, int nP, int nBloque)
{
  int i, j;

  if (ppdL == NULL)
    return -2;

  if ((nN <= 0) || (nN > MAX_DIM))
    return -3;

  for (i = 0; i < nN; i++) {
    MPI_Bcast(&pdB[i], 1, MPI_DOUBLE, i % nP, MPI_COMM_WORLD);
    for (j = i + 1; j < nN; j++) {
      if (j % nP == nId)
        pdB[j] -= ppdL[j / nP][i] * pdB[i];
    }
  }
  return 0;
}

/* Sustitucion Regresiva                                  */
/* Resuelve el sistema Ux = b                             */
/* Entrada: Matriz U, Vector B y Dimension                */
/* Salida: Vector Resultado                               */
/* Nota: Asume que la memoria esta reservada              */
/* Nota: Devuelve la solucion en el vector B              */
int nSustReg(double **ppdU, double *pdB, int nN, int nId, int nP, int nBloque)
{
  int i, j;

  if (ppdU == NULL)
    return -2;

  if ((nN <= 0) || (nN > MAX_DIM))
    return -3;

  for (i = nN - 1; i >= 0; i--) {
    if (i % nP == nId) {
      if (fabs(ppdU[i / nP][i]) < EPSILON) return -1;
      pdB[i] = pdB[i] / ppdU[i / nP][i];
    }
    MPI_Bcast(&pdB[i], 1, MPI_DOUBLE, i % nP, MPI_COMM_WORLD);
    for (j = i - 1; j >= 0; j--) {
      if (j % nP == nId)
        pdB[j] -= ppdU[j / nP][i] * pdB[i];
    }
  }
  return 0;
}

/* main                                                      */
/* Argumentos: <dimension del problema>                      */
int main(int argc, char *argv[])
{
  double **ppdMat, **ppdMatLcl;
  double *pdX;
  int nN, i, rc;
  int nBloque;  /* Tamaño de bloque */
  int nLocalN;  /* Numero de filas locales */
  int nId, nP;  /* Indice y numero de procesos */
  double dError;

  MPI_Init(&argc, &argv);
  MPI_Comm_rank(MPI_COMM_WORLD, &nId);
  MPI_Comm_size(MPI_COMM_WORLD, &nP);

  if (nId == 0) {
    nN = atoi(argv[1]);
    if ((nN <= 0) || (nN > MAX_DIM)) {
      printf("Error en las dimensiones: %d\n", nN);
      return -1;
    }
  }

  MPI_Bcast(&nN, 1, MPI_INT, 0, MPI_COMM_WORLD);

  /* Calculo del tamaño de bloque y del numero de filas locales */
  nBloque = ceil(((float)nN) / nP);
  nLocalN = MIN(nBloque, nN - nBloque * nId);
  if (nLocalN < 0) nLocalN = 0;

  if (nId == 0) {
    /* Hacemos que la matriz global tenga un numero de filas que sea multiplo
     * del tamaño de bloque, para poder usar MPI_Scatter */
    ppdMat = ppdGenMat(nP * nBloque, nN);
    CHECK(ppdMat == NULL, 0);
    rc = nRellenaMat(ppdMat, nN, nN);
    CHECK(rc, 1);
    ppdMatLcl = ppdGenMat(nBloque, nN);  /* Evitamos conflictos en implementaciones de MPI que no soportan el mismo puntero en Scatter */
  } else {
    /* Matriz local de tamaño nBloque para todos los procesos, para poder
     * usar MPI_Scatter */
    ppdMatLcl = ppdGenMat(nBloque, nN);
    ppdMat = ppdMatLcl;    /* Pequeño parche para evitar que explote el ppdMat[0] del scatter en nId>0 */
    CHECK(ppdMatLcl == NULL, 100);
  }

  if (nId == 0) {
    pdX = pdGenTI(nN);
    CHECK(pdX == NULL, 2);
  } else {
    pdX = (double *)malloc(sizeof(double) * nN);
    CHECK(pdX == NULL, 102);
  }

  MPI_Bcast(pdX, nN, MPI_DOUBLE, 0, MPI_COMM_WORLD);

  MPI_Scatter(ppdMat[0], nBloque * nN, MPI_DOUBLE,
              ppdMatLcl[0], nBloque * nN, MPI_DOUBLE, 0, MPI_COMM_WORLD);

#ifdef VERBOSE
  printf("\nMatriz A (%d)\n", nId);
  rc = nPrintMat(ppdMatLcl, nLocalN, nN);
  CHECK(rc, 4);

  printf("\nVector B (%d)\n", nId);
  rc = nPrintVec(&pdX[nId * nBloque], nLocalN);
  CHECK(rc, 5);
#endif

  rc = nLU(ppdMatLcl, nN, nId, nP, nBloque);
  CHECK(rc, 6);

#ifdef VERBOSE
  printf("\nMatriz LU (%d)\n", nId);
  rc = nPrintMat(ppdMatLcl, nLocalN, nN);
  CHECK(rc, 7);
#endif

#ifdef VERBOSE
  printf("\nVector X antes de EP (%d)\n", nId);
  rc = nPrintVec(pdX, nN);
#endif

  rc = nElimProg(ppdMatLcl, pdX, nN, nId, nP, nBloque);
  CHECK(rc, 8);

#ifdef VERBOSE
  printf("\nVector X tras EP (%d)\n", nId);
  rc = nPrintVec(pdX, nN);
#endif
  rc = nSustReg(ppdMatLcl, pdX, nN, nId, nP, nBloque);
  CHECK(rc, 9);

#ifdef VERBOSE
  printf("\nVector X (%d)\n", nId);
  rc = nPrintVec(pdX, nN);
  CHECK(rc, 10);
#endif

  if (nId == 0) {
    dError = 0.0;
    for (i = 0; i < nN; i++)
      dError += fabs(pdX[i] - 1.0);
    printf("Error total acumulado: %f\n", dError);
  }

  free(pdX);
  rc = nLiberaMat(ppdMatLcl);
  CHECK(rc, 12);
  if (nId == 0) {
    rc = nLiberaMat(ppdMat);
    CHECK(rc, 12);
  }

  MPI_Finalize();
  return 0;
}
