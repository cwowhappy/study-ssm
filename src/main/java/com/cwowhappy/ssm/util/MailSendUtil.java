package com.cwowhappy.ssm.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Map;

/**
 * Created by cwowhappy on 17-5-23.
 */
@Component
public class MailSendUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(MailSendUtil.class);
    private JavaMailSender javaMailSender;
    private String fromUser;

    public void send(String to, String subject, String content) {

    }

    public void send(String[] toUsers, String[] ccUsers, String subject, String content,
                     Map<String, FileSystemResource> inlineResources,
                     Map<String, FileSystemResource> attachments) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        final MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        mimeMessageHelper.setFrom(fromUser);
        mimeMessageHelper.setTo(toUsers);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(content, true);
        if(null != ccUsers) {
            mimeMessageHelper.setCc(ccUsers);
        }
        /**
         * 添加内联资源
         */
        if(null != inlineResources) {
            inlineResources.forEach((key, value) -> {
                try {
                    mimeMessageHelper.addInline(key, value);
                } catch (MessagingException e) {
                    LOGGER.error("Exception: {}", e.getMessage());
                    LOGGER.debug("{}", e);
                }
            });
        }
        /**
         * 添加附件
         */
        if(null != attachments) {
            attachments.forEach((key, value) -> {
                try {
                    mimeMessageHelper.addAttachment(key, value);
                } catch (MessagingException e) {
                    LOGGER.error("Exception: {}", e.getMessage());
                    LOGGER.debug("{}", e);
                }
            });
        }
        /**
         * 发送邮件
         */
        javaMailSender.send(mimeMessage);
    }

    @Autowired
    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Value("${mail.account.username}")
    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }
}
