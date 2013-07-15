/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.math.BigInteger;
import java.util.Random;

/**
 *
 * @author Roberto
 */
public class RSA {

    int tamPrimo;
    BigInteger n, q, p;
    BigInteger totient;
    BigInteger e, d;
    double t_genPrimos;
    double t_genClaves;
    double t_encriptando;
    double t_desencriptando;
    BigInteger encriptado[];

    public RSA(int tamPrimo) {
        this.tamPrimo = tamPrimo;
    }

    public RSA() {
    }

    /**
     * Genera primos: p y q
     *
     * @param algoPrimos nro entre 0 y 3
     */
    public void generaPrimos(int algoPrimos) {
        double t_ini = System.currentTimeMillis();
        p = new BigInteger(tamPrimo, new Random());
        q = new BigInteger(tamPrimo, new Random());

        if (algoPrimos == 0) {
            /*while (!esPrimo(p)) {
                p = new BigInteger(tamPrimo, new Random());
            }
            do {
                while (!esPrimo(q)) {
                    q = new BigInteger(tamPrimo, new Random());
                }
            } while (q.compareTo(p) == 0);*/
        } else if (algoPrimos == 1) {
        } else if (algoPrimos == 2) {
        } else if (algoPrimos == 3) {
        }
        
        t_genPrimos = System.currentTimeMillis() - t_ini;
    }

    /**
     * Genera las claves: e y d, asi como el nro totient
     * @param algoClavePriv nro entre 0 y 2
     */
    public void generaClaves(int algoClavePriv) {
        double t_ini = System.currentTimeMillis();
        // n = p * q
        n = p.multiply(q);
        // toltient = (p-1)*(q-1)
        totient = p.subtract(BigInteger.valueOf(1));
        totient = totient.multiply(q.subtract(BigInteger.valueOf(1)));
        // Elegimos un e coprimo de y menor que n
        do {
            e = new BigInteger(2 * tamPrimo, new Random());
        } while ((e.compareTo(totient) != -1) || (e.gcd(totient).compareTo(BigInteger.valueOf(1)) != 0));
        // d = e^1 mod totient
        //d = e.modInverse(totient);
        if (algoClavePriv == 0) {
            // Elegimos un e coprimo de y menor que n
            do {
                e = new BigInteger(2 * tamPrimo, new Random());
            } while ((e.compareTo(totient) != -1)
                    || (e.gcd(totient).compareTo(BigInteger.valueOf(1)) != 0));
            // d = e^1 mod totient
            d = e.modInverse(totient);
        } else if (algoClavePriv == 1) {
            //d = genClavePriv();
        } else if (algoClavePriv == 2) {
        }

        t_genClaves = System.currentTimeMillis() - t_ini;
    }

    /**
     * Genera primos: p y q usando el algoritmo interno de BigInteger
     */
    public void generaPrimos() {
        p = new BigInteger(tamPrimo, 10, new Random());
        do {
            q = new BigInteger(tamPrimo, 10, new Random());
        } while (q.compareTo(p) == 0);
    }

    public void generaClaves() {
        // n = p * q
        n = p.multiply(q);
        // toltient = (p-1)*(q-1)
        totient = p.subtract(BigInteger.valueOf(1));
        totient = totient.multiply(q.subtract(BigInteger.valueOf(1)));
        // Elegimos un e coprimo de y menor que n
        do {
            e = new BigInteger(2 * tamPrimo, new Random());
        } while ((e.compareTo(totient) != -1)
                || (e.gcd(totient).compareTo(BigInteger.valueOf(1)) != 0));
        // d = e^1 mod totient
        d = e.modInverse(totient);
    }

    public BigInteger[] encriptar(String mensaje) {
        double t_ini = System.currentTimeMillis();
        int i;
        byte[] temp = new byte[1];
        byte[] digitos = mensaje.getBytes();
        BigInteger[] bigdigitos = new BigInteger[digitos.length];
        //esquema de relleno
        for (i = 0; i < bigdigitos.length; i++) {
            temp[0] = digitos[i];
            bigdigitos[i] = new BigInteger(temp);
        }

        encriptado = new BigInteger[bigdigitos.length];

        for (i = 0; i < bigdigitos.length; i++) {
            encriptado[i] = bigdigitos[i].modPow(e, n);
        }

        t_encriptando = System.currentTimeMillis() - t_ini;
        return (encriptado);
    }

    public String desencriptar(BigInteger[] encriptado) {
        double t_ini = System.currentTimeMillis();
        BigInteger[] desencriptado = new BigInteger[encriptado.length];

        for (int i = 0; i < desencriptado.length; i++) {
            desencriptado[i] = encriptado[i].modPow(d, n);
        }

        char[] charArray = new char[desencriptado.length];

        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = (char) (desencriptado[i].intValue());
        }

        t_desencriptando = System.currentTimeMillis() - t_ini;
        return (new String(charArray));
    }
    
    public void setTamPrimo(int tamPrimo) {
        this.tamPrimo = tamPrimo;
    }

    public BigInteger[] getEncriptado() {
        return encriptado;
    }
    
    public BigInteger getP() {
        return p;
    }

    public BigInteger getQ() {
        return q;
    }

    public BigInteger getTotient() {
        return totient;
    }

    public BigInteger getE() {
        return e;
    }

    public BigInteger getD() {
        return d;
    }

    public double getT_genPrimos() {
        return t_genPrimos;
    }

    public double getT_genClaves() {
        return t_genClaves;
    }

    public double getT_desencriptando() {
        return t_desencriptando;
    }

    public double getT_encriptando() {
        return t_encriptando;
    }
}