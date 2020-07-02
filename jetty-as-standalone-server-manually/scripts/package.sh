cp -r ./src/webapp ./target/webapp
cp -r ./target/classes ./target/webapp/WEB-INF/classes
mkdir ./target/webapp/WEB-INF/lib
jar -c -v -f ./target/myapp.war -C ./target/webapp .
