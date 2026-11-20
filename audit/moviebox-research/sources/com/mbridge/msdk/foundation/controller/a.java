package com.mbridge.msdk.foundation.controller;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.i;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.al;
import com.mbridge.msdk.foundation.tools.g;
import com.mbridge.msdk.foundation.tools.z;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f44040a = c.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static HashMap<String, String> f44041b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected String f44042c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected Context f44043d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected String f44044e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private WeakReference<Activity> f44046g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f44047h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f44048i;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f44051l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f44052m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f44053n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private WeakReference<Context> f44055p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private JSONObject f44056q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f44058s;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final g f44045f = new g();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private JSONObject f44049j = new JSONObject();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f44050k = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ConcurrentHashMap<String, String> f44054o = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f44057r = 0;

    /* JADX INFO: renamed from: com.mbridge.msdk.foundation.controller.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public interface InterfaceC0484a {
    }

    public final BitmapDrawable a(String str, int i11) {
        ConcurrentHashMap<String, String> concurrentHashMap;
        String str2;
        if (TextUtils.isEmpty(str) || (concurrentHashMap = this.f44054o) == null || !concurrentHashMap.containsKey(str) || !af.a().a("w_m_r_l", true)) {
            return null;
        }
        String str3 = this.f44054o.get(str);
        BitmapDrawable bitmapDrawableN = ai.n(str3);
        int i12 = TextUtils.isEmpty(str3) ? 2 : 1;
        if (TextUtils.isEmpty(str3)) {
            str2 = "get watermark failed";
        } else {
            str2 = bitmapDrawableN != null ? "" : "str to bitmap failed";
        }
        q.a(str, i11, i12, str2, bitmapDrawableN == null ? 2 : 1, str3);
        return bitmapDrawableN;
    }

    public final WeakReference<Activity> a() {
        return this.f44046g;
    }

    public final void a(int i11) {
        this.f44048i = i11;
    }

    public final void a(Context context) {
        if (context instanceof Activity) {
            this.f44055p = new WeakReference<>(context);
        }
    }

    public abstract void a(InterfaceC0484a interfaceC0484a);

    public final void a(final InterfaceC0484a interfaceC0484a, final Handler handler) {
        if (this.f44050k) {
            return;
        }
        try {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.b.a() && com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                Object objA = al.a(this.f44043d, MBridgeConstans.SP_GA_ID, "");
                Object objA2 = al.a(this.f44043d, MBridgeConstans.SP_GA_ID_LIMIT, 0);
                if (objA instanceof String) {
                    String str = (String) objA;
                    if (TextUtils.isEmpty(str)) {
                        com.mbridge.msdk.foundation.tools.e.c();
                    } else {
                        com.mbridge.msdk.foundation.tools.e.a(str);
                    }
                    if (objA2 instanceof Integer) {
                        com.mbridge.msdk.foundation.tools.e.a(((Integer) objA2).intValue());
                    }
                }
            }
        } catch (Exception e11) {
            ad.b(f44040a, e11.getMessage());
        }
        try {
            JSONObject jSONObject = new JSONObject();
            this.f44056q = jSONObject;
            jSONObject.put("webgl", 0);
        } catch (JSONException e12) {
            ad.b(f44040a, e12.getMessage());
        }
        new Thread(new Runnable() { // from class: com.mbridge.msdk.foundation.controller.a.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    z.o(a.this.f44043d);
                    a.this.a(interfaceC0484a);
                    a aVar = a.this;
                    h.a(aVar.f44043d, aVar.f44042c);
                } catch (Exception e13) {
                    ad.b(a.f44040a, e13.getMessage());
                }
                if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                    try {
                        z.c(a.this.f44043d.getPackageManager().getApplicationInfo("com.android.vending", 0).enabled ? 1 : 2);
                    } catch (PackageManager.NameNotFoundException unused) {
                        z.c(0);
                    } catch (Throwable th2) {
                        ad.b(a.f44040a, th2.getMessage());
                    }
                }
                try {
                    com.mbridge.msdk.c.g gVarB = h.a().b(c.m().k());
                    if (gVarB == null) {
                        h.a();
                        gVarB = i.a();
                    }
                    Message messageObtain = Message.obtain();
                    messageObtain.obj = gVarB;
                    messageObtain.what = 9;
                    handler.sendMessage(messageObtain);
                } catch (Exception e14) {
                    ad.b(a.f44040a, e14.getMessage());
                }
            }
        }).start();
    }

    public final void a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f44052m = str;
            Context context = this.f44043d;
            if (context != null) {
                al.b(context, "sp_wx_appKey", str);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void a(String str, JSONObject jSONObject) {
        if (af.a().a("w_m_r_l", true)) {
            try {
                if (this.f44049j == null) {
                    this.f44049j = jSONObject;
                } else if (jSONObject != null) {
                    Iterator<String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        this.f44049j.put(next, jSONObject.get(next));
                    }
                }
                if (this.f44049j.has(MBridgeConstans.EXTRA_KEY_WM)) {
                    if (this.f44054o == null) {
                        this.f44054o = new ConcurrentHashMap<>();
                    }
                    this.f44054o.put(str, this.f44049j.getString(MBridgeConstans.EXTRA_KEY_WM));
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public final void a(WeakReference<Activity> weakReference) {
        this.f44046g = weakReference;
    }

    public final void a(JSONObject jSONObject) {
        this.f44056q = jSONObject;
    }

    public final String b() {
        if (!TextUtils.isEmpty(this.f44051l)) {
            return this.f44051l;
        }
        Context context = this.f44043d;
        if (context != null) {
            return (String) al.a(context, "sp_appKey", "");
        }
        return null;
    }

    public final void b(int i11) {
        this.f44053n = i11;
    }

    public final void b(Context context) {
        this.f44043d = context;
    }

    public final void b(String str) {
        try {
            if (this.f44054o != null && !TextUtils.isEmpty(str) && this.f44054o.containsKey(str)) {
                this.f44054o.remove(str);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final Context c() {
        return this.f44043d;
    }

    public final void c(int i11) {
        this.f44057r = i11;
    }

    public final void c(String str) {
        Context context;
        try {
            this.f44047h = str;
            if (TextUtils.isEmpty(str) || (context = this.f44043d) == null) {
                return;
            }
            al.b(context, "applicationIds", str);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final g d() {
        return this.f44045f;
    }

    public final void d(String str) {
        Context context;
        try {
            this.f44042c = str;
            if (TextUtils.isEmpty(str) || (context = this.f44043d) == null) {
                return;
            }
            al.b(context, "sp_appId", str);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final Context e() {
        WeakReference<Context> weakReference = this.f44055p;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public final void e(String str) {
        Context context;
        try {
            this.f44051l = str;
            if (TextUtils.isEmpty(str) || (context = this.f44043d) == null) {
                return;
            }
            al.b(context, "sp_appKey", str);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final int f() {
        return this.f44048i;
    }

    public final void f(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f44044e = str;
    }

    public final String g() {
        try {
            if (!TextUtils.isEmpty(this.f44044e)) {
                return this.f44044e;
            }
            Context context = this.f44043d;
            if (context == null) {
                return null;
            }
            String packageName = context.getPackageName();
            this.f44044e = packageName;
            return packageName;
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public final String h() {
        if (!TextUtils.isEmpty(this.f44052m)) {
            return this.f44052m;
        }
        Context context = this.f44043d;
        if (context != null) {
            return (String) al.a(context, "sp_wx_appKey", "");
        }
        return null;
    }

    public final JSONObject i() {
        return this.f44056q;
    }

    public final int j() {
        return this.f44057r;
    }

    public final String k() {
        try {
            if (!TextUtils.isEmpty(this.f44042c)) {
                return this.f44042c;
            }
            Context context = this.f44043d;
            if (context != null) {
                return (String) al.a(context, "sp_appId", "");
            }
            return "";
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final String l() {
        if (!TextUtils.isEmpty(this.f44058s)) {
            return this.f44058s;
        }
        try {
            String md5 = SameMD5.getMD5(c.m().k() + c.m().b());
            this.f44058s = md5;
            return md5;
        } catch (Exception unused) {
            return "";
        }
    }
}
