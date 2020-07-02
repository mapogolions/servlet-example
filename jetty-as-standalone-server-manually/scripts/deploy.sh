./scripts/clean.sh
./scripts/build.sh
./scripts/package.sh
cp ./target/myapp.war $JETTY_HOME/webapps/myapp.war
