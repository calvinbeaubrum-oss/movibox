package org.apache.commons.compress.archivers.zip;

import java.io.Serializable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class ZipShort implements Cloneable, Serializable {
    public static final ZipShort ZERO = new ZipShort(0);
    private static final long serialVersionUID = 1;
    private final int value;

    public ZipShort(int i11) {
        this.value = i11;
    }

    public ZipShort(byte[] bArr) {
        this(bArr, 0);
    }

    public ZipShort(byte[] bArr, int i11) {
        this.value = getValue(bArr, i11);
    }

    public static byte[] getBytes(int i11) {
        byte[] bArr = new byte[2];
        putShort(i11, bArr, 0);
        return bArr;
    }

    public static int getValue(byte[] bArr) {
        return getValue(bArr, 0);
    }

    public static int getValue(byte[] bArr, int i11) {
        return (int) o20.b.b(bArr, i11, 2);
    }

    public static void putShort(int i11, byte[] bArr, int i12) {
        o20.b.c(bArr, i11, i12, 2);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e11) {
            throw new RuntimeException(e11);
        }
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof ZipShort) && this.value == ((ZipShort) obj).getValue();
    }

    public byte[] getBytes() {
        byte[] bArr = new byte[2];
        o20.b.c(bArr, this.value, 0, 2);
        return bArr;
    }

    public int getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.value;
    }

    public String toString() {
        return "ZipShort value: " + this.value;
    }
}
