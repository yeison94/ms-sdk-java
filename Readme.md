Mobile Services SDK Java
==========

Cliente Java para Mobile Services - Viafirma

#### [Histórico de cambios y versiones](History.md)

### Ejemplo de uso:

<pre>
V1Api api = new V1Api();

// URL de acceso al API REST
api.setBasePath(urlApi);

// OAuth consumer key
api.setConsumerKey(consumerKey);

// OAuth consumer secret
api.setConsumerSecret(consumerSecret);

// Activa o desactiva la validación de la firma de las respuestas
// por defecto false
api.setValidateResponse(validateResponse);

// Solicitar un nuevo token
Token token = api.requestToken();
api.setToken(token.getOauth_token());
api.setTokenSecret(token.getOauth_token_secret());

// Aceptar el token recibido
token = api.accessToken(userCode, userPass, "client_auth");
api.setToken(token.getOauth_token());
api.setTokenSecret(token.getOauth_token_secret());

// Ejemplo de como recuperar un message conocido su código
Message message = api.getMessageByCode("1400834631788R255");
</pre>

### Integración en proyecto maven

> Es necesario añadir el siguiente repositorio
`````
<repository>
	<id>viavansi-repo</id>
	<name>Viavansi Maven Repository</name>
	<url>http://repositorio.viavansi.com/repo</url>
</repository>
`````
> Añadir la siguiente dependencia
`````
<dependency>
	<groupId>com.viafirma</groupId>
	<artifactId>ms-sdk-java</artifactId>
	<version>2.X.X</version>
</dependency>
`````
