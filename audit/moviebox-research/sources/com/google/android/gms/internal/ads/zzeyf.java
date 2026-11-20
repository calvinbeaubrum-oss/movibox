package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.Base64;
import com.google.common.util.concurrent.s;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzeyf implements zzexq {
    private final com.google.android.gms.ads.internal.util.zzg zza;
    private final Context zzb;
    private final zzgey zzc;
    private final ScheduledExecutorService zzd;
    private final zzeil zze;
    private final zzfhh zzf;

    public zzeyf(com.google.android.gms.ads.internal.util.zzg zzgVar, Context context, zzgey zzgeyVar, ScheduledExecutorService scheduledExecutorService, zzeil zzeilVar, zzfhh zzfhhVar) {
        this.zza = zzgVar;
        this.zzb = context;
        this.zzc = zzgeyVar;
        this.zzd = scheduledExecutorService;
        this.zze = zzeilVar;
        this.zzf = zzfhhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final int zza() {
        return 56;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0038, code lost:
    
        if (r5.zzf.zzd.zzy != com.google.android.gms.ads.RequestConfiguration.PublisherPrivacyPersonalizationState.DISABLED.getValue()) goto L10;
     */
    @Override // com.google.android.gms.internal.ads.zzexq
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final s zzb() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjU)).booleanValue() && this.zza.zzR()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjX)).booleanValue()) {
            }
            return zzgen.zzf(zzgen.zzn(zzgee.zzu(zzgen.zzo(this.zze.zza(false), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjV)).intValue(), TimeUnit.MILLISECONDS, this.zzd)), new zzgdu() { // from class: com.google.android.gms.internal.ads.zzeyd
                @Override // com.google.android.gms.internal.ads.zzgdu
                public final s zza(Object obj) {
                    zzhdn zzhdnVarZza = zzhdo.zza();
                    for (androidx.privacysandbox.ads.adservices.topics.c cVar : ((androidx.privacysandbox.ads.adservices.topics.b) obj).a()) {
                        zzhdl zzhdlVarZza = zzhdm.zza();
                        zzhdlVarZza.zzc(cVar.c());
                        zzhdlVarZza.zza(cVar.a());
                        zzhdlVarZza.zzb(cVar.b());
                        zzhdnVarZza.zza((zzhdm) zzhdlVarZza.zzal());
                    }
                    return zzgen.zzh(new zzeyh(Base64.encodeToString(((zzhdo) zzhdnVarZza.zzal()).zzax(), 1), 1, null));
                }
            }, this.zzc), Throwable.class, new zzgdu() { // from class: com.google.android.gms.internal.ads.zzeye
                @Override // com.google.android.gms.internal.ads.zzgdu
                public final s zza(Object obj) {
                    return this.zza.zzc((Throwable) obj);
                }
            }, this.zzc);
        }
        return zzgen.zzh(new zzeyh("", -1, null));
    }

    public final /* synthetic */ s zzc(Throwable th2) throws Exception {
        zzeyh zzeyhVar;
        zzbxw.zza(this.zzb).zzg(th2, "TopicsSignal.fetchTopicsSignal");
        if (th2 instanceof SecurityException) {
            zzeyhVar = new zzeyh("", 2, null);
        } else if (th2 instanceof IllegalStateException) {
            zzeyhVar = new zzeyh("", 3, null);
        } else if (th2 instanceof IllegalArgumentException) {
            zzeyhVar = new zzeyh("", 4, null);
        } else {
            zzeyhVar = th2 instanceof TimeoutException ? new zzeyh("", 5, null) : new zzeyh("", 0, null);
        }
        return zzgen.zzh(zzeyhVar);
    }
}
