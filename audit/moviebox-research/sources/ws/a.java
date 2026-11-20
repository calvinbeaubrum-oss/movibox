package ws;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import com.transsion.core.deviceinfo.DeviceInfo;
import com.transsion.core.utils.f;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    public static Context f79586a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f79587b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f79588c = false;

    public static Context a() {
        Context context = f79586a;
        if (context != null) {
            return context;
        }
        throw new NullPointerException("u should init first");
    }

    public static void b(@NonNull Context context) {
        if (f79586a != null) {
            return;
        }
        f79586a = context.getApplicationContext();
        DeviceInfo.d();
        f.a(a());
    }

    public static boolean c() {
        return f79587b;
    }

    public static boolean d() {
        return f79588c;
    }

    public static void e(boolean z11) {
        f79587b = z11;
    }
}
