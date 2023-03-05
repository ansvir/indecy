#!/usr/bin/env bash
mvn install:install-file -Dfile=indecy-groovy-1.0.1-SNAPSHOT.jar -DgroupId=org.itique.indecy -DartifactId=indecy-groovy -Dversion=1.0.1 -Dpackaging=jar
mvn install:install-file -Dfile=indecy-java-1.0.1-SNAPSHOT.jar -DgroupId=org.itique.indecy -DartifactId=indecy-java -Dversion=1.0.1 -Dpackaging=jar