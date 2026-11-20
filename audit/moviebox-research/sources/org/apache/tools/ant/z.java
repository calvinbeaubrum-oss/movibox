package org.apache.tools.ant;

import java.util.Enumeration;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class z extends v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y f73010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f73011b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f73012c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RuntimeConfigurable f73013d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f73014f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c0 f73015g;

    public void c() throws BuildException {
    }

    public y d() {
        return this.f73010a;
    }

    public final c0 h() {
        if (this.f73015g == null) {
            c0 c0Var = new c0(this.f73012c);
            this.f73015g = c0Var;
            c0Var.setProject(getProject());
            this.f73015g.t(this.f73012c);
            this.f73015g.s(this.f73011b);
            this.f73015g.setLocation(this.location);
            this.f73015g.q(this.f73010a);
            this.f73015g.r(this.f73013d);
            this.f73013d.setProxy(this.f73015g);
            p(this.f73013d, this.f73015g);
            this.f73010a.g(this, this.f73015g);
            this.f73015g.n();
        }
        return this.f73015g;
    }

    public String j() {
        return this.f73011b;
    }

    public String k() {
        return this.f73012c;
    }

    public RuntimeConfigurable l() {
        return this.f73013d;
    }

    @Override // org.apache.tools.ant.v
    public void log(String str) {
        log(str, 2);
    }

    @Override // org.apache.tools.ant.v
    public void log(String str, int i11) {
        if (getProject() != null) {
            getProject().z(this, str, i11);
        } else {
            super.log(str, i11);
        }
    }

    public void m() throws BuildException {
    }

    public void n() throws BuildException {
        if (this.f73014f) {
            h();
            return;
        }
        RuntimeConfigurable runtimeConfigurable = this.f73013d;
        if (runtimeConfigurable != null) {
            runtimeConfigurable.maybeConfigure(getProject());
        }
    }

    public final void o() throws Throwable {
        Throwable th2;
        if (this.f73014f) {
            h().H().o();
            return;
        }
        getProject().l(this);
        BuildException buildException = null;
        try {
            try {
                n();
                p20.a.a(this);
                getProject().k(this, null);
            } catch (Error e11) {
                throw e11;
            } catch (BuildException e12) {
                if (e12.getLocation() == Location.UNKNOWN_LOCATION) {
                    e12.setLocation(getLocation());
                }
                try {
                    throw e12;
                } catch (Throwable th3) {
                    th2 = th3;
                    buildException = e12;
                    getProject().k(this, buildException);
                    throw th2;
                }
            } catch (Exception e13) {
                BuildException buildException2 = new BuildException(e13);
                buildException2.setLocation(getLocation());
                throw buildException2;
            }
        } catch (Throwable th4) {
            th2 = th4;
            getProject().k(this, buildException);
            throw th2;
        }
    }

    public final void p(RuntimeConfigurable runtimeConfigurable, c0 c0Var) {
        Enumeration children = runtimeConfigurable.getChildren();
        while (children.hasMoreElements()) {
            RuntimeConfigurable runtimeConfigurable2 = (RuntimeConfigurable) children.nextElement();
            c0 c0Var2 = new c0(runtimeConfigurable2.getElementTag());
            c0Var.v(c0Var2);
            c0Var2.setProject(getProject());
            c0Var2.r(runtimeConfigurable2);
            runtimeConfigurable2.setProxy(c0Var2);
            p(runtimeConfigurable2, c0Var2);
        }
    }

    public void q(y yVar) {
        this.f73010a = yVar;
    }

    public void r(RuntimeConfigurable runtimeConfigurable) {
        this.f73013d = runtimeConfigurable;
    }

    public void s(String str) {
        this.f73011b = str;
    }

    public void t(String str) {
        this.f73012c = str;
    }
}
