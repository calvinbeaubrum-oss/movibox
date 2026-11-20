package w2;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class g {
    public static j a(ConstraintWidget constraintWidget, int i11, ArrayList<j> arrayList, j jVar) {
        int iW1;
        int i12 = i11 == 0 ? constraintWidget.S0 : constraintWidget.T0;
        if (i12 != -1 && (jVar == null || i12 != jVar.f79187b)) {
            for (int i13 = 0; i13 < arrayList.size(); i13++) {
                j jVar2 = arrayList.get(i13);
                if (jVar2.c() == i12) {
                    if (jVar != null) {
                        jVar.g(i11, jVar2);
                        arrayList.remove(jVar);
                    }
                    jVar = jVar2;
                    break;
                }
            }
        } else if (i12 != -1) {
            return jVar;
        }
        if (jVar == null) {
            if ((constraintWidget instanceof v2.b) && (iW1 = ((v2.b) constraintWidget).w1(i11)) != -1) {
                for (int i14 = 0; i14 < arrayList.size(); i14++) {
                    j jVar3 = arrayList.get(i14);
                    if (jVar3.c() == iW1) {
                        jVar = jVar3;
                        break;
                    }
                }
            }
            if (jVar == null) {
                jVar = new j(i11);
            }
            arrayList.add(jVar);
        }
        if (jVar.a(constraintWidget)) {
            if (constraintWidget instanceof androidx.constraintlayout.core.widgets.f) {
                androidx.constraintlayout.core.widgets.f fVar = (androidx.constraintlayout.core.widgets.f) constraintWidget;
                fVar.v1().c(fVar.w1() == 0 ? 1 : 0, arrayList, jVar);
            }
            if (i11 == 0) {
                constraintWidget.S0 = jVar.c();
                constraintWidget.Q.c(i11, arrayList, jVar);
                constraintWidget.S.c(i11, arrayList, jVar);
            } else {
                constraintWidget.T0 = jVar.c();
                constraintWidget.R.c(i11, arrayList, jVar);
                constraintWidget.U.c(i11, arrayList, jVar);
                constraintWidget.T.c(i11, arrayList, jVar);
            }
            constraintWidget.X.c(i11, arrayList, jVar);
        }
        return jVar;
    }

    public static j b(ArrayList<j> arrayList, int i11) {
        int size = arrayList.size();
        for (int i12 = 0; i12 < size; i12++) {
            j jVar = arrayList.get(i12);
            if (i11 == jVar.f79187b) {
                return jVar;
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:176:0x0348  */
    public static boolean c(androidx.constraintlayout.core.widgets.d dVar, b.InterfaceC0880b interfaceC0880b) {
        j jVar;
        j jVar2;
        ArrayList<ConstraintWidget> arrayListV1 = dVar.v1();
        int size = arrayListV1.size();
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            ConstraintWidget constraintWidget = arrayListV1.get(i12);
            if (!d(dVar.C(), dVar.V(), constraintWidget.C(), constraintWidget.V()) || (constraintWidget instanceof androidx.constraintlayout.core.widgets.e)) {
                return false;
            }
        }
        int i13 = 0;
        ArrayList arrayList = null;
        ArrayList<v2.b> arrayList2 = null;
        ArrayList arrayList3 = null;
        ArrayList<v2.b> arrayList4 = null;
        ArrayList arrayList5 = null;
        ArrayList arrayList6 = null;
        while (i13 < size) {
            ConstraintWidget constraintWidget2 = arrayListV1.get(i13);
            if (!d(dVar.C(), dVar.V(), constraintWidget2.C(), constraintWidget2.V())) {
                androidx.constraintlayout.core.widgets.d.X1(i11, constraintWidget2, interfaceC0880b, dVar.f6660z1, b.a.f79150k);
            }
            boolean z11 = constraintWidget2 instanceof androidx.constraintlayout.core.widgets.f;
            if (z11) {
                androidx.constraintlayout.core.widgets.f fVar = (androidx.constraintlayout.core.widgets.f) constraintWidget2;
                if (fVar.w1() == 0) {
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList();
                    }
                    arrayList3.add(fVar);
                }
                if (fVar.w1() == 1) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(fVar);
                }
            }
            if (constraintWidget2 instanceof v2.b) {
                if (constraintWidget2 instanceof androidx.constraintlayout.core.widgets.a) {
                    androidx.constraintlayout.core.widgets.a aVar = (androidx.constraintlayout.core.widgets.a) constraintWidget2;
                    if (aVar.B1() == 0) {
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        arrayList2.add(aVar);
                    }
                    if (aVar.B1() == 1) {
                        if (arrayList4 == null) {
                            arrayList4 = new ArrayList();
                        }
                        arrayList4.add(aVar);
                    }
                } else {
                    v2.b bVar = (v2.b) constraintWidget2;
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    arrayList2.add(bVar);
                    if (arrayList4 == null) {
                        arrayList4 = new ArrayList();
                    }
                    arrayList4.add(bVar);
                }
            }
            if (constraintWidget2.Q.f6524f == null && constraintWidget2.S.f6524f == null && !z11 && !(constraintWidget2 instanceof androidx.constraintlayout.core.widgets.a)) {
                if (arrayList5 == null) {
                    arrayList5 = new ArrayList();
                }
                arrayList5.add(constraintWidget2);
            }
            if (constraintWidget2.R.f6524f == null && constraintWidget2.T.f6524f == null && constraintWidget2.U.f6524f == null && !z11 && !(constraintWidget2 instanceof androidx.constraintlayout.core.widgets.a)) {
                if (arrayList6 == null) {
                    arrayList6 = new ArrayList();
                }
                arrayList6.add(constraintWidget2);
            }
            i13++;
            i11 = 0;
        }
        ArrayList<j> arrayList7 = new ArrayList<>();
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                a((androidx.constraintlayout.core.widgets.f) it.next(), 0, arrayList7, null);
            }
        }
        int i14 = 0;
        j jVar3 = null;
        if (arrayList2 != null) {
            for (v2.b bVar2 : arrayList2) {
                j jVarA = a(bVar2, i14, arrayList7, jVar3);
                bVar2.v1(arrayList7, i14, jVarA);
                jVarA.b(arrayList7);
                i14 = 0;
                jVar3 = null;
            }
        }
        ConstraintAnchor constraintAnchorQ = dVar.q(ConstraintAnchor.Type.LEFT);
        if (constraintAnchorQ.d() != null) {
            Iterator<ConstraintAnchor> it2 = constraintAnchorQ.d().iterator();
            while (it2.hasNext()) {
                a(it2.next().f6522d, 0, arrayList7, null);
            }
        }
        ConstraintAnchor constraintAnchorQ2 = dVar.q(ConstraintAnchor.Type.RIGHT);
        if (constraintAnchorQ2.d() != null) {
            Iterator<ConstraintAnchor> it3 = constraintAnchorQ2.d().iterator();
            while (it3.hasNext()) {
                a(it3.next().f6522d, 0, arrayList7, null);
            }
        }
        ConstraintAnchor constraintAnchorQ3 = dVar.q(ConstraintAnchor.Type.CENTER);
        if (constraintAnchorQ3.d() != null) {
            Iterator<ConstraintAnchor> it4 = constraintAnchorQ3.d().iterator();
            while (it4.hasNext()) {
                a(it4.next().f6522d, 0, arrayList7, null);
            }
        }
        j jVar4 = null;
        if (arrayList5 != null) {
            Iterator it5 = arrayList5.iterator();
            while (it5.hasNext()) {
                a((ConstraintWidget) it5.next(), 0, arrayList7, null);
            }
        }
        if (arrayList3 != null) {
            Iterator it6 = arrayList3.iterator();
            while (it6.hasNext()) {
                a((androidx.constraintlayout.core.widgets.f) it6.next(), 1, arrayList7, null);
            }
        }
        int i15 = 1;
        if (arrayList4 != null) {
            for (v2.b bVar3 : arrayList4) {
                j jVarA2 = a(bVar3, i15, arrayList7, jVar4);
                bVar3.v1(arrayList7, i15, jVarA2);
                jVarA2.b(arrayList7);
                i15 = 1;
                jVar4 = null;
            }
        }
        ConstraintAnchor constraintAnchorQ4 = dVar.q(ConstraintAnchor.Type.TOP);
        if (constraintAnchorQ4.d() != null) {
            Iterator<ConstraintAnchor> it7 = constraintAnchorQ4.d().iterator();
            while (it7.hasNext()) {
                a(it7.next().f6522d, 1, arrayList7, null);
            }
        }
        ConstraintAnchor constraintAnchorQ5 = dVar.q(ConstraintAnchor.Type.BASELINE);
        if (constraintAnchorQ5.d() != null) {
            Iterator<ConstraintAnchor> it8 = constraintAnchorQ5.d().iterator();
            while (it8.hasNext()) {
                a(it8.next().f6522d, 1, arrayList7, null);
            }
        }
        ConstraintAnchor constraintAnchorQ6 = dVar.q(ConstraintAnchor.Type.BOTTOM);
        if (constraintAnchorQ6.d() != null) {
            Iterator<ConstraintAnchor> it9 = constraintAnchorQ6.d().iterator();
            while (it9.hasNext()) {
                a(it9.next().f6522d, 1, arrayList7, null);
            }
        }
        ConstraintAnchor constraintAnchorQ7 = dVar.q(ConstraintAnchor.Type.CENTER);
        if (constraintAnchorQ7.d() != null) {
            Iterator<ConstraintAnchor> it10 = constraintAnchorQ7.d().iterator();
            while (it10.hasNext()) {
                a(it10.next().f6522d, 1, arrayList7, null);
            }
        }
        if (arrayList6 != null) {
            Iterator it11 = arrayList6.iterator();
            while (it11.hasNext()) {
                a((ConstraintWidget) it11.next(), 1, arrayList7, null);
            }
        }
        for (int i16 = 0; i16 < size; i16++) {
            ConstraintWidget constraintWidget3 = arrayListV1.get(i16);
            if (constraintWidget3.u0()) {
                j jVarB = b(arrayList7, constraintWidget3.S0);
                j jVarB2 = b(arrayList7, constraintWidget3.T0);
                if (jVarB != null && jVarB2 != null) {
                    jVarB.g(0, jVarB2);
                    jVarB2.i(2);
                    arrayList7.remove(jVarB);
                }
            }
        }
        if (arrayList7.size() <= 1) {
            return false;
        }
        if (dVar.C() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
            jVar = null;
            int i17 = 0;
            for (j jVar5 : arrayList7) {
                if (jVar5.d() != 1) {
                    jVar5.h(false);
                    int iF = jVar5.f(dVar.P1(), 0);
                    if (iF > i17) {
                        jVar = jVar5;
                        i17 = iF;
                    }
                }
            }
            if (jVar != null) {
                dVar.T0(ConstraintWidget.DimensionBehaviour.FIXED);
                dVar.o1(i17);
                jVar.h(true);
            } else {
                jVar = null;
            }
        } else {
            jVar = null;
        }
        if (dVar.V() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
            j jVar6 = null;
            int i18 = 0;
            for (j jVar7 : arrayList7) {
                if (jVar7.d() != 0) {
                    jVar7.h(false);
                    int iF2 = jVar7.f(dVar.P1(), 1);
                    if (iF2 > i18) {
                        jVar6 = jVar7;
                        i18 = iF2;
                    }
                }
            }
            if (jVar6 != null) {
                dVar.k1(ConstraintWidget.DimensionBehaviour.FIXED);
                dVar.P0(i18);
                jVar6.h(true);
                jVar2 = jVar6;
            }
            return jVar == null || jVar2 != null;
        }
        jVar2 = null;
        if (jVar == null) {
        }
    }

    public static boolean d(ConstraintWidget.DimensionBehaviour dimensionBehaviour, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, ConstraintWidget.DimensionBehaviour dimensionBehaviour3, ConstraintWidget.DimensionBehaviour dimensionBehaviour4) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour5;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour6;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour7 = ConstraintWidget.DimensionBehaviour.FIXED;
        return (dimensionBehaviour3 == dimensionBehaviour7 || dimensionBehaviour3 == (dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || (dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && dimensionBehaviour != dimensionBehaviour6)) || (dimensionBehaviour4 == dimensionBehaviour7 || dimensionBehaviour4 == (dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || (dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && dimensionBehaviour2 != dimensionBehaviour5));
    }
}
