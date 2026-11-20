package org.apache.tools.ant.taskdefs;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.ComponentHelper;
import org.apache.tools.ant.w;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class e extends c {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static b f72761x = new b(null);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f72762l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f72763m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public File f72764n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f72765o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f72766p = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f72767q = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f72768r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f72769s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f72770t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Class f72771u;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Class f72772w;

    /* JADX INFO: compiled from: source.java */
    public static class a extends org.apache.tools.ant.types.f {
        public a(String str) {
            e(str);
        }

        @Override // org.apache.tools.ant.types.f
        public String[] c() {
            return new String[]{"fail", "report", "ignore", "failall"};
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b extends ThreadLocal {
        public b() {
        }

        public /* synthetic */ b(d dVar) {
            this();
        }

        public Map a() {
            return (Map) get();
        }

        @Override // java.lang.ThreadLocal
        public Object initialValue() {
            return new HashMap();
        }
    }

    public static String G(String str) {
        String strSubstring = str.substring(7);
        if (!strSubstring.startsWith("//")) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(strSubstring.replace('.', '/'));
            stringBuffer.append("/antlib.xml");
            return stringBuffer.toString();
        }
        String strSubstring2 = strSubstring.substring(2);
        if (strSubstring2.endsWith(".xml")) {
            return strSubstring2;
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(strSubstring2);
        stringBuffer2.append("/antlib.xml");
        return stringBuffer2.toString();
    }

    public void C(ClassLoader classLoader, String str, String str2) throws BuildException {
        try {
            try {
                String strE = w.e(x(), str);
                Class<?> cls = this.f72768r != 2 ? Class.forName(str2, true, classLoader) : null;
                String str3 = this.f72769s;
                if (str3 != null) {
                    this.f72771u = Class.forName(str3, true, classLoader);
                }
                String str4 = this.f72770t;
                if (str4 != null) {
                    this.f72772w = Class.forName(str4, true, classLoader);
                }
                org.apache.tools.ant.b bVar = new org.apache.tools.ant.b();
                bVar.t(strE);
                bVar.s(str2);
                bVar.q(cls);
                bVar.p(this.f72771u);
                bVar.o(this.f72772w);
                bVar.r(classLoader);
                if (cls != null) {
                    bVar.a(getProject());
                }
                ComponentHelper.j(getProject()).a(bVar);
            } catch (ClassNotFoundException e11) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(j());
                stringBuffer.append(" class ");
                stringBuffer.append(str2);
                stringBuffer.append(" cannot be found");
                throw new BuildException(stringBuffer.toString(), e11, getLocation());
            } catch (NoClassDefFoundError e12) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append(j());
                stringBuffer2.append(" A class needed by class ");
                stringBuffer2.append(str2);
                stringBuffer2.append(" cannot be found: ");
                stringBuffer2.append(e12.getMessage());
                throw new BuildException(stringBuffer2.toString(), e12, getLocation());
            }
        } catch (BuildException e13) {
            int i11 = this.f72768r;
            if (i11 != 0) {
                if (i11 == 1) {
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append(e13.getLocation());
                    stringBuffer3.append("Warning: ");
                    stringBuffer3.append(e13.getMessage());
                    log(stringBuffer3.toString(), 1);
                    return;
                }
                if (i11 != 3) {
                    StringBuffer stringBuffer4 = new StringBuffer();
                    stringBuffer4.append(e13.getLocation());
                    stringBuffer4.append(e13.getMessage());
                    log(stringBuffer4.toString(), 4);
                    return;
                }
            }
            throw e13;
        }
    }

    public final URL D() {
        String string;
        if (this.f72764n.exists()) {
            string = null;
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("File ");
            stringBuffer.append(this.f72764n);
            stringBuffer.append(" does not exist");
            string = stringBuffer.toString();
        }
        if (string == null && !this.f72764n.isFile()) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("File ");
            stringBuffer2.append(this.f72764n);
            stringBuffer2.append(" is not a file");
            string = stringBuffer2.toString();
        }
        if (string == null) {
            try {
                return this.f72764n.toURL();
            } catch (Exception e11) {
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("File ");
                stringBuffer3.append(this.f72764n);
                stringBuffer3.append(" cannot use as URL: ");
                stringBuffer3.append(e11.toString());
                string = stringBuffer3.toString();
            }
        }
        int i11 = this.f72768r;
        if (i11 == 0 || i11 == 1) {
            log(string, 1);
        } else if (i11 == 2) {
            log(string, 3);
        } else if (i11 == 3) {
            throw new BuildException(string);
        }
        return null;
    }

    public final void E(ClassLoader classLoader, URL url) {
        try {
            org.apache.tools.ant.taskdefs.a aVarX = org.apache.tools.ant.taskdefs.a.x(getProject(), url, x());
            aVarX.z(classLoader);
            aVarX.A(x());
            aVarX.c();
        } catch (BuildException e11) {
            throw w.a(e11, getLocation());
        }
    }

    public void F(ClassLoader classLoader, URL url) {
        try {
            try {
                InputStream inputStreamOpenStream = FirebasePerfUrlConnection.openStream(url);
                if (inputStreamOpenStream == null) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Could not load definitions from ");
                    stringBuffer.append(url);
                    log(stringBuffer.toString(), 1);
                    org.apache.tools.ant.util.d.b(inputStreamOpenStream);
                    return;
                }
                Properties properties = new Properties();
                properties.load(inputStreamOpenStream);
                Enumeration enumerationKeys = properties.keys();
                while (enumerationKeys.hasMoreElements()) {
                    String str = (String) enumerationKeys.nextElement();
                    this.f72762l = str;
                    String property = properties.getProperty(str);
                    this.f72763m = property;
                    C(classLoader, this.f72762l, property);
                }
                org.apache.tools.ant.util.d.b(inputStreamOpenStream);
            } catch (IOException e11) {
                throw new BuildException(e11, getLocation());
            }
        } catch (Throwable th2) {
            org.apache.tools.ant.util.d.b(null);
            throw th2;
        }
    }

    public final Enumeration H(ClassLoader classLoader) {
        try {
            Enumeration<URL> resources = classLoader.getResources(this.f72765o);
            if (!resources.hasMoreElements()) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Could not load definitions from resource ");
                stringBuffer.append(this.f72765o);
                stringBuffer.append(". It could not be found.");
                String string = stringBuffer.toString();
                int i11 = this.f72768r;
                if (i11 == 0 || i11 == 1) {
                    log(string, 1);
                } else if (i11 == 2) {
                    log(string, 3);
                } else if (i11 == 3) {
                    throw new BuildException(string);
                }
            }
            return resources;
        } catch (IOException e11) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Could not fetch resources named ");
            stringBuffer2.append(this.f72765o);
            throw new BuildException(stringBuffer2.toString(), e11, getLocation());
        }
    }

    public void R(a aVar) {
        this.f72768r = aVar.a();
    }

    public void S(String str) {
        if (this.f72767q) {
            T();
        }
        this.f72767q = true;
        this.f72765o = str;
    }

    public final void T() {
        throw new BuildException("Only one of the attributes name, file and resource can be set", getLocation());
    }

    @Override // org.apache.tools.ant.z
    public void c() throws BuildException {
        Enumeration enumerationH;
        ClassLoader classLoaderA = A();
        if (!this.f72767q) {
            if (x() == null) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("name, file or resource attribute of ");
                stringBuffer.append(j());
                stringBuffer.append(" is undefined");
                throw new BuildException(stringBuffer.toString(), getLocation());
            }
            if (!x().startsWith("antlib:")) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Only antlib URIs can be located from the URI alone,not the URI ");
                stringBuffer2.append(x());
                throw new BuildException(stringBuffer2.toString());
            }
            S(G(x()));
        }
        String str = this.f72762l;
        if (str != null) {
            String str2 = this.f72763m;
            if (str2 != null) {
                C(classLoaderA, str, str2);
                return;
            }
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("classname attribute of ");
            stringBuffer3.append(j());
            stringBuffer3.append(" element ");
            stringBuffer3.append("is undefined");
            throw new BuildException(stringBuffer3.toString(), getLocation());
        }
        if (this.f72763m != null) {
            throw new BuildException("You must not specify classname together with file or resource.", getLocation());
        }
        if (this.f72764n != null) {
            URL urlD = D();
            if (urlD == null) {
                return;
            } else {
                enumerationH = new d(this, urlD);
            }
        } else {
            enumerationH = H(classLoaderA);
        }
        while (enumerationH.hasMoreElements()) {
            URL url = (URL) enumerationH.nextElement();
            int i11 = this.f72766p;
            if (!url.toString().toLowerCase(Locale.US).endsWith(".xml") && i11 == 0) {
                F(classLoaderA, url);
                return;
            }
            if (f72761x.a().get(url) != null) {
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append("Warning: Recursive loading of ");
                stringBuffer4.append(url);
                stringBuffer4.append(" ignored");
                stringBuffer4.append(" at ");
                stringBuffer4.append(getLocation());
                stringBuffer4.append(" originally loaded at ");
                stringBuffer4.append(f72761x.a().get(url));
                log(stringBuffer4.toString(), 1);
            } else {
                try {
                    f72761x.a().put(url, getLocation());
                    E(classLoaderA, url);
                    f72761x.a().remove(url);
                } catch (Throwable th2) {
                    f72761x.a().remove(url);
                    throw th2;
                }
            }
        }
    }
}
