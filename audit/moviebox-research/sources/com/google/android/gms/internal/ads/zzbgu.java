package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public final class zzbgu {
    private final List zza = new LinkedList();
    private final Map zzb;
    private final Object zzc;

    public zzbgu(boolean z11, String str, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.zzb = linkedHashMap;
        this.zzc = new Object();
        linkedHashMap.put("action", "make_wv");
        linkedHashMap.put("ad_format", str2);
    }

    public static final zzbgr zzf() {
        return new zzbgr(com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime(), null, null);
    }

    public final zzbgt zza() {
        zzbgt zzbgtVar;
        boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbQ)).booleanValue();
        StringBuilder sb2 = new StringBuilder();
        HashMap map = new HashMap();
        synchronized (this.zzc) {
            try {
                for (zzbgr zzbgrVar : this.zza) {
                    long jZza = zzbgrVar.zza();
                    String strZzc = zzbgrVar.zzc();
                    zzbgr zzbgrVarZzb = zzbgrVar.zzb();
                    if (zzbgrVarZzb != null && jZza > 0) {
                        long jZza2 = jZza - zzbgrVarZzb.zza();
                        sb2.append(strZzc);
                        sb2.append('.');
                        sb2.append(jZza2);
                        sb2.append(',');
                        if (zBooleanValue) {
                            if (map.containsKey(Long.valueOf(zzbgrVarZzb.zza()))) {
                                StringBuilder sb3 = (StringBuilder) map.get(Long.valueOf(zzbgrVarZzb.zza()));
                                sb3.append('+');
                                sb3.append(strZzc);
                            } else {
                                map.put(Long.valueOf(zzbgrVarZzb.zza()), new StringBuilder(strZzc));
                            }
                        }
                    }
                }
                this.zza.clear();
                String string = null;
                if (!TextUtils.isEmpty(null)) {
                    sb2.append((String) null);
                } else if (sb2.length() > 0) {
                    sb2.setLength(sb2.length() - 1);
                }
                StringBuilder sb4 = new StringBuilder();
                if (zBooleanValue) {
                    for (Map.Entry entry : map.entrySet()) {
                        sb4.append((CharSequence) entry.getValue());
                        sb4.append('.');
                        sb4.append(com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis() + (((Long) entry.getKey()).longValue() - com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime()));
                        sb4.append(',');
                    }
                    if (sb4.length() > 0) {
                        sb4.setLength(sb4.length() - 1);
                    }
                    string = sb4.toString();
                }
                zzbgtVar = new zzbgt(sb2.toString(), string);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return zzbgtVar;
    }

    public final Map zzb() {
        Map map;
        synchronized (this.zzc) {
            com.google.android.gms.ads.internal.zzt.zzo().zzg();
            map = this.zzb;
        }
        return map;
    }

    public final void zzc(@Nullable zzbgu zzbguVar) {
        synchronized (this.zzc) {
        }
    }

    public final void zzd(String str, String str2) {
        zzbgk zzbgkVarZzg;
        if (TextUtils.isEmpty(str2) || (zzbgkVarZzg = com.google.android.gms.ads.internal.zzt.zzo().zzg()) == null) {
            return;
        }
        synchronized (this.zzc) {
            zzbgq zzbgqVarZza = zzbgkVarZzg.zza(str);
            Map map = this.zzb;
            map.put(str, zzbgqVarZza.zza((String) map.get(str), str2));
        }
    }

    public final boolean zze(zzbgr zzbgrVar, long j11, String... strArr) {
        synchronized (this.zzc) {
            for (int i11 = 0; i11 <= 0; i11++) {
                try {
                    this.zza.add(new zzbgr(j11, strArr[i11], zzbgrVar));
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return true;
    }
}
