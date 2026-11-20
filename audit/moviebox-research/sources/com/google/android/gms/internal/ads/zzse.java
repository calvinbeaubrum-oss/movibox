package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.os.HandlerThread;
import android.os.Trace;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzse implements zzsq {
    private final zzfxu zzb;
    private final zzfxu zzc;
    private boolean zzd;

    public zzse(int i11) {
        zzsc zzscVar = new zzsc(i11);
        zzsd zzsdVar = new zzsd(i11);
        this.zzb = zzscVar;
        this.zzc = zzsdVar;
        this.zzd = true;
    }

    public static /* synthetic */ HandlerThread zza(int i11) {
        return new HandlerThread(zzsg.zzr(i11, "ExoPlayer:MediaCodecAsyncAdapter:"));
    }

    public static /* synthetic */ HandlerThread zzb(int i11) {
        return new HandlerThread(zzsg.zzr(i11, "ExoPlayer:MediaCodecQueueingThread:"));
    }

    /* JADX WARN: Code duplicated, block: B:14:0x003d A[Catch: Exception -> 0x003b, TryCatch #0 {Exception -> 0x003b, blocks: (B:4:0x001f, B:6:0x0023, B:9:0x002c, B:11:0x0034, B:15:0x004d, B:14:0x003d), top: B:27:0x001f }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.google.android.gms.internal.ads.zzsf] */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.android.gms.internal.ads.zzsg] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public final zzsg zzc(zzsp zzspVar) throws Exception {
        MediaCodec mediaCodecCreateByCodecName;
        zzss zzskVar;
        int i11;
        String str = zzspVar.zza.zza;
        ?? r11 = 0;
        r11 = 0;
        try {
            int i12 = zzfy.zza;
            Trace.beginSection("createCodec:" + str);
            mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
            try {
                if (this.zzd) {
                    zzam zzamVar = zzspVar.zzc;
                    if (zzfy.zza >= 34 && zzcb.zzh(zzamVar.zzm)) {
                        zzskVar = new zztq(mediaCodecCreateByCodecName);
                        i11 = 4;
                    } else {
                        zzskVar = new zzsk(mediaCodecCreateByCodecName, zzb(((zzsd) this.zzc).zza));
                        i11 = 0;
                    }
                } else {
                    zzskVar = new zzsk(mediaCodecCreateByCodecName, zzb(((zzsd) this.zzc).zza));
                    i11 = 0;
                }
                zzsg zzsgVar = new zzsg(mediaCodecCreateByCodecName, zza(((zzsc) this.zzb).zza), zzskVar, r11);
                try {
                    Trace.endSection();
                    zzsg.zzh(zzsgVar, zzspVar.zzb, zzspVar.zzd, null, i11);
                    return zzsgVar;
                } catch (Exception e11) {
                    e = e11;
                    r11 = zzsgVar;
                    if (r11 != 0) {
                        r11.zzl();
                    } else if (mediaCodecCreateByCodecName != null) {
                        mediaCodecCreateByCodecName.release();
                    }
                    throw e;
                }
            } catch (Exception e12) {
                e = e12;
            }
        } catch (Exception e13) {
            e = e13;
            mediaCodecCreateByCodecName = null;
        }
    }

    public final void zzd(boolean z11) {
        this.zzd = true;
    }
}
