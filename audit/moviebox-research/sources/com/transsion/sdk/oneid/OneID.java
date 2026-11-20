package com.transsion.sdk.oneid;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.transsion.sdk.oneid.data.AppIdInfo;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class OneID {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static transient boolean f57389c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f57390d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile OneID f57391e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f57392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f57393b;

    /* JADX INFO: compiled from: source.java */
    public class a extends TypeToken<ConcurrentHashMap<Integer, AppIdInfo>> {
        public a(OneID oneID) {
        }
    }

    public OneID(Context context) {
        this.f57393b = context;
        this.f57392a = e.a(context.getApplicationContext());
        cu.a.b(context.getApplicationContext());
    }

    public static void c(Context context, int i11) {
        e eVar;
        if (context != null && f57391e == null) {
            synchronized (OneID.class) {
                try {
                    if (f57391e == null) {
                        f57391e = new OneID(context);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        OneID oneID = f57391e;
        if (oneID.f57393b == null || (eVar = oneID.f57392a) == null) {
            return;
        }
        eVar.b(i11);
    }

    public static void d(Context context, int i11, int i12) {
        if (f57390d == 0) {
            f57390d = i12;
        }
        c(context, i11);
    }

    public static OneID e() {
        if (f57391e != null) {
            return f57391e;
        }
        throw new IllegalStateException("You should call OneID.init first!");
    }

    public static boolean f() {
        return f57389c;
    }

    public String a(int i11) throws OneIDException {
        AppIdInfo appIdInfo;
        if (this.f57393b == null) {
            throw new OneIDException("OneID not init yet");
        }
        e eVar = this.f57392a;
        String str = "";
        String strI = eVar != null ? eVar.i(i11) : "";
        if (!TextUtils.isEmpty(strI)) {
            return strI;
        }
        try {
            String strH = k20.b.b(this.f57393b).h("appid_info_list");
            if (!TextUtils.isEmpty(strH) && (appIdInfo = (AppIdInfo) ((ConcurrentHashMap) new Gson().fromJson(strH, new a(this).getType())).get(Integer.valueOf(i11))) != null) {
                strI = appIdInfo.odid;
                str = appIdInfo.msg;
            }
        } catch (Exception e11) {
            f.f57417a.i(Log.getStackTraceString(e11));
        }
        if (!TextUtils.isEmpty(strI)) {
            return strI;
        }
        if (TextUtils.isEmpty(str)) {
            str = "Please try later";
        }
        throw new OneIDException(str);
    }

    @Deprecated
    public String b() {
        e eVar = this.f57392a;
        return eVar != null ? eVar.h() : "";
    }
}
