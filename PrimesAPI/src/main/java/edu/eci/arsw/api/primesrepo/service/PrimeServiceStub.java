package edu.eci.arsw.api.primesrepo.service;

import edu.eci.arsw.api.primesrepo.model.FoundPrime;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Cesar Villamil
 * 10/09/2020
 */

@Service
public class PrimeServiceStub implements PrimeService

{
    private CopyOnWriteArrayList<FoundPrime> primos;

    public PrimeServiceStub() {
        primos = new CopyOnWriteArrayList<>();
        FoundPrime Federer = new FoundPrime();
        Federer.setUser("Federer");
        Federer.setPrime("656601");
        FoundPrime Nadal = new FoundPrime();
        Nadal.setUser("Nadal");
        Nadal.setPrime("552721");
        FoundPrime Djokovic = new FoundPrime();
        Djokovic.setUser("Djokovic");
        Djokovic.setPrime("530881");
        FoundPrime Murray = new FoundPrime();
        Murray.setUser("Murray");
        Murray.setPrime("512461");
        FoundPrime Medvedev = new FoundPrime();
        Medvedev.setUser("Medvedev");
        Medvedev.setPrime("488881");
        FoundPrime Thiem = new FoundPrime();
        Thiem.setUser("Thiem");
        Thiem.setPrime("449065");
        primos.add(Federer);
        primos.add(Nadal);
        primos.add(Djokovic);
        primos.add(Murray);
        primos.add(Medvedev);
        primos.add(Thiem);


    }
    @Override
    public void addFoundPrime(FoundPrime fp) throws FoundPrimeException {
        for (FoundPrime iterador:primos) {
            if(iterador.getPrime().equals(fp.getPrime())){
                throw new FoundPrimeException("El numero ya existe");
            }
        }
        primos.add(fp);
    }

    @Override
    public List<FoundPrime> getFoundPrimes() {
        return primos;
    }

    @Override
    public FoundPrime getPrime(String prime) {
        for (int i = 0; i < primos.size(); i++) {
            if (primos.get(i).getPrime().equals(prime)) {
                return primos.get(i);
            }
        }
        return null;
    }
}
