package com.google.android.exoplayer2;

import android.os.Bundle;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class q1 extends u2 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g.a<q1> f33698d = new g.a() { // from class: com.google.android.exoplayer2.p1
        @Override // com.google.android.exoplayer2.g.a
        public final g a(Bundle bundle) {
            return q1.e(bundle);
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f33699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f33700c;

    public q1() {
        this.f33699b = false;
        this.f33700c = false;
    }

    public q1(boolean z11) {
        this.f33699b = true;
        this.f33700c = z11;
    }

    private static String c(int i11) {
        return Integer.toString(i11, 36);
    }

    public static q1 e(Bundle bundle) {
        com.google.android.exoplayer2.util.a.a(bundle.getInt(c(0), -1) == 0);
        return bundle.getBoolean(c(1), false) ? new q1(bundle.getBoolean(c(2), false)) : new q1();
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof q1)) {
            return false;
        }
        q1 q1Var = (q1) obj;
        return this.f33700c == q1Var.f33700c && this.f33699b == q1Var.f33699b;
    }

    public int hashCode() {
        return com.google.common.base.j.b(Boolean.valueOf(this.f33699b), Boolean.valueOf(this.f33700c));
    }

    @Override // com.google.android.exoplayer2.g
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(c(0), 0);
        bundle.putBoolean(c(1), this.f33699b);
        bundle.putBoolean(c(2), this.f33700c);
        return bundle;
    }
}
