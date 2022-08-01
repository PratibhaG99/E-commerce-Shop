package com.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shop.entity.Mail;
import com.shop.serviceImpl.MailServiceImpl;

@RestController
@RequestMapping("/shop/mail")
public class MailController {
	
	@Autowired
	private MailServiceImpl mailService;
	
	//api to send mail
	
	@RequestMapping(value="/sendmail", method=RequestMethod.POST)
	public ResponseEntity<?> sendemail(@RequestBody Mail mail){
		boolean result=  this.mailService.sendEmail(mail.getTo(),mail.getSubject(),mail.getMessage());
		System.out.println(mail);
		if(result) {
			return ResponseEntity.ok("MAIL SENT SUCCESSFULLY !!!");	
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("MAIL NOT SENT");
	}

}
