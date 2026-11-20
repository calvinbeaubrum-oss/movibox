package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.AEADBadTagException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgwn implements zzgfs {
    private static final ThreadLocal zza = new zzgwl();
    private static final ThreadLocal zzb = new zzgwm();
    private final byte[] zzc;
    private final byte[] zzd;
    private final byte[] zze;
    private final SecretKeySpec zzf;
    private final int zzg;

    private zzgwn(byte[] bArr, int i11, byte[] bArr2) throws GeneralSecurityException {
        if (!zzgmv.zza(1)) {
            throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
        }
        if (i11 != 12 && i11 != 16) {
            throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
        }
        this.zzg = i11;
        zzgxo.zza(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.zzf = secretKeySpec;
        Cipher cipher = (Cipher) zza.get();
        cipher.init(1, secretKeySpec);
        byte[] bArrZzc = zzc(cipher.doFinal(new byte[16]));
        this.zzc = bArrZzc;
        this.zzd = zzc(bArrZzc);
        this.zze = bArr2;
    }

    public static zzgfs zzb(zzgii zzgiiVar) throws GeneralSecurityException {
        if (!zzgmv.zza(1)) {
            throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
        }
        zzgiiVar.zza();
        return new zzgwn(zzgiiVar.zzc().zzd(zzggb.zza()), zzgiiVar.zza().zzb(), zzgiiVar.zzb().zzc());
    }

    private static byte[] zzc(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i11 = 0;
        while (i11 < 15) {
            byte b11 = bArr[i11];
            int i12 = i11 + 1;
            bArr2[i11] = (byte) (((b11 + b11) ^ ((bArr[i12] & 255) >>> 7)) & 255);
            i11 = i12;
        }
        byte b12 = bArr[15];
        bArr2[15] = (byte) (((bArr[0] >> 7) & TsExtractor.TS_STREAM_TYPE_E_AC3) ^ (b12 + b12));
        return bArr2;
    }

    private final byte[] zzd(Cipher cipher, int i11, byte[] bArr, int i12, int i13) throws BadPaddingException, IllegalBlockSizeException {
        int length;
        byte[] bArrZzf;
        byte[] bArr2 = new byte[16];
        bArr2[15] = (byte) i11;
        if (i13 == 0) {
            return cipher.doFinal(zzf(bArr2, this.zzc));
        }
        byte[] bArrDoFinal = cipher.doFinal(bArr2);
        int i14 = 0;
        int i15 = 0;
        while (i13 - i15 > 16) {
            for (int i16 = 0; i16 < 16; i16++) {
                bArrDoFinal[i16] = (byte) (bArr[(i12 + i15) + i16] ^ bArrDoFinal[i16]);
            }
            bArrDoFinal = cipher.doFinal(bArrDoFinal);
            i15 += 16;
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i15 + i12, i12 + i13);
        if (bArrCopyOfRange.length == 16) {
            bArrZzf = zzf(bArrCopyOfRange, this.zzc);
        } else {
            byte[] bArrCopyOf = Arrays.copyOf(this.zzd, 16);
            while (true) {
                length = bArrCopyOfRange.length;
                if (i14 >= length) {
                    break;
                }
                bArrCopyOf[i14] = (byte) (bArrCopyOf[i14] ^ bArrCopyOfRange[i14]);
                i14++;
            }
            bArrCopyOf[length] = (byte) (bArrCopyOf[length] ^ 128);
            bArrZzf = bArrCopyOf;
        }
        return cipher.doFinal(zzf(bArrDoFinal, bArrZzf));
    }

    private final byte[] zze(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i11 = (length - this.zzg) - 16;
        if (i11 < 0) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        Cipher cipher = (Cipher) zza.get();
        cipher.init(1, this.zzf);
        byte[] bArrZzd = zzd(cipher, 0, bArr, 0, this.zzg);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        byte[] bArr3 = bArr2;
        byte[] bArrZzd2 = zzd(cipher, 1, bArr3, 0, bArr3.length);
        byte[] bArrZzd3 = zzd(cipher, 2, bArr, this.zzg, i11);
        int i12 = length - 16;
        byte b11 = 0;
        for (int i13 = 0; i13 < 16; i13++) {
            b11 = (byte) (b11 | (((bArr[i12 + i13] ^ bArrZzd2[i13]) ^ bArrZzd[i13]) ^ bArrZzd3[i13]));
        }
        if (b11 != 0) {
            throw new AEADBadTagException("tag mismatch");
        }
        Cipher cipher2 = (Cipher) zzb.get();
        cipher2.init(1, this.zzf, new IvParameterSpec(bArrZzd));
        return cipher2.doFinal(bArr, this.zzg, i11);
    }

    private static byte[] zzf(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i11 = 0; i11 < length; i11++) {
            bArr3[i11] = (byte) (bArr[i11] ^ bArr2[i11]);
        }
        return bArr3;
    }

    @Override // com.google.android.gms.internal.ads.zzgfs
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zze;
        if (bArr3.length == 0) {
            return zze(bArr, bArr2);
        }
        if (!zzgpm.zzb(bArr3, bArr)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        byte[] bArr4 = this.zze;
        return zze(Arrays.copyOfRange(bArr, bArr4.length, bArr.length), bArr2);
    }
}
