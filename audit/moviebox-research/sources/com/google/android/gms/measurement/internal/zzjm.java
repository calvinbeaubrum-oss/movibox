package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@VisibleForTesting
public final class zzjm extends zzf {
    private final zzjl zza;
    private zzdx zzb;
    private volatile Boolean zzc;
    private final zzap zzd;
    private final zzkd zze;
    private final List zzf;
    private final zzap zzg;

    public zzjm(zzfr zzfrVar) {
        super(zzfrVar);
        this.zzf = new ArrayList();
        this.zze = new zzkd(zzfrVar.zzav());
        this.zza = new zzjl(this);
        this.zzd = new zziw(this, zzfrVar);
        this.zzg = new zziy(this, zzfrVar);
    }

    private final zzq zzO(boolean z11) {
        Pair pairZza;
        this.zzt.zzaw();
        zzdy zzdyVarZzh = this.zzt.zzh();
        String str = null;
        if (z11) {
            zzeh zzehVarZzay = this.zzt.zzay();
            if (zzehVarZzay.zzt.zzm().zzb != null && (pairZza = zzehVarZzay.zzt.zzm().zzb.zza()) != null && pairZza != zzew.zza) {
                str = String.valueOf(pairZza.second) + ":" + ((String) pairZza.first);
            }
        }
        return zzdyVarZzh.zzj(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzP() {
        zzg();
        this.zzt.zzay().zzj().zzb("Processing queued up service tasks", Integer.valueOf(this.zzf.size()));
        Iterator it = this.zzf.iterator();
        while (it.hasNext()) {
            try {
                ((Runnable) it.next()).run();
            } catch (RuntimeException e11) {
                this.zzt.zzay().zzd().zzb("Task exception while flushing queue", e11);
            }
        }
        this.zzf.clear();
        this.zzg.zzb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzQ() {
        zzg();
        this.zze.zzb();
        zzap zzapVar = this.zzd;
        this.zzt.zzf();
        zzapVar.zzd(((Long) zzdu.zzI.zza(null)).longValue());
    }

    private final void zzR(Runnable runnable) throws IllegalStateException {
        zzg();
        if (zzL()) {
            runnable.run();
            return;
        }
        int size = this.zzf.size();
        this.zzt.zzf();
        if (size >= 1000) {
            this.zzt.zzay().zzd().zza("Discarding data. Max runnable queue size reached");
            return;
        }
        this.zzf.add(runnable);
        this.zzg.zzd(ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS);
        zzr();
    }

    private final boolean zzS() {
        this.zzt.zzaw();
        return true;
    }

    public static /* bridge */ /* synthetic */ void zzo(zzjm zzjmVar, ComponentName componentName) {
        zzjmVar.zzg();
        if (zzjmVar.zzb != null) {
            zzjmVar.zzb = null;
            zzjmVar.zzt.zzay().zzj().zzb("Disconnected from device MeasurementService", componentName);
            zzjmVar.zzg();
            zzjmVar.zzr();
        }
    }

    public final void zzA(zzaw zzawVar, String str) {
        Preconditions.checkNotNull(zzawVar);
        zzg();
        zza();
        zzS();
        zzR(new zzjb(this, true, zzO(true), this.zzt.zzi().zzo(zzawVar), zzawVar, str));
    }

    public final void zzB(com.google.android.gms.internal.measurement.zzcf zzcfVar, zzaw zzawVar, String str) {
        zzg();
        zza();
        if (this.zzt.zzv().zzo(12451000) == 0) {
            zzR(new zzix(this, zzawVar, str, zzcfVar));
        } else {
            this.zzt.zzay().zzk().zza("Not bundling data. Service unavailable or out of date");
            this.zzt.zzv().zzS(zzcfVar, new byte[0]);
        }
    }

    public final void zzC() {
        zzg();
        zza();
        zzq zzqVarZzO = zzO(false);
        zzS();
        this.zzt.zzi().zzj();
        zzR(new zziq(this, zzqVarZzO));
    }

    @VisibleForTesting
    public final void zzD(zzdx zzdxVar, AbstractSafeParcelable abstractSafeParcelable, zzq zzqVar) {
        int size;
        zzg();
        zza();
        zzS();
        this.zzt.zzf();
        int i11 = 0;
        int i12 = 100;
        while (i11 < 1001 && i12 == 100) {
            ArrayList arrayList = new ArrayList();
            List listZzi = this.zzt.zzi().zzi(100);
            if (listZzi != null) {
                arrayList.addAll(listZzi);
                size = listZzi.size();
            } else {
                size = 0;
            }
            if (abstractSafeParcelable != null && size < 100) {
                arrayList.add(abstractSafeParcelable);
            }
            int size2 = arrayList.size();
            for (int i13 = 0; i13 < size2; i13++) {
                AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) arrayList.get(i13);
                if (abstractSafeParcelable2 instanceof zzaw) {
                    try {
                        zzdxVar.zzk((zzaw) abstractSafeParcelable2, zzqVar);
                    } catch (RemoteException e11) {
                        this.zzt.zzay().zzd().zzb("Failed to send event to the service", e11);
                    }
                } else if (abstractSafeParcelable2 instanceof zzkw) {
                    try {
                        zzdxVar.zzt((zzkw) abstractSafeParcelable2, zzqVar);
                    } catch (RemoteException e12) {
                        this.zzt.zzay().zzd().zzb("Failed to send user property to the service", e12);
                    }
                } else if (abstractSafeParcelable2 instanceof zzac) {
                    try {
                        zzdxVar.zzn((zzac) abstractSafeParcelable2, zzqVar);
                    } catch (RemoteException e13) {
                        this.zzt.zzay().zzd().zzb("Failed to send conditional user property to the service", e13);
                    }
                } else {
                    this.zzt.zzay().zzd().zza("Discarding data. Unrecognized parcel type.");
                }
            }
            i11++;
            i12 = size;
        }
    }

    public final void zzE(zzac zzacVar) {
        Preconditions.checkNotNull(zzacVar);
        zzg();
        zza();
        this.zzt.zzaw();
        zzR(new zzjc(this, true, zzO(true), this.zzt.zzi().zzn(zzacVar), new zzac(zzacVar), zzacVar));
    }

    public final void zzF(boolean z11) {
        zzg();
        zza();
        if (z11) {
            zzS();
            this.zzt.zzi().zzj();
        }
        if (zzM()) {
            zzR(new zzja(this, zzO(false)));
        }
    }

    public final void zzG(zzie zzieVar) {
        zzg();
        zza();
        zzR(new zziu(this, zzieVar));
    }

    public final void zzH(Bundle bundle) {
        zzg();
        zza();
        zzR(new zziv(this, zzO(false), bundle));
    }

    public final void zzI() {
        zzg();
        zza();
        zzR(new zziz(this, zzO(true)));
    }

    @VisibleForTesting
    public final void zzJ(zzdx zzdxVar) {
        zzg();
        Preconditions.checkNotNull(zzdxVar);
        this.zzb = zzdxVar;
        zzQ();
        zzP();
    }

    public final void zzK(zzkw zzkwVar) {
        zzg();
        zza();
        zzS();
        zzR(new zzio(this, zzO(true), this.zzt.zzi().zzp(zzkwVar), zzkwVar));
    }

    public final boolean zzL() {
        zzg();
        zza();
        return this.zzb != null;
    }

    public final boolean zzM() {
        zzg();
        zza();
        return !zzN() || this.zzt.zzv().zzm() >= ((Integer) zzdu.zzaf.zza(null)).intValue();
    }

    public final boolean zzN() {
        zzg();
        zza();
        if (this.zzc == null) {
            zzg();
            zza();
            zzew zzewVarZzm = this.zzt.zzm();
            zzewVarZzm.zzg();
            boolean z11 = false;
            Boolean boolValueOf = !zzewVarZzm.zza().contains("use_service") ? null : Boolean.valueOf(zzewVarZzm.zza().getBoolean("use_service", false));
            boolean z12 = true;
            if (boolValueOf == null || !boolValueOf.booleanValue()) {
                this.zzt.zzaw();
                if (this.zzt.zzh().zzh() == 1) {
                    z11 = true;
                } else {
                    this.zzt.zzay().zzj().zza("Checking service availability");
                    int iZzo = this.zzt.zzv().zzo(12451000);
                    if (iZzo == 0) {
                        this.zzt.zzay().zzj().zza("Service available");
                    } else if (iZzo != 1) {
                        if (iZzo == 2) {
                            this.zzt.zzay().zzc().zza("Service container out of date");
                            if (this.zzt.zzv().zzm() >= 17443) {
                                z11 = boolValueOf == null;
                            }
                        } else if (iZzo == 3) {
                            this.zzt.zzay().zzk().zza("Service disabled");
                        } else if (iZzo == 9) {
                            this.zzt.zzay().zzk().zza("Service invalid");
                        } else if (iZzo != 18) {
                            this.zzt.zzay().zzk().zzb("Unexpected service status", Integer.valueOf(iZzo));
                        } else {
                            this.zzt.zzay().zzk().zza("Service updating");
                        }
                        z12 = false;
                    } else {
                        this.zzt.zzay().zzj().zza("Service missing");
                    }
                    z11 = true;
                }
                if (!z11 && this.zzt.zzf().zzx()) {
                    this.zzt.zzay().zzd().zza("No way to upload. Consider using the full version of Analytics");
                } else if (z12) {
                    zzew zzewVarZzm2 = this.zzt.zzm();
                    zzewVarZzm2.zzg();
                    SharedPreferences.Editor editorEdit = zzewVarZzm2.zza().edit();
                    editorEdit.putBoolean("use_service", z11);
                    editorEdit.apply();
                }
                z12 = z11;
            }
            this.zzc = Boolean.valueOf(z12);
        }
        return this.zzc.booleanValue();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final boolean zzf() {
        return false;
    }

    public final Boolean zzj() {
        return this.zzc;
    }

    public final void zzq() {
        zzg();
        zza();
        zzq zzqVarZzO = zzO(true);
        this.zzt.zzi().zzk();
        zzR(new zzit(this, zzqVarZzO));
    }

    public final void zzr() {
        zzg();
        zza();
        if (zzL()) {
            return;
        }
        if (zzN()) {
            this.zza.zzc();
            return;
        }
        if (this.zzt.zzf().zzx()) {
            return;
        }
        this.zzt.zzaw();
        List<ResolveInfo> listQueryIntentServices = this.zzt.zzau().getPackageManager().queryIntentServices(new Intent().setClassName(this.zzt.zzau(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
            this.zzt.zzay().zzd().zza("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            return;
        }
        Intent intent = new Intent("com.google.android.gms.measurement.START");
        Context contextZzau = this.zzt.zzau();
        this.zzt.zzaw();
        intent.setComponent(new ComponentName(contextZzau, "com.google.android.gms.measurement.AppMeasurementService"));
        this.zza.zzb(intent);
    }

    public final void zzs() {
        zzg();
        zza();
        this.zza.zzd();
        try {
            ConnectionTracker.getInstance().unbindService(this.zzt.zzau(), this.zza);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.zzb = null;
    }

    public final void zzt(com.google.android.gms.internal.measurement.zzcf zzcfVar) {
        zzg();
        zza();
        zzR(new zzis(this, zzO(false), zzcfVar));
    }

    public final void zzu(AtomicReference atomicReference) {
        zzg();
        zza();
        zzR(new zzir(this, atomicReference, zzO(false)));
    }

    public final void zzv(com.google.android.gms.internal.measurement.zzcf zzcfVar, String str, String str2) {
        zzg();
        zza();
        zzR(new zzje(this, str, str2, zzO(false), zzcfVar));
    }

    public final void zzw(AtomicReference atomicReference, String str, String str2, String str3) {
        zzg();
        zza();
        zzR(new zzjd(this, atomicReference, null, str2, str3, zzO(false)));
    }

    public final void zzx(AtomicReference atomicReference, boolean z11) {
        zzg();
        zza();
        zzR(new zzip(this, atomicReference, zzO(false), z11));
    }

    public final void zzy(com.google.android.gms.internal.measurement.zzcf zzcfVar, String str, String str2, boolean z11) {
        zzg();
        zza();
        zzR(new zzin(this, str, str2, zzO(false), z11, zzcfVar));
    }

    public final void zzz(AtomicReference atomicReference, String str, String str2, String str3, boolean z11) {
        zzg();
        zza();
        zzR(new zzjf(this, atomicReference, null, str2, str3, zzO(false), z11));
    }
}
