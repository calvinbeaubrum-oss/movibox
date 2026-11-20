package zs;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.UserManager;
import android.text.TextUtils;
import ys.b;
import ys.d;
import ys.m;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f82151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Context f82152c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f82153a;

    public a(Context context) {
        f82152c = context.getApplicationContext();
        c(context);
    }

    public static synchronized a a(Context context) {
        try {
            if (f82151b == null) {
                f82151b = new a(context);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f82151b;
    }

    public String b(String str) {
        if (f82152c == null || !m.b().a(f82152c)) {
            return "";
        }
        if (this.f82153a == null) {
            this.f82153a = c(f82152c);
        }
        if (this.f82153a == null) {
            return "";
        }
        try {
            d dVar = new d(f82152c);
            String string = this.f82153a.getString(str, "");
            if (TextUtils.isEmpty(string)) {
                return "";
            }
            String[] strArrSplit = string.split("_");
            int length = strArrSplit.length;
            byte[] bArrD = dVar.d(dVar.a(strArrSplit[1]));
            int length2 = bArrD.length;
            byte[] bArr = new byte[32];
            byte[] bArr2 = new byte[16];
            System.arraycopy(bArrD, 0, bArr, 0, 32);
            System.arraycopy(bArrD, 32, bArr2, 0, 16);
            ys.a aVar = new ys.a(bArr, bArr2);
            return new String(aVar.d(aVar.a(strArrSplit[0])));
        } catch (Exception unused) {
            return "";
        }
    }

    public final SharedPreferences c(Context context) {
        if (Build.VERSION.SDK_INT < 24) {
            SharedPreferences sharedPreferences = this.f82153a;
            if (sharedPreferences != null) {
                return sharedPreferences;
            }
            if (context == null) {
                return null;
            }
            try {
                this.f82153a = context.getSharedPreferences("tcrypto", 0);
            } catch (Exception unused) {
            }
            return this.f82153a;
        }
        try {
            if (((UserManager) context.getSystemService("user")).isUserUnlocked()) {
                SharedPreferences sharedPreferences2 = context.getSharedPreferences("tcrypto", 0);
                this.f82153a = sharedPreferences2;
                return sharedPreferences2;
            }
            SharedPreferences sharedPreferences3 = context.createDeviceProtectedStorageContext().getSharedPreferences("tcrypto", 0);
            this.f82153a = sharedPreferences3;
            return sharedPreferences3;
        } catch (Exception unused2) {
            return null;
        }
    }

    public void d(String str, String str2) throws Exception {
        if (f82152c == null) {
            throw new Exception("context is null");
        }
        if (!m.b().a(f82152c)) {
            throw new Exception("key not created");
        }
        if (this.f82153a == null) {
            this.f82153a = c(f82152c);
        }
        if (this.f82153a == null) {
            throw new Exception("sp is null");
        }
        try {
            b bVar = new b();
            d dVar = new d(f82152c);
            String strC = bVar.c(bVar.e(str2));
            String strC2 = dVar.c(dVar.e(bVar.i()));
            this.f82153a.edit().putString(str, strC + "_" + strC2).apply();
        } catch (Exception unused) {
        }
    }
}
