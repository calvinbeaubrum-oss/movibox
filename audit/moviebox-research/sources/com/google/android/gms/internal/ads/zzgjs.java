package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgjs {
    private Integer zza;
    private zzgjt zzb;

    private zzgjs() {
        this.zza = null;
        throw null;
    }

    public /* synthetic */ zzgjs(zzgjr zzgjrVar) {
        this.zza = null;
        this.zzb = zzgjt.zzc;
    }

    public final zzgjs zza(int i11) throws GeneralSecurityException {
        if (i11 != 16 && i11 != 32) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte and 32-byte AES keys are supported", Integer.valueOf(i11)));
        }
        this.zza = Integer.valueOf(i11);
        return this;
    }

    public final zzgjs zzb(zzgjt zzgjtVar) {
        this.zzb = zzgjtVar;
        return this;
    }

    public final zzgjv zzc() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            throw new GeneralSecurityException("Key size is not set");
        }
        if (this.zzb != null) {
            return new zzgjv(num.intValue(), this.zzb, null);
        }
        throw new GeneralSecurityException("Variant is not set");
    }
}
