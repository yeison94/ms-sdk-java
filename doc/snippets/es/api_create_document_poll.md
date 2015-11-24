```java
            int count = 100;
            String status = null;
            while (count > 0) {
                count--;
                Message msg = api.getMessageByCode(messageCode);
                status = msg.getWorkflow().getCurrent();

                if ("RESPONSED".equals(status)) {
                    String documentCode = msg.getDocument().getDraftedCode();
                    byte[] pdf = api.getDocument("temporal", messageCode, documentCode);
                    Assert.assertNotNull(pdf);
                } else {
                    Thread.sleep(1000);
                }
            }
```
