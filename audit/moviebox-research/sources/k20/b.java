package k20;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static b f68210c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f68211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f68212b;

    public b(Context context) {
        this.f68212b = context.getApplicationContext();
    }

    public static synchronized b b(Context context) {
        try {
            if (f68210c == null) {
                f68210c = new b(context);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f68210c;
    }

    public int a(String str) {
        Context context = this.f68212b;
        if (context == null) {
            return -1;
        }
        if (this.f68211a == null) {
            this.f68211a = e(context);
        }
        SharedPreferences sharedPreferences = this.f68211a;
        if (sharedPreferences == null) {
            return -1;
        }
        try {
            return sharedPreferences.getInt(str, 0);
        } catch (Exception unused) {
            return -1;
        }
    }

    public void c(String str, int i11) {
        Context context = this.f68212b;
        if (context == null) {
            return;
        }
        if (this.f68211a == null) {
            this.f68211a = e(context);
        }
        SharedPreferences sharedPreferences = this.f68211a;
        if (sharedPreferences == null) {
            return;
        }
        try {
            sharedPreferences.edit().putInt(str, i11).apply();
        } catch (Exception e11) {
            com.transsion.sdk.oneid.f.f57417a.i(Log.getStackTraceString(e11));
        }
    }

    public void d(String str, String str2) throws Exception {
        Context context = this.f68212b;
        if (context == null) {
            throw new Exception("context is null");
        }
        if (this.f68211a == null) {
            this.f68211a = e(context);
        }
        if (this.f68211a == null) {
            throw new Exception("sp is null");
        }
        try {
            if (!ww.c.b().a(this.f68212b)) {
                throw new Exception("keystore encrypt error");
            }
            ww.b bVar = new ww.b(this.f68212b);
            String strC = bVar.c(bVar.e(str2));
            if (TextUtils.isEmpty(strC)) {
                throw new Exception("rsaCrypter encrypt error");
            }
            SharedPreferences.Editor editorEdit = this.f68211a.edit();
            editorEdit.putString(str, strC);
            editorEdit.apply();
        } catch (Exception e11) {
            com.transsion.sdk.oneid.f.f57417a.i(Log.getStackTraceString(e11));
            throw e11;
        }
    }

    public final SharedPreferences e(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences(com.transsion.sdk.oneid.f.j(context) + "_tcrypto", 0);
                this.f68211a = sharedPreferences;
                return sharedPreferences;
            } catch (Exception unused) {
                return null;
            }
        }
        SharedPreferences sharedPreferences2 = this.f68211a;
        if (sharedPreferences2 != null) {
            return sharedPreferences2;
        }
        if (context == null) {
            return null;
        }
        try {
            this.f68211a = context.getSharedPreferences(com.transsion.sdk.oneid.f.j(context) + "_tcrypto", 0);
        } catch (Exception unused2) {
        }
        return this.f68211a;
    }

    public String f(String str) throws Exception {
        Context context = this.f68212b;
        if (context == null) {
            throw new Exception("context is null");
        }
        if (this.f68211a == null) {
            this.f68211a = e(context);
        }
        if (this.f68211a == null) {
            throw new Exception("sp is null");
        }
        try {
            if (!ww.c.b().a(this.f68212b)) {
                throw new Exception("keystore decrypt error");
            }
            String string = this.f68211a.getString(str, "");
            if (!TextUtils.isEmpty(string) && !string.contains("_")) {
                ww.b bVar = new ww.b(this.f68212b);
                String str2 = new String(bVar.d(bVar.a(string)));
                if (TextUtils.isEmpty(str2)) {
                    throw new Exception("rsaCrypter decrypt error");
                }
                return str2;
            }
            return "";
        } catch (Exception e11) {
            com.transsion.sdk.oneid.f.f57417a.i(Log.getStackTraceString(e11));
            throw e11;
        }
    }

    public void g(String str, String str2) {
        Context context = this.f68212b;
        if (context == null) {
            return;
        }
        if (this.f68211a == null) {
            this.f68211a = e(context);
        }
        SharedPreferences sharedPreferences = this.f68211a;
        if (sharedPreferences == null) {
            return;
        }
        try {
            sharedPreferences.edit().putString(str, str2).apply();
        } catch (Exception e11) {
            com.transsion.sdk.oneid.f.f57417a.i(Log.getStackTraceString(e11));
        }
    }

    public String h(String str) {
        Context context = this.f68212b;
        if (context == null) {
            return "";
        }
        if (this.f68211a == null) {
            this.f68211a = e(context);
        }
        SharedPreferences sharedPreferences = this.f68211a;
        if (sharedPreferences == null) {
            return "";
        }
        try {
            return sharedPreferences.getString(str, "");
        } catch (Exception e11) {
            com.transsion.sdk.oneid.f.f57417a.i(Log.getStackTraceString(e11));
            return "";
        }
    }
}
