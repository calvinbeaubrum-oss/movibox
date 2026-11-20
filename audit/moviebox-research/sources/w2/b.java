package w2;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<ConstraintWidget> f79147a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f79148b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public androidx.constraintlayout.core.widgets.d f79149c;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static int f79150k = 0;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static int f79151l = 1;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static int f79152m = 2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ConstraintWidget.DimensionBehaviour f79153a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ConstraintWidget.DimensionBehaviour f79154b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f79155c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f79156d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f79157e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f79158f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f79159g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f79160h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f79161i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f79162j;
    }

    /* JADX INFO: renamed from: w2.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public interface InterfaceC0880b {
        void a();

        void b(ConstraintWidget constraintWidget, a aVar);
    }

    public b(androidx.constraintlayout.core.widgets.d dVar) {
        this.f79149c = dVar;
    }

    public final boolean a(InterfaceC0880b interfaceC0880b, ConstraintWidget constraintWidget, int i11) {
        this.f79148b.f79153a = constraintWidget.C();
        this.f79148b.f79154b = constraintWidget.V();
        this.f79148b.f79155c = constraintWidget.Y();
        this.f79148b.f79156d = constraintWidget.z();
        a aVar = this.f79148b;
        aVar.f79161i = false;
        aVar.f79162j = i11;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = aVar.f79153a;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z11 = dimensionBehaviour == dimensionBehaviour2;
        boolean z12 = aVar.f79154b == dimensionBehaviour2;
        boolean z13 = z11 && constraintWidget.f6540f0 > 0.0f;
        boolean z14 = z12 && constraintWidget.f6540f0 > 0.0f;
        if (z13 && constraintWidget.f6577y[0] == 4) {
            aVar.f79153a = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (z14 && constraintWidget.f6577y[1] == 4) {
            aVar.f79154b = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        interfaceC0880b.b(constraintWidget, aVar);
        constraintWidget.o1(this.f79148b.f79157e);
        constraintWidget.P0(this.f79148b.f79158f);
        constraintWidget.O0(this.f79148b.f79160h);
        constraintWidget.E0(this.f79148b.f79159g);
        a aVar2 = this.f79148b;
        aVar2.f79162j = a.f79150k;
        return aVar2.f79161i;
    }

    /* JADX WARN: Code duplicated, block: B:60:0x009c  */
    /* JADX WARN: Code duplicated, block: B:71:0x00a1 A[SYNTHETIC] */
    public final void b(androidx.constraintlayout.core.widgets.d dVar) {
        androidx.constraintlayout.core.widgets.analyzer.c cVar;
        androidx.constraintlayout.core.widgets.analyzer.d dVar2;
        int size = dVar.V0.size();
        boolean zY1 = dVar.Y1(64);
        InterfaceC0880b interfaceC0880bN1 = dVar.N1();
        for (int i11 = 0; i11 < size; i11++) {
            ConstraintWidget constraintWidget = dVar.V0.get(i11);
            if (!(constraintWidget instanceof androidx.constraintlayout.core.widgets.f) && !(constraintWidget instanceof androidx.constraintlayout.core.widgets.a) && !constraintWidget.n0() && (!zY1 || (cVar = constraintWidget.f6537e) == null || (dVar2 = constraintWidget.f6539f) == null || !cVar.f6600e.f6593j || !dVar2.f6600e.f6593j)) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviourW = constraintWidget.w(0);
                ConstraintWidget.DimensionBehaviour dimensionBehaviourW2 = constraintWidget.w(1);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                boolean z11 = dimensionBehaviourW == dimensionBehaviour && constraintWidget.f6573w != 1 && dimensionBehaviourW2 == dimensionBehaviour && constraintWidget.f6575x != 1;
                if (!z11 && dVar.Y1(1) && !(constraintWidget instanceof androidx.constraintlayout.core.widgets.i)) {
                    if (dimensionBehaviourW == dimensionBehaviour && constraintWidget.f6573w == 0 && dimensionBehaviourW2 != dimensionBehaviour && !constraintWidget.k0()) {
                        z11 = true;
                    }
                    boolean z12 = (dimensionBehaviourW2 != dimensionBehaviour || constraintWidget.f6575x != 0 || dimensionBehaviourW == dimensionBehaviour || constraintWidget.k0()) ? z11 : true;
                    if ((dimensionBehaviourW != dimensionBehaviour && dimensionBehaviourW2 != dimensionBehaviour) || constraintWidget.f6540f0 <= 0.0f) {
                        z11 = z12;
                        if (z11) {
                            a(interfaceC0880bN1, constraintWidget, a.f79150k);
                        }
                    }
                } else if (z11) {
                    a(interfaceC0880bN1, constraintWidget, a.f79150k);
                }
            }
        }
        interfaceC0880bN1.a();
    }

    public final void c(androidx.constraintlayout.core.widgets.d dVar, String str, int i11, int i12, int i13) {
        int iK = dVar.K();
        int iJ = dVar.J();
        dVar.e1(0);
        dVar.d1(0);
        dVar.o1(i12);
        dVar.P0(i13);
        dVar.e1(iK);
        dVar.d1(iJ);
        this.f79149c.c2(i11);
        this.f79149c.w1();
    }

    public long d(androidx.constraintlayout.core.widgets.d dVar, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19) {
        boolean zL1;
        int i21;
        int i22;
        boolean z11;
        int i23;
        boolean z12;
        b bVar = this;
        InterfaceC0880b interfaceC0880bN1 = dVar.N1();
        int size = dVar.V0.size();
        int iY = dVar.Y();
        int iZ = dVar.z();
        boolean zB = androidx.constraintlayout.core.widgets.g.b(i11, 128);
        boolean z13 = zB || androidx.constraintlayout.core.widgets.g.b(i11, 64);
        if (z13) {
            for (int i24 = 0; i24 < size; i24++) {
                ConstraintWidget constraintWidget = dVar.V0.get(i24);
                ConstraintWidget.DimensionBehaviour dimensionBehaviourC = constraintWidget.C();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                boolean z14 = (dimensionBehaviourC == dimensionBehaviour) && (constraintWidget.V() == dimensionBehaviour) && constraintWidget.x() > 0.0f;
                if ((constraintWidget.k0() && z14) || ((constraintWidget.m0() && z14) || (constraintWidget instanceof androidx.constraintlayout.core.widgets.i) || constraintWidget.k0() || constraintWidget.m0())) {
                    z13 = false;
                    break;
                }
            }
        }
        if (z13) {
            boolean z15 = androidx.constraintlayout.core.d.f6346r;
        }
        boolean z16 = z13 & ((i14 == 1073741824 && i16 == 1073741824) || zB);
        if (z16) {
            int iMin = Math.min(dVar.I(), i15);
            int iMin2 = Math.min(dVar.H(), i17);
            if (i14 == 1073741824 && dVar.Y() != iMin) {
                dVar.o1(iMin);
                dVar.R1();
            }
            if (i16 == 1073741824 && dVar.z() != iMin2) {
                dVar.P0(iMin2);
                dVar.R1();
            }
            if (i14 == 1073741824 && i16 == 1073741824) {
                zL1 = dVar.J1(zB);
                i21 = 2;
            } else {
                boolean zK1 = dVar.K1(zB);
                if (i14 == 1073741824) {
                    zK1 &= dVar.L1(zB, 0);
                    i21 = 1;
                } else {
                    i21 = 0;
                }
                if (i16 == 1073741824) {
                    zL1 = dVar.L1(zB, 1) & zK1;
                    i21++;
                } else {
                    zL1 = zK1;
                }
            }
            if (zL1) {
                dVar.t1(i14 == 1073741824, i16 == 1073741824);
            }
        } else {
            zL1 = false;
            i21 = 0;
        }
        if (zL1 && i21 == 2) {
            return 0L;
        }
        int iO1 = dVar.O1();
        if (size > 0) {
            b(dVar);
        }
        e(dVar);
        int size2 = bVar.f79147a.size();
        if (size > 0) {
            c(dVar, "First pass", 0, iY, iZ);
        }
        if (size2 > 0) {
            ConstraintWidget.DimensionBehaviour dimensionBehaviourC2 = dVar.C();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            boolean z17 = dimensionBehaviourC2 == dimensionBehaviour2;
            boolean z18 = dVar.V() == dimensionBehaviour2;
            int iMax = Math.max(dVar.Y(), bVar.f79149c.K());
            int iMax2 = Math.max(dVar.z(), bVar.f79149c.J());
            int i25 = 0;
            boolean zJ1 = false;
            while (i25 < size2) {
                ConstraintWidget constraintWidget2 = bVar.f79147a.get(i25);
                if (constraintWidget2 instanceof androidx.constraintlayout.core.widgets.i) {
                    int iY2 = constraintWidget2.Y();
                    int iZ2 = constraintWidget2.z();
                    boolean zA = bVar.a(interfaceC0880bN1, constraintWidget2, a.f79151l) | zJ1;
                    int iY3 = constraintWidget2.Y();
                    int iZ3 = constraintWidget2.z();
                    if (iY3 != iY2) {
                        constraintWidget2.o1(iY3);
                        if (z17 && constraintWidget2.O() > iMax) {
                            iMax = Math.max(iMax, constraintWidget2.O() + constraintWidget2.q(ConstraintAnchor.Type.RIGHT).f());
                        }
                        z12 = true;
                    } else {
                        z12 = zA;
                    }
                    if (iZ3 != iZ2) {
                        constraintWidget2.P0(iZ3);
                        if (z18 && constraintWidget2.t() > iMax2) {
                            iMax2 = Math.max(iMax2, constraintWidget2.t() + constraintWidget2.q(ConstraintAnchor.Type.BOTTOM).f());
                        }
                        z12 = true;
                    }
                    zJ1 = z12 | ((androidx.constraintlayout.core.widgets.i) constraintWidget2).J1();
                }
                i25++;
                iO1 = iO1;
            }
            int i26 = iO1;
            int i27 = 2;
            int i28 = 0;
            while (i28 < i27) {
                int i29 = 0;
                while (i29 < size2) {
                    ConstraintWidget constraintWidget3 = bVar.f79147a.get(i29);
                    if (((constraintWidget3 instanceof v2.a) && !(constraintWidget3 instanceof androidx.constraintlayout.core.widgets.i)) || (constraintWidget3 instanceof androidx.constraintlayout.core.widgets.f) || constraintWidget3.X() == 8 || ((z16 && constraintWidget3.f6537e.f6600e.f6593j && constraintWidget3.f6539f.f6600e.f6593j) || (constraintWidget3 instanceof androidx.constraintlayout.core.widgets.i))) {
                        z11 = z16;
                        i23 = size2;
                    } else {
                        int iY4 = constraintWidget3.Y();
                        int iZ4 = constraintWidget3.z();
                        z11 = z16;
                        int iR = constraintWidget3.r();
                        int i31 = a.f79151l;
                        i23 = size2;
                        if (i28 == 1) {
                            i31 = a.f79152m;
                        }
                        boolean zA2 = bVar.a(interfaceC0880bN1, constraintWidget3, i31) | zJ1;
                        int iY5 = constraintWidget3.Y();
                        int iZ5 = constraintWidget3.z();
                        if (iY5 != iY4) {
                            constraintWidget3.o1(iY5);
                            if (z17 && constraintWidget3.O() > iMax) {
                                iMax = Math.max(iMax, constraintWidget3.O() + constraintWidget3.q(ConstraintAnchor.Type.RIGHT).f());
                            }
                            zA2 = true;
                        }
                        if (iZ5 != iZ4) {
                            constraintWidget3.P0(iZ5);
                            if (z18 && constraintWidget3.t() > iMax2) {
                                iMax2 = Math.max(iMax2, constraintWidget3.t() + constraintWidget3.q(ConstraintAnchor.Type.BOTTOM).f());
                            }
                            zA2 = true;
                        }
                        zJ1 = (!constraintWidget3.b0() || iR == constraintWidget3.r()) ? zA2 : true;
                    }
                    i29++;
                    bVar = this;
                    z16 = z11;
                    size2 = i23;
                }
                boolean z19 = z16;
                int i32 = size2;
                if (!zJ1) {
                    break;
                }
                i28++;
                c(dVar, "intermediate pass", i28, iY, iZ);
                bVar = this;
                z16 = z19;
                size2 = i32;
                i27 = 2;
                zJ1 = false;
            }
            i22 = i26;
        } else {
            i22 = iO1;
        }
        dVar.b2(i22);
        return 0L;
    }

    public void e(androidx.constraintlayout.core.widgets.d dVar) {
        this.f79147a.clear();
        int size = dVar.V0.size();
        for (int i11 = 0; i11 < size; i11++) {
            ConstraintWidget constraintWidget = dVar.V0.get(i11);
            ConstraintWidget.DimensionBehaviour dimensionBehaviourC = constraintWidget.C();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (dimensionBehaviourC == dimensionBehaviour || constraintWidget.V() == dimensionBehaviour) {
                this.f79147a.add(constraintWidget);
            }
        }
        dVar.R1();
    }
}
