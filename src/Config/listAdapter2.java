package Config;

import java.util.List;
import java.util.Random;

import com.Activitys.real.Addfriend;
import com.Activitys.real.Listdetail;
import com.example.real.R;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class listAdapter2 extends ArrayAdapter<thelistcontent> {

	public listAdapter2(Context context, int resource, List<thelistcontent> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    	Random random = new java.util.Random();
    	// 获取老师的数据
    	int newposition ;
    	if(position<5){
    		newposition = random.nextInt(position+5);
    	}
    	else{
    		newposition = random.nextInt(position+1);
    	}
       final  thelistcontent teacher = getItem(newposition);

        // 创建布局
        View oneTeacherView = LayoutInflater.from(getContext()).inflate(R.layout.item, parent, false);

        // 获取ImageView和TextView
        ImageView imageView = (ImageView) oneTeacherView.findViewById(R.id.teacher_small_imageView);
        TextView textView = (TextView) oneTeacherView.findViewById(R.id.teacher_name_textView);
//        TextView textview2 = (TextView) oneTeacherView.findViewById(R.id.content);
        // 根据老师数据设置ImageView和TextView的展现
        imageView.setImageResource(teacher.getImageId());
        textView.setText(teacher.getName());
//        textview2.setText(teacher.getcontent());
        oneTeacherView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	Intent intent = new Intent(getContext(),Addfriend.class);
                // 准备跳转
               intent.putExtra("teacher_image", teacher.getImageId());
               intent.putExtra("teacher_desc", teacher.getDesc());
               intent.putExtra("teacher_name", teacher.getName());
               intent.putExtra("teacher_introduce", teacher.getintroduce());
               getContext().startActivity(intent);

            }
        });

        return oneTeacherView;
    }

}
