package oh;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.g;
import com.google.android.exoplayer2.util.o0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class c implements g {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final c f72417h = new c(null, new a[0], 0, C.TIME_UNSET, 0);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f72418i = new a(0).j(0);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final g.a<c> f72419j = new g.a() { // from class: oh.a
        @Override // com.google.android.exoplayer2.g.a
        public final g a(Bundle bundle) {
            return c.b(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final Object f72420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f72421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f72422c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f72423d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f72424f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a[] f72425g;

    /* JADX INFO: compiled from: source.java */
    public static final class a implements g {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final g.a<a> f72426i = new g.a() { // from class: oh.b
            @Override // com.google.android.exoplayer2.g.a
            public final g a(Bundle bundle) {
                return c.a.d(bundle);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f72427a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f72428b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Uri[] f72429c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int[] f72430d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long[] f72431f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f72432g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f72433h;

        public a(long j11) {
            this(j11, -1, new int[0], new Uri[0], new long[0], 0L, false);
        }

        public a(long j11, int i11, int[] iArr, Uri[] uriArr, long[] jArr, long j12, boolean z11) {
            com.google.android.exoplayer2.util.a.a(iArr.length == uriArr.length);
            this.f72427a = j11;
            this.f72428b = i11;
            this.f72430d = iArr;
            this.f72429c = uriArr;
            this.f72431f = jArr;
            this.f72432g = j12;
            this.f72433h = z11;
        }

        @CheckResult
        public static long[] b(long[] jArr, int i11) {
            int length = jArr.length;
            int iMax = Math.max(i11, length);
            long[] jArrCopyOf = Arrays.copyOf(jArr, iMax);
            Arrays.fill(jArrCopyOf, length, iMax, C.TIME_UNSET);
            return jArrCopyOf;
        }

        @CheckResult
        public static int[] c(int[] iArr, int i11) {
            int length = iArr.length;
            int iMax = Math.max(i11, length);
            int[] iArrCopyOf = Arrays.copyOf(iArr, iMax);
            Arrays.fill(iArrCopyOf, length, iMax, 0);
            return iArrCopyOf;
        }

        public static a d(Bundle bundle) {
            long j11 = bundle.getLong(h(0));
            int i11 = bundle.getInt(h(1), -1);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(h(2));
            int[] intArray = bundle.getIntArray(h(3));
            long[] longArray = bundle.getLongArray(h(4));
            long j12 = bundle.getLong(h(5));
            boolean z11 = bundle.getBoolean(h(6));
            if (intArray == null) {
                intArray = new int[0];
            }
            return new a(j11, i11, intArray, parcelableArrayList == null ? new Uri[0] : (Uri[]) parcelableArrayList.toArray(new Uri[0]), longArray == null ? new long[0] : longArray, j12, z11);
        }

        private static String h(int i11) {
            return Integer.toString(i11, 36);
        }

        public int e() {
            return f(-1);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f72427a == aVar.f72427a && this.f72428b == aVar.f72428b && Arrays.equals(this.f72429c, aVar.f72429c) && Arrays.equals(this.f72430d, aVar.f72430d) && Arrays.equals(this.f72431f, aVar.f72431f) && this.f72432g == aVar.f72432g && this.f72433h == aVar.f72433h;
        }

        public int f(int i11) {
            int i12;
            int i13 = i11 + 1;
            while (true) {
                int[] iArr = this.f72430d;
                if (i13 >= iArr.length || this.f72433h || (i12 = iArr[i13]) == 0 || i12 == 1) {
                    break;
                }
                i13++;
            }
            return i13;
        }

        public boolean g() {
            if (this.f72428b == -1) {
                return true;
            }
            for (int i11 = 0; i11 < this.f72428b; i11++) {
                int i12 = this.f72430d[i11];
                if (i12 == 0 || i12 == 1) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            int i11 = this.f72428b * 31;
            long j11 = this.f72427a;
            int iHashCode = (((((((i11 + ((int) (j11 ^ (j11 >>> 32)))) * 31) + Arrays.hashCode(this.f72429c)) * 31) + Arrays.hashCode(this.f72430d)) * 31) + Arrays.hashCode(this.f72431f)) * 31;
            long j12 = this.f72432g;
            return ((iHashCode + ((int) (j12 ^ (j12 >>> 32)))) * 31) + (this.f72433h ? 1 : 0);
        }

        public boolean i() {
            return this.f72428b == -1 || e() < this.f72428b;
        }

        @CheckResult
        public a j(int i11) {
            int[] iArrC = c(this.f72430d, i11);
            long[] jArrB = b(this.f72431f, i11);
            return new a(this.f72427a, i11, iArrC, (Uri[]) Arrays.copyOf(this.f72429c, i11), jArrB, this.f72432g, this.f72433h);
        }

        @Override // com.google.android.exoplayer2.g
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putLong(h(0), this.f72427a);
            bundle.putInt(h(1), this.f72428b);
            bundle.putParcelableArrayList(h(2), new ArrayList<>(Arrays.asList(this.f72429c)));
            bundle.putIntArray(h(3), this.f72430d);
            bundle.putLongArray(h(4), this.f72431f);
            bundle.putLong(h(5), this.f72432g);
            bundle.putBoolean(h(6), this.f72433h);
            return bundle;
        }
    }

    public c(@Nullable Object obj, a[] aVarArr, long j11, long j12, int i11) {
        this.f72420a = obj;
        this.f72422c = j11;
        this.f72423d = j12;
        this.f72421b = aVarArr.length + i11;
        this.f72425g = aVarArr;
        this.f72424f = i11;
    }

    public static c b(Bundle bundle) {
        a[] aVarArr;
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(g(1));
        if (parcelableArrayList == null) {
            aVarArr = new a[0];
        } else {
            a[] aVarArr2 = new a[parcelableArrayList.size()];
            for (int i11 = 0; i11 < parcelableArrayList.size(); i11++) {
                aVarArr2[i11] = (a) a.f72426i.a((Bundle) parcelableArrayList.get(i11));
            }
            aVarArr = aVarArr2;
        }
        return new c(null, aVarArr, bundle.getLong(g(2), 0L), bundle.getLong(g(3), C.TIME_UNSET), bundle.getInt(g(4)));
    }

    private static String g(int i11) {
        return Integer.toString(i11, 36);
    }

    public a c(int i11) {
        int i12 = this.f72424f;
        return i11 < i12 ? f72418i : this.f72425g[i11 - i12];
    }

    public int d(long j11, long j12) {
        if (j11 == Long.MIN_VALUE) {
            return -1;
        }
        if (j12 != C.TIME_UNSET && j11 >= j12) {
            return -1;
        }
        int i11 = this.f72424f;
        while (i11 < this.f72421b && ((c(i11).f72427a != Long.MIN_VALUE && c(i11).f72427a <= j11) || !c(i11).i())) {
            i11++;
        }
        if (i11 < this.f72421b) {
            return i11;
        }
        return -1;
    }

    public int e(long j11, long j12) {
        int i11 = this.f72421b - 1;
        while (i11 >= 0 && f(j11, j12, i11)) {
            i11--;
        }
        if (i11 < 0 || !c(i11).g()) {
            return -1;
        }
        return i11;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return o0.c(this.f72420a, cVar.f72420a) && this.f72421b == cVar.f72421b && this.f72422c == cVar.f72422c && this.f72423d == cVar.f72423d && this.f72424f == cVar.f72424f && Arrays.equals(this.f72425g, cVar.f72425g);
    }

    public final boolean f(long j11, long j12, int i11) {
        if (j11 == Long.MIN_VALUE) {
            return false;
        }
        long j13 = c(i11).f72427a;
        if (j13 == Long.MIN_VALUE) {
            return j12 == C.TIME_UNSET || j11 < j12;
        }
        return j11 < j13;
    }

    public int hashCode() {
        int i11 = this.f72421b * 31;
        Object obj = this.f72420a;
        return ((((((((i11 + (obj == null ? 0 : obj.hashCode())) * 31) + ((int) this.f72422c)) * 31) + ((int) this.f72423d)) * 31) + this.f72424f) * 31) + Arrays.hashCode(this.f72425g);
    }

    @Override // com.google.android.exoplayer2.g
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        for (a aVar : this.f72425g) {
            arrayList.add(aVar.toBundle());
        }
        bundle.putParcelableArrayList(g(1), arrayList);
        bundle.putLong(g(2), this.f72422c);
        bundle.putLong(g(3), this.f72423d);
        bundle.putInt(g(4), this.f72424f);
        return bundle;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("AdPlaybackState(adsId=");
        sb2.append(this.f72420a);
        sb2.append(", adResumePositionUs=");
        sb2.append(this.f72422c);
        sb2.append(", adGroups=[");
        for (int i11 = 0; i11 < this.f72425g.length; i11++) {
            sb2.append("adGroup(timeUs=");
            sb2.append(this.f72425g[i11].f72427a);
            sb2.append(", ads=[");
            for (int i12 = 0; i12 < this.f72425g[i11].f72430d.length; i12++) {
                sb2.append("ad(state=");
                int i13 = this.f72425g[i11].f72430d[i12];
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
                sb2.append(this.f72425g[i11].f72431f[i12]);
                sb2.append(')');
                if (i12 < this.f72425g[i11].f72430d.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("])");
            if (i11 < this.f72425g.length - 1) {
                sb2.append(", ");
            }
        }
        sb2.append("])");
        return sb2.toString();
    }
}
