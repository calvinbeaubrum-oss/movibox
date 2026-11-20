package j8;

import android.content.Context;
import android.os.Build;
import com.bykv.vk.openvk.sc.sc.pFF.pFF.TRI.sc;
import org.json.JSONObject;
import v8.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static w8.a f67938a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f67939b = 10;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f67940c = 10;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f67941d = 10;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f67942e = 10;

    public static int a() {
        return f67942e;
    }

    public static int b() {
        return f67941d;
    }

    public static int c() {
        return f67939b;
    }

    public static void d() {
        w8.a aVar = f67938a;
        if (aVar != null) {
            aVar.We();
        }
    }

    public static void e(Context context) {
        b.a(context);
        if (Build.VERSION.SDK_INT < 23) {
            sc.c();
        }
    }

    public static void f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            f67939b = jSONObject.optInt("splash", 10);
            f67940c = jSONObject.optInt("reward", 10);
            f67941d = jSONObject.optInt("brand", 10);
            int iOptInt = jSONObject.optInt("other", 10);
            f67942e = iOptInt;
            if (f67939b < 0) {
                f67939b = 10;
            }
            if (f67940c < 0) {
                f67940c = 10;
            }
            if (f67941d < 0) {
                f67941d = 10;
            }
            if (iOptInt < 0) {
                f67942e = 10;
            }
        } catch (Throwable th2) {
            th2.getMessage();
        }
    }

    public static void g(w8.a aVar) {
        f67938a = aVar;
    }

    public static int h() {
        return f67940c;
    }
}
