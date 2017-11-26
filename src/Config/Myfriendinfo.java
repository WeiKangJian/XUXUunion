package Config;

import java.util.ArrayList;
import java.util.List;

import com.Activitys.real.Addfriend;
import com.example.real.R;

public class Myfriendinfo {
	 private String name;
	 private int image;
	 public static String mid;
	 public static int imageId;
//	 private String desc;
//	 private String content;
//	 private String introduce;
//	 public static String Myname;
//	 public static String Mymain;
//	 public static String Mycontent ;
	// public  static boolean flag = false;
	 public Myfriendinfo(String name,int image) {
	        this.name = name;
	        this.image = image;
//	        this.imageId = imageId;
//	        this.content = content;
//	        this.desc = desc;
//	        this.introduce = introduce;
	    }
	public static List<Myfriendinfo> teachers = new ArrayList<Myfriendinfo>();
	public static List<Myfriendinfo> getAllLists() {
		if(mid!=null){
		teachers.add(new Myfriendinfo(mid,imageId));}
		return teachers;
	}
	 public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public int getImageId() {
	        return image;
	    }

	    public void setImageId(int imageId) {
	        this.image = imageId;
	    }
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
