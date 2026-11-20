package nh;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class k0 implements com.google.android.exoplayer2.g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final k0 f71939d = new k0(new i0[0]);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final com.google.android.exoplayer2.g.a<k0> f71940f = new com.google.android.exoplayer2.g.a() { // from class: nh.j0
        @Override // com.google.android.exoplayer2.g.a
        public final com.google.android.exoplayer2.g a(Bundle bundle) {
            return k0.e(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f71941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImmutableList<i0> f71942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f71943c;

    public k0(i0... i0VarArr) {
        this.f71942b = ImmutableList.copyOf(i0VarArr);
        this.f71941a = i0VarArr.length;
        f();
    }

    private static String d(int i11) {
        return Integer.toString(i11, 36);
    }

    public static /* synthetic */ k0 e(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(d(0));
        return parcelableArrayList == null ? new k0(new i0[0]) : new k0((i0[]) com.google.android.exoplayer2.util.d.b(i0.f71930g, parcelableArrayList).toArray(new i0[0]));
    }

    private void f() {
        int i11 = 0;
        while (i11 < this.f71942b.size()) {
            int i12 = i11 + 1;
            for (int i13 = i12; i13 < this.f71942b.size(); i13++) {
                if (this.f71942b.get(i11).equals(this.f71942b.get(i13))) {
                    com.google.android.exoplayer2.util.s.d("TrackGroupArray", "", new IllegalArgumentException("Multiple identical TrackGroups added to one TrackGroupArray."));
                }
            }
            i11 = i12;
        }
    }

    public i0 b(int i11) {
        return this.f71942b.get(i11);
    }

    public int c(i0 i0Var) {
        int iIndexOf = this.f71942b.indexOf(i0Var);
        if (iIndexOf >= 0) {
            return iIndexOf;
        }
        return -1;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k0.class != obj.getClass()) {
            return false;
        }
        k0 k0Var = (k0) obj;
        return this.f71941a == k0Var.f71941a && this.f71942b.equals(k0Var.f71942b);
    }

    public int hashCode() {
        if (this.f71943c == 0) {
            this.f71943c = this.f71942b.hashCode();
        }
        return this.f71943c;
    }

    @Override // com.google.android.exoplayer2.g
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(d(0), com.google.android.exoplayer2.util.d.d(this.f71942b));
        return bundle;
    }
}
