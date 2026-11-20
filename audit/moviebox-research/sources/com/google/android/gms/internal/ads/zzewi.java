package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.s;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzewi implements zzexq {
    private final String zza;
    private final String zzb;

    public zzewi(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final int zza() {
        return 31;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final s zzb() {
        return zzgen.zzh(new zzewj(this.zza, this.zzb));
    }
}
