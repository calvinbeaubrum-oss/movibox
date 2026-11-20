package u4;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class n0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final n0 f78352c = new n0(0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f78353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f78354b;

    public n0(long j11, long j12) {
        this.f78353a = j11;
        this.f78354b = j12;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n0.class != obj.getClass()) {
            return false;
        }
        n0 n0Var = (n0) obj;
        return this.f78353a == n0Var.f78353a && this.f78354b == n0Var.f78354b;
    }

    public int hashCode() {
        return (((int) this.f78353a) * 31) + ((int) this.f78354b);
    }

    public String toString() {
        return "[timeUs=" + this.f78353a + ", position=" + this.f78354b + "]";
    }
}
