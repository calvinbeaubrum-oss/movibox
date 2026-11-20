package com.google.android.gms.internal.ads;

import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzhbx extends zzgyl {
    static final int[] zza = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Api.BaseClientBuilder.API_PRIORITY_OTHER};
    private final int zzc;
    private final zzgyl zzd;
    private final zzgyl zze;
    private final int zzf;
    private final int zzg;

    private zzhbx(zzgyl zzgylVar, zzgyl zzgylVar2) {
        this.zzd = zzgylVar;
        this.zze = zzgylVar2;
        int iZzd = zzgylVar.zzd();
        this.zzf = iZzd;
        this.zzc = iZzd + zzgylVar2.zzd();
        this.zzg = Math.max(zzgylVar.zzf(), zzgylVar2.zzf()) + 1;
    }

    public static zzgyl zzC(zzgyl zzgylVar, zzgyl zzgylVar2) {
        if (zzgylVar2.zzd() == 0) {
            return zzgylVar;
        }
        if (zzgylVar.zzd() == 0) {
            return zzgylVar2;
        }
        int iZzd = zzgylVar.zzd() + zzgylVar2.zzd();
        if (iZzd < 128) {
            return zzD(zzgylVar, zzgylVar2);
        }
        if (zzgylVar instanceof zzhbx) {
            zzhbx zzhbxVar = (zzhbx) zzgylVar;
            if (zzhbxVar.zze.zzd() + zzgylVar2.zzd() < 128) {
                return new zzhbx(zzhbxVar.zzd, zzD(zzhbxVar.zze, zzgylVar2));
            }
            if (zzhbxVar.zzd.zzf() > zzhbxVar.zze.zzf() && zzhbxVar.zzg > zzgylVar2.zzf()) {
                return new zzhbx(zzhbxVar.zzd, new zzhbx(zzhbxVar.zze, zzgylVar2));
            }
        }
        return iZzd >= zzc(Math.max(zzgylVar.zzf(), zzgylVar2.zzf()) + 1) ? new zzhbx(zzgylVar, zzgylVar2) : zzhbt.zza(new zzhbt(null), zzgylVar, zzgylVar2);
    }

    private static zzgyl zzD(zzgyl zzgylVar, zzgyl zzgylVar2) {
        int iZzd = zzgylVar.zzd();
        int iZzd2 = zzgylVar2.zzd();
        byte[] bArr = new byte[iZzd + iZzd2];
        zzgylVar.zzz(bArr, 0, 0, iZzd);
        zzgylVar2.zzz(bArr, 0, iZzd, iZzd2);
        return new zzgyh(bArr);
    }

    public static int zzc(int i11) {
        int[] iArr = zza;
        int length = iArr.length;
        return i11 >= 47 ? Api.BaseClientBuilder.API_PRIORITY_OTHER : iArr[i11];
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgyl)) {
            return false;
        }
        zzgyl zzgylVar = (zzgyl) obj;
        if (this.zzc != zzgylVar.zzd()) {
            return false;
        }
        if (this.zzc == 0) {
            return true;
        }
        int iZzr = zzr();
        int iZzr2 = zzgylVar.zzr();
        if (iZzr != 0 && iZzr2 != 0 && iZzr != iZzr2) {
            return false;
        }
        zzhbu zzhbuVar = null;
        zzhbv zzhbvVar = new zzhbv(this, zzhbuVar);
        zzgyg zzgygVarZza = zzhbvVar.next();
        zzhbv zzhbvVar2 = new zzhbv(zzgylVar, zzhbuVar);
        zzgyg zzgygVarZza2 = zzhbvVar2.next();
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (true) {
            int iZzd = zzgygVarZza.zzd() - i11;
            int iZzd2 = zzgygVarZza2.zzd() - i12;
            int iMin = Math.min(iZzd, iZzd2);
            if (!(i11 == 0 ? zzgygVarZza.zzg(zzgygVarZza2, i12, iMin) : zzgygVarZza2.zzg(zzgygVarZza, i11, iMin))) {
                return false;
            }
            i13 += iMin;
            int i14 = this.zzc;
            if (i13 >= i14) {
                if (i13 == i14) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (iMin == iZzd) {
                zzgygVarZza = zzhbvVar.next();
                i11 = 0;
            } else {
                i11 += iMin;
            }
            if (iMin == iZzd2) {
                zzgygVarZza = zzgygVarZza;
                zzgygVarZza2 = zzhbvVar2.next();
                i12 = 0;
            } else {
                zzgygVarZza = zzgygVarZza;
                i12 += iMin;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgyl, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzhbr(this);
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public final byte zza(int i11) {
        zzgyl.zzy(i11, this.zzc);
        return zzb(i11);
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public final byte zzb(int i11) {
        int i12 = this.zzf;
        return i11 < i12 ? this.zzd.zzb(i11) : this.zze.zzb(i11 - i12);
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public final int zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public final void zze(byte[] bArr, int i11, int i12, int i13) {
        int i14 = i11 + i13;
        int i15 = this.zzf;
        if (i14 <= i15) {
            this.zzd.zze(bArr, i11, i12, i13);
        } else {
            if (i11 >= i15) {
                this.zze.zze(bArr, i11 - i15, i12, i13);
                return;
            }
            int i16 = i15 - i11;
            this.zzd.zze(bArr, i11, i12, i16);
            this.zze.zze(bArr, 0, i12 + i16, i13 - i16);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public final int zzf() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public final boolean zzh() {
        return this.zzc >= zzc(this.zzg);
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public final int zzi(int i11, int i12, int i13) {
        int i14 = i12 + i13;
        int i15 = this.zzf;
        if (i14 <= i15) {
            return this.zzd.zzi(i11, i12, i13);
        }
        if (i12 >= i15) {
            return this.zze.zzi(i11, i12 - i15, i13);
        }
        int i16 = i15 - i12;
        return this.zze.zzi(this.zzd.zzi(i11, i12, i16), 0, i13 - i16);
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public final int zzj(int i11, int i12, int i13) {
        int i14 = i12 + i13;
        int i15 = this.zzf;
        if (i14 <= i15) {
            return this.zzd.zzj(i11, i12, i13);
        }
        if (i12 >= i15) {
            return this.zze.zzj(i11, i12 - i15, i13);
        }
        int i16 = i15 - i12;
        return this.zze.zzj(this.zzd.zzj(i11, i12, i16), 0, i13 - i16);
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public final zzgyl zzk(int i11, int i12) {
        int iZzq = zzgyl.zzq(i11, i12, this.zzc);
        if (iZzq == 0) {
            return zzgyl.zzb;
        }
        if (iZzq == this.zzc) {
            return this;
        }
        int i13 = this.zzf;
        if (i12 <= i13) {
            return this.zzd.zzk(i11, i12);
        }
        if (i11 >= i13) {
            return this.zze.zzk(i11 - i13, i12 - i13);
        }
        zzgyl zzgylVar = this.zzd;
        return new zzhbx(zzgylVar.zzk(i11, zzgylVar.zzd()), this.zze.zzk(0, i12 - this.zzf));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzgyl
    public final zzgyt zzl() {
        ArrayList<ByteBuffer> arrayList = new ArrayList();
        Object[] objArr = 0;
        zzhbv zzhbvVar = new zzhbv(this, null);
        while (zzhbvVar.hasNext()) {
            arrayList.add(zzhbvVar.next().zzn());
        }
        int i11 = zzgyt.zzd;
        int i12 = 0;
        int iRemaining = 0;
        for (ByteBuffer byteBuffer : arrayList) {
            iRemaining += byteBuffer.remaining();
            i12 = byteBuffer.hasArray() ? i12 | 1 : byteBuffer.isDirect() ? i12 | 2 : i12 | 4;
        }
        return i12 == 2 ? new zzgyp(arrayList, iRemaining, true, objArr == true ? 1 : 0) : zzgyt.zzH(new zzhah(arrayList), 4096);
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public final String zzm(Charset charset) {
        return new String(zzA(), charset);
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public final ByteBuffer zzn() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public final void zzo(zzgya zzgyaVar) throws IOException {
        this.zzd.zzo(zzgyaVar);
        this.zze.zzo(zzgyaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public final boolean zzp() {
        zzgyl zzgylVar = this.zzd;
        zzgyl zzgylVar2 = this.zze;
        return zzgylVar2.zzj(zzgylVar.zzj(0, 0, this.zzf), 0, zzgylVar2.zzd()) == 0;
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    /* JADX INFO: renamed from: zzs */
    public final zzgyf iterator() {
        return new zzhbr(this);
    }
}
