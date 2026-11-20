package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgxk implements zzgse {
    private final SecretKey zza;
    private final byte[] zzb;
    private final byte[] zzc;

    public zzgxk(byte[] bArr) throws GeneralSecurityException {
        zzgxo.zza(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.zza = secretKeySpec;
        Cipher cipherZzb = zzb();
        cipherZzb.init(1, secretKeySpec);
        byte[] bArrZza = zzgrl.zza(cipherZzb.doFinal(new byte[16]));
        this.zzb = bArrZza;
        this.zzc = zzgrl.zza(bArrZza);
    }

    private static Cipher zzb() throws GeneralSecurityException {
        if (zzgmv.zza(1)) {
            return (Cipher) zzgwz.zza.zza("AES/ECB/NoPadding");
        }
        throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
    }

    @Override // com.google.android.gms.internal.ads.zzgse
    public final byte[] zza(byte[] bArr, int i11) throws GeneralSecurityException {
        byte[] bArrZzc;
        if (i11 > 16) {
            throw new InvalidAlgorithmParameterException("outputLength too large, max is 16 bytes");
        }
        SecretKey secretKey = this.zza;
        Cipher cipherZzb = zzb();
        cipherZzb.init(1, secretKey);
        int length = bArr.length;
        int iMax = Math.max(1, (int) Math.ceil(((double) length) / 16.0d));
        int i12 = iMax - 1;
        int i13 = i12 * 16;
        if (iMax * 16 == length) {
            bArrZzc = zzgwp.zzd(bArr, i13, this.zzb, 0, 16);
        } else {
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i13, length);
            int length2 = bArrCopyOfRange.length;
            if (length2 >= 16) {
                throw new IllegalArgumentException("x must be smaller than a block.");
            }
            byte[] bArrCopyOf = Arrays.copyOf(bArrCopyOfRange, 16);
            bArrCopyOf[length2] = -128;
            bArrZzc = zzgwp.zzc(bArrCopyOf, this.zzc);
        }
        byte[] bArrDoFinal = new byte[16];
        for (int i14 = 0; i14 < i12; i14++) {
            bArrDoFinal = cipherZzb.doFinal(zzgwp.zzd(bArrDoFinal, 0, bArr, i14 * 16, 16));
        }
        return Arrays.copyOf(cipherZzb.doFinal(zzgwp.zzc(bArrZzc, bArrDoFinal)), i11);
    }
}
