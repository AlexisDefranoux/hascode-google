1/ Pour build le projet depuis la console, à la racine du projet, saisissez :
mvn clean install

2/ Puis pour executer le module engine, placez vous dans teama/engine depuis la console et saisissez :
mvn exec:java -Dexec.mainClass="fr.uca.unice.polytech.si3.ps5.year17.teama.engine.Main" -Dexec.args="id_de_la_stratégie full/path/to/source/file/data.in full/path/to/result/file/data.out full/path/to/result/file/score.out"

3/ Pour executer le module benchmark, placez vous dans teama/benchmark depuis la console et saisissez :
cd teama/benchmark
mvn clean install
java -jar target/benchmarks.jar -rf json

4/ Pour executer le module visualiser, placez vous dans teama/visualiser depuis la console et saisissez :
mvn exec:java -Dexec.mainClass="fr.uca.unice.polytech.si3.ps5.year17.teama.visualiser.Main" -Dexec.args="full/path/to/source/file/data.in full/path/to/result/file1/data.out;full/path/to/result/file2/data.out full/path/to/result/file1/score.out;full/path/to/result/file2/score.out full/path/to/benchmark/file/result.json full/path/to/result/folder