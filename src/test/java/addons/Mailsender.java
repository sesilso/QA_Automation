package addons;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Mailsender {

	public void SendMail(String ToEmail){
		//authentication info
				final String username = "geekuser2019@yahoo.com";
				final String password = "Sebas50pl1n";
				String fromEmail = "geekuser2019@yahoo.com";
				String toEmail = "sergio.silsop@gmail.com";
				
				Properties properties = new Properties();
				properties.put("mail.smtp.auth", "true");
				properties.put("mail.smtp.starttls.enable", "true");
				properties.put("mail.smtp.host", "smtp.mail.yahoo.com");
				properties.put("mail.smtp.port", "587");
				
				Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username,password);
					}
				});
				//Start our mail message
				MimeMessage msg = new MimeMessage(session);
				try {
					msg.setFrom(new InternetAddress(fromEmail));
					msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
					msg.setSubject("Automated Test Execution Results - Sergio Silva");
					
					Multipart emailContent = new MimeMultipart();
					
					//Text body part
					MimeBodyPart textBodyPart = new MimeBodyPart();
					textBodyPart.setText("QA Automation : Ebay Automated Order Test. Attached results");
					
					//Attachment body part.
					MimeBodyPart htmlAttachment = new MimeBodyPart();
					htmlAttachment.attachFile("./test-output/emailable-report.html");
					
					//Attach body parts
					emailContent.addBodyPart(textBodyPart);
					emailContent.addBodyPart(htmlAttachment);
					
					//Attach multipart to message
					msg.setContent(emailContent);
					
					Transport.send(msg);
					System.out.println("Sent message");
				} catch (MessagingException e) {
					e.printStackTrace();
				} 
					catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
}
