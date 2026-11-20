package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzerx implements zzexp {
    public final com.google.android.gms.ads.internal.client.zzq zza;

    @Nullable
    public final String zzb;
    public final boolean zzc;
    public final String zzd;
    public final float zze;
    public final int zzf;
    public final int zzg;

    @Nullable
    public final String zzh;
    public final boolean zzi;

    public zzerx(com.google.android.gms.ads.internal.client.zzq zzqVar, @Nullable String str, boolean z11, String str2, float f11, int i11, int i12, @Nullable String str3, boolean z12) {
        Preconditions.checkNotNull(zzqVar, "the adSize must not be null");
        this.zza = zzqVar;
        this.zzb = str;
        this.zzc = z11;
        this.zzd = str2;
        this.zze = f11;
        this.zzf = i11;
        this.zzg = i12;
        this.zzh = str3;
        this.zzi = z12;
    }

    @Override // com.google.android.gms.internal.ads.zzexp
    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzfhv.zzf(bundle, "smart_w", "full", this.zza.zze == -1);
        zzfhv.zzf(bundle, "smart_h", "auto", this.zza.zzb == -2);
        zzfhv.zzg(bundle, "ene", true, this.zza.zzj);
        zzfhv.zzf(bundle, "rafmt", "102", this.zza.zzm);
        zzfhv.zzf(bundle, "rafmt", "103", this.zza.zzn);
        zzfhv.zzf(bundle, "rafmt", "105", this.zza.zzo);
        zzfhv.zzg(bundle, "inline_adaptive_slot", true, this.zzi);
        zzfhv.zzg(bundle, "interscroller_slot", true, this.zza.zzo);
        zzfhv.zzc(bundle, "format", this.zzb);
        zzfhv.zzf(bundle, "fluid", "height", this.zzc);
        zzfhv.zzf(bundle, "sz", this.zzd, !TextUtils.isEmpty(this.zzd));
        bundle.putFloat("u_sd", this.zze);
        bundle.putInt("sw", this.zzf);
        bundle.putInt(com.mbridge.msdk.foundation.entity.b.JSON_KEY_SH, this.zzg);
        zzfhv.zzf(bundle, "sc", this.zzh, !TextUtils.isEmpty(this.zzh));
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        com.google.android.gms.ads.internal.client.zzq[] zzqVarArr = this.zza.zzg;
        if (zzqVarArr == null) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("height", this.zza.zzb);
            bundle2.putInt("width", this.zza.zze);
            bundle2.putBoolean("is_fluid_height", this.zza.zzi);
            arrayList.add(bundle2);
        } else {
            for (com.google.android.gms.ads.internal.client.zzq zzqVar : zzqVarArr) {
                Bundle bundle3 = new Bundle();
                bundle3.putBoolean("is_fluid_height", zzqVar.zzi);
                bundle3.putInt("height", zzqVar.zzb);
                bundle3.putInt("width", zzqVar.zze);
                arrayList.add(bundle3);
            }
        }
        bundle.putParcelableArrayList("valid_ad_sizes", arrayList);
    }
}
