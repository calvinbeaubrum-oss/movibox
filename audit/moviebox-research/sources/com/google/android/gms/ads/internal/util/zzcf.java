package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.android.gms.internal.ads.zzbgc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcf {
    private final Map zza = new HashMap();
    private final List zzb = new ArrayList();
    private final Context zzc;

    public zzcf(Context context) {
        this.zzc = context;
    }

    public final synchronized void zzb(String str) {
        try {
            if (this.zza.containsKey(str)) {
                return;
            }
            SharedPreferences defaultSharedPreferences = Objects.equals(str, "__default__") ? PreferenceManager.getDefaultSharedPreferences(this.zzc) : this.zzc.getSharedPreferences(str, 0);
            zzce zzceVar = new zzce(this, str);
            this.zza.put(str, zzceVar);
            defaultSharedPreferences.registerOnSharedPreferenceChangeListener(zzceVar);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void zzc() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjU)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.zzp();
            Map mapZzu = zzt.zzu((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjY));
            Iterator it = mapZzu.keySet().iterator();
            while (it.hasNext()) {
                zzb((String) it.next());
            }
            zzd(new zzcd(mapZzu));
        }
    }

    public final synchronized void zzd(zzcd zzcdVar) {
        this.zzb.add(zzcdVar);
    }
}
