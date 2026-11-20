package w2;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public androidx.constraintlayout.core.widgets.d f79165a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public androidx.constraintlayout.core.widgets.d f79168d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f79166b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f79167c = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList<WidgetRun> f79169e = new ArrayList<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList<i> f79170f = new ArrayList<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b.InterfaceC0880b f79171g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b.a f79172h = new b.a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayList<i> f79173i = new ArrayList<>();

    public e(androidx.constraintlayout.core.widgets.d dVar) {
        this.f79165a = dVar;
        this.f79168d = dVar;
    }

    public final void a(DependencyNode dependencyNode, int i11, int i12, DependencyNode dependencyNode2, ArrayList<i> arrayList, i iVar) {
        WidgetRun widgetRun = dependencyNode.f6587d;
        if (widgetRun.f6598c == null) {
            androidx.constraintlayout.core.widgets.d dVar = this.f79165a;
            if (widgetRun == dVar.f6537e || widgetRun == dVar.f6539f) {
                return;
            }
            if (iVar == null) {
                iVar = new i(widgetRun, i12);
                arrayList.add(iVar);
            }
            widgetRun.f6598c = iVar;
            iVar.a(widgetRun);
            for (d dVar2 : widgetRun.f6603h.f6594k) {
                if (dVar2 instanceof DependencyNode) {
                    a((DependencyNode) dVar2, i11, 0, dependencyNode2, arrayList, iVar);
                }
            }
            for (d dVar3 : widgetRun.f6604i.f6594k) {
                if (dVar3 instanceof DependencyNode) {
                    a((DependencyNode) dVar3, i11, 1, dependencyNode2, arrayList, iVar);
                }
            }
            if (i11 == 1 && (widgetRun instanceof androidx.constraintlayout.core.widgets.analyzer.d)) {
                for (d dVar4 : ((androidx.constraintlayout.core.widgets.analyzer.d) widgetRun).f6610k.f6594k) {
                    if (dVar4 instanceof DependencyNode) {
                        a((DependencyNode) dVar4, i11, 2, dependencyNode2, arrayList, iVar);
                    }
                }
            }
            for (DependencyNode dependencyNode3 : widgetRun.f6603h.f6595l) {
                if (dependencyNode3 == dependencyNode2) {
                    iVar.f79179b = true;
                }
                a(dependencyNode3, i11, 0, dependencyNode2, arrayList, iVar);
            }
            for (DependencyNode dependencyNode4 : widgetRun.f6604i.f6595l) {
                if (dependencyNode4 == dependencyNode2) {
                    iVar.f79179b = true;
                }
                a(dependencyNode4, i11, 1, dependencyNode2, arrayList, iVar);
            }
            if (i11 == 1 && (widgetRun instanceof androidx.constraintlayout.core.widgets.analyzer.d)) {
                Iterator<DependencyNode> it = ((androidx.constraintlayout.core.widgets.analyzer.d) widgetRun).f6610k.f6595l.iterator();
                while (it.hasNext()) {
                    a(it.next(), i11, 2, dependencyNode2, arrayList, iVar);
                }
            }
        }
    }

    public final boolean b(androidx.constraintlayout.core.widgets.d dVar) {
        int iY;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        int iZ;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour4;
        for (ConstraintWidget constraintWidget : dVar.V0) {
            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.f6532b0;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = dimensionBehaviourArr[0];
            ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = dimensionBehaviourArr[1];
            if (constraintWidget.X() == 8) {
                constraintWidget.f6529a = true;
            } else {
                if (constraintWidget.B < 1.0f && dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    constraintWidget.f6573w = 2;
                }
                if (constraintWidget.E < 1.0f && dimensionBehaviour6 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    constraintWidget.f6575x = 2;
                }
                if (constraintWidget.x() > 0.0f) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour7 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (dimensionBehaviour5 == dimensionBehaviour7 && (dimensionBehaviour6 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour6 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        constraintWidget.f6573w = 3;
                    } else if (dimensionBehaviour6 == dimensionBehaviour7 && (dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        constraintWidget.f6575x = 3;
                    } else if (dimensionBehaviour5 == dimensionBehaviour7 && dimensionBehaviour6 == dimensionBehaviour7) {
                        if (constraintWidget.f6573w == 0) {
                            constraintWidget.f6573w = 3;
                        }
                        if (constraintWidget.f6575x == 0) {
                            constraintWidget.f6575x = 3;
                        }
                    }
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour8 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviour5 == dimensionBehaviour8 && constraintWidget.f6573w == 1 && (constraintWidget.Q.f6524f == null || constraintWidget.S.f6524f == null)) {
                    dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour9 = dimensionBehaviour5;
                if (dimensionBehaviour6 == dimensionBehaviour8 && constraintWidget.f6575x == 1 && (constraintWidget.R.f6524f == null || constraintWidget.T.f6524f == null)) {
                    dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour10 = dimensionBehaviour6;
                androidx.constraintlayout.core.widgets.analyzer.c cVar = constraintWidget.f6537e;
                cVar.f6599d = dimensionBehaviour9;
                int i11 = constraintWidget.f6573w;
                cVar.f6596a = i11;
                androidx.constraintlayout.core.widgets.analyzer.d dVar2 = constraintWidget.f6539f;
                dVar2.f6599d = dimensionBehaviour10;
                int i12 = constraintWidget.f6575x;
                dVar2.f6596a = i12;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour11 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
                if ((dimensionBehaviour9 == dimensionBehaviour11 || dimensionBehaviour9 == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviour9 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && (dimensionBehaviour10 == dimensionBehaviour11 || dimensionBehaviour10 == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviour10 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)) {
                    int iY2 = constraintWidget.Y();
                    if (dimensionBehaviour9 == dimensionBehaviour11) {
                        iY = (dVar.Y() - constraintWidget.Q.f6525g) - constraintWidget.S.f6525g;
                        dimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
                    } else {
                        iY = iY2;
                        dimensionBehaviour = dimensionBehaviour9;
                    }
                    int iZ2 = constraintWidget.z();
                    if (dimensionBehaviour10 == dimensionBehaviour11) {
                        iZ = (dVar.z() - constraintWidget.R.f6525g) - constraintWidget.T.f6525g;
                        dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.FIXED;
                    } else {
                        iZ = iZ2;
                        dimensionBehaviour2 = dimensionBehaviour10;
                    }
                    l(constraintWidget, dimensionBehaviour, iY, dimensionBehaviour2, iZ);
                    constraintWidget.f6537e.f6600e.d(constraintWidget.Y());
                    constraintWidget.f6539f.f6600e.d(constraintWidget.z());
                    constraintWidget.f6529a = true;
                } else {
                    if (dimensionBehaviour9 == dimensionBehaviour8 && (dimensionBehaviour10 == (dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || dimensionBehaviour10 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        if (i11 == 3) {
                            if (dimensionBehaviour10 == dimensionBehaviour4) {
                                l(constraintWidget, dimensionBehaviour4, 0, dimensionBehaviour4, 0);
                            }
                            int iZ3 = constraintWidget.z();
                            int i13 = (int) ((iZ3 * constraintWidget.f6540f0) + 0.5f);
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour12 = ConstraintWidget.DimensionBehaviour.FIXED;
                            l(constraintWidget, dimensionBehaviour12, i13, dimensionBehaviour12, iZ3);
                            constraintWidget.f6537e.f6600e.d(constraintWidget.Y());
                            constraintWidget.f6539f.f6600e.d(constraintWidget.z());
                            constraintWidget.f6529a = true;
                        } else if (i11 == 1) {
                            l(constraintWidget, dimensionBehaviour4, 0, dimensionBehaviour10, 0);
                            constraintWidget.f6537e.f6600e.f6607m = constraintWidget.Y();
                        } else if (i11 == 2) {
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour13 = dVar.f6532b0[0];
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour14 = ConstraintWidget.DimensionBehaviour.FIXED;
                            if (dimensionBehaviour13 == dimensionBehaviour14 || dimensionBehaviour13 == dimensionBehaviour11) {
                                l(constraintWidget, dimensionBehaviour14, (int) ((constraintWidget.B * dVar.Y()) + 0.5f), dimensionBehaviour10, constraintWidget.z());
                                constraintWidget.f6537e.f6600e.d(constraintWidget.Y());
                                constraintWidget.f6539f.f6600e.d(constraintWidget.z());
                                constraintWidget.f6529a = true;
                            }
                        } else {
                            ConstraintAnchor[] constraintAnchorArr = constraintWidget.Y;
                            if (constraintAnchorArr[0].f6524f == null || constraintAnchorArr[1].f6524f == null) {
                                l(constraintWidget, dimensionBehaviour4, 0, dimensionBehaviour10, 0);
                                constraintWidget.f6537e.f6600e.d(constraintWidget.Y());
                                constraintWidget.f6539f.f6600e.d(constraintWidget.z());
                                constraintWidget.f6529a = true;
                            }
                        }
                    }
                    if (dimensionBehaviour10 == dimensionBehaviour8 && (dimensionBehaviour9 == (dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || dimensionBehaviour9 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        if (i12 == 3) {
                            if (dimensionBehaviour9 == dimensionBehaviour3) {
                                l(constraintWidget, dimensionBehaviour3, 0, dimensionBehaviour3, 0);
                            }
                            int iY3 = constraintWidget.Y();
                            float f11 = constraintWidget.f6540f0;
                            if (constraintWidget.y() == -1) {
                                f11 = 1.0f / f11;
                            }
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour15 = ConstraintWidget.DimensionBehaviour.FIXED;
                            l(constraintWidget, dimensionBehaviour15, iY3, dimensionBehaviour15, (int) ((iY3 * f11) + 0.5f));
                            constraintWidget.f6537e.f6600e.d(constraintWidget.Y());
                            constraintWidget.f6539f.f6600e.d(constraintWidget.z());
                            constraintWidget.f6529a = true;
                        } else if (i12 == 1) {
                            l(constraintWidget, dimensionBehaviour9, 0, dimensionBehaviour3, 0);
                            constraintWidget.f6539f.f6600e.f6607m = constraintWidget.z();
                        } else if (i12 == 2) {
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour16 = dVar.f6532b0[1];
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour17 = ConstraintWidget.DimensionBehaviour.FIXED;
                            if (dimensionBehaviour16 == dimensionBehaviour17 || dimensionBehaviour16 == dimensionBehaviour11) {
                                l(constraintWidget, dimensionBehaviour9, constraintWidget.Y(), dimensionBehaviour17, (int) ((constraintWidget.E * dVar.z()) + 0.5f));
                                constraintWidget.f6537e.f6600e.d(constraintWidget.Y());
                                constraintWidget.f6539f.f6600e.d(constraintWidget.z());
                                constraintWidget.f6529a = true;
                            }
                        } else {
                            ConstraintAnchor[] constraintAnchorArr2 = constraintWidget.Y;
                            if (constraintAnchorArr2[2].f6524f == null || constraintAnchorArr2[3].f6524f == null) {
                                l(constraintWidget, dimensionBehaviour3, 0, dimensionBehaviour10, 0);
                                constraintWidget.f6537e.f6600e.d(constraintWidget.Y());
                                constraintWidget.f6539f.f6600e.d(constraintWidget.z());
                                constraintWidget.f6529a = true;
                            }
                        }
                    }
                    if (dimensionBehaviour9 == dimensionBehaviour8 && dimensionBehaviour10 == dimensionBehaviour8) {
                        if (i11 == 1 || i12 == 1) {
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour18 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                            l(constraintWidget, dimensionBehaviour18, 0, dimensionBehaviour18, 0);
                            constraintWidget.f6537e.f6600e.f6607m = constraintWidget.Y();
                            constraintWidget.f6539f.f6600e.f6607m = constraintWidget.z();
                        } else if (i12 == 2 && i11 == 2) {
                            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr2 = dVar.f6532b0;
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour19 = dimensionBehaviourArr2[0];
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour20 = ConstraintWidget.DimensionBehaviour.FIXED;
                            if (dimensionBehaviour19 == dimensionBehaviour20 && dimensionBehaviourArr2[1] == dimensionBehaviour20) {
                                l(constraintWidget, dimensionBehaviour20, (int) ((constraintWidget.B * dVar.Y()) + 0.5f), dimensionBehaviour20, (int) ((constraintWidget.E * dVar.z()) + 0.5f));
                                constraintWidget.f6537e.f6600e.d(constraintWidget.Y());
                                constraintWidget.f6539f.f6600e.d(constraintWidget.z());
                                constraintWidget.f6529a = true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public void c() {
        d(this.f79169e);
        this.f79173i.clear();
        i.f79177h = 0;
        i(this.f79165a.f6537e, 0, this.f79173i);
        i(this.f79165a.f6539f, 1, this.f79173i);
        this.f79166b = false;
    }

    public void d(ArrayList<WidgetRun> arrayList) {
        arrayList.clear();
        this.f79168d.f6537e.f();
        this.f79168d.f6539f.f();
        arrayList.add(this.f79168d.f6537e);
        arrayList.add(this.f79168d.f6539f);
        HashSet hashSet = null;
        for (ConstraintWidget constraintWidget : this.f79168d.V0) {
            if (constraintWidget instanceof androidx.constraintlayout.core.widgets.f) {
                arrayList.add(new h(constraintWidget));
            } else {
                if (constraintWidget.k0()) {
                    if (constraintWidget.f6533c == null) {
                        constraintWidget.f6533c = new c(constraintWidget, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(constraintWidget.f6533c);
                } else {
                    arrayList.add(constraintWidget.f6537e);
                }
                if (constraintWidget.m0()) {
                    if (constraintWidget.f6535d == null) {
                        constraintWidget.f6535d = new c(constraintWidget, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(constraintWidget.f6535d);
                } else {
                    arrayList.add(constraintWidget.f6539f);
                }
                if (constraintWidget instanceof v2.b) {
                    arrayList.add(new androidx.constraintlayout.core.widgets.analyzer.b(constraintWidget));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator<WidgetRun> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().f();
        }
        for (WidgetRun widgetRun : arrayList) {
            if (widgetRun.f6597b != this.f79168d) {
                widgetRun.d();
            }
        }
    }

    public final int e(androidx.constraintlayout.core.widgets.d dVar, int i11) {
        int size = this.f79173i.size();
        long jMax = 0;
        for (int i12 = 0; i12 < size; i12++) {
            jMax = Math.max(jMax, this.f79173i.get(i12).b(dVar, i11));
        }
        return (int) jMax;
    }

    public boolean f(boolean z11) {
        boolean z12;
        boolean z13 = true;
        boolean z14 = z11 & true;
        if (this.f79166b || this.f79167c) {
            for (ConstraintWidget constraintWidget : this.f79165a.V0) {
                constraintWidget.p();
                constraintWidget.f6529a = false;
                constraintWidget.f6537e.r();
                constraintWidget.f6539f.q();
            }
            this.f79165a.p();
            androidx.constraintlayout.core.widgets.d dVar = this.f79165a;
            dVar.f6529a = false;
            dVar.f6537e.r();
            this.f79165a.f6539f.q();
            this.f79167c = false;
        }
        if (b(this.f79168d)) {
            return false;
        }
        this.f79165a.q1(0);
        this.f79165a.r1(0);
        ConstraintWidget.DimensionBehaviour dimensionBehaviourW = this.f79165a.w(0);
        ConstraintWidget.DimensionBehaviour dimensionBehaviourW2 = this.f79165a.w(1);
        if (this.f79166b) {
            c();
        }
        int iZ = this.f79165a.Z();
        int iA0 = this.f79165a.a0();
        this.f79165a.f6537e.f6603h.d(iZ);
        this.f79165a.f6539f.f6603h.d(iA0);
        m();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (dimensionBehaviourW == dimensionBehaviour || dimensionBehaviourW2 == dimensionBehaviour) {
            if (z14) {
                Iterator<WidgetRun> it = this.f79169e.iterator();
                while (it.hasNext()) {
                    if (!it.next().m()) {
                        z14 = false;
                        break;
                    }
                }
            }
            if (z14 && dimensionBehaviourW == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.f79165a.T0(ConstraintWidget.DimensionBehaviour.FIXED);
                androidx.constraintlayout.core.widgets.d dVar2 = this.f79165a;
                dVar2.o1(e(dVar2, 0));
                androidx.constraintlayout.core.widgets.d dVar3 = this.f79165a;
                dVar3.f6537e.f6600e.d(dVar3.Y());
            }
            if (z14 && dimensionBehaviourW2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.f79165a.k1(ConstraintWidget.DimensionBehaviour.FIXED);
                androidx.constraintlayout.core.widgets.d dVar4 = this.f79165a;
                dVar4.P0(e(dVar4, 1));
                androidx.constraintlayout.core.widgets.d dVar5 = this.f79165a;
                dVar5.f6539f.f6600e.d(dVar5.z());
            }
        }
        androidx.constraintlayout.core.widgets.d dVar6 = this.f79165a;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dVar6.f6532b0[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (dimensionBehaviour2 == dimensionBehaviour3 || dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int iY = dVar6.Y() + iZ;
            this.f79165a.f6537e.f6604i.d(iY);
            this.f79165a.f6537e.f6600e.d(iY - iZ);
            m();
            androidx.constraintlayout.core.widgets.d dVar7 = this.f79165a;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = dVar7.f6532b0[1];
            if (dimensionBehaviour4 == dimensionBehaviour3 || dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int iZ2 = dVar7.z() + iA0;
                this.f79165a.f6539f.f6604i.d(iZ2);
                this.f79165a.f6539f.f6600e.d(iZ2 - iA0);
            }
            m();
            z12 = true;
        } else {
            z12 = false;
        }
        for (WidgetRun widgetRun : this.f79169e) {
            if (widgetRun.f6597b != this.f79165a || widgetRun.f6602g) {
                widgetRun.e();
            }
        }
        for (WidgetRun widgetRun2 : this.f79169e) {
            if (z12 || widgetRun2.f6597b != this.f79165a) {
                if (!widgetRun2.f6603h.f6593j || ((!widgetRun2.f6604i.f6593j && !(widgetRun2 instanceof h)) || (!widgetRun2.f6600e.f6593j && !(widgetRun2 instanceof c) && !(widgetRun2 instanceof h)))) {
                    z13 = false;
                    break;
                }
            }
        }
        this.f79165a.T0(dimensionBehaviourW);
        this.f79165a.k1(dimensionBehaviourW2);
        return z13;
    }

    public boolean g(boolean z11) {
        if (this.f79166b) {
            for (ConstraintWidget constraintWidget : this.f79165a.V0) {
                constraintWidget.p();
                constraintWidget.f6529a = false;
                androidx.constraintlayout.core.widgets.analyzer.c cVar = constraintWidget.f6537e;
                cVar.f6600e.f6593j = false;
                cVar.f6602g = false;
                cVar.r();
                androidx.constraintlayout.core.widgets.analyzer.d dVar = constraintWidget.f6539f;
                dVar.f6600e.f6593j = false;
                dVar.f6602g = false;
                dVar.q();
            }
            this.f79165a.p();
            androidx.constraintlayout.core.widgets.d dVar2 = this.f79165a;
            dVar2.f6529a = false;
            androidx.constraintlayout.core.widgets.analyzer.c cVar2 = dVar2.f6537e;
            cVar2.f6600e.f6593j = false;
            cVar2.f6602g = false;
            cVar2.r();
            androidx.constraintlayout.core.widgets.analyzer.d dVar3 = this.f79165a.f6539f;
            dVar3.f6600e.f6593j = false;
            dVar3.f6602g = false;
            dVar3.q();
            c();
        }
        if (b(this.f79168d)) {
            return false;
        }
        this.f79165a.q1(0);
        this.f79165a.r1(0);
        this.f79165a.f6537e.f6603h.d(0);
        this.f79165a.f6539f.f6603h.d(0);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00c2  */
    public boolean h(boolean z11, int i11) {
        boolean z12;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        boolean z13 = true;
        boolean z14 = z11 & true;
        ConstraintWidget.DimensionBehaviour dimensionBehaviourW = this.f79165a.w(0);
        ConstraintWidget.DimensionBehaviour dimensionBehaviourW2 = this.f79165a.w(1);
        int iZ = this.f79165a.Z();
        int iA0 = this.f79165a.a0();
        if (z14 && (dimensionBehaviourW == (dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || dimensionBehaviourW2 == dimensionBehaviour)) {
            for (WidgetRun widgetRun : this.f79169e) {
                if (widgetRun.f6601f == i11 && !widgetRun.m()) {
                    z14 = false;
                    break;
                }
            }
            if (i11 == 0) {
                if (z14 && dimensionBehaviourW == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    this.f79165a.T0(ConstraintWidget.DimensionBehaviour.FIXED);
                    androidx.constraintlayout.core.widgets.d dVar = this.f79165a;
                    dVar.o1(e(dVar, 0));
                    androidx.constraintlayout.core.widgets.d dVar2 = this.f79165a;
                    dVar2.f6537e.f6600e.d(dVar2.Y());
                }
            } else if (z14 && dimensionBehaviourW2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.f79165a.k1(ConstraintWidget.DimensionBehaviour.FIXED);
                androidx.constraintlayout.core.widgets.d dVar3 = this.f79165a;
                dVar3.P0(e(dVar3, 1));
                androidx.constraintlayout.core.widgets.d dVar4 = this.f79165a;
                dVar4.f6539f.f6600e.d(dVar4.z());
            }
        }
        if (i11 == 0) {
            androidx.constraintlayout.core.widgets.d dVar5 = this.f79165a;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dVar5.f6532b0[0];
            if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int iY = dVar5.Y() + iZ;
                this.f79165a.f6537e.f6604i.d(iY);
                this.f79165a.f6537e.f6600e.d(iY - iZ);
                z12 = true;
            } else {
                z12 = false;
            }
        } else {
            androidx.constraintlayout.core.widgets.d dVar6 = this.f79165a;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = dVar6.f6532b0[1];
            if (dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int iZ2 = dVar6.z() + iA0;
                this.f79165a.f6539f.f6604i.d(iZ2);
                this.f79165a.f6539f.f6600e.d(iZ2 - iA0);
                z12 = true;
            } else {
                z12 = false;
            }
        }
        m();
        for (WidgetRun widgetRun2 : this.f79169e) {
            if (widgetRun2.f6601f == i11 && (widgetRun2.f6597b != this.f79165a || widgetRun2.f6602g)) {
                widgetRun2.e();
            }
        }
        for (WidgetRun widgetRun3 : this.f79169e) {
            if (widgetRun3.f6601f == i11 && (z12 || widgetRun3.f6597b != this.f79165a)) {
                if (!widgetRun3.f6603h.f6593j || !widgetRun3.f6604i.f6593j || (!(widgetRun3 instanceof c) && !widgetRun3.f6600e.f6593j)) {
                    z13 = false;
                    break;
                }
            }
        }
        this.f79165a.T0(dimensionBehaviourW);
        this.f79165a.k1(dimensionBehaviourW2);
        return z13;
    }

    public final void i(WidgetRun widgetRun, int i11, ArrayList<i> arrayList) {
        for (d dVar : widgetRun.f6603h.f6594k) {
            if (dVar instanceof DependencyNode) {
                a((DependencyNode) dVar, i11, 0, widgetRun.f6604i, arrayList, null);
            } else if (dVar instanceof WidgetRun) {
                a(((WidgetRun) dVar).f6603h, i11, 0, widgetRun.f6604i, arrayList, null);
            }
        }
        for (d dVar2 : widgetRun.f6604i.f6594k) {
            if (dVar2 instanceof DependencyNode) {
                a((DependencyNode) dVar2, i11, 1, widgetRun.f6603h, arrayList, null);
            } else if (dVar2 instanceof WidgetRun) {
                a(((WidgetRun) dVar2).f6604i, i11, 1, widgetRun.f6603h, arrayList, null);
            }
        }
        if (i11 == 1) {
            for (d dVar3 : ((androidx.constraintlayout.core.widgets.analyzer.d) widgetRun).f6610k.f6594k) {
                if (dVar3 instanceof DependencyNode) {
                    a((DependencyNode) dVar3, i11, 2, null, arrayList, null);
                }
            }
        }
    }

    public void j() {
        this.f79166b = true;
    }

    public void k() {
        this.f79167c = true;
    }

    public final void l(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i11, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i12) {
        b.a aVar = this.f79172h;
        aVar.f79153a = dimensionBehaviour;
        aVar.f79154b = dimensionBehaviour2;
        aVar.f79155c = i11;
        aVar.f79156d = i12;
        this.f79171g.b(constraintWidget, aVar);
        constraintWidget.o1(this.f79172h.f79157e);
        constraintWidget.P0(this.f79172h.f79158f);
        constraintWidget.O0(this.f79172h.f79160h);
        constraintWidget.E0(this.f79172h.f79159g);
    }

    public void m() {
        androidx.constraintlayout.core.widgets.analyzer.a aVar;
        for (ConstraintWidget constraintWidget : this.f79165a.V0) {
            if (!constraintWidget.f6529a) {
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.f6532b0;
                boolean z11 = false;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                int i11 = constraintWidget.f6573w;
                int i12 = constraintWidget.f6575x;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                boolean z12 = dimensionBehaviour == dimensionBehaviour3 || (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && i11 == 1);
                if (dimensionBehaviour2 == dimensionBehaviour3 || (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && i12 == 1)) {
                    z11 = true;
                }
                androidx.constraintlayout.core.widgets.analyzer.a aVar2 = constraintWidget.f6537e.f6600e;
                boolean z13 = aVar2.f6593j;
                androidx.constraintlayout.core.widgets.analyzer.a aVar3 = constraintWidget.f6539f.f6600e;
                boolean z14 = aVar3.f6593j;
                if (z13 && z14) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
                    l(constraintWidget, dimensionBehaviour4, aVar2.f6590g, dimensionBehaviour4, aVar3.f6590g);
                    constraintWidget.f6529a = true;
                } else if (z13 && z11) {
                    l(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, aVar2.f6590g, dimensionBehaviour3, aVar3.f6590g);
                    if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        constraintWidget.f6539f.f6600e.f6607m = constraintWidget.z();
                    } else {
                        constraintWidget.f6539f.f6600e.d(constraintWidget.z());
                        constraintWidget.f6529a = true;
                    }
                } else if (z14 && z12) {
                    l(constraintWidget, dimensionBehaviour3, aVar2.f6590g, ConstraintWidget.DimensionBehaviour.FIXED, aVar3.f6590g);
                    if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        constraintWidget.f6537e.f6600e.f6607m = constraintWidget.Y();
                    } else {
                        constraintWidget.f6537e.f6600e.d(constraintWidget.Y());
                        constraintWidget.f6529a = true;
                    }
                }
                if (constraintWidget.f6529a && (aVar = constraintWidget.f6539f.f6611l) != null) {
                    aVar.d(constraintWidget.r());
                }
            }
        }
    }

    public void n(b.InterfaceC0880b interfaceC0880b) {
        this.f79171g = interfaceC0880b;
    }
}
