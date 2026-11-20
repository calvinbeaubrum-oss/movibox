package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzfb {
    public final Object zza;
    private zzaf zzb = new zzaf();
    private boolean zzc;
    private boolean zzd;

    public zzfb(Object obj) {
        this.zza = obj;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzfb.class != obj.getClass()) {
            return false;
        }
        return this.zza.equals(((zzfb) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zza(int i11, zzez zzezVar) {
        if (this.zzd) {
            return;
        }
        if (i11 != -1) {
            this.zzb.zza(i11);
        }
        this.zzc = true;
        zzezVar.zza(this.zza);
    }

    public final void zzb(zzfa zzfaVar) {
        if (this.zzd || !this.zzc) {
            return;
        }
        zzah zzahVarZzb = this.zzb.zzb();
        this.zzb = new zzaf();
        this.zzc = false;
        zzfaVar.zza(this.zza, zzahVarZzb);
    }

    public final void zzc(zzfa zzfaVar) {
        this.zzd = true;
        if (this.zzc) {
            this.zzc = false;
            zzfaVar.zza(this.zza, this.zzb.zzb());
        }
    }
}
