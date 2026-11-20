package com.apm.insight.b;

import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.apm.insight.runtime.r;
import com.google.logging.type.LogSeverity;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;
import okhttp3.internal.http2.Settings;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static int f16651r = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f16652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f16653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile int f16654c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f16655d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f16656e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private f f16657f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f16658g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f16659h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f16660i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f16661j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f16662k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f16663l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private com.apm.insight.b.e f16664m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private volatile boolean f16665n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f16666o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final r f16667p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private volatile boolean f16668q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Runnable f16669s;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f16678a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f16679b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f16680c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f16681d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f16682e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        StackTraceElement[] f16683f;

        private a() {
        }

        public /* synthetic */ a(byte b11) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        a f16684a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f16685b;

        public final void a(a aVar) {
            throw null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
    }

    /* JADX INFO: compiled from: source.java */
    public static class d {
    }

    /* JADX INFO: compiled from: source.java */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f16686a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f16687b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f16688c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f16689d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f16690e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        long f16691f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        long f16692g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        String f16693h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f16694i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private String f16695j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private d f16696k;

        public final JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, g.a(this.f16693h));
                jSONObject.put("cpuDuration", this.f16692g);
                jSONObject.put("duration", this.f16691f);
                jSONObject.put("type", this.f16689d);
                jSONObject.put("count", this.f16690e);
                jSONObject.put("messageCount", this.f16690e);
                jSONObject.put("lastDuration", this.f16687b - this.f16688c);
                jSONObject.put("start", this.f16686a);
                jSONObject.put(TtmlNode.END, this.f16687b);
                jSONObject.put("block_uuid", (Object) null);
                jSONObject.put("sblock_uuid", (Object) null);
                jSONObject.put("belong_frame", false);
            } catch (JSONException e11) {
                e11.printStackTrace();
            }
            return jSONObject;
        }

        public final void b() {
            this.f16689d = -1;
            this.f16690e = -1;
            this.f16691f = -1L;
            this.f16693h = null;
            this.f16695j = null;
            this.f16696k = null;
            this.f16694i = null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f16697a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f16698b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private e f16699c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private List<e> f16700d = new ArrayList();

        public f(int i11) {
            this.f16697a = i11;
        }

        public final e a(int i11) {
            e eVar = this.f16699c;
            if (eVar != null) {
                eVar.f16689d = i11;
                this.f16699c = null;
                return eVar;
            }
            e eVar2 = new e();
            eVar2.f16689d = i11;
            return eVar2;
        }

        public final List<e> a() {
            ArrayList arrayList = new ArrayList();
            int i11 = 0;
            if (this.f16700d.size() == this.f16697a) {
                for (int i12 = this.f16698b; i12 < this.f16700d.size(); i12++) {
                    arrayList.add(this.f16700d.get(i12));
                }
                while (i11 < this.f16698b - 1) {
                    arrayList.add(this.f16700d.get(i11));
                    i11++;
                }
            } else {
                while (i11 < this.f16700d.size()) {
                    arrayList.add(this.f16700d.get(i11));
                    i11++;
                }
            }
            return arrayList;
        }

        public final void a(e eVar) {
            int size = this.f16700d.size();
            int i11 = this.f16697a;
            if (size < i11) {
                this.f16700d.add(eVar);
                this.f16698b = this.f16700d.size();
                return;
            }
            int i12 = this.f16698b % i11;
            this.f16698b = i12;
            e eVar2 = this.f16700d.set(i12, eVar);
            eVar2.b();
            this.f16699c = eVar2;
            this.f16698b++;
        }
    }

    public g() {
        this((byte) 0);
    }

    private g(byte b11) {
        this.f16653b = 0;
        this.f16654c = 0;
        this.f16655d = 100;
        this.f16656e = 200;
        this.f16658g = -1L;
        this.f16659h = -1L;
        this.f16660i = -1;
        this.f16661j = -1L;
        this.f16665n = false;
        this.f16666o = false;
        this.f16668q = false;
        this.f16669s = new Runnable() { // from class: com.apm.insight.b.g.2

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private long f16672b;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private long f16671a = 0;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private int f16673c = -1;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private int f16674d = 0;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private int f16675e = 0;

            @Override // java.lang.Runnable
            public final void run() {
                long jUptimeMillis = SystemClock.uptimeMillis();
                if (g.c().f16684a != null) {
                    throw null;
                }
                a aVar = new a((byte) 0);
                if (this.f16673c == g.this.f16654c) {
                    this.f16674d++;
                } else {
                    this.f16674d = 0;
                    this.f16675e = 0;
                    this.f16672b = jUptimeMillis;
                }
                this.f16673c = g.this.f16654c;
                int i11 = this.f16674d;
                if (i11 > 0 && i11 - this.f16675e >= g.f16651r && this.f16671a != 0 && jUptimeMillis - this.f16672b > 700 && g.this.f16668q) {
                    aVar.f16683f = Looper.getMainLooper().getThread().getStackTrace();
                    this.f16675e = this.f16674d;
                }
                aVar.f16681d = g.this.f16668q;
                aVar.f16680c = (jUptimeMillis - this.f16671a) - 300;
                aVar.f16678a = jUptimeMillis;
                long jUptimeMillis2 = SystemClock.uptimeMillis();
                this.f16671a = jUptimeMillis2;
                aVar.f16679b = jUptimeMillis2 - jUptimeMillis;
                aVar.f16682e = g.this.f16654c;
                g.e().a(g.this.f16669s, 300L);
                g.c().a(aVar);
            }
        };
        this.f16652a = new c() { // from class: com.apm.insight.b.g.1
        };
        this.f16667p = null;
    }

    private static long a(int i11) {
        if (i11 < 0) {
            return 0L;
        }
        try {
            return com.apm.insight.runtime.f.a(i11);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static String a(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return "unknown message";
        }
        try {
            String[] strArrSplit = str.split(":");
            String str3 = strArrSplit.length == 2 ? strArrSplit[1] : "";
            if (str.contains("{") && str.contains("}")) {
                str2 = str.split("\\{")[0];
                try {
                    str = str2 + str.split("\\}")[1];
                } catch (Throwable unused) {
                    return str2;
                }
            } else {
                str2 = str;
            }
            if (str.contains("@")) {
                String[] strArrSplit2 = str.split("@");
                if (strArrSplit2.length > 1) {
                    str = strArrSplit2[0];
                }
            }
            if (str.contains("(") && str.contains(")") && !str.endsWith(" null")) {
                String[] strArrSplit3 = str.split("\\(");
                if (strArrSplit3.length > 1) {
                    str = strArrSplit3[1];
                }
                str = str.replace(")", "");
            }
            if (str.startsWith(" ")) {
                str = str.replace(" ", "");
            }
            return str + str3;
        } catch (Throwable unused2) {
            return str;
        }
    }

    private void a(int i11, long j11, String str) {
        a(i11, j11, str, true);
    }

    private void a(int i11, long j11, String str, boolean z11) {
        this.f16666o = true;
        e eVarA = this.f16657f.a(i11);
        eVarA.f16691f = j11 - this.f16658g;
        if (z11) {
            long jCurrentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
            eVarA.f16692g = jCurrentThreadTimeMillis - this.f16661j;
            this.f16661j = jCurrentThreadTimeMillis;
        } else {
            eVarA.f16692g = -1L;
        }
        eVarA.f16690e = this.f16653b;
        eVarA.f16693h = str;
        eVarA.f16694i = this.f16662k;
        eVarA.f16686a = this.f16658g;
        eVarA.f16687b = j11;
        eVarA.f16688c = this.f16659h;
        this.f16657f.a(eVarA);
        this.f16653b = 0;
        this.f16658g = j11;
    }

    public static /* synthetic */ void a(g gVar, boolean z11, long j11) {
        int i11 = gVar.f16654c + 1;
        gVar.f16654c = i11;
        gVar.f16654c = i11 & Settings.DEFAULT_INITIAL_WINDOW_SIZE;
        gVar.f16666o = false;
        if (gVar.f16658g < 0) {
            gVar.f16658g = j11;
        }
        if (gVar.f16659h < 0) {
            gVar.f16659h = j11;
        }
        if (gVar.f16660i < 0) {
            gVar.f16660i = Process.myTid();
            gVar.f16661j = SystemClock.currentThreadTimeMillis();
        }
        long j12 = j11 - gVar.f16658g;
        int i12 = gVar.f16656e;
        if (j12 > i12) {
            long j13 = gVar.f16659h;
            if (j11 - j13 <= i12) {
                gVar.a(9, j11, gVar.f16663l);
            } else if (z11) {
                if (gVar.f16653b == 0) {
                    gVar.a(1, j11, "no message running");
                } else {
                    gVar.a(9, j13, gVar.f16662k);
                    gVar.a(1, j11, "no message running", false);
                }
            } else if (gVar.f16653b == 0) {
                gVar.a(8, j11, gVar.f16663l, true);
            } else {
                gVar.a(9, j13, gVar.f16662k, false);
                gVar.a(8, j11, gVar.f16663l, true);
            }
        }
        gVar.f16659h = j11;
    }

    public static /* synthetic */ b c() {
        return null;
    }

    public static /* synthetic */ int d(g gVar) {
        int i11 = gVar.f16653b;
        gVar.f16653b = i11 + 1;
        return i11;
    }

    public static /* synthetic */ r e() {
        return null;
    }

    public final e a(long j11) {
        e eVar = new e();
        eVar.f16693h = this.f16663l;
        eVar.f16694i = this.f16662k;
        eVar.f16691f = j11 - this.f16659h;
        eVar.f16692g = a(this.f16660i) - this.f16661j;
        eVar.f16690e = this.f16653b;
        return eVar;
    }

    public final void a() {
        if (this.f16665n) {
            return;
        }
        this.f16665n = true;
        this.f16655d = 100;
        this.f16656e = LogSeverity.NOTICE_VALUE;
        this.f16657f = new f(100);
        this.f16664m = new com.apm.insight.b.e() { // from class: com.apm.insight.b.g.3
            @Override // com.apm.insight.b.e
            public final void a(String str) {
                g.this.f16668q = true;
                g.this.f16663l = str;
                super.a(str);
                g.a(g.this, true, com.apm.insight.b.e.f16645a);
            }

            @Override // com.apm.insight.b.e
            public final boolean a() {
                return true;
            }

            @Override // com.apm.insight.b.e
            public final void b(String str) {
                super.b(str);
                g.d(g.this);
                g.a(g.this, false, com.apm.insight.b.e.f16645a);
                g gVar = g.this;
                gVar.f16662k = gVar.f16663l;
                g.this.f16663l = "no message running";
                g.this.f16668q = false;
            }
        };
        h.a();
        h.a(this.f16664m);
        j.a(j.a());
    }

    public final JSONArray b() {
        JSONArray jSONArray = new JSONArray();
        try {
            int i11 = 0;
            for (e eVar : this.f16657f.a()) {
                if (eVar != null) {
                    i11++;
                    jSONArray.put(eVar.a().put("id", i11));
                }
            }
        } catch (Throwable unused) {
        }
        return jSONArray;
    }
}
