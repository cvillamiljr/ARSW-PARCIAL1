package edu.eci.arsw.api.primesrepo.model;

/**
 * @author Cesar Villamil
 * 10/09/2020
 */
public class FoundPrime
{
    String user;

    String prime;

    public FoundPrime()
    {
    }

    public String getUser()
    {
        return user;
    }

    public void setUser( String user )
    {
        this.user = user;
    }

    public String getPrime()
    {
        return prime;
    }

    public void setPrime( String prime )
    {
        this.prime = prime;
    }
}
