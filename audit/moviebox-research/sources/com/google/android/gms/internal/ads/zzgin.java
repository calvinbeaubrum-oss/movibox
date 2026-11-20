package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgin {
    private Integer zza;
    private Integer zzb;
    private Integer zzc;
    private zzgio zzd;

    private zzgin() {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        throw null;
    }

    public /* synthetic */ zzgin(zzgim zzgimVar) {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        this.zzd = zzgio.zzc;
    }

    public final zzgin zza(int i11) throws GeneralSecurityException {
        if (i11 != 12 && i11 != 16) {
            throw new GeneralSecurityException(String.format("Invalid IV size in bytes %d; acceptable values have 12 or 16 bytes", Integer.valueOf(i11)));
        }
        this.zzb = Integer.valueOf(i11);
        return this;
    }

    public final zzgin zzb(int i11) throws GeneralSecurityException {
        if (i11 != 16 && i11 != 24 && i11 != 32) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", Integer.valueOf(i11)));
        }
        this.zza = Integer.valueOf(i11);
        return this;
    }

    public final zzgin zzc(int i11) throws GeneralSecurityException {
        this.zzc = 16;
        return this;
    }

    public final zzgin zzd(zzgio zzgioVar) {
        this.zzd = zzgioVar;
        return this;
    }

    public final zzgiq zze() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            throw new GeneralSecurityException("Key size is not set");
        }
        if (this.zzb == null) {
            throw new GeneralSecurityException("IV size is not set");
        }
        if (this.zzd == null) {
            throw new GeneralSecurityException("Variant is not set");
        }
        if (this.zzc == null) {
            throw new GeneralSecurityException("Tag size is not set");
        }
        int iIntValue = num.intValue();
        int iIntValue2 = this.zzb.intValue();
        this.zzc.intValue();
        return new zzgiq(iIntValue, iIntValue2, 16, this.zzd, null);
    }
}
