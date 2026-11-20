package com.google.android.exoplayer2;

import android.os.Bundle;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class i2 extends u2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final g.a<i2> f33291c = new g.a() { // from class: com.google.android.exoplayer2.h2
        @Override // com.google.android.exoplayer2.g.a
        public final g a(Bundle bundle) {
            return i2.e(bundle);
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f33292b;

    public i2() {
        this.f33292b = -1.0f;
    }

    public i2(float f11) {
        com.google.android.exoplayer2.util.a.b(f11 >= 0.0f && f11 <= 100.0f, "percent must be in the range of [0, 100]");
        this.f33292b = f11;
    }

    private static String c(int i11) {
        return Integer.toString(i11, 36);
    }

    public static i2 e(Bundle bundle) {
        com.google.android.exoplayer2.util.a.a(bundle.getInt(c(0), -1) == 1);
        float f11 = bundle.getFloat(c(1), -1.0f);
        return f11 == -1.0f ? new i2() : new i2(f11);
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof i2) && this.f33292b == ((i2) obj).f33292b;
    }

    public int hashCode() {
        return com.google.common.base.j.b(Float.valueOf(this.f33292b));
    }

    @Override // com.google.android.exoplayer2.g
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(c(0), 1);
        bundle.putFloat(c(1), this.f33292b);
        return bundle;
    }
}
