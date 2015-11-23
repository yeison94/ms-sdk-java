# Solicitud de acceso al API (OAuth 1.0)

Los servicios REST expuestos por viafirma documents están securizados con OAuth 1.0 

Para más información se puede consultar la [Documentación oficial de OAuth 1.0](http://oauth.net/core/1.0/).

Desde la administración de aplicaciones del backend, podremos configurar la seguridad de acceso al API dos formas:

* **OAuth a nivel de aplicación** en el acceso a los servicios REST solo se identifica a la aplicación que hace uso de los mismo y no se requiere la renovación de token de acceso. Pensado para integraciones desde aplicaciones como CRM
* **OAuth a nivel de usuario** en el acceso a los servicios REST se identifica a la aplicación que hace uso de los servicios y al usuario que hace uso de la aplicación, se requiere la renovación de token cada X minutos, según lo configurado en el backend. Pensado para la integración de aplicaciones en la que que participa el usuario final.

