package com.applovin.impl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class yd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f24653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f24654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f24655c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f24656d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f24657e;

    public yd(yd ydVar) {
        this.f24653a = ydVar.f24653a;
        this.f24654b = ydVar.f24654b;
        this.f24655c = ydVar.f24655c;
        this.f24656d = ydVar.f24656d;
        this.f24657e = ydVar.f24657e;
    }

    public yd(Object obj) {
        this(obj, -1L);
    }

    public yd(Object obj, int i11, int i12, long j11) {
        this(obj, i11, i12, j11, -1);
    }

    private yd(Object obj, int i11, int i12, long j11, int i13) {
        this.f24653a = obj;
        this.f24654b = i11;
        this.f24655c = i12;
        this.f24656d = j11;
        this.f24657e = i13;
    }

    public yd(Object obj, long j11) {
        this(obj, -1, -1, j11, -1);
    }

    public yd(Object obj, long j11, int i11) {
        this(obj, -1, -1, j11, i11);
    }

    public yd a(Object obj) {
        return this.f24653a.equals(obj) ? this : new yd(obj, this.f24654b, this.f24655c, this.f24656d, this.f24657e);
    }

    public boolean a() {
        return this.f24654b != -1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof yd)) {
            return false;
        }
        yd ydVar = (yd) obj;
        return this.f24653a.equals(ydVar.f24653a) && this.f24654b == ydVar.f24654b && this.f24655c == ydVar.f24655c && this.f24656d == ydVar.f24656d && this.f24657e == ydVar.f24657e;
    }

    public int hashCode() {
        return ((((((((this.f24653a.hashCode() + 527) * 31) + this.f24654b) * 31) + this.f24655c) * 31) + ((int) this.f24656d)) * 31) + this.f24657e;
    }
}
