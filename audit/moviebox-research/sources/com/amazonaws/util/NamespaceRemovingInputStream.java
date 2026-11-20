package com.amazonaws.util;

import com.amazonaws.internal.SdkFilterInputStream;
import java.io.BufferedInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class NamespaceRemovingInputStream extends SdkFilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f16268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f16269b;

    /* JADX INFO: compiled from: source.java */
    public static final class StringPrefixSlicer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f16270a;

        public StringPrefixSlicer(String str) {
            this.f16270a = str;
        }

        public String a() {
            return this.f16270a;
        }

        public boolean b(String str) {
            if (!this.f16270a.startsWith(str)) {
                return false;
            }
            this.f16270a = this.f16270a.substring(str.length());
            return true;
        }

        public boolean c(String str) {
            int iIndexOf = this.f16270a.indexOf(str);
            if (iIndexOf < 0) {
                return false;
            }
            this.f16270a = this.f16270a.substring(iIndexOf + str.length());
            return true;
        }

        public boolean d(String str) {
            if (!this.f16270a.startsWith(str)) {
                return false;
            }
            while (this.f16270a.startsWith(str)) {
                this.f16270a = this.f16270a.substring(str.length());
            }
            return true;
        }
    }

    public NamespaceRemovingInputStream(InputStream inputStream) {
        super(new BufferedInputStream(inputStream));
        this.f16268a = new byte[200];
        this.f16269b = false;
    }

    public final int d(String str) {
        StringPrefixSlicer stringPrefixSlicer = new StringPrefixSlicer(str);
        if (!stringPrefixSlicer.b("xmlns")) {
            return -1;
        }
        stringPrefixSlicer.d(" ");
        if (!stringPrefixSlicer.b("=")) {
            return -1;
        }
        stringPrefixSlicer.d(" ");
        if (stringPrefixSlicer.b("\"") && stringPrefixSlicer.c("\"")) {
            return str.length() - stringPrefixSlicer.a().length();
        }
        return -1;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        c();
        int i11 = ((FilterInputStream) this).in.read();
        if (i11 != 120 || this.f16269b) {
            return i11;
        }
        this.f16268a[0] = (byte) i11;
        ((FilterInputStream) this).in.mark(this.f16268a.length);
        InputStream inputStream = ((FilterInputStream) this).in;
        byte[] bArr = this.f16268a;
        int i12 = inputStream.read(bArr, 1, bArr.length - 1);
        ((FilterInputStream) this).in.reset();
        int iD = d(new String(this.f16268a, 0, i12 + 1, StringUtils.f16272a));
        if (iD <= 0) {
            return i11;
        }
        for (int i13 = 0; i13 < iD - 1; i13++) {
            ((FilterInputStream) this).in.read();
        }
        int i14 = ((FilterInputStream) this).in.read();
        this.f16269b = true;
        return i14;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i11, int i12) throws IOException {
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = read();
            if (i14 == -1) {
                if (i13 == 0) {
                    return -1;
                }
                return i13;
            }
            bArr[i13 + i11] = (byte) i14;
        }
        return i12;
    }
}
