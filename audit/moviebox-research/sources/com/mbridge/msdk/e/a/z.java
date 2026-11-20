package com.mbridge.msdk.e.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class z extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f43847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f43848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f43849c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f43850d;

    public z() {
        this.f43849c = 0;
        this.f43850d = "";
        this.f43847a = null;
    }

    public z(m mVar) {
        this.f43849c = 0;
        this.f43850d = "";
        this.f43847a = mVar;
    }

    public z(String str) {
        super(str);
        this.f43849c = 0;
        this.f43850d = "";
        this.f43847a = null;
    }

    public z(Throwable th2) {
        super(th2);
        this.f43849c = 0;
        this.f43850d = "";
        this.f43847a = null;
    }

    public abstract int a();

    public final void a(int i11) {
        this.f43849c = i11;
    }

    public final void a(long j11) {
        this.f43848b = j11;
    }

    public final void a(String str) {
        this.f43850d = str;
    }

    public final int b() {
        return this.f43849c;
    }

    public final String c() {
        return this.f43850d;
    }
}
