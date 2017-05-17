#include <stdio.h>
#include <mpi.h>
int main (int argc, char *argv[])
{
	int rank, size;
	char name[MPI_MAX_PROCESSOR_NAME];
	MPI_Init(&argc, &argv);
	MPI_Comm_rank(MPI_COMM_WORLD, &rank);
	MPI_Comm_size(MPI_COMM_WORLD, &size);
	MPI_Get_processor_name(name,&size);
	printf("Hello world from process %d of %d\n", rank, size);
	printf("Name of %d : %d\n",rank,name);
	MPI_Finalize();
	
return 0;
}
