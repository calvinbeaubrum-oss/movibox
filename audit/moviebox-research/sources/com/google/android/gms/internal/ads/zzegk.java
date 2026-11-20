package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzegk extends zzegl {
    private static final SparseArray zzb;
    private final Context zzc;
    private final zzdab zzd;
    private final TelephonyManager zze;
    private final zzegc zzf;
    private int zzg;

    static {
        SparseArray sparseArray = new SparseArray();
        zzb = sparseArray;
        sparseArray.put(NetworkInfo.DetailedState.CONNECTED.ordinal(), zzbec.CONNECTED);
        int iOrdinal = NetworkInfo.DetailedState.AUTHENTICATING.ordinal();
        zzbec zzbecVar = zzbec.CONNECTING;
        sparseArray.put(iOrdinal, zzbecVar);
        sparseArray.put(NetworkInfo.DetailedState.CONNECTING.ordinal(), zzbecVar);
        sparseArray.put(NetworkInfo.DetailedState.OBTAINING_IPADDR.ordinal(), zzbecVar);
        sparseArray.put(NetworkInfo.DetailedState.DISCONNECTING.ordinal(), zzbec.DISCONNECTING);
        int iOrdinal2 = NetworkInfo.DetailedState.BLOCKED.ordinal();
        zzbec zzbecVar2 = zzbec.DISCONNECTED;
        sparseArray.put(iOrdinal2, zzbecVar2);
        sparseArray.put(NetworkInfo.DetailedState.DISCONNECTED.ordinal(), zzbecVar2);
        sparseArray.put(NetworkInfo.DetailedState.FAILED.ordinal(), zzbecVar2);
        sparseArray.put(NetworkInfo.DetailedState.IDLE.ordinal(), zzbecVar2);
        sparseArray.put(NetworkInfo.DetailedState.SCANNING.ordinal(), zzbecVar2);
        sparseArray.put(NetworkInfo.DetailedState.SUSPENDED.ordinal(), zzbec.SUSPENDED);
        sparseArray.put(NetworkInfo.DetailedState.CAPTIVE_PORTAL_CHECK.ordinal(), zzbecVar);
        sparseArray.put(NetworkInfo.DetailedState.VERIFYING_POOR_LINK.ordinal(), zzbecVar);
    }

    public zzegk(Context context, zzdab zzdabVar, zzegc zzegcVar, zzefy zzefyVar, com.google.android.gms.ads.internal.util.zzg zzgVar) {
        super(zzefyVar, zzgVar);
        this.zzc = context;
        this.zzd = zzdabVar;
        this.zzf = zzegcVar;
        this.zze = (TelephonyManager) context.getSystemService("phone");
    }

    public static /* bridge */ /* synthetic */ zzbdt zza(zzegk zzegkVar, Bundle bundle) {
        zzbdm zzbdmVarZza = zzbdt.zza();
        int i11 = bundle.getInt("cnt", -2);
        int i12 = bundle.getInt("gnt", 0);
        int i13 = 2;
        if (i11 == -1) {
            zzegkVar.zzg = 2;
        } else {
            zzegkVar.zzg = 1;
            if (i11 == 0) {
                zzbdmVarZza.zzb(2);
            } else if (i11 != 1) {
                zzbdmVarZza.zzb(1);
            } else {
                zzbdmVarZza.zzb(3);
            }
            switch (i12) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                    i13 = 3;
                    break;
                case 13:
                    i13 = 5;
                    break;
                default:
                    i13 = 1;
                    break;
            }
            zzbdmVarZza.zza(i13);
        }
        return (zzbdt) zzbdmVarZza.zzal();
    }

    public static /* bridge */ /* synthetic */ zzbec zzb(zzegk zzegkVar, Bundle bundle) {
        return (zzbec) zzb.get(zzfhv.zza(zzfhv.zza(bundle, "device"), "network").getInt("active_network_state", -1), zzbec.UNSPECIFIED);
    }

    public static /* bridge */ /* synthetic */ byte[] zze(zzegk zzegkVar, boolean z11, ArrayList arrayList, zzbdt zzbdtVar, zzbec zzbecVar) {
        zzbdx zzbdxVarZzg = zzbdy.zzg();
        zzbdxVarZzg.zza(arrayList);
        zzbdxVarZzg.zzi(zzg(Settings.Global.getInt(zzegkVar.zzc.getContentResolver(), "airplane_mode_on", 0) != 0));
        zzbdxVarZzg.zzj(com.google.android.gms.ads.internal.zzt.zzq().zzi(zzegkVar.zzc, zzegkVar.zze));
        zzbdxVarZzg.zzf(zzegkVar.zzf.zze());
        zzbdxVarZzg.zze(zzegkVar.zzf.zzb());
        zzbdxVarZzg.zzb(zzegkVar.zzf.zza());
        zzbdxVarZzg.zzc(zzbecVar);
        zzbdxVarZzg.zzd(zzbdtVar);
        zzbdxVarZzg.zzk(zzegkVar.zzg);
        zzbdxVarZzg.zzl(zzg(z11));
        zzbdxVarZzg.zzh(zzegkVar.zzf.zzd());
        zzbdxVarZzg.zzg(com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis());
        zzbdxVarZzg.zzm(zzg(Settings.Global.getInt(zzegkVar.zzc.getContentResolver(), "wifi_on", 0) != 0));
        return ((zzbdy) zzbdxVarZzg.zzal()).zzax();
    }

    private static final int zzg(boolean z11) {
        return z11 ? 2 : 1;
    }

    public final void zzd(boolean z11) {
        zzgen.zzr(this.zzd.zzb(), new zzegj(this, z11), zzcep.zzf);
    }
}
