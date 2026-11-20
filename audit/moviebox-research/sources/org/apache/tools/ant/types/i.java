package org.apache.tools.ant.types;

import java.io.File;
import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Vector;
import org.apache.tools.ant.BuildException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class i extends e {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static /* synthetic */ Class f72882l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f72883a = "@";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f72884b = "@";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f72885c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f72886d = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Hashtable f72887f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Vector f72888g = new Vector();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b f72889h = b.f72896d;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f72890i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f72891j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Vector f72892k = new Vector();

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f72893a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f72894b;

        public a(String str, String str2) {
            a(str);
            b(str2);
        }

        public void a(String str) {
            this.f72893a = str;
        }

        public void b(String str) {
            this.f72894b = str;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String[] f72895c = {"fail", "warn", "ignore"};

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f72896d = new b("fail");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f72897e = new b("warn");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f72898f = new b("ignore");

        public b(String str) {
            e(str);
        }

        @Override // org.apache.tools.ant.types.f
        public String[] c() {
            return f72895c;
        }
    }

    public static /* synthetic */ Class c(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e11) {
            throw new NoClassDefFoundError(e11.getMessage());
        }
    }

    @Override // org.apache.tools.ant.types.e, org.apache.tools.ant.v
    public synchronized Object clone() throws BuildException {
        if (isReference()) {
            return h().clone();
        }
        try {
            i iVar = (i) super.clone();
            iVar.f72892k = (Vector) d().clone();
            iVar.setProject(getProject());
            return iVar;
        } catch (CloneNotSupportedException e11) {
            throw new BuildException(e11);
        }
    }

    public synchronized Vector d() {
        if (isReference()) {
            return h().d();
        }
        if (!this.f72890i) {
            this.f72890i = true;
            int size = this.f72888g.size();
            for (int i11 = 0; i11 < size; i11++) {
                k((File) this.f72888g.get(i11));
            }
            this.f72888g.clear();
            this.f72890i = false;
        }
        return this.f72892k;
    }

    public i h() {
        Class clsC = f72882l;
        if (clsC == null) {
            clsC = c("org.apache.tools.ant.types.FilterSet");
            f72882l = clsC;
        }
        return (i) getCheckedRef(clsC, "filterset");
    }

    public final void j(String str) {
        int iA = this.f72889h.a();
        if (iA == 0) {
            throw new BuildException(str);
        }
        if (iA == 1) {
            log(str, 1);
        } else if (iA != 2) {
            throw new BuildException("Invalid value for onMissingFiltersFile");
        }
    }

    public synchronized void k(File file) throws BuildException {
        try {
            if (isReference()) {
                throw tooManyAttributes();
            }
            if (!file.exists()) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Could not read filters from file ");
                stringBuffer.append(file);
                stringBuffer.append(" as it doesn't exist.");
                j(stringBuffer.toString());
            }
            FileInputStream fileInputStream = null;
            if (file.isFile()) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Reading filters from ");
                stringBuffer2.append(file);
                log(stringBuffer2.toString(), 3);
                try {
                    try {
                        Properties properties = new Properties();
                        FileInputStream fileInputStream2 = new FileInputStream(file);
                        try {
                            properties.load(fileInputStream2);
                            Enumeration<?> enumerationPropertyNames = properties.propertyNames();
                            Vector vectorD = d();
                            while (enumerationPropertyNames.hasMoreElements()) {
                                String str = (String) enumerationPropertyNames.nextElement();
                                vectorD.addElement(new a(str, properties.getProperty(str)));
                            }
                            org.apache.tools.ant.util.d.b(fileInputStream2);
                        } catch (Exception e11) {
                            e = e11;
                            fileInputStream = fileInputStream2;
                            StringBuffer stringBuffer3 = new StringBuffer();
                            stringBuffer3.append("Could not read filters from file: ");
                            stringBuffer3.append(file);
                            throw new BuildException(stringBuffer3.toString(), e);
                        } catch (Throwable th2) {
                            th = th2;
                            fileInputStream = fileInputStream2;
                            org.apache.tools.ant.util.d.b(fileInputStream);
                            throw th;
                        }
                    } catch (Exception e12) {
                        e = e12;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } else {
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append("Must specify a file rather than a directory in the filtersfile attribute:");
                stringBuffer4.append(file);
                j(stringBuffer4.toString());
            }
            this.f72887f = null;
        } catch (Throwable th4) {
            throw th4;
        }
    }
}
