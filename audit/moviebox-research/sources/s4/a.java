package s4;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.media3.common.m0;
import androidx.media3.common.n0;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.h0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class a extends c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final androidx.media3.exoplayer.upstream.e f75958h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f75959i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f75960j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f75961k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f75962l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f75963m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float f75964n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final float f75965o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ImmutableList<C0837a> f75966p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final z3.d f75967q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f75968r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f75969s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f75970t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f75971u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Nullable
    public q4.m f75972v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f75973w;

    /* JADX INFO: renamed from: s4.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0837a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f75974a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f75975b;

        public C0837a(long j11, long j12) {
            this.f75974a = j11;
            this.f75975b = j12;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0837a)) {
                return false;
            }
            C0837a c0837a = (C0837a) obj;
            return this.f75974a == c0837a.f75974a && this.f75975b == c0837a.f75975b;
        }

        public int hashCode() {
            return (((int) this.f75974a) * 31) + ((int) this.f75975b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b implements z.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f75976a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f75977b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f75978c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f75979d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f75980e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final float f75981f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final float f75982g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final z3.d f75983h;

        public b() {
            this(10000, 25000, 25000, 0.7f);
        }

        public b(int i11, int i12, int i13, float f11) {
            this(i11, i12, i13, 1279, 719, f11, 0.75f, z3.d.f81767a);
        }

        public b(int i11, int i12, int i13, int i14, int i15, float f11, float f12, z3.d dVar) {
            this.f75976a = i11;
            this.f75977b = i12;
            this.f75978c = i13;
            this.f75979d = i14;
            this.f75980e = i15;
            this.f75981f = f11;
            this.f75982g = f12;
            this.f75983h = dVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // s4.z.b
        public final z[] a(z.a[] aVarArr, androidx.media3.exoplayer.upstream.e eVar, androidx.media3.exoplayer.source.l.b bVar, m0 m0Var) {
            ImmutableList immutableListO = a.o(aVarArr);
            z[] zVarArr = new z[aVarArr.length];
            for (int i11 = 0; i11 < aVarArr.length; i11++) {
                z.a aVar = aVarArr[i11];
                if (aVar != null) {
                    int[] iArr = aVar.f76108b;
                    if (iArr.length != 0) {
                        zVarArr[i11] = iArr.length == 1 ? new a0(aVar.f76107a, iArr[0], aVar.f76109c) : b(aVar.f76107a, iArr, aVar.f76109c, eVar, (ImmutableList) immutableListO.get(i11));
                    }
                }
            }
            return zVarArr;
        }

        public a b(n0 n0Var, int[] iArr, int i11, androidx.media3.exoplayer.upstream.e eVar, ImmutableList<C0837a> immutableList) {
            return new a(n0Var, iArr, i11, eVar, this.f75976a, this.f75977b, this.f75978c, this.f75979d, this.f75980e, this.f75981f, this.f75982g, immutableList, this.f75983h);
        }
    }

    public a(n0 n0Var, int[] iArr, int i11, androidx.media3.exoplayer.upstream.e eVar, long j11, long j12, long j13, int i12, int i13, float f11, float f12, List<C0837a> list, z3.d dVar) {
        long j14;
        super(n0Var, iArr, i11);
        if (j13 < j11) {
            z3.o.h("AdaptiveTrackSelection", "Adjusting minDurationToRetainAfterDiscardMs to be at least minDurationForQualityIncreaseMs");
            j14 = j11;
        } else {
            j14 = j13;
        }
        this.f75958h = eVar;
        this.f75959i = j11 * 1000;
        this.f75960j = j12 * 1000;
        this.f75961k = j14 * 1000;
        this.f75962l = i12;
        this.f75963m = i13;
        this.f75964n = f11;
        this.f75965o = f12;
        this.f75966p = ImmutableList.copyOf((Collection) list);
        this.f75967q = dVar;
        this.f75968r = 1.0f;
        this.f75970t = 0;
        this.f75971u = C.TIME_UNSET;
        this.f75973w = -2147483647L;
    }

    public static void l(List<ImmutableList.a<C0837a>> list, long[] jArr) {
        long j11 = 0;
        for (long j12 : jArr) {
            j11 += j12;
        }
        for (int i11 = 0; i11 < list.size(); i11++) {
            ImmutableList.a<C0837a> aVar = list.get(i11);
            if (aVar != null) {
                aVar.a(new C0837a(j11, jArr[i11]));
            }
        }
    }

    public static ImmutableList<ImmutableList<C0837a>> o(z.a[] aVarArr) {
        ArrayList arrayList = new ArrayList();
        for (z.a aVar : aVarArr) {
            if (aVar == null || aVar.f76108b.length <= 1) {
                arrayList.add(null);
            } else {
                ImmutableList.a aVarBuilder = ImmutableList.builder();
                aVarBuilder.a(new C0837a(0L, 0L));
                arrayList.add(aVarBuilder);
            }
        }
        long[][] jArrT = t(aVarArr);
        int[] iArr = new int[jArrT.length];
        long[] jArr = new long[jArrT.length];
        for (int i11 = 0; i11 < jArrT.length; i11++) {
            long[] jArr2 = jArrT[i11];
            jArr[i11] = jArr2.length == 0 ? 0L : jArr2[0];
        }
        l(arrayList, jArr);
        ImmutableList<Integer> immutableListU = u(jArrT);
        for (int i12 = 0; i12 < immutableListU.size(); i12++) {
            int iIntValue = immutableListU.get(i12).intValue();
            int i13 = iArr[iIntValue] + 1;
            iArr[iIntValue] = i13;
            jArr[iIntValue] = jArrT[iIntValue][i13];
            l(arrayList, jArr);
        }
        for (int i14 = 0; i14 < aVarArr.length; i14++) {
            if (arrayList.get(i14) != null) {
                jArr[i14] = jArr[i14] * 2;
            }
        }
        l(arrayList, jArr);
        ImmutableList.a aVarBuilder2 = ImmutableList.builder();
        for (int i15 = 0; i15 < arrayList.size(); i15++) {
            ImmutableList.a aVar2 = (ImmutableList.a) arrayList.get(i15);
            aVarBuilder2.a(aVar2 == null ? ImmutableList.of() : aVar2.m());
        }
        return aVarBuilder2.m();
    }

    public static long[][] t(z.a[] aVarArr) {
        long[][] jArr = new long[aVarArr.length][];
        for (int i11 = 0; i11 < aVarArr.length; i11++) {
            z.a aVar = aVarArr[i11];
            if (aVar == null) {
                jArr[i11] = new long[0];
            } else {
                jArr[i11] = new long[aVar.f76108b.length];
                int i12 = 0;
                while (true) {
                    int[] iArr = aVar.f76108b;
                    if (i12 >= iArr.length) {
                        break;
                    }
                    long j11 = aVar.f76107a.a(iArr[i12]).f9497i;
                    long[] jArr2 = jArr[i11];
                    if (j11 == -1) {
                        j11 = 0;
                    }
                    jArr2[i12] = j11;
                    i12++;
                }
                Arrays.sort(jArr[i11]);
            }
        }
        return jArr;
    }

    public static ImmutableList<Integer> u(long[][] jArr) {
        h0 h0VarE = MultimapBuilder.c().a().e();
        for (int i11 = 0; i11 < jArr.length; i11++) {
            long[] jArr2 = jArr[i11];
            if (jArr2.length > 1) {
                int length = jArr2.length;
                double[] dArr = new double[length];
                int i12 = 0;
                while (true) {
                    long[] jArr3 = jArr[i11];
                    double dLog = 0.0d;
                    if (i12 >= jArr3.length) {
                        break;
                    }
                    long j11 = jArr3[i12];
                    if (j11 != -1) {
                        dLog = Math.log(j11);
                    }
                    dArr[i12] = dLog;
                    i12++;
                }
                int i13 = length - 1;
                double d11 = dArr[i13] - dArr[0];
                int i14 = 0;
                while (i14 < i13) {
                    double d12 = dArr[i14];
                    i14++;
                    h0VarE.put(Double.valueOf(d11 == 0.0d ? 1.0d : (((d12 + dArr[i14]) * 0.5d) - dArr[0]) / d11), Integer.valueOf(i11));
                }
            }
        }
        return ImmutableList.copyOf(h0VarE.values());
    }

    @Override // s4.c, s4.z
    @CallSuper
    public void disable() {
        this.f75972v = null;
    }

    @Override // s4.c, s4.z
    @CallSuper
    public void enable() {
        this.f75971u = C.TIME_UNSET;
        this.f75972v = null;
    }

    @Override // s4.c, s4.z
    public int evaluateQueueSize(long j11, List<? extends q4.m> list) {
        int i11;
        int i12;
        long jElapsedRealtime = this.f75967q.elapsedRealtime();
        if (!x(jElapsedRealtime, list)) {
            return list.size();
        }
        this.f75971u = jElapsedRealtime;
        this.f75972v = list.isEmpty() ? null : (q4.m) com.google.common.collect.e0.g(list);
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        long jM0 = u0.m0(list.get(size - 1).f74328g - j11, this.f75968r);
        long jR = r();
        if (jM0 < jR) {
            return size;
        }
        androidx.media3.common.y format = getFormat(n(jElapsedRealtime, q(list)));
        for (int i13 = 0; i13 < size; i13++) {
            q4.m mVar = list.get(i13);
            androidx.media3.common.y yVar = mVar.f74325d;
            if (u0.m0(mVar.f74328g - j11, this.f75968r) >= jR && yVar.f9497i < format.f9497i && (i11 = yVar.f9507s) != -1 && i11 <= this.f75963m && (i12 = yVar.f9506r) != -1 && i12 <= this.f75962l && i11 < format.f9507s) {
                return i13;
            }
        }
        return size;
    }

    @Override // s4.z
    public int getSelectedIndex() {
        return this.f75969s;
    }

    @Override // s4.z
    @Nullable
    public Object getSelectionData() {
        return null;
    }

    @Override // s4.z
    public int getSelectionReason() {
        return this.f75970t;
    }

    @Override // s4.z
    public void h(long j11, long j12, long j13, List<? extends q4.m> list, q4.n[] nVarArr) {
        long jElapsedRealtime = this.f75967q.elapsedRealtime();
        long jS = s(nVarArr, list);
        int i11 = this.f75970t;
        if (i11 == 0) {
            this.f75970t = 1;
            this.f75969s = n(jElapsedRealtime, jS);
            return;
        }
        int i12 = this.f75969s;
        int iE = list.isEmpty() ? -1 : e(((q4.m) com.google.common.collect.e0.g(list)).f74325d);
        if (iE != -1) {
            i11 = ((q4.m) com.google.common.collect.e0.g(list)).f74326e;
            i12 = iE;
        }
        int iN = n(jElapsedRealtime, jS);
        if (iN != i12 && !d(i12, jElapsedRealtime)) {
            androidx.media3.common.y format = getFormat(i12);
            androidx.media3.common.y format2 = getFormat(iN);
            long jW = w(j13, jS);
            int i13 = format2.f9497i;
            int i14 = format.f9497i;
            if ((i13 > i14 && j12 < jW) || (i13 < i14 && j12 >= this.f75960j)) {
                iN = i12;
            }
        }
        if (iN != i12) {
            i11 = 3;
        }
        this.f75970t = i11;
        this.f75969s = iN;
    }

    public boolean m(androidx.media3.common.y yVar, int i11, long j11) {
        return ((long) i11) <= j11;
    }

    public final int n(long j11, long j12) {
        long jP = p(j12);
        int i11 = 0;
        for (int i12 = 0; i12 < this.f75995b; i12++) {
            if (j11 == Long.MIN_VALUE || !d(i12, j11)) {
                androidx.media3.common.y format = getFormat(i12);
                if (m(format, format.f9497i, jP)) {
                    return i12;
                }
                i11 = i12;
            }
        }
        return i11;
    }

    @Override // s4.c, s4.z
    public void onPlaybackSpeed(float f11) {
        this.f75968r = f11;
    }

    public final long p(long j11) {
        long jV = v(j11);
        if (this.f75966p.isEmpty()) {
            return jV;
        }
        int i11 = 1;
        while (i11 < this.f75966p.size() - 1 && this.f75966p.get(i11).f75974a < jV) {
            i11++;
        }
        C0837a c0837a = this.f75966p.get(i11 - 1);
        C0837a c0837a2 = this.f75966p.get(i11);
        long j12 = c0837a.f75974a;
        float f11 = (jV - j12) / (c0837a2.f75974a - j12);
        long j13 = c0837a.f75975b;
        return j13 + ((long) (f11 * (c0837a2.f75975b - j13)));
    }

    public final long q(List<? extends q4.m> list) {
        if (list.isEmpty()) {
            return C.TIME_UNSET;
        }
        q4.m mVar = (q4.m) com.google.common.collect.e0.g(list);
        long j11 = mVar.f74328g;
        if (j11 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        long j12 = mVar.f74329h;
        return j12 != C.TIME_UNSET ? j12 - j11 : C.TIME_UNSET;
    }

    public long r() {
        return this.f75961k;
    }

    public final long s(q4.n[] nVarArr, List<? extends q4.m> list) {
        int i11 = this.f75969s;
        if (i11 < nVarArr.length && nVarArr[i11].next()) {
            q4.n nVar = nVarArr[this.f75969s];
            return nVar.b() - nVar.a();
        }
        for (q4.n nVar2 : nVarArr) {
            if (nVar2.next()) {
                return nVar2.b() - nVar2.a();
            }
        }
        return q(list);
    }

    public final long v(long j11) {
        long bitrateEstimate = this.f75958h.getBitrateEstimate();
        this.f75973w = bitrateEstimate;
        long j12 = (long) (bitrateEstimate * this.f75964n);
        long jA = this.f75958h.a();
        if (jA == C.TIME_UNSET || j11 == C.TIME_UNSET) {
            return (long) (j12 / this.f75968r);
        }
        float f11 = j11;
        return (long) ((j12 * Math.max((f11 / this.f75968r) - jA, 0.0f)) / f11);
    }

    public final long w(long j11, long j12) {
        if (j11 == C.TIME_UNSET) {
            return this.f75959i;
        }
        if (j12 != C.TIME_UNSET) {
            j11 -= j12;
        }
        return Math.min((long) (j11 * this.f75965o), this.f75959i);
    }

    public boolean x(long j11, List<? extends q4.m> list) {
        long j12 = this.f75971u;
        return j12 == C.TIME_UNSET || j11 - j12 >= 1000 || !(list.isEmpty() || ((q4.m) com.google.common.collect.e0.g(list)).equals(this.f75972v));
    }
}
