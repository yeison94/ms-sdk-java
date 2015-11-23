# Compatibilidad SDK anterior a 2.5.X

#### Acceso al API

En el siguiente ejemplo podemos ver como configurar el cliente para hacer uso de los direfentes servicios. 

{% include "../snippets/api_initialize.md" %}

En el ejemplo anterior podemos observar como en el caso de necesitar el acceso al API con OAuth a nivel de usuario, indicamos los datos de acceso del usuario y con el código ```api.generateNewToken();``` solicitamos un nuevo token.

#### Listar dispositivos utilizados por un usuario

{% include "../snippets/api_user_devices.md" %}

#### Recuperar información de un usuario configurada en el backend

{% include "../snippets/api_find_user.md" %}

#### Listar plantillas asignadas a un usuario

{% include "../snippets/api_user_templates.md" %}

#### Recuperar información de una plantilla configurada en el backend

{% include "../snippets/api_find_template.md" %}

#### Generación de un nuevo documento usando una plantilla configurada en el backend

{% include "../snippets/api_create_document.md" %}

En el ejemplo anterior podemos ver como podemos indicar la url del servicio donde se avisará cuando el documento esté disponible y como configurar emails a los que enviar el documento generado.

De todas formas siempre podemos esperar a que el documento sea generado, como podemos ver en el siguiente ejemplo

{% include "../snippets/api_create_document_poll.md" %}

#### Generación de un nuevo documento y envío al dispositivo del usuario

{% include "../snippets/api_send_message.md" %}

#### Generación de un nuevo documento y envío al dispositivo del usuario utilizando una plantilla

{% include "../snippets/api_send_message_template.md" %}