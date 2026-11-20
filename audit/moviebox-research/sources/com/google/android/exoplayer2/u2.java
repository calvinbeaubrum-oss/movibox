package com.google.android.exoplayer2;

import android.os.Bundle;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class u2 implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g.a<u2> f34869a = new g.a() { // from class: com.google.android.exoplayer2.t2
        @Override // com.google.android.exoplayer2.g.a
        public final g a(Bundle bundle) {
            return u2.b(bundle);
        }
    };

    public static u2 b(Bundle bundle) {
        int i11 = bundle.getInt(c(0), -1);
        if (i11 == 0) {
            return (u2) q1.f33698d.a(bundle);
        }
        if (i11 == 1) {
            return (u2) i2.f33291c.a(bundle);
        }
        if (i11 == 2) {
            return (u2) d3.f33026d.a(bundle);
        }
        if (i11 == 3) {
            return (u2) h3.f33260d.a(bundle);
        }
        throw new IllegalArgumentException("Unknown RatingType: " + i11);
    }

    private static String c(int i11) {
        return Integer.toString(i11, 36);
    }
}
