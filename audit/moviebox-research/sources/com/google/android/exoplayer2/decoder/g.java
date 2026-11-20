package com.google.android.exoplayer2.decoder;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m1;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f33076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m1 f33077b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m1 f33078c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f33079d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f33080e;

    public g(String str, m1 m1Var, m1 m1Var2, int i11, int i12) {
        com.google.android.exoplayer2.util.a.a(i11 == 0 || i12 == 0);
        this.f33076a = com.google.android.exoplayer2.util.a.d(str);
        this.f33077b = (m1) com.google.android.exoplayer2.util.a.e(m1Var);
        this.f33078c = (m1) com.google.android.exoplayer2.util.a.e(m1Var2);
        this.f33079d = i11;
        this.f33080e = i12;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        return this.f33079d == gVar.f33079d && this.f33080e == gVar.f33080e && this.f33076a.equals(gVar.f33076a) && this.f33077b.equals(gVar.f33077b) && this.f33078c.equals(gVar.f33078c);
    }

    public int hashCode() {
        return ((((((((527 + this.f33079d) * 31) + this.f33080e) * 31) + this.f33076a.hashCode()) * 31) + this.f33077b.hashCode()) * 31) + this.f33078c.hashCode();
    }
}
