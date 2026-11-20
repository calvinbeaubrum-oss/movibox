package org.apache.commons.compress.archivers.zip;

import java.util.zip.CRC32;
import java.util.zip.ZipException;
import org.apache.tools.zip.UnixStat;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class b implements w, Cloneable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ZipShort f72551h = new ZipShort(30062);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f72552a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f72553b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f72554c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f72555d = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f72556f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CRC32 f72557g = new CRC32();

    public int a() {
        return this.f72554c;
    }

    public String b() {
        return this.f72555d;
    }

    public int c() {
        return this.f72552a;
    }

    public Object clone() {
        try {
            b bVar = (b) super.clone();
            bVar.f72557g = new CRC32();
            return bVar;
        } catch (CloneNotSupportedException e11) {
            throw new RuntimeException(e11);
        }
    }

    public int d(int i11) {
        int i12;
        if (h()) {
            i12 = UnixStat.LINK_FLAG;
        } else {
            i12 = g() ? 16384 : 32768;
        }
        return (i11 & UnixStat.PERM_MASK) | i12;
    }

    public int f() {
        return this.f72553b;
    }

    public boolean g() {
        return this.f72556f && !h();
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public byte[] getCentralDirectoryData() {
        return getLocalFileDataData();
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public ZipShort getCentralDirectoryLength() {
        return getLocalFileDataLength();
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public ZipShort getHeaderId() {
        return f72551h;
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public byte[] getLocalFileDataData() {
        int value = getLocalFileDataLength().getValue();
        int i11 = value - 4;
        byte[] bArr = new byte[i11];
        System.arraycopy(ZipShort.getBytes(c()), 0, bArr, 0, 2);
        byte[] bytes = b().getBytes();
        System.arraycopy(ZipLong.getBytes(bytes.length), 0, bArr, 2, 4);
        System.arraycopy(ZipShort.getBytes(f()), 0, bArr, 6, 2);
        System.arraycopy(ZipShort.getBytes(a()), 0, bArr, 8, 2);
        System.arraycopy(bytes, 0, bArr, 10, bytes.length);
        this.f72557g.reset();
        this.f72557g.update(bArr);
        byte[] bArr2 = new byte[value];
        System.arraycopy(ZipLong.getBytes(this.f72557g.getValue()), 0, bArr2, 0, 4);
        System.arraycopy(bArr, 0, bArr2, 4, i11);
        return bArr2;
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public ZipShort getLocalFileDataLength() {
        return new ZipShort(b().getBytes().length + 14);
    }

    public boolean h() {
        return b().length() != 0;
    }

    public void j(boolean z11) {
        this.f72556f = z11;
        this.f72552a = d(this.f72552a);
    }

    public void k(int i11) {
        this.f72552a = d(i11);
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public void parseFromCentralDirectoryData(byte[] bArr, int i11, int i12) throws ZipException {
        parseFromLocalFileData(bArr, i11, i12);
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public void parseFromLocalFileData(byte[] bArr, int i11, int i12) throws ZipException {
        long value = ZipLong.getValue(bArr, i11);
        int i13 = i12 - 4;
        byte[] bArr2 = new byte[i13];
        System.arraycopy(bArr, i11 + 4, bArr2, 0, i13);
        this.f72557g.reset();
        this.f72557g.update(bArr2);
        long value2 = this.f72557g.getValue();
        if (value != value2) {
            throw new ZipException("Bad CRC checksum, expected " + Long.toHexString(value) + " instead of " + Long.toHexString(value2));
        }
        int value3 = ZipShort.getValue(bArr2, 0);
        int value4 = (int) ZipLong.getValue(bArr2, 2);
        byte[] bArr3 = new byte[value4];
        this.f72553b = ZipShort.getValue(bArr2, 6);
        this.f72554c = ZipShort.getValue(bArr2, 8);
        if (value4 == 0) {
            this.f72555d = "";
        } else {
            if (value4 > i12 - 14) {
                throw new ZipException("Bad symbolic link name length " + value4 + " in ASI extra field");
            }
            System.arraycopy(bArr2, 10, bArr3, 0, value4);
            this.f72555d = new String(bArr3);
        }
        j((value3 & 16384) != 0);
        k(value3);
    }
}
