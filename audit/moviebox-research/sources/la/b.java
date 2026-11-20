package la;

import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class b {
    public static void a(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str2) || Log.isLoggable("miniapp", 3)) {
                return;
            }
            Log.isLoggable("Launcher", 3);
        } catch (Throwable th2) {
            Log.e("MiniAppProtocolModule::", "d: ", th2);
        }
    }

    public static void b(String str, String str2) {
        try {
            Log.e(str, str2, null);
        } catch (Throwable th2) {
            Log.e("MiniAppProtocolModule::", "e: ", th2);
        }
    }

    public static void c(String str, String str2, Throwable th2) {
        try {
            Log.e(str, str2, th2);
        } catch (Throwable th3) {
            Log.e("MiniAppProtocolModule::", "e: ", th3);
        }
    }
}
