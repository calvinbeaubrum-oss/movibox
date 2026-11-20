package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.util.IOUtils;
import com.google.common.util.concurrent.s;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcik extends zzgq {
    private final Context zza;
    private final zzgw zzb;
    private final String zzc;
    private final int zzd;
    private final boolean zze;
    private InputStream zzf;
    private boolean zzg;
    private Uri zzh;
    private volatile zzbbb zzi;
    private boolean zzj;
    private boolean zzk;
    private boolean zzl;
    private boolean zzm;
    private long zzn;
    private s zzo;
    private final AtomicLong zzp;
    private final zzciv zzq;

    public zzcik(Context context, zzgw zzgwVar, String str, int i11, zzhy zzhyVar, zzciv zzcivVar) {
        super(false);
        this.zza = context;
        this.zzb = zzgwVar;
        this.zzq = zzcivVar;
        this.zzc = str;
        this.zzd = i11;
        this.zzj = false;
        this.zzk = false;
        this.zzl = false;
        this.zzm = false;
        this.zzn = 0L;
        this.zzp = new AtomicLong(-1L);
        this.zzo = null;
        this.zze = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbQ)).booleanValue();
        zzf(zzhyVar);
    }

    private final boolean zzr() {
        if (!this.zze) {
            return false;
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzem)).booleanValue() || this.zzl) {
            return ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzen)).booleanValue() && !this.zzm;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzu
    public final int zza(byte[] bArr, int i11, int i12) throws IOException {
        if (!this.zzg) {
            throw new IOException("Attempt to read closed GcacheDataSource.");
        }
        InputStream inputStream = this.zzf;
        int iZza = inputStream != null ? inputStream.read(bArr, i11, i12) : this.zzb.zza(bArr, i11, i12);
        if (!this.zze || this.zzf != null) {
            zzg(iZza);
        }
        return iZza;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.google.android.gms.internal.ads.zzcix] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.ads.zzgw
    public final long zzb(zzhb zzhbVar) throws Throwable {
        zzbay zzbayVarZzb;
        Long l11;
        boolean z11;
        boolean z12;
        long jElapsedRealtime;
        String string = "ms";
        if (this.zzg) {
            throw new IOException("Attempt to open an already open GcacheDataSource.");
        }
        ?? r11 = 1;
        this.zzg = true;
        this.zzh = zzhbVar.zza;
        if (!this.zze) {
            zzj(zzhbVar);
        }
        this.zzi = zzbbb.zza(zzhbVar.zza);
        ?? sb2 = -1;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzej)).booleanValue()) {
            if (this.zzi != null) {
                this.zzi.zzh = zzhbVar.zzf;
                this.zzi.zzi = zzfxt.zzc(this.zzc);
                this.zzi.zzj = this.zzd;
                zzbayVarZzb = com.google.android.gms.ads.internal.zzt.zzc().zzb(this.zzi);
            } else {
                zzbayVarZzb = null;
            }
            if (zzbayVarZzb != null && zzbayVarZzb.zze()) {
                this.zzj = zzbayVarZzb.zzd();
                this.zzl = zzbayVarZzb.zzg();
                this.zzm = zzbayVarZzb.zzf();
                this.zzn = zzbayVarZzb.zza();
                this.zzk = true;
                if (!zzr()) {
                    this.zzf = zzbayVarZzb.zzc();
                    if (this.zze) {
                        zzj(zzhbVar);
                    }
                    return -1L;
                }
            }
        } else if (this.zzi != null) {
            this.zzi.zzh = zzhbVar.zzf;
            this.zzi.zzi = zzfxt.zzc(this.zzc);
            this.zzi.zzj = this.zzd;
            if (this.zzi.zzg) {
                l11 = (Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzel);
            } else {
                l11 = (Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzek);
            }
            long jLongValue = l11.longValue();
            long jElapsedRealtime2 = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();
            com.google.android.gms.ads.internal.zzt.zzd();
            Future futureZza = zzbbm.zza(this.zza, this.zzi);
            try {
                try {
                    zzbbn zzbbnVar = (zzbbn) futureZza.get(jLongValue, TimeUnit.MILLISECONDS);
                    try {
                        this.zzj = zzbbnVar.zzd();
                        this.zzl = zzbbnVar.zzf();
                        this.zzm = zzbbnVar.zze();
                        this.zzn = zzbbnVar.zza();
                        if (!zzr()) {
                            this.zzf = zzbbnVar.zzc();
                            if (this.zze) {
                                zzj(zzhbVar);
                            }
                            long jElapsedRealtime3 = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - jElapsedRealtime2;
                            this.zzq.zza.zzab(true, jElapsedRealtime3);
                            this.zzk = true;
                            com.google.android.gms.ads.internal.util.zze.zza("Cache connection took " + jElapsedRealtime3 + "ms");
                            return -1L;
                        }
                        long jElapsedRealtime4 = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - jElapsedRealtime2;
                        this.zzq.zza.zzab(true, jElapsedRealtime4);
                        this.zzk = true;
                        string = "Cache connection took " + jElapsedRealtime4 + "ms";
                    } catch (InterruptedException unused) {
                        z12 = true;
                        futureZza.cancel(true);
                        Thread.currentThread().interrupt();
                        jElapsedRealtime = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - jElapsedRealtime2;
                        this.zzq.zza.zzab(z12, jElapsedRealtime);
                        this.zzk = z12;
                        sb2 = new StringBuilder();
                        sb2.append("Cache connection took ");
                        sb2.append(jElapsedRealtime);
                        sb2.append("ms");
                        string = sb2.toString();
                    } catch (ExecutionException | TimeoutException unused2) {
                        z11 = true;
                        futureZza.cancel(true);
                        jElapsedRealtime = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - jElapsedRealtime2;
                        this.zzq.zza.zzab(z11, jElapsedRealtime);
                        this.zzk = z11;
                        sb2 = new StringBuilder();
                        sb2.append("Cache connection took ");
                        sb2.append(jElapsedRealtime);
                        sb2.append("ms");
                        string = sb2.toString();
                    } catch (Throwable th2) {
                        th = th2;
                        long jElapsedRealtime5 = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - jElapsedRealtime2;
                        this.zzq.zza.zzab(r11, jElapsedRealtime5);
                        this.zzk = r11;
                        com.google.android.gms.ads.internal.util.zze.zza("Cache connection took " + jElapsedRealtime5 + string);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    r11 = sb2;
                }
            } catch (InterruptedException unused3) {
                z12 = false;
            } catch (ExecutionException | TimeoutException unused4) {
                z11 = false;
            } catch (Throwable th4) {
                th = th4;
                r11 = 0;
            }
            com.google.android.gms.ads.internal.util.zze.zza(string);
        }
        this.zzk = false;
        if (this.zzi != null) {
            zzhbVar = new zzhb(Uri.parse(this.zzi.zza), null, zzhbVar.zze, zzhbVar.zzf, zzhbVar.zzg, null, zzhbVar.zzi);
        }
        return this.zzb.zzb(zzhbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final Uri zzc() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final void zzd() throws IOException {
        if (!this.zzg) {
            throw new IOException("Attempt to close an already closed GcacheDataSource.");
        }
        this.zzg = false;
        this.zzh = null;
        boolean z11 = (this.zze && this.zzf == null) ? false : true;
        InputStream inputStream = this.zzf;
        if (inputStream != null) {
            IOUtils.closeQuietly(inputStream);
            this.zzf = null;
        } else {
            this.zzb.zzd();
        }
        if (z11) {
            zzh();
        }
    }

    public final long zzk() {
        return this.zzn;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long zzl() {
        if (this.zzi != null) {
            if (this.zzp.get() != -1) {
                return this.zzp.get();
            }
            synchronized (this) {
                try {
                    if (this.zzo == null) {
                        this.zzo = zzcep.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzcij
                            @Override // java.util.concurrent.Callable
                            public final Object call() {
                                return this.zza.zzm();
                            }
                        });
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (this.zzo.isDone()) {
                try {
                    this.zzp.compareAndSet(-1L, ((Long) this.zzo.get()).longValue());
                    return this.zzp.get();
                } catch (InterruptedException | ExecutionException unused) {
                }
            }
        }
        return -1L;
    }

    public final /* synthetic */ Long zzm() throws Exception {
        return Long.valueOf(com.google.android.gms.ads.internal.zzt.zzc().zza(this.zzi));
    }

    public final boolean zzn() {
        return this.zzj;
    }

    public final boolean zzo() {
        return this.zzm;
    }

    public final boolean zzp() {
        return this.zzl;
    }

    public final boolean zzq() {
        return this.zzk;
    }
}
