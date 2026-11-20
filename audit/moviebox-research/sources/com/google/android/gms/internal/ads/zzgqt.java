package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgqt {
    private Integer zza;
    private Integer zzb;
    private zzgqu zzc;
    private zzgqv zzd;

    private zzgqt() {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        throw null;
    }

    public /* synthetic */ zzgqt(zzgqs zzgqsVar) {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        this.zzd = zzgqv.zzd;
    }

    public final zzgqt zza(zzgqu zzgquVar) {
        this.zzc = zzgquVar;
        return this;
    }

    public final zzgqt zzb(int i11) throws GeneralSecurityException {
        this.zza = Integer.valueOf(i11);
        return this;
    }

    public final zzgqt zzc(int i11) throws GeneralSecurityException {
        this.zzb = Integer.valueOf(i11);
        return this;
    }

    public final zzgqt zzd(zzgqv zzgqvVar) {
        this.zzd = zzgqvVar;
        return this;
    }

    public final zzgqx zze() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            throw new GeneralSecurityException("key size is not set");
        }
        if (this.zzb == null) {
            throw new GeneralSecurityException("tag size is not set");
        }
        if (this.zzc == null) {
            throw new GeneralSecurityException("hash type is not set");
        }
        if (this.zzd == null) {
            throw new GeneralSecurityException("variant is not set");
        }
        if (num.intValue() < 16) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size in bytes %d; must be at least 16 bytes", this.zza));
        }
        int iIntValue = this.zzb.intValue();
        zzgqu zzgquVar = this.zzc;
        if (iIntValue < 10) {
            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; must be at least 10 bytes", Integer.valueOf(iIntValue)));
        }
        if (zzgquVar == zzgqu.zza) {
            if (iIntValue > 20) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 20 bytes for SHA1", Integer.valueOf(iIntValue)));
            }
        } else if (zzgquVar == zzgqu.zzb) {
            if (iIntValue > 28) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 28 bytes for SHA224", Integer.valueOf(iIntValue)));
            }
        } else if (zzgquVar == zzgqu.zzc) {
            if (iIntValue > 32) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 32 bytes for SHA256", Integer.valueOf(iIntValue)));
            }
        } else if (zzgquVar == zzgqu.zzd) {
            if (iIntValue > 48) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 48 bytes for SHA384", Integer.valueOf(iIntValue)));
            }
        } else {
            if (zzgquVar != zzgqu.zze) {
                throw new GeneralSecurityException("unknown hash type; must be SHA256, SHA384 or SHA512");
            }
            if (iIntValue > 64) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 64 bytes for SHA512", Integer.valueOf(iIntValue)));
            }
        }
        return new zzgqx(this.zza.intValue(), this.zzb.intValue(), this.zzd, this.zzc, null);
    }
}
