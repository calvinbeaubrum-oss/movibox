package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
import okio.Utf8;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzabv {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {1, 2, 3, 6};
    private static final int[] zzc = {48000, 44100, 32000};
    private static final int[] zzd = {24000, 22050, 16000};
    private static final int[] zze = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] zzf = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, PsExtractor.AUDIO_STREAM, 224, 256, 320, 384, 448, 512, 576, 640};
    private static final int[] zzg = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, TTAdConstant.DOWNLOAD_URL_AND_PACKAGE_NAME, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static int zza(ByteBuffer byteBuffer) {
        if (((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) > 10) {
            return zzb[((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? (byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4 : 3] * 256;
        }
        return 1536;
    }

    public static int zzb(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        if (((bArr[5] & 248) >> 3) <= 10) {
            byte b11 = bArr[4];
            return zzf((b11 & 192) >> 6, b11 & Utf8.REPLACEMENT_BYTE);
        }
        int i11 = bArr[2] & 7;
        int i12 = ((bArr[3] & 255) | (i11 << 8)) + 1;
        return i12 + i12;
    }

    public static zzam zzc(zzfp zzfpVar, String str, String str2, @Nullable zzae zzaeVar) {
        zzfo zzfoVar = new zzfo();
        zzfoVar.zzi(zzfpVar);
        int i11 = zzc[zzfoVar.zzd(2)];
        zzfoVar.zzm(8);
        int i12 = zze[zzfoVar.zzd(3)];
        if (zzfoVar.zzd(1) != 0) {
            i12++;
        }
        int i13 = zzf[zzfoVar.zzd(5)] * 1000;
        zzfoVar.zze();
        zzfpVar.zzK(zzfoVar.zzb());
        zzak zzakVar = new zzak();
        zzakVar.zzK(str);
        zzakVar.zzW(MimeTypes.AUDIO_AC3);
        zzakVar.zzy(i12);
        zzakVar.zzX(i11);
        zzakVar.zzE(zzaeVar);
        zzakVar.zzN(str2);
        zzakVar.zzx(i13);
        zzakVar.zzR(i13);
        return zzakVar.zzac();
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0062  */
    public static zzam zzd(zzfp zzfpVar, String str, String str2, @Nullable zzae zzaeVar) {
        String str3;
        zzfo zzfoVar = new zzfo();
        zzfoVar.zzi(zzfpVar);
        int iZzd = zzfoVar.zzd(13) * 1000;
        zzfoVar.zzm(3);
        int i11 = zzc[zzfoVar.zzd(2)];
        zzfoVar.zzm(10);
        int i12 = zze[zzfoVar.zzd(3)];
        if (zzfoVar.zzd(1) != 0) {
            i12++;
        }
        zzfoVar.zzm(3);
        int iZzd2 = zzfoVar.zzd(4);
        zzfoVar.zzm(1);
        if (iZzd2 > 0) {
            zzfoVar.zzm(6);
            if (zzfoVar.zzd(1) != 0) {
                i12 += 2;
            }
            zzfoVar.zzm(1);
        }
        if (zzfoVar.zza() > 7) {
            zzfoVar.zzm(7);
            if (zzfoVar.zzd(1) != 0) {
                str3 = MimeTypes.AUDIO_E_AC3_JOC;
            } else {
                str3 = MimeTypes.AUDIO_E_AC3;
            }
        } else {
            str3 = MimeTypes.AUDIO_E_AC3;
        }
        zzfoVar.zze();
        zzfpVar.zzK(zzfoVar.zzb());
        zzak zzakVar = new zzak();
        zzakVar.zzK(str);
        zzakVar.zzW(str3);
        zzakVar.zzy(i12);
        zzakVar.zzX(i11);
        zzakVar.zzE(zzaeVar);
        zzakVar.zzN(str2);
        zzakVar.zzR(iZzd);
        return zzakVar.zzac();
    }

    public static zzabu zze(zzfo zzfoVar) {
        String str;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i21;
        int i22;
        int iZzc = zzfoVar.zzc();
        zzfoVar.zzm(40);
        int iZzd = zzfoVar.zzd(5);
        zzfoVar.zzk(iZzc);
        int i23 = -1;
        if (iZzd > 10) {
            zzfoVar.zzm(16);
            int iZzd2 = zzfoVar.zzd(2);
            if (iZzd2 == 0) {
                i23 = 0;
            } else if (iZzd2 == 1) {
                i23 = 1;
            } else if (iZzd2 == 2) {
                i23 = 2;
            }
            zzfoVar.zzm(3);
            int iZzd3 = zzfoVar.zzd(11) + 1;
            int iZzd4 = zzfoVar.zzd(2);
            if (iZzd4 == 3) {
                i18 = zzd[zzfoVar.zzd(2)];
                i17 = 3;
                i19 = 6;
            } else {
                int iZzd5 = zzfoVar.zzd(2);
                int i24 = zzb[iZzd5];
                i17 = iZzd5;
                i18 = zzc[iZzd4];
                i19 = i24;
            }
            int i25 = iZzd3 + iZzd3;
            int i26 = (i25 * i18) / (i19 * 32);
            int iZzd6 = zzfoVar.zzd(3);
            boolean zZzo = zzfoVar.zzo();
            int i27 = zze[iZzd6] + (zZzo ? 1 : 0);
            zzfoVar.zzm(10);
            if (zzfoVar.zzo()) {
                zzfoVar.zzm(8);
            }
            if (iZzd6 == 0) {
                zzfoVar.zzm(5);
                if (zzfoVar.zzo()) {
                    zzfoVar.zzm(8);
                }
                i21 = 0;
                iZzd6 = 0;
            } else {
                i21 = iZzd6;
            }
            if (i23 == 1) {
                if (zzfoVar.zzo()) {
                    zzfoVar.zzm(16);
                }
                i22 = 1;
            } else {
                i22 = i23;
            }
            if (zzfoVar.zzo()) {
                if (i21 > 2) {
                    zzfoVar.zzm(2);
                }
                if ((i21 & 1) != 0 && i21 > 2) {
                    zzfoVar.zzm(6);
                }
                if ((i21 & 4) != 0) {
                    zzfoVar.zzm(6);
                }
                if (zZzo && zzfoVar.zzo()) {
                    zzfoVar.zzm(5);
                }
                if (i22 == 0) {
                    if (zzfoVar.zzo()) {
                        zzfoVar.zzm(6);
                    }
                    if (i21 == 0 && zzfoVar.zzo()) {
                        zzfoVar.zzm(6);
                    }
                    if (zzfoVar.zzo()) {
                        zzfoVar.zzm(6);
                    }
                    int iZzd7 = zzfoVar.zzd(2);
                    if (iZzd7 == 1) {
                        zzfoVar.zzm(5);
                    } else if (iZzd7 == 2) {
                        zzfoVar.zzm(12);
                    } else if (iZzd7 == 3) {
                        int iZzd8 = zzfoVar.zzd(5);
                        if (zzfoVar.zzo()) {
                            zzfoVar.zzm(5);
                            if (zzfoVar.zzo()) {
                                zzfoVar.zzm(4);
                            }
                            if (zzfoVar.zzo()) {
                                zzfoVar.zzm(4);
                            }
                            if (zzfoVar.zzo()) {
                                zzfoVar.zzm(4);
                            }
                            if (zzfoVar.zzo()) {
                                zzfoVar.zzm(4);
                            }
                            if (zzfoVar.zzo()) {
                                zzfoVar.zzm(4);
                            }
                            if (zzfoVar.zzo()) {
                                zzfoVar.zzm(4);
                            }
                            if (zzfoVar.zzo()) {
                                zzfoVar.zzm(4);
                            }
                            if (zzfoVar.zzo()) {
                                if (zzfoVar.zzo()) {
                                    zzfoVar.zzm(4);
                                }
                                if (zzfoVar.zzo()) {
                                    zzfoVar.zzm(4);
                                }
                            }
                        }
                        if (zzfoVar.zzo()) {
                            zzfoVar.zzm(5);
                            if (zzfoVar.zzo()) {
                                zzfoVar.zzm(7);
                                if (zzfoVar.zzo()) {
                                    zzfoVar.zzm(8);
                                }
                            }
                        }
                        zzfoVar.zzm((iZzd8 + 2) * 8);
                        zzfoVar.zze();
                    }
                    if (i21 < 2) {
                        if (zzfoVar.zzo()) {
                            zzfoVar.zzm(14);
                        }
                        if (iZzd6 == 0 && zzfoVar.zzo()) {
                            zzfoVar.zzm(14);
                        }
                    }
                    if (!zzfoVar.zzo()) {
                        i22 = 0;
                    } else if (i17 == 0) {
                        zzfoVar.zzm(5);
                        i22 = 0;
                        i17 = 0;
                    } else {
                        for (int i28 = 0; i28 < i19; i28++) {
                            if (zzfoVar.zzo()) {
                                zzfoVar.zzm(5);
                            }
                        }
                        i22 = 0;
                    }
                }
            }
            if (zzfoVar.zzo()) {
                zzfoVar.zzm(5);
                if (i21 == 2) {
                    zzfoVar.zzm(4);
                    i21 = 2;
                }
                if (i21 >= 6) {
                    zzfoVar.zzm(2);
                }
                if (zzfoVar.zzo()) {
                    zzfoVar.zzm(8);
                }
                if (i21 == 0 && zzfoVar.zzo()) {
                    zzfoVar.zzm(8);
                }
                if (iZzd4 < 3) {
                    zzfoVar.zzl();
                }
            }
            if (i22 == 0 && i17 != 3) {
                zzfoVar.zzl();
            }
            if (i22 == 2 && (i17 == 3 || zzfoVar.zzo())) {
                zzfoVar.zzm(6);
            }
            str = (zzfoVar.zzo() && zzfoVar.zzd(6) == 1 && zzfoVar.zzd(8) == 1) ? MimeTypes.AUDIO_E_AC3_JOC : MimeTypes.AUDIO_E_AC3;
            i15 = i23;
            i12 = i25;
            i13 = i18;
            i16 = i19 * 256;
            i11 = i26;
            i14 = i27;
        } else {
            zzfoVar.zzm(32);
            int iZzd9 = zzfoVar.zzd(2);
            String str2 = iZzd9 == 3 ? null : MimeTypes.AUDIO_AC3;
            int iZzd10 = zzfoVar.zzd(6);
            int i29 = zzf[iZzd10 / 2] * 1000;
            int iZzf = zzf(iZzd9, iZzd10);
            zzfoVar.zzm(8);
            int iZzd11 = zzfoVar.zzd(3);
            if ((iZzd11 & 1) != 0 && iZzd11 != 1) {
                zzfoVar.zzm(2);
            }
            if ((iZzd11 & 4) != 0) {
                zzfoVar.zzm(2);
            }
            if (iZzd11 == 2) {
                zzfoVar.zzm(2);
            }
            str = str2;
            i11 = i29;
            i12 = iZzf;
            i13 = iZzd9 < 3 ? zzc[iZzd9] : -1;
            i14 = zze[iZzd11] + (zzfoVar.zzo() ? 1 : 0);
            i15 = -1;
            i16 = 1536;
        }
        return new zzabu(str, i15, i14, i13, i12, i16, i11, null);
    }

    private static int zzf(int i11, int i12) {
        int i13;
        if (i11 < 0 || i11 >= 3 || i12 < 0 || (i13 = i12 >> 1) >= 19) {
            return -1;
        }
        int i14 = zzc[i11];
        if (i14 == 44100) {
            int i15 = zzg[i13] + (i12 & 1);
            return i15 + i15;
        }
        int i16 = zzf[i13];
        return i14 == 32000 ? i16 * 6 : i16 * 4;
    }
}
