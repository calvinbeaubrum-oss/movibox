package com.google.android.gms.internal.ads;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgkp implements zzgfs {
    private static final byte[] zza = new byte[0];
    private static final Set zzb;
    private final zzguy zzc;
    private final zzgfs zzd;

    static {
        HashSet hashSet = new HashSet();
        hashSet.add("type.googleapis.com/google.crypto.tink.AesGcmKey");
        hashSet.add("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        hashSet.add("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        hashSet.add("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        hashSet.add("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        hashSet.add("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zzb = Collections.unmodifiableSet(hashSet);
    }

    @Deprecated
    public zzgkp(zzguy zzguyVar, zzgfs zzgfsVar) {
        if (zzb.contains(zzguyVar.zzh())) {
            this.zzc = zzguyVar;
            this.zzd = zzgfsVar;
            return;
        }
        throw new IllegalArgumentException("Unsupported DEK key type: " + zzguyVar.zzh() + ". Only Tink AEAD key types are supported.");
    }

    @Override // com.google.android.gms.internal.ads.zzgfs
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        try {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            int i11 = byteBufferWrap.getInt();
            if (i11 <= 0 || i11 > bArr.length - 4) {
                throw new GeneralSecurityException("invalid ciphertext");
            }
            byte[] bArr3 = new byte[i11];
            byteBufferWrap.get(bArr3, 0, i11);
            byte[] bArr4 = new byte[byteBufferWrap.remaining()];
            byteBufferWrap.get(bArr4, 0, byteBufferWrap.remaining());
            byte[] bArrZza = this.zzd.zza(bArr3, zza);
            String strZzh = this.zzc.zzh();
            int i12 = zzghb.zza;
            zzgyl zzgylVar = zzgyl.zzb;
            return ((zzgfs) zzghb.zzd(strZzh, zzgyl.zzv(bArrZza, 0, bArrZza.length), zzgfs.class)).zza(bArr4, bArr2);
        } catch (IndexOutOfBoundsException e11) {
            e = e11;
            throw new GeneralSecurityException("invalid ciphertext", e);
        } catch (NegativeArraySizeException e12) {
            e = e12;
            throw new GeneralSecurityException("invalid ciphertext", e);
        } catch (BufferUnderflowException e13) {
            e = e13;
            throw new GeneralSecurityException("invalid ciphertext", e);
        }
    }
}
