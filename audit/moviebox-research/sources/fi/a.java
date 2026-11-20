package fi;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.j3;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.util.o0;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.e0;
import com.google.common.collect.h0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import nh.i0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class a extends c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.e f64928h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f64929i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f64930j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f64931k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f64932l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f64933m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float f64934n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final float f64935o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ImmutableList<C0673a> f64936p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.e f64937q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f64938r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f64939s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f64940t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f64941u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Nullable
    public ph.n f64942v;

    /* JADX INFO: renamed from: fi.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0673a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f64943a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f64944b;

        public C0673a(long j11, long j12) {
            this.f64943a = j11;
            this.f64944b = j12;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0673a)) {
                return false;
            }
            C0673a c0673a = (C0673a) obj;
            return this.f64943a == c0673a.f64943a && this.f64944b == c0673a.f64944b;
        }

        public int hashCode() {
            return (((int) this.f64943a) * 31) + ((int) this.f64944b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b implements s.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f64945a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f64946b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f64947c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f64948d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f64949e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final float f64950f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final float f64951g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final com.google.android.exoplayer2.util.e f64952h;

        public b() {
            this(10000, 25000, 25000, 0.7f);
        }

        public b(int i11, int i12, int i13, float f11) {
            this(i11, i12, i13, 1279, 719, f11, 0.75f, com.google.android.exoplayer2.util.e.f35556a);
        }

        public b(int i11, int i12, int i13, int i14, int i15, float f11, float f12, com.google.android.exoplayer2.util.e eVar) {
            this.f64945a = i11;
            this.f64946b = i12;
            this.f64947c = i13;
            this.f64948d = i14;
            this.f64949e = i15;
            this.f64950f = f11;
            this.f64951g = f12;
            this.f64952h = eVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // fi.s.b
        public final s[] a(s.a[] aVarArr, com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.source.i.b bVar, j3 j3Var) {
            ImmutableList immutableListN = a.n(aVarArr);
            s[] sVarArr = new s[aVarArr.length];
            for (int i11 = 0; i11 < aVarArr.length; i11++) {
                s.a aVar = aVarArr[i11];
                if (aVar != null) {
                    int[] iArr = aVar.f65042b;
                    if (iArr.length != 0) {
                        sVarArr[i11] = iArr.length == 1 ? new t(aVar.f65041a, iArr[0], aVar.f65043c) : b(aVar.f65041a, iArr, aVar.f65043c, eVar, (ImmutableList) immutableListN.get(i11));
                    }
                }
            }
            return sVarArr;
        }

        public a b(i0 i0Var, int[] iArr, int i11, com.google.android.exoplayer2.upstream.e eVar, ImmutableList<C0673a> immutableList) {
            return new a(i0Var, iArr, i11, eVar, this.f64945a, this.f64946b, this.f64947c, this.f64948d, this.f64949e, this.f64950f, this.f64951g, immutableList, this.f64952h);
        }
    }

    public a(i0 i0Var, int[] iArr, int i11, com.google.android.exoplayer2.upstream.e eVar, long j11, long j12, long j13, int i12, int i13, float f11, float f12, List<C0673a> list, com.google.android.exoplayer2.util.e eVar2) {
        long j14;
        super(i0Var, iArr, i11);
        if (j13 < j11) {
            com.google.android.exoplayer2.util.s.i("AdaptiveTrackSelection", "Adjusting minDurationToRetainAfterDiscardMs to be at least minDurationForQualityIncreaseMs");
            j14 = j11;
        } else {
            j14 = j13;
        }
        this.f64928h = eVar;
        this.f64929i = j11 * 1000;
        this.f64930j = j12 * 1000;
        this.f64931k = j14 * 1000;
        this.f64932l = i12;
        this.f64933m = i13;
        this.f64934n = f11;
        this.f64935o = f12;
        this.f64936p = ImmutableList.copyOf((Collection) list);
        this.f64937q = eVar2;
        this.f64938r = 1.0f;
        this.f64940t = 0;
        this.f64941u = C.TIME_UNSET;
    }

    public static void k(List<ImmutableList.a<C0673a>> list, long[] jArr) {
        long j11 = 0;
        for (long j12 : jArr) {
            j11 += j12;
        }
        for (int i11 = 0; i11 < list.size(); i11++) {
            ImmutableList.a<C0673a> aVar = list.get(i11);
            if (aVar != null) {
                aVar.a(new C0673a(j11, jArr[i11]));
            }
        }
    }

    public static ImmutableList<ImmutableList<C0673a>> n(s.a[] aVarArr) {
        ArrayList arrayList = new ArrayList();
        for (s.a aVar : aVarArr) {
            if (aVar == null || aVar.f65042b.length <= 1) {
                arrayList.add(null);
            } else {
                ImmutableList.a aVarBuilder = ImmutableList.builder();
                aVarBuilder.a(new C0673a(0L, 0L));
                arrayList.add(aVarBuilder);
            }
        }
        long[][] jArrS = s(aVarArr);
        int[] iArr = new int[jArrS.length];
        long[] jArr = new long[jArrS.length];
        for (int i11 = 0; i11 < jArrS.length; i11++) {
            long[] jArr2 = jArrS[i11];
            jArr[i11] = jArr2.length == 0 ? 0L : jArr2[0];
        }
        k(arrayList, jArr);
        ImmutableList<Integer> immutableListT = t(jArrS);
        for (int i12 = 0; i12 < immutableListT.size(); i12++) {
            int iIntValue = immutableListT.get(i12).intValue();
            int i13 = iArr[iIntValue] + 1;
            iArr[iIntValue] = i13;
            jArr[iIntValue] = jArrS[iIntValue][i13];
            k(arrayList, jArr);
        }
        for (int i14 = 0; i14 < aVarArr.length; i14++) {
            if (arrayList.get(i14) != null) {
                jArr[i14] = jArr[i14] * 2;
            }
        }
        k(arrayList, jArr);
        ImmutableList.a aVarBuilder2 = ImmutableList.builder();
        for (int i15 = 0; i15 < arrayList.size(); i15++) {
            ImmutableList.a aVar2 = (ImmutableList.a) arrayList.get(i15);
            aVarBuilder2.a(aVar2 == null ? ImmutableList.of() : aVar2.m());
        }
        return aVarBuilder2.m();
    }

    public static long[][] s(s.a[] aVarArr) {
        long[][] jArr = new long[aVarArr.length][];
        for (int i11 = 0; i11 < aVarArr.length; i11++) {
            s.a aVar = aVarArr[i11];
            if (aVar == null) {
                jArr[i11] = new long[0];
            } else {
                jArr[i11] = new long[aVar.f65042b.length];
                int i12 = 0;
                while (true) {
                    int[] iArr = aVar.f65042b;
                    if (i12 >= iArr.length) {
                        break;
                    }
                    jArr[i11][i12] = aVar.f65041a.c(iArr[i12]).f33441i;
                    i12++;
                }
                Arrays.sort(jArr[i11]);
            }
        }
        return jArr;
    }

    public static ImmutableList<Integer> t(long[][] jArr) {
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

    @Override // fi.s
    public void d(long j11, long j12, long j13, List<? extends ph.n> list, ph.o[] oVarArr) {
        long jElapsedRealtime = this.f64937q.elapsedRealtime();
        long jR = r(oVarArr, list);
        int i11 = this.f64940t;
        if (i11 == 0) {
            this.f64940t = 1;
            this.f64939s = m(jElapsedRealtime, jR);
            return;
        }
        int i12 = this.f64939s;
        int iG = list.isEmpty() ? -1 : g(((ph.n) e0.g(list)).f73809d);
        if (iG != -1) {
            i11 = ((ph.n) e0.g(list)).f73810e;
            i12 = iG;
        }
        int iM = m(jElapsedRealtime, jR);
        if (!e(i12, jElapsedRealtime)) {
            m1 format = getFormat(i12);
            m1 format2 = getFormat(iM);
            long jV = v(j13, jR);
            int i13 = format2.f33441i;
            int i14 = format.f33441i;
            if ((i13 > i14 && j12 < jV) || (i13 < i14 && j12 >= this.f64930j)) {
                iM = i12;
            }
        }
        if (iM != i12) {
            i11 = 3;
        }
        this.f64940t = i11;
        this.f64939s = iM;
    }

    @Override // fi.c, fi.s
    @CallSuper
    public void disable() {
        this.f64942v = null;
    }

    @Override // fi.c, fi.s
    @CallSuper
    public void enable() {
        this.f64941u = C.TIME_UNSET;
        this.f64942v = null;
    }

    @Override // fi.c, fi.s
    public int evaluateQueueSize(long j11, List<? extends ph.n> list) {
        int i11;
        int i12;
        long jElapsedRealtime = this.f64937q.elapsedRealtime();
        if (!w(jElapsedRealtime, list)) {
            return list.size();
        }
        this.f64941u = jElapsedRealtime;
        this.f64942v = list.isEmpty() ? null : (ph.n) e0.g(list);
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        long jF0 = o0.f0(list.get(size - 1).f73812g - j11, this.f64938r);
        long jQ = q();
        if (jF0 < jQ) {
            return size;
        }
        m1 format = getFormat(m(jElapsedRealtime, p(list)));
        for (int i13 = 0; i13 < size; i13++) {
            ph.n nVar = list.get(i13);
            m1 m1Var = nVar.f73809d;
            if (o0.f0(nVar.f73812g - j11, this.f64938r) >= jQ && m1Var.f33441i < format.f33441i && (i11 = m1Var.f33451s) != -1 && i11 <= this.f64933m && (i12 = m1Var.f33450r) != -1 && i12 <= this.f64932l && i11 < format.f33451s) {
                return i13;
            }
        }
        return size;
    }

    @Override // fi.s
    public int getSelectedIndex() {
        return this.f64939s;
    }

    @Override // fi.s
    @Nullable
    public Object getSelectionData() {
        return null;
    }

    @Override // fi.s
    public int getSelectionReason() {
        return this.f64940t;
    }

    public boolean l(m1 m1Var, int i11, long j11) {
        return ((long) i11) <= j11;
    }

    public final int m(long j11, long j12) {
        long jO = o(j12);
        int i11 = 0;
        for (int i12 = 0; i12 < this.f64956b; i12++) {
            if (j11 == Long.MIN_VALUE || !e(i12, j11)) {
                m1 format = getFormat(i12);
                if (l(format, format.f33441i, jO)) {
                    return i12;
                }
                i11 = i12;
            }
        }
        return i11;
    }

    public final long o(long j11) {
        long jU = u(j11);
        if (this.f64936p.isEmpty()) {
            return jU;
        }
        int i11 = 1;
        while (i11 < this.f64936p.size() - 1 && this.f64936p.get(i11).f64943a < jU) {
            i11++;
        }
        C0673a c0673a = this.f64936p.get(i11 - 1);
        C0673a c0673a2 = this.f64936p.get(i11);
        long j12 = c0673a.f64943a;
        float f11 = (jU - j12) / (c0673a2.f64943a - j12);
        long j13 = c0673a.f64944b;
        return j13 + ((long) (f11 * (c0673a2.f64944b - j13)));
    }

    @Override // fi.c, fi.s
    public void onPlaybackSpeed(float f11) {
        this.f64938r = f11;
    }

    public final long p(List<? extends ph.n> list) {
        if (list.isEmpty()) {
            return C.TIME_UNSET;
        }
        ph.n nVar = (ph.n) e0.g(list);
        long j11 = nVar.f73812g;
        if (j11 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        long j12 = nVar.f73813h;
        return j12 != C.TIME_UNSET ? j12 - j11 : C.TIME_UNSET;
    }

    public long q() {
        return this.f64931k;
    }

    public final long r(ph.o[] oVarArr, List<? extends ph.n> list) {
        int i11 = this.f64939s;
        if (i11 < oVarArr.length && oVarArr[i11].next()) {
            ph.o oVar = oVarArr[this.f64939s];
            return oVar.b() - oVar.a();
        }
        for (ph.o oVar2 : oVarArr) {
            if (oVar2.next()) {
                return oVar2.b() - oVar2.a();
            }
        }
        return p(list);
    }

    public final long u(long j11) {
        long bitrateEstimate = (long) (this.f64928h.getBitrateEstimate() * this.f64934n);
        long jA = this.f64928h.a();
        if (jA == C.TIME_UNSET || j11 == C.TIME_UNSET) {
            return (long) (bitrateEstimate / this.f64938r);
        }
        float f11 = j11;
        return (long) ((bitrateEstimate * Math.max((f11 / this.f64938r) - jA, 0.0f)) / f11);
    }

    public final long v(long j11, long j12) {
        if (j11 == C.TIME_UNSET) {
            return this.f64929i;
        }
        if (j12 != C.TIME_UNSET) {
            j11 -= j12;
        }
        return Math.min((long) (j11 * this.f64935o), this.f64929i);
    }

    public boolean w(long j11, List<? extends ph.n> list) {
        long j12 = this.f64941u;
        return j12 == C.TIME_UNSET || j11 - j12 >= 1000 || !(list.isEmpty() || ((ph.n) e0.g(list)).equals(this.f64942v));
    }
}
