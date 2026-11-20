package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgxm implements zzgse {
    private final ThreadLocal zza;
    private final String zzb;
    private final Key zzc;
    private final int zzd;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:24:0x005b  */
    public zzgxm(String str, Key key) throws GeneralSecurityException {
        byte b11;
        int i11;
        zzgxl zzgxlVar = new zzgxl(this);
        this.zza = zzgxlVar;
        if (!zzgmv.zza(2)) {
            throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
        }
        this.zzb = str;
        this.zzc = key;
        if (key.getEncoded().length < 16) {
            throw new InvalidAlgorithmParameterException("key size too small, need at least 16 bytes");
        }
        switch (str) {
            case "HMACSHA1":
                b11 = 0;
                break;
            case "HMACSHA224":
                b11 = 1;
                break;
            case "HMACSHA256":
                b11 = 2;
                break;
            case "HMACSHA384":
                b11 = 3;
                break;
            case "HMACSHA512":
                b11 = 4;
                break;
            default:
                b11 = -1;
                break;
        }
        if (b11 == 0) {
            i11 = 20;
        } else if (b11 == 1) {
            i11 = 28;
        } else if (b11 == 2) {
            i11 = 32;
        } else if (b11 == 3) {
            i11 = 48;
        } else {
            if (b11 != 4) {
                throw new NoSuchAlgorithmException("unknown Hmac algorithm: ".concat(str));
            }
            i11 = 64;
        }
        this.zzd = i11;
        zzgxlVar.get();
    }

    @Override // com.google.android.gms.internal.ads.zzgse
    public final byte[] zza(byte[] bArr, int i11) throws GeneralSecurityException {
        if (i11 > this.zzd) {
            throw new InvalidAlgorithmParameterException("tag size too big");
        }
        ((Mac) this.zza.get()).update(bArr);
        return Arrays.copyOf(((Mac) this.zza.get()).doFinal(), i11);
    }
}
