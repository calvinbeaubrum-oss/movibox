package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgwk implements zzgxj {
    private static final ThreadLocal zza = new zzgwj();
    private final SecretKeySpec zzb;
    private final int zzc;
    private final int zzd;

    public zzgwk(byte[] bArr, int i11) throws GeneralSecurityException {
        if (!zzgmv.zza(2)) {
            throw new GeneralSecurityException("Can not use AES-CTR in FIPS-mode, as BoringCrypto module is not available.");
        }
        zzgxo.zza(bArr.length);
        this.zzb = new SecretKeySpec(bArr, "AES");
        int blockSize = ((Cipher) zza.get()).getBlockSize();
        this.zzd = blockSize;
        if (i11 > blockSize) {
            throw new GeneralSecurityException("invalid IV size");
        }
        this.zzc = i11;
    }

    @Override // com.google.android.gms.internal.ads.zzgxj
    public final byte[] zza(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i11 = this.zzc;
        if (length < i11) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        byte[] bArr2 = new byte[i11];
        System.arraycopy(bArr, 0, bArr2, 0, i11);
        int i12 = this.zzc;
        int i13 = length - i12;
        byte[] bArr3 = new byte[i13];
        Cipher cipher = (Cipher) zza.get();
        byte[] bArr4 = new byte[this.zzd];
        System.arraycopy(bArr2, 0, bArr4, 0, this.zzc);
        cipher.init(2, this.zzb, new IvParameterSpec(bArr4));
        if (cipher.doFinal(bArr, i12, i13, bArr3, 0) == i13) {
            return bArr3;
        }
        throw new GeneralSecurityException("stored output's length does not match input's length");
    }
}
