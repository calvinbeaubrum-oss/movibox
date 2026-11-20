package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdyy {
    private final zzdyi zza;
    private final zzdtx zzb;
    private final Object zzc = new Object();
    private final List zzd = new ArrayList();
    private boolean zze;

    public zzdyy(zzdyi zzdyiVar, zzdtx zzdtxVar) {
        this.zza = zzdyiVar;
        this.zzb = zzdtxVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzd(List list) {
        zzdtw zzdtwVarZza;
        zzdtw zzdtwVarZza2;
        zzbvg zzbvgVar;
        synchronized (this.zzc) {
            try {
                if (this.zze) {
                    return;
                }
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    zzbpd zzbpdVar = (zzbpd) it.next();
                    String string = (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjj)).booleanValue() || (zzdtwVarZza2 = this.zzb.zza(zzbpdVar.zza)) == null || (zzbvgVar = zzdtwVarZza2.zzc) == null) ? "" : zzbvgVar.toString();
                    String str = string;
                    boolean z11 = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjk)).booleanValue() && (zzdtwVarZza = this.zzb.zza(zzbpdVar.zza)) != null && zzdtwVarZza.zzd;
                    List list2 = this.zzd;
                    String str2 = zzbpdVar.zza;
                    list2.add(new zzdyx(str2, str, this.zzb.zzc(str2), zzbpdVar.zzb ? 1 : 0, zzbpdVar.zzd, zzbpdVar.zzc, z11));
                }
                this.zze = true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0031 A[Catch: all -> 0x001e, LOOP:0: B:15:0x002b->B:17:0x0031, LOOP_END, TryCatch #0 {all -> 0x001e, blocks: (B:4:0x0008, B:6:0x000c, B:8:0x0014, B:11:0x0020, B:12:0x0023, B:14:0x0025, B:15:0x002b, B:17:0x0031, B:18:0x003f), top: B:22:0x0008 }] */
    public final JSONArray zza() throws JSONException {
        Iterator it;
        JSONArray jSONArray = new JSONArray();
        synchronized (this.zzc) {
            try {
                if (this.zze) {
                    it = this.zzd.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(((zzdyx) it.next()).zza());
                    }
                } else if (this.zza.zzt()) {
                    zzd(this.zza.zzg());
                    it = this.zzd.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(((zzdyx) it.next()).zza());
                    }
                } else {
                    zzc();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return jSONArray;
    }

    public final void zzc() {
        this.zza.zzs(new zzdyw(this));
    }
}
