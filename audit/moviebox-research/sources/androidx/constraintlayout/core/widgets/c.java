package androidx.constraintlayout.core.widgets;

import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ConstraintWidget f6613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ConstraintWidget f6614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ConstraintWidget f6615c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ConstraintWidget f6616d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ConstraintWidget f6617e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ConstraintWidget f6618f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ConstraintWidget f6619g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList<ConstraintWidget> f6620h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f6621i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f6622j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f6623k = 0.0f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f6624l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f6625m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f6626n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f6627o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f6628p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f6629q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f6630r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f6631s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f6632t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f6633u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f6634v;

    public c(ConstraintWidget constraintWidget, int i11, boolean z11) {
        this.f6613a = constraintWidget;
        this.f6628p = i11;
        this.f6629q = z11;
    }

    public static boolean c(ConstraintWidget constraintWidget, int i11) {
        int i12;
        return constraintWidget.X() != 8 && constraintWidget.f6532b0[i11] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && ((i12 = constraintWidget.f6577y[i11]) == 0 || i12 == 3);
    }

    public void a() {
        if (!this.f6634v) {
            b();
        }
        this.f6634v = true;
    }

    public final void b() {
        int i11 = this.f6628p * 2;
        ConstraintWidget constraintWidget = this.f6613a;
        this.f6627o = true;
        ConstraintWidget constraintWidget2 = constraintWidget;
        boolean z11 = false;
        while (!z11) {
            this.f6621i++;
            ConstraintWidget[] constraintWidgetArr = constraintWidget.P0;
            int i12 = this.f6628p;
            ConstraintWidget constraintWidget3 = null;
            constraintWidgetArr[i12] = null;
            constraintWidget.O0[i12] = null;
            if (constraintWidget.X() != 8) {
                this.f6624l++;
                ConstraintWidget.DimensionBehaviour dimensionBehaviourW = constraintWidget.w(this.f6628p);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviourW != dimensionBehaviour) {
                    this.f6625m += constraintWidget.G(this.f6628p);
                }
                int iF = this.f6625m + constraintWidget.Y[i11].f();
                this.f6625m = iF;
                int i13 = i11 + 1;
                this.f6625m = iF + constraintWidget.Y[i13].f();
                int iF2 = this.f6626n + constraintWidget.Y[i11].f();
                this.f6626n = iF2;
                this.f6626n = iF2 + constraintWidget.Y[i13].f();
                if (this.f6614b == null) {
                    this.f6614b = constraintWidget;
                }
                this.f6616d = constraintWidget;
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.f6532b0;
                int i14 = this.f6628p;
                if (dimensionBehaviourArr[i14] == dimensionBehaviour) {
                    int i15 = constraintWidget.f6577y[i14];
                    if (i15 == 0 || i15 == 3 || i15 == 2) {
                        this.f6622j++;
                        float f11 = constraintWidget.N0[i14];
                        if (f11 > 0.0f) {
                            this.f6623k += f11;
                        }
                        if (c(constraintWidget, i14)) {
                            if (f11 < 0.0f) {
                                this.f6630r = true;
                            } else {
                                this.f6631s = true;
                            }
                            if (this.f6620h == null) {
                                this.f6620h = new ArrayList<>();
                            }
                            this.f6620h.add(constraintWidget);
                        }
                        if (this.f6618f == null) {
                            this.f6618f = constraintWidget;
                        }
                        ConstraintWidget constraintWidget4 = this.f6619g;
                        if (constraintWidget4 != null) {
                            constraintWidget4.O0[this.f6628p] = constraintWidget;
                        }
                        this.f6619g = constraintWidget;
                    }
                    if (this.f6628p == 0) {
                        if (constraintWidget.f6573w != 0 || constraintWidget.f6579z != 0 || constraintWidget.A != 0) {
                            this.f6627o = false;
                        }
                    } else if (constraintWidget.f6575x != 0 || constraintWidget.C != 0 || constraintWidget.D != 0) {
                        this.f6627o = false;
                    }
                    if (constraintWidget.f6540f0 != 0.0f) {
                        this.f6627o = false;
                        this.f6633u = true;
                    }
                }
            }
            if (constraintWidget2 != constraintWidget) {
                constraintWidget2.P0[this.f6628p] = constraintWidget;
            }
            ConstraintAnchor constraintAnchor = constraintWidget.Y[i11 + 1].f6524f;
            if (constraintAnchor != null) {
                ConstraintWidget constraintWidget5 = constraintAnchor.f6522d;
                ConstraintAnchor constraintAnchor2 = constraintWidget5.Y[i11].f6524f;
                if (constraintAnchor2 != null && constraintAnchor2.f6522d == constraintWidget) {
                    constraintWidget3 = constraintWidget5;
                }
            }
            if (constraintWidget3 == null) {
                constraintWidget3 = constraintWidget;
                z11 = true;
            }
            constraintWidget2 = constraintWidget;
            constraintWidget = constraintWidget3;
        }
        ConstraintWidget constraintWidget6 = this.f6614b;
        if (constraintWidget6 != null) {
            this.f6625m -= constraintWidget6.Y[i11].f();
        }
        ConstraintWidget constraintWidget7 = this.f6616d;
        if (constraintWidget7 != null) {
            this.f6625m -= constraintWidget7.Y[i11 + 1].f();
        }
        this.f6615c = constraintWidget;
        if (this.f6628p == 0 && this.f6629q) {
            this.f6617e = constraintWidget;
        } else {
            this.f6617e = this.f6613a;
        }
        this.f6632t = this.f6631s && this.f6630r;
    }
}
