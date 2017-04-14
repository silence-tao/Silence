package com.silencetao.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.silencetao.exception.SilenceException;

/**
 * 邮件发送工具类
 * @author Silence
 *
 */
public class MailUtil extends Thread {
	private final Logger log = LoggerFactory.getLogger(getClass());
	private String subject;
	private String content;
	private String toEmail;
	private boolean result;

	public MailUtil(String subject, String content, String toEmail) {
		this.subject = subject;
		this.content = content;
		this.toEmail = toEmail;
		this.result = false;
	}

	public boolean isResult() {
		return this.result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public void run() throws SilenceException {
		this.log.info("开始发送邮件");
		Properties properties = new Properties();
		properties.setProperty("mail.host", PropertiesUtil.getProperties("host"));
		properties.setProperty("mail.smtp.auth", "true");
		Session session = Session.getDefaultInstance(properties,
				new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(PropertiesUtil
								.getProperties("email"), PropertiesUtil
								.getProperties("password"));
					}
				});
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(PropertiesUtil
					.getProperties("email")));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(
					this.toEmail));
			message.setSubject(this.subject);
			message.setContent(this.content, "text/html;charset=UTF-8");
			Transport.send(message);
			this.result = true;
			this.log.info("邮件发送成功");
		} catch (AddressException e) {
			this.log.warn("邮箱格式不正确");
			this.log.error(e.getMessage(), e);
			throw new SilenceException("邮箱格式不正确");
		} catch (MessagingException e) {
			this.log.warn("邮件内容不符合规定");
			this.log.error(e.getMessage(), e);
			throw new SilenceException("邮件内容不符合规定");
		} catch (Exception e) {
			this.log.warn("邮件发送失败");
			this.log.error(e.getMessage(), e);
			throw new SilenceException("邮件发送失败");
		}
	}
}