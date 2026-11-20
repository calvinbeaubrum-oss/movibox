package org.apache.tools.ant.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Vector;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f72962a = v20.a.a("dos");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f72963b = v20.a.b("netware");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f72964c = v20.a.b("aix");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f72965d = System.getProperty("java.home");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f72966e = d.k();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f72967f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f72968g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f72969h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Vector f72970i;

    static {
        try {
            f72967f = "1.1";
            f72968g = 10 + 1;
            Class.forName("java.lang.ThreadLocal");
            f72967f = "1.2";
            f72968g++;
            Class.forName("java.lang.StrictMath");
            int i11 = f72968g;
            f72967f = "1.4";
            f72968g = i11 + 2;
            Class.forName("java.net.Proxy");
            f72967f = "1.5";
            f72968g++;
            Class.forName("java.util.ServiceLoader");
            f72967f = "1.6";
            f72968g++;
        } catch (Throwable unused) {
        }
        f72969h = false;
        try {
            Class.forName("kaffe.util.NotImplemented");
            f72969h = true;
        } catch (Throwable unused2) {
        }
    }

    public static String a(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(f72962a ? ".exe" : "");
        return stringBuffer.toString();
    }

    public static void b() {
        Vector vector = new Vector();
        f72970i = vector;
        switch (f72968g) {
            case 15:
            case 16:
                vector.addElement("com.sun.org.apache");
            case 14:
                if (f72968g == 14) {
                    f72970i.addElement("org.apache.crimson");
                    f72970i.addElement("org.apache.xalan");
                    f72970i.addElement("org.apache.xml");
                    f72970i.addElement("org.apache.xpath");
                }
                f72970i.addElement("org.ietf.jgss");
                f72970i.addElement("org.w3c.dom");
                f72970i.addElement("org.xml.sax");
            case 13:
                f72970i.addElement("org.omg");
                f72970i.addElement("com.sun.corba");
                f72970i.addElement("com.sun.jndi");
                f72970i.addElement("com.sun.media");
                f72970i.addElement("com.sun.naming");
                f72970i.addElement("com.sun.org.omg");
                f72970i.addElement("com.sun.rmi");
                f72970i.addElement("sunw.io");
                f72970i.addElement("sunw.util");
            case 12:
                f72970i.addElement("com.sun.java");
                f72970i.addElement("com.sun.image");
                break;
        }
        f72970i.addElement("sun");
        f72970i.addElement("java");
        f72970i.addElement("javax");
    }

    public static File c(String[] strArr) throws Throwable {
        File fileF = f72966e.f("ANT", ".JAVA_OPTS", null, false, true);
        PrintWriter printWriter = null;
        try {
            PrintWriter printWriter2 = new PrintWriter(new BufferedWriter(new FileWriter(fileF)));
            for (String str : strArr) {
                try {
                    printWriter2.println(str);
                } catch (Throwable th2) {
                    th = th2;
                    printWriter = printWriter2;
                    d.e(printWriter);
                    throw th;
                }
            }
            d.e(printWriter2);
            return fileF;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static File d(String str, String str2) {
        File fileO = f72966e.o(str);
        if (!fileO.exists()) {
            return null;
        }
        File file = new File(fileO, a(str2));
        if (file.exists()) {
            return file;
        }
        return null;
    }

    public static String e() {
        return f72967f;
    }

    public static int f() {
        return f72968g;
    }

    public static String g(String str) {
        File fileD;
        if (f72963b) {
            return str;
        }
        if (f72964c) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(f72965d);
            stringBuffer.append("/sh");
            fileD = d(stringBuffer.toString(), str);
        } else {
            fileD = null;
        }
        if (fileD == null) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(f72965d);
            stringBuffer2.append("/bin");
            fileD = d(stringBuffer2.toString(), str);
        }
        return fileD != null ? fileD.getAbsolutePath() : a(str);
    }

    public static Vector h() {
        if (f72970i == null) {
            b();
        }
        return f72970i;
    }
}
