package ea;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.cloud.sdk.commonutil.util.f;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f64070a = "";

    public static String b() {
        String str = f64070a;
        if (str == null || str.length() == 0) {
            new Thread(new Runnable() { // from class: ea.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.e();
                }
            }).start();
        }
        return f64070a;
    }

    public static String c() {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) f.a().getSystemService("phone");
            return telephonyManager == null ? "" : telephonyManager.getSimOperator();
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean d() {
        Context contextA = f.a();
        return contextA.getResources() != null && (contextA.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public static /* synthetic */ void e() {
        try {
            f64070a = a.a(f.a()).a();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("advertisingId is ");
            sb2.append(f64070a);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }
}
