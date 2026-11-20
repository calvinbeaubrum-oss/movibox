package org.apache.tools.ant.taskdefs;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.c0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class l extends org.apache.tools.ant.b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public org.apache.tools.ant.b f72815h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public c0 f72816i;

    @Override // org.apache.tools.ant.b
    public void a(Project project) {
        this.f72815h.a(project);
    }

    @Override // org.apache.tools.ant.b
    public Object c(Project project) {
        return this;
    }

    @Override // org.apache.tools.ant.b
    public ClassLoader f() {
        return this.f72815h.f();
    }

    @Override // org.apache.tools.ant.b
    public String g() {
        return this.f72815h.g();
    }

    @Override // org.apache.tools.ant.b
    public Class h(Project project) {
        return this.f72815h.h(project);
    }

    @Override // org.apache.tools.ant.b
    public Class j(Project project) {
        return this.f72815h.j(project);
    }

    @Override // org.apache.tools.ant.b
    public boolean n(org.apache.tools.ant.b bVar, Project project) {
        org.apache.tools.ant.b bVar2;
        if (bVar != null && bVar.getClass() == getClass() && (bVar2 = this.f72815h) != null) {
            l lVar = (l) bVar;
            if (bVar2.n(lVar.f72815h, project) && this.f72816i.X(lVar.f72816i)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.tools.ant.b
    public void o(Class cls) {
        throw new BuildException("Not supported");
    }

    @Override // org.apache.tools.ant.b
    public void p(Class cls) {
        throw new BuildException("Not supported");
    }

    @Override // org.apache.tools.ant.b
    public void q(Class cls) {
        throw new BuildException("Not supported");
    }

    @Override // org.apache.tools.ant.b
    public void r(ClassLoader classLoader) {
        throw new BuildException("Not supported");
    }

    @Override // org.apache.tools.ant.b
    public void s(String str) {
        throw new BuildException("Not supported");
    }

    @Override // org.apache.tools.ant.b
    public boolean u(org.apache.tools.ant.b bVar, Project project) {
        org.apache.tools.ant.b bVar2;
        if (bVar != null && bVar.getClass().getName().equals(getClass().getName()) && (bVar2 = this.f72815h) != null) {
            l lVar = (l) bVar;
            if (bVar2.u(lVar.f72815h, project) && this.f72816i.X(lVar.f72816i)) {
                return true;
            }
        }
        return false;
    }

    public Object v(Project project) {
        return this.f72815h.c(project);
    }

    public c0 w() {
        return this.f72816i;
    }
}
