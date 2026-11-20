package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class zzena extends zzeob {
    private final zzdjd zza;

    public zzena(zzdav zzdavVar, zzdis zzdisVar, zzdbp zzdbpVar, zzdce zzdceVar, zzdcj zzdcjVar, zzdbk zzdbkVar, zzdfr zzdfrVar, zzdjk zzdjkVar, zzddd zzdddVar, zzdjd zzdjdVar, zzdfn zzdfnVar) {
        super(zzdavVar, zzdisVar, zzdbpVar, zzdceVar, zzdcjVar, zzdfrVar, zzdddVar, zzdjkVar, zzdfnVar, zzdbkVar);
        this.zza = zzdjdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeob, com.google.android.gms.internal.ads.zzbtb
    public final void zzs(zzcag zzcagVar) {
        this.zza.zza(zzcagVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeob, com.google.android.gms.internal.ads.zzbtb
    public final void zzt(zzcak zzcakVar) throws RemoteException {
        this.zza.zza(new zzcag(zzcakVar.zzf(), zzcakVar.zze()));
    }

    @Override // com.google.android.gms.internal.ads.zzeob, com.google.android.gms.internal.ads.zzbtb
    public final void zzu() throws RemoteException {
        this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzeob, com.google.android.gms.internal.ads.zzbtb
    public final void zzv() {
        this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzeob, com.google.android.gms.internal.ads.zzbtb
    public final void zzy() {
        this.zza.zzc();
    }
}
