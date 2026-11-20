package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.common.util.concurrent.s;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbsb implements zzbrn {
    private final zzbrp zza;
    private final zzbrq zzb;
    private final zzbrj zzc;
    private final String zzd;

    public zzbsb(zzbrj zzbrjVar, String str, zzbrq zzbrqVar, zzbrp zzbrpVar) {
        this.zzc = zzbrjVar;
        this.zzd = str;
        this.zzb = zzbrqVar;
        this.zza = zzbrpVar;
    }

    public static /* bridge */ /* synthetic */ void zzd(zzbsb zzbsbVar, zzbrd zzbrdVar, zzbrk zzbrkVar, Object obj, zzceu zzceuVar) {
        try {
            com.google.android.gms.ads.internal.zzt.zzp();
            String string = UUID.randomUUID().toString();
            zzbnf.zzo.zzc(string, new zzbsa(zzbsbVar, zzbrdVar, zzceuVar));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", string);
            jSONObject.put("args", zzbsbVar.zzb.zzb(obj));
            zzbrkVar.zzl(zzbsbVar.zzd, jSONObject);
        } catch (Exception e11) {
            try {
                zzceuVar.zzd(e11);
                zzcec.zzh("Unable to invokeJavascript", e11);
            } finally {
                zzbrdVar.zzb();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgdu
    public final s zza(@Nullable Object obj) throws Exception {
        return zzb(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzbrn
    public final s zzb(Object obj) {
        zzceu zzceuVar = new zzceu();
        zzbrd zzbrdVarZzb = this.zzc.zzb(null);
        com.google.android.gms.ads.internal.util.zze.zza("callJs > getEngine: Promise created");
        zzbrdVarZzb.zzi(new zzbry(this, zzbrdVarZzb, obj, zzceuVar), new zzbrz(this, zzceuVar, zzbrdVarZzb));
        return zzceuVar;
    }
}
