package com.google.android.gms.internal.ads;

import android.os.Handler;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzua extends zzts {
    private final HashMap zza = new HashMap();

    @Nullable
    private Handler zzb;

    @Nullable
    private zzhy zzc;

    public abstract void zzA(Object obj, zzut zzutVar, zzcx zzcxVar);

    public final void zzB(final Object obj, zzut zzutVar) {
        zzek.zzd(!this.zza.containsKey(obj));
        zzus zzusVar = new zzus() { // from class: com.google.android.gms.internal.ads.zztx
            @Override // com.google.android.gms.internal.ads.zzus
            public final void zza(zzut zzutVar2, zzcx zzcxVar) {
                this.zza.zzA(obj, zzutVar2, zzcxVar);
            }
        };
        zzty zztyVar = new zzty(this, obj);
        this.zza.put(obj, new zztz(zzutVar, zzusVar, zztyVar));
        Handler handler = this.zzb;
        handler.getClass();
        zzutVar.zzh(handler, zztyVar);
        Handler handler2 = this.zzb;
        handler2.getClass();
        zzutVar.zzg(handler2, zztyVar);
        zzutVar.zzm(zzusVar, this.zzc, zzb());
        if (zzu()) {
            return;
        }
        zzutVar.zzi(zzusVar);
    }

    @Override // com.google.android.gms.internal.ads.zzts
    @CallSuper
    public final void zzj() {
        for (zztz zztzVar : this.zza.values()) {
            zztzVar.zza.zzi(zztzVar.zzb);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzts
    @CallSuper
    public final void zzl() {
        for (zztz zztzVar : this.zza.values()) {
            zztzVar.zza.zzk(zztzVar.zzb);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzts
    @CallSuper
    public void zzn(@Nullable zzhy zzhyVar) {
        this.zzc = zzhyVar;
        this.zzb = zzfy.zzw(null);
    }

    @Override // com.google.android.gms.internal.ads.zzts
    @CallSuper
    public void zzq() {
        for (zztz zztzVar : this.zza.values()) {
            zztzVar.zza.zzp(zztzVar.zzb);
            zztzVar.zza.zzs(zztzVar.zzc);
            zztzVar.zza.zzr(zztzVar.zzc);
        }
        this.zza.clear();
    }

    public int zzw(Object obj, int i11) {
        return 0;
    }

    public long zzx(Object obj, long j11, @Nullable zzur zzurVar) {
        return j11;
    }

    @Nullable
    public zzur zzy(Object obj, zzur zzurVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzut
    @CallSuper
    public void zzz() throws IOException {
        Iterator it = this.zza.values().iterator();
        while (it.hasNext()) {
            ((zztz) it.next()).zza.zzz();
        }
    }
}
