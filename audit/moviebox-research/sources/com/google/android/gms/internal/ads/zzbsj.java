package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.s;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbsj implements zzgdu {
    private final zzbrp zza;
    private final zzbrq zzb;
    private final String zzc = "google.afma.activeView.handleUpdate";
    private final s zzd;

    public zzbsj(s sVar, String str, zzbrq zzbrqVar, zzbrp zzbrpVar) {
        this.zzd = sVar;
        this.zzb = zzbrqVar;
        this.zza = zzbrpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdu
    public final s zza(Object obj) throws Exception {
        return zzb(obj);
    }

    public final s zzb(final Object obj) {
        return zzgen.zzn(this.zzd, new zzgdu() { // from class: com.google.android.gms.internal.ads.zzbsh
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final s zza(Object obj2) {
                return this.zza.zzc(obj, (zzbrk) obj2);
            }
        }, zzcep.zzf);
    }

    public final /* synthetic */ s zzc(Object obj, zzbrk zzbrkVar) throws Exception {
        zzceu zzceuVar = new zzceu();
        com.google.android.gms.ads.internal.zzt.zzp();
        String string = UUID.randomUUID().toString();
        zzbnf.zzo.zzc(string, new zzbsi(this, zzceuVar));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", string);
        jSONObject.put("args", (JSONObject) obj);
        zzbrkVar.zzl(this.zzc, jSONObject);
        return zzceuVar;
    }
}
