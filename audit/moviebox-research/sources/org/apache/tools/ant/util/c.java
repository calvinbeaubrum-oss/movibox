package org.apache.tools.ant.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.tools.ant.v;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class c extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f72943a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f72944b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public File[] f72945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public InputStream f72946d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public v f72947f;

    public c(File[] fileArr) throws IOException {
        this.f72945c = fileArr;
    }

    public final void a() {
        d.b(this.f72946d);
        this.f72946d = null;
    }

    public void b(String str, int i11) {
        v vVar = this.f72947f;
        if (vVar != null) {
            vVar.log(str, i11);
        } else if (i11 > 1) {
            System.out.println(str);
        } else {
            System.err.println(str);
        }
    }

    public final void c(int i11) throws IOException {
        a();
        File[] fileArr = this.f72945c;
        if (fileArr == null || i11 >= fileArr.length) {
            this.f72944b = true;
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Opening ");
        stringBuffer.append(this.f72945c[i11]);
        b(stringBuffer.toString(), 3);
        try {
            this.f72946d = new BufferedInputStream(new FileInputStream(this.f72945c[i11]));
        } catch (IOException e11) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Failed to open ");
            stringBuffer2.append(this.f72945c[i11]);
            b(stringBuffer2.toString(), 0);
            throw e11;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        a();
        this.f72944b = true;
    }

    public final int d() throws IOException {
        InputStream inputStream;
        if (this.f72944b || (inputStream = this.f72946d) == null) {
            return -1;
        }
        return inputStream.read();
    }

    public void e(v vVar) {
        this.f72947f = vVar;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int iD = d();
        if (iD != -1 || this.f72944b) {
            return iD;
        }
        int i11 = this.f72943a + 1;
        this.f72943a = i11;
        c(i11);
        return d();
    }
}
