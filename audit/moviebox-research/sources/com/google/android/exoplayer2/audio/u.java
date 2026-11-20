package com.google.android.exoplayer2.audio;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f32946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f32947b;

    public u(int i11, float f11) {
        this.f32946a = i11;
        this.f32947b = f11;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || u.class != obj.getClass()) {
            return false;
        }
        u uVar = (u) obj;
        return this.f32946a == uVar.f32946a && Float.compare(uVar.f32947b, this.f32947b) == 0;
    }

    public int hashCode() {
        return ((527 + this.f32946a) * 31) + Float.floatToIntBits(this.f32947b);
    }
}
