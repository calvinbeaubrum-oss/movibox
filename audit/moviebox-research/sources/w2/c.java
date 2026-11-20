package w2;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends WidgetRun {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArrayList<WidgetRun> f79163k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f79164l;

    public c(ConstraintWidget constraintWidget, int i11) {
        super(constraintWidget);
        this.f79163k = new ArrayList<>();
        this.f6601f = i11;
        q();
    }

    /* JADX WARN: Code duplicated, block: B:293:0x00f4 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:64:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:65:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:67:0x00ec A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:90:0x0153  */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, w2.d
    public void a(d dVar) {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        float f11;
        boolean z11;
        int i16;
        int i17;
        int i18;
        int i19;
        int i21;
        int i22;
        int i23;
        float f12;
        if (this.f6603h.f6593j && this.f6604i.f6593j) {
            ConstraintWidget constraintWidgetM = this.f6597b.M();
            boolean zU1 = constraintWidgetM instanceof androidx.constraintlayout.core.widgets.d ? ((androidx.constraintlayout.core.widgets.d) constraintWidgetM).U1() : false;
            int i24 = this.f6604i.f6590g - this.f6603h.f6590g;
            int size = this.f79163k.size();
            int i25 = 0;
            while (true) {
                i11 = -1;
                i12 = 8;
                if (i25 >= size) {
                    i25 = -1;
                    break;
                } else if (this.f79163k.get(i25).f6597b.X() != 8) {
                    break;
                } else {
                    i25++;
                }
            }
            int i26 = size - 1;
            for (int i27 = i26; i27 >= 0; i27--) {
                if (this.f79163k.get(i27).f6597b.X() != 8) {
                    i11 = i27;
                    break;
                }
            }
            int i28 = 0;
            while (true) {
                if (i28 >= 2) {
                    i13 = 0;
                    i14 = 0;
                    i15 = 0;
                    f11 = 0.0f;
                    break;
                }
                int i29 = 0;
                i14 = 0;
                i15 = 0;
                int i31 = 0;
                f11 = 0.0f;
                while (i29 < size) {
                    WidgetRun widgetRun = this.f79163k.get(i29);
                    if (widgetRun.f6597b.X() != i12) {
                        i31++;
                        if (i29 > 0 && i29 >= i25) {
                            i14 += widgetRun.f6603h.f6589f;
                        }
                        androidx.constraintlayout.core.widgets.analyzer.a aVar = widgetRun.f6600e;
                        int i32 = aVar.f6590g;
                        boolean z12 = widgetRun.f6599d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                        if (z12) {
                            int i33 = this.f6601f;
                            if (i33 == 0 && !widgetRun.f6597b.f6537e.f6600e.f6593j) {
                                return;
                            }
                            if (i33 == 1 && !widgetRun.f6597b.f6539f.f6600e.f6593j) {
                                return;
                            } else {
                                i22 = i32;
                            }
                        } else {
                            i22 = i32;
                            if (widgetRun.f6596a == 1 && i28 == 0) {
                                i23 = aVar.f6607m;
                                i15++;
                            } else {
                                if (aVar.f6593j) {
                                    i23 = i22;
                                }
                                if (z12) {
                                    i14 += i23;
                                } else {
                                    i15++;
                                    f12 = widgetRun.f6597b.N0[this.f6601f];
                                    if (f12 >= 0.0f) {
                                        f11 += f12;
                                    }
                                }
                                if (i29 >= i26 && i29 < i11) {
                                    i14 += -widgetRun.f6604i.f6589f;
                                }
                            }
                            z12 = true;
                            if (z12) {
                                i15++;
                                f12 = widgetRun.f6597b.N0[this.f6601f];
                                if (f12 >= 0.0f) {
                                    f11 += f12;
                                }
                            } else {
                                i14 += i23;
                            }
                            if (i29 >= i26) {
                            }
                        }
                        i23 = i22;
                        if (z12) {
                            i15++;
                            f12 = widgetRun.f6597b.N0[this.f6601f];
                            if (f12 >= 0.0f) {
                                f11 += f12;
                            }
                        } else {
                            i14 += i23;
                        }
                        if (i29 >= i26) {
                        }
                    }
                    i29++;
                    i12 = 8;
                }
                if (i14 < i24 || i15 == 0) {
                    i13 = i31;
                    break;
                } else {
                    i28++;
                    i12 = 8;
                }
            }
            int i34 = this.f6603h.f6590g;
            if (zU1) {
                i34 = this.f6604i.f6590g;
            }
            if (i14 > i24) {
                i34 = zU1 ? i34 + ((int) (((i14 - i24) / 2.0f) + 0.5f)) : i34 - ((int) (((i14 - i24) / 2.0f) + 0.5f));
            }
            if (i15 > 0) {
                float f13 = i24 - i14;
                int i35 = (int) ((f13 / i15) + 0.5f);
                int i36 = 0;
                int i37 = 0;
                while (i36 < size) {
                    WidgetRun widgetRun2 = this.f79163k.get(i36);
                    int i38 = i35;
                    int i39 = i14;
                    if (widgetRun2.f6597b.X() != 8 && widgetRun2.f6599d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        androidx.constraintlayout.core.widgets.analyzer.a aVar2 = widgetRun2.f6600e;
                        if (aVar2.f6593j) {
                            zU1 = zU1;
                            i34 = i34;
                            f13 = f13;
                        } else {
                            int i40 = f11 > 0.0f ? (int) (((widgetRun2.f6597b.N0[this.f6601f] * f13) / f11) + 0.5f) : i38;
                            if (this.f6601f == 0) {
                                ConstraintWidget constraintWidget = widgetRun2.f6597b;
                                i21 = constraintWidget.A;
                                i19 = constraintWidget.f6579z;
                            } else {
                                ConstraintWidget constraintWidget2 = widgetRun2.f6597b;
                                int i41 = constraintWidget2.D;
                                i19 = constraintWidget2.C;
                                i21 = i41;
                            }
                            int iMax = Math.max(i19, widgetRun2.f6596a == 1 ? Math.min(i40, aVar2.f6607m) : i40);
                            if (i21 > 0) {
                                iMax = Math.min(i21, iMax);
                            }
                            if (iMax != i40) {
                                i37++;
                                i40 = iMax;
                            }
                            widgetRun2.f6600e.d(i40);
                        }
                    } else {
                        zU1 = zU1;
                        i34 = i34;
                        f13 = f13;
                    }
                    i36++;
                    i35 = i38;
                    i14 = i39;
                    i34 = i34;
                    f13 = f13;
                    zU1 = zU1;
                    i13 = i13;
                }
                z11 = zU1;
                i16 = i13;
                i17 = i34;
                int i42 = i14;
                if (i37 > 0) {
                    i15 -= i37;
                    i14 = 0;
                    for (int i43 = 0; i43 < size; i43++) {
                        WidgetRun widgetRun3 = this.f79163k.get(i43);
                        if (widgetRun3.f6597b.X() != 8) {
                            if (i43 > 0 && i43 >= i25) {
                                i14 += widgetRun3.f6603h.f6589f;
                            }
                            i14 += widgetRun3.f6600e.f6590g;
                            if (i43 < i26 && i43 < i11) {
                                i14 += -widgetRun3.f6604i.f6589f;
                            }
                        }
                    }
                } else {
                    i14 = i42;
                }
                i18 = 2;
                if (this.f79164l == 2 && i37 == 0) {
                    this.f79164l = 0;
                }
            } else {
                z11 = zU1;
                i16 = i13;
                i17 = i34;
                i18 = 2;
            }
            if (i14 > i24) {
                this.f79164l = i18;
            }
            if (i16 > 0 && i15 == 0 && i25 == i11) {
                this.f79164l = i18;
            }
            int i44 = this.f79164l;
            if (i44 == 1) {
                int i45 = i16;
                int i46 = i45 > 1 ? (i24 - i14) / (i45 - 1) : i45 == 1 ? (i24 - i14) / 2 : 0;
                if (i15 > 0) {
                    i46 = 0;
                }
                int i47 = i17;
                for (int i48 = 0; i48 < size; i48++) {
                    WidgetRun widgetRun4 = this.f79163k.get(z11 ? size - (i48 + 1) : i48);
                    if (widgetRun4.f6597b.X() == 8) {
                        widgetRun4.f6603h.d(i47);
                        widgetRun4.f6604i.d(i47);
                    } else {
                        if (i48 > 0) {
                            i47 = z11 ? i47 - i46 : i47 + i46;
                        }
                        if (i48 > 0 && i48 >= i25) {
                            i47 = z11 ? i47 - widgetRun4.f6603h.f6589f : i47 + widgetRun4.f6603h.f6589f;
                        }
                        if (z11) {
                            widgetRun4.f6604i.d(i47);
                        } else {
                            widgetRun4.f6603h.d(i47);
                        }
                        androidx.constraintlayout.core.widgets.analyzer.a aVar3 = widgetRun4.f6600e;
                        int i49 = aVar3.f6590g;
                        if (widgetRun4.f6599d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun4.f6596a == 1) {
                            i49 = aVar3.f6607m;
                        }
                        i47 = z11 ? i47 - i49 : i47 + i49;
                        if (z11) {
                            widgetRun4.f6603h.d(i47);
                        } else {
                            widgetRun4.f6604i.d(i47);
                        }
                        widgetRun4.f6602g = true;
                        if (i48 < i26 && i48 < i11) {
                            i47 = z11 ? i47 - (-widgetRun4.f6604i.f6589f) : i47 + (-widgetRun4.f6604i.f6589f);
                        }
                    }
                }
                return;
            }
            int i50 = i16;
            if (i44 == 0) {
                int i51 = (i24 - i14) / (i50 + 1);
                if (i15 > 0) {
                    i51 = 0;
                }
                int i52 = i17;
                for (int i53 = 0; i53 < size; i53++) {
                    WidgetRun widgetRun5 = this.f79163k.get(z11 ? size - (i53 + 1) : i53);
                    if (widgetRun5.f6597b.X() == 8) {
                        widgetRun5.f6603h.d(i52);
                        widgetRun5.f6604i.d(i52);
                    } else {
                        int i54 = z11 ? i52 - i51 : i52 + i51;
                        if (i53 > 0 && i53 >= i25) {
                            i54 = z11 ? i54 - widgetRun5.f6603h.f6589f : i54 + widgetRun5.f6603h.f6589f;
                        }
                        if (z11) {
                            widgetRun5.f6604i.d(i54);
                        } else {
                            widgetRun5.f6603h.d(i54);
                        }
                        androidx.constraintlayout.core.widgets.analyzer.a aVar4 = widgetRun5.f6600e;
                        int iMin = aVar4.f6590g;
                        if (widgetRun5.f6599d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun5.f6596a == 1) {
                            iMin = Math.min(iMin, aVar4.f6607m);
                        }
                        i52 = z11 ? i54 - iMin : i54 + iMin;
                        if (z11) {
                            widgetRun5.f6603h.d(i52);
                        } else {
                            widgetRun5.f6604i.d(i52);
                        }
                        if (i53 < i26 && i53 < i11) {
                            i52 = z11 ? i52 - (-widgetRun5.f6604i.f6589f) : i52 + (-widgetRun5.f6604i.f6589f);
                        }
                    }
                }
                return;
            }
            if (i44 == 2) {
                float fA = this.f6601f == 0 ? this.f6597b.A() : this.f6597b.T();
                if (z11) {
                    fA = 1.0f - fA;
                }
                int i55 = (int) (((i24 - i14) * fA) + 0.5f);
                if (i55 < 0 || i15 > 0) {
                    i55 = 0;
                }
                int i56 = z11 ? i17 - i55 : i17 + i55;
                for (int i57 = 0; i57 < size; i57++) {
                    WidgetRun widgetRun6 = this.f79163k.get(z11 ? size - (i57 + 1) : i57);
                    if (widgetRun6.f6597b.X() == 8) {
                        widgetRun6.f6603h.d(i56);
                        widgetRun6.f6604i.d(i56);
                    } else {
                        if (i57 > 0 && i57 >= i25) {
                            i56 = z11 ? i56 - widgetRun6.f6603h.f6589f : i56 + widgetRun6.f6603h.f6589f;
                        }
                        if (z11) {
                            widgetRun6.f6604i.d(i56);
                        } else {
                            widgetRun6.f6603h.d(i56);
                        }
                        androidx.constraintlayout.core.widgets.analyzer.a aVar5 = widgetRun6.f6600e;
                        int i58 = aVar5.f6590g;
                        if (widgetRun6.f6599d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun6.f6596a == 1) {
                            i58 = aVar5.f6607m;
                        }
                        i56 = z11 ? i56 - i58 : i56 + i58;
                        if (z11) {
                            widgetRun6.f6603h.d(i56);
                        } else {
                            widgetRun6.f6604i.d(i56);
                        }
                        if (i57 < i26 && i57 < i11) {
                            i56 = z11 ? i56 - (-widgetRun6.f6604i.f6589f) : i56 + (-widgetRun6.f6604i.f6589f);
                        }
                    }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void d() {
        Iterator<WidgetRun> it = this.f79163k.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
        int size = this.f79163k.size();
        if (size < 1) {
            return;
        }
        ConstraintWidget constraintWidget = this.f79163k.get(0).f6597b;
        ConstraintWidget constraintWidget2 = this.f79163k.get(size - 1).f6597b;
        if (this.f6601f == 0) {
            ConstraintAnchor constraintAnchor = constraintWidget.Q;
            ConstraintAnchor constraintAnchor2 = constraintWidget2.S;
            DependencyNode dependencyNodeI = i(constraintAnchor, 0);
            int iF = constraintAnchor.f();
            ConstraintWidget constraintWidgetR = r();
            if (constraintWidgetR != null) {
                iF = constraintWidgetR.Q.f();
            }
            if (dependencyNodeI != null) {
                b(this.f6603h, dependencyNodeI, iF);
            }
            DependencyNode dependencyNodeI2 = i(constraintAnchor2, 0);
            int iF2 = constraintAnchor2.f();
            ConstraintWidget constraintWidgetS = s();
            if (constraintWidgetS != null) {
                iF2 = constraintWidgetS.S.f();
            }
            if (dependencyNodeI2 != null) {
                b(this.f6604i, dependencyNodeI2, -iF2);
            }
        } else {
            ConstraintAnchor constraintAnchor3 = constraintWidget.R;
            ConstraintAnchor constraintAnchor4 = constraintWidget2.T;
            DependencyNode dependencyNodeI3 = i(constraintAnchor3, 1);
            int iF3 = constraintAnchor3.f();
            ConstraintWidget constraintWidgetR2 = r();
            if (constraintWidgetR2 != null) {
                iF3 = constraintWidgetR2.R.f();
            }
            if (dependencyNodeI3 != null) {
                b(this.f6603h, dependencyNodeI3, iF3);
            }
            DependencyNode dependencyNodeI4 = i(constraintAnchor4, 1);
            int iF4 = constraintAnchor4.f();
            ConstraintWidget constraintWidgetS2 = s();
            if (constraintWidgetS2 != null) {
                iF4 = constraintWidgetS2.T.f();
            }
            if (dependencyNodeI4 != null) {
                b(this.f6604i, dependencyNodeI4, -iF4);
            }
        }
        this.f6603h.f6584a = this;
        this.f6604i.f6584a = this;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void e() {
        for (int i11 = 0; i11 < this.f79163k.size(); i11++) {
            this.f79163k.get(i11).e();
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void f() {
        this.f6598c = null;
        Iterator<WidgetRun> it = this.f79163k.iterator();
        while (it.hasNext()) {
            it.next().f();
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public long j() {
        int size = this.f79163k.size();
        long j11 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            WidgetRun widgetRun = this.f79163k.get(i11);
            j11 = j11 + ((long) widgetRun.f6603h.f6589f) + widgetRun.j() + ((long) widgetRun.f6604i.f6589f);
        }
        return j11;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public boolean m() {
        int size = this.f79163k.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (!this.f79163k.get(i11).m()) {
                return false;
            }
        }
        return true;
    }

    public final void q() {
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2 = this.f6597b;
        ConstraintWidget constraintWidgetN = constraintWidget2.N(this.f6601f);
        while (true) {
            ConstraintWidget constraintWidget3 = constraintWidgetN;
            constraintWidget = constraintWidget2;
            constraintWidget2 = constraintWidget3;
            if (constraintWidget2 == null) {
                break;
            } else {
                constraintWidgetN = constraintWidget2.N(this.f6601f);
            }
        }
        this.f6597b = constraintWidget;
        this.f79163k.add(constraintWidget.P(this.f6601f));
        ConstraintWidget constraintWidgetL = constraintWidget.L(this.f6601f);
        while (constraintWidgetL != null) {
            this.f79163k.add(constraintWidgetL.P(this.f6601f));
            constraintWidgetL = constraintWidgetL.L(this.f6601f);
        }
        for (WidgetRun widgetRun : this.f79163k) {
            int i11 = this.f6601f;
            if (i11 == 0) {
                widgetRun.f6597b.f6533c = this;
            } else if (i11 == 1) {
                widgetRun.f6597b.f6535d = this;
            }
        }
        if (this.f6601f == 0 && ((androidx.constraintlayout.core.widgets.d) this.f6597b.M()).U1() && this.f79163k.size() > 1) {
            ArrayList<WidgetRun> arrayList = this.f79163k;
            this.f6597b = arrayList.get(arrayList.size() - 1).f6597b;
        }
        this.f79164l = this.f6601f == 0 ? this.f6597b.B() : this.f6597b.U();
    }

    public final ConstraintWidget r() {
        for (int i11 = 0; i11 < this.f79163k.size(); i11++) {
            WidgetRun widgetRun = this.f79163k.get(i11);
            if (widgetRun.f6597b.X() != 8) {
                return widgetRun.f6597b;
            }
        }
        return null;
    }

    public final ConstraintWidget s() {
        for (int size = this.f79163k.size() - 1; size >= 0; size--) {
            WidgetRun widgetRun = this.f79163k.get(size);
            if (widgetRun.f6597b.X() != 8) {
                return widgetRun.f6597b;
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("ChainRun ");
        sb2.append(this.f6601f == 0 ? "horizontal : " : "vertical : ");
        for (WidgetRun widgetRun : this.f79163k) {
            sb2.append("<");
            sb2.append(widgetRun);
            sb2.append("> ");
        }
        return sb2.toString();
    }
}
