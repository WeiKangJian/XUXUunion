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
        teachers.add(new thelistcontent("��С��", R.drawable.list1,"����", "  ������������������ \n ��û�ͷ��������ӣ�����ռ��λ��\n�������������� "));
        teachers.add(new thelistcontent("��С��", R.drawable.list1, "����","  ������������������ \n ��û�ͷ��������ӣ�����ռ��λ��\n�������������� "));
        teachers.add(new thelistcontent("��С��", R.drawable.list1, "���ۿ�������","  ������������������ \n ��û�ͷ��������ӣ�����ռ��λ��\n��������������"));
        teachers.add(new thelistcontent("�ܴ�", R.drawable.list1, "�ܶ������ҵķ���","  ������������������ \n ��û�ͷ��������ӣ�����ռ��λ��\n�������������� "));
        teachers.add(new thelistcontent("�ܶ�", R.drawable.list1, "���ۺúó�","  ������������������ \n ��û�ͷ��������ӣ�����ռ��λ��\n�������������� "));
        teachers.add(new thelistcontent("��ͷǿ", R.drawable.list1, "��Ҫ�ӹ���","  ������������������ \n ��û�ͷ��������ӣ�����ռ��λ��\n�������������� "));
        teachers.add(new thelistcontent("��ͷǿ", R.drawable.list1, "��Ҫ�ӹ���","  ������������������ \n ��û�ͷ��������ӣ�����ռ��λ��\n�������������� "));
        teachers.add(new thelistcontent("��ͷǿ", R.drawable.list1, "��Ҫ�ӹ���","  ������������������ \n ��û�ͷ��������ӣ�����ռ��λ��\n�������������� "));
        teachers.add(new thelistcontent("��ͷǿ", R.drawable.list1, "��Ҫ�ӹ���","  ������������������ \n ��û�ͷ��������ӣ�����ռ��λ��\n�������������� "));
        teachers.add(new thelistcontent("��ͷǿ", R.drawable.list1, "��Ҫ�ӹ���","  ������������������\n ��û�ͷ��������ӣ�����ռ��λ��\n�������������� "));
        teachers.add(new thelistcontent("��ͷǿ", R.drawable.list1, "��Ҫ�ӹ���","  ������������������ \n ��û�ͷ��������ӣ�����ռ��λ��\n�������������� "));
        teachers.add(new thelistcontent("��ͷǿ", R.drawable.list1, "��Ҫ�ӹ���","  ������������������ \n ��û�ͷ��������ӣ�����ռ��λ�� \n�������������� "));
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

