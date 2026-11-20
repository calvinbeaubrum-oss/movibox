package androidx.constraintlayout.core.widgets;

import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends i {
    public ConstraintWidget[] H1;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public int f6661k1 = -1;

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    public int f6662l1 = -1;

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    public int f6663m1 = -1;

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    public int f6664n1 = -1;

    /* JADX INFO: renamed from: o1, reason: collision with root package name */
    public int f6665o1 = -1;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public int f6666p1 = -1;

    /* JADX INFO: renamed from: q1, reason: collision with root package name */
    public float f6667q1 = 0.5f;

    /* JADX INFO: renamed from: r1, reason: collision with root package name */
    public float f6668r1 = 0.5f;

    /* JADX INFO: renamed from: s1, reason: collision with root package name */
    public float f6669s1 = 0.5f;

    /* JADX INFO: renamed from: t1, reason: collision with root package name */
    public float f6670t1 = 0.5f;

    /* JADX INFO: renamed from: u1, reason: collision with root package name */
    public float f6671u1 = 0.5f;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public float f6672v1 = 0.5f;

    /* JADX INFO: renamed from: w1, reason: collision with root package name */
    public int f6673w1 = 0;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public int f6674x1 = 0;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public int f6675y1 = 2;

    /* JADX INFO: renamed from: z1, reason: collision with root package name */
    public int f6676z1 = 2;
    public int A1 = 0;
    public int B1 = -1;
    public int C1 = 0;
    public ArrayList<a> D1 = new ArrayList<>();
    public ConstraintWidget[] E1 = null;
    public ConstraintWidget[] F1 = null;
    public int[] G1 = null;
    public int I1 = 0;

    /* JADX INFO: compiled from: source.java */
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6677a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ConstraintAnchor f6680d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ConstraintAnchor f6681e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ConstraintAnchor f6682f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public ConstraintAnchor f6683g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f6684h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f6685i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f6686j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f6687k;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f6693q;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ConstraintWidget f6678b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f6679c = 0;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f6688l = 0;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f6689m = 0;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f6690n = 0;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f6691o = 0;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f6692p = 0;

        public a(int i11, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i12) {
            this.f6684h = 0;
            this.f6685i = 0;
            this.f6686j = 0;
            this.f6687k = 0;
            this.f6693q = 0;
            this.f6677a = i11;
            this.f6680d = constraintAnchor;
            this.f6681e = constraintAnchor2;
            this.f6682f = constraintAnchor3;
            this.f6683g = constraintAnchor4;
            this.f6684h = e.this.D1();
            this.f6685i = e.this.F1();
            this.f6686j = e.this.E1();
            this.f6687k = e.this.C1();
            this.f6693q = i12;
        }

        public void b(ConstraintWidget constraintWidget) {
            if (this.f6677a == 0) {
                int iP2 = e.this.p2(constraintWidget, this.f6693q);
                if (constraintWidget.C() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.f6692p++;
                    iP2 = 0;
                }
                this.f6688l += iP2 + (constraintWidget.X() != 8 ? e.this.f6673w1 : 0);
                int iO2 = e.this.o2(constraintWidget, this.f6693q);
                if (this.f6678b == null || this.f6679c < iO2) {
                    this.f6678b = constraintWidget;
                    this.f6679c = iO2;
                    this.f6689m = iO2;
                }
            } else {
                int iP3 = e.this.p2(constraintWidget, this.f6693q);
                int iO3 = e.this.o2(constraintWidget, this.f6693q);
                if (constraintWidget.V() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.f6692p++;
                    iO3 = 0;
                }
                this.f6689m += iO3 + (constraintWidget.X() != 8 ? e.this.f6674x1 : 0);
                if (this.f6678b == null || this.f6679c < iP3) {
                    this.f6678b = constraintWidget;
                    this.f6679c = iP3;
                    this.f6688l = iP3;
                }
            }
            this.f6691o++;
        }

        public void c() {
            this.f6679c = 0;
            this.f6678b = null;
            this.f6688l = 0;
            this.f6689m = 0;
            this.f6690n = 0;
            this.f6691o = 0;
            this.f6692p = 0;
        }

        public void d(boolean z11, int i11, boolean z12) {
            ConstraintWidget constraintWidget;
            float f11;
            float f12;
            int i12 = this.f6691o;
            for (int i13 = 0; i13 < i12 && this.f6690n + i13 < e.this.I1; i13++) {
                ConstraintWidget constraintWidget2 = e.this.H1[this.f6690n + i13];
                if (constraintWidget2 != null) {
                    constraintWidget2.x0();
                }
            }
            if (i12 == 0 || this.f6678b == null) {
                return;
            }
            boolean z13 = z12 && i11 == 0;
            int i14 = -1;
            int i15 = -1;
            for (int i16 = 0; i16 < i12; i16++) {
                int i17 = z11 ? (i12 - 1) - i16 : i16;
                if (this.f6690n + i17 >= e.this.I1) {
                    break;
                }
                ConstraintWidget constraintWidget3 = e.this.H1[this.f6690n + i17];
                if (constraintWidget3 != null && constraintWidget3.X() == 0) {
                    if (i14 == -1) {
                        i14 = i16;
                    }
                    i15 = i16;
                }
            }
            ConstraintWidget constraintWidget4 = null;
            if (this.f6677a != 0) {
                ConstraintWidget constraintWidget5 = this.f6678b;
                constraintWidget5.R0(e.this.f6661k1);
                int i18 = this.f6684h;
                if (i11 > 0) {
                    i18 += e.this.f6673w1;
                }
                if (z11) {
                    constraintWidget5.S.a(this.f6682f, i18);
                    if (z12) {
                        constraintWidget5.Q.a(this.f6680d, this.f6686j);
                    }
                    if (i11 > 0) {
                        this.f6682f.f6522d.Q.a(constraintWidget5.S, 0);
                    }
                } else {
                    constraintWidget5.Q.a(this.f6680d, i18);
                    if (z12) {
                        constraintWidget5.S.a(this.f6682f, this.f6686j);
                    }
                    if (i11 > 0) {
                        this.f6680d.f6522d.S.a(constraintWidget5.Q, 0);
                    }
                }
                for (int i19 = 0; i19 < i12 && this.f6690n + i19 < e.this.I1; i19++) {
                    ConstraintWidget constraintWidget6 = e.this.H1[this.f6690n + i19];
                    if (constraintWidget6 != null) {
                        if (i19 == 0) {
                            constraintWidget6.l(constraintWidget6.R, this.f6681e, this.f6685i);
                            int i21 = e.this.f6662l1;
                            float f13 = e.this.f6668r1;
                            if (this.f6690n == 0 && e.this.f6664n1 != -1) {
                                i21 = e.this.f6664n1;
                                f13 = e.this.f6670t1;
                            } else if (z12 && e.this.f6666p1 != -1) {
                                i21 = e.this.f6666p1;
                                f13 = e.this.f6672v1;
                            }
                            constraintWidget6.i1(i21);
                            constraintWidget6.h1(f13);
                        }
                        if (i19 == i12 - 1) {
                            constraintWidget6.l(constraintWidget6.T, this.f6683g, this.f6687k);
                        }
                        if (constraintWidget4 != null) {
                            constraintWidget6.R.a(constraintWidget4.T, e.this.f6674x1);
                            if (i19 == i14) {
                                constraintWidget6.R.u(this.f6685i);
                            }
                            constraintWidget4.T.a(constraintWidget6.R, 0);
                            if (i19 == i15 + 1) {
                                constraintWidget4.T.u(this.f6687k);
                            }
                        }
                        if (constraintWidget6 != constraintWidget5) {
                            if (z11) {
                                int i22 = e.this.f6675y1;
                                if (i22 == 0) {
                                    constraintWidget6.S.a(constraintWidget5.S, 0);
                                } else if (i22 == 1) {
                                    constraintWidget6.Q.a(constraintWidget5.Q, 0);
                                } else if (i22 == 2) {
                                    constraintWidget6.Q.a(constraintWidget5.Q, 0);
                                    constraintWidget6.S.a(constraintWidget5.S, 0);
                                }
                            } else {
                                int i23 = e.this.f6675y1;
                                if (i23 == 0) {
                                    constraintWidget6.Q.a(constraintWidget5.Q, 0);
                                } else if (i23 == 1) {
                                    constraintWidget6.S.a(constraintWidget5.S, 0);
                                } else if (i23 == 2) {
                                    if (z13) {
                                        constraintWidget6.Q.a(this.f6680d, this.f6684h);
                                        constraintWidget6.S.a(this.f6682f, this.f6686j);
                                    } else {
                                        constraintWidget6.Q.a(constraintWidget5.Q, 0);
                                        constraintWidget6.S.a(constraintWidget5.S, 0);
                                    }
                                }
                            }
                        }
                        constraintWidget4 = constraintWidget6;
                    }
                }
                return;
            }
            ConstraintWidget constraintWidget7 = this.f6678b;
            constraintWidget7.i1(e.this.f6662l1);
            int i24 = this.f6685i;
            if (i11 > 0) {
                i24 += e.this.f6674x1;
            }
            constraintWidget7.R.a(this.f6681e, i24);
            if (z12) {
                constraintWidget7.T.a(this.f6683g, this.f6687k);
            }
            if (i11 > 0) {
                this.f6681e.f6522d.T.a(constraintWidget7.R, 0);
            }
            if (e.this.f6676z1 != 3 || constraintWidget7.b0()) {
                constraintWidget = constraintWidget7;
                break;
            }
            int i25 = 0;
            while (true) {
                if (i25 < i12) {
                    int i26 = z11 ? (i12 - 1) - i25 : i25;
                    if (this.f6690n + i26 < e.this.I1) {
                        constraintWidget = e.this.H1[this.f6690n + i26];
                        if (constraintWidget.b0()) {
                            break;
                        } else {
                            i25++;
                        }
                    }
                }
                constraintWidget = constraintWidget7;
                break;
            }
            int i27 = 0;
            while (i27 < i12) {
                int i28 = z11 ? (i12 - 1) - i27 : i27;
                if (this.f6690n + i28 >= e.this.I1) {
                    return;
                }
                ConstraintWidget constraintWidget8 = e.this.H1[this.f6690n + i28];
                if (constraintWidget8 == null) {
                    constraintWidget8 = constraintWidget4;
                } else {
                    if (i27 == 0) {
                        constraintWidget8.l(constraintWidget8.Q, this.f6680d, this.f6684h);
                    }
                    if (i28 == 0) {
                        int i29 = e.this.f6661k1;
                        float f14 = e.this.f6667q1;
                        if (z11) {
                            f14 = 1.0f - f14;
                        }
                        if (this.f6690n == 0 && e.this.f6663m1 != -1) {
                            i29 = e.this.f6663m1;
                            if (z11) {
                                f12 = e.this.f6669s1;
                                f11 = 1.0f - f12;
                            } else {
                                f11 = e.this.f6669s1;
                            }
                            f14 = f11;
                        } else if (z12 && e.this.f6665o1 != -1) {
                            i29 = e.this.f6665o1;
                            if (z11) {
                                f12 = e.this.f6671u1;
                                f11 = 1.0f - f12;
                            } else {
                                f11 = e.this.f6671u1;
                            }
                            f14 = f11;
                        }
                        constraintWidget8.R0(i29);
                        constraintWidget8.Q0(f14);
                    }
                    if (i27 == i12 - 1) {
                        constraintWidget8.l(constraintWidget8.S, this.f6682f, this.f6686j);
                    }
                    if (constraintWidget4 != null) {
                        constraintWidget8.Q.a(constraintWidget4.S, e.this.f6673w1);
                        if (i27 == i14) {
                            constraintWidget8.Q.u(this.f6684h);
                        }
                        constraintWidget4.S.a(constraintWidget8.Q, 0);
                        if (i27 == i15 + 1) {
                            constraintWidget4.S.u(this.f6686j);
                        }
                    }
                    if (constraintWidget8 != constraintWidget7) {
                        if (e.this.f6676z1 == 3 && constraintWidget.b0() && constraintWidget8 != constraintWidget && constraintWidget8.b0()) {
                            constraintWidget8.U.a(constraintWidget.U, 0);
                        } else {
                            int i31 = e.this.f6676z1;
                            if (i31 == 0) {
                                constraintWidget8.R.a(constraintWidget7.R, 0);
                            } else if (i31 == 1) {
                                constraintWidget8.T.a(constraintWidget7.T, 0);
                            } else if (z13) {
                                constraintWidget8.R.a(this.f6681e, this.f6685i);
                                constraintWidget8.T.a(this.f6683g, this.f6687k);
                            } else {
                                constraintWidget8.R.a(constraintWidget7.R, 0);
                                constraintWidget8.T.a(constraintWidget7.T, 0);
                            }
                        }
                    }
                    i27++;
                    constraintWidget4 = constraintWidget8;
                }
                i27++;
                constraintWidget4 = constraintWidget8;
            }
        }

        public int e() {
            return this.f6677a == 1 ? this.f6689m - e.this.f6674x1 : this.f6689m;
        }

        public int f() {
            return this.f6677a == 0 ? this.f6688l - e.this.f6673w1 : this.f6688l;
        }

        public void g(int i11) {
            int i12 = this.f6692p;
            if (i12 == 0) {
                return;
            }
            int i13 = this.f6691o;
            int i14 = i11 / i12;
            for (int i15 = 0; i15 < i13 && this.f6690n + i15 < e.this.I1; i15++) {
                ConstraintWidget constraintWidget = e.this.H1[this.f6690n + i15];
                if (this.f6677a == 0) {
                    if (constraintWidget != null && constraintWidget.C() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.f6573w == 0) {
                        e.this.H1(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i14, constraintWidget.V(), constraintWidget.z());
                    }
                } else if (constraintWidget != null && constraintWidget.V() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.f6575x == 0) {
                    e.this.H1(constraintWidget, constraintWidget.C(), constraintWidget.Y(), ConstraintWidget.DimensionBehaviour.FIXED, i14);
                }
            }
            h();
        }

        public final void h() {
            this.f6688l = 0;
            this.f6689m = 0;
            this.f6678b = null;
            this.f6679c = 0;
            int i11 = this.f6691o;
            for (int i12 = 0; i12 < i11 && this.f6690n + i12 < e.this.I1; i12++) {
                ConstraintWidget constraintWidget = e.this.H1[this.f6690n + i12];
                if (this.f6677a == 0) {
                    int iY = constraintWidget.Y();
                    int i13 = e.this.f6673w1;
                    if (constraintWidget.X() == 8) {
                        i13 = 0;
                    }
                    this.f6688l += iY + i13;
                    int iO2 = e.this.o2(constraintWidget, this.f6693q);
                    if (this.f6678b == null || this.f6679c < iO2) {
                        this.f6678b = constraintWidget;
                        this.f6679c = iO2;
                        this.f6689m = iO2;
                    }
                } else {
                    int iP2 = e.this.p2(constraintWidget, this.f6693q);
                    int iO3 = e.this.o2(constraintWidget, this.f6693q);
                    int i14 = e.this.f6674x1;
                    if (constraintWidget.X() == 8) {
                        i14 = 0;
                    }
                    this.f6689m += iO3 + i14;
                    if (this.f6678b == null || this.f6679c < iP2) {
                        this.f6678b = constraintWidget;
                        this.f6679c = iP2;
                        this.f6688l = iP2;
                    }
                }
            }
        }

        public void i(int i11) {
            this.f6690n = i11;
        }

        public void j(int i11, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i12, int i13, int i14, int i15, int i16) {
            this.f6677a = i11;
            this.f6680d = constraintAnchor;
            this.f6681e = constraintAnchor2;
            this.f6682f = constraintAnchor3;
            this.f6683g = constraintAnchor4;
            this.f6684h = i12;
            this.f6685i = i13;
            this.f6686j = i14;
            this.f6687k = i15;
            this.f6693q = i16;
        }
    }

    public void A2(int i11) {
        this.f6673w1 = i11;
    }

    public void B2(int i11) {
        this.f6661k1 = i11;
    }

    public void C2(float f11) {
        this.f6671u1 = f11;
    }

    public void D2(int i11) {
        this.f6665o1 = i11;
    }

    public void E2(float f11) {
        this.f6672v1 = f11;
    }

    public void F2(int i11) {
        this.f6666p1 = i11;
    }

    /* JADX WARN: Code duplicated, block: B:58:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ed A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:60:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:61:0x00f4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:63:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:65:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:66:0x00fc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:67:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:68:0x0103 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:70:0x0106  */
    /* JADX WARN: Code duplicated, block: B:74:0x0115  */
    @Override // androidx.constraintlayout.core.widgets.i
    public void G1(int i11, int i12, int i13, int i14) {
        int i15;
        int i16;
        boolean z11;
        char c11;
        int iMin;
        int iMin2;
        if (this.W0 > 0 && !I1()) {
            L1(0, 0);
            K1(false);
            return;
        }
        int iD1 = D1();
        int iE1 = E1();
        int iF1 = F1();
        int iC1 = C1();
        int[] iArr = new int[2];
        int i17 = (i12 - iD1) - iE1;
        int i18 = this.C1;
        if (i18 == 1) {
            i17 = (i14 - iF1) - iC1;
        }
        int i19 = i17;
        if (i18 == 0) {
            if (this.f6661k1 == -1) {
                this.f6661k1 = 0;
            }
            if (this.f6662l1 == -1) {
                this.f6662l1 = 0;
            }
        } else {
            if (this.f6661k1 == -1) {
                this.f6661k1 = 0;
            }
            if (this.f6662l1 == -1) {
                this.f6662l1 = 0;
            }
        }
        ConstraintWidget[] constraintWidgetArr = this.V0;
        int i21 = 0;
        int i22 = 0;
        while (true) {
            i15 = this.W0;
            if (i21 >= i15) {
                break;
            }
            if (this.V0[i21].X() == 8) {
                i22++;
            }
            i21++;
        }
        if (i22 > 0) {
            constraintWidgetArr = new ConstraintWidget[i15 - i22];
            int i23 = 0;
            for (int i24 = 0; i24 < this.W0; i24++) {
                ConstraintWidget constraintWidget = this.V0[i24];
                if (constraintWidget.X() != 8) {
                    constraintWidgetArr[i23] = constraintWidget;
                    i23++;
                }
            }
            i16 = i23;
        } else {
            i16 = i15;
        }
        this.H1 = constraintWidgetArr;
        this.I1 = i16;
        int i25 = this.A1;
        if (i25 == 0) {
            z11 = true;
            t2(constraintWidgetArr, i16, this.C1, i19, iArr);
        } else if (i25 == 1) {
            z11 = true;
            r2(constraintWidgetArr, i16, this.C1, i19, iArr);
        } else {
            if (i25 != 2) {
                if (i25 != 3) {
                    iArr = iArr;
                    c11 = 0;
                    z11 = true;
                } else {
                    z11 = true;
                    s2(constraintWidgetArr, i16, this.C1, i19, iArr);
                }
                iMin = iArr[c11] + iD1 + iE1;
                iMin2 = iArr[z11 ? 1 : 0] + iF1 + iC1;
                if (i11 == 1073741824) {
                    iMin = i12;
                } else if (i11 == Integer.MIN_VALUE) {
                    iMin = Math.min(iMin, i12);
                } else if (i11 != 0) {
                    iMin = 0;
                }
                if (i13 == 1073741824) {
                    iMin2 = i14;
                } else if (i13 == Integer.MIN_VALUE) {
                    iMin2 = Math.min(iMin2, i14);
                } else if (i13 != 0) {
                    iMin2 = 0;
                }
                L1(iMin, iMin2);
                o1(iMin);
                P0(iMin2);
                if (this.W0 <= 0) {
                    z11 = false;
                }
                K1(z11);
            }
            z11 = true;
            q2(constraintWidgetArr, i16, this.C1, i19, iArr);
        }
        c11 = 0;
        iMin = iArr[c11] + iD1 + iE1;
        iMin2 = iArr[z11 ? 1 : 0] + iF1 + iC1;
        if (i11 == 1073741824) {
            iMin = i12;
        } else if (i11 == Integer.MIN_VALUE) {
            iMin = Math.min(iMin, i12);
        } else if (i11 != 0) {
            iMin = 0;
        }
        if (i13 == 1073741824) {
            iMin2 = i14;
        } else if (i13 == Integer.MIN_VALUE) {
            iMin2 = Math.min(iMin2, i14);
        } else if (i13 != 0) {
            iMin2 = 0;
        }
        L1(iMin, iMin2);
        o1(iMin);
        P0(iMin2);
        if (this.W0 <= 0) {
            z11 = false;
        }
        K1(z11);
    }

    public void G2(int i11) {
        this.B1 = i11;
    }

    public void H2(int i11) {
        this.C1 = i11;
    }

    public void I2(int i11) {
        this.f6676z1 = i11;
    }

    public void J2(float f11) {
        this.f6668r1 = f11;
    }

    public void K2(int i11) {
        this.f6674x1 = i11;
    }

    public void L2(int i11) {
        this.f6662l1 = i11;
    }

    public void M2(int i11) {
        this.A1 = i11;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void g(androidx.constraintlayout.core.d dVar, boolean z11) {
        super.g(dVar, z11);
        boolean z12 = M() != null && ((d) M()).U1();
        int i11 = this.A1;
        if (i11 != 0) {
            if (i11 == 1) {
                int size = this.D1.size();
                int i12 = 0;
                while (i12 < size) {
                    this.D1.get(i12).d(z12, i12, i12 == size + (-1));
                    i12++;
                }
            } else if (i11 == 2) {
                n2(z12);
            } else if (i11 == 3) {
                int size2 = this.D1.size();
                int i13 = 0;
                while (i13 < size2) {
                    this.D1.get(i13).d(z12, i13, i13 == size2 + (-1));
                    i13++;
                }
            }
        } else if (this.D1.size() > 0) {
            this.D1.get(0).d(z12, 0, true);
        }
        K1(false);
    }

    @Override // v2.b, androidx.constraintlayout.core.widgets.ConstraintWidget
    public void n(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> map) {
        super.n(constraintWidget, map);
        e eVar = (e) constraintWidget;
        this.f6661k1 = eVar.f6661k1;
        this.f6662l1 = eVar.f6662l1;
        this.f6663m1 = eVar.f6663m1;
        this.f6664n1 = eVar.f6664n1;
        this.f6665o1 = eVar.f6665o1;
        this.f6666p1 = eVar.f6666p1;
        this.f6667q1 = eVar.f6667q1;
        this.f6668r1 = eVar.f6668r1;
        this.f6669s1 = eVar.f6669s1;
        this.f6670t1 = eVar.f6670t1;
        this.f6671u1 = eVar.f6671u1;
        this.f6672v1 = eVar.f6672v1;
        this.f6673w1 = eVar.f6673w1;
        this.f6674x1 = eVar.f6674x1;
        this.f6675y1 = eVar.f6675y1;
        this.f6676z1 = eVar.f6676z1;
        this.A1 = eVar.A1;
        this.B1 = eVar.B1;
        this.C1 = eVar.C1;
    }

    public final void n2(boolean z11) {
        ConstraintWidget constraintWidget;
        float f11;
        int i11;
        if (this.G1 == null || this.F1 == null || this.E1 == null) {
            return;
        }
        for (int i12 = 0; i12 < this.I1; i12++) {
            this.H1[i12].x0();
        }
        int[] iArr = this.G1;
        int i13 = iArr[0];
        int i14 = iArr[1];
        float f12 = this.f6667q1;
        ConstraintWidget constraintWidget2 = null;
        int i15 = 0;
        while (i15 < i13) {
            if (z11) {
                i11 = (i13 - i15) - 1;
                f11 = 1.0f - this.f6667q1;
            } else {
                f11 = f12;
                i11 = i15;
            }
            ConstraintWidget constraintWidget3 = this.F1[i11];
            if (constraintWidget3 != null && constraintWidget3.X() != 8) {
                if (i15 == 0) {
                    constraintWidget3.l(constraintWidget3.Q, this.Q, D1());
                    constraintWidget3.R0(this.f6661k1);
                    constraintWidget3.Q0(f11);
                }
                if (i15 == i13 - 1) {
                    constraintWidget3.l(constraintWidget3.S, this.S, E1());
                }
                if (i15 > 0 && constraintWidget2 != null) {
                    constraintWidget3.l(constraintWidget3.Q, constraintWidget2.S, this.f6673w1);
                    constraintWidget2.l(constraintWidget2.S, constraintWidget3.Q, 0);
                }
                constraintWidget2 = constraintWidget3;
            }
            i15++;
            f12 = f11;
        }
        for (int i16 = 0; i16 < i14; i16++) {
            ConstraintWidget constraintWidget4 = this.E1[i16];
            if (constraintWidget4 != null && constraintWidget4.X() != 8) {
                if (i16 == 0) {
                    constraintWidget4.l(constraintWidget4.R, this.R, F1());
                    constraintWidget4.i1(this.f6662l1);
                    constraintWidget4.h1(this.f6668r1);
                }
                if (i16 == i14 - 1) {
                    constraintWidget4.l(constraintWidget4.T, this.T, C1());
                }
                if (i16 > 0 && constraintWidget2 != null) {
                    constraintWidget4.l(constraintWidget4.R, constraintWidget2.T, this.f6674x1);
                    constraintWidget2.l(constraintWidget2.T, constraintWidget4.R, 0);
                }
                constraintWidget2 = constraintWidget4;
            }
        }
        for (int i17 = 0; i17 < i13; i17++) {
            for (int i18 = 0; i18 < i14; i18++) {
                int i19 = (i18 * i13) + i17;
                if (this.C1 == 1) {
                    i19 = (i17 * i14) + i18;
                }
                ConstraintWidget[] constraintWidgetArr = this.H1;
                if (i19 < constraintWidgetArr.length && (constraintWidget = constraintWidgetArr[i19]) != null && constraintWidget.X() != 8) {
                    ConstraintWidget constraintWidget5 = this.F1[i17];
                    ConstraintWidget constraintWidget6 = this.E1[i18];
                    if (constraintWidget != constraintWidget5) {
                        constraintWidget.l(constraintWidget.Q, constraintWidget5.Q, 0);
                        constraintWidget.l(constraintWidget.S, constraintWidget5.S, 0);
                    }
                    if (constraintWidget != constraintWidget6) {
                        constraintWidget.l(constraintWidget.R, constraintWidget6.R, 0);
                        constraintWidget.l(constraintWidget.T, constraintWidget6.T, 0);
                    }
                }
            }
        }
    }

    public final int o2(ConstraintWidget constraintWidget, int i11) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.V() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i12 = constraintWidget.f6575x;
            if (i12 == 0) {
                return 0;
            }
            if (i12 == 2) {
                int i13 = (int) (constraintWidget.E * i11);
                if (i13 != constraintWidget.z()) {
                    constraintWidget.c1(true);
                    H1(constraintWidget, constraintWidget.C(), constraintWidget.Y(), ConstraintWidget.DimensionBehaviour.FIXED, i13);
                }
                return i13;
            }
            if (i12 == 1) {
                return constraintWidget.z();
            }
            if (i12 == 3) {
                return (int) ((constraintWidget.Y() * constraintWidget.f6540f0) + 0.5f);
            }
        }
        return constraintWidget.z();
    }

    public final int p2(ConstraintWidget constraintWidget, int i11) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.C() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i12 = constraintWidget.f6573w;
            if (i12 == 0) {
                return 0;
            }
            if (i12 == 2) {
                int i13 = (int) (constraintWidget.B * i11);
                if (i13 != constraintWidget.Y()) {
                    constraintWidget.c1(true);
                    H1(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i13, constraintWidget.V(), constraintWidget.z());
                }
                return i13;
            }
            if (i12 == 1) {
                return constraintWidget.Y();
            }
            if (i12 == 3) {
                return (int) ((constraintWidget.z() * constraintWidget.f6540f0) + 0.5f);
            }
        }
        return constraintWidget.Y();
    }

    /* JADX WARN: Code duplicated, block: B:100:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:106:0x010f A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:109:0x0117 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:117:0x011d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:118:0x0115 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:119:0x0059 A[ADDED_TO_REGION, EDGE_INSN: B:119:0x0059->B:42:0x0059 BREAK  A[LOOP:1: B:44:0x005c->B:124:0x005c], REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:121:0x010d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:122:0x0059 A[ADDED_TO_REGION, EDGE_INSN: B:122:0x0059->B:42:0x0059 BREAK  A[LOOP:1: B:44:0x005c->B:124:0x005c], REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:132:0x00d3 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:136:0x00ed A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:139:0x0104 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:0x005e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:46:0x0060  */
    /* JADX WARN: Code duplicated, block: B:47:0x006a  */
    /* JADX WARN: Code duplicated, block: B:50:0x0078  */
    /* JADX WARN: Code duplicated, block: B:54:0x0080  */
    /* JADX WARN: Code duplicated, block: B:57:0x0088  */
    /* JADX WARN: Code duplicated, block: B:61:0x0090  */
    /* JADX WARN: Code duplicated, block: B:64:0x0097  */
    /* JADX WARN: Code duplicated, block: B:66:0x009a  */
    /* JADX WARN: Code duplicated, block: B:68:0x009f  */
    /* JADX WARN: Code duplicated, block: B:72:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:77:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:79:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:82:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:84:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:89:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:91:0x00e3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:92:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:97:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:99:0x00fa A[DONT_INVERT] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:105:0x010d -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:106:0x010f -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:108:0x0115 -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:109:0x0117 -> B:42:0x0059). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:45:0x005e
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final void q2(androidx.constraintlayout.core.widgets.ConstraintWidget[] r11, int r12, int r13, int r14, int[] r15) {
        /*
            Method dump skipped, instruction units count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.e.q2(androidx.constraintlayout.core.widgets.ConstraintWidget[], int, int, int, int[]):void");
    }

    public final void r2(ConstraintWidget[] constraintWidgetArr, int i11, int i12, int i13, int[] iArr) {
        int i14;
        int i15;
        int i16;
        ConstraintAnchor constraintAnchor;
        int iE1;
        ConstraintAnchor constraintAnchor2;
        int iC1;
        int i17;
        if (i11 == 0) {
            return;
        }
        this.D1.clear();
        a aVar = new a(i12, this.Q, this.R, this.S, this.T, i13);
        this.D1.add(aVar);
        if (i12 == 0) {
            i14 = 0;
            int i18 = 0;
            int i19 = 0;
            while (i19 < i11) {
                ConstraintWidget constraintWidget = constraintWidgetArr[i19];
                int iP2 = p2(constraintWidget, i13);
                if (constraintWidget.C() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i14++;
                }
                int i21 = i14;
                boolean z11 = (i18 == i13 || (this.f6673w1 + i18) + iP2 > i13) && aVar.f6678b != null;
                if ((z11 || i19 <= 0 || (i17 = this.B1) <= 0 || i19 % i17 != 0) && !z11) {
                    if (i19 > 0) {
                        i18 += this.f6673w1 + iP2;
                    }
                    aVar.b(constraintWidget);
                    i19++;
                    i14 = i21;
                } else {
                    aVar = new a(i12, this.Q, this.R, this.S, this.T, i13);
                    aVar.i(i19);
                    this.D1.add(aVar);
                }
                i18 = iP2;
                aVar.b(constraintWidget);
                i19++;
                i14 = i21;
            }
        } else {
            i14 = 0;
            int i22 = 0;
            int i23 = 0;
            while (i23 < i11) {
                ConstraintWidget constraintWidget2 = constraintWidgetArr[i23];
                int iO2 = o2(constraintWidget2, i13);
                if (constraintWidget2.V() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i14++;
                }
                int i24 = i14;
                boolean z12 = (i22 == i13 || (this.f6674x1 + i22) + iO2 > i13) && aVar.f6678b != null;
                if ((z12 || i23 <= 0 || (i15 = this.B1) <= 0 || i23 % i15 != 0) && !z12) {
                    if (i23 > 0) {
                        i22 += this.f6674x1 + iO2;
                    }
                    aVar.b(constraintWidget2);
                    i23++;
                    i14 = i24;
                } else {
                    aVar = new a(i12, this.Q, this.R, this.S, this.T, i13);
                    aVar.i(i23);
                    this.D1.add(aVar);
                }
                i22 = iO2;
                aVar.b(constraintWidget2);
                i23++;
                i14 = i24;
            }
        }
        int size = this.D1.size();
        ConstraintAnchor constraintAnchor3 = this.Q;
        ConstraintAnchor constraintAnchor4 = this.R;
        ConstraintAnchor constraintAnchor5 = this.S;
        ConstraintAnchor constraintAnchor6 = this.T;
        int iD1 = D1();
        int iF1 = F1();
        int iE2 = E1();
        int iC2 = C1();
        ConstraintWidget.DimensionBehaviour dimensionBehaviourC = C();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        boolean z13 = dimensionBehaviourC == dimensionBehaviour || V() == dimensionBehaviour;
        if (i14 > 0 && z13) {
            for (int i25 = 0; i25 < size; i25++) {
                a aVar2 = this.D1.get(i25);
                if (i12 == 0) {
                    aVar2.g(i13 - aVar2.f());
                } else {
                    aVar2.g(i13 - aVar2.e());
                }
            }
        }
        int i26 = iF1;
        int i27 = iE2;
        int iE = 0;
        int iF = 0;
        int i28 = 0;
        int i29 = iD1;
        ConstraintAnchor constraintAnchor7 = constraintAnchor4;
        ConstraintAnchor constraintAnchor8 = constraintAnchor3;
        int i31 = iC2;
        while (i28 < size) {
            a aVar3 = this.D1.get(i28);
            if (i12 == 0) {
                if (i28 < size - 1) {
                    constraintAnchor2 = this.D1.get(i28 + 1).f6678b.R;
                    iC1 = 0;
                } else {
                    constraintAnchor2 = this.T;
                    iC1 = C1();
                }
                ConstraintAnchor constraintAnchor9 = aVar3.f6678b.T;
                ConstraintAnchor constraintAnchor10 = constraintAnchor8;
                ConstraintAnchor constraintAnchor11 = constraintAnchor8;
                int i32 = iE;
                ConstraintAnchor constraintAnchor12 = constraintAnchor7;
                int i33 = iF;
                ConstraintAnchor constraintAnchor13 = constraintAnchor5;
                ConstraintAnchor constraintAnchor14 = constraintAnchor5;
                i16 = i28;
                aVar3.j(i12, constraintAnchor10, constraintAnchor12, constraintAnchor13, constraintAnchor2, i29, i26, i27, iC1, i13);
                int iMax = Math.max(i33, aVar3.f());
                iE = i32 + aVar3.e();
                if (i16 > 0) {
                    iE += this.f6674x1;
                }
                constraintAnchor8 = constraintAnchor11;
                iF = iMax;
                constraintAnchor7 = constraintAnchor9;
                i26 = 0;
                constraintAnchor = constraintAnchor14;
                int i34 = iC1;
                constraintAnchor6 = constraintAnchor2;
                i31 = i34;
            } else {
                ConstraintAnchor constraintAnchor15 = constraintAnchor8;
                int i35 = iE;
                int i36 = iF;
                i16 = i28;
                if (i16 < size - 1) {
                    constraintAnchor = this.D1.get(i16 + 1).f6678b.Q;
                    iE1 = 0;
                } else {
                    constraintAnchor = this.S;
                    iE1 = E1();
                }
                ConstraintAnchor constraintAnchor16 = aVar3.f6678b.S;
                aVar3.j(i12, constraintAnchor15, constraintAnchor7, constraintAnchor, constraintAnchor6, i29, i26, iE1, i31, i13);
                iF = i36 + aVar3.f();
                int iMax2 = Math.max(i35, aVar3.e());
                if (i16 > 0) {
                    iF += this.f6673w1;
                }
                iE = iMax2;
                i27 = iE1;
                constraintAnchor8 = constraintAnchor16;
                i29 = 0;
            }
            i28 = i16 + 1;
            constraintAnchor5 = constraintAnchor;
        }
        iArr[0] = iF;
        iArr[1] = iE;
    }

    public final void s2(ConstraintWidget[] constraintWidgetArr, int i11, int i12, int i13, int[] iArr) {
        int i14;
        int i15;
        int i16;
        ConstraintAnchor constraintAnchor;
        int iE1;
        ConstraintAnchor constraintAnchor2;
        int iC1;
        int i17;
        if (i11 == 0) {
            return;
        }
        this.D1.clear();
        a aVar = new a(i12, this.Q, this.R, this.S, this.T, i13);
        this.D1.add(aVar);
        if (i12 == 0) {
            int i18 = 0;
            i14 = 0;
            int i19 = 0;
            int i21 = 0;
            while (i21 < i11) {
                int i22 = i18 + 1;
                ConstraintWidget constraintWidget = constraintWidgetArr[i21];
                int iP2 = p2(constraintWidget, i13);
                if (constraintWidget.C() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i14++;
                }
                int i23 = i14;
                boolean z11 = (i19 == i13 || (this.f6673w1 + i19) + iP2 > i13) && aVar.f6678b != null;
                if ((z11 || i21 <= 0 || (i17 = this.B1) <= 0 || i22 <= i17) && !z11) {
                    i19 = i21 > 0 ? i19 + this.f6673w1 + iP2 : iP2;
                    i18 = 0;
                } else {
                    aVar = new a(i12, this.Q, this.R, this.S, this.T, i13);
                    aVar.i(i21);
                    this.D1.add(aVar);
                    i18 = i22;
                    i19 = iP2;
                }
                aVar.b(constraintWidget);
                i21++;
                i14 = i23;
            }
        } else {
            int i24 = 0;
            i14 = 0;
            int i25 = 0;
            while (i25 < i11) {
                ConstraintWidget constraintWidget2 = constraintWidgetArr[i25];
                int iO2 = o2(constraintWidget2, i13);
                if (constraintWidget2.V() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i14++;
                }
                int i26 = i14;
                boolean z12 = (i24 == i13 || (this.f6674x1 + i24) + iO2 > i13) && aVar.f6678b != null;
                if ((z12 || i25 <= 0 || (i15 = this.B1) <= 0 || i15 >= 0) && !z12) {
                    if (i25 > 0) {
                        i24 += this.f6674x1 + iO2;
                    }
                    aVar.b(constraintWidget2);
                    i25++;
                    i14 = i26;
                } else {
                    aVar = new a(i12, this.Q, this.R, this.S, this.T, i13);
                    aVar.i(i25);
                    this.D1.add(aVar);
                }
                i24 = iO2;
                aVar.b(constraintWidget2);
                i25++;
                i14 = i26;
            }
        }
        int size = this.D1.size();
        ConstraintAnchor constraintAnchor3 = this.Q;
        ConstraintAnchor constraintAnchor4 = this.R;
        ConstraintAnchor constraintAnchor5 = this.S;
        ConstraintAnchor constraintAnchor6 = this.T;
        int iD1 = D1();
        int iF1 = F1();
        int iE2 = E1();
        int iC2 = C1();
        ConstraintWidget.DimensionBehaviour dimensionBehaviourC = C();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        boolean z13 = dimensionBehaviourC == dimensionBehaviour || V() == dimensionBehaviour;
        if (i14 > 0 && z13) {
            for (int i27 = 0; i27 < size; i27++) {
                a aVar2 = this.D1.get(i27);
                if (i12 == 0) {
                    aVar2.g(i13 - aVar2.f());
                } else {
                    aVar2.g(i13 - aVar2.e());
                }
            }
        }
        int i28 = iF1;
        int i29 = iE2;
        int iE = 0;
        int iF = 0;
        int i31 = 0;
        int i32 = iD1;
        ConstraintAnchor constraintAnchor7 = constraintAnchor4;
        ConstraintAnchor constraintAnchor8 = constraintAnchor3;
        int i33 = iC2;
        while (i31 < size) {
            a aVar3 = this.D1.get(i31);
            if (i12 == 0) {
                if (i31 < size - 1) {
                    constraintAnchor2 = this.D1.get(i31 + 1).f6678b.R;
                    iC1 = 0;
                } else {
                    constraintAnchor2 = this.T;
                    iC1 = C1();
                }
                ConstraintAnchor constraintAnchor9 = aVar3.f6678b.T;
                ConstraintAnchor constraintAnchor10 = constraintAnchor8;
                ConstraintAnchor constraintAnchor11 = constraintAnchor8;
                int i34 = iE;
                ConstraintAnchor constraintAnchor12 = constraintAnchor7;
                int i35 = iF;
                ConstraintAnchor constraintAnchor13 = constraintAnchor5;
                ConstraintAnchor constraintAnchor14 = constraintAnchor5;
                i16 = i31;
                aVar3.j(i12, constraintAnchor10, constraintAnchor12, constraintAnchor13, constraintAnchor2, i32, i28, i29, iC1, i13);
                int iMax = Math.max(i35, aVar3.f());
                iE = i34 + aVar3.e();
                if (i16 > 0) {
                    iE += this.f6674x1;
                }
                constraintAnchor8 = constraintAnchor11;
                iF = iMax;
                constraintAnchor7 = constraintAnchor9;
                i28 = 0;
                constraintAnchor = constraintAnchor14;
                int i36 = iC1;
                constraintAnchor6 = constraintAnchor2;
                i33 = i36;
            } else {
                ConstraintAnchor constraintAnchor15 = constraintAnchor8;
                int i37 = iE;
                int i38 = iF;
                i16 = i31;
                if (i16 < size - 1) {
                    constraintAnchor = this.D1.get(i16 + 1).f6678b.Q;
                    iE1 = 0;
                } else {
                    constraintAnchor = this.S;
                    iE1 = E1();
                }
                ConstraintAnchor constraintAnchor16 = aVar3.f6678b.S;
                aVar3.j(i12, constraintAnchor15, constraintAnchor7, constraintAnchor, constraintAnchor6, i32, i28, iE1, i33, i13);
                iF = i38 + aVar3.f();
                int iMax2 = Math.max(i37, aVar3.e());
                if (i16 > 0) {
                    iF += this.f6673w1;
                }
                iE = iMax2;
                i29 = iE1;
                constraintAnchor8 = constraintAnchor16;
                i32 = 0;
            }
            i31 = i16 + 1;
            constraintAnchor5 = constraintAnchor;
        }
        iArr[0] = iF;
        iArr[1] = iE;
    }

    public final void t2(ConstraintWidget[] constraintWidgetArr, int i11, int i12, int i13, int[] iArr) {
        a aVar;
        if (i11 == 0) {
            return;
        }
        if (this.D1.size() == 0) {
            aVar = new a(i12, this.Q, this.R, this.S, this.T, i13);
            this.D1.add(aVar);
        } else {
            a aVar2 = this.D1.get(0);
            aVar2.c();
            aVar = aVar2;
            aVar.j(i12, this.Q, this.R, this.S, this.T, D1(), F1(), E1(), C1(), i13);
        }
        for (int i14 = 0; i14 < i11; i14++) {
            aVar.b(constraintWidgetArr[i14]);
        }
        iArr[0] = aVar.f();
        iArr[1] = aVar.e();
    }

    public void u2(float f11) {
        this.f6669s1 = f11;
    }

    public void v2(int i11) {
        this.f6663m1 = i11;
    }

    public void w2(float f11) {
        this.f6670t1 = f11;
    }

    public void x2(int i11) {
        this.f6664n1 = i11;
    }

    public void y2(int i11) {
        this.f6675y1 = i11;
    }

    public void z2(float f11) {
        this.f6667q1 = f11;
    }
}
