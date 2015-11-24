```java
                    Download download = V1documentsApi.getInstance().downloadSigned(messageCode);
                    byte[] pdf = IOUtils.toByteArray((new URL(download.getLink())).openStream());
```
