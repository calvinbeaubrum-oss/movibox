package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends WidgetRun {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public DependencyNode f6610k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public androidx.constraintlayout.core.widgets.analyzer.a f6611l;

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6612a;

        static {
            int[] iArr = new int[WidgetRun.RunType.values().length];
            f6612a = iArr;
            try {
                iArr[WidgetRun.RunType.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6612a[WidgetRun.RunType.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6612a[WidgetRun.RunType.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public d(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        DependencyNode dependencyNode = new DependencyNode(this);
        this.f6610k = dependencyNode;
        this.f6611l = null;
        this.f6603h.f6588e = DependencyNode.Type.TOP;
        this.f6604i.f6588e = DependencyNode.Type.BOTTOM;
        dependencyNode.f6588e = DependencyNode.Type.BASELINE;
        this.f6601f = 1;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, w2.d
    public void a(w2.d dVar) {
        float f11;
        float fX;
        float fX2;
        int i11;
        int i12 = a.f6612a[this.f6605j.ordinal()];
        if (i12 == 1) {
            p(dVar);
        } else if (i12 == 2) {
            o(dVar);
        } else if (i12 == 3) {
            ConstraintWidget constraintWidget = this.f6597b;
            n(dVar, constraintWidget.R, constraintWidget.T, 1);
            return;
        }
        androidx.constraintlayout.core.widgets.analyzer.a aVar = this.f6600e;
        if (aVar.f6586c && !aVar.f6593j && this.f6599d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget2 = this.f6597b;
            int i13 = constraintWidget2.f6575x;
            if (i13 == 2) {
                ConstraintWidget constraintWidgetM = constraintWidget2.M();
                if (constraintWidgetM != null) {
                    androidx.constraintlayout.core.widgets.analyzer.a aVar2 = constraintWidgetM.f6539f.f6600e;
                    if (aVar2.f6593j) {
                        this.f6600e.d((int) ((aVar2.f6590g * this.f6597b.E) + 0.5f));
                    }
                }
            } else if (i13 == 3 && constraintWidget2.f6537e.f6600e.f6593j) {
                int iY = constraintWidget2.y();
                if (iY != -1) {
                    if (iY == 0) {
                        ConstraintWidget constraintWidget3 = this.f6597b;
                        fX2 = constraintWidget3.f6537e.f6600e.f6590g * constraintWidget3.x();
                        i11 = (int) (fX2 + 0.5f);
                    } else if (iY != 1) {
                        i11 = 0;
                    } else {
                        ConstraintWidget constraintWidget4 = this.f6597b;
                        f11 = constraintWidget4.f6537e.f6600e.f6590g;
                        fX = constraintWidget4.x();
                    }
                    this.f6600e.d(i11);
                } else {
                    ConstraintWidget constraintWidget5 = this.f6597b;
                    f11 = constraintWidget5.f6537e.f6600e.f6590g;
                    fX = constraintWidget5.x();
                }
                fX2 = f11 / fX;
                i11 = (int) (fX2 + 0.5f);
                this.f6600e.d(i11);
            }
        }
        DependencyNode dependencyNode = this.f6603h;
        if (dependencyNode.f6586c) {
            DependencyNode dependencyNode2 = this.f6604i;
            if (dependencyNode2.f6586c) {
                if (dependencyNode.f6593j && dependencyNode2.f6593j && this.f6600e.f6593j) {
                    return;
                }
                if (!this.f6600e.f6593j && this.f6599d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    ConstraintWidget constraintWidget6 = this.f6597b;
                    if (constraintWidget6.f6573w == 0 && !constraintWidget6.m0()) {
                        DependencyNode dependencyNode3 = this.f6603h.f6595l.get(0);
                        DependencyNode dependencyNode4 = this.f6604i.f6595l.get(0);
                        int i14 = dependencyNode3.f6590g;
                        DependencyNode dependencyNode5 = this.f6603h;
                        int i15 = i14 + dependencyNode5.f6589f;
                        int i16 = dependencyNode4.f6590g + this.f6604i.f6589f;
                        dependencyNode5.d(i15);
                        this.f6604i.d(i16);
                        this.f6600e.d(i16 - i15);
                        return;
                    }
                }
                if (!this.f6600e.f6593j && this.f6599d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.f6596a == 1 && this.f6603h.f6595l.size() > 0 && this.f6604i.f6595l.size() > 0) {
                    DependencyNode dependencyNode6 = this.f6603h.f6595l.get(0);
                    int i17 = (this.f6604i.f6595l.get(0).f6590g + this.f6604i.f6589f) - (dependencyNode6.f6590g + this.f6603h.f6589f);
                    androidx.constraintlayout.core.widgets.analyzer.a aVar3 = this.f6600e;
                    int i18 = aVar3.f6607m;
                    if (i17 < i18) {
                        aVar3.d(i17);
                    } else {
                        aVar3.d(i18);
                    }
                }
                if (this.f6600e.f6593j && this.f6603h.f6595l.size() > 0 && this.f6604i.f6595l.size() > 0) {
                    DependencyNode dependencyNode7 = this.f6603h.f6595l.get(0);
                    DependencyNode dependencyNode8 = this.f6604i.f6595l.get(0);
                    int i19 = dependencyNode7.f6590g + this.f6603h.f6589f;
                    int i21 = dependencyNode8.f6590g + this.f6604i.f6589f;
                    float fT = this.f6597b.T();
                    if (dependencyNode7 == dependencyNode8) {
                        i19 = dependencyNode7.f6590g;
                        i21 = dependencyNode8.f6590g;
                        fT = 0.5f;
                    }
                    this.f6603h.d((int) (i19 + 0.5f + (((i21 - i19) - this.f6600e.f6590g) * fT)));
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
            this.f6600e.d(constraintWidget.z());
        }
        if (!this.f6600e.f6593j) {
            this.f6599d = this.f6597b.V();
            if (this.f6597b.b0()) {
                this.f6611l = new w2.a(this);
            }
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.f6599d;
            if (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (constraintWidgetM2 = this.f6597b.M()) != null && constraintWidgetM2.V() == ConstraintWidget.DimensionBehaviour.FIXED) {
                    int iZ = (constraintWidgetM2.z() - this.f6597b.R.f()) - this.f6597b.T.f();
                    b(this.f6603h, constraintWidgetM2.f6539f.f6603h, this.f6597b.R.f());
                    b(this.f6604i, constraintWidgetM2.f6539f.f6604i, -this.f6597b.T.f());
                    this.f6600e.d(iZ);
                    return;
                }
                if (this.f6599d == ConstraintWidget.DimensionBehaviour.FIXED) {
                    this.f6600e.d(this.f6597b.z());
                }
            }
        } else if (this.f6599d == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (constraintWidgetM = this.f6597b.M()) != null && constraintWidgetM.V() == ConstraintWidget.DimensionBehaviour.FIXED) {
            b(this.f6603h, constraintWidgetM.f6539f.f6603h, this.f6597b.R.f());
            b(this.f6604i, constraintWidgetM.f6539f.f6604i, -this.f6597b.T.f());
            return;
        }
        androidx.constraintlayout.core.widgets.analyzer.a aVar = this.f6600e;
        boolean z11 = aVar.f6593j;
        if (z11) {
            ConstraintWidget constraintWidget2 = this.f6597b;
            if (constraintWidget2.f6529a) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget2.Y;
                ConstraintAnchor constraintAnchor = constraintAnchorArr[2];
                ConstraintAnchor constraintAnchor2 = constraintAnchor.f6524f;
                if (constraintAnchor2 != null && constraintAnchorArr[3].f6524f != null) {
                    if (constraintWidget2.m0()) {
                        this.f6603h.f6589f = this.f6597b.Y[2].f();
                        this.f6604i.f6589f = -this.f6597b.Y[3].f();
                    } else {
                        DependencyNode dependencyNodeH = h(this.f6597b.Y[2]);
                        if (dependencyNodeH != null) {
                            b(this.f6603h, dependencyNodeH, this.f6597b.Y[2].f());
                        }
                        DependencyNode dependencyNodeH2 = h(this.f6597b.Y[3]);
                        if (dependencyNodeH2 != null) {
                            b(this.f6604i, dependencyNodeH2, -this.f6597b.Y[3].f());
                        }
                        this.f6603h.f6585b = true;
                        this.f6604i.f6585b = true;
                    }
                    if (this.f6597b.b0()) {
                        b(this.f6610k, this.f6603h, this.f6597b.r());
                        return;
                    }
                    return;
                }
                if (constraintAnchor2 != null) {
                    DependencyNode dependencyNodeH3 = h(constraintAnchor);
                    if (dependencyNodeH3 != null) {
                        b(this.f6603h, dependencyNodeH3, this.f6597b.Y[2].f());
                        b(this.f6604i, this.f6603h, this.f6600e.f6590g);
                        if (this.f6597b.b0()) {
                            b(this.f6610k, this.f6603h, this.f6597b.r());
                            return;
                        }
                        return;
                    }
                    return;
                }
                ConstraintAnchor constraintAnchor3 = constraintAnchorArr[3];
                if (constraintAnchor3.f6524f != null) {
                    DependencyNode dependencyNodeH4 = h(constraintAnchor3);
                    if (dependencyNodeH4 != null) {
                        b(this.f6604i, dependencyNodeH4, -this.f6597b.Y[3].f());
                        b(this.f6603h, this.f6604i, -this.f6600e.f6590g);
                    }
                    if (this.f6597b.b0()) {
                        b(this.f6610k, this.f6603h, this.f6597b.r());
                        return;
                    }
                    return;
                }
                ConstraintAnchor constraintAnchor4 = constraintAnchorArr[4];
                if (constraintAnchor4.f6524f != null) {
                    DependencyNode dependencyNodeH5 = h(constraintAnchor4);
                    if (dependencyNodeH5 != null) {
                        b(this.f6610k, dependencyNodeH5, 0);
                        b(this.f6603h, this.f6610k, -this.f6597b.r());
                        b(this.f6604i, this.f6603h, this.f6600e.f6590g);
                        return;
                    }
                    return;
                }
                if ((constraintWidget2 instanceof v2.a) || constraintWidget2.M() == null || this.f6597b.q(ConstraintAnchor.Type.CENTER).f6524f != null) {
                    return;
                }
                b(this.f6603h, this.f6597b.M().f6539f.f6603h, this.f6597b.a0());
                b(this.f6604i, this.f6603h, this.f6600e.f6590g);
                if (this.f6597b.b0()) {
                    b(this.f6610k, this.f6603h, this.f6597b.r());
                    return;
                }
                return;
            }
        }
        if (z11 || this.f6599d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            aVar.b(this);
        } else {
            ConstraintWidget constraintWidget3 = this.f6597b;
            int i11 = constraintWidget3.f6575x;
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
            } else if (i11 == 3 && !constraintWidget3.m0()) {
                ConstraintWidget constraintWidget4 = this.f6597b;
                if (constraintWidget4.f6573w != 3) {
                    androidx.constraintlayout.core.widgets.analyzer.a aVar4 = constraintWidget4.f6537e.f6600e;
                    this.f6600e.f6595l.add(aVar4);
                    aVar4.f6594k.add(this.f6600e);
                    androidx.constraintlayout.core.widgets.analyzer.a aVar5 = this.f6600e;
                    aVar5.f6585b = true;
                    aVar5.f6594k.add(this.f6603h);
                    this.f6600e.f6594k.add(this.f6604i);
                }
            }
        }
        ConstraintWidget constraintWidget5 = this.f6597b;
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget5.Y;
        ConstraintAnchor constraintAnchor5 = constraintAnchorArr2[2];
        ConstraintAnchor constraintAnchor6 = constraintAnchor5.f6524f;
        if (constraintAnchor6 != null && constraintAnchorArr2[3].f6524f != null) {
            if (constraintWidget5.m0()) {
                this.f6603h.f6589f = this.f6597b.Y[2].f();
                this.f6604i.f6589f = -this.f6597b.Y[3].f();
            } else {
                DependencyNode dependencyNodeH6 = h(this.f6597b.Y[2]);
                DependencyNode dependencyNodeH7 = h(this.f6597b.Y[3]);
                if (dependencyNodeH6 != null) {
                    dependencyNodeH6.b(this);
                }
                if (dependencyNodeH7 != null) {
                    dependencyNodeH7.b(this);
                }
                this.f6605j = WidgetRun.RunType.CENTER;
            }
            if (this.f6597b.b0()) {
                c(this.f6610k, this.f6603h, 1, this.f6611l);
            }
        } else if (constraintAnchor6 != null) {
            DependencyNode dependencyNodeH8 = h(constraintAnchor5);
            if (dependencyNodeH8 != null) {
                b(this.f6603h, dependencyNodeH8, this.f6597b.Y[2].f());
                c(this.f6604i, this.f6603h, 1, this.f6600e);
                if (this.f6597b.b0()) {
                    c(this.f6610k, this.f6603h, 1, this.f6611l);
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.f6599d;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviour2 == dimensionBehaviour3 && this.f6597b.x() > 0.0f) {
                    c cVar = this.f6597b.f6537e;
                    if (cVar.f6599d == dimensionBehaviour3) {
                        cVar.f6600e.f6594k.add(this.f6600e);
                        this.f6600e.f6595l.add(this.f6597b.f6537e.f6600e);
                        this.f6600e.f6584a = this;
                    }
                }
            }
        } else {
            ConstraintAnchor constraintAnchor7 = constraintAnchorArr2[3];
            if (constraintAnchor7.f6524f != null) {
                DependencyNode dependencyNodeH9 = h(constraintAnchor7);
                if (dependencyNodeH9 != null) {
                    b(this.f6604i, dependencyNodeH9, -this.f6597b.Y[3].f());
                    c(this.f6603h, this.f6604i, -1, this.f6600e);
                    if (this.f6597b.b0()) {
                        c(this.f6610k, this.f6603h, 1, this.f6611l);
                    }
                }
            } else {
                ConstraintAnchor constraintAnchor8 = constraintAnchorArr2[4];
                if (constraintAnchor8.f6524f != null) {
                    DependencyNode dependencyNodeH10 = h(constraintAnchor8);
                    if (dependencyNodeH10 != null) {
                        b(this.f6610k, dependencyNodeH10, 0);
                        c(this.f6603h, this.f6610k, -1, this.f6611l);
                        c(this.f6604i, this.f6603h, 1, this.f6600e);
                    }
                } else if (!(constraintWidget5 instanceof v2.a) && constraintWidget5.M() != null) {
                    b(this.f6603h, this.f6597b.M().f6539f.f6603h, this.f6597b.a0());
                    c(this.f6604i, this.f6603h, 1, this.f6600e);
                    if (this.f6597b.b0()) {
                        c(this.f6610k, this.f6603h, 1, this.f6611l);
                    }
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = this.f6599d;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (dimensionBehaviour4 == dimensionBehaviour5 && this.f6597b.x() > 0.0f) {
                        c cVar2 = this.f6597b.f6537e;
                        if (cVar2.f6599d == dimensionBehaviour5) {
                            cVar2.f6600e.f6594k.add(this.f6600e);
                            this.f6600e.f6595l.add(this.f6597b.f6537e.f6600e);
                            this.f6600e.f6584a = this;
                        }
                    }
                }
            }
        }
        if (this.f6600e.f6595l.size() == 0) {
            this.f6600e.f6586c = true;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void e() {
        DependencyNode dependencyNode = this.f6603h;
        if (dependencyNode.f6593j) {
            this.f6597b.r1(dependencyNode.f6590g);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void f() {
        this.f6598c = null;
        this.f6603h.c();
        this.f6604i.c();
        this.f6610k.c();
        this.f6600e.c();
        this.f6602g = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public boolean m() {
        return this.f6599d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.f6597b.f6575x == 0;
    }

    public void q() {
        this.f6602g = false;
        this.f6603h.c();
        this.f6603h.f6593j = false;
        this.f6604i.c();
        this.f6604i.f6593j = false;
        this.f6610k.c();
        this.f6610k.f6593j = false;
        this.f6600e.f6593j = false;
    }

    public String toString() {
        return "VerticalRun " + this.f6597b.v();
    }
}
