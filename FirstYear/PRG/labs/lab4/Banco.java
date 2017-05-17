/**
 * Clase Banco para representar un conjunto de cuentas.
 * @author PRG 
 * @version Curso 2014/15
 */
public class Banco {
    
    /** Array de objetos Cuenta. */
    private Cuenta[] cuentas;
    /** Número actual de cuentas y primer índice disponible en el array cuentas. */
    private int numCuentas;
    /** Número máximo de cuentas. */
    public static final int MAX_CUENTAS = 100;

    /**
     * Crea un banco sin cuentas (puede tener un máximo de MAX_CUENTAS cuentas).
     */
    public Banco() {
        this.cuentas = new Cuenta[MAX_CUENTAS];
        this.numCuentas = 0;
    }

    /**
     * Consultor del número actual de cuentas.
     * @return int, número actual de cuentas.
     */
    public int getNumCuentas() { return numCuentas; }
    
    /**
     * Permite añadir la Cuenta c al banco. Si el banco está completo,
     * duplica el número de cuentas que pueden haber en el banco.
     * @param c Cuenta a añadir.
     */
    public void añadir(Cuenta c) {
        if (numCuentas >= cuentas.length) duplica();   
        cuentas[numCuentas++] = c;
    }
    
    /**
     * Duplica el tamaño del array cuentas.
     */
    private void duplica() {
        Cuenta[] aux = new Cuenta[2*cuentas.length];
        for (int i = 0; i < cuentas.length; i++) aux[i] = cuentas[i];
        cuentas = aux;
    }

    /**
     * Devuelve la cuenta con número de cuenta n.
     * Si tal cuenta no existe, devuelve null.
     * @param n int que indica el número de cuenta.
     * @return Cuenta, la cuenta resultado.
     */
    public Cuenta getCuenta(int n) {
        int i = 0;
        while (i < numCuentas && cuentas[i].getNumCuenta() != n) i++;
        if (i < numCuentas) return cuentas[i];
        else return null;
    }

    /**
     * Devuelve una String con toda la información del banco.
     * El formato es una cuenta por línea.
     * @return String.
     */
    public String toString() {
        if (numCuentas == 0) return "No hay cuentas en el banco";
        else {
            String res = "";
            for (int i = 0; i < numCuentas; i++) res += cuentas[i] + "\n"; 
            return res;
        }        
    }
}
