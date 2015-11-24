# Nuevo documento sin dispositivo

En el siguiente ejemplo puede ver como solicitar la generación de un documento a partir de una plantilla configurada en el backend. Para este caso debe de utilizar en workflow **EX005** dado que el documento no será enviado a ningún dispositivo.

{% include "../snippets/api_v1_create_document.md" %}

En el ejemplo anterior podemos ver como podemos indicar la url del servicio donde se avisará cuando el documento esté disponible y como configurar emails a los que enviar el documento generado.

De todas formas siempre podemos esperar a que el documento sea generado, como podemos ver en el siguiente ejemplo

{% include "../snippets/api_v1_create_document_poll.md" %}