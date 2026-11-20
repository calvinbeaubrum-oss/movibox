package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.s;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzebg implements zzece {
    private static final Pattern zza = Pattern.compile("Received error HTTP response code: (.*)");
    private final zzeah zzb;
    private final zzgey zzc;
    private final zzfhh zzd;
    private final ScheduledExecutorService zze;
    private final zzegc zzf;
    private final zzfmz zzg;
    private final Context zzh;

    public zzebg(Context context, zzfhh zzfhhVar, zzeah zzeahVar, zzgey zzgeyVar, ScheduledExecutorService scheduledExecutorService, zzegc zzegcVar, zzfmz zzfmzVar) {
        this.zzh = context;
        this.zzd = zzfhhVar;
        this.zzb = zzeahVar;
        this.zzc = zzgeyVar;
        this.zze = scheduledExecutorService;
        this.zzf = zzegcVar;
        this.zzg = zzfmzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzece
    public final s zzb(zzbze zzbzeVar) {
        Context context = this.zzh;
        s sVarZzb = this.zzb.zzb(zzbzeVar);
        zzfmo zzfmoVarZza = zzfmn.zza(context, 11);
        zzfmy.zzd(sVarZzb, zzfmoVarZza);
        s sVarZzn = zzgen.zzn(sVarZzb, new zzgdu() { // from class: com.google.android.gms.internal.ads.zzebd
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final s zza(Object obj) {
                return this.zza.zzc((InputStream) obj);
            }
        }, this.zzc);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfv)).booleanValue()) {
            sVarZzn = zzgen.zzf(zzgen.zzo(sVarZzn, ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfx)).intValue(), TimeUnit.SECONDS, this.zze), TimeoutException.class, new zzgdu() { // from class: com.google.android.gms.internal.ads.zzebe
                @Override // com.google.android.gms.internal.ads.zzgdu
                public final s zza(Object obj) {
                    return zzgen.zzg(new zzead(5));
                }
            }, zzcep.zzf);
        }
        zzfmy.zza(sVarZzn, this.zzg, zzfmoVarZza);
        zzgen.zzr(sVarZzn, new zzebf(this), zzcep.zzf);
        return sVarZzn;
    }

    public final /* synthetic */ s zzc(InputStream inputStream) throws Exception {
        return zzgen.zzh(new zzfgy(new zzfgv(this.zzd), zzfgx.zza(new InputStreamReader(inputStream))));
    }
}
