package com.google.zxing;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f41499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f41500b;

    public int a() {
        return this.f41500b;
    }

    public int b() {
        return this.f41499a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f41499a == cVar.f41499a && this.f41500b == cVar.f41500b;
    }

    public int hashCode() {
        return (this.f41499a * 32713) + this.f41500b;
    }

    public String toString() {
        return this.f41499a + "x" + this.f41500b;
    }
}
