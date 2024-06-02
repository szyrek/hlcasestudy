# Build:

```
mvn clean install
```

# Deploy:

```
cp -rf target/hlcasestudy.war $WILDFLY_HOME/standalone/deplyments
```

# Test out:

```
curl http://localhost:8080/hlcasestudy/rest/useraccounts

curl -X POST http://localhost:8080/hlcasestudy/rest/useraccounts  -H 'Content-Type: application/json' -d '{"username":"szymon", "age": 36, "gender": "MALE"}'

curl -X DELETE http://localhost:8080/hlcasestudy/rest/useraccounts?id=3

curl -X PUT http://localhost:8080/hlcasestudy/rest/useraccounts  -H 'Content-Type: application/json' -d '{"id":"1", "username":"baba"}'
```
