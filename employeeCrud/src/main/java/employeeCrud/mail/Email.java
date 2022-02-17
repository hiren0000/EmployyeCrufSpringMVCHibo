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
		
   
		public void sendEmail(String receiverEmail)
		{
			String senderEmail = "lifeofprogrammer13@gmail.com";
			
			
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setFrom(senderEmail);
			msg.setTo(receiverEmail);
			msg.setSubject("OTP Verification");
			msg.setText("Hello there this is the exmaple of simple sedning email to the dynamic users");
			
			mailSender.send(msg);
			
		}
	

}
