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
        teachers.add(new thelistcontent("��С��", "���� ����Ϊ�Լ�����",R.drawable.head1,"����", "  ������������������ \n ��û�ͷ��������ӣ�����ռ��λ��\n�������������� "));
        teachers.add(new thelistcontent("��С��", "���� ����Ϊ�Լ�����",R.drawable.head2, "����","  ������������������ \n ��û�ͷ��������ӣ�����ռ��λ��\n�������������� "));
        teachers.add(new thelistcontent("��С��","���� ����Ϊ�Լ�����", R.drawable.head3, "���ۿ�������","  ������������������ \n ��û�ͷ��������ӣ�����ռ��λ��\n��������������"));
        teachers.add(new thelistcontent("�ܴ�", "���� ����Ϊ�Լ�����",R.drawable.head5, "�ܶ������ҵķ���","  ������������������ \n ��û�ͷ��������ӣ�����ռ��λ��\n�������������� "));
        teachers.add(new thelistcontent("�ܶ�", "���� ����Ϊ�Լ�����",R.drawable.head6, "���ۺúó�","  ������������������ \n ��û�ͷ��������ӣ�����ռ��λ��\n�������������� "));
        teachers.add(new thelistcontent("��ͷǿ","���� ����Ϊ�Լ�����", R.drawable.head7, "��Ҫ�ӹ���","  ������������������ \n ��û�ͷ��������ӣ�����ռ��λ��\n�������������� "));
        teachers.add(new thelistcontent("��ͷǿ","���� ����Ϊ�Լ�����", R.drawable.head8, "��Ҫ�ӹ���","  ������������������ \n ��û�ͷ��������ӣ�����ռ��λ��\n�������������� "));
        teachers.add(new thelistcontent("��ͷǿ", "���� ����Ϊ�Լ�����",R.drawable.head1, "��Ҫ�ӹ���","  ������������������ \n ��û�ͷ��������ӣ�����ռ��λ��\n�������������� "));
        teachers.add(new thelistcontent("��ͷǿ","���� ����Ϊ�Լ�����", R.drawable.head2, "��Ҫ�ӹ���","  ������������������ \n ��û�ͷ��������ӣ�����ռ��λ��\n�������������� "));
        teachers.add(new thelistcontent("��ͷǿ", "���� ����Ϊ�Լ�����",R.drawable.head3, "��Ҫ�ӹ���","  ������������������\n ��û�ͷ��������ӣ�����ռ��λ��\n�������������� "));
        teachers.add(new thelistcontent("��ͷǿ","���� ����Ϊ�Լ�����", R.drawable.head7, "��Ҫ�ӹ���","  ������������������ \n ��û�ͷ��������ӣ�����ռ��λ��\n�������������� "));
        teachers.add(new thelistcontent("��ͷǿ","���� ����Ϊ�Լ�����", R.drawable.head8, "��Ҫ�ӹ���","  ������������������ \n ��û�ͷ��������ӣ�����ռ��λ�� \n�������������� "));
    }
	public static List<thelistcontent> getAllLists() {
	    if (flag==true){
	        teachers.add(new thelistcontent(" ���Լ�","���� ����Ϊ�Լ�����", R.drawable.head8, "��Ҫ�ӹ���",Mycontent));
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

