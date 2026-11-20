package androidx.media3.exoplayer;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class z2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final z2 f11785c = new z2(0, false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f11787b;

    public z2(int i11, boolean z11) {
        this.f11786a = i11;
        this.f11787b = z11;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || z2.class != obj.getClass()) {
            return false;
        }
        z2 z2Var = (z2) obj;
        return this.f11786a == z2Var.f11786a && this.f11787b == z2Var.f11787b;
    }

    public int hashCode() {
        return (this.f11786a << 1) + (this.f11787b ? 1 : 0);
    }
}
