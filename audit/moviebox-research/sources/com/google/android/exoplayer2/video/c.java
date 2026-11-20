package com.google.android.exoplayer2.video;

import android.os.Bundle;
import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class c implements com.google.android.exoplayer2.g {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final com.google.android.exoplayer2.g.a<c> f35716g = new com.google.android.exoplayer2.g.a() { // from class: com.google.android.exoplayer2.video.b
        @Override // com.google.android.exoplayer2.g.a
        public final com.google.android.exoplayer2.g a(Bundle bundle) {
            return c.e(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f35717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f35718b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f35719c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final byte[] f35720d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f35721f;

    public c(int i11, int i12, int i13, @Nullable byte[] bArr) {
        this.f35717a = i11;
        this.f35718b = i12;
        this.f35719c = i13;
        this.f35720d = bArr;
    }

    public static int b(int i11) {
        if (i11 == 1) {
            return 1;
        }
        if (i11 != 9) {
            return (i11 == 4 || i11 == 5 || i11 == 6 || i11 == 7) ? 2 : -1;
        }
        return 6;
    }

    public static int c(int i11) {
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

    private static String d(int i11) {
        return Integer.toString(i11, 36);
    }

    public static /* synthetic */ c e(Bundle bundle) {
        return new c(bundle.getInt(d(0), -1), bundle.getInt(d(1), -1), bundle.getInt(d(2), -1), bundle.getByteArray(d(3)));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return this.f35717a == cVar.f35717a && this.f35718b == cVar.f35718b && this.f35719c == cVar.f35719c && Arrays.equals(this.f35720d, cVar.f35720d);
    }

    public int hashCode() {
        if (this.f35721f == 0) {
            this.f35721f = ((((((527 + this.f35717a) * 31) + this.f35718b) * 31) + this.f35719c) * 31) + Arrays.hashCode(this.f35720d);
        }
        return this.f35721f;
    }

    @Override // com.google.android.exoplayer2.g
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(d(0), this.f35717a);
        bundle.putInt(d(1), this.f35718b);
        bundle.putInt(d(2), this.f35719c);
        bundle.putByteArray(d(3), this.f35720d);
        return bundle;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("ColorInfo(");
        sb2.append(this.f35717a);
        sb2.append(", ");
        sb2.append(this.f35718b);
        sb2.append(", ");
        sb2.append(this.f35719c);
        sb2.append(", ");
        sb2.append(this.f35720d != null);
        sb2.append(")");
        return sb2.toString();
    }
}
