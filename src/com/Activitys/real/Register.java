package com.Activitys.real;


import java.text.SimpleDateFormat;
import java.util.Date;
import com.example.real.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import Config.Config;
public class Register extends Activity implements OnClickListener{
	SharedPreferences preferences;
	SharedPreferences.Editor editor;
	private EditText usernum;
	private EditText pwd;
	private EditText re_pwd;
	private Button button_register;
	@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			requestWindowFeature(Window.FEATURE_NO_TITLE);
			setContentView(R.layout.register_layout);
			preferences = getSharedPreferences("myinfo", MODE_WORLD_READABLE);
			usernum = (EditText)findViewById(R.id.usernum);
			pwd = (EditText)findViewById(R.id.pwd);
			re_pwd = (EditText)findViewById(R.id.re_pwd);
			button_register = (Button)findViewById(R.id.btn_regiter);
			button_register.setOnClickListener(Register.this);
			
		}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String user_num = usernum.getText().toString();
					String password1 = pwd.getText().toString();
					String password2 = re_pwd.getText().toString();
					
					if(password1.equals(password2))
					{
						Toast.makeText(Register.this, "注册成功", 0).show();
						Config.CachedToken(this,"username",user_num);
						Config.CachedToken(this,"password",password1);
						Intent intent=new Intent(Register.this,LoginActivity.class);
						startActivity(intent);
						finish();
						
					}
					else
					{
						Toast.makeText(Register.this, "前后两次输入的密码不一致，请重新输入。。。", 0).show();; 
					}
	}
}
