package com.boot.www.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.boot.www.common.model.Email;

@Entity
@Table(name = "oa_email")
public class OaEmail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5822026229100795066L;

	/**
	 * 自增主键
	 */
	private Long id;
	
	/**
	 * 接收人邮箱(多个逗号分开)
	 */
	private String receiveEmail;
	
	/**
	 * 主题
	 */
	private String subject;
	
	/**
	 * 发送内容
	 */
	private String content;
	
	/**
	 * 模板
	 */
	private String template;
	
	/**
	 * 发送时间
	 */
	private Timestamp sendTime;
	

	public OaEmail() {
		super();
	}

	public OaEmail(Email mail) {
		this.receiveEmail = Arrays.toString(mail.getEmail());
		this.subject = mail.getSubject();
		this.content = mail.getContent();
		this.template = mail.getTemplate();
		this.sendTime = new Timestamp(new Date().getTime());
	}

	public void setId(Long id) {
		this.id = id;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}
	
	public void setReceiveEmail(String receiveEmail) {
		this.receiveEmail = receiveEmail;
	}
	@Column(name = "receive_email", nullable = false, length = 500)
	public String getReceiveEmail() {
		return receiveEmail;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	@Column(name = "subject", nullable = false, length = 100)
	public String getSubject() {
		return subject;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	@Column(name = "content", nullable = false, length = 65535)
	public String getContent() {
		return content;
	}
	
	public void setTemplate(String template) {
		this.template = template;
	}
	@Column(name = "template", nullable = false, length = 100)
	public String getTemplate() {
		return template;
	}
	
	public void setSendTime(Timestamp sendTime) {
		this.sendTime = sendTime;
	}
	@Column(name = "send_time", nullable = false, length = 19)
	public Timestamp getSendTime() {
		return sendTime;
	}
}
