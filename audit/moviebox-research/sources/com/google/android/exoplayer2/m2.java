package com.google.android.exoplayer2;

import android.os.Bundle;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class m2 implements g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final m2 f33485d = new m2(1.0f);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final g.a<m2> f33486f = new g.a() { // from class: com.google.android.exoplayer2.l2
        @Override // com.google.android.exoplayer2.g.a
        public final g a(Bundle bundle) {
            return m2.d(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f33487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f33488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f33489c;

    public m2(float f11) {
        this(f11, 1.0f);
    }

    public m2(float f11, float f12) {
        com.google.android.exoplayer2.util.a.a(f11 > 0.0f);
        com.google.android.exoplayer2.util.a.a(f12 > 0.0f);
        this.f33487a = f11;
        this.f33488b = f12;
        this.f33489c = Math.round(f11 * 1000.0f);
    }

    private static String c(int i11) {
        return Integer.toString(i11, 36);
    }

    public static /* synthetic */ m2 d(Bundle bundle) {
        return new m2(bundle.getFloat(c(0), 1.0f), bundle.getFloat(c(1), 1.0f));
    }

    public long b(long j11) {
        return j11 * ((long) this.f33489c);
    }

    @CheckResult
    public m2 e(float f11) {
        return new m2(f11, this.f33488b);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || m2.class != obj.getClass()) {
            return false;
        }
        m2 m2Var = (m2) obj;
        return this.f33487a == m2Var.f33487a && this.f33488b == m2Var.f33488b;
    }

    public int hashCode() {
        return ((527 + Float.floatToRawIntBits(this.f33487a)) * 31) + Float.floatToRawIntBits(this.f33488b);
    }

    @Override // com.google.android.exoplayer2.g
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putFloat(c(0), this.f33487a);
        bundle.putFloat(c(1), this.f33488b);
        return bundle;
    }

    public String toString() {
        return com.google.android.exoplayer2.util.o0.C("PlaybackParameters(speed=%.2f, pitch=%.2f)", Float.valueOf(this.f33487a), Float.valueOf(this.f33488b));
    }
}
