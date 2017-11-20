package Config;

import android.content.Context;
import android.content.SharedPreferences.Editor;

public class config2 {
		public static String getcacheToken(Context context,String a){
			return context.getSharedPreferences("ID",context.MODE_PRIVATE).getString(a, null);
		}
		public static void setcacheToken(Context context,String a,String token){
			Editor e = context.getSharedPreferences("ID",context.MODE_PRIVATE).edit();
			e.putString(a, token);
			e.commit();
		}
}
