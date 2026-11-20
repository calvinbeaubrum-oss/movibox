package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzghe {
    public static zzggq zza(byte[] bArr) throws GeneralSecurityException {
        try {
            zzguy zzguyVarZze = zzguy.zze(bArr, zzgzf.zza());
            zzgoe zzgoeVarZzd = zzgoe.zzd();
            zzgoy zzgoyVarZza = zzgoy.zza(zzguyVarZze);
            return !zzgoeVarZzd.zzk(zzgoyVarZza) ? new zzgnp(zzgoyVarZza) : zzgoeVarZzd.zzc(zzgoyVarZza);
        } catch (IOException e11) {
            throw new GeneralSecurityException("Failed to parse proto", e11);
        }
    }

    public static byte[] zzb(zzggq zzggqVar) throws GeneralSecurityException {
        return ((zzgoy) zzgoe.zzd().zzf(zzggqVar, zzgoy.class)).zzc().zzax();
    }
}
