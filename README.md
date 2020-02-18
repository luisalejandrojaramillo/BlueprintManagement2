Realizado por **Fernando Barrera Barrera**, **Luis Alejandro Jaramillo** y **Carlos Andrés Castañeda**

# BlueprintManagement2

## Part II

### POST

``` 
curl -i -X POST -HContent-Type:application/json -HAccept:application/json http://localhost:8080/blueprints/create -d "{"""author""":"""carlos""","""points""":[{"""x""":140,"""y""":140},{"""x""":150,"""y""":150}],"""name""":"""plano4"""}
```
![](/img/2_1.png)

![](/img/pantallagetx.png)

![](/img/pantallaLuis.png)

### PUT

* Cambiamos 150 por 170

```
curl -i -X PUT -HContent-Type:application/json -HAccept:application/json http://localhost:8080/blueprints/luis/plano4 -d "{"""author""":"""luis""","""points""":[{"""x""":170,"""y""":170},{"""x""":150,"""y""":150}],"""name""":"""plano4"""}"
```

![](/img/postLuis.png)

## Part III
