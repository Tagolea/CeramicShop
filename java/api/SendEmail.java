package api;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

	public static void sendMail(String email, String uname, String upw) {
		String host = "smtp.naver.com"; // 사용할 사이트
		final String user = "qktyd1003@naver.com"; // ID
		final String password = "a39193041a1!1!"; // PW

		String to = email;// 보낼 email주소
System.out.println("sss");
		// Get the session object
		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});

		// Compose the message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// 제목
			message.setSubject(uname + "님 필기 임시 비밀번호 전송");

			// 내용
			message.setText("변경된 임시 비밀번호 : " + upw);

			// send the message
			Transport.send(message);
			System.out.println("이메일 전송 성공!");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
