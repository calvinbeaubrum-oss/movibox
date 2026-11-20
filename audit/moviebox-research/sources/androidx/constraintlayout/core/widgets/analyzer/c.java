package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends WidgetRun {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static int[] f6608k = new int[2];

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6609a;

        static {
            int[] iArr = new int[WidgetRun.RunType.values().length];
            f6609a = iArr;
            try {
                iArr[WidgetRun.RunType.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6609a[WidgetRun.RunType.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6609a[WidgetRun.RunType.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public c(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        this.f6603h.f6588e = DependencyNode.Type.LEFT;
        this.f6604i.f6588e = DependencyNode.Type.RIGHT;
        this.f6601f = 0;
    }

    /* JADX WARN: Code duplicated, block: B:125:0x02e3  */
    /* JADX WARN: Code duplicated, block: B:127:0x02f2  */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, w2.d
    public void a(w2.d dVar) {
        int iG;
        int i11;
        int iG2;
        float f11;
        float fX;
        float fX2;
        int i12;
        int i13 = a.f6609a[this.f6605j.ordinal()];
        if (i13 == 1) {
            p(dVar);
        } else if (i13 == 2) {
            o(dVar);
        } else if (i13 == 3) {
            ConstraintWidget constraintWidget = this.f6597b;
            n(dVar, constraintWidget.Q, constraintWidget.S, 0);
            return;
        }
        if (!this.f6600e.f6593j && this.f6599d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget2 = this.f6597b;
            int i14 = constraintWidget2.f6573w;
            if (i14 == 2) {
                ConstraintWidget constraintWidgetM = constraintWidget2.M();
                if (constraintWidgetM != null) {
                    androidx.constraintlayout.core.widgets.analyzer.a aVar = constraintWidgetM.f6537e.f6600e;
                    if (aVar.f6593j) {
                        this.f6600e.d((int) ((aVar.f6590g * this.f6597b.B) + 0.5f));
                    }
                }
            } else if (i14 == 3) {
                int i15 = constraintWidget2.f6575x;
                if (i15 == 0 || i15 == 3) {
                    d dVar2 = constraintWidget2.f6539f;
                    DependencyNode dependencyNode = dVar2.f6603h;
                    DependencyNode dependencyNode2 = dVar2.f6604i;
                    boolean z11 = constraintWidget2.Q.f6524f != null;
                    boolean z12 = constraintWidget2.R.f6524f != null;
                    boolean z13 = constraintWidget2.S.f6524f != null;
                    boolean z14 = constraintWidget2.T.f6524f != null;
                    int iY = constraintWidget2.y();
                    if (z11 && z12 && z13 && z14) {
                        float fX3 = this.f6597b.x();
                        if (dependencyNode.f6593j && dependencyNode2.f6593j) {
                            DependencyNode dependencyNode3 = this.f6603h;
                            if (dependencyNode3.f6586c && this.f6604i.f6586c) {
                                q(f6608k, dependencyNode3.f6595l.get(0).f6590g + this.f6603h.f6589f, this.f6604i.f6595l.get(0).f6590g - this.f6604i.f6589f, dependencyNode.f6590g + dependencyNode.f6589f, dependencyNode2.f6590g - dependencyNode2.f6589f, fX3, iY);
                                this.f6600e.d(f6608k[0]);
                                this.f6597b.f6539f.f6600e.d(f6608k[1]);
                                return;
                            }
                            return;
                        }
                        DependencyNode dependencyNode4 = this.f6603h;
                        if (dependencyNode4.f6593j) {
                            DependencyNode dependencyNode5 = this.f6604i;
                            if (dependencyNode5.f6593j) {
                                if (!dependencyNode.f6586c || !dependencyNode2.f6586c) {
                                    return;
                                }
                                q(f6608k, dependencyNode4.f6590g + dependencyNode4.f6589f, dependencyNode5.f6590g - dependencyNode5.f6589f, dependencyNode.f6595l.get(0).f6590g + dependencyNode.f6589f, dependencyNode2.f6595l.get(0).f6590g - dependencyNode2.f6589f, fX3, iY);
                                this.f6600e.d(f6608k[0]);
                                this.f6597b.f6539f.f6600e.d(f6608k[1]);
                            }
                        }
                        DependencyNode dependencyNode6 = this.f6603h;
                        if (!dependencyNode6.f6586c || !this.f6604i.f6586c || !dependencyNode.f6586c || !dependencyNode2.f6586c) {
                            return;
                        }
                        q(f6608k, dependencyNode6.f6595l.get(0).f6590g + this.f6603h.f6589f, this.f6604i.f6595l.get(0).f6590g - this.f6604i.f6589f, dependencyNode.f6595l.get(0).f6590g + dependencyNode.f6589f, dependencyNode2.f6595l.get(0).f6590g - dependencyNode2.f6589f, fX3, iY);
                        this.f6600e.d(f6608k[0]);
                        this.f6597b.f6539f.f6600e.d(f6608k[1]);
                    } else if (z11 && z13) {
                        if (!this.f6603h.f6586c || !this.f6604i.f6586c) {
                            return;
                        }
                        float fX4 = this.f6597b.x();
                        int i16 = this.f6603h.f6595l.get(0).f6590g + this.f6603h.f6589f;
                        int i17 = this.f6604i.f6595l.get(0).f6590g - this.f6604i.f6589f;
                        if (iY == -1 || iY == 0) {
                            int iG3 = g(i17 - i16, 0);
                            int i18 = (int) ((iG3 * fX4) + 0.5f);
                            int iG4 = g(i18, 1);
                            if (i18 != iG4) {
                                iG3 = (int) ((iG4 / fX4) + 0.5f);
                            }
                            this.f6600e.d(iG3);
                            this.f6597b.f6539f.f6600e.d(iG4);
                        } else if (iY == 1) {
                            int iG5 = g(i17 - i16, 0);
                            int i19 = (int) ((iG5 / fX4) + 0.5f);
                            int iG6 = g(i19, 1);
                            if (i19 != iG6) {
                                iG5 = (int) ((iG6 * fX4) + 0.5f);
                            }
                            this.f6600e.d(iG5);
                            this.f6597b.f6539f.f6600e.d(iG6);
                        }
                    } else if (z12 && z14) {
                        if (!dependencyNode.f6586c || !dependencyNode2.f6586c) {
                            return;
                        }
                        float fX5 = this.f6597b.x();
                        int i21 = dependencyNode.f6595l.get(0).f6590g + dependencyNode.f6589f;
                        int i22 = dependencyNode2.f6595l.get(0).f6590g - dependencyNode2.f6589f;
                        if (iY == -1) {
                            iG = g(i22 - i21, 1);
                            i11 = (int) ((iG / fX5) + 0.5f);
                            iG2 = g(i11, 0);
                            if (i11 != iG2) {
                                iG = (int) ((iG2 * fX5) + 0.5f);
                            }
                            this.f6600e.d(iG2);
                            this.f6597b.f6539f.f6600e.d(iG);
                        } else if (iY == 0) {
                            int iG7 = g(i22 - i21, 1);
                            int i23 = (int) ((iG7 * fX5) + 0.5f);
                            int iG8 = g(i23, 0);
                            if (i23 != iG8) {
                                iG7 = (int) ((iG8 / fX5) + 0.5f);
                            }
                            this.f6600e.d(iG8);
                            this.f6597b.f6539f.f6600e.d(iG7);
                        } else if (iY == 1) {
                            iG = g(i22 - i21, 1);
                            i11 = (int) ((iG / fX5) + 0.5f);
                            iG2 = g(i11, 0);
                            if (i11 != iG2) {
                                iG = (int) ((iG2 * fX5) + 0.5f);
                            }
                            this.f6600e.d(iG2);
                            this.f6597b.f6539f.f6600e.d(iG);
                        }
                    }
                } else {
                    int iY2 = constraintWidget2.y();
                    if (iY2 != -1) {
                        if (iY2 == 0) {
                            ConstraintWidget constraintWidget3 = this.f6597b;
                            fX2 = constraintWidget3.f6539f.f6600e.f6590g / constraintWidget3.x();
                            i12 = (int) (fX2 + 0.5f);
                        } else if (iY2 != 1) {
                            i12 = 0;
                        } else {
                            ConstraintWidget constraintWidget4 = this.f6597b;
                            f11 = constraintWidget4.f6539f.f6600e.f6590g;
                            fX = constraintWidget4.x();
                        }
                        this.f6600e.d(i12);
                    } else {
                        ConstraintWidget constraintWidget5 = this.f6597b;
                        f11 = constraintWidget5.f6539f.f6600e.f6590g;
                        fX = constraintWidget5.x();
                    }
                    fX2 = f11 * fX;
                    i12 = (int) (fX2 + 0.5f);
                    this.f6600e.d(i12);
                }
            }
        }
        DependencyNode dependencyNode7 = this.f6603h;
        if (dependencyNode7.f6586c) {
            DependencyNode dependencyNode8 = this.f6604i;
            if (dependencyNode8.f6586c) {
                if (dependencyNode7.f6593j && dependencyNode8.f6593j && this.f6600e.f6593j) {
                    return;
                }
                if (!this.f6600e.f6593j && this.f6599d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    ConstraintWidget constraintWidget6 = this.f6597b;
                    if (constraintWidget6.f6573w == 0 && !constraintWidget6.k0()) {
                        DependencyNode dependencyNode9 = this.f6603h.f6595l.get(0);
                        DependencyNode dependencyNode10 = this.f6604i.f6595l.get(0);
                        int i24 = dependencyNode9.f6590g;
                        DependencyNode dependencyNode11 = this.f6603h;
                        int i25 = i24 + dependencyNode11.f6589f;
                        int i26 = dependencyNode10.f6590g + this.f6604i.f6589f;
                        dependencyNode11.d(i25);
                        this.f6604i.d(i26);
                        this.f6600e.d(i26 - i25);
                        return;
                    }
                }
                if (!this.f6600e.f6593j && this.f6599d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.f6596a == 1 && this.f6603h.f6595l.size() > 0 && this.f6604i.f6595l.size() > 0) {
                    int iMin = Math.min((this.f6604i.f6595l.get(0).f6590g + this.f6604i.f6589f) - (this.f6603h.f6595l.get(0).f6590g + this.f6603h.f6589f), this.f6600e.f6607m);
                    ConstraintWidget constraintWidget7 = this.f6597b;
                    int i27 = constraintWidget7.A;
                    int iMax = Math.max(constraintWidget7.f6579z, iMin);
                    if (i27 > 0) {
                        iMax = Math.min(i27, iMax);
                    }
                    this.f6600e.d(iMax);
                }
                if (this.f6600e.f6593j) {
                    DependencyNode dependencyNode12 = this.f6603h.f6595l.get(0);
                    DependencyNode dependencyNode13 = this.f6604i.f6595l.get(0);
                    int i28 = dependencyNode12.f6590g + this.f6603h.f6589f;
                    int i29 = dependencyNode13.f6590g + this.f6604i.f6589f;
                    float fA = this.f6597b.A();
                    if (dependencyNode12 == dependencyNode13) {
                        i28 = dependencyNode12.f6590g;
                        i29 = dependencyNode13.f6590g;
                        fA = 0.5f;
                    }
                    this.f6603h.d((int) (i28 + 0.5f + (((i29 - i28) - this.f6600e.f6590g) * fA)));
                    this.f6604i.d(this.f6603h.f6590g + this.f6600e.f6590g);
                }
            }
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void d() {
        ConstraintWidget constraintWidgetM;
        ConstraintWidget constraintWidgetM2;
        ConstraintWidget constraintWidget = this.f6597b;
        if (constraintWidget.f6529a) {
            this.f6600e.d(constraintWidget.Y());
        }
        if (this.f6600e.f6593j) {
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.f6599d;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
            if (dimensionBehaviour == dimensionBehaviour2 && (constraintWidgetM = this.f6597b.M()) != null && (constraintWidgetM.C() == ConstraintWidget.DimensionBehaviour.FIXED || constraintWidgetM.C() == dimensionBehaviour2)) {
                b(this.f6603h, constraintWidgetM.f6537e.f6603h, this.f6597b.Q.f());
                b(this.f6604i, constraintWidgetM.f6537e.f6604i, -this.f6597b.S.f());
                return;
            }
        } else {
            ConstraintWidget.DimensionBehaviour dimensionBehaviourC = this.f6597b.C();
            this.f6599d = dimensionBehaviourC;
            if (dimensionBehaviourC != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
                if (dimensionBehaviourC == dimensionBehaviour3 && (constraintWidgetM2 = this.f6597b.M()) != null && (constraintWidgetM2.C() == ConstraintWidget.DimensionBehaviour.FIXED || constraintWidgetM2.C() == dimensionBehaviour3)) {
                    int iY = (constraintWidgetM2.Y() - this.f6597b.Q.f()) - this.f6597b.S.f();
                    b(this.f6603h, constraintWidgetM2.f6537e.f6603h, this.f6597b.Q.f());
                    b(this.f6604i, constraintWidgetM2.f6537e.f6604i, -this.f6597b.S.f());
                    this.f6600e.d(iY);
                    return;
                }
                if (this.f6599d == ConstraintWidget.DimensionBehaviour.FIXED) {
                    this.f6600e.d(this.f6597b.Y());
                }
            }
        }
        androidx.constraintlayout.core.widgets.analyzer.a aVar = this.f6600e;
        if (aVar.f6593j) {
            ConstraintWidget constraintWidget2 = this.f6597b;
            if (constraintWidget2.f6529a) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget2.Y;
                ConstraintAnchor constraintAnchor = constraintAnchorArr[0];
                ConstraintAnchor constraintAnchor2 = constraintAnchor.f6524f;
                if (constraintAnchor2 != null && constraintAnchorArr[1].f6524f != null) {
                    if (constraintWidget2.k0()) {
                        this.f6603h.f6589f = this.f6597b.Y[0].f();
                        this.f6604i.f6589f = -this.f6597b.Y[1].f();
                        return;
                    }
                    DependencyNode dependencyNodeH = h(this.f6597b.Y[0]);
                    if (dependencyNodeH != null) {
                        b(this.f6603h, dependencyNodeH, this.f6597b.Y[0].f());
                    }
                    DependencyNode dependencyNodeH2 = h(this.f6597b.Y[1]);
                    if (dependencyNodeH2 != null) {
                        b(this.f6604i, dependencyNodeH2, -this.f6597b.Y[1].f());
                    }
                    this.f6603h.f6585b = true;
                    this.f6604i.f6585b = true;
                    return;
                }
                if (constraintAnchor2 != null) {
                    DependencyNode dependencyNodeH3 = h(constraintAnchor);
                    if (dependencyNodeH3 != null) {
                        b(this.f6603h, dependencyNodeH3, this.f6597b.Y[0].f());
                        b(this.f6604i, this.f6603h, this.f6600e.f6590g);
                        return;
                    }
                    return;
                }
                ConstraintAnchor constraintAnchor3 = constraintAnchorArr[1];
                if (constraintAnchor3.f6524f != null) {
                    DependencyNode dependencyNodeH4 = h(constraintAnchor3);
                    if (dependencyNodeH4 != null) {
                        b(this.f6604i, dependencyNodeH4, -this.f6597b.Y[1].f());
                        b(this.f6603h, this.f6604i, -this.f6600e.f6590g);
                        return;
                    }
                    return;
                }
                if ((constraintWidget2 instanceof v2.a) || constraintWidget2.M() == null || this.f6597b.q(ConstraintAnchor.Type.CENTER).f6524f != null) {
                    return;
                }
                b(this.f6603h, this.f6597b.M().f6537e.f6603h, this.f6597b.Z());
                b(this.f6604i, this.f6603h, this.f6600e.f6590g);
                return;
            }
        }
        if (this.f6599d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget3 = this.f6597b;
            int i11 = constraintWidget3.f6573w;
            if (i11 == 2) {
                ConstraintWidget constraintWidgetM3 = constraintWidget3.M();
                if (constraintWidgetM3 != null) {
                    androidx.constraintlayout.core.widgets.analyzer.a aVar2 = constraintWidgetM3.f6539f.f6600e;
                    this.f6600e.f6595l.add(aVar2);
                    aVar2.f6594k.add(this.f6600e);
                    androidx.constraintlayout.core.widgets.analyzer.a aVar3 = this.f6600e;
                    aVar3.f6585b = true;
                    aVar3.f6594k.add(this.f6603h);
                    this.f6600e.f6594k.add(this.f6604i);
                }
            } else if (i11 == 3) {
                if (constraintWidget3.f6575x == 3) {
                    this.f6603h.f6584a = this;
                    this.f6604i.f6584a = this;
                    d dVar = constraintWidget3.f6539f;
                    dVar.f6603h.f6584a = this;
                    dVar.f6604i.f6584a = this;
                    aVar.f6584a = this;
                    if (constraintWidget3.m0()) {
                        this.f6600e.f6595l.add(this.f6597b.f6539f.f6600e);
                        this.f6597b.f6539f.f6600e.f6594k.add(this.f6600e);
                        d dVar2 = this.f6597b.f6539f;
                        dVar2.f6600e.f6584a = this;
                        this.f6600e.f6595l.add(dVar2.f6603h);
                        this.f6600e.f6595l.add(this.f6597b.f6539f.f6604i);
                        this.f6597b.f6539f.f6603h.f6594k.add(this.f6600e);
                        this.f6597b.f6539f.f6604i.f6594k.add(this.f6600e);
                    } else if (this.f6597b.k0()) {
                        this.f6597b.f6539f.f6600e.f6595l.add(this.f6600e);
                        this.f6600e.f6594k.add(this.f6597b.f6539f.f6600e);
                    } else {
                        this.f6597b.f6539f.f6600e.f6595l.add(this.f6600e);
                    }
                } else {
                    androidx.constraintlayout.core.widgets.analyzer.a aVar4 = constraintWidget3.f6539f.f6600e;
                    aVar.f6595l.add(aVar4);
                    aVar4.f6594k.add(this.f6600e);
                    this.f6597b.f6539f.f6603h.f6594k.add(this.f6600e);
                    this.f6597b.f6539f.f6604i.f6594k.add(this.f6600e);
                    androidx.constraintlayout.core.widgets.analyzer.a aVar5 = this.f6600e;
                    aVar5.f6585b = true;
                    aVar5.f6594k.add(this.f6603h);
                    this.f6600e.f6594k.add(this.f6604i);
                    this.f6603h.f6595l.add(this.f6600e);
                    this.f6604i.f6595l.add(this.f6600e);
                }
            }
        }
        ConstraintWidget constraintWidget4 = this.f6597b;
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget4.Y;
        ConstraintAnchor constraintAnchor4 = constraintAnchorArr2[0];
        ConstraintAnchor constraintAnchor5 = constraintAnchor4.f6524f;
        if (constraintAnchor5 != null && constraintAnchorArr2[1].f6524f != null) {
            if (constraintWidget4.k0()) {
                this.f6603h.f6589f = this.f6597b.Y[0].f();
                this.f6604i.f6589f = -this.f6597b.Y[1].f();
                return;
            }
            DependencyNode dependencyNodeH5 = h(this.f6597b.Y[0]);
            DependencyNode dependencyNodeH6 = h(this.f6597b.Y[1]);
            if (dependencyNodeH5 != null) {
                dependencyNodeH5.b(this);
            }
            if (dependencyNodeH6 != null) {
                dependencyNodeH6.b(this);
            }
            this.f6605j = WidgetRun.RunType.CENTER;
            return;
        }
        if (constraintAnchor5 != null) {
            DependencyNode dependencyNodeH7 = h(constraintAnchor4);
            if (dependencyNodeH7 != null) {
                b(this.f6603h, dependencyNodeH7, this.f6597b.Y[0].f());
                c(this.f6604i, this.f6603h, 1, this.f6600e);
                return;
            }
            return;
        }
        ConstraintAnchor constraintAnchor6 = constraintAnchorArr2[1];
        if (constraintAnchor6.f6524f != null) {
            DependencyNode dependencyNodeH8 = h(constraintAnchor6);
            if (dependencyNodeH8 != null) {
                b(this.f6604i, dependencyNodeH8, -this.f6597b.Y[1].f());
                c(this.f6603h, this.f6604i, -1, this.f6600e);
                return;
            }
            return;
        }
        if ((constraintWidget4 instanceof v2.a) || constraintWidget4.M() == null) {
            return;
        }
        b(this.f6603h, this.f6597b.M().f6537e.f6603h, this.f6597b.Z());
        c(this.f6604i, this.f6603h, 1, this.f6600e);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void e() {
        DependencyNode dependencyNode = this.f6603h;
        if (dependencyNode.f6593j) {
            this.f6597b.q1(dependencyNode.f6590g);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void f() {
        this.f6598c = null;
        this.f6603h.c();
        this.f6604i.c();
        this.f6600e.c();
        this.f6602g = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public boolean m() {
        return this.f6599d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.f6597b.f6573w == 0;
    }

    public final void q(int[] iArr, int i11, int i12, int i13, int i14, float f11, int i15) {
        int i16 = i12 - i11;
        int i17 = i14 - i13;
        if (i15 != -1) {
            if (i15 == 0) {
                iArr[0] = (int) ((i17 * f11) + 0.5f);
                iArr[1] = i17;
                return;
            } else {
                if (i15 != 1) {
                    return;
                }
                iArr[0] = i16;
                iArr[1] = (int) ((i16 * f11) + 0.5f);
                return;
            }
        }
        int i18 = (int) ((i17 * f11) + 0.5f);
        int i19 = (int) ((i16 / f11) + 0.5f);
        if (i18 <= i16) {
            iArr[0] = i18;
            iArr[1] = i17;
        } else if (i19 <= i17) {
            iArr[0] = i16;
            iArr[1] = i19;
        }
    }

    public void r() {
        this.f6602g = false;
        this.f6603h.c();
        this.f6603h.f6593j = false;
        this.f6604i.c();
        this.f6604i.f6593j = false;
        this.f6600e.f6593j = false;
    }

    public String toString() {
        return "HorizontalRun " + this.f6597b.v();
    }
}
