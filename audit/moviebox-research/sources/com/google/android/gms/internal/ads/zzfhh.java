package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfhh {

    @Nullable
    public final com.google.android.gms.ads.internal.client.zzfk zza;

    @Nullable
    public final zzbpp zzb;

    @Nullable
    public final zzeqe zzc;
    public final com.google.android.gms.ads.internal.client.zzl zzd;
    public final com.google.android.gms.ads.internal.client.zzq zze;
    public final String zzf;
    public final ArrayList zzg;
    public final ArrayList zzh;
    public final zzbjb zzi;
    public final com.google.android.gms.ads.internal.client.zzw zzj;
    public final int zzk;
    public final AdManagerAdViewOptions zzl;
    public final PublisherAdViewOptions zzm;
    public final com.google.android.gms.ads.internal.client.zzcb zzn;
    public final zzfgu zzo;
    public final boolean zzp;
    public final boolean zzq;

    @Nullable
    public final com.google.android.gms.ads.internal.client.zzcf zzr;

    public /* synthetic */ zzfhh(zzfhf zzfhfVar, zzfhg zzfhgVar) {
        this.zze = zzfhfVar.zzb;
        this.zzf = zzfhfVar.zzc;
        this.zzr = zzfhfVar.zzs;
        int i11 = zzfhfVar.zza.zza;
        long j11 = zzfhfVar.zza.zzb;
        Bundle bundle = zzfhfVar.zza.zzc;
        int i12 = zzfhfVar.zza.zzd;
        List list = zzfhfVar.zza.zze;
        boolean z11 = zzfhfVar.zza.zzf;
        int i13 = zzfhfVar.zza.zzg;
        boolean z12 = true;
        if (!zzfhfVar.zza.zzh && !zzfhfVar.zze) {
            z12 = false;
        }
        this.zzd = new com.google.android.gms.ads.internal.client.zzl(i11, j11, bundle, i12, list, z11, i13, z12, zzfhfVar.zza.zzi, zzfhfVar.zza.zzj, zzfhfVar.zza.zzk, zzfhfVar.zza.zzl, zzfhfVar.zza.zzm, zzfhfVar.zza.zzn, zzfhfVar.zza.zzo, zzfhfVar.zza.zzp, zzfhfVar.zza.zzq, zzfhfVar.zza.zzr, zzfhfVar.zza.zzs, zzfhfVar.zza.zzt, zzfhfVar.zza.zzu, zzfhfVar.zza.zzv, com.google.android.gms.ads.internal.util.zzt.zza(zzfhfVar.zza.zzw), zzfhfVar.zza.zzx, zzfhfVar.zza.zzy);
        this.zza = zzfhfVar.zzd != null ? zzfhfVar.zzd : zzfhfVar.zzh != null ? zzfhfVar.zzh.zzf : null;
        this.zzg = zzfhfVar.zzf;
        this.zzh = zzfhfVar.zzg;
        this.zzi = zzfhfVar.zzf == null ? null : zzfhfVar.zzh == null ? new zzbjb(new NativeAdOptions.Builder().build()) : zzfhfVar.zzh;
        this.zzj = zzfhfVar.zzi;
        this.zzk = zzfhfVar.zzm;
        this.zzl = zzfhfVar.zzj;
        this.zzm = zzfhfVar.zzk;
        this.zzn = zzfhfVar.zzl;
        this.zzb = zzfhfVar.zzn;
        this.zzo = new zzfgu(zzfhfVar.zzo, null);
        this.zzp = zzfhfVar.zzp;
        this.zzc = zzfhfVar.zzq;
        this.zzq = zzfhfVar.zzr;
    }

    @Nullable
    public final zzbld zza() {
        PublisherAdViewOptions publisherAdViewOptions = this.zzm;
        if (publisherAdViewOptions == null && this.zzl == null) {
            return null;
        }
        return publisherAdViewOptions != null ? publisherAdViewOptions.zzb() : this.zzl.zza();
    }

    public final boolean zzb() {
        return this.zzf.matches((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcW));
    }
}
