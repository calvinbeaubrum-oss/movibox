package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f1064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f1065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f1066c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LayoutInflater f1067d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LayoutInflater f1068f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public l.a f1069g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f1070h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f1071i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public m f1072j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f1073k;

    public b(Context context, int i11, int i12) {
        this.f1064a = context;
        this.f1067d = LayoutInflater.from(context);
        this.f1070h = i11;
        this.f1071i = i12;
    }

    public void a(View view, int i11) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f1072j).addView(view, i11);
    }

    @Override // androidx.appcompat.view.menu.l
    public void b(f fVar, boolean z11) {
        l.a aVar = this.f1069g;
        if (aVar != null) {
            aVar.b(fVar, z11);
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean c(f fVar, h hVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.l
    public void d(l.a aVar) {
        this.f1069g = aVar;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.appcompat.view.menu.l
    public boolean f(q qVar) {
        l.a aVar = this.f1069g;
        f fVar = qVar;
        if (aVar == null) {
            return false;
        }
        if (qVar == null) {
            fVar = this.f1066c;
        }
        return aVar.c(fVar);
    }

    @Override // androidx.appcompat.view.menu.l
    public int getId() {
        return this.f1073k;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.l
    public void h(boolean z11) {
        ViewGroup viewGroup = (ViewGroup) this.f1072j;
        if (viewGroup == null) {
            return;
        }
        f fVar = this.f1066c;
        int i11 = 0;
        if (fVar != null) {
            fVar.t();
            ArrayList<h> arrayListG = this.f1066c.G();
            int size = arrayListG.size();
            int i12 = 0;
            for (int i13 = 0; i13 < size; i13++) {
                h hVar = arrayListG.get(i13);
                if (s(i12, hVar)) {
                    View childAt = viewGroup.getChildAt(i12);
                    h itemData = childAt instanceof m.a ? ((m.a) childAt).getItemData() : null;
                    View viewP = p(hVar, childAt, viewGroup);
                    if (hVar != itemData) {
                        viewP.setPressed(false);
                        viewP.jumpDrawablesToCurrentState();
                    }
                    if (viewP != childAt) {
                        a(viewP, i12);
                    }
                    i12++;
                }
            }
            i11 = i12;
        }
        while (i11 < viewGroup.getChildCount()) {
            if (!n(viewGroup, i11)) {
                i11++;
            }
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean j(f fVar, h hVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.l
    public void k(Context context, f fVar) {
        this.f1065b = context;
        this.f1068f = LayoutInflater.from(context);
        this.f1066c = fVar;
    }

    public abstract void l(h hVar, m.a aVar);

    public m.a m(ViewGroup viewGroup) {
        return (m.a) this.f1067d.inflate(this.f1071i, viewGroup, false);
    }

    public boolean n(ViewGroup viewGroup, int i11) {
        viewGroup.removeViewAt(i11);
        return true;
    }

    public l.a o() {
        return this.f1069g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View p(h hVar, View view, ViewGroup viewGroup) {
        m.a aVarM = view instanceof m.a ? (m.a) view : m(viewGroup);
        l(hVar, aVarM);
        return (View) aVarM;
    }

    public m q(ViewGroup viewGroup) {
        if (this.f1072j == null) {
            m mVar = (m) this.f1067d.inflate(this.f1070h, viewGroup, false);
            this.f1072j = mVar;
            mVar.initialize(this.f1066c);
            h(true);
        }
        return this.f1072j;
    }

    public void r(int i11) {
        this.f1073k = i11;
    }

    public abstract boolean s(int i11, h hVar);
}
