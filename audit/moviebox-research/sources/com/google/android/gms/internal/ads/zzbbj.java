package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.common.util.concurrent.s;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzbbj implements BaseGmsClient.BaseConnectionCallbacks {
    public static final /* synthetic */ int zzd = 0;
    final /* synthetic */ zzbbb zza;
    final /* synthetic */ zzceu zzb;
    final /* synthetic */ zzbbl zzc;

    public zzbbj(zzbbl zzbblVar, zzbbb zzbbbVar, zzceu zzceuVar) {
        this.zza = zzbbbVar;
        this.zzb = zzceuVar;
        this.zzc = zzbblVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(@Nullable Bundle bundle) {
        synchronized (this.zzc.zzd) {
            try {
                zzbbl zzbblVar = this.zzc;
                if (zzbblVar.zzb) {
                    return;
                }
                zzbblVar.zzb = true;
                final zzbba zzbbaVar = this.zzc.zza;
                if (zzbbaVar == null) {
                    return;
                }
                zzgey zzgeyVar = zzcep.zza;
                final zzbbb zzbbbVar = this.zza;
                final zzceu zzceuVar = this.zzb;
                final s sVarZza = zzgeyVar.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbbg
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzbbj zzbbjVar = this.zza;
                        zzbba zzbbaVar2 = zzbbaVar;
                        zzceu zzceuVar2 = zzceuVar;
                        try {
                            zzbbd zzbbdVarZzq = zzbbaVar2.zzq();
                            boolean zZzp = zzbbaVar2.zzp();
                            zzbbb zzbbbVar2 = zzbbbVar;
                            zzbay zzbayVarZzg = zZzp ? zzbbdVarZzq.zzg(zzbbbVar2) : zzbbdVarZzq.zzf(zzbbbVar2);
                            if (!zzbayVarZzg.zze()) {
                                zzceuVar2.zzd(new RuntimeException("No entry contents."));
                                zzbbl.zze(zzbbjVar.zzc);
                                return;
                            }
                            zzbbi zzbbiVar = new zzbbi(zzbbjVar, zzbayVarZzg.zzc(), 1);
                            int i11 = zzbbiVar.read();
                            if (i11 == -1) {
                                throw new IOException("Unable to read from cache.");
                            }
                            zzbbiVar.unread(i11);
                            zzceuVar2.zzc(zzbbn.zzb(zzbbiVar, zzbayVarZzg.zzd(), zzbayVarZzg.zzg(), zzbayVarZzg.zza(), zzbayVarZzg.zzf()));
                        } catch (RemoteException e11) {
                            e = e11;
                            zzcec.zzh("Unable to obtain a cache service instance.", e);
                            zzceuVar2.zzd(e);
                            zzbbl.zze(zzbbjVar.zzc);
                        } catch (IOException e12) {
                            e = e12;
                            zzcec.zzh("Unable to obtain a cache service instance.", e);
                            zzceuVar2.zzd(e);
                            zzbbl.zze(zzbbjVar.zzc);
                        }
                    }
                });
                final zzceu zzceuVar2 = this.zzb;
                zzceuVar2.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbbh
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (zzceuVar2.isCancelled()) {
                            sVarZza.cancel(true);
                        }
                    }
                }, zzcep.zzf);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i11) {
    }
}
