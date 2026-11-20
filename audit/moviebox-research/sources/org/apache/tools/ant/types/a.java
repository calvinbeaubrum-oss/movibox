package org.apache.tools.ant.types;

import java.util.Vector;
import org.apache.tools.ant.BuildException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class a extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f72852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Vector f72853b = new Vector();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public n f72854c;

    public String c() {
        return this.f72852a;
    }

    public n d() {
        return this.f72854c;
    }

    public l[] h() {
        l[] lVarArr = new l[this.f72853b.size()];
        this.f72853b.copyInto(lVarArr);
        return lVarArr;
    }

    @Override // org.apache.tools.ant.types.e
    public void setRefid(r rVar) throws BuildException {
        if (!this.f72853b.isEmpty() || this.f72852a != null || this.f72854c != null) {
            throw tooManyAttributes();
        }
        getProject();
        throw null;
    }
}
