package athena;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class k0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static k0 f13717c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f13718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f13719b;

    public k0(Context context) {
        this.f13719b = context.getApplicationContext();
    }

    public static synchronized k0 a(Context context) {
        try {
            if (f13717c == null) {
                f13717c = new k0(context);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f13717c;
    }

    public String b(String str) throws Exception {
        Context context = this.f13719b;
        if (context == null) {
            throw new Exception("context is null");
        }
        if (this.f13718a == null) {
            this.f13718a = d(context);
        }
        if (this.f13718a == null) {
            throw new Exception("sp is null");
        }
        if (!ww.c.b().a(this.f13719b)) {
            throw new Exception("keystore decrypt error");
        }
        String string = this.f13718a.getString(str, "");
        if (TextUtils.isEmpty(string) || string.contains("_")) {
            return "";
        }
        ww.b bVar = new ww.b(this.f13719b);
        String str2 = new String(bVar.d(bVar.a(string)));
        if (TextUtils.isEmpty(str2)) {
            throw new Exception("rsaCrypter decrypt error");
        }
        return str2;
    }

    public void c(String str, String str2) throws Exception {
        Context context = this.f13719b;
        if (context == null) {
            throw new Exception("context is null");
        }
        if (this.f13718a == null) {
            this.f13718a = d(context);
        }
        if (this.f13718a == null) {
            throw new Exception("sp is null");
        }
        try {
            if (!ww.c.b().a(this.f13719b)) {
                throw new Exception("keystore encrypt error");
            }
            ww.b bVar = new ww.b(this.f13719b);
            String strC = bVar.c(bVar.e(str2));
            if (TextUtils.isEmpty(strC)) {
                throw new Exception("rsaCrypter encrypt error");
            }
            SharedPreferences.Editor editorEdit = this.f13718a.edit();
            editorEdit.putString(str, strC);
            editorEdit.apply();
        } catch (Exception e11) {
            a0.c(Log.getStackTraceString(e11));
            throw e11;
        }
    }

    public final SharedPreferences d(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences(com.transsion.ga.g.f(context) + "_tcrypto", 0);
                this.f13718a = sharedPreferences;
                return sharedPreferences;
            } catch (Exception e11) {
                a0.c(Log.getStackTraceString(e11));
                return null;
            }
        }
        SharedPreferences sharedPreferences2 = this.f13718a;
        if (sharedPreferences2 != null) {
            return sharedPreferences2;
        }
        if (context == null) {
            return null;
        }
        try {
            this.f13718a = context.getSharedPreferences(com.transsion.ga.g.f(context) + "_tcrypto", 0);
        } catch (Exception e12) {
            a0.c(Log.getStackTraceString(e12));
        }
        return this.f13718a;
    }
}
