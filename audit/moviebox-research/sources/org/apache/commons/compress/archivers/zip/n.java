package org.apache.commons.compress.archivers.zip;

import java.util.Date;
import java.util.zip.ZipException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class n implements w {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ZipShort f72588d = new ZipShort(10);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ZipShort f72589f = new ZipShort(1);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ZipShort f72590g = new ZipShort(24);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ZipEightByteInteger f72591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ZipEightByteInteger f72592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ZipEightByteInteger f72593c;

    public n() {
        ZipEightByteInteger zipEightByteInteger = ZipEightByteInteger.ZERO;
        this.f72591a = zipEightByteInteger;
        this.f72592b = zipEightByteInteger;
        this.f72593c = zipEightByteInteger;
    }

    public static Date f(ZipEightByteInteger zipEightByteInteger) {
        if (zipEightByteInteger == null || ZipEightByteInteger.ZERO.equals(zipEightByteInteger)) {
            return null;
        }
        return new Date((zipEightByteInteger.getLongValue() - 116444736000000000L) / 10000);
    }

    public Date a() {
        return f(this.f72592b);
    }

    public Date b() {
        return f(this.f72593c);
    }

    public Date c() {
        return f(this.f72591a);
    }

    public final void d(byte[] bArr, int i11, int i12) {
        if (i12 >= 26) {
            if (f72590g.equals(new ZipShort(bArr, i11))) {
                this.f72591a = new ZipEightByteInteger(bArr, i11 + 2);
                this.f72592b = new ZipEightByteInteger(bArr, i11 + 10);
                this.f72593c = new ZipEightByteInteger(bArr, i11 + 18);
            }
        }
    }

    public final void e() {
        ZipEightByteInteger zipEightByteInteger = ZipEightByteInteger.ZERO;
        this.f72591a = zipEightByteInteger;
        this.f72592b = zipEightByteInteger;
        this.f72593c = zipEightByteInteger;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        ZipEightByteInteger zipEightByteInteger = this.f72591a;
        ZipEightByteInteger zipEightByteInteger2 = nVar.f72591a;
        if (zipEightByteInteger != zipEightByteInteger2 && (zipEightByteInteger == null || !zipEightByteInteger.equals(zipEightByteInteger2))) {
            return false;
        }
        ZipEightByteInteger zipEightByteInteger3 = this.f72592b;
        ZipEightByteInteger zipEightByteInteger4 = nVar.f72592b;
        if (zipEightByteInteger3 != zipEightByteInteger4 && (zipEightByteInteger3 == null || !zipEightByteInteger3.equals(zipEightByteInteger4))) {
            return false;
        }
        ZipEightByteInteger zipEightByteInteger5 = this.f72593c;
        ZipEightByteInteger zipEightByteInteger6 = nVar.f72593c;
        return zipEightByteInteger5 == zipEightByteInteger6 || (zipEightByteInteger5 != null && zipEightByteInteger5.equals(zipEightByteInteger6));
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
        return f72588d;
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public byte[] getLocalFileDataData() {
        byte[] bArr = new byte[getLocalFileDataLength().getValue()];
        System.arraycopy(f72589f.getBytes(), 0, bArr, 4, 2);
        System.arraycopy(f72590g.getBytes(), 0, bArr, 6, 2);
        System.arraycopy(this.f72591a.getBytes(), 0, bArr, 8, 8);
        System.arraycopy(this.f72592b.getBytes(), 0, bArr, 16, 8);
        System.arraycopy(this.f72593c.getBytes(), 0, bArr, 24, 8);
        return bArr;
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public ZipShort getLocalFileDataLength() {
        return new ZipShort(32);
    }

    public int hashCode() {
        ZipEightByteInteger zipEightByteInteger = this.f72591a;
        int iHashCode = zipEightByteInteger != null ? (-123) ^ zipEightByteInteger.hashCode() : -123;
        ZipEightByteInteger zipEightByteInteger2 = this.f72592b;
        if (zipEightByteInteger2 != null) {
            iHashCode ^= Integer.rotateLeft(zipEightByteInteger2.hashCode(), 11);
        }
        ZipEightByteInteger zipEightByteInteger3 = this.f72593c;
        return zipEightByteInteger3 != null ? iHashCode ^ Integer.rotateLeft(zipEightByteInteger3.hashCode(), 22) : iHashCode;
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public void parseFromCentralDirectoryData(byte[] bArr, int i11, int i12) throws ZipException {
        e();
        parseFromLocalFileData(bArr, i11, i12);
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public void parseFromLocalFileData(byte[] bArr, int i11, int i12) throws ZipException {
        int i13 = i12 + i11;
        int value = i11 + 4;
        while (value + 4 <= i13) {
            ZipShort zipShort = new ZipShort(bArr, value);
            int i14 = value + 2;
            if (zipShort.equals(f72589f)) {
                d(bArr, i14, i13 - i14);
                return;
            }
            value = i14 + new ZipShort(bArr, i14).getValue() + 2;
        }
    }

    public String toString() {
        return "0x000A Zip Extra Field: Modify:[" + c() + "]  Access:[" + a() + "]  Create:[" + b() + "] ";
    }
}
