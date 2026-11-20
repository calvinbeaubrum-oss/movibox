package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzchx implements zzbng {
    @Nullable
    private static final Integer zzb(Map map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt((String) map.get(str)));
        } catch (NumberFormatException unused) {
            zzcec.zzj("Precache invalid numeric parameter '" + str + "': " + ((String) map.get(str)));
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbng
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzchw zzchzVar;
        zzcgl zzcglVar = (zzcgl) obj;
        if (zzcec.zzm(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            zzcec.zze("Precache GMSG: ".concat(jSONObject.toString()));
        }
        zzchp<zzcho> zzchpVarZzy = com.google.android.gms.ads.internal.zzt.zzy();
        if (map.containsKey("abort")) {
            if (zzchpVarZzy.zzd(zzcglVar)) {
                return;
            }
            zzcec.zzj("Precache abort but no precache task running.");
            return;
        }
        String str = (String) map.get("src");
        Integer numZzb = zzb(map, "periodicReportIntervalMs");
        Integer numZzb2 = zzb(map, "exoPlayerRenderingIntervalMs");
        Integer numZzb3 = zzb(map, "exoPlayerIdleIntervalMs");
        zzcgk zzcgkVar = new zzcgk((String) map.get("flags"));
        boolean z11 = zzcgkVar.zzl;
        if (str != null) {
            String[] strArr = {str};
            String str2 = (String) map.get("demuxed");
            zzcho zzchoVarZza = null;
            if (str2 != null) {
                try {
                    JSONArray jSONArray = new JSONArray(str2);
                    String[] strArr2 = new String[jSONArray.length()];
                    for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                        strArr2[i11] = jSONArray.getString(i11);
                    }
                    strArr = strArr2;
                } catch (JSONException unused) {
                    zzcec.zzj("Malformed demuxed URL list for precache: ".concat(str2));
                    strArr = null;
                }
            }
            if (strArr == null) {
                strArr = new String[]{str};
            }
            if (z11) {
                for (zzcho zzchoVar : zzchpVarZzy) {
                    if (zzchoVar.zza == zzcglVar && str.equals(zzchoVar.zze())) {
                        zzchoVarZza = zzchoVar;
                        break;
                    }
                }
            } else {
                zzchoVarZza = zzchpVarZzy.zza(zzcglVar);
            }
            if (zzchoVarZza != null) {
                zzcec.zzj("Precache task is already running.");
                return;
            }
            if (zzcglVar.zzj() == null) {
                zzcec.zzj("Precache requires a dependency provider.");
                return;
            }
            Integer numZzb4 = zzb(map, "player");
            if (numZzb4 == null) {
                numZzb4 = 0;
            }
            if (numZzb != null) {
                zzcglVar.zzA(numZzb.intValue());
            }
            if (numZzb2 != null) {
                zzcglVar.zzy(numZzb2.intValue());
            }
            if (numZzb3 != null) {
                zzcglVar.zzx(numZzb3.intValue());
            }
            int iIntValue = numZzb4.intValue();
            zzchi zzchiVar = zzcglVar.zzj().zzb;
            if (iIntValue > 0) {
                int i12 = zzcgkVar.zzh;
                int iZzu = zzcgc.zzu();
                zzchzVar = iZzu < i12 ? new zzcif(zzcglVar, zzcgkVar) : iZzu < zzcgkVar.zzb ? new zzcic(zzcglVar, zzcgkVar) : new zzcia(zzcglVar);
            } else {
                zzchzVar = new zzchz(zzcglVar);
            }
            new zzcho(zzcglVar, zzchzVar, str, strArr).zzb();
        } else {
            zzcho zzchoVarZza2 = zzchpVarZzy.zza(zzcglVar);
            if (zzchoVarZza2 == null) {
                zzcec.zzj("Precache must specify a source.");
                return;
            }
            zzchzVar = zzchoVarZza2.zzb;
        }
        Integer numZzb5 = zzb(map, "minBufferMs");
        if (numZzb5 != null) {
            zzchzVar.zzs(numZzb5.intValue());
        }
        Integer numZzb6 = zzb(map, "maxBufferMs");
        if (numZzb6 != null) {
            zzchzVar.zzr(numZzb6.intValue());
        }
        Integer numZzb7 = zzb(map, "bufferForPlaybackMs");
        if (numZzb7 != null) {
            zzchzVar.zzp(numZzb7.intValue());
        }
        Integer numZzb8 = zzb(map, "bufferForPlaybackAfterRebufferMs");
        if (numZzb8 != null) {
            zzchzVar.zzq(numZzb8.intValue());
        }
    }
}
