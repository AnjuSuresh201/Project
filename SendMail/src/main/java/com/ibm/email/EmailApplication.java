package com.ibm.email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.ibm.email.entity.Mail;
import com.ibm.email.service.MailService;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class EmailApplication {

	public static void main(String[] args) {
		Mail mail = new Mail();
        mail.setMailFrom("");		// sender email id
        mail.setMailTo("");			// Receipent's email id
        mail.setMailSubject("HomeLoan Status");
        mail.setMailContent("Your HomeLoan Request is approved. \n Please visit our application for further details.");
 
        ApplicationContext ctx = SpringApplication.run(EmailApplication.class, args);
        MailService mailService = (MailService) ctx.getBean("mailService");
        mailService.sendEmail(mail);
	}

}
