package org.apache.tools.ant;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Project f72997a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public x f72998b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Hashtable f72999c = new Hashtable();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Hashtable f73000d = new Hashtable();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Hashtable f73001e = new Hashtable();

    public static synchronized x d(Project project) {
        x xVar = (x) project.t("ant.PropertyHelper");
        if (xVar != null) {
            return xVar;
        }
        x xVar2 = new x();
        xVar2.k(project);
        project.d("ant.PropertyHelper", xVar2);
        return xVar2;
    }

    public static void h(String str, Vector vector, Vector vector2) throws BuildException {
        int i11 = 0;
        while (true) {
            int iIndexOf = str.indexOf("$", i11);
            if (iIndexOf < 0) {
                if (i11 < str.length()) {
                    vector.addElement(str.substring(i11));
                    return;
                }
                return;
            }
            if (iIndexOf > 0) {
                vector.addElement(str.substring(i11, iIndexOf));
            }
            if (iIndexOf == str.length() - 1) {
                vector.addElement("$");
                i11 = iIndexOf + 1;
            } else {
                int i12 = iIndexOf + 1;
                if (str.charAt(i12) == '{') {
                    int iIndexOf2 = str.indexOf(125, iIndexOf);
                    if (iIndexOf2 < 0) {
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("Syntax error in property: ");
                        stringBuffer.append(str);
                        throw new BuildException(stringBuffer.toString());
                    }
                    String strSubstring = str.substring(iIndexOf + 2, iIndexOf2);
                    vector.addElement(null);
                    vector2.addElement(strSubstring);
                    i11 = iIndexOf2 + 1;
                } else if (str.charAt(i12) == '$') {
                    vector.addElement("$");
                    i11 = iIndexOf + 2;
                } else {
                    i11 = iIndexOf + 2;
                    vector.addElement(str.substring(iIndexOf, i11));
                }
            }
        }
    }

    public x a() {
        return this.f72998b;
    }

    public Hashtable b() {
        Hashtable hashtable;
        synchronized (this.f72999c) {
            hashtable = new Hashtable(this.f72999c);
        }
        return hashtable;
    }

    public synchronized Object c(String str, String str2) {
        if (str2 == null) {
            return null;
        }
        Object objE = e(str, str2, false);
        if (objE != null) {
            return objE;
        }
        return this.f72999c.get(str2);
    }

    public Object e(String str, String str2, boolean z11) {
        Object objE;
        if (a() != null && (objE = a().e(str, str2, z11)) != null) {
            return objE;
        }
        if (!str2.startsWith("toString:")) {
            return null;
        }
        Object objT = this.f72997a.t(str2.substring(9));
        if (objT == null) {
            return null;
        }
        return objT.toString();
    }

    public Hashtable f() {
        Hashtable hashtable;
        synchronized (this.f73000d) {
            hashtable = new Hashtable(this.f73000d);
        }
        return hashtable;
    }

    public void g(String str, Vector vector, Vector vector2) throws BuildException {
        h(str, vector, vector2);
    }

    public String i(String str, String str2, Hashtable hashtable) throws BuildException {
        if (str2 == null || str2.indexOf(36) == -1) {
            return str2;
        }
        Vector vector = new Vector();
        Vector vector2 = new Vector();
        g(str2, vector, vector2);
        StringBuffer stringBuffer = new StringBuffer();
        Enumeration enumerationElements = vector.elements();
        Enumeration enumerationElements2 = vector2.elements();
        while (enumerationElements.hasMoreElements()) {
            String string = (String) enumerationElements.nextElement();
            if (string == null) {
                String str3 = (String) enumerationElements2.nextElement();
                Object objC = hashtable != null ? hashtable.get(str3) : null;
                if (objC == null) {
                    objC = c(str, str3);
                }
                if (objC == null) {
                    Project project = this.f72997a;
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("Property \"");
                    stringBuffer2.append(str3);
                    stringBuffer2.append("\" has not been set");
                    project.x(stringBuffer2.toString(), 3);
                }
                if (objC != null) {
                    string = objC.toString();
                } else {
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append("${");
                    stringBuffer3.append(str3);
                    stringBuffer3.append("}");
                    string = stringBuffer3.toString();
                }
            }
            stringBuffer.append(string);
        }
        return stringBuffer.toString();
    }

    public synchronized void j(String str, String str2, Object obj) {
        if (this.f72999c.get(str2) != null) {
            Project project = this.f72997a;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Override ignored for property \"");
            stringBuffer.append(str2);
            stringBuffer.append("\"");
            project.x(stringBuffer.toString(), 3);
            return;
        }
        if (m(str, str2, obj, false, false, true)) {
            return;
        }
        Project project2 = this.f72997a;
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("Setting project property: ");
        stringBuffer2.append(str2);
        stringBuffer2.append(" -> ");
        stringBuffer2.append(obj);
        project2.x(stringBuffer2.toString(), 4);
        if (str2 != null && obj != null) {
            this.f72999c.put(str2, obj);
        }
    }

    public void k(Project project) {
        this.f72997a = project;
    }

    public synchronized boolean l(String str, String str2, Object obj, boolean z11) {
        if (this.f73000d.get(str2) != null) {
            if (z11) {
                Project project = this.f72997a;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Override ignored for user property \"");
                stringBuffer.append(str2);
                stringBuffer.append("\"");
                project.x(stringBuffer.toString(), 3);
            }
            return false;
        }
        if (m(str, str2, obj, false, false, false)) {
            return true;
        }
        if (this.f72999c.get(str2) != null && z11) {
            Project project2 = this.f72997a;
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Overriding previous definition of property \"");
            stringBuffer2.append(str2);
            stringBuffer2.append("\"");
            project2.x(stringBuffer2.toString(), 3);
        }
        if (z11) {
            Project project3 = this.f72997a;
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("Setting project property: ");
            stringBuffer3.append(str2);
            stringBuffer3.append(" -> ");
            stringBuffer3.append(obj);
            project3.x(stringBuffer3.toString(), 4);
        }
        if (str2 != null && obj != null) {
            this.f72999c.put(str2, obj);
        }
        return true;
    }

    public boolean m(String str, String str2, Object obj, boolean z11, boolean z12, boolean z13) {
        return a() != null && a().m(str, str2, obj, z11, z12, z13);
    }

    public synchronized void n(String str, String str2, Object obj) {
        Project project = this.f72997a;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Setting ro project property: ");
        stringBuffer.append(str2);
        stringBuffer.append(" -> ");
        stringBuffer.append(obj);
        project.x(stringBuffer.toString(), 4);
        this.f73000d.put(str2, obj);
        if (m(str, str2, obj, false, true, false)) {
            return;
        }
        this.f72999c.put(str2, obj);
    }
}
