package com.google.android.exoplayer2;

import android.os.Bundle;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class h3 extends u2 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g.a<h3> f33260d = new g.a() { // from class: com.google.android.exoplayer2.g3
        @Override // com.google.android.exoplayer2.g.a
        public final g a(Bundle bundle) {
            return h3.e(bundle);
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f33261b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f33262c;

    public h3() {
        this.f33261b = false;
        this.f33262c = false;
    }

    public h3(boolean z11) {
        this.f33261b = true;
        this.f33262c = z11;
    }

    private static String c(int i11) {
        return Integer.toString(i11, 36);
    }

    public static h3 e(Bundle bundle) {
        com.google.android.exoplayer2.util.a.a(bundle.getInt(c(0), -1) == 3);
        return bundle.getBoolean(c(1), false) ? new h3(bundle.getBoolean(c(2), false)) : new h3();
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof h3)) {
            return false;
        }
        h3 h3Var = (h3) obj;
        return this.f33262c == h3Var.f33262c && this.f33261b == h3Var.f33261b;
    }

    public int hashCode() {
        return com.google.common.base.j.b(Boolean.valueOf(this.f33261b), Boolean.valueOf(this.f33262c));
    }

    @Override // com.google.android.exoplayer2.g
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(c(0), 3);
        bundle.putBoolean(c(1), this.f33261b);
        bundle.putBoolean(c(2), this.f33262c);
        return bundle;
    }
}
