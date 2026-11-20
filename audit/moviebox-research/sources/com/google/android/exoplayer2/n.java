package com.google.android.exoplayer2;

import android.os.Bundle;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class n implements g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final n f33596d = new n(0, 0, 0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final g.a<n> f33597f = new g.a() { // from class: com.google.android.exoplayer2.m
        @Override // com.google.android.exoplayer2.g.a
        public final g a(Bundle bundle) {
            return n.c(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f33598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f33599b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f33600c;

    public n(int i11, int i12, int i13) {
        this.f33598a = i11;
        this.f33599b = i12;
        this.f33600c = i13;
    }

    private static String b(int i11) {
        return Integer.toString(i11, 36);
    }

    public static /* synthetic */ n c(Bundle bundle) {
        return new n(bundle.getInt(b(0), 0), bundle.getInt(b(1), 0), bundle.getInt(b(2), 0));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return this.f33598a == nVar.f33598a && this.f33599b == nVar.f33599b && this.f33600c == nVar.f33600c;
    }

    public int hashCode() {
        return ((((527 + this.f33598a) * 31) + this.f33599b) * 31) + this.f33600c;
    }

    @Override // com.google.android.exoplayer2.g
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(b(0), this.f33598a);
        bundle.putInt(b(1), this.f33599b);
        bundle.putInt(b(2), this.f33600c);
        return bundle;
    }
}
