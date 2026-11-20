package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcia extends zzchw {
    public zzcia(zzcgl zzcglVar) {
        super(zzcglVar);
    }

    @Override // com.google.android.gms.internal.ads.zzchw
    public final void zzf() {
    }

    @Override // com.google.android.gms.internal.ads.zzchw
    public final boolean zzt(String str) {
        String strZze = zzcdv.zze(str);
        zzcgl zzcglVar = (zzcgl) this.zzc.get();
        if (zzcglVar != null && strZze != null) {
            zzcglVar.zzt(strZze, this);
        }
        zzcec.zzj("VideoStreamNoopCache is doing nothing.");
        zzg(str, strZze, "noop", "Noop cache is a noop.");
        return false;
    }
}
