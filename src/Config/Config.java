package Config;

import android.content.Context;
import android.content.SharedPreferences.Editor;

public class Config {
	public static String KEY_TOKEN="token";
	public static String APP_ID ="XuXuXu";
	public static String getCachedToken(Context context){
			return context.getSharedPreferences(APP_ID,context.MODE_PRIVATE).getString(KEY_TOKEN, null);
			//APP_ID代表XML文件名
	}
	public static void  CachedToken(Context context,String token){
		Editor e =context.getSharedPreferences(APP_ID, context.MODE_PRIVATE).edit();
		e.putString(KEY_TOKEN, token);
	}
}

