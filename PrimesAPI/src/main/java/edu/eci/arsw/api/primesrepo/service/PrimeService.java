package edu.eci.arsw.api.primesrepo.service;

import edu.eci.arsw.api.primesrepo.model.FoundPrime;

import java.util.List;

/**
 * @author Cesar Villamil
 * 10/09/2020
 */

public interface PrimeService
{

    void addFoundPrime( FoundPrime foundPrime ) throws FoundPrimeException;

    List<FoundPrime> getFoundPrimes();

    FoundPrime getPrime( String prime );

}
