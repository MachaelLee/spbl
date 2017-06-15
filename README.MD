## 运行
java -jar target/spbl-1.0.jar

## 验证

```
curl 'localhost:8090/greeting'
{"id":1,"content":"Hello, World!"}lgj@loki:~$
lgj@loki:~$ curl 'localhost:8090/greeting?name=m'
{"id":2,"content":"Hello, m!"}lgj@loki:~$
```
