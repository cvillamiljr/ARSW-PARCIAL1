package edu.eci.arsw.primefinder;

import edu.eci.arsw.mouseutils.MouseMovementMonitor;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class PrimesFinderTool {

    private  ArrayList<Concurrent> hilos;
    private PrimeFinder pf;
    private PrimesResultSet prs;

    public PrimesFinderTool(){
        prs = new PrimesResultSet("john");

        pf = new PrimeFinder();
        pf.findPrimes(new BigInteger("1"), new BigInteger("100"), prs);
        hilos =pf.gethilos();

    }

    public void process(){
        for (Concurrent c:hilos) {
            c.start();
        }

        for (Concurrent c:hilos) {
            try {
                c.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    public static void main(String[] args) {
        PrimesFinderTool primesFinder = new PrimesFinderTool();
        Thread processingThread = new Thread(() -> primesFinder.process());
        processingThread.start();
        boolean mouse=true;
        while (mouse) {
            try {
                //check every 10ms if the idle status (10 seconds without mouse
                //activity) was reached.
                Thread.sleep(10);
                if (MouseMovementMonitor.getInstance().getTimeSinceLastMouseMovement() > 10000) {
                    for (Concurrent c: primesFinder.hilos) {
                        c.pausar();
                    }
                    mouse=false;
                } else {
                    for(Concurrent c: primesFinder.hilos){
                        c.resumir();
                    }
                    mouse=true;
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(PrimesFinderTool.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        System.out.println("Prime numbers found:");

        System.out.println(primesFinder.prs.getPrimes());


    }

}


