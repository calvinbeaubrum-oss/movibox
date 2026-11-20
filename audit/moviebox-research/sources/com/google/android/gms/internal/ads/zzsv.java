package com.google.android.gms.internal.ads;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzsv {
    public final String zza;
    public final String zzb;
    public final String zzc;

    @Nullable
    public final MediaCodecInfo.CodecCapabilities zzd;
    public final boolean zze;
    public final boolean zzf;
    public final boolean zzg;
    private final boolean zzh;

    public zzsv(String str, String str2, String str3, @Nullable MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16) {
        str.getClass();
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = codecCapabilities;
        this.zzg = z11;
        this.zze = z14;
        this.zzf = z16;
        this.zzh = zzcb.zzh(str2);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x003d  */
    /* JADX WARN: Code duplicated, block: B:23:0x004c  */
    /* JADX WARN: Code duplicated, block: B:28:0x005b  */
    public static zzsv zzc(String str, String str2, String str3, @Nullable MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        boolean z16;
        boolean z17;
        boolean z18;
        if (codecCapabilities != null) {
            int i11 = zzfy.zza;
            if (codecCapabilities.isFeatureSupported("adaptive-playback")) {
                if (zzfy.zza <= 22) {
                    String str4 = zzfy.zzd;
                    z16 = (("ODROID-XU3".equals(str4) || "Nexus 10".equals(str4)) && ("OMX.Exynos.AVC.Decoder".equals(str) || "OMX.Exynos.AVC.Decoder.secure".equals(str))) ? false : true;
                }
            }
        }
        if (codecCapabilities != null) {
            int i12 = zzfy.zza;
            if (codecCapabilities.isFeatureSupported("tunneled-playback")) {
                z17 = true;
            } else {
                z17 = false;
            }
        } else {
            z17 = false;
        }
        if (!z15) {
            if (codecCapabilities != null) {
                int i13 = zzfy.zza;
                z18 = codecCapabilities.isFeatureSupported("secure-playback");
            }
        }
        return new zzsv(str, str2, str3, codecCapabilities, z11, z12, z13, z16, z17, z18);
    }

    @RequiresApi(21)
    private static Point zzi(MediaCodecInfo.VideoCapabilities videoCapabilities, int i11, int i12) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        int i13 = zzfy.zza;
        return new Point((((i11 + widthAlignment) - 1) / widthAlignment) * widthAlignment, (((i12 + heightAlignment) - 1) / heightAlignment) * heightAlignment);
    }

    private final void zzj(String str) {
        zzff.zzb(com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecInfo.TAG, "NoSupport [" + str + "] [" + this.zza + ", " + this.zzb + "] [" + zzfy.zze + "]");
    }

    @RequiresApi(21)
    private static boolean zzk(MediaCodecInfo.VideoCapabilities videoCapabilities, int i11, int i12, double d11) {
        Point pointZzi = zzi(videoCapabilities, i11, i12);
        int i13 = pointZzi.x;
        int i14 = pointZzi.y;
        return (d11 == -1.0d || d11 < 1.0d) ? videoCapabilities.isSizeSupported(i13, i14) : videoCapabilities.areSizeAndRateSupported(i13, i14, Math.floor(d11));
    }

    /* JADX WARN: Code duplicated, block: B:29:0x007b  */
    /* JADX WARN: Code duplicated, block: B:32:0x0081  */
    /* JADX WARN: Code duplicated, block: B:33:0x0084  */
    /* JADX WARN: Code duplicated, block: B:35:0x0089  */
    /* JADX WARN: Code duplicated, block: B:36:0x008c  */
    /* JADX WARN: Code duplicated, block: B:38:0x0091  */
    /* JADX WARN: Code duplicated, block: B:39:0x0094  */
    /* JADX WARN: Code duplicated, block: B:41:0x0099  */
    /* JADX WARN: Code duplicated, block: B:42:0x009c  */
    /* JADX WARN: Code duplicated, block: B:44:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:45:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:47:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:48:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:50:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:51:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:54:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:56:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:57:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:59:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:60:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:64:0x00db  */
    private final boolean zzl(zzam zzamVar, boolean z11) {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArrZzh;
        int i11;
        MediaCodecInfo.CodecCapabilities codecCapabilities;
        int iIntValue;
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        Pair pairZza = zztn.zza(zzamVar);
        if (pairZza != null) {
            int iIntValue2 = ((Integer) pairZza.first).intValue();
            int iIntValue3 = ((Integer) pairZza.second).intValue();
            int i12 = 8;
            if ("video/dolby-vision".equals(zzamVar.zzm)) {
                if (MimeTypes.VIDEO_H264.equals(this.zzb)) {
                    iIntValue3 = 0;
                    iIntValue2 = 8;
                } else if (MimeTypes.VIDEO_H265.equals(this.zzb)) {
                    iIntValue3 = 0;
                    iIntValue2 = 2;
                }
            }
            if (this.zzh) {
                codecProfileLevelArrZzh = zzh();
                if (zzfy.zza <= 23 && MimeTypes.VIDEO_VP9.equals(this.zzb) && codecProfileLevelArrZzh.length == 0) {
                    codecCapabilities = this.zzd;
                    if (codecCapabilities != null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
                        iIntValue = 0;
                    } else {
                        iIntValue = ((Integer) videoCapabilities.getBitrateRange().getUpper()).intValue();
                    }
                    if (iIntValue >= 180000000) {
                        i12 = 1024;
                    } else if (iIntValue >= 120000000) {
                        i12 = 512;
                    } else if (iIntValue >= 60000000) {
                        i12 = 256;
                    } else if (iIntValue >= 30000000) {
                        i12 = 128;
                    } else if (iIntValue >= 18000000) {
                        i12 = 64;
                    } else if (iIntValue >= 12000000) {
                        i12 = 32;
                    } else if (iIntValue >= 7200000) {
                        i12 = 16;
                    } else if (iIntValue < 3600000) {
                        if (iIntValue >= 1800000) {
                            i12 = 4;
                        } else if (iIntValue >= 800000) {
                            i12 = 2;
                        } else {
                            i12 = 1;
                        }
                    }
                    MediaCodecInfo.CodecProfileLevel codecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
                    codecProfileLevel.profile = 1;
                    codecProfileLevel.level = i12;
                    codecProfileLevelArrZzh = new MediaCodecInfo.CodecProfileLevel[]{codecProfileLevel};
                }
                for (MediaCodecInfo.CodecProfileLevel codecProfileLevel2 : codecProfileLevelArrZzh) {
                    if (codecProfileLevel2.profile != iIntValue2 && (codecProfileLevel2.level >= iIntValue3 || !z11)) {
                        if (MimeTypes.VIDEO_H265.equals(this.zzb) && iIntValue2 == 2) {
                            String str = zzfy.zzb;
                            if ("sailfish".equals(str) || "marlin".equals(str)) {
                            }
                        }
                    }
                }
                zzj("codec.profileLevel, " + zzamVar.zzj + ", " + this.zzc);
                return false;
            }
            if (iIntValue2 == 42) {
                iIntValue2 = 42;
                codecProfileLevelArrZzh = zzh();
                if (zzfy.zza <= 23) {
                    codecCapabilities = this.zzd;
                    if (codecCapabilities != null) {
                        iIntValue = 0;
                    } else {
                        iIntValue = 0;
                    }
                    if (iIntValue >= 180000000) {
                        i12 = 1024;
                    } else if (iIntValue >= 120000000) {
                        i12 = 512;
                    } else if (iIntValue >= 60000000) {
                        i12 = 256;
                    } else if (iIntValue >= 30000000) {
                        i12 = 128;
                    } else if (iIntValue >= 18000000) {
                        i12 = 64;
                    } else if (iIntValue >= 12000000) {
                        i12 = 32;
                    } else if (iIntValue >= 7200000) {
                        i12 = 16;
                    } else if (iIntValue < 3600000) {
                        if (iIntValue >= 1800000) {
                            i12 = 4;
                        } else if (iIntValue >= 800000) {
                            i12 = 2;
                        } else {
                            i12 = 1;
                        }
                    }
                    MediaCodecInfo.CodecProfileLevel codecProfileLevel3 = new MediaCodecInfo.CodecProfileLevel();
                    codecProfileLevel3.profile = 1;
                    codecProfileLevel3.level = i12;
                    codecProfileLevelArrZzh = new MediaCodecInfo.CodecProfileLevel[]{codecProfileLevel3};
                }
                while (i11 < r5) {
                    if (codecProfileLevel2.profile != iIntValue2) {
                    }
                }
                zzj("codec.profileLevel, " + zzamVar.zzj + ", " + this.zzc);
                return false;
            }
        }
        return true;
    }

    private final boolean zzm(zzam zzamVar) {
        return this.zzb.equals(zzamVar.zzm) || this.zzb.equals(zztn.zzc(zzamVar));
    }

    public final String toString() {
        return this.zza;
    }

    @Nullable
    @RequiresApi(21)
    public final Point zza(int i11, int i12) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
            return null;
        }
        return zzi(videoCapabilities, i11, i12);
    }

    public final zzis zzb(zzam zzamVar, zzam zzamVar2) {
        int i11 = true != zzfy.zzF(zzamVar.zzm, zzamVar2.zzm) ? 8 : 0;
        if (this.zzh) {
            if (zzamVar.zzu != zzamVar2.zzu) {
                i11 |= 1024;
            }
            if (!this.zze && (zzamVar.zzr != zzamVar2.zzr || zzamVar.zzs != zzamVar2.zzs)) {
                i11 |= 512;
            }
            if (!zzfy.zzF(zzamVar.zzy, zzamVar2.zzy)) {
                i11 |= 2048;
            }
            String str = this.zza;
            if (zzfy.zzd.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str) && !zzamVar.zzd(zzamVar2)) {
                i11 |= 2;
            }
            if (i11 == 0) {
                return new zzis(this.zza, zzamVar, zzamVar2, true != zzamVar.zzd(zzamVar2) ? 2 : 3, 0);
            }
        } else {
            if (zzamVar.zzz != zzamVar2.zzz) {
                i11 |= 4096;
            }
            if (zzamVar.zzA != zzamVar2.zzA) {
                i11 |= 8192;
            }
            if (zzamVar.zzB != zzamVar2.zzB) {
                i11 |= 16384;
            }
            if (i11 == 0 && MimeTypes.AUDIO_AAC.equals(this.zzb)) {
                Pair pairZza = zztn.zza(zzamVar);
                Pair pairZza2 = zztn.zza(zzamVar2);
                if (pairZza != null && pairZza2 != null) {
                    int iIntValue = ((Integer) pairZza.first).intValue();
                    int iIntValue2 = ((Integer) pairZza2.first).intValue();
                    if (iIntValue == 42 && iIntValue2 == 42) {
                        return new zzis(this.zza, zzamVar, zzamVar2, 3, 0);
                    }
                }
            }
            if (!zzamVar.zzd(zzamVar2)) {
                i11 |= 32;
            }
            if (MimeTypes.AUDIO_OPUS.equals(this.zzb)) {
                i11 |= 2;
            }
            if (i11 == 0) {
                return new zzis(this.zza, zzamVar, zzamVar2, 1, 0);
            }
        }
        return new zzis(this.zza, zzamVar, zzamVar2, 0, i11);
    }

    public final boolean zzd(zzam zzamVar) {
        return zzm(zzamVar) && zzl(zzamVar, false);
    }

    public final boolean zze(zzam zzamVar) throws zzth {
        int i11;
        int i12;
        if (!zzm(zzamVar) || !zzl(zzamVar, true)) {
            return false;
        }
        if (this.zzh) {
            int i13 = zzamVar.zzr;
            if (i13 <= 0 || (i12 = zzamVar.zzs) <= 0) {
                return true;
            }
            int i14 = zzfy.zza;
            return zzg(i13, i12, zzamVar.zzt);
        }
        int i15 = zzfy.zza;
        int i16 = zzamVar.zzA;
        if (i16 != -1) {
            MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
            if (codecCapabilities == null) {
                zzj("sampleRate.caps");
                return false;
            }
            MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
            if (audioCapabilities == null) {
                zzj("sampleRate.aCaps");
                return false;
            }
            if (!audioCapabilities.isSampleRateSupported(i16)) {
                zzj("sampleRate.support, " + i16);
                return false;
            }
        }
        int i17 = zzamVar.zzz;
        if (i17 != -1) {
            MediaCodecInfo.CodecCapabilities codecCapabilities2 = this.zzd;
            if (codecCapabilities2 == null) {
                zzj("channelCount.caps");
            } else {
                MediaCodecInfo.AudioCapabilities audioCapabilities2 = codecCapabilities2.getAudioCapabilities();
                if (audioCapabilities2 == null) {
                    zzj("channelCount.aCaps");
                } else {
                    String str = this.zza;
                    String str2 = this.zzb;
                    int maxInputChannelCount = audioCapabilities2.getMaxInputChannelCount();
                    if (maxInputChannelCount <= 1 && ((zzfy.zza < 26 || maxInputChannelCount <= 0) && !MimeTypes.AUDIO_MPEG.equals(str2) && !MimeTypes.AUDIO_AMR_NB.equals(str2) && !MimeTypes.AUDIO_AMR_WB.equals(str2) && !MimeTypes.AUDIO_AAC.equals(str2) && !MimeTypes.AUDIO_VORBIS.equals(str2) && !MimeTypes.AUDIO_OPUS.equals(str2) && !MimeTypes.AUDIO_RAW.equals(str2) && !MimeTypes.AUDIO_FLAC.equals(str2) && !MimeTypes.AUDIO_ALAW.equals(str2) && !MimeTypes.AUDIO_MLAW.equals(str2) && !MimeTypes.AUDIO_MSGSM.equals(str2))) {
                        if (MimeTypes.AUDIO_AC3.equals(str2)) {
                            i11 = 6;
                        } else {
                            i11 = MimeTypes.AUDIO_E_AC3.equals(str2) ? 16 : 30;
                        }
                        zzff.zzf(com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecInfo.TAG, "AssumedMaxChannelAdjustment: " + str + ", [" + maxInputChannelCount + " to " + i11 + "]");
                        maxInputChannelCount = i11;
                    }
                    if (maxInputChannelCount < i17) {
                        zzj("channelCount.support, " + i17);
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final boolean zzf(zzam zzamVar) {
        if (this.zzh) {
            return this.zze;
        }
        Pair pairZza = zztn.zza(zzamVar);
        return pairZza != null && ((Integer) pairZza.first).intValue() == 42;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x005b  */
    @RequiresApi(21)
    public final boolean zzg(int i11, int i12, double d11) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
        if (codecCapabilities == null) {
            zzj("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            zzj("sizeAndRate.vCaps");
            return false;
        }
        if (zzfy.zza >= 29) {
            int iZza = zzsu.zza(videoCapabilities, this.zzb, i11, i12, d11);
            if (iZza != 2) {
                if (iZza == 1) {
                    zzj("sizeAndRate.cover, " + i11 + "x" + i12 + "@" + d11);
                    return false;
                }
                if (!zzk(videoCapabilities, i11, i12, d11)) {
                    if (i11 < i12) {
                    }
                    zzj("sizeAndRate.support, " + i11 + "x" + i12 + "@" + d11);
                    return false;
                }
            }
        } else if (!zzk(videoCapabilities, i11, i12, d11)) {
            if (i11 < i12 || (("OMX.MTK.VIDEO.DECODER.HEVC".equals(this.zza) && "mcv5a".equals(zzfy.zzb)) || !zzk(videoCapabilities, i12, i11, d11))) {
                zzj("sizeAndRate.support, " + i11 + "x" + i12 + "@" + d11);
                return false;
            }
            zzff.zzb(com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecInfo.TAG, "AssumedSupport [" + ("sizeAndRate.rotated, " + i11 + "x" + i12 + "@" + d11) + "] [" + this.zza + ", " + this.zzb + "] [" + zzfy.zze + "]");
        }
        return true;
    }

    public final MediaCodecInfo.CodecProfileLevel[] zzh() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
        return (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) ? new MediaCodecInfo.CodecProfileLevel[0] : codecProfileLevelArr;
    }
}
