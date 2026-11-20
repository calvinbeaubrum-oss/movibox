package com.apm.insight.f;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.apm.insight.CrashType;
import com.apm.insight.entity.c;
import com.apm.insight.k.g;
import com.apm.insight.l.m;
import com.apm.insight.runtime.a.f;
import com.apm.insight.runtime.n;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f16770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private JSONObject f16771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f16772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f16773d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f16774e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f16775f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f16776g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<String> f16777h;

    public static void a(final Object obj, final Throwable th2, final String str, final String str2, @NonNull final String str3) {
        try {
            n.a().a(new Runnable() { // from class: com.apm.insight.f.b.2

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                private /* synthetic */ boolean f16786d = true;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                private /* synthetic */ Map f16787e = null;

                @Override // java.lang.Runnable
                public final void run() {
                    b.a(obj, th2, str, this.f16786d, null, str2, str3);
                }
            });
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(Object obj, Throwable th2, String str, boolean z11, Map<String, String> map, String str2, @NonNull String str3) {
        if (th2 == null) {
            return;
        }
        try {
            StackTraceElement[] stackTrace = th2.getStackTrace();
            StackTraceElement stackTraceElement = stackTrace[0];
            if (stackTraceElement == null) {
                return;
            }
            String strA = m.a(th2);
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            c cVarA = c.a(stackTraceElement, strA, str, Thread.currentThread().getName(), z11, str2, str3);
            if (obj != null) {
                cVarA.a("exception_line_num", (Object) com.apm.insight.entity.b.a(obj, th2, stackTrace));
            }
            a(null, cVarA);
            f.a().a(CrashType.ENSURE, cVarA);
            g.a(obj, cVarA);
            com.apm.insight.a.b((Object) "[reportException] ".concat(String.valueOf(str)));
        } catch (Throwable th3) {
            com.apm.insight.a.b(th3);
        }
    }

    public static void a(final Throwable th2, final String str, @NonNull final String str2) {
        try {
            n.a().a(new Runnable() { // from class: com.apm.insight.f.b.1

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                private /* synthetic */ boolean f16780c = true;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                private /* synthetic */ Map f16781d = null;

                @Override // java.lang.Runnable
                public final void run() {
                    b.a(null, th2, str, this.f16780c, null, "EnsureNotReachHere", str2);
                }
            });
        } catch (Throwable unused) {
        }
    }

    private static void a(Map<String, String> map, c cVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (map != null) {
                for (String str : map.keySet()) {
                    jSONObject.put(str, map.get(str));
                }
                cVar.a("custom", jSONObject);
            }
        } catch (Throwable unused) {
        }
    }

    public static /* synthetic */ void a(StackTraceElement[] stackTraceElementArr, int i11, String str, String str2, String str3, Map map) {
        StackTraceElement stackTraceElement;
        String string;
        if (stackTraceElementArr != null) {
            try {
                if (stackTraceElementArr.length > i11 + 1 && (stackTraceElement = stackTraceElementArr[i11]) != null) {
                    if (stackTraceElementArr.length <= 0) {
                        string = null;
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        while (i11 < stackTraceElementArr.length) {
                            m.a(stackTraceElementArr[i11], sb2);
                            i11++;
                        }
                        string = sb2.toString();
                    }
                    if (TextUtils.isEmpty(string)) {
                        return;
                    }
                    c cVarA = c.a(stackTraceElement, string, str, Thread.currentThread().getName(), true, str2, str3);
                    a(null, cVarA);
                    f.a().a(CrashType.ENSURE, cVarA);
                    g.a(cVarA);
                    com.apm.insight.a.b((Object) "[report] ".concat(String.valueOf(str)));
                }
            } catch (Throwable th2) {
                com.apm.insight.a.b(th2);
            }
        }
    }

    public static void a(final StackTraceElement[] stackTraceElementArr, @Nullable final String str, final String str2) {
        try {
            n.a().a(new Runnable() { // from class: com.apm.insight.f.b.3

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private /* synthetic */ int f16791b = 5;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                private /* synthetic */ Map f16794e = null;

                @Override // java.lang.Runnable
                public final void run() {
                    b.a(stackTraceElementArr, this.f16791b, str, str2, "core_exception_monitor", (Map) null);
                }
            });
        } catch (Throwable unused) {
        }
    }

    public final String a() {
        return this.f16770a;
    }

    public final void a(String str) {
        this.f16770a = str;
    }

    public final void a(List<String> list) {
        this.f16777h = list;
    }

    public final void a(JSONObject jSONObject) {
        this.f16771b = jSONObject;
    }

    public final void a(boolean z11) {
        this.f16773d = z11;
    }

    public final JSONObject b() {
        return this.f16771b;
    }

    public final void b(String str) {
        this.f16772c = str;
    }

    public final String c() {
        return this.f16772c;
    }

    public final void c(String str) {
        this.f16774e = str;
    }

    public final String d() {
        return this.f16774e;
    }

    public final void d(String str) {
        this.f16775f = str;
    }

    public final String e() {
        return this.f16775f;
    }

    public final void e(String str) {
        this.f16776g = str;
    }

    public final String f() {
        return this.f16776g;
    }

    public final List<String> g() {
        return this.f16777h;
    }
}
