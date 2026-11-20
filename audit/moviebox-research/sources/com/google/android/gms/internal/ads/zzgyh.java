package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
class zzgyh extends zzgyg {
    protected final byte[] zza;

    public zzgyh(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgyl) || zzd() != ((zzgyl) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzgyh)) {
            return obj.equals(this);
        }
        zzgyh zzgyhVar = (zzgyh) obj;
        int iZzr = zzr();
        int iZzr2 = zzgyhVar.zzr();
        if (iZzr == 0 || iZzr2 == 0 || iZzr == iZzr2) {
            return zzg(zzgyhVar, 0, zzd());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public byte zza(int i11) {
        return this.zza[i11];
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public byte zzb(int i11) {
        return this.zza[i11];
    }

    public int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public void zze(byte[] bArr, int i11, int i12, int i13) {
        System.arraycopy(this.zza, i11, bArr, i12, i13);
    }

    @Override // com.google.android.gms.internal.ads.zzgyg
    public final boolean zzg(zzgyl zzgylVar, int i11, int i12) {
        if (i12 > zzgylVar.zzd()) {
            throw new IllegalArgumentException("Length too large: " + i12 + zzd());
        }
        int i13 = i11 + i12;
        if (i13 > zzgylVar.zzd()) {
            throw new IllegalArgumentException("Ran off end of other: " + i11 + ", " + i12 + ", " + zzgylVar.zzd());
        }
        if (!(zzgylVar instanceof zzgyh)) {
            return zzgylVar.zzk(i11, i13).equals(zzk(0, i12));
        }
        zzgyh zzgyhVar = (zzgyh) zzgylVar;
        byte[] bArr = this.zza;
        byte[] bArr2 = zzgyhVar.zza;
        int iZzc = zzc() + i12;
        int iZzc2 = zzc();
        int iZzc3 = zzgyhVar.zzc() + i11;
        while (iZzc2 < iZzc) {
            if (bArr[iZzc2] != bArr2[iZzc3]) {
                return false;
            }
            iZzc2++;
            iZzc3++;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public final int zzi(int i11, int i12, int i13) {
        return zzhae.zzb(i11, this.zza, zzc() + i12, i13);
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public final int zzj(int i11, int i12, int i13) {
        int iZzc = zzc() + i12;
        return zzhde.zzf(i11, this.zza, iZzc, i13 + iZzc);
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public final zzgyl zzk(int i11, int i12) {
        int iZzq = zzgyl.zzq(i11, i12, zzd());
        return iZzq == 0 ? zzgyl.zzb : new zzgye(this.zza, zzc() + i11, iZzq);
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public final zzgyt zzl() {
        return zzgyt.zzI(this.zza, zzc(), zzd(), true);
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public final String zzm(Charset charset) {
        return new String(this.zza, zzc(), zzd(), charset);
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public final ByteBuffer zzn() {
        return ByteBuffer.wrap(this.zza, zzc(), zzd()).asReadOnlyBuffer();
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public final void zzo(zzgya zzgyaVar) throws IOException {
        zzgyaVar.zza(this.zza, zzc(), zzd());
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public final boolean zzp() {
        int iZzc = zzc();
        return zzhde.zzj(this.zza, iZzc, zzd() + iZzc);
    }
}
