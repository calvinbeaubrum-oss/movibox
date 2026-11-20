package com.applovin.impl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ya implements bf.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f24575a;

    public ya(String str) {
        this.f24575a = str;
    }

    @Override // com.applovin.impl.bf.b
    public /* synthetic */ void a(vd.b bVar) {
        jt.a(this, bVar);
    }

    @Override // com.applovin.impl.bf.b
    public /* synthetic */ byte[] a() {
        return jt.b(this);
    }

    @Override // com.applovin.impl.bf.b
    public /* synthetic */ f9 b() {
        return jt.c(this);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return this.f24575a;
    }
}
