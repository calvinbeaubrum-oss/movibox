package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaei implements zzacu {
    public static final zzadb zza = new zzadb() { // from class: com.google.android.gms.internal.ads.zzaeh
        @Override // com.google.android.gms.internal.ads.zzadb
        public final /* synthetic */ zzacu[] zza(Uri uri, Map map) {
            int i11 = zzada.zza;
            return new zzacu[]{new zzaei(0)};
        }
    };
    private static final int[] zzb = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};
    private static final int[] zzc;
    private static final byte[] zzd;
    private static final byte[] zze;
    private static final int zzf;
    private final byte[] zzg;
    private boolean zzh;
    private long zzi;
    private int zzj;
    private int zzk;
    private boolean zzl;
    private int zzm;
    private int zzn;
    private long zzo;
    private zzacx zzp;
    private zzaea zzq;
    private zzadu zzr;
    private boolean zzs;

    static {
        int[] iArr = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        zzc = iArr;
        int i11 = zzfy.zza;
        Charset charset = zzfwq.zzc;
        zzd = "#!AMR\n".getBytes(charset);
        zze = "#!AMR-WB\n".getBytes(charset);
        zzf = iArr[8];
    }

    public zzaei() {
        this(0);
    }

    public zzaei(int i11) {
        this.zzg = new byte[1];
        this.zzm = -1;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002d  */
    /* JADX WARN: Code duplicated, block: B:15:0x002f  */
    /* JADX WARN: Code duplicated, block: B:39:0x0080  */
    private final int zza(zzacv zzacvVar) throws IOException {
        int i11 = this.zzk;
        if (i11 == 0) {
            try {
                zzacvVar.zzj();
                ((zzack) zzacvVar).zzm(this.zzg, 0, 1, false);
                byte b11 = this.zzg[0];
                if ((b11 & 131) > 0) {
                    throw zzcc.zza("Invalid padding bits for frame header " + ((int) b11), null);
                }
                boolean z11 = this.zzh;
                int i12 = (b11 >> 3) & 15;
                if (!z11) {
                    if (!z11) {
                        if (i12 >= 12 && i12 <= 14) {
                        }
                    }
                    throw zzcc.zza("Illegal AMR " + (true != z11 ? "NB" : "WB") + " frame type " + i12, null);
                }
                if (i12 >= 10 && i12 <= 13) {
                    if (!z11) {
                        if (i12 >= 12) {
                        }
                    }
                    if (true != z11) {
                    }
                    throw zzcc.zza("Illegal AMR " + (true != z11 ? "NB" : "WB") + " frame type " + i12, null);
                }
                i11 = z11 ? zzc[i12] : zzb[i12];
                this.zzj = i11;
                this.zzk = i11;
                int i13 = this.zzm;
                if (i13 == -1) {
                    this.zzm = i11;
                    i13 = i11;
                }
                if (i13 == i11) {
                    this.zzn++;
                }
            } catch (EOFException unused) {
                return -1;
            }
        }
        int iZza = zzady.zza(this.zzq, zzacvVar, i11, true);
        if (iZza == -1) {
            return -1;
        }
        int i14 = this.zzk - iZza;
        this.zzk = i14;
        if (i14 > 0) {
            return 0;
        }
        this.zzq.zzt(this.zzi, 1, this.zzj, 0, null);
        this.zzi += DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT;
        return 0;
    }

    private static boolean zzf(zzacv zzacvVar, byte[] bArr) throws IOException {
        zzacvVar.zzj();
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        ((zzack) zzacvVar).zzm(bArr2, 0, length, false);
        return Arrays.equals(bArr2, bArr);
    }

    private final boolean zzg(zzacv zzacvVar) throws IOException {
        byte[] bArr = zzd;
        if (zzf(zzacvVar, bArr)) {
            this.zzh = false;
            ((zzack) zzacvVar).zzo(bArr.length, false);
            return true;
        }
        byte[] bArr2 = zze;
        if (!zzf(zzacvVar, bArr2)) {
            return false;
        }
        this.zzh = true;
        ((zzack) zzacvVar).zzo(bArr2.length, false);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final int zzb(zzacv zzacvVar, zzadr zzadrVar) throws IOException {
        zzek.zzb(this.zzq);
        int i11 = zzfy.zza;
        if (zzacvVar.zzf() == 0 && !zzg(zzacvVar)) {
            throw zzcc.zza("Could not find AMR header.", null);
        }
        if (!this.zzs) {
            this.zzs = true;
            boolean z11 = this.zzh;
            String str = true != z11 ? MimeTypes.AUDIO_AMR_NB : MimeTypes.AUDIO_AMR_WB;
            int i12 = true != z11 ? 8000 : 16000;
            zzaea zzaeaVar = this.zzq;
            zzak zzakVar = new zzak();
            zzakVar.zzW(str);
            zzakVar.zzO(zzf);
            zzakVar.zzy(1);
            zzakVar.zzX(i12);
            zzaeaVar.zzl(zzakVar.zzac());
        }
        int iZza = zza(zzacvVar);
        if (this.zzl) {
            return iZza;
        }
        zzadt zzadtVar = new zzadt(C.TIME_UNSET, 0L);
        this.zzr = zzadtVar;
        this.zzp.zzO(zzadtVar);
        this.zzl = true;
        return iZza;
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzc(zzacx zzacxVar) {
        this.zzp = zzacxVar;
        this.zzq = zzacxVar.zzw(0, 1);
        zzacxVar.zzD();
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzd(long j11, long j12) {
        this.zzi = 0L;
        this.zzj = 0;
        this.zzk = 0;
        this.zzo = 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final boolean zze(zzacv zzacvVar) throws IOException {
        return zzg(zzacvVar);
    }
}
