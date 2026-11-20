package com.bumptech.glide.repackaged.com.squareup.javapoet;

import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class LineWrapper {
    private boolean closed;
    private final int columnLimit;
    private final String indent;
    private final Appendable out;
    private final StringBuilder buffer = new StringBuilder();
    private int column = 0;
    private int indentLevel = -1;

    public LineWrapper(Appendable appendable, String str, int i11) {
        Util.checkNotNull(appendable, "out == null", new Object[0]);
        this.out = appendable;
        this.indent = str;
        this.columnLimit = i11;
    }

    private void flush(boolean z11) throws IOException {
        int i11;
        if (z11) {
            this.out.append('\n');
            int i12 = 0;
            while (true) {
                i11 = this.indentLevel;
                if (i12 >= i11) {
                    break;
                }
                this.out.append(this.indent);
                i12++;
            }
            int length = i11 * this.indent.length();
            this.column = length;
            this.column = length + this.buffer.length();
        } else {
            this.out.append(' ');
        }
        this.out.append(this.buffer);
        StringBuilder sb2 = this.buffer;
        sb2.delete(0, sb2.length());
        this.indentLevel = -1;
    }

    public void append(String str) throws IOException {
        int length;
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (this.indentLevel != -1) {
            int iIndexOf = str.indexOf(10);
            if (iIndexOf == -1 && this.column + str.length() <= this.columnLimit) {
                this.buffer.append(str);
                this.column += str.length();
                return;
            }
            flush(iIndexOf == -1 || this.column + iIndexOf > this.columnLimit);
        }
        this.out.append(str);
        int iLastIndexOf = str.lastIndexOf(10);
        if (iLastIndexOf != -1) {
            length = (str.length() - iLastIndexOf) - 1;
        } else {
            length = str.length() + this.column;
        }
        this.column = length;
    }

    public void wrappingSpace(int i11) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (this.indentLevel != -1) {
            flush(false);
        }
        this.column++;
        this.indentLevel = i11;
    }
}
