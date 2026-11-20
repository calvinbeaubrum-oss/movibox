package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.o0;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.g1;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import com.transsion.home.p003enum.BottomTabType;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f34632a = Pattern.compile("([A-Z_]+) (.*) RTSP/1\\.0");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f34633b = Pattern.compile("RTSP/1\\.0 (\\d+) (.+)");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f34634c = Pattern.compile("Content-Length:\\s?(\\d+)", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f34635d = Pattern.compile("([\\w$\\-_.+]+)(?:;\\s?timeout=(\\d+))?");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Pattern f34636e = Pattern.compile("Digest realm=\"([^\"\\x00-\\x08\\x0A-\\x1f\\x7f]+)\",\\s?(?:domain=\"(.+)\",\\s?)?nonce=\"([^\"\\x00-\\x08\\x0A-\\x1f\\x7f]+)\"(?:,\\s?opaque=\"([^\"\\x00-\\x08\\x0A-\\x1f\\x7f]+)\")?");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Pattern f34637f = Pattern.compile("Basic realm=\"([^\"\\x00-\\x08\\x0A-\\x1f\\x7f]+)\"");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f34638g = new String(new byte[]{10});

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f34639h = new String(new byte[]{Ascii.CR, 10});

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f34640a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f34641b;

        public a(String str, String str2) {
            this.f34640a = str;
            this.f34641b = str2;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f34642a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f34643b;

        public b(String str, long j11) {
            this.f34642a = str;
            this.f34643b = j11;
        }
    }

    public static void a(boolean z11, @Nullable String str) throws ParserException {
        if (!z11) {
            throw ParserException.createForMalformedManifest(str, null);
        }
    }

    public static byte[] b(List<String> list) {
        return com.google.common.base.g.h(f34639h).d(list).getBytes(u.f34609h);
    }

    public static String c(int i11) {
        if (i11 == 200) {
            return "OK";
        }
        if (i11 == 461) {
            return "Unsupported Transport";
        }
        if (i11 == 500) {
            return "Internal Server Error";
        }
        if (i11 == 505) {
            return "RTSP Version Not Supported";
        }
        if (i11 == 301) {
            return "Move Permanently";
        }
        if (i11 == 302) {
            return "Move Temporarily";
        }
        if (i11 == 400) {
            return "Bad Request";
        }
        if (i11 == 401) {
            return "Unauthorized";
        }
        if (i11 == 404) {
            return "Not Found";
        }
        if (i11 == 405) {
            return "Method Not Allowed";
        }
        switch (i11) {
            case 454:
                return "Session Not Found";
            case 455:
                return "Method Not Valid In This State";
            case 456:
                return "Header Field Not Valid";
            case 457:
                return "Invalid Range";
            default:
                throw new IllegalArgumentException();
        }
    }

    public static byte[] d(String str) {
        return str.getBytes(u.f34609h);
    }

    public static boolean e(List<String> list) {
        return f34633b.matcher(list.get(0)).matches();
    }

    public static boolean f(String str) {
        return f34632a.matcher(str).matches() || f34633b.matcher(str).matches();
    }

    public static long g(String str) throws ParserException {
        try {
            Matcher matcher = f34634c.matcher(str);
            if (matcher.find()) {
                return Long.parseLong((String) com.google.android.exoplayer2.util.a.e(matcher.group(1)));
            }
            return -1L;
        } catch (NumberFormatException e11) {
            throw ParserException.createForMalformedManifest(str, e11);
        }
    }

    public static int h(String str) throws ParserException {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e11) {
            throw ParserException.createForMalformedManifest(str, e11);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static int i(String str) {
        str.hashCode();
        byte b11 = -1;
        switch (str.hashCode()) {
            case -1881579439:
                if (str.equals("RECORD")) {
                    b11 = 0;
                }
                break;
            case -880847356:
                if (str.equals("TEARDOWN")) {
                    b11 = 1;
                }
                break;
            case -702888512:
                if (str.equals("GET_PARAMETER")) {
                    b11 = 2;
                }
                break;
            case -531492226:
                if (str.equals("OPTIONS")) {
                    b11 = 3;
                }
                break;
            case -84360524:
                if (str.equals("PLAY_NOTIFY")) {
                    b11 = 4;
                }
                break;
            case 2458420:
                if (str.equals("PLAY")) {
                    b11 = 5;
                }
                break;
            case 6481884:
                if (str.equals(BottomTabType.TAB_OPEN_TYPE_TAB)) {
                    b11 = 6;
                }
                break;
            case 71242700:
                if (str.equals("SET_PARAMETER")) {
                    b11 = 7;
                }
                break;
            case 75902422:
                if (str.equals("PAUSE")) {
                    b11 = 8;
                }
                break;
            case 78791261:
                if (str.equals("SETUP")) {
                    b11 = 9;
                }
                break;
            case 133006441:
                if (str.equals("ANNOUNCE")) {
                    b11 = 10;
                }
                break;
            case 1800840907:
                if (str.equals("DESCRIBE")) {
                    b11 = Ascii.VT;
                }
                break;
        }
        switch (b11) {
            case 0:
                return 8;
            case 1:
                return 12;
            case 2:
                return 3;
            case 3:
                return 4;
            case 4:
                return 7;
            case 5:
                return 6;
            case 6:
                return 9;
            case 7:
                return 11;
            case 8:
                return 5;
            case 9:
                return 10;
            case 10:
                return 1;
            case 11:
                return 2;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static ImmutableList<Integer> j(@Nullable String str) {
        if (str == null) {
            return ImmutableList.of();
        }
        ImmutableList.a aVar = new ImmutableList.a();
        for (String str2 : o0.T0(str, ",\\s?")) {
            aVar.a(Integer.valueOf(i(str2)));
        }
        return aVar.m();
    }

    public static b0 k(List<String> list) {
        Matcher matcher = f34632a.matcher(list.get(0));
        com.google.android.exoplayer2.util.a.a(matcher.matches());
        int i11 = i((String) com.google.android.exoplayer2.util.a.e(matcher.group(1)));
        Uri uri = Uri.parse((String) com.google.android.exoplayer2.util.a.e(matcher.group(2)));
        int iIndexOf = list.indexOf("");
        com.google.android.exoplayer2.util.a.a(iIndexOf > 0);
        return new b0(uri, i11, new o.b().c(list.subList(1, iIndexOf)).e(), com.google.common.base.g.h(f34639h).d(list.subList(iIndexOf + 1, list.size())));
    }

    public static c0 l(List<String> list) {
        Matcher matcher = f34633b.matcher(list.get(0));
        com.google.android.exoplayer2.util.a.a(matcher.matches());
        int i11 = Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(matcher.group(1)));
        int iIndexOf = list.indexOf("");
        com.google.android.exoplayer2.util.a.a(iIndexOf > 0);
        return new c0(i11, new o.b().c(list.subList(1, iIndexOf)).e(), com.google.common.base.g.h(f34639h).d(list.subList(iIndexOf + 1, list.size())));
    }

    public static b m(String str) throws ParserException {
        long j11;
        Matcher matcher = f34635d.matcher(str);
        if (!matcher.matches()) {
            throw ParserException.createForMalformedManifest(str, null);
        }
        String str2 = (String) com.google.android.exoplayer2.util.a.e(matcher.group(1));
        String strGroup = matcher.group(2);
        if (strGroup != null) {
            try {
                j11 = ((long) Integer.parseInt(strGroup)) * 1000;
            } catch (NumberFormatException e11) {
                throw ParserException.createForMalformedManifest(str, e11);
            }
        } else {
            j11 = ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS;
        }
        return new b(str2, j11);
    }

    @Nullable
    public static a n(Uri uri) {
        String userInfo = uri.getUserInfo();
        if (userInfo == null || !userInfo.contains(":")) {
            return null;
        }
        String[] strArrU0 = o0.U0(userInfo, ":");
        return new a(strArrU0[0], strArrU0[1]);
    }

    public static l o(String str) throws ParserException {
        Matcher matcher = f34636e.matcher(str);
        if (matcher.find()) {
            return new l(2, (String) com.google.android.exoplayer2.util.a.e(matcher.group(1)), (String) com.google.android.exoplayer2.util.a.e(matcher.group(3)), com.google.common.base.p.e(matcher.group(4)));
        }
        Matcher matcher2 = f34637f.matcher(str);
        if (matcher2.matches()) {
            return new l(1, (String) com.google.android.exoplayer2.util.a.e(matcher2.group(1)), "", "");
        }
        throw ParserException.createForMalformedManifest("Invalid WWW-Authenticate header " + str, null);
    }

    public static Uri p(Uri uri) {
        if (uri.getUserInfo() == null) {
            return uri;
        }
        String str = (String) com.google.android.exoplayer2.util.a.e(uri.getAuthority());
        com.google.android.exoplayer2.util.a.a(str.contains("@"));
        return uri.buildUpon().encodedAuthority(o0.T0(str, "@")[1]).build();
    }

    public static ImmutableList<String> q(b0 b0Var) {
        com.google.android.exoplayer2.util.a.a(b0Var.f34452c.d("CSeq") != null);
        ImmutableList.a aVar = new ImmutableList.a();
        aVar.a(o0.C("%s %s %s", t(b0Var.f34451b), b0Var.f34450a, "RTSP/1.0"));
        ImmutableListMultimap<String, String> immutableListMultimapB = b0Var.f34452c.b();
        g1<String> it = immutableListMultimapB.keySet().iterator();
        while (it.hasNext()) {
            String next = it.next();
            ImmutableList<String> immutableList = immutableListMultimapB.get(next);
            for (int i11 = 0; i11 < immutableList.size(); i11++) {
                aVar.a(o0.C("%s: %s", next, immutableList.get(i11)));
            }
        }
        aVar.a("");
        aVar.a(b0Var.f34453d);
        return aVar.m();
    }

    public static ImmutableList<String> r(c0 c0Var) {
        com.google.android.exoplayer2.util.a.a(c0Var.f34455b.d("CSeq") != null);
        ImmutableList.a aVar = new ImmutableList.a();
        aVar.a(o0.C("%s %s %s", "RTSP/1.0", Integer.valueOf(c0Var.f34454a), c(c0Var.f34454a)));
        ImmutableListMultimap<String, String> immutableListMultimapB = c0Var.f34455b.b();
        g1<String> it = immutableListMultimapB.keySet().iterator();
        while (it.hasNext()) {
            String next = it.next();
            ImmutableList<String> immutableList = immutableListMultimapB.get(next);
            for (int i11 = 0; i11 < immutableList.size(); i11++) {
                aVar.a(o0.C("%s: %s", next, immutableList.get(i11)));
            }
        }
        aVar.a("");
        aVar.a(c0Var.f34456c);
        return aVar.m();
    }

    public static String[] s(String str) {
        String str2 = f34639h;
        if (!str.contains(str2)) {
            str2 = f34638g;
        }
        return o0.T0(str, str2);
    }

    public static String t(int i11) {
        switch (i11) {
            case 1:
                return "ANNOUNCE";
            case 2:
                return "DESCRIBE";
            case 3:
                return "GET_PARAMETER";
            case 4:
                return "OPTIONS";
            case 5:
                return "PAUSE";
            case 6:
                return "PLAY";
            case 7:
                return "PLAY_NOTIFY";
            case 8:
                return "RECORD";
            case 9:
                return BottomTabType.TAB_OPEN_TYPE_TAB;
            case 10:
                return "SETUP";
            case 11:
                return "SET_PARAMETER";
            case 12:
                return "TEARDOWN";
            default:
                throw new IllegalStateException();
        }
    }
}
