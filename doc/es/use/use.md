# Ejemplos de uso del SDK

### Parámetros de configuración para los ejemplos

* **API_URL** Dirección para el acceso a los servicios rest por ejemplo https://localhost:8080/mobile-services/api
* **CONSUMER_KEY** Identificador de la aplicación configurada en el backend que permite el accesos a los servicios rest. 
* **CONSUMER_SECRET** Clave de la aplicación anterior.
* **USER_CODE** Código de acceso del usuario que accede a los servicios.
* **USER_PASSWORD** Clave de usuario que accede a los servicios.
* **OAUTH_TYPE** Tipo de autenticación para el acceso al API, puede tomar los valores OAUTH_APPLICATION | OAUTH_USER según la configuración de la aplicación en el backend, indica si se necesitan credencales de usuario o no para acceder a los servicios.
* **AUTH_MODE** indica el tipo de autenticación utilizado para aceptar un token de OAuth en la versión actual siempre tiene el valor **"client_auth"**
* **MESSAGE_CODE** Código del mensaje de ejemplo.
* **TEMPLATE_CODE** Código de la plantilla que queremos utilizar.
* **TEMPLATE_TYPE** Tipo la plantilla configurada en el parámetro   TEMPLATE_CODE y puede tomar los valores (docx | odt | url).
* **DEVICE_CODE** Código del dispositivo de ejemplo.
* **DEVICE_DESCRIPTION** Descripción del dispositivo de ejemplo.
* **DEVICE_LOCALE** Idioma del dispositivo, por ejemplo "es_ES"
* **DEVICE_TYPE** Tipo de dispositivo (ANDROID|IOS)
* **DEVICE_APP_CODE** Código de la aplicación (configurado en el backend) al que pertenece el dispositivo de ejemplo
