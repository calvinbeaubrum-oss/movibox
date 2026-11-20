package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgwr implements zzgfs {
    private final zzgxj zza;
    private final zzggp zzb;
    private final int zzc;
    private final byte[] zzd;

    private zzgwr(zzgxj zzgxjVar, zzggp zzggpVar, int i11, byte[] bArr) {
        this.zza = zzgxjVar;
        this.zzb = zzggpVar;
        this.zzc = i11;
        this.zzd = bArr;
    }

    public static zzgfs zzb(zzghp zzghpVar) throws GeneralSecurityException {
        zzgwk zzgwkVar = new zzgwk(zzghpVar.zzc().zzd(zzggb.zza()), zzghpVar.zza().zzd());
        String strValueOf = String.valueOf(zzghpVar.zza().zzf());
        return new zzgwr(zzgwkVar, new zzgxn(new zzgxm("HMAC".concat(strValueOf), new SecretKeySpec(zzghpVar.zzd().zzd(zzggb.zza()), "HMAC")), zzghpVar.zza().zze()), zzghpVar.zza().zze(), zzghpVar.zzb().zzc());
    }

    @Override // com.google.android.gms.internal.ads.zzgfs
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzd;
        int i11 = this.zzc;
        int length = bArr3.length;
        int length2 = bArr.length;
        if (length2 < i11 + length) {
            throw new GeneralSecurityException("Decryption failed (ciphertext too short).");
        }
        if (!zzgpm.zzb(bArr3, bArr)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, this.zzd.length, length2 - this.zzc);
        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr, length2 - this.zzc, length2);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        if (MessageDigest.isEqual(((zzgxn) this.zzb).zzc(zzgwp.zzb(bArr2, bArrCopyOfRange, Arrays.copyOf(ByteBuffer.allocate(8).putLong(((long) bArr2.length) * 8).array(), 8))), bArrCopyOfRange2)) {
            return this.zza.zza(bArrCopyOfRange);
        }
        throw new GeneralSecurityException("invalid MAC");
    }
}
