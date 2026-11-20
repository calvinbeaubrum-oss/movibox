package com.google.android.gms.internal.ads;

import android.util.Base64;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfhw {
    public zzfhw() {
        try {
            zzghg.zza();
        } catch (GeneralSecurityException e11) {
            com.google.android.gms.ads.internal.util.zze.zza("Failed to Configure Aead. ".concat(e11.toString()));
            com.google.android.gms.ads.internal.zzt.zzo().zzw(e11, "CryptoUtils.registerAead");
        }
    }

    public static final String zza() {
        zzgyi zzgyiVarZzt = zzgyl.zzt();
        try {
            zzgfv.zzb(zzggm.zzc(zzggf.zza(zzgoa.zzb().zza("AES128_GCM"))), zzgfu.zzb(zzgyiVarZzt));
        } catch (IOException | GeneralSecurityException e11) {
            com.google.android.gms.ads.internal.util.zze.zza("Failed to generate key".concat(e11.toString()));
            com.google.android.gms.ads.internal.zzt.zzo().zzw(e11, "CryptoUtils.generateKey");
        }
        String strEncodeToString = Base64.encodeToString(zzgyiVarZzt.zzb().zzA(), 11);
        zzgyiVarZzt.zzc();
        return strEncodeToString;
    }

    public static final String zzb(byte[] bArr, byte[] bArr2, String str, zzdwa zzdwaVar) {
        zzggm zzggmVarZzc = zzc(str);
        if (zzggmVarZzc == null) {
            return null;
        }
        try {
            byte[] bArrZza = ((zzgfs) zzggmVarZzc.zze(zzgpb.zza(), zzgfs.class)).zza(bArr, bArr2);
            zzdwaVar.zza().put("ds", "1");
            return new String(bArrZza, "UTF-8");
        } catch (UnsupportedEncodingException | UnsupportedOperationException | GeneralSecurityException e11) {
            com.google.android.gms.ads.internal.util.zze.zza("Failed to decrypt ".concat(e11.toString()));
            com.google.android.gms.ads.internal.zzt.zzo().zzw(e11, "CryptoUtils.decrypt");
            zzdwaVar.zza().put("dsf", e11.toString());
            return null;
        }
    }

    private static final zzggm zzc(String str) {
        try {
            return zzgfv.zza(zzgft.zzb(Base64.decode(str, 11)));
        } catch (IOException | GeneralSecurityException e11) {
            com.google.android.gms.ads.internal.util.zze.zza("Failed to get keysethandle".concat(e11.toString()));
            com.google.android.gms.ads.internal.zzt.zzo().zzw(e11, "CryptoUtils.getHandle");
            return null;
        }
    }
}
