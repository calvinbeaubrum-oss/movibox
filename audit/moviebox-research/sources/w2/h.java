package w2;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class h extends WidgetRun {
    public h(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        constraintWidget.f6537e.f();
        constraintWidget.f6539f.f();
        this.f6601f = ((androidx.constraintlayout.core.widgets.f) constraintWidget).w1();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, w2.d
    public void a(d dVar) {
        DependencyNode dependencyNode = this.f6603h;
        if (dependencyNode.f6586c && !dependencyNode.f6593j) {
            this.f6603h.d((int) ((dependencyNode.f6595l.get(0).f6590g * ((androidx.constraintlayout.core.widgets.f) this.f6597b).z1()) + 0.5f));
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void d() {
        androidx.constraintlayout.core.widgets.f fVar = (androidx.constraintlayout.core.widgets.f) this.f6597b;
        int iX1 = fVar.x1();
        int iY1 = fVar.y1();
        fVar.z1();
        if (fVar.w1() == 1) {
            if (iX1 != -1) {
                this.f6603h.f6595l.add(this.f6597b.f6534c0.f6537e.f6603h);
                this.f6597b.f6534c0.f6537e.f6603h.f6594k.add(this.f6603h);
                this.f6603h.f6589f = iX1;
            } else if (iY1 != -1) {
                this.f6603h.f6595l.add(this.f6597b.f6534c0.f6537e.f6604i);
                this.f6597b.f6534c0.f6537e.f6604i.f6594k.add(this.f6603h);
                this.f6603h.f6589f = -iY1;
            } else {
                DependencyNode dependencyNode = this.f6603h;
                dependencyNode.f6585b = true;
                dependencyNode.f6595l.add(this.f6597b.f6534c0.f6537e.f6604i);
                this.f6597b.f6534c0.f6537e.f6604i.f6594k.add(this.f6603h);
            }
            q(this.f6597b.f6537e.f6603h);
            q(this.f6597b.f6537e.f6604i);
            return;
        }
        if (iX1 != -1) {
            this.f6603h.f6595l.add(this.f6597b.f6534c0.f6539f.f6603h);
            this.f6597b.f6534c0.f6539f.f6603h.f6594k.add(this.f6603h);
            this.f6603h.f6589f = iX1;
        } else if (iY1 != -1) {
            this.f6603h.f6595l.add(this.f6597b.f6534c0.f6539f.f6604i);
            this.f6597b.f6534c0.f6539f.f6604i.f6594k.add(this.f6603h);
            this.f6603h.f6589f = -iY1;
        } else {
            DependencyNode dependencyNode2 = this.f6603h;
            dependencyNode2.f6585b = true;
            dependencyNode2.f6595l.add(this.f6597b.f6534c0.f6539f.f6604i);
            this.f6597b.f6534c0.f6539f.f6604i.f6594k.add(this.f6603h);
        }
        q(this.f6597b.f6539f.f6603h);
        q(this.f6597b.f6539f.f6604i);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void e() {
        if (((androidx.constraintlayout.core.widgets.f) this.f6597b).w1() == 1) {
            this.f6597b.q1(this.f6603h.f6590g);
        } else {
            this.f6597b.r1(this.f6603h.f6590g);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void f() {
        this.f6603h.c();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public boolean m() {
        return false;
    }

    public final void q(DependencyNode dependencyNode) {
        this.f6603h.f6594k.add(dependencyNode);
        dependencyNode.f6595l.add(this.f6603h);
    }
}
