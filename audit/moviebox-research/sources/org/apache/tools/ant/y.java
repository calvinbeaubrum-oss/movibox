package org.apache.tools.ant;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class y implements a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f73002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f73003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f73004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List f73005d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List f73006f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Location f73007g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Project f73008h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f73009i;

    public y() {
        this.f73003b = "";
        this.f73004c = "";
        this.f73005d = null;
        this.f73006f = new ArrayList();
        this.f73007g = Location.UNKNOWN_LOCATION;
        this.f73009i = null;
    }

    public y(y yVar) {
        this.f73003b = "";
        this.f73004c = "";
        this.f73005d = null;
        this.f73006f = new ArrayList();
        this.f73007g = Location.UNKNOWN_LOCATION;
        this.f73009i = null;
        this.f73002a = yVar.f73002a;
        this.f73003b = yVar.f73003b;
        this.f73004c = yVar.f73004c;
        this.f73005d = yVar.f73005d;
        this.f73007g = yVar.f73007g;
        this.f73008h = yVar.f73008h;
        this.f73009i = yVar.f73009i;
        this.f73006f = yVar.f73006f;
    }

    public void a(String str) {
        if (this.f73005d == null) {
            this.f73005d = new ArrayList(2);
        }
        this.f73005d.add(str);
    }

    @Override // org.apache.tools.ant.a0
    public void b(z zVar) {
        this.f73006f.add(zVar);
    }

    public Location c() {
        return this.f73007g;
    }

    public String d() {
        return this.f73002a;
    }

    public Project e() {
        return this.f73008h;
    }

    public z[] f() {
        ArrayList arrayList = new ArrayList(this.f73006f.size());
        for (Object obj : this.f73006f) {
            if (obj instanceof z) {
                arrayList.add(obj);
            }
        }
        return (z[]) arrayList.toArray(new z[arrayList.size()]);
    }

    public void g(z zVar, z zVar2) {
        while (true) {
            int iIndexOf = this.f73006f.indexOf(zVar);
            if (iIndexOf < 0) {
                return;
            } else {
                this.f73006f.set(iIndexOf, zVar2);
            }
        }
    }

    public void h(String str) {
        if (str.length() > 0) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, ",", true);
            while (stringTokenizer.hasMoreTokens()) {
                String strTrim = stringTokenizer.nextToken().trim();
                if ("".equals(strTrim) || ",".equals(strTrim)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Syntax Error: depends attribute of target \"");
                    stringBuffer.append(d());
                    stringBuffer.append("\" has an empty string as dependency.");
                    throw new BuildException(stringBuffer.toString());
                }
                a(strTrim);
                if (stringTokenizer.hasMoreTokens()) {
                    String strNextToken = stringTokenizer.nextToken();
                    if (!stringTokenizer.hasMoreTokens() || !",".equals(strNextToken)) {
                        StringBuffer stringBuffer2 = new StringBuffer();
                        stringBuffer2.append("Syntax Error: Depend attribute for target \"");
                        stringBuffer2.append(d());
                        stringBuffer2.append("\" ends with a , character");
                        throw new BuildException(stringBuffer2.toString());
                    }
                }
            }
        }
    }

    public void i(String str) {
        this.f73009i = str;
    }

    public void j(String str) {
        if (str == null) {
            str = "";
        }
        this.f73003b = str;
    }

    public void k(Location location) {
        this.f73007g = location;
    }

    public void l(String str) {
        this.f73002a = str;
    }

    public void m(Project project) {
        this.f73008h = project;
    }

    public void n(String str) {
        if (str == null) {
            str = "";
        }
        this.f73004c = str;
    }

    public String toString() {
        return this.f73002a;
    }
}
