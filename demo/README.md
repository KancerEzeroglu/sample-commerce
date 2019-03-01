Run below command to run the server
```
mvn spring-boot:run
```

If you want to build jar and run
```
mvn clean install
java -jar target/demo-0.0.1-SNAPSHOT.jar
```

Run tests with
```
mvn test
```

Create products reading from a file(create.json)
```
python client.py -u http://localhost:8080 -c -i create.json 
```

Fetch products and write to reading from a file(create.json)
```
python client.py -u http://localhost:8080 -f -o test.json
```

