package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.google.common.util.concurrent.s;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzerw implements zzexq {
    private final zzexq zza;
    private final zzfhh zzb;
    private final Context zzc;
    private final zzcdl zzd;

    public zzerw(zzetq zzetqVar, zzfhh zzfhhVar, Context context, zzcdl zzcdlVar) {
        this.zza = zzetqVar;
        this.zzb = zzfhhVar;
        this.zzc = context;
        this.zzd = zzcdlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final int zza() {
        return 7;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final s zzb() {
        return zzgen.zzm(this.zza.zzb(), new zzfws() { // from class: com.google.android.gms.internal.ads.zzerv
            @Override // com.google.android.gms.internal.ads.zzfws
            public final Object apply(Object obj) {
                return this.zza.zzc((zzexv) obj);
            }
        }, zzcep.zzf);
    }

    public final /* synthetic */ zzerx zzc(zzexv zzexvVar) {
        String str;
        boolean z11;
        String strZzm;
        int i11;
        float f11;
        int i12;
        int i13;
        DisplayMetrics displayMetrics;
        com.google.android.gms.ads.internal.client.zzq zzqVar = this.zzb.zze;
        com.google.android.gms.ads.internal.client.zzq[] zzqVarArr = zzqVar.zzg;
        if (zzqVarArr != null) {
            str = null;
            boolean z12 = false;
            boolean z13 = false;
            z11 = false;
            for (com.google.android.gms.ads.internal.client.zzq zzqVar2 : zzqVarArr) {
                boolean z14 = zzqVar2.zzi;
                if (!z14 && !z12) {
                    str = zzqVar2.zza;
                    z12 = true;
                }
                if (z14) {
                    if (z13) {
                        z13 = true;
                    } else {
                        z13 = true;
                        z11 = true;
                    }
                }
                if (z12 && z13) {
                    break;
                }
            }
        } else {
            str = zzqVar.zza;
            z11 = zzqVar.zzi;
        }
        Resources resources = this.zzc.getResources();
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            strZzm = null;
            i11 = 0;
            f11 = 0.0f;
            i12 = 0;
        } else {
            zzcdl zzcdlVar = this.zzd;
            f11 = displayMetrics.density;
            i12 = displayMetrics.widthPixels;
            i11 = displayMetrics.heightPixels;
            strZzm = zzcdlVar.zzi().zzm();
        }
        StringBuilder sb2 = new StringBuilder();
        com.google.android.gms.ads.internal.client.zzq[] zzqVarArr2 = zzqVar.zzg;
        if (zzqVarArr2 != null) {
            boolean z15 = false;
            for (com.google.android.gms.ads.internal.client.zzq zzqVar3 : zzqVarArr2) {
                if (zzqVar3.zzi) {
                    z15 = true;
                } else {
                    if (sb2.length() != 0) {
                        sb2.append("|");
                    }
                    int i14 = zzqVar3.zze;
                    if (i14 == -1) {
                        i14 = f11 != 0.0f ? (int) (zzqVar3.zzf / f11) : -1;
                    }
                    sb2.append(i14);
                    sb2.append("x");
                    int i15 = zzqVar3.zzb;
                    if (i15 == -2) {
                        i15 = f11 != 0.0f ? (int) (zzqVar3.zzc / f11) : -2;
                    }
                    sb2.append(i15);
                }
            }
            if (z15) {
                if (sb2.length() != 0) {
                    i13 = 0;
                    sb2.insert(0, "|");
                } else {
                    i13 = 0;
                }
                sb2.insert(i13, "320x50");
            }
        }
        return new zzerx(zzqVar, str, z11, sb2.toString(), f11, i12, i11, strZzm, this.zzb.zzp);
    }
}
