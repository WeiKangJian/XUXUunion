package com.Activitys.real;


import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.real.R;

import android.R.string;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.Contacts.People;
import Config.Config;
public class LoginActivity extends Activity implements OnClickListener {
	private EditText username, password;
	private Button bt_username_clear;
	private Button bt_pwd_clear;
	private Button forgive_pwd;
	private Button bt_pwd_eye;
	private Button login;
	private Button register;
	private boolean isOpen = false;
	String user;
	String pwd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		initView();

	}

	private void initView() {

		username = (EditText) findViewById(R.id.username);
		// 监听文本框内容变化
		username.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// 获得文本框中的用户
				user = username.getText().toString().trim();
				if ("".equals(user)) {
					// 用户名为空,设置按钮不可见
					bt_username_clear.setVisibility(View.INVISIBLE);
				} else {
					// 用户名不为空，设置按钮可见
					bt_username_clear.setVisibility(View.VISIBLE);
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {

			}

			@Override
			public void afterTextChanged(Editable s) {
				
			}
		});
		password = (EditText) findViewById(R.id.password);
		// 监听文本框内容变化
		password.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// 获得文本框中的用户
				pwd = password.getText().toString().trim();
				if ("".equals(pwd)) {
					// 密码为空,设置按钮不可见
					bt_pwd_clear.setVisibility(View.INVISIBLE);
				} else {
					// 密码不为空，设置按钮可见
					bt_pwd_clear.setVisibility(View.VISIBLE);
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {

			}

			@Override
			public void afterTextChanged(Editable s) {

			}
		});

		bt_username_clear = (Button) findViewById(R.id.bt_username_clear);
		bt_username_clear.setOnClickListener(this);

		bt_pwd_clear = (Button) findViewById(R.id.bt_pwd_clear);
		bt_pwd_clear.setOnClickListener(this);

		bt_pwd_eye = (Button) findViewById(R.id.bt_pwd_eye);
		bt_pwd_eye.setOnClickListener(this);

		login = (Button) findViewById(R.id.login);
		login.setOnClickListener(this);

		register = (Button) findViewById(R.id.register);
		register.setOnClickListener(this);

		forgive_pwd = (Button) findViewById(R.id.forgive_pwd);
		forgive_pwd.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bt_username_clear:
			// 清除登录名
			username.setText("");
			break;
		case R.id.bt_pwd_clear:
			// 清除密码
			password.setText("");
			break;
		case R.id.bt_pwd_eye:
			// 密码可见与不可见的切换
			if (isOpen) {
				isOpen = false;
			} else {
				isOpen = true;
			}

			// 默认isOpen是false,密码不可见
			changePwdOpenOrClose(isOpen);
			break;
		case R.id.login:
			// TODO 登录按钮
			login();
			break;
		case R.id.register:
				// 注册按钮
			Intent intent=new Intent(LoginActivity.this,Register.class);
			startActivity(intent);
			finish();
			break;
		case R.id.forgive_pwd:
			// 忘记密码按钮
			Toast.makeText(LoginActivity.this, "你忘了能怪谁呢略略路", 0).show();
			break;
		default:
			break;
		}
	}
	private void login() {
		String userdbname=Config.getCachedToken(this, "username");
		String userdbpassword=Config.getCachedToken(this, "password");
		if (userdbname.equals(user)&&userdbpassword.equals(pwd)) {
			Toast.makeText(LoginActivity.this, "登陆成功！",0).show();
			Intent intent=new Intent(LoginActivity.this,ListActivity.class);
			startActivity(intent);
			finish();
		}else {
			Toast.makeText(LoginActivity.this, "登陆失败，请重新登陆",0).show();
		}
	}
	// 密码可见与不可见的切换
	private void changePwdOpenOrClose(boolean flag) {
		// 第一次过来是false，密码不可见
		if (flag) {
			// 密码可见
			bt_pwd_eye.setBackgroundResource(R.drawable.password_open);
			// 设置EditText的密码可见
			password.setTransformationMethod(HideReturnsTransformationMethod
					.getInstance());
		} else {
			// 密码不可见
			bt_pwd_eye.setBackgroundResource(R.drawable.password_close);
			// 设置EditText的密码隐藏
			password.setTransformationMethod(PasswordTransformationMethod
					.getInstance());
		}
	}

}