package org.apache.tools.ant.taskdefs;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.z;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class b extends z {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f72754h = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ClassLoader f72755i;

    public ClassLoader v() {
        return this.f72755i;
    }

    public String x() {
        return this.f72754h;
    }

    public void y(ClassLoader classLoader) {
        this.f72755i = classLoader;
    }

    public void z(String str) throws BuildException {
        if (str.equals("antlib:org.apache.tools.ant")) {
            str = "";
        }
        if (!str.startsWith("ant:")) {
            this.f72754h = str;
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Attempt to use a reserved URI ");
        stringBuffer.append(str);
        throw new BuildException(stringBuffer.toString());
    }
}
