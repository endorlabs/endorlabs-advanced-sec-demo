# DemoCommonsTextVuln

The class `Internal`, defined in `foo/package-info.java`, exploits a vulnerability in Commons Text to execute JavaScript. It uses `StringSubstitutor` on the string `"${script:javascript:java.lang.Runtime.getRuntime().exec('touch ./foo')}"`, which results in the execution of operating system commands. In this example, it will touch the local file `foo`. The class `Internal` also runs the bash command `/bin/bash -c {touch,./target/bar}|{/bin/bash,-i}` using `Runtime.exec(String)`.

An Uber-JAR is created using `maven-assembly-plugin`, which is obfuscated using [yGuard](https://github.com/yWorks/yGuard/) and deployed in the local `.m2` directory as `demo-commons-text-vuln-1.0-obfuscated.jar`.

Install and run as follows:
```
mvn clean install
java -jar target/demo-commons-text-vuln-1.0-obfuscated.jar 
```

The Commons Test vulnerability can be fixed by updating to `1.10.0`.

References:
- https://commons.apache.org/proper/commons-text/security.html
- https://securitylab.github.com/advisories/GHSL-2022-018_Apache_Commons_Text/