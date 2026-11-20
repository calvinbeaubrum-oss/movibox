package org.apache.tools.ant.types;

import java.util.Vector;
import org.apache.tools.ant.BuildException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Vector f72878a = new Vector();

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f72879a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f72880b;

        public String a() throws BuildException {
            d();
            StringBuffer stringBuffer = new StringBuffer(this.f72879a.trim());
            stringBuffer.append("=");
            stringBuffer.append(this.f72880b.trim());
            return stringBuffer.toString();
        }

        public String b() {
            return this.f72879a;
        }

        public String c() {
            return this.f72880b;
        }

        public void d() {
            if (this.f72879a == null || this.f72880b == null) {
                throw new BuildException("key and value must be specified for environment variables.");
            }
        }
    }

    public String[] a() throws BuildException {
        if (this.f72878a.size() == 0) {
            return null;
        }
        int size = this.f72878a.size();
        String[] strArr = new String[size];
        for (int i11 = 0; i11 < size; i11++) {
            strArr[i11] = ((a) this.f72878a.elementAt(i11)).a();
        }
        return strArr;
    }
}
