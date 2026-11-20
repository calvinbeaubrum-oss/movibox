package org.apache.tools.ant.taskdefs;

import com.google.android.gms.common.api.Api;
import com.transsion.push.PushConstants;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Vector;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.util.p;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class g {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static a f72775m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static a f72776n;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static boolean f72779q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static /* synthetic */ Class f72780r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static /* synthetic */ Class f72781s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static /* synthetic */ Class f72782t;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String[] f72783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String[] f72784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f72785c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public org.apache.tools.ant.taskdefs.h f72786d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public org.apache.tools.ant.taskdefs.i f72787e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public File f72788f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Project f72789g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f72790h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f72791i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f72792j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final org.apache.tools.ant.util.d f72773k = org.apache.tools.ant.util.d.k();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static String f72774l = System.getProperty("user.dir");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static Vector f72777o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static ProcessDestroyer f72778p = new ProcessDestroyer();

    /* JADX INFO: compiled from: source.java */
    public static class a {
        public a() {
        }

        public /* synthetic */ a(org.apache.tools.ant.taskdefs.f fVar) {
            this();
        }

        public Process a(Project project, String[] strArr, String[] strArr2) throws IOException {
            if (project != null) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Execute:CommandLauncher: ");
                stringBuffer.append(org.apache.tools.ant.types.c.g(strArr));
                project.x(stringBuffer.toString(), 4);
            }
            return Runtime.getRuntime().exec(strArr, strArr2);
        }

        public Process b(Project project, String[] strArr, String[] strArr2, File file) throws IOException {
            if (file == null) {
                return a(project, strArr, strArr2);
            }
            throw new IOException("Cannot execute a process in different directory under this JVM");
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public a f72793a;

        public b(a aVar) {
            super(null);
            this.f72793a = aVar;
        }

        @Override // org.apache.tools.ant.taskdefs.g.a
        public Process a(Project project, String[] strArr, String[] strArr2) throws IOException {
            return this.f72793a.a(project, strArr, strArr2);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Method f72794a;

        public c() throws NoSuchMethodException {
            super(null);
            Class clsD = g.f72782t;
            if (clsD == null) {
                clsD = g.d("java.lang.Runtime");
                g.f72782t = clsD;
            }
            Class<?>[] clsArr = new Class[3];
            Class<?> clsD2 = g.f72780r;
            if (clsD2 == null) {
                clsD2 = g.d("[Ljava.lang.String;");
                g.f72780r = clsD2;
            }
            clsArr[0] = clsD2;
            Class<?> clsD3 = g.f72780r;
            if (clsD3 == null) {
                clsD3 = g.d("[Ljava.lang.String;");
                g.f72780r = clsD3;
            }
            clsArr[1] = clsD3;
            Class<?> clsD4 = g.f72781s;
            if (clsD4 == null) {
                clsD4 = g.d("java.io.File");
                g.f72781s = clsD4;
            }
            clsArr[2] = clsD4;
            this.f72794a = clsD.getMethod("exec", clsArr);
        }

        @Override // org.apache.tools.ant.taskdefs.g.a
        public Process b(Project project, String[] strArr, String[] strArr2, File file) throws IOException {
            if (project != null) {
                try {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Execute:Java13CommandLauncher: ");
                    stringBuffer.append(org.apache.tools.ant.types.c.g(strArr));
                    project.x(stringBuffer.toString(), 4);
                } catch (InvocationTargetException e11) {
                    Throwable targetException = e11.getTargetException();
                    if (targetException instanceof ThreadDeath) {
                        throw ((ThreadDeath) targetException);
                    }
                    if (targetException instanceof IOException) {
                        throw ((IOException) targetException);
                    }
                    throw new BuildException("Unable to execute command", targetException);
                } catch (Exception e12) {
                    throw new BuildException("Unable to execute command", e12);
                }
            }
            return (Process) this.f72794a.invoke(Runtime.getRuntime(), strArr, strArr2, file);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d extends b {
        public d(a aVar) {
            super(aVar);
        }

        @Override // org.apache.tools.ant.taskdefs.g.a
        public Process b(Project project, String[] strArr, String[] strArr2, File file) throws IOException {
            if (file == null) {
                return a(project, strArr, strArr2);
            }
            System.getProperties().put("user.dir", file.getAbsolutePath());
            try {
                return a(project, strArr, strArr2);
            } finally {
                System.getProperties().put("user.dir", g.f72774l);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class e extends b {
        public e(a aVar) {
            super(aVar);
        }

        @Override // org.apache.tools.ant.taskdefs.g.a
        public Process b(Project project, String[] strArr, String[] strArr2, File file) throws IOException {
            if (file == null) {
                if (project == null) {
                    return a(project, strArr, strArr2);
                }
                file = project.m();
            }
            String absolutePath = file.getAbsolutePath();
            String[] strArr3 = new String[strArr.length + 7];
            strArr3[0] = "cmd";
            strArr3[1] = "/c";
            strArr3[2] = absolutePath.substring(0, 2);
            strArr3[3] = "&&";
            strArr3[4] = "cd";
            strArr3[5] = absolutePath.substring(2);
            strArr3[6] = "&&";
            System.arraycopy(strArr, 0, strArr3, 7, strArr.length);
            return a(project, strArr3, strArr2);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class f extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f72795b;

        public f(String str, a aVar) {
            super(aVar);
            this.f72795b = str;
        }

        @Override // org.apache.tools.ant.taskdefs.g.a
        public Process b(Project project, String[] strArr, String[] strArr2, File file) throws IOException {
            if (project == null) {
                if (file == null) {
                    return a(project, strArr, strArr2);
                }
                throw new IOException("Cannot locate antRun script: No project provided");
            }
            String strS = project.s("ant.home");
            if (strS == null) {
                throw new IOException("Cannot locate antRun script: Property 'ant.home' not found");
            }
            org.apache.tools.ant.util.d dVar = g.f72773k;
            File fileM = project.m();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(strS);
            stringBuffer.append(File.separator);
            stringBuffer.append(this.f72795b);
            String string = dVar.q(fileM, stringBuffer.toString()).toString();
            if (file == null) {
                file = project.m();
            }
            String[] strArr3 = new String[strArr.length + 3];
            strArr3[0] = "perl";
            strArr3[1] = string;
            strArr3[2] = file.getAbsolutePath();
            System.arraycopy(strArr, 0, strArr3, 3, strArr.length);
            return a(project, strArr3, strArr2);
        }
    }

    /* JADX INFO: renamed from: org.apache.tools.ant.taskdefs.g$g, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0786g extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f72796b;

        public C0786g(String str, a aVar) {
            super(aVar);
            this.f72796b = str;
        }

        @Override // org.apache.tools.ant.taskdefs.g.a
        public Process b(Project project, String[] strArr, String[] strArr2, File file) throws IOException {
            if (project == null) {
                if (file == null) {
                    return a(project, strArr, strArr2);
                }
                throw new IOException("Cannot locate antRun script: No project provided");
            }
            String strS = project.s("ant.home");
            if (strS == null) {
                throw new IOException("Cannot locate antRun script: Property 'ant.home' not found");
            }
            org.apache.tools.ant.util.d dVar = g.f72773k;
            File fileM = project.m();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(strS);
            stringBuffer.append(File.separator);
            stringBuffer.append(this.f72796b);
            String string = dVar.q(fileM, stringBuffer.toString()).toString();
            if (file == null) {
                file = project.m();
            }
            String[] strArr3 = new String[strArr.length + 2];
            strArr3[0] = string;
            strArr3[1] = file.getAbsolutePath();
            System.arraycopy(strArr, 0, strArr3, 2, strArr.length);
            return a(project, strArr3, strArr2);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class h extends c {
        @Override // org.apache.tools.ant.taskdefs.g.a
        public Process a(Project project, String[] strArr, String[] strArr2) throws Throwable {
            File fileC = c(strArr, strArr2);
            Process processA = super.a(project, new String[]{fileC.getPath()}, strArr2);
            d(fileC, processA);
            return processA;
        }

        @Override // org.apache.tools.ant.taskdefs.g.c, org.apache.tools.ant.taskdefs.g.a
        public Process b(Project project, String[] strArr, String[] strArr2, File file) throws Throwable {
            File fileC = c(strArr, strArr2);
            Process processB = super.b(project, new String[]{fileC.getPath()}, strArr2, file);
            d(fileC, processB);
            return processB;
        }

        public final File c(String[] strArr, String[] strArr2) throws Throwable {
            File fileF = g.f72773k.f("ANT", ".COM", null, true, true);
            PrintWriter printWriter = null;
            try {
                PrintWriter printWriter2 = new PrintWriter(new FileWriter(fileF));
                if (strArr2 != null) {
                    for (int i11 = 0; i11 < strArr2.length; i11++) {
                        try {
                            int iIndexOf = strArr2[i11].indexOf(61);
                            if (iIndexOf != -1) {
                                printWriter2.print("$ DEFINE/NOLOG ");
                                printWriter2.print(strArr2[i11].substring(0, iIndexOf));
                                printWriter2.print(" \"");
                                printWriter2.print(strArr2[i11].substring(iIndexOf + 1));
                                printWriter2.println('\"');
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            printWriter = printWriter2;
                            if (printWriter != null) {
                                printWriter.close();
                            }
                            throw th;
                        }
                    }
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("$ ");
                stringBuffer.append(strArr[0]);
                printWriter2.print(stringBuffer.toString());
                for (int i12 = 1; i12 < strArr.length; i12++) {
                    printWriter2.println(" -");
                    printWriter2.print(strArr[i12]);
                }
                printWriter2.close();
                return fileF;
            } catch (Throwable th3) {
                th = th3;
            }
        }

        public final void d(final File file, final Process process) {
            new Thread() { // from class: org.apache.tools.ant.taskdefs.Execute$VmsCommandLauncher$1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        process.waitFor();
                    } catch (InterruptedException unused) {
                    }
                    org.apache.tools.ant.util.d.g(file);
                }
            }.start();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class i extends b {
        public i(a aVar) {
            super(aVar);
        }

        @Override // org.apache.tools.ant.taskdefs.g.a
        public Process b(Project project, String[] strArr, String[] strArr2, File file) throws IOException {
            if (file == null) {
                if (project == null) {
                    return a(project, strArr, strArr2);
                }
                file = project.m();
            }
            String[] strArr3 = new String[strArr.length + 6];
            strArr3[0] = "cmd";
            strArr3[1] = "/c";
            strArr3[2] = "cd";
            strArr3[3] = "/d";
            strArr3[4] = file.getAbsolutePath();
            strArr3[5] = "&&";
            System.arraycopy(strArr, 0, strArr3, 6, strArr.length);
            return a(project, strArr3, strArr2);
        }
    }

    static {
        org.apache.tools.ant.taskdefs.f fVar = null;
        f72775m = null;
        f72776n = null;
        f72779q = false;
        try {
            if (!v20.a.a("os/2")) {
                f72775m = new c();
            }
        } catch (NoSuchMethodException unused) {
        }
        if (v20.a.a("mac") && !v20.a.a("unix")) {
            f72776n = new d(new a(fVar));
            return;
        }
        if (v20.a.a("os/2")) {
            f72776n = new e(new a(fVar));
            return;
        }
        if (v20.a.a("windows")) {
            f72779q = true;
            a aVar = new a(fVar);
            if (v20.a.a("win9x")) {
                f72776n = new C0786g("bin/antRun.bat", aVar);
                return;
            } else {
                f72776n = new i(aVar);
                return;
            }
        }
        if (v20.a.a("netware")) {
            f72776n = new f("bin/antRun.pl", new a(fVar));
        } else if (!v20.a.a("openvms")) {
            f72776n = new C0786g("bin/antRun", new a(fVar));
        } else {
            try {
                f72776n = new h();
            } catch (NoSuchMethodException unused2) {
            }
        }
    }

    public g(org.apache.tools.ant.taskdefs.h hVar) {
        this(hVar, null);
    }

    public g(org.apache.tools.ant.taskdefs.h hVar, org.apache.tools.ant.taskdefs.i iVar) {
        this.f72783a = null;
        this.f72784b = null;
        this.f72785c = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.f72788f = null;
        this.f72789g = null;
        this.f72790h = false;
        this.f72791i = false;
        this.f72792j = true;
        s(hVar);
        this.f72787e = iVar;
        if (v20.a.a("openvms")) {
            this.f72792j = false;
        }
    }

    public static Vector c(Vector vector, BufferedReader bufferedReader) throws IOException {
        HashMap map = new HashMap();
        String str = null;
        String string = null;
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            if (line.startsWith("\t=")) {
                if (str != null) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(string);
                    stringBuffer.append(",");
                    stringBuffer.append(line.substring(4, line.length() - 1));
                    string = stringBuffer.toString();
                }
            } else if (line.startsWith("  \"")) {
                if (str != null) {
                    map.put(str, string);
                }
                int iIndexOf = line.indexOf(61);
                String strSubstring = line.substring(3, iIndexOf - 2);
                if (map.containsKey(strSubstring)) {
                    str = null;
                } else {
                    string = line.substring(iIndexOf + 3, line.length() - 1);
                    str = strSubstring;
                }
            }
        }
        if (str != null) {
            map.put(str, string);
        }
        for (String str2 : map.keySet()) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(str2);
            stringBuffer2.append("=");
            stringBuffer2.append(map.get(str2));
            vector.add(stringBuffer2.toString());
        }
        return vector;
    }

    public static /* synthetic */ Class d(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e11) {
            throw new NoClassDefFoundError(e11.getMessage());
        }
    }

    public static void e(Process process) {
        org.apache.tools.ant.util.d.b(process.getInputStream());
        org.apache.tools.ant.util.d.c(process.getOutputStream());
        org.apache.tools.ant.util.d.b(process.getErrorStream());
    }

    public static String[] j() {
        if (v20.a.a("os/2")) {
            return new String[]{"cmd", "/c", "set"};
        }
        if (v20.a.a("windows")) {
            return v20.a.a("win9x") ? new String[]{"command.com", "/c", "set"} : new String[]{"cmd", "/c", "set"};
        }
        if (!v20.a.a("z/os") && !v20.a.a("unix")) {
            if (v20.a.a("netware") || v20.a.a("os/400")) {
                return new String[]{"env"};
            }
            if (v20.a.a("openvms")) {
                return new String[]{PushConstants.PUSH_SERVICE_TYPE_SHOW, "logical"};
            }
            return null;
        }
        String[] strArr = new String[1];
        if (new File("/bin/env").canRead()) {
            strArr[0] = "/bin/env";
        } else if (new File("/usr/bin/env").canRead()) {
            strArr[0] = "/usr/bin/env";
        } else {
            strArr[0] = "env";
        }
        return strArr;
    }

    public static synchronized Vector k() {
        Vector vector = f72777o;
        if (vector != null) {
            return vector;
        }
        f72777o = new Vector();
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            g gVar = new g(new m(byteArrayOutputStream));
            gVar.p(j());
            gVar.r(true);
            gVar.f();
            BufferedReader bufferedReader = new BufferedReader(new StringReader(u(byteArrayOutputStream)));
            if (v20.a.a("openvms")) {
                Vector vectorC = c(f72777o, bufferedReader);
                f72777o = vectorC;
                return vectorC;
            }
            String str = p.f72993a;
            String string = null;
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                if (line.indexOf(61) != -1) {
                    if (string != null) {
                        f72777o.addElement(string);
                    }
                    string = line;
                } else if (string == null) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(str);
                    stringBuffer.append(line);
                    string = stringBuffer.toString();
                } else {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append(string);
                    stringBuffer2.append(str);
                    stringBuffer2.append(line);
                    string = stringBuffer2.toString();
                }
            }
            if (string != null) {
                f72777o.addElement(string);
            }
            return f72777o;
        } catch (IOException e11) {
            e11.printStackTrace();
        }
    }

    public static Process m(Project project, String[] strArr, String[] strArr2, File file, boolean z11) throws IOException {
        a aVar;
        if (file == null || file.exists()) {
            if (!z11 || (aVar = f72775m) == null) {
                aVar = f72776n;
            }
            return aVar.b(project, strArr, strArr2, file);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(file);
        stringBuffer.append(" doesn't exist.");
        throw new BuildException(stringBuffer.toString());
    }

    public static String u(ByteArrayOutputStream byteArrayOutputStream) {
        try {
            if (v20.a.a("z/os")) {
                return byteArrayOutputStream.toString("Cp1047");
            }
            if (v20.a.a("os/400")) {
                return byteArrayOutputStream.toString("Cp500");
            }
            return byteArrayOutputStream.toString();
        } catch (UnsupportedEncodingException unused) {
        }
    }

    public int f() throws IOException {
        File file = this.f72788f;
        if (file != null && !file.exists()) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.f72788f);
            stringBuffer.append(" doesn't exist.");
            throw new BuildException(stringBuffer.toString());
        }
        Process processM = m(this.f72789g, g(), h(), this.f72788f, this.f72792j);
        try {
            this.f72786d.b(processM.getOutputStream());
            this.f72786d.c(processM.getInputStream());
            this.f72786d.a(processM.getErrorStream());
            this.f72786d.start();
            try {
                try {
                    f72778p.add(processM);
                    org.apache.tools.ant.taskdefs.i iVar = this.f72787e;
                    if (iVar != null) {
                        iVar.d(processM);
                    }
                    v(processM);
                    org.apache.tools.ant.taskdefs.i iVar2 = this.f72787e;
                    if (iVar2 != null) {
                        iVar2.e();
                    }
                    this.f72786d.stop();
                    e(processM);
                    org.apache.tools.ant.taskdefs.i iVar3 = this.f72787e;
                    if (iVar3 != null) {
                        iVar3.a();
                    }
                    int i11 = i();
                    f72778p.remove(processM);
                    return i11;
                } catch (Throwable th2) {
                    f72778p.remove(processM);
                    throw th2;
                }
            } catch (ThreadDeath e11) {
                processM.destroy();
                throw e11;
            }
        } catch (IOException e12) {
            processM.destroy();
            throw e12;
        }
    }

    public String[] g() {
        return this.f72783a;
    }

    public String[] h() {
        String[] strArr = this.f72784b;
        return (strArr == null || this.f72790h) ? strArr : n();
    }

    public int i() {
        return this.f72785c;
    }

    public boolean l() {
        org.apache.tools.ant.taskdefs.i iVar = this.f72787e;
        return iVar != null && iVar.c();
    }

    public final String[] n() {
        if (v20.a.a("openvms")) {
            return this.f72784b;
        }
        Vector vector = (Vector) k().clone();
        int i11 = 0;
        while (true) {
            String[] strArr = this.f72784b;
            if (i11 >= strArr.length) {
                return (String[]) vector.toArray(new String[vector.size()]);
            }
            String string = strArr[i11];
            String strSubstring = string.substring(0, string.indexOf(61) + 1);
            if (f72779q) {
                strSubstring = strSubstring.toLowerCase();
            }
            int size = vector.size();
            for (int i12 = 0; i12 < size; i12++) {
                String str = (String) vector.elementAt(i12);
                if ((f72779q ? str.toLowerCase() : str).startsWith(strSubstring)) {
                    vector.removeElementAt(i12);
                    if (!f72779q) {
                        break;
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(str.substring(0, strSubstring.length()));
                    stringBuffer.append(string.substring(strSubstring.length()));
                    string = stringBuffer.toString();
                    break;
                }
            }
            vector.addElement(string);
            i11++;
        }
    }

    public void o(Project project) throws BuildException {
        this.f72789g = project;
    }

    public void p(String[] strArr) {
        this.f72783a = strArr;
    }

    public void q(int i11) {
        this.f72785c = i11;
    }

    public void r(boolean z11) {
        this.f72790h = z11;
    }

    public void s(org.apache.tools.ant.taskdefs.h hVar) {
        this.f72786d = hVar;
    }

    public void t(boolean z11) {
        this.f72792j = z11;
    }

    public void v(Process process) {
        try {
            process.waitFor();
            q(process.exitValue());
        } catch (InterruptedException unused) {
            process.destroy();
        }
    }
}
