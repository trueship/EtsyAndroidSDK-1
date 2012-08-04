package com.etsy.etsyModels;

import org.json.JSONException;
import org.json.JSONObject;

public class ForumPost extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4253290644929724604L;
	private int thread_id;
	private int post_id;
	private String post;
	private String user_id;
	private int last_edit_time;
	private int create_date;


	
	public int getThreadId() {
		return thread_id;
	}
	
	public int getPostId() {
		return post_id;
	}
	
	public String getPost() {
		return post;
	}
	
	public String getUserId() {
		return user_id;
	}
	
	public int getLastEditTime() {
		return last_edit_time;
	}
	
	public int getCreateDate() {
		return create_date;
	}


	@Override
	public void parseData(JSONObject data) throws JSONException {
		this.thread_id = data.optInt("thread_id");
		this.post_id = data.optInt("post_id");
		this.post = data.optString("post");
		this.user_id = data.optString("user_id");
		this.last_edit_time = data.optInt("last_edit_time");
		this.create_date = data.optInt("create_date");

	}
	
	
}