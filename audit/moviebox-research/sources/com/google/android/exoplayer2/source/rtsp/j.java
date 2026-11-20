package com.google.android.exoplayer2.source.rtsp;

import androidx.annotation.Nullable;
import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.exoplayer2.m1;
import com.google.common.collect.ImmutableMap;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Map;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f34550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f34551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m1 f34552c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImmutableMap<String, String> f34553d;

    public j(m1 m1Var, int i11, int i12, Map<String, String> map) {
        this.f34550a = i11;
        this.f34551b = i12;
        this.f34552c = m1Var;
        this.f34553d = ImmutableMap.copyOf((Map) map);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static String a(String str) {
        String strG = com.google.common.base.a.g(str);
        strG.hashCode();
        byte b11 = -1;
        switch (strG.hashCode()) {
            case -1922091719:
                if (strG.equals("MPEG4-GENERIC")) {
                    b11 = 0;
                }
                break;
            case 2412:
                if (strG.equals("L8")) {
                    b11 = 1;
                }
                break;
            case 64593:
                if (strG.equals("AC3")) {
                    b11 = 2;
                }
                break;
            case 64934:
                if (strG.equals("AMR")) {
                    b11 = 3;
                }
                break;
            case 74609:
                if (strG.equals("L16")) {
                    b11 = 4;
                }
                break;
            case 85182:
                if (strG.equals("VP8")) {
                    b11 = 5;
                }
                break;
            case 85183:
                if (strG.equals("VP9")) {
                    b11 = 6;
                }
                break;
            case 2194728:
                if (strG.equals("H264")) {
                    b11 = 7;
                }
                break;
            case 2194729:
                if (strG.equals("H265")) {
                    b11 = 8;
                }
                break;
            case 2433087:
                if (strG.equals("OPUS")) {
                    b11 = 9;
                }
                break;
            case 2450119:
                if (strG.equals("PCMA")) {
                    b11 = 10;
                }
                break;
            case 2450139:
                if (strG.equals("PCMU")) {
                    b11 = Ascii.VT;
                }
                break;
            case 1934494802:
                if (strG.equals("AMR-WB")) {
                    b11 = Ascii.FF;
                }
                break;
            case 1959269366:
                if (strG.equals("MP4V-ES")) {
                    b11 = Ascii.CR;
                }
                break;
            case 2137188397:
                if (strG.equals("H263-1998")) {
                    b11 = Ascii.SO;
                }
                break;
            case 2137209252:
                if (strG.equals("H263-2000")) {
                    b11 = Ascii.SI;
                }
                break;
        }
        switch (b11) {
            case 0:
                return MimeTypes.AUDIO_AAC;
            case 1:
            case 4:
                return MimeTypes.AUDIO_RAW;
            case 2:
                return MimeTypes.AUDIO_AC3;
            case 3:
                return MimeTypes.AUDIO_AMR_NB;
            case 5:
                return MimeTypes.VIDEO_VP8;
            case 6:
                return MimeTypes.VIDEO_VP9;
            case 7:
                return MimeTypes.VIDEO_H264;
            case 8:
                return MimeTypes.VIDEO_H265;
            case 9:
                return MimeTypes.AUDIO_OPUS;
            case 10:
                return MimeTypes.AUDIO_ALAW;
            case 11:
                return MimeTypes.AUDIO_MLAW;
            case 12:
                return MimeTypes.AUDIO_AMR_WB;
            case 13:
                return MimeTypes.VIDEO_MP4V;
            case 14:
            case 15:
                return MimeTypes.VIDEO_H263;
            default:
                throw new IllegalArgumentException(str);
        }
    }

    public static int b(String str) {
        com.google.android.exoplayer2.util.a.a(str.equals("L8") || str.equals("L16"));
        if (str.equals("L8")) {
            return 3;
        }
        return ASTNode.DEOP;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static boolean c(a aVar) {
        String strG = com.google.common.base.a.g(aVar.f34433j.f34444b);
        strG.hashCode();
        byte b11 = -1;
        switch (strG.hashCode()) {
            case -1922091719:
                if (strG.equals("MPEG4-GENERIC")) {
                    b11 = 0;
                }
                break;
            case 2412:
                if (strG.equals("L8")) {
                    b11 = 1;
                }
                break;
            case 64593:
                if (strG.equals("AC3")) {
                    b11 = 2;
                }
                break;
            case 64934:
                if (strG.equals("AMR")) {
                    b11 = 3;
                }
                break;
            case 74609:
                if (strG.equals("L16")) {
                    b11 = 4;
                }
                break;
            case 85182:
                if (strG.equals("VP8")) {
                    b11 = 5;
                }
                break;
            case 85183:
                if (strG.equals("VP9")) {
                    b11 = 6;
                }
                break;
            case 2194728:
                if (strG.equals("H264")) {
                    b11 = 7;
                }
                break;
            case 2194729:
                if (strG.equals("H265")) {
                    b11 = 8;
                }
                break;
            case 2433087:
                if (strG.equals("OPUS")) {
                    b11 = 9;
                }
                break;
            case 2450119:
                if (strG.equals("PCMA")) {
                    b11 = 10;
                }
                break;
            case 2450139:
                if (strG.equals("PCMU")) {
                    b11 = Ascii.VT;
                }
                break;
            case 1934494802:
                if (strG.equals("AMR-WB")) {
                    b11 = Ascii.FF;
                }
                break;
            case 1959269366:
                if (strG.equals("MP4V-ES")) {
                    b11 = Ascii.CR;
                }
                break;
            case 2137188397:
                if (strG.equals("H263-1998")) {
                    b11 = Ascii.SO;
                }
                break;
            case 2137209252:
                if (strG.equals("H263-2000")) {
                    b11 = Ascii.SI;
                }
                break;
        }
        switch (b11) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return true;
            default:
                return false;
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || j.class != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        return this.f34550a == jVar.f34550a && this.f34551b == jVar.f34551b && this.f34552c.equals(jVar.f34552c) && this.f34553d.equals(jVar.f34553d);
    }

    public int hashCode() {
        return ((((((217 + this.f34550a) * 31) + this.f34551b) * 31) + this.f34552c.hashCode()) * 31) + this.f34553d.hashCode();
    }
}
