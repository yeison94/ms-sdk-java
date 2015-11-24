```java
            List<Device> devices = api.findDeviceByUser(USER_CODE);

            Device device = null;
            for(Device cd: devices){
                if (cd.getCode().equals(DEVICE_CODE)) {
                    device = cd;
                }
            }
            Assert.assertNotNull(devices);

            Message message = new Message();

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

            Notification notification = new Notification();
            notification.setText("Notification Example");
            notification.setDevices(new ArrayList<Device>());
            notification.getDevices().add(device);

            message.setNotification(notification);

            message.setPolicies(new ArrayList<Policy>());
            Policy policy = new Policy();
            policy.setTypeSign(TypeSignEnum.ATTACHED);
            policy.setTypeFormatSign(TypeFormatSignEnum.DIGITALIZED_SIGN);
            policy.setParamList(new ArrayList<Param>());

            Param param01 = new Param();
            param01.setKey("digitalizedSignHelpText");
            param01.setValue("Firme Aquí");
            policy.getParamList().add(param01);

            Param param02 = new Param();
            param02.setKey("fileName");
            param02.setValue("example.pdf");
            policy.getParamList().add(param02);

            Param param03 = new Param();
            param03.setKey("biometricAlias");
            param03.setValue("viafirmadocuments");
            policy.getParamList().add(param03);

            Param param04 = new Param();
            param04.setKey("biometricPass");
            param04.setValue("12345");
            policy.getParamList().add(param04);

            Param param05 = new Param();
            param05.setKey("op");
            param05.setValue("pen");
            policy.getParamList().add(param05);

            Param param06 = new Param();
            param06.setKey("signPositionEnable");
            param06.setValue("true");
            policy.getParamList().add(param06);

            message.getPolicies().add(policy);

            //java example in https://github.com/viavansi/ms-callback
            message.setCallbackURL("https://localhost:8080/ms-callback/response");
            
            //send document by email (optional)
            message.setCallbackMails("user1@mail.com,user2@mail.com");
            
            String messageCode = api.sendMessage(message);
```
