package Config;

import java.util.ArrayList;
import java.util.List;

import com.example.real.R;

public class thelistcontent {
	 private String name;
	 private int imageId;
	 private String desc;
	 private String content;
	 private String introduce;
	 public static String Mycontent ;
	 public  static boolean flag = false;
	 public thelistcontent(String name,String introduce,int imageId, String content,String desc) {
	        this.name = name;
	        this.imageId = imageId;
	        this.content = content;
	        this.desc = desc;
	        this.introduce = introduce;
	    }
	public static List<thelistcontent> teachers = new ArrayList<thelistcontent>();
	static {
        teachers.add(new thelistcontent("张小三", "我是 ，我为自己代言",R.drawable.head1,"交友", "  啦啦啦啦啦啦啦拉拉 \n 还没和服务器连接，我先占个位置\n啦啦啦啦阿拉啦 "));
        teachers.add(new thelistcontent("李小四", "我是 ，我为自己代言",R.drawable.head2, "借书","  啦啦啦啦啦啦啦拉拉 \n 还没和服务器连接，我先占个位置\n啦啦啦啦阿拉啦 "));
        teachers.add(new thelistcontent("王小五","我是 ，我为自己代言", R.drawable.head3, "出售考研资料","  啦啦啦啦啦啦啦拉拉 \n 还没和服务器连接，我先占个位置\n啦啦啦啦阿拉啦"));
        teachers.add(new thelistcontent("熊大", "我是 ，我为自己代言",R.drawable.head5, "熊二吃了我的蜂蜜","  啦啦啦啦啦啦啦拉拉 \n 还没和服务器连接，我先占个位置\n啦啦啦啦阿拉啦 "));
        teachers.add(new thelistcontent("熊二", "我是 ，我为自己代言",R.drawable.head6, "蜂蜜好好吃","  啦啦啦啦啦啦啦拉拉 \n 还没和服务器连接，我先占个位置\n啦啦啦啦阿拉啦 "));
        teachers.add(new thelistcontent("光头强","我是 ，我为自己代言", R.drawable.head7, "我要加工资","  啦啦啦啦啦啦啦拉拉 \n 还没和服务器连接，我先占个位置\n啦啦啦啦阿拉啦 "));
        teachers.add(new thelistcontent("光头强","我是 ，我为自己代言", R.drawable.head8, "我要加工资","  啦啦啦啦啦啦啦拉拉 \n 还没和服务器连接，我先占个位置\n啦啦啦啦阿拉啦 "));
        teachers.add(new thelistcontent("光头强", "我是 ，我为自己代言",R.drawable.head1, "我要加工资","  啦啦啦啦啦啦啦拉拉 \n 还没和服务器连接，我先占个位置\n啦啦啦啦阿拉啦 "));
        teachers.add(new thelistcontent("光头强","我是 ，我为自己代言", R.drawable.head2, "我要加工资","  啦啦啦啦啦啦啦拉拉 \n 还没和服务器连接，我先占个位置\n啦啦啦啦阿拉啦 "));
        teachers.add(new thelistcontent("光头强", "我是 ，我为自己代言",R.drawable.head3, "我要加工资","  啦啦啦啦啦啦啦拉拉\n 还没和服务器连接，我先占个位置\n啦啦啦啦阿拉啦 "));
        teachers.add(new thelistcontent("光头强","我是 ，我为自己代言", R.drawable.head7, "我要加工资","  啦啦啦啦啦啦啦拉拉 \n 还没和服务器连接，我先占个位置\n啦啦啦啦阿拉啦 "));
        teachers.add(new thelistcontent("光头强","我是 ，我为自己代言", R.drawable.head8, "我要加工资","  啦啦啦啦啦啦啦拉拉 \n 还没和服务器连接，我先占个位置 \n啦啦啦啦阿拉啦 "));
    }
	public static List<thelistcontent> getAllLists() {
	    if (flag==true){
	        teachers.add(new thelistcontent(" 我自己","我是 ，我为自己代言", R.drawable.head8, "我要加工资",Mycontent));
	        }
	    flag =false;
		return teachers;
	}
	 public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public int getImageId() {
	        return imageId;
	    }

	    public void setImageId(int imageId) {
	        this.imageId = imageId;
	    }
	    public void setcontent(String content){
	    	this.content  = content;
	    }
	    public  String getcontent(){
	    	return content;
	    }
	    public String getDesc() {
	        return desc;
	    }

	    public void setDesc(String desc) {
	        this.desc = desc;
	    }
	    public String getintroduce(){
	    	return introduce;
	    }
	    public void setintroduce(String introduce){
	    	this.introduce = introduce;
	    }
	}

