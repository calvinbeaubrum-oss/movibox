package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgr extends zzgq {
    private final byte[] zza;

    @Nullable
    private Uri zzb;
    private int zzc;
    private int zzd;
    private boolean zze;

    public zzgr(byte[] bArr) {
        super(false);
        zzek.zzd(bArr.length > 0);
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzu
    public final int zza(byte[] bArr, int i11, int i12) {
        if (i12 == 0) {
            return 0;
        }
        int i13 = this.zzd;
        if (i13 == 0) {
            return -1;
        }
        int iMin = Math.min(i12, i13);
        System.arraycopy(this.zza, this.zzc, bArr, i11, iMin);
        this.zzc += iMin;
        this.zzd -= iMin;
        zzg(iMin);
        return iMin;
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final long zzb(zzhb zzhbVar) throws IOException {
        this.zzb = zzhbVar.zza;
        zzi(zzhbVar);
        long j11 = zzhbVar.zzf;
        int length = this.zza.length;
        if (j11 > length) {
            throw new zzgx(2008);
        }
        int i11 = (int) j11;
        this.zzc = i11;
        int i12 = length - i11;
        this.zzd = i12;
        long j12 = zzhbVar.zzg;
        if (j12 != -1) {
            this.zzd = (int) Math.min(i12, j12);
        }
        this.zze = true;
        zzj(zzhbVar);
        long j13 = zzhbVar.zzg;
        return j13 != -1 ? j13 : this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    @Nullable
    public final Uri zzc() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final void zzd() {
        if (this.zze) {
            this.zze = false;
            zzh();
        }
        this.zzb = null;
    }
}
