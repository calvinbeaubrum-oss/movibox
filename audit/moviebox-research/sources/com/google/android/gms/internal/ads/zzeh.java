package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzeh {
    private static final String zzc = Integer.toString(0, 36);
    private static final String zzd = Integer.toString(1, 36);
    public final String zza;
    public final int zzb;

    public zzeh(String str, int i11) {
        this.zza = str;
        this.zzb = i11;
    }

    public final Bundle zza() {
        Bundle bundle = new Bundle();
        bundle.putString(zzc, this.zza);
        bundle.putInt(zzd, this.zzb);
        return bundle;
    }
}
