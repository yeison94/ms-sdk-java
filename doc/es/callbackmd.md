# Servlet para callback

En el proyecto https://github.com/viavansi/ms-callback puede consultar una implementación de ejemplo de un servlet en el que recibir la notificaciones de las solicitudes finalizadas.

```java
private void doService(HttpServletRequest req, HttpServletResponse resp) {
    if(req.getParameter("message")!=null){
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            Message message = mapper.readValue(req.getParameter("message"), Message.class);
            //check message status or download document
        } catch (Exception e) {
            log.log(Level.SEVERE,"Error parsing message JSON.",e);
        }
    }else{
        log.log(Level.WARNING,"Empty request received.");   
    }
}

```

En el ejemplo anterior extraido del proyecto de ejemplo puede ver como procesar las llamadas al servicio (servlet), creando un objeto mensaje que contiene toda la información referente a la petición y desde el que podría descargar el documento firmado, siguiendo los ejemplos de uso del sdk descritos en esta documentación.