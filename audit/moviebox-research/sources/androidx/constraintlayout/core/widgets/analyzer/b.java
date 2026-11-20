package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends WidgetRun {
    public b(ConstraintWidget constraintWidget) {
        super(constraintWidget);
    }

    private void q(DependencyNode dependencyNode) {
        this.f6603h.f6594k.add(dependencyNode);
        dependencyNode.f6595l.add(this.f6603h);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, w2.d
    public void a(w2.d dVar) {
        androidx.constraintlayout.core.widgets.a aVar = (androidx.constraintlayout.core.widgets.a) this.f6597b;
        int iZ1 = aVar.z1();
        Iterator<DependencyNode> it = this.f6603h.f6595l.iterator();
        int i11 = 0;
        int i12 = -1;
        while (it.hasNext()) {
            int i13 = it.next().f6590g;
            if (i12 == -1 || i13 < i12) {
                i12 = i13;
            }
            if (i11 < i13) {
                i11 = i13;
            }
        }
        if (iZ1 == 0 || iZ1 == 2) {
            this.f6603h.d(i12 + aVar.A1());
        } else {
            this.f6603h.d(i11 + aVar.A1());
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void d() {
        ConstraintWidget constraintWidget = this.f6597b;
        if (constraintWidget instanceof androidx.constraintlayout.core.widgets.a) {
            this.f6603h.f6585b = true;
            androidx.constraintlayout.core.widgets.a aVar = (androidx.constraintlayout.core.widgets.a) constraintWidget;
            int iZ1 = aVar.z1();
            boolean zY1 = aVar.y1();
            int i11 = 0;
            if (iZ1 == 0) {
                this.f6603h.f6588e = DependencyNode.Type.LEFT;
                while (i11 < aVar.W0) {
                    ConstraintWidget constraintWidget2 = aVar.V0[i11];
                    if (zY1 || constraintWidget2.X() != 8) {
                        DependencyNode dependencyNode = constraintWidget2.f6537e.f6603h;
                        dependencyNode.f6594k.add(this.f6603h);
                        this.f6603h.f6595l.add(dependencyNode);
                    }
                    i11++;
                }
                q(this.f6597b.f6537e.f6603h);
                q(this.f6597b.f6537e.f6604i);
                return;
            }
            if (iZ1 == 1) {
                this.f6603h.f6588e = DependencyNode.Type.RIGHT;
                while (i11 < aVar.W0) {
                    ConstraintWidget constraintWidget3 = aVar.V0[i11];
                    if (zY1 || constraintWidget3.X() != 8) {
                        DependencyNode dependencyNode2 = constraintWidget3.f6537e.f6604i;
                        dependencyNode2.f6594k.add(this.f6603h);
                        this.f6603h.f6595l.add(dependencyNode2);
                    }
                    i11++;
                }
                q(this.f6597b.f6537e.f6603h);
                q(this.f6597b.f6537e.f6604i);
                return;
            }
            if (iZ1 == 2) {
                this.f6603h.f6588e = DependencyNode.Type.TOP;
                while (i11 < aVar.W0) {
                    ConstraintWidget constraintWidget4 = aVar.V0[i11];
                    if (zY1 || constraintWidget4.X() != 8) {
                        DependencyNode dependencyNode3 = constraintWidget4.f6539f.f6603h;
                        dependencyNode3.f6594k.add(this.f6603h);
                        this.f6603h.f6595l.add(dependencyNode3);
                    }
                    i11++;
                }
                q(this.f6597b.f6539f.f6603h);
                q(this.f6597b.f6539f.f6604i);
                return;
            }
            if (iZ1 != 3) {
                return;
            }
            this.f6603h.f6588e = DependencyNode.Type.BOTTOM;
            while (i11 < aVar.W0) {
                ConstraintWidget constraintWidget5 = aVar.V0[i11];
                if (zY1 || constraintWidget5.X() != 8) {
                    DependencyNode dependencyNode4 = constraintWidget5.f6539f.f6604i;
                    dependencyNode4.f6594k.add(this.f6603h);
                    this.f6603h.f6595l.add(dependencyNode4);
                }
                i11++;
            }
            q(this.f6597b.f6539f.f6603h);
            q(this.f6597b.f6539f.f6604i);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void e() {
        ConstraintWidget constraintWidget = this.f6597b;
        if (constraintWidget instanceof androidx.constraintlayout.core.widgets.a) {
            int iZ1 = ((androidx.constraintlayout.core.widgets.a) constraintWidget).z1();
            if (iZ1 == 0 || iZ1 == 1) {
                this.f6597b.q1(this.f6603h.f6590g);
            } else {
                this.f6597b.r1(this.f6603h.f6590g);
            }
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void f() {
        this.f6598c = null;
        this.f6603h.c();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public boolean m() {
        return false;
    }
}
