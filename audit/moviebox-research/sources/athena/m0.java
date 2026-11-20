package athena;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class m0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static m0 f13721c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f13722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f13723b;

    public m0(Context context) {
        this.f13723b = context.getApplicationContext();
    }

    public static synchronized m0 a(Context context) {
        try {
            if (f13721c == null) {
                f13721c = new m0(context);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f13721c;
    }

    public void b(String str, int i11) {
        Context context = this.f13723b;
        if (context == null) {
            return;
        }
        if (this.f13722a == null) {
            this.f13722a = f(context);
        }
        SharedPreferences sharedPreferences = this.f13722a;
        if (sharedPreferences == null) {
            return;
        }
        try {
            sharedPreferences.edit().putInt(str, i11).apply();
        } catch (Exception e11) {
            a0.c(Log.getStackTraceString(e11));
        }
    }

    public void c(String str, String str2) throws Exception {
        Context context = this.f13723b;
        if (context == null) {
            throw new Exception("context is null");
        }
        if (this.f13722a == null) {
            this.f13722a = f(context);
        }
        if (this.f13722a == null) {
            throw new Exception("sp is null");
        }
        if (!ww.c.b().a(this.f13723b)) {
            throw new Exception("keystore encrypt error");
        }
        ww.b bVar = new ww.b(this.f13723b);
        String strC = bVar.c(bVar.e(str2));
        if (TextUtils.isEmpty(strC)) {
            throw new Exception("rsaCrypter encrypt error");
        }
        SharedPreferences.Editor editorEdit = this.f13722a.edit();
        editorEdit.putString(str, strC);
        editorEdit.apply();
    }

    public boolean d(String str) {
        if (this.f13722a == null) {
            this.f13722a = f(this.f13723b);
        }
        SharedPreferences sharedPreferences = this.f13722a;
        return sharedPreferences != null && sharedPreferences.contains(str);
    }

    public int e(String str) {
        Context context = this.f13723b;
        if (context == null) {
            return -1;
        }
        if (this.f13722a == null) {
            this.f13722a = f(context);
        }
        SharedPreferences sharedPreferences = this.f13722a;
        if (sharedPreferences == null) {
            return -1;
        }
        try {
            return sharedPreferences.getInt(str, 0);
        } catch (Exception e11) {
            a0.c(e11.getMessage());
            return -1;
        }
    }

    public final SharedPreferences f(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences("tcrypto", 0);
                this.f13722a = sharedPreferences;
                return sharedPreferences;
            } catch (Exception e11) {
                a0.c(e11.getMessage());
                return null;
            }
        }
        SharedPreferences sharedPreferences2 = this.f13722a;
        if (sharedPreferences2 != null) {
            return sharedPreferences2;
        }
        if (context == null) {
            return null;
        }
        try {
            this.f13722a = context.getSharedPreferences("tcrypto", 0);
        } catch (Exception e12) {
            a0.c(e12.getMessage());
        }
        return this.f13722a;
    }

    public void g(String str, String str2) {
        Context context = this.f13723b;
        if (context == null) {
            return;
        }
        if (this.f13722a == null) {
            this.f13722a = f(context);
        }
        SharedPreferences sharedPreferences = this.f13722a;
        if (sharedPreferences == null) {
            return;
        }
        try {
            sharedPreferences.edit().putString(str, str2).apply();
        } catch (Exception e11) {
            a0.c(Log.getStackTraceString(e11));
        }
    }

    public String h(String str) throws Exception {
        Context context = this.f13723b;
        if (context == null) {
            throw new Exception("context is null");
        }
        if (this.f13722a == null) {
            this.f13722a = f(context);
        }
        if (this.f13722a == null) {
            throw new Exception("sp is null");
        }
        if (!ww.c.b().a(this.f13723b)) {
            throw new Exception("keystore decrypt error");
        }
        String string = this.f13722a.getString(str, "");
        if (TextUtils.isEmpty(string) || string.contains("_")) {
            return "";
        }
        ww.b bVar = new ww.b(this.f13723b);
        String str2 = new String(bVar.d(bVar.a(string)));
        if (TextUtils.isEmpty(str2)) {
            throw new Exception("rsaCrypter decrypt error");
        }
        return str2;
    }

    public String i(String str) {
        Context context = this.f13723b;
        if (context == null) {
            return "";
        }
        if (this.f13722a == null) {
            this.f13722a = f(context);
        }
        SharedPreferences sharedPreferences = this.f13722a;
        if (sharedPreferences == null) {
            return "";
        }
        try {
            return sharedPreferences.getString(str, "");
        } catch (Exception e11) {
            a0.c(Log.getStackTraceString(e11));
            return "";
        }
    }
}
