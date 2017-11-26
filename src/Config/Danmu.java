package Config;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* TranslateAnimation(float fromXDelta, float toXDelta, float fromYDelta, float toYDelta)
float fromXDelta ������ʼ�ĵ��뵱ǰView X�����ϵĲ�ֵ
float toXDelta ���������ĵ��뵱ǰView X�����ϵĲ�ֵ
float fromYDelta ������ʼ�ĵ��뵱ǰView Y�����ϵĲ�ֵ
float toYDelta ���������ĵ��뵱ǰView Y�����ϵĲ�ֵ*/
//������
public class Danmu {
private TranslateAnimation translateAnimation;
//���õ���TextView.������Լ�ϲ�á������boolean����������ʵ�����ֵ�Ļ��Ч
public Danmu(TextView textView, RelativeLayout relativeLayout,boolean isIn){
    int length=relativeLayout.getBottom()-relativeLayout.getTop();      //��ȡrelativelayout�ĳ���

    int y=(int) ((0.5*relativeLayout.getTop())+(int)(Math.random()*length));       //���õ�Ļ���������y����
    translateAnimation=new TranslateAnimation(relativeLayout.getLeft(),relativeLayout.getRight(),y-400,y-400);
    translateAnimation.setDuration(3000);
    textView.setAnimation(translateAnimation);
    translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
    translateAnimation.start();
}
}
