package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzci {
    private final zzaf zza = new zzaf();

    public final zzci zza(int i11) {
        this.zza.zza(i11);
        return this;
    }

    public final zzci zzb(zzck zzckVar) {
        zzah zzahVar = zzckVar.zzd;
        for (int i11 = 0; i11 < zzahVar.zzb(); i11++) {
            this.zza.zza(zzahVar.zza(i11));
        }
        return this;
    }

    public final zzci zzc(int... iArr) {
        for (int i11 = 0; i11 < 20; i11++) {
            this.zza.zza(iArr[i11]);
        }
        return this;
    }

    public final zzci zzd(int i11, boolean z11) {
        if (z11) {
            this.zza.zza(i11);
        }
        return this;
    }

    public final zzck zze() {
        return new zzck(this.zza.zzb(), null);
    }
}
