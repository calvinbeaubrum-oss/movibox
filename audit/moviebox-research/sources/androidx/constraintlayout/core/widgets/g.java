package androidx.constraintlayout.core.widgets;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean[] f6699a = new boolean[3];

    public static void a(d dVar, androidx.constraintlayout.core.d dVar2, ConstraintWidget constraintWidget) {
        constraintWidget.f6567t = -1;
        constraintWidget.f6569u = -1;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = dVar.f6532b0[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (dimensionBehaviour != dimensionBehaviour2 && constraintWidget.f6532b0[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int i11 = constraintWidget.Q.f6525g;
            int iY = dVar.Y() - constraintWidget.S.f6525g;
            ConstraintAnchor constraintAnchor = constraintWidget.Q;
            constraintAnchor.f6527i = dVar2.q(constraintAnchor);
            ConstraintAnchor constraintAnchor2 = constraintWidget.S;
            constraintAnchor2.f6527i = dVar2.q(constraintAnchor2);
            dVar2.f(constraintWidget.Q.f6527i, i11);
            dVar2.f(constraintWidget.S.f6527i, iY);
            constraintWidget.f6567t = 2;
            constraintWidget.S0(i11, iY);
        }
        if (dVar.f6532b0[1] == dimensionBehaviour2 || constraintWidget.f6532b0[1] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            return;
        }
        int i12 = constraintWidget.R.f6525g;
        int iZ = dVar.z() - constraintWidget.T.f6525g;
        ConstraintAnchor constraintAnchor3 = constraintWidget.R;
        constraintAnchor3.f6527i = dVar2.q(constraintAnchor3);
        ConstraintAnchor constraintAnchor4 = constraintWidget.T;
        constraintAnchor4.f6527i = dVar2.q(constraintAnchor4);
        dVar2.f(constraintWidget.R.f6527i, i12);
        dVar2.f(constraintWidget.T.f6527i, iZ);
        if (constraintWidget.f6556n0 > 0 || constraintWidget.X() == 8) {
            ConstraintAnchor constraintAnchor5 = constraintWidget.U;
            constraintAnchor5.f6527i = dVar2.q(constraintAnchor5);
            dVar2.f(constraintWidget.U.f6527i, constraintWidget.f6556n0 + i12);
        }
        constraintWidget.f6569u = 2;
        constraintWidget.j1(i12, iZ);
    }

    public static final boolean b(int i11, int i12) {
        return (i11 & i12) == i12;
    }
}
