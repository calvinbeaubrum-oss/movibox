package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import w2.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class WidgetRun implements w2.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ConstraintWidget f6597b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public i f6598c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ConstraintWidget.DimensionBehaviour f6599d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public androidx.constraintlayout.core.widgets.analyzer.a f6600e = new androidx.constraintlayout.core.widgets.analyzer.a(this);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f6601f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f6602g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public DependencyNode f6603h = new DependencyNode(this);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public DependencyNode f6604i = new DependencyNode(this);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public RunType f6605j = RunType.NONE;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public enum RunType {
        NONE,
        START,
        END,
        CENTER
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6606a;

        static {
            int[] iArr = new int[ConstraintAnchor.Type.values().length];
            f6606a = iArr;
            try {
                iArr[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6606a[ConstraintAnchor.Type.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6606a[ConstraintAnchor.Type.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6606a[ConstraintAnchor.Type.BASELINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6606a[ConstraintAnchor.Type.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public WidgetRun(ConstraintWidget constraintWidget) {
        this.f6597b = constraintWidget;
    }

    @Override // w2.d
    public void a(w2.d dVar) {
    }

    public final void b(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i11) {
        dependencyNode.f6595l.add(dependencyNode2);
        dependencyNode.f6589f = i11;
        dependencyNode2.f6594k.add(dependencyNode);
    }

    public final void c(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i11, androidx.constraintlayout.core.widgets.analyzer.a aVar) {
        dependencyNode.f6595l.add(dependencyNode2);
        dependencyNode.f6595l.add(this.f6600e);
        dependencyNode.f6591h = i11;
        dependencyNode.f6592i = aVar;
        dependencyNode2.f6594k.add(dependencyNode);
        aVar.f6594k.add(dependencyNode);
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public final int g(int i11, int i12) {
        int iMax;
        if (i12 == 0) {
            ConstraintWidget constraintWidget = this.f6597b;
            int i13 = constraintWidget.A;
            iMax = Math.max(constraintWidget.f6579z, i11);
            if (i13 > 0) {
                iMax = Math.min(i13, i11);
            }
            if (iMax == i11) {
                return i11;
            }
        } else {
            ConstraintWidget constraintWidget2 = this.f6597b;
            int i14 = constraintWidget2.D;
            iMax = Math.max(constraintWidget2.C, i11);
            if (i14 > 0) {
                iMax = Math.min(i14, i11);
            }
            if (iMax == i11) {
                return i11;
            }
        }
        return iMax;
    }

    public final DependencyNode h(ConstraintAnchor constraintAnchor) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f6524f;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.f6522d;
        int i11 = a.f6606a[constraintAnchor2.f6523e.ordinal()];
        if (i11 == 1) {
            return constraintWidget.f6537e.f6603h;
        }
        if (i11 == 2) {
            return constraintWidget.f6537e.f6604i;
        }
        if (i11 == 3) {
            return constraintWidget.f6539f.f6603h;
        }
        if (i11 == 4) {
            return constraintWidget.f6539f.f6610k;
        }
        if (i11 != 5) {
            return null;
        }
        return constraintWidget.f6539f.f6604i;
    }

    public final DependencyNode i(ConstraintAnchor constraintAnchor, int i11) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f6524f;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.f6522d;
        WidgetRun widgetRun = i11 == 0 ? constraintWidget.f6537e : constraintWidget.f6539f;
        int i12 = a.f6606a[constraintAnchor2.f6523e.ordinal()];
        if (i12 != 1) {
            if (i12 != 2) {
                if (i12 != 3) {
                    if (i12 != 5) {
                        return null;
                    }
                }
            }
            return widgetRun.f6604i;
        }
        return widgetRun.f6603h;
    }

    public long j() {
        androidx.constraintlayout.core.widgets.analyzer.a aVar = this.f6600e;
        if (aVar.f6593j) {
            return aVar.f6590g;
        }
        return 0L;
    }

    public boolean k() {
        return this.f6602g;
    }

    public final void l(int i11, int i12) {
        int i13 = this.f6596a;
        if (i13 == 0) {
            this.f6600e.d(g(i12, i11));
            return;
        }
        if (i13 == 1) {
            this.f6600e.d(Math.min(g(this.f6600e.f6607m, i11), i12));
            return;
        }
        if (i13 == 2) {
            ConstraintWidget constraintWidgetM = this.f6597b.M();
            if (constraintWidgetM != null) {
                androidx.constraintlayout.core.widgets.analyzer.a aVar = (i11 == 0 ? constraintWidgetM.f6537e : constraintWidgetM.f6539f).f6600e;
                if (aVar.f6593j) {
                    ConstraintWidget constraintWidget = this.f6597b;
                    this.f6600e.d(g((int) ((aVar.f6590g * (i11 == 0 ? constraintWidget.B : constraintWidget.E)) + 0.5f), i11));
                    return;
                }
                return;
            }
            return;
        }
        if (i13 != 3) {
            return;
        }
        ConstraintWidget constraintWidget2 = this.f6597b;
        WidgetRun widgetRun = constraintWidget2.f6537e;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = widgetRun.f6599d;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (dimensionBehaviour == dimensionBehaviour2 && widgetRun.f6596a == 3) {
            d dVar = constraintWidget2.f6539f;
            if (dVar.f6599d == dimensionBehaviour2 && dVar.f6596a == 3) {
                return;
            }
        }
        if (i11 == 0) {
            widgetRun = constraintWidget2.f6539f;
        }
        if (widgetRun.f6600e.f6593j) {
            float fX = constraintWidget2.x();
            this.f6600e.d(i11 == 1 ? (int) ((widgetRun.f6600e.f6590g / fX) + 0.5f) : (int) ((fX * widgetRun.f6600e.f6590g) + 0.5f));
        }
    }

    public abstract boolean m();

    public void n(w2.d dVar, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i11) {
        DependencyNode dependencyNodeH = h(constraintAnchor);
        DependencyNode dependencyNodeH2 = h(constraintAnchor2);
        if (dependencyNodeH.f6593j && dependencyNodeH2.f6593j) {
            int iF = dependencyNodeH.f6590g + constraintAnchor.f();
            int iF2 = dependencyNodeH2.f6590g - constraintAnchor2.f();
            int i12 = iF2 - iF;
            if (!this.f6600e.f6593j && this.f6599d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                l(i11, i12);
            }
            androidx.constraintlayout.core.widgets.analyzer.a aVar = this.f6600e;
            if (aVar.f6593j) {
                if (aVar.f6590g == i12) {
                    this.f6603h.d(iF);
                    this.f6604i.d(iF2);
                    return;
                }
                ConstraintWidget constraintWidget = this.f6597b;
                float fA = i11 == 0 ? constraintWidget.A() : constraintWidget.T();
                if (dependencyNodeH == dependencyNodeH2) {
                    iF = dependencyNodeH.f6590g;
                    iF2 = dependencyNodeH2.f6590g;
                    fA = 0.5f;
                }
                this.f6603h.d((int) (iF + 0.5f + (((iF2 - iF) - this.f6600e.f6590g) * fA)));
                this.f6604i.d(this.f6603h.f6590g + this.f6600e.f6590g);
            }
        }
    }

    public void o(w2.d dVar) {
    }

    public void p(w2.d dVar) {
    }
}
