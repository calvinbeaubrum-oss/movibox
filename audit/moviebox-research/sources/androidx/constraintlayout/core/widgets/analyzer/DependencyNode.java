package androidx.constraintlayout.core.widgets.analyzer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class DependencyNode implements w2.d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WidgetRun f6587d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f6589f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f6590g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public w2.d f6584a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f6585b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f6586c = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Type f6588e = Type.UNKNOWN;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f6591h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f6592i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f6593j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<w2.d> f6594k = new ArrayList();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<DependencyNode> f6595l = new ArrayList();

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public enum Type {
        UNKNOWN,
        HORIZONTAL_DIMENSION,
        VERTICAL_DIMENSION,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        BASELINE
    }

    public DependencyNode(WidgetRun widgetRun) {
        this.f6587d = widgetRun;
    }

    @Override // w2.d
    public void a(w2.d dVar) {
        Iterator<DependencyNode> it = this.f6595l.iterator();
        while (it.hasNext()) {
            if (!it.next().f6593j) {
                return;
            }
        }
        this.f6586c = true;
        w2.d dVar2 = this.f6584a;
        if (dVar2 != null) {
            dVar2.a(this);
        }
        if (this.f6585b) {
            this.f6587d.a(this);
            return;
        }
        DependencyNode dependencyNode = null;
        int i11 = 0;
        for (DependencyNode dependencyNode2 : this.f6595l) {
            if (!(dependencyNode2 instanceof a)) {
                i11++;
                dependencyNode = dependencyNode2;
            }
        }
        if (dependencyNode != null && i11 == 1 && dependencyNode.f6593j) {
            a aVar = this.f6592i;
            if (aVar != null) {
                if (!aVar.f6593j) {
                    return;
                } else {
                    this.f6589f = this.f6591h * aVar.f6590g;
                }
            }
            d(dependencyNode.f6590g + this.f6589f);
        }
        w2.d dVar3 = this.f6584a;
        if (dVar3 != null) {
            dVar3.a(this);
        }
    }

    public void b(w2.d dVar) {
        this.f6594k.add(dVar);
        if (this.f6593j) {
            dVar.a(dVar);
        }
    }

    public void c() {
        this.f6595l.clear();
        this.f6594k.clear();
        this.f6593j = false;
        this.f6590g = 0;
        this.f6586c = false;
        this.f6585b = false;
    }

    public void d(int i11) {
        if (this.f6593j) {
            return;
        }
        this.f6593j = true;
        this.f6590g = i11;
        for (w2.d dVar : this.f6594k) {
            dVar.a(dVar);
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f6587d.f6597b.v());
        sb2.append(":");
        sb2.append(this.f6588e);
        sb2.append("(");
        sb2.append(this.f6593j ? Integer.valueOf(this.f6590g) : "unresolved");
        sb2.append(") <t=");
        sb2.append(this.f6595l.size());
        sb2.append(":d=");
        sb2.append(this.f6594k.size());
        sb2.append(">");
        return sb2.toString();
    }
}
