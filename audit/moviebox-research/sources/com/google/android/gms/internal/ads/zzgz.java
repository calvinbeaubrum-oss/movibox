package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgz {

    @Nullable
    private Uri zza;
    private Map zzb = Collections.emptyMap();
    private long zzc;
    private int zzd;

    public final zzgz zza(int i11) {
        this.zzd = 6;
        return this;
    }

    public final zzgz zzb(Map map) {
        this.zzb = map;
        return this;
    }

    public final zzgz zzc(long j11) {
        this.zzc = j11;
        return this;
    }

    public final zzgz zzd(Uri uri) {
        this.zza = uri;
        return this;
    }

    public final zzhb zze() {
        if (this.zza != null) {
            return new zzhb(this.zza, this.zzb, this.zzc, this.zzd);
        }
        throw new IllegalStateException("The uri must be set.");
    }
}
