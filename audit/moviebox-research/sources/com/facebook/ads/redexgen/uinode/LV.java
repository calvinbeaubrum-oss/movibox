package com.facebook.ads.redexgen.uinode;

import java.io.IOException;
import java.io.Writer;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class LV extends Writer {
    public static String[] A03 = {"m3VYVt1tyYlWEg8H2HS3pUr0VsrhpbIN", "rEdvzR", "IUQqTrakmjCy7RtoUebGZ8YLkwuKbv7t", "x1ufNW", "e7NtJ1", "AK7iWzpXctzvcUrQA38QQTSmPkrm2HP", "25DCnOqD1cr08G9nl6wTfczykol7NaSA", "0bM1VBntYb2o4FFsMu8yzxmwObMsLmHM"};
    public int A00;
    public char[] A01 = new char[1024];
    public final LU A02;

    public LV(LU lu2) {
        this.A02 = lu2;
    }

    private void A00() {
        this.A02.AE8(new String(this.A01, 0, this.A00));
        this.A00 = 0;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        flush();
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
        if (this.A00 > 0) {
            A00();
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0031  */
    @Override // java.io.Writer
    public final void write(char[] cArr, int i11, int i12) throws IOException {
        int i13 = i11;
        while (true) {
            int i14 = i11 + i12;
            String[] strArr = A03;
            if (strArr[3].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            A03[5] = "5m1TKypG4e5yu";
            if (i13 >= i14) {
                return;
            }
            if (cArr[i13] != '\n') {
                int i15 = this.A00;
                char[] cArr2 = this.A01;
                if (i15 == cArr2.length) {
                    A00();
                } else {
                    cArr2[i15] = cArr[i13];
                    this.A00 = i15 + 1;
                }
            } else {
                A00();
            }
            i13++;
        }
    }
}
