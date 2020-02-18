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
