package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.input;

import java.io.Reader;
import java.io.Serializable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class CharSequenceReader extends Reader implements Serializable {
    private static final long serialVersionUID = 3724187752191401220L;
    private final CharSequence charSequence;
    private int idx;
    private int mark;

    public CharSequenceReader(String str) {
        this.charSequence = str == null ? "" : str;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.idx = 0;
        this.mark = 0;
    }

    @Override // java.io.Reader
    public void mark(int i11) {
        this.mark = this.idx;
    }

    @Override // java.io.Reader
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.Reader
    public int read() {
        if (this.idx >= this.charSequence.length()) {
            return -1;
        }
        CharSequence charSequence = this.charSequence;
        int i11 = this.idx;
        this.idx = i11 + 1;
        return charSequence.charAt(i11);
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i11, int i12) {
        if (this.idx >= this.charSequence.length()) {
            return -1;
        }
        if (cArr == null) {
            throw new NullPointerException("Character array is missing");
        }
        if (i12 < 0 || i11 < 0 || i11 + i12 > cArr.length) {
            throw new IndexOutOfBoundsException("Array Size=" + cArr.length + ", offset=" + i11 + ", length=" + i12);
        }
        int i13 = 0;
        for (int i14 = 0; i14 < i12; i14++) {
            int i15 = read();
            if (i15 == -1) {
                return i13;
            }
            cArr[i11 + i14] = (char) i15;
            i13++;
        }
        return i13;
    }

    @Override // java.io.Reader
    public void reset() {
        this.idx = this.mark;
    }

    @Override // java.io.Reader
    public long skip(long j11) {
        if (j11 < 0) {
            throw new IllegalArgumentException("Number of characters to skip is less than zero: " + j11);
        }
        if (this.idx >= this.charSequence.length()) {
            return -1L;
        }
        int iMin = (int) Math.min(this.charSequence.length(), ((long) this.idx) + j11);
        int i11 = iMin - this.idx;
        this.idx = iMin;
        return i11;
    }

    public String toString() {
        return this.charSequence.toString();
    }
}
