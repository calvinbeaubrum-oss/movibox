package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbrj {
    private final Context zzb;
    private final String zzc;
    private final zzcei zzd;

    @Nullable
    private final zzfnc zze;
    private final com.google.android.gms.ads.internal.util.zzbd zzf;
    private final com.google.android.gms.ads.internal.util.zzbd zzg;

    @Nullable
    private zzbri zzh;
    private final Object zza = new Object();
    private int zzi = 1;

    public zzbrj(Context context, zzcei zzceiVar, String str, com.google.android.gms.ads.internal.util.zzbd zzbdVar, com.google.android.gms.ads.internal.util.zzbd zzbdVar2, @Nullable zzfnc zzfncVar) {
        this.zzc = str;
        this.zzb = context.getApplicationContext();
        this.zzd = zzceiVar;
        this.zze = zzfncVar;
        this.zzf = zzbdVar;
        this.zzg = zzbdVar2;
    }

    public final zzbrd zzb(@Nullable zzavi zzaviVar) {
        com.google.android.gms.ads.internal.util.zze.zza("getEngine: Trying to acquire lock");
        synchronized (this.zza) {
            try {
                com.google.android.gms.ads.internal.util.zze.zza("getEngine: Lock acquired");
                com.google.android.gms.ads.internal.util.zze.zza("refreshIfDestroyed: Trying to acquire lock");
                synchronized (this.zza) {
                    try {
                        com.google.android.gms.ads.internal.util.zze.zza("refreshIfDestroyed: Lock acquired");
                        zzbri zzbriVar = this.zzh;
                        if (zzbriVar != null && this.zzi == 0) {
                            zzbriVar.zzi(new zzcey() { // from class: com.google.android.gms.internal.ads.zzbqp
                                @Override // com.google.android.gms.internal.ads.zzcey
                                public final void zza(Object obj) {
                                    this.zza.zzk((zzbqe) obj);
                                }
                            }, new zzcew() { // from class: com.google.android.gms.internal.ads.zzbqq
                                @Override // com.google.android.gms.internal.ads.zzcew
                                public final void zza() {
                                }
                            });
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                com.google.android.gms.ads.internal.util.zze.zza("refreshIfDestroyed: Lock released");
                zzbri zzbriVar2 = this.zzh;
                if (zzbriVar2 != null && zzbriVar2.zze() != -1) {
                    int i11 = this.zzi;
                    if (i11 == 0) {
                        com.google.android.gms.ads.internal.util.zze.zza("getEngine (NO_UPDATE): Lock released");
                        return this.zzh.zza();
                    }
                    if (i11 != 1) {
                        com.google.android.gms.ads.internal.util.zze.zza("getEngine (UPDATING): Lock released");
                        return this.zzh.zza();
                    }
                    this.zzi = 2;
                    zzd(null);
                    com.google.android.gms.ads.internal.util.zze.zza("getEngine (PENDING_UPDATE): Lock released");
                    return this.zzh.zza();
                }
                this.zzi = 2;
                this.zzh = zzd(null);
                com.google.android.gms.ads.internal.util.zze.zza("getEngine (NULL or REJECTED): Lock released");
                return this.zzh.zza();
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public final zzbri zzd(@Nullable zzavi zzaviVar) {
        zzfmo zzfmoVarZza = zzfmn.zza(this.zzb, 6);
        zzfmoVarZza.zzh();
        final zzbri zzbriVar = new zzbri(this.zzg);
        com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > Before UI_THREAD_EXECUTOR");
        final zzavi zzaviVar2 = null;
        zzcep.zze.execute(new Runnable(zzaviVar2, zzbriVar) { // from class: com.google.android.gms.internal.ads.zzbqt
            public final /* synthetic */ zzbri zzb;

            {
                this.zzb = zzbriVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzj(null, this.zzb);
            }
        });
        com.google.android.gms.ads.internal.util.zze.zza("loadNewJavascriptEngine: Promise created");
        zzbriVar.zzi(new zzbqy(this, zzbriVar, zzfmoVarZza), new zzbqz(this, zzbriVar, zzfmoVarZza));
        return zzbriVar;
    }

    public final /* synthetic */ void zzi(zzbri zzbriVar, final zzbqe zzbqeVar, ArrayList arrayList, long j11) {
        com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > newEngine.setLoadedListener(postDelayed): Trying to acquire lock");
        synchronized (this.zza) {
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > newEngine.setLoadedListener(postDelayed): Lock acquired");
            if (zzbriVar.zze() != -1 && zzbriVar.zze() != 1) {
                zzbriVar.zzg();
                zzgey zzgeyVar = zzcep.zze;
                Objects.requireNonNull(zzbqeVar);
                zzgeyVar.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbqr
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzbqeVar.zzc();
                    }
                });
                com.google.android.gms.ads.internal.util.zze.zza("Could not receive /jsLoaded in " + String.valueOf(com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzc)) + " ms. JS engine session reference status(onEngLoadedTimeout) is " + zzbriVar.zze() + ". Update status(onEngLoadedTimeout) is " + this.zzi + ". LoadNewJavascriptEngine(onEngLoadedTimeout) latency is " + String.valueOf(arrayList.get(0)) + " ms. Total latency(onEngLoadedTimeout) is " + (com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis() - j11) + " ms. Rejecting.");
                com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > newEngine.setLoadedListener(postDelayed): Lock released");
                return;
            }
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > newEngine.setLoadedListener(postDelayed): Lock released, the promise is already settled");
        }
    }

    public final /* synthetic */ void zzj(zzavi zzaviVar, zzbri zzbriVar) {
        long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        try {
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > Before createJavascriptEngine");
            zzbqm zzbqmVar = new zzbqm(this.zzb, this.zzd, null, null);
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > After createJavascriptEngine");
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > Before setting new engine loaded listener");
            zzbqmVar.zzk(new zzbqs(this, arrayList, jCurrentTimeMillis, zzbriVar, zzbqmVar));
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > Before registering GmsgHandler for /jsLoaded");
            zzbqmVar.zzq("/jsLoaded", new zzbqu(this, jCurrentTimeMillis, zzbriVar, zzbqmVar));
            com.google.android.gms.ads.internal.util.zzcc zzccVar = new com.google.android.gms.ads.internal.util.zzcc();
            zzbqv zzbqvVar = new zzbqv(this, null, zzbqmVar, zzccVar);
            zzccVar.zzb(zzbqvVar);
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > Before registering GmsgHandler for /requestReload");
            zzbqmVar.zzq("/requestReload", zzbqvVar);
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > javascriptPath: ".concat(String.valueOf(this.zzc)));
            if (this.zzc.endsWith(".js")) {
                com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > Before newEngine.loadJavascript");
                zzbqmVar.zzh(this.zzc);
                com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > After newEngine.loadJavascript");
            } else if (this.zzc.startsWith("<html>")) {
                com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > Before newEngine.loadHtml");
                zzbqmVar.zzf(this.zzc);
                com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > After newEngine.loadHtml");
            } else {
                com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > Before newEngine.loadHtmlWrapper");
                zzbqmVar.zzg(this.zzc);
                com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > After newEngine.loadHtmlWrapper");
            }
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > Before calling ADMOB_UI_HANDLER.postDelayed");
            com.google.android.gms.ads.internal.util.zzt.zza.postDelayed(new zzbqx(this, zzbriVar, zzbqmVar, arrayList, jCurrentTimeMillis), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzd)).intValue());
        } catch (Throwable th2) {
            zzcec.zzh("Error creating webview.", th2);
            com.google.android.gms.ads.internal.zzt.zzo().zzw(th2, "SdkJavascriptFactory.loadJavascriptEngine");
            zzbriVar.zzg();
        }
    }

    public final /* synthetic */ void zzk(zzbqe zzbqeVar) {
        if (zzbqeVar.zzi()) {
            this.zzi = 1;
        }
    }
}
