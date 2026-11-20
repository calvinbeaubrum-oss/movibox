package com.google.android.exoplayer2;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Booleans;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class o3 implements g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o3 f33625b = new o3(ImmutableList.of());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final g.a<o3> f33626c = new g.a() { // from class: com.google.android.exoplayer2.m3
        @Override // com.google.android.exoplayer2.g.a
        public final g a(Bundle bundle) {
            return o3.f(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImmutableList<a> f33627a;

    /* JADX INFO: compiled from: source.java */
    public static final class a implements g {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final g.a<a> f33628g = new g.a() { // from class: com.google.android.exoplayer2.n3
            @Override // com.google.android.exoplayer2.g.a
            public final g a(Bundle bundle) {
                return o3.a.k(bundle);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f33629a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final nh.i0 f33630b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f33631c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int[] f33632d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean[] f33633f;

        public a(nh.i0 i0Var, boolean z11, int[] iArr, boolean[] zArr) {
            int i11 = i0Var.f71931a;
            this.f33629a = i11;
            boolean z12 = false;
            com.google.android.exoplayer2.util.a.a(i11 == iArr.length && i11 == zArr.length);
            this.f33630b = i0Var;
            if (z11 && i11 > 1) {
                z12 = true;
            }
            this.f33631c = z12;
            this.f33632d = (int[]) iArr.clone();
            this.f33633f = (boolean[]) zArr.clone();
        }

        private static String j(int i11) {
            return Integer.toString(i11, 36);
        }

        public static /* synthetic */ a k(Bundle bundle) {
            nh.i0 i0Var = (nh.i0) nh.i0.f71930g.a((Bundle) com.google.android.exoplayer2.util.a.e(bundle.getBundle(j(0))));
            return new a(i0Var, bundle.getBoolean(j(4), false), (int[]) com.google.common.base.h.a(bundle.getIntArray(j(1)), new int[i0Var.f71931a]), (boolean[]) com.google.common.base.h.a(bundle.getBooleanArray(j(3)), new boolean[i0Var.f71931a]));
        }

        public nh.i0 b() {
            return this.f33630b;
        }

        public m1 c(int i11) {
            return this.f33630b.c(i11);
        }

        public int d() {
            return this.f33630b.f71933c;
        }

        public boolean e() {
            return this.f33631c;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f33631c == aVar.f33631c && this.f33630b.equals(aVar.f33630b) && Arrays.equals(this.f33632d, aVar.f33632d) && Arrays.equals(this.f33633f, aVar.f33633f);
        }

        public boolean f() {
            return Booleans.b(this.f33633f, true);
        }

        public boolean g(int i11) {
            return this.f33633f[i11];
        }

        public boolean h(int i11) {
            return i(i11, false);
        }

        public int hashCode() {
            return (((((this.f33630b.hashCode() * 31) + (this.f33631c ? 1 : 0)) * 31) + Arrays.hashCode(this.f33632d)) * 31) + Arrays.hashCode(this.f33633f);
        }

        public boolean i(int i11, boolean z11) {
            int i12 = this.f33632d[i11];
            return i12 == 4 || (z11 && i12 == 3);
        }

        @Override // com.google.android.exoplayer2.g
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putBundle(j(0), this.f33630b.toBundle());
            bundle.putIntArray(j(1), this.f33632d);
            bundle.putBooleanArray(j(3), this.f33633f);
            bundle.putBoolean(j(4), this.f33631c);
            return bundle;
        }
    }

    public o3(List<a> list) {
        this.f33627a = ImmutableList.copyOf((Collection) list);
    }

    private static String e(int i11) {
        return Integer.toString(i11, 36);
    }

    public static /* synthetic */ o3 f(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(e(0));
        return new o3(parcelableArrayList == null ? ImmutableList.of() : com.google.android.exoplayer2.util.d.b(a.f33628g, parcelableArrayList));
    }

    public ImmutableList<a> b() {
        return this.f33627a;
    }

    public boolean c() {
        return this.f33627a.isEmpty();
    }

    public boolean d(int i11) {
        for (int i12 = 0; i12 < this.f33627a.size(); i12++) {
            a aVar = this.f33627a.get(i12);
            if (aVar.f() && aVar.d() == i11) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o3.class != obj.getClass()) {
            return false;
        }
        return this.f33627a.equals(((o3) obj).f33627a);
    }

    public int hashCode() {
        return this.f33627a.hashCode();
    }

    @Override // com.google.android.exoplayer2.g
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(e(0), com.google.android.exoplayer2.util.d.d(this.f33627a));
        return bundle;
    }
}
