package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.media3.common.PlaybackException;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzrj extends zzsz implements zzlh {
    private final Context zzb;
    private final zzpt zzc;
    private final zzqb zzd;
    private int zze;
    private boolean zzf;
    private boolean zzg;

    @Nullable
    private zzam zzh;

    @Nullable
    private zzam zzi;
    private long zzj;
    private boolean zzk;
    private boolean zzl;

    @Nullable
    private zzme zzm;
    private boolean zzn;

    public zzrj(Context context, zzsq zzsqVar, zztb zztbVar, boolean z11, @Nullable Handler handler, @Nullable zzpu zzpuVar, zzqb zzqbVar) {
        super(1, zzsqVar, zztbVar, false, 44100.0f);
        this.zzb = context.getApplicationContext();
        this.zzd = zzqbVar;
        this.zzc = new zzpt(handler, zzpuVar);
        zzqbVar.zzp(new zzri(this, null));
    }

    private final int zzaK(zzsv zzsvVar, zzam zzamVar) {
        int i11;
        if (!"OMX.google.raw.decoder".equals(zzsvVar.zza) || (i11 = zzfy.zza) >= 24 || (i11 == 23 && zzfy.zzJ(this.zzb))) {
            return zzamVar.zzn;
        }
        return -1;
    }

    private static List zzaL(zztb zztbVar, zzam zzamVar, boolean z11, zzqb zzqbVar) throws zzth {
        zzsv zzsvVarZzb;
        if (zzamVar.zzm == null) {
            return zzgaa.zzl();
        }
        return (!zzqbVar.zzz(zzamVar) || (zzsvVarZzb = zztn.zzb()) == null) ? zztn.zzf(zztbVar, zzamVar, false, false) : zzgaa.zzm(zzsvVarZzb);
    }

    private final void zzaM() {
        long jZzb = this.zzd.zzb(zzV());
        if (jZzb != Long.MIN_VALUE) {
            if (!this.zzk) {
                jZzb = Math.max(this.zzj, jZzb);
            }
            this.zzj = jZzb;
            this.zzk = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zziq
    public final void zzA() {
    }

    @Override // com.google.android.gms.internal.ads.zzsz, com.google.android.gms.internal.ads.zziq
    public final void zzB() {
        this.zzn = false;
        try {
            super.zzB();
            if (this.zzl) {
            }
        } finally {
            if (this.zzl) {
                this.zzl = false;
                this.zzd.zzk();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zziq
    public final void zzC() {
        this.zzd.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zziq
    public final void zzD() {
        zzaM();
        this.zzd.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzmf, com.google.android.gms.internal.ads.zzmh
    public final String zzT() {
        return "MediaCodecAudioRenderer";
    }

    @Override // com.google.android.gms.internal.ads.zzsz, com.google.android.gms.internal.ads.zzmf
    public final boolean zzV() {
        return super.zzV() && this.zzd.zzy();
    }

    @Override // com.google.android.gms.internal.ads.zzsz, com.google.android.gms.internal.ads.zzmf
    public final boolean zzW() {
        return this.zzd.zzx() || super.zzW();
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    public final float zzY(float f11, zzam zzamVar, zzam[] zzamVarArr) {
        int iMax = -1;
        for (zzam zzamVar2 : zzamVarArr) {
            int i11 = zzamVar2.zzA;
            if (i11 != -1) {
                iMax = Math.max(iMax, i11);
            }
        }
        if (iMax == -1) {
            return -1.0f;
        }
        return iMax * f11;
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    public final int zzZ(zztb zztbVar, zzam zzamVar) throws zzth {
        int i11;
        boolean z11;
        if (!zzcb.zzg(zzamVar.zzm)) {
            return 128;
        }
        int i12 = zzfy.zza;
        int i13 = zzamVar.zzG;
        boolean zZzaJ = zzsz.zzaJ(zzamVar);
        int i14 = 1;
        if (!zZzaJ || (i13 != 0 && zztn.zzb() == null)) {
            i11 = 0;
        } else {
            zzpg zzpgVarZzd = this.zzd.zzd(zzamVar);
            if (zzpgVarZzd.zzb) {
                i11 = true != zzpgVarZzd.zzc ? 512 : 1536;
                if (zzpgVarZzd.zzd) {
                    i11 |= 2048;
                }
            } else {
                i11 = 0;
            }
            if (this.zzd.zzz(zzamVar)) {
                return i11 | 172;
            }
        }
        if ((!MimeTypes.AUDIO_RAW.equals(zzamVar.zzm) || this.zzd.zzz(zzamVar)) && this.zzd.zzz(zzfy.zzy(2, zzamVar.zzz, zzamVar.zzA))) {
            List listZzaL = zzaL(zztbVar, zzamVar, false, this.zzd);
            if (!listZzaL.isEmpty()) {
                if (zZzaJ) {
                    zzsv zzsvVar = (zzsv) listZzaL.get(0);
                    boolean zZze = zzsvVar.zze(zzamVar);
                    if (!zZze) {
                        int i15 = 1;
                        while (true) {
                            if (i15 >= listZzaL.size()) {
                                z11 = true;
                                break;
                            }
                            zzsv zzsvVar2 = (zzsv) listZzaL.get(i15);
                            if (zzsvVar2.zze(zzamVar)) {
                                zzsvVar = zzsvVar2;
                                z11 = false;
                                zZze = true;
                                break;
                            }
                            i15++;
                        }
                    } else {
                        z11 = true;
                        break;
                    }
                    int i16 = true != zZze ? 3 : 4;
                    int i17 = 8;
                    if (zZze && zzsvVar.zzf(zzamVar)) {
                        i17 = 16;
                    }
                    return i16 | i17 | 32 | (true != zzsvVar.zzg ? 0 : 64) | (true != z11 ? 0 : 128) | i11;
                }
                i14 = 2;
            }
        }
        return i14 | 128;
    }

    @Override // com.google.android.gms.internal.ads.zzlh
    public final long zza() {
        if (zzbf() == 2) {
            zzaM();
        }
        return this.zzj;
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    public final zzis zzaa(zzsv zzsvVar, zzam zzamVar, zzam zzamVar2) {
        int i11;
        int i12;
        zzis zzisVarZzb = zzsvVar.zzb(zzamVar, zzamVar2);
        int i13 = zzisVarZzb.zze;
        if (zzaH(zzamVar2)) {
            i13 |= 32768;
        }
        if (zzaK(zzsvVar, zzamVar2) > this.zze) {
            i13 |= 64;
        }
        String str = zzsvVar.zza;
        if (i13 != 0) {
            i12 = i13;
            i11 = 0;
        } else {
            i11 = zzisVarZzb.zzd;
            i12 = 0;
        }
        return new zzis(str, zzamVar, zzamVar2, i11, i12);
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    @Nullable
    public final zzis zzab(zzlb zzlbVar) throws zziz {
        zzam zzamVar = zzlbVar.zza;
        zzamVar.getClass();
        this.zzh = zzamVar;
        zzis zzisVarZzab = super.zzab(zzlbVar);
        this.zzc.zzi(zzamVar, zzisVarZzab);
        return zzisVarZzab;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x005e  */
    /* JADX WARN: Code duplicated, block: B:44:0x00d1  */
    @Override // com.google.android.gms.internal.ads.zzsz
    public final zzsp zzae(zzsv zzsvVar, zzam zzamVar, @Nullable MediaCrypto mediaCrypto, float f11) {
        boolean z11;
        zzam[] zzamVarArrZzS = zzS();
        int length = zzamVarArrZzS.length;
        int iZzaK = zzaK(zzsvVar, zzamVar);
        if (length != 1) {
            for (zzam zzamVar2 : zzamVarArrZzS) {
                if (zzsvVar.zzb(zzamVar, zzamVar2).zzd != 0) {
                    iZzaK = Math.max(iZzaK, zzaK(zzsvVar, zzamVar2));
                }
            }
        }
        this.zze = iZzaK;
        String str = zzsvVar.zza;
        int i11 = zzfy.zza;
        if (i11 < 24 && "OMX.SEC.aac.dec".equals(str) && "samsung".equals(zzfy.zzc)) {
            String str2 = zzfy.zzb;
            if (str2.startsWith("zeroflte") || str2.startsWith("herolte") || str2.startsWith("heroqlte")) {
                z11 = true;
            } else {
                z11 = false;
            }
        } else {
            z11 = false;
        }
        this.zzf = z11;
        String str3 = zzsvVar.zza;
        this.zzg = str3.equals("OMX.google.opus.decoder") || str3.equals("c2.android.opus.decoder") || str3.equals("OMX.google.vorbis.decoder") || str3.equals("c2.android.vorbis.decoder");
        String str4 = zzsvVar.zzc;
        int i12 = this.zze;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str4);
        mediaFormat.setInteger("channel-count", zzamVar.zzz);
        mediaFormat.setInteger("sample-rate", zzamVar.zzA);
        zzfi.zzb(mediaFormat, zzamVar.zzo);
        zzfi.zza(mediaFormat, "max-input-size", i12);
        if (i11 >= 23) {
            mediaFormat.setInteger(TrackingKey.PRIORITY, 0);
            if (f11 != -1.0f) {
                if (i11 == 23) {
                    String str5 = zzfy.zzd;
                    if (!"ZTE B2017G".equals(str5) && !"AXON 7 mini".equals(str5)) {
                        mediaFormat.setFloat("operating-rate", f11);
                    }
                } else {
                    mediaFormat.setFloat("operating-rate", f11);
                }
            }
        }
        if (i11 <= 28 && "audio/ac4".equals(zzamVar.zzm)) {
            mediaFormat.setInteger("ac4-is-sync", 1);
        }
        if (i11 >= 24 && this.zzd.zza(zzfy.zzy(4, zzamVar.zzz, zzamVar.zzA)) == 2) {
            mediaFormat.setInteger("pcm-encoding", 4);
        }
        if (i11 >= 32) {
            mediaFormat.setInteger("max-output-channel-count", 99);
        }
        this.zzi = (!MimeTypes.AUDIO_RAW.equals(zzsvVar.zzb) || MimeTypes.AUDIO_RAW.equals(zzamVar.zzm)) ? null : zzamVar;
        return zzsp.zza(zzsvVar, mediaFormat, zzamVar, null);
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    public final List zzaf(zztb zztbVar, zzam zzamVar, boolean z11) throws zzth {
        return zztn.zzg(zzaL(zztbVar, zzamVar, false, this.zzd), zzamVar);
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    public final void zzah(zzih zzihVar) {
        zzam zzamVar;
        if (zzfy.zza < 29 || (zzamVar = zzihVar.zza) == null || !Objects.equals(zzamVar.zzm, MimeTypes.AUDIO_OPUS) || !zzaG()) {
            return;
        }
        ByteBuffer byteBuffer = zzihVar.zzf;
        byteBuffer.getClass();
        zzam zzamVar2 = zzihVar.zza;
        zzamVar2.getClass();
        if (byteBuffer.remaining() == 8) {
            this.zzd.zzq(zzamVar2.zzC, (int) ((byteBuffer.order(ByteOrder.LITTLE_ENDIAN).getLong() * 48000) / C.NANOS_PER_SECOND));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    public final void zzai(Exception exc) {
        zzff.zzd("MediaCodecAudioRenderer", "Audio codec error", exc);
        this.zzc.zza(exc);
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    public final void zzaj(String str, zzsp zzspVar, long j11, long j12) {
        this.zzc.zze(str, j11, j12);
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    public final void zzak(String str) {
        this.zzc.zzf(str);
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    public final void zzal(zzam zzamVar, @Nullable MediaFormat mediaFormat) throws zziz {
        int iZzk;
        int i11;
        zzam zzamVar2 = this.zzi;
        boolean z11 = true;
        int[] iArr = null;
        if (zzamVar2 != null) {
            zzamVar = zzamVar2;
        } else if (zzau() != null) {
            mediaFormat.getClass();
            if (MimeTypes.AUDIO_RAW.equals(zzamVar.zzm)) {
                iZzk = zzamVar.zzB;
            } else if (zzfy.zza < 24 || !mediaFormat.containsKey("pcm-encoding")) {
                iZzk = mediaFormat.containsKey("v-bits-per-sample") ? zzfy.zzk(mediaFormat.getInteger("v-bits-per-sample")) : 2;
            } else {
                iZzk = mediaFormat.getInteger("pcm-encoding");
            }
            zzak zzakVar = new zzak();
            zzakVar.zzW(MimeTypes.AUDIO_RAW);
            zzakVar.zzQ(iZzk);
            zzakVar.zzF(zzamVar.zzC);
            zzakVar.zzG(zzamVar.zzD);
            zzakVar.zzP(zzamVar.zzk);
            zzakVar.zzK(zzamVar.zzb);
            zzakVar.zzM(zzamVar.zzc);
            zzakVar.zzN(zzamVar.zzd);
            zzakVar.zzY(zzamVar.zze);
            zzakVar.zzU(zzamVar.zzf);
            zzakVar.zzy(mediaFormat.getInteger("channel-count"));
            zzakVar.zzX(mediaFormat.getInteger("sample-rate"));
            zzam zzamVarZzac = zzakVar.zzac();
            if (this.zzf && zzamVarZzac.zzz == 6 && (i11 = zzamVar.zzz) < 6) {
                iArr = new int[i11];
                for (int i12 = 0; i12 < zzamVar.zzz; i12++) {
                    iArr[i12] = i12;
                }
            } else if (this.zzg) {
                int i13 = zzamVarZzac.zzz;
                if (i13 == 3) {
                    iArr = new int[]{0, 2, 1};
                } else if (i13 == 5) {
                    iArr = new int[]{0, 2, 1, 3, 4};
                } else if (i13 == 6) {
                    iArr = new int[]{0, 2, 1, 5, 3, 4};
                } else if (i13 == 7) {
                    iArr = new int[]{0, 2, 1, 6, 5, 3, 4};
                } else if (i13 == 8) {
                    iArr = new int[]{0, 2, 1, 7, 5, 6, 3, 4};
                }
            }
            zzamVar = zzamVarZzac;
        }
        try {
            int i14 = zzfy.zza;
            if (i14 >= 29) {
                if (zzaG()) {
                    zzm();
                }
                if (i14 < 29) {
                    z11 = false;
                }
                zzek.zzf(z11);
            }
            this.zzd.zze(zzamVar, 0, iArr);
        } catch (zzpw e11) {
            throw zzi(e11, e11.zza, false, 5001);
        }
    }

    @CallSuper
    public final void zzam() {
        this.zzk = true;
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    public final void zzan() {
        this.zzd.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    public final void zzao() throws zziz {
        try {
            this.zzd.zzj();
        } catch (zzqa e11) {
            throw zzi(e11, e11.zzc, e11.zzb, true != zzaG() ? 5002 : PlaybackException.ERROR_CODE_AUDIO_TRACK_OFFLOAD_WRITE_FAILED);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    public final boolean zzap(long j11, long j12, @Nullable zzsr zzsrVar, @Nullable ByteBuffer byteBuffer, int i11, int i12, int i13, long j13, boolean z11, boolean z12, zzam zzamVar) throws zziz {
        byteBuffer.getClass();
        if (this.zzi != null && (i12 & 2) != 0) {
            zzsrVar.getClass();
            zzsrVar.zzn(i11, false);
            return true;
        }
        if (z11) {
            if (zzsrVar != null) {
                zzsrVar.zzn(i11, false);
            }
            ((zzsz) this).zza.zzf += i13;
            this.zzd.zzg();
            return true;
        }
        try {
            if (!this.zzd.zzw(byteBuffer, j13, i13)) {
                return false;
            }
            if (zzsrVar != null) {
                zzsrVar.zzn(i11, false);
            }
            ((zzsz) this).zza.zze += i13;
            return true;
        } catch (zzpx e11) {
            throw zzi(e11, this.zzh, e11.zzb, 5001);
        } catch (zzqa e12) {
            if (zzaG()) {
                zzm();
            }
            throw zzi(e12, zzamVar, e12.zzb, 5002);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    public final boolean zzaq(zzam zzamVar) {
        zzm();
        return this.zzd.zzz(zzamVar);
    }

    @Override // com.google.android.gms.internal.ads.zzlh
    public final zzcg zzc() {
        return this.zzd.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzlh
    public final void zzg(zzcg zzcgVar) {
        this.zzd.zzr(zzcgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzlh
    public final boolean zzj() {
        boolean z11 = this.zzn;
        this.zzn = false;
        return z11;
    }

    @Override // com.google.android.gms.internal.ads.zziq, com.google.android.gms.internal.ads.zzmf
    @Nullable
    public final zzlh zzk() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zziq, com.google.android.gms.internal.ads.zzma
    public final void zzt(int i11, @Nullable Object obj) throws zziz {
        if (i11 == 2) {
            zzqb zzqbVar = this.zzd;
            obj.getClass();
            zzqbVar.zzv(((Float) obj).floatValue());
            return;
        }
        if (i11 == 3) {
            zzk zzkVar = (zzk) obj;
            zzqb zzqbVar2 = this.zzd;
            zzkVar.getClass();
            zzqbVar2.zzl(zzkVar);
            return;
        }
        if (i11 == 6) {
            zzl zzlVar = (zzl) obj;
            zzqb zzqbVar3 = this.zzd;
            zzlVar.getClass();
            zzqbVar3.zzn(zzlVar);
            return;
        }
        switch (i11) {
            case 9:
                zzqb zzqbVar4 = this.zzd;
                obj.getClass();
                zzqbVar4.zzu(((Boolean) obj).booleanValue());
                break;
            case 10:
                zzqb zzqbVar5 = this.zzd;
                obj.getClass();
                zzqbVar5.zzm(((Integer) obj).intValue());
                break;
            case 11:
                this.zzm = (zzme) obj;
                break;
            case 12:
                if (zzfy.zza >= 23) {
                    zzrg.zza(this.zzd, obj);
                }
                break;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsz, com.google.android.gms.internal.ads.zziq
    public final void zzw() {
        this.zzl = true;
        this.zzh = null;
        try {
            this.zzd.zzf();
            super.zzw();
        } catch (Throwable th2) {
            super.zzw();
            throw th2;
        } finally {
            this.zzc.zzg(((zzsz) this).zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsz, com.google.android.gms.internal.ads.zziq
    public final void zzx(boolean z11, boolean z12) throws zziz {
        super.zzx(z11, z12);
        this.zzc.zzh(((zzsz) this).zza);
        zzm();
        this.zzd.zzs(zzn());
        this.zzd.zzo(zzh());
    }

    @Override // com.google.android.gms.internal.ads.zzsz, com.google.android.gms.internal.ads.zziq
    public final void zzz(long j11, boolean z11) throws zziz {
        super.zzz(j11, z11);
        this.zzd.zzf();
        this.zzj = j11;
        this.zzn = false;
        this.zzk = true;
    }
}
