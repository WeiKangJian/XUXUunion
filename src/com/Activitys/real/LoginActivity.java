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
		// �����ı������ݱ仯
		username.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// ����ı����е��û�
				user = username.getText().toString().trim();
				if ("".equals(user)) {
					// �û���Ϊ��,���ð�ť���ɼ�
					bt_username_clear.setVisibility(View.INVISIBLE);
				} else {
					// �û�����Ϊ�գ����ð�ť�ɼ�
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
		// �����ı������ݱ仯
		password.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// ����ı����е��û�
				pwd = password.getText().toString().trim();
				if ("".equals(pwd)) {
					// ����Ϊ��,���ð�ť���ɼ�
					bt_pwd_clear.setVisibility(View.INVISIBLE);
				} else {
					// ���벻Ϊ�գ����ð�ť�ɼ�
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
			// �����¼��
			username.setText("");
			break;
		case R.id.bt_pwd_clear:
			// �������
			password.setText("");
			break;
		case R.id.bt_pwd_eye:
			// ����ɼ��벻�ɼ����л�
			if (isOpen) {
				isOpen = false;
			} else {
				isOpen = true;
			}

			// Ĭ��isOpen��false,���벻�ɼ�
			changePwdOpenOrClose(isOpen);
			break;
		case R.id.login:
			// TODO ��¼��ť
			login();
			break;
		case R.id.register:
				// ע�ᰴť
			Intent intent=new Intent(LoginActivity.this,Register.class);
			startActivity(intent);
			finish();
			break;
		case R.id.forgive_pwd:
			// �������밴ť
			Toast.makeText(LoginActivity.this, "�������ܹ�˭������·", 0).show();
			break;
		default:
			break;
		}
	}
	private void login() {
		String userdbname=Config.getCachedToken(this, "username");
		String userdbpassword=Config.getCachedToken(this, "password");
		if (userdbname.equals(user)&&userdbpassword.equals(pwd)) {
			Toast.makeText(LoginActivity.this, "��½�ɹ���",0).show();
			Intent intent=new Intent(LoginActivity.this,ListActivity.class);
			startActivity(intent);
			finish();
		}else {
			Toast.makeText(LoginActivity.this, "��½ʧ�ܣ������µ�½",0).show();
		}
	}
	// ����ɼ��벻�ɼ����л�
	private void changePwdOpenOrClose(boolean flag) {
		// ��һ�ι�����false�����벻�ɼ�
		if (flag) {
			// ����ɼ�
			bt_pwd_eye.setBackgroundResource(R.drawable.password_open);
			// ����EditText������ɼ�
			password.setTransformationMethod(HideReturnsTransformationMethod
					.getInstance());
		} else {
			// ���벻�ɼ�
			bt_pwd_eye.setBackgroundResource(R.drawable.password_close);
			// ����EditText����������
			password.setTransformationMethod(PasswordTransformationMethod
					.getInstance());
		}
	}

}