package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Api;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzaku implements zzaea {
    private final zzaea zza;
    private final zzakp zzb;

    @Nullable
    private zzakr zzh;
    private zzam zzi;
    private final zzaki zzc = new zzaki();
    private int zze = 0;
    private int zzf = 0;
    private byte[] zzg = zzfy.zzf;
    private final zzfp zzd = new zzfp();

    public zzaku(zzaea zzaeaVar, zzakp zzakpVar) {
        this.zza = zzaeaVar;
        this.zzb = zzakpVar;
    }

    private final void zzb(int i11) {
        int length = this.zzg.length;
        int i12 = this.zzf;
        if (length - i12 >= i11) {
            return;
        }
        int i13 = i12 - this.zze;
        int iMax = Math.max(i13 + i13, i11 + i13);
        byte[] bArr = this.zzg;
        byte[] bArr2 = iMax <= bArr.length ? bArr : new byte[iMax];
        System.arraycopy(bArr, this.zze, bArr2, 0, i13);
        this.zze = 0;
        this.zzf = i13;
        this.zzg = bArr2;
    }

    public final /* synthetic */ void zza(long j11, int i11, zzakj zzakjVar) {
        zzek.zzb(this.zzi);
        zzgaa zzgaaVar = zzakjVar.zza;
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(zzgaaVar.size());
        Iterator<E> it = zzgaaVar.iterator();
        while (it.hasNext()) {
            arrayList.add(((zzec) it.next()).zza());
        }
        long j12 = zzakjVar.zzc;
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("c", arrayList);
        bundle.putLong(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, j12);
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeBundle(bundle);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        zzfp zzfpVar = this.zzd;
        int length = bArrMarshall.length;
        zzfpVar.zzI(bArrMarshall, length);
        this.zza.zzr(this.zzd, length);
        int i12 = i11 & Api.BaseClientBuilder.API_PRIORITY_OTHER;
        long j13 = zzakjVar.zzb;
        if (j13 == C.TIME_UNSET) {
            zzek.zzf(this.zzi.zzq == Long.MAX_VALUE);
        } else {
            long j14 = this.zzi.zzq;
            j11 = j14 == Long.MAX_VALUE ? j11 + j13 : j13 + j14;
        }
        this.zza.zzt(j11, i12, length, 0, null);
    }

    @Override // com.google.android.gms.internal.ads.zzaea
    public final /* synthetic */ int zzf(zzu zzuVar, int i11, boolean z11) {
        return zzady.zza(this, zzuVar, i11, z11);
    }

    @Override // com.google.android.gms.internal.ads.zzaea
    public final int zzg(zzu zzuVar, int i11, boolean z11, int i12) throws IOException {
        if (this.zzh == null) {
            return this.zza.zzg(zzuVar, i11, z11, 0);
        }
        zzb(i11);
        int iZza = zzuVar.zza(this.zzg, this.zzf, i11);
        if (iZza != -1) {
            this.zzf += iZza;
            return iZza;
        }
        if (z11) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // com.google.android.gms.internal.ads.zzaea
    public final void zzl(zzam zzamVar) {
        String str = zzamVar.zzm;
        str.getClass();
        zzek.zzd(zzcb.zzb(str) == 3);
        if (!zzamVar.equals(this.zzi)) {
            this.zzi = zzamVar;
            this.zzh = this.zzb.zzc(zzamVar) ? this.zzb.zzb(zzamVar) : null;
        }
        if (this.zzh == null) {
            this.zza.zzl(zzamVar);
            return;
        }
        zzaea zzaeaVar = this.zza;
        zzak zzakVarZzb = zzamVar.zzb();
        zzakVarZzb.zzW("application/x-media3-cues");
        zzakVarZzb.zzz(zzamVar.zzm);
        zzakVarZzb.zzaa(Long.MAX_VALUE);
        zzakVarZzb.zzD(this.zzb.zza(zzamVar));
        zzaeaVar.zzl(zzakVarZzb.zzac());
    }

    @Override // com.google.android.gms.internal.ads.zzaea
    public final /* synthetic */ void zzr(zzfp zzfpVar, int i11) {
        zzady.zzb(this, zzfpVar, i11);
    }

    @Override // com.google.android.gms.internal.ads.zzaea
    public final void zzs(zzfp zzfpVar, int i11, int i12) {
        if (this.zzh == null) {
            this.zza.zzs(zzfpVar, i11, i12);
            return;
        }
        zzb(i11);
        zzfpVar.zzG(this.zzg, this.zzf, i11);
        this.zzf += i11;
    }

    @Override // com.google.android.gms.internal.ads.zzaea
    public final void zzt(final long j11, final int i11, int i12, int i13, @Nullable zzadz zzadzVar) {
        if (this.zzh == null) {
            this.zza.zzt(j11, i11, i12, i13, zzadzVar);
            return;
        }
        zzek.zze(zzadzVar == null, "DRM on subtitles is not supported");
        int i14 = (this.zzf - i13) - i12;
        this.zzh.zza(this.zzg, i14, i12, zzakq.zza(), new zzep() { // from class: com.google.android.gms.internal.ads.zzakt
            @Override // com.google.android.gms.internal.ads.zzep
            public final void zza(Object obj) {
                this.zza.zza(j11, i11, (zzakj) obj);
            }
        });
        int i15 = i14 + i12;
        this.zze = i15;
        if (i15 == this.zzf) {
            this.zze = 0;
            this.zzf = 0;
        }
    }
}
