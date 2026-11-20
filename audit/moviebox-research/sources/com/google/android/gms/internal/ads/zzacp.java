package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.vungle.warren.error.VungleException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzacp implements zzadb {
    private static final int[] zza = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 16, 15, 14, 17, 18, 19, 20};
    private static final zzaco zzc = new zzaco(new zzacn() { // from class: com.google.android.gms.internal.ads.zzacl
        @Override // com.google.android.gms.internal.ads.zzacn
        public final Constructor zza() {
            if (Boolean.TRUE.equals(Class.forName("androidx.media3.decoder.flac.FlacLibrary").getMethod("isAvailable", new Class[0]).invoke(null, new Object[0]))) {
                return Class.forName("androidx.media3.decoder.flac.FlacExtractor").asSubclass(zzacu.class).getConstructor(Integer.TYPE);
            }
            return null;
        }
    });
    private static final zzaco zzd = new zzaco(new zzacn() { // from class: com.google.android.gms.internal.ads.zzacm
        @Override // com.google.android.gms.internal.ads.zzacn
        public final Constructor zza() {
            return Class.forName("androidx.media3.decoder.midi.MidiExtractor").asSubclass(zzacu.class).getConstructor(new Class[0]);
        }
    });

    @Nullable
    private zzgaa zze;
    private final zzakp zzf = new zzakk();

    private final void zzb(int i11, List list) {
        switch (i11) {
            case 0:
                list.add(new zzamn());
                break;
            case 1:
                list.add(new zzamq());
                break;
            case 2:
                list.add(new zzamt(0));
                break;
            case 3:
                list.add(new zzaei(0));
                break;
            case 4:
                zzacu zzacuVarZza = zzc.zza(0);
                if (zzacuVarZza == null) {
                    list.add(new zzafa(0));
                } else {
                    list.add(zzacuVarZza);
                }
                break;
            case 5:
                list.add(new zzafd());
                break;
            case 6:
                list.add(new zzahy(0));
                break;
            case 7:
                list.add(new zzaig(0));
                break;
            case 8:
                list.add(new zzajc(this.zzf, 32, null, null, zzgaa.zzl(), null));
                list.add(new zzajh(this.zzf, 16));
                break;
            case 9:
                list.add(new zzajw());
                break;
            case 10:
                list.add(new zzanw());
                break;
            case 11:
                if (this.zze == null) {
                    this.zze = zzgaa.zzl();
                }
                list.add(new zzaog(1, 1, this.zzf, new zzfw(0L), new zzamv(0, this.zze), 112800));
                break;
            case 12:
                list.add(new zzaos());
                break;
            case 14:
                list.add(new zzafj(0));
                break;
            case 15:
                zzacu zzacuVarZza2 = zzd.zza(new Object[0]);
                if (zzacuVarZza2 != null) {
                    list.add(zzacuVarZza2);
                }
                break;
            case 16:
                list.add(new zzaen());
                break;
            case 17:
                list.add(new zzakh());
                break;
            case 18:
                list.add(new zzaox());
                break;
            case 19:
                list.add(new zzaeu());
                break;
            case 20:
                list.add(new zzafi());
                break;
        }
    }

    /* JADX WARN: Code duplicated, block: B:108:0x01af  */
    /* JADX WARN: Code duplicated, block: B:135:0x01f4  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.google.android.gms.internal.ads.zzadb
    public final synchronized zzacu[] zza(Uri uri, Map map) {
        byte b11;
        int i11;
        int i12;
        zzacu[] zzacuVarArr;
        try {
            ArrayList arrayList = new ArrayList(20);
            List list = (List) map.get(HttpHeaders.CONTENT_TYPE);
            String str = (list == null || list.isEmpty()) ? null : (String) list.get(0);
            if (str != null) {
                String strZze = zzcb.zze(str);
                switch (strZze.hashCode()) {
                    case -2123537834:
                        if (strZze.equals(MimeTypes.AUDIO_E_AC3_JOC)) {
                            b11 = 2;
                        } else {
                            b11 = -1;
                        }
                        break;
                    case -1662384011:
                        if (strZze.equals("video/mp2p")) {
                            b11 = Ascii.DC4;
                        } else {
                            b11 = -1;
                        }
                        break;
                    case -1662384007:
                        if (strZze.equals("video/mp2t")) {
                            b11 = Ascii.NAK;
                        } else {
                            b11 = -1;
                        }
                        break;
                    case -1662095187:
                        if (strZze.equals(MimeTypes.VIDEO_WEBM)) {
                            b11 = Ascii.FF;
                        } else {
                            b11 = -1;
                        }
                        break;
                    case -1606874997:
                        if (strZze.equals(MimeTypes.AUDIO_AMR_WB)) {
                            b11 = 6;
                        } else {
                            b11 = -1;
                        }
                        break;
                    case -1487464690:
                        if (strZze.equals("image/heif")) {
                            b11 = Ascii.GS;
                        } else {
                            b11 = -1;
                        }
                        break;
                    case -1487394660:
                        if (strZze.equals("image/jpeg")) {
                            b11 = Ascii.CAN;
                        } else {
                            b11 = -1;
                        }
                        break;
                    case -1487018032:
                        if (strZze.equals("image/webp")) {
                            b11 = Ascii.ESC;
                        } else {
                            b11 = -1;
                        }
                        break;
                    case -1248337486:
                        if (strZze.equals(MimeTypes.APPLICATION_MP4)) {
                            b11 = Ascii.DC2;
                        } else {
                            b11 = -1;
                        }
                        break;
                    case -1079884372:
                        if (strZze.equals("video/x-msvideo")) {
                            b11 = Ascii.EM;
                        } else {
                            b11 = -1;
                        }
                        break;
                    case -1004728940:
                        if (strZze.equals(MimeTypes.TEXT_VTT)) {
                            b11 = Ascii.ETB;
                        } else {
                            b11 = -1;
                        }
                        break;
                    case -879272239:
                        if (strZze.equals("image/bmp")) {
                            b11 = Ascii.FS;
                        } else {
                            b11 = -1;
                        }
                        break;
                    case -879258763:
                        if (strZze.equals("image/png")) {
                            b11 = Ascii.SUB;
                        } else {
                            b11 = -1;
                        }
                        break;
                    case -387023398:
                        if (strZze.equals("audio/x-matroska")) {
                            b11 = Ascii.VT;
                        } else {
                            b11 = -1;
                        }
                        break;
                    case -43467528:
                        if (strZze.equals(MimeTypes.APPLICATION_WEBM)) {
                            b11 = Ascii.SO;
                        } else {
                            b11 = -1;
                        }
                        break;
                    case 13915911:
                        if (strZze.equals("video/x-flv")) {
                            b11 = 8;
                        } else {
                            b11 = -1;
                        }
                        break;
                    case 187078296:
                        if (strZze.equals(MimeTypes.AUDIO_AC3)) {
                            b11 = 0;
                        } else {
                            b11 = -1;
                        }
                        break;
                    case 187078297:
                        if (strZze.equals("audio/ac4")) {
                            b11 = 3;
                        } else {
                            b11 = -1;
                        }
                        break;
                    case 187078669:
                        if (strZze.equals("audio/amr")) {
                            b11 = 4;
                        } else {
                            b11 = -1;
                        }
                        break;
                    case 187090232:
                        if (strZze.equals(MimeTypes.AUDIO_MP4)) {
                            b11 = 17;
                        } else {
                            b11 = -1;
                        }
                        break;
                    case 187091926:
                        if (strZze.equals("audio/ogg")) {
                            b11 = 19;
                        } else {
                            b11 = -1;
                        }
                        break;
                    case 187099443:
                        if (strZze.equals("audio/wav")) {
                            b11 = Ascii.SYN;
                        } else {
                            b11 = -1;
                        }
                        break;
                    case 1331848029:
                        if (strZze.equals(MimeTypes.VIDEO_MP4)) {
                            b11 = Ascii.DLE;
                        } else {
                            b11 = -1;
                        }
                        break;
                    case 1503095341:
                        if (strZze.equals(MimeTypes.AUDIO_AMR_NB)) {
                            b11 = 5;
                        } else {
                            b11 = -1;
                        }
                        break;
                    case 1504578661:
                        if (strZze.equals(MimeTypes.AUDIO_E_AC3)) {
                            b11 = 1;
                        } else {
                            b11 = -1;
                        }
                        break;
                    case 1504619009:
                        if (strZze.equals(MimeTypes.AUDIO_FLAC)) {
                            b11 = 7;
                        } else {
                            b11 = -1;
                        }
                        break;
                    case 1504824762:
                        if (strZze.equals("audio/midi")) {
                            b11 = 9;
                        } else {
                            b11 = -1;
                        }
                        break;
                    case 1504831518:
                        if (strZze.equals(MimeTypes.AUDIO_MPEG)) {
                            b11 = Ascii.SI;
                        } else {
                            b11 = -1;
                        }
                        break;
                    case 1505118770:
                        if (strZze.equals(MimeTypes.AUDIO_WEBM)) {
                            b11 = Ascii.CR;
                        } else {
                            b11 = -1;
                        }
                        break;
                    case 2039520277:
                        if (strZze.equals("video/x-matroska")) {
                            b11 = 10;
                        } else {
                            b11 = -1;
                        }
                        break;
                    default:
                        b11 = -1;
                        break;
                }
                switch (b11) {
                    case 0:
                    case 1:
                    case 2:
                        i11 = 0;
                        break;
                    case 3:
                        i11 = 1;
                        break;
                    case 4:
                    case 5:
                    case 6:
                        i11 = 3;
                        break;
                    case 7:
                        i11 = 4;
                        break;
                    case 8:
                        i11 = 5;
                        break;
                    case 9:
                        i11 = 15;
                        break;
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                        i11 = 6;
                        break;
                    case 15:
                        i11 = 7;
                        break;
                    case 16:
                    case 17:
                    case 18:
                        i11 = 8;
                        break;
                    case 19:
                        i11 = 9;
                        break;
                    case 20:
                        i11 = 10;
                        break;
                    case 21:
                        i11 = 11;
                        break;
                    case 22:
                        i11 = 12;
                        break;
                    case 23:
                        i11 = 13;
                        break;
                    case 24:
                        i11 = 14;
                        break;
                    case 25:
                        i11 = 16;
                        break;
                    case 26:
                        i11 = 17;
                        break;
                    case 27:
                        i11 = 18;
                        break;
                    case 28:
                        i11 = 19;
                        break;
                    case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                        i11 = 20;
                        break;
                    default:
                        i11 = -1;
                        break;
                }
            } else {
                i11 = -1;
            }
            if (i11 != -1) {
                zzb(i11, arrayList);
            }
            String lastPathSegment = uri.getLastPathSegment();
            if (lastPathSegment == null) {
                i12 = -1;
            } else if (lastPathSegment.endsWith(".ac3") || lastPathSegment.endsWith(".ec3")) {
                i12 = 0;
            } else if (lastPathSegment.endsWith(".ac4")) {
                i12 = 1;
            } else if (lastPathSegment.endsWith(".adts") || lastPathSegment.endsWith(".aac")) {
                i12 = 2;
            } else if (lastPathSegment.endsWith(".amr")) {
                i12 = 3;
            } else if (lastPathSegment.endsWith(".flac")) {
                i12 = 4;
            } else if (lastPathSegment.endsWith(".flv")) {
                i12 = 5;
            } else if (lastPathSegment.endsWith(".mid") || lastPathSegment.endsWith(".midi") || lastPathSegment.endsWith(".smf")) {
                i12 = 15;
            } else if (lastPathSegment.startsWith(".mk", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".webm")) {
                i12 = 6;
            } else if (lastPathSegment.endsWith(".mp3")) {
                i12 = 7;
            } else if (lastPathSegment.endsWith(".mp4") || lastPathSegment.startsWith(".m4", lastPathSegment.length() - 4) || lastPathSegment.startsWith(".mp4", lastPathSegment.length() - 5) || lastPathSegment.startsWith(".cmf", lastPathSegment.length() - 5)) {
                i12 = 8;
            } else if (lastPathSegment.startsWith(".og", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".opus")) {
                i12 = 9;
            } else if (lastPathSegment.endsWith(".ps") || lastPathSegment.endsWith(".mpeg") || lastPathSegment.endsWith(".mpg") || lastPathSegment.endsWith(".m2p")) {
                i12 = 10;
            } else if (lastPathSegment.endsWith(".ts") || lastPathSegment.startsWith(".ts", lastPathSegment.length() - 4)) {
                i12 = 11;
            } else if (lastPathSegment.endsWith(".wav") || lastPathSegment.endsWith(".wave")) {
                i12 = 12;
            } else if (lastPathSegment.endsWith(".vtt") || lastPathSegment.endsWith(".webvtt")) {
                i12 = 13;
            } else if (lastPathSegment.endsWith(".jpg") || lastPathSegment.endsWith(".jpeg")) {
                i12 = 14;
            } else if (lastPathSegment.endsWith(".avi")) {
                i12 = 16;
            } else if (lastPathSegment.endsWith(".png")) {
                i12 = 17;
            } else if (lastPathSegment.endsWith(".webp")) {
                i12 = 18;
            } else if (lastPathSegment.endsWith(".bmp") || lastPathSegment.endsWith(".dib")) {
                i12 = 19;
            } else if (lastPathSegment.endsWith(".heic")) {
                i12 = 20;
            } else {
                i12 = -1;
            }
            if (i12 != -1 && i12 != i11) {
                zzb(i12, arrayList);
            }
            int[] iArr = zza;
            for (int i13 = 0; i13 < 20; i13++) {
                int i14 = iArr[i13];
                if (i14 != i11 && i14 != i12) {
                    zzb(i14, arrayList);
                }
            }
            zzacuVarArr = new zzacu[arrayList.size()];
            for (int i15 = 0; i15 < arrayList.size(); i15++) {
                zzacuVarArr[i15] = (zzacu) arrayList.get(i15);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return zzacuVarArr;
    }
}
