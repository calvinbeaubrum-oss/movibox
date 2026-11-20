package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zztk implements zzti {
    private zztk() {
    }

    public /* synthetic */ zztk(zztj zztjVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzti
    public final int zza() {
        return MediaCodecList.getCodecCount();
    }

    @Override // com.google.android.gms.internal.ads.zzti
    public final MediaCodecInfo zzb(int i11) {
        return MediaCodecList.getCodecInfoAt(i11);
    }

    @Override // com.google.android.gms.internal.ads.zzti
    public final boolean zzc(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzti
    public final boolean zzd(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return "secure-playback".equals(str) && MimeTypes.VIDEO_H264.equals(str2);
    }

    @Override // com.google.android.gms.internal.ads.zzti
    public final boolean zze() {
        return false;
    }
}
