package androidx.media3.common;

import android.os.Bundle;
import androidx.annotation.Nullable;
import java.util.Arrays;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final k f9256h = new b().d(1).c(2).e(3).a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final k f9257i = new b().d(1).c(1).e(2).a();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f9258j = u0.E0(0);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f9259k = u0.E0(1);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f9260l = u0.E0(2);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f9261m = u0.E0(3);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f9262n = u0.E0(4);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f9263o = u0.E0(5);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Deprecated
    public static final i<k> f9264p = new androidx.media3.common.b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9267c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final byte[] f9268d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f9269e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f9270f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f9271g;

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f9272a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f9273b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f9274c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public byte[] f9275d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f9276e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f9277f;

        public b() {
            this.f9272a = -1;
            this.f9273b = -1;
            this.f9274c = -1;
            this.f9276e = -1;
            this.f9277f = -1;
        }

        public b(k kVar) {
            this.f9272a = kVar.f9265a;
            this.f9273b = kVar.f9266b;
            this.f9274c = kVar.f9267c;
            this.f9275d = kVar.f9268d;
            this.f9276e = kVar.f9269e;
            this.f9277f = kVar.f9270f;
        }

        public k a() {
            return new k(this.f9272a, this.f9273b, this.f9274c, this.f9275d, this.f9276e, this.f9277f);
        }

        public b b(int i11) {
            this.f9277f = i11;
            return this;
        }

        public b c(int i11) {
            this.f9273b = i11;
            return this;
        }

        public b d(int i11) {
            this.f9272a = i11;
            return this;
        }

        public b e(int i11) {
            this.f9274c = i11;
            return this;
        }

        public b f(@Nullable byte[] bArr) {
            this.f9275d = bArr;
            return this;
        }

        public b g(int i11) {
            this.f9276e = i11;
            return this;
        }
    }

    public k(int i11, int i12, int i13, @Nullable byte[] bArr, int i14, int i15) {
        this.f9265a = i11;
        this.f9266b = i12;
        this.f9267c = i13;
        this.f9268d = bArr;
        this.f9269e = i14;
        this.f9270f = i15;
    }

    public static String b(int i11) {
        if (i11 == -1) {
            return "NA";
        }
        return i11 + "bit Chroma";
    }

    public static String c(int i11) {
        if (i11 == -1) {
            return "Unset color range";
        }
        if (i11 != 1) {
            return i11 != 2 ? "Undefined color range" : "Limited range";
        }
        return "Full range";
    }

    public static String d(int i11) {
        if (i11 == -1) {
            return "Unset color space";
        }
        if (i11 == 6) {
            return "BT2020";
        }
        if (i11 != 1) {
            return i11 != 2 ? "Undefined color space" : "BT601";
        }
        return "BT709";
    }

    public static String e(int i11) {
        if (i11 == -1) {
            return "Unset color transfer";
        }
        if (i11 == 10) {
            return "Gamma 2.2";
        }
        if (i11 == 1) {
            return "Linear";
        }
        if (i11 == 2) {
            return "sRGB";
        }
        if (i11 == 3) {
            return "SDR SMPTE 170M";
        }
        if (i11 != 6) {
            return i11 != 7 ? "Undefined color transfer" : "HLG";
        }
        return "ST2084 PQ";
    }

    public static k f(Bundle bundle) {
        return new k(bundle.getInt(f9258j, -1), bundle.getInt(f9259k, -1), bundle.getInt(f9260l, -1), bundle.getByteArray(f9261m), bundle.getInt(f9262n, -1), bundle.getInt(f9263o, -1));
    }

    public static boolean i(@Nullable k kVar) {
        int i11;
        int i12;
        int i13;
        int i14;
        if (kVar == null) {
            return true;
        }
        int i15 = kVar.f9265a;
        return (i15 == -1 || i15 == 1 || i15 == 2) && ((i11 = kVar.f9266b) == -1 || i11 == 2) && (((i12 = kVar.f9267c) == -1 || i12 == 3) && kVar.f9268d == null && (((i13 = kVar.f9270f) == -1 || i13 == 8) && ((i14 = kVar.f9269e) == -1 || i14 == 8)));
    }

    public static boolean j(@Nullable k kVar) {
        int i11;
        return kVar != null && ((i11 = kVar.f9267c) == 7 || i11 == 6);
    }

    public static int l(int i11) {
        if (i11 == 1) {
            return 1;
        }
        if (i11 != 9) {
            return (i11 == 4 || i11 == 5 || i11 == 6 || i11 == 7) ? 2 : -1;
        }
        return 6;
    }

    public static int m(int i11) {
        if (i11 == 1) {
            return 3;
        }
        if (i11 == 4) {
            return 10;
        }
        if (i11 == 13) {
            return 2;
        }
        if (i11 == 16) {
            return 6;
        }
        if (i11 != 18) {
            return (i11 == 6 || i11 == 7) ? 3 : -1;
        }
        return 7;
    }

    public static String n(int i11) {
        if (i11 == -1) {
            return "NA";
        }
        return i11 + "bit Luma";
    }

    public b a() {
        return new b();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k.class != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        return this.f9265a == kVar.f9265a && this.f9266b == kVar.f9266b && this.f9267c == kVar.f9267c && Arrays.equals(this.f9268d, kVar.f9268d) && this.f9269e == kVar.f9269e && this.f9270f == kVar.f9270f;
    }

    public boolean g() {
        return (this.f9269e == -1 || this.f9270f == -1) ? false : true;
    }

    public boolean h() {
        return (this.f9265a == -1 || this.f9266b == -1 || this.f9267c == -1) ? false : true;
    }

    public int hashCode() {
        if (this.f9271g == 0) {
            this.f9271g = ((((((((((527 + this.f9265a) * 31) + this.f9266b) * 31) + this.f9267c) * 31) + Arrays.hashCode(this.f9268d)) * 31) + this.f9269e) * 31) + this.f9270f;
        }
        return this.f9271g;
    }

    public boolean k() {
        return g() || h();
    }

    public Bundle o() {
        Bundle bundle = new Bundle();
        bundle.putInt(f9258j, this.f9265a);
        bundle.putInt(f9259k, this.f9266b);
        bundle.putInt(f9260l, this.f9267c);
        bundle.putByteArray(f9261m, this.f9268d);
        bundle.putInt(f9262n, this.f9269e);
        bundle.putInt(f9263o, this.f9270f);
        return bundle;
    }

    public String p() {
        String str;
        String strG = h() ? u0.G("%s/%s/%s", d(this.f9265a), c(this.f9266b), e(this.f9267c)) : "NA/NA/NA";
        if (g()) {
            str = this.f9269e + "/" + this.f9270f;
        } else {
            str = "NA/NA";
        }
        return strG + "/" + str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("ColorInfo(");
        sb2.append(d(this.f9265a));
        sb2.append(", ");
        sb2.append(c(this.f9266b));
        sb2.append(", ");
        sb2.append(e(this.f9267c));
        sb2.append(", ");
        sb2.append(this.f9268d != null);
        sb2.append(", ");
        sb2.append(n(this.f9269e));
        sb2.append(", ");
        sb2.append(b(this.f9270f));
        sb2.append(")");
        return sb2.toString();
    }
}
