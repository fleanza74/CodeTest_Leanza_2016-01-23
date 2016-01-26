# CodeTest_Leanza_2016-01-23

## Tools

La funzionalità è stata realizzata utilizzando le API java standard (**JDK7**) ad eccezione delle seguenti librerie di utility:

 - **apache commons-cli**: utilizzata per la creazione dell'interfaccia;

Il software è disponibile sottoforma di `executable-jar`assemblato con [**Maven**][]. Per le istruzioni di utilizzo vedi [qui](#build) 

## Implementation


Di seguito un diagramma UML delle classi:

![uml](https://raw.githubusercontent.com/fleanza74/CodeTest_Leanza_2016-01-23/master/src/main/doc/uml_tennis_2.png)


## Build

Per eseguire l'applicazione eseguire il seguente comando

```
$ mvn clean package
$ cd target && java -jar *-with-dependencies.jar
```


[Maven]: http://maven.apache.org/

