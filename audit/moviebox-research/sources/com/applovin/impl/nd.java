package com.applovin.impl;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Pair;
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
/* JADX INFO: loaded from: classes3.dex */
public abstract class nd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f21319a = Pattern.compile("^\\D?(\\d+)$");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final HashMap f21320b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f21321c = -1;

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f21322a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f21323b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f21324c;

        public b(String str, boolean z11, boolean z12) {
            this.f21322a = str;
            this.f21323b = z11;
            this.f21324c = z12;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != b.class) {
                return false;
            }
            b bVar = (b) obj;
            return TextUtils.equals(this.f21322a, bVar.f21322a) && this.f21323b == bVar.f21323b && this.f21324c == bVar.f21324c;
        }

        public int hashCode() {
            return ((((this.f21322a.hashCode() + 31) * 31) + (this.f21323b ? 1231 : 1237)) * 31) + (this.f21324c ? 1231 : 1237);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c extends Exception {
        private c(Throwable th2) {
            super("Failed to query underlying media codecs", th2);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface d {
        int a();

        MediaCodecInfo a(int i11);

        boolean a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean b();

        boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e implements d {
        private e() {
        }

        @Override // com.applovin.impl.nd.d
        public int a() {
            return MediaCodecList.getCodecCount();
        }

        @Override // com.applovin.impl.nd.d
        public MediaCodecInfo a(int i11) {
            return MediaCodecList.getCodecInfoAt(i11);
        }

        @Override // com.applovin.impl.nd.d
        public boolean a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return false;
        }

        @Override // com.applovin.impl.nd.d
        public boolean b() {
            return false;
        }

        @Override // com.applovin.impl.nd.d
        public boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return "secure-playback".equals(str) && MimeTypes.VIDEO_H264.equals(str2);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class f implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f21325a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private MediaCodecInfo[] f21326b;

        public f(boolean z11, boolean z12) {
            this.f21325a = (z11 || z12) ? 1 : 0;
        }

        private void c() {
            if (this.f21326b == null) {
                this.f21326b = new MediaCodecList(this.f21325a).getCodecInfos();
            }
        }

        @Override // com.applovin.impl.nd.d
        public int a() {
            c();
            return this.f21326b.length;
        }

        @Override // com.applovin.impl.nd.d
        public MediaCodecInfo a(int i11) {
            c();
            return this.f21326b[i11];
        }

        @Override // com.applovin.impl.nd.d
        public boolean a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureRequired(str);
        }

        @Override // com.applovin.impl.nd.d
        public boolean b() {
            return true;
        }

        @Override // com.applovin.impl.nd.d
        public boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported(str);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface g {
        int a(Object obj);
    }

    private static int a(int i11) {
        switch (i11) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return 128;
            case 8:
                return 256;
            case 9:
                return 512;
            case 10:
                return 1024;
            case 11:
                return 2048;
            case 12:
                return 4096;
            case 13:
                return 8192;
            case 14:
                return 16384;
            case 15:
                return 32768;
            case 16:
                return 65536;
            case 17:
                return 131072;
            case 18:
                return 262144;
            case 19:
                return 524288;
            case 20:
                return 1048576;
            case 21:
                return 2097152;
            case 22:
                return 4194304;
            case 23:
                return 8388608;
            default:
                return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int a(f9 f9Var, kd kdVar) {
        try {
            return kdVar.b(f9Var) ? 1 : 0;
        } catch (c unused) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int a(kd kdVar) {
        String str = kdVar.f20199a;
        if (str.startsWith("OMX.google") || str.startsWith("c2.android")) {
            return 1;
        }
        return (xp.f24372a >= 26 || !str.equals("OMX.MTK.AUDIO.DECODER.RAW")) ? 0 : -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int a(g gVar, Object obj, Object obj2) {
        return gVar.a(obj2) - gVar.a(obj);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:11:0x002b  */
    public static Pair a(f9 f9Var) {
        String str = f9Var.f18897j;
        if (str == null) {
            return null;
        }
        String[] strArrSplit = str.split("\\.");
        if ("video/dolby-vision".equals(f9Var.f18900m)) {
            return c(f9Var.f18897j, strArrSplit);
        }
        byte b11 = 0;
        String str2 = strArrSplit[0];
        str2.hashCode();
        switch (str2.hashCode()) {
            case 3004662:
                if (!str2.equals("av01")) {
                    b11 = -1;
                }
                break;
            case 3006243:
                if (!str2.equals("avc1")) {
                    b11 = -1;
                } else {
                    b11 = 1;
                }
                break;
            case 3006244:
                if (!str2.equals("avc2")) {
                    b11 = -1;
                } else {
                    b11 = 2;
                }
                break;
            case 3199032:
                if (!str2.equals("hev1")) {
                    b11 = -1;
                } else {
                    b11 = 3;
                }
                break;
            case 3214780:
                if (!str2.equals("hvc1")) {
                    b11 = -1;
                } else {
                    b11 = 4;
                }
                break;
            case 3356560:
                if (!str2.equals("mp4a")) {
                    b11 = -1;
                } else {
                    b11 = 5;
                }
                break;
            case 3624515:
                if (!str2.equals("vp09")) {
                    b11 = -1;
                } else {
                    b11 = 6;
                }
                break;
            default:
                b11 = -1;
                break;
        }
        switch (b11) {
            case 0:
                return a(f9Var.f18897j, strArrSplit, f9Var.f18912y);
            case 1:
            case 2:
                return b(f9Var.f18897j, strArrSplit);
            case 3:
            case 4:
                return d(f9Var.f18897j, strArrSplit);
            case 5:
                return a(f9Var.f18897j, strArrSplit);
            case 6:
                return e(f9Var.f18897j, strArrSplit);
            default:
                return null;
        }
    }

    private static Pair a(String str, String[] strArr) {
        int iE;
        if (strArr.length != 3) {
            pc.d("MediaCodecUtil", "Ignoring malformed MP4A codec string: " + str);
            return null;
        }
        try {
            if (MimeTypes.AUDIO_AAC.equals(Cif.a(Integer.parseInt(strArr[1], 16))) && (iE = e(Integer.parseInt(strArr[2]))) != -1) {
                return new Pair(Integer.valueOf(iE), 0);
            }
        } catch (NumberFormatException unused) {
            pc.d("MediaCodecUtil", "Ignoring malformed MP4A codec string: " + str);
        }
        return null;
    }

    private static Pair a(String str, String[] strArr, r3 r3Var) {
        int i11;
        if (strArr.length < 4) {
            pc.d("MediaCodecUtil", "Ignoring malformed AV1 codec string: " + str);
            return null;
        }
        int i12 = 1;
        try {
            int i13 = Integer.parseInt(strArr[1]);
            int i14 = Integer.parseInt(strArr[2].substring(0, 2));
            int i15 = Integer.parseInt(strArr[3]);
            if (i13 != 0) {
                pc.d("MediaCodecUtil", "Unknown AV1 profile: " + i13);
                return null;
            }
            if (i15 != 8 && i15 != 10) {
                pc.d("MediaCodecUtil", "Unknown AV1 bit depth: " + i15);
                return null;
            }
            if (i15 != 8) {
                i12 = (r3Var == null || !(r3Var.f22034d != null || (i11 = r3Var.f22033c) == 7 || i11 == 6)) ? 2 : 4096;
            }
            int iA = a(i14);
            if (iA != -1) {
                return new Pair(Integer.valueOf(i12), Integer.valueOf(iA));
            }
            pc.d("MediaCodecUtil", "Unknown AV1 level: " + i14);
            return null;
        } catch (NumberFormatException unused) {
            pc.d("MediaCodecUtil", "Ignoring malformed AV1 codec string: " + str);
            return null;
        }
    }

    public static kd a() {
        return a(MimeTypes.AUDIO_RAW, false, false);
    }

    public static kd a(String str, boolean z11, boolean z12) {
        List listB = b(str, z11, z12);
        if (listB.isEmpty()) {
            return null;
        }
        return (kd) listB.get(0);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static Integer a(String str) {
        if (str == null) {
            return null;
        }
        byte b11 = -1;
        switch (str.hashCode()) {
            case 1537:
                if (str.equals("01")) {
                    b11 = 0;
                }
                break;
            case 1538:
                if (str.equals("02")) {
                    b11 = 1;
                }
                break;
            case 1539:
                if (str.equals("03")) {
                    b11 = 2;
                }
                break;
            case 1540:
                if (str.equals("04")) {
                    b11 = 3;
                }
                break;
            case 1541:
                if (str.equals("05")) {
                    b11 = 4;
                }
                break;
            case 1542:
                if (str.equals("06")) {
                    b11 = 5;
                }
                break;
            case 1543:
                if (str.equals("07")) {
                    b11 = 6;
                }
                break;
            case 1544:
                if (str.equals("08")) {
                    b11 = 7;
                }
                break;
            case 1545:
                if (str.equals("09")) {
                    b11 = 8;
                }
                break;
            case 1567:
                if (str.equals(PrepareException.ERROR_MINI_APPID)) {
                    b11 = 9;
                }
                break;
            case 1568:
                if (str.equals(PrepareException.ERROR_DOWNLOAD_PACKAGE_URL_EMPTY)) {
                    b11 = 10;
                }
                break;
            case 1569:
                if (str.equals(PrepareException.ERROR_LOCAL_DATA_FILE_SCAN)) {
                    b11 = Ascii.VT;
                }
                break;
            case 1570:
                if (str.equals(PrepareException.ERROR_WARMUP_DOWNLOAD_EXCEPTION)) {
                    b11 = Ascii.FF;
                }
                break;
        }
        switch (b11) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return 128;
            case 8:
                return 256;
            case 9:
                return 512;
            case 10:
                return 1024;
            case 11:
                return 2048;
            case 12:
                return 4096;
            default:
                return null;
        }
    }

    private static String a(MediaCodecInfo mediaCodecInfo, String str, String str2) {
        for (String str3 : mediaCodecInfo.getSupportedTypes()) {
            if (str3.equalsIgnoreCase(str2)) {
                return str3;
            }
        }
        if (str2.equals("video/dolby-vision")) {
            if ("OMX.MS.HEVCDV.Decoder".equals(str)) {
                return "video/hevcdv";
            }
            if ("OMX.RTK.video.decoder".equals(str) || "OMX.realtek.video.decoder.tunneled".equals(str)) {
                return "video/dv_hevc";
            }
            return null;
        }
        if (str2.equals(MimeTypes.AUDIO_ALAC) && "OMX.lge.alac.decoder".equals(str)) {
            return "audio/x-lg-alac";
        }
        if (str2.equals(MimeTypes.AUDIO_FLAC) && "OMX.lge.flac.decoder".equals(str)) {
            return "audio/x-lg-flac";
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x008e  */
    /* JADX WARN: Code duplicated, block: B:58:0x0105 A[Catch: Exception -> 0x012e, TRY_ENTER, TryCatch #1 {Exception -> 0x012e, blocks: (B:3:0x0008, B:5:0x001b, B:61:0x0124, B:8:0x002d, B:11:0x0038, B:55:0x00fd, B:58:0x0105, B:60:0x010b, B:64:0x0130, B:65:0x0153), top: B:71:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0025  */
    /* JADX WARN: Code duplicated, block: B:83:0x0130 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    private static ArrayList a(b bVar, d dVar) throws c {
        String strA;
        String str;
        int i11;
        boolean z11;
        int i12;
        b bVar2 = bVar;
        try {
            ArrayList arrayList = new ArrayList();
            String str2 = bVar2.f21322a;
            int iA = dVar.a();
            boolean zB = dVar.b();
            int i13 = 0;
            while (i13 < iA) {
                MediaCodecInfo mediaCodecInfoA = dVar.a(i13);
                if (a(mediaCodecInfoA)) {
                    i11 = i13;
                    z11 = zB;
                    i12 = iA;
                } else {
                    String name = mediaCodecInfoA.getName();
                    if (a(mediaCodecInfoA, name, zB, str2) && (strA = a(mediaCodecInfoA, name, str2)) != null) {
                        try {
                            MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfoA.getCapabilitiesForType(strA);
                            boolean zB2 = dVar.b("tunneled-playback", strA, capabilitiesForType);
                            boolean zA = dVar.a("tunneled-playback", strA, capabilitiesForType);
                            boolean z12 = bVar2.f21324c;
                            if ((z12 || !zA) && (!z12 || zB2)) {
                                boolean zB3 = dVar.b("secure-playback", strA, capabilitiesForType);
                                boolean zA2 = dVar.a("secure-playback", strA, capabilitiesForType);
                                boolean z13 = bVar2.f21323b;
                                if ((z13 || !zA2) && (!z13 || zB3)) {
                                    boolean zC = c(mediaCodecInfoA);
                                    boolean zE = e(mediaCodecInfoA);
                                    boolean zG = g(mediaCodecInfoA);
                                    if (zB && bVar2.f21323b == zB3) {
                                        i11 = i13;
                                        z11 = zB;
                                        i12 = iA;
                                        arrayList.add(kd.a(name, str2, strA, capabilitiesForType, zC, zE, zG, false, false));
                                    } else {
                                        if (!zB) {
                                            try {
                                                if (!bVar2.f21323b) {
                                                    i11 = i13;
                                                    z11 = zB;
                                                    i12 = iA;
                                                    try {
                                                        arrayList.add(kd.a(name, str2, strA, capabilitiesForType, zC, zE, zG, false, false));
                                                    } catch (Exception e11) {
                                                        e = e11;
                                                        str = name;
                                                        if (xp.f24372a <= 23) {
                                                        }
                                                        pc.b("MediaCodecUtil", "Failed to query codec " + str + " (" + strA + ")");
                                                        throw e;
                                                    }
                                                }
                                            } catch (Exception e12) {
                                                e = e12;
                                                i11 = i13;
                                                z11 = zB;
                                                i12 = iA;
                                                str = name;
                                                if (xp.f24372a <= 23 || arrayList.isEmpty()) {
                                                    pc.b("MediaCodecUtil", "Failed to query codec " + str + " (" + strA + ")");
                                                    throw e;
                                                }
                                                pc.b("MediaCodecUtil", "Skipping codec " + str + " (failed to query capabilities)");
                                                i13 = i11 + 1;
                                                bVar2 = bVar;
                                                iA = i12;
                                                zB = z11;
                                            }
                                        }
                                        strA = strA;
                                        i11 = i13;
                                        z11 = zB;
                                        i12 = iA;
                                        if (!z11 && zB3) {
                                            StringBuilder sb2 = new StringBuilder();
                                            try {
                                                sb2.append(name);
                                                sb2.append(".secure");
                                                str = name;
                                                try {
                                                    arrayList.add(kd.a(sb2.toString(), str2, strA, capabilitiesForType, zC, zE, zG, false, true));
                                                    return arrayList;
                                                } catch (Exception e13) {
                                                    e = e13;
                                                    if (xp.f24372a <= 23) {
                                                    }
                                                    pc.b("MediaCodecUtil", "Failed to query codec " + str + " (" + strA + ")");
                                                    throw e;
                                                }
                                            } catch (Exception e14) {
                                                e = e14;
                                                str = name;
                                            }
                                        }
                                    }
                                } else {
                                    i11 = i13;
                                    z11 = zB;
                                    i12 = iA;
                                }
                            } else {
                                i11 = i13;
                                z11 = zB;
                                i12 = iA;
                            }
                        } catch (Exception e15) {
                            e = e15;
                            strA = strA;
                            str = name;
                            i11 = i13;
                            z11 = zB;
                            i12 = iA;
                        }
                    } else {
                        i11 = i13;
                        z11 = zB;
                        i12 = iA;
                    }
                }
                i13 = i11 + 1;
                bVar2 = bVar;
                iA = i12;
                zB = z11;
            }
            return arrayList;
        } catch (Exception e16) {
            throw new c(e16);
        }
    }

    public static List a(List list, final f9 f9Var) {
        ArrayList arrayList = new ArrayList(list);
        a(arrayList, new g() { // from class: com.applovin.impl.k00
            @Override // com.applovin.impl.nd.g
            public final int a(Object obj) {
                return nd.a(f9Var, (kd) obj);
            }
        });
        return arrayList;
    }

    private static void a(String str, List list) {
        if (MimeTypes.AUDIO_RAW.equals(str)) {
            if (xp.f24372a < 26 && xp.f24373b.equals("R9") && list.size() == 1 && ((kd) list.get(0)).f20199a.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                list.add(kd.a("OMX.google.raw.decoder", MimeTypes.AUDIO_RAW, MimeTypes.AUDIO_RAW, null, false, true, false, false, false));
            }
            a(list, new g() { // from class: com.applovin.impl.i00
                @Override // com.applovin.impl.nd.g
                public final int a(Object obj) {
                    return nd.a((kd) obj);
                }
            });
        }
        int i11 = xp.f24372a;
        if (i11 < 21 && list.size() > 1) {
            String str2 = ((kd) list.get(0)).f20199a;
            if ("OMX.SEC.mp3.dec".equals(str2) || "OMX.SEC.MP3.Decoder".equals(str2) || "OMX.brcm.audio.mp3.decoder".equals(str2)) {
                a(list, new g() { // from class: com.applovin.impl.j00
                    @Override // com.applovin.impl.nd.g
                    public final int a(Object obj) {
                        return nd.b((kd) obj);
                    }
                });
            }
        }
        if (i11 >= 32 || list.size() <= 1 || !"OMX.qti.audio.decoder.flac".equals(((kd) list.get(0)).f20199a)) {
            return;
        }
        list.add((kd) list.remove(0));
    }

    private static void a(List list, final g gVar) {
        Collections.sort(list, new Comparator() { // from class: com.applovin.impl.l00
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return nd.a(gVar, obj, obj2);
            }
        });
    }

    private static boolean a(MediaCodecInfo mediaCodecInfo) {
        return xp.f24372a >= 29 && b(mediaCodecInfo);
    }

    private static boolean a(MediaCodecInfo mediaCodecInfo, String str, boolean z11, String str2) {
        if (mediaCodecInfo.isEncoder() || (!z11 && str.endsWith(".secure"))) {
            return false;
        }
        int i11 = xp.f24372a;
        if (i11 < 21 && ("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "CIPAMRNBDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
            return false;
        }
        if (i11 < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(str)) {
            String str3 = xp.f24373b;
            if ("a70".equals(str3) || ("Xiaomi".equals(xp.f24374c) && str3.startsWith("HM"))) {
                return false;
            }
        }
        if (i11 == 16 && "OMX.qcom.audio.decoder.mp3".equals(str)) {
            String str4 = xp.f24373b;
            if ("dlxu".equals(str4) || "protou".equals(str4) || "ville".equals(str4) || "villeplus".equals(str4) || "villec2".equals(str4) || str4.startsWith("gee") || "C6602".equals(str4) || "C6603".equals(str4) || "C6606".equals(str4) || "C6616".equals(str4) || "L36h".equals(str4) || "SO-02E".equals(str4)) {
                return false;
            }
        }
        if (i11 == 16 && "OMX.qcom.audio.decoder.aac".equals(str)) {
            String str5 = xp.f24373b;
            if ("C1504".equals(str5) || "C1505".equals(str5) || "C1604".equals(str5) || "C1605".equals(str5)) {
                return false;
            }
        }
        if (i11 < 24 && (("OMX.SEC.aac.dec".equals(str) || "OMX.Exynos.AAC.Decoder".equals(str)) && "samsung".equals(xp.f24374c))) {
            String str6 = xp.f24373b;
            if (str6.startsWith("zeroflte") || str6.startsWith("zerolte") || str6.startsWith("zenlte") || "SC-05G".equals(str6) || "marinelteatt".equals(str6) || "404SC".equals(str6) || "SC-04G".equals(str6) || "SCV31".equals(str6)) {
                return false;
            }
        }
        if (i11 <= 19 && "OMX.SEC.vp8.dec".equals(str) && "samsung".equals(xp.f24374c)) {
            String str7 = xp.f24373b;
            if (str7.startsWith("d2") || str7.startsWith("serrano") || str7.startsWith("jflte") || str7.startsWith("santos") || str7.startsWith("t0")) {
                return false;
            }
        }
        if (i11 <= 19 && xp.f24373b.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(str)) {
            return false;
        }
        return (MimeTypes.AUDIO_E_AC3_JOC.equals(str2) && "OMX.MTK.AUDIO.DECODER.DSPAC3".equals(str)) ? false : true;
    }

    public static int b() {
        if (f21321c == -1) {
            int iMax = 0;
            kd kdVarA = a(MimeTypes.VIDEO_H264, false, false);
            if (kdVarA != null) {
                MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArrA = kdVarA.a();
                int length = codecProfileLevelArrA.length;
                int iMax2 = 0;
                while (iMax < length) {
                    iMax2 = Math.max(c(codecProfileLevelArrA[iMax].level), iMax2);
                    iMax++;
                }
                iMax = Math.max(iMax2, xp.f24372a >= 21 ? 345600 : 172800);
            }
            f21321c = iMax;
        }
        return f21321c;
    }

    private static int b(int i11) {
        switch (i11) {
            case 10:
                return 1;
            case 11:
                return 4;
            case 12:
                return 8;
            case 13:
                return 16;
            default:
                switch (i11) {
                    case 20:
                        return 32;
                    case 21:
                        return 64;
                    case 22:
                        return 128;
                    default:
                        switch (i11) {
                            case 30:
                                return 256;
                            case VungleException.WEB_CRASH /* 31 */:
                                return 512;
                            case 32:
                                return 1024;
                            default:
                                switch (i11) {
                                    case 40:
                                        return 2048;
                                    case 41:
                                        return 4096;
                                    case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                                        return 8192;
                                    default:
                                        switch (i11) {
                                            case 50:
                                                return 16384;
                                            case 51:
                                                return 32768;
                                            case 52:
                                                return 65536;
                                            default:
                                                return -1;
                                        }
                                }
                        }
                }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int b(kd kdVar) {
        return kdVar.f20199a.startsWith("OMX.google") ? 1 : 0;
    }

    private static Pair b(String str, String[] strArr) {
        int i11;
        int i12;
        if (strArr.length < 2) {
            pc.d("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                i12 = Integer.parseInt(strArr[1].substring(0, 2), 16);
                i11 = Integer.parseInt(strArr[1].substring(4), 16);
            } else {
                if (strArr.length < 3) {
                    pc.d("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
                    return null;
                }
                int i13 = Integer.parseInt(strArr[1]);
                i11 = Integer.parseInt(strArr[2]);
                i12 = i13;
            }
            int iD = d(i12);
            if (iD == -1) {
                pc.d("MediaCodecUtil", "Unknown AVC profile: " + i12);
                return null;
            }
            int iB = b(i11);
            if (iB != -1) {
                return new Pair(Integer.valueOf(iD), Integer.valueOf(iB));
            }
            pc.d("MediaCodecUtil", "Unknown AVC level: " + i11);
            return null;
        } catch (NumberFormatException unused) {
            pc.d("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
            return null;
        }
    }

    private static Integer b(String str) {
        if (str == null) {
            return null;
        }
        switch (str) {
            case "00":
                return 1;
            case "01":
                return 2;
            case "02":
                return 4;
            case "03":
                return 8;
            case "04":
                return 16;
            case "05":
                return 32;
            case "06":
                return 64;
            case "07":
                return 128;
            case "08":
                return 256;
            case "09":
                return 512;
            default:
                return null;
        }
    }

    public static synchronized List b(String str, boolean z11, boolean z12) {
        try {
            b bVar = new b(str, z11, z12);
            HashMap map = f21320b;
            List list = (List) map.get(bVar);
            if (list != null) {
                return list;
            }
            int i11 = xp.f24372a;
            ArrayList arrayListA = a(bVar, i11 >= 21 ? new f(z11, z12) : new e());
            if (z11 && arrayListA.isEmpty() && 21 <= i11 && i11 <= 23) {
                arrayListA = a(bVar, new e());
                if (!arrayListA.isEmpty()) {
                    pc.d("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + ((kd) arrayListA.get(0)).f20199a);
                }
            }
            a(str, arrayListA);
            List listUnmodifiableList = Collections.unmodifiableList(arrayListA);
            map.put(bVar, listUnmodifiableList);
            return listUnmodifiableList;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private static boolean b(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isAlias();
    }

    private static int c(int i11) {
        if (i11 == 1 || i11 == 2) {
            return 25344;
        }
        switch (i11) {
            case 8:
            case 16:
            case 32:
                return 101376;
            case 64:
                return 202752;
            case 128:
            case 256:
                return 414720;
            case 512:
                return 921600;
            case 1024:
                return 1310720;
            case 2048:
            case 4096:
                return 2097152;
            case 8192:
                return 2228224;
            case 16384:
                return 5652480;
            case 32768:
            case 65536:
                return 9437184;
            case 131072:
            case 262144:
            case 524288:
                return 35651584;
            default:
                return -1;
        }
    }

    private static Pair c(String str, String[] strArr) {
        if (strArr.length < 3) {
            pc.d("MediaCodecUtil", "Ignoring malformed Dolby Vision codec string: " + str);
            return null;
        }
        Matcher matcher = f21319a.matcher(strArr[1]);
        if (!matcher.matches()) {
            pc.d("MediaCodecUtil", "Ignoring malformed Dolby Vision codec string: " + str);
            return null;
        }
        String strGroup = matcher.group(1);
        Integer numB = b(strGroup);
        if (numB == null) {
            pc.d("MediaCodecUtil", "Unknown Dolby Vision profile string: " + strGroup);
            return null;
        }
        String str2 = strArr[2];
        Integer numA = a(str2);
        if (numA != null) {
            return new Pair(numB, numA);
        }
        pc.d("MediaCodecUtil", "Unknown Dolby Vision level string: " + str2);
        return null;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static Integer c(String str) {
        if (str == null) {
            return null;
        }
        byte b11 = -1;
        switch (str.hashCode()) {
            case 70821:
                if (str.equals("H30")) {
                    b11 = 0;
                }
                break;
            case 70914:
                if (str.equals("H60")) {
                    b11 = 1;
                }
                break;
            case 70917:
                if (str.equals("H63")) {
                    b11 = 2;
                }
                break;
            case 71007:
                if (str.equals("H90")) {
                    b11 = 3;
                }
                break;
            case 71010:
                if (str.equals("H93")) {
                    b11 = 4;
                }
                break;
            case 74665:
                if (str.equals("L30")) {
                    b11 = 5;
                }
                break;
            case 74758:
                if (str.equals("L60")) {
                    b11 = 6;
                }
                break;
            case 74761:
                if (str.equals("L63")) {
                    b11 = 7;
                }
                break;
            case 74851:
                if (str.equals("L90")) {
                    b11 = 8;
                }
                break;
            case 74854:
                if (str.equals("L93")) {
                    b11 = 9;
                }
                break;
            case 2193639:
                if (str.equals("H120")) {
                    b11 = 10;
                }
                break;
            case 2193642:
                if (str.equals("H123")) {
                    b11 = Ascii.VT;
                }
                break;
            case 2193732:
                if (str.equals("H150")) {
                    b11 = Ascii.FF;
                }
                break;
            case 2193735:
                if (str.equals("H153")) {
                    b11 = Ascii.CR;
                }
                break;
            case 2193738:
                if (str.equals("H156")) {
                    b11 = Ascii.SO;
                }
                break;
            case 2193825:
                if (str.equals("H180")) {
                    b11 = Ascii.SI;
                }
                break;
            case 2193828:
                if (str.equals("H183")) {
                    b11 = Ascii.DLE;
                }
                break;
            case 2193831:
                if (str.equals("H186")) {
                    b11 = 17;
                }
                break;
            case 2312803:
                if (str.equals("L120")) {
                    b11 = Ascii.DC2;
                }
                break;
            case 2312806:
                if (str.equals("L123")) {
                    b11 = 19;
                }
                break;
            case 2312896:
                if (str.equals("L150")) {
                    b11 = Ascii.DC4;
                }
                break;
            case 2312899:
                if (str.equals("L153")) {
                    b11 = Ascii.NAK;
                }
                break;
            case 2312902:
                if (str.equals("L156")) {
                    b11 = Ascii.SYN;
                }
                break;
            case 2312989:
                if (str.equals("L180")) {
                    b11 = Ascii.ETB;
                }
                break;
            case 2312992:
                if (str.equals("L183")) {
                    b11 = Ascii.CAN;
                }
                break;
            case 2312995:
                if (str.equals("L186")) {
                    b11 = Ascii.EM;
                }
                break;
        }
        switch (b11) {
            case 0:
                return 2;
            case 1:
                return 8;
            case 2:
                return 32;
            case 3:
                return 128;
            case 4:
                return 512;
            case 5:
                return 1;
            case 6:
                return 4;
            case 7:
                return 16;
            case 8:
                return 64;
            case 9:
                return 256;
            case 10:
                return 2048;
            case 11:
                return 8192;
            case 12:
                return 32768;
            case 13:
                return 131072;
            case 14:
                return 524288;
            case 15:
                return 2097152;
            case 16:
                return 8388608;
            case 17:
                return Integer.valueOf(ASTNode.PCTX_STORED);
            case 18:
                return 1024;
            case 19:
                return 4096;
            case 20:
                return 16384;
            case 21:
                return 65536;
            case 22:
                return 262144;
            case 23:
                return 1048576;
            case 24:
                return 4194304;
            case 25:
                return 16777216;
            default:
                return null;
        }
    }

    private static boolean c(MediaCodecInfo mediaCodecInfo) {
        return xp.f24372a >= 29 ? d(mediaCodecInfo) : !e(mediaCodecInfo);
    }

    private static int d(int i11) {
        if (i11 == 66) {
            return 1;
        }
        if (i11 == 77) {
            return 2;
        }
        if (i11 == 88) {
            return 4;
        }
        if (i11 == 100) {
            return 8;
        }
        if (i11 == 110) {
            return 16;
        }
        if (i11 != 122) {
            return i11 != 244 ? -1 : 64;
        }
        return 32;
    }

    private static Pair d(String str, String[] strArr) {
        if (strArr.length < 4) {
            pc.d("MediaCodecUtil", "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        int i11 = 1;
        Matcher matcher = f21319a.matcher(strArr[1]);
        if (!matcher.matches()) {
            pc.d("MediaCodecUtil", "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        String strGroup = matcher.group(1);
        if (!"1".equals(strGroup)) {
            if (!"2".equals(strGroup)) {
                pc.d("MediaCodecUtil", "Unknown HEVC profile string: " + strGroup);
                return null;
            }
            i11 = 2;
        }
        String str2 = strArr[3];
        Integer numC = c(str2);
        if (numC != null) {
            return new Pair(Integer.valueOf(i11), numC);
        }
        pc.d("MediaCodecUtil", "Unknown HEVC level string: " + str2);
        return null;
    }

    private static boolean d(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isHardwareAccelerated();
    }

    private static int e(int i11) {
        int i12 = 17;
        if (i11 != 17) {
            i12 = 20;
            if (i11 != 20) {
                i12 = 23;
                if (i11 != 23) {
                    i12 = 29;
                    if (i11 != 29) {
                        i12 = 39;
                        if (i11 != 39) {
                            i12 = 42;
                            if (i11 != 42) {
                                switch (i11) {
                                    case 1:
                                        return 1;
                                    case 2:
                                        return 2;
                                    case 3:
                                        return 3;
                                    case 4:
                                        return 4;
                                    case 5:
                                        return 5;
                                    case 6:
                                        return 6;
                                    default:
                                        return -1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return i12;
    }

    private static Pair e(String str, String[] strArr) {
        if (strArr.length < 3) {
            pc.d("MediaCodecUtil", "Ignoring malformed VP9 codec string: " + str);
            return null;
        }
        try {
            int i11 = Integer.parseInt(strArr[1]);
            int i12 = Integer.parseInt(strArr[2]);
            int iG = g(i11);
            if (iG == -1) {
                pc.d("MediaCodecUtil", "Unknown VP9 profile: " + i11);
                return null;
            }
            int iF = f(i12);
            if (iF != -1) {
                return new Pair(Integer.valueOf(iG), Integer.valueOf(iF));
            }
            pc.d("MediaCodecUtil", "Unknown VP9 level: " + i12);
            return null;
        } catch (NumberFormatException unused) {
            pc.d("MediaCodecUtil", "Ignoring malformed VP9 codec string: " + str);
            return null;
        }
    }

    private static boolean e(MediaCodecInfo mediaCodecInfo) {
        if (xp.f24372a >= 29) {
            return f(mediaCodecInfo);
        }
        String lowerCase = Ascii.toLowerCase(mediaCodecInfo.getName());
        if (lowerCase.startsWith("arc.")) {
            return false;
        }
        return lowerCase.startsWith("omx.google.") || lowerCase.startsWith("omx.ffmpeg.") || (lowerCase.startsWith("omx.sec.") && lowerCase.contains(".sw.")) || lowerCase.equals("omx.qcom.video.decoder.hevcswvdec") || lowerCase.startsWith("c2.android.") || lowerCase.startsWith("c2.google.") || !(lowerCase.startsWith("omx.") || lowerCase.startsWith("c2."));
    }

    private static int f(int i11) {
        if (i11 == 10) {
            return 1;
        }
        if (i11 == 11) {
            return 2;
        }
        if (i11 == 20) {
            return 4;
        }
        if (i11 == 21) {
            return 8;
        }
        if (i11 == 30) {
            return 16;
        }
        if (i11 == 31) {
            return 32;
        }
        if (i11 == 40) {
            return 64;
        }
        if (i11 == 41) {
            return 128;
        }
        if (i11 == 50) {
            return 256;
        }
        if (i11 == 51) {
            return 512;
        }
        switch (i11) {
            case 60:
                return 2048;
            case 61:
                return 4096;
            case 62:
                return 8192;
            default:
                return -1;
        }
    }

    private static boolean f(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isSoftwareOnly();
    }

    private static int g(int i11) {
        if (i11 == 0) {
            return 1;
        }
        if (i11 == 1) {
            return 2;
        }
        if (i11 != 2) {
            return i11 != 3 ? -1 : 8;
        }
        return 4;
    }

    private static boolean g(MediaCodecInfo mediaCodecInfo) {
        if (xp.f24372a >= 29) {
            return h(mediaCodecInfo);
        }
        String lowerCase = Ascii.toLowerCase(mediaCodecInfo.getName());
        return (lowerCase.startsWith("omx.google.") || lowerCase.startsWith("c2.android.") || lowerCase.startsWith("c2.google.")) ? false : true;
    }

    private static boolean h(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isVendor();
    }
}
