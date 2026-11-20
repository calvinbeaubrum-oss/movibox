package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.common.util.concurrent.s;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcdl {
    private final Object zza = new Object();
    private final com.google.android.gms.ads.internal.util.zzj zzb;
    private final zzcdp zzc;
    private boolean zzd;
    private Context zze;
    private zzcei zzf;
    private String zzg;

    @Nullable
    private zzbgk zzh;

    @Nullable
    private Boolean zzi;
    private final AtomicInteger zzj;
    private final AtomicInteger zzk;
    private final zzcdk zzl;
    private final Object zzm;
    private s zzn;
    private final AtomicBoolean zzo;

    public zzcdl() {
        com.google.android.gms.ads.internal.util.zzj zzjVar = new com.google.android.gms.ads.internal.util.zzj();
        this.zzb = zzjVar;
        this.zzc = new zzcdp(com.google.android.gms.ads.internal.client.zzay.zzd(), zzjVar);
        this.zzd = false;
        this.zzh = null;
        this.zzi = null;
        this.zzj = new AtomicInteger(0);
        this.zzk = new AtomicInteger(0);
        this.zzl = new zzcdk(null);
        this.zzm = new Object();
        this.zzo = new AtomicBoolean();
    }

    public final int zza() {
        return this.zzk.get();
    }

    public final int zzb() {
        return this.zzj.get();
    }

    @Nullable
    public final Context zzd() {
        return this.zze;
    }

    @Nullable
    public final Resources zze() {
        if (this.zzf.zzd) {
            return this.zze.getResources();
        }
        try {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzkq)).booleanValue()) {
                return zzceg.zza(this.zze).getResources();
            }
            zzceg.zza(this.zze).getResources();
            return null;
        } catch (zzcef e11) {
            zzcec.zzk("Cannot load resource from dynamite apk or local jar", e11);
            return null;
        }
    }

    @Nullable
    public final zzbgk zzg() {
        zzbgk zzbgkVar;
        synchronized (this.zza) {
            zzbgkVar = this.zzh;
        }
        return zzbgkVar;
    }

    public final zzcdp zzh() {
        return this.zzc;
    }

    public final com.google.android.gms.ads.internal.util.zzg zzi() {
        com.google.android.gms.ads.internal.util.zzj zzjVar;
        synchronized (this.zza) {
            zzjVar = this.zzb;
        }
        return zzjVar;
    }

    public final s zzk() {
        if (this.zze != null) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcB)).booleanValue()) {
                synchronized (this.zzm) {
                    try {
                        s sVar = this.zzn;
                        if (sVar != null) {
                            return sVar;
                        }
                        s sVarZzb = zzcep.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzcdg
                            @Override // java.util.concurrent.Callable
                            public final Object call() {
                                return this.zza.zzo();
                            }
                        });
                        this.zzn = sVarZzb;
                        return sVarZzb;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        }
        return zzgen.zzh(new ArrayList());
    }

    public final Boolean zzl() {
        Boolean bool;
        synchronized (this.zza) {
            bool = this.zzi;
        }
        return bool;
    }

    public final String zzn() {
        return this.zzg;
    }

    public final /* synthetic */ ArrayList zzo() throws Exception {
        Context contextZza = zzbzs.zza(this.zze);
        ArrayList arrayList = new ArrayList();
        try {
            PackageInfo packageInfo = Wrappers.packageManager(contextZza).getPackageInfo(contextZza.getApplicationInfo().packageName, 4096);
            if (packageInfo.requestedPermissions != null && packageInfo.requestedPermissionsFlags != null) {
                int i11 = 0;
                while (true) {
                    String[] strArr = packageInfo.requestedPermissions;
                    if (i11 >= strArr.length) {
                        break;
                    }
                    if ((packageInfo.requestedPermissionsFlags[i11] & 2) != 0) {
                        arrayList.add(strArr[i11]);
                    }
                    i11++;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return arrayList;
    }

    public final void zzq() {
        this.zzl.zza();
    }

    public final void zzr() {
        this.zzj.decrementAndGet();
    }

    public final void zzs() {
        this.zzk.incrementAndGet();
    }

    public final void zzt() {
        this.zzj.incrementAndGet();
    }

    @TargetApi(23)
    public final void zzu(Context context, zzcei zzceiVar) {
        zzbgk zzbgkVar;
        synchronized (this.zza) {
            try {
                if (!this.zzd) {
                    this.zze = context.getApplicationContext();
                    this.zzf = zzceiVar;
                    com.google.android.gms.ads.internal.zzt.zzb().zzc(this.zzc);
                    this.zzb.zzr(this.zze);
                    zzbxw.zzb(this.zze, this.zzf);
                    com.google.android.gms.ads.internal.zzt.zze();
                    if (((Boolean) zzbhu.zzc.zze()).booleanValue()) {
                        zzbgkVar = new zzbgk();
                    } else {
                        com.google.android.gms.ads.internal.util.zze.zza("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
                        zzbgkVar = null;
                    }
                    this.zzh = zzbgkVar;
                    if (zzbgkVar != null) {
                        zzces.zza(new zzcdh(this).zzb(), "AppState.registerCsiReporter");
                    }
                    if (PlatformVersion.isAtLeastO()) {
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzim)).booleanValue()) {
                            ((ConnectivityManager) context.getSystemService("connectivity")).registerDefaultNetworkCallback(new zzcdi(this));
                        }
                    }
                    this.zzd = true;
                    zzk();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        com.google.android.gms.ads.internal.zzt.zzp().zzc(context, zzceiVar.zza);
    }

    public final void zzv(Throwable th2, String str) {
        zzbxw.zzb(this.zze, this.zzf).zzh(th2, str, ((Double) zzbij.zzg.zze()).floatValue());
    }

    public final void zzw(Throwable th2, String str) {
        zzbxw.zzb(this.zze, this.zzf).zzg(th2, str);
    }

    public final void zzx(Boolean bool) {
        synchronized (this.zza) {
            this.zzi = bool;
        }
    }

    public final void zzy(String str) {
        this.zzg = str;
    }

    public final boolean zzz(Context context) {
        if (PlatformVersion.isAtLeastO()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzim)).booleanValue()) {
                return this.zzo.get();
            }
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
