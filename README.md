# OnlineStoreBE

## This is repo for BE files of Online Store Project


This project is being build on Java 8. In order to make it running you need to use 
_MySql_ database, where you need to create a schema _onlinestore_. 
Flyway migrations will take care of creating two tables, for now, 
and most important from them is _category_ table.The test data will 
be input by migrations, so you can test REST points.
In _application.properties_ file you need to input your own
database user and password:

_spring.datasource.username=****_

_spring.datasource.password=****_

as in this file you will find asterisks instead of actual values.
Run this app by running _OnlineStoreApplication_ class.

