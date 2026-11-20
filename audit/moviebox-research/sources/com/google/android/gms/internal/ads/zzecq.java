package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import com.google.common.util.concurrent.s;
import java.io.InputStream;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzecq {
    private final zzgey zza;
    private final zzebw zzb;
    private final zzhgx zzc;
    private final zzfnc zzd;
    private final Context zze;
    private final zzcei zzf;

    public zzecq(zzgey zzgeyVar, zzebw zzebwVar, zzhgx zzhgxVar, zzfnc zzfncVar, Context context, zzcei zzceiVar) {
        this.zza = zzgeyVar;
        this.zzb = zzebwVar;
        this.zzc = zzhgxVar;
        this.zzd = zzfncVar;
        this.zze = context;
        this.zzf = zzceiVar;
    }

    private final s zzh(final zzbze zzbzeVar, zzecp zzecpVar, final zzecp zzecpVar2, final zzgdu zzgduVar) {
        s sVarZzf;
        String str = zzbzeVar.zzd;
        com.google.android.gms.ads.internal.zzt.zzp();
        if (com.google.android.gms.ads.internal.util.zzt.zzB(str)) {
            sVarZzf = zzgen.zzg(new zzecf(1));
        } else {
            sVarZzf = zzgen.zzf(zzecpVar.zza(zzbzeVar), ExecutionException.class, new zzgdu() { // from class: com.google.android.gms.internal.ads.zzeco
                @Override // com.google.android.gms.internal.ads.zzgdu
                public final s zza(Object obj) {
                    Throwable cause = (ExecutionException) obj;
                    if (cause.getCause() != null) {
                        cause = cause.getCause();
                    }
                    return zzgen.zzg(cause);
                }
            }, this.zza);
        }
        return zzgen.zzf(zzgen.zzn(zzgee.zzu(sVarZzf), zzgduVar, this.zza), zzecf.class, new zzgdu() { // from class: com.google.android.gms.internal.ads.zzecn
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final s zza(Object obj) {
                return this.zza.zzc(zzecpVar2, zzbzeVar, zzgduVar, (zzecf) obj);
            }
        }, this.zza);
    }

    public final s zza(final zzbze zzbzeVar) {
        zzgdu zzgduVar = new zzgdu() { // from class: com.google.android.gms.internal.ads.zzeck
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final s zza(Object obj) {
                String str = new String(zzgci.zzb((InputStream) obj), zzfwq.zzc);
                zzbze zzbzeVar2 = zzbzeVar;
                zzbzeVar2.zzj = str;
                return zzgen.zzh(zzbzeVar2);
            }
        };
        final zzebw zzebwVar = this.zzb;
        Objects.requireNonNull(zzebwVar);
        return zzh(zzbzeVar, new zzecp() { // from class: com.google.android.gms.internal.ads.zzecl
            @Override // com.google.android.gms.internal.ads.zzecp
            public final s zza(zzbze zzbzeVar2) {
                return zzebwVar.zzb(zzbzeVar2);
            }
        }, new zzecp() { // from class: com.google.android.gms.internal.ads.zzecm
            @Override // com.google.android.gms.internal.ads.zzecp
            public final s zza(zzbze zzbzeVar2) {
                return this.zza.zzd(zzbzeVar2);
            }
        }, zzgduVar);
    }

    public final s zzb(JSONObject jSONObject) {
        return zzgen.zzn(zzgee.zzu(zzgen.zzh(jSONObject)), com.google.android.gms.ads.internal.zzt.zzf().zza(this.zze, this.zzf, this.zzd).zza("AFMA_getAdDictionary", zzbru.zza, new zzbrp() { // from class: com.google.android.gms.internal.ads.zzecg
            @Override // com.google.android.gms.internal.ads.zzbrp
            public final Object zza(JSONObject jSONObject2) {
                return new zzbzh(jSONObject2);
            }
        }), this.zza);
    }

    public final /* synthetic */ s zzc(zzecp zzecpVar, zzbze zzbzeVar, zzgdu zzgduVar, zzecf zzecfVar) throws Exception {
        return zzgen.zzn(zzecpVar.zza(zzbzeVar), zzgduVar, this.zza);
    }

    public final /* synthetic */ s zzd(zzbze zzbzeVar) {
        return ((zzeem) this.zzc.zzb()).zzb(zzbzeVar, Binder.getCallingUid());
    }

    public final /* synthetic */ s zze(zzbze zzbzeVar) {
        return this.zzb.zzc(zzbzeVar.zzh);
    }

    public final /* synthetic */ s zzf(zzbze zzbzeVar) {
        return ((zzeem) this.zzc.zzb()).zzi(zzbzeVar.zzh);
    }

    public final s zzg(zzbze zzbzeVar) {
        return zzh(zzbzeVar, new zzecp() { // from class: com.google.android.gms.internal.ads.zzeci
            @Override // com.google.android.gms.internal.ads.zzecp
            public final s zza(zzbze zzbzeVar2) {
                return this.zza.zze(zzbzeVar2);
            }
        }, new zzecp() { // from class: com.google.android.gms.internal.ads.zzecj
            @Override // com.google.android.gms.internal.ads.zzecp
            public final s zza(zzbze zzbzeVar2) {
                return this.zza.zzf(zzbzeVar2);
            }
        }, new zzgdu() { // from class: com.google.android.gms.internal.ads.zzech
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final s zza(Object obj) {
                return zzgen.zzh(null);
            }
        });
    }
}
