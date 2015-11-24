# Nuevo documento desde plantilla

En el siguiente ejemplo puede ver como solicitar la generación de un documento, utilizando la configuración de firma definida en la plantilla seleccionada.

{% include "../snippets/api_v1_send_message_template.md" %}

En el ejemplo anterior podemos ver como podemos indicar la url del servicio donde se avisará cuando el documento esté firmado y como configurar emails a los que enviar el documento firmado.

De todas formas siempre podemos esperar a que el documento sea firmado en el dispositivo, como podemos ver en el siguiente ejemplo.

{% include "../snippets/api_v1_send_messages_poll.md" %}