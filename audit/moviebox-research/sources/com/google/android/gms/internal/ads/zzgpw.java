package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgpw {
    private Integer zza;
    private Integer zzb;
    private zzgpx zzc;

    private zzgpw() {
        this.zza = null;
        this.zzb = null;
        throw null;
    }

    public /* synthetic */ zzgpw(zzgpv zzgpvVar) {
        this.zza = null;
        this.zzb = null;
        this.zzc = zzgpx.zzd;
    }

    public final zzgpw zza(int i11) throws GeneralSecurityException {
        if (i11 != 16 && i11 != 32) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 128-bit and 256-bit AES keys are supported", Integer.valueOf(i11 * 8)));
        }
        this.zza = Integer.valueOf(i11);
        return this;
    }

    public final zzgpw zzb(int i11) throws GeneralSecurityException {
        if (i11 >= 10 && i11 <= 16) {
            this.zzb = Integer.valueOf(i11);
            return this;
        }
        throw new GeneralSecurityException("Invalid tag size for AesCmacParameters: " + i11);
    }

    public final zzgpw zzc(zzgpx zzgpxVar) {
        this.zzc = zzgpxVar;
        return this;
    }

    public final zzgpz zzd() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            throw new GeneralSecurityException("key size not set");
        }
        if (this.zzb == null) {
            throw new GeneralSecurityException("tag size not set");
        }
        if (this.zzc != null) {
            return new zzgpz(num.intValue(), this.zzb.intValue(), this.zzc, null);
        }
        throw new GeneralSecurityException("variant not set");
    }
}
