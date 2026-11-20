package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.common.util.concurrent.s;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbzo extends zzbzp {
    private final Object zza = new Object();
    private final Context zzb;

    @Nullable
    private SharedPreferences zzc;
    private final zzbrn zzd;

    public zzbzo(Context context, zzbrn zzbrnVar) {
        this.zzb = context.getApplicationContext();
        this.zzd = zzbrnVar;
    }

    public static JSONObject zzc(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("js", zzcei.zza().zza);
            jSONObject.put("mf", zzbia.zza.zze());
            jSONObject.put("cl", "610756093");
            jSONObject.put("rapid_rc", "dev");
            jSONObject.put("rapid_rollup", "HEAD");
            jSONObject.put("admob_module_version", 12451000);
            jSONObject.put("dynamite_local_version", ModuleDescriptor.MODULE_VERSION);
            jSONObject.put("dynamite_version", DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID));
            jSONObject.put("container_version", 12451000);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @Override // com.google.android.gms.internal.ads.zzbzp
    public final s zza() {
        synchronized (this.zza) {
            try {
                if (this.zzc == null) {
                    this.zzc = this.zzb.getSharedPreferences("google_ads_flags_meta", 0);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis() - this.zzc.getLong("js_last_update", 0L) < ((Long) zzbia.zzb.zze()).longValue()) {
            return zzgen.zzh(null);
        }
        return zzgen.zzm(this.zzd.zzb(zzc(this.zzb)), new zzfws() { // from class: com.google.android.gms.internal.ads.zzbzn
            @Override // com.google.android.gms.internal.ads.zzfws
            public final Object apply(Object obj) {
                this.zza.zzb((JSONObject) obj);
                return null;
            }
        }, zzcep.zzf);
    }

    public final /* synthetic */ Void zzb(JSONObject jSONObject) {
        zzbfu zzbfuVar = zzbgc.zza;
        com.google.android.gms.ads.internal.client.zzba.zzb();
        SharedPreferences.Editor editorEdit = zzbfw.zza(this.zzb).edit();
        com.google.android.gms.ads.internal.client.zzba.zza();
        zzbhm zzbhmVar = zzbhr.zza;
        com.google.android.gms.ads.internal.client.zzba.zza().zze(editorEdit, 1, jSONObject);
        com.google.android.gms.ads.internal.client.zzba.zzb();
        editorEdit.commit();
        this.zzc.edit().putLong("js_last_update", com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis()).apply();
        return null;
    }
}
