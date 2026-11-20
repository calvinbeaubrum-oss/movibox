package com.applovin.impl;

import android.os.Bundle;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class r3 implements o2 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final o2.a f22030g = new o2.a() { // from class: com.applovin.impl.s40
        @Override // com.applovin.impl.o2.a
        public final o2 a(Bundle bundle) {
            return r3.a(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f22031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f22032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f22033c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f22034d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f22035f;

    public r3(int i11, int i12, int i13, byte[] bArr) {
        this.f22031a = i11;
        this.f22032b = i12;
        this.f22033c = i13;
        this.f22034d = bArr;
    }

    public static int a(int i11) {
        if (i11 == 1) {
            return 1;
        }
        if (i11 != 9) {
            return (i11 == 4 || i11 == 5 || i11 == 6 || i11 == 7) ? 2 : -1;
        }
        return 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ r3 a(Bundle bundle) {
        return new r3(bundle.getInt(c(0), -1), bundle.getInt(c(1), -1), bundle.getInt(c(2), -1), bundle.getByteArray(c(3)));
    }

    public static int b(int i11) {
        if (i11 == 1) {
            return 3;
        }
        if (i11 == 16) {
            return 6;
        }
        if (i11 != 18) {
            return (i11 == 6 || i11 == 7) ? 3 : -1;
        }
        return 7;
    }

    private static String c(int i11) {
        return Integer.toString(i11, 36);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || r3.class != obj.getClass()) {
            return false;
        }
        r3 r3Var = (r3) obj;
        return this.f22031a == r3Var.f22031a && this.f22032b == r3Var.f22032b && this.f22033c == r3Var.f22033c && Arrays.equals(this.f22034d, r3Var.f22034d);
    }

    public int hashCode() {
        if (this.f22035f == 0) {
            this.f22035f = ((((((this.f22031a + 527) * 31) + this.f22032b) * 31) + this.f22033c) * 31) + Arrays.hashCode(this.f22034d);
        }
        return this.f22035f;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("ColorInfo(");
        sb2.append(this.f22031a);
        sb2.append(", ");
        sb2.append(this.f22032b);
        sb2.append(", ");
        sb2.append(this.f22033c);
        sb2.append(", ");
        sb2.append(this.f22034d != null);
        sb2.append(")");
        return sb2.toString();
    }
}
