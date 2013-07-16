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
        int nroIteraciones = 10;
        BigInteger n = BigInteger.valueOf(2).pow(tamPrimo).subtract(BigInteger.ONE);
        p = new BigInteger(tamPrimo, new Random());
        q = new BigInteger(tamPrimo, new Random());

        if (algoPrimos == -1) {//mi test de primos
            while (!miTestDePrimos(p)) {
                p = p.add(BigInteger.ONE);
                if (p.compareTo(n) == 0) {
                    p = new BigInteger(tamPrimo, new Random());
                }
            }
            do {
                while (!miTestDePrimos(q)) {
                    q = q.add(BigInteger.ONE);
                    if (q.compareTo(n) == 0) {
                        q = new BigInteger(tamPrimo, new Random());
                    }
                }
            } while (q.compareTo(p) == 0);
        } else if (algoPrimos == 1) {//test de fermat
            while (!testDeFermat(p, nroIteraciones)) {
                p = p.add(BigInteger.ONE);
                if (p.compareTo(n) == 0) {
                    p = new BigInteger(tamPrimo, new Random());
                }
            }
            do {
                while (!testDeFermat(q, nroIteraciones)) {
                    q = q.add(BigInteger.ONE);
                    if (q.compareTo(n) == 0) {
                        q = new BigInteger(tamPrimo, new Random());
                    }
                }
            } while (q.compareTo(p) == 0);
        } else if (algoPrimos == 2) {//test de miller-rabin
            while (!testDeMillerRabin(p, nroIteraciones)) {
                p = p.add(BigInteger.ONE);
                if (p.compareTo(n) == 0) {
                    p = new BigInteger(tamPrimo, new Random());
                }
            }
            do {
                while (!testDeMillerRabin(q, nroIteraciones)) {
                    q = q.add(BigInteger.ONE);
                    if (q.compareTo(n) == 0) {
                        q = new BigInteger(tamPrimo, new Random());
                    }
                }
            } while (q.compareTo(p) == 0);
        } else if (algoPrimos == 3) {
        }

        t_genPrimos = System.currentTimeMillis() - t_ini;
    }

    /**
     * Genera las claves: e y d, asi como el nro totient
     *
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

    boolean miTestDePrimos(BigInteger m) {
        switch (m.compareTo(BigInteger.ONE)) {
            case -1:
                return false;
            case 0:
                return false;
        }
        BigInteger w = BigInteger.valueOf(2);
        if (m.compareTo(w)==0) {
            return true;
        }

        if (m.mod(w).equals(BigInteger.ZERO)) {
            return false;
        }
        for (w = BigInteger.valueOf(3); w.multiply(w).compareTo(m) == -1 || w.multiply(w).compareTo(m) == 0; w = w.add(BigInteger.ONE)) {
            if ((m.mod(w)).compareTo(BigInteger.ZERO)==0) {
                return false;
            }
        }
        return true;
    }

    boolean testDeFermat(BigInteger n, int iteraciones) {
        switch (n.compareTo(BigInteger.ONE)) {
            case -1:
                return false;
            case 0:
                return false;
        }
        for (int i = 0; i < iteraciones; i++) {

            double aux = Math.random() * (Integer.MAX_VALUE - 1) + 1;
            int a = (int) aux;
            BigInteger b = BigInteger.valueOf(a);
            b.modPow(n.subtract(BigInteger.ONE), n);
            if (!b.modPow(n.subtract(BigInteger.ONE), n).equals(BigInteger.ONE)) {
                return false;
            }
        }
        return true;
    }

    boolean testDeMillerRabin(BigInteger n, int iteraciones) {
        int c = n.compareTo(BigInteger.valueOf(2));
        if (c == -1) {
            return false;
        }
        if (!(c == 0) && n.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
            return false;
        }

        BigInteger s = new BigInteger(n.toString()).subtract(BigInteger.ONE);
        while (s.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
            s = s.divide(BigInteger.valueOf(2));
        }
        for (int i = 0; i < iteraciones; i++) {
            double aux = Math.random() * (Integer.MAX_VALUE - 1) + 1;
            int a = (int) aux;
            BigInteger b = BigInteger.valueOf(a);
            BigInteger tmp = s;
            BigInteger mod = b.modPow(tmp, n);

            while (!(tmp.equals(n.subtract(BigInteger.ONE))) && !mod.equals(BigInteger.ONE) && !mod.equals(n.subtract(BigInteger.ONE))) {
                mod = (mod.multiply(mod)).mod(n);
                tmp = tmp.multiply(BigInteger.valueOf(2));
            }
            if (!mod.equals(n.subtract(BigInteger.valueOf(1))) && tmp.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
                return false;
            }
        }
        return true;
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