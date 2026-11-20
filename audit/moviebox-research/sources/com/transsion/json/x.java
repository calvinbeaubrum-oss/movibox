package com.transsion.json;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f52995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f52996b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f52997c;

    public x(a aVar) {
        this.f52995a = aVar;
    }

    public void a() {
        this.f52996b = Math.max(this.f52996b - 1, 0);
    }

    public void b(String str) {
        this.f52997c = str;
    }

    public a c() {
        return this.f52995a;
    }

    public void d() {
        this.f52996b++;
    }

    public boolean e() {
        return this.f52996b != 0;
    }
}
