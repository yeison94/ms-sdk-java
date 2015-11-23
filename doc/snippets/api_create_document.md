```java
            Message message = new Message();

            // Create notification info
            Notification notification = new Notification();
            notification.setText("Title");
            notification.setDetail("Detail");
            message.setNotification(notification);

            Workflow workflow = new Workflow();
            // only generate PDF from template. It´s not sent to mobile devices.
            workflow.setCode("EX005"); 
            message.setWorkflow(workflow);

            Document document = new Document();
            document.setTemplateCode(TEMPLATE_CODE);
            document.setTemplateType(TEMPLATE_TYPE);
            document.setItems(new ArrayList<Item>());

            Item item01 = new Item();
            item01.setKey("KEY_01");
            item01.setValue("Jhon");
            document.getItems().add(item01);

            Item item02 = new Item();
            item02.setKey("KEY_02");
            item02.setValue("Doe");
            document.getItems().add(item02);

            Item item03 = new Item();
            item03.setKey("KEY_03");
            item03.setValue("11111111T");
            document.getItems().add(item03);

            message.setDocument(document);
            
            //java example in https://github.com/viavansi/ms-callback
            message.setCallbackURL("https://localhost:8080/ms-callback/response");
            
            //send document by email (optional)
            message.setCallbackMails("user1@mail.com,user2@mail.com");

            messageCode = api.sendMessage(message);
```
