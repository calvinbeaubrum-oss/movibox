package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzaer implements zzaej {
    public final zzgaa zza;
    private final int zzb;

    private zzaer(int i11, zzgaa zzgaaVar) {
        this.zzb = i11;
        this.zza = zzgaaVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static zzaer zzc(int i11, zzfp zzfpVar) {
        String str;
        zzaej zzaesVar;
        String str2;
        zzfzx zzfzxVar = new zzfzx();
        int iZze = zzfpVar.zze();
        int i12 = -2;
        while (zzfpVar.zzb() > 8) {
            int iZzi = zzfpVar.zzi();
            int iZzd = zzfpVar.zzd() + zzfpVar.zzi();
            zzfpVar.zzJ(iZzd);
            if (iZzi != 1414744396) {
                zzaes zzaesVar2 = null;
                switch (iZzi) {
                    case 1718776947:
                        if (i12 != 2) {
                            if (i12 == 1) {
                                int iZzk = zzfpVar.zzk();
                                if (iZzk == 1) {
                                    str = MimeTypes.AUDIO_RAW;
                                } else if (iZzk == 85) {
                                    str = MimeTypes.AUDIO_MPEG;
                                } else if (iZzk == 255) {
                                    str = MimeTypes.AUDIO_AAC;
                                } else if (iZzk != 8192) {
                                    str = iZzk != 8193 ? null : MimeTypes.AUDIO_DTS;
                                } else {
                                    str = MimeTypes.AUDIO_AC3;
                                }
                                if (str != null) {
                                    int iZzk2 = zzfpVar.zzk();
                                    int iZzi2 = zzfpVar.zzi();
                                    zzfpVar.zzL(6);
                                    int iZzk3 = zzfy.zzk(zzfpVar.zzq());
                                    int iZzk4 = zzfpVar.zzk();
                                    byte[] bArr = new byte[iZzk4];
                                    zzfpVar.zzG(bArr, 0, iZzk4);
                                    zzak zzakVar = new zzak();
                                    zzakVar.zzW(str);
                                    zzakVar.zzy(iZzk2);
                                    zzakVar.zzX(iZzi2);
                                    if (MimeTypes.AUDIO_RAW.equals(str) && iZzk3 != 0) {
                                        zzakVar.zzQ(iZzk3);
                                    }
                                    if (MimeTypes.AUDIO_AAC.equals(str) && iZzk4 > 0) {
                                        zzakVar.zzL(zzgaa.zzm(bArr));
                                    }
                                    zzaesVar = new zzaes(zzakVar.zzac());
                                } else {
                                    zzff.zzf("StreamFormatChunk", "Ignoring track with unsupported format tag " + iZzk);
                                }
                            } else {
                                zzff.zzf("StreamFormatChunk", "Ignoring strf box for unsupported track type: ".concat(zzfy.zzB(i12)));
                            }
                            break;
                        } else {
                            zzfpVar.zzL(4);
                            int iZzi3 = zzfpVar.zzi();
                            int iZzi4 = zzfpVar.zzi();
                            zzfpVar.zzL(4);
                            int iZzi5 = zzfpVar.zzi();
                            switch (iZzi5) {
                                case 808802372:
                                case 877677894:
                                case 1145656883:
                                case 1145656920:
                                case 1482049860:
                                case 1684633208:
                                case 2021026148:
                                    str2 = MimeTypes.VIDEO_MP4V;
                                    break;
                                case 826496577:
                                case 828601953:
                                case 875967048:
                                    str2 = MimeTypes.VIDEO_H264;
                                    break;
                                case 842289229:
                                    str2 = "video/mp42";
                                    break;
                                case 859066445:
                                    str2 = "video/mp43";
                                    break;
                                case 1196444237:
                                case 1735420525:
                                    str2 = "video/mjpeg";
                                    break;
                                default:
                                    str2 = null;
                                    break;
                            }
                            if (str2 == null) {
                                zzff.zzf("StreamFormatChunk", "Ignoring track with unsupported compression " + iZzi5);
                            } else {
                                zzak zzakVar2 = new zzak();
                                zzakVar2.zzab(iZzi3);
                                zzakVar2.zzI(iZzi4);
                                zzakVar2.zzW(str2);
                                zzaesVar2 = new zzaes(zzakVar2.zzac());
                            }
                        }
                        zzaesVar = zzaesVar2;
                        break;
                    case 1751742049:
                        zzaesVar = zzaeo.zzb(zzfpVar);
                        break;
                    case 1752331379:
                        zzaesVar = zzaep.zzb(zzfpVar);
                        break;
                    case 1852994675:
                        zzaesVar = zzaet.zzb(zzfpVar);
                        break;
                    default:
                        zzaesVar = zzaesVar2;
                        break;
                }
            } else {
                zzaesVar = zzc(zzfpVar.zzi(), zzfpVar);
            }
            if (zzaesVar != null) {
                if (zzaesVar.zza() == 1752331379) {
                    int i13 = ((zzaep) zzaesVar).zza;
                    if (i13 == 1935960438) {
                        i12 = 2;
                    } else if (i13 == 1935963489) {
                        i12 = 1;
                    } else if (i13 != 1937012852) {
                        zzff.zzf("AviStreamHeaderChunk", "Found unsupported streamType fourCC: ".concat(String.valueOf(Integer.toHexString(i13))));
                        i12 = -1;
                    } else {
                        i12 = 3;
                    }
                }
                zzfzxVar.zzf(zzaesVar);
            }
            zzfpVar.zzK(iZzd);
            zzfpVar.zzJ(iZze);
        }
        return new zzaer(i11, zzfzxVar.zzi());
    }

    @Override // com.google.android.gms.internal.ads.zzaej
    public final int zza() {
        return this.zzb;
    }

    @Nullable
    public final zzaej zzb(Class cls) {
        zzgaa zzgaaVar = this.zza;
        int size = zzgaaVar.size();
        int i11 = 0;
        while (i11 < size) {
            zzaej zzaejVar = (zzaej) zzgaaVar.get(i11);
            i11++;
            if (zzaejVar.getClass() == cls) {
                return zzaejVar;
            }
        }
        return null;
    }
}
