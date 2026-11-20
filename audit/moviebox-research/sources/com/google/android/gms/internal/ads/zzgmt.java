package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzgmt extends ThreadLocal {
    public static final Cipher zza() {
        try {
            Cipher cipher = (Cipher) zzgwz.zza.zza("AES/GCM-SIV/NoPadding");
            if (zzgmu.zze(cipher)) {
                return cipher;
            }
            return null;
        } catch (GeneralSecurityException e11) {
            throw new IllegalStateException(e11);
        }
    }

    @Override // java.lang.ThreadLocal
    public final /* bridge */ /* synthetic */ Object initialValue() {
        return zza();
    }
}
