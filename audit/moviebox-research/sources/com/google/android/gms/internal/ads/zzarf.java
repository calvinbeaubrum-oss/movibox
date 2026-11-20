package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.File;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzarf implements zzaqv {
    final /* synthetic */ Context zza;
    private File zzb = null;

    public zzarf(Context context) {
        this.zza = context;
    }

    @Override // com.google.android.gms.internal.ads.zzaqv
    public final File zza() {
        if (this.zzb == null) {
            this.zzb = new File(this.zza.getCacheDir(), "volley");
        }
        return this.zzb;
    }
}
