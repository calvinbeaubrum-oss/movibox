package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgix {
    private zzgji zza = null;
    private zzgxr zzb = null;
    private Integer zzc = null;

    private zzgix() {
    }

    public /* synthetic */ zzgix(zzgiw zzgiwVar) {
    }

    public final zzgix zza(Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzgix zzb(zzgxr zzgxrVar) {
        this.zzb = zzgxrVar;
        return this;
    }

    public final zzgix zzc(zzgji zzgjiVar) {
        this.zza = zzgjiVar;
        return this;
    }

    public final zzgiz zzd() throws GeneralSecurityException {
        zzgxr zzgxrVar;
        zzgxq zzgxqVarZzb;
        zzgji zzgjiVar = this.zza;
        if (zzgjiVar == null || (zzgxrVar = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (zzgjiVar.zzb() != zzgxrVar.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (zzgjiVar.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.zza.zza() && this.zzc != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (this.zza.zzd() == zzgjg.zzc) {
            zzgxqVarZzb = zzgxq.zzb(new byte[0]);
        } else if (this.zza.zzd() == zzgjg.zzb) {
            zzgxqVarZzb = zzgxq.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
        } else {
            if (this.zza.zzd() != zzgjg.zza) {
                throw new IllegalStateException("Unknown AesGcmParameters.Variant: ".concat(String.valueOf(this.zza.zzd())));
            }
            zzgxqVarZzb = zzgxq.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
        }
        return new zzgiz(this.zza, this.zzb, zzgxqVarZzb, this.zzc, null);
    }
}
