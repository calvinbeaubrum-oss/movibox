package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzri implements zzpy {
    final /* synthetic */ zzrj zza;

    public /* synthetic */ zzri(zzrj zzrjVar, zzrh zzrhVar) {
        this.zza = zzrjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzpy
    public final void zza(Exception exc) {
        zzff.zzd("MediaCodecAudioRenderer", "Audio sink error", exc);
        this.zza.zzc.zzb(exc);
    }

    @Override // com.google.android.gms.internal.ads.zzpy
    public final void zzb() {
        zzrj zzrjVar = this.zza;
        if (zzrjVar.zzm != null) {
            zzrjVar.zzm.zzb();
        }
    }
}
