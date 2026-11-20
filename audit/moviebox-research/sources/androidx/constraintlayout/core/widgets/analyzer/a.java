package androidx.constraintlayout.core.widgets.analyzer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class a extends DependencyNode {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f6607m;

    public a(WidgetRun widgetRun) {
        super(widgetRun);
        if (widgetRun instanceof c) {
            this.f6588e = DependencyNode.Type.HORIZONTAL_DIMENSION;
        } else {
            this.f6588e = DependencyNode.Type.VERTICAL_DIMENSION;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.DependencyNode
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
}
