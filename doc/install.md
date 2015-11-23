### Integración en proyecto maven

Es necesario añadir el siguiente repositorio

`````
<repository>
	<id>viavansi-repo</id>
	<name>Viavansi Maven Repository</name>
	<url>http://repositorio.viavansi.com/repo</url>
</repository>
`````
Añadir la siguiente dependencia

`````
<dependency>
	<groupId>com.viafirma</groupId>
	<artifactId>ms-sdk-java</artifactId>
	<version>2.X.X</version>
</dependency>
`````