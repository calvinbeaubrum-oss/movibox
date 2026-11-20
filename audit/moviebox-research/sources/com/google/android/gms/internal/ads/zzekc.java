package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.common.util.concurrent.s;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzekc implements zzein {
    private final Context zza;
    private final zzdko zzb;
    private final Executor zzc;
    private final zzfgl zzd;

    public zzekc(Context context, Executor executor, zzdko zzdkoVar, zzfgl zzfglVar) {
        this.zza = context;
        this.zzb = zzdkoVar;
        this.zzc = executor;
        this.zzd = zzfglVar;
    }

    @Nullable
    private static String zzd(zzfgm zzfgmVar) {
        try {
            return zzfgmVar.zzw.getString("tab_url");
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzein
    public final s zza(final zzfgy zzfgyVar, final zzfgm zzfgmVar) {
        String strZzd = zzd(zzfgmVar);
        final Uri uri = strZzd != null ? Uri.parse(strZzd) : null;
        return zzgen.zzn(zzgen.zzh(null), new zzgdu() { // from class: com.google.android.gms.internal.ads.zzeka
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final s zza(Object obj) {
                return this.zza.zzc(uri, zzfgyVar, zzfgmVar, obj);
            }
        }, this.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzein
    public final boolean zzb(zzfgy zzfgyVar, zzfgm zzfgmVar) {
        Context context = this.zza;
        return (context instanceof Activity) && zzbhd.zzg(context) && !TextUtils.isEmpty(zzd(zzfgmVar));
    }

    public final /* synthetic */ s zzc(Uri uri, zzfgy zzfgyVar, zzfgm zzfgmVar, Object obj) throws Exception {
        try {
            androidx.browser.customtabs.d dVarA = new androidx.browser.customtabs.d.b().a();
            dVarA.f1830a.setData(uri);
            com.google.android.gms.ads.internal.overlay.zzc zzcVar = new com.google.android.gms.ads.internal.overlay.zzc(dVarA.f1830a, null);
            final zzceu zzceuVar = new zzceu();
            zzdjo zzdjoVarZze = this.zzb.zze(new zzcwx(zzfgyVar, zzfgmVar, null), new zzdjr(new zzdkw() { // from class: com.google.android.gms.internal.ads.zzekb
                @Override // com.google.android.gms.internal.ads.zzdkw
                public final void zza(boolean z11, Context context, zzdbk zzdbkVar) {
                    zzceu zzceuVar2 = zzceuVar;
                    try {
                        com.google.android.gms.ads.internal.zzt.zzi();
                        com.google.android.gms.ads.internal.overlay.zzn.zza(context, (AdOverlayInfoParcel) zzceuVar2.get(), true);
                    } catch (Exception unused) {
                    }
                }
            }, null));
            zzceuVar.zzc(new AdOverlayInfoParcel(zzcVar, null, zzdjoVarZze.zza(), null, new zzcei(0, 0, false, false, false), null, null));
            this.zzd.zza();
            return zzgen.zzh(zzdjoVarZze.zzg());
        } catch (Throwable th2) {
            zzcec.zzh("Error in CustomTabsAdRenderer", th2);
            throw th2;
        }
    }
}
