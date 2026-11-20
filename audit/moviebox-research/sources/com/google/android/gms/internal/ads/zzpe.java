package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzpe {
    private boolean zza;
    private boolean zzb;
    private boolean zzc;

    public final zzpe zza(boolean z11) {
        this.zza = true;
        return this;
    }

    public final zzpe zzb(boolean z11) {
        this.zzb = z11;
        return this;
    }

    public final zzpe zzc(boolean z11) {
        this.zzc = z11;
        return this;
    }

    public final zzpg zzd() {
        if (this.zza || !(this.zzb || this.zzc)) {
            return new zzpg(this, null);
        }
        throw new IllegalStateException("Secondary offload attribute fields are true but primary isFormatSupported is false");
    }
}
