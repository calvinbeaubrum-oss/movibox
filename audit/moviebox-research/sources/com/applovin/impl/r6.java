package com.applovin.impl;

import android.os.Bundle;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class r6 implements o2 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final r6 f22048d = new r6(0, 0, 0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final o2.a f22049f = new o2.a() { // from class: com.applovin.impl.t40
        @Override // com.applovin.impl.o2.a
        public final o2 a(Bundle bundle) {
            return r6.a(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f22050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f22051b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f22052c;

    public r6(int i11, int i12, int i13) {
        this.f22050a = i11;
        this.f22051b = i12;
        this.f22052c = i13;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ r6 a(Bundle bundle) {
        return new r6(bundle.getInt(a(0), 0), bundle.getInt(a(1), 0), bundle.getInt(a(2), 0));
    }

    private static String a(int i11) {
        return Integer.toString(i11, 36);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r6)) {
            return false;
        }
        r6 r6Var = (r6) obj;
        return this.f22050a == r6Var.f22050a && this.f22051b == r6Var.f22051b && this.f22052c == r6Var.f22052c;
    }

    public int hashCode() {
        return ((((this.f22050a + 527) * 31) + this.f22051b) * 31) + this.f22052c;
    }
}
