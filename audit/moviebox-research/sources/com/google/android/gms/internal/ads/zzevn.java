package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.applovin.sdk.AppLovinMediationProvider;
import com.google.common.util.concurrent.s;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzevn implements zzexq {
    private final zzgey zza;
    private final zzfhh zzb;

    @Nullable
    private final PackageInfo zzc;
    private final com.google.android.gms.ads.internal.util.zzg zzd;

    public zzevn(zzgey zzgeyVar, zzfhh zzfhhVar, @Nullable PackageInfo packageInfo, com.google.android.gms.ads.internal.util.zzg zzgVar) {
        this.zza = zzgeyVar;
        this.zzb = zzfhhVar;
        this.zzc = packageInfo;
        this.zzd = zzgVar;
    }

    public static /* synthetic */ zzevo zzc(final zzevn zzevnVar) {
        final ArrayList arrayList = zzevnVar.zzb.zzg;
        if (arrayList == null) {
            return new zzevo() { // from class: com.google.android.gms.internal.ads.zzevk
                @Override // com.google.android.gms.internal.ads.zzexp
                public final void zzj(Object obj) {
                }
            };
        }
        return arrayList.isEmpty() ? new zzevo() { // from class: com.google.android.gms.internal.ads.zzevl
            @Override // com.google.android.gms.internal.ads.zzexp
            public final void zzj(Object obj) {
                ((Bundle) obj).putInt("native_version", 0);
            }
        } : new zzevo() { // from class: com.google.android.gms.internal.ads.zzevm
            @Override // com.google.android.gms.internal.ads.zzexp
            public final void zzj(Object obj) {
                this.zza.zzd(arrayList, (Bundle) obj);
            }
        };
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final int zza() {
        return 26;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final s zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzevj
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzevn.zzc(this.zza);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:58:0x00fe  */
    public final /* synthetic */ void zzd(ArrayList arrayList, Bundle bundle) {
        JSONArray jSONArrayOptJSONArray;
        String str;
        bundle.putInt("native_version", 3);
        bundle.putStringArrayList("native_templates", arrayList);
        bundle.putStringArrayList("native_custom_templates", this.zzb.zzh);
        String str2 = "any";
        if (this.zzb.zzi.zza > 3) {
            bundle.putBoolean("enable_native_media_orientation", true);
            int i11 = this.zzb.zzi.zzh;
            if (i11 == 1) {
                str = "any";
            } else if (i11 == 2) {
                str = "landscape";
            } else if (i11 != 3) {
                str = i11 != 4 ? AppLovinMediationProvider.UNKNOWN : "square";
            } else {
                str = "portrait";
            }
            if (!AppLovinMediationProvider.UNKNOWN.equals(str)) {
                bundle.putString("native_media_orientation", str);
            }
        }
        int i12 = this.zzb.zzi.zzc;
        if (i12 != 0) {
            if (i12 != 1) {
                str2 = i12 != 2 ? AppLovinMediationProvider.UNKNOWN : "landscape";
            } else {
                str2 = "portrait";
            }
        }
        if (!AppLovinMediationProvider.UNKNOWN.equals(str2)) {
            bundle.putString("native_image_orientation", str2);
        }
        bundle.putBoolean("native_multiple_images", this.zzb.zzi.zzd);
        bundle.putBoolean("use_custom_mute", this.zzb.zzi.zzg);
        zzbjb zzbjbVar = this.zzb.zzi;
        if (zzbjbVar.zzi != 0) {
            bundle.putBoolean("sccg_tap", zzbjbVar.zzj);
            bundle.putInt("sccg_dir", this.zzb.zzi.zzi);
        }
        PackageInfo packageInfo = this.zzc;
        int i13 = packageInfo == null ? 0 : packageInfo.versionCode;
        if (i13 > this.zzd.zza()) {
            this.zzd.zzs();
            this.zzd.zzv(i13);
        }
        JSONObject jSONObjectZzp = this.zzd.zzp();
        String string = null;
        if (jSONObjectZzp != null && (jSONArrayOptJSONArray = jSONObjectZzp.optJSONArray(this.zzb.zzf)) != null) {
            string = jSONArrayOptJSONArray.toString();
        }
        if (!TextUtils.isEmpty(string)) {
            bundle.putString("native_advanced_settings", string);
        }
        int i14 = this.zzb.zzk;
        if (i14 > 1) {
            bundle.putInt("max_num_ads", i14);
        }
        zzbpp zzbppVar = this.zzb.zzb;
        if (zzbppVar != null) {
            if (TextUtils.isEmpty(zzbppVar.zzc)) {
                int i15 = zzbppVar.zza;
                String str3 = TtmlNode.TAG_P;
                if (i15 >= 2) {
                    int i16 = zzbppVar.zzd;
                    if (i16 == 2 || i16 != 3) {
                        str3 = "l";
                    }
                } else {
                    int i17 = zzbppVar.zzb;
                    if (i17 == 1) {
                        str3 = "l";
                    } else if (i17 != 2) {
                        zzcec.zzg("Instream ad video aspect ratio " + i17 + " is wrong.");
                        str3 = "l";
                    }
                }
                bundle.putString("ia_var", str3);
            } else {
                bundle.putString("ad_tag", zzbppVar.zzc);
            }
            bundle.putBoolean("instr", true);
        }
        if (this.zzb.zza() != null) {
            bundle.putBoolean("has_delayed_banner_listener", true);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzlj)).booleanValue()) {
            if (this.zzb.zzi.zzf != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean("startMuted", this.zzb.zzi.zzf.zza);
                bundle2.putBoolean("clickToExpandRequested", this.zzb.zzi.zzf.zzc);
                bundle2.putBoolean("customControlsRequested", this.zzb.zzi.zzf.zzb);
                bundle.putBundle("video", bundle2);
            }
            bundle.putBoolean("disable_image_loading", this.zzb.zzi.zzb);
            bundle.putInt("preferred_ad_choices_position", this.zzb.zzi.zze);
        }
    }
}
