package d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.transsion.core.deviceinfo.DeviceInfo;
import com.transsion.push.utils.PushLogUtils;
import java.util.TimeZone;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class f {
    public static String a() {
        try {
            return c(true, true, TimeZone.getDefault().getRawOffset());
        } catch (Throwable th2) {
            PushLogUtils.LOG.i(Log.getStackTraceString(th2));
            return "";
        }
    }

    public static String b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e11) {
            e11.printStackTrace();
            return "";
        }
    }

    public static String c(boolean z11, boolean z12, int i11) {
        char c11;
        int i12 = i11 / 60000;
        if (i12 < 0) {
            i12 = -i12;
            c11 = '-';
        } else {
            c11 = '+';
        }
        StringBuilder sb2 = new StringBuilder(9);
        if (z11) {
            sb2.append("GMT");
        }
        sb2.append(c11);
        d(sb2, 2, i12 / 60);
        if (z12) {
            sb2.append(':');
        }
        d(sb2, 2, i12 % 60);
        return sb2.toString();
    }

    public static void d(StringBuilder sb2, int i11, int i12) {
        String string = Integer.toString(i12);
        for (int i13 = 0; i13 < i11 - string.length(); i13++) {
            sb2.append('0');
        }
        sb2.append(string);
    }

    public static int e() {
        String strF = DeviceInfo.f();
        if (TextUtils.isEmpty(strF) || strF.length() < 3) {
            return 0;
        }
        try {
            return Integer.parseInt(strF.substring(0, 3));
        } catch (Exception e11) {
            e11.printStackTrace();
            return 0;
        }
    }

    public static boolean f(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public static int g() {
        String strF = DeviceInfo.f();
        if (!TextUtils.isEmpty(strF) && strF.length() >= 4) {
            try {
                return Integer.parseInt(strF.substring(3));
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        return 0;
    }

    public static String h() {
        try {
            return ws.a.a().getPackageName();
        } catch (Exception unused) {
            return "";
        }
    }
}
