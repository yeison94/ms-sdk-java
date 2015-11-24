```java
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
                    }
                }
            }
```
