package com.Activitys.real;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import com.example.real.R;

import Config.Config;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.Image;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class Mylist2Activity extends Activity {
	private VideoView video1;
	private Button button1;
	private Button button2;
	private ImageView imagemian;
	private Bitmap myBitmap;
	private byte[] mContent;
	public static final String url = "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4" ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mylist2);
		String videourl = url;
		Uri uri = Uri.parse(videourl);
		video1 = (VideoView) findViewById(R.id.videoView);
		video1.setOnCompletionListener( new MyPlayerOnCompletionListener());
		video1.setVideoURI(uri);
		button2 = (Button) findViewById(R.id.buttonofSelectPicture);
		button1 = (Button) findViewById(R.id.button1);
		imagemian = (ImageView) findViewById(R.id.imageViewtochange);
		setpicture();
		button1.setOnClickListener(new OnClickListener() {
			int flag = 1;
			@Override
			public void onClick(View arg0) {
				if(flag==1){
				video1.start();
				flag = 0;
				button1.setText("暂停");
				}
				else if(flag==0){
					video1.pause();
					flag = 1;
					button1.setText("播放");
				}
			}
		});
		button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				final CharSequence[] items = { "相册", "拍照" };
				
					AlertDialog dlg = new AlertDialog.Builder(Mylist2Activity.this).setTitle("选择照片").setItems(items, 
		    		new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								// TODO Auto-generated method stub
							//这里item是根据选择的方式，	在items数组里面定义了两种方式，拍照的下标为1所以就调用拍照方法	
								if(which==1){
									Intent getImageByCamera  = new Intent("android.media.action.IMAGE_CAPTURE");
									startActivityForResult(getImageByCamera, 1);
								}else{
									Intent getImage = new Intent(Intent.ACTION_GET_CONTENT);
									getImage.addCategory(Intent.CATEGORY_OPENABLE);
									getImage.setType("image/jpeg");
									startActivityForResult(getImage, 0);
								}
								
							}
						}).create();
				dlg.show();
			}
		});
//		button2 = (Button) findViewById(R.id.button2);
//		button2.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View arg0) {
//				video1.pause();
//				// TODO Auto-generated method stub
//				
//			}
//		});
	}
     private void setpicture(){
    	 if(Config.flagOfPicture==true){
    		 imagemian.setBackgroundColor(Color.BLACK);
    		 imagemian.setImageBitmap(Config.bit);
    	 }
     }
	class MyPlayerOnCompletionListener implements MediaPlayer.OnCompletionListener {

        @Override
        public void onCompletion(MediaPlayer mp) {
            Toast.makeText( Mylist2Activity.this, "感谢您的收看", Toast.LENGTH_SHORT).show();
        }
        
    }
	@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	// TODO Auto-generated method stub
    	super.onActivityResult(requestCode, resultCode, data);
    	
    	ContentResolver contentResolver  =getContentResolver();
    	 /**
         * 因为两种方式都用到了startActivityForResult方法，这个方法执行完后都会执行onActivityResult方法，
         * 所以为了区别到底选择了那个方式获取图片要进行判断，这里的requestCode跟startActivityForResult里面第二个参数对应
         */
    	
    	if(requestCode==0){
    		
    		try {
    			 //获得图片的uri 
    			Uri orginalUri = data.getData();
    			  //将图片内容解析成字节数组 
    			mContent = readStream(contentResolver.openInputStream(Uri.parse(orginalUri.toString())));
    			 //将字节数组转换为ImageView可调用的Bitmap对象 
    			myBitmap  =getPicFromBytes(mContent,null);
    			  ////把得到的图片绑定在控件上显示
    			imagemian.setBackgroundColor(Color.BLACK);
    			imagemian.setImageBitmap(myBitmap);
    			Config.flagOfPicture =true;
    			Config.bit = myBitmap;
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
    		
    		//方式二
//    		try {
//    			Uri selectedImage = data.getData();
//        		String[] filePathColumn = { MediaStore.Images.Media.DATA };
//
//    			Cursor cursor = getContentResolver().query(selectedImage,
//    					filePathColumn, null, null, null);
//    			cursor.moveToFirst();
//
//    			int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
//    			String picturePath = cursor.getString(columnIndex);
//    			cursor.close();
//    			imagemian.setImageBitmap(BitmapFactory.decodeFile(picturePath));
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//			}
    		
    		
    	}else if(requestCode==1){
    		try {
    			Bundle extras = data.getExtras();
		    	myBitmap = (Bitmap) extras.get("data");
		    	ByteArrayOutputStream baos = new ByteArrayOutputStream();     
		    	myBitmap.compress(Bitmap.CompressFormat.JPEG , 100, baos);     
				mContent=baos.toByteArray();
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
    		imagemian.setBackgroundColor(Color.BLACK);
    		imagemian.setImageBitmap(myBitmap);
			Config.flagOfPicture =true;
			Config.bit = myBitmap;
    	}
    	
    }
    
   public static Bitmap getPicFromBytes(byte[] bytes, BitmapFactory.Options opts) { 
        if (bytes != null) 
            if (opts != null) 
                return BitmapFactory.decodeByteArray(bytes, 0, bytes.length,opts); 
            else 
                return BitmapFactory.decodeByteArray(bytes, 0, bytes.length); 
        return null; 
    } 
    
    
    
 public static byte[] readStream(InputStream in) throws Exception{
	 byte[] buffer  =new byte[1024];
	 int len  =-1;
	 ByteArrayOutputStream outStream = new ByteArrayOutputStream();
	 
	 while((len=in.read(buffer))!=-1){
		 outStream.write(buffer, 0, len);
	 }
	 byte[] data  =outStream.toByteArray();
	 outStream.close();
	 in.close();
	 return data;
 }
    
}
