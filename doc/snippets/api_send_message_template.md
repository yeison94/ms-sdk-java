```java
            Message message = new Message();

            // Create notification info
            Notification notification = new Notification();
            notification.setText("Title");
            notification.setDetail("Detail");

            // Find user device
            Device device = api.findDeviceByUser(USER_CODE).get(0);
            notification.setDevices(new ArrayList<Device>());
            notification.getDevices().add(device);
            message.setNotification(notification);

            Document document = new Document();
            document.setTemplateCode(TEMPLATE_CODE);
            document.setTemplateType(TEMPLATE_TYPE);
            document.setItems(new ArrayList<Item>());

            //GET Template info
            Template template = api.findTemplateByCode(TEMPLATE_CODE);
            
            //Find items in template form
            Form form = template.getForm();
            for(Container container: form.getContainers()){
                for(Row row: container.getRows()){
                    for(Item item: row.getItems()){
                        if (item.getKey().equals("KEY_01")) {
                            item.setValue("Jhon");
                        } else if (item.getKey().equals("KEY_02")) {
                            item.setValue("Doe");
                        } else if (item.getKey().equals("KEY_03")) {
                            item.setValue("11111111T");
                        }
                        //Add item to document
                        document.getItems().add(item);
                    }
                }
            }
            
            message.setDocument(document);

            // Copy policies form template
            message.setPolicies(template.getForm().getSettings().getPolicies());

            //java example in https://github.com/viavansi/ms-callback
            message.setCallbackURL("https://localhost:8080/ms-callback/response");
            
            //send document by email (optional)
            message.setCallbackMails("user1@mail.com,user2@mail.com");
            
            String messageCode = api.sendMessage(message);
```
