package com.amazonaws.logging;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class AndroidLog implements Log {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LogFactory.Level f15762b = null;

    public AndroidLog(String str) {
        this.f15761a = str;
    }

    @Override // com.amazonaws.logging.Log
    public void a(Object obj) {
        if (l() == null || l().getValue() <= LogFactory.Level.DEBUG.getValue()) {
            obj.toString();
        }
    }

    @Override // com.amazonaws.logging.Log
    public boolean b() {
        return android.util.Log.isLoggable(this.f15761a, 3) && (l() == null || l().getValue() <= LogFactory.Level.DEBUG.getValue());
    }

    @Override // com.amazonaws.logging.Log
    public boolean c() {
        return android.util.Log.isLoggable(this.f15761a, 4) && (l() == null || l().getValue() <= LogFactory.Level.INFO.getValue());
    }

    @Override // com.amazonaws.logging.Log
    public void d(Object obj) {
        if (l() == null || l().getValue() <= LogFactory.Level.INFO.getValue()) {
            obj.toString();
        }
    }

    @Override // com.amazonaws.logging.Log
    public void e(Object obj, Throwable th2) {
        if (l() == null || l().getValue() <= LogFactory.Level.ERROR.getValue()) {
            android.util.Log.e(this.f15761a, obj.toString(), th2);
        }
    }

    @Override // com.amazonaws.logging.Log
    public void f(Object obj) {
        if (l() == null || l().getValue() <= LogFactory.Level.ERROR.getValue()) {
            android.util.Log.e(this.f15761a, obj.toString());
        }
    }

    @Override // com.amazonaws.logging.Log
    public void g(Object obj, Throwable th2) {
        if (l() == null || l().getValue() <= LogFactory.Level.DEBUG.getValue()) {
            obj.toString();
        }
    }

    @Override // com.amazonaws.logging.Log
    public boolean h() {
        return android.util.Log.isLoggable(this.f15761a, 6) && (l() == null || l().getValue() <= LogFactory.Level.ERROR.getValue());
    }

    @Override // com.amazonaws.logging.Log
    public void i(Object obj, Throwable th2) {
        if (l() == null || l().getValue() <= LogFactory.Level.WARN.getValue()) {
            android.util.Log.w(this.f15761a, obj.toString(), th2);
        }
    }

    @Override // com.amazonaws.logging.Log
    public void j(Object obj) {
        if (l() == null || l().getValue() <= LogFactory.Level.WARN.getValue()) {
            android.util.Log.w(this.f15761a, obj.toString());
        }
    }

    @Override // com.amazonaws.logging.Log
    public void k(Object obj) {
        if (l() == null || l().getValue() <= LogFactory.Level.TRACE.getValue()) {
            android.util.Log.v(this.f15761a, obj.toString());
        }
    }

    public final LogFactory.Level l() {
        LogFactory.Level level = this.f15762b;
        return level != null ? level : LogFactory.a();
    }
}
