package Config;

import android.widget.ArrayAdapter;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

import com.example.real.Listdetail;
import com.example.real.R;
public class listAdapter extends ArrayAdapter<thelistcontent> {
	public listAdapter(Context context, int resource, List<thelistcontent> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // ��ȡ��ʦ������
       final  thelistcontent teacher = getItem(position);

        // ��������
        View oneTeacherView = LayoutInflater.from(getContext()).inflate(R.layout.item, parent, false);

        // ��ȡImageView��TextView
        ImageView imageView = (ImageView) oneTeacherView.findViewById(R.id.teacher_small_imageView);
        TextView textView = (TextView) oneTeacherView.findViewById(R.id.teacher_name_textView);
        TextView textview2 = (TextView) oneTeacherView.findViewById(R.id.content);
        // ������ʦ��������ImageView��TextView��չ��
        imageView.setImageResource(teacher.getImageId());
        textView.setText(teacher.getName());
        textview2.setText(teacher.getcontent());
        oneTeacherView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	Intent intent = new Intent(getContext(),Listdetail.class);
                // ׼����ת
                intent.putExtra("teacher_image", teacher.getImageId());
                intent.putExtra("teacher_desc", teacher.getDesc());
                getContext().startActivity(intent);

            }
        });

        return oneTeacherView;
    }

}
