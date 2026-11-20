package org.mvel2.sh;

import java.io.InputStream;
import java.io.PrintStream;
import q30.d;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
class ShellSession$1 implements Runnable {
    final /* synthetic */ a this$0;
    final /* synthetic */ InputStream val$inStream;
    final /* synthetic */ a.C0793a val$runState;
    final /* synthetic */ PrintStream val$sysPrintStream;

    public ShellSession$1(a aVar, InputStream inputStream, PrintStream printStream, a.C0793a c0793a) {
        this.val$inStream = inputStream;
        this.val$sysPrintStream = printStream;
    }

    @Override // java.lang.Runnable
    public void run() {
        byte[] bArr = new byte[25];
        while (true) {
            try {
                int i11 = this.val$inStream.read(bArr);
                if (i11 <= 0) {
                    throw null;
                }
                for (int i12 = 0; i12 < i11; i12++) {
                    this.val$sysPrintStream.print((char) bArr[i12]);
                }
                this.val$sysPrintStream.flush();
            } catch (Exception unused) {
                this.val$sysPrintStream.flush();
                if (!a.a(null)) {
                    a.c(null, a.e(null, String.valueOf(d.b((String) a.f(null).get("$PROMPT"), a.g(null)))).length());
                    a.h(null).append((CharSequence) a.d(null));
                    return;
                } else {
                    a.h(null).append((CharSequence) ">");
                    a.b(null);
                    a.i(null);
                    throw null;
                }
            }
        }
    }
}
