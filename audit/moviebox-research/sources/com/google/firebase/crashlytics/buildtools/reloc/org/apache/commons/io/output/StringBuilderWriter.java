package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.output;

import java.io.Serializable;
import java.io.Writer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class StringBuilderWriter extends Writer implements Serializable {
    private static final long serialVersionUID = -146927496096066153L;
    private final StringBuilder builder;

    public StringBuilderWriter() {
        this.builder = new StringBuilder();
    }

    public StringBuilderWriter(int i11) {
        this.builder = new StringBuilder(i11);
    }

    public StringBuilderWriter(StringBuilder sb2) {
        this.builder = sb2 == null ? new StringBuilder() : sb2;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c11) {
        this.builder.append(c11);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence) {
        this.builder.append(charSequence);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence, int i11, int i12) {
        this.builder.append(charSequence, i11, i12);
        return this;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
    }

    public StringBuilder getBuilder() {
        return this.builder;
    }

    public String toString() {
        return this.builder.toString();
    }

    @Override // java.io.Writer
    public void write(String str) {
        if (str != null) {
            this.builder.append(str);
        }
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i11, int i12) {
        if (cArr != null) {
            this.builder.append(cArr, i11, i12);
        }
    }
}
