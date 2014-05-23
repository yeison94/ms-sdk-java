Mobile Services SDK Java
==========

Cliente Java para Mobile Services - Viafirma

Ejemplo de uso:

<pre>
V1Api api = new V1Api();
api.setBasePath("http://localhost:8080/mobile-services/api");
api.setConsumerKey("com.viafirma.ios.example");
api.setConsumerSecret("1234");
Message message = api.getMessageByCode("1400834631788R255");
</pre>