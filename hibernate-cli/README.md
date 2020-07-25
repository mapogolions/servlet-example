```sh
$ mvn clean package
$ mvn dependency:build-classpath -Dmdep.outputFile=cp.txt
$ cat cp.txt
$ deps=$(<cp.txt)
$ rm cp.txt
$ java -cp ./target/persistence-layer-1.0-SNAPSHOT.jar:$deps io.github.mapogolions.App
```
