package com.applovin.impl;

import android.net.Uri;
import android.os.Bundle;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class u implements o2 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final u f23439h = new u(null, new a[0], 0, C.TIME_UNSET, 0);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final a f23440i = new a(0).c(0);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final o2.a f23441j = new o2.a() { // from class: com.applovin.impl.k60
        @Override // com.applovin.impl.o2.a
        public final o2 a(Bundle bundle) {
            return u.a(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f23442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f23443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f23444c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f23445d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f23446f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final a[] f23447g;

    /* JADX INFO: compiled from: source.java */
    public static final class a implements o2 {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final o2.a f23448i = new o2.a() { // from class: com.applovin.impl.l60
            @Override // com.applovin.impl.o2.a
            public final o2 a(Bundle bundle) {
                return u.a.a(bundle);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f23449a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f23450b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Uri[] f23451c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int[] f23452d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long[] f23453f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f23454g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f23455h;

        public a(long j11) {
            this(j11, -1, new int[0], new Uri[0], new long[0], 0L, false);
        }

        private a(long j11, int i11, int[] iArr, Uri[] uriArr, long[] jArr, long j12, boolean z11) {
            b1.a(iArr.length == uriArr.length);
            this.f23449a = j11;
            this.f23450b = i11;
            this.f23452d = iArr;
            this.f23451c = uriArr;
            this.f23453f = jArr;
            this.f23454g = j12;
            this.f23455h = z11;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static a a(Bundle bundle) {
            long j11 = bundle.getLong(b(0));
            int i11 = bundle.getInt(b(1), -1);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(b(2));
            int[] intArray = bundle.getIntArray(b(3));
            long[] longArray = bundle.getLongArray(b(4));
            long j12 = bundle.getLong(b(5));
            boolean z11 = bundle.getBoolean(b(6));
            if (intArray == null) {
                intArray = new int[0];
            }
            return new a(j11, i11, intArray, parcelableArrayList == null ? new Uri[0] : (Uri[]) parcelableArrayList.toArray(new Uri[0]), longArray == null ? new long[0] : longArray, j12, z11);
        }

        private static int[] a(int[] iArr, int i11) {
            int length = iArr.length;
            int iMax = Math.max(i11, length);
            int[] iArrCopyOf = Arrays.copyOf(iArr, iMax);
            Arrays.fill(iArrCopyOf, length, iMax, 0);
            return iArrCopyOf;
        }

        private static long[] a(long[] jArr, int i11) {
            int length = jArr.length;
            int iMax = Math.max(i11, length);
            long[] jArrCopyOf = Arrays.copyOf(jArr, iMax);
            Arrays.fill(jArrCopyOf, length, iMax, C.TIME_UNSET);
            return jArrCopyOf;
        }

        private static String b(int i11) {
            return Integer.toString(i11, 36);
        }

        public int a() {
            return a(-1);
        }

        public int a(int i11) {
            int i12;
            int i13 = i11 + 1;
            while (true) {
                int[] iArr = this.f23452d;
                if (i13 >= iArr.length || this.f23455h || (i12 = iArr[i13]) == 0 || i12 == 1) {
                    break;
                }
                i13++;
            }
            return i13;
        }

        public boolean b() {
            if (this.f23450b == -1) {
                return true;
            }
            for (int i11 = 0; i11 < this.f23450b; i11++) {
                int i12 = this.f23452d[i11];
                if (i12 == 0 || i12 == 1) {
                    return true;
                }
            }
            return false;
        }

        public a c(int i11) {
            int[] iArrA = a(this.f23452d, i11);
            long[] jArrA = a(this.f23453f, i11);
            return new a(this.f23449a, i11, iArrA, (Uri[]) Arrays.copyOf(this.f23451c, i11), jArrA, this.f23454g, this.f23455h);
        }

        public boolean c() {
            return this.f23450b == -1 || a() < this.f23450b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f23449a == aVar.f23449a && this.f23450b == aVar.f23450b && Arrays.equals(this.f23451c, aVar.f23451c) && Arrays.equals(this.f23452d, aVar.f23452d) && Arrays.equals(this.f23453f, aVar.f23453f) && this.f23454g == aVar.f23454g && this.f23455h == aVar.f23455h;
        }

        public int hashCode() {
            int i11 = this.f23450b * 31;
            long j11 = this.f23449a;
            int iHashCode = (((((((i11 + ((int) (j11 ^ (j11 >>> 32)))) * 31) + Arrays.hashCode(this.f23451c)) * 31) + Arrays.hashCode(this.f23452d)) * 31) + Arrays.hashCode(this.f23453f)) * 31;
            long j12 = this.f23454g;
            return ((iHashCode + ((int) (j12 ^ (j12 >>> 32)))) * 31) + (this.f23455h ? 1 : 0);
        }
    }

    private u(Object obj, a[] aVarArr, long j11, long j12, int i11) {
        this.f23442a = obj;
        this.f23444c = j11;
        this.f23445d = j12;
        this.f23443b = aVarArr.length + i11;
        this.f23447g = aVarArr;
        this.f23446f = i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static u a(Bundle bundle) {
        a[] aVarArr;
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(b(1));
        if (parcelableArrayList == null) {
            aVarArr = new a[0];
        } else {
            a[] aVarArr2 = new a[parcelableArrayList.size()];
            for (int i11 = 0; i11 < parcelableArrayList.size(); i11++) {
                aVarArr2[i11] = (a) a.f23448i.a((Bundle) parcelableArrayList.get(i11));
            }
            aVarArr = aVarArr2;
        }
        return new u(null, aVarArr, bundle.getLong(b(2), 0L), bundle.getLong(b(3), C.TIME_UNSET), bundle.getInt(b(4)));
    }

    private boolean a(long j11, long j12, int i11) {
        if (j11 == Long.MIN_VALUE) {
            return false;
        }
        long j13 = a(i11).f23449a;
        if (j13 == Long.MIN_VALUE) {
            return j12 == C.TIME_UNSET || j11 < j12;
        }
        return j11 < j13;
    }

    private static String b(int i11) {
        return Integer.toString(i11, 36);
    }

    public int a(long j11, long j12) {
        if (j11 == Long.MIN_VALUE) {
            return -1;
        }
        if (j12 != C.TIME_UNSET && j11 >= j12) {
            return -1;
        }
        int i11 = this.f23446f;
        while (i11 < this.f23443b && ((a(i11).f23449a != Long.MIN_VALUE && a(i11).f23449a <= j11) || !a(i11).c())) {
            i11++;
        }
        if (i11 < this.f23443b) {
            return i11;
        }
        return -1;
    }

    public a a(int i11) {
        int i12 = this.f23446f;
        return i11 < i12 ? f23440i : this.f23447g[i11 - i12];
    }

    public int b(long j11, long j12) {
        int i11 = this.f23443b - 1;
        while (i11 >= 0 && a(j11, j12, i11)) {
            i11--;
        }
        if (i11 < 0 || !a(i11).b()) {
            return -1;
        }
        return i11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || u.class != obj.getClass()) {
            return false;
        }
        u uVar = (u) obj;
        return xp.a(this.f23442a, uVar.f23442a) && this.f23443b == uVar.f23443b && this.f23444c == uVar.f23444c && this.f23445d == uVar.f23445d && this.f23446f == uVar.f23446f && Arrays.equals(this.f23447g, uVar.f23447g);
    }

    public int hashCode() {
        int i11 = this.f23443b * 31;
        Object obj = this.f23442a;
        return ((((((((i11 + (obj == null ? 0 : obj.hashCode())) * 31) + ((int) this.f23444c)) * 31) + ((int) this.f23445d)) * 31) + this.f23446f) * 31) + Arrays.hashCode(this.f23447g);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("AdPlaybackState(adsId=");
        sb2.append(this.f23442a);
        sb2.append(", adResumePositionUs=");
        sb2.append(this.f23444c);
        sb2.append(", adGroups=[");
        for (int i11 = 0; i11 < this.f23447g.length; i11++) {
            sb2.append("adGroup(timeUs=");
            sb2.append(this.f23447g[i11].f23449a);
            sb2.append(", ads=[");
            for (int i12 = 0; i12 < this.f23447g[i11].f23452d.length; i12++) {
                sb2.append("ad(state=");
                int i13 = this.f23447g[i11].f23452d[i12];
                if (i13 == 0) {
                    sb2.append('_');
                } else if (i13 == 1) {
                    sb2.append('R');
                } else if (i13 == 2) {
                    sb2.append('S');
                } else if (i13 == 3) {
                    sb2.append('P');
                } else if (i13 != 4) {
                    sb2.append('?');
                } else {
                    sb2.append('!');
                }
                sb2.append(", durationUs=");
                sb2.append(this.f23447g[i11].f23453f[i12]);
                sb2.append(')');
                if (i12 < this.f23447g[i11].f23452d.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("])");
            if (i11 < this.f23447g.length - 1) {
                sb2.append(", ");
            }
        }
        sb2.append("])");
        return sb2.toString();
    }
}
