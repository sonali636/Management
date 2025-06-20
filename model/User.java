package model;

public class User {

	
	    private String uname;
	    private String uemail;
	    private String upwd;

	    // Constructor
	    public User(String uname, String uemail, String upwd) {
	        this.uname = uname;
	        this.uemail = uemail;
	        this.upwd = upwd;
	    }

	    // Getters and Setters
	    public String getUname() {
	        return uname;
	    }

	    public void setUname(String uname) {
	        this.uname = uname;
	    }

	    public String getUemail() {
	        return uemail;
	    }

	    public void setUemail(String uemail) {
	        this.uemail = uemail;
	    }

	    public String getUpwd() {
	        return upwd;
	    }

	    public void setUpwd(String upwd) {
	        this.upwd = upwd;
	    }
	}

