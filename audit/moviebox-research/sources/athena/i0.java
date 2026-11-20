package athena;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.transsion.push.PushConstants;
import com.transsion.sdk.oneid.OneID;
import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f13690a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f13691b = false;

    public static String a() {
        if (!TextUtils.isEmpty(f13690a)) {
            return f13690a;
        }
        if (OneID.f()) {
            a0.a("OneID isEnable = true");
            f13690a = f13691b ? OneID.e().b() : "";
        }
        return f13690a;
    }

    public static void b(Context context) {
        if (TextUtils.isEmpty(f13690a)) {
            if (Build.VERSION.SDK_INT >= 26) {
                try {
                    String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
                    if (!TextUtils.isEmpty(string)) {
                        f13690a = UUID.nameUUIDFromBytes((context.getPackageName() + string).getBytes()).toString();
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
            if (TextUtils.isEmpty(f13690a)) {
                f13690a = UUID.randomUUID().toString();
            }
            try {
                k0.a(context).c(PushConstants.PROVIDER_VAID, f13690a);
            } catch (Exception e12) {
                a0.c(Log.getStackTraceString(e12));
            }
        }
    }

    public static void c(Context context, int i11, int i12) {
        try {
            OneID.d(context, i11, i12);
            f13691b = true;
        } catch (Exception e11) {
            a0.c(Log.getStackTraceString(e11));
        }
    }

    public static String d(Context context) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            if (!TextUtils.isEmpty(f13690a)) {
                return f13690a;
            }
            if (OneID.f()) {
                a0.a("OneID isEnable = true");
                f13690a = f13691b ? OneID.e().b() : "";
            }
            if (TextUtils.isEmpty(f13690a)) {
                f13690a = k0.a(context).b(PushConstants.PROVIDER_VAID);
                b(context);
            }
            a0.a("*******************/ vaid cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " /*******************");
            return f13690a;
        } catch (Exception e11) {
            a0.c(Log.getStackTraceString(e11));
            b(context);
        }
    }
}
