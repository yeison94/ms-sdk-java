```java
            Message message = new Message();
            
            //Find device in user device list
            Device device = null;
            List<Device> devices = V1devicesApi.getInstance().findDeviceByUser(USER_CODE);
            for (Device d: devices) {
                if (DEVICE_CODE.equals(d.getCode())) {
                    device = d;
                    break;
                }
            }
            
            // Create notification info
            Notification notification = new Notification();
            notification.setText("External document demo");
            notification.setDetail("Sign a document available at URL");
            notification.setDevices(new ArrayList<Device>());
            notification.getDevices().add(device);
            message.setNotification(notification);

            // Create a template document
            Document document = new Document();
            document.setTemplateReference("http://descargas.viavansi.com/mobile-services/example-sign.pdf");
            document.setTemplateType(TemplateTypeEnum.url);
            message.setDocument(document);
            
            Policy policy = new Policy();
            policy.setTypeFormatSign(TypeFormatSignEnum.DIGITALIZED_SIGN);
            policy.setTypeSign(TypeSignEnum.ATTACHED);
            
            List<Param> paramList = new ArrayList<Param>();
            
            Param p1 = new Param();
            p1.setKey("digitalizedSignHelpText");
            p1.setValue("Firme aquí");
            paramList.add(p1);
            
            Param p2 = new Param();
            p2.setKey("signPositionEnable");
            p2.setValue("true");
            paramList.add(p2);
            
            Param p3 = new Param();
            p3.setKey("fileName");
            p3.setValue("demo_001.pdf");
            paramList.add(p3);
            
            Param p4 = new Param();
            p4.setKey("op");
            p4.setValue("pen");
            paramList.add(p4);
            
            policy.setParamList(paramList);
            
            List<Policy> policies = new ArrayList<Policy>();
            policies.add(policy);
            message.setPolicies(policies);
            
            //java example in https://github.com/viavansi/ms-callback
            message.setCallbackURL("https://localhost:8080/ms-callback/response");

            //send document by email (optional)
            message.setCallbackMails("user1@mail.com,user2@mail.com");

            String messageCode = V1messagesApi.getInstance().sendMessage(message);
```
