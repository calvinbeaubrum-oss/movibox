package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzchj extends zzari {
    static final zzchj zzb = new zzchj();

    @Override // com.google.android.gms.internal.ads.zzari
    public final zzarm zza(String str, byte[] bArr, String str2) {
        if ("moov".equals(str)) {
            return new zzaro();
        }
        return "mvhd".equals(str) ? new zzarp() : new zzarq(str);
    }
}
