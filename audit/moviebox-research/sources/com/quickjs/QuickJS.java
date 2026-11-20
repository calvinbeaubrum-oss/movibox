package com.quickjs;

import android.os.HandlerThread;
import androidx.annotation.Keep;
import java.io.Closeable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class QuickJS implements Closeable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<Long, y> f48893d = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f48894f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f48895g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f48896h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static int f48897i = 3;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static int f48898j = 8;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static int f48899k = 16;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static int f48900l = 32;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static int f48901m = 64;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f48902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f48903b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w f48904c;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c0 f48905a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public b0 f48906b;
    }

    static {
        System.loadLibrary("quickjs");
        System.loadLibrary("quickjs-android");
    }

    public QuickJS(long j11, HandlerThread handlerThread) {
        this.f48903b = j11;
        this.f48904c = new w(this, handlerThread);
    }

    public static void b(y yVar) {
        String[] strArr_getException = yVar.getNative()._getException(yVar.getContextPtr());
        if (strArr_getException == null) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(strArr_getException[1]);
        sb2.append('\n');
        for (int i11 = 2; i11 < strArr_getException.length; i11++) {
            sb2.append(strArr_getException[i11]);
        }
        throw new QuickJSException(strArr_getException[0], sb2.toString());
    }

    @Keep
    public static Object callJavaCallback(long j11, int i11, JSValue jSValue, JSArray jSArray, boolean z11) {
        a aVar;
        y yVar = f48893d.get(Long.valueOf(j11));
        if (yVar == null || (aVar = yVar.f49018g.get(Integer.valueOf(i11))) == null) {
            return null;
        }
        JSObject jSObject = jSValue instanceof JSObject ? (JSObject) jSValue : null;
        if (!z11) {
            return aVar.f48906b.a(jSObject, jSArray);
        }
        aVar.f48905a.a(jSObject, jSArray);
        return null;
    }

    @Keep
    public static String convertModuleName(long j11, String str, String str2) {
        y yVar = f48893d.get(Long.valueOf(j11));
        if (yVar != null && (yVar instanceof d0)) {
            return ((d0) yVar).l0(str, str2);
        }
        return null;
    }

    @Keep
    public static JSValue createJSValue(long j11, int i11, long j12, int i12, double d11, long j13) {
        y yVar = f48893d.get(Long.valueOf(j11));
        if (i11 == 5) {
            return new JSArray(yVar, j12, i12, d11, j13);
        }
        if (i11 == 6) {
            return new JSObject(yVar, j12, i12, d11, j13);
        }
        if (i11 != 7) {
            return i11 != 99 ? new JSValue(yVar, j12, i12, d11, j13) : new JSObject.a(yVar, j12, i12, d11, j13);
        }
        return new JSFunction(yVar, j12, i12, d11, j13);
    }

    public static QuickJS d() {
        return new QuickJS(QuickJSNativeImpl._createRuntime(), null);
    }

    @Keep
    public static String getModuleScript(long j11, String str) {
        y yVar = f48893d.get(Long.valueOf(j11));
        if (yVar != null && (yVar instanceof d0)) {
            return ((d0) yVar).p0(str);
        }
        return null;
    }

    public y c() {
        return new y(this, e()._createContext(this.f48903b));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        i(new Runnable() { // from class: com.quickjs.f0
            @Override // java.lang.Runnable
            public final void run() {
                this.f48932a.h();
            }
        });
    }

    public g0 e() {
        return this.f48904c;
    }

    public boolean g() {
        return this.f48902a;
    }

    public final /* synthetic */ void h() {
        if (this.f48902a) {
            return;
        }
        Map<Long, y> map = f48893d;
        int size = map.size();
        y[] yVarArr = new y[size];
        map.values().toArray(yVarArr);
        for (int i11 = 0; i11 < size; i11++) {
            y yVar = yVarArr[i11];
            if (yVar.getQuickJS() == this) {
                yVar.close();
            }
        }
        e()._releaseRuntime(this.f48903b);
        this.f48902a = true;
        this.f48904c.w();
    }

    public void i(Runnable runnable) {
        this.f48904c.V(runnable, false);
    }
}
