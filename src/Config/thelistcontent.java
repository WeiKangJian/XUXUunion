package Config;

import java.util.ArrayList;
import java.util.List;

import com.example.real.R;

public class thelistcontent {
	 private String name;
	 private int imageId;
	 private String desc;
	 private String content;
	 public thelistcontent(String name, int imageId, String content,String desc) {
	        this.name = name;
	        this.imageId = imageId;
	        this.content = content;
	        this.desc = desc;
	    }

	public static List<thelistcontent> getAllLists() {
        List<thelistcontent> teachers = new ArrayList<thelistcontent>();
        teachers.add(new thelistcontent("张小三", R.drawable.list1,"交友", "  啦啦啦啦啦啦啦拉拉 \n 还没和服务器连接，我先占个位置\n啦啦啦啦阿拉啦 "));
        teachers.add(new thelistcontent("李小四", R.drawable.list1, "借书","  啦啦啦啦啦啦啦拉拉 \n 还没和服务器连接，我先占个位置\n啦啦啦啦阿拉啦 "));
        teachers.add(new thelistcontent("王小五", R.drawable.list1, "出售考研资料","  啦啦啦啦啦啦啦拉拉 \n 还没和服务器连接，我先占个位置\n啦啦啦啦阿拉啦"));
        teachers.add(new thelistcontent("熊大", R.drawable.list1, "熊二吃了我的蜂蜜","  啦啦啦啦啦啦啦拉拉 \n 还没和服务器连接，我先占个位置\n啦啦啦啦阿拉啦 "));
        teachers.add(new thelistcontent("熊二", R.drawable.list1, "蜂蜜好好吃","  啦啦啦啦啦啦啦拉拉 \n 还没和服务器连接，我先占个位置\n啦啦啦啦阿拉啦 "));
        teachers.add(new thelistcontent("光头强", R.drawable.list1, "我要加工资","  啦啦啦啦啦啦啦拉拉 \n 还没和服务器连接，我先占个位置\n啦啦啦啦阿拉啦 "));
        teachers.add(new thelistcontent("光头强", R.drawable.list1, "我要加工资","  啦啦啦啦啦啦啦拉拉 \n 还没和服务器连接，我先占个位置\n啦啦啦啦阿拉啦 "));
        teachers.add(new thelistcontent("光头强", R.drawable.list1, "我要加工资","  啦啦啦啦啦啦啦拉拉 \n 还没和服务器连接，我先占个位置\n啦啦啦啦阿拉啦 "));
        teachers.add(new thelistcontent("光头强", R.drawable.list1, "我要加工资","  啦啦啦啦啦啦啦拉拉 \n 还没和服务器连接，我先占个位置\n啦啦啦啦阿拉啦 "));
        teachers.add(new thelistcontent("光头强", R.drawable.list1, "我要加工资","  啦啦啦啦啦啦啦拉拉\n 还没和服务器连接，我先占个位置\n啦啦啦啦阿拉啦 "));
        teachers.add(new thelistcontent("光头强", R.drawable.list1, "我要加工资","  啦啦啦啦啦啦啦拉拉 \n 还没和服务器连接，我先占个位置\n啦啦啦啦阿拉啦 "));
        teachers.add(new thelistcontent("光头强", R.drawable.list1, "我要加工资","  啦啦啦啦啦啦啦拉拉 \n 还没和服务器连接，我先占个位置 \n啦啦啦啦阿拉啦 "));
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
	}

