package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.o0;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.transsion.gslb.Worker;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f34537a = Pattern.compile("([a-z])=\\s?(.+)");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f34538b = Pattern.compile("([\\x21\\x23-\\x27\\x2a\\x2b\\x2d\\x2e\\x30-\\x39\\x41-\\x5a\\x5e-\\x7e]+)(?::(.*))?");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f34539c = Pattern.compile("(\\S+)\\s(\\S+)\\s(\\S+)\\s(\\S+)");

    public static void a(g0.b bVar, a.b bVar2) throws ParserException {
        try {
            bVar.n(bVar2.j());
        } catch (IllegalArgumentException | IllegalStateException e11) {
            throw ParserException.createForMalformedManifest(null, e11);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:57:0x00e9  */
    public static g0 b(String str) throws ParserException {
        byte b11;
        g0.b bVar = new g0.b();
        a.b bVarC = null;
        for (String str2 : y.s(str)) {
            if (!"".equals(str2)) {
                Matcher matcher = f34537a.matcher(str2);
                if (!matcher.matches()) {
                    throw ParserException.createForMalformedManifest("Malformed SDP line: " + str2, null);
                }
                String str3 = (String) com.google.android.exoplayer2.util.a.e(matcher.group(1));
                String str4 = (String) com.google.android.exoplayer2.util.a.e(matcher.group(2));
                switch (str3.hashCode()) {
                    case 97:
                        if (str3.equals("a")) {
                            b11 = Ascii.VT;
                        } else {
                            b11 = -1;
                        }
                        break;
                    case 98:
                        if (str3.equals(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B)) {
                            b11 = 8;
                        } else {
                            b11 = -1;
                        }
                        break;
                    case 99:
                        if (str3.equals("c")) {
                            b11 = 7;
                        } else {
                            b11 = -1;
                        }
                        break;
                    case 100:
                    case 102:
                    case Worker.WHAT_SYNC_DATA /* 103 */:
                    case 104:
                    case 106:
                    case 108:
                    case Worker.WHAT_QUIT /* 110 */:
                    case 113:
                    case 119:
                    case 120:
                    case 121:
                    default:
                        b11 = -1;
                        break;
                    case 101:
                        if (str3.equals("e")) {
                            b11 = 5;
                        } else {
                            b11 = -1;
                        }
                        break;
                    case 105:
                        if (str3.equals("i")) {
                            b11 = 3;
                        } else {
                            b11 = -1;
                        }
                        break;
                    case 107:
                        if (str3.equals(CampaignEx.JSON_KEY_AD_K)) {
                            b11 = 10;
                        } else {
                            b11 = -1;
                        }
                        break;
                    case 109:
                        if (str3.equals("m")) {
                            b11 = Ascii.FF;
                        } else {
                            b11 = -1;
                        }
                        break;
                    case 111:
                        if (str3.equals("o")) {
                            b11 = 1;
                        } else {
                            b11 = -1;
                        }
                        break;
                    case 112:
                        if (str3.equals(TtmlNode.TAG_P)) {
                            b11 = 6;
                        } else {
                            b11 = -1;
                        }
                        break;
                    case 114:
                        if (str3.equals(CampaignEx.JSON_KEY_AD_R)) {
                            b11 = Ascii.CR;
                        } else {
                            b11 = -1;
                        }
                        break;
                    case 115:
                        if (str3.equals("s")) {
                            b11 = 2;
                        } else {
                            b11 = -1;
                        }
                        break;
                    case 116:
                        if (str3.equals("t")) {
                            b11 = 9;
                        } else {
                            b11 = -1;
                        }
                        break;
                    case 117:
                        if (str3.equals("u")) {
                            b11 = 4;
                        } else {
                            b11 = -1;
                        }
                        break;
                    case 118:
                        if (str3.equals("v")) {
                            b11 = 0;
                        } else {
                            b11 = -1;
                        }
                        break;
                    case 122:
                        if (str3.equals("z")) {
                            b11 = Ascii.SO;
                        } else {
                            b11 = -1;
                        }
                        break;
                }
                switch (b11) {
                    case 0:
                        if (!"0".equals(str4)) {
                            throw ParserException.createForMalformedManifest(String.format("SDP version %s is not supported.", str4), null);
                        }
                        break;
                        break;
                    case 1:
                        bVar.t(str4);
                        break;
                    case 2:
                        bVar.w(str4);
                        break;
                    case 3:
                        if (bVarC == null) {
                            bVar.v(str4);
                        } else {
                            bVarC.p(str4);
                        }
                        break;
                    case 4:
                        bVar.y(Uri.parse(str4));
                        break;
                    case 5:
                        bVar.r(str4);
                        break;
                    case 6:
                        bVar.u(str4);
                        break;
                    case 7:
                        if (bVarC == null) {
                            bVar.q(str4);
                        } else {
                            bVarC.n(str4);
                        }
                        break;
                    case 8:
                        String[] strArrT0 = o0.T0(str4, ":\\s?");
                        com.google.android.exoplayer2.util.a.a(strArrT0.length == 2);
                        int i11 = Integer.parseInt(strArrT0[1]);
                        if (bVarC == null) {
                            bVar.p(i11 * 1000);
                        } else {
                            bVarC.m(i11 * 1000);
                        }
                        break;
                    case 9:
                        bVar.x(str4);
                        break;
                    case 10:
                        if (bVarC == null) {
                            bVar.s(str4);
                        } else {
                            bVarC.o(str4);
                        }
                        break;
                    case 11:
                        Matcher matcher2 = f34538b.matcher(str4);
                        if (!matcher2.matches()) {
                            throw ParserException.createForMalformedManifest("Malformed Attribute line: " + str2, null);
                        }
                        String str5 = (String) com.google.android.exoplayer2.util.a.e(matcher2.group(1));
                        String strE = com.google.common.base.p.e(matcher2.group(2));
                        if (bVarC == null) {
                            bVar.m(str5, strE);
                        } else {
                            bVarC.i(str5, strE);
                        }
                        break;
                        break;
                    case 12:
                        if (bVarC != null) {
                            a(bVar, bVarC);
                        }
                        bVarC = c(str4);
                        break;
                }
            }
        }
        if (bVarC != null) {
            a(bVar, bVarC);
        }
        try {
            return bVar.o();
        } catch (IllegalArgumentException | IllegalStateException e11) {
            throw ParserException.createForMalformedManifest(null, e11);
        }
    }

    public static a.b c(String str) throws ParserException {
        Matcher matcher = f34539c.matcher(str);
        if (!matcher.matches()) {
            throw ParserException.createForMalformedManifest("Malformed SDP media description line: " + str, null);
        }
        try {
            return new a.b((String) com.google.android.exoplayer2.util.a.e(matcher.group(1)), Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(matcher.group(2))), (String) com.google.android.exoplayer2.util.a.e(matcher.group(3)), Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(matcher.group(4))));
        } catch (NumberFormatException e11) {
            throw ParserException.createForMalformedManifest("Malformed SDP media description line: " + str, e11);
        }
    }
}
