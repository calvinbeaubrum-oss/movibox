package org.apache.tools.ant.taskdefs;

import org.apache.tools.ant.BuildException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class c extends b {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ClassLoader f72756j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public org.apache.tools.ant.util.a.C0787a f72757k;

    public ClassLoader A() {
        if (v() != null && this.f72757k == null) {
            return v();
        }
        if (this.f72756j == null) {
            ClassLoader classLoaderB = B().b();
            this.f72756j = classLoaderB;
            ((org.apache.tools.ant.a) classLoaderB).h("org.apache.tools.ant");
        }
        return this.f72756j;
    }

    public final org.apache.tools.ant.util.a.C0787a B() {
        if (this.f72757k == null) {
            this.f72757k = org.apache.tools.ant.util.a.c(this);
        }
        return this.f72757k;
    }

    @Override // org.apache.tools.ant.z
    public void m() throws BuildException {
        super.m();
    }
}
