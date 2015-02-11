Mobile Services SDK Java
==========

Cliente Java para Mobile Services - Viafirma

#### [Histórico de cambios y versiones](History.md)

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

### Ejemplo de uso:

#### Recuperar información de un mensaje conocido el código

Ejemplo de Autenticación OAuth a nivel de usuario

````
V1Api api = new V1Api();

// URL de acceso al API REST
api.setBasePath(urlApi);

// OAuth consumer key
api.setConsumerKey(consumerKey);

// OAuth consumer secret
api.setConsumerSecret(consumerSecret);

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
````

#### Ejemplo de envio de mensaje para solo generar documentos pdf

Ejemplo de autenticación OAuth a nivel de aplicación

````

V1Api api = new V1Api();

// URL de acceso al API REST
api.setBasePath(urlApi);

// OAuth consumer key
api.setConsumerKey(consumerKey);

// OAuth consumer secret
api.setConsumerSecret(consumerSecret);

//Create message
Message message = new Message();

//Create workflow
Workflow workflow = new Workflow();
workflow.setCode("EX005");
message.setWorkflow(workflow);

//Create notification info
Notification notification = new Notification();
notification.setText("Notification Demo");
notification.setDetail("Generate a example document from template");
message.setNotification(notification);

//Create a template document
Document document = new Document();
document.setTemplateCode("022_example");
document.setTemplateType("docx");

//Add dato to template
List<Item> items = new ArrayList<Item>();
Item item = new Item();

item.setKey("KEY_01");
item.setLabel("Test key 1");
item.setValue(UUID.randomUUID().toString());
items.add(item);

item.setKey("KEY_02");
item.setLabel("Test key 2");
item.setValue(UUID.randomUUID().toString());
items.add(item);

item.setKey("KEY_03");
item.setLabel("Test key 3");
item.setValue(UUID.randomUUID().toString());
items.add(item);

item.setKey("KEY_04");
item.setLabel("Test key 4");
item.setValue(UUID.randomUUID().toString());
items.add(item);

document.setItems(items);
message.setDocument(document);

//Send message
String messageCode = api.sendMessage(message);
````
