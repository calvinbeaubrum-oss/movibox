package org.apache.tools.ant.types;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Vector;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.v;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class c implements Cloneable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f72859c = v20.a.a("win9x");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f72860d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Vector f72861a = new Vector();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f72862b = null;

    /* JADX INFO: compiled from: source.java */
    public static class a extends v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String[] f72863a;

        public String[] c() {
            return this.f72863a;
        }

        public void d(String str) {
            this.f72863a = new String[]{str};
        }
    }

    static {
        StringBuffer stringBuffer = new StringBuffer();
        String str = org.apache.tools.ant.util.p.f72993a;
        stringBuffer.append(str);
        stringBuffer.append("The ' characters around the executable and arguments are");
        stringBuffer.append(str);
        stringBuffer.append("not part of the command.");
        stringBuffer.append(str);
        f72860d = stringBuffer.toString();
    }

    public static String f(String[] strArr, int i11) {
        if (strArr == null || strArr.length <= i11) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer("argument");
        if (strArr.length > i11) {
            stringBuffer.append("s");
        }
        stringBuffer.append(":");
        stringBuffer.append(org.apache.tools.ant.util.p.f72993a);
        while (i11 < strArr.length) {
            stringBuffer.append("'");
            stringBuffer.append(strArr[i11]);
            stringBuffer.append("'");
            stringBuffer.append(org.apache.tools.ant.util.p.f72993a);
            i11++;
        }
        stringBuffer.append(f72860d);
        return stringBuffer.toString();
    }

    public static String g(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer("Executing '");
        stringBuffer.append(strArr[0]);
        stringBuffer.append("'");
        if (strArr.length > 1) {
            stringBuffer.append(" with ");
            stringBuffer.append(f(strArr, 1));
        } else {
            stringBuffer.append(f72860d);
        }
        return stringBuffer.toString();
    }

    public static String l(String str) {
        if (str.indexOf("\"") > -1) {
            if (str.indexOf("'") > -1) {
                throw new BuildException("Can't handle single and double quotes in same argument");
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append('\'');
            stringBuffer.append(str);
            stringBuffer.append('\'');
            return stringBuffer.toString();
        }
        if (str.indexOf("'") <= -1 && str.indexOf(" ") <= -1 && (!f72859c || str.indexOf(59) == -1)) {
            return str;
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append('\"');
        stringBuffer2.append(str);
        stringBuffer2.append('\"');
        return stringBuffer2.toString();
    }

    public static String n(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i11 = 0; i11 < strArr.length; i11++) {
            if (i11 > 0) {
                stringBuffer.append(' ');
            }
            stringBuffer.append(l(strArr[i11]));
        }
        return stringBuffer.toString();
    }

    public void a(ListIterator listIterator) {
        for (int i11 = 0; i11 < this.f72861a.size(); i11++) {
            String[] strArrC = ((a) this.f72861a.elementAt(i11)).c();
            if (strArrC != null) {
                for (String str : strArrC) {
                    listIterator.add(str);
                }
            }
        }
    }

    public void b(ListIterator listIterator) {
        String str = this.f72862b;
        if (str != null) {
            listIterator.add(str);
        }
        a(listIterator);
    }

    public a c() {
        return d(false);
    }

    public Object clone() {
        try {
            c cVar = (c) super.clone();
            cVar.f72861a = (Vector) this.f72861a.clone();
            return cVar;
        } catch (CloneNotSupportedException e11) {
            throw new BuildException(e11);
        }
    }

    public a d(boolean z11) {
        a aVar = new a();
        if (z11) {
            this.f72861a.insertElementAt(aVar, 0);
        } else {
            this.f72861a.addElement(aVar);
        }
        return aVar;
    }

    public String[] h() {
        ArrayList arrayList = new ArrayList(this.f72861a.size() * 2);
        a(arrayList.listIterator());
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public String[] j() {
        LinkedList linkedList = new LinkedList();
        b(linkedList.listIterator());
        return (String[]) linkedList.toArray(new String[linkedList.size()]);
    }

    public String k() {
        return this.f72862b;
    }

    public void m(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        char c11 = File.separatorChar;
        this.f72862b = str.replace('/', c11).replace('\\', c11);
    }

    public String toString() {
        return n(j());
    }
}
