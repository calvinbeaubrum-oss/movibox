package com.google.android.exoplayer2.video;

import android.os.Bundle;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class y implements com.google.android.exoplayer2.g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final y f35861f = new y(0, 0);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final com.google.android.exoplayer2.g.a<y> f35862g = new com.google.android.exoplayer2.g.a() { // from class: com.google.android.exoplayer2.video.x
        @Override // com.google.android.exoplayer2.g.a
        public final com.google.android.exoplayer2.g a(Bundle bundle) {
            return y.c(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f35863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f35864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f35865c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f35866d;

    public y(int i11, int i12) {
        this(i11, i12, 0, 1.0f);
    }

    public y(int i11, int i12, int i13, float f11) {
        this.f35863a = i11;
        this.f35864b = i12;
        this.f35865c = i13;
        this.f35866d = f11;
    }

    private static String b(int i11) {
        return Integer.toString(i11, 36);
    }

    public static /* synthetic */ y c(Bundle bundle) {
        return new y(bundle.getInt(b(0), 0), bundle.getInt(b(1), 0), bundle.getInt(b(2), 0), bundle.getFloat(b(3), 1.0f));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return this.f35863a == yVar.f35863a && this.f35864b == yVar.f35864b && this.f35865c == yVar.f35865c && this.f35866d == yVar.f35866d;
    }

    public int hashCode() {
        return ((((((217 + this.f35863a) * 31) + this.f35864b) * 31) + this.f35865c) * 31) + Float.floatToRawIntBits(this.f35866d);
    }

    @Override // com.google.android.exoplayer2.g
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(b(0), this.f35863a);
        bundle.putInt(b(1), this.f35864b);
        bundle.putInt(b(2), this.f35865c);
        bundle.putFloat(b(3), this.f35866d);
        return bundle;
    }
}
