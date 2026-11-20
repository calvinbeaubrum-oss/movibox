package com.google.zxing;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f41497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public hm.b f41498b;

    public b(a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("Binarizer must be non-null.");
        }
        this.f41497a = aVar;
    }

    public hm.b a() throws NotFoundException {
        if (this.f41498b == null) {
            this.f41498b = this.f41497a.b();
        }
        return this.f41498b;
    }

    public hm.a b(int i11, hm.a aVar) throws NotFoundException {
        return this.f41497a.c(i11, aVar);
    }

    public int c() {
        return this.f41497a.d();
    }

    public int d() {
        return this.f41497a.f();
    }

    public boolean e() {
        return this.f41497a.e().f();
    }

    public b f() {
        return new b(this.f41497a.a(this.f41497a.e().g()));
    }

    public String toString() {
        try {
            return a().toString();
        } catch (NotFoundException unused) {
            return "";
        }
    }
}
