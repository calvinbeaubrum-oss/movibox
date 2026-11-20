package com.journeyapps.barcodescanner.camera;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class CameraSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f42571a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f42572b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f42573c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f42574d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f42575e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f42576f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f42577g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f42578h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public FocusMode f42579i = FocusMode.AUTO;

    /* JADX INFO: compiled from: source.java */
    public enum FocusMode {
        AUTO,
        CONTINUOUS,
        INFINITY,
        MACRO
    }

    public FocusMode a() {
        return this.f42579i;
    }

    public int b() {
        return this.f42571a;
    }

    public boolean c() {
        return this.f42575e;
    }

    public boolean d() {
        return this.f42578h;
    }

    public boolean e() {
        return this.f42573c;
    }

    public boolean f() {
        return this.f42577g;
    }

    public boolean g() {
        return this.f42574d;
    }

    public boolean h() {
        return this.f42572b;
    }

    public void i(int i11) {
        this.f42571a = i11;
    }
}
