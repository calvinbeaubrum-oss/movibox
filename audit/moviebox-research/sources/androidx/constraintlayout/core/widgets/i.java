package androidx.constraintlayout.core.widgets;

import java.util.HashSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class i extends v2.b {
    public int X0 = 0;
    public int Y0 = 0;
    public int Z0 = 0;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    public int f6700a1 = 0;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public int f6701b1 = 0;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    public int f6702c1 = 0;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    public int f6703d1 = 0;

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    public int f6704e1 = 0;

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    public boolean f6705f1 = false;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public int f6706g1 = 0;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public int f6707h1 = 0;

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    public w2.b.a f6708i1 = new w2.b.a();

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    public w2.b.InterfaceC0880b f6709j1 = null;

    public int A1() {
        return this.f6707h1;
    }

    public int B1() {
        return this.f6706g1;
    }

    public int C1() {
        return this.Y0;
    }

    public int D1() {
        return this.f6703d1;
    }

    public int E1() {
        return this.f6704e1;
    }

    public int F1() {
        return this.X0;
    }

    public void G1(int i11, int i12, int i13, int i14) {
    }

    public void H1(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i11, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i12) {
        while (this.f6709j1 == null && M() != null) {
            this.f6709j1 = ((d) M()).N1();
        }
        w2.b.a aVar = this.f6708i1;
        aVar.f79153a = dimensionBehaviour;
        aVar.f79154b = dimensionBehaviour2;
        aVar.f79155c = i11;
        aVar.f79156d = i12;
        this.f6709j1.b(constraintWidget, aVar);
        constraintWidget.o1(this.f6708i1.f79157e);
        constraintWidget.P0(this.f6708i1.f79158f);
        constraintWidget.O0(this.f6708i1.f79160h);
        constraintWidget.E0(this.f6708i1.f79159g);
    }

    public boolean I1() {
        ConstraintWidget constraintWidget = this.f6534c0;
        w2.b.InterfaceC0880b interfaceC0880bN1 = constraintWidget != null ? ((d) constraintWidget).N1() : null;
        if (interfaceC0880bN1 == null) {
            return false;
        }
        for (int i11 = 0; i11 < this.W0; i11++) {
            ConstraintWidget constraintWidget2 = this.V0[i11];
            if (constraintWidget2 != null && !(constraintWidget2 instanceof f)) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviourW = constraintWidget2.w(0);
                ConstraintWidget.DimensionBehaviour dimensionBehaviourW2 = constraintWidget2.w(1);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviourW != dimensionBehaviour || constraintWidget2.f6573w == 1 || dimensionBehaviourW2 != dimensionBehaviour || constraintWidget2.f6575x == 1) {
                    if (dimensionBehaviourW == dimensionBehaviour) {
                        dimensionBehaviourW = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    }
                    if (dimensionBehaviourW2 == dimensionBehaviour) {
                        dimensionBehaviourW2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    }
                    w2.b.a aVar = this.f6708i1;
                    aVar.f79153a = dimensionBehaviourW;
                    aVar.f79154b = dimensionBehaviourW2;
                    aVar.f79155c = constraintWidget2.Y();
                    this.f6708i1.f79156d = constraintWidget2.z();
                    interfaceC0880bN1.b(constraintWidget2, this.f6708i1);
                    constraintWidget2.o1(this.f6708i1.f79157e);
                    constraintWidget2.P0(this.f6708i1.f79158f);
                    constraintWidget2.E0(this.f6708i1.f79159g);
                }
            }
        }
        return true;
    }

    public boolean J1() {
        return this.f6705f1;
    }

    public void K1(boolean z11) {
        this.f6705f1 = z11;
    }

    public void L1(int i11, int i12) {
        this.f6706g1 = i11;
        this.f6707h1 = i12;
    }

    public void M1(int i11) {
        this.Z0 = i11;
        this.X0 = i11;
        this.f6700a1 = i11;
        this.Y0 = i11;
        this.f6701b1 = i11;
        this.f6702c1 = i11;
    }

    public void N1(int i11) {
        this.Y0 = i11;
    }

    public void O1(int i11) {
        this.f6702c1 = i11;
    }

    public void P1(int i11) {
        this.Z0 = i11;
        this.f6703d1 = i11;
    }

    public void Q1(int i11) {
        this.f6700a1 = i11;
        this.f6704e1 = i11;
    }

    public void R1(int i11) {
        this.f6701b1 = i11;
        this.f6703d1 = i11;
        this.f6704e1 = i11;
    }

    public void S1(int i11) {
        this.X0 = i11;
    }

    @Override // v2.b, v2.a
    public void c(d dVar) {
        y1();
    }

    public void x1(boolean z11) {
        int i11 = this.f6701b1;
        if (i11 > 0 || this.f6702c1 > 0) {
            if (z11) {
                this.f6703d1 = this.f6702c1;
                this.f6704e1 = i11;
            } else {
                this.f6703d1 = i11;
                this.f6704e1 = this.f6702c1;
            }
        }
    }

    public void y1() {
        for (int i11 = 0; i11 < this.W0; i11++) {
            ConstraintWidget constraintWidget = this.V0[i11];
            if (constraintWidget != null) {
                constraintWidget.Y0(true);
            }
        }
    }

    public boolean z1(HashSet<ConstraintWidget> hashSet) {
        for (int i11 = 0; i11 < this.W0; i11++) {
            if (hashSet.contains(this.V0[i11])) {
                return true;
            }
        }
        return false;
    }
}
