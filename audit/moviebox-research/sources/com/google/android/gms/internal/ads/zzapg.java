package com.google.android.gms.internal.ads;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.api.gateway.utils.EncoderUtil;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.security.DigestException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzapg {
    public static X509Certificate[][] zza(String str) throws zzapd, SecurityException, IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, CampaignEx.JSON_KEY_AD_R);
        try {
            Pair pairZzc = zzaph.zzc(randomAccessFile);
            if (pairZzc == null) {
                throw new zzapd("Not an APK file: ZIP End of Central Directory record not found in file with " + randomAccessFile.length() + " bytes");
            }
            ByteBuffer byteBuffer = (ByteBuffer) pairZzc.first;
            long jLongValue = ((Long) pairZzc.second).longValue();
            long j11 = (-20) + jLongValue;
            if (j11 >= 0) {
                randomAccessFile.seek(j11);
                if (randomAccessFile.readInt() == 1347094023) {
                    throw new zzapd("ZIP64 APK not supported");
                }
            }
            long jZza = zzaph.zza(byteBuffer);
            if (jZza >= jLongValue) {
                throw new zzapd("ZIP Central Directory offset out of range: " + jZza + ". ZIP End of Central Directory offset: " + jLongValue);
            }
            if (zzaph.zzb(byteBuffer) + jZza != jLongValue) {
                throw new zzapd("ZIP Central Directory is not immediately followed by End of Central Directory");
            }
            if (jZza < 32) {
                throw new zzapd("APK too small for APK Signing Block. ZIP Central Directory offset: " + jZza);
            }
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(24);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            byteBufferAllocate.order(byteOrder);
            randomAccessFile.seek(jZza - ((long) byteBufferAllocate.capacity()));
            randomAccessFile.readFully(byteBufferAllocate.array(), byteBufferAllocate.arrayOffset(), byteBufferAllocate.capacity());
            if (byteBufferAllocate.getLong(8) != 2334950737559900225L || byteBufferAllocate.getLong(16) != 3617552046287187010L) {
                throw new zzapd("No APK Signing Block before ZIP Central Directory");
            }
            int i11 = 0;
            long j12 = byteBufferAllocate.getLong(0);
            if (j12 < byteBufferAllocate.capacity() || j12 > 2147483639) {
                throw new zzapd("APK Signing Block size out of range: " + j12);
            }
            int i12 = (int) (8 + j12);
            long j13 = jZza - ((long) i12);
            if (j13 < 0) {
                throw new zzapd("APK Signing Block offset out of range: " + j13);
            }
            ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(i12);
            byteBufferAllocate2.order(byteOrder);
            randomAccessFile.seek(j13);
            randomAccessFile.readFully(byteBufferAllocate2.array(), byteBufferAllocate2.arrayOffset(), byteBufferAllocate2.capacity());
            long j14 = byteBufferAllocate2.getLong(0);
            if (j14 != j12) {
                throw new zzapd("APK Signing Block sizes in header and footer do not match: " + j14 + " vs " + j12);
            }
            Pair pairCreate = Pair.create(byteBufferAllocate2, Long.valueOf(j13));
            ByteBuffer byteBuffer2 = (ByteBuffer) pairCreate.first;
            long jLongValue2 = ((Long) pairCreate.second).longValue();
            if (byteBuffer2.order() != byteOrder) {
                throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
            }
            int iCapacity = byteBuffer2.capacity() - 24;
            if (iCapacity < 8) {
                throw new IllegalArgumentException("end < start: " + iCapacity + " < 8");
            }
            int iCapacity2 = byteBuffer2.capacity();
            if (iCapacity > byteBuffer2.capacity()) {
                throw new IllegalArgumentException("end > capacity: " + iCapacity + " > " + iCapacity2);
            }
            int iLimit = byteBuffer2.limit();
            int iPosition = byteBuffer2.position();
            try {
                byteBuffer2.position(0);
                byteBuffer2.limit(iCapacity);
                byteBuffer2.position(8);
                ByteBuffer byteBufferSlice = byteBuffer2.slice();
                byteBufferSlice.order(byteBuffer2.order());
                byteBuffer2.position(0);
                byteBuffer2.limit(iLimit);
                byteBuffer2.position(iPosition);
                while (byteBufferSlice.hasRemaining()) {
                    i11++;
                    if (byteBufferSlice.remaining() < 8) {
                        throw new zzapd("Insufficient data to read size of APK Signing Block entry #" + i11);
                    }
                    long j15 = byteBufferSlice.getLong();
                    if (j15 < 4 || j15 > 2147483647L) {
                        throw new zzapd("APK Signing Block entry #" + i11 + " size out of range: " + j15);
                    }
                    int i13 = (int) j15;
                    int iPosition2 = byteBufferSlice.position() + i13;
                    if (i13 > byteBufferSlice.remaining()) {
                        throw new zzapd("APK Signing Block entry #" + i11 + " size out of range: " + i13 + ", available: " + byteBufferSlice.remaining());
                    }
                    if (byteBufferSlice.getInt() == 1896449818) {
                        X509Certificate[][] x509CertificateArrZzl = zzl(randomAccessFile.getChannel(), new zzapc(zze(byteBufferSlice, i13 - 4), jLongValue2, jZza, jLongValue, byteBuffer, null));
                        randomAccessFile.close();
                        try {
                            randomAccessFile.close();
                        } catch (IOException unused) {
                        }
                        return x509CertificateArrZzl;
                    }
                    byteBufferSlice.position(iPosition2);
                }
                throw new zzapd("No APK Signature Scheme v2 block in APK Signing Block");
            } catch (Throwable th2) {
                byteBuffer2.position(0);
                byteBuffer2.limit(iLimit);
                byteBuffer2.position(iPosition);
                throw th2;
            }
        } catch (Throwable th3) {
            try {
                randomAccessFile.close();
            } catch (IOException unused2) {
            }
            throw th3;
        }
    }

    private static int zzb(int i11) {
        if (i11 == 1) {
            return 32;
        }
        if (i11 == 2) {
            return 64;
        }
        throw new IllegalArgumentException("Unknown content digest algorthm: " + i11);
    }

    private static int zzc(int i11) {
        if (i11 == 513) {
            return 1;
        }
        if (i11 == 514) {
            return 2;
        }
        if (i11 == 769) {
            return 1;
        }
        switch (i11) {
            case InputDeviceCompat.SOURCE_KEYBOARD /* 257 */:
            case 259:
                return 1;
            case 258:
            case 260:
                return 2;
            default:
                throw new IllegalArgumentException("Unknown signature algorithm: 0x".concat(String.valueOf(Long.toHexString(i11))));
        }
    }

    private static String zzd(int i11) {
        if (i11 == 1) {
            return EncoderUtil.ALGORITHM_SHA_256;
        }
        if (i11 == 2) {
            return EncoderUtil.ALGORITHM_SHA_512;
        }
        throw new IllegalArgumentException("Unknown content digest algorthm: " + i11);
    }

    private static ByteBuffer zze(ByteBuffer byteBuffer, int i11) throws BufferUnderflowException {
        int iLimit = byteBuffer.limit();
        int iPosition = byteBuffer.position();
        int i12 = i11 + iPosition;
        if (i12 < iPosition || i12 > iLimit) {
            throw new BufferUnderflowException();
        }
        byteBuffer.limit(i12);
        try {
            ByteBuffer byteBufferSlice = byteBuffer.slice();
            byteBufferSlice.order(byteBuffer.order());
            byteBuffer.position(i12);
            return byteBufferSlice;
        } finally {
            byteBuffer.limit(iLimit);
        }
    }

    private static ByteBuffer zzf(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.remaining() < 4) {
            throw new IOException("Remaining buffer too short to contain length of length-prefixed field. Remaining: " + byteBuffer.remaining());
        }
        int i11 = byteBuffer.getInt();
        if (i11 < 0) {
            throw new IllegalArgumentException("Negative length");
        }
        if (i11 <= byteBuffer.remaining()) {
            return zze(byteBuffer, i11);
        }
        throw new IOException("Length-prefixed field longer than remaining buffer. Field length: " + i11 + ", remaining: " + byteBuffer.remaining());
    }

    private static void zzg(int i11, byte[] bArr, int i12) {
        bArr[1] = (byte) (i11 & 255);
        bArr[2] = (byte) ((i11 >>> 8) & 255);
        bArr[3] = (byte) ((i11 >>> 16) & 255);
        bArr[4] = (byte) (i11 >> 24);
    }

    private static void zzh(Map map, FileChannel fileChannel, long j11, long j12, long j13, ByteBuffer byteBuffer) throws SecurityException {
        if (map.isEmpty()) {
            throw new SecurityException("No digests provided");
        }
        zzapa zzapaVar = new zzapa(fileChannel, 0L, j11);
        zzapa zzapaVar2 = new zzapa(fileChannel, j12, j13 - j12);
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.order(ByteOrder.LITTLE_ENDIAN);
        zzaph.zzd(byteBufferDuplicate, j11);
        zzaoy zzaoyVar = new zzaoy(byteBufferDuplicate);
        int size = map.size();
        int[] iArr = new int[size];
        Iterator it = map.keySet().iterator();
        int i11 = 0;
        while (it.hasNext()) {
            iArr[i11] = ((Integer) it.next()).intValue();
            i11++;
        }
        try {
            byte[][] bArrZzk = zzk(iArr, new zzaoz[]{zzapaVar, zzapaVar2, zzaoyVar});
            for (int i12 = 0; i12 < size; i12++) {
                int i13 = iArr[i12];
                if (!MessageDigest.isEqual((byte[]) map.get(Integer.valueOf(i13)), bArrZzk[i12])) {
                    throw new SecurityException(zzd(i13).concat(" digest of contents did not verify"));
                }
            }
        } catch (DigestException e11) {
            throw new SecurityException("Failed to compute digest(s) of contents", e11);
        }
    }

    private static byte[] zzi(ByteBuffer byteBuffer) throws IOException {
        int i11 = byteBuffer.getInt();
        if (i11 < 0) {
            throw new IOException("Negative length");
        }
        if (i11 <= byteBuffer.remaining()) {
            byte[] bArr = new byte[i11];
            byteBuffer.get(bArr);
            return bArr;
        }
        throw new IOException("Underflow while reading length-prefixed value. Length: " + i11 + ", available: " + byteBuffer.remaining());
    }

    private static X509Certificate[] zzj(ByteBuffer byteBuffer, Map map, CertificateFactory certificateFactory) throws IOException, SecurityException {
        String str;
        Pair pairCreate;
        ByteBuffer byteBufferZzf = zzf(byteBuffer);
        ByteBuffer byteBufferZzf2 = zzf(byteBuffer);
        byte[] bArrZzi = zzi(byteBuffer);
        ArrayList arrayList = new ArrayList();
        byte[] bArrZzi2 = null;
        byte[] bArrZzi3 = null;
        int i11 = -1;
        int i12 = 0;
        while (byteBufferZzf2.hasRemaining()) {
            i12++;
            try {
                ByteBuffer byteBufferZzf3 = zzf(byteBufferZzf2);
                if (byteBufferZzf3.remaining() < 8) {
                    throw new SecurityException("Signature record too short");
                }
                int i13 = byteBufferZzf3.getInt();
                arrayList.add(Integer.valueOf(i13));
                if (i13 != 513 && i13 != 514 && i13 != 769) {
                    switch (i13) {
                        case InputDeviceCompat.SOURCE_KEYBOARD /* 257 */:
                        case 258:
                        case 259:
                        case 260:
                            break;
                        default:
                            continue;
                    }
                }
                if (i11 != -1) {
                    int iZzc = zzc(i13);
                    int iZzc2 = zzc(i11);
                    if (iZzc != 1 && iZzc2 == 1) {
                    }
                }
                bArrZzi3 = zzi(byteBufferZzf3);
                i11 = i13;
            } catch (IOException e11) {
                e = e11;
                throw new SecurityException("Failed to parse signature record #" + i12, e);
            } catch (BufferUnderflowException e12) {
                e = e12;
                throw new SecurityException("Failed to parse signature record #" + i12, e);
            }
        }
        if (i11 == -1) {
            if (i12 == 0) {
                throw new SecurityException("No signatures found");
            }
            throw new SecurityException("No supported signatures found");
        }
        if (i11 == 513 || i11 == 514) {
            str = "EC";
        } else if (i11 != 769) {
            switch (i11) {
                case InputDeviceCompat.SOURCE_KEYBOARD /* 257 */:
                case 258:
                case 259:
                case 260:
                    str = "RSA";
                    break;
                default:
                    throw new IllegalArgumentException("Unknown signature algorithm: 0x".concat(String.valueOf(Long.toHexString(i11))));
            }
        } else {
            str = "DSA";
        }
        if (i11 == 513) {
            pairCreate = Pair.create("SHA256withECDSA", null);
        } else if (i11 == 514) {
            pairCreate = Pair.create("SHA512withECDSA", null);
        } else if (i11 != 769) {
            switch (i11) {
                case InputDeviceCompat.SOURCE_KEYBOARD /* 257 */:
                    pairCreate = Pair.create("SHA256withRSA/PSS", new PSSParameterSpec(EncoderUtil.ALGORITHM_SHA_256, "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
                    break;
                case 258:
                    pairCreate = Pair.create("SHA512withRSA/PSS", new PSSParameterSpec(EncoderUtil.ALGORITHM_SHA_512, "MGF1", MGF1ParameterSpec.SHA512, 64, 1));
                    break;
                case 259:
                    pairCreate = Pair.create("SHA256withRSA", null);
                    break;
                case 260:
                    pairCreate = Pair.create("SHA512withRSA", null);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown signature algorithm: 0x".concat(String.valueOf(Long.toHexString(i11))));
            }
        } else {
            pairCreate = Pair.create("SHA256withDSA", null);
        }
        String str2 = (String) pairCreate.first;
        AlgorithmParameterSpec algorithmParameterSpec = (AlgorithmParameterSpec) pairCreate.second;
        try {
            PublicKey publicKeyGeneratePublic = KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(bArrZzi));
            Signature signature = Signature.getInstance(str2);
            signature.initVerify(publicKeyGeneratePublic);
            if (algorithmParameterSpec != null) {
                signature.setParameter(algorithmParameterSpec);
            }
            signature.update(byteBufferZzf);
            if (!signature.verify(bArrZzi3)) {
                throw new SecurityException(String.valueOf(str2).concat(" signature did not verify"));
            }
            byteBufferZzf.clear();
            ByteBuffer byteBufferZzf4 = zzf(byteBufferZzf);
            ArrayList arrayList2 = new ArrayList();
            int i14 = 0;
            while (byteBufferZzf4.hasRemaining()) {
                i14++;
                try {
                    ByteBuffer byteBufferZzf5 = zzf(byteBufferZzf4);
                    if (byteBufferZzf5.remaining() < 8) {
                        throw new IOException("Record too short");
                    }
                    int i15 = byteBufferZzf5.getInt();
                    arrayList2.add(Integer.valueOf(i15));
                    if (i15 == i11) {
                        bArrZzi2 = zzi(byteBufferZzf5);
                    }
                } catch (IOException e13) {
                    e = e13;
                    throw new IOException("Failed to parse digest record #" + i14, e);
                } catch (BufferUnderflowException e14) {
                    e = e14;
                    throw new IOException("Failed to parse digest record #" + i14, e);
                }
            }
            if (!arrayList.equals(arrayList2)) {
                throw new SecurityException("Signature algorithms don't match between digests and signatures records");
            }
            int iZzc3 = zzc(i11);
            byte[] bArr = (byte[]) map.put(Integer.valueOf(iZzc3), bArrZzi2);
            if (bArr != null && !MessageDigest.isEqual(bArr, bArrZzi2)) {
                throw new SecurityException(zzd(iZzc3).concat(" contents digest does not match the digest specified by a preceding signer"));
            }
            ByteBuffer byteBufferZzf6 = zzf(byteBufferZzf);
            ArrayList arrayList3 = new ArrayList();
            int i16 = 0;
            while (byteBufferZzf6.hasRemaining()) {
                i16++;
                byte[] bArrZzi4 = zzi(byteBufferZzf6);
                try {
                    arrayList3.add(new zzape((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(bArrZzi4)), bArrZzi4));
                } catch (CertificateException e15) {
                    throw new SecurityException("Failed to decode certificate #" + i16, e15);
                }
            }
            if (arrayList3.isEmpty()) {
                throw new SecurityException("No certificates listed");
            }
            if (Arrays.equals(bArrZzi, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                return (X509Certificate[]) arrayList3.toArray(new X509Certificate[arrayList3.size()]);
            }
            throw new SecurityException("Public key mismatch between certificate and signature record");
        } catch (InvalidAlgorithmParameterException e16) {
            e = e16;
            throw new SecurityException("Failed to verify " + str2 + " signature", e);
        } catch (InvalidKeyException e17) {
            e = e17;
            throw new SecurityException("Failed to verify " + str2 + " signature", e);
        } catch (NoSuchAlgorithmException e18) {
            e = e18;
            throw new SecurityException("Failed to verify " + str2 + " signature", e);
        } catch (SignatureException e19) {
            e = e19;
            throw new SecurityException("Failed to verify " + str2 + " signature", e);
        } catch (InvalidKeySpecException e21) {
            e = e21;
            throw new SecurityException("Failed to verify " + str2 + " signature", e);
        }
    }

    private static byte[][] zzk(int[] iArr, zzaoz[] zzaozVarArr) throws DigestException {
        long j11;
        int i11;
        int length;
        int i12 = 0;
        long j12 = 0;
        long jZza = 0;
        int i13 = 0;
        while (true) {
            j11 = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            if (i13 >= 3) {
                break;
            }
            jZza += (zzaozVarArr[i13].zza() + 1048575) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            i13++;
        }
        if (jZza >= 2097151) {
            throw new DigestException("Too many chunks: " + jZza);
        }
        byte[][] bArr = new byte[iArr.length][];
        int i14 = 0;
        while (true) {
            length = iArr.length;
            if (i14 >= length) {
                break;
            }
            int i15 = (int) jZza;
            byte[] bArr2 = new byte[(zzb(iArr[i14]) * i15) + 5];
            bArr2[0] = 90;
            zzg(i15, bArr2, 1);
            bArr[i14] = bArr2;
            i14++;
        }
        byte[] bArr3 = new byte[5];
        bArr3[0] = -91;
        MessageDigest[] messageDigestArr = new MessageDigest[length];
        for (int i16 = 0; i16 < iArr.length; i16++) {
            String strZzd = zzd(iArr[i16]);
            try {
                messageDigestArr[i16] = MessageDigest.getInstance(strZzd);
            } catch (NoSuchAlgorithmException e11) {
                throw new RuntimeException(strZzd.concat(" digest not supported"), e11);
            }
        }
        int i17 = 0;
        int i18 = 0;
        for (i11 = 3; i17 < i11; i11 = 3) {
            zzaoz zzaozVar = zzaozVarArr[i17];
            long j13 = j12;
            long jZza2 = zzaozVar.zza();
            while (jZza2 > j12) {
                int iMin = (int) Math.min(jZza2, j11);
                zzg(iMin, bArr3, 1);
                for (int i19 = 0; i19 < length; i19++) {
                    messageDigestArr[i19].update(bArr3);
                }
                long j14 = j13;
                try {
                    zzaozVar.zzb(messageDigestArr, j14, iMin);
                    byte[] bArr4 = bArr3;
                    int i21 = 0;
                    while (i21 < iArr.length) {
                        int i22 = iArr[i21];
                        zzaoz zzaozVar2 = zzaozVar;
                        byte[] bArr5 = bArr[i21];
                        int iZzb = zzb(i22);
                        int i23 = length;
                        MessageDigest messageDigest = messageDigestArr[i21];
                        MessageDigest[] messageDigestArr2 = messageDigestArr;
                        int iDigest = messageDigest.digest(bArr5, (i18 * iZzb) + 5, iZzb);
                        if (iDigest != iZzb) {
                            throw new RuntimeException("Unexpected output size of " + messageDigest.getAlgorithm() + " digest: " + iDigest);
                        }
                        i21++;
                        zzaozVar = zzaozVar2;
                        length = i23;
                        messageDigestArr = messageDigestArr2;
                    }
                    long j15 = iMin;
                    long j16 = j14 + j15;
                    jZza2 -= j15;
                    i18++;
                    j12 = 0;
                    j11 = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
                    bArr3 = bArr4;
                    j13 = j16;
                    messageDigestArr = messageDigestArr;
                } catch (IOException e12) {
                    throw new DigestException("Failed to digest chunk #" + i18 + " of section #" + i12, e12);
                }
            }
            i12++;
            i17++;
            j12 = 0;
            j11 = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        }
        byte[][] bArr6 = new byte[iArr.length][];
        for (int i24 = 0; i24 < iArr.length; i24++) {
            int i25 = iArr[i24];
            byte[] bArr7 = bArr[i24];
            String strZzd2 = zzd(i25);
            try {
                bArr6[i24] = MessageDigest.getInstance(strZzd2).digest(bArr7);
            } catch (NoSuchAlgorithmException e13) {
                throw new RuntimeException(strZzd2.concat(" digest not supported"), e13);
            }
        }
        return bArr6;
    }

    private static X509Certificate[][] zzl(FileChannel fileChannel, zzapc zzapcVar) throws SecurityException {
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer byteBufferZzf = zzf(zzapcVar.zza);
                int i11 = 0;
                while (byteBufferZzf.hasRemaining()) {
                    i11++;
                    try {
                        arrayList.add(zzj(zzf(byteBufferZzf), map, certificateFactory));
                    } catch (IOException | SecurityException | BufferUnderflowException e11) {
                        throw new SecurityException("Failed to parse/verify signer #" + i11 + " block", e11);
                    }
                }
                if (i11 <= 0) {
                    throw new SecurityException("No signers found");
                }
                if (map.isEmpty()) {
                    throw new SecurityException("No content digests found");
                }
                zzh(map, fileChannel, zzapcVar.zzb, zzapcVar.zzc, zzapcVar.zzd, zzapcVar.zze);
                return (X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()][]);
            } catch (IOException e12) {
                throw new SecurityException("Failed to read list of signers", e12);
            }
        } catch (CertificateException e13) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e13);
        }
    }
}
