package androidx.media3.common;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f9217b;

    public g(int i11, float f11) {
        this.f9216a = i11;
        this.f9217b = f11;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        return this.f9216a == gVar.f9216a && Float.compare(gVar.f9217b, this.f9217b) == 0;
    }

    public int hashCode() {
        return ((527 + this.f9216a) * 31) + Float.floatToIntBits(this.f9217b);
    }
}
