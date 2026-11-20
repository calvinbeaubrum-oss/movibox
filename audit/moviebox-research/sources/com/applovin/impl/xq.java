package com.applovin.impl;

import android.os.Bundle;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class xq implements o2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final xq f24387f = new xq(0, 0);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final o2.a f24388g = new o2.a() { // from class: com.applovin.impl.j90
        @Override // com.applovin.impl.o2.a
        public final o2 a(Bundle bundle) {
            return xq.a(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f24389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f24390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f24391c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f24392d;

    public xq(int i11, int i12) {
        this(i11, i12, 0, 1.0f);
    }

    public xq(int i11, int i12, int i13, float f11) {
        this.f24389a = i11;
        this.f24390b = i12;
        this.f24391c = i13;
        this.f24392d = f11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ xq a(Bundle bundle) {
        return new xq(bundle.getInt(a(0), 0), bundle.getInt(a(1), 0), bundle.getInt(a(2), 0), bundle.getFloat(a(3), 1.0f));
    }

    private static String a(int i11) {
        return Integer.toString(i11, 36);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof xq)) {
            return false;
        }
        xq xqVar = (xq) obj;
        return this.f24389a == xqVar.f24389a && this.f24390b == xqVar.f24390b && this.f24391c == xqVar.f24391c && this.f24392d == xqVar.f24392d;
    }

    public int hashCode() {
        return ((((((this.f24389a + 217) * 31) + this.f24390b) * 31) + this.f24391c) * 31) + Float.floatToRawIntBits(this.f24392d);
    }
}
