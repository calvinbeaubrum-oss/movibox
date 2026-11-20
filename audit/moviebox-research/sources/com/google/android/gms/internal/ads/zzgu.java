package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.util.Base64;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.net.URLDecoder;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgu extends zzgq {

    @Nullable
    private zzhb zza;

    @Nullable
    private byte[] zzb;
    private int zzc;
    private int zzd;

    public zzgu() {
        super(false);
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
        byte[] bArr2 = this.zzb;
        int i14 = zzfy.zza;
        System.arraycopy(bArr2, this.zzc, bArr, i11, iMin);
        this.zzc += iMin;
        this.zzd -= iMin;
        zzg(iMin);
        return iMin;
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final long zzb(zzhb zzhbVar) throws IOException {
        zzi(zzhbVar);
        this.zza = zzhbVar;
        Uri uriNormalizeScheme = zzhbVar.zza.normalizeScheme();
        String scheme = uriNormalizeScheme.getScheme();
        zzek.zze("data".equals(scheme), "Unsupported scheme: ".concat(String.valueOf(scheme)));
        String schemeSpecificPart = uriNormalizeScheme.getSchemeSpecificPart();
        int i11 = zzfy.zza;
        String[] strArrSplit = schemeSpecificPart.split(",", -1);
        if (strArrSplit.length != 2) {
            throw zzcc.zzb("Unexpected URI format: ".concat(String.valueOf(uriNormalizeScheme)), null);
        }
        String str = strArrSplit[1];
        if (strArrSplit[0].contains(";base64")) {
            try {
                this.zzb = Base64.decode(str, 0);
            } catch (IllegalArgumentException e11) {
                throw zzcc.zzb("Error while parsing Base64 encoded string: ".concat(String.valueOf(str)), e11);
            }
        } else {
            this.zzb = URLDecoder.decode(str, zzfwq.zza.name()).getBytes(zzfwq.zzc);
        }
        long j11 = zzhbVar.zzf;
        int length = this.zzb.length;
        if (j11 > length) {
            this.zzb = null;
            throw new zzgx(2008);
        }
        int i12 = (int) j11;
        this.zzc = i12;
        int i13 = length - i12;
        this.zzd = i13;
        long j12 = zzhbVar.zzg;
        if (j12 != -1) {
            this.zzd = (int) Math.min(i13, j12);
        }
        zzj(zzhbVar);
        long j13 = zzhbVar.zzg;
        return j13 != -1 ? j13 : this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    @Nullable
    public final Uri zzc() {
        zzhb zzhbVar = this.zza;
        if (zzhbVar != null) {
            return zzhbVar.zza;
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final void zzd() {
        if (this.zzb != null) {
            this.zzb = null;
            zzh();
        }
        this.zza = null;
    }
}
