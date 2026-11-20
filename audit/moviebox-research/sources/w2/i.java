package w2;

import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f79177h;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WidgetRun f79180c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WidgetRun f79181d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f79183f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f79184g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f79178a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f79179b = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList<WidgetRun> f79182e = new ArrayList<>();

    public i(WidgetRun widgetRun, int i11) {
        this.f79180c = null;
        this.f79181d = null;
        int i12 = f79177h;
        this.f79183f = i12;
        f79177h = i12 + 1;
        this.f79180c = widgetRun;
        this.f79181d = widgetRun;
        this.f79184g = i11;
    }

    public void a(WidgetRun widgetRun) {
        this.f79182e.add(widgetRun);
        this.f79181d = widgetRun;
    }

    public long b(androidx.constraintlayout.core.widgets.d dVar, int i11) {
        long j11;
        int i12;
        WidgetRun widgetRun = this.f79180c;
        if (widgetRun instanceof c) {
            if (((c) widgetRun).f6601f != i11) {
                return 0L;
            }
        } else if (i11 == 0) {
            if (!(widgetRun instanceof androidx.constraintlayout.core.widgets.analyzer.c)) {
                return 0L;
            }
        } else if (!(widgetRun instanceof androidx.constraintlayout.core.widgets.analyzer.d)) {
            return 0L;
        }
        DependencyNode dependencyNode = (i11 == 0 ? dVar.f6537e : dVar.f6539f).f6603h;
        DependencyNode dependencyNode2 = (i11 == 0 ? dVar.f6537e : dVar.f6539f).f6604i;
        boolean zContains = widgetRun.f6603h.f6595l.contains(dependencyNode);
        boolean zContains2 = this.f79180c.f6604i.f6595l.contains(dependencyNode2);
        long j12 = this.f79180c.j();
        if (zContains && zContains2) {
            long jD = d(this.f79180c.f6603h, 0L);
            long jC = c(this.f79180c.f6604i, 0L);
            long j13 = jD - j12;
            WidgetRun widgetRun2 = this.f79180c;
            int i13 = widgetRun2.f6604i.f6589f;
            if (j13 >= (-i13)) {
                j13 += (long) i13;
            }
            int i14 = widgetRun2.f6603h.f6589f;
            long j14 = ((-jC) - j12) - ((long) i14);
            if (j14 >= i14) {
                j14 -= (long) i14;
            }
            float fS = widgetRun2.f6597b.s(i11);
            float f11 = fS > 0.0f ? (long) ((j14 / fS) + (j13 / (1.0f - fS))) : 0L;
            long j15 = ((long) ((f11 * fS) + 0.5f)) + j12 + ((long) ((f11 * (1.0f - fS)) + 0.5f));
            WidgetRun widgetRun3 = this.f79180c;
            j11 = ((long) widgetRun3.f6603h.f6589f) + j15;
            i12 = widgetRun3.f6604i.f6589f;
        } else {
            if (zContains) {
                DependencyNode dependencyNode3 = this.f79180c.f6603h;
                return Math.max(d(dependencyNode3, dependencyNode3.f6589f), ((long) this.f79180c.f6603h.f6589f) + j12);
            }
            if (zContains2) {
                DependencyNode dependencyNode4 = this.f79180c.f6604i;
                return Math.max(-c(dependencyNode4, dependencyNode4.f6589f), ((long) (-this.f79180c.f6604i.f6589f)) + j12);
            }
            WidgetRun widgetRun4 = this.f79180c;
            j11 = ((long) widgetRun4.f6603h.f6589f) + widgetRun4.j();
            i12 = this.f79180c.f6604i.f6589f;
        }
        return j11 - ((long) i12);
    }

    public final long c(DependencyNode dependencyNode, long j11) {
        WidgetRun widgetRun = dependencyNode.f6587d;
        if (widgetRun instanceof androidx.constraintlayout.core.widgets.analyzer.b) {
            return j11;
        }
        int size = dependencyNode.f6594k.size();
        long jMin = j11;
        for (int i11 = 0; i11 < size; i11++) {
            d dVar = dependencyNode.f6594k.get(i11);
            if (dVar instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dVar;
                if (dependencyNode2.f6587d != widgetRun) {
                    jMin = Math.min(jMin, c(dependencyNode2, ((long) dependencyNode2.f6589f) + j11));
                }
            }
        }
        if (dependencyNode != widgetRun.f6604i) {
            return jMin;
        }
        long j12 = j11 - widgetRun.j();
        return Math.min(Math.min(jMin, c(widgetRun.f6603h, j12)), j12 - ((long) widgetRun.f6603h.f6589f));
    }

    public final long d(DependencyNode dependencyNode, long j11) {
        WidgetRun widgetRun = dependencyNode.f6587d;
        if (widgetRun instanceof androidx.constraintlayout.core.widgets.analyzer.b) {
            return j11;
        }
        int size = dependencyNode.f6594k.size();
        long jMax = j11;
        for (int i11 = 0; i11 < size; i11++) {
            d dVar = dependencyNode.f6594k.get(i11);
            if (dVar instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dVar;
                if (dependencyNode2.f6587d != widgetRun) {
                    jMax = Math.max(jMax, d(dependencyNode2, ((long) dependencyNode2.f6589f) + j11));
                }
            }
        }
        if (dependencyNode != widgetRun.f6603h) {
            return jMax;
        }
        long j12 = j11 + widgetRun.j();
        return Math.max(Math.max(jMax, d(widgetRun.f6604i, j12)), j12 - ((long) widgetRun.f6604i.f6589f));
    }
}
