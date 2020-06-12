package Bean;
public class BoardBean {
	private int id;
	private String name;
	private String value;
	private String mail;
	private String create_time;
	private String editing_time;
	private String address;
	private String picture;

	public BoardBean(int id,String value,String editing_time){
		super();
		this.id=id;
		this.value=value;
		this.editing_time=editing_time;
	}
	public BoardBean(int id,String name,String value,String mail,String create_time) {
		super();
		this.id=id;
		this.name = name;
		this.value = value;
		this.mail = mail;
		this.create_time = create_time;
	}
	public BoardBean(int id,String name,String value,String mail,String create_time,String editing_time,String address,String picture){
		this.id = id;
		this.name = name;
		this.value = value;
		this.mail = mail;
		this.create_time = create_time;
		this.editing_time=editing_time;
		this.address=address;
		this.picture=picture;
	}
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getValue(){
		return value;
	}
	public void setValue(String value){
		this.value=value;
	}
	public String getMail(){
		return mail;
	}
	public void setMail(String mail){
		this.mail=mail;
	}
	public String getTime(){
		return create_time;
	}
	public void setTime(String create_time){
		this.create_time=create_time;
	}
	public String getTime2(){
		return editing_time;
	}
	public void setTime2(String editing_time){
		this.editing_time=editing_time;
	}
	public String getAdd(){
		return address;
	}
	public void setAdd(String address){
		this.address=address;
	}
	public String getPicture(){
		return picture;
	}
	public void setPicture(String picture){
		this.picture=picture;
	}
}
