```java
            api = new V1Api();
            api.setBasePath(API_URL);
            api.setConsumerKey(CONSUMER_KEY);
            api.setConsumerSecret(CONSUMER_SECRET);

            if (OAUTH_TYPE == OAuthType.OAUTH_USER) {
                api.setUser(USER_CODE);
                api.setPassword(USER_PASSWORD);
                api.setAuth_mode(AUTH_MODE);
                api.generateNewToken();
            }
```
