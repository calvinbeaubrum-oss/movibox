package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzccm {
    private final Map zza = new HashMap();
    private final List zzb = new ArrayList();
    private final Context zzc;
    private final zzcbx zzd;

    public zzccm(Context context, zzcbx zzcbxVar) {
        this.zzc = context;
        this.zzd = zzcbxVar;
    }

    public final /* synthetic */ void zzb(Map map, SharedPreferences sharedPreferences, String str, String str2) {
        if (map.containsKey(str) && ((Set) map.get(str)).contains(str2)) {
            this.zzd.zzd();
        }
    }

    public final synchronized void zzc(String str) {
        try {
            if (this.zza.containsKey(str)) {
                return;
            }
            SharedPreferences defaultSharedPreferences = Objects.equals(str, "__default__") ? PreferenceManager.getDefaultSharedPreferences(this.zzc) : this.zzc.getSharedPreferences(str, 0);
            zzccl zzcclVar = new zzccl(this, str);
            this.zza.put(str, zzcclVar);
            defaultSharedPreferences.registerOnSharedPreferenceChangeListener(zzcclVar);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void zzd(zzcck zzcckVar) {
        this.zzb.add(zzcckVar);
    }
}
