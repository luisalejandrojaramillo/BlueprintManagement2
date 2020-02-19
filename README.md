Realizado por **Fernando Barrera Barrera**, **Luis Alejandro Jaramillo** y **Carlos Andrés Castañeda**

# BlueprintManagement2

## Part II

### POST

* Por medio del comando unix **curl** podemos ingresar un objeto Bluerpint por medio del formato JSON.

``` 
curl -i -X POST -HContent-Type:application/json -HAccept:application/json http://localhost:8080/blueprints/create -d "{"""author""":"""luis""","""points""":[{"""x""":140,"""y""":140},{"""x""":150,"""y""":150}],"""name""":"""plano4"""}
```
![](/img/2_1.png)

![](/img/pantallagetx.png)

* Podemos observar que se agrego el objeto.

![](/img/pantallaLuis.png)

### PUT


* Con el mismo usuario **Luis** cambiamos **140,140** por **170,170**.
* Usamos el mismo comando unix **curl** para modificar los datos.

```
curl -i -X PUT -HContent-Type:application/json -HAccept:application/json http://localhost:8080/blueprints/luis/plano4 -d "{"""author""":"""luis""","""points""":[{"""x""":170,"""y""":170},{"""x""":150,"""y""":150}],"""name""":"""plano4"""}"
```

![](/img/postLuis.png)

## Part III

### Que condiciones de carrera podrian ocurrir?

las posibles condicones de carrera son las siguientes:

    1. cuando un usuario quiere consultar los planos y al mismo tiempo otro quiere insertar un nuevo plano.
    2. cuando un usuario quiere consultar los planos y al mismo tiempo otro quiere actualizar un plano.
    3. cuando un usuario quiere insertar un nuevo plano y al mismo tiempo otro quiere actualizar un plano.
    4. cuandos dos usuarios quieren actualizar el mismo plano al mismo tiempo.

### Cuales son la regiones criticas?

las regiones criticas se dan en las funciones de consulta,insercion y actualizacion de los planos ,puesto que estas operaciones requieren acceso al mismo recurso que en este caso es el hashmap que contiene los planos,si se da el caso que se ejecutan dos de estan funciones al mismo tiempo podria generar una ConcurrentModificationException.

### Como suprimir las condiciones de carrera?

una forma de suprimir la condiciones de carrera seria con un synchronized que me ayude a controlar el acceso al hashmap que contiene los planos pero esta solucion genera sobrecarga de rendimiento y aumenta el tiempo de ejecucion de cada subproceso por lo tanto lo mas coneveniete seria utilizar un ConcurrentHashMap que permite que mas de un subproceso tenga acceso al recurso por lo tanto no nos baja el rendimiento y nos disminuye el tiempo de ejecuacion de cada subproceso y ademas nos asegura el ciclo de vida de cada subproceso sin necesidad de usar el synchronized.
