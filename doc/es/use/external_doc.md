# Firma documento externo

En el siguiente ejemplo puede ver como solicitar la firmar de un documento previamente generado y disponible en una url, así como un ejemplo de configuración del dispositivo al que deseamos enviar la solicitud de firma.

{% include "../snippets/api_v1_send_external_doc.md" %}

En el ejemplo anterior podemos ver como podemos indicar la url del servicio donde se avisará cuando el documento esté firmado y como configurar emails a los que enviar el documento firmado.

De todas formas siempre podemos esperar a que el documento sea firmado en el dispositivo, como podemos ver en el siguiente ejemplo.

{% include "../snippets/api_v1_send_messages_poll.md" %}