package androidx.media3.exoplayer.hls.playlist;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Metadata;
import androidx.media3.common.ParserException;
import androidx.media3.common.f0;
import androidx.media3.common.j;
import androidx.media3.common.y;
import androidx.media3.exoplayer.hls.HlsTrackMetadataEntry;
import androidx.media3.exoplayer.upstream.o;
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
import k4.e;
import l5.l;
import z3.k0;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class HlsPlaylistParser implements o.a<e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f10491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final b f10492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f10467c = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f10469d = Pattern.compile("VIDEO=\"(.+?)\"");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Pattern f10470f = Pattern.compile("AUDIO=\"(.+?)\"");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Pattern f10471g = Pattern.compile("SUBTITLES=\"(.+?)\"");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Pattern f10472h = Pattern.compile("CLOSED-CAPTIONS=\"(.+?)\"");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Pattern f10473i = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Pattern f10474j = Pattern.compile("CHANNELS=\"(.+?)\"");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Pattern f10475k = Pattern.compile("CODECS=\"(.+?)\"");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Pattern f10476l = Pattern.compile("RESOLUTION=(\\d+x\\d+)");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Pattern f10477m = Pattern.compile("FRAME-RATE=([\\d\\.]+)\\b");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Pattern f10478n = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Pattern f10479o = Pattern.compile("DURATION=([\\d\\.]+)\\b");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Pattern f10480p = Pattern.compile("PART-TARGET=([\\d\\.]+)\\b");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Pattern f10481q = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Pattern f10482r = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Pattern f10483s = Pattern.compile("CAN-SKIP-UNTIL=([\\d\\.]+)\\b");

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Pattern f10484t = b("CAN-SKIP-DATERANGES");

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Pattern f10485u = Pattern.compile("SKIPPED-SEGMENTS=(\\d+)\\b");

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Pattern f10486v = Pattern.compile("[:|,]HOLD-BACK=([\\d\\.]+)\\b");

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final Pattern f10487w = Pattern.compile("PART-HOLD-BACK=([\\d\\.]+)\\b");

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Pattern f10488x = b("CAN-BLOCK-RELOAD");

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final Pattern f10489y = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final Pattern f10490z = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
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
    public static final Pattern f10465a0 = Pattern.compile("VALUE=\"(.+?)\"");

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final Pattern f10466b0 = Pattern.compile("IMPORT=\"(.+?)\"");

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final Pattern f10468c0 = Pattern.compile("\\{\\$([a-zA-Z0-9\\-_]+)\\}");

    /* JADX INFO: compiled from: source.java */
    public static final class DeltaUpdateException extends IOException {
    }

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BufferedReader f10493a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Queue<String> f10494b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public String f10495c;

        public a(Queue<String> queue, BufferedReader bufferedReader) {
            this.f10494b = queue;
            this.f10493a = bufferedReader;
        }

        public boolean a() throws IOException {
            String strTrim;
            if (this.f10495c != null) {
                return true;
            }
            if (!this.f10494b.isEmpty()) {
                this.f10495c = (String) z3.a.e(this.f10494b.poll());
                return true;
            }
            do {
                String line = this.f10493a.readLine();
                this.f10495c = line;
                if (line == null) {
                    return false;
                }
                strTrim = line.trim();
                this.f10495c = strTrim;
            } while (strTrim.isEmpty());
            return true;
        }

        public String b() throws IOException {
            if (!a()) {
                throw new NoSuchElementException();
            }
            String str = this.f10495c;
            this.f10495c = null;
            return str;
        }
    }

    public HlsPlaylistParser() {
        this(c.f10566n, null);
    }

    public HlsPlaylistParser(c cVar, @Nullable b bVar) {
        this.f10491a = cVar;
        this.f10492b = bVar;
    }

    public static String A(String str, Map<String, String> map) {
        Matcher matcher = f10468c0.matcher(str);
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
        while (i11 != -1 && Character.isWhitespace(i11) && (z11 || !u0.K0(i11))) {
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
        return u0.K0(B(bufferedReader, false, iB));
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
    public static c.b e(ArrayList<c.b> arrayList, String str) {
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            c.b bVar = arrayList.get(i11);
            if (str.equals(bVar.f10584d)) {
                return bVar;
            }
        }
        return null;
    }

    @Nullable
    public static c.b f(ArrayList<c.b> arrayList, String str) {
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            c.b bVar = arrayList.get(i11);
            if (str.equals(bVar.f10585e)) {
                return bVar;
            }
        }
        return null;
    }

    @Nullable
    public static c.b g(ArrayList<c.b> arrayList, String str) {
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            c.b bVar = arrayList.get(i11);
            if (str.equals(bVar.f10583c)) {
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
            return new DrmInitData.SchemeData(j.f9254d, MimeTypes.VIDEO_MP4, Base64.decode(strY.substring(strY.indexOf(44)), 0));
        }
        if ("com.widevine".equals(str2)) {
            return new DrmInitData.SchemeData(j.f9254d, "hls", u0.w0(str));
        }
        if (!"com.microsoft.playready".equals(str2) || !"1".equals(strT)) {
            return null;
        }
        String strY2 = y(str, L, map);
        byte[] bArrDecode = Base64.decode(strY2.substring(strY2.indexOf(44)), 0);
        UUID uuid = j.f9255e;
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
    public static b n(c cVar, @Nullable b bVar, a aVar, String str) throws IOException {
        ArrayList arrayList;
        ArrayList arrayList2;
        String str2;
        int i11;
        b.C0100b c0100b;
        String strU;
        long j11;
        long j12;
        Object drmInitData;
        long j13;
        long j14;
        cVar = cVar;
        bVar = bVar;
        boolean z11 = cVar.f68241c;
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        b.f fVar = new b.f(C.TIME_UNSET, false, C.TIME_UNSET, C.TIME_UNSET, false);
        TreeMap treeMap = new TreeMap();
        boolean z12 = false;
        String str3 = "";
        boolean z13 = z11;
        b.f fVarX = fVar;
        String strT = str3;
        int i12 = 0;
        String strY = null;
        long jI = C.TIME_UNSET;
        boolean zP = false;
        long jS0 = 0;
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
        b.d dVar = null;
        long jZ = 0;
        long j21 = 0;
        ArrayList arrayList7 = arrayList4;
        b.C0100b c0100b2 = null;
        while (aVar.a()) {
            String strB = aVar.b();
            if (strB.startsWith("#EXT")) {
                arrayList6.add(strB);
            }
            if (strB.startsWith("#EXT-X-PLAYLIST-TYPE")) {
                String strY2 = y(strB, f10482r, map);
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
                jI2 = (long) (i(strB, f10480p) * 1000000.0d);
            } else if (strB.startsWith("#EXT-X-MAP")) {
                String strY3 = y(strB, L, map);
                String strU2 = u(strB, F, map);
                if (strU2 != null) {
                    String[] strArrO1 = u0.o1(strU2, "@");
                    j18 = Long.parseLong(strArrO1[z12 ? 1 : 0]);
                    if (strArrO1.length > 1) {
                        j16 = Long.parseLong(strArrO1[1]);
                    }
                }
                if (j18 == -1) {
                    j16 = 0;
                }
                String str5 = str4;
                if (strY != null && str5 == null) {
                    throw ParserException.createForMalformedManifest("The encryption IV attribute must be present when an initialization segment is encrypted with METHOD=AES-128.", null);
                }
                dVar = new b.d(strY3, j16, j18, strY, str5);
                if (j18 != -1) {
                    j16 += j18;
                }
                str4 = str5;
                j18 = -1;
            } else {
                String str6 = str4;
                if (strB.startsWith("#EXT-X-TARGETDURATION")) {
                    jL = 1000000 * ((long) l(strB, f10478n));
                } else {
                    if (strB.startsWith("#EXT-X-MEDIA-SEQUENCE")) {
                        jM = m(strB, f10489y);
                        str4 = str6;
                        j15 = jM;
                    } else if (strB.startsWith("#EXT-X-VERSION")) {
                        iL = l(strB, f10481q);
                    } else {
                        if (strB.startsWith("#EXT-X-DEFINE")) {
                            String strU3 = u(strB, f10466b0, map);
                            if (strU3 != null) {
                                String str7 = cVar.f10575l.get(strU3);
                                if (str7 != null) {
                                    map.put(strU3, str7);
                                }
                            } else {
                                map.put(y(strB, Q, map), y(strB, f10465a0, map));
                            }
                            arrayList = arrayList7;
                            arrayList2 = arrayList6;
                            str2 = strK;
                            i11 = i12;
                        } else if (strB.startsWith("#EXTINF")) {
                            jZ = z(strB, f10490z);
                            strT = t(strB, A, str3, map);
                        } else {
                            String str8 = str3;
                            if (strB.startsWith("#EXT-X-SKIP")) {
                                int iL2 = l(strB, f10485u);
                                z3.a.g(bVar != null && arrayList3.isEmpty());
                                int i15 = (int) (j15 - ((b) u0.i(bVar)).f10531k);
                                int i16 = iL2 + i15;
                                if (i15 < 0 || i16 > bVar.f10538r.size()) {
                                    throw new DeltaUpdateException();
                                }
                                str3 = str8;
                                String str9 = str6;
                                long j22 = j19;
                                while (i15 < i16) {
                                    b.d dVarB = bVar.f10538r.get(i15);
                                    ArrayList arrayList8 = arrayList7;
                                    ArrayList arrayList9 = arrayList6;
                                    if (j15 != bVar.f10531k) {
                                        dVarB = dVarB.b(j22, (bVar.f10530j - i13) + dVarB.f10553d);
                                    }
                                    arrayList3.add(dVarB);
                                    j22 += dVarB.f10552c;
                                    long j23 = dVarB.f10559k;
                                    if (j23 != -1) {
                                        j16 = dVarB.f10558j + j23;
                                    }
                                    int i17 = dVarB.f10553d;
                                    b.d dVar2 = dVarB.f10551b;
                                    DrmInitData drmInitData2 = dVarB.f10555g;
                                    String str10 = dVarB.f10556h;
                                    String str11 = dVarB.f10557i;
                                    if (str11 == null || !str11.equals(Long.toHexString(jM))) {
                                        str9 = dVarB.f10557i;
                                    }
                                    jM++;
                                    i15++;
                                    bVar = bVar;
                                    obj = drmInitData2;
                                    strY = str10;
                                    j17 = j22;
                                    i16 = i16;
                                    i14 = i17;
                                    dVar = dVar2;
                                    arrayList7 = arrayList8;
                                    arrayList6 = arrayList9;
                                }
                                cVar = cVar;
                                bVar = bVar;
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
                                        String[] strArrO2 = u0.o1(y(strB, E, map), "@");
                                        j18 = Long.parseLong(strArrO2[0]);
                                        if (strArrO2.length > 1) {
                                            j16 = Long.parseLong(strArrO2[1]);
                                        }
                                    } else if (strB.startsWith("#EXT-X-DISCONTINUITY-SEQUENCE")) {
                                        i13 = Integer.parseInt(strB.substring(strB.indexOf(58) + 1));
                                        cVar = cVar;
                                        bVar = bVar;
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
                                            if (jS0 == 0) {
                                                jS0 = u0.S0(u0.Z0(strB.substring(strB.indexOf(58) + 1))) - j19;
                                            } else {
                                                i11 = i12;
                                                str2 = str13;
                                            }
                                        } else if (strB.equals("#EXT-X-GAP")) {
                                            cVar = cVar;
                                            bVar = bVar;
                                            strK = str13;
                                            str4 = str6;
                                            arrayList7 = arrayList10;
                                            arrayList6 = arrayList2;
                                            z12 = false;
                                            z16 = true;
                                        } else if (strB.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                                            cVar = cVar;
                                            bVar = bVar;
                                            strK = str13;
                                            str4 = str6;
                                            arrayList7 = arrayList10;
                                            arrayList6 = arrayList2;
                                            z12 = false;
                                            z13 = true;
                                        } else if (strB.equals("#EXT-X-ENDLIST")) {
                                            cVar = cVar;
                                            bVar = bVar;
                                            strK = str13;
                                            str4 = str6;
                                            arrayList7 = arrayList10;
                                            arrayList6 = arrayList2;
                                            z12 = false;
                                            z15 = true;
                                        } else if (strB.startsWith("#EXT-X-RENDITION-REPORT")) {
                                            i11 = i12;
                                            str2 = str13;
                                            arrayList5.add(new b.c(Uri.parse(k0.e(str, y(strB, L, map))), s(strB, B, -1L), r(strB, C, -1)));
                                        } else {
                                            i11 = i12;
                                            str2 = str13;
                                            if (!strB.startsWith("#EXT-X-PRELOAD-HINT")) {
                                                jM = jM;
                                                if (strB.startsWith("#EXT-X-PART")) {
                                                    String strD = d(jM, strY, str6);
                                                    String strY5 = y(strB, L, map);
                                                    long jI3 = (long) (i(strB, f10479o) * 1000000.0d);
                                                    c0100b = c0100b2;
                                                    boolean zP2 = p(strB, X, false) | (z13 && arrayList10.isEmpty());
                                                    boolean zP3 = p(strB, Y, false);
                                                    String strU4 = u(strB, F, map);
                                                    if (strU4 != null) {
                                                        String[] strArrO3 = u0.o1(strU4, "@");
                                                        j14 = Long.parseLong(strArrO3[0]);
                                                        if (strArrO3.length > 1) {
                                                            j21 = Long.parseLong(strArrO3[1]);
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
                                                    arrayList.add(new b.C0100b(strY5, dVar, jI3, i14, j17, obj, strY, strD, j21, j14, zP3, zP2, false));
                                                    j17 += jI3;
                                                    if (j14 != j13) {
                                                        j21 += j14;
                                                    }
                                                } else {
                                                    c0100b = c0100b2;
                                                    arrayList = arrayList10;
                                                    if (!strB.startsWith(Utils.SEPARATOR)) {
                                                        String strD2 = d(jM, strY, str6);
                                                        long j24 = jM + 1;
                                                        String strA = A(strB, map);
                                                        b.d dVar3 = (b.d) map2.get(strA);
                                                        if (j18 == -1) {
                                                            j11 = 0;
                                                        } else {
                                                            if (z17 && dVar == null && dVar3 == null) {
                                                                dVar3 = new b.d(strA, 0L, j16, null, null);
                                                                map2.put(strA, dVar3);
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
                                                        arrayList3.add(new b.d(strA, dVar != null ? dVar : dVar3, strT, jZ, i14, j19, drmInitData, strY, strD2, j11, j18, z16, arrayList));
                                                        j17 = j19 + jZ;
                                                        arrayList7 = new ArrayList();
                                                        if (j18 != -1) {
                                                            j11 += j18;
                                                        }
                                                        j16 = j11;
                                                        cVar = cVar;
                                                        bVar = bVar;
                                                        str4 = str6;
                                                        obj = drmInitData;
                                                        strT = str3;
                                                        j19 = j17;
                                                        i12 = i11;
                                                        c0100b2 = c0100b;
                                                        arrayList6 = arrayList2;
                                                        z16 = false;
                                                        j18 = -1;
                                                        jZ = 0;
                                                        strK = str2;
                                                        jM = j12;
                                                    }
                                                }
                                                cVar = cVar;
                                                bVar = bVar;
                                                str4 = str6;
                                                i12 = i11;
                                                c0100b2 = c0100b;
                                                jM = jM;
                                                strK = str2;
                                                arrayList7 = arrayList;
                                                arrayList6 = arrayList2;
                                            } else if (c0100b2 == null && "PART".equals(y(strB, O, map))) {
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
                                                    c0100b2 = new b.C0100b(strY6, dVar, 0L, i14, j17, obj, strY, strD3, jS != -1 ? jS : 0L, jS2, false, false, true);
                                                }
                                                cVar = cVar;
                                                bVar = bVar;
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
                        c0100b = c0100b2;
                        cVar = cVar;
                        bVar = bVar;
                        str4 = str6;
                        i12 = i11;
                        c0100b2 = c0100b;
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
        b.C0100b c0100b3 = c0100b2;
        ArrayList arrayList11 = arrayList7;
        ArrayList arrayList12 = arrayList6;
        HashMap map3 = new HashMap();
        for (int i19 = 0; i19 < arrayList5.size(); i19++) {
            b.c cVar2 = (b.c) arrayList5.get(i19);
            long size = cVar2.f10546b;
            if (size == -1) {
                size = (j15 + ((long) arrayList3.size())) - (arrayList11.isEmpty() ? 1L : 0L);
            }
            int size2 = cVar2.f10547c;
            if (size2 == -1 && jI2 != C.TIME_UNSET) {
                size2 = (arrayList11.isEmpty() ? ((b.d) e0.g(arrayList3)).f10549n : arrayList11).size() - 1;
            }
            Uri uri = cVar2.f10545a;
            map3.put(uri, new b.c(uri, size, size2));
        }
        if (c0100b3 != null) {
            arrayList11.add(c0100b3);
        }
        return new b(i18, str, arrayList12, jI, zP, jS0, z14, i13, j15, iL, jL, jI2, z13, z15, jS0 != 0, drmInitDataC, arrayList3, arrayList11, fVarX, map3);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:80:0x0327  */
    public static c o(a aVar, String str) throws IOException {
        ArrayList arrayList;
        String strG;
        int i11;
        String str2;
        String strG2;
        int i12;
        int i13;
        Uri uriF;
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
                    c.b bVar = (c.b) arrayList2.get(i15);
                    if (hashSet.add(bVar.f10581a)) {
                        z3.a.g(bVar.f10582b.f9499k == null);
                        arrayList17.add(bVar.a(bVar.f10582b.b().d0(new Metadata(new HlsTrackMetadataEntry(null, null, (List) z3.a.e((ArrayList) map4.get(bVar.f10581a))))).I()));
                    }
                }
                Uri uri = null;
                ArrayList arrayList18 = null;
                y yVarI = null;
                int i16 = 0;
                while (i16 < arrayList10.size()) {
                    ArrayList arrayList19 = arrayList10;
                    String str4 = (String) arrayList19.get(i16);
                    String strY = y(str4, R, map3);
                    String strY2 = y(str4, Q, map3);
                    y.b bVarB0 = new y.b().X(strY + ":" + strY2).Z(strY2).O(str3).m0(w(str4)).i0(v(str4, map3)).b0(u(str4, P, map3));
                    String strU = u(str4, L, map3);
                    Uri uriF2 = strU == null ? uri : k0.f(str, strU);
                    arrayList10 = arrayList19;
                    String str5 = str3;
                    Metadata metadata = new Metadata(new HlsTrackMetadataEntry(strY, strY2, Collections.emptyList()));
                    String strY3 = y(str4, N, map3);
                    strY3.hashCode();
                    switch (strY3) {
                        case "SUBTITLES":
                            yVarI = yVarI;
                            arrayList12 = arrayList12;
                            arrayList = arrayList11;
                            c.b bVarF = f(arrayList2, strY);
                            if (bVarF != null) {
                                String strQ = u0.Q(bVarF.f10582b.f9498j, 3);
                                bVarB0.M(strQ);
                                strG = f0.g(strQ);
                            } else {
                                strG = null;
                            }
                            if (strG == null) {
                                strG = MimeTypes.TEXT_VTT;
                            }
                            bVarB0.k0(strG).d0(metadata);
                            if (uriF2 != null) {
                                c.a aVar2 = new c.a(uriF2, bVarB0.I(), strY, strY2);
                                arrayList13 = arrayList13;
                                arrayList13.add(aVar2);
                                break;
                            } else {
                                arrayList13 = arrayList13;
                                z3.o.h("HlsPlaylistParser", "EXT-X-MEDIA tag with missing mandatory URI attribute: skipping");
                                break;
                            }
                            break;
                        case "CLOSED-CAPTIONS":
                            yVarI = yVarI;
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
                            bVarB0.k0(str2).J(i11);
                            arrayList18.add(bVarB0.I());
                            arrayList13 = arrayList13;
                            break;
                        case "AUDIO":
                            arrayList = arrayList11;
                            c.b bVarE = e(arrayList2, strY);
                            if (bVarE != null) {
                                String strQ2 = u0.Q(bVarE.f10582b.f9498j, 1);
                                bVarB0.M(strQ2);
                                strG2 = f0.g(strQ2);
                            } else {
                                strG2 = null;
                            }
                            String strU2 = u(str4, f10474j, map3);
                            if (strU2 != null) {
                                bVarB0.L(Integer.parseInt(u0.p1(strU2, "/")[0]));
                                if (MimeTypes.AUDIO_E_AC3.equals(strG2) && strU2.endsWith("/JOC")) {
                                    bVarB0.M("ec+3");
                                    strG2 = MimeTypes.AUDIO_E_AC3_JOC;
                                }
                            }
                            bVarB0.k0(strG2);
                            if (uriF2 != null) {
                                bVarB0.d0(metadata);
                                arrayList12 = arrayList12;
                                arrayList12.add(new c.a(uriF2, bVarB0.I(), strY, strY2));
                            } else {
                                arrayList12 = arrayList12;
                                if (bVarE != null) {
                                    yVarI = bVarB0.I();
                                }
                            }
                            arrayList13 = arrayList13;
                            break;
                        case "VIDEO":
                            c.b bVarG = g(arrayList2, strY);
                            if (bVarG != null) {
                                y yVar = bVarG.f10582b;
                                String strQ3 = u0.Q(yVar.f9498j, 2);
                                bVarB0.M(strQ3).k0(f0.g(strQ3)).r0(yVar.f9506r).V(yVar.f9507s).U(yVar.f9508t);
                            }
                            if (uriF2 != null) {
                                bVarB0.d0(metadata);
                                arrayList = arrayList11;
                                arrayList.add(new c.a(uriF2, bVarB0.I(), strY, strY2));
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
                    yVarI = yVarI;
                    uri = null;
                }
                return new c(str, arrayList15, arrayList17, arrayList11, arrayList12, arrayList13, arrayList14, yVarI, z12 ? Collections.emptyList() : arrayList18, z13, map3, arrayList16);
            }
            String strB = aVar.b();
            if (strB.startsWith("#EXT")) {
                arrayList9.add(strB);
            }
            boolean zStartsWith = strB.startsWith("#EXT-X-I-FRAME-STREAM-INF");
            boolean z14 = z11;
            if (strB.startsWith("#EXT-X-DEFINE")) {
                map3.put(y(strB, Q, map3), y(strB, f10465a0, map3));
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
                    int iL = l(strB, f10473i);
                    int iR = r(strB, f10467c, -1);
                    String strU3 = u(strB, f10475k, map3);
                    String strU4 = u(strB, f10476l, map3);
                    if (strU4 != null) {
                        String[] strArrO1 = u0.o1(strU4, "x");
                        int i18 = Integer.parseInt(strArrO1[0]);
                        int i19 = Integer.parseInt(strArrO1[1]);
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
                    String strU5 = u(strB, f10477m, map3);
                    float f11 = strU5 != null ? Float.parseFloat(strU5) : -1.0f;
                    String strU6 = u(strB, f10469d, map3);
                    String strU7 = u(strB, f10470f, map3);
                    HashMap map5 = map2;
                    String strU8 = u(strB, f10471g, map3);
                    String strU9 = u(strB, f10472h, map3);
                    if (zStartsWith) {
                        uriF = k0.f(str, y(strB, L, map3));
                    } else {
                        if (!aVar.a()) {
                            throw ParserException.createForMalformedManifest("#EXT-X-STREAM-INF must be followed by another line", null);
                        }
                        uriF = k0.f(str, A(aVar.b(), map3));
                    }
                    arrayList2.add(new c.b(uriF, new y.b().W(arrayList2.size()).O(MimeTypes.APPLICATION_M3U8).M(strU3).K(iR).f0(iL).r0(i12).V(i13).U(f11).i0(i17).I(), strU6, strU7, strU8, strU9));
                    map = map5;
                    ArrayList arrayList20 = (ArrayList) map.get(uriF);
                    if (arrayList20 == null) {
                        arrayList20 = new ArrayList();
                        map.put(uriF, arrayList20);
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
        return matcher.find() ? Double.parseDouble((String) z3.a.e(matcher.group(1))) : d11;
    }

    public static int r(String str, Pattern pattern, int i11) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Integer.parseInt((String) z3.a.e(matcher.group(1))) : i11;
    }

    public static long s(String str, Pattern pattern, long j11) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Long.parseLong((String) z3.a.e(matcher.group(1))) : j11;
    }

    public static String t(String str, Pattern pattern, String str2, Map<String, String> map) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            str2 = (String) z3.a.e(matcher.group(1));
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
        String[] strArrO1 = u0.o1(strU, ",");
        int i11 = u0.s(strArrO1, "public.accessibility.describes-video") ? 512 : 0;
        if (u0.s(strArrO1, "public.accessibility.transcribes-spoken-dialog")) {
            i11 |= 4096;
        }
        if (u0.s(strArrO1, "public.accessibility.describes-music-and-sound")) {
            i11 |= 1024;
        }
        return u0.s(strArrO1, "public.easy-to-read") ? i11 | 8192 : i11;
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

    public static b.f x(String str) {
        double dQ = q(str, f10483s, -9.223372036854776E18d);
        long j11 = C.TIME_UNSET;
        long j12 = dQ == -9.223372036854776E18d ? -9223372036854775807L : (long) (dQ * 1000000.0d);
        boolean zP = p(str, f10484t, false);
        double dQ2 = q(str, f10486v, -9.223372036854776E18d);
        long j13 = dQ2 == -9.223372036854776E18d ? -9223372036854775807L : (long) (dQ2 * 1000000.0d);
        double dQ3 = q(str, f10487w, -9.223372036854776E18d);
        if (dQ3 != -9.223372036854776E18d) {
            j11 = (long) (dQ3 * 1000000.0d);
        }
        return new b.f(j12, zP, j13, j11, p(str, f10488x, false));
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

    @Override // androidx.media3.exoplayer.upstream.o.a
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
                    u0.m(bufferedReader);
                    throw ParserException.createForMalformedManifest("Failed to parse the playlist, could not identify any tags.", null);
                }
                String strTrim = line.trim();
                if (!strTrim.isEmpty()) {
                    if (strTrim.startsWith("#EXT-X-STREAM-INF")) {
                        arrayDeque.add(strTrim);
                        c cVarO = o(new a(arrayDeque, bufferedReader), uri.toString());
                        u0.m(bufferedReader);
                        return cVarO;
                    }
                    if (!strTrim.startsWith("#EXT-X-TARGETDURATION") && !strTrim.startsWith("#EXT-X-MEDIA-SEQUENCE") && !strTrim.startsWith("#EXTINF") && !strTrim.startsWith("#EXT-X-KEY") && !strTrim.startsWith("#EXT-X-BYTERANGE") && !strTrim.equals("#EXT-X-DISCONTINUITY") && !strTrim.equals("#EXT-X-DISCONTINUITY-SEQUENCE") && !strTrim.equals("#EXT-X-ENDLIST")) {
                        arrayDeque.add(strTrim);
                    }
                    arrayDeque.add(strTrim);
                    b bVarN = n(this.f10491a, this.f10492b, new a(arrayDeque, bufferedReader), uri.toString());
                    u0.m(bufferedReader);
                    return bVarN;
                }
            }
        } catch (Throwable th2) {
            u0.m(bufferedReader);
            throw th2;
        }
    }
}
