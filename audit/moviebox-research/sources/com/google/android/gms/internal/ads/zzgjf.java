package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgjf {
    private Integer zza;
    private Integer zzb;
    private Integer zzc;
    private zzgjg zzd;

    private zzgjf() {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        throw null;
    }

    public /* synthetic */ zzgjf(zzgje zzgjeVar) {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        this.zzd = zzgjg.zzc;
    }

    public final zzgjf zza(int i11) throws GeneralSecurityException {
        this.zzb = 12;
        return this;
    }

    public final zzgjf zzb(int i11) throws GeneralSecurityException {
        if (i11 != 16 && i11 != 24 && i11 != 32) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", Integer.valueOf(i11)));
        }
        this.zza = Integer.valueOf(i11);
        return this;
    }

    public final zzgjf zzc(int i11) throws GeneralSecurityException {
        this.zzc = 16;
        return this;
    }

    public final zzgjf zzd(zzgjg zzgjgVar) {
        this.zzd = zzgjgVar;
        return this;
    }

    public final zzgji zze() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            throw new GeneralSecurityException("Key size is not set");
        }
        if (this.zzd == null) {
            throw new GeneralSecurityException("Variant is not set");
        }
        if (this.zzb == null) {
            throw new GeneralSecurityException("IV size is not set");
        }
        if (this.zzc == null) {
            throw new GeneralSecurityException("Tag size is not set");
        }
        int iIntValue = num.intValue();
        this.zzb.intValue();
        this.zzc.intValue();
        return new zzgji(iIntValue, 12, 16, this.zzd, null);
    }
}
