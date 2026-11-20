package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.media.MediaCodecInfo;
import android.util.Pair;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.core.view.MotionEventCompat;
import com.applovin.exoplayer2.common.base.Ascii;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.vungle.warren.error.VungleException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@SuppressLint({"InlinedApi"})
public final class zztn {
    public static final /* synthetic */ int zza = 0;
    private static final Pattern zzb = Pattern.compile("^\\D?(\\d+)$");
    private static final HashMap zzc = new HashMap();

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:137:0x0249  */
    /* JADX WARN: Code duplicated, block: B:15:0x0064  */
    /* JADX WARN: Code duplicated, block: B:173:0x02c4 A[Catch: NumberFormatException -> 0x02d5, TRY_LEAVE, TryCatch #0 {NumberFormatException -> 0x02d5, blocks: (B:144:0x0268, B:146:0x027a, B:157:0x0296, B:173:0x02c4), top: B:478:0x0268 }] */
    /* JADX WARN: Code duplicated, block: B:245:0x0437  */
    /* JADX WARN: Code duplicated, block: B:327:0x0569  */
    /* JADX WARN: Code duplicated, block: B:49:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:66:0x0121  */
    /* JADX WARN: Failed to clean up code after switch over string restore
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r1v116 int, still in use, count: 1, list:
  (r1v116 int) from 0x012b: SWITCH (r1v116 int)
 case 1567: goto B:80:0x015d
 case 1568: goto B:77:0x014d
 case 1569: goto B:74:0x013d
 case 1570: goto B:71:0x012f
 default: goto B:66:0x0121 A[RegionRef:SW:69]
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
    	at jadx.core.utils.InsnRemover.remove(InsnRemover.java:226)
    	at jadx.core.utils.InsnRemover.remove(InsnRemover.java:215)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.replaceWithMergedSwitch(SwitchOverStringVisitor.java:355)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:111)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:72)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:140)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:47)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:66)
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Nullable
    public static Pair zza(zzam zzamVar) {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        char c11;
        int i17;
        byte b11;
        Integer numValueOf;
        int i18;
        int i19;
        int i21;
        int i22;
        int i23;
        Integer num;
        Integer num2;
        String str = zzamVar.zzj;
        if (str != null) {
            String[] strArrSplit = str.split("\\.");
            int i24 = 2;
            int i25 = 1;
            if (!"video/dolby-vision".equals(zzamVar.zzm)) {
                switch (strArrSplit[0]) {
                    case "avc1":
                    case "avc2":
                        String str2 = zzamVar.zzj;
                        int length = strArrSplit.length;
                        if (length < 2) {
                            zzff.zzf("MediaCodecUtil", "Ignoring malformed AVC codec string: ".concat(String.valueOf(str2)));
                            break;
                        } else {
                            try {
                                if (strArrSplit[1].length() == 6) {
                                    i11 = Integer.parseInt(strArrSplit[1].substring(0, 2), 16);
                                    i12 = Integer.parseInt(strArrSplit[1].substring(4), 16);
                                } else if (length < 3) {
                                    zzff.zzf("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str2);
                                } else {
                                    i11 = Integer.parseInt(strArrSplit[1]);
                                    i12 = Integer.parseInt(strArrSplit[2]);
                                }
                                if (i11 == 66) {
                                    i13 = -1;
                                    i24 = 1;
                                } else if (i11 == 77) {
                                    i13 = -1;
                                } else if (i11 == 88) {
                                    i13 = -1;
                                    i24 = 4;
                                } else if (i11 == 100) {
                                    i13 = -1;
                                    i24 = 8;
                                } else if (i11 == 110) {
                                    i13 = -1;
                                    i24 = 16;
                                } else if (i11 == 122) {
                                    i13 = -1;
                                    i24 = 32;
                                } else if (i11 != 244) {
                                    i13 = -1;
                                    i24 = -1;
                                } else {
                                    i13 = -1;
                                    i24 = 64;
                                }
                                if (i24 == i13) {
                                    zzff.zzf("MediaCodecUtil", "Unknown AVC profile: " + i11);
                                } else {
                                    switch (i12) {
                                        case 10:
                                            i14 = 1;
                                            break;
                                        case 11:
                                            i14 = 4;
                                            break;
                                        case 12:
                                            i14 = 8;
                                            break;
                                        case 13:
                                            i14 = 16;
                                            break;
                                        default:
                                            switch (i12) {
                                                case 20:
                                                    i14 = 32;
                                                    break;
                                                case 21:
                                                    i14 = 64;
                                                    break;
                                                case 22:
                                                    i14 = 128;
                                                    break;
                                                default:
                                                    switch (i12) {
                                                        case 30:
                                                            i14 = 256;
                                                            break;
                                                        case VungleException.WEB_CRASH /* 31 */:
                                                            i14 = 512;
                                                            break;
                                                        case 32:
                                                            i14 = 1024;
                                                            break;
                                                        default:
                                                            switch (i12) {
                                                                case 40:
                                                                    i14 = 2048;
                                                                    break;
                                                                case 41:
                                                                    i14 = 4096;
                                                                    break;
                                                                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                                                                    i14 = 8192;
                                                                    break;
                                                                default:
                                                                    switch (i12) {
                                                                        case 50:
                                                                            i14 = 16384;
                                                                            break;
                                                                        case 51:
                                                                            i14 = 32768;
                                                                            break;
                                                                        case 52:
                                                                            i14 = 65536;
                                                                            break;
                                                                        default:
                                                                            i14 = -1;
                                                                            break;
                                                                    }
                                                                    break;
                                                            }
                                                            break;
                                                    }
                                                    break;
                                            }
                                            break;
                                    }
                                    if (i14 != -1) {
                                        return new Pair(Integer.valueOf(i24), Integer.valueOf(i14));
                                    }
                                    zzff.zzf("MediaCodecUtil", "Unknown AVC level: " + i12);
                                }
                            } catch (NumberFormatException unused) {
                                zzff.zzf("MediaCodecUtil", "Ignoring malformed AVC codec string: ".concat(String.valueOf(str2)));
                            }
                            break;
                        }
                        break;
                    case "vp09":
                        String str3 = zzamVar.zzj;
                        if (strArrSplit.length < 3) {
                            zzff.zzf("MediaCodecUtil", "Ignoring malformed VP9 codec string: ".concat(String.valueOf(str3)));
                            break;
                        } else {
                            try {
                                int i26 = Integer.parseInt(strArrSplit[1]);
                                int i27 = Integer.parseInt(strArrSplit[2]);
                                if (i26 == 0) {
                                    i15 = 1;
                                } else if (i26 == 1) {
                                    i15 = 2;
                                } else if (i26 != 2) {
                                    i15 = i26 != 3 ? -1 : 8;
                                } else {
                                    i15 = 4;
                                }
                                if (i15 == -1) {
                                    zzff.zzf("MediaCodecUtil", "Unknown VP9 profile: " + i26);
                                } else {
                                    if (i27 == 10) {
                                        i16 = -1;
                                    } else if (i27 == 11) {
                                        i16 = -1;
                                        i25 = 2;
                                    } else if (i27 == 20) {
                                        i16 = -1;
                                        i25 = 4;
                                    } else if (i27 == 21) {
                                        i16 = -1;
                                        i25 = 8;
                                    } else if (i27 == 30) {
                                        i16 = -1;
                                        i25 = 16;
                                    } else if (i27 == 31) {
                                        i16 = -1;
                                        i25 = 32;
                                    } else if (i27 == 40) {
                                        i16 = -1;
                                        i25 = 64;
                                    } else if (i27 == 41) {
                                        i16 = -1;
                                        i25 = 128;
                                    } else if (i27 == 50) {
                                        i16 = -1;
                                        i25 = 256;
                                    } else if (i27 != 51) {
                                        switch (i27) {
                                            case 60:
                                                i16 = -1;
                                                i25 = 2048;
                                                break;
                                            case 61:
                                                i16 = -1;
                                                i25 = 4096;
                                                break;
                                            case 62:
                                                i16 = -1;
                                                i25 = 8192;
                                                break;
                                            default:
                                                i16 = -1;
                                                i25 = -1;
                                                break;
                                        }
                                    } else {
                                        i16 = -1;
                                        i25 = 512;
                                    }
                                    if (i25 != i16) {
                                        return new Pair(Integer.valueOf(i15), Integer.valueOf(i25));
                                    }
                                    zzff.zzf("MediaCodecUtil", "Unknown VP9 level: " + i27);
                                }
                            } catch (NumberFormatException unused2) {
                                zzff.zzf("MediaCodecUtil", "Ignoring malformed VP9 codec string: ".concat(String.valueOf(str3)));
                            }
                            break;
                        }
                        break;
                    case "hev1":
                    case "hvc1":
                        String str4 = zzamVar.zzj;
                        zzt zztVar = zzamVar.zzy;
                        if (strArrSplit.length >= 4) {
                            Matcher matcher = zzb.matcher(strArrSplit[1]);
                            if (!matcher.matches()) {
                                zzff.zzf("MediaCodecUtil", "Ignoring malformed HEVC codec string: ".concat(String.valueOf(str4)));
                            } else {
                                String strGroup = matcher.group(1);
                                if ("1".equals(strGroup)) {
                                    c11 = 3;
                                    i17 = 1;
                                } else if (!"2".equals(strGroup)) {
                                    zzff.zzf("MediaCodecUtil", "Unknown HEVC profile string: ".concat(String.valueOf(strGroup)));
                                    break;
                                } else if (zztVar == null || zztVar.zzf != 6) {
                                    c11 = 3;
                                    i17 = 2;
                                } else {
                                    c11 = 3;
                                    i17 = 4096;
                                }
                                String str5 = strArrSplit[c11];
                                if (str5 != null) {
                                    switch (str5.hashCode()) {
                                        case 70821:
                                            if (!str5.equals("H30")) {
                                                b11 = -1;
                                            } else {
                                                b11 = Ascii.CR;
                                            }
                                            break;
                                        case 70914:
                                            if (!str5.equals("H60")) {
                                                b11 = -1;
                                            } else {
                                                b11 = Ascii.SO;
                                            }
                                            break;
                                        case 70917:
                                            if (!str5.equals("H63")) {
                                                b11 = -1;
                                            } else {
                                                b11 = Ascii.SI;
                                            }
                                            break;
                                        case 71007:
                                            if (!str5.equals("H90")) {
                                                b11 = -1;
                                            } else {
                                                b11 = Ascii.DLE;
                                            }
                                            break;
                                        case 71010:
                                            if (!str5.equals("H93")) {
                                                b11 = -1;
                                            } else {
                                                b11 = 17;
                                            }
                                            break;
                                        case 74665:
                                            if (!str5.equals("L30")) {
                                                b11 = -1;
                                            } else {
                                                b11 = 0;
                                            }
                                            break;
                                        case 74758:
                                            if (!str5.equals("L60")) {
                                                b11 = -1;
                                            } else {
                                                b11 = 1;
                                            }
                                            break;
                                        case 74761:
                                            if (!str5.equals("L63")) {
                                                b11 = -1;
                                            } else {
                                                b11 = 2;
                                            }
                                            break;
                                        case 74851:
                                            if (!str5.equals("L90")) {
                                                b11 = -1;
                                            } else {
                                                b11 = 3;
                                            }
                                            break;
                                        case 74854:
                                            if (!str5.equals("L93")) {
                                                b11 = -1;
                                            } else {
                                                b11 = 4;
                                            }
                                            break;
                                        case 2193639:
                                            if (!str5.equals("H120")) {
                                                b11 = -1;
                                            } else {
                                                b11 = Ascii.DC2;
                                            }
                                            break;
                                        case 2193642:
                                            if (!str5.equals("H123")) {
                                                b11 = -1;
                                            } else {
                                                b11 = 19;
                                            }
                                            break;
                                        case 2193732:
                                            if (!str5.equals("H150")) {
                                                b11 = -1;
                                            } else {
                                                b11 = Ascii.DC4;
                                            }
                                            break;
                                        case 2193735:
                                            if (!str5.equals("H153")) {
                                                b11 = -1;
                                            } else {
                                                b11 = Ascii.NAK;
                                            }
                                            break;
                                        case 2193738:
                                            if (!str5.equals("H156")) {
                                                b11 = -1;
                                            } else {
                                                b11 = Ascii.SYN;
                                            }
                                            break;
                                        case 2193825:
                                            if (!str5.equals("H180")) {
                                                b11 = -1;
                                            } else {
                                                b11 = Ascii.ETB;
                                            }
                                            break;
                                        case 2193828:
                                            if (!str5.equals("H183")) {
                                                b11 = -1;
                                            } else {
                                                b11 = Ascii.CAN;
                                            }
                                            break;
                                        case 2193831:
                                            if (!str5.equals("H186")) {
                                                b11 = -1;
                                            } else {
                                                b11 = Ascii.EM;
                                            }
                                            break;
                                        case 2312803:
                                            if (!str5.equals("L120")) {
                                                b11 = -1;
                                            } else {
                                                b11 = 5;
                                            }
                                            break;
                                        case 2312806:
                                            if (!str5.equals("L123")) {
                                                b11 = -1;
                                            } else {
                                                b11 = 6;
                                            }
                                            break;
                                        case 2312896:
                                            if (!str5.equals("L150")) {
                                                b11 = -1;
                                            } else {
                                                b11 = 7;
                                            }
                                            break;
                                        case 2312899:
                                            if (!str5.equals("L153")) {
                                                b11 = -1;
                                            } else {
                                                b11 = 8;
                                            }
                                            break;
                                        case 2312902:
                                            if (!str5.equals("L156")) {
                                                b11 = -1;
                                            } else {
                                                b11 = 9;
                                            }
                                            break;
                                        case 2312989:
                                            if (!str5.equals("L180")) {
                                                b11 = -1;
                                            } else {
                                                b11 = 10;
                                            }
                                            break;
                                        case 2312992:
                                            if (!str5.equals("L183")) {
                                                b11 = -1;
                                            } else {
                                                b11 = Ascii.VT;
                                            }
                                            break;
                                        case 2312995:
                                            if (!str5.equals("L186")) {
                                                b11 = -1;
                                            } else {
                                                b11 = Ascii.FF;
                                            }
                                            break;
                                        default:
                                            b11 = -1;
                                            break;
                                    }
                                    switch (b11) {
                                        case 0:
                                            numValueOf = 1;
                                            break;
                                        case 1:
                                            numValueOf = 4;
                                            break;
                                        case 2:
                                            numValueOf = 16;
                                            break;
                                        case 3:
                                            numValueOf = 64;
                                            break;
                                        case 4:
                                            numValueOf = 256;
                                            break;
                                        case 5:
                                            numValueOf = 1024;
                                            break;
                                        case 6:
                                            numValueOf = 4096;
                                            break;
                                        case 7:
                                            numValueOf = 16384;
                                            break;
                                        case 8:
                                            numValueOf = 65536;
                                            break;
                                        case 9:
                                            numValueOf = 262144;
                                            break;
                                        case 10:
                                            numValueOf = 1048576;
                                            break;
                                        case 11:
                                            numValueOf = 4194304;
                                            break;
                                        case 12:
                                            numValueOf = 16777216;
                                            break;
                                        case 13:
                                            numValueOf = 2;
                                            break;
                                        case 14:
                                            numValueOf = 8;
                                            break;
                                        case 15:
                                            numValueOf = 32;
                                            break;
                                        case 16:
                                            numValueOf = 128;
                                            break;
                                        case 17:
                                            numValueOf = 512;
                                            break;
                                        case 18:
                                            numValueOf = 2048;
                                            break;
                                        case 19:
                                            numValueOf = 8192;
                                            break;
                                        case 20:
                                            numValueOf = 32768;
                                            break;
                                        case 21:
                                            numValueOf = 131072;
                                            break;
                                        case 22:
                                            numValueOf = 524288;
                                            break;
                                        case 23:
                                            numValueOf = 2097152;
                                            break;
                                        case 24:
                                            numValueOf = 8388608;
                                            break;
                                        case 25:
                                            numValueOf = Integer.valueOf(ASTNode.PCTX_STORED);
                                            break;
                                        default:
                                            numValueOf = null;
                                            break;
                                    }
                                } else {
                                    numValueOf = null;
                                }
                                if (numValueOf != null) {
                                    return new Pair(Integer.valueOf(i17), numValueOf);
                                }
                                zzff.zzf("MediaCodecUtil", "Unknown HEVC level string: ".concat(String.valueOf(str5)));
                            }
                            break;
                        } else {
                            zzff.zzf("MediaCodecUtil", "Ignoring malformed HEVC codec string: ".concat(String.valueOf(str4)));
                            break;
                        }
                        break;
                    case "av01":
                        String str6 = zzamVar.zzj;
                        zzt zztVar2 = zzamVar.zzy;
                        if (strArrSplit.length < 4) {
                            zzff.zzf("MediaCodecUtil", "Ignoring malformed AV1 codec string: ".concat(String.valueOf(str6)));
                            break;
                        } else {
                            try {
                                int i28 = Integer.parseInt(strArrSplit[1]);
                                int i29 = Integer.parseInt(strArrSplit[2].substring(0, 2));
                                int i31 = Integer.parseInt(strArrSplit[3]);
                                if (i28 != 0) {
                                    zzff.zzf("MediaCodecUtil", "Unknown AV1 profile: " + i28);
                                } else {
                                    if (i31 == 8) {
                                        i18 = 1;
                                    } else if (i31 != 10) {
                                        zzff.zzf("MediaCodecUtil", "Unknown AV1 bit depth: " + i31);
                                    } else {
                                        i18 = (zztVar2 == null || !(zztVar2.zzg != null || (i21 = zztVar2.zzf) == 7 || i21 == 6)) ? 2 : 4096;
                                    }
                                    switch (i29) {
                                        case 0:
                                            i19 = 1;
                                            break;
                                        case 1:
                                            i19 = 2;
                                            break;
                                        case 2:
                                            i19 = 4;
                                            break;
                                        case 3:
                                            i19 = 8;
                                            break;
                                        case 4:
                                            i19 = 16;
                                            break;
                                        case 5:
                                            i19 = 32;
                                            break;
                                        case 6:
                                            i19 = 64;
                                            break;
                                        case 7:
                                            i19 = 128;
                                            break;
                                        case 8:
                                            i19 = 256;
                                            break;
                                        case 9:
                                            i19 = 512;
                                            break;
                                        case 10:
                                            i19 = 1024;
                                            break;
                                        case 11:
                                            i19 = 2048;
                                            break;
                                        case 12:
                                            i19 = 4096;
                                            break;
                                        case 13:
                                            i19 = 8192;
                                            break;
                                        case 14:
                                            i19 = 16384;
                                            break;
                                        case 15:
                                            i19 = 32768;
                                            break;
                                        case 16:
                                            i19 = 65536;
                                            break;
                                        case 17:
                                            i19 = 131072;
                                            break;
                                        case 18:
                                            i19 = 262144;
                                            break;
                                        case 19:
                                            i19 = 524288;
                                            break;
                                        case 20:
                                            i19 = 1048576;
                                            break;
                                        case 21:
                                            i19 = 2097152;
                                            break;
                                        case 22:
                                            i19 = 4194304;
                                            break;
                                        case 23:
                                            i19 = 8388608;
                                            break;
                                        default:
                                            i19 = -1;
                                            break;
                                    }
                                    if (i19 != -1) {
                                        return new Pair(Integer.valueOf(i18), Integer.valueOf(i19));
                                    }
                                    zzff.zzf("MediaCodecUtil", "Unknown AV1 level: " + i29);
                                }
                            } catch (NumberFormatException unused3) {
                                zzff.zzf("MediaCodecUtil", "Ignoring malformed AV1 codec string: ".concat(String.valueOf(str6)));
                            }
                            break;
                        }
                        break;
                    case "mp4a":
                        String str7 = zzamVar.zzj;
                        if (strArrSplit.length != 3) {
                            zzff.zzf("MediaCodecUtil", "Ignoring malformed MP4A codec string: ".concat(String.valueOf(str7)));
                            break;
                        } else {
                            try {
                                if (MimeTypes.AUDIO_AAC.equals(zzcb.zzd(Integer.parseInt(strArrSplit[1], 16)))) {
                                    int i32 = Integer.parseInt(strArrSplit[2]);
                                    if (i32 != 17) {
                                        if (i32 == 20) {
                                            i23 = -1;
                                            i22 = 20;
                                        } else if (i32 == 23) {
                                            i22 = 23;
                                        } else if (i32 == 29) {
                                            i22 = 29;
                                        } else if (i32 == 39) {
                                            i22 = 39;
                                        } else if (i32 != 42) {
                                            switch (i32) {
                                                case 1:
                                                    i23 = -1;
                                                    i22 = 1;
                                                    break;
                                                case 2:
                                                    i23 = -1;
                                                    i22 = 2;
                                                    break;
                                                case 3:
                                                    i23 = -1;
                                                    i22 = 3;
                                                    break;
                                                case 4:
                                                    i23 = -1;
                                                    i22 = 4;
                                                    break;
                                                case 5:
                                                    i23 = -1;
                                                    i22 = 5;
                                                    break;
                                                case 6:
                                                    i23 = -1;
                                                    i22 = 6;
                                                    break;
                                                default:
                                                    i23 = -1;
                                                    i22 = -1;
                                                    break;
                                            }
                                        } else {
                                            i22 = 42;
                                        }
                                        if (i22 != i23) {
                                            return new Pair(Integer.valueOf(i22), 0);
                                        }
                                    } else {
                                        i22 = 17;
                                    }
                                    i23 = -1;
                                    if (i22 != i23) {
                                        return new Pair(Integer.valueOf(i22), 0);
                                    }
                                }
                            } catch (NumberFormatException unused4) {
                                zzff.zzf("MediaCodecUtil", "Ignoring malformed MP4A codec string: ".concat(String.valueOf(str7)));
                            }
                            break;
                        }
                        break;
                }
            } else {
                String str8 = zzamVar.zzj;
                if (strArrSplit.length < 3) {
                    zzff.zzf("MediaCodecUtil", "Ignoring malformed Dolby Vision codec string: ".concat(String.valueOf(str8)));
                } else {
                    Matcher matcher2 = zzb.matcher(strArrSplit[1]);
                    if (matcher2.matches()) {
                        String strGroup2 = matcher2.group(1);
                        if (strGroup2 != null) {
                            switch (strGroup2) {
                                case "00":
                                    num = 1;
                                    break;
                                case "01":
                                    num = 2;
                                    break;
                                case "02":
                                    num = 4;
                                    break;
                                case "03":
                                    num = 8;
                                    break;
                                case "04":
                                    num = 16;
                                    break;
                                case "05":
                                    num = 32;
                                    break;
                                case "06":
                                    num = 64;
                                    break;
                                case "07":
                                    num = 128;
                                    break;
                                case "08":
                                    num = 256;
                                    break;
                                case "09":
                                    num = 512;
                                    break;
                                default:
                                    num = null;
                                    break;
                            }
                        } else {
                            num = null;
                        }
                        if (num == null) {
                            zzff.zzf("MediaCodecUtil", "Unknown Dolby Vision profile string: ".concat(String.valueOf(strGroup2)));
                        } else {
                            String str9 = strArrSplit[2];
                            if (str9 != null) {
                                switch (str9) {
                                    case "01":
                                        num2 = 1;
                                        break;
                                    case "02":
                                        num2 = 2;
                                        break;
                                    case "03":
                                        num2 = 4;
                                        break;
                                    case "04":
                                        num2 = 8;
                                        break;
                                    case "05":
                                        num2 = 16;
                                        break;
                                    case "06":
                                        num2 = 32;
                                        break;
                                    case "07":
                                        num2 = 64;
                                        break;
                                    case "08":
                                        num2 = 128;
                                        break;
                                    case "09":
                                        num2 = 256;
                                        break;
                                    default:
                                        switch (str9) {
                                            case 1567:
                                                if (!str9.equals(PrepareException.ERROR_MINI_APPID)) {
                                                    num2 = null;
                                                } else {
                                                    num2 = 512;
                                                }
                                                break;
                                            case 1568:
                                                if (!str9.equals(PrepareException.ERROR_DOWNLOAD_PACKAGE_URL_EMPTY)) {
                                                    num2 = null;
                                                } else {
                                                    num2 = 1024;
                                                }
                                                break;
                                            case 1569:
                                                if (!str9.equals(PrepareException.ERROR_LOCAL_DATA_FILE_SCAN)) {
                                                    num2 = null;
                                                } else {
                                                    num2 = 2048;
                                                }
                                                break;
                                            case 1570:
                                                if (!str9.equals(PrepareException.ERROR_WARMUP_DOWNLOAD_EXCEPTION)) {
                                                    num2 = null;
                                                } else {
                                                    num2 = 4096;
                                                }
                                                break;
                                            default:
                                                num2 = null;
                                                break;
                                        }
                                }
                            } else {
                                num2 = null;
                            }
                            if (num2 != null) {
                                return new Pair(num, num2);
                            }
                            zzff.zzf("MediaCodecUtil", "Unknown Dolby Vision level string: ".concat(String.valueOf(str9)));
                        }
                    } else {
                        zzff.zzf("MediaCodecUtil", "Ignoring malformed Dolby Vision codec string: ".concat(String.valueOf(str8)));
                    }
                }
            }
        }
        return null;
    }

    @Nullable
    public static zzsv zzb() throws zzth {
        List listZze = zze(MimeTypes.AUDIO_RAW, false, false);
        if (listZze.isEmpty()) {
            return null;
        }
        return (zzsv) listZze.get(0);
    }

    @Nullable
    public static String zzc(zzam zzamVar) {
        Pair pairZza;
        if (MimeTypes.AUDIO_E_AC3_JOC.equals(zzamVar.zzm)) {
            return MimeTypes.AUDIO_E_AC3;
        }
        if (!"video/dolby-vision".equals(zzamVar.zzm) || (pairZza = zza(zzamVar)) == null) {
            return null;
        }
        int iIntValue = ((Integer) pairZza.first).intValue();
        if (iIntValue == 16 || iIntValue == 256) {
            return MimeTypes.VIDEO_H265;
        }
        if (iIntValue == 512) {
            return MimeTypes.VIDEO_H264;
        }
        return null;
    }

    public static List zzd(zztb zztbVar, zzam zzamVar, boolean z11, boolean z12) throws zzth {
        String strZzc = zzc(zzamVar);
        return strZzc == null ? zzgaa.zzl() : zze(strZzc, z11, z12);
    }

    public static synchronized List zze(String str, boolean z11, boolean z12) throws zzth {
        try {
            zztf zztfVar = new zztf(str, z11, z12);
            HashMap map = zzc;
            List list = (List) map.get(zztfVar);
            if (list != null) {
                return list;
            }
            int i11 = zzfy.zza;
            ArrayList arrayListZzh = zzh(zztfVar, new zztl(z11, z12));
            if (z11 && arrayListZzh.isEmpty() && zzfy.zza <= 23) {
                arrayListZzh = zzh(zztfVar, new zztk(null));
                if (!arrayListZzh.isEmpty()) {
                    zzff.zzf("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + ((zzsv) arrayListZzh.get(0)).zza);
                }
            }
            if (MimeTypes.AUDIO_RAW.equals(str)) {
                if (zzfy.zza < 26 && zzfy.zzb.equals("R9") && arrayListZzh.size() == 1 && ((zzsv) arrayListZzh.get(0)).zza.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                    arrayListZzh.add(zzsv.zzc("OMX.google.raw.decoder", MimeTypes.AUDIO_RAW, MimeTypes.AUDIO_RAW, null, false, true, false, false, false));
                }
                zzi(arrayListZzh, new zztm() { // from class: com.google.android.gms.internal.ads.zztd
                    @Override // com.google.android.gms.internal.ads.zztm
                    public final int zza(Object obj) {
                        int i12 = zztn.zza;
                        String str2 = ((zzsv) obj).zza;
                        if (str2.startsWith("OMX.google") || str2.startsWith("c2.android")) {
                            return 1;
                        }
                        return (zzfy.zza >= 26 || !str2.equals("OMX.MTK.AUDIO.DECODER.RAW")) ? 0 : -1;
                    }
                });
            }
            if (zzfy.zza < 32 && arrayListZzh.size() > 1 && "OMX.qti.audio.decoder.flac".equals(((zzsv) arrayListZzh.get(0)).zza)) {
                arrayListZzh.add((zzsv) arrayListZzh.remove(0));
            }
            zzgaa zzgaaVarZzj = zzgaa.zzj(arrayListZzh);
            map.put(zztfVar, zzgaaVarZzj);
            return zzgaaVarZzj;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public static List zzf(zztb zztbVar, zzam zzamVar, boolean z11, boolean z12) throws zzth {
        List listZze = zze(zzamVar.zzm, z11, z12);
        List listZzd = zzd(zztbVar, zzamVar, z11, z12);
        zzfzx zzfzxVar = new zzfzx();
        zzfzxVar.zzh(listZze);
        zzfzxVar.zzh(listZzd);
        return zzfzxVar.zzi();
    }

    @CheckResult
    public static List zzg(List list, final zzam zzamVar) {
        ArrayList arrayList = new ArrayList(list);
        zzi(arrayList, new zztm() { // from class: com.google.android.gms.internal.ads.zzte
            @Override // com.google.android.gms.internal.ads.zztm
            public final int zza(Object obj) {
                int i11 = zztn.zza;
                return ((zzsv) obj).zzd(zzamVar) ? 1 : 0;
            }
        });
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x017a  */
    /* JADX WARN: Code duplicated, block: B:102:0x017c  */
    /* JADX WARN: Code duplicated, block: B:105:0x0185 A[Catch: Exception -> 0x016b, TryCatch #0 {Exception -> 0x016b, blocks: (B:82:0x0135, B:88:0x014c, B:94:0x0160, B:96:0x0166, B:103:0x017d, B:105:0x0185, B:115:0x01af, B:106:0x018a, B:108:0x019a, B:110:0x01a2, B:99:0x0174), top: B:151:0x0135 }] */
    /* JADX WARN: Code duplicated, block: B:106:0x018a A[Catch: Exception -> 0x016b, TryCatch #0 {Exception -> 0x016b, blocks: (B:82:0x0135, B:88:0x014c, B:94:0x0160, B:96:0x0166, B:103:0x017d, B:105:0x0185, B:115:0x01af, B:106:0x018a, B:108:0x019a, B:110:0x01a2, B:99:0x0174), top: B:151:0x0135 }] */
    /* JADX WARN: Code duplicated, block: B:108:0x019a A[Catch: Exception -> 0x016b, TryCatch #0 {Exception -> 0x016b, blocks: (B:82:0x0135, B:88:0x014c, B:94:0x0160, B:96:0x0166, B:103:0x017d, B:105:0x0185, B:115:0x01af, B:106:0x018a, B:108:0x019a, B:110:0x01a2, B:99:0x0174), top: B:151:0x0135 }] */
    /* JADX WARN: Code duplicated, block: B:113:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:115:0x01af A[Catch: Exception -> 0x016b, TRY_LEAVE, TryCatch #0 {Exception -> 0x016b, blocks: (B:82:0x0135, B:88:0x014c, B:94:0x0160, B:96:0x0166, B:103:0x017d, B:105:0x0185, B:115:0x01af, B:106:0x018a, B:108:0x019a, B:110:0x01a2, B:99:0x0174), top: B:151:0x0135 }] */
    /* JADX WARN: Code duplicated, block: B:117:0x01b3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:120:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:128:0x01ec A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:142:0x021e A[Catch: Exception -> 0x0033, TRY_ENTER, TryCatch #3 {Exception -> 0x0033, blocks: (B:3:0x0008, B:5:0x001c, B:7:0x0026, B:12:0x0036, B:16:0x0044, B:20:0x004e, B:22:0x0056, B:24:0x005e, B:26:0x0068, B:28:0x0072, B:30:0x007a, B:32:0x0082, B:34:0x008a, B:36:0x0092, B:38:0x009a, B:40:0x00a2, B:44:0x00ae, B:46:0x00b6, B:48:0x00be, B:50:0x00c6, B:139:0x0216, B:142:0x021e, B:144:0x0224, B:145:0x023e, B:146:0x025f, B:53:0x00cf, B:54:0x00d2, B:56:0x00da, B:59:0x00e5, B:61:0x00ed, B:66:0x00fb, B:68:0x0103, B:71:0x010e, B:73:0x0116, B:76:0x0121, B:78:0x0129), top: B:157:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:151:0x0135 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:161:0x01b5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:165:0x023e A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:169:0x0260 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:172:0x00d2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:173:0x00ce A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:42:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:48:0x00be A[Catch: Exception -> 0x0033, TryCatch #3 {Exception -> 0x0033, blocks: (B:3:0x0008, B:5:0x001c, B:7:0x0026, B:12:0x0036, B:16:0x0044, B:20:0x004e, B:22:0x0056, B:24:0x005e, B:26:0x0068, B:28:0x0072, B:30:0x007a, B:32:0x0082, B:34:0x008a, B:36:0x0092, B:38:0x009a, B:40:0x00a2, B:44:0x00ae, B:46:0x00b6, B:48:0x00be, B:50:0x00c6, B:139:0x0216, B:142:0x021e, B:144:0x0224, B:145:0x023e, B:146:0x025f, B:53:0x00cf, B:54:0x00d2, B:56:0x00da, B:59:0x00e5, B:61:0x00ed, B:66:0x00fb, B:68:0x0103, B:71:0x010e, B:73:0x0116, B:76:0x0121, B:78:0x0129), top: B:157:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x00c6 A[Catch: Exception -> 0x0033, TryCatch #3 {Exception -> 0x0033, blocks: (B:3:0x0008, B:5:0x001c, B:7:0x0026, B:12:0x0036, B:16:0x0044, B:20:0x004e, B:22:0x0056, B:24:0x005e, B:26:0x0068, B:28:0x0072, B:30:0x007a, B:32:0x0082, B:34:0x008a, B:36:0x0092, B:38:0x009a, B:40:0x00a2, B:44:0x00ae, B:46:0x00b6, B:48:0x00be, B:50:0x00c6, B:139:0x0216, B:142:0x021e, B:144:0x0224, B:145:0x023e, B:146:0x025f, B:53:0x00cf, B:54:0x00d2, B:56:0x00da, B:59:0x00e5, B:61:0x00ed, B:66:0x00fb, B:68:0x0103, B:71:0x010e, B:73:0x0116, B:76:0x0121, B:78:0x0129), top: B:157:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x00cf A[Catch: Exception -> 0x0033, LOOP:1: B:49:0x00c4->B:53:0x00cf, LOOP_END, TryCatch #3 {Exception -> 0x0033, blocks: (B:3:0x0008, B:5:0x001c, B:7:0x0026, B:12:0x0036, B:16:0x0044, B:20:0x004e, B:22:0x0056, B:24:0x005e, B:26:0x0068, B:28:0x0072, B:30:0x007a, B:32:0x0082, B:34:0x008a, B:36:0x0092, B:38:0x009a, B:40:0x00a2, B:44:0x00ae, B:46:0x00b6, B:48:0x00be, B:50:0x00c6, B:139:0x0216, B:142:0x021e, B:144:0x0224, B:145:0x023e, B:146:0x025f, B:53:0x00cf, B:54:0x00d2, B:56:0x00da, B:59:0x00e5, B:61:0x00ed, B:66:0x00fb, B:68:0x0103, B:71:0x010e, B:73:0x0116, B:76:0x0121, B:78:0x0129), top: B:157:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x00da A[Catch: Exception -> 0x0033, TryCatch #3 {Exception -> 0x0033, blocks: (B:3:0x0008, B:5:0x001c, B:7:0x0026, B:12:0x0036, B:16:0x0044, B:20:0x004e, B:22:0x0056, B:24:0x005e, B:26:0x0068, B:28:0x0072, B:30:0x007a, B:32:0x0082, B:34:0x008a, B:36:0x0092, B:38:0x009a, B:40:0x00a2, B:44:0x00ae, B:46:0x00b6, B:48:0x00be, B:50:0x00c6, B:139:0x0216, B:142:0x021e, B:144:0x0224, B:145:0x023e, B:146:0x025f, B:53:0x00cf, B:54:0x00d2, B:56:0x00da, B:59:0x00e5, B:61:0x00ed, B:66:0x00fb, B:68:0x0103, B:71:0x010e, B:73:0x0116, B:76:0x0121, B:78:0x0129), top: B:157:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x00e2 A[EDGE_INSN: B:58:0x00e2->B:81:0x0133 BREAK  A[LOOP:1: B:49:0x00c4->B:53:0x00cf]] */
    /* JADX WARN: Code duplicated, block: B:59:0x00e5 A[Catch: Exception -> 0x0033, TryCatch #3 {Exception -> 0x0033, blocks: (B:3:0x0008, B:5:0x001c, B:7:0x0026, B:12:0x0036, B:16:0x0044, B:20:0x004e, B:22:0x0056, B:24:0x005e, B:26:0x0068, B:28:0x0072, B:30:0x007a, B:32:0x0082, B:34:0x008a, B:36:0x0092, B:38:0x009a, B:40:0x00a2, B:44:0x00ae, B:46:0x00b6, B:48:0x00be, B:50:0x00c6, B:139:0x0216, B:142:0x021e, B:144:0x0224, B:145:0x023e, B:146:0x025f, B:53:0x00cf, B:54:0x00d2, B:56:0x00da, B:59:0x00e5, B:61:0x00ed, B:66:0x00fb, B:68:0x0103, B:71:0x010e, B:73:0x0116, B:76:0x0121, B:78:0x0129), top: B:157:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x00ed A[Catch: Exception -> 0x0033, TryCatch #3 {Exception -> 0x0033, blocks: (B:3:0x0008, B:5:0x001c, B:7:0x0026, B:12:0x0036, B:16:0x0044, B:20:0x004e, B:22:0x0056, B:24:0x005e, B:26:0x0068, B:28:0x0072, B:30:0x007a, B:32:0x0082, B:34:0x008a, B:36:0x0092, B:38:0x009a, B:40:0x00a2, B:44:0x00ae, B:46:0x00b6, B:48:0x00be, B:50:0x00c6, B:139:0x0216, B:142:0x021e, B:144:0x0224, B:145:0x023e, B:146:0x025f, B:53:0x00cf, B:54:0x00d2, B:56:0x00da, B:59:0x00e5, B:61:0x00ed, B:66:0x00fb, B:68:0x0103, B:71:0x010e, B:73:0x0116, B:76:0x0121, B:78:0x0129), top: B:157:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x00f6 A[EDGE_INSN: B:64:0x00f6->B:81:0x0133 BREAK  A[LOOP:1: B:49:0x00c4->B:53:0x00cf]] */
    /* JADX WARN: Code duplicated, block: B:66:0x00fb A[Catch: Exception -> 0x0033, TryCatch #3 {Exception -> 0x0033, blocks: (B:3:0x0008, B:5:0x001c, B:7:0x0026, B:12:0x0036, B:16:0x0044, B:20:0x004e, B:22:0x0056, B:24:0x005e, B:26:0x0068, B:28:0x0072, B:30:0x007a, B:32:0x0082, B:34:0x008a, B:36:0x0092, B:38:0x009a, B:40:0x00a2, B:44:0x00ae, B:46:0x00b6, B:48:0x00be, B:50:0x00c6, B:139:0x0216, B:142:0x021e, B:144:0x0224, B:145:0x023e, B:146:0x025f, B:53:0x00cf, B:54:0x00d2, B:56:0x00da, B:59:0x00e5, B:61:0x00ed, B:66:0x00fb, B:68:0x0103, B:71:0x010e, B:73:0x0116, B:76:0x0121, B:78:0x0129), top: B:157:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x0103 A[Catch: Exception -> 0x0033, TryCatch #3 {Exception -> 0x0033, blocks: (B:3:0x0008, B:5:0x001c, B:7:0x0026, B:12:0x0036, B:16:0x0044, B:20:0x004e, B:22:0x0056, B:24:0x005e, B:26:0x0068, B:28:0x0072, B:30:0x007a, B:32:0x0082, B:34:0x008a, B:36:0x0092, B:38:0x009a, B:40:0x00a2, B:44:0x00ae, B:46:0x00b6, B:48:0x00be, B:50:0x00c6, B:139:0x0216, B:142:0x021e, B:144:0x0224, B:145:0x023e, B:146:0x025f, B:53:0x00cf, B:54:0x00d2, B:56:0x00da, B:59:0x00e5, B:61:0x00ed, B:66:0x00fb, B:68:0x0103, B:71:0x010e, B:73:0x0116, B:76:0x0121, B:78:0x0129), top: B:157:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x010e A[Catch: Exception -> 0x0033, TryCatch #3 {Exception -> 0x0033, blocks: (B:3:0x0008, B:5:0x001c, B:7:0x0026, B:12:0x0036, B:16:0x0044, B:20:0x004e, B:22:0x0056, B:24:0x005e, B:26:0x0068, B:28:0x0072, B:30:0x007a, B:32:0x0082, B:34:0x008a, B:36:0x0092, B:38:0x009a, B:40:0x00a2, B:44:0x00ae, B:46:0x00b6, B:48:0x00be, B:50:0x00c6, B:139:0x0216, B:142:0x021e, B:144:0x0224, B:145:0x023e, B:146:0x025f, B:53:0x00cf, B:54:0x00d2, B:56:0x00da, B:59:0x00e5, B:61:0x00ed, B:66:0x00fb, B:68:0x0103, B:71:0x010e, B:73:0x0116, B:76:0x0121, B:78:0x0129), top: B:157:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x0116 A[Catch: Exception -> 0x0033, TryCatch #3 {Exception -> 0x0033, blocks: (B:3:0x0008, B:5:0x001c, B:7:0x0026, B:12:0x0036, B:16:0x0044, B:20:0x004e, B:22:0x0056, B:24:0x005e, B:26:0x0068, B:28:0x0072, B:30:0x007a, B:32:0x0082, B:34:0x008a, B:36:0x0092, B:38:0x009a, B:40:0x00a2, B:44:0x00ae, B:46:0x00b6, B:48:0x00be, B:50:0x00c6, B:139:0x0216, B:142:0x021e, B:144:0x0224, B:145:0x023e, B:146:0x025f, B:53:0x00cf, B:54:0x00d2, B:56:0x00da, B:59:0x00e5, B:61:0x00ed, B:66:0x00fb, B:68:0x0103, B:71:0x010e, B:73:0x0116, B:76:0x0121, B:78:0x0129), top: B:157:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x0121 A[Catch: Exception -> 0x0033, TryCatch #3 {Exception -> 0x0033, blocks: (B:3:0x0008, B:5:0x001c, B:7:0x0026, B:12:0x0036, B:16:0x0044, B:20:0x004e, B:22:0x0056, B:24:0x005e, B:26:0x0068, B:28:0x0072, B:30:0x007a, B:32:0x0082, B:34:0x008a, B:36:0x0092, B:38:0x009a, B:40:0x00a2, B:44:0x00ae, B:46:0x00b6, B:48:0x00be, B:50:0x00c6, B:139:0x0216, B:142:0x021e, B:144:0x0224, B:145:0x023e, B:146:0x025f, B:53:0x00cf, B:54:0x00d2, B:56:0x00da, B:59:0x00e5, B:61:0x00ed, B:66:0x00fb, B:68:0x0103, B:71:0x010e, B:73:0x0116, B:76:0x0121, B:78:0x0129), top: B:157:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x0129 A[Catch: Exception -> 0x0033, TryCatch #3 {Exception -> 0x0033, blocks: (B:3:0x0008, B:5:0x001c, B:7:0x0026, B:12:0x0036, B:16:0x0044, B:20:0x004e, B:22:0x0056, B:24:0x005e, B:26:0x0068, B:28:0x0072, B:30:0x007a, B:32:0x0082, B:34:0x008a, B:36:0x0092, B:38:0x009a, B:40:0x00a2, B:44:0x00ae, B:46:0x00b6, B:48:0x00be, B:50:0x00c6, B:139:0x0216, B:142:0x021e, B:144:0x0224, B:145:0x023e, B:146:0x025f, B:53:0x00cf, B:54:0x00d2, B:56:0x00da, B:59:0x00e5, B:61:0x00ed, B:66:0x00fb, B:68:0x0103, B:71:0x010e, B:73:0x0116, B:76:0x0121, B:78:0x0129), top: B:157:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:84:0x0145 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:85:0x0147  */
    /* JADX WARN: Code duplicated, block: B:86:0x0148 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:87:0x014a  */
    /* JADX WARN: Code duplicated, block: B:88:0x014c A[Catch: Exception -> 0x016b, TryCatch #0 {Exception -> 0x016b, blocks: (B:82:0x0135, B:88:0x014c, B:94:0x0160, B:96:0x0166, B:103:0x017d, B:105:0x0185, B:115:0x01af, B:106:0x018a, B:108:0x019a, B:110:0x01a2, B:99:0x0174), top: B:151:0x0135 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x015a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:91:0x015c  */
    /* JADX WARN: Code duplicated, block: B:92:0x015d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:93:0x015f  */
    /* JADX WARN: Code duplicated, block: B:96:0x0166 A[Catch: Exception -> 0x016b, TryCatch #0 {Exception -> 0x016b, blocks: (B:82:0x0135, B:88:0x014c, B:94:0x0160, B:96:0x0166, B:103:0x017d, B:105:0x0185, B:115:0x01af, B:106:0x018a, B:108:0x019a, B:110:0x01a2, B:99:0x0174), top: B:151:0x0135 }] */
    /* JADX WARN: Code duplicated, block: B:99:0x0174 A[Catch: Exception -> 0x016b, TryCatch #0 {Exception -> 0x016b, blocks: (B:82:0x0135, B:88:0x014c, B:94:0x0160, B:96:0x0166, B:103:0x017d, B:105:0x0185, B:115:0x01af, B:106:0x018a, B:108:0x019a, B:110:0x01a2, B:99:0x0174), top: B:151:0x0135 }] */
    /* JADX WARN: Code duplicated, block: B:9:0x002c  */
    private static ArrayList zzh(zztf zztfVar, zzti zztiVar) throws zzth {
        String[] supportedTypes;
        int length;
        int i11;
        String str;
        String str2;
        int i12;
        int i13;
        String str3;
        MediaCodecInfo.CodecCapabilities capabilitiesForType;
        boolean zZzd;
        boolean zZzc;
        boolean zZzd2;
        boolean zZzc2;
        int i14;
        boolean zIsHardwareAccelerated;
        boolean zZzj;
        String strZza;
        boolean zIsVendor;
        String str4;
        zztf zztfVar2 = zztfVar;
        try {
            ArrayList arrayList = new ArrayList();
            String str5 = zztfVar2.zza;
            boolean zZze = zztiVar.zze();
            int i15 = 0;
            for (int iZza = zztiVar.zza(); i15 < iZza; iZza = i13) {
                MediaCodecInfo mediaCodecInfoZzb = zztiVar.zzb(i15);
                int i16 = zzfy.zza;
                if (i16 < 29 || !mediaCodecInfoZzb.isAlias()) {
                    String name = mediaCodecInfoZzb.getName();
                    if (mediaCodecInfoZzb.isEncoder() || (!zZze && name.endsWith(".secure"))) {
                        i12 = i15;
                        i13 = iZza;
                        str3 = str5;
                    } else if (i16 < 24 && (("OMX.SEC.aac.dec".equals(name) || "OMX.Exynos.AAC.Decoder".equals(name)) && "samsung".equals(zzfy.zzc))) {
                        String str6 = zzfy.zzb;
                        if (str6.startsWith("zeroflte") || str6.startsWith("zerolte") || str6.startsWith("zenlte") || "SC-05G".equals(str6) || "marinelteatt".equals(str6) || "404SC".equals(str6) || "SC-04G".equals(str6) || "SCV31".equals(str6)) {
                            i12 = i15;
                            i13 = iZza;
                            str3 = str5;
                        } else if (i16 > 23) {
                            supportedTypes = mediaCodecInfoZzb.getSupportedTypes();
                            length = supportedTypes.length;
                            i11 = 0;
                            while (true) {
                                if (i11 >= length) {
                                    if (!str5.equals("video/dolby-vision")) {
                                        if (!str5.equals(MimeTypes.AUDIO_ALAC)) {
                                            if (!str5.equals(MimeTypes.AUDIO_FLAC)) {
                                                if (!str5.equals(MimeTypes.AUDIO_AC3)) {
                                                    str = null;
                                                    break;
                                                }
                                                str = null;
                                                break;
                                            }
                                            if (!str5.equals(MimeTypes.AUDIO_AC3)) {
                                                str = null;
                                                break;
                                            }
                                            str = null;
                                            break;
                                        }
                                        if (!str5.equals(MimeTypes.AUDIO_FLAC)) {
                                            if (!str5.equals(MimeTypes.AUDIO_AC3)) {
                                                str = null;
                                                break;
                                            }
                                            str = null;
                                            break;
                                        }
                                        if (!str5.equals(MimeTypes.AUDIO_AC3)) {
                                            str = null;
                                            break;
                                        }
                                        str = null;
                                        break;
                                    }
                                    if (!"OMX.MS.HEVCDV.Decoder".equals(name)) {
                                        if ("OMX.RTK.video.decoder".equals(name)) {
                                        }
                                        str = "video/dv_hevc";
                                        break;
                                    }
                                    str = "video/hevcdv";
                                    break;
                                }
                                str = supportedTypes[i11];
                                if (str.equalsIgnoreCase(str5)) {
                                    break;
                                    break;
                                }
                                i11++;
                            }
                            if (str != null) {
                                capabilitiesForType = mediaCodecInfoZzb.getCapabilitiesForType(str);
                                zZzd = zztiVar.zzd("tunneled-playback", str, capabilitiesForType);
                                zZzc = zztiVar.zzc("tunneled-playback", str, capabilitiesForType);
                                if (zztfVar2.zzc) {
                                    if (zZzd) {
                                        zZzd2 = zztiVar.zzd("secure-playback", str, capabilitiesForType);
                                        zZzc2 = zztiVar.zzc("secure-playback", str, capabilitiesForType);
                                        if (zztfVar2.zzb) {
                                            if (zZzd2) {
                                                zZzd2 = true;
                                                i14 = zzfy.zza;
                                                if (i14 >= 29) {
                                                    zIsHardwareAccelerated = mediaCodecInfoZzb.isHardwareAccelerated();
                                                } else if (zzj(mediaCodecInfoZzb, str5)) {
                                                    zIsHardwareAccelerated = false;
                                                } else {
                                                    zIsHardwareAccelerated = true;
                                                }
                                                zZzj = zzj(mediaCodecInfoZzb, str5);
                                                if (i14 >= 29) {
                                                    zIsVendor = mediaCodecInfoZzb.isVendor();
                                                } else {
                                                    strZza = zzfwk.zza(mediaCodecInfoZzb.getName());
                                                    if (strZza.startsWith("omx.google.")) {
                                                        zIsVendor = false;
                                                    } else {
                                                        zIsVendor = false;
                                                    }
                                                }
                                                if (zZze) {
                                                    if (!zZze) {
                                                        if (!zztfVar2.zzb) {
                                                            str4 = name;
                                                            i12 = i15;
                                                            i13 = iZza;
                                                            str3 = str5;
                                                            arrayList.add(zzsv.zzc(name, str5, str, capabilitiesForType, zIsHardwareAccelerated, zZzj, zIsVendor, false, false));
                                                        }
                                                    }
                                                    str4 = name;
                                                    i12 = i15;
                                                    i13 = iZza;
                                                    str3 = str5;
                                                    if (zZze) {
                                                        continue;
                                                    }
                                                } else {
                                                    if (!zZze) {
                                                        if (!zztfVar2.zzb) {
                                                            str4 = name;
                                                            i12 = i15;
                                                            i13 = iZza;
                                                            str3 = str5;
                                                            arrayList.add(zzsv.zzc(name, str5, str, capabilitiesForType, zIsHardwareAccelerated, zZzj, zIsVendor, false, false));
                                                        }
                                                    }
                                                    str4 = name;
                                                    i12 = i15;
                                                    i13 = iZza;
                                                    str3 = str5;
                                                    if (zZze) {
                                                        continue;
                                                    }
                                                }
                                            }
                                        } else if (!zZzc2) {
                                            i14 = zzfy.zza;
                                            if (i14 >= 29) {
                                                zIsHardwareAccelerated = mediaCodecInfoZzb.isHardwareAccelerated();
                                            } else if (zzj(mediaCodecInfoZzb, str5)) {
                                                zIsHardwareAccelerated = true;
                                            } else {
                                                zIsHardwareAccelerated = false;
                                            }
                                            zZzj = zzj(mediaCodecInfoZzb, str5);
                                            if (i14 >= 29) {
                                                zIsVendor = mediaCodecInfoZzb.isVendor();
                                            } else {
                                                strZza = zzfwk.zza(mediaCodecInfoZzb.getName());
                                                if (strZza.startsWith("omx.google.")) {
                                                    zIsVendor = false;
                                                } else {
                                                    zIsVendor = false;
                                                }
                                            }
                                            if (zZze) {
                                                if (!zZze) {
                                                    if (!zztfVar2.zzb) {
                                                        str4 = name;
                                                        i12 = i15;
                                                        i13 = iZza;
                                                        str3 = str5;
                                                        arrayList.add(zzsv.zzc(name, str5, str, capabilitiesForType, zIsHardwareAccelerated, zZzj, zIsVendor, false, false));
                                                    }
                                                }
                                                str4 = name;
                                                i12 = i15;
                                                i13 = iZza;
                                                str3 = str5;
                                                if (zZze) {
                                                    continue;
                                                }
                                            } else {
                                                if (!zZze) {
                                                    if (!zztfVar2.zzb) {
                                                        str4 = name;
                                                        i12 = i15;
                                                        i13 = iZza;
                                                        str3 = str5;
                                                        arrayList.add(zzsv.zzc(name, str5, str, capabilitiesForType, zIsHardwareAccelerated, zZzj, zIsVendor, false, false));
                                                    }
                                                }
                                                str4 = name;
                                                i12 = i15;
                                                i13 = iZza;
                                                str3 = str5;
                                                if (zZze) {
                                                    continue;
                                                }
                                            }
                                        }
                                    }
                                } else if (!zZzc) {
                                    zZzd2 = zztiVar.zzd("secure-playback", str, capabilitiesForType);
                                    zZzc2 = zztiVar.zzc("secure-playback", str, capabilitiesForType);
                                    if (zztfVar2.zzb) {
                                        if (!zZzc2) {
                                            i14 = zzfy.zza;
                                            if (i14 >= 29) {
                                                zIsHardwareAccelerated = mediaCodecInfoZzb.isHardwareAccelerated();
                                            } else if (zzj(mediaCodecInfoZzb, str5)) {
                                                zIsHardwareAccelerated = true;
                                            } else {
                                                zIsHardwareAccelerated = false;
                                            }
                                            zZzj = zzj(mediaCodecInfoZzb, str5);
                                            if (i14 >= 29) {
                                                zIsVendor = mediaCodecInfoZzb.isVendor();
                                            } else {
                                                strZza = zzfwk.zza(mediaCodecInfoZzb.getName());
                                                if (strZza.startsWith("omx.google.")) {
                                                    zIsVendor = false;
                                                } else {
                                                    zIsVendor = false;
                                                }
                                            }
                                            if (zZze) {
                                                if (!zZze) {
                                                    if (!zztfVar2.zzb) {
                                                        str4 = name;
                                                        i12 = i15;
                                                        i13 = iZza;
                                                        str3 = str5;
                                                        arrayList.add(zzsv.zzc(name, str5, str, capabilitiesForType, zIsHardwareAccelerated, zZzj, zIsVendor, false, false));
                                                    }
                                                }
                                                str4 = name;
                                                i12 = i15;
                                                i13 = iZza;
                                                str3 = str5;
                                                if (zZze) {
                                                    continue;
                                                }
                                            } else {
                                                if (!zZze) {
                                                    if (!zztfVar2.zzb) {
                                                        str4 = name;
                                                        i12 = i15;
                                                        i13 = iZza;
                                                        str3 = str5;
                                                        arrayList.add(zzsv.zzc(name, str5, str, capabilitiesForType, zIsHardwareAccelerated, zZzj, zIsVendor, false, false));
                                                    }
                                                }
                                                str4 = name;
                                                i12 = i15;
                                                i13 = iZza;
                                                str3 = str5;
                                                if (zZze) {
                                                    continue;
                                                }
                                            }
                                        }
                                    } else if (zZzd2) {
                                        zZzd2 = true;
                                        i14 = zzfy.zza;
                                        if (i14 >= 29) {
                                            zIsHardwareAccelerated = mediaCodecInfoZzb.isHardwareAccelerated();
                                        } else if (zzj(mediaCodecInfoZzb, str5)) {
                                            zIsHardwareAccelerated = true;
                                        } else {
                                            zIsHardwareAccelerated = false;
                                        }
                                        zZzj = zzj(mediaCodecInfoZzb, str5);
                                        if (i14 >= 29) {
                                            zIsVendor = mediaCodecInfoZzb.isVendor();
                                        } else {
                                            strZza = zzfwk.zza(mediaCodecInfoZzb.getName());
                                            if (strZza.startsWith("omx.google.")) {
                                                zIsVendor = false;
                                            } else {
                                                zIsVendor = false;
                                            }
                                        }
                                        if (zZze) {
                                            if (!zZze) {
                                                if (!zztfVar2.zzb) {
                                                    str4 = name;
                                                    i12 = i15;
                                                    i13 = iZza;
                                                    str3 = str5;
                                                    arrayList.add(zzsv.zzc(name, str5, str, capabilitiesForType, zIsHardwareAccelerated, zZzj, zIsVendor, false, false));
                                                }
                                            }
                                            str4 = name;
                                            i12 = i15;
                                            i13 = iZza;
                                            str3 = str5;
                                            if (zZze) {
                                                continue;
                                            }
                                        } else {
                                            if (!zZze) {
                                                if (!zztfVar2.zzb) {
                                                    str4 = name;
                                                    i12 = i15;
                                                    i13 = iZza;
                                                    str3 = str5;
                                                    arrayList.add(zzsv.zzc(name, str5, str, capabilitiesForType, zIsHardwareAccelerated, zZzj, zIsVendor, false, false));
                                                }
                                            }
                                            str4 = name;
                                            i12 = i15;
                                            i13 = iZza;
                                            str3 = str5;
                                            if (zZze) {
                                                continue;
                                            }
                                        }
                                    }
                                }
                                i12 = i15;
                                i13 = iZza;
                                str3 = str5;
                            } else {
                                i12 = i15;
                                i13 = iZza;
                                str3 = str5;
                            }
                        } else {
                            supportedTypes = mediaCodecInfoZzb.getSupportedTypes();
                            length = supportedTypes.length;
                            i11 = 0;
                            while (true) {
                                if (i11 >= length) {
                                    if (!str5.equals("video/dolby-vision")) {
                                        if (!str5.equals(MimeTypes.AUDIO_ALAC)) {
                                            if (!str5.equals(MimeTypes.AUDIO_FLAC)) {
                                                if (!str5.equals(MimeTypes.AUDIO_AC3)) {
                                                    str = null;
                                                    break;
                                                }
                                                str = null;
                                                break;
                                            }
                                            if (!str5.equals(MimeTypes.AUDIO_AC3)) {
                                                str = null;
                                                break;
                                            }
                                            str = null;
                                            break;
                                        }
                                        if (!str5.equals(MimeTypes.AUDIO_FLAC)) {
                                            if (!str5.equals(MimeTypes.AUDIO_AC3)) {
                                                str = null;
                                                break;
                                            }
                                            str = null;
                                            break;
                                        }
                                        if (!str5.equals(MimeTypes.AUDIO_AC3)) {
                                            str = null;
                                            break;
                                        }
                                        str = null;
                                        break;
                                    }
                                    if (!"OMX.MS.HEVCDV.Decoder".equals(name)) {
                                        if ("OMX.RTK.video.decoder".equals(name)) {
                                        }
                                        str = "video/dv_hevc";
                                        break;
                                    }
                                    str = "video/hevcdv";
                                    break;
                                }
                                str = supportedTypes[i11];
                                if (str.equalsIgnoreCase(str5)) {
                                    break;
                                    break;
                                }
                                i11++;
                            }
                            if (str != null) {
                                capabilitiesForType = mediaCodecInfoZzb.getCapabilitiesForType(str);
                                zZzd = zztiVar.zzd("tunneled-playback", str, capabilitiesForType);
                                zZzc = zztiVar.zzc("tunneled-playback", str, capabilitiesForType);
                                if (zztfVar2.zzc) {
                                    if (!zZzc) {
                                        zZzd2 = zztiVar.zzd("secure-playback", str, capabilitiesForType);
                                        zZzc2 = zztiVar.zzc("secure-playback", str, capabilitiesForType);
                                        if (zztfVar2.zzb) {
                                            if (!zZzc2) {
                                                i14 = zzfy.zza;
                                                if (i14 >= 29) {
                                                    zIsHardwareAccelerated = mediaCodecInfoZzb.isHardwareAccelerated();
                                                } else if (zzj(mediaCodecInfoZzb, str5)) {
                                                    zIsHardwareAccelerated = true;
                                                } else {
                                                    zIsHardwareAccelerated = false;
                                                }
                                                zZzj = zzj(mediaCodecInfoZzb, str5);
                                                if (i14 >= 29) {
                                                    zIsVendor = mediaCodecInfoZzb.isVendor();
                                                } else {
                                                    strZza = zzfwk.zza(mediaCodecInfoZzb.getName());
                                                    if (strZza.startsWith("omx.google.")) {
                                                        zIsVendor = false;
                                                    } else {
                                                        zIsVendor = false;
                                                    }
                                                }
                                                if (zZze) {
                                                    if (!zZze) {
                                                        if (!zztfVar2.zzb) {
                                                            str4 = name;
                                                            i12 = i15;
                                                            i13 = iZza;
                                                            str3 = str5;
                                                            arrayList.add(zzsv.zzc(name, str5, str, capabilitiesForType, zIsHardwareAccelerated, zZzj, zIsVendor, false, false));
                                                        }
                                                    }
                                                    str4 = name;
                                                    i12 = i15;
                                                    i13 = iZza;
                                                    str3 = str5;
                                                    if (zZze) {
                                                        continue;
                                                    }
                                                } else {
                                                    if (!zZze) {
                                                        if (!zztfVar2.zzb) {
                                                            str4 = name;
                                                            i12 = i15;
                                                            i13 = iZza;
                                                            str3 = str5;
                                                            arrayList.add(zzsv.zzc(name, str5, str, capabilitiesForType, zIsHardwareAccelerated, zZzj, zIsVendor, false, false));
                                                        }
                                                    }
                                                    str4 = name;
                                                    i12 = i15;
                                                    i13 = iZza;
                                                    str3 = str5;
                                                    if (zZze) {
                                                        continue;
                                                    }
                                                }
                                            }
                                        } else if (zZzd2) {
                                            zZzd2 = true;
                                            i14 = zzfy.zza;
                                            if (i14 >= 29) {
                                                zIsHardwareAccelerated = mediaCodecInfoZzb.isHardwareAccelerated();
                                            } else if (zzj(mediaCodecInfoZzb, str5)) {
                                                zIsHardwareAccelerated = true;
                                            } else {
                                                zIsHardwareAccelerated = false;
                                            }
                                            zZzj = zzj(mediaCodecInfoZzb, str5);
                                            if (i14 >= 29) {
                                                zIsVendor = mediaCodecInfoZzb.isVendor();
                                            } else {
                                                strZza = zzfwk.zza(mediaCodecInfoZzb.getName());
                                                if (strZza.startsWith("omx.google.")) {
                                                    zIsVendor = false;
                                                } else {
                                                    zIsVendor = false;
                                                }
                                            }
                                            if (zZze) {
                                                if (!zZze) {
                                                    if (!zztfVar2.zzb) {
                                                        str4 = name;
                                                        i12 = i15;
                                                        i13 = iZza;
                                                        str3 = str5;
                                                        arrayList.add(zzsv.zzc(name, str5, str, capabilitiesForType, zIsHardwareAccelerated, zZzj, zIsVendor, false, false));
                                                    }
                                                }
                                                str4 = name;
                                                i12 = i15;
                                                i13 = iZza;
                                                str3 = str5;
                                                if (zZze) {
                                                    continue;
                                                }
                                            } else {
                                                if (!zZze) {
                                                    if (!zztfVar2.zzb) {
                                                        str4 = name;
                                                        i12 = i15;
                                                        i13 = iZza;
                                                        str3 = str5;
                                                        arrayList.add(zzsv.zzc(name, str5, str, capabilitiesForType, zIsHardwareAccelerated, zZzj, zIsVendor, false, false));
                                                    }
                                                }
                                                str4 = name;
                                                i12 = i15;
                                                i13 = iZza;
                                                str3 = str5;
                                                if (zZze) {
                                                    continue;
                                                }
                                            }
                                        }
                                    }
                                } else if (zZzd) {
                                    zZzd2 = zztiVar.zzd("secure-playback", str, capabilitiesForType);
                                    zZzc2 = zztiVar.zzc("secure-playback", str, capabilitiesForType);
                                    if (zztfVar2.zzb) {
                                        if (!zZzc2) {
                                            i14 = zzfy.zza;
                                            if (i14 >= 29) {
                                                zIsHardwareAccelerated = mediaCodecInfoZzb.isHardwareAccelerated();
                                            } else if (zzj(mediaCodecInfoZzb, str5)) {
                                                zIsHardwareAccelerated = true;
                                            } else {
                                                zIsHardwareAccelerated = false;
                                            }
                                            zZzj = zzj(mediaCodecInfoZzb, str5);
                                            if (i14 >= 29) {
                                                zIsVendor = mediaCodecInfoZzb.isVendor();
                                            } else {
                                                strZza = zzfwk.zza(mediaCodecInfoZzb.getName());
                                                if (strZza.startsWith("omx.google.")) {
                                                    zIsVendor = false;
                                                } else {
                                                    zIsVendor = false;
                                                }
                                            }
                                            if (zZze) {
                                                if (!zZze) {
                                                    if (!zztfVar2.zzb) {
                                                        str4 = name;
                                                        i12 = i15;
                                                        i13 = iZza;
                                                        str3 = str5;
                                                        arrayList.add(zzsv.zzc(name, str5, str, capabilitiesForType, zIsHardwareAccelerated, zZzj, zIsVendor, false, false));
                                                    }
                                                }
                                                str4 = name;
                                                i12 = i15;
                                                i13 = iZza;
                                                str3 = str5;
                                                if (zZze) {
                                                    continue;
                                                }
                                            } else {
                                                if (!zZze) {
                                                    if (!zztfVar2.zzb) {
                                                        str4 = name;
                                                        i12 = i15;
                                                        i13 = iZza;
                                                        str3 = str5;
                                                        arrayList.add(zzsv.zzc(name, str5, str, capabilitiesForType, zIsHardwareAccelerated, zZzj, zIsVendor, false, false));
                                                    }
                                                }
                                                str4 = name;
                                                i12 = i15;
                                                i13 = iZza;
                                                str3 = str5;
                                                if (zZze) {
                                                    continue;
                                                }
                                            }
                                        }
                                    } else if (zZzd2) {
                                        zZzd2 = true;
                                        i14 = zzfy.zza;
                                        if (i14 >= 29) {
                                            zIsHardwareAccelerated = mediaCodecInfoZzb.isHardwareAccelerated();
                                        } else if (zzj(mediaCodecInfoZzb, str5)) {
                                            zIsHardwareAccelerated = true;
                                        } else {
                                            zIsHardwareAccelerated = false;
                                        }
                                        zZzj = zzj(mediaCodecInfoZzb, str5);
                                        if (i14 >= 29) {
                                            zIsVendor = mediaCodecInfoZzb.isVendor();
                                        } else {
                                            strZza = zzfwk.zza(mediaCodecInfoZzb.getName());
                                            if (strZza.startsWith("omx.google.")) {
                                                zIsVendor = false;
                                            } else {
                                                zIsVendor = false;
                                            }
                                        }
                                        if (zZze) {
                                            if (!zZze) {
                                                if (!zztfVar2.zzb) {
                                                    str4 = name;
                                                    i12 = i15;
                                                    i13 = iZza;
                                                    str3 = str5;
                                                    arrayList.add(zzsv.zzc(name, str5, str, capabilitiesForType, zIsHardwareAccelerated, zZzj, zIsVendor, false, false));
                                                }
                                            }
                                            str4 = name;
                                            i12 = i15;
                                            i13 = iZza;
                                            str3 = str5;
                                            if (zZze) {
                                                continue;
                                            }
                                        } else {
                                            if (!zZze) {
                                                if (!zztfVar2.zzb) {
                                                    str4 = name;
                                                    i12 = i15;
                                                    i13 = iZza;
                                                    str3 = str5;
                                                    arrayList.add(zzsv.zzc(name, str5, str, capabilitiesForType, zIsHardwareAccelerated, zZzj, zIsVendor, false, false));
                                                }
                                            }
                                            str4 = name;
                                            i12 = i15;
                                            i13 = iZza;
                                            str3 = str5;
                                            if (zZze) {
                                                continue;
                                            }
                                        }
                                    }
                                }
                                i12 = i15;
                                i13 = iZza;
                                str3 = str5;
                            } else {
                                i12 = i15;
                                i13 = iZza;
                                str3 = str5;
                            }
                        }
                    } else if (i16 > 23 && MimeTypes.AUDIO_E_AC3_JOC.equals(str5) && "OMX.MTK.AUDIO.DECODER.DSPAC3".equals(name)) {
                        i12 = i15;
                        i13 = iZza;
                        str3 = str5;
                    } else {
                        supportedTypes = mediaCodecInfoZzb.getSupportedTypes();
                        length = supportedTypes.length;
                        i11 = 0;
                        while (true) {
                            if (i11 >= length) {
                                if (!str5.equals("video/dolby-vision")) {
                                    if (!str5.equals(MimeTypes.AUDIO_ALAC) && "OMX.lge.alac.decoder".equals(name)) {
                                        str = "audio/x-lg-alac";
                                        break;
                                    }
                                    if (!str5.equals(MimeTypes.AUDIO_FLAC) && "OMX.lge.flac.decoder".equals(name)) {
                                        str = "audio/x-lg-flac";
                                        break;
                                    }
                                    if (!str5.equals(MimeTypes.AUDIO_AC3) && "OMX.lge.ac3.decoder".equals(name)) {
                                        str = "audio/lg-ac3";
                                        break;
                                    }
                                    str = null;
                                    break;
                                }
                                if (!"OMX.MS.HEVCDV.Decoder".equals(name)) {
                                    if ("OMX.RTK.video.decoder".equals(name) && !"OMX.realtek.video.decoder.tunneled".equals(name)) {
                                        str = null;
                                        break;
                                    }
                                    str = "video/dv_hevc";
                                    break;
                                }
                                str = "video/hevcdv";
                                break;
                            }
                            str = supportedTypes[i11];
                            if (str.equalsIgnoreCase(str5)) {
                                break;
                            }
                            i11++;
                        }
                        if (str != null) {
                            try {
                                capabilitiesForType = mediaCodecInfoZzb.getCapabilitiesForType(str);
                                zZzd = zztiVar.zzd("tunneled-playback", str, capabilitiesForType);
                                zZzc = zztiVar.zzc("tunneled-playback", str, capabilitiesForType);
                                if (zztfVar2.zzc) {
                                    if (!zZzc) {
                                        zZzd2 = zztiVar.zzd("secure-playback", str, capabilitiesForType);
                                        zZzc2 = zztiVar.zzc("secure-playback", str, capabilitiesForType);
                                        if (zztfVar2.zzb) {
                                            if (!zZzc2) {
                                                i14 = zzfy.zza;
                                                if (i14 >= 29) {
                                                    zIsHardwareAccelerated = mediaCodecInfoZzb.isHardwareAccelerated();
                                                } else if (zzj(mediaCodecInfoZzb, str5)) {
                                                    zIsHardwareAccelerated = true;
                                                } else {
                                                    zIsHardwareAccelerated = false;
                                                }
                                                zZzj = zzj(mediaCodecInfoZzb, str5);
                                                if (i14 >= 29) {
                                                    zIsVendor = mediaCodecInfoZzb.isVendor();
                                                } else {
                                                    strZza = zzfwk.zza(mediaCodecInfoZzb.getName());
                                                    if (strZza.startsWith("omx.google.") || strZza.startsWith("c2.android.") || strZza.startsWith("c2.google.")) {
                                                        zIsVendor = false;
                                                    } else {
                                                        zIsVendor = true;
                                                    }
                                                }
                                                if (zZze || zztfVar2.zzb != zZzd2) {
                                                    if (!zZze) {
                                                        try {
                                                            if (!zztfVar2.zzb) {
                                                                str4 = name;
                                                                i12 = i15;
                                                                i13 = iZza;
                                                                str3 = str5;
                                                                try {
                                                                    arrayList.add(zzsv.zzc(name, str5, str, capabilitiesForType, zIsHardwareAccelerated, zZzj, zIsVendor, false, false));
                                                                } catch (Exception e11) {
                                                                    e = e11;
                                                                    str2 = str4;
                                                                    if (zzfy.zza <= 23 || arrayList.isEmpty()) {
                                                                        zzff.zzc("MediaCodecUtil", "Failed to query codec " + str2 + " (" + str + ")");
                                                                        throw e;
                                                                    }
                                                                    zzff.zzc("MediaCodecUtil", "Skipping codec " + str2 + " (failed to query capabilities)");
                                                                }
                                                            }
                                                        } catch (Exception e12) {
                                                            e = e12;
                                                            str4 = name;
                                                            i12 = i15;
                                                            i13 = iZza;
                                                            str3 = str5;
                                                            str2 = str4;
                                                            if (zzfy.zza <= 23) {
                                                            }
                                                            zzff.zzc("MediaCodecUtil", "Failed to query codec " + str2 + " (" + str + ")");
                                                            throw e;
                                                        }
                                                    }
                                                    str4 = name;
                                                    i12 = i15;
                                                    i13 = iZza;
                                                    str3 = str5;
                                                    if (zZze && zZzd2) {
                                                        StringBuilder sb2 = new StringBuilder();
                                                        try {
                                                            sb2.append(str4);
                                                            sb2.append(".secure");
                                                            str2 = str4;
                                                            try {
                                                                arrayList.add(zzsv.zzc(sb2.toString(), str3, str, capabilitiesForType, zIsHardwareAccelerated, zZzj, zIsVendor, false, true));
                                                                break;
                                                            } catch (Exception e13) {
                                                                e = e13;
                                                                if (zzfy.zza <= 23) {
                                                                }
                                                                zzff.zzc("MediaCodecUtil", "Failed to query codec " + str2 + " (" + str + ")");
                                                                throw e;
                                                            }
                                                        } catch (Exception e14) {
                                                            e = e14;
                                                            str2 = str4;
                                                        }
                                                    }
                                                } else {
                                                    str4 = name;
                                                    i12 = i15;
                                                    i13 = iZza;
                                                    str3 = str5;
                                                    arrayList.add(zzsv.zzc(name, str5, str, capabilitiesForType, zIsHardwareAccelerated, zZzj, zIsVendor, false, false));
                                                }
                                            }
                                        } else if (zZzd2) {
                                            zZzd2 = true;
                                            i14 = zzfy.zza;
                                            if (i14 >= 29) {
                                                zIsHardwareAccelerated = mediaCodecInfoZzb.isHardwareAccelerated();
                                            } else if (zzj(mediaCodecInfoZzb, str5)) {
                                                zIsHardwareAccelerated = true;
                                            } else {
                                                zIsHardwareAccelerated = false;
                                            }
                                            zZzj = zzj(mediaCodecInfoZzb, str5);
                                            if (i14 >= 29) {
                                                zIsVendor = mediaCodecInfoZzb.isVendor();
                                            } else {
                                                strZza = zzfwk.zza(mediaCodecInfoZzb.getName());
                                                if (strZza.startsWith("omx.google.")) {
                                                    zIsVendor = false;
                                                } else {
                                                    zIsVendor = false;
                                                }
                                            }
                                            if (zZze) {
                                                if (!zZze) {
                                                    if (!zztfVar2.zzb) {
                                                        str4 = name;
                                                        i12 = i15;
                                                        i13 = iZza;
                                                        str3 = str5;
                                                        arrayList.add(zzsv.zzc(name, str5, str, capabilitiesForType, zIsHardwareAccelerated, zZzj, zIsVendor, false, false));
                                                    }
                                                }
                                                str4 = name;
                                                i12 = i15;
                                                i13 = iZza;
                                                str3 = str5;
                                                if (zZze) {
                                                    continue;
                                                }
                                            } else {
                                                if (!zZze) {
                                                    if (!zztfVar2.zzb) {
                                                        str4 = name;
                                                        i12 = i15;
                                                        i13 = iZza;
                                                        str3 = str5;
                                                        arrayList.add(zzsv.zzc(name, str5, str, capabilitiesForType, zIsHardwareAccelerated, zZzj, zIsVendor, false, false));
                                                    }
                                                }
                                                str4 = name;
                                                i12 = i15;
                                                i13 = iZza;
                                                str3 = str5;
                                                if (zZze) {
                                                    continue;
                                                }
                                            }
                                        }
                                    }
                                } else if (zZzd) {
                                    zZzd2 = zztiVar.zzd("secure-playback", str, capabilitiesForType);
                                    zZzc2 = zztiVar.zzc("secure-playback", str, capabilitiesForType);
                                    if (zztfVar2.zzb) {
                                        if (!zZzc2) {
                                            i14 = zzfy.zza;
                                            if (i14 >= 29) {
                                                zIsHardwareAccelerated = mediaCodecInfoZzb.isHardwareAccelerated();
                                            } else if (zzj(mediaCodecInfoZzb, str5)) {
                                                zIsHardwareAccelerated = true;
                                            } else {
                                                zIsHardwareAccelerated = false;
                                            }
                                            zZzj = zzj(mediaCodecInfoZzb, str5);
                                            if (i14 >= 29) {
                                                zIsVendor = mediaCodecInfoZzb.isVendor();
                                            } else {
                                                strZza = zzfwk.zza(mediaCodecInfoZzb.getName());
                                                if (strZza.startsWith("omx.google.")) {
                                                    zIsVendor = false;
                                                } else {
                                                    zIsVendor = false;
                                                }
                                            }
                                            if (zZze) {
                                                if (!zZze) {
                                                    if (!zztfVar2.zzb) {
                                                        str4 = name;
                                                        i12 = i15;
                                                        i13 = iZza;
                                                        str3 = str5;
                                                        arrayList.add(zzsv.zzc(name, str5, str, capabilitiesForType, zIsHardwareAccelerated, zZzj, zIsVendor, false, false));
                                                    }
                                                }
                                                str4 = name;
                                                i12 = i15;
                                                i13 = iZza;
                                                str3 = str5;
                                                if (zZze) {
                                                    continue;
                                                }
                                            } else {
                                                if (!zZze) {
                                                    if (!zztfVar2.zzb) {
                                                        str4 = name;
                                                        i12 = i15;
                                                        i13 = iZza;
                                                        str3 = str5;
                                                        arrayList.add(zzsv.zzc(name, str5, str, capabilitiesForType, zIsHardwareAccelerated, zZzj, zIsVendor, false, false));
                                                    }
                                                }
                                                str4 = name;
                                                i12 = i15;
                                                i13 = iZza;
                                                str3 = str5;
                                                if (zZze) {
                                                    continue;
                                                }
                                            }
                                        }
                                    } else if (zZzd2) {
                                        zZzd2 = true;
                                        i14 = zzfy.zza;
                                        if (i14 >= 29) {
                                            zIsHardwareAccelerated = mediaCodecInfoZzb.isHardwareAccelerated();
                                        } else if (zzj(mediaCodecInfoZzb, str5)) {
                                            zIsHardwareAccelerated = true;
                                        } else {
                                            zIsHardwareAccelerated = false;
                                        }
                                        zZzj = zzj(mediaCodecInfoZzb, str5);
                                        if (i14 >= 29) {
                                            zIsVendor = mediaCodecInfoZzb.isVendor();
                                        } else {
                                            strZza = zzfwk.zza(mediaCodecInfoZzb.getName());
                                            if (strZza.startsWith("omx.google.")) {
                                                zIsVendor = false;
                                            } else {
                                                zIsVendor = false;
                                            }
                                        }
                                        if (zZze) {
                                            if (!zZze) {
                                                if (!zztfVar2.zzb) {
                                                    str4 = name;
                                                    i12 = i15;
                                                    i13 = iZza;
                                                    str3 = str5;
                                                    arrayList.add(zzsv.zzc(name, str5, str, capabilitiesForType, zIsHardwareAccelerated, zZzj, zIsVendor, false, false));
                                                }
                                            }
                                            str4 = name;
                                            i12 = i15;
                                            i13 = iZza;
                                            str3 = str5;
                                            if (zZze) {
                                                continue;
                                            }
                                        } else {
                                            if (!zZze) {
                                                if (!zztfVar2.zzb) {
                                                    str4 = name;
                                                    i12 = i15;
                                                    i13 = iZza;
                                                    str3 = str5;
                                                    arrayList.add(zzsv.zzc(name, str5, str, capabilitiesForType, zIsHardwareAccelerated, zZzj, zIsVendor, false, false));
                                                }
                                            }
                                            str4 = name;
                                            i12 = i15;
                                            i13 = iZza;
                                            str3 = str5;
                                            if (zZze) {
                                                continue;
                                            }
                                        }
                                    }
                                }
                                i12 = i15;
                                i13 = iZza;
                                str3 = str5;
                            } catch (Exception e15) {
                                e = e15;
                                str2 = name;
                                i12 = i15;
                                i13 = iZza;
                                str3 = str5;
                            }
                        } else {
                            i12 = i15;
                            i13 = iZza;
                            str3 = str5;
                        }
                    }
                } else {
                    i12 = i15;
                    i13 = iZza;
                    str3 = str5;
                }
                i15 = i12 + 1;
                zztfVar2 = zztfVar;
                str5 = str3;
            }
            return arrayList;
        } catch (Exception e16) {
            throw new zzth(e16, null);
        }
    }

    private static void zzi(List list, final zztm zztmVar) {
        Collections.sort(list, new Comparator() { // from class: com.google.android.gms.internal.ads.zztc
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int i11 = zztn.zza;
                zztm zztmVar2 = zztmVar;
                return zztmVar2.zza(obj2) - zztmVar2.zza(obj);
            }
        });
    }

    private static boolean zzj(MediaCodecInfo mediaCodecInfo, String str) {
        if (zzfy.zza >= 29) {
            return mediaCodecInfo.isSoftwareOnly();
        }
        if (zzcb.zzg(str)) {
            return true;
        }
        String strZza = zzfwk.zza(mediaCodecInfo.getName());
        if (strZza.startsWith("arc.")) {
            return false;
        }
        if (strZza.startsWith("omx.google.") || strZza.startsWith("omx.ffmpeg.")) {
            return true;
        }
        if ((strZza.startsWith("omx.sec.") && strZza.contains(".sw.")) || strZza.equals("omx.qcom.video.decoder.hevcswvdec") || strZza.startsWith("c2.android.") || strZza.startsWith("c2.google.")) {
            return true;
        }
        return (strZza.startsWith("omx.") || strZza.startsWith("c2.")) ? false : true;
    }
}
