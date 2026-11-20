package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.os.Handler;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import androidx.core.view.MotionEventCompat;
import androidx.media3.container.MdtaMetadataEntry;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.AdError;
import com.google.android.exoplayer2.util.o0;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.fido.u2f.api.common.RegisterRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.gslb.Worker;
import com.transsion.home.p003enum.BottomTabType;
import com.transsion.search.bean.HotRankItem;
import com.vungle.warren.error.VungleException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.internal.ws.WebSocketProtocol;
import okio.Utf8;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class q implements e, k0 {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final ImmutableList<Long> f35451p = ImmutableList.of(4800000L, 3100000L, 2100000L, 1500000L, 800000L);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final ImmutableList<Long> f35452q = ImmutableList.of(1500000L, 1000000L, 730000L, 440000L, 170000L);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final ImmutableList<Long> f35453r = ImmutableList.of(2200000L, 1400000L, 1100000L, 910000L, 620000L);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final ImmutableList<Long> f35454s = ImmutableList.of(3000000L, 1900000L, 1400000L, 1000000L, 660000L);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final ImmutableList<Long> f35455t = ImmutableList.of(6000000L, 4100000L, 3200000L, 1800000L, 1000000L);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final ImmutableList<Long> f35456u = ImmutableList.of(2800000L, 2400000L, 1600000L, 1100000L, 950000L);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Nullable
    public static q f35457v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImmutableMap<Integer, Long> f35458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e.a.C0373a f35459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h0 f35460c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.e f35461d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f35462e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f35463f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f35464g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f35465h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f35466i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f35467j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f35468k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f35469l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f35470m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f35471n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f35472o;

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final Context f35473a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map<Integer, Long> f35474b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f35475c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public com.google.android.exoplayer2.util.e f35476d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f35477e;

        public b(Context context) {
            this.f35473a = context == null ? null : context.getApplicationContext();
            this.f35474b = b(o0.N(context));
            this.f35475c = 2000;
            this.f35476d = com.google.android.exoplayer2.util.e.f35556a;
            this.f35477e = true;
        }

        public static Map<Integer, Long> b(String str) {
            int[] iArrK = q.k(str);
            HashMap map = new HashMap(8);
            map.put(0, 1000000L);
            ImmutableList<Long> immutableList = q.f35451p;
            map.put(2, immutableList.get(iArrK[0]));
            map.put(3, q.f35452q.get(iArrK[1]));
            map.put(4, q.f35453r.get(iArrK[2]));
            map.put(5, q.f35454s.get(iArrK[3]));
            map.put(10, q.f35455t.get(iArrK[4]));
            map.put(9, q.f35456u.get(iArrK[5]));
            map.put(7, immutableList.get(iArrK[0]));
            return map;
        }

        public q a() {
            return new q(this.f35473a, this.f35474b, this.f35475c, this.f35476d, this.f35477e);
        }
    }

    public q(@Nullable Context context, Map<Integer, Long> map, int i11, com.google.android.exoplayer2.util.e eVar, boolean z11) {
        this.f35458a = ImmutableMap.copyOf((Map) map);
        this.f35459b = new e.a.C0373a();
        this.f35460c = new h0(i11);
        this.f35461d = eVar;
        this.f35462e = z11;
        if (context == null) {
            this.f35466i = 0;
            this.f35469l = l(0);
            return;
        }
        com.google.android.exoplayer2.util.z zVarD = com.google.android.exoplayer2.util.z.d(context);
        int iF = zVarD.f();
        this.f35466i = iF;
        this.f35469l = l(iF);
        zVarD.i(new com.google.android.exoplayer2.util.z.c() { // from class: com.google.android.exoplayer2.upstream.p
            @Override // com.google.android.exoplayer2.util.z.c
            public final void a(int i12) {
                this.f35450a.p(i12);
            }
        });
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static int[] k(String str) {
        str.hashCode();
        byte b11 = -1;
        switch (str.hashCode()) {
            case 2083:
                if (str.equals("AD")) {
                    b11 = 0;
                }
                break;
            case 2084:
                if (str.equals("AE")) {
                    b11 = 1;
                }
                break;
            case 2085:
                if (str.equals("AF")) {
                    b11 = 2;
                }
                break;
            case 2086:
                if (str.equals("AG")) {
                    b11 = 3;
                }
                break;
            case 2088:
                if (str.equals("AI")) {
                    b11 = 4;
                }
                break;
            case 2091:
                if (str.equals("AL")) {
                    b11 = 5;
                }
                break;
            case 2092:
                if (str.equals("AM")) {
                    b11 = 6;
                }
                break;
            case 2094:
                if (str.equals("AO")) {
                    b11 = 7;
                }
                break;
            case 2096:
                if (str.equals("AQ")) {
                    b11 = 8;
                }
                break;
            case 2097:
                if (str.equals("AR")) {
                    b11 = 9;
                }
                break;
            case 2098:
                if (str.equals("AS")) {
                    b11 = 10;
                }
                break;
            case 2099:
                if (str.equals("AT")) {
                    b11 = Ascii.VT;
                }
                break;
            case AdError.BROKEN_MEDIA_ERROR_CODE /* 2100 */:
                if (str.equals("AU")) {
                    b11 = Ascii.FF;
                }
                break;
            case 2102:
                if (str.equals("AW")) {
                    b11 = Ascii.CR;
                }
                break;
            case 2103:
                if (str.equals("AX")) {
                    b11 = Ascii.SO;
                }
                break;
            case 2105:
                if (str.equals("AZ")) {
                    b11 = Ascii.SI;
                }
                break;
            case 2111:
                if (str.equals("BA")) {
                    b11 = Ascii.DLE;
                }
                break;
            case 2112:
                if (str.equals("BB")) {
                    b11 = 17;
                }
                break;
            case 2114:
                if (str.equals("BD")) {
                    b11 = Ascii.DC2;
                }
                break;
            case 2115:
                if (str.equals("BE")) {
                    b11 = 19;
                }
                break;
            case 2116:
                if (str.equals("BF")) {
                    b11 = Ascii.DC4;
                }
                break;
            case 2117:
                if (str.equals("BG")) {
                    b11 = Ascii.NAK;
                }
                break;
            case 2118:
                if (str.equals("BH")) {
                    b11 = Ascii.SYN;
                }
                break;
            case 2119:
                if (str.equals("BI")) {
                    b11 = Ascii.ETB;
                }
                break;
            case 2120:
                if (str.equals("BJ")) {
                    b11 = Ascii.CAN;
                }
                break;
            case 2122:
                if (str.equals("BL")) {
                    b11 = Ascii.EM;
                }
                break;
            case 2123:
                if (str.equals("BM")) {
                    b11 = Ascii.SUB;
                }
                break;
            case 2124:
                if (str.equals("BN")) {
                    b11 = Ascii.ESC;
                }
                break;
            case 2125:
                if (str.equals("BO")) {
                    b11 = Ascii.FS;
                }
                break;
            case 2127:
                if (str.equals("BQ")) {
                    b11 = Ascii.GS;
                }
                break;
            case 2129:
                if (str.equals("BS")) {
                    b11 = Ascii.RS;
                }
                break;
            case 2130:
                if (str.equals("BT")) {
                    b11 = Ascii.US;
                }
                break;
            case 2133:
                if (str.equals("BW")) {
                    b11 = 32;
                }
                break;
            case 2135:
                if (str.equals("BY")) {
                    b11 = 33;
                }
                break;
            case 2136:
                if (str.equals("BZ")) {
                    b11 = 34;
                }
                break;
            case 2142:
                if (str.equals("CA")) {
                    b11 = 35;
                }
                break;
            case 2145:
                if (str.equals("CD")) {
                    b11 = 36;
                }
                break;
            case 2147:
                if (str.equals("CF")) {
                    b11 = 37;
                }
                break;
            case 2148:
                if (str.equals("CG")) {
                    b11 = 38;
                }
                break;
            case 2149:
                if (str.equals("CH")) {
                    b11 = 39;
                }
                break;
            case 2150:
                if (str.equals("CI")) {
                    b11 = 40;
                }
                break;
            case 2152:
                if (str.equals("CK")) {
                    b11 = 41;
                }
                break;
            case 2153:
                if (str.equals("CL")) {
                    b11 = 42;
                }
                break;
            case 2154:
                if (str.equals("CM")) {
                    b11 = 43;
                }
                break;
            case 2155:
                if (str.equals("CN")) {
                    b11 = 44;
                }
                break;
            case 2156:
                if (str.equals("CO")) {
                    b11 = 45;
                }
                break;
            case 2159:
                if (str.equals("CR")) {
                    b11 = 46;
                }
                break;
            case 2162:
                if (str.equals("CU")) {
                    b11 = 47;
                }
                break;
            case 2163:
                if (str.equals("CV")) {
                    b11 = 48;
                }
                break;
            case 2164:
                if (str.equals("CW")) {
                    b11 = 49;
                }
                break;
            case 2165:
                if (str.equals("CX")) {
                    b11 = 50;
                }
                break;
            case 2166:
                if (str.equals("CY")) {
                    b11 = 51;
                }
                break;
            case 2167:
                if (str.equals("CZ")) {
                    b11 = 52;
                }
                break;
            case 2177:
                if (str.equals("DE")) {
                    b11 = 53;
                }
                break;
            case 2182:
                if (str.equals("DJ")) {
                    b11 = 54;
                }
                break;
            case 2183:
                if (str.equals("DK")) {
                    b11 = 55;
                }
                break;
            case 2185:
                if (str.equals("DM")) {
                    b11 = 56;
                }
                break;
            case 2187:
                if (str.equals("DO")) {
                    b11 = 57;
                }
                break;
            case 2198:
                if (str.equals("DZ")) {
                    b11 = 58;
                }
                break;
            case 2206:
                if (str.equals("EC")) {
                    b11 = 59;
                }
                break;
            case 2208:
                if (str.equals("EE")) {
                    b11 = 60;
                }
                break;
            case 2210:
                if (str.equals("EG")) {
                    b11 = 61;
                }
                break;
            case 2221:
                if (str.equals("ER")) {
                    b11 = 62;
                }
                break;
            case 2222:
                if (str.equals("ES")) {
                    b11 = Utf8.REPLACEMENT_BYTE;
                }
                break;
            case 2223:
                if (str.equals("ET")) {
                    b11 = 64;
                }
                break;
            case 2243:
                if (str.equals("FI")) {
                    b11 = 65;
                }
                break;
            case 2244:
                if (str.equals("FJ")) {
                    b11 = 66;
                }
                break;
            case 2245:
                if (str.equals("FK")) {
                    b11 = 67;
                }
                break;
            case 2247:
                if (str.equals("FM")) {
                    b11 = 68;
                }
                break;
            case 2249:
                if (str.equals("FO")) {
                    b11 = 69;
                }
                break;
            case 2252:
                if (str.equals("FR")) {
                    b11 = 70;
                }
                break;
            case 2266:
                if (str.equals("GA")) {
                    b11 = 71;
                }
                break;
            case 2267:
                if (str.equals("GB")) {
                    b11 = 72;
                }
                break;
            case 2269:
                if (str.equals("GD")) {
                    b11 = 73;
                }
                break;
            case 2270:
                if (str.equals("GE")) {
                    b11 = 74;
                }
                break;
            case 2271:
                if (str.equals("GF")) {
                    b11 = 75;
                }
                break;
            case 2272:
                if (str.equals("GG")) {
                    b11 = 76;
                }
                break;
            case 2273:
                if (str.equals("GH")) {
                    b11 = 77;
                }
                break;
            case 2274:
                if (str.equals("GI")) {
                    b11 = 78;
                }
                break;
            case 2277:
                if (str.equals("GL")) {
                    b11 = 79;
                }
                break;
            case 2278:
                if (str.equals("GM")) {
                    b11 = 80;
                }
                break;
            case 2279:
                if (str.equals("GN")) {
                    b11 = 81;
                }
                break;
            case 2281:
                if (str.equals("GP")) {
                    b11 = 82;
                }
                break;
            case 2282:
                if (str.equals("GQ")) {
                    b11 = 83;
                }
                break;
            case 2283:
                if (str.equals("GR")) {
                    b11 = 84;
                }
                break;
            case 2285:
                if (str.equals("GT")) {
                    b11 = 85;
                }
                break;
            case 2286:
                if (str.equals("GU")) {
                    b11 = 86;
                }
                break;
            case 2288:
                if (str.equals("GW")) {
                    b11 = 87;
                }
                break;
            case 2290:
                if (str.equals("GY")) {
                    b11 = 88;
                }
                break;
            case 2307:
                if (str.equals("HK")) {
                    b11 = 89;
                }
                break;
            case 2314:
                if (str.equals("HR")) {
                    b11 = 90;
                }
                break;
            case 2316:
                if (str.equals("HT")) {
                    b11 = 91;
                }
                break;
            case 2317:
                if (str.equals("HU")) {
                    b11 = 92;
                }
                break;
            case 2331:
                if (str.equals("ID")) {
                    b11 = 93;
                }
                break;
            case 2332:
                if (str.equals("IE")) {
                    b11 = 94;
                }
                break;
            case 2339:
                if (str.equals("IL")) {
                    b11 = 95;
                }
                break;
            case 2340:
                if (str.equals("IM")) {
                    b11 = 96;
                }
                break;
            case 2341:
                if (str.equals("IN")) {
                    b11 = 97;
                }
                break;
            case 2342:
                if (str.equals("IO")) {
                    b11 = 98;
                }
                break;
            case 2344:
                if (str.equals("IQ")) {
                    b11 = 99;
                }
                break;
            case 2345:
                if (str.equals("IR")) {
                    b11 = 100;
                }
                break;
            case 2346:
                if (str.equals("IS")) {
                    b11 = 101;
                }
                break;
            case 2347:
                if (str.equals("IT")) {
                    b11 = 102;
                }
                break;
            case 2363:
                if (str.equals("JE")) {
                    b11 = 103;
                }
                break;
            case 2371:
                if (str.equals("JM")) {
                    b11 = 104;
                }
                break;
            case 2373:
                if (str.equals("JO")) {
                    b11 = 105;
                }
                break;
            case 2374:
                if (str.equals("JP")) {
                    b11 = 106;
                }
                break;
            case 2394:
                if (str.equals("KE")) {
                    b11 = 107;
                }
                break;
            case 2396:
                if (str.equals("KG")) {
                    b11 = 108;
                }
                break;
            case 2397:
                if (str.equals("KH")) {
                    b11 = 109;
                }
                break;
            case 2398:
                if (str.equals("KI")) {
                    b11 = 110;
                }
                break;
            case 2402:
                if (str.equals("KM")) {
                    b11 = 111;
                }
                break;
            case 2403:
                if (str.equals("KN")) {
                    b11 = 112;
                }
                break;
            case 2405:
                if (str.equals("KP")) {
                    b11 = 113;
                }
                break;
            case 2407:
                if (str.equals("KR")) {
                    b11 = 114;
                }
                break;
            case 2412:
                if (str.equals("KW")) {
                    b11 = 115;
                }
                break;
            case 2414:
                if (str.equals("KY")) {
                    b11 = 116;
                }
                break;
            case 2415:
                if (str.equals("KZ")) {
                    b11 = 117;
                }
                break;
            case 2421:
                if (str.equals("LA")) {
                    b11 = 118;
                }
                break;
            case 2422:
                if (str.equals("LB")) {
                    b11 = 119;
                }
                break;
            case 2423:
                if (str.equals("LC")) {
                    b11 = 120;
                }
                break;
            case 2429:
                if (str.equals("LI")) {
                    b11 = 121;
                }
                break;
            case 2431:
                if (str.equals("LK")) {
                    b11 = 122;
                }
                break;
            case 2438:
                if (str.equals("LR")) {
                    b11 = 123;
                }
                break;
            case 2439:
                if (str.equals("LS")) {
                    b11 = 124;
                }
                break;
            case 2440:
                if (str.equals("LT")) {
                    b11 = 125;
                }
                break;
            case 2441:
                if (str.equals("LU")) {
                    b11 = 126;
                }
                break;
            case 2442:
                if (str.equals("LV")) {
                    b11 = Ascii.DEL;
                }
                break;
            case 2445:
                if (str.equals("LY")) {
                    b11 = 128;
                }
                break;
            case 2452:
                if (str.equals(RequestConfiguration.MAX_AD_CONTENT_RATING_MA)) {
                    b11 = 129;
                }
                break;
            case 2454:
                if (str.equals("MC")) {
                    b11 = 130;
                }
                break;
            case 2455:
                if (str.equals("MD")) {
                    b11 = 131;
                }
                break;
            case 2456:
                if (str.equals(BottomTabType.TAB_CODE_ME)) {
                    b11 = 132;
                }
                break;
            case 2457:
                if (str.equals("MF")) {
                    b11 = 133;
                }
                break;
            case 2458:
                if (str.equals("MG")) {
                    b11 = 134;
                }
                break;
            case 2459:
                if (str.equals("MH")) {
                    b11 = 135;
                }
                break;
            case 2462:
                if (str.equals("MK")) {
                    b11 = 136;
                }
                break;
            case 2463:
                if (str.equals("ML")) {
                    b11 = 137;
                }
                break;
            case 2464:
                if (str.equals("MM")) {
                    b11 = 138;
                }
                break;
            case 2465:
                if (str.equals("MN")) {
                    b11 = 139;
                }
                break;
            case 2466:
                if (str.equals("MO")) {
                    b11 = 140;
                }
                break;
            case 2467:
                if (str.equals("MP")) {
                    b11 = 141;
                }
                break;
            case 2468:
                if (str.equals("MQ")) {
                    b11 = 142;
                }
                break;
            case 2469:
                if (str.equals("MR")) {
                    b11 = 143;
                }
                break;
            case 2470:
                if (str.equals("MS")) {
                    b11 = 144;
                }
                break;
            case 2471:
                if (str.equals("MT")) {
                    b11 = 145;
                }
                break;
            case 2472:
                if (str.equals("MU")) {
                    b11 = 146;
                }
                break;
            case 2473:
                if (str.equals("MV")) {
                    b11 = 147;
                }
                break;
            case 2474:
                if (str.equals("MW")) {
                    b11 = 148;
                }
                break;
            case 2475:
                if (str.equals("MX")) {
                    b11 = 149;
                }
                break;
            case 2476:
                if (str.equals("MY")) {
                    b11 = 150;
                }
                break;
            case 2477:
                if (str.equals("MZ")) {
                    b11 = 151;
                }
                break;
            case 2483:
                if (str.equals("NA")) {
                    b11 = 152;
                }
                break;
            case 2485:
                if (str.equals("NC")) {
                    b11 = 153;
                }
                break;
            case 2487:
                if (str.equals("NE")) {
                    b11 = 154;
                }
                break;
            case 2489:
                if (str.equals("NG")) {
                    b11 = 155;
                }
                break;
            case 2491:
                if (str.equals("NI")) {
                    b11 = 156;
                }
                break;
            case 2494:
                if (str.equals("NL")) {
                    b11 = 157;
                }
                break;
            case 2497:
                if (str.equals("NO")) {
                    b11 = 158;
                }
                break;
            case 2498:
                if (str.equals("NP")) {
                    b11 = 159;
                }
                break;
            case DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS /* 2500 */:
                if (str.equals("NR")) {
                    b11 = 160;
                }
                break;
            case 2503:
                if (str.equals("NU")) {
                    b11 = 161;
                }
                break;
            case 2508:
                if (str.equals("NZ")) {
                    b11 = 162;
                }
                break;
            case 2526:
                if (str.equals("OM")) {
                    b11 = 163;
                }
                break;
            case 2545:
                if (str.equals("PA")) {
                    b11 = 164;
                }
                break;
            case 2549:
                if (str.equals("PE")) {
                    b11 = 165;
                }
                break;
            case 2550:
                if (str.equals("PF")) {
                    b11 = 166;
                }
                break;
            case 2551:
                if (str.equals(RequestConfiguration.MAX_AD_CONTENT_RATING_PG)) {
                    b11 = 167;
                }
                break;
            case 2552:
                if (str.equals("PH")) {
                    b11 = 168;
                }
                break;
            case 2555:
                if (str.equals("PK")) {
                    b11 = 169;
                }
                break;
            case 2556:
                if (str.equals("PL")) {
                    b11 = 170;
                }
                break;
            case 2557:
                if (str.equals("PM")) {
                    b11 = 171;
                }
                break;
            case 2562:
                if (str.equals("PR")) {
                    b11 = 172;
                }
                break;
            case 2563:
                if (str.equals("PS")) {
                    b11 = 173;
                }
                break;
            case 2564:
                if (str.equals("PT")) {
                    b11 = 174;
                }
                break;
            case 2567:
                if (str.equals("PW")) {
                    b11 = 175;
                }
                break;
            case 2576:
                if (str.equals("QA")) {
                    b11 = 176;
                }
                break;
            case 2611:
                if (str.equals("RE")) {
                    b11 = 177;
                }
                break;
            case 2621:
                if (str.equals("RO")) {
                    b11 = 178;
                }
                break;
            case 2625:
                if (str.equals("RS")) {
                    b11 = 179;
                }
                break;
            case 2627:
                if (str.equals("RU")) {
                    b11 = 180;
                }
                break;
            case 2629:
                if (str.equals("RW")) {
                    b11 = 181;
                }
                break;
            case 2638:
                if (str.equals("SA")) {
                    b11 = 182;
                }
                break;
            case 2639:
                if (str.equals("SB")) {
                    b11 = 183;
                }
                break;
            case 2640:
                if (str.equals("SC")) {
                    b11 = 184;
                }
                break;
            case 2641:
                if (str.equals("SD")) {
                    b11 = 185;
                }
                break;
            case 2642:
                if (str.equals("SE")) {
                    b11 = 186;
                }
                break;
            case 2644:
                if (str.equals("SG")) {
                    b11 = 187;
                }
                break;
            case 2645:
                if (str.equals("SH")) {
                    b11 = 188;
                }
                break;
            case 2646:
                if (str.equals("SI")) {
                    b11 = 189;
                }
                break;
            case 2648:
                if (str.equals("SK")) {
                    b11 = 190;
                }
                break;
            case 2649:
                if (str.equals("SL")) {
                    b11 = 191;
                }
                break;
            case 2650:
                if (str.equals("SM")) {
                    b11 = 192;
                }
                break;
            case 2651:
                if (str.equals("SN")) {
                    b11 = 193;
                }
                break;
            case 2652:
                if (str.equals("SO")) {
                    b11 = 194;
                }
                break;
            case 2655:
                if (str.equals("SR")) {
                    b11 = 195;
                }
                break;
            case 2656:
                if (str.equals("SS")) {
                    b11 = 196;
                }
                break;
            case 2657:
                if (str.equals("ST")) {
                    b11 = 197;
                }
                break;
            case 2659:
                if (str.equals("SV")) {
                    b11 = 198;
                }
                break;
            case 2661:
                if (str.equals("SX")) {
                    b11 = 199;
                }
                break;
            case 2662:
                if (str.equals("SY")) {
                    b11 = 200;
                }
                break;
            case 2663:
                if (str.equals("SZ")) {
                    b11 = 201;
                }
                break;
            case 2671:
                if (str.equals("TC")) {
                    b11 = 202;
                }
                break;
            case 2672:
                if (str.equals("TD")) {
                    b11 = 203;
                }
                break;
            case 2675:
                if (str.equals("TG")) {
                    b11 = 204;
                }
                break;
            case 2676:
                if (str.equals("TH")) {
                    b11 = 205;
                }
                break;
            case 2678:
                if (str.equals("TJ")) {
                    b11 = 206;
                }
                break;
            case 2679:
                if (str.equals("TK")) {
                    b11 = 207;
                }
                break;
            case 2680:
                if (str.equals("TL")) {
                    b11 = 208;
                }
                break;
            case 2681:
                if (str.equals("TM")) {
                    b11 = 209;
                }
                break;
            case 2682:
                if (str.equals("TN")) {
                    b11 = 210;
                }
                break;
            case 2683:
                if (str.equals("TO")) {
                    b11 = 211;
                }
                break;
            case 2686:
                if (str.equals("TR")) {
                    b11 = 212;
                }
                break;
            case 2688:
                if (str.equals("TT")) {
                    b11 = 213;
                }
                break;
            case 2690:
                if (str.equals(HotRankItem.CATE_TV)) {
                    b11 = 214;
                }
                break;
            case 2691:
                if (str.equals("TW")) {
                    b11 = 215;
                }
                break;
            case 2694:
                if (str.equals("TZ")) {
                    b11 = 216;
                }
                break;
            case 2700:
                if (str.equals("UA")) {
                    b11 = 217;
                }
                break;
            case 2706:
                if (str.equals("UG")) {
                    b11 = 218;
                }
                break;
            case 2718:
                if (str.equals("US")) {
                    b11 = 219;
                }
                break;
            case 2724:
                if (str.equals("UY")) {
                    b11 = 220;
                }
                break;
            case 2725:
                if (str.equals("UZ")) {
                    b11 = 221;
                }
                break;
            case 2731:
                if (str.equals("VA")) {
                    b11 = 222;
                }
                break;
            case 2733:
                if (str.equals("VC")) {
                    b11 = 223;
                }
                break;
            case 2735:
                if (str.equals("VE")) {
                    b11 = 224;
                }
                break;
            case 2737:
                if (str.equals("VG")) {
                    b11 = 225;
                }
                break;
            case 2739:
                if (str.equals("VI")) {
                    b11 = 226;
                }
                break;
            case 2744:
                if (str.equals("VN")) {
                    b11 = 227;
                }
                break;
            case 2751:
                if (str.equals("VU")) {
                    b11 = 228;
                }
                break;
            case 2767:
                if (str.equals("WF")) {
                    b11 = 229;
                }
                break;
            case 2780:
                if (str.equals("WS")) {
                    b11 = 230;
                }
                break;
            case 2803:
                if (str.equals("XK")) {
                    b11 = 231;
                }
                break;
            case 2828:
                if (str.equals("YE")) {
                    b11 = 232;
                }
                break;
            case 2843:
                if (str.equals("YT")) {
                    b11 = 233;
                }
                break;
            case 2855:
                if (str.equals("ZA")) {
                    b11 = 234;
                }
                break;
            case 2867:
                if (str.equals("ZM")) {
                    b11 = 235;
                }
                break;
            case 2877:
                if (str.equals("ZW")) {
                    b11 = 236;
                }
                break;
        }
        switch (b11) {
            case 0:
            case 26:
            case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
            case 73:
            case 79:
            case 112:
            case 116:
            case 120:
            case 223:
                return new int[]{1, 2, 0, 0, 2, 2};
            case 1:
                return new int[]{1, 4, 4, 4, 4, 0};
            case 2:
            case 80:
                return new int[]{4, 3, 3, 4, 2, 2};
            case 3:
                return new int[]{2, 4, 1, 2, 2, 2};
            case 4:
                return new int[]{0, 2, 0, 3, 2, 2};
            case 5:
            case 231:
                return new int[]{1, 1, 1, 1, 2, 2};
            case 6:
                return new int[]{2, 3, 2, 3, 2, 2};
            case 7:
                return new int[]{4, 4, 3, 2, 2, 2};
            case 8:
            case 62:
            case 188:
                return new int[]{4, 2, 2, 2, 2, 2};
            case 9:
            case 108:
            case 210:
            case 220:
                return new int[]{2, 1, 1, 1, 2, 2};
            case 10:
                return new int[]{2, 2, 3, 3, 2, 2};
            case 11:
                return new int[]{1, 0, 1, 1, 0, 0};
            case 12:
                return new int[]{0, 1, 1, 1, 2, 0};
            case 13:
                return new int[]{1, 3, 4, 4, 2, 2};
            case 14:
            case 121:
            case 144:
            case 171:
            case PsExtractor.AUDIO_STREAM /* 192 */:
                return new int[]{0, 2, 2, 2, 2, 2};
            case 15:
            case 75:
            case 128:
            case 169:
            case 194:
            case 211:
                return new int[]{3, 2, 3, 3, 2, 2};
            case 16:
                return new int[]{1, 2, 1, 1, 2, 2};
            case 17:
            case 56:
            case 69:
            case 78:
                return new int[]{0, 2, 0, 0, 2, 2};
            case 18:
                return new int[]{2, 1, 3, 3, 2, 2};
            case 19:
                return new int[]{0, 1, 4, 4, 3, 2};
            case 20:
                return new int[]{4, 3, 4, 3, 2, 2};
            case 21:
            case 145:
            case 190:
                return new int[]{0, 0, 0, 0, 1, 2};
            case 22:
                return new int[]{1, 2, 1, 3, 4, 2};
            case 23:
            case 91:
            case 111:
            case TsExtractor.TS_STREAM_TYPE_SPLICE_INFO /* 134 */:
            case 154:
            case 185:
            case 203:
            case 224:
            case 232:
                return new int[]{4, 4, 4, 4, 2, 2};
            case 24:
                return new int[]{4, 4, 3, 3, 2, 2};
            case 25:
            case 50:
            case 222:
                return new int[]{1, 2, 2, 2, 2, 2};
            case 27:
            case 49:
                return new int[]{2, 2, 0, 0, 2, 2};
            case 28:
                return new int[]{1, 2, 3, 2, 2, 2};
            case 30:
                return new int[]{4, 4, 2, 2, 2, 2};
            case VungleException.WEB_CRASH /* 31 */:
                return new int[]{3, 1, 3, 2, 2, 2};
            case 32:
                return new int[]{3, 2, 1, 0, 2, 2};
            case 33:
                return new int[]{0, 1, 2, 3, 2, 2};
            case 34:
                return new int[]{2, 4, 2, 1, 2, 2};
            case 35:
                return new int[]{0, 2, 2, 2, 3, 2};
            case 36:
                return new int[]{4, 2, 3, 2, 2, 2};
            case 37:
            case Worker.WHAT_QUIT /* 110 */:
                return new int[]{4, 2, 4, 2, 2, 2};
            case 38:
            case 61:
            case 87:
                return new int[]{3, 4, 3, 3, 2, 2};
            case 39:
                return new int[]{0, 0, 0, 1, 0, 2};
            case 40:
            case 58:
            case 123:
                return new int[]{3, 4, 4, 4, 2, 2};
            case 41:
            case 166:
                return new int[]{2, 2, 2, 1, 2, 2};
            case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
            case 95:
                return new int[]{1, 2, 2, 2, 3, 2};
            case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                return new int[]{3, 3, 3, 3, 2, 2};
            case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                return new int[]{2, 0, 1, 1, 3, 2};
            case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                return new int[]{2, 3, 4, 3, 2, 2};
            case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                return new int[]{2, 3, 4, 4, 2, 2};
            case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
            case 54:
            case 200:
            case 206:
            case 208:
                return new int[]{4, 3, 4, 4, 2, 2};
            case 48:
                return new int[]{2, 1, 0, 0, 2, 2};
            case 51:
            case 115:
                return new int[]{1, 0, 0, 0, 0, 2};
            case 52:
            case 158:
                return new int[]{0, 0, 2, 0, 1, 2};
            case 53:
                return new int[]{0, 1, 2, 2, 2, 3};
            case 55:
                return new int[]{0, 0, 3, 2, 0, 2};
            case DownloadBean.STATUS_COMPLETED_REMOVED /* 57 */:
                return new int[]{3, 4, 4, 4, 4, 2};
            case 59:
                return new int[]{2, 3, 2, 1, 2, 2};
            case 60:
            case 101:
            case 127:
            case 174:
            case 186:
            case 215:
                return new int[]{0, 0, 0, 0, 0, 2};
            case 63:
            case 94:
                return new int[]{0, 1, 1, 1, 2, 2};
            case 64:
                return new int[]{4, 3, 3, 1, 2, 2};
            case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                return new int[]{0, 0, 0, 3, 0, 2};
            case 66:
                return new int[]{3, 1, 2, 2, 2, 2};
            case MdtaMetadataEntry.TYPE_INDICATOR_INT32 /* 67 */:
            case 107:
            case 113:
                return new int[]{3, 2, 2, 2, 2, 2};
            case 68:
                return new int[]{4, 2, 4, 1, 2, 2};
            case 70:
                return new int[]{1, 2, 3, 1, 0, 2};
            case 71:
            case 204:
                return new int[]{3, 4, 1, 0, 2, 2};
            case 72:
                return new int[]{0, 0, 1, 1, 1, 1};
            case 74:
                return new int[]{1, 1, 1, 2, 2, 2};
            case 76:
            case 226:
                return new int[]{0, 2, 0, 1, 2, 2};
            case 77:
            case 152:
            case 228:
                return new int[]{3, 3, 3, 2, 2, 2};
            case 81:
                return new int[]{4, 3, 4, 2, 2, 2};
            case 82:
            case 142:
                return new int[]{2, 1, 2, 3, 2, 2};
            case 83:
                return new int[]{4, 2, 1, 4, 2, 2};
            case 84:
            case 90:
            case PsExtractor.PRIVATE_STREAM_1 /* 189 */:
                return new int[]{1, 0, 0, 0, 1, 2};
            case 85:
                return new int[]{2, 3, 2, 2, 2, 2};
            case ModuleDescriptor.MODULE_VERSION /* 86 */:
            case 165:
                return new int[]{1, 2, 4, 4, 4, 2};
            case 88:
                return new int[]{3, 2, 2, 1, 2, 2};
            case TsExtractor.TS_STREAM_TYPE_DVBSUBS /* 89 */:
                return new int[]{0, 1, 2, 3, 2, 0};
            case 92:
                return new int[]{0, 0, 0, 1, 3, 2};
            case 93:
                return new int[]{3, 1, 2, 2, 3, 2};
            case 96:
            case 217:
                return new int[]{0, 2, 1, 1, 2, 2};
            case 97:
                return new int[]{1, 1, 3, 2, 3, 3};
            case 98:
            case TsExtractor.TS_STREAM_TYPE_E_AC3 /* 135 */:
            case 214:
            case 229:
                return new int[]{4, 2, 2, 4, 2, 2};
            case 99:
                return new int[]{3, 2, 2, 3, 2, 2};
            case 100:
                return new int[]{3, 0, 1, 1, 4, 1};
            case 102:
                return new int[]{0, 0, 0, 1, 1, 2};
            case Worker.WHAT_SYNC_DATA /* 103 */:
            case 233:
                return new int[]{4, 2, 2, 3, 2, 2};
            case 104:
                return new int[]{2, 4, 3, 2, 2, 2};
            case 105:
                return new int[]{2, 1, 1, 2, 2, 2};
            case 106:
                return new int[]{0, 1, 1, 2, 2, 4};
            case 109:
                return new int[]{2, 1, 4, 2, 2, 2};
            case 114:
                return new int[]{0, 1, 1, 3, 4, 4};
            case 117:
                return new int[]{2, 1, 2, 2, 2, 2};
            case 118:
                return new int[]{1, 2, 1, 3, 2, 2};
            case 119:
                return new int[]{3, 3, 2, 4, 2, 2};
            case 122:
                return new int[]{3, 1, 3, 3, 4, 2};
            case 124:
                return new int[]{3, 3, 2, 2, 2, 2};
            case 125:
                return new int[]{0, 0, 0, 0, 2, 2};
            case WebSocketProtocol.PAYLOAD_SHORT /* 126 */:
                return new int[]{1, 0, 3, 2, 1, 4};
            case TsExtractor.TS_STREAM_TYPE_AC3 /* 129 */:
                return new int[]{3, 3, 1, 1, 2, 2};
            case TsExtractor.TS_STREAM_TYPE_HDMV_DTS /* 130 */:
                return new int[]{0, 2, 2, 0, 2, 2};
            case 131:
            case 179:
                return new int[]{1, 0, 0, 0, 2, 2};
            case 132:
                return new int[]{2, 0, 0, 1, 2, 2};
            case 133:
            case 177:
                return new int[]{1, 2, 1, 2, 2, 2};
            case 136:
                return new int[]{1, 0, 0, 1, 3, 2};
            case 137:
            case 167:
                return new int[]{4, 3, 3, 2, 2, 2};
            case TsExtractor.TS_STREAM_TYPE_DTS /* 138 */:
                return new int[]{2, 4, 2, 3, 2, 2};
            case 139:
                return new int[]{2, 0, 1, 2, 2, 2};
            case 140:
            case 141:
                return new int[]{0, 2, 4, 4, 2, 2};
            case 143:
            case 236:
                return new int[]{4, 2, 4, 4, 2, 2};
            case 146:
                return new int[]{3, 1, 1, 2, 2, 2};
            case 147:
                return new int[]{3, 4, 1, 4, 2, 2};
            case 148:
                return new int[]{4, 2, 3, 3, 2, 2};
            case 149:
                return new int[]{2, 4, 3, 4, 2, 2};
            case 150:
                return new int[]{1, 0, 3, 1, 3, 2};
            case 151:
                return new int[]{3, 1, 2, 1, 2, 2};
            case 153:
                return new int[]{3, 3, 4, 4, 2, 2};
            case 155:
                return new int[]{3, 4, 2, 1, 2, 2};
            case 156:
            case 164:
            case 198:
                return new int[]{2, 3, 3, 3, 2, 2};
            case 157:
                return new int[]{0, 2, 2, 3, 0, 3};
            case 159:
                return new int[]{2, 2, 4, 3, 2, 2};
            case 160:
            case 161:
                return new int[]{4, 2, 2, 1, 2, 2};
            case 162:
            case 170:
                return new int[]{1, 1, 2, 2, 4, 2};
            case 163:
                return new int[]{2, 3, 1, 3, 4, 2};
            case 168:
                return new int[]{2, 1, 3, 3, 3, 0};
            case 172:
                return new int[]{2, 0, 2, 1, 2, 1};
            case 173:
                return new int[]{3, 4, 1, 2, 2, 2};
            case 175:
                return new int[]{2, 2, 4, 1, 2, 2};
            case 176:
                return new int[]{2, 4, 4, 4, 4, 2};
            case 178:
                return new int[]{0, 0, 1, 2, 1, 2};
            case 180:
                return new int[]{1, 0, 0, 0, 4, 3};
            case 181:
                return new int[]{3, 4, 2, 0, 2, 2};
            case 182:
                return new int[]{3, 1, 1, 1, 2, 2};
            case 183:
                return new int[]{4, 2, 4, 3, 2, 2};
            case 184:
            case 209:
                return new int[]{4, 2, 1, 1, 2, 2};
            case 187:
                return new int[]{1, 1, 2, 2, 2, 1};
            case 191:
            case 218:
                return new int[]{3, 3, 4, 3, 2, 2};
            case 193:
                return new int[]{4, 4, 4, 3, 2, 2};
            case 195:
                return new int[]{2, 4, 3, 0, 2, 2};
            case 196:
                return new int[]{4, 3, 2, 3, 2, 2};
            case 197:
                return new int[]{2, 2, 1, 2, 2, 2};
            case 199:
            case 202:
                return new int[]{1, 2, 1, 0, 2, 2};
            case 201:
                return new int[]{3, 3, 3, 4, 2, 2};
            case 205:
                return new int[]{0, 2, 2, 3, 3, 4};
            case 207:
                return new int[]{2, 2, 2, 4, 2, 2};
            case 212:
                return new int[]{1, 1, 0, 0, 2, 2};
            case 213:
                return new int[]{1, 4, 1, 3, 2, 2};
            case 216:
                return new int[]{3, 4, 3, 2, 2, 2};
            case 219:
                return new int[]{1, 0, 2, 2, 3, 1};
            case 221:
                return new int[]{2, 2, 3, 4, 2, 2};
            case 225:
                return new int[]{2, 2, 1, 1, 2, 2};
            case 227:
                return new int[]{0, 3, 3, 4, 2, 2};
            case 230:
                return new int[]{3, 1, 3, 1, 2, 2};
            case 234:
                return new int[]{3, 2, 2, 1, 1, 2};
            case 235:
                return new int[]{3, 3, 4, 2, 2, 2};
            default:
                return new int[]{2, 2, 2, 2, 2, 2};
        }
    }

    public static synchronized q m(Context context) {
        try {
            if (f35457v == null) {
                f35457v = new b(context).a();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f35457v;
    }

    public static boolean n(n nVar, boolean z11) {
        return z11 && !nVar.d(8);
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public /* synthetic */ long a() {
        return c.a(this);
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public k0 b() {
        return this;
    }

    @Override // com.google.android.exoplayer2.upstream.k0
    public synchronized void c(k kVar, n nVar, boolean z11) {
        try {
            if (n(nVar, z11)) {
                com.google.android.exoplayer2.util.a.g(this.f35463f > 0);
                long jElapsedRealtime = this.f35461d.elapsedRealtime();
                int i11 = (int) (jElapsedRealtime - this.f35464g);
                this.f35467j += (long) i11;
                long j11 = this.f35468k;
                long j12 = this.f35465h;
                this.f35468k = j11 + j12;
                if (i11 > 0) {
                    this.f35460c.c((int) Math.sqrt(j12), (j12 * 8000.0f) / i11);
                    if (this.f35467j >= AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS || this.f35468k >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                        this.f35469l = (long) this.f35460c.f(0.5f);
                    }
                    o(i11, this.f35465h, this.f35469l);
                    this.f35464g = jElapsedRealtime;
                    this.f35465h = 0L;
                }
                this.f35463f--;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public void d(e.a aVar) {
        this.f35459b.e(aVar);
    }

    @Override // com.google.android.exoplayer2.upstream.k0
    public synchronized void e(k kVar, n nVar, boolean z11, int i11) {
        if (n(nVar, z11)) {
            this.f35465h += (long) i11;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public void f(Handler handler, e.a aVar) {
        com.google.android.exoplayer2.util.a.e(handler);
        com.google.android.exoplayer2.util.a.e(aVar);
        this.f35459b.b(handler, aVar);
    }

    @Override // com.google.android.exoplayer2.upstream.k0
    public synchronized void g(k kVar, n nVar, boolean z11) {
        try {
            if (n(nVar, z11)) {
                if (this.f35463f == 0) {
                    this.f35464g = this.f35461d.elapsedRealtime();
                }
                this.f35463f++;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public synchronized long getBitrateEstimate() {
        return this.f35469l;
    }

    @Override // com.google.android.exoplayer2.upstream.k0
    public void h(k kVar, n nVar, boolean z11) {
    }

    public final long l(int i11) {
        Long l11 = this.f35458a.get(Integer.valueOf(i11));
        if (l11 == null) {
            l11 = this.f35458a.get(0);
        }
        if (l11 == null) {
            l11 = 1000000L;
        }
        return l11.longValue();
    }

    public final void o(int i11, long j11, long j12) {
        if (i11 == 0 && j11 == 0 && j12 == this.f35470m) {
            return;
        }
        this.f35470m = j12;
        this.f35459b.c(i11, j11, j12);
    }

    public final synchronized void p(int i11) {
        int i12 = this.f35466i;
        if (i12 == 0 || this.f35462e) {
            if (this.f35471n) {
                i11 = this.f35472o;
            }
            if (i12 == i11) {
                return;
            }
            this.f35466i = i11;
            if (i11 != 1 && i11 != 0 && i11 != 8) {
                this.f35469l = l(i11);
                long jElapsedRealtime = this.f35461d.elapsedRealtime();
                o(this.f35463f > 0 ? (int) (jElapsedRealtime - this.f35464g) : 0, this.f35465h, this.f35469l);
                this.f35464g = jElapsedRealtime;
                this.f35465h = 0L;
                this.f35468k = 0L;
                this.f35467j = 0L;
                this.f35460c.i();
            }
        }
    }
}
