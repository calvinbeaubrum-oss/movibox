package org.apache.commons.compress.archivers.zip;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipException;
import okhttp3.internal.http2.Settings;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class PKWareExtraHeader implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ZipShort f72527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f72528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f72529c;

    /* JADX INFO: compiled from: source.java */
    public enum EncryptionAlgorithm {
        DES(26113),
        RC2pre52(26114),
        TripleDES168(26115),
        TripleDES192(26121),
        AES128(26126),
        AES192(26127),
        AES256(26128),
        RC2(26370),
        RC4(26625),
        UNKNOWN(Settings.DEFAULT_INITIAL_WINDOW_SIZE);

        private static final Map<Integer, EncryptionAlgorithm> codeToEnum;
        private final int code;

        static {
            HashMap map = new HashMap();
            for (EncryptionAlgorithm encryptionAlgorithm : values()) {
                map.put(Integer.valueOf(encryptionAlgorithm.getCode()), encryptionAlgorithm);
            }
            codeToEnum = Collections.unmodifiableMap(map);
        }

        EncryptionAlgorithm(int i11) {
            this.code = i11;
        }

        public static EncryptionAlgorithm getAlgorithmByCode(int i11) {
            return codeToEnum.get(Integer.valueOf(i11));
        }

        public int getCode() {
            return this.code;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum HashAlgorithm {
        NONE(0),
        CRC32(1),
        MD5(32771),
        SHA1(32772),
        RIPEND160(32775),
        SHA256(32780),
        SHA384(32781),
        SHA512(32782);

        private static final Map<Integer, HashAlgorithm> codeToEnum;
        private final int code;

        static {
            HashMap map = new HashMap();
            for (HashAlgorithm hashAlgorithm : values()) {
                map.put(Integer.valueOf(hashAlgorithm.getCode()), hashAlgorithm);
            }
            codeToEnum = Collections.unmodifiableMap(map);
        }

        HashAlgorithm(int i11) {
            this.code = i11;
        }

        public static HashAlgorithm getAlgorithmByCode(int i11) {
            return codeToEnum.get(Integer.valueOf(i11));
        }

        public int getCode() {
            return this.code;
        }
    }

    public PKWareExtraHeader(ZipShort zipShort) {
        this.f72527a = zipShort;
    }

    public final void a(int i11, int i12) throws ZipException {
        if (i12 >= i11) {
            return;
        }
        throw new ZipException(getClass().getName() + " is too short, only " + i12 + " bytes, expected at least " + i11);
    }

    public void b(byte[] bArr) {
        this.f72529c = x.c(bArr);
    }

    public void c(byte[] bArr) {
        this.f72528b = x.c(bArr);
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public byte[] getCentralDirectoryData() {
        byte[] bArr = this.f72529c;
        return bArr != null ? x.c(bArr) : getLocalFileDataData();
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public ZipShort getCentralDirectoryLength() {
        return this.f72529c != null ? new ZipShort(this.f72529c.length) : getLocalFileDataLength();
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public ZipShort getHeaderId() {
        return this.f72527a;
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public byte[] getLocalFileDataData() {
        return x.c(this.f72528b);
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public ZipShort getLocalFileDataLength() {
        byte[] bArr = this.f72528b;
        return new ZipShort(bArr != null ? bArr.length : 0);
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public void parseFromCentralDirectoryData(byte[] bArr, int i11, int i12) throws ZipException {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i11, i12 + i11);
        b(bArrCopyOfRange);
        if (this.f72528b == null) {
            c(bArrCopyOfRange);
        }
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public void parseFromLocalFileData(byte[] bArr, int i11, int i12) throws ZipException {
        c(Arrays.copyOfRange(bArr, i11, i12 + i11));
    }
}
