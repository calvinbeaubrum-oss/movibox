package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.EOFException;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zztu implements zzvi {
    private final zzadb zza;

    @Nullable
    private zzacu zzb;

    @Nullable
    private zzacv zzc;

    public zztu(zzadb zzadbVar) {
        this.zza = zzadbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzvi
    public final int zza(zzadr zzadrVar) throws IOException {
        zzacu zzacuVar = this.zzb;
        zzacuVar.getClass();
        zzacv zzacvVar = this.zzc;
        zzacvVar.getClass();
        return zzacuVar.zzb(zzacvVar, zzadrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzvi
    public final long zzb() {
        zzacv zzacvVar = this.zzc;
        if (zzacvVar != null) {
            return zzacvVar.zzf();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzvi
    public final void zzc() {
        zzacu zzacuVar = this.zzb;
        if (zzacuVar != null && (zzacuVar instanceof zzaig)) {
            ((zzaig) zzacuVar).zza();
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0045  */
    @Override // com.google.android.gms.internal.ads.zzvi
    public final void zzd(zzu zzuVar, Uri uri, Map map, long j11, long j12, zzacx zzacxVar) throws IOException {
        zzack zzackVar = new zzack(zzuVar, j11, j12);
        this.zzc = zzackVar;
        if (this.zzb != null) {
            return;
        }
        zzacu[] zzacuVarArrZza = this.zza.zza(uri, map);
        int i11 = 0;
        if (zzacuVarArrZza.length == 1) {
            this.zzb = zzacuVarArrZza[0];
        } else {
            for (zzacu zzacuVar : zzacuVarArrZza) {
                try {
                    if (zzacuVar.zze(zzackVar)) {
                        this.zzb = zzacuVar;
                        zzek.zzf(true);
                        zzackVar.zzj();
                        break;
                    } else {
                        boolean z11 = this.zzb != null || zzackVar.zzf() == j11;
                        zzek.zzf(z11);
                        zzackVar.zzj();
                    }
                } catch (EOFException unused) {
                    if (this.zzb != null || zzackVar.zzf() == j11) {
                    }
                } catch (Throwable th2) {
                    zzek.zzf(this.zzb != null || zzackVar.zzf() == j11);
                    zzackVar.zzj();
                    throw th2;
                }
                zzek.zzf(z11);
                zzackVar.zzj();
            }
            if (this.zzb == null) {
                StringBuilder sb2 = new StringBuilder();
                while (true) {
                    int length = zzacuVarArrZza.length;
                    if (i11 >= length) {
                        throw new zzwt("None of the available extractors (" + sb2.toString() + ") could read the stream.", uri);
                    }
                    sb2.append(zzacuVarArrZza[i11].getClass().getSimpleName());
                    if (i11 < length - 1) {
                        sb2.append(", ");
                    }
                    i11++;
                }
            }
        }
        this.zzb.zzc(zzacxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzvi
    public final void zze() {
        if (this.zzb != null) {
            this.zzb = null;
        }
        this.zzc = null;
    }

    @Override // com.google.android.gms.internal.ads.zzvi
    public final void zzf(long j11, long j12) {
        zzacu zzacuVar = this.zzb;
        zzacuVar.getClass();
        zzacuVar.zzd(j11, j12);
    }
}
