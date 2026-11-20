package org.apache.tools.ant;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class c0 extends z {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f72677h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f72679j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Object f72680k;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f72678i = "";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List f72681l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f72682m = false;

    public c0(String str) {
        this.f72677h = str;
    }

    public static boolean A(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equals(str2);
    }

    public String B() {
        return w.e(C(), G());
    }

    public String C() {
        return this.f72678i;
    }

    public BuildException D(String str, String str2) {
        return new BuildException(ComponentHelper.j(getProject()).f(str2, str), getLocation());
    }

    public String E() {
        return this.f72679j;
    }

    public Object F() {
        return this.f72680k;
    }

    public String G() {
        return this.f72677h;
    }

    public z H() {
        Object obj = this.f72680k;
        if (obj instanceof z) {
            return (z) obj;
        }
        return null;
    }

    public final boolean R(String str, t tVar, Object obj, c0 c0Var, RuntimeConfigurable runtimeConfigurable) {
        String strE = w.e(c0Var.C(), c0Var.G());
        if (!tVar.s(str, strE)) {
            return false;
        }
        t.d dVarI = tVar.i(getProject(), str, obj, strE, c0Var);
        dVarI.c(runtimeConfigurable.getPolyType());
        Object objA = dVarI.a();
        if (objA instanceof org.apache.tools.ant.taskdefs.l) {
            Object objB = dVarI.b();
            c0Var.x(((org.apache.tools.ant.taskdefs.l) objA).w());
            objA = objB;
        }
        runtimeConfigurable.setCreator(dVarI);
        runtimeConfigurable.setProxy(objA);
        if (objA instanceof z) {
            z zVar = (z) objA;
            zVar.r(runtimeConfigurable);
            zVar.s(strE);
            zVar.t(strE);
        }
        if (objA instanceof v) {
            ((v) objA).setLocation(c0Var.getLocation());
        }
        runtimeConfigurable.maybeConfigure(getProject());
        c0Var.S(objA, runtimeConfigurable);
        dVarI.d();
        return true;
    }

    public void S(Object obj, RuntimeConfigurable runtimeConfigurable) throws BuildException {
        if (obj instanceof b0) {
            obj = ((b0) obj).c();
        }
        String strC = C();
        t tVarK = t.k(getProject(), obj.getClass());
        List<c0> list = this.f72681l;
        if (list != null) {
            int i11 = 0;
            for (c0 c0Var : list) {
                RuntimeConfigurable child = runtimeConfigurable.getChild(i11);
                try {
                    if (!R(strC, tVarK, obj, c0Var, child)) {
                        if (obj instanceof a0) {
                            ((a0) obj).b(c0Var);
                        } else {
                            tVarK.t(getProject(), obj, c0Var.G());
                        }
                    }
                    i11++;
                } catch (UnsupportedElementException e11) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(runtimeConfigurable.getElementTag());
                    stringBuffer.append(" doesn't support the nested \"");
                    stringBuffer.append(e11.getElement());
                    stringBuffer.append("\" element.");
                    throw new BuildException(stringBuffer.toString(), e11);
                }
            }
        }
    }

    public Object T(c0 c0Var, RuntimeConfigurable runtimeConfigurable) {
        ComponentHelper componentHelperJ = ComponentHelper.j(getProject());
        String strB = c0Var.B();
        Object objE = componentHelperJ.e(c0Var, c0Var.C(), strB);
        if (objE == null) {
            throw D("task or type", strB);
        }
        if (objE instanceof org.apache.tools.ant.taskdefs.l) {
            org.apache.tools.ant.taskdefs.l lVar = (org.apache.tools.ant.taskdefs.l) objE;
            Object objV = lVar.v(c0Var.getProject());
            if (objV == null) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("preset ");
                stringBuffer.append(strB);
                throw D(stringBuffer.toString(), lVar.w().B());
            }
            c0Var.x(lVar.w());
            if (objV instanceof z) {
                z zVar = (z) objV;
                zVar.t(c0Var.k());
                zVar.s(c0Var.j());
                zVar.m();
            }
            objE = objV;
        }
        if (objE instanceof c0) {
            c0 c0Var2 = (c0) objE;
            objE = c0Var2.T(c0Var2, runtimeConfigurable);
        }
        if (objE instanceof z) {
            ((z) objE).q(d());
        }
        if (objE instanceof v) {
            ((v) objE).setLocation(getLocation());
        }
        return objE;
    }

    public void U(String str) {
        if (str.equals("ant:current")) {
            str = ComponentHelper.j(getProject()).k();
        }
        if (str == null) {
            str = "";
        }
        this.f72678i = str;
    }

    public void V(String str) {
        this.f72679j = str;
    }

    public void W(Object obj) {
        this.f72680k = obj;
    }

    public boolean X(Object obj) {
        if (obj == null || !getClass().getName().equals(obj.getClass().getName())) {
            return false;
        }
        c0 c0Var = (c0) obj;
        if (!A(this.f72677h, c0Var.f72677h) || !this.f72678i.equals(c0Var.f72678i) || !this.f72679j.equals(c0Var.f72679j) || !l().getAttributeMap().equals(c0Var.l().getAttributeMap()) || !l().getText().toString().equals(c0Var.l().getText().toString())) {
            return false;
        }
        List list = this.f72681l;
        if (list == null || list.size() == 0) {
            List list2 = c0Var.f72681l;
            return list2 == null || list2.size() == 0;
        }
        if (c0Var.f72681l == null || this.f72681l.size() != c0Var.f72681l.size()) {
            return false;
        }
        for (int i11 = 0; i11 < this.f72681l.size(); i11++) {
            if (!((c0) this.f72681l.get(i11)).X(c0Var.f72681l.get(i11))) {
                return false;
            }
        }
        return true;
    }

    @Override // org.apache.tools.ant.z
    public String j() {
        Object obj = this.f72680k;
        return (obj == null || !(obj instanceof z)) ? super.j() : ((z) obj).j();
    }

    @Override // org.apache.tools.ant.z
    public RuntimeConfigurable l() {
        return super.l();
    }

    @Override // org.apache.tools.ant.z
    public void n() throws BuildException {
        if (this.f72680k != null) {
            return;
        }
        y(T(this, l()));
    }

    public void v(c0 c0Var) {
        if (this.f72681l == null) {
            this.f72681l = new ArrayList();
        }
        this.f72681l.add(c0Var);
    }

    public void x(c0 c0Var) {
        if (this.f72682m) {
            return;
        }
        l().applyPreSet(c0Var.l());
        if (c0Var.f72681l != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(c0Var.f72681l);
            List list = this.f72681l;
            if (list != null) {
                arrayList.addAll(list);
            }
            this.f72681l = arrayList;
        }
        this.f72682m = true;
    }

    public void y(Object obj) {
        z zVar;
        this.f72680k = obj;
        l().setProxy(this.f72680k);
        Object obj2 = this.f72680k;
        if (obj2 instanceof z) {
            zVar = (z) obj2;
            zVar.r(l());
            if (l().getId() != null) {
                d().g(this, (z) this.f72680k);
            }
        } else {
            zVar = null;
        }
        if (zVar != null) {
            zVar.n();
        } else {
            l().maybeConfigure(getProject());
        }
        S(this.f72680k, l());
    }

    public c0 z(Project project) {
        c0 c0Var = new c0(G());
        c0Var.U(C());
        c0Var.setProject(project);
        c0Var.V(E());
        c0Var.t(k());
        c0Var.s(j());
        c0Var.setLocation(getLocation());
        if (d() == null) {
            y yVar = new y();
            yVar.m(getProject());
            c0Var.q(yVar);
        } else {
            c0Var.q(d());
        }
        RuntimeConfigurable runtimeConfigurable = new RuntimeConfigurable(c0Var, j());
        runtimeConfigurable.setPolyType(l().getPolyType());
        for (Map.Entry entry : l().getAttributeMap().entrySet()) {
            runtimeConfigurable.setAttribute((String) entry.getKey(), (String) entry.getValue());
        }
        runtimeConfigurable.addText(l().getText().toString());
        Enumeration children = l().getChildren();
        while (children.hasMoreElements()) {
            c0 c0VarZ = ((c0) ((RuntimeConfigurable) children.nextElement()).getProxy()).z(project);
            runtimeConfigurable.addChild(c0VarZ.l());
            c0Var.v(c0VarZ);
        }
        return c0Var;
    }
}
