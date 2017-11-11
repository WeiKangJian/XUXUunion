package Config;

import android.content.Context;
import android.content.SharedPreferences.Editor;

public class config2 {
		public static String getcacheToken(Context context){
			return context.getSharedPreferences("ID",context.MODE_PRIVATE).getString("Token", null);
		}
		public static void setcacheToken(Context context,String token){
			Editor e = context.getSharedPreferences("ID",context.MODE_PRIVATE).edit();
			e.putString("Token", token);
		}
}
