package q8;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.pFF.sc.UFX;
import java.io.File;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f74453a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f74454b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f74455c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static UFX f74456d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f74457e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f74458f = false;

    public static boolean a() {
        return f74458f;
    }

    public static int b() {
        return f74457e;
    }

    public static UFX c() {
        if (f74456d == null) {
            UFX.sc scVar = new UFX.sc("v_config");
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            f74456d = scVar.sc(10000L, timeUnit).pFF(10000L, timeUnit).zY(10000L, timeUnit).sc();
        }
        return f74456d;
    }

    public static String d() {
        if (TextUtils.isEmpty(f74454b)) {
            try {
                File file = new File(e().getFilesDir(), "ttad_dir");
                if (!file.exists()) {
                    file.mkdirs();
                }
                f74454b = file.getAbsolutePath();
            } catch (Throwable unused) {
            }
        }
        return f74454b;
    }

    public static Context e() {
        return f74453a;
    }

    public static void f(int i11) {
        f74457e = i11;
    }

    public static void g(Context context, String str) {
        f74453a = context;
        f74454b = str;
    }

    public static void h(UFX ufx) {
        f74456d = ufx;
    }

    public static void i(boolean z11) {
        f74455c = z11;
    }

    public static boolean j() {
        return f74455c;
    }
}
