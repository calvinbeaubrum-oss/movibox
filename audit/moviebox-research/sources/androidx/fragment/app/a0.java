package androidx.fragment.app;

import java.io.Writer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a0 extends Writer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public StringBuilder f8578b = new StringBuilder(128);

    public a0(String str) {
        this.f8577a = str;
    }

    public final void a() {
        if (this.f8578b.length() > 0) {
            this.f8578b.toString();
            StringBuilder sb2 = this.f8578b;
            sb2.delete(0, sb2.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        a();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i11, int i12) {
        for (int i13 = 0; i13 < i12; i13++) {
            char c11 = cArr[i11 + i13];
            if (c11 == '\n') {
                a();
            } else {
                this.f8578b.append(c11);
            }
        }
    }
}
