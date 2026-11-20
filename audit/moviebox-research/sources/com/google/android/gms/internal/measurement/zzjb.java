package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
class zzjb extends zzja {
    protected final byte[] zza;

    public zzjb(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.measurement.zzje
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzje) || zzd() != ((zzje) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzjb)) {
            return obj.equals(this);
        }
        zzjb zzjbVar = (zzjb) obj;
        int iZzk = zzk();
        int iZzk2 = zzjbVar.zzk();
        if (iZzk != 0 && iZzk2 != 0 && iZzk != iZzk2) {
            return false;
        }
        int iZzd = zzd();
        if (iZzd > zzjbVar.zzd()) {
            throw new IllegalArgumentException("Length too large: " + iZzd + zzd());
        }
        if (iZzd > zzjbVar.zzd()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + iZzd + ", " + zzjbVar.zzd());
        }
        byte[] bArr = this.zza;
        byte[] bArr2 = zzjbVar.zza;
        zzjbVar.zzc();
        int i11 = 0;
        int i12 = 0;
        while (i11 < iZzd) {
            if (bArr[i11] != bArr2[i12]) {
                return false;
            }
            i11++;
            i12++;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzje
    public byte zza(int i11) {
        return this.zza[i11];
    }

    @Override // com.google.android.gms.internal.measurement.zzje
    public byte zzb(int i11) {
        return this.zza[i11];
    }

    public int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzje
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.gms.internal.measurement.zzje
    public final int zze(int i11, int i12, int i13) {
        return zzkn.zzd(i11, this.zza, 0, i13);
    }

    @Override // com.google.android.gms.internal.measurement.zzje
    public final zzje zzf(int i11, int i12) {
        int iZzj = zzje.zzj(0, i12, zzd());
        return iZzj == 0 ? zzje.zzb : new zziy(this.zza, 0, iZzj);
    }

    @Override // com.google.android.gms.internal.measurement.zzje
    public final String zzg(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    @Override // com.google.android.gms.internal.measurement.zzje
    public final void zzh(zziu zziuVar) throws IOException {
        ((zzjj) zziuVar).zzc(this.zza, 0, zzd());
    }

    @Override // com.google.android.gms.internal.measurement.zzje
    public final boolean zzi() {
        return zznd.zzf(this.zza, 0, zzd());
    }
}
