package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import android.os.Trace;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.applovin.exoplayer2.common.base.Ascii;
import com.cloud.tmc.integration.core.TmcEngineFactory;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzsz extends zziq {
    private static final byte[] zzb = {0, 0, 1, 103, 66, -64, Ascii.VT, -38, 37, -112, 0, 0, 1, 104, -50, Ascii.SI, 19, 32, 0, 0, 1, 101, -120, -124, Ascii.CR, -50, 113, Ascii.CAN, -96, 0, 47, -65, Ascii.FS, 49, -61, 39, 93, 120};
    private int zzA;
    private boolean zzB;
    private boolean zzC;
    private boolean zzD;
    private boolean zzE;
    private boolean zzF;
    private boolean zzG;
    private long zzH;
    private int zzI;
    private int zzJ;

    @Nullable
    private ByteBuffer zzK;
    private boolean zzL;
    private boolean zzM;
    private boolean zzN;
    private boolean zzO;
    private boolean zzP;
    private boolean zzQ;
    private int zzR;
    private int zzS;
    private int zzT;
    private boolean zzU;
    private boolean zzV;
    private boolean zzW;
    private long zzX;
    private long zzY;
    private boolean zzZ;
    protected zzir zza;
    private boolean zzaa;
    private boolean zzab;
    private zzsy zzac;
    private long zzad;
    private boolean zzae;

    @Nullable
    private zzrz zzaf;

    @Nullable
    private zzrz zzag;
    private final zzsq zzc;
    private final zztb zzd;
    private final float zze;
    private final zzih zzf;
    private final zzih zzg;
    private final zzih zzh;
    private final zzsn zzi;
    private final MediaCodec.BufferInfo zzj;
    private final ArrayDeque zzk;
    private final zzrk zzl;

    @Nullable
    private zzam zzm;

    @Nullable
    private zzam zzn;

    @Nullable
    private MediaCrypto zzo;
    private boolean zzp;
    private long zzq;
    private float zzr;

    @Nullable
    private zzsr zzs;

    @Nullable
    private zzam zzt;

    @Nullable
    private MediaFormat zzu;
    private boolean zzv;
    private float zzw;

    @Nullable
    private ArrayDeque zzx;

    @Nullable
    private zzsx zzy;

    @Nullable
    private zzsv zzz;

    public zzsz(int i11, zzsq zzsqVar, zztb zztbVar, boolean z11, float f11) {
        super(i11);
        this.zzc = zzsqVar;
        zztbVar.getClass();
        this.zzd = zztbVar;
        this.zze = f11;
        this.zzf = new zzih(0, 0);
        this.zzg = new zzih(0, 0);
        this.zzh = new zzih(2, 0);
        zzsn zzsnVar = new zzsn();
        this.zzi = zzsnVar;
        this.zzj = new MediaCodec.BufferInfo();
        this.zzr = 1.0f;
        this.zzq = C.TIME_UNSET;
        this.zzk = new ArrayDeque();
        this.zzac = zzsy.zza;
        zzsnVar.zzi(0);
        zzsnVar.zzc.order(ByteOrder.nativeOrder());
        this.zzl = new zzrk();
        this.zzw = -1.0f;
        this.zzA = 0;
        this.zzR = 0;
        this.zzI = -1;
        this.zzJ = -1;
        this.zzH = C.TIME_UNSET;
        this.zzX = C.TIME_UNSET;
        this.zzY = C.TIME_UNSET;
        this.zzad = C.TIME_UNSET;
        this.zzS = 0;
        this.zzT = 0;
        this.zza = new zzir();
    }

    public static boolean zzaJ(zzam zzamVar) {
        return zzamVar.zzG == 0;
    }

    @TargetApi(23)
    private final void zzaK() throws zziz {
        int i11 = this.zzT;
        if (i11 == 1) {
            zzag();
            return;
        }
        if (i11 == 2) {
            zzag();
            zzaO();
        } else if (i11 != 3) {
            this.zzaa = true;
            zzao();
        } else {
            zzaB();
            zzax();
        }
    }

    private final void zzaL() {
        this.zzI = -1;
        this.zzg.zzc = null;
    }

    private final void zzaM() {
        this.zzJ = -1;
        this.zzK = null;
    }

    private final void zzaN(zzsy zzsyVar) {
        this.zzac = zzsyVar;
        if (zzsyVar.zzd != C.TIME_UNSET) {
            this.zzae = true;
        }
    }

    @RequiresApi(23)
    private final void zzaO() throws zziz {
        zzrz zzrzVar = this.zzag;
        zzrzVar.getClass();
        this.zzaf = zzrzVar;
        this.zzS = 0;
        this.zzT = 0;
    }

    @TargetApi(23)
    private final boolean zzaP() throws zziz {
        if (this.zzU) {
            this.zzS = 1;
            if (this.zzC) {
                this.zzT = 3;
                return false;
            }
            this.zzT = 2;
        } else {
            zzaO();
        }
        return true;
    }

    private final boolean zzaQ() throws zziz {
        zzsr zzsrVar = this.zzs;
        if (zzsrVar == null || this.zzS == 2 || this.zzZ) {
            return false;
        }
        if (this.zzI < 0) {
            int iZza = zzsrVar.zza();
            this.zzI = iZza;
            if (iZza < 0) {
                return false;
            }
            this.zzg.zzc = zzsrVar.zzf(iZza);
            this.zzg.zzb();
        }
        if (this.zzS == 1) {
            if (!this.zzG) {
                this.zzV = true;
                zzsrVar.zzj(this.zzI, 0, 0, 0L, 4);
                zzaL();
            }
            this.zzS = 2;
            return false;
        }
        if (this.zzE) {
            this.zzE = false;
            ByteBuffer byteBuffer = this.zzg.zzc;
            byteBuffer.getClass();
            byteBuffer.put(zzb);
            zzsrVar.zzj(this.zzI, 0, 38, 0L, 0);
            zzaL();
            this.zzU = true;
            return true;
        }
        if (this.zzR == 1) {
            int i11 = 0;
            while (true) {
                zzam zzamVar = this.zzt;
                zzamVar.getClass();
                if (i11 >= zzamVar.zzo.size()) {
                    break;
                }
                byte[] bArr = (byte[]) this.zzt.zzo.get(i11);
                ByteBuffer byteBuffer2 = this.zzg.zzc;
                byteBuffer2.getClass();
                byteBuffer2.put(bArr);
                i11++;
            }
            this.zzR = 2;
        }
        ByteBuffer byteBuffer3 = this.zzg.zzc;
        byteBuffer3.getClass();
        int iPosition = byteBuffer3.position();
        zzlb zzlbVarZzbi = zzbi();
        try {
            int iZzbg = zzbg(zzlbVarZzbi, this.zzg, 0);
            if (iZzbg == -3) {
                if (zzP()) {
                    this.zzY = this.zzX;
                }
                return false;
            }
            if (iZzbg == -5) {
                if (this.zzR == 2) {
                    this.zzg.zzb();
                    this.zzR = 1;
                }
                zzab(zzlbVarZzbi);
                return true;
            }
            zzih zzihVar = this.zzg;
            if (zzihVar.zzf()) {
                this.zzY = this.zzX;
                if (this.zzR == 2) {
                    zzihVar.zzb();
                    this.zzR = 1;
                }
                this.zzZ = true;
                if (!this.zzU) {
                    zzaK();
                    return false;
                }
                try {
                    if (!this.zzG) {
                        this.zzV = true;
                        zzsrVar.zzj(this.zzI, 0, 0, 0L, 4);
                        zzaL();
                    }
                    return false;
                } catch (MediaCodec.CryptoException e11) {
                    throw zzi(e11, this.zzm, false, zzfy.zzi(e11.getErrorCode()));
                }
            }
            if (!this.zzU && !zzihVar.zzg()) {
                zzihVar.zzb();
                if (this.zzR == 2) {
                    this.zzR = 1;
                }
                return true;
            }
            boolean zZzk = zzihVar.zzk();
            if (zZzk) {
                zzihVar.zzb.zzb(iPosition);
            }
            long j11 = this.zzg.zze;
            if (this.zzab) {
                if (this.zzk.isEmpty()) {
                    zzfv zzfvVar = this.zzac.zze;
                    zzam zzamVar2 = this.zzm;
                    zzamVar2.getClass();
                    zzfvVar.zzd(j11, zzamVar2);
                } else {
                    zzfv zzfvVar2 = ((zzsy) this.zzk.peekLast()).zze;
                    zzam zzamVar3 = this.zzm;
                    zzamVar3.getClass();
                    zzfvVar2.zzd(j11, zzamVar3);
                }
                this.zzab = false;
            }
            long jMax = Math.max(this.zzX, j11);
            this.zzX = jMax;
            if (zzP() || this.zzg.zzh()) {
                this.zzY = jMax;
            }
            this.zzg.zzj();
            zzih zzihVar2 = this.zzg;
            if (zzihVar2.zze()) {
                zzah(zzihVar2);
            }
            zzaz(this.zzg);
            zzar(this.zzg);
            try {
                if (zZzk) {
                    zzsrVar.zzk(this.zzI, 0, this.zzg.zzb, j11, 0);
                } else {
                    int i12 = this.zzI;
                    ByteBuffer byteBuffer4 = this.zzg.zzc;
                    byteBuffer4.getClass();
                    zzsrVar.zzj(i12, 0, byteBuffer4.limit(), j11, 0);
                }
                zzaL();
                this.zzU = true;
                this.zzR = 0;
                this.zza.zzc++;
                return true;
            } catch (MediaCodec.CryptoException e12) {
                throw zzi(e12, this.zzm, false, zzfy.zzi(e12.getErrorCode()));
            }
        } catch (zzig e13) {
            zzai(e13);
            zzaT(0);
            zzag();
            return true;
        }
    }

    private final boolean zzaR() {
        return this.zzJ >= 0;
    }

    private final boolean zzaS(long j11, long j12) {
        if (j12 >= j11) {
            return false;
        }
        zzam zzamVar = this.zzn;
        return (zzamVar != null && Objects.equals(zzamVar.zzm, MimeTypes.AUDIO_OPUS) && zzadq.zzf(j11, j12)) ? false : true;
    }

    private final boolean zzaT(int i11) throws zziz {
        zzih zzihVar = this.zzf;
        zzlb zzlbVarZzbi = zzbi();
        zzihVar.zzb();
        int iZzbg = zzbg(zzlbVarZzbi, this.zzf, i11 | 4);
        if (iZzbg == -5) {
            zzab(zzlbVarZzbi);
            return true;
        }
        if (iZzbg != -4 || !this.zzf.zzf()) {
            return false;
        }
        this.zzZ = true;
        zzaK();
        return false;
    }

    private final boolean zzaU(long j11) {
        if (this.zzq == C.TIME_UNSET) {
            return true;
        }
        zzh();
        return SystemClock.elapsedRealtime() - j11 < this.zzq;
    }

    private final boolean zzaV(@Nullable zzam zzamVar) throws zziz {
        if (zzfy.zza >= 23 && this.zzs != null && this.zzT != 3 && zzbf() != 0) {
            float f11 = this.zzr;
            zzamVar.getClass();
            float fZzY = zzY(f11, zzamVar, zzS());
            float f12 = this.zzw;
            if (f12 != fZzY) {
                if (fZzY == -1.0f) {
                    zzad();
                    return false;
                }
                if (f12 != -1.0f || fZzY > this.zze) {
                    Bundle bundle = new Bundle();
                    bundle.putFloat("operating-rate", fZzY);
                    zzsr zzsrVar = this.zzs;
                    zzsrVar.getClass();
                    zzsrVar.zzp(bundle);
                    this.zzw = fZzY;
                }
            }
        }
        return true;
    }

    private final void zzac() {
        this.zzP = false;
        this.zzi.zzb();
        this.zzh.zzb();
        this.zzO = false;
        this.zzN = false;
        this.zzl.zzb();
    }

    private final void zzad() throws zziz {
        if (this.zzU) {
            this.zzS = 1;
            this.zzT = 3;
        } else {
            zzaB();
            zzax();
        }
    }

    private final void zzag() {
        try {
            zzsr zzsrVar = this.zzs;
            zzek.zzb(zzsrVar);
            zzsrVar.zzi();
        } finally {
            zzaC();
        }
    }

    /* JADX WARN: Code duplicated, block: B:156:0x0335  */
    /* JADX WARN: Code duplicated, block: B:163:0x034a  */
    private final void zzam(zzsv zzsvVar, @Nullable MediaCrypto mediaCrypto) throws Exception {
        zzsr zztpVar;
        int i11;
        zzam zzamVar = this.zzm;
        zzamVar.getClass();
        String str = zzsvVar.zza;
        int i12 = zzfy.zza;
        float fZzY = i12 < 23 ? -1.0f : zzY(this.zzr, zzamVar, zzS());
        if (fZzY <= this.zze) {
            fZzY = -1.0f;
        }
        zzaA(zzamVar);
        zzh();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        MediaCodec mediaCodec = null;
        zzsp zzspVarZzae = zzae(zzsvVar, zzamVar, null, fZzY);
        if (i12 >= 31) {
            zzsw.zza(zzspVarZzae, zzn());
        }
        try {
            Trace.beginSection("createCodec:" + str);
            int i13 = 0;
            if (i12 < 23 || i12 < 31) {
                try {
                    String str2 = zzspVarZzae.zza.zza;
                    Trace.beginSection("createCodec:".concat(str2));
                    MediaCodec mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str2);
                    Trace.endSection();
                    try {
                        Trace.beginSection("configureCodec");
                        mediaCodecCreateByCodecName.configure(zzspVarZzae.zzb, zzspVarZzae.zzd, (MediaCrypto) null, 0);
                        Trace.endSection();
                        Trace.beginSection("startCodec");
                        mediaCodecCreateByCodecName.start();
                        Trace.endSection();
                        zztpVar = new zztp(mediaCodecCreateByCodecName, null);
                    } catch (IOException | RuntimeException e11) {
                        e = e11;
                        mediaCodec = mediaCodecCreateByCodecName;
                        if (mediaCodec != null) {
                            mediaCodec.release();
                        }
                        throw e;
                    }
                } catch (IOException e12) {
                    e = e12;
                } catch (RuntimeException e13) {
                    e = e13;
                }
            } else {
                int iZzb = zzcb.zzb(zzspVarZzae.zzc.zzm);
                zzff.zze("DMCodecAdapterFactory", "Creating an asynchronous MediaCodec adapter for track type ".concat(zzfy.zzB(iZzb)));
                zzse zzseVar = new zzse(iZzb);
                zzseVar.zzd(true);
                zztpVar = zzseVar.zzc(zzspVarZzae);
            }
            this.zzs = zztpVar;
            Trace.endSection();
            zzh();
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            if (!zzsvVar.zze(zzamVar)) {
                Object[] objArr = new Object[2];
                StringBuilder sb2 = new StringBuilder();
                sb2.append("id=");
                sb2.append(zzamVar.zzb);
                sb2.append(", mimeType=");
                sb2.append(zzamVar.zzm);
                if (zzamVar.zzl != null) {
                    sb2.append(", container=");
                    sb2.append(zzamVar.zzl);
                }
                if (zzamVar.zzi != -1) {
                    sb2.append(", bitrate=");
                    sb2.append(zzamVar.zzi);
                }
                if (zzamVar.zzj != null) {
                    sb2.append(", codecs=");
                    sb2.append(zzamVar.zzj);
                }
                if (zzamVar.zzp != null) {
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    while (true) {
                        zzae zzaeVar = zzamVar.zzp;
                        if (i13 >= zzaeVar.zzb) {
                            break;
                        }
                        UUID uuid = zzaeVar.zza(i13).zza;
                        if (uuid.equals(zzo.zzb)) {
                            linkedHashSet.add(C.CENC_TYPE_cenc);
                        } else if (uuid.equals(zzo.zzc)) {
                            linkedHashSet.add("clearkey");
                        } else if (uuid.equals(zzo.zze)) {
                            linkedHashSet.add("playready");
                        } else if (uuid.equals(zzo.zzd)) {
                            linkedHashSet.add("widevine");
                        } else if (uuid.equals(zzo.zza)) {
                            linkedHashSet.add("universal");
                        } else {
                            linkedHashSet.add("unknown (" + uuid.toString() + ")");
                        }
                        i13++;
                    }
                    sb2.append(", drm=[");
                    zzfwt.zzb(sb2, linkedHashSet, ",");
                    sb2.append(']');
                }
                if (zzamVar.zzr != -1 && zzamVar.zzs != -1) {
                    sb2.append(", res=");
                    sb2.append(zzamVar.zzr);
                    sb2.append("x");
                    sb2.append(zzamVar.zzs);
                }
                zzt zztVar = zzamVar.zzy;
                if (zztVar != null && (zztVar.zze() || zztVar.zzf())) {
                    sb2.append(", color=");
                    sb2.append(zzamVar.zzy.zzd());
                }
                if (zzamVar.zzt != -1.0f) {
                    sb2.append(", fps=");
                    sb2.append(zzamVar.zzt);
                }
                if (zzamVar.zzz != -1) {
                    sb2.append(", channels=");
                    sb2.append(zzamVar.zzz);
                }
                if (zzamVar.zzA != -1) {
                    sb2.append(", sample_rate=");
                    sb2.append(zzamVar.zzA);
                }
                if (zzamVar.zzd != null) {
                    sb2.append(", language=");
                    sb2.append(zzamVar.zzd);
                }
                if (zzamVar.zzc != null) {
                    sb2.append(", label=");
                    sb2.append(zzamVar.zzc);
                }
                if (zzamVar.zze != 0) {
                    sb2.append(", selectionFlags=[");
                    int i14 = zzamVar.zze;
                    ArrayList arrayList = new ArrayList();
                    if ((i14 & 1) != 0) {
                        arrayList.add(TmcEngineFactory.ENGINE_TYPE_DEFAULT);
                    }
                    if ((i14 & 2) != 0) {
                        arrayList.add("forced");
                    }
                    zzfwt.zzb(sb2, arrayList, ",");
                    sb2.append("]");
                }
                if (zzamVar.zzf != 0) {
                    sb2.append(", roleFlags=[");
                    int i15 = zzamVar.zzf;
                    ArrayList arrayList2 = new ArrayList();
                    if ((i15 & 1) != 0) {
                        arrayList2.add("main");
                    }
                    if ((i15 & 2) != 0) {
                        arrayList2.add("alt");
                    }
                    if ((i15 & 4) != 0) {
                        arrayList2.add("supplementary");
                    }
                    if ((i15 & 8) != 0) {
                        arrayList2.add("commentary");
                    }
                    if ((i15 & 16) != 0) {
                        arrayList2.add("dub");
                    }
                    if ((i15 & 32) != 0) {
                        arrayList2.add("emergency");
                    }
                    if ((i15 & 64) != 0) {
                        arrayList2.add("caption");
                    }
                    if ((i15 & 128) != 0) {
                        arrayList2.add("subtitle");
                    }
                    if ((i15 & 256) != 0) {
                        arrayList2.add("sign");
                    }
                    if ((i15 & 512) != 0) {
                        arrayList2.add("describes-video");
                    }
                    if ((i15 & 1024) != 0) {
                        arrayList2.add("describes-music");
                    }
                    if ((i15 & 2048) != 0) {
                        arrayList2.add("enhanced-intelligibility");
                    }
                    if ((i15 & 4096) != 0) {
                        arrayList2.add("transcribes-dialog");
                    }
                    if ((i15 & 8192) != 0) {
                        arrayList2.add("easy-read");
                    }
                    if ((i15 & 16384) != 0) {
                        arrayList2.add("trick-play");
                    }
                    zzfwt.zzb(sb2, arrayList2, ",");
                    sb2.append("]");
                }
                objArr[0] = sb2.toString();
                objArr[1] = str;
                zzff.zzf("MediaCodecRenderer", String.format(Locale.US, "Format exceeds selected codec's capabilities [%s, %s]", objArr));
            }
            this.zzz = zzsvVar;
            this.zzw = fZzY;
            this.zzt = zzamVar;
            int i16 = zzfy.zza;
            if (i16 <= 25 && "OMX.Exynos.avc.dec.secure".equals(str)) {
                String str3 = zzfy.zzd;
                if (str3.startsWith("SM-T585") || str3.startsWith("SM-A510") || str3.startsWith("SM-A520") || str3.startsWith("SM-J700")) {
                    i11 = 2;
                } else if (i16 < 24) {
                    i11 = 0;
                } else {
                    i11 = 0;
                }
            } else if (i16 < 24 || !("OMX.Nvidia.h264.decode".equals(str) || "OMX.Nvidia.h264.decode.secure".equals(str))) {
                i11 = 0;
            } else {
                String str4 = zzfy.zzb;
                if ("flounder".equals(str4) || "flounder_lte".equals(str4) || "grouper".equals(str4) || "tilapia".equals(str4)) {
                    i11 = 1;
                } else {
                    i11 = 0;
                }
            }
            this.zzA = i11;
            this.zzt.getClass();
            this.zzB = i16 == 29 && "c2.android.aac.decoder".equals(str);
            this.zzC = i16 <= 23 && "OMX.google.vorbis.decoder".equals(str);
            this.zzD = i16 == 21 && "OMX.google.aac.decoder".equals(str);
            this.zzt.getClass();
            String str5 = zzsvVar.zza;
            this.zzG = (i16 <= 25 && "OMX.rk.video_decoder.avc".equals(str5)) || (i16 <= 29 && ("OMX.broadcom.video_decoder.tunnel".equals(str5) || "OMX.broadcom.video_decoder.tunnel.secure".equals(str5) || "OMX.bcm.vdec.avc.tunnel".equals(str5) || "OMX.bcm.vdec.avc.tunnel.secure".equals(str5) || "OMX.bcm.vdec.hevc.tunnel".equals(str5) || "OMX.bcm.vdec.hevc.tunnel.secure".equals(str5))) || ("Amazon".equals(zzfy.zzc) && "AFTS".equals(zzfy.zzd) && zzsvVar.zzf);
            this.zzs.getClass();
            if (zzbf() == 2) {
                zzh();
                this.zzH = SystemClock.elapsedRealtime() + 1000;
            }
            this.zza.zza++;
            zzaj(str, zzspVarZzae, jElapsedRealtime2, jElapsedRealtime2 - jElapsedRealtime);
        } catch (Throwable th2) {
            Trace.endSection();
            throw th2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zziq
    public void zzB() {
        try {
            zzac();
            zzaB();
        } finally {
            this.zzag = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0037, code lost:
    
        if (r5 >= r1) goto L14;
     */
    @Override // com.google.android.gms.internal.ads.zziq
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzE(zzam[] zzamVarArr, long j11, long j12, zzur zzurVar) throws zziz {
        if (this.zzac.zzd == C.TIME_UNSET) {
            zzaN(new zzsy(C.TIME_UNSET, j11, j12));
            return;
        }
        if (this.zzk.isEmpty()) {
            long j13 = this.zzX;
            if (j13 != C.TIME_UNSET) {
                long j14 = this.zzad;
                if (j14 != C.TIME_UNSET) {
                }
            }
            zzaN(new zzsy(C.TIME_UNSET, j11, j12));
            if (this.zzac.zzd != C.TIME_UNSET) {
                zzan();
                return;
            }
            return;
        }
        this.zzk.add(new zzsy(this.zzX, j11, j12));
    }

    @Override // com.google.android.gms.internal.ads.zziq, com.google.android.gms.internal.ads.zzmf
    public void zzL(float f11, float f12) throws zziz {
        this.zzr = f12;
        zzaV(this.zzt);
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 10591. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    @Override // com.google.android.gms.internal.ads.zzmf
    public void zzU(long r24, long r26) throws com.google.android.gms.internal.ads.zziz {
        /*
            Method dump skipped, instruction units count: 1059
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsz.zzU(long, long):void");
    }

    @Override // com.google.android.gms.internal.ads.zzmf
    public boolean zzV() {
        return this.zzaa;
    }

    @Override // com.google.android.gms.internal.ads.zzmf
    public boolean zzW() {
        if (this.zzm == null) {
            return false;
        }
        if (zzR() || zzaR()) {
            return true;
        }
        if (this.zzH == C.TIME_UNSET) {
            return false;
        }
        zzh();
        return SystemClock.elapsedRealtime() < this.zzH;
    }

    @Override // com.google.android.gms.internal.ads.zzmh
    public final int zzX(zzam zzamVar) throws zziz {
        try {
            return zzZ(this.zzd, zzamVar);
        } catch (zzth e11) {
            throw zzi(e11, zzamVar, false, 4002);
        }
    }

    public float zzY(float f11, zzam zzamVar, zzam[] zzamVarArr) {
        throw null;
    }

    public abstract int zzZ(zztb zztbVar, zzam zzamVar) throws zzth;

    public void zzaA(zzam zzamVar) throws zziz {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzaB() {
        try {
            zzsr zzsrVar = this.zzs;
            if (zzsrVar != null) {
                zzsrVar.zzl();
                this.zza.zzb++;
                zzsv zzsvVar = this.zzz;
                zzsvVar.getClass();
                zzak(zzsvVar.zza);
            }
        } finally {
            this.zzs = null;
            this.zzo = null;
            this.zzaf = null;
            zzaD();
        }
    }

    @CallSuper
    public void zzaC() {
        zzaL();
        zzaM();
        this.zzH = C.TIME_UNSET;
        this.zzV = false;
        this.zzU = false;
        this.zzE = false;
        this.zzF = false;
        this.zzL = false;
        this.zzM = false;
        this.zzX = C.TIME_UNSET;
        this.zzY = C.TIME_UNSET;
        this.zzad = C.TIME_UNSET;
        this.zzS = 0;
        this.zzT = 0;
        this.zzR = this.zzQ ? 1 : 0;
    }

    @CallSuper
    public final void zzaD() {
        zzaC();
        this.zzx = null;
        this.zzz = null;
        this.zzt = null;
        this.zzu = null;
        this.zzv = false;
        this.zzW = false;
        this.zzw = -1.0f;
        this.zzA = 0;
        this.zzB = false;
        this.zzC = false;
        this.zzD = false;
        this.zzG = false;
        this.zzQ = false;
        this.zzR = 0;
        this.zzp = false;
    }

    public final boolean zzaE() throws zziz {
        boolean zZzaF = zzaF();
        if (zZzaF) {
            zzax();
        }
        return zZzaF;
    }

    public final boolean zzaF() {
        if (this.zzs == null) {
            return false;
        }
        int i11 = this.zzT;
        if (i11 == 3 || ((this.zzB && !this.zzW) || (this.zzC && this.zzV))) {
            zzaB();
            return true;
        }
        if (i11 == 2) {
            int i12 = zzfy.zza;
            zzek.zzf(i12 >= 23);
            if (i12 >= 23) {
                try {
                    zzaO();
                } catch (zziz e11) {
                    zzff.zzg("MediaCodecRenderer", "Failed to update the DRM session, releasing the codec instead.", e11);
                    zzaB();
                    return true;
                }
            }
        }
        zzag();
        return false;
    }

    public final boolean zzaG() {
        return this.zzN;
    }

    public final boolean zzaH(zzam zzamVar) {
        return this.zzag == null && zzaq(zzamVar);
    }

    public boolean zzaI(zzsv zzsvVar) {
        return true;
    }

    public zzis zzaa(zzsv zzsvVar, zzam zzamVar, zzam zzamVar2) {
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x005e  */
    @Nullable
    @CallSuper
    public zzis zzab(zzlb zzlbVar) throws zziz {
        int i11;
        boolean z11 = true;
        this.zzab = true;
        zzam zzamVar = zzlbVar.zza;
        zzamVar.getClass();
        if (zzamVar.zzm == null) {
            throw zzi(new IllegalArgumentException("Sample MIME type is null."), zzamVar, false, 4005);
        }
        this.zzag = zzlbVar.zzb;
        this.zzm = zzamVar;
        if (this.zzN) {
            this.zzP = true;
            return null;
        }
        zzsr zzsrVar = this.zzs;
        if (zzsrVar == null) {
            this.zzx = null;
            zzax();
            return null;
        }
        zzsv zzsvVar = this.zzz;
        zzsvVar.getClass();
        zzam zzamVar2 = this.zzt;
        zzamVar2.getClass();
        zzrz zzrzVar = this.zzaf;
        zzrz zzrzVar2 = this.zzag;
        if (zzrzVar != zzrzVar2) {
            zzad();
            return new zzis(zzsvVar.zza, zzamVar2, zzamVar, 0, 128);
        }
        boolean z12 = zzrzVar2 != zzrzVar;
        zzek.zzf(!z12 || zzfy.zza >= 23);
        zzis zzisVarZzaa = zzaa(zzsvVar, zzamVar2, zzamVar);
        int i12 = zzisVarZzaa.zzd;
        if (i12 != 0) {
            i11 = 2;
            if (i12 != 1) {
                if (i12 != 2) {
                    if (zzaV(zzamVar)) {
                        this.zzt = zzamVar;
                        if (!z12 || zzaP()) {
                        }
                    } else {
                        i11 = 16;
                    }
                } else if (zzaV(zzamVar)) {
                    this.zzQ = true;
                    this.zzR = 1;
                    int i13 = this.zzA;
                    if (i13 != 2 && (i13 != 1 || zzamVar.zzr != zzamVar2.zzr || zzamVar.zzs != zzamVar2.zzs)) {
                        z11 = false;
                    }
                    this.zzE = z11;
                    this.zzt = zzamVar;
                    if (!z12 || zzaP()) {
                    }
                } else {
                    i11 = 16;
                }
            } else if (zzaV(zzamVar)) {
                this.zzt = zzamVar;
                if (z12) {
                    if (zzaP()) {
                    }
                } else if (this.zzU) {
                    this.zzS = 1;
                    if (this.zzC) {
                        this.zzT = 3;
                    } else {
                        this.zzT = 1;
                    }
                }
            } else {
                i11 = 16;
            }
            return (zzisVarZzaa.zzd != 0 || (this.zzs == zzsrVar && this.zzT != 3)) ? zzisVarZzaa : new zzis(zzsvVar.zza, zzamVar2, zzamVar, 0, i11);
        }
        zzad();
        i11 = 0;
        if (zzisVarZzaa.zzd != 0) {
        }
    }

    public abstract zzsp zzae(zzsv zzsvVar, zzam zzamVar, @Nullable MediaCrypto mediaCrypto, float f11);

    public abstract List zzaf(zztb zztbVar, zzam zzamVar, boolean z11) throws zzth;

    public void zzah(zzih zzihVar) throws zziz {
        throw null;
    }

    public void zzai(Exception exc) {
        throw null;
    }

    public void zzaj(String str, zzsp zzspVar, long j11, long j12) {
        throw null;
    }

    public void zzak(String str) {
        throw null;
    }

    public void zzal(zzam zzamVar, @Nullable MediaFormat mediaFormat) throws zziz {
        throw null;
    }

    public void zzan() {
    }

    public void zzao() throws zziz {
    }

    public abstract boolean zzap(long j11, long j12, @Nullable zzsr zzsrVar, @Nullable ByteBuffer byteBuffer, int i11, int i12, int i13, long j13, boolean z11, boolean z12, zzam zzamVar) throws zziz;

    public boolean zzaq(zzam zzamVar) {
        return false;
    }

    public int zzar(zzih zzihVar) {
        return 0;
    }

    public final long zzas() {
        return this.zzac.zzd;
    }

    public final long zzat() {
        return this.zzac.zzc;
    }

    @Nullable
    public final zzsr zzau() {
        return this.zzs;
    }

    public zzst zzav(Throwable th2, @Nullable zzsv zzsvVar) {
        return new zzst(th2, zzsvVar);
    }

    @Nullable
    public final zzsv zzaw() {
        return this.zzz;
    }

    public final void zzax() throws zziz {
        zzam zzamVar;
        if (this.zzs != null || this.zzN || (zzamVar = this.zzm) == null) {
            return;
        }
        if (zzaH(zzamVar)) {
            zzam zzamVar2 = this.zzm;
            zzac();
            String str = zzamVar2.zzm;
            if (MimeTypes.AUDIO_AAC.equals(str) || MimeTypes.AUDIO_MPEG.equals(str) || MimeTypes.AUDIO_OPUS.equals(str)) {
                this.zzi.zzn(32);
            } else {
                this.zzi.zzn(1);
            }
            this.zzN = true;
            return;
        }
        zzrz zzrzVar = this.zzag;
        this.zzaf = zzrzVar;
        if (zzrzVar != null) {
            zzek.zzf(true);
            zzrz zzrzVar2 = this.zzaf;
            this.zzm.getClass();
            boolean z11 = zzsa.zza;
            zzrzVar2.zza();
        }
        try {
            zzam zzamVar3 = this.zzm;
            zzamVar3.getClass();
            if (this.zzx == null) {
                try {
                    List listZzaf = zzaf(this.zzd, zzamVar3, false);
                    listZzaf.isEmpty();
                    this.zzx = new ArrayDeque();
                    if (!listZzaf.isEmpty()) {
                        this.zzx.add((zzsv) listZzaf.get(0));
                    }
                    this.zzy = null;
                } catch (zzth e11) {
                    throw new zzsx(zzamVar3, (Throwable) e11, false, -49998);
                }
            }
            if (this.zzx.isEmpty()) {
                throw new zzsx(zzamVar3, (Throwable) null, false, -49999);
            }
            ArrayDeque arrayDeque = this.zzx;
            arrayDeque.getClass();
            zzsv zzsvVar = (zzsv) arrayDeque.peekFirst();
            while (this.zzs == null) {
                zzsv zzsvVar2 = (zzsv) arrayDeque.peekFirst();
                zzsvVar2.getClass();
                if (!zzaI(zzsvVar2)) {
                    return;
                }
                try {
                    zzam(zzsvVar2, null);
                } catch (Exception e12) {
                    if (zzsvVar2 != zzsvVar) {
                        throw e12;
                    }
                    try {
                        zzff.zzf("MediaCodecRenderer", "Preferred decoder instantiation failed. Sleeping for 50ms then retrying.");
                        Thread.sleep(50L);
                        zzam(zzsvVar2, null);
                    } catch (Exception e13) {
                        zzff.zzg("MediaCodecRenderer", "Failed to initialize decoder: ".concat(zzsvVar2.zza), e13);
                        arrayDeque.removeFirst();
                        zzsx zzsxVar = new zzsx(zzamVar3, (Throwable) e13, false, zzsvVar2);
                        zzai(zzsxVar);
                        zzsx zzsxVar2 = this.zzy;
                        if (zzsxVar2 == null) {
                            this.zzy = zzsxVar;
                        } else {
                            this.zzy = zzsx.zza(zzsxVar2, zzsxVar);
                        }
                        if (arrayDeque.isEmpty()) {
                            throw this.zzy;
                        }
                    }
                }
            }
            this.zzx = null;
        } catch (zzsx e14) {
            throw zzi(e14, this.zzm, false, 4001);
        }
    }

    @CallSuper
    public void zzay(long j11) {
        this.zzad = j11;
        while (!this.zzk.isEmpty() && j11 >= ((zzsy) this.zzk.peek()).zzb) {
            zzsy zzsyVar = (zzsy) this.zzk.poll();
            zzsyVar.getClass();
            zzaN(zzsyVar);
            zzan();
        }
    }

    public void zzaz(zzih zzihVar) throws zziz {
    }

    @Override // com.google.android.gms.internal.ads.zziq, com.google.android.gms.internal.ads.zzmh
    public final int zze() {
        return 8;
    }

    @Override // com.google.android.gms.internal.ads.zziq
    public void zzw() {
        this.zzm = null;
        zzaN(zzsy.zza);
        this.zzk.clear();
        zzaF();
    }

    @Override // com.google.android.gms.internal.ads.zziq
    public void zzx(boolean z11, boolean z12) throws zziz {
        this.zza = new zzir();
    }

    @Override // com.google.android.gms.internal.ads.zziq
    public void zzz(long j11, boolean z11) throws zziz {
        this.zzZ = false;
        this.zzaa = false;
        if (this.zzN) {
            this.zzi.zzb();
            this.zzh.zzb();
            this.zzO = false;
            this.zzl.zzb();
        } else {
            zzaE();
        }
        zzfv zzfvVar = this.zzac.zze;
        if (zzfvVar.zza() > 0) {
            this.zzab = true;
        }
        zzfvVar.zze();
        this.zzk.clear();
    }
}
