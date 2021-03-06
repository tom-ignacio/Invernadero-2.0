# Invernadero 2.0

# ¿Qué es Invernadero 2.0?
Invernadero 2.0 es una aplicación donde se tiene una lista de plantas con ciertas características, tales como su familia, género, entre otros. Esta aplicación es una actualización del programa Invernadero para que el manejo de la misma sea más sencilla y eficiente para el usuario.

# Requisitos
Se necesita tener instalado PostgreSQL (preferiblemente la versión 13.0), de lo contrario el programa no podrá funcionar debido a que la información se almacena en una base de datos de PostgreSQL.

# Configurando Invernadero 2.0

## Ingresando el usuario y contraseña de PostgreSQL
Lo primero que se debe hacer es modificar el archivo ```Invernadero.java``` para que contenga el usuario y contraseña de PostgreSQL del usuario. Esto se puede cambiar en las líneas 32 y 33 del archivo:
```
    private final String user = "postgres";
    private final String password = "12345";
```
Donde ```postgres``` es el usuario y ```12345``` es la contraseña, si desconoce el usuario y contraseña luego de instalar PostgreSQL es posible que el usuario y contraseña sean los predeterminados de PostgreSQL.

## Creando la date de basos "Invernadero"
Se debe acceder a PostgreSQL por medio de cmd.exe a través del siguiente comando:
```
createdb -U postgres Invernadero
```
Con eso se creará la base de datos "Invernadero" que es donde se almacenará toda la información ingresada en Invernadero 2.0, es posible que haya que ingresar la contraseña para la creación de la base de datos. El siguiente comando a ingresar es el siguiente:
```
psql -U postgres -h localhost Invernadero
```
Este comando permitirá acceder a la base de datos, a la cual nos interesa ingresar para poder crear los atributos que contiene la misma, esto se crea a través del siguiente comando:
```
CREATE TABLE Invernadero (
  serial INTEGER PRIMARY KEY,
  nombre TEXT,
  grupo TEXT,
  orden TEXT,
  familia TEXT,
  genero TEXT,
  cantidad INTEGER
);
```
Luego de esto ya se podrá ejecutar Invernadero 2.0 sin problema alguno. Este procedimiento solo se debe realizar la primera vez que se instala el programa.

# Utilizando Invernadero 2.0

## Ingresando datos
Una vez ingresado en el programa todo es autoexplicativo, los datos se ingresan en las cajas vacias y los datos a ingresar son los siguientes:
* **Serial:** únicamente puede ser un número entero y solo puede ser usado una vez. *En caso de ingresar un valor no permitido saldrá un mensaje de error y no se guardará ningun dato*
* **Nombre:** no existen limitaciones respecto a este.
* **Grupo:** solo se pueden seleccionar entre espermatofita y pteridofita
* **Orden:** no existen limitaciones respecto a este.
* **Familia:** no existen limitaciones respecto a este.
* **Género:** no existen limitaciones respecto a este.
* **Cantidad:** unicamente puede ser un número entero.

## Función de cada botón

* **Guardar:** guarda todos los datos ingresados.
* **Modificar:** modifica los datos de una planta siempre y cuando se ingresen los datos y se especifique el serial.
* **Eliminar:** elimina los datos de una planta siempre y cuando se ingresen los datos y se especifique el serial.
* **Refrescar:** refresca la lista de base de datos. *Generalmente es recomendado para cuando se inicie el programa luego de haberlo cerrado, ya que la tabla de datos saldrá vacía.
* **Nuevo:** vacia todas las casillas a ingresar para poder ingresar datos nuevo.
