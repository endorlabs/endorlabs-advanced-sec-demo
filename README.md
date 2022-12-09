# DemoCommonsTextVuln

The class `Internal`, defined in `foo/package-info.java`:

- Exploits a vulnerability in Apache Commons Text to execute JavaScript (using
`StringSubstitutor` on the string
`"${script:javascript:java.lang.Runtime.getRuntime().exec('touch ./foo')}"`,
which results in the execution of an operating system command to touch the local file `./target/foo`).
- Uses `Runtime.exec(String)` to run `/bin/bash -c {touch,./target/bar}|{/bin/bash,-i}`.

An Uber-JAR is created using `maven-assembly-plugin`, which is obfuscated using
[yGuard](https://github.com/yWorks/yGuard/) and deployed in the local `.m2`
directory as `demo-commons-text-vuln-1.0-obfuscated.jar`.

Install and run as follows:
```
mvn clean install
java -jar target/demo-commons-text-vuln-1.0-obfuscated.jar 
```

The Commons Test vulnerability can be fixed by updating to `1.10.0`.

References:
- https://commons.apache.org/proper/commons-text/security.html
- https://securitylab.github.com/advisories/GHSL-2022-018_Apache_Commons_Text/