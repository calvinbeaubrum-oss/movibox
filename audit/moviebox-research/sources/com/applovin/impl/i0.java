package com.applovin.impl;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class i0 extends f2 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final y1 f19558h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f19559i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final long f19560j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final long f19561k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final float f19562l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final float f19563m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final eb f19564n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final l3 f19565o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f19566p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f19567q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f19568r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f19569s;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f19570a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f19571b;

        public a(long j11, long j12) {
            this.f19570a = j11;
            this.f19571b = j12;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f19570a == aVar.f19570a && this.f19571b == aVar.f19571b;
        }

        public int hashCode() {
            return (((int) this.f19570a) * 31) + ((int) this.f19571b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b implements h8.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f19572a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f19573b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f19574c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f19575d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final float f19576e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final l3 f19577f;

        public b() {
            this(10000, 25000, 25000, 0.7f, 0.75f, l3.f20326a);
        }

        public b(int i11, int i12, int i13, float f11, float f12, l3 l3Var) {
            this.f19572a = i11;
            this.f19573b = i12;
            this.f19574c = i13;
            this.f19575d = f11;
            this.f19576e = f12;
            this.f19577f = l3Var;
        }

        public i0 a(oo ooVar, int[] iArr, int i11, y1 y1Var, eb ebVar) {
            return new i0(ooVar, iArr, i11, y1Var, this.f19572a, this.f19573b, this.f19574c, this.f19575d, this.f19576e, ebVar, this.f19577f);
        }

        @Override // com.applovin.impl.h8.b
        public final h8[] a(h8.a[] aVarArr, y1 y1Var, be.a aVar, fo foVar) {
            eb ebVarB = i0.b(aVarArr);
            h8[] h8VarArr = new h8[aVarArr.length];
            for (int i11 = 0; i11 < aVarArr.length; i11++) {
                h8.a aVar2 = aVarArr[i11];
                if (aVar2 != null) {
                    int[] iArr = aVar2.f19393b;
                    if (iArr.length != 0) {
                        h8VarArr[i11] = iArr.length == 1 ? new t8(aVar2.f19392a, iArr[0], aVar2.f19394c) : a(aVar2.f19392a, iArr, aVar2.f19394c, y1Var, (eb) ebVarB.get(i11));
                    }
                }
            }
            return h8VarArr;
        }
    }

    public i0(oo ooVar, int[] iArr, int i11, y1 y1Var, long j11, long j12, long j13, float f11, float f12, List list, l3 l3Var) {
        super(ooVar, iArr, i11);
        if (j13 < j11) {
            pc.d("AdaptiveTrackSelection", "Adjusting minDurationToRetainAfterDiscardMs to be at least minDurationForQualityIncreaseMs");
            j13 = j11;
        }
        this.f19558h = y1Var;
        this.f19559i = j11 * 1000;
        this.f19560j = j12 * 1000;
        this.f19561k = j13 * 1000;
        this.f19562l = f11;
        this.f19563m = f12;
        this.f19564n = eb.a((Collection) list);
        this.f19565o = l3Var;
        this.f19566p = 1.0f;
        this.f19568r = 0;
        this.f19569s = C.TIME_UNSET;
    }

    private static eb a(long[][] jArr) {
        fc fcVarB = wf.a().a().b();
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
                    fcVarB.put(Double.valueOf(d11 == 0.0d ? 1.0d : (((d12 + dArr[i14]) * 0.5d) - dArr[0]) / d11), Integer.valueOf(i11));
                }
            }
        }
        return eb.a(fcVarB.values());
    }

    private static void a(List list, long[] jArr) {
        long j11 = 0;
        for (long j12 : jArr) {
            j11 += j12;
        }
        for (int i11 = 0; i11 < list.size(); i11++) {
            eb.a aVar = (eb.a) list.get(i11);
            if (aVar != null) {
                aVar.b(new a(j11, jArr[i11]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static eb b(h8.a[] aVarArr) {
        ArrayList arrayList = new ArrayList();
        for (h8.a aVar : aVarArr) {
            if (aVar == null || aVar.f19393b.length <= 1) {
                arrayList.add(null);
            } else {
                eb.a aVarF = eb.f();
                aVarF.b(new a(0L, 0L));
                arrayList.add(aVarF);
            }
        }
        long[][] jArrC = c(aVarArr);
        int[] iArr = new int[jArrC.length];
        long[] jArr = new long[jArrC.length];
        for (int i11 = 0; i11 < jArrC.length; i11++) {
            long[] jArr2 = jArrC[i11];
            jArr[i11] = jArr2.length == 0 ? 0L : jArr2[0];
        }
        a(arrayList, jArr);
        eb ebVarA = a(jArrC);
        for (int i12 = 0; i12 < ebVarA.size(); i12++) {
            int iIntValue = ((Integer) ebVarA.get(i12)).intValue();
            int i13 = iArr[iIntValue] + 1;
            iArr[iIntValue] = i13;
            jArr[iIntValue] = jArrC[iIntValue][i13];
            a(arrayList, jArr);
        }
        for (int i14 = 0; i14 < aVarArr.length; i14++) {
            if (arrayList.get(i14) != null) {
                jArr[i14] = jArr[i14] * 2;
            }
        }
        a(arrayList, jArr);
        eb.a aVarF2 = eb.f();
        for (int i15 = 0; i15 < arrayList.size(); i15++) {
            eb.a aVar2 = (eb.a) arrayList.get(i15);
            aVarF2.b(aVar2 == null ? eb.h() : aVar2.a());
        }
        return aVarF2.a();
    }

    private static long[][] c(h8.a[] aVarArr) {
        long[][] jArr = new long[aVarArr.length][];
        for (int i11 = 0; i11 < aVarArr.length; i11++) {
            h8.a aVar = aVarArr[i11];
            if (aVar == null) {
                jArr[i11] = new long[0];
            } else {
                jArr[i11] = new long[aVar.f19393b.length];
                int i12 = 0;
                while (true) {
                    int[] iArr = aVar.f19393b;
                    if (i12 >= iArr.length) {
                        break;
                    }
                    jArr[i11][i12] = aVar.f19392a.a(iArr[i12]).f18896i;
                    i12++;
                }
                Arrays.sort(jArr[i11]);
            }
        }
        return jArr;
    }

    @Override // com.applovin.impl.f2, com.applovin.impl.h8
    public void a(float f11) {
        this.f19566p = f11;
    }

    @Override // com.applovin.impl.f2, com.applovin.impl.h8
    public void f() {
    }

    @Override // com.applovin.impl.h8
    public int h() {
        return this.f19567q;
    }

    @Override // com.applovin.impl.f2, com.applovin.impl.h8
    public void i() {
        this.f19569s = C.TIME_UNSET;
    }
}
