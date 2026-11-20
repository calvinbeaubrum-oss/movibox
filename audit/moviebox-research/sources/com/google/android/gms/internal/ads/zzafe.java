package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzafe extends zzafg {
    private long zzb;
    private long[] zzc;
    private long[] zzd;

    public zzafe() {
        super(new zzact());
        this.zzb = C.TIME_UNSET;
        this.zzc = new long[0];
        this.zzd = new long[0];
    }

    private static Double zzg(zzfp zzfpVar) {
        return Double.valueOf(Double.longBitsToDouble(zzfpVar.zzt()));
    }

    @Nullable
    private static Object zzh(zzfp zzfpVar, int i11) {
        if (i11 == 0) {
            return zzg(zzfpVar);
        }
        if (i11 == 1) {
            return Boolean.valueOf(zzfpVar.zzm() == 1);
        }
        if (i11 == 2) {
            return zzi(zzfpVar);
        }
        if (i11 != 3) {
            if (i11 == 8) {
                return zzj(zzfpVar);
            }
            if (i11 != 10) {
                if (i11 != 11) {
                    return null;
                }
                Date date = new Date((long) zzg(zzfpVar).doubleValue());
                zzfpVar.zzL(2);
                return date;
            }
            int iZzp = zzfpVar.zzp();
            ArrayList arrayList = new ArrayList(iZzp);
            for (int i12 = 0; i12 < iZzp; i12++) {
                Object objZzh = zzh(zzfpVar, zzfpVar.zzm());
                if (objZzh != null) {
                    arrayList.add(objZzh);
                }
            }
            return arrayList;
        }
        HashMap map = new HashMap();
        while (true) {
            String strZzi = zzi(zzfpVar);
            int iZzm = zzfpVar.zzm();
            if (iZzm == 9) {
                return map;
            }
            Object objZzh2 = zzh(zzfpVar, iZzm);
            if (objZzh2 != null) {
                map.put(strZzi, objZzh2);
            }
        }
    }

    private static String zzi(zzfp zzfpVar) {
        int iZzq = zzfpVar.zzq();
        int iZzd = zzfpVar.zzd();
        zzfpVar.zzL(iZzq);
        return new String(zzfpVar.zzM(), iZzd, iZzq);
    }

    private static HashMap zzj(zzfp zzfpVar) {
        int iZzp = zzfpVar.zzp();
        HashMap map = new HashMap(iZzp);
        for (int i11 = 0; i11 < iZzp; i11++) {
            String strZzi = zzi(zzfpVar);
            Object objZzh = zzh(zzfpVar, zzfpVar.zzm());
            if (objZzh != null) {
                map.put(strZzi, objZzh);
            }
        }
        return map;
    }

    @Override // com.google.android.gms.internal.ads.zzafg
    public final boolean zza(zzfp zzfpVar) {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzafg
    public final boolean zzb(zzfp zzfpVar, long j11) {
        if (zzfpVar.zzm() == 2 && "onMetaData".equals(zzi(zzfpVar)) && zzfpVar.zzb() != 0 && zzfpVar.zzm() == 8) {
            HashMap mapZzj = zzj(zzfpVar);
            Object obj = mapZzj.get("duration");
            if (obj instanceof Double) {
                double dDoubleValue = ((Double) obj).doubleValue();
                if (dDoubleValue > 0.0d) {
                    this.zzb = (long) (dDoubleValue * 1000000.0d);
                }
            }
            Object obj2 = mapZzj.get("keyframes");
            if (obj2 instanceof Map) {
                Map map = (Map) obj2;
                Object obj3 = map.get("filepositions");
                Object obj4 = map.get("times");
                if ((obj3 instanceof List) && (obj4 instanceof List)) {
                    List list = (List) obj3;
                    List list2 = (List) obj4;
                    int size = list2.size();
                    this.zzc = new long[size];
                    this.zzd = new long[size];
                    for (int i11 = 0; i11 < size; i11++) {
                        Object obj5 = list.get(i11);
                        Object obj6 = list2.get(i11);
                        if (!(obj6 instanceof Double) || !(obj5 instanceof Double)) {
                            this.zzc = new long[0];
                            this.zzd = new long[0];
                            break;
                        }
                        this.zzc[i11] = (long) (((Double) obj6).doubleValue() * 1000000.0d);
                        this.zzd[i11] = ((Double) obj5).longValue();
                    }
                }
            }
        }
        return false;
    }

    public final long zzc() {
        return this.zzb;
    }

    public final long[] zzd() {
        return this.zzd;
    }

    public final long[] zze() {
        return this.zzc;
    }
}
