```java
            int count = 100;
            String status = null;
            while (count > 0) {
                count--;
                Message msg = V1messagesApi.getInstance().getMessageByCode(messageCode);
                status = msg.getWorkflow().getCurrent();

                if ("RESPONSED".equals(status)) {
                    Download download = V1documentsApi.getInstance().downloadTemporal(messageCode);
                    byte[] pdf = IOUtils.toByteArray((new URL(download.getLink())).openStream());
                    Assert.assertNotNull(pdf);
                } else {
                    Thread.sleep(1000);
                }
            }
```
