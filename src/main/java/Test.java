import com.viafirma.mobile.services.sdk.java.ApiException;
import com.viafirma.mobile.services.sdk.java.api.V1Api;
import com.viafirma.mobile.services.sdk.java.model.Message;

/*
 *  Copyright 2013 Viafirma S.L.
 *
 *  Licensed under the Viafirma License, Version 1.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.viafirma.com/licenses/LICENSE-1.0
 *
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

/**
 * @author Jesus Lopez Calero @inyenia inyenia@gmail.com
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			V1Api api = new V1Api();
			api.setBasePath("http://dev.viafirma.com/mobile-services/api");
			api.setConsumerKey("com.viafirma.mobile.ios.documents");
			api.setConsumerSecret("5816437553");
			Message message = api.getMessageByCode("1400834631788R255");
			System.out.println(message);
		} catch (ApiException e) {
			e.printStackTrace();
		}
	}

}
