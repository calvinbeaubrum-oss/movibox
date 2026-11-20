package androidx.media3.common;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Arrays;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class n0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f9327f = u0.E0(0);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f9328g = u0.E0(1);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Deprecated
    public static final i<n0> f9329h = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9332c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final y[] f9333d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f9334e;

    public n0(String str, y... yVarArr) {
        z3.a.a(yVarArr.length > 0);
        this.f9331b = str;
        this.f9333d = yVarArr;
        this.f9330a = yVarArr.length;
        int iK = f0.k(yVarArr[0].f9501m);
        this.f9332c = iK == -1 ? f0.k(yVarArr[0].f9500l) : iK;
        f();
    }

    public n0(y... yVarArr) {
        this("", yVarArr);
    }

    public static void c(String str, @Nullable String str2, @Nullable String str3, int i11) {
        z3.o.d("TrackGroup", "", new IllegalStateException("Different " + str + " combined in one TrackGroup: '" + str2 + "' (track 0) and '" + str3 + "' (track " + i11 + ")"));
    }

    public static String d(@Nullable String str) {
        return (str == null || str.equals(C.LANGUAGE_UNDETERMINED)) ? "" : str;
    }

    public static int e(int i11) {
        return i11 | 16384;
    }

    public y a(int i11) {
        return this.f9333d[i11];
    }

    public int b(y yVar) {
        int i11 = 0;
        while (true) {
            y[] yVarArr = this.f9333d;
            if (i11 >= yVarArr.length) {
                return -1;
            }
            if (yVar == yVarArr[i11]) {
                return i11;
            }
            i11++;
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n0.class != obj.getClass()) {
            return false;
        }
        n0 n0Var = (n0) obj;
        return this.f9331b.equals(n0Var.f9331b) && Arrays.equals(this.f9333d, n0Var.f9333d);
    }

    public final void f() {
        String strD = d(this.f9333d[0].f9492d);
        int iE = e(this.f9333d[0].f9494f);
        int i11 = 1;
        while (true) {
            y[] yVarArr = this.f9333d;
            if (i11 >= yVarArr.length) {
                return;
            }
            if (!strD.equals(d(yVarArr[i11].f9492d))) {
                y[] yVarArr2 = this.f9333d;
                c("languages", yVarArr2[0].f9492d, yVarArr2[i11].f9492d, i11);
                return;
            } else {
                if (iE != e(this.f9333d[i11].f9494f)) {
                    c("role flags", Integer.toBinaryString(this.f9333d[0].f9494f), Integer.toBinaryString(this.f9333d[i11].f9494f), i11);
                    return;
                }
                i11++;
            }
        }
    }

    public int hashCode() {
        if (this.f9334e == 0) {
            this.f9334e = ((527 + this.f9331b.hashCode()) * 31) + Arrays.hashCode(this.f9333d);
        }
        return this.f9334e;
    }
}
