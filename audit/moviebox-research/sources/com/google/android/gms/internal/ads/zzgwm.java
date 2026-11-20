package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzgwm extends ThreadLocal {
    public static final Cipher zza() {
        try {
            return (Cipher) zzgwz.zza.zza("AES/CTR/NOPADDING");
        } catch (GeneralSecurityException e11) {
            throw new IllegalStateException(e11);
        }
    }

    @Override // java.lang.ThreadLocal
    public final /* bridge */ /* synthetic */ Object initialValue() {
        return zza();
    }
}
