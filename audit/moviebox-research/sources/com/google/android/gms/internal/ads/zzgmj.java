package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgmj extends zzgmk {
    public zzgmj(byte[] bArr) throws GeneralSecurityException {
        super(bArr);
    }

    @Override // com.google.android.gms.internal.ads.zzgmk
    public final zzgmi zza(byte[] bArr, int i11) throws InvalidKeyException {
        return new zzgmh(bArr, i11);
    }
}
