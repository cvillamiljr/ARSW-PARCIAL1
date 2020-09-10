package edu.eci.arsw.primefinder;

import edu.eci.arsw.math.MathUtilities;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PrimeFinder {


    public static void findPrimes(BigInteger _a, BigInteger _b, PrimesResultSet prs) {

        ArrayList<Concurrent> hilos = new ArrayList<>();
        BigInteger a = _a;
        BigInteger b = _b;
        BigInteger cantidad = new BigInteger("4");
        BigInteger total = null;
        total = b.subtract(a).divide(cantidad);
        int division = Math.round(total.intValue());
        for (int i = 0; i < 4; i++) {
            int inicio = (division * i);
            int fin = (division * (i + 1)) - 1;
            Concurrent hilo = new Concurrent(new BigInteger(String.valueOf(inicio + a.intValue())), new BigInteger(String.valueOf(fin + a.intValue())), prs);
            hilos.add(hilo);
        }
        for (Concurrent i : hilos) {
            i.start();
        }
        for (Concurrent i : hilos) {
            try {
                i.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }


}
