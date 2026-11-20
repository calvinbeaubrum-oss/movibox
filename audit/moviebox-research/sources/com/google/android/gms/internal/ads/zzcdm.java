package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.gms.ads.AdActivity;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcdm {
    final String zzf;
    private final com.google.android.gms.ads.internal.util.zzg zzk;
    long zza = -1;
    long zzb = -1;
    int zzc = -1;
    int zzd = -1;
    long zze = 0;
    private final Object zzj = new Object();
    int zzg = 0;
    int zzh = 0;
    int zzi = 0;

    public zzcdm(String str, com.google.android.gms.ads.internal.util.zzg zzgVar) {
        this.zzf = str;
        this.zzk = zzgVar;
    }

    private final void zzi() {
        if (((Boolean) zzbih.zza.zze()).booleanValue()) {
            synchronized (this.zzj) {
                this.zzc--;
                this.zzd--;
            }
        }
    }

    public final int zza() {
        int i11;
        synchronized (this.zzj) {
            i11 = this.zzi;
        }
        return i11;
    }

    public final Bundle zzb(Context context, String str) {
        Bundle bundle;
        synchronized (this.zzj) {
            try {
                bundle = new Bundle();
                if (!this.zzk.zzQ()) {
                    bundle.putString("session_id", this.zzf);
                }
                bundle.putLong("basets", this.zzb);
                bundle.putLong("currts", this.zza);
                bundle.putString("seq_num", str);
                bundle.putInt("preqs", this.zzc);
                bundle.putInt("preqs_in_session", this.zzd);
                bundle.putLong("time_in_session", this.zze);
                bundle.putInt("pclick", this.zzg);
                bundle.putInt("pimp", this.zzh);
                Context contextZza = zzbzs.zza(context);
                int identifier = contextZza.getResources().getIdentifier("Theme.Translucent", TtmlNode.TAG_STYLE, "android");
                boolean z11 = false;
                if (identifier == 0) {
                    zzcec.zzi("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
                } else {
                    try {
                        if (identifier == contextZza.getPackageManager().getActivityInfo(new ComponentName(contextZza.getPackageName(), AdActivity.CLASS_NAME), 0).theme) {
                            z11 = true;
                        } else {
                            zzcec.zzi("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
                        }
                    } catch (PackageManager.NameNotFoundException unused) {
                        zzcec.zzj("Fail to fetch AdActivity theme");
                        zzcec.zzi("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
                    }
                }
                bundle.putBoolean("support_transparent_background", z11);
                bundle.putInt("consent_form_action_identifier", zza());
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return bundle;
    }

    public final void zzc() {
        synchronized (this.zzj) {
            this.zzg++;
        }
    }

    public final void zzd() {
        synchronized (this.zzj) {
            this.zzh++;
        }
    }

    public final void zze() {
        zzi();
    }

    public final void zzf() {
        zzi();
    }

    public final void zzg(com.google.android.gms.ads.internal.client.zzl zzlVar, long j11) {
        Bundle bundle;
        synchronized (this.zzj) {
            try {
                long jZzd = this.zzk.zzd();
                long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis();
                if (this.zzb == -1) {
                    if (jCurrentTimeMillis - jZzd > ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzaT)).longValue()) {
                        this.zzd = -1;
                    } else {
                        this.zzd = this.zzk.zzc();
                    }
                    this.zzb = j11;
                    this.zza = j11;
                } else {
                    this.zza = j11;
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzdt)).booleanValue() || (bundle = zzlVar.zzc) == null || bundle.getInt("gw", 2) != 1) {
                    this.zzc++;
                    int i11 = this.zzd + 1;
                    this.zzd = i11;
                    if (i11 == 0) {
                        this.zze = 0L;
                        this.zzk.zzD(jCurrentTimeMillis);
                    } else {
                        this.zze = jCurrentTimeMillis - this.zzk.zze();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void zzh() {
        synchronized (this.zzj) {
            this.zzi++;
        }
    }
}
