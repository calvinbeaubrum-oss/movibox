package org.apache.tools.ant.types;

import java.util.Vector;
import org.apache.tools.ant.BuildException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class h extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Vector f72881a = new Vector();

    public Vector c() {
        return this.f72881a;
    }

    @Override // org.apache.tools.ant.types.e
    public void setRefid(r rVar) throws BuildException {
        if (!this.f72881a.isEmpty()) {
            throw tooManyAttributes();
        }
        getProject();
        throw null;
    }
}
