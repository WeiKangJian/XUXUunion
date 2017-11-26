package Config;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* TranslateAnimation(float fromXDelta, float toXDelta, float fromYDelta, float toYDelta)
float fromXDelta 动画开始的点离当前View X坐标上的差值
float toXDelta 动画结束的点离当前View X坐标上的差值
float fromYDelta 动画开始的点离当前View Y坐标上的差值
float toYDelta 动画结束的点离当前View Y坐标上的差值*/
//动画类
public class Danmu {
private TranslateAnimation translateAnimation;
//我用的是TextView.这个看自己喜好。这里的boolean量是我用来实现两种弹幕特效
public Danmu(TextView textView, RelativeLayout relativeLayout,boolean isIn){
    int length=relativeLayout.getBottom()-relativeLayout.getTop();      //获取relativelayout的长度

    int y=(int) ((0.5*relativeLayout.getTop())+(int)(Math.random()*length));       //设置弹幕随机产生的y坐标
    translateAnimation=new TranslateAnimation(relativeLayout.getLeft(),relativeLayout.getRight(),y-400,y-400);
    translateAnimation.setDuration(3000);
    textView.setAnimation(translateAnimation);
    translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
    translateAnimation.start();
}
}
