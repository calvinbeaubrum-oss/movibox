package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.ads.MobileAds;
import com.hisavana.common.tracking.TrackingKey;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzefg implements zzdfp, com.google.android.gms.ads.internal.client.zza, zzdbr, zzdbb {
    private final Context zza;
    private final zzfhz zzb;
    private final zzfgy zzc;
    private final zzfgm zzd;
    private final zzehh zze;

    @Nullable
    private Boolean zzf;
    private final boolean zzg = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgR)).booleanValue();

    @NonNull
    private final zzflw zzh;
    private final String zzi;

    public zzefg(Context context, zzfhz zzfhzVar, zzfgy zzfgyVar, zzfgm zzfgmVar, zzehh zzehhVar, @NonNull zzflw zzflwVar, String str) {
        this.zza = context;
        this.zzb = zzfhzVar;
        this.zzc = zzfgyVar;
        this.zzd = zzfgmVar;
        this.zze = zzehhVar;
        this.zzh = zzflwVar;
        this.zzi = str;
    }

    private final zzflv zzd(String str) {
        zzflv zzflvVarZzb = zzflv.zzb(str);
        zzflvVarZzb.zzh(this.zzc, null);
        zzflvVarZzb.zzf(this.zzd);
        zzflvVarZzb.zza(TrackingKey.REQUEST_ID, this.zzi);
        if (!this.zzd.zzu.isEmpty()) {
            zzflvVarZzb.zza("ancn", (String) this.zzd.zzu.get(0));
        }
        if (this.zzd.zzaj) {
            zzflvVarZzb.zza("device_connectivity", true != com.google.android.gms.ads.internal.zzt.zzo().zzz(this.zza) ? "offline" : androidx.browser.customtabs.c.ONLINE_EXTRAS_KEY);
            zzflvVarZzb.zza("event_timestamp", String.valueOf(com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis()));
            zzflvVarZzb.zza("offline_ad", "1");
        }
        return zzflvVarZzb;
    }

    private final void zze(zzflv zzflvVar) {
        if (!this.zzd.zzaj) {
            this.zzh.zzb(zzflvVar);
            return;
        }
        this.zze.zzd(new zzehj(com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis(), this.zzc.zzb.zzb.zzb, this.zzh.zza(zzflvVar), 2));
    }

    private final boolean zzf() {
        String strZzp;
        if (this.zzf == null) {
            synchronized (this) {
                if (this.zzf == null) {
                    String str = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbt);
                    com.google.android.gms.ads.internal.zzt.zzp();
                    try {
                        strZzp = com.google.android.gms.ads.internal.util.zzt.zzp(this.zza);
                    } catch (RemoteException unused) {
                        strZzp = null;
                    }
                    boolean zMatches = false;
                    if (str != null && strZzp != null) {
                        try {
                            zMatches = Pattern.matches(str, strZzp);
                        } catch (RuntimeException e11) {
                            com.google.android.gms.ads.internal.zzt.zzo().zzw(e11, "CsiActionsListener.isPatternMatched");
                        }
                    }
                    this.zzf = Boolean.valueOf(zMatches);
                }
            }
        }
        return this.zzf.booleanValue();
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        if (this.zzd.zzaj) {
            zze(zzd("click"));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbb
    public final void zza(com.google.android.gms.ads.internal.client.zze zzeVar) {
        com.google.android.gms.ads.internal.client.zze zzeVar2;
        if (this.zzg) {
            int i11 = zzeVar.zza;
            String str = zzeVar.zzb;
            if (zzeVar.zzc.equals(MobileAds.ERROR_DOMAIN) && (zzeVar2 = zzeVar.zzd) != null && !zzeVar2.zzc.equals(MobileAds.ERROR_DOMAIN)) {
                com.google.android.gms.ads.internal.client.zze zzeVar3 = zzeVar.zzd;
                i11 = zzeVar3.zza;
                str = zzeVar3.zzb;
            }
            String strZza = this.zzb.zza(str);
            zzflv zzflvVarZzd = zzd("ifts");
            zzflvVarZzd.zza("reason", "adapter");
            if (i11 >= 0) {
                zzflvVarZzd.zza("arec", String.valueOf(i11));
            }
            if (strZza != null) {
                zzflvVarZzd.zza("areec", strZza);
            }
            this.zzh.zzb(zzflvVarZzd);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbb
    public final void zzb() {
        if (this.zzg) {
            zzflw zzflwVar = this.zzh;
            zzflv zzflvVarZzd = zzd("ifts");
            zzflvVarZzd.zza("reason", "blocked");
            zzflwVar.zzb(zzflvVarZzd);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbb
    public final void zzc(zzdkv zzdkvVar) {
        if (this.zzg) {
            zzflv zzflvVarZzd = zzd("ifts");
            zzflvVarZzd.zza("reason", "exception");
            if (!TextUtils.isEmpty(zzdkvVar.getMessage())) {
                zzflvVarZzd.zza(NotificationCompat.CATEGORY_MESSAGE, zzdkvVar.getMessage());
            }
            this.zzh.zzb(zzflvVarZzd);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdfp
    public final void zzi() {
        if (zzf()) {
            this.zzh.zzb(zzd("adapter_shown"));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdfp
    public final void zzj() {
        if (zzf()) {
            this.zzh.zzb(zzd("adapter_impression"));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbr
    public final void zzq() {
        if (zzf() || this.zzd.zzaj) {
            zze(zzd("impression"));
        }
    }
}
