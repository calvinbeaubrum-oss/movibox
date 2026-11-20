package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdq {
    private final zzgaa zza;
    private final List zzb = new ArrayList();
    private ByteBuffer[] zzc = new ByteBuffer[0];
    private zzdr zzd;
    private zzdr zze;
    private boolean zzf;

    public zzdq(zzgaa zzgaaVar) {
        this.zza = zzgaaVar;
        zzdr zzdrVar = zzdr.zza;
        this.zzd = zzdrVar;
        this.zze = zzdrVar;
        this.zzf = false;
    }

    private final int zzi() {
        return this.zzc.length - 1;
    }

    private final void zzj(ByteBuffer byteBuffer) {
        boolean z11;
        ByteBuffer byteBuffer2;
        do {
            int i11 = 0;
            z11 = false;
            while (i11 <= zzi()) {
                int i12 = i11 + 1;
                if (!this.zzc[i11].hasRemaining()) {
                    zzdt zzdtVar = (zzdt) this.zzb.get(i11);
                    if (!zzdtVar.zzh()) {
                        if (i11 > 0) {
                            byteBuffer2 = this.zzc[i11 - 1];
                        } else {
                            byteBuffer2 = byteBuffer.hasRemaining() ? byteBuffer : zzdt.zza;
                        }
                        long jRemaining = byteBuffer2.remaining();
                        zzdtVar.zze(byteBuffer2);
                        this.zzc[i11] = zzdtVar.zzb();
                        boolean z12 = true;
                        if (jRemaining - ((long) byteBuffer2.remaining()) <= 0 && !this.zzc[i11].hasRemaining()) {
                            z12 = false;
                        }
                        z11 |= z12;
                    } else if (!this.zzc[i11].hasRemaining() && i11 < zzi()) {
                        ((zzdt) this.zzb.get(i12)).zzd();
                    }
                }
                i11 = i12;
            }
        } while (z11);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdq)) {
            return false;
        }
        zzdq zzdqVar = (zzdq) obj;
        if (this.zza.size() != zzdqVar.zza.size()) {
            return false;
        }
        for (int i11 = 0; i11 < this.zza.size(); i11++) {
            if (this.zza.get(i11) != zzdqVar.zza.get(i11)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final zzdr zza(zzdr zzdrVar) throws zzds {
        if (zzdrVar.equals(zzdr.zza)) {
            throw new zzds("Unhandled input format:", zzdrVar);
        }
        for (int i11 = 0; i11 < this.zza.size(); i11++) {
            zzdt zzdtVar = (zzdt) this.zza.get(i11);
            zzdr zzdrVarZza = zzdtVar.zza(zzdrVar);
            if (zzdtVar.zzg()) {
                zzek.zzf(!zzdrVarZza.equals(zzdr.zza));
                zzdrVar = zzdrVarZza;
            }
        }
        this.zze = zzdrVar;
        return zzdrVar;
    }

    public final ByteBuffer zzb() {
        if (!zzh()) {
            return zzdt.zza;
        }
        ByteBuffer byteBuffer = this.zzc[zzi()];
        if (byteBuffer.hasRemaining()) {
            return byteBuffer;
        }
        zzj(zzdt.zza);
        return this.zzc[zzi()];
    }

    public final void zzc() {
        this.zzb.clear();
        this.zzd = this.zze;
        this.zzf = false;
        for (int i11 = 0; i11 < this.zza.size(); i11++) {
            zzdt zzdtVar = (zzdt) this.zza.get(i11);
            zzdtVar.zzc();
            if (zzdtVar.zzg()) {
                this.zzb.add(zzdtVar);
            }
        }
        this.zzc = new ByteBuffer[this.zzb.size()];
        for (int i12 = 0; i12 <= zzi(); i12++) {
            this.zzc[i12] = ((zzdt) this.zzb.get(i12)).zzb();
        }
    }

    public final void zzd() {
        if (!zzh() || this.zzf) {
            return;
        }
        this.zzf = true;
        ((zzdt) this.zzb.get(0)).zzd();
    }

    public final void zze(ByteBuffer byteBuffer) {
        if (!zzh() || this.zzf) {
            return;
        }
        zzj(byteBuffer);
    }

    public final void zzf() {
        for (int i11 = 0; i11 < this.zza.size(); i11++) {
            zzdt zzdtVar = (zzdt) this.zza.get(i11);
            zzdtVar.zzc();
            zzdtVar.zzf();
        }
        this.zzc = new ByteBuffer[0];
        zzdr zzdrVar = zzdr.zza;
        this.zzd = zzdrVar;
        this.zze = zzdrVar;
        this.zzf = false;
    }

    public final boolean zzg() {
        return this.zzf && ((zzdt) this.zzb.get(zzi())).zzh() && !this.zzc[zzi()].hasRemaining();
    }

    public final boolean zzh() {
        return !this.zzb.isEmpty();
    }
}
