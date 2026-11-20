package com.pgl.ssdk.ces;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.pgl.ssdk.a0;
import com.pgl.ssdk.b0;
import com.pgl.ssdk.b1;
import com.pgl.ssdk.c0;
import com.pgl.ssdk.ces.out.PglSSConfig;
import com.pgl.ssdk.d0;
import com.pgl.ssdk.e0;
import com.pgl.ssdk.f0;
import com.pgl.ssdk.g0;
import com.pgl.ssdk.h0;
import com.pgl.ssdk.i0;
import com.pgl.ssdk.j0;
import com.pgl.ssdk.l0;
import com.pgl.ssdk.n0;
import com.pgl.ssdk.o0;
import com.pgl.ssdk.s;
import com.pgl.ssdk.t;
import com.pgl.ssdk.t0;
import com.pgl.ssdk.u;
import com.pgl.ssdk.u0;
import com.pgl.ssdk.v;
import com.pgl.ssdk.v0;
import com.pgl.ssdk.w;
import com.pgl.ssdk.x;
import com.pgl.ssdk.y;
import com.pgl.ssdk.z;
import com.transsion.gslb.Worker;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f48732a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile b f48733b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f48734c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Map<String, Object> f48735d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f48736e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static t0.a f48737f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Context f48739h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f48740i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f48741j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f48742k;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f48747p;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f48738g = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f48743l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f48744m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f48745n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f48746o = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f48748q = false;

    /* JADX INFO: compiled from: source.java */
    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            x.b(x.b());
        }
    }

    /* JADX INFO: renamed from: com.pgl.ssdk.ces.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class RunnableC0533b implements Runnable {
        public RunnableC0533b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j0.a(b.this.f48739h).a();
            i0.a(b.this.f48739h).a();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            z.b(b.this.f48739h);
        }
    }

    private b(Context context, String str) {
        this.f48739h = context;
        this.f48740i = str;
    }

    public static b a(Context context, String str, int i11, int i12, String str2) {
        if (f48733b == null) {
            synchronized (b.class) {
                try {
                    if (f48733b == null) {
                        if (context == null) {
                            context = z.a().getApplicationContext();
                        }
                        if (context == null) {
                            f48736e = 4;
                            return null;
                        }
                        a(i11);
                        t0.a aVarB = t0.b(context, "nms");
                        if (aVarB != null) {
                            f48736e = aVarB.f48838a;
                            f48737f = aVarB;
                            return null;
                        }
                        b bVar = new b(context, str);
                        f48733b = bVar;
                        bVar.f48741j = i12;
                        f48733b.f48742k = str2;
                        f48733b.b(context);
                        f48733b.c(a(context));
                        x.c(context);
                        f48736e = 0;
                        o0.b(new a());
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f48733b;
    }

    private static String a(Context context) {
        String strA = u0.a(context, "iid");
        if (!TextUtils.isEmpty(strA)) {
            return strA;
        }
        String string = UUID.randomUUID().toString();
        u0.b(context, "iid", string);
        return string;
    }

    public static void a(int i11) {
        l0.a(i11);
    }

    private void b(Context context) {
        if (context == null || f48734c) {
            return;
        }
        try {
            com.pgl.ssdk.ces.a.meta(101, null, "1");
            com.pgl.ssdk.ces.a.meta(102, null, this.f48740i);
            com.pgl.ssdk.ces.a.meta(114, null, Integer.valueOf(this.f48741j));
            StringBuilder sb2 = new StringBuilder();
            sb2.append(z.g(context));
            com.pgl.ssdk.ces.a.meta(105, null, sb2.toString());
            com.pgl.ssdk.ces.a.meta(106, null, z.e(context));
            com.pgl.ssdk.ces.a.meta(107, null, z.d(context));
            com.pgl.ssdk.ces.a.meta(108, null, z.c(context));
            com.pgl.ssdk.ces.a.meta(109, null, z.c());
            com.pgl.ssdk.ces.a.meta(Worker.WHAT_QUIT, null, z.b());
            com.pgl.ssdk.ces.a.meta(115, null, this.f48742k);
            f48734c = true;
        } catch (Throwable unused) {
        }
    }

    private void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f48747p = str;
        com.pgl.ssdk.ces.a.meta(104, null, str);
    }

    public static String d() {
        if (h() != null) {
            return h().f48740i;
        }
        return null;
    }

    public static String e() {
        if (h() != null) {
            return h().f48743l;
        }
        return null;
    }

    public static int g() {
        return f48736e;
    }

    public static b h() {
        return f48733b;
    }

    public static t0.a i() {
        return f48737f;
    }

    private void l() {
        b1.a(this.f48739h, this.f48740i);
    }

    public Object a(int i11, Object obj) {
        if (i11 == 123) {
            return d0.a(this.f48739h);
        }
        if (i11 == 121) {
            return b0.a();
        }
        if (i11 == 122) {
            return b0.b();
        }
        if (i11 == 126) {
            return b0.b(this.f48739h);
        }
        if (i11 == 128) {
            return b0.c(this.f48739h);
        }
        if (i11 == 120) {
            return a0.c();
        }
        if (i11 == 124) {
            return e0.c(this.f48739h);
        }
        if (i11 == 130) {
            return e0.a(this.f48739h);
        }
        if (i11 == 145) {
            return f0.b(this.f48739h);
        }
        if (i11 == 125) {
            return e0.b(this.f48739h);
        }
        if (i11 == 129) {
            return c0.e(this.f48739h);
        }
        if (i11 == 141) {
            return c0.d(this.f48739h);
        }
        if (i11 == 131) {
            return b1.a();
        }
        if (i11 == 134) {
            return j0.a(this.f48739h).b();
        }
        if (i11 == 140) {
            return i0.a(this.f48739h).e();
        }
        if (i11 == 144) {
            return i0.a(this.f48739h).d();
        }
        String string = null;
        if (i11 == 133) {
            try {
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry<String, Object> entry : f48735d.entrySet()) {
                    if (entry.getValue() == null) {
                        jSONObject.put(entry.getKey(), "");
                    } else {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                }
                string = jSONObject.toString();
            } catch (Throwable unused) {
            }
            return string == null ? "{}" : string.trim();
        }
        if (i11 == 135) {
            return t.f();
        }
        if (i11 == 201) {
            return b0.a(this.f48739h);
        }
        if (i11 == 202) {
            return b0.c();
        }
        if (i11 == 236) {
            return v0.a((String) obj);
        }
        if (i11 == 142) {
            return z.f(this.f48739h);
        }
        if (i11 == 143) {
            return f0.a(this.f48739h);
        }
        if (i11 == 146) {
            try {
                return t.b();
            } catch (Throwable unused2) {
                return null;
            }
        }
        if (i11 == 147) {
            return Boolean.valueOf(z.h(this.f48739h));
        }
        if (i11 == 148) {
            return s.b(this.f48739h);
        }
        if (i11 == 149) {
            return u.a(this.f48739h);
        }
        if (i11 == 150) {
            return Integer.valueOf(v.a());
        }
        if (i11 == 151) {
            return u.c();
        }
        if (i11 == 161) {
            return Boolean.valueOf(t.g());
        }
        if (i11 == 163) {
            return h0.a();
        }
        if (i11 == 164) {
            return Boolean.valueOf(y.b(this.f48739h));
        }
        if (i11 == 165) {
            return Integer.valueOf(w.b((String) obj));
        }
        return null;
    }

    public Map<String, String> a(String str, byte[] bArr) {
        HashMap map = new HashMap();
        Object[] objArr = new Object[2];
        if (str == null) {
            str = "";
        }
        objArr[0] = str;
        if (bArr == null) {
            bArr = new byte[0];
        }
        objArr[1] = bArr;
        String str2 = (String) com.pgl.ssdk.ces.a.meta(224, this.f48739h, objArr);
        if (!TextUtils.isEmpty(str2)) {
            map.put("X-Armors", str2);
        }
        return map;
    }

    public void a() {
        o0.b(new RunnableC0533b());
    }

    public void a(MotionEvent motionEvent) {
        w.a(motionEvent, this.f48739h);
    }

    public synchronized void a(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.f48743l)) {
            com.pgl.ssdk.ces.a.meta(Worker.WHAT_SYNC_DATA, null, str);
            b1.c();
            this.f48743l = str;
        }
    }

    public void a(String str, String str2, String str3, String str4) {
        this.f48743l = str2;
        this.f48745n = str3;
        this.f48744m = str;
        com.pgl.ssdk.ces.a.meta(113, null, str);
        com.pgl.ssdk.ces.a.meta(112, null, str3);
        com.pgl.ssdk.ces.a.meta(Worker.WHAT_SYNC_DATA, null, str2);
        com.pgl.ssdk.ces.a.meta(111, null, str4);
        try {
            m();
        } catch (Throwable unused) {
        }
    }

    public void a(String str, Map<String, Object> map) {
        try {
            long j11 = "CZL-L1st".equals(str) ? 10000L : 0L;
            Handler handlerB = o0.b();
            if (handlerB != null) {
                handlerB.postDelayed(new com.pgl.ssdk.ces.c(this.f48739h, str, map), j11);
            }
            a();
            x.a();
        } catch (Throwable unused) {
        }
    }

    public void a(Map<String, Object> map) {
        if (map != null) {
            f48735d = map;
        }
    }

    public void b() {
        Map<String, Object> map = f48735d;
        if (map != null) {
            Object obj = map.get(PglSSConfig.CUSTOMINFO_KEY_CHECKCLAZZ);
            if (obj instanceof String) {
                String strA = g0.a((String) obj);
                if (TextUtils.isEmpty(strA)) {
                    return;
                }
                com.pgl.ssdk.ces.a.meta(159, null, strA);
            }
        }
    }

    public synchronized void b(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.f48746o)) {
            com.pgl.ssdk.ces.a.meta(111, null, str);
            this.f48746o = str;
            b1.c();
        }
    }

    public void c() {
        o0.b(new c());
    }

    public synchronized void d(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.f48745n)) {
            com.pgl.ssdk.ces.a.meta(112, null, str);
            this.f48745n = str;
            b1.c();
        }
    }

    public long f() {
        return x.a(this.f48739h);
    }

    public String j() {
        return x.c();
    }

    public String k() {
        return b1.b();
    }

    public void m() {
        this.f48748q = true;
        n0.b();
        l();
        a("CZL-L1st", (Map<String, Object>) null);
    }
}
