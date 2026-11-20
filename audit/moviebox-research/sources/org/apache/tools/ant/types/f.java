package org.apache.tools.ant.types;

import org.apache.tools.ant.BuildException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f72876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f72877b = -1;

    public final int a() {
        return this.f72877b;
    }

    public final String b() {
        return this.f72876a;
    }

    public abstract String[] c();

    public final int d(String str) {
        String[] strArrC = c();
        if (strArrC != null && str != null) {
            for (int i11 = 0; i11 < strArrC.length; i11++) {
                if (str.equals(strArrC[i11])) {
                    return i11;
                }
            }
        }
        return -1;
    }

    public final void e(String str) throws BuildException {
        int iD = d(str);
        if (iD != -1) {
            this.f72877b = iD;
            this.f72876a = str;
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(" is not a legal value for this attribute");
            throw new BuildException(stringBuffer.toString());
        }
    }

    public String toString() {
        return b();
    }
}
