# DemoCommonsTextVuln

Package and run as follows:
```
mvn clean package
java -jar target/demo-commons-text-vuln-1.0-jar-with-dependencies.jar
```

The class `Main` uses `StringSubstitutor` on the string `"${script:javascript:java.lang.Runtime.getRuntime().exec('touch ./foo')}"`, which results in the execution of operating system commands. In this example, it will touch the local file `foo`.

Fix by updating commons-text to `1.10.0`.

References:
- https://commons.apache.org/proper/commons-text/security.html
- https://securitylab.github.com/advisories/GHSL-2022-018_Apache_Commons_Text/