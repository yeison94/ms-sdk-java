```java
try {
Device device = new Device();
device.setAppCode(DEVICE_APP_CODE);
device.setUserCode(USER_CODE);
device.setCode(DEVICE_CODE);
device.setDescription(DEVICE_DESCRIPTION);
device.setLocale(DEVICE_LOCALE);
device.setType(DEVICE_TYPE);
device.setUniqueIdentifier(DEVICE_IDENTIFIER);
device = api.registerDevice(device);
Assert.assertNotNull(device);
} catch (ApiException e) {
Assert.assertNotNull(testApiException(e));
}
```
