package org.apache.tools.ant.taskdefs;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Vector;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.util.p;
import org.apache.tools.ant.util.q;
import org.apache.tools.ant.v;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class n {
    public static final String B = System.getProperty("file.encoding");
    public boolean A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public File[] f72823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public File[] f72824b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public File[] f72825c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f72829g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f72830h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f72831i;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public v f72835m;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Vector f72841s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Vector f72842t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Vector f72843u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f72844v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f72845w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f72846x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f72847y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ThreadGroup f72848z;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f72826d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f72827e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f72828f = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f72832j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f72833k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f72834l = true;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public OutputStream f72836n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public OutputStream f72837o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public InputStream f72838p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public PrintStream f72839q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public PrintStream f72840r = null;

    /* JADX INFO: compiled from: source.java */
    public class a extends ByteArrayOutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f72849a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f72850b = false;

        public a(String str) {
            this.f72849a = str;
        }

        @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f72850b) {
                return;
            }
            if (n.this.f72832j && n.this.f72847y) {
                return;
            }
            n.this.k(this, this.f72849a);
            this.f72850b = true;
        }
    }

    public n(v vVar) {
        String str = B;
        this.f72844v = str;
        this.f72845w = str;
        this.f72846x = str;
        this.f72847y = true;
        this.f72848z = new ThreadGroup("redirector");
        this.A = true;
        this.f72835m = vVar;
    }

    public synchronized void d() throws IOException {
        try {
            System.out.flush();
            System.err.flush();
            InputStream inputStream = this.f72838p;
            if (inputStream != null) {
                inputStream.close();
            }
            this.f72836n.flush();
            this.f72836n.close();
            this.f72837o.flush();
            this.f72837o.close();
            while (this.f72848z.activeCount() > 0) {
                try {
                    v vVar = this.f72835m;
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("waiting for ");
                    stringBuffer.append(this.f72848z.activeCount());
                    stringBuffer.append(" Threads:");
                    vVar.log(stringBuffer.toString(), 4);
                    int iActiveCount = this.f72848z.activeCount();
                    Thread[] threadArr = new Thread[iActiveCount];
                    this.f72848z.enumerate(threadArr);
                    for (int i11 = 0; i11 < iActiveCount; i11++) {
                        Thread thread = threadArr[i11];
                        if (thread == null) {
                            break;
                        }
                        try {
                            this.f72835m.log(thread.toString(), 4);
                        } catch (NullPointerException unused) {
                        }
                    }
                    wait(1000L);
                } catch (InterruptedException unused2) {
                }
            }
            j();
            this.f72838p = null;
            this.f72836n = null;
            this.f72837o = null;
            this.f72839q = null;
            this.f72840r = null;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized h e() throws BuildException {
        f();
        return new m(this.f72836n, this.f72837o, this.f72838p);
    }

    public synchronized void f() {
        Vector vector;
        try {
            i();
            g();
            if (this.f72833k || this.f72836n == null) {
                OutputStream jVar = new j(this.f72835m, 2);
                if (this.f72836n != null) {
                    jVar = new q(jVar, this.f72836n);
                }
                this.f72836n = jVar;
            }
            if (this.f72833k || this.f72837o == null) {
                OutputStream jVar2 = new j(this.f72835m, 1);
                if (this.f72837o != null) {
                    jVar2 = new q(jVar2, this.f72837o);
                }
                this.f72837o = jVar2;
            }
            Vector vector2 = this.f72841s;
            if ((vector2 != null && vector2.size() > 0) || !this.f72844v.equalsIgnoreCase(this.f72846x)) {
                try {
                    org.apache.tools.ant.util.i iVar = new org.apache.tools.ant.util.i();
                    iVar.b(this.f72835m);
                    Reader inputStreamReader = new InputStreamReader(iVar, this.f72846x);
                    Vector vector3 = this.f72841s;
                    if (vector3 != null && vector3.size() > 0) {
                        r20.a aVar = new r20.a();
                        aVar.e(this.f72835m.getProject());
                        aVar.d(inputStreamReader);
                        aVar.c(this.f72841s);
                        inputStreamReader = aVar.b();
                    }
                    Thread thread = new Thread(this.f72848z, new StreamPumper(new org.apache.tools.ant.util.n(inputStreamReader, this.f72844v), this.f72836n, true), "output pumper");
                    thread.setPriority(10);
                    this.f72836n = new PipedOutputStream(iVar);
                    thread.start();
                } catch (IOException e11) {
                    throw new BuildException("error setting up output stream", e11);
                }
            }
            Vector vector4 = this.f72842t;
            if ((vector4 != null && vector4.size() > 0) || !this.f72845w.equalsIgnoreCase(this.f72846x)) {
                try {
                    org.apache.tools.ant.util.i iVar2 = new org.apache.tools.ant.util.i();
                    iVar2.b(this.f72835m);
                    Reader inputStreamReader2 = new InputStreamReader(iVar2, this.f72846x);
                    Vector vector5 = this.f72842t;
                    if (vector5 != null && vector5.size() > 0) {
                        r20.a aVar2 = new r20.a();
                        aVar2.e(this.f72835m.getProject());
                        aVar2.d(inputStreamReader2);
                        aVar2.c(this.f72842t);
                        inputStreamReader2 = aVar2.b();
                    }
                    Thread thread2 = new Thread(this.f72848z, new StreamPumper(new org.apache.tools.ant.util.n(inputStreamReader2, this.f72845w), this.f72837o, true), "error pumper");
                    thread2.setPriority(10);
                    this.f72837o = new PipedOutputStream(iVar2);
                    thread2.start();
                } catch (IOException e12) {
                    throw new BuildException("error setting up error stream", e12);
                }
            }
            File[] fileArr = this.f72823a;
            if (fileArr != null && fileArr.length > 0) {
                v vVar = this.f72835m;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Redirecting input from file");
                stringBuffer.append(this.f72823a.length == 1 ? "" : "s");
                vVar.log(stringBuffer.toString(), 3);
                try {
                    org.apache.tools.ant.util.c cVar = new org.apache.tools.ant.util.c(this.f72823a);
                    this.f72838p = cVar;
                    cVar.e(this.f72835m);
                } catch (IOException e13) {
                    throw new BuildException(e13);
                }
            } else if (this.f72831i != null) {
                StringBuffer stringBuffer2 = new StringBuffer("Using input ");
                if (this.A) {
                    stringBuffer2.append('\"');
                    stringBuffer2.append(this.f72831i);
                    stringBuffer2.append('\"');
                } else {
                    stringBuffer2.append("string");
                }
                this.f72835m.log(stringBuffer2.toString(), 3);
                this.f72838p = new ByteArrayInputStream(this.f72831i.getBytes());
            }
            if (this.f72838p != null && (vector = this.f72843u) != null && vector.size() > 0) {
                r20.a aVar3 = new r20.a();
                aVar3.e(this.f72835m.getProject());
                try {
                    aVar3.d(new InputStreamReader(this.f72838p, this.f72846x));
                    aVar3.c(this.f72843u);
                    this.f72838p = new org.apache.tools.ant.util.n(aVar3.b(), this.f72846x);
                } catch (IOException e14) {
                    throw new BuildException("error setting up input stream", e14);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void g() {
        OutputStream outputStream;
        File[] fileArr = this.f72825c;
        if (fileArr != null && fileArr.length > 0) {
            StringBuffer stringBuffer = new StringBuffer("Error ");
            stringBuffer.append(this.f72832j ? "appended" : "redirected");
            stringBuffer.append(" to ");
            this.f72837o = h(this.f72825c, stringBuffer.toString(), 3);
        } else if (!this.f72826d && (outputStream = this.f72836n) != null) {
            org.apache.tools.ant.util.m mVar = new org.apache.tools.ant.util.m(outputStream, 0L);
            try {
                this.f72836n = mVar.g();
                this.f72837o = mVar.g();
            } catch (IOException e11) {
                throw new BuildException("error splitting output/error streams", e11);
            }
        }
        if (this.f72830h == null) {
            this.f72828f = null;
            return;
        }
        if (this.f72828f == null) {
            this.f72828f = new a(this.f72830h);
            v vVar = this.f72835m;
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Error redirected to property: ");
            stringBuffer2.append(this.f72830h);
            vVar.log(stringBuffer2.toString(), 3);
        }
        OutputStream gVar = new org.apache.tools.ant.util.g(this.f72828f);
        File[] fileArr2 = this.f72825c;
        if (fileArr2 != null && fileArr2.length != 0) {
            gVar = new q(this.f72837o, gVar);
        }
        this.f72837o = gVar;
    }

    public final OutputStream h(File[] fileArr, String str, int i11) {
        org.apache.tools.ant.util.h hVar = new org.apache.tools.ant.util.h(fileArr[0], this.f72832j, this.f72834l);
        v vVar = this.f72835m;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(fileArr[0]);
        vVar.log(stringBuffer.toString(), i11);
        char[] cArr = new char[str.length()];
        Arrays.fill(cArr, ' ');
        String str2 = new String(cArr);
        for (int i12 = 1; i12 < fileArr.length; i12++) {
            this.f72836n = new q(this.f72836n, new org.apache.tools.ant.util.h(fileArr[i12], this.f72832j, this.f72834l));
            v vVar2 = this.f72835m;
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(str2);
            stringBuffer2.append(fileArr[i12]);
            vVar2.log(stringBuffer2.toString(), i11);
        }
        return hVar;
    }

    public final void i() {
        File[] fileArr = this.f72824b;
        if (fileArr != null && fileArr.length > 0) {
            StringBuffer stringBuffer = new StringBuffer("Output ");
            stringBuffer.append(this.f72832j ? "appended" : "redirected");
            stringBuffer.append(" to ");
            this.f72836n = h(this.f72824b, stringBuffer.toString(), 3);
        }
        if (this.f72829g == null) {
            this.f72827e = null;
            return;
        }
        if (this.f72827e == null) {
            this.f72827e = new a(this.f72829g);
            v vVar = this.f72835m;
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Output redirected to property: ");
            stringBuffer2.append(this.f72829g);
            vVar.log(stringBuffer2.toString(), 3);
        }
        OutputStream gVar = new org.apache.tools.ant.util.g(this.f72827e);
        if (this.f72836n != null) {
            gVar = new q(this.f72836n, gVar);
        }
        this.f72836n = gVar;
    }

    public synchronized void j() {
        a aVar = this.f72827e;
        if (aVar != null) {
            try {
                aVar.close();
            } catch (IOException unused) {
            }
        }
        a aVar2 = this.f72828f;
        if (aVar2 != null) {
            try {
                aVar2.close();
            } catch (IOException unused2) {
            }
        }
    }

    public final void k(ByteArrayOutputStream byteArrayOutputStream, String str) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new StringReader(g.u(byteArrayOutputStream)));
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                this.f72835m.getProject().J(str, stringBuffer.toString());
                return;
            } else {
                if (stringBuffer.length() != 0) {
                    stringBuffer.append(p.f72993a);
                }
                stringBuffer.append(line);
            }
        }
    }
}
