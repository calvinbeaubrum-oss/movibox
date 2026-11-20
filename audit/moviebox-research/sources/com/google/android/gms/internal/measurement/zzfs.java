package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfs extends zzkb implements zzln {
    private zzfs() {
        super(zzft.zza);
    }

    public /* synthetic */ zzfs(zzfk zzfkVar) {
        super(zzft.zza);
    }

    public final int zza() {
        return ((zzft) this.zza).zzb();
    }

    public final long zzb() {
        return ((zzft) this.zza).zzc();
    }

    public final long zzc() {
        return ((zzft) this.zza).zzd();
    }

    public final zzfs zzd(Iterable iterable) {
        zzaG();
        zzft.zzm((zzft) this.zza, iterable);
        return this;
    }

    public final zzfs zze(zzfw zzfwVar) {
        zzaG();
        zzft.zzk((zzft) this.zza, (zzfx) zzfwVar.zzaC());
        return this;
    }

    public final zzfs zzf(zzfx zzfxVar) {
        zzaG();
        zzft.zzk((zzft) this.zza, zzfxVar);
        return this;
    }

    public final zzfs zzg() {
        zzaG();
        ((zzft) this.zza).zze = zzkf.zzbE();
        return this;
    }

    public final zzfs zzh(int i11) {
        zzaG();
        zzft.zzo((zzft) this.zza, i11);
        return this;
    }

    public final zzfs zzi(String str) {
        zzaG();
        zzft.zzp((zzft) this.zza, str);
        return this;
    }

    public final zzfs zzj(int i11, zzfw zzfwVar) {
        zzaG();
        zzft.zzj((zzft) this.zza, i11, (zzfx) zzfwVar.zzaC());
        return this;
    }

    public final zzfs zzk(int i11, zzfx zzfxVar) {
        zzaG();
        zzft.zzj((zzft) this.zza, i11, zzfxVar);
        return this;
    }

    public final zzfs zzl(long j11) {
        zzaG();
        zzft.zzr((zzft) this.zza, j11);
        return this;
    }

    public final zzfs zzm(long j11) {
        zzaG();
        zzft.zzq((zzft) this.zza, j11);
        return this;
    }

    public final zzfx zzn(int i11) {
        return ((zzft) this.zza).zzg(i11);
    }

    public final String zzo() {
        return ((zzft) this.zza).zzh();
    }

    public final List zzp() {
        return Collections.unmodifiableList(((zzft) this.zza).zzi());
    }

    public final boolean zzq() {
        return ((zzft) this.zza).zzu();
    }
}
