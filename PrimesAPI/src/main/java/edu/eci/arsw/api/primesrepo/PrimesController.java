package edu.eci.arsw.api.primesrepo;

import edu.eci.arsw.api.primesrepo.model.FoundPrime;
import edu.eci.arsw.api.primesrepo.service.FoundPrimeException;
import edu.eci.arsw.api.primesrepo.service.PrimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author Cesar Villamil
 * 10/09/2020
 */

@RestController
@RequestMapping(value = "/primes")
public class PrimesController
{
    @Autowired
    @Qualifier("primeServiceStub")
    PrimeService primeService;

    @RequestMapping(method = GET )
    public ResponseEntity<?> getCinemaByName() throws ResourceNotFoundException {
        return new ResponseEntity<>(primeService.getFoundPrimes(), HttpStatus.ACCEPTED);
    }
    @RequestMapping(value="/{primeNumber}")
    public ResponseEntity<?> getCinemaByName(@PathVariable("primeNumber") String number) throws ResourceNotFoundException {
        return new ResponseEntity<>(primeService.getPrime(number), HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> postCinemaFunction(@RequestBody FoundPrime fp) throws FoundPrimeException {

        try{
            primeService.addFoundPrime(fp);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (FoundPrimeException e){
            return new ResponseEntity<>("El numero ya existe",HttpStatus.BAD_REQUEST);
        }


    }


}
