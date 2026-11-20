package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfnu {
    private final zzemh zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final Context zze;
    private final zzfgz zzf;
    private final zzfha zzg;
    private final Clock zzh;
    private final zzavi zzi;

    public zzfnu(zzemh zzemhVar, zzcei zzceiVar, String str, String str2, Context context, @Nullable zzfgz zzfgzVar, @Nullable zzfha zzfhaVar, Clock clock, zzavi zzaviVar) {
        this.zza = zzemhVar;
        this.zzb = zzceiVar.zza;
        this.zzc = str;
        this.zzd = str2;
        this.zze = context;
        this.zzf = zzfgzVar;
        this.zzg = zzfhaVar;
        this.zzh = clock;
        this.zzi = zzaviVar;
    }

    public static final List zzf(int i11, int i12, List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(zzj((String) it.next(), "@gw_mpe@", "2." + i12));
        }
        return arrayList;
    }

    public static final List zzg(List list, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(zzj((String) it.next(), "@gw_adnetstatus@", str));
        }
        return arrayList;
    }

    public static final List zzh(List list, long j11) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(zzj((String) it.next(), "@gw_ttr@", Long.toString(j11, 10)));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static String zzi(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return zzceb.zzk() ? "fakeForAdDebugLog" : str;
    }

    private static String zzj(String str, String str2, @Nullable String str3) {
        if (true == TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        return str.replaceAll(str2, str3);
    }

    public final List zzc(zzfgy zzfgyVar, zzfgm zzfgmVar, List list) {
        return zzd(zzfgyVar, zzfgmVar, false, "", "", list);
    }

    public final List zzd(zzfgy zzfgyVar, @Nullable zzfgm zzfgmVar, boolean z11, @Nullable String str, @Nullable String str2, List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            boolean z12 = true;
            String strZzj = zzj(zzj(zzj((String) it.next(), "@gw_adlocid@", zzfgyVar.zza.zza.zzf), "@gw_adnetrefresh@", true != z11 ? "0" : "1"), "@gw_sdkver@", this.zzb);
            if (zzfgmVar != null) {
                strZzj = zzccj.zzc(zzj(zzj(zzj(strZzj, "@gw_qdata@", zzfgmVar.zzz), "@gw_adnetid@", zzfgmVar.zzy), "@gw_allocid@", zzfgmVar.zzx), this.zze, zzfgmVar.zzX);
            }
            String strZzj2 = zzj(zzj(zzj(zzj(strZzj, "@gw_adnetstatus@", this.zza.zzg()), "@gw_ttr@", Long.toString(this.zza.zza(), 10)), "@gw_seqnum@", this.zzc), "@gw_sessid@", this.zzd);
            boolean z13 = false;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzdp)).booleanValue() && !TextUtils.isEmpty(str)) {
                z13 = true;
            }
            boolean z14 = !TextUtils.isEmpty(str2);
            if (z13) {
                z12 = z14;
            } else {
                if (z14) {
                }
                arrayList.add(strZzj2);
            }
            if (this.zzi.zzf(Uri.parse(strZzj2))) {
                Uri.Builder builderBuildUpon = Uri.parse(strZzj2).buildUpon();
                if (z13) {
                    builderBuildUpon = builderBuildUpon.appendQueryParameter("ms", str);
                }
                if (z12) {
                    builderBuildUpon = builderBuildUpon.appendQueryParameter("attok", str2);
                }
                strZzj2 = builderBuildUpon.build().toString();
            }
            arrayList.add(strZzj2);
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0060 A[LOOP:0: B:13:0x005a->B:15:0x0060, LOOP_END] */
    public final List zze(zzfgm zzfgmVar, List list, zzbzu zzbzuVar) {
        zzfgz zzfgzVar;
        zzfwz zzfwzVarZzd;
        String str;
        String str2;
        Iterator it;
        ArrayList arrayList = new ArrayList();
        long jCurrentTimeMillis = this.zzh.currentTimeMillis();
        try {
            String strZzc = zzbzuVar.zzc();
            String string = Integer.toString(zzbzuVar.zzb());
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzdq)).booleanValue()) {
                zzfha zzfhaVar = this.zzg;
                if (zzfhaVar == null) {
                    zzfwzVarZzd = zzfwz.zzc();
                } else {
                    zzfgzVar = zzfhaVar.zza;
                }
                str = (String) zzfwzVarZzd.zza(new zzfws() { // from class: com.google.android.gms.internal.ads.zzfns
                    @Override // com.google.android.gms.internal.ads.zzfws
                    public final Object apply(Object obj) {
                        return zzfnu.zzi(((zzfgz) obj).zza);
                    }
                }).zzb("");
                str2 = (String) zzfwzVarZzd.zza(new zzfws() { // from class: com.google.android.gms.internal.ads.zzfnt
                    @Override // com.google.android.gms.internal.ads.zzfws
                    public final Object apply(Object obj) {
                        return zzfnu.zzi(((zzfgz) obj).zzb);
                    }
                }).zzb("");
                it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(zzccj.zzc(zzj(zzj(zzj(zzj(zzj(zzj((String) it.next(), "@gw_rwd_userid@", Uri.encode(str)), "@gw_rwd_custom_data@", Uri.encode(str2)), "@gw_tmstmp@", Long.toString(jCurrentTimeMillis)), "@gw_rwd_itm@", Uri.encode(strZzc)), "@gw_rwd_amt@", string), "@gw_sdkver@", this.zzb), this.zze, zzfgmVar.zzX));
                }
                return arrayList;
            }
            zzfgzVar = this.zzf;
            zzfwzVarZzd = zzfwz.zzd(zzfgzVar);
            str = (String) zzfwzVarZzd.zza(new zzfws() { // from class: com.google.android.gms.internal.ads.zzfns
                @Override // com.google.android.gms.internal.ads.zzfws
                public final Object apply(Object obj) {
                    return zzfnu.zzi(((zzfgz) obj).zza);
                }
            }).zzb("");
            str2 = (String) zzfwzVarZzd.zza(new zzfws() { // from class: com.google.android.gms.internal.ads.zzfnt
                @Override // com.google.android.gms.internal.ads.zzfws
                public final Object apply(Object obj) {
                    return zzfnu.zzi(((zzfgz) obj).zzb);
                }
            }).zzb("");
            it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(zzccj.zzc(zzj(zzj(zzj(zzj(zzj(zzj((String) it.next(), "@gw_rwd_userid@", Uri.encode(str)), "@gw_rwd_custom_data@", Uri.encode(str2)), "@gw_tmstmp@", Long.toString(jCurrentTimeMillis)), "@gw_rwd_itm@", Uri.encode(strZzc)), "@gw_rwd_amt@", string), "@gw_sdkver@", this.zzb), this.zze, zzfgmVar.zzX));
            }
            return arrayList;
        } catch (RemoteException e11) {
            zzcec.zzh("Unable to determine award type and amount.", e11);
            return arrayList;
        }
    }
}
