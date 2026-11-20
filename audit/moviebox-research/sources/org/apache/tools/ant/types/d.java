package org.apache.tools.ant.types;

import java.util.Enumeration;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Properties;
import java.util.Vector;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class d implements Cloneable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f72869g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f72864a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f72865b = new c();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f72866c = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public n f72867d = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public n f72868f = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f72870h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b f72871i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f72872j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f72873k = false;

    /* JADX INFO: compiled from: source.java */
    public static class a extends g implements Cloneable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Properties f72874b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Vector f72875c = new Vector();

        public void b(ListIterator listIterator) {
            String[] strArrA = super.a();
            if (strArrA != null) {
                for (String str : strArrA) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("-D");
                    stringBuffer.append(str);
                    listIterator.add(stringBuffer.toString());
                }
            }
            Properties propertiesF = f();
            Enumeration enumerationKeys = propertiesF.keys();
            while (enumerationKeys.hasMoreElements()) {
                String str2 = (String) enumerationKeys.nextElement();
                String property = propertiesF.getProperty(str2);
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("-D");
                stringBuffer2.append(str2);
                stringBuffer2.append("=");
                stringBuffer2.append(property);
                listIterator.add(stringBuffer2.toString());
            }
        }

        public void c(a aVar) {
            this.f72878a.addAll(aVar.f72878a);
            this.f72875c.addAll(aVar.f72875c);
        }

        public Object clone() throws CloneNotSupportedException {
            try {
                a aVar = (a) super.clone();
                aVar.f72878a = (Vector) this.f72878a.clone();
                aVar.f72875c = (Vector) this.f72875c.clone();
                return aVar;
            } catch (CloneNotSupportedException unused) {
                return null;
            }
        }

        public void d(q qVar) {
            this.f72875c.addElement(qVar);
        }

        public final Properties f() {
            Properties properties = new Properties();
            Enumeration enumerationElements = this.f72875c.elements();
            while (enumerationElements.hasMoreElements()) {
                properties.putAll(((q) enumerationElements.nextElement()).o());
            }
            return properties;
        }

        public void g() throws BuildException {
            Properties properties = this.f72874b;
            if (properties == null) {
                throw new BuildException("Unbalanced nesting of SysProperties");
            }
            try {
                System.setProperties(properties);
                this.f72874b = null;
            } catch (SecurityException e11) {
                throw new BuildException("Cannot modify system properties", e11);
            }
        }

        public void h() throws BuildException {
            try {
                this.f72874b = System.getProperties();
                Properties properties = new Properties();
                Enumeration<?> enumerationPropertyNames = this.f72874b.propertyNames();
                while (enumerationPropertyNames.hasMoreElements()) {
                    String str = (String) enumerationPropertyNames.nextElement();
                    properties.put(str, this.f72874b.getProperty(str));
                }
                properties.putAll(f());
                Enumeration enumerationElements = this.f72878a.elements();
                while (enumerationElements.hasMoreElements()) {
                    g.a aVar = (g.a) enumerationElements.nextElement();
                    aVar.d();
                    properties.put(aVar.b(), aVar.c());
                }
                System.setProperties(properties);
            } catch (SecurityException e11) {
                throw new BuildException("Cannot modify system properties", e11);
            }
        }
    }

    public d() {
        n(org.apache.tools.ant.util.f.g("java"));
        o(org.apache.tools.ant.util.f.e());
    }

    public final void a(ListIterator listIterator) {
        g().b(listIterator);
        this.f72866c.b(listIterator);
        if (l()) {
            a aVar = new a();
            q qVar = new q();
            q.a aVar2 = new q.a();
            aVar2.e("system");
            qVar.h(aVar2);
            aVar.d(qVar);
            aVar.b(listIterator);
        }
        n nVarC = c(true);
        if (nVarC.size() > 0) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("-Xbootclasspath:");
            stringBuffer.append(nVarC.toString());
            listIterator.add(stringBuffer.toString());
        }
        if (k()) {
            listIterator.add("-classpath");
            listIterator.add(this.f72867d.p("ignore").toString());
        }
        if (h() != null) {
            h().c(listIterator);
        }
        if (this.f72872j) {
            listIterator.add("-jar");
        }
        this.f72865b.b(listIterator);
    }

    public void b(a aVar) {
        this.f72866c.c(aVar);
    }

    public final n c(boolean z11) {
        if (this.f72869g.startsWith("1.1")) {
            n nVar = this.f72868f;
            if (nVar != null && z11) {
                nVar.log("Ignoring bootclasspath as the target VM doesn't support it.");
            }
        } else {
            n nVar2 = this.f72868f;
            if (nVar2 != null) {
                return nVar2.o(l() ? "last" : "ignore");
            }
            if (l()) {
                return n.f72901d;
            }
        }
        return new n(null);
    }

    public Object clone() throws CloneNotSupportedException {
        try {
            d dVar = (d) super.clone();
            dVar.f72864a = (c) this.f72864a.clone();
            dVar.f72865b = (c) this.f72865b.clone();
            dVar.f72866c = (a) this.f72866c.clone();
            n nVar = this.f72867d;
            if (nVar != null) {
                dVar.f72867d = (n) nVar.clone();
            }
            n nVar2 = this.f72868f;
            if (nVar2 != null) {
                dVar.f72868f = (n) nVar2.clone();
            }
            b bVar = this.f72871i;
            if (bVar != null) {
                dVar.f72871i = (b) bVar.clone();
            }
            return dVar;
        } catch (CloneNotSupportedException e11) {
            throw new BuildException(e11);
        }
    }

    public c.a d() {
        return this.f72865b.c();
    }

    public n f(Project project) {
        if (this.f72867d == null) {
            this.f72867d = new n(project);
        }
        return this.f72867d;
    }

    public c g() {
        c cVar = (c) this.f72864a.clone();
        if (this.f72870h != null) {
            if (this.f72869g.startsWith("1.1")) {
                c.a aVarC = cVar.c();
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("-mx");
                stringBuffer.append(this.f72870h);
                aVarC.d(stringBuffer.toString());
            } else {
                c.a aVarC2 = cVar.c();
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("-Xmx");
                stringBuffer2.append(this.f72870h);
                aVarC2.d(stringBuffer2.toString());
            }
        }
        return cVar;
    }

    public b h() {
        return this.f72871i;
    }

    public String[] j() {
        LinkedList linkedList = new LinkedList();
        a(linkedList.listIterator());
        return (String[]) linkedList.toArray(new String[linkedList.size()]);
    }

    public boolean k() {
        n nVar = this.f72867d;
        n nVarP = nVar != null ? nVar.p("ignore") : null;
        return nVarP != null && nVarP.toString().trim().length() > 0;
    }

    public final boolean l() {
        return this.f72873k || "true".equals(System.getProperty("ant.build.clonevm"));
    }

    public void m(String str) {
        this.f72865b.m(str);
        this.f72872j = false;
    }

    public void n(String str) {
        this.f72864a.m(str);
    }

    public void o(String str) {
        this.f72869g = str;
    }

    public String toString() {
        return c.n(j());
    }
}
