package org.apache.tools.ant;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.apache.tools.ant.taskdefs.ManifestException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class a extends ClassLoader implements c {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final org.apache.tools.ant.util.d f72652k = org.apache.tools.ant.util.d.k();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static Map f72653l = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static /* synthetic */ Class f72654m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static /* synthetic */ Class f72655n;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Project f72657b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Vector f72656a = new Vector();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f72658c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Vector f72659d = new Vector();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Vector f72660e = new Vector();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f72661f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ClassLoader f72662g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Hashtable f72663h = new Hashtable();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ClassLoader f72664i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f72665j = false;

    /* JADX INFO: renamed from: org.apache.tools.ant.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0785a implements Enumeration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f72666a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f72667b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public URL f72668c;

        public C0785a(String str) {
            this.f72666a = str;
            a();
        }

        public final void a() {
            URL urlV = null;
            while (this.f72667b < a.this.f72656a.size() && urlV == null) {
                try {
                    urlV = a.this.v((File) a.this.f72656a.elementAt(this.f72667b), this.f72666a);
                    this.f72667b++;
                } catch (BuildException unused) {
                }
            }
            this.f72668c = urlV;
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.f72668c != null;
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            URL url = this.f72668c;
            a();
            return url;
        }
    }

    public a() {
        F(null);
    }

    public a(ClassLoader classLoader, Project project, org.apache.tools.ant.types.n nVar) throws Throwable {
        F(classLoader);
        D(nVar);
        H(project);
    }

    public static /* synthetic */ Class i(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e11) {
            throw new NoClassDefFoundError(e11.getMessage());
        }
    }

    public final InputStream A(String str) {
        Enumeration enumerationElements = this.f72656a.elements();
        InputStream inputStreamU = null;
        while (enumerationElements.hasMoreElements() && inputStreamU == null) {
            inputStreamU = u((File) enumerationElements.nextElement(), str);
        }
        return inputStreamU;
    }

    public void B(String str, int i11) {
        Project project = this.f72657b;
        if (project != null) {
            project.x(str, i11);
        }
    }

    public void C() {
        if (org.apache.tools.ant.util.k.b() && this.f72665j) {
            org.apache.tools.ant.util.k.c(this.f72664i);
            this.f72664i = null;
            this.f72665j = false;
        }
    }

    public void D(org.apache.tools.ant.types.n nVar) throws Throwable {
        this.f72656a.removeAllElements();
        if (nVar != null) {
            for (String str : nVar.p("ignore").t()) {
                try {
                    f(str);
                } catch (BuildException unused) {
                }
            }
        }
    }

    public synchronized void E(boolean z11) {
        this.f72661f = z11;
    }

    public void F(ClassLoader classLoader) {
        if (classLoader != null) {
            this.f72662g = classLoader;
            return;
        }
        Class clsI = f72654m;
        if (clsI == null) {
            clsI = i("org.apache.tools.ant.AntClassLoader");
            f72654m = clsI;
        }
        this.f72662g = clsI.getClassLoader();
    }

    public void G(boolean z11) {
        this.f72658c = z11;
    }

    public void H(Project project) {
        this.f72657b = project;
        if (project != null) {
            project.a(this);
        }
    }

    public void I() {
        if (this.f72665j) {
            throw new BuildException("Context loader has not been reset");
        }
        if (org.apache.tools.ant.util.k.b()) {
            this.f72664i = org.apache.tools.ant.util.k.a();
            Project project = this.f72657b;
            org.apache.tools.ant.util.k.c((project == null || !"only".equals(project.s("build.sysclasspath"))) ? this : getClass().getClassLoader());
            this.f72665j = true;
        }
    }

    @Override // org.apache.tools.ant.c
    public void a(BuildEvent buildEvent) {
    }

    @Override // org.apache.tools.ant.c
    public void b(BuildEvent buildEvent) {
    }

    @Override // org.apache.tools.ant.c
    public void c(BuildEvent buildEvent) {
    }

    public void e() {
        Enumeration enumerationElements = org.apache.tools.ant.util.f.h().elements();
        while (enumerationElements.hasMoreElements()) {
            h((String) enumerationElements.nextElement());
        }
    }

    public void f(String str) throws Throwable {
        Project project = this.f72657b;
        try {
            g(project != null ? project.D(str) : new File(str));
        } catch (IOException e11) {
            throw new BuildException(e11);
        }
    }

    @Override // java.lang.ClassLoader
    public Class findClass(String str) throws ClassNotFoundException {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Finding class ");
        stringBuffer.append(str);
        B(stringBuffer.toString(), 4);
        return o(str);
    }

    @Override // java.lang.ClassLoader
    public Enumeration findResources(String str) throws IOException {
        C0785a c0785a = new C0785a(str);
        ClassLoader classLoader = this.f72662g;
        Enumeration<URL> c0788b = (classLoader == null || classLoader == getParent()) ? new org.apache.tools.ant.util.b.C0788b() : this.f72662g.getResources(str);
        if (y(str)) {
            return org.apache.tools.ant.util.b.a(c0788b, c0785a);
        }
        if (this.f72661f) {
            return w() == null ? c0785a : org.apache.tools.ant.util.b.a(c0785a, w().getResources(str));
        }
        return org.apache.tools.ant.util.b.a(c0785a, c0788b);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x008d  */
    /* JADX WARN: Code duplicated, block: B:34:0x0099  */
    /* JADX WARN: Code duplicated, block: B:37:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:45:0x00fc A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:51:0x00df A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x00bf A[SYNTHETIC] */
    public void g(File file) throws Throwable {
        URL urlJ;
        StringTokenizer stringTokenizer;
        String strNextToken;
        URL url;
        File file2;
        ZipFile zipFile;
        this.f72656a.addElement(file);
        if (file.isDirectory()) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(file.getAbsolutePath());
        stringBuffer.append(file.lastModified());
        stringBuffer.append("-");
        stringBuffer.append(file.length());
        String string = stringBuffer.toString();
        String strE = (String) f72653l.get(string);
        if (strE == null) {
            try {
                zipFile = new ZipFile(file);
                try {
                    InputStream inputStream = zipFile.getInputStream(new ZipEntry("META-INF/MANIFEST.MF"));
                    if (inputStream == null) {
                        org.apache.tools.ant.util.d.b(inputStream);
                        zipFile.close();
                        return;
                    } else {
                        strE = new org.apache.tools.ant.taskdefs.k(new InputStreamReader(inputStream, "UTF-8")).b().e("Class-Path");
                        org.apache.tools.ant.util.d.b(inputStream);
                    }
                } catch (ManifestException unused) {
                    org.apache.tools.ant.util.d.b(null);
                    if (zipFile != null) {
                    }
                    if (strE == null) {
                        strE = "";
                    }
                    f72653l.put(string, strE);
                    if ("".equals(strE)) {
                    }
                    urlJ = f72652k.j(file);
                    stringTokenizer = new StringTokenizer(strE);
                    while (stringTokenizer.hasMoreTokens()) {
                        strNextToken = stringTokenizer.nextToken();
                        url = new URL(urlJ, strNextToken);
                        if (url.getProtocol().equals("file")) {
                            file2 = new File(u20.b.a(url.getFile()));
                            if (!file2.exists()) {
                            }
                        } else {
                            StringBuffer stringBuffer2 = new StringBuffer();
                            stringBuffer2.append("Skipping jar library ");
                            stringBuffer2.append(strNextToken);
                            stringBuffer2.append(" since only relative URLs are supported by this");
                            stringBuffer2.append(" loader");
                            B(stringBuffer2.toString(), 3);
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    org.apache.tools.ant.util.d.b(null);
                    if (zipFile != null) {
                        zipFile.close();
                    }
                    throw th;
                }
            } catch (ManifestException unused2) {
                zipFile = null;
            } catch (Throwable th3) {
                th = th3;
                zipFile = null;
            }
            zipFile.close();
            if (strE == null) {
                strE = "";
            }
            f72653l.put(string, strE);
        }
        if ("".equals(strE)) {
            urlJ = f72652k.j(file);
            stringTokenizer = new StringTokenizer(strE);
            while (stringTokenizer.hasMoreTokens()) {
                strNextToken = stringTokenizer.nextToken();
                url = new URL(urlJ, strNextToken);
                if (url.getProtocol().equals("file")) {
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append("Skipping jar library ");
                    stringBuffer3.append(strNextToken);
                    stringBuffer3.append(" since only relative URLs are supported by this");
                    stringBuffer3.append(" loader");
                    B(stringBuffer3.toString(), 3);
                } else {
                    file2 = new File(u20.b.a(url.getFile()));
                    if (!file2.exists() && !x(file2)) {
                        g(file2);
                    }
                }
            }
        }
    }

    @Override // java.lang.ClassLoader
    public URL getResource(String str) {
        URL urlV;
        if (y(str)) {
            ClassLoader classLoader = this.f72662g;
            urlV = classLoader == null ? super.getResource(str) : classLoader.getResource(str);
        } else {
            urlV = null;
        }
        if (urlV != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Resource ");
            stringBuffer.append(str);
            stringBuffer.append(" loaded from parent loader");
            B(stringBuffer.toString(), 4);
        } else {
            Enumeration enumerationElements = this.f72656a.elements();
            while (enumerationElements.hasMoreElements() && urlV == null) {
                urlV = v((File) enumerationElements.nextElement(), str);
                if (urlV != null) {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("Resource ");
                    stringBuffer2.append(str);
                    stringBuffer2.append(" loaded from ant loader");
                    B(stringBuffer2.toString(), 4);
                }
            }
        }
        if (urlV == null && !y(str)) {
            if (this.f72661f) {
                urlV = w() != null ? w().getResource(str) : null;
            } else {
                ClassLoader classLoader2 = this.f72662g;
                urlV = classLoader2 == null ? super.getResource(str) : classLoader2.getResource(str);
            }
            if (urlV != null) {
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("Resource ");
                stringBuffer3.append(str);
                stringBuffer3.append(" loaded from parent loader");
                B(stringBuffer3.toString(), 4);
            }
        }
        if (urlV == null) {
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append("Couldn't load Resource ");
            stringBuffer4.append(str);
            B(stringBuffer4.toString(), 4);
        }
        return urlV;
    }

    @Override // java.lang.ClassLoader
    public InputStream getResourceAsStream(String str) {
        InputStream inputStreamA;
        if (y(str)) {
            inputStreamA = z(str);
            if (inputStreamA != null) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("ResourceStream for ");
                stringBuffer.append(str);
                stringBuffer.append(" loaded from parent loader");
                B(stringBuffer.toString(), 4);
            } else {
                inputStreamA = A(str);
                if (inputStreamA != null) {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("ResourceStream for ");
                    stringBuffer2.append(str);
                    stringBuffer2.append(" loaded from ant loader");
                    B(stringBuffer2.toString(), 4);
                }
            }
        } else {
            inputStreamA = A(str);
            if (inputStreamA != null) {
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("ResourceStream for ");
                stringBuffer3.append(str);
                stringBuffer3.append(" loaded from ant loader");
                B(stringBuffer3.toString(), 4);
            } else {
                inputStreamA = z(str);
                if (inputStreamA != null) {
                    StringBuffer stringBuffer4 = new StringBuffer();
                    stringBuffer4.append("ResourceStream for ");
                    stringBuffer4.append(str);
                    stringBuffer4.append(" loaded from parent loader");
                    B(stringBuffer4.toString(), 4);
                }
            }
        }
        if (inputStreamA == null) {
            StringBuffer stringBuffer5 = new StringBuffer();
            stringBuffer5.append("Couldn't load ResourceStream for ");
            stringBuffer5.append(str);
            B(stringBuffer5.toString(), 4);
        }
        return inputStreamA;
    }

    public void h(String str) {
        Vector vector = this.f72659d;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        String str2 = InstructionFileId.DOT;
        if (str.endsWith(InstructionFileId.DOT)) {
            str2 = "";
        }
        stringBuffer.append(str2);
        vector.addElement(stringBuffer.toString());
    }

    public synchronized void j() {
        Enumeration enumerationElements = this.f72663h.elements();
        while (enumerationElements.hasMoreElements()) {
            try {
                ((ZipFile) enumerationElements.nextElement()).close();
            } catch (IOException unused) {
            }
        }
        this.f72663h = new Hashtable();
        Project project = this.f72657b;
        if (project != null) {
            project.B(this);
        }
        this.f72657b = null;
    }

    public Class k(File file, byte[] bArr, String str) throws Throwable {
        l(file, str);
        int length = bArr.length;
        Class clsI = f72655n;
        if (clsI == null) {
            clsI = i("org.apache.tools.ant.Project");
            f72655n = clsI;
        }
        return defineClass(str, bArr, 0, length, clsI.getProtectionDomain());
    }

    public void l(File file, String str) throws Throwable {
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf == -1) {
            return;
        }
        String strSubstring = str.substring(0, iLastIndexOf);
        if (getPackage(strSubstring) != null) {
            return;
        }
        Manifest manifestT = t(file);
        if (manifestT == null) {
            definePackage(strSubstring, null, null, null, null, null, null, null);
        } else {
            m(file, strSubstring, manifestT);
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x009a A[Catch: all -> 0x0033, TRY_LEAVE, TryCatch #1 {, blocks: (B:3:0x0001, B:7:0x0009, B:10:0x0010, B:23:0x009a, B:16:0x0058, B:14:0x0035, B:19:0x0077, B:21:0x007b, B:26:0x009f), top: B:31:0x0001, inners: #0, #2 }] */
    @Override // java.lang.ClassLoader
    public synchronized Class loadClass(String str, boolean z11) throws ClassNotFoundException {
        Class clsFindClass;
        Class<?> clsFindLoadedClass = findLoadedClass(str);
        if (clsFindLoadedClass != null) {
            return clsFindLoadedClass;
        }
        if (y(str)) {
            try {
                clsFindClass = n(str);
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Class ");
                stringBuffer.append(str);
                stringBuffer.append(" loaded from parent loader ");
                stringBuffer.append("(parentFirst)");
                B(stringBuffer.toString(), 4);
            } catch (ClassNotFoundException unused) {
                clsFindClass = findClass(str);
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Class ");
                stringBuffer2.append(str);
                stringBuffer2.append(" loaded from ant loader ");
                stringBuffer2.append("(parentFirst)");
                B(stringBuffer2.toString(), 4);
            }
            if (z11) {
                resolveClass(clsFindClass);
            }
            return clsFindClass;
        }
        try {
            clsFindClass = findClass(str);
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("Class ");
            stringBuffer3.append(str);
            stringBuffer3.append(" loaded from ant loader");
            B(stringBuffer3.toString(), 4);
        } catch (ClassNotFoundException e11) {
            if (this.f72661f) {
                throw e11;
            }
            clsFindClass = n(str);
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append("Class ");
            stringBuffer4.append(str);
            stringBuffer4.append(" loaded from parent loader");
            B(stringBuffer4.toString(), 4);
        }
        if (z11) {
            resolveClass(clsFindClass);
        }
        return clsFindClass;
    }

    public void m(File file, String str, Manifest manifest) {
        String value;
        String value2;
        String value3;
        String value4;
        String value5;
        String value6;
        String value7;
        URL url;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str.replace('.', '/'));
        stringBuffer.append("/");
        Attributes attributes = manifest.getAttributes(stringBuffer.toString());
        if (attributes != null) {
            value2 = attributes.getValue(Attributes.Name.SPECIFICATION_TITLE);
            value3 = attributes.getValue(Attributes.Name.SPECIFICATION_VENDOR);
            value4 = attributes.getValue(Attributes.Name.SPECIFICATION_VERSION);
            value5 = attributes.getValue(Attributes.Name.IMPLEMENTATION_TITLE);
            value6 = attributes.getValue(Attributes.Name.IMPLEMENTATION_VENDOR);
            value7 = attributes.getValue(Attributes.Name.IMPLEMENTATION_VERSION);
            value = attributes.getValue(Attributes.Name.SEALED);
        } else {
            value = null;
            value2 = null;
            value3 = null;
            value4 = null;
            value5 = null;
            value6 = null;
            value7 = null;
        }
        Attributes mainAttributes = manifest.getMainAttributes();
        if (mainAttributes != null) {
            if (value2 == null) {
                value2 = mainAttributes.getValue(Attributes.Name.SPECIFICATION_TITLE);
            }
            if (value3 == null) {
                value3 = mainAttributes.getValue(Attributes.Name.SPECIFICATION_VENDOR);
            }
            if (value4 == null) {
                value4 = mainAttributes.getValue(Attributes.Name.SPECIFICATION_VERSION);
            }
            if (value5 == null) {
                value5 = mainAttributes.getValue(Attributes.Name.IMPLEMENTATION_TITLE);
            }
            if (value6 == null) {
                value6 = mainAttributes.getValue(Attributes.Name.IMPLEMENTATION_VENDOR);
            }
            if (value7 == null) {
                value7 = mainAttributes.getValue(Attributes.Name.IMPLEMENTATION_VERSION);
            }
            if (value == null) {
                value = mainAttributes.getValue(Attributes.Name.SEALED);
            }
        }
        String str2 = value6;
        String str3 = value7;
        String str4 = value3;
        String str5 = value5;
        String str6 = value4;
        String str7 = value2;
        if (value == null || !value.toLowerCase(Locale.ENGLISH).equals("true")) {
            url = null;
        } else {
            try {
                url = new URL(org.apache.tools.ant.util.d.k().r(file.getAbsolutePath()));
            } catch (MalformedURLException unused) {
                url = null;
            }
        }
        definePackage(str, str7, str6, str4, str5, str3, str2, url);
    }

    public final Class n(String str) throws ClassNotFoundException {
        ClassLoader classLoader = this.f72662g;
        return classLoader == null ? findSystemClass(str) : classLoader.loadClass(str);
    }

    public final Class o(String str) throws ClassNotFoundException {
        String strQ = q(str);
        InputStream inputStreamU = null;
        try {
            Enumeration enumerationElements = this.f72656a.elements();
            while (enumerationElements.hasMoreElements()) {
                File file = (File) enumerationElements.nextElement();
                try {
                    try {
                        inputStreamU = u(file, strQ);
                        if (inputStreamU != null) {
                            StringBuffer stringBuffer = new StringBuffer();
                            stringBuffer.append("Loaded from ");
                            stringBuffer.append(file);
                            stringBuffer.append(" ");
                            stringBuffer.append(strQ);
                            B(stringBuffer.toString(), 4);
                            Class clsR = r(inputStreamU, str, file);
                            org.apache.tools.ant.util.d.b(inputStreamU);
                            return clsR;
                        }
                        continue;
                    } catch (SecurityException e11) {
                        throw e11;
                    }
                } catch (IOException e12) {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("Exception reading component ");
                    stringBuffer2.append(file);
                    stringBuffer2.append(" (reason: ");
                    stringBuffer2.append(e12.getMessage());
                    stringBuffer2.append(")");
                    B(stringBuffer2.toString(), 3);
                }
            }
            throw new ClassNotFoundException(str);
        } catch (Throwable th2) {
            org.apache.tools.ant.util.d.b(inputStreamU);
            throw th2;
        }
    }

    public Class p(String str) throws ClassNotFoundException {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("force loading ");
        stringBuffer.append(str);
        B(stringBuffer.toString(), 4);
        Class<?> clsFindLoadedClass = findLoadedClass(str);
        return clsFindLoadedClass == null ? findClass(str) : clsFindLoadedClass;
    }

    public final String q(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str.replace('.', '/'));
        stringBuffer.append(".class");
        return stringBuffer.toString();
    }

    public final Class r(InputStream inputStream, String str, File file) throws IOException, SecurityException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int i11 = inputStream.read(bArr, 0, 8192);
            if (i11 == -1) {
                return k(file, byteArrayOutputStream.toByteArray(), str);
            }
            byteArrayOutputStream.write(bArr, 0, i11);
        }
    }

    public String s() {
        StringBuffer stringBuffer = new StringBuffer();
        Enumeration enumerationElements = this.f72656a.elements();
        boolean z11 = true;
        while (enumerationElements.hasMoreElements()) {
            if (z11) {
                z11 = false;
            } else {
                stringBuffer.append(System.getProperty("path.separator"));
            }
            stringBuffer.append(((File) enumerationElements.nextElement()).getAbsolutePath());
        }
        return stringBuffer.toString();
    }

    public final Manifest t(File file) throws Throwable {
        JarFile jarFile = null;
        if (file.isDirectory()) {
            return null;
        }
        try {
            JarFile jarFile2 = new JarFile(file);
            try {
                Manifest manifest = jarFile2.getManifest();
                jarFile2.close();
                return manifest;
            } catch (Throwable th2) {
                th = th2;
                jarFile = jarFile2;
                if (jarFile != null) {
                    jarFile.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("AntClassLoader[");
        stringBuffer.append(s());
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public final InputStream u(File file, String str) {
        try {
            ZipFile zipFile = (ZipFile) this.f72663h.get(file);
            if (zipFile == null && file.isDirectory()) {
                File file2 = new File(file, str);
                if (file2.exists()) {
                    return new FileInputStream(file2);
                }
            } else {
                if (zipFile == null) {
                    if (!file.exists()) {
                        return null;
                    }
                    this.f72663h.put(file, new ZipFile(file));
                    zipFile = (ZipFile) this.f72663h.get(file);
                }
                ZipEntry entry = zipFile.getEntry(str);
                if (entry != null) {
                    return zipFile.getInputStream(entry);
                }
            }
        } catch (Exception e11) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Ignoring Exception ");
            stringBuffer.append(e11.getClass().getName());
            stringBuffer.append(": ");
            stringBuffer.append(e11.getMessage());
            stringBuffer.append(" reading resource ");
            stringBuffer.append(str);
            stringBuffer.append(" from ");
            stringBuffer.append(file);
            B(stringBuffer.toString(), 3);
        }
        return null;
    }

    public URL v(File file, String str) {
        try {
            ZipFile zipFile = (ZipFile) this.f72663h.get(file);
            if (zipFile == null && file.isDirectory()) {
                File file2 = new File(file, str);
                if (file2.exists()) {
                    try {
                        return f72652k.j(file2);
                    } catch (MalformedURLException unused) {
                        return null;
                    }
                }
            } else {
                if (zipFile == null) {
                    if (!file.exists()) {
                        return null;
                    }
                    zipFile = new ZipFile(file);
                    this.f72663h.put(file, zipFile);
                }
                ZipEntry entry = zipFile.getEntry(str);
                if (entry != null) {
                    try {
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("jar:");
                        stringBuffer.append(f72652k.j(file));
                        stringBuffer.append("!/");
                        stringBuffer.append(entry);
                        return new URL(stringBuffer.toString());
                    } catch (MalformedURLException unused2) {
                        return null;
                    }
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return null;
    }

    public final ClassLoader w() {
        ClassLoader classLoader = getClass().getClassLoader();
        while (classLoader != null && classLoader.getParent() != null) {
            classLoader = classLoader.getParent();
        }
        return classLoader;
    }

    public boolean x(File file) {
        Enumeration enumerationElements = this.f72656a.elements();
        while (enumerationElements.hasMoreElements()) {
            if (((File) enumerationElements.nextElement()).equals(file)) {
                return true;
            }
        }
        return false;
    }

    public final boolean y(String str) {
        boolean z11 = this.f72658c;
        Enumeration enumerationElements = this.f72659d.elements();
        while (enumerationElements.hasMoreElements()) {
            if (str.startsWith((String) enumerationElements.nextElement())) {
                z11 = true;
                break;
            }
        }
        Enumeration enumerationElements2 = this.f72660e.elements();
        while (enumerationElements2.hasMoreElements()) {
            if (str.startsWith((String) enumerationElements2.nextElement())) {
                return false;
            }
        }
        return z11;
    }

    public final InputStream z(String str) {
        ClassLoader classLoader = this.f72662g;
        return classLoader == null ? ClassLoader.getSystemResourceAsStream(str) : classLoader.getResourceAsStream(str);
    }
}
