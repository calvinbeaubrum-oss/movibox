package com.google.android.exoplayer2;

import android.os.Bundle;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class d3 extends u2 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g.a<d3> f33026d = new g.a() { // from class: com.google.android.exoplayer2.c3
        @Override // com.google.android.exoplayer2.g.a
        public final g a(Bundle bundle) {
            return d3.e(bundle);
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f33027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f33028c;

    public d3(int i11) {
        com.google.android.exoplayer2.util.a.b(i11 > 0, "maxStars must be a positive integer");
        this.f33027b = i11;
        this.f33028c = -1.0f;
    }

    public d3(int i11, float f11) {
        com.google.android.exoplayer2.util.a.b(i11 > 0, "maxStars must be a positive integer");
        com.google.android.exoplayer2.util.a.b(f11 >= 0.0f && f11 <= ((float) i11), "starRating is out of range [0, maxStars]");
        this.f33027b = i11;
        this.f33028c = f11;
    }

    private static String c(int i11) {
        return Integer.toString(i11, 36);
    }

    public static d3 e(Bundle bundle) {
        com.google.android.exoplayer2.util.a.a(bundle.getInt(c(0), -1) == 2);
        int i11 = bundle.getInt(c(1), 5);
        float f11 = bundle.getFloat(c(2), -1.0f);
        return f11 == -1.0f ? new d3(i11) : new d3(i11, f11);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof d3)) {
            return false;
        }
        d3 d3Var = (d3) obj;
        return this.f33027b == d3Var.f33027b && this.f33028c == d3Var.f33028c;
    }

    public int hashCode() {
        return com.google.common.base.j.b(Integer.valueOf(this.f33027b), Float.valueOf(this.f33028c));
    }

    @Override // com.google.android.exoplayer2.g
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(c(0), 2);
        bundle.putInt(c(1), this.f33027b);
        bundle.putFloat(c(2), this.f33028c);
        return bundle;
    }
}
