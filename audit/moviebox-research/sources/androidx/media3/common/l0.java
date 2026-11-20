package androidx.media3.common;

import android.view.Surface;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Surface f9278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9280c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f9281d;

    public l0(Surface surface, int i11, int i12) {
        this(surface, i11, i12, 0);
    }

    public l0(Surface surface, int i11, int i12, int i13) {
        z3.a.b(i13 == 0 || i13 == 90 || i13 == 180 || i13 == 270, "orientationDegrees must be 0, 90, 180, or 270");
        this.f9278a = surface;
        this.f9279b = i11;
        this.f9280c = i12;
        this.f9281d = i13;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l0)) {
            return false;
        }
        l0 l0Var = (l0) obj;
        return this.f9279b == l0Var.f9279b && this.f9280c == l0Var.f9280c && this.f9281d == l0Var.f9281d && this.f9278a.equals(l0Var.f9278a);
    }

    public int hashCode() {
        return (((((this.f9278a.hashCode() * 31) + this.f9279b) * 31) + this.f9280c) * 31) + this.f9281d;
    }
}
