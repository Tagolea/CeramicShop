package api;

import java.util.HashMap;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class SendSms {

//사용 한도 14번 ^^

	static public void sendSms(String to, String msg) {
		String api_key = "NCS8LY0QO0MKM1LP";
		String api_secret = "JVKE47OD9M3KRUCACPXARHLWOM1STWTL";
		Message coolsms = new Message(api_key, api_secret);

		// 4 params(to, from, type, text) are mandatory. must be filled
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("to", to); // 수신자
		params.put("from", "01095803041"); // 발신자
		params.put("type", "SMS");
		params.put("text", "필기 아이디 : " + msg); // 문자내용
		params.put("app_version", "test app 1.2"); // application name and version

		try {
			JSONObject obj = (JSONObject) coolsms.send(params);
			System.out.println(obj.toString());
		} catch (CoolsmsException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCode());
		}
	}
}