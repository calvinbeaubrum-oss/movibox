package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.Nullable;
import bh.l;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.h;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry;
import com.google.android.exoplayer2.upstream.b0;
import com.google.android.exoplayer2.util.m0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.s;
import com.google.android.exoplayer2.util.w;
import com.google.common.collect.e0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.transsion.gslb.Utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.TreeMap;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import sh.e;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class HlsPlaylistParser implements b0.a<e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f34128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final c f34129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f34104c = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f34106d = Pattern.compile("VIDEO=\"(.+?)\"");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Pattern f34107f = Pattern.compile("AUDIO=\"(.+?)\"");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Pattern f34108g = Pattern.compile("SUBTITLES=\"(.+?)\"");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Pattern f34109h = Pattern.compile("CLOSED-CAPTIONS=\"(.+?)\"");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Pattern f34110i = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Pattern f34111j = Pattern.compile("CHANNELS=\"(.+?)\"");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Pattern f34112k = Pattern.compile("CODECS=\"(.+?)\"");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Pattern f34113l = Pattern.compile("RESOLUTION=(\\d+x\\d+)");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Pattern f34114m = Pattern.compile("FRAME-RATE=([\\d\\.]+)\\b");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Pattern f34115n = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Pattern f34116o = Pattern.compile("DURATION=([\\d\\.]+)\\b");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Pattern f34117p = Pattern.compile("PART-TARGET=([\\d\\.]+)\\b");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Pattern f34118q = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Pattern f34119r = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Pattern f34120s = Pattern.compile("CAN-SKIP-UNTIL=([\\d\\.]+)\\b");

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Pattern f34121t = b("CAN-SKIP-DATERANGES");

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Pattern f34122u = Pattern.compile("SKIPPED-SEGMENTS=(\\d+)\\b");

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Pattern f34123v = Pattern.compile("[:|,]HOLD-BACK=([\\d\\.]+)\\b");

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final Pattern f34124w = Pattern.compile("PART-HOLD-BACK=([\\d\\.]+)\\b");

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Pattern f34125x = b("CAN-BLOCK-RELOAD");

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final Pattern f34126y = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final Pattern f34127z = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
    public static final Pattern A = Pattern.compile("#EXTINF:[\\d\\.]+\\b,(.+)");
    public static final Pattern B = Pattern.compile("LAST-MSN=(\\d+)\\b");
    public static final Pattern C = Pattern.compile("LAST-PART=(\\d+)\\b");
    public static final Pattern D = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
    public static final Pattern E = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    public static final Pattern F = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
    public static final Pattern G = Pattern.compile("BYTERANGE-START=(\\d+)\\b");
    public static final Pattern H = Pattern.compile("BYTERANGE-LENGTH=(\\d+)\\b");
    public static final Pattern I = Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES|SAMPLE-AES-CENC|SAMPLE-AES-CTR)\\s*(?:,|$)");
    public static final Pattern J = Pattern.compile("KEYFORMAT=\"(.+?)\"");
    public static final Pattern K = Pattern.compile("KEYFORMATVERSIONS=\"(.+?)\"");
    public static final Pattern L = Pattern.compile("URI=\"(.+?)\"");
    public static final Pattern M = Pattern.compile("IV=([^,.*]+)");
    public static final Pattern N = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    public static final Pattern O = Pattern.compile("TYPE=(PART|MAP)");
    public static final Pattern P = Pattern.compile("LANGUAGE=\"(.+?)\"");
    public static final Pattern Q = Pattern.compile("NAME=\"(.+?)\"");
    public static final Pattern R = Pattern.compile("GROUP-ID=\"(.+?)\"");
    public static final Pattern S = Pattern.compile("CHARACTERISTICS=\"(.+?)\"");
    public static final Pattern T = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
    public static final Pattern U = b("AUTOSELECT");
    public static final Pattern V = b("DEFAULT");
    public static final Pattern W = b("FORCED");
    public static final Pattern X = b("INDEPENDENT");
    public static final Pattern Y = b("GAP");
    public static final Pattern Z = b("PRECISE");

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final Pattern f34102a0 = Pattern.compile("VALUE=\"(.+?)\"");

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final Pattern f34103b0 = Pattern.compile("IMPORT=\"(.+?)\"");

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final Pattern f34105c0 = Pattern.compile("\\{\\$([a-zA-Z0-9\\-_]+)\\}");

    /* JADX INFO: compiled from: source.java */
    public static final class DeltaUpdateException extends IOException {
    }

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BufferedReader f34130a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Queue<String> f34131b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public String f34132c;

        public a(Queue<String> queue, BufferedReader bufferedReader) {
            this.f34131b = queue;
            this.f34130a = bufferedReader;
        }

        public boolean a() throws IOException {
            String strTrim;
            if (this.f34132c != null) {
                return true;
            }
            if (!this.f34131b.isEmpty()) {
                this.f34132c = (String) com.google.android.exoplayer2.util.a.e(this.f34131b.poll());
                return true;
            }
            do {
                String line = this.f34130a.readLine();
                this.f34132c = line;
                if (line == null) {
                    return false;
                }
                strTrim = line.trim();
                this.f34132c = strTrim;
            } while (strTrim.isEmpty());
            return true;
        }

        public String b() throws IOException {
            if (!a()) {
                throw new NoSuchElementException();
            }
            String str = this.f34132c;
            this.f34132c = null;
            return str;
        }
    }

    public HlsPlaylistParser() {
        this(d.f34203n, null);
    }

    public HlsPlaylistParser(d dVar, @Nullable c cVar) {
        this.f34128a = dVar;
        this.f34129b = cVar;
    }

    public static String A(String str, Map<String, String> map) {
        Matcher matcher = f34105c0.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String strGroup = matcher.group(1);
            if (map.containsKey(strGroup)) {
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(map.get(strGroup)));
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    public static int B(BufferedReader bufferedReader, boolean z11, int i11) throws IOException {
        while (i11 != -1 && Character.isWhitespace(i11) && (z11 || !o0.v0(i11))) {
            i11 = bufferedReader.read();
        }
        return i11;
    }

    public static boolean a(BufferedReader bufferedReader) throws IOException {
        int i11 = bufferedReader.read();
        if (i11 == 239) {
            if (bufferedReader.read() != 187 || bufferedReader.read() != 191) {
                return false;
            }
            i11 = bufferedReader.read();
        }
        int iB = B(bufferedReader, true, i11);
        for (int i12 = 0; i12 < 7; i12++) {
            if (iB != "#EXTM3U".charAt(i12)) {
                return false;
            }
            iB = bufferedReader.read();
        }
        return o0.v0(B(bufferedReader, false, iB));
    }

    public static Pattern b(String str) {
        return Pattern.compile(str + "=(NO|YES)");
    }

    public static DrmInitData c(@Nullable String str, DrmInitData.SchemeData[] schemeDataArr) {
        DrmInitData.SchemeData[] schemeDataArr2 = new DrmInitData.SchemeData[schemeDataArr.length];
        for (int i11 = 0; i11 < schemeDataArr.length; i11++) {
            schemeDataArr2[i11] = schemeDataArr[i11].copyWithData(null);
        }
        return new DrmInitData(str, schemeDataArr2);
    }

    @Nullable
    public static String d(long j11, @Nullable String str, @Nullable String str2) {
        if (str == null) {
            return null;
        }
        return str2 != null ? str2 : Long.toHexString(j11);
    }

    @Nullable
    public static d.b e(ArrayList<d.b> arrayList, String str) {
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            d.b bVar = arrayList.get(i11);
            if (str.equals(bVar.f34221d)) {
                return bVar;
            }
        }
        return null;
    }

    @Nullable
    public static d.b f(ArrayList<d.b> arrayList, String str) {
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            d.b bVar = arrayList.get(i11);
            if (str.equals(bVar.f34222e)) {
                return bVar;
            }
        }
        return null;
    }

    @Nullable
    public static d.b g(ArrayList<d.b> arrayList, String str) {
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            d.b bVar = arrayList.get(i11);
            if (str.equals(bVar.f34220c)) {
                return bVar;
            }
        }
        return null;
    }

    public static double i(String str, Pattern pattern) throws ParserException {
        return Double.parseDouble(y(str, pattern, Collections.emptyMap()));
    }

    @Nullable
    public static DrmInitData.SchemeData j(String str, String str2, Map<String, String> map) throws ParserException {
        String strT = t(str, K, "1", map);
        if ("urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed".equals(str2)) {
            String strY = y(str, L, map);
            return new DrmInitData.SchemeData(h.f33256d, MimeTypes.VIDEO_MP4, Base64.decode(strY.substring(strY.indexOf(44)), 0));
        }
        if ("com.widevine".equals(str2)) {
            return new DrmInitData.SchemeData(h.f33256d, "hls", o0.n0(str));
        }
        if (!"com.microsoft.playready".equals(str2) || !"1".equals(strT)) {
            return null;
        }
        String strY2 = y(str, L, map);
        byte[] bArrDecode = Base64.decode(strY2.substring(strY2.indexOf(44)), 0);
        UUID uuid = h.f33257e;
        return new DrmInitData.SchemeData(uuid, MimeTypes.VIDEO_MP4, l.a(uuid, bArrDecode));
    }

    public static String k(String str) {
        return ("SAMPLE-AES-CENC".equals(str) || "SAMPLE-AES-CTR".equals(str)) ? C.CENC_TYPE_cenc : C.CENC_TYPE_cbcs;
    }

    public static int l(String str, Pattern pattern) throws ParserException {
        return Integer.parseInt(y(str, pattern, Collections.emptyMap()));
    }

    public static long m(String str, Pattern pattern) throws ParserException {
        return Long.parseLong(y(str, pattern, Collections.emptyMap()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static c n(d dVar, @Nullable c cVar, a aVar, String str) throws IOException {
        ArrayList arrayList;
        ArrayList arrayList2;
        String str2;
        int i11;
        c.b bVar;
        String strU;
        long j11;
        long j12;
        Object drmInitData;
        long j13;
        long j14;
        dVar = dVar;
        cVar = cVar;
        boolean z11 = dVar.f76361c;
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        c.f fVar = new c.f(C.TIME_UNSET, false, C.TIME_UNSET, C.TIME_UNSET, false);
        TreeMap treeMap = new TreeMap();
        boolean z12 = false;
        String str3 = "";
        boolean z13 = z11;
        c.f fVarX = fVar;
        String strT = str3;
        int i12 = 0;
        String strY = null;
        long jI = C.TIME_UNSET;
        boolean zP = false;
        long jC0 = 0;
        boolean z14 = false;
        int i13 = 0;
        long j15 = 0;
        int iL = 1;
        long jL = C.TIME_UNSET;
        long jI2 = C.TIME_UNSET;
        boolean z15 = false;
        DrmInitData drmInitDataC = null;
        long j16 = 0;
        Object obj = null;
        long j17 = 0;
        boolean z16 = false;
        long j18 = -1;
        String str4 = null;
        String strK = null;
        int i14 = 0;
        long j19 = 0;
        long jM = 0;
        boolean z17 = false;
        c.d dVar2 = null;
        long jZ = 0;
        long j21 = 0;
        ArrayList arrayList7 = arrayList4;
        c.b bVar2 = null;
        while (aVar.a()) {
            String strB = aVar.b();
            if (strB.startsWith("#EXT")) {
                arrayList6.add(strB);
            }
            if (strB.startsWith("#EXT-X-PLAYLIST-TYPE")) {
                String strY2 = y(strB, f34119r, map);
                if ("VOD".equals(strY2)) {
                    i12 = 1;
                } else if ("EVENT".equals(strY2)) {
                    i12 = 2;
                }
            } else if (strB.equals("#EXT-X-I-FRAMES-ONLY")) {
                z17 = true;
            } else if (strB.startsWith("#EXT-X-START")) {
                jI = (long) (i(strB, D) * 1000000.0d);
                zP = p(strB, Z, z12);
            } else if (strB.startsWith("#EXT-X-SERVER-CONTROL")) {
                fVarX = x(strB);
            } else if (strB.startsWith("#EXT-X-PART-INF")) {
                jI2 = (long) (i(strB, f34117p) * 1000000.0d);
            } else if (strB.startsWith("#EXT-X-MAP")) {
                String strY3 = y(strB, L, map);
                String strU2 = u(strB, F, map);
                if (strU2 != null) {
                    String[] strArrT0 = o0.T0(strU2, "@");
                    j18 = Long.parseLong(strArrT0[z12 ? 1 : 0]);
                    if (strArrT0.length > 1) {
                        j16 = Long.parseLong(strArrT0[1]);
                    }
                }
                if (j18 == -1) {
                    j16 = 0;
                }
                String str5 = str4;
                if (strY != null && str5 == null) {
                    throw ParserException.createForMalformedManifest("The encryption IV attribute must be present when an initialization segment is encrypted with METHOD=AES-128.", null);
                }
                dVar2 = new c.d(strY3, j16, j18, strY, str5);
                if (j18 != -1) {
                    j16 += j18;
                }
                str4 = str5;
                j18 = -1;
            } else {
                String str6 = str4;
                if (strB.startsWith("#EXT-X-TARGETDURATION")) {
                    jL = 1000000 * ((long) l(strB, f34115n));
                } else {
                    if (strB.startsWith("#EXT-X-MEDIA-SEQUENCE")) {
                        jM = m(strB, f34126y);
                        str4 = str6;
                        j15 = jM;
                    } else if (strB.startsWith("#EXT-X-VERSION")) {
                        iL = l(strB, f34118q);
                    } else {
                        if (strB.startsWith("#EXT-X-DEFINE")) {
                            String strU3 = u(strB, f34103b0, map);
                            if (strU3 != null) {
                                String str7 = dVar.f34212l.get(strU3);
                                if (str7 != null) {
                                    map.put(strU3, str7);
                                }
                            } else {
                                map.put(y(strB, Q, map), y(strB, f34102a0, map));
                            }
                            arrayList = arrayList7;
                            arrayList2 = arrayList6;
                            str2 = strK;
                            i11 = i12;
                        } else if (strB.startsWith("#EXTINF")) {
                            jZ = z(strB, f34127z);
                            strT = t(strB, A, str3, map);
                        } else {
                            String str8 = str3;
                            if (strB.startsWith("#EXT-X-SKIP")) {
                                int iL2 = l(strB, f34122u);
                                com.google.android.exoplayer2.util.a.g(cVar != null && arrayList3.isEmpty());
                                int i15 = (int) (j15 - ((c) o0.j(cVar)).f34168k);
                                int i16 = iL2 + i15;
                                if (i15 < 0 || i16 > cVar.f34175r.size()) {
                                    throw new DeltaUpdateException();
                                }
                                str3 = str8;
                                String str9 = str6;
                                long j22 = j19;
                                while (i15 < i16) {
                                    c.d dVarB = cVar.f34175r.get(i15);
                                    ArrayList arrayList8 = arrayList7;
                                    ArrayList arrayList9 = arrayList6;
                                    if (j15 != cVar.f34168k) {
                                        dVarB = dVarB.b(j22, (cVar.f34167j - i13) + dVarB.f34190d);
                                    }
                                    arrayList3.add(dVarB);
                                    j22 += dVarB.f34189c;
                                    long j23 = dVarB.f34196k;
                                    if (j23 != -1) {
                                        j16 = dVarB.f34195j + j23;
                                    }
                                    int i17 = dVarB.f34190d;
                                    c.d dVar3 = dVarB.f34188b;
                                    DrmInitData drmInitData2 = dVarB.f34192g;
                                    String str10 = dVarB.f34193h;
                                    String str11 = dVarB.f34194i;
                                    if (str11 == null || !str11.equals(Long.toHexString(jM))) {
                                        str9 = dVarB.f34194i;
                                    }
                                    jM++;
                                    i15++;
                                    cVar = cVar;
                                    obj = drmInitData2;
                                    strY = str10;
                                    j17 = j22;
                                    i16 = i16;
                                    i14 = i17;
                                    dVar2 = dVar3;
                                    arrayList7 = arrayList8;
                                    arrayList6 = arrayList9;
                                }
                                dVar = dVar;
                                cVar = cVar;
                                j19 = j22;
                                str4 = str9;
                            } else {
                                ArrayList arrayList10 = arrayList7;
                                arrayList2 = arrayList6;
                                str3 = str8;
                                if (strB.startsWith("#EXT-X-KEY")) {
                                    String strY4 = y(strB, I, map);
                                    String strT2 = t(strB, J, "identity", map);
                                    if ("NONE".equals(strY4)) {
                                        treeMap.clear();
                                        strU = null;
                                        strY = null;
                                    } else {
                                        strU = u(strB, M, map);
                                        if ("identity".equals(strT2)) {
                                            if ("AES-128".equals(strY4)) {
                                                strY = y(strB, L, map);
                                            }
                                            str4 = strU;
                                        } else {
                                            String str12 = strK;
                                            strK = str12 == null ? k(strY4) : str12;
                                            DrmInitData.SchemeData schemeDataJ = j(strB, strT2, map);
                                            if (schemeDataJ != null) {
                                                treeMap.put(strT2, schemeDataJ);
                                                strY = null;
                                            }
                                            str4 = strU;
                                        }
                                        strY = null;
                                        str4 = strU;
                                    }
                                    obj = strY;
                                    str4 = strU;
                                } else {
                                    String str13 = strK;
                                    if (strB.startsWith("#EXT-X-BYTERANGE")) {
                                        String[] strArrT1 = o0.T0(y(strB, E, map), "@");
                                        j18 = Long.parseLong(strArrT1[0]);
                                        if (strArrT1.length > 1) {
                                            j16 = Long.parseLong(strArrT1[1]);
                                        }
                                    } else if (strB.startsWith("#EXT-X-DISCONTINUITY-SEQUENCE")) {
                                        i13 = Integer.parseInt(strB.substring(strB.indexOf(58) + 1));
                                        dVar = dVar;
                                        cVar = cVar;
                                        strK = str13;
                                        str4 = str6;
                                        arrayList7 = arrayList10;
                                        arrayList6 = arrayList2;
                                        z12 = false;
                                        z14 = true;
                                    } else if (strB.equals("#EXT-X-DISCONTINUITY")) {
                                        i14++;
                                    } else {
                                        if (strB.startsWith("#EXT-X-PROGRAM-DATE-TIME")) {
                                            if (jC0 == 0) {
                                                jC0 = o0.C0(o0.J0(strB.substring(strB.indexOf(58) + 1))) - j19;
                                            } else {
                                                i11 = i12;
                                                str2 = str13;
                                            }
                                        } else if (strB.equals("#EXT-X-GAP")) {
                                            dVar = dVar;
                                            cVar = cVar;
                                            strK = str13;
                                            str4 = str6;
                                            arrayList7 = arrayList10;
                                            arrayList6 = arrayList2;
                                            z12 = false;
                                            z16 = true;
                                        } else if (strB.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                                            dVar = dVar;
                                            cVar = cVar;
                                            strK = str13;
                                            str4 = str6;
                                            arrayList7 = arrayList10;
                                            arrayList6 = arrayList2;
                                            z12 = false;
                                            z13 = true;
                                        } else if (strB.equals("#EXT-X-ENDLIST")) {
                                            dVar = dVar;
                                            cVar = cVar;
                                            strK = str13;
                                            str4 = str6;
                                            arrayList7 = arrayList10;
                                            arrayList6 = arrayList2;
                                            z12 = false;
                                            z15 = true;
                                        } else if (strB.startsWith("#EXT-X-RENDITION-REPORT")) {
                                            i11 = i12;
                                            str2 = str13;
                                            arrayList5.add(new c.C0367c(Uri.parse(m0.d(str, y(strB, L, map))), s(strB, B, -1L), r(strB, C, -1)));
                                        } else {
                                            i11 = i12;
                                            str2 = str13;
                                            if (!strB.startsWith("#EXT-X-PRELOAD-HINT")) {
                                                jM = jM;
                                                if (strB.startsWith("#EXT-X-PART")) {
                                                    String strD = d(jM, strY, str6);
                                                    String strY5 = y(strB, L, map);
                                                    long jI3 = (long) (i(strB, f34116o) * 1000000.0d);
                                                    bVar = bVar2;
                                                    boolean zP2 = p(strB, X, false) | (z13 && arrayList10.isEmpty());
                                                    boolean zP3 = p(strB, Y, false);
                                                    String strU4 = u(strB, F, map);
                                                    if (strU4 != null) {
                                                        String[] strArrT2 = o0.T0(strU4, "@");
                                                        j14 = Long.parseLong(strArrT2[0]);
                                                        if (strArrT2.length > 1) {
                                                            j21 = Long.parseLong(strArrT2[1]);
                                                        }
                                                        j13 = -1;
                                                    } else {
                                                        j13 = -1;
                                                        j14 = -1;
                                                    }
                                                    if (j14 == j13) {
                                                        j21 = 0;
                                                    }
                                                    if (obj == null && !treeMap.isEmpty()) {
                                                        DrmInitData.SchemeData[] schemeDataArr = (DrmInitData.SchemeData[]) treeMap.values().toArray(new DrmInitData.SchemeData[0]);
                                                        DrmInitData drmInitData3 = new DrmInitData(str2, schemeDataArr);
                                                        if (drmInitDataC == null) {
                                                            drmInitDataC = c(str2, schemeDataArr);
                                                        }
                                                        obj = drmInitData3;
                                                    }
                                                    arrayList = arrayList10;
                                                    arrayList.add(new c.b(strY5, dVar2, jI3, i14, j17, obj, strY, strD, j21, j14, zP3, zP2, false));
                                                    j17 += jI3;
                                                    if (j14 != j13) {
                                                        j21 += j14;
                                                    }
                                                } else {
                                                    bVar = bVar2;
                                                    arrayList = arrayList10;
                                                    if (!strB.startsWith(Utils.SEPARATOR)) {
                                                        String strD2 = d(jM, strY, str6);
                                                        long j24 = jM + 1;
                                                        String strA = A(strB, map);
                                                        c.d dVar4 = (c.d) map2.get(strA);
                                                        if (j18 == -1) {
                                                            j11 = 0;
                                                        } else {
                                                            if (z17 && dVar2 == null && dVar4 == null) {
                                                                dVar4 = new c.d(strA, 0L, j16, null, null);
                                                                map2.put(strA, dVar4);
                                                            }
                                                            j11 = j16;
                                                        }
                                                        if (obj != null || treeMap.isEmpty()) {
                                                            j12 = j24;
                                                            drmInitData = obj;
                                                        } else {
                                                            j12 = j24;
                                                            DrmInitData.SchemeData[] schemeDataArr2 = (DrmInitData.SchemeData[]) treeMap.values().toArray(new DrmInitData.SchemeData[0]);
                                                            drmInitData = new DrmInitData(str2, schemeDataArr2);
                                                            if (drmInitDataC == null) {
                                                                drmInitDataC = c(str2, schemeDataArr2);
                                                            }
                                                        }
                                                        arrayList3.add(new c.d(strA, dVar2 != null ? dVar2 : dVar4, strT, jZ, i14, j19, drmInitData, strY, strD2, j11, j18, z16, arrayList));
                                                        j17 = j19 + jZ;
                                                        arrayList7 = new ArrayList();
                                                        if (j18 != -1) {
                                                            j11 += j18;
                                                        }
                                                        j16 = j11;
                                                        dVar = dVar;
                                                        cVar = cVar;
                                                        str4 = str6;
                                                        obj = drmInitData;
                                                        strT = str3;
                                                        j19 = j17;
                                                        i12 = i11;
                                                        bVar2 = bVar;
                                                        arrayList6 = arrayList2;
                                                        z16 = false;
                                                        j18 = -1;
                                                        jZ = 0;
                                                        strK = str2;
                                                        jM = j12;
                                                    }
                                                }
                                                dVar = dVar;
                                                cVar = cVar;
                                                str4 = str6;
                                                i12 = i11;
                                                bVar2 = bVar;
                                                jM = jM;
                                                strK = str2;
                                                arrayList7 = arrayList;
                                                arrayList6 = arrayList2;
                                            } else if (bVar2 == null && "PART".equals(y(strB, O, map))) {
                                                String strY6 = y(strB, L, map);
                                                long jS = s(strB, G, -1L);
                                                long jS2 = s(strB, H, -1L);
                                                long j25 = jM;
                                                String strD3 = d(j25, strY, str6);
                                                if (obj == null && !treeMap.isEmpty()) {
                                                    DrmInitData.SchemeData[] schemeDataArr3 = (DrmInitData.SchemeData[]) treeMap.values().toArray(new DrmInitData.SchemeData[0]);
                                                    DrmInitData drmInitData4 = new DrmInitData(str2, schemeDataArr3);
                                                    if (drmInitDataC == null) {
                                                        drmInitDataC = c(str2, schemeDataArr3);
                                                    }
                                                    obj = drmInitData4;
                                                }
                                                if (jS == -1 || jS2 != -1) {
                                                    bVar2 = new c.b(strY6, dVar2, 0L, i14, j17, obj, strY, strD3, jS != -1 ? jS : 0L, jS2, false, false, true);
                                                }
                                                dVar = dVar;
                                                cVar = cVar;
                                                jM = j25;
                                                str4 = str6;
                                                arrayList7 = arrayList10;
                                                i12 = i11;
                                                arrayList6 = arrayList2;
                                                strK = str2;
                                            }
                                        }
                                        arrayList = arrayList10;
                                    }
                                    strK = str13;
                                    str4 = str6;
                                }
                                arrayList7 = arrayList10;
                                arrayList6 = arrayList2;
                            }
                        }
                        bVar = bVar2;
                        dVar = dVar;
                        cVar = cVar;
                        str4 = str6;
                        i12 = i11;
                        bVar2 = bVar;
                        jM = jM;
                        strK = str2;
                        arrayList7 = arrayList;
                        arrayList6 = arrayList2;
                    }
                    z12 = false;
                }
                str4 = str6;
                z12 = false;
            }
        }
        int i18 = i12;
        c.b bVar3 = bVar2;
        ArrayList arrayList11 = arrayList7;
        ArrayList arrayList12 = arrayList6;
        HashMap map3 = new HashMap();
        for (int i19 = 0; i19 < arrayList5.size(); i19++) {
            c.C0367c c0367c = (c.C0367c) arrayList5.get(i19);
            long size = c0367c.f34183b;
            if (size == -1) {
                size = (j15 + ((long) arrayList3.size())) - (arrayList11.isEmpty() ? 1L : 0L);
            }
            int size2 = c0367c.f34184c;
            if (size2 == -1 && jI2 != C.TIME_UNSET) {
                size2 = (arrayList11.isEmpty() ? ((c.d) e0.g(arrayList3)).f34186n : arrayList11).size() - 1;
            }
            Uri uri = c0367c.f34182a;
            map3.put(uri, new c.C0367c(uri, size, size2));
        }
        if (bVar3 != null) {
            arrayList11.add(bVar3);
        }
        return new c(i18, str, arrayList12, jI, zP, jC0, z14, i13, j15, iL, jL, jI2, z13, z15, jC0 != 0, drmInitDataC, arrayList3, arrayList11, fVarX, map3);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:80:0x0327  */
    public static d o(a aVar, String str) throws IOException {
        ArrayList arrayList;
        String strG;
        int i11;
        String str2;
        String strG2;
        int i12;
        int i13;
        Uri uriE;
        HashMap map;
        int i14;
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = new ArrayList();
        ArrayList arrayList9 = new ArrayList();
        boolean z11 = false;
        boolean z12 = false;
        while (true) {
            boolean zA = aVar.a();
            String str3 = MimeTypes.APPLICATION_M3U8;
            if (!zA) {
                HashMap map4 = map2;
                ArrayList arrayList10 = arrayList7;
                ArrayList arrayList11 = arrayList3;
                ArrayList arrayList12 = arrayList4;
                ArrayList arrayList13 = arrayList5;
                ArrayList arrayList14 = arrayList6;
                ArrayList arrayList15 = arrayList9;
                boolean z13 = z11;
                ArrayList arrayList16 = arrayList8;
                ArrayList arrayList17 = new ArrayList();
                HashSet hashSet = new HashSet();
                for (int i15 = 0; i15 < arrayList2.size(); i15++) {
                    d.b bVar = (d.b) arrayList2.get(i15);
                    if (hashSet.add(bVar.f34218a)) {
                        com.google.android.exoplayer2.util.a.g(bVar.f34219b.f33443k == null);
                        arrayList17.add(bVar.a(bVar.f34219b.b().X(new Metadata(new HlsTrackMetadataEntry(null, null, (List) com.google.android.exoplayer2.util.a.e((ArrayList) map4.get(bVar.f34218a))))).E()));
                    }
                }
                Uri uri = null;
                ArrayList arrayList18 = null;
                m1 m1VarE = null;
                int i16 = 0;
                while (i16 < arrayList10.size()) {
                    ArrayList arrayList19 = arrayList10;
                    String str4 = (String) arrayList19.get(i16);
                    String strY = y(str4, R, map3);
                    String strY2 = y(str4, Q, map3);
                    m1.b bVarV = new m1.b().S(strY + ":" + strY2).U(strY2).K(str3).g0(w(str4)).c0(v(str4, map3)).V(u(str4, P, map3));
                    String strU = u(str4, L, map3);
                    Uri uriE2 = strU == null ? uri : m0.e(str, strU);
                    arrayList10 = arrayList19;
                    String str5 = str3;
                    Metadata metadata = new Metadata(new HlsTrackMetadataEntry(strY, strY2, Collections.emptyList()));
                    String strY3 = y(str4, N, map3);
                    strY3.hashCode();
                    switch (strY3) {
                        case "SUBTITLES":
                            m1VarE = m1VarE;
                            arrayList12 = arrayList12;
                            arrayList = arrayList11;
                            d.b bVarF = f(arrayList2, strY);
                            if (bVarF != null) {
                                String strL = o0.L(bVarF.f34219b.f33442j, 3);
                                bVarV.I(strL);
                                strG = w.g(strL);
                            } else {
                                strG = null;
                            }
                            if (strG == null) {
                                strG = MimeTypes.TEXT_VTT;
                            }
                            bVarV.e0(strG).X(metadata);
                            if (uriE2 != null) {
                                d.a aVar2 = new d.a(uriE2, bVarV.E(), strY, strY2);
                                arrayList13 = arrayList13;
                                arrayList13.add(aVar2);
                                break;
                            } else {
                                arrayList13 = arrayList13;
                                s.i("HlsPlaylistParser", "EXT-X-MEDIA tag with missing mandatory URI attribute: skipping");
                                break;
                            }
                            break;
                        case "CLOSED-CAPTIONS":
                            m1VarE = m1VarE;
                            arrayList12 = arrayList12;
                            arrayList = arrayList11;
                            String strY4 = y(str4, T, map3);
                            if (strY4.startsWith("CC")) {
                                i11 = Integer.parseInt(strY4.substring(2));
                                str2 = MimeTypes.APPLICATION_CEA608;
                            } else {
                                i11 = Integer.parseInt(strY4.substring(7));
                                str2 = MimeTypes.APPLICATION_CEA708;
                            }
                            if (arrayList18 == null) {
                                arrayList18 = new ArrayList();
                            }
                            bVarV.e0(str2).F(i11);
                            arrayList18.add(bVarV.E());
                            arrayList13 = arrayList13;
                            break;
                        case "AUDIO":
                            arrayList = arrayList11;
                            d.b bVarE = e(arrayList2, strY);
                            if (bVarE != null) {
                                String strL2 = o0.L(bVarE.f34219b.f33442j, 1);
                                bVarV.I(strL2);
                                strG2 = w.g(strL2);
                            } else {
                                strG2 = null;
                            }
                            String strU2 = u(str4, f34111j, map3);
                            if (strU2 != null) {
                                bVarV.H(Integer.parseInt(o0.U0(strU2, "/")[0]));
                                if (MimeTypes.AUDIO_E_AC3.equals(strG2) && strU2.endsWith("/JOC")) {
                                    bVarV.I("ec+3");
                                    strG2 = MimeTypes.AUDIO_E_AC3_JOC;
                                }
                            }
                            bVarV.e0(strG2);
                            if (uriE2 != null) {
                                bVarV.X(metadata);
                                arrayList12 = arrayList12;
                                arrayList12.add(new d.a(uriE2, bVarV.E(), strY, strY2));
                            } else {
                                arrayList12 = arrayList12;
                                if (bVarE != null) {
                                    m1VarE = bVarV.E();
                                }
                            }
                            arrayList13 = arrayList13;
                            break;
                        case "VIDEO":
                            d.b bVarG = g(arrayList2, strY);
                            if (bVarG != null) {
                                m1 m1Var = bVarG.f34219b;
                                String strL3 = o0.L(m1Var.f33442j, 2);
                                bVarV.I(strL3).e0(w.g(strL3)).j0(m1Var.f33450r).Q(m1Var.f33451s).P(m1Var.f33452t);
                            }
                            if (uriE2 != null) {
                                bVarV.X(metadata);
                                arrayList = arrayList11;
                                arrayList.add(new d.a(uriE2, bVarV.E(), strY, strY2));
                            }
                        default:
                            arrayList = arrayList11;
                            break;
                    }
                    i16++;
                    arrayList13 = arrayList13;
                    arrayList12 = arrayList12;
                    arrayList11 = arrayList;
                    str3 = str5;
                    m1VarE = m1VarE;
                    uri = null;
                }
                return new d(str, arrayList15, arrayList17, arrayList11, arrayList12, arrayList13, arrayList14, m1VarE, z12 ? Collections.emptyList() : arrayList18, z13, map3, arrayList16);
            }
            String strB = aVar.b();
            if (strB.startsWith("#EXT")) {
                arrayList9.add(strB);
            }
            boolean zStartsWith = strB.startsWith("#EXT-X-I-FRAME-STREAM-INF");
            boolean z14 = z11;
            if (strB.startsWith("#EXT-X-DEFINE")) {
                map3.put(y(strB, Q, map3), y(strB, f34102a0, map3));
            } else {
                if (strB.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                    map = map2;
                    arrayList4 = arrayList4;
                    arrayList5 = arrayList5;
                    z11 = true;
                } else if (strB.startsWith("#EXT-X-MEDIA")) {
                    arrayList7.add(strB);
                } else if (strB.startsWith("#EXT-X-SESSION-KEY")) {
                    DrmInitData.SchemeData schemeDataJ = j(strB, t(strB, J, "identity", map3), map3);
                    if (schemeDataJ != null) {
                        arrayList8.add(new DrmInitData(k(y(strB, I, map3)), schemeDataJ));
                    }
                } else if (strB.startsWith("#EXT-X-STREAM-INF") || zStartsWith) {
                    boolean zContains = z12 | strB.contains("CLOSED-CAPTIONS=NONE");
                    int i17 = zStartsWith ? 16384 : 0;
                    int iL = l(strB, f34110i);
                    int iR = r(strB, f34104c, -1);
                    String strU3 = u(strB, f34112k, map3);
                    String strU4 = u(strB, f34113l, map3);
                    if (strU4 != null) {
                        String[] strArrT0 = o0.T0(strU4, "x");
                        int i18 = Integer.parseInt(strArrT0[0]);
                        int i19 = Integer.parseInt(strArrT0[1]);
                        if (i18 <= 0 || i19 <= 0) {
                            i19 = -1;
                            i14 = -1;
                        } else {
                            i14 = i18;
                        }
                        i13 = i19;
                        i12 = i14;
                    } else {
                        i12 = -1;
                        i13 = -1;
                    }
                    String strU5 = u(strB, f34114m, map3);
                    float f11 = strU5 != null ? Float.parseFloat(strU5) : -1.0f;
                    String strU6 = u(strB, f34106d, map3);
                    String strU7 = u(strB, f34107f, map3);
                    HashMap map5 = map2;
                    String strU8 = u(strB, f34108g, map3);
                    String strU9 = u(strB, f34109h, map3);
                    if (zStartsWith) {
                        uriE = m0.e(str, y(strB, L, map3));
                    } else {
                        if (!aVar.a()) {
                            throw ParserException.createForMalformedManifest("#EXT-X-STREAM-INF must be followed by another line", null);
                        }
                        uriE = m0.e(str, A(aVar.b(), map3));
                    }
                    arrayList2.add(new d.b(uriE, new m1.b().R(arrayList2.size()).K(MimeTypes.APPLICATION_M3U8).I(strU3).G(iR).Z(iL).j0(i12).Q(i13).P(f11).c0(i17).E(), strU6, strU7, strU8, strU9));
                    map = map5;
                    ArrayList arrayList20 = (ArrayList) map.get(uriE);
                    if (arrayList20 == null) {
                        arrayList20 = new ArrayList();
                        map.put(uriE, arrayList20);
                    }
                    arrayList20.add(new HlsTrackMetadataEntry.VariantInfo(iR, iL, strU6, strU7, strU8, strU9));
                    z11 = z14;
                    z12 = zContains;
                }
                map2 = map;
                arrayList8 = arrayList8;
                arrayList6 = arrayList6;
                arrayList9 = arrayList9;
                arrayList5 = arrayList5;
                arrayList4 = arrayList4;
                arrayList3 = arrayList3;
                arrayList7 = arrayList7;
            }
            map = map2;
            arrayList4 = arrayList4;
            arrayList5 = arrayList5;
            z11 = z14;
            map2 = map;
            arrayList8 = arrayList8;
            arrayList6 = arrayList6;
            arrayList9 = arrayList9;
            arrayList5 = arrayList5;
            arrayList4 = arrayList4;
            arrayList3 = arrayList3;
            arrayList7 = arrayList7;
        }
    }

    public static boolean p(String str, Pattern pattern, boolean z11) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? "YES".equals(matcher.group(1)) : z11;
    }

    public static double q(String str, Pattern pattern, double d11) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Double.parseDouble((String) com.google.android.exoplayer2.util.a.e(matcher.group(1))) : d11;
    }

    public static int r(String str, Pattern pattern, int i11) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(matcher.group(1))) : i11;
    }

    public static long s(String str, Pattern pattern, long j11) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Long.parseLong((String) com.google.android.exoplayer2.util.a.e(matcher.group(1))) : j11;
    }

    public static String t(String str, Pattern pattern, String str2, Map<String, String> map) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            str2 = (String) com.google.android.exoplayer2.util.a.e(matcher.group(1));
        }
        return (map.isEmpty() || str2 == null) ? str2 : A(str2, map);
    }

    @Nullable
    public static String u(String str, Pattern pattern, Map<String, String> map) {
        return t(str, pattern, null, map);
    }

    public static int v(String str, Map<String, String> map) {
        String strU = u(str, S, map);
        if (TextUtils.isEmpty(strU)) {
            return 0;
        }
        String[] strArrT0 = o0.T0(strU, ",");
        int i11 = o0.s(strArrT0, "public.accessibility.describes-video") ? 512 : 0;
        if (o0.s(strArrT0, "public.accessibility.transcribes-spoken-dialog")) {
            i11 |= 4096;
        }
        if (o0.s(strArrT0, "public.accessibility.describes-music-and-sound")) {
            i11 |= 1024;
        }
        return o0.s(strArrT0, "public.easy-to-read") ? i11 | 8192 : i11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public static int w(String str) {
        boolean zP = p(str, V, false);
        ?? r11 = zP;
        if (p(str, W, false)) {
            r11 = (zP ? 1 : 0) | 2;
        }
        return p(str, U, false) ? r11 | 4 : r11;
    }

    public static c.f x(String str) {
        double dQ = q(str, f34120s, -9.223372036854776E18d);
        long j11 = C.TIME_UNSET;
        long j12 = dQ == -9.223372036854776E18d ? -9223372036854775807L : (long) (dQ * 1000000.0d);
        boolean zP = p(str, f34121t, false);
        double dQ2 = q(str, f34123v, -9.223372036854776E18d);
        long j13 = dQ2 == -9.223372036854776E18d ? -9223372036854775807L : (long) (dQ2 * 1000000.0d);
        double dQ3 = q(str, f34124w, -9.223372036854776E18d);
        if (dQ3 != -9.223372036854776E18d) {
            j11 = (long) (dQ3 * 1000000.0d);
        }
        return new c.f(j12, zP, j13, j11, p(str, f34125x, false));
    }

    public static String y(String str, Pattern pattern, Map<String, String> map) throws ParserException {
        String strU = u(str, pattern, map);
        if (strU != null) {
            return strU;
        }
        throw ParserException.createForMalformedManifest("Couldn't match " + pattern.pattern() + " in " + str, null);
    }

    public static long z(String str, Pattern pattern) throws ParserException {
        return new BigDecimal(y(str, pattern, Collections.emptyMap())).multiply(new BigDecimal(1000000L)).longValue();
    }

    @Override // com.google.android.exoplayer2.upstream.b0.a
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public e parse(Uri uri, InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ArrayDeque arrayDeque = new ArrayDeque();
        try {
            if (!a(bufferedReader)) {
                throw ParserException.createForMalformedManifest("Input does not start with the #EXTM3U header.", null);
            }
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    o0.n(bufferedReader);
                    throw ParserException.createForMalformedManifest("Failed to parse the playlist, could not identify any tags.", null);
                }
                String strTrim = line.trim();
                if (!strTrim.isEmpty()) {
                    if (strTrim.startsWith("#EXT-X-STREAM-INF")) {
                        arrayDeque.add(strTrim);
                        d dVarO = o(new a(arrayDeque, bufferedReader), uri.toString());
                        o0.n(bufferedReader);
                        return dVarO;
                    }
                    if (!strTrim.startsWith("#EXT-X-TARGETDURATION") && !strTrim.startsWith("#EXT-X-MEDIA-SEQUENCE") && !strTrim.startsWith("#EXTINF") && !strTrim.startsWith("#EXT-X-KEY") && !strTrim.startsWith("#EXT-X-BYTERANGE") && !strTrim.equals("#EXT-X-DISCONTINUITY") && !strTrim.equals("#EXT-X-DISCONTINUITY-SEQUENCE") && !strTrim.equals("#EXT-X-ENDLIST")) {
                        arrayDeque.add(strTrim);
                    }
                    arrayDeque.add(strTrim);
                    c cVarN = n(this.f34128a, this.f34129b, new a(arrayDeque, bufferedReader), uri.toString());
                    o0.n(bufferedReader);
                    return cVarN;
                }
            }
        } catch (Throwable th2) {
            o0.n(bufferedReader);
            throw th2;
        }
    }
}
