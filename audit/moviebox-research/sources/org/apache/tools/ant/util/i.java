package org.apache.tools.ant.util;

import java.io.IOException;
import java.io.PipedInputStream;
import org.apache.tools.ant.v;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class i extends PipedInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public v f72977a;

    public void a(String str, int i11) {
        v vVar = this.f72977a;
        if (vVar != null) {
            vVar.log(str, i11);
        } else if (i11 > 1) {
            System.out.println(str);
        } else {
            System.err.println(str);
        }
    }

    public void b(v vVar) {
        this.f72977a = vVar;
    }

    @Override // java.io.PipedInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        int i11;
        try {
            i11 = super.read();
        } catch (IOException e11) {
            if ("write end dead".equalsIgnoreCase(e11.getMessage())) {
                int i12 = ((PipedInputStream) this).in;
                if (i12 > 0) {
                    int i13 = ((PipedInputStream) this).out;
                    byte[] bArr = ((PipedInputStream) this).buffer;
                    if (i13 < bArr.length && i13 > i12) {
                        ((PipedInputStream) this).out = i13 + 1;
                        i11 = bArr[i13] & 255;
                    }
                }
            } else {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("error at LeadPipeInputStream.read():  ");
                stringBuffer.append(e11.getMessage());
                a(stringBuffer.toString(), 2);
            }
            i11 = -1;
        }
        return i11;
    }
}
