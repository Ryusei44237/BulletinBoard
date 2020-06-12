package Bean;
  public class UserBean {
	  private String user_name;
	  private String user_pass;

    public UserBean(String user_name,String user_pass){
    	super();
    	this.user_name=user_name;
    	this.user_pass=user_pass;
    }

    public String getName(){
      return user_name;
    }
    public void setId(String user_name){
      this.user_name=user_name;
    }
    public String getPass(){
      return user_pass;
    }
    public void setName(String user_pass){
      this.user_pass=user_pass;
    }
  }
