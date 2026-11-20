package org.apache.tools.ant.taskdefs;

import java.io.IOException;
import org.apache.tools.ant.v;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class j extends org.apache.tools.ant.util.j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public v f72802c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f72803d;

    public j(v vVar) {
        this.f72803d = 2;
        this.f72802c = vVar;
    }

    public j(v vVar, int i11) {
        this(vVar);
        this.f72803d = i11;
    }

    @Override // org.apache.tools.ant.util.j
    public void a() {
        try {
            super.a();
        } catch (IOException e11) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Impossible IOException caught: ");
            stringBuffer.append(e11);
            throw new RuntimeException(stringBuffer.toString());
        }
    }

    @Override // org.apache.tools.ant.util.j
    public void b(String str) {
        c(str, this.f72803d);
    }

    public void c(String str, int i11) {
        this.f72802c.log(str, i11);
    }
}
