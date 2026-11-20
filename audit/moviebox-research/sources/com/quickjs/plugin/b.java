package com.quickjs.plugin;

import android.util.Log;
import android.webkit.JavascriptInterface;
import com.quickjs.JSArray;
import com.quickjs.JSObject;
import com.quickjs.c0;
import com.quickjs.e0;
import com.quickjs.y;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class b extends e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f48975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Long> f48976b = new HashMap();

    @Override // com.quickjs.e0
    public void a(y yVar) {
    }

    @Override // com.quickjs.e0
    public void b(y yVar) {
        yVar.d(this, "console").p(new c0() { // from class: com.quickjs.plugin.a
            @Override // com.quickjs.c0
            public final void a(JSObject jSObject, JSArray jSArray) {
                this.f48974a.d(jSObject, jSArray);
            }
        }, "assert");
    }

    @JavascriptInterface
    public void clear() {
        log("This 'console.clear' function is not supported");
    }

    @JavascriptInterface
    public final int count() {
        return this.f48975a;
    }

    public final /* synthetic */ void d(JSObject jSObject, JSArray jSArray) {
        if (jSArray.x(0)) {
            return;
        }
        error(jSArray.getString(1));
    }

    public void e(int i11, String str) {
        Log.println(i11, "QuickJS", str);
    }

    @JavascriptInterface
    public final void error(String str) {
        this.f48975a++;
        e(6, str);
    }

    @JavascriptInterface
    public void group(String str) {
        log("This 'console.group' function is not supported");
    }

    @JavascriptInterface
    public void groupCollapsed(String str) {
        log("This 'console.groupCollapsed' function is not supported");
    }

    @JavascriptInterface
    public void groupEnd(String str) {
        log("This 'console.groupEnd' function is not supported");
    }

    @JavascriptInterface
    public final void info(String str) {
        this.f48975a++;
        e(4, str);
    }

    @JavascriptInterface
    public final void log(String str) {
        this.f48975a++;
        e(3, str);
    }

    @JavascriptInterface
    public final void table(JSObject jSObject) {
        if (jSObject instanceof JSArray) {
            log(((JSArray) jSObject).i0().toString());
        } else if (jSObject != null) {
            log(jSObject.t().toString());
        }
    }

    @JavascriptInterface
    public final void time(String str) {
        if (this.f48976b.containsKey(str)) {
            warn(String.format("Timer '%s' already exists", str));
        } else {
            this.f48976b.put(str, Long.valueOf(System.currentTimeMillis()));
        }
    }

    @JavascriptInterface
    public final void timeEnd(String str) {
        Long l11 = this.f48976b.get(str);
        if (l11 != null) {
            log(String.format("%s: %s ms", str, Float.valueOf(System.currentTimeMillis() - l11.longValue())));
        }
        this.f48976b.remove(str);
    }

    @JavascriptInterface
    public void trace() {
        log("This 'console.trace' function is not supported");
    }

    @JavascriptInterface
    public final void warn(String str) {
        this.f48975a++;
        e(5, str);
    }
}
