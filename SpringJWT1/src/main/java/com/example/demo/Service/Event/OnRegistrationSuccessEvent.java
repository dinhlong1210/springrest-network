package com.example.demo.Service.Event;

import org.springframework.context.ApplicationEvent;
import com.example.demo.Model.User;

public class OnRegistrationSuccessEvent extends ApplicationEvent {
	
	private static final long serialVersionUID = 1L;
	private User user;
	
	public OnRegistrationSuccessEvent(User user) {
		super(user);
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
