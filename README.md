# CodeTest_Leanza_2016-01-23

## Tools

La funzionalità è stata realizzata utilizzando le API java standard (**JDK7**) ad eccezione delle seguenti librerie di utility:

 - **apache commons-cli**: utilizzata per la creazione dell'interfaccia;

Il software è disponibile sottoforma di `executable-jar`assemblato con [Maven][]. Per le istruzioni di utilizzo vedi [qui](#build) 

## Implementation


Di seguito un diagramma UML delle classi:

![uml](https://raw.githubusercontent.com/fleanza74/CodeTest_Leanza_2016-01-23/master/src/main/doc/uml_tennis_2.png)


## Build

Per eseguire l'applicazione eseguire il seguenti comandi

```
$ mvn clean package
$ cd target && java -jar *-with-dependencies.jar
```

```
usage: java -jar tennis-jar-with-dependencies.jar [-h] -p1 <player1> -p2 <player2> [-s <strategy>]
Tennis Game

-h              Print this help
-p1 <player1>   The player 1 name
-p2 <player2>   The player 1 name
-s <strategy>   Game strategy.
                Valid value are: R=Random, P=Preload (Default: Random)
```

[Maven]: http://maven.apache.org/

