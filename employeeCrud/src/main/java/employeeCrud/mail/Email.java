package employeeCrud.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class Email 
{	
		@Autowired
		private MailSender mailSender;

		public void setMailSender(MailSender mailSender) {
			this.mailSender = mailSender;
		}
		
   
		public void sendEmail(String receiverEmail, long otp)
		{
			String senderEmail = "lifeofprogrammer13@gmail.com";
			
			
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setFrom(senderEmail);
			msg.setTo(receiverEmail);
			msg.setSubject("OTP Verification");
			msg.setText("Hello there, please use the below OTP "+"\n"+otp);
			
			mailSender.send(msg);
			
		}
	

}
