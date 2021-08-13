mvn package;
cp target/*.hpi ~/.jenkins/plugins/build-executors.jpi;
scp target/*.hpi amptest@10.30.7.159:~/.jenkins/plugins/build-executors.jpi;
