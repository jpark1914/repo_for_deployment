package com.revature.beans;

public class VideoGame {
	
	private int vgid;
	private String vgname;
	private int vgmetascore;
	
	
	public VideoGame() {
		super();
		// TODO Auto-generated constructor stub
	}


	public VideoGame(int vgid, String vgname, int vgmetascore) {
		super();
		this.vgid = vgid;
		this.vgname = vgname;
		this.vgmetascore = vgmetascore;
	}


	public int getVgid() {
		return vgid;
	}


	public void setVgid(int vgid) {
		this.vgid = vgid;
	}


	public String getVgname() {
		return vgname;
	}


	public void setVgname(String vgname) {
		this.vgname = vgname;
	}


	public int getVgmetascore() {
		return vgmetascore;
	}


	public void setVgmetascore(int vgmetascore) {
		this.vgmetascore = vgmetascore;
	}


	@Override
	public String toString() {
		return "VideoGame [vgid=" + vgid + ", vgname=" + vgname + ", vgmetascore=" + vgmetascore + "]";
	}
	
	

}
