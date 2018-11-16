package org.citiustech.RESTfulAPI.messenger.Datebase;

import java.util.HashMap;
import java.util.Map;

import org.citiustech.RESTfulAPI.messenger.model.Message;
import org.citiustech.RESTfulAPI.messenger.model.Profile;

public class DatabaseClass {
	private static Map<Long,Message> messages= new HashMap<Long,Message>();
	private static Map<String,Profile> profiles= new HashMap<String,Profile>();
	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	public static void setMessages(Map<Long, Message> messages) {
		DatabaseClass.messages = messages;
	}
	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
	public static void setProfiles(Map<String, Profile> profiles) {
		DatabaseClass.profiles = profiles;
	}
	
}
