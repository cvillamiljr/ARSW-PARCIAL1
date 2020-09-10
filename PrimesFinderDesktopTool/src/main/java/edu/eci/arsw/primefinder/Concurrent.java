package edu.eci.arsw.primefinder;

import edu.eci.arsw.math.MathUtilities;

import java.math.BigInteger;

public class Concurrent extends Thread {

    private final BigInteger inicio;
    private final BigInteger fin;
    private final PrimesResultSet prs;

    public Concurrent (BigInteger _a, BigInteger _b, PrimesResultSet prs) {
        this.inicio = _a;
        this.fin = _b;
        this.prs = prs;


    }
    public void run(){

        MathUtilities mt=new MathUtilities();
        int itCount=0;

        BigInteger i = inicio;
        while (i.compareTo(fin)<=0){
            itCount++;
            if (mt.isPrime(i)){
                prs.addPrime(i);

            }

            i=i.add(BigInteger.ONE);
        }
    }
}
