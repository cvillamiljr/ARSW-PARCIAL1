#PrimesApi

> 1. Se soporta el metodo GET para los numeros primos en el recurso /primes:
>
>   ![](img/metodoGet.png)
>
>   ![](img/getPostman.png)
>
>   ![](img/getPrimes.png)
>
> 2. Se soporta el metodo GET para un numero primo en especifico en el recurso /primes/primeNumber:
>
>   ![](img/metodoGetPrime.png)
>
>   ![](img/getPostman.png)
>
> 3. Se soporta el metodo POST para un numero primo nuevo, teniendo en cuenta que no se puede crear uno que ya exista:
>
>   ![](img/metodoPost.png)
>
>   ![](img/Post.png)
>
> Se modificó el metodo de añadir un numero para que lance la excepción si el numero ya existe de la siguiente forma:
>
>   ![](img/verificacion.png)
>
> Aqui la prueba de que no hace el POST si existe el numero:
>
>   ![](img/badPost.png)
>
> 4. Para evitar problemas de concurrencia se hizo la lista de primos una lista concurrente para que no existan problemas con los
>verbos HTTP
>
>   ![](img/concurrent.png)
>