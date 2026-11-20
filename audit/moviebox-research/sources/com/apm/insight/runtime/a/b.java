package com.apm.insight.runtime.a;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f17013a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f17014b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f17015c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f17016d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f17017e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static long f17018f = -1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static volatile b f17019z;
    private int B;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Application f17020g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Context f17021h;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f17027n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f17028o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f17029p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f17030q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f17031r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f17032s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private String f17033t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f17034u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private String f17035v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private long f17036w;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<String> f17022i = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private List<Long> f17023j = new ArrayList();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private List<String> f17024k = new ArrayList();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private List<Long> f17025l = new ArrayList();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private LinkedList<a> f17026m = new LinkedList<>();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f17037x = false;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private long f17038y = -1;
    private int A = 50;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f17040a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f17041b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f17042c;

        public a(String str, String str2, long j11) {
            this.f17041b = str2;
            this.f17042c = j11;
            this.f17040a = str;
        }

        public final String toString() {
            return com.apm.insight.l.b.a().format(new Date(this.f17042c)) + " : " + this.f17040a + ' ' + this.f17041b;
        }
    }

    private b(@NonNull Application application) {
        this.f17021h = application;
        this.f17020g = application;
        if (application != null) {
            try {
                this.f17020g.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.apm.insight.runtime.a.b.1
                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public final void onActivityCreated(Activity activity, Bundle bundle) {
                        b.this.f17027n = activity.getClass().getName();
                        b.this.f17028o = System.currentTimeMillis();
                        boolean unused = b.f17014b = bundle != null;
                        boolean unused2 = b.f17015c = true;
                        b.this.f17022i.add(b.this.f17027n);
                        b.this.f17023j.add(Long.valueOf(b.this.f17028o));
                        b bVar = b.this;
                        b.a(bVar, bVar.f17027n, b.this.f17028o, "onCreate");
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public final void onActivityDestroyed(Activity activity) {
                        String name = activity.getClass().getName();
                        int iIndexOf = b.this.f17022i.indexOf(name);
                        if (iIndexOf >= 0 && iIndexOf < b.this.f17022i.size()) {
                            b.this.f17022i.remove(iIndexOf);
                            b.this.f17023j.remove(iIndexOf);
                        }
                        b.this.f17024k.add(name);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        b.this.f17025l.add(Long.valueOf(jCurrentTimeMillis));
                        b.a(b.this, name, jCurrentTimeMillis, "onDestroy");
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public final void onActivityPaused(Activity activity) {
                        b.this.f17033t = activity.getClass().getName();
                        b.this.f17034u = System.currentTimeMillis();
                        b.l(b.this);
                        if (b.this.B == 0) {
                            b.this.f17037x = false;
                            boolean unused = b.f17015c = false;
                            b.this.f17038y = SystemClock.uptimeMillis();
                        } else if (b.this.B < 0) {
                            b.n(b.this);
                            b.this.f17037x = false;
                            boolean unused2 = b.f17015c = false;
                            b.this.f17038y = SystemClock.uptimeMillis();
                        }
                        b bVar = b.this;
                        b.a(bVar, bVar.f17033t, b.this.f17034u, "onPause");
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public final void onActivityResumed(Activity activity) {
                        b.this.f17031r = activity.getClass().getName();
                        b.this.f17032s = System.currentTimeMillis();
                        b.g(b.this);
                        if (!b.this.f17037x) {
                            if (b.f17013a) {
                                b.k();
                                int unused = b.f17016d = 1;
                                long unused2 = b.f17018f = b.this.f17032s;
                            }
                            if (!b.this.f17031r.equals(b.this.f17033t)) {
                                return;
                            }
                            if (b.f17015c && !b.f17014b) {
                                int unused3 = b.f17016d = 4;
                                long unused4 = b.f17018f = b.this.f17032s;
                                return;
                            } else if (!b.f17015c) {
                                int unused5 = b.f17016d = 3;
                                long unused6 = b.f17018f = b.this.f17032s;
                                return;
                            }
                        }
                        b.this.f17037x = true;
                        b bVar = b.this;
                        b.a(bVar, bVar.f17031r, b.this.f17032s, "onResume");
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public final void onActivityStarted(Activity activity) {
                        b.this.f17029p = activity.getClass().getName();
                        b.this.f17030q = System.currentTimeMillis();
                        b bVar = b.this;
                        b.a(bVar, bVar.f17029p, b.this.f17030q, "onStart");
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public final void onActivityStopped(Activity activity) {
                        b.this.f17035v = activity.getClass().getName();
                        b.this.f17036w = System.currentTimeMillis();
                        b bVar = b.this;
                        b.a(bVar, bVar.f17035v, b.this.f17036w, "onStop");
                    }
                });
            } catch (Throwable unused) {
            }
        }
    }

    private static JSONObject a(String str, long j11) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", str);
            jSONObject.put("time", j11);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static void a() {
        f17017e = true;
    }

    public static /* synthetic */ void a(b bVar, String str, long j11, String str2) {
        a aVar;
        try {
            if (bVar.f17026m.size() >= bVar.A) {
                aVar = bVar.f17026m.poll();
                if (aVar != null) {
                    bVar.f17026m.add(aVar);
                }
            } else {
                aVar = null;
            }
            if (aVar == null) {
                aVar = new a(str, str2, j11);
                bVar.f17026m.add(aVar);
            }
            aVar.f17041b = str2;
            aVar.f17040a = str;
            aVar.f17042c = j11;
        } catch (Throwable unused) {
        }
    }

    public static int b() {
        int i11 = f17016d;
        if (i11 == 1) {
            return f17017e ? 2 : 1;
        }
        return i11;
    }

    public static long c() {
        return f17018f;
    }

    public static b d() {
        if (f17019z == null) {
            synchronized (b.class) {
                try {
                    if (f17019z == null) {
                        f17019z = new b(com.apm.insight.e.h());
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f17019z;
    }

    public static /* synthetic */ int g(b bVar) {
        int i11 = bVar.B;
        bVar.B = i11 + 1;
        return i11;
    }

    public static /* synthetic */ boolean k() {
        f17013a = false;
        return false;
    }

    public static /* synthetic */ int l(b bVar) {
        int i11 = bVar.B;
        bVar.B = i11 - 1;
        return i11;
    }

    public static /* synthetic */ int n(b bVar) {
        bVar.B = 0;
        return 0;
    }

    private JSONArray n() {
        JSONArray jSONArray = new JSONArray();
        List<String> list = this.f17022i;
        if (list != null && !list.isEmpty()) {
            for (int i11 = 0; i11 < this.f17022i.size(); i11++) {
                try {
                    jSONArray.put(a(this.f17022i.get(i11), this.f17023j.get(i11).longValue()));
                } catch (Throwable unused) {
                }
            }
        }
        return jSONArray;
    }

    private JSONArray o() {
        JSONArray jSONArray = new JSONArray();
        List<String> list = this.f17024k;
        if (list != null && !list.isEmpty()) {
            for (int i11 = 0; i11 < this.f17024k.size(); i11++) {
                try {
                    jSONArray.put(a(this.f17024k.get(i11), this.f17025l.get(i11).longValue()));
                } catch (Throwable unused) {
                }
            }
        }
        return jSONArray;
    }

    public final long e() {
        return SystemClock.uptimeMillis() - this.f17038y;
    }

    public final boolean f() {
        return this.f17037x;
    }

    public final JSONObject g() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("last_create_activity", a(this.f17027n, this.f17028o));
            jSONObject.put("last_start_activity", a(this.f17029p, this.f17030q));
            jSONObject.put("last_resume_activity", a(this.f17031r, this.f17032s));
            jSONObject.put("last_pause_activity", a(this.f17033t, this.f17034u));
            jSONObject.put("last_stop_activity", a(this.f17035v, this.f17036w));
            jSONObject.put("alive_activities", n());
            jSONObject.put("finish_activities", o());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @NonNull
    public final String h() {
        return String.valueOf(this.f17031r);
    }

    public final JSONArray i() {
        JSONArray jSONArray = new JSONArray();
        Iterator it = new ArrayList(this.f17026m).iterator();
        while (it.hasNext()) {
            jSONArray.put(((a) it.next()).toString());
        }
        return jSONArray;
    }
}
