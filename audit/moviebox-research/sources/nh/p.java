package nh;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f71960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f71961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f71962c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f71963d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f71964e;

    public p(Object obj) {
        this(obj, -1L);
    }

    public p(Object obj, int i11, int i12, long j11) {
        this(obj, i11, i12, j11, -1);
    }

    public p(Object obj, int i11, int i12, long j11, int i13) {
        this.f71960a = obj;
        this.f71961b = i11;
        this.f71962c = i12;
        this.f71963d = j11;
        this.f71964e = i13;
    }

    public p(Object obj, long j11) {
        this(obj, -1, -1, j11, -1);
    }

    public p(Object obj, long j11, int i11) {
        this(obj, -1, -1, j11, i11);
    }

    public p(p pVar) {
        this.f71960a = pVar.f71960a;
        this.f71961b = pVar.f71961b;
        this.f71962c = pVar.f71962c;
        this.f71963d = pVar.f71963d;
        this.f71964e = pVar.f71964e;
    }

    public p a(Object obj) {
        return this.f71960a.equals(obj) ? this : new p(obj, this.f71961b, this.f71962c, this.f71963d, this.f71964e);
    }

    public boolean b() {
        return this.f71961b != -1;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return this.f71960a.equals(pVar.f71960a) && this.f71961b == pVar.f71961b && this.f71962c == pVar.f71962c && this.f71963d == pVar.f71963d && this.f71964e == pVar.f71964e;
    }

    public int hashCode() {
        return ((((((((527 + this.f71960a.hashCode()) * 31) + this.f71961b) * 31) + this.f71962c) * 31) + ((int) this.f71963d)) * 31) + this.f71964e;
    }
}
