package tg;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class c0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c0 f76995c = new c0(0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f76996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f76997b;

    public c0(long j11, long j12) {
        this.f76996a = j11;
        this.f76997b = j12;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c0.class != obj.getClass()) {
            return false;
        }
        c0 c0Var = (c0) obj;
        return this.f76996a == c0Var.f76996a && this.f76997b == c0Var.f76997b;
    }

    public int hashCode() {
        return (((int) this.f76996a) * 31) + ((int) this.f76997b);
    }

    public String toString() {
        return "[timeUs=" + this.f76996a + ", position=" + this.f76997b + "]";
    }
}
