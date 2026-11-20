package org.apache.tools.ant.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class j extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ByteArrayOutputStream f72978a = new ByteArrayOutputStream(132);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f72979b = false;

    public void a() throws IOException {
        try {
            b(this.f72978a.toString());
        } finally {
            this.f72978a.reset();
        }
    }

    public abstract void b(String str) throws IOException;

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.f72978a.size() > 0) {
            a();
        }
        super.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() throws IOException {
        if (this.f72978a.size() > 0) {
            a();
        }
    }

    @Override // java.io.OutputStream
    public final void write(int i11) throws IOException {
        byte b11 = (byte) i11;
        if (b11 != 10 && b11 != 13) {
            this.f72978a.write(i11);
        } else if (!this.f72979b) {
            a();
        }
        this.f72979b = b11 == 13;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i11, int i12) throws IOException {
        byte b11;
        while (i12 > 0) {
            int i13 = i11;
            while (i12 > 0 && (b11 = bArr[i13]) != 10 && b11 != 13) {
                i13++;
                i12--;
            }
            int i14 = i13 - i11;
            if (i14 > 0) {
                this.f72978a.write(bArr, i11, i14);
            }
            i11 = i13;
            while (i12 > 0) {
                byte b12 = bArr[i11];
                if (b12 != 10 && b12 != 13) {
                    break;
                }
                write(b12);
                i11++;
                i12--;
            }
        }
    }
}
