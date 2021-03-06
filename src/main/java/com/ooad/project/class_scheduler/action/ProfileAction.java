package com.ooad.project.class_scheduler.action;

import java.util.Map;

import com.ooad.project.class_scheduler.bean.User;
import com.ooad.project.class_scheduler.model.UserModel;
import com.ooad.project.class_scheduler.util.Validator;
import com.ooad.project.class_scheduler.util.ValidatorUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ProfileAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private User user;
	private UserModel userModel;
	private Map<String, Object> session;
	private int id;
	private String name, email, username, password, track, school;
	private ValidatorUtil validatorUtil;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTrack() {
		return track;
	}

	public void setTrack(String track) {
		this.track = track;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public ProfileAction() {
		user = new User();
		userModel = new UserModel();
		validatorUtil = new ValidatorUtil(new Validator());
		session = ActionContext.getContext().getSession();
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		user = userModel.fetchUserByUsername((String) session.get("current_user"));
		setId(user.getId());
		setName(user.getName());
		setEmail(user.getEmail());
		setTrack(user.getTrack());
		setSchool(user.getSchool());
		setUsername(user.getUsername());
		setPassword(user.getPassword());
		return super.execute();
	}
	
	public String updateProfile() throws Exception {
		user.setId(id);
		user.setName(name);
		user.setEmail(email);
		user.setUsername(username);
		user.setPassword(password);
		user.setTrack(track);
		user.setSchool(school);
		if(isValid() && userModel.updateUser(user)){
			addActionMessage(getText("message.register.success"));
			return SUCCESS;
		} else {
			addActionError(getText("message.register.error"));
			return ERROR;
		}
	}
	
	public boolean isValid() {
		// TODO Auto-generated method stub
		boolean valid = true;
		
		if(!validatorUtil.checkValid(getName())) {
			addFieldError("name", getText("errors.name.required"));
			valid = false;
		}
		if(!validatorUtil.checkValid(getEmail())) {
			addFieldError("email", getText("errors.email.required"));
			valid = false;
		}
		if(!validatorUtil.checkValid(getTrack())) {
			addFieldError("track", getText("errors.track.required"));
			valid = false;
		}
		if(!validatorUtil.checkValid(getSchool())) {
			addFieldError("school", getText("errors.school.required"));
			valid = false;
		}
		if(!validatorUtil.checkValid(getUsername())) {
			addFieldError("username", getText("errors.username.required"));
			valid = false;
		}
		if(!validatorUtil.checkValid(getPassword())) {
			addFieldError("password", getText("errors.password.required"));
			valid = false;
		}
		
		return valid;
	}
}
