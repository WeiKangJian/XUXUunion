package Config;

import java.util.ArrayList;
import java.util.List;

import com.example.real.Addfriend;
import com.example.real.R;

public class Myfriendinfo {
	 private String name;
	 public static String mid;
//	 private int imageId;
//	 private String desc;
//	 private String content;
//	 private String introduce;
//	 public static String Myname;
//	 public static String Mymain;
//	 public static String Mycontent ;
	// public  static boolean flag = false;
	 public Myfriendinfo(String name) {
	        this.name = name;
//	        this.imageId = imageId;
//	        this.content = content;
//	        this.desc = desc;
//	        this.introduce = introduce;
	    }
	public static List<Myfriendinfo> teachers = new ArrayList<Myfriendinfo>();
	public static List<Myfriendinfo> getAllLists() {
		if(mid!=null){
		teachers.add(new Myfriendinfo(mid));}
		return teachers;
	}
	 public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

//	    public int getImageId() {
//	        return imageId;
//	    }
//
//	    public void setImageId(int imageId) {
//	        this.imageId = imageId;
//	    }
//	    public void setcontent(String content){
//	    	this.content  = content;
//	    }
//	    public  String getcontent(){
//	    	return content;
//	    }
//	    public String getDesc() {
//	        return desc;
//	    }
//
//	    public void setDesc(String desc) {
//	        this.desc = desc;
//	    }
//	    public String getintroduce(){
//	    	return introduce;
//	    }
//	    public void setintroduce(String introduce){
//	    	this.introduce = introduce;
//	    }
}
