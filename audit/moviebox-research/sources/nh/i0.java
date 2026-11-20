package nh;

import android.os.Bundle;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m1;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class i0 implements com.google.android.exoplayer2.g {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final com.google.android.exoplayer2.g.a<i0> f71930g = new com.google.android.exoplayer2.g.a() { // from class: nh.h0
        @Override // com.google.android.exoplayer2.g.a
        public final com.google.android.exoplayer2.g a(Bundle bundle) {
            return i0.f(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f71931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f71932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f71933c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m1[] f71934d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f71935f;

    public i0(String str, m1... m1VarArr) {
        com.google.android.exoplayer2.util.a.a(m1VarArr.length > 0);
        this.f71932b = str;
        this.f71934d = m1VarArr;
        this.f71931a = m1VarArr.length;
        int iK = com.google.android.exoplayer2.util.w.k(m1VarArr[0].f33445m);
        this.f71933c = iK == -1 ? com.google.android.exoplayer2.util.w.k(m1VarArr[0].f33444l) : iK;
        j();
    }

    public i0(m1... m1VarArr) {
        this("", m1VarArr);
    }

    private static String e(int i11) {
        return Integer.toString(i11, 36);
    }

    public static /* synthetic */ i0 f(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(e(0));
        return new i0(bundle.getString(e(1), ""), (m1[]) (parcelableArrayList == null ? ImmutableList.of() : com.google.android.exoplayer2.util.d.b(m1.I, parcelableArrayList)).toArray(new m1[0]));
    }

    public static void g(String str, @Nullable String str2, @Nullable String str3, int i11) {
        com.google.android.exoplayer2.util.s.d("TrackGroup", "", new IllegalStateException("Different " + str + " combined in one TrackGroup: '" + str2 + "' (track 0) and '" + str3 + "' (track " + i11 + ")"));
    }

    public static String h(@Nullable String str) {
        return (str == null || str.equals(C.LANGUAGE_UNDETERMINED)) ? "" : str;
    }

    public static int i(int i11) {
        return i11 | 16384;
    }

    @CheckResult
    public i0 b(String str) {
        return new i0(str, this.f71934d);
    }

    public m1 c(int i11) {
        return this.f71934d[i11];
    }

    public int d(m1 m1Var) {
        int i11 = 0;
        while (true) {
            m1[] m1VarArr = this.f71934d;
            if (i11 >= m1VarArr.length) {
                return -1;
            }
            if (m1Var == m1VarArr[i11]) {
                return i11;
            }
            i11++;
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i0.class != obj.getClass()) {
            return false;
        }
        i0 i0Var = (i0) obj;
        return this.f71932b.equals(i0Var.f71932b) && Arrays.equals(this.f71934d, i0Var.f71934d);
    }

    public int hashCode() {
        if (this.f71935f == 0) {
            this.f71935f = ((527 + this.f71932b.hashCode()) * 31) + Arrays.hashCode(this.f71934d);
        }
        return this.f71935f;
    }

    public final void j() {
        String strH = h(this.f71934d[0].f33436c);
        int i11 = i(this.f71934d[0].f33438f);
        int i12 = 1;
        while (true) {
            m1[] m1VarArr = this.f71934d;
            if (i12 >= m1VarArr.length) {
                return;
            }
            if (!strH.equals(h(m1VarArr[i12].f33436c))) {
                m1[] m1VarArr2 = this.f71934d;
                g("languages", m1VarArr2[0].f33436c, m1VarArr2[i12].f33436c, i12);
                return;
            } else {
                if (i11 != i(this.f71934d[i12].f33438f)) {
                    g("role flags", Integer.toBinaryString(this.f71934d[0].f33438f), Integer.toBinaryString(this.f71934d[i12].f33438f), i12);
                    return;
                }
                i12++;
            }
        }
    }

    @Override // com.google.android.exoplayer2.g
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(e(0), com.google.android.exoplayer2.util.d.d(Lists.l(this.f71934d)));
        bundle.putString(e(1), this.f71932b);
        return bundle;
    }
}
