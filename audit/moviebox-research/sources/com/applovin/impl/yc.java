package com.applovin.impl;

import android.net.Uri;
import android.util.Pair;
import android.util.SparseArray;
import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.vungle.warren.error.VungleException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class yc implements k8 {

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final o8 f24586b0 = new o8() { // from class: com.applovin.impl.w90
        @Override // com.applovin.impl.o8
        public final k8[] a() {
            return yc.g();
        }

        @Override // com.applovin.impl.o8
        public /* synthetic */ k8[] a(Uri uri, Map map) {
            return q00.a(this, uri, map);
        }
    };

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private static final byte[] f24587c0 = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private static final byte[] f24588d0 = xp.c("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private static final byte[] f24589e0 = {68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private static final UUID f24590f0 = new UUID(72057594037932032L, -9223371306706625679L);

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private static final Map f24591g0;
    private long A;
    private long B;
    private rc C;
    private rc D;
    private boolean E;
    private boolean F;
    private int G;
    private long H;
    private long I;
    private int J;
    private int K;
    private int[] L;
    private int M;
    private int N;
    private int O;
    private int P;
    private boolean Q;
    private int R;
    private int S;
    private int T;
    private boolean U;
    private boolean V;
    private boolean W;
    private int X;
    private byte Y;
    private boolean Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p7 f24592a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private m8 f24593a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zp f24594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SparseArray f24595c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f24596d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final bh f24597e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final bh f24598f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final bh f24599g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final bh f24600h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final bh f24601i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final bh f24602j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final bh f24603k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final bh f24604l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final bh f24605m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final bh f24606n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ByteBuffer f24607o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f24608p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f24609q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private long f24610r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f24611s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private long f24612t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private c f24613u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f24614v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f24615w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private long f24616x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f24617y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private long f24618z;

    /* JADX INFO: compiled from: source.java */
    public final class b implements o7 {
        private b() {
        }

        @Override // com.applovin.impl.o7
        public void a(int i11) throws dh {
            yc.this.c(i11);
        }

        @Override // com.applovin.impl.o7
        public void a(int i11, double d11) {
            yc.this.a(i11, d11);
        }

        @Override // com.applovin.impl.o7
        public void a(int i11, int i12, l8 l8Var) throws dh {
            yc.this.a(i11, i12, l8Var);
        }

        @Override // com.applovin.impl.o7
        public void a(int i11, long j11) throws dh {
            yc.this.a(i11, j11);
        }

        @Override // com.applovin.impl.o7
        public void a(int i11, long j11, long j12) throws dh {
            yc.this.a(i11, j11, j12);
        }

        @Override // com.applovin.impl.o7
        public void a(int i11, String str) throws dh {
            yc.this.a(i11, str);
        }

        @Override // com.applovin.impl.o7
        public int b(int i11) {
            return yc.this.e(i11);
        }

        @Override // com.applovin.impl.o7
        public boolean c(int i11) {
            return yc.this.f(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {
        public int A;
        public int B;
        public int C;
        public float D;
        public float E;
        public float F;
        public float G;
        public float H;
        public float I;
        public float J;
        public float K;
        public float L;
        public float M;
        public byte[] N;
        public int O;
        public int P;
        public int Q;
        public long R;
        public long S;
        public d T;
        public boolean U;
        public boolean V;
        private String W;
        public qo X;
        public int Y;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f24620a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f24621b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f24622c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f24623d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f24624e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f24625f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f24626g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f24627h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public byte[] f24628i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public qo.a f24629j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public byte[] f24630k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public y6 f24631l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f24632m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f24633n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f24634o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f24635p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f24636q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f24637r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public float f24638s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public float f24639t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public float f24640u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public byte[] f24641v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f24642w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public boolean f24643x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public int f24644y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public int f24645z;

        private c() {
            this.f24632m = -1;
            this.f24633n = -1;
            this.f24634o = -1;
            this.f24635p = -1;
            this.f24636q = 0;
            this.f24637r = -1;
            this.f24638s = 0.0f;
            this.f24639t = 0.0f;
            this.f24640u = 0.0f;
            this.f24641v = null;
            this.f24642w = -1;
            this.f24643x = false;
            this.f24644y = -1;
            this.f24645z = -1;
            this.A = -1;
            this.B = 1000;
            this.C = 200;
            this.D = -1.0f;
            this.E = -1.0f;
            this.F = -1.0f;
            this.G = -1.0f;
            this.H = -1.0f;
            this.I = -1.0f;
            this.J = -1.0f;
            this.K = -1.0f;
            this.L = -1.0f;
            this.M = -1.0f;
            this.O = 1;
            this.P = -1;
            this.Q = 8000;
            this.R = 0L;
            this.S = 0L;
            this.V = true;
            this.W = "eng";
        }

        private static Pair a(bh bhVar) throws dh {
            try {
                bhVar.g(16);
                long jP = bhVar.p();
                if (jP == 1482049860) {
                    return new Pair("video/divx", null);
                }
                if (jP == 859189832) {
                    return new Pair(MimeTypes.VIDEO_H263, null);
                }
                if (jP != 826496599) {
                    pc.d("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                    return new Pair(MimeTypes.VIDEO_UNKNOWN, null);
                }
                byte[] bArrC = bhVar.c();
                for (int iD = bhVar.d() + 20; iD < bArrC.length - 4; iD++) {
                    if (bArrC[iD] == 0 && bArrC[iD + 1] == 0 && bArrC[iD + 2] == 1 && bArrC[iD + 3] == 15) {
                        return new Pair(MimeTypes.VIDEO_VC1, Collections.singletonList(Arrays.copyOfRange(bArrC, iD, bArrC.length)));
                    }
                }
                throw dh.a("Failed to find FourCC VC1 initialization data", null);
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw dh.a("Error parsing FourCC private data", null);
            }
        }

        private static List a(byte[] bArr) throws dh {
            int i11;
            int i12;
            try {
                if (bArr[0] != 2) {
                    throw dh.a("Error parsing vorbis codec private", null);
                }
                int i13 = 1;
                int i14 = 0;
                while (true) {
                    i11 = bArr[i13] & 255;
                    if (i11 != 255) {
                        break;
                    }
                    i14 += 255;
                    i13++;
                }
                int i15 = i13 + 1;
                int i16 = i14 + i11;
                int i17 = 0;
                while (true) {
                    i12 = bArr[i15] & 255;
                    if (i12 != 255) {
                        break;
                    }
                    i17 += 255;
                    i15++;
                }
                int i18 = i15 + 1;
                int i19 = i17 + i12;
                if (bArr[i18] != 1) {
                    throw dh.a("Error parsing vorbis codec private", null);
                }
                byte[] bArr2 = new byte[i16];
                System.arraycopy(bArr, i18, bArr2, 0, i16);
                int i21 = i18 + i16;
                if (bArr[i21] != 3) {
                    throw dh.a("Error parsing vorbis codec private", null);
                }
                int i22 = i21 + i19;
                if (bArr[i22] != 5) {
                    throw dh.a("Error parsing vorbis codec private", null);
                }
                byte[] bArr3 = new byte[bArr.length - i22];
                System.arraycopy(bArr, i22, bArr3, 0, bArr.length - i22);
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(bArr2);
                arrayList.add(bArr3);
                return arrayList;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw dh.a("Error parsing vorbis codec private", null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            b1.a(this.X);
        }

        private byte[] a(String str) throws dh {
            byte[] bArr = this.f24630k;
            if (bArr != null) {
                return bArr;
            }
            throw dh.a("Missing CodecPrivate for codec " + str, null);
        }

        private static boolean b(bh bhVar) throws dh {
            try {
                int iR = bhVar.r();
                if (iR == 1) {
                    return true;
                }
                if (iR != 65534) {
                    return false;
                }
                bhVar.f(24);
                return bhVar.s() == yc.f24590f0.getMostSignificantBits() && bhVar.s() == yc.f24590f0.getLeastSignificantBits();
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw dh.a("Error parsing MS/ACM codec private", null);
            }
        }

        private byte[] b() {
            if (this.D == -1.0f || this.E == -1.0f || this.F == -1.0f || this.G == -1.0f || this.H == -1.0f || this.I == -1.0f || this.J == -1.0f || this.K == -1.0f || this.L == -1.0f || this.M == -1.0f) {
                return null;
            }
            byte[] bArr = new byte[25];
            ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            byteBufferOrder.put((byte) 0);
            byteBufferOrder.putShort((short) ((this.D * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.E * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.F * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.G * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.H * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.I * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.J * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.K * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) (this.L + 0.5f));
            byteBufferOrder.putShort((short) (this.M + 0.5f));
            byteBufferOrder.putShort((short) this.B);
            byteBufferOrder.putShort((short) this.C);
            return bArr;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:198:0x0400  */
        /* JADX WARN: Code duplicated, block: B:203:0x0415  */
        /* JADX WARN: Code duplicated, block: B:204:0x0417  */
        /* JADX WARN: Code duplicated, block: B:207:0x0424  */
        /* JADX WARN: Code duplicated, block: B:208:0x0436  */
        /* JADX WARN: Code duplicated, block: B:210:0x043c  */
        /* JADX WARN: Code duplicated, block: B:212:0x0440  */
        /* JADX WARN: Code duplicated, block: B:214:0x0445  */
        /* JADX WARN: Code duplicated, block: B:217:0x044d  */
        /* JADX WARN: Code duplicated, block: B:219:0x0452  */
        /* JADX WARN: Code duplicated, block: B:222:0x0457  */
        /* JADX WARN: Code duplicated, block: B:225:0x0467  */
        /* JADX WARN: Code duplicated, block: B:228:0x046d  */
        /* JADX WARN: Code duplicated, block: B:231:0x0481  */
        /* JADX WARN: Code duplicated, block: B:236:0x04a1  */
        /* JADX WARN: Code duplicated, block: B:255:0x04ed  */
        /* JADX WARN: Code duplicated, block: B:257:0x0513  */
        /* JADX WARN: Code duplicated, block: B:259:0x0519  */
        /* JADX WARN: Code duplicated, block: B:272:0x053d  */
        /* JADX WARN: Code duplicated, block: B:4:0x0015  */
        public void a(m8 m8Var, int i11) throws dh {
            byte b11;
            List listSingletonList;
            String str;
            String str2;
            int i12;
            String str3;
            List list;
            String str4;
            String str5;
            String str6;
            byte[] bArr;
            int i13;
            f9.b bVar;
            int iIntValue;
            int i14;
            float f11;
            int i15;
            int i16;
            int i17;
            x6 x6VarA;
            String str7 = this.f24621b;
            str7.hashCode();
            int iD = 4;
            int i18 = 3;
            int i19 = 0;
            switch (str7) {
                case "V_MPEG4/ISO/AP":
                    b11 = 0;
                    break;
                case "V_MPEG4/ISO/SP":
                    b11 = 1;
                    break;
                case "A_MS/ACM":
                    b11 = 2;
                    break;
                case "A_TRUEHD":
                    b11 = 3;
                    break;
                case "A_VORBIS":
                    b11 = 4;
                    break;
                case "A_MPEG/L2":
                    b11 = 5;
                    break;
                case "A_MPEG/L3":
                    b11 = 6;
                    break;
                case "V_MS/VFW/FOURCC":
                    b11 = 7;
                    break;
                case "S_DVBSUB":
                    b11 = 8;
                    break;
                case "V_MPEG4/ISO/ASP":
                    b11 = 9;
                    break;
                case "V_MPEG4/ISO/AVC":
                    b11 = 10;
                    break;
                case "S_VOBSUB":
                    b11 = Ascii.VT;
                    break;
                case "A_DTS/LOSSLESS":
                    b11 = Ascii.FF;
                    break;
                case "A_AAC":
                    b11 = Ascii.CR;
                    break;
                case "A_AC3":
                    b11 = Ascii.SO;
                    break;
                case "A_DTS":
                    b11 = Ascii.SI;
                    break;
                case "V_AV1":
                    b11 = Ascii.DLE;
                    break;
                case "V_VP8":
                    b11 = 17;
                    break;
                case "V_VP9":
                    b11 = Ascii.DC2;
                    break;
                case "S_HDMV/PGS":
                    b11 = 19;
                    break;
                case "V_THEORA":
                    b11 = Ascii.DC4;
                    break;
                case "A_DTS/EXPRESS":
                    b11 = Ascii.NAK;
                    break;
                case "A_PCM/FLOAT/IEEE":
                    b11 = Ascii.SYN;
                    break;
                case "A_PCM/INT/BIG":
                    b11 = Ascii.ETB;
                    break;
                case "A_PCM/INT/LIT":
                    b11 = Ascii.CAN;
                    break;
                case "S_TEXT/ASS":
                    b11 = Ascii.EM;
                    break;
                case "V_MPEGH/ISO/HEVC":
                    b11 = Ascii.SUB;
                    break;
                case "S_TEXT/UTF8":
                    b11 = Ascii.ESC;
                    break;
                case "V_MPEG2":
                    b11 = Ascii.FS;
                    break;
                case "A_EAC3":
                    b11 = Ascii.GS;
                    break;
                case "A_FLAC":
                    b11 = Ascii.RS;
                    break;
                case "A_OPUS":
                    b11 = Ascii.US;
                    break;
                default:
                    b11 = -1;
                    break;
            }
            String str8 = MimeTypes.AUDIO_RAW;
            switch (b11) {
                case 0:
                case 1:
                case 9:
                    byte[] bArr2 = this.f24630k;
                    listSingletonList = bArr2 == null ? null : Collections.singletonList(bArr2);
                    str = MimeTypes.VIDEO_MP4V;
                    iD = -1;
                    str5 = str;
                    str6 = null;
                    str3 = str6;
                    str2 = str5;
                    i12 = -1;
                    bArr = this.N;
                    if (bArr != null && (x6VarA = x6.a(new bh(bArr))) != null) {
                        str3 = x6VarA.f24264c;
                        str2 = "video/dolby-vision";
                    }
                    boolean z11 = this.V;
                    if (this.U) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i21 = (z11 ? 1 : 0) | i13;
                    bVar = new f9.b();
                    if (Cif.g(str2)) {
                        bVar.c(this.O).n(this.Q).j(iD);
                        i18 = 1;
                    } else if (Cif.i(str2)) {
                        if (this.f24636q == 0) {
                            i16 = this.f24634o;
                            iIntValue = -1;
                            if (i16 == -1) {
                                i16 = this.f24632m;
                            }
                            this.f24634o = i16;
                            i17 = this.f24635p;
                            if (i17 == -1) {
                                i17 = this.f24633n;
                            }
                            this.f24635p = i17;
                        } else {
                            iIntValue = -1;
                        }
                        i14 = this.f24634o;
                        if (i14 != iIntValue || (i15 = this.f24635p) == iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = (this.f24633n * i14) / (this.f24632m * i15);
                        }
                        r3 r3Var = this.f24643x ? new r3(this.f24644y, this.A, this.f24645z, b()) : null;
                        if (this.f24620a != null && yc.f24591g0.containsKey(this.f24620a)) {
                            iIntValue = ((Integer) yc.f24591g0.get(this.f24620a)).intValue();
                        }
                        if (this.f24637r == 0 || Float.compare(this.f24638s, 0.0f) != 0 || Float.compare(this.f24639t, 0.0f) != 0) {
                            i19 = iIntValue;
                        } else if (Float.compare(this.f24640u, 0.0f) != 0) {
                            if (Float.compare(this.f24639t, 90.0f) == 0) {
                                i19 = 90;
                            } else if (Float.compare(this.f24639t, -180.0f) == 0 || Float.compare(this.f24639t, 180.0f) == 0) {
                                i19 = 180;
                            } else if (Float.compare(this.f24639t, -90.0f) == 0) {
                                i19 = 270;
                            } else {
                                i19 = iIntValue;
                            }
                        }
                        bVar.q(this.f24632m).g(this.f24633n).b(f11).m(i19).a(this.f24641v).p(this.f24642w).a(r3Var);
                        i18 = 2;
                    } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str2) && !MimeTypes.TEXT_SSA.equals(str2) && !MimeTypes.APPLICATION_VOBSUB.equals(str2) && !MimeTypes.APPLICATION_PGS.equals(str2) && !MimeTypes.APPLICATION_DVBSUBS.equals(str2)) {
                        throw dh.a("Unexpected MIME type.", null);
                    }
                    if (this.f24620a != null && !yc.f24591g0.containsKey(this.f24620a)) {
                        bVar.d(this.f24620a);
                    }
                    f9 f9VarA = bVar.h(i11).f(str2).i(i12).e(this.W).o(i21).a(listSingletonList).a(str3).a(this.f24631l).a();
                    qo qoVarA = m8Var.a(this.f24622c, i18);
                    this.X = qoVarA;
                    qoVarA.a(f9VarA);
                    return;
                case 2:
                    if (b(new bh(a(this.f24621b)))) {
                        int iD2 = xp.d(this.P);
                        if (iD2 == 0) {
                            pc.d("MatroskaExtractor", "Unsupported PCM bit depth: " + this.P + ". Setting mimeType to " + MimeTypes.AUDIO_UNKNOWN);
                        } else {
                            iD = iD2;
                        }
                        listSingletonList = null;
                        str = str8;
                        str5 = str;
                        str6 = null;
                        str3 = str6;
                        str2 = str5;
                        i12 = -1;
                        bArr = this.N;
                        if (bArr != null) {
                            str3 = x6VarA.f24264c;
                            str2 = "video/dolby-vision";
                        }
                        boolean z12 = this.V;
                        if (this.U) {
                            i13 = 2;
                        } else {
                            i13 = 0;
                        }
                        int i22 = (z12 ? 1 : 0) | i13;
                        bVar = new f9.b();
                        if (Cif.g(str2)) {
                            bVar.c(this.O).n(this.Q).j(iD);
                            i18 = 1;
                        } else if (Cif.i(str2)) {
                            if (this.f24636q == 0) {
                                i16 = this.f24634o;
                                iIntValue = -1;
                                if (i16 == -1) {
                                    i16 = this.f24632m;
                                }
                                this.f24634o = i16;
                                i17 = this.f24635p;
                                if (i17 == -1) {
                                    i17 = this.f24633n;
                                }
                                this.f24635p = i17;
                            } else {
                                iIntValue = -1;
                            }
                            i14 = this.f24634o;
                            if (i14 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f24643x) {
                            }
                            if (this.f24620a != null) {
                                iIntValue = ((Integer) yc.f24591g0.get(this.f24620a)).intValue();
                            }
                            if (this.f24637r == 0) {
                                i19 = iIntValue;
                            } else {
                                i19 = iIntValue;
                            }
                            bVar.q(this.f24632m).g(this.f24633n).b(f11).m(i19).a(this.f24641v).p(this.f24642w).a(r3Var);
                            i18 = 2;
                        } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str2)) {
                            throw dh.a("Unexpected MIME type.", null);
                        }
                        if (this.f24620a != null) {
                            bVar.d(this.f24620a);
                        }
                        f9 f9VarA2 = bVar.h(i11).f(str2).i(i12).e(this.W).o(i22).a(listSingletonList).a(str3).a(this.f24631l).a();
                        qo qoVarA2 = m8Var.a(this.f24622c, i18);
                        this.X = qoVarA2;
                        qoVarA2.a(f9VarA2);
                        return;
                    }
                    pc.d("MatroskaExtractor", "Non-PCM MS/ACM is unsupported. Setting mimeType to " + MimeTypes.AUDIO_UNKNOWN);
                    str8 = MimeTypes.AUDIO_UNKNOWN;
                    iD = -1;
                    listSingletonList = null;
                    str = str8;
                    str5 = str;
                    str6 = null;
                    str3 = str6;
                    str2 = str5;
                    i12 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                        str3 = x6VarA.f24264c;
                        str2 = "video/dolby-vision";
                    }
                    boolean z13 = this.V;
                    if (this.U) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i23 = (z13 ? 1 : 0) | i13;
                    bVar = new f9.b();
                    if (Cif.g(str2)) {
                        bVar.c(this.O).n(this.Q).j(iD);
                        i18 = 1;
                    } else if (Cif.i(str2)) {
                        if (this.f24636q == 0) {
                            i16 = this.f24634o;
                            iIntValue = -1;
                            if (i16 == -1) {
                                i16 = this.f24632m;
                            }
                            this.f24634o = i16;
                            i17 = this.f24635p;
                            if (i17 == -1) {
                                i17 = this.f24633n;
                            }
                            this.f24635p = i17;
                        } else {
                            iIntValue = -1;
                        }
                        i14 = this.f24634o;
                        if (i14 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.f24643x) {
                        }
                        if (this.f24620a != null) {
                            iIntValue = ((Integer) yc.f24591g0.get(this.f24620a)).intValue();
                        }
                        if (this.f24637r == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        bVar.q(this.f24632m).g(this.f24633n).b(f11).m(i19).a(this.f24641v).p(this.f24642w).a(r3Var);
                        i18 = 2;
                    } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str2)) {
                        throw dh.a("Unexpected MIME type.", null);
                    }
                    if (this.f24620a != null) {
                        bVar.d(this.f24620a);
                    }
                    f9 f9VarA3 = bVar.h(i11).f(str2).i(i12).e(this.W).o(i23).a(listSingletonList).a(str3).a(this.f24631l).a();
                    qo qoVarA3 = m8Var.a(this.f24622c, i18);
                    this.X = qoVarA3;
                    qoVarA3.a(f9VarA3);
                    return;
                case 3:
                    this.T = new d();
                    str8 = MimeTypes.AUDIO_TRUEHD;
                    iD = -1;
                    listSingletonList = null;
                    str = str8;
                    str5 = str;
                    str6 = null;
                    str3 = str6;
                    str2 = str5;
                    i12 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                        str3 = x6VarA.f24264c;
                        str2 = "video/dolby-vision";
                    }
                    boolean z14 = this.V;
                    if (this.U) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i24 = (z14 ? 1 : 0) | i13;
                    bVar = new f9.b();
                    if (Cif.g(str2)) {
                        bVar.c(this.O).n(this.Q).j(iD);
                        i18 = 1;
                    } else if (Cif.i(str2)) {
                        if (this.f24636q == 0) {
                            i16 = this.f24634o;
                            iIntValue = -1;
                            if (i16 == -1) {
                                i16 = this.f24632m;
                            }
                            this.f24634o = i16;
                            i17 = this.f24635p;
                            if (i17 == -1) {
                                i17 = this.f24633n;
                            }
                            this.f24635p = i17;
                        } else {
                            iIntValue = -1;
                        }
                        i14 = this.f24634o;
                        if (i14 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.f24643x) {
                        }
                        if (this.f24620a != null) {
                            iIntValue = ((Integer) yc.f24591g0.get(this.f24620a)).intValue();
                        }
                        if (this.f24637r == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        bVar.q(this.f24632m).g(this.f24633n).b(f11).m(i19).a(this.f24641v).p(this.f24642w).a(r3Var);
                        i18 = 2;
                    } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str2)) {
                        throw dh.a("Unexpected MIME type.", null);
                    }
                    if (this.f24620a != null) {
                        bVar.d(this.f24620a);
                    }
                    f9 f9VarA4 = bVar.h(i11).f(str2).i(i12).e(this.W).o(i24).a(listSingletonList).a(str3).a(this.f24631l).a();
                    qo qoVarA4 = m8Var.a(this.f24622c, i18);
                    this.X = qoVarA4;
                    qoVarA4.a(f9VarA4);
                    return;
                case 4:
                    listSingletonList = a(a(this.f24621b));
                    str2 = MimeTypes.AUDIO_VORBIS;
                    i12 = 8192;
                    str3 = null;
                    iD = -1;
                    bArr = this.N;
                    if (bArr != null) {
                        str3 = x6VarA.f24264c;
                        str2 = "video/dolby-vision";
                    }
                    boolean z15 = this.V;
                    if (this.U) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i25 = (z15 ? 1 : 0) | i13;
                    bVar = new f9.b();
                    if (Cif.g(str2)) {
                        bVar.c(this.O).n(this.Q).j(iD);
                        i18 = 1;
                    } else if (Cif.i(str2)) {
                        if (this.f24636q == 0) {
                            i16 = this.f24634o;
                            iIntValue = -1;
                            if (i16 == -1) {
                                i16 = this.f24632m;
                            }
                            this.f24634o = i16;
                            i17 = this.f24635p;
                            if (i17 == -1) {
                                i17 = this.f24633n;
                            }
                            this.f24635p = i17;
                        } else {
                            iIntValue = -1;
                        }
                        i14 = this.f24634o;
                        if (i14 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.f24643x) {
                        }
                        if (this.f24620a != null) {
                            iIntValue = ((Integer) yc.f24591g0.get(this.f24620a)).intValue();
                        }
                        if (this.f24637r == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        bVar.q(this.f24632m).g(this.f24633n).b(f11).m(i19).a(this.f24641v).p(this.f24642w).a(r3Var);
                        i18 = 2;
                    } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str2)) {
                        throw dh.a("Unexpected MIME type.", null);
                    }
                    if (this.f24620a != null) {
                        bVar.d(this.f24620a);
                    }
                    f9 f9VarA5 = bVar.h(i11).f(str2).i(i12).e(this.W).o(i25).a(listSingletonList).a(str3).a(this.f24631l).a();
                    qo qoVarA5 = m8Var.a(this.f24622c, i18);
                    this.X = qoVarA5;
                    qoVarA5.a(f9VarA5);
                    return;
                case 5:
                    str2 = MimeTypes.AUDIO_MPEG_L2;
                    listSingletonList = null;
                    str3 = null;
                    i12 = 4096;
                    iD = -1;
                    bArr = this.N;
                    if (bArr != null) {
                        str3 = x6VarA.f24264c;
                        str2 = "video/dolby-vision";
                    }
                    boolean z16 = this.V;
                    if (this.U) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i26 = (z16 ? 1 : 0) | i13;
                    bVar = new f9.b();
                    if (Cif.g(str2)) {
                        bVar.c(this.O).n(this.Q).j(iD);
                        i18 = 1;
                    } else if (Cif.i(str2)) {
                        if (this.f24636q == 0) {
                            i16 = this.f24634o;
                            iIntValue = -1;
                            if (i16 == -1) {
                                i16 = this.f24632m;
                            }
                            this.f24634o = i16;
                            i17 = this.f24635p;
                            if (i17 == -1) {
                                i17 = this.f24633n;
                            }
                            this.f24635p = i17;
                        } else {
                            iIntValue = -1;
                        }
                        i14 = this.f24634o;
                        if (i14 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.f24643x) {
                        }
                        if (this.f24620a != null) {
                            iIntValue = ((Integer) yc.f24591g0.get(this.f24620a)).intValue();
                        }
                        if (this.f24637r == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        bVar.q(this.f24632m).g(this.f24633n).b(f11).m(i19).a(this.f24641v).p(this.f24642w).a(r3Var);
                        i18 = 2;
                    } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str2)) {
                        throw dh.a("Unexpected MIME type.", null);
                    }
                    if (this.f24620a != null) {
                        bVar.d(this.f24620a);
                    }
                    f9 f9VarA6 = bVar.h(i11).f(str2).i(i12).e(this.W).o(i26).a(listSingletonList).a(str3).a(this.f24631l).a();
                    qo qoVarA6 = m8Var.a(this.f24622c, i18);
                    this.X = qoVarA6;
                    qoVarA6.a(f9VarA6);
                    return;
                case 6:
                    str2 = MimeTypes.AUDIO_MPEG;
                    listSingletonList = null;
                    str3 = null;
                    i12 = 4096;
                    iD = -1;
                    bArr = this.N;
                    if (bArr != null) {
                        str3 = x6VarA.f24264c;
                        str2 = "video/dolby-vision";
                    }
                    boolean z17 = this.V;
                    if (this.U) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i27 = (z17 ? 1 : 0) | i13;
                    bVar = new f9.b();
                    if (Cif.g(str2)) {
                        bVar.c(this.O).n(this.Q).j(iD);
                        i18 = 1;
                    } else if (Cif.i(str2)) {
                        if (this.f24636q == 0) {
                            i16 = this.f24634o;
                            iIntValue = -1;
                            if (i16 == -1) {
                                i16 = this.f24632m;
                            }
                            this.f24634o = i16;
                            i17 = this.f24635p;
                            if (i17 == -1) {
                                i17 = this.f24633n;
                            }
                            this.f24635p = i17;
                        } else {
                            iIntValue = -1;
                        }
                        i14 = this.f24634o;
                        if (i14 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.f24643x) {
                        }
                        if (this.f24620a != null) {
                            iIntValue = ((Integer) yc.f24591g0.get(this.f24620a)).intValue();
                        }
                        if (this.f24637r == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        bVar.q(this.f24632m).g(this.f24633n).b(f11).m(i19).a(this.f24641v).p(this.f24642w).a(r3Var);
                        i18 = 2;
                    } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str2)) {
                        throw dh.a("Unexpected MIME type.", null);
                    }
                    if (this.f24620a != null) {
                        bVar.d(this.f24620a);
                    }
                    f9 f9VarA7 = bVar.h(i11).f(str2).i(i12).e(this.W).o(i27).a(listSingletonList).a(str3).a(this.f24631l).a();
                    qo qoVarA7 = m8Var.a(this.f24622c, i18);
                    this.X = qoVarA7;
                    qoVarA7.a(f9VarA7);
                    return;
                case 7:
                    Pair pairA = a(new bh(a(this.f24621b)));
                    str = (String) pairA.first;
                    listSingletonList = (List) pairA.second;
                    iD = -1;
                    str5 = str;
                    str6 = null;
                    str3 = str6;
                    str2 = str5;
                    i12 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                        str3 = x6VarA.f24264c;
                        str2 = "video/dolby-vision";
                    }
                    boolean z18 = this.V;
                    if (this.U) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i28 = (z18 ? 1 : 0) | i13;
                    bVar = new f9.b();
                    if (Cif.g(str2)) {
                        bVar.c(this.O).n(this.Q).j(iD);
                        i18 = 1;
                    } else if (Cif.i(str2)) {
                        if (this.f24636q == 0) {
                            i16 = this.f24634o;
                            iIntValue = -1;
                            if (i16 == -1) {
                                i16 = this.f24632m;
                            }
                            this.f24634o = i16;
                            i17 = this.f24635p;
                            if (i17 == -1) {
                                i17 = this.f24633n;
                            }
                            this.f24635p = i17;
                        } else {
                            iIntValue = -1;
                        }
                        i14 = this.f24634o;
                        if (i14 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.f24643x) {
                        }
                        if (this.f24620a != null) {
                            iIntValue = ((Integer) yc.f24591g0.get(this.f24620a)).intValue();
                        }
                        if (this.f24637r == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        bVar.q(this.f24632m).g(this.f24633n).b(f11).m(i19).a(this.f24641v).p(this.f24642w).a(r3Var);
                        i18 = 2;
                    } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str2)) {
                        throw dh.a("Unexpected MIME type.", null);
                    }
                    if (this.f24620a != null) {
                        bVar.d(this.f24620a);
                    }
                    f9 f9VarA8 = bVar.h(i11).f(str2).i(i12).e(this.W).o(i28).a(listSingletonList).a(str3).a(this.f24631l).a();
                    qo qoVarA8 = m8Var.a(this.f24622c, i18);
                    this.X = qoVarA8;
                    qoVarA8.a(f9VarA8);
                    return;
                case 8:
                    byte[] bArr3 = new byte[4];
                    System.arraycopy(a(this.f24621b), 0, bArr3, 0, 4);
                    listSingletonList = eb.a(bArr3);
                    str = MimeTypes.APPLICATION_DVBSUBS;
                    iD = -1;
                    str5 = str;
                    str6 = null;
                    str3 = str6;
                    str2 = str5;
                    i12 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                        str3 = x6VarA.f24264c;
                        str2 = "video/dolby-vision";
                    }
                    boolean z19 = this.V;
                    if (this.U) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i29 = (z19 ? 1 : 0) | i13;
                    bVar = new f9.b();
                    if (Cif.g(str2)) {
                        bVar.c(this.O).n(this.Q).j(iD);
                        i18 = 1;
                    } else if (Cif.i(str2)) {
                        if (this.f24636q == 0) {
                            i16 = this.f24634o;
                            iIntValue = -1;
                            if (i16 == -1) {
                                i16 = this.f24632m;
                            }
                            this.f24634o = i16;
                            i17 = this.f24635p;
                            if (i17 == -1) {
                                i17 = this.f24633n;
                            }
                            this.f24635p = i17;
                        } else {
                            iIntValue = -1;
                        }
                        i14 = this.f24634o;
                        if (i14 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.f24643x) {
                        }
                        if (this.f24620a != null) {
                            iIntValue = ((Integer) yc.f24591g0.get(this.f24620a)).intValue();
                        }
                        if (this.f24637r == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        bVar.q(this.f24632m).g(this.f24633n).b(f11).m(i19).a(this.f24641v).p(this.f24642w).a(r3Var);
                        i18 = 2;
                    } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str2)) {
                        throw dh.a("Unexpected MIME type.", null);
                    }
                    if (this.f24620a != null) {
                        bVar.d(this.f24620a);
                    }
                    f9 f9VarA9 = bVar.h(i11).f(str2).i(i12).e(this.W).o(i29).a(listSingletonList).a(str3).a(this.f24631l).a();
                    qo qoVarA9 = m8Var.a(this.f24622c, i18);
                    this.X = qoVarA9;
                    qoVarA9.a(f9VarA9);
                    return;
                case 10:
                    w1 w1VarB = w1.b(new bh(a(this.f24621b)));
                    list = w1VarB.f24005a;
                    this.Y = w1VarB.f24006b;
                    str4 = w1VarB.f24010f;
                    str5 = MimeTypes.VIDEO_H264;
                    iD = -1;
                    List list2 = list;
                    str6 = str4;
                    listSingletonList = list2;
                    str3 = str6;
                    str2 = str5;
                    i12 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                        str3 = x6VarA.f24264c;
                        str2 = "video/dolby-vision";
                    }
                    boolean z110 = this.V;
                    if (this.U) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i210 = (z110 ? 1 : 0) | i13;
                    bVar = new f9.b();
                    if (Cif.g(str2)) {
                        bVar.c(this.O).n(this.Q).j(iD);
                        i18 = 1;
                    } else if (Cif.i(str2)) {
                        if (this.f24636q == 0) {
                            i16 = this.f24634o;
                            iIntValue = -1;
                            if (i16 == -1) {
                                i16 = this.f24632m;
                            }
                            this.f24634o = i16;
                            i17 = this.f24635p;
                            if (i17 == -1) {
                                i17 = this.f24633n;
                            }
                            this.f24635p = i17;
                        } else {
                            iIntValue = -1;
                        }
                        i14 = this.f24634o;
                        if (i14 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.f24643x) {
                        }
                        if (this.f24620a != null) {
                            iIntValue = ((Integer) yc.f24591g0.get(this.f24620a)).intValue();
                        }
                        if (this.f24637r == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        bVar.q(this.f24632m).g(this.f24633n).b(f11).m(i19).a(this.f24641v).p(this.f24642w).a(r3Var);
                        i18 = 2;
                    } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str2)) {
                        throw dh.a("Unexpected MIME type.", null);
                    }
                    if (this.f24620a != null) {
                        bVar.d(this.f24620a);
                    }
                    f9 f9VarA10 = bVar.h(i11).f(str2).i(i12).e(this.W).o(i210).a(listSingletonList).a(str3).a(this.f24631l).a();
                    qo qoVarA10 = m8Var.a(this.f24622c, i18);
                    this.X = qoVarA10;
                    qoVarA10.a(f9VarA10);
                    return;
                case 11:
                    listSingletonList = eb.a(a(this.f24621b));
                    str = MimeTypes.APPLICATION_VOBSUB;
                    iD = -1;
                    str5 = str;
                    str6 = null;
                    str3 = str6;
                    str2 = str5;
                    i12 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                        str3 = x6VarA.f24264c;
                        str2 = "video/dolby-vision";
                    }
                    boolean z111 = this.V;
                    if (this.U) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i211 = (z111 ? 1 : 0) | i13;
                    bVar = new f9.b();
                    if (Cif.g(str2)) {
                        bVar.c(this.O).n(this.Q).j(iD);
                        i18 = 1;
                    } else if (Cif.i(str2)) {
                        if (this.f24636q == 0) {
                            i16 = this.f24634o;
                            iIntValue = -1;
                            if (i16 == -1) {
                                i16 = this.f24632m;
                            }
                            this.f24634o = i16;
                            i17 = this.f24635p;
                            if (i17 == -1) {
                                i17 = this.f24633n;
                            }
                            this.f24635p = i17;
                        } else {
                            iIntValue = -1;
                        }
                        i14 = this.f24634o;
                        if (i14 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.f24643x) {
                        }
                        if (this.f24620a != null) {
                            iIntValue = ((Integer) yc.f24591g0.get(this.f24620a)).intValue();
                        }
                        if (this.f24637r == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        bVar.q(this.f24632m).g(this.f24633n).b(f11).m(i19).a(this.f24641v).p(this.f24642w).a(r3Var);
                        i18 = 2;
                    } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str2)) {
                        throw dh.a("Unexpected MIME type.", null);
                    }
                    if (this.f24620a != null) {
                        bVar.d(this.f24620a);
                    }
                    f9 f9VarA11 = bVar.h(i11).f(str2).i(i12).e(this.W).o(i211).a(listSingletonList).a(str3).a(this.f24631l).a();
                    qo qoVarA11 = m8Var.a(this.f24622c, i18);
                    this.X = qoVarA11;
                    qoVarA11.a(f9VarA11);
                    return;
                case 12:
                    str8 = MimeTypes.AUDIO_DTS_HD;
                    iD = -1;
                    listSingletonList = null;
                    str = str8;
                    str5 = str;
                    str6 = null;
                    str3 = str6;
                    str2 = str5;
                    i12 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                        str3 = x6VarA.f24264c;
                        str2 = "video/dolby-vision";
                    }
                    boolean z112 = this.V;
                    if (this.U) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i212 = (z112 ? 1 : 0) | i13;
                    bVar = new f9.b();
                    if (Cif.g(str2)) {
                        bVar.c(this.O).n(this.Q).j(iD);
                        i18 = 1;
                    } else if (Cif.i(str2)) {
                        if (this.f24636q == 0) {
                            i16 = this.f24634o;
                            iIntValue = -1;
                            if (i16 == -1) {
                                i16 = this.f24632m;
                            }
                            this.f24634o = i16;
                            i17 = this.f24635p;
                            if (i17 == -1) {
                                i17 = this.f24633n;
                            }
                            this.f24635p = i17;
                        } else {
                            iIntValue = -1;
                        }
                        i14 = this.f24634o;
                        if (i14 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.f24643x) {
                        }
                        if (this.f24620a != null) {
                            iIntValue = ((Integer) yc.f24591g0.get(this.f24620a)).intValue();
                        }
                        if (this.f24637r == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        bVar.q(this.f24632m).g(this.f24633n).b(f11).m(i19).a(this.f24641v).p(this.f24642w).a(r3Var);
                        i18 = 2;
                    } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str2)) {
                        throw dh.a("Unexpected MIME type.", null);
                    }
                    if (this.f24620a != null) {
                        bVar.d(this.f24620a);
                    }
                    f9 f9VarA12 = bVar.h(i11).f(str2).i(i12).e(this.W).o(i212).a(listSingletonList).a(str3).a(this.f24631l).a();
                    qo qoVarA12 = m8Var.a(this.f24622c, i18);
                    this.X = qoVarA12;
                    qoVarA12.a(f9VarA12);
                    return;
                case 13:
                    listSingletonList = Collections.singletonList(a(this.f24621b));
                    com.applovin.impl.a.b bVarA = com.applovin.impl.a.a(this.f24630k);
                    this.Q = bVarA.f17404a;
                    this.O = bVarA.f17405b;
                    str6 = bVarA.f17406c;
                    str5 = MimeTypes.AUDIO_AAC;
                    iD = -1;
                    str3 = str6;
                    str2 = str5;
                    i12 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                        str3 = x6VarA.f24264c;
                        str2 = "video/dolby-vision";
                    }
                    boolean z113 = this.V;
                    if (this.U) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i213 = (z113 ? 1 : 0) | i13;
                    bVar = new f9.b();
                    if (Cif.g(str2)) {
                        bVar.c(this.O).n(this.Q).j(iD);
                        i18 = 1;
                    } else if (Cif.i(str2)) {
                        if (this.f24636q == 0) {
                            i16 = this.f24634o;
                            iIntValue = -1;
                            if (i16 == -1) {
                                i16 = this.f24632m;
                            }
                            this.f24634o = i16;
                            i17 = this.f24635p;
                            if (i17 == -1) {
                                i17 = this.f24633n;
                            }
                            this.f24635p = i17;
                        } else {
                            iIntValue = -1;
                        }
                        i14 = this.f24634o;
                        if (i14 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.f24643x) {
                        }
                        if (this.f24620a != null) {
                            iIntValue = ((Integer) yc.f24591g0.get(this.f24620a)).intValue();
                        }
                        if (this.f24637r == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        bVar.q(this.f24632m).g(this.f24633n).b(f11).m(i19).a(this.f24641v).p(this.f24642w).a(r3Var);
                        i18 = 2;
                    } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str2)) {
                        throw dh.a("Unexpected MIME type.", null);
                    }
                    if (this.f24620a != null) {
                        bVar.d(this.f24620a);
                    }
                    f9 f9VarA13 = bVar.h(i11).f(str2).i(i12).e(this.W).o(i213).a(listSingletonList).a(str3).a(this.f24631l).a();
                    qo qoVarA13 = m8Var.a(this.f24622c, i18);
                    this.X = qoVarA13;
                    qoVarA13.a(f9VarA13);
                    return;
                case 14:
                    str8 = MimeTypes.AUDIO_AC3;
                    iD = -1;
                    listSingletonList = null;
                    str = str8;
                    str5 = str;
                    str6 = null;
                    str3 = str6;
                    str2 = str5;
                    i12 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                        str3 = x6VarA.f24264c;
                        str2 = "video/dolby-vision";
                    }
                    boolean z114 = this.V;
                    if (this.U) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i214 = (z114 ? 1 : 0) | i13;
                    bVar = new f9.b();
                    if (Cif.g(str2)) {
                        bVar.c(this.O).n(this.Q).j(iD);
                        i18 = 1;
                    } else if (Cif.i(str2)) {
                        if (this.f24636q == 0) {
                            i16 = this.f24634o;
                            iIntValue = -1;
                            if (i16 == -1) {
                                i16 = this.f24632m;
                            }
                            this.f24634o = i16;
                            i17 = this.f24635p;
                            if (i17 == -1) {
                                i17 = this.f24633n;
                            }
                            this.f24635p = i17;
                        } else {
                            iIntValue = -1;
                        }
                        i14 = this.f24634o;
                        if (i14 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.f24643x) {
                        }
                        if (this.f24620a != null) {
                            iIntValue = ((Integer) yc.f24591g0.get(this.f24620a)).intValue();
                        }
                        if (this.f24637r == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        bVar.q(this.f24632m).g(this.f24633n).b(f11).m(i19).a(this.f24641v).p(this.f24642w).a(r3Var);
                        i18 = 2;
                    } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str2)) {
                        throw dh.a("Unexpected MIME type.", null);
                    }
                    if (this.f24620a != null) {
                        bVar.d(this.f24620a);
                    }
                    f9 f9VarA14 = bVar.h(i11).f(str2).i(i12).e(this.W).o(i214).a(listSingletonList).a(str3).a(this.f24631l).a();
                    qo qoVarA14 = m8Var.a(this.f24622c, i18);
                    this.X = qoVarA14;
                    qoVarA14.a(f9VarA14);
                    return;
                case 15:
                case 21:
                    str8 = MimeTypes.AUDIO_DTS;
                    iD = -1;
                    listSingletonList = null;
                    str = str8;
                    str5 = str;
                    str6 = null;
                    str3 = str6;
                    str2 = str5;
                    i12 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                        str3 = x6VarA.f24264c;
                        str2 = "video/dolby-vision";
                    }
                    boolean z115 = this.V;
                    if (this.U) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i215 = (z115 ? 1 : 0) | i13;
                    bVar = new f9.b();
                    if (Cif.g(str2)) {
                        bVar.c(this.O).n(this.Q).j(iD);
                        i18 = 1;
                    } else if (Cif.i(str2)) {
                        if (this.f24636q == 0) {
                            i16 = this.f24634o;
                            iIntValue = -1;
                            if (i16 == -1) {
                                i16 = this.f24632m;
                            }
                            this.f24634o = i16;
                            i17 = this.f24635p;
                            if (i17 == -1) {
                                i17 = this.f24633n;
                            }
                            this.f24635p = i17;
                        } else {
                            iIntValue = -1;
                        }
                        i14 = this.f24634o;
                        if (i14 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.f24643x) {
                        }
                        if (this.f24620a != null) {
                            iIntValue = ((Integer) yc.f24591g0.get(this.f24620a)).intValue();
                        }
                        if (this.f24637r == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        bVar.q(this.f24632m).g(this.f24633n).b(f11).m(i19).a(this.f24641v).p(this.f24642w).a(r3Var);
                        i18 = 2;
                    } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str2)) {
                        throw dh.a("Unexpected MIME type.", null);
                    }
                    if (this.f24620a != null) {
                        bVar.d(this.f24620a);
                    }
                    f9 f9VarA15 = bVar.h(i11).f(str2).i(i12).e(this.W).o(i215).a(listSingletonList).a(str3).a(this.f24631l).a();
                    qo qoVarA15 = m8Var.a(this.f24622c, i18);
                    this.X = qoVarA15;
                    qoVarA15.a(f9VarA15);
                    return;
                case 16:
                    str8 = "video/av01";
                    iD = -1;
                    listSingletonList = null;
                    str = str8;
                    str5 = str;
                    str6 = null;
                    str3 = str6;
                    str2 = str5;
                    i12 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                        str3 = x6VarA.f24264c;
                        str2 = "video/dolby-vision";
                    }
                    boolean z116 = this.V;
                    if (this.U) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i216 = (z116 ? 1 : 0) | i13;
                    bVar = new f9.b();
                    if (Cif.g(str2)) {
                        bVar.c(this.O).n(this.Q).j(iD);
                        i18 = 1;
                    } else if (Cif.i(str2)) {
                        if (this.f24636q == 0) {
                            i16 = this.f24634o;
                            iIntValue = -1;
                            if (i16 == -1) {
                                i16 = this.f24632m;
                            }
                            this.f24634o = i16;
                            i17 = this.f24635p;
                            if (i17 == -1) {
                                i17 = this.f24633n;
                            }
                            this.f24635p = i17;
                        } else {
                            iIntValue = -1;
                        }
                        i14 = this.f24634o;
                        if (i14 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.f24643x) {
                        }
                        if (this.f24620a != null) {
                            iIntValue = ((Integer) yc.f24591g0.get(this.f24620a)).intValue();
                        }
                        if (this.f24637r == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        bVar.q(this.f24632m).g(this.f24633n).b(f11).m(i19).a(this.f24641v).p(this.f24642w).a(r3Var);
                        i18 = 2;
                    } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str2)) {
                        throw dh.a("Unexpected MIME type.", null);
                    }
                    if (this.f24620a != null) {
                        bVar.d(this.f24620a);
                    }
                    f9 f9VarA16 = bVar.h(i11).f(str2).i(i12).e(this.W).o(i216).a(listSingletonList).a(str3).a(this.f24631l).a();
                    qo qoVarA16 = m8Var.a(this.f24622c, i18);
                    this.X = qoVarA16;
                    qoVarA16.a(f9VarA16);
                    return;
                case 17:
                    str8 = MimeTypes.VIDEO_VP8;
                    iD = -1;
                    listSingletonList = null;
                    str = str8;
                    str5 = str;
                    str6 = null;
                    str3 = str6;
                    str2 = str5;
                    i12 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                        str3 = x6VarA.f24264c;
                        str2 = "video/dolby-vision";
                    }
                    boolean z117 = this.V;
                    if (this.U) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i217 = (z117 ? 1 : 0) | i13;
                    bVar = new f9.b();
                    if (Cif.g(str2)) {
                        bVar.c(this.O).n(this.Q).j(iD);
                        i18 = 1;
                    } else if (Cif.i(str2)) {
                        if (this.f24636q == 0) {
                            i16 = this.f24634o;
                            iIntValue = -1;
                            if (i16 == -1) {
                                i16 = this.f24632m;
                            }
                            this.f24634o = i16;
                            i17 = this.f24635p;
                            if (i17 == -1) {
                                i17 = this.f24633n;
                            }
                            this.f24635p = i17;
                        } else {
                            iIntValue = -1;
                        }
                        i14 = this.f24634o;
                        if (i14 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.f24643x) {
                        }
                        if (this.f24620a != null) {
                            iIntValue = ((Integer) yc.f24591g0.get(this.f24620a)).intValue();
                        }
                        if (this.f24637r == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        bVar.q(this.f24632m).g(this.f24633n).b(f11).m(i19).a(this.f24641v).p(this.f24642w).a(r3Var);
                        i18 = 2;
                    } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str2)) {
                        throw dh.a("Unexpected MIME type.", null);
                    }
                    if (this.f24620a != null) {
                        bVar.d(this.f24620a);
                    }
                    f9 f9VarA17 = bVar.h(i11).f(str2).i(i12).e(this.W).o(i217).a(listSingletonList).a(str3).a(this.f24631l).a();
                    qo qoVarA17 = m8Var.a(this.f24622c, i18);
                    this.X = qoVarA17;
                    qoVarA17.a(f9VarA17);
                    return;
                case 18:
                    str8 = MimeTypes.VIDEO_VP9;
                    iD = -1;
                    listSingletonList = null;
                    str = str8;
                    str5 = str;
                    str6 = null;
                    str3 = str6;
                    str2 = str5;
                    i12 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                        str3 = x6VarA.f24264c;
                        str2 = "video/dolby-vision";
                    }
                    boolean z118 = this.V;
                    if (this.U) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i218 = (z118 ? 1 : 0) | i13;
                    bVar = new f9.b();
                    if (Cif.g(str2)) {
                        bVar.c(this.O).n(this.Q).j(iD);
                        i18 = 1;
                    } else if (Cif.i(str2)) {
                        if (this.f24636q == 0) {
                            i16 = this.f24634o;
                            iIntValue = -1;
                            if (i16 == -1) {
                                i16 = this.f24632m;
                            }
                            this.f24634o = i16;
                            i17 = this.f24635p;
                            if (i17 == -1) {
                                i17 = this.f24633n;
                            }
                            this.f24635p = i17;
                        } else {
                            iIntValue = -1;
                        }
                        i14 = this.f24634o;
                        if (i14 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.f24643x) {
                        }
                        if (this.f24620a != null) {
                            iIntValue = ((Integer) yc.f24591g0.get(this.f24620a)).intValue();
                        }
                        if (this.f24637r == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        bVar.q(this.f24632m).g(this.f24633n).b(f11).m(i19).a(this.f24641v).p(this.f24642w).a(r3Var);
                        i18 = 2;
                    } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str2)) {
                        throw dh.a("Unexpected MIME type.", null);
                    }
                    if (this.f24620a != null) {
                        bVar.d(this.f24620a);
                    }
                    f9 f9VarA18 = bVar.h(i11).f(str2).i(i12).e(this.W).o(i218).a(listSingletonList).a(str3).a(this.f24631l).a();
                    qo qoVarA18 = m8Var.a(this.f24622c, i18);
                    this.X = qoVarA18;
                    qoVarA18.a(f9VarA18);
                    return;
                case 19:
                    str8 = MimeTypes.APPLICATION_PGS;
                    iD = -1;
                    listSingletonList = null;
                    str = str8;
                    str5 = str;
                    str6 = null;
                    str3 = str6;
                    str2 = str5;
                    i12 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                        str3 = x6VarA.f24264c;
                        str2 = "video/dolby-vision";
                    }
                    boolean z119 = this.V;
                    if (this.U) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i219 = (z119 ? 1 : 0) | i13;
                    bVar = new f9.b();
                    if (Cif.g(str2)) {
                        bVar.c(this.O).n(this.Q).j(iD);
                        i18 = 1;
                    } else if (Cif.i(str2)) {
                        if (this.f24636q == 0) {
                            i16 = this.f24634o;
                            iIntValue = -1;
                            if (i16 == -1) {
                                i16 = this.f24632m;
                            }
                            this.f24634o = i16;
                            i17 = this.f24635p;
                            if (i17 == -1) {
                                i17 = this.f24633n;
                            }
                            this.f24635p = i17;
                        } else {
                            iIntValue = -1;
                        }
                        i14 = this.f24634o;
                        if (i14 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.f24643x) {
                        }
                        if (this.f24620a != null) {
                            iIntValue = ((Integer) yc.f24591g0.get(this.f24620a)).intValue();
                        }
                        if (this.f24637r == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        bVar.q(this.f24632m).g(this.f24633n).b(f11).m(i19).a(this.f24641v).p(this.f24642w).a(r3Var);
                        i18 = 2;
                    } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str2)) {
                        throw dh.a("Unexpected MIME type.", null);
                    }
                    if (this.f24620a != null) {
                        bVar.d(this.f24620a);
                    }
                    f9 f9VarA19 = bVar.h(i11).f(str2).i(i12).e(this.W).o(i219).a(listSingletonList).a(str3).a(this.f24631l).a();
                    qo qoVarA19 = m8Var.a(this.f24622c, i18);
                    this.X = qoVarA19;
                    qoVarA19.a(f9VarA19);
                    return;
                case 20:
                    str8 = MimeTypes.VIDEO_UNKNOWN;
                    iD = -1;
                    listSingletonList = null;
                    str = str8;
                    str5 = str;
                    str6 = null;
                    str3 = str6;
                    str2 = str5;
                    i12 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                        str3 = x6VarA.f24264c;
                        str2 = "video/dolby-vision";
                    }
                    boolean z1110 = this.V;
                    if (this.U) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i2110 = (z1110 ? 1 : 0) | i13;
                    bVar = new f9.b();
                    if (Cif.g(str2)) {
                        bVar.c(this.O).n(this.Q).j(iD);
                        i18 = 1;
                    } else if (Cif.i(str2)) {
                        if (this.f24636q == 0) {
                            i16 = this.f24634o;
                            iIntValue = -1;
                            if (i16 == -1) {
                                i16 = this.f24632m;
                            }
                            this.f24634o = i16;
                            i17 = this.f24635p;
                            if (i17 == -1) {
                                i17 = this.f24633n;
                            }
                            this.f24635p = i17;
                        } else {
                            iIntValue = -1;
                        }
                        i14 = this.f24634o;
                        if (i14 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.f24643x) {
                        }
                        if (this.f24620a != null) {
                            iIntValue = ((Integer) yc.f24591g0.get(this.f24620a)).intValue();
                        }
                        if (this.f24637r == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        bVar.q(this.f24632m).g(this.f24633n).b(f11).m(i19).a(this.f24641v).p(this.f24642w).a(r3Var);
                        i18 = 2;
                    } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str2)) {
                        throw dh.a("Unexpected MIME type.", null);
                    }
                    if (this.f24620a != null) {
                        bVar.d(this.f24620a);
                    }
                    f9 f9VarA110 = bVar.h(i11).f(str2).i(i12).e(this.W).o(i2110).a(listSingletonList).a(str3).a(this.f24631l).a();
                    qo qoVarA110 = m8Var.a(this.f24622c, i18);
                    this.X = qoVarA110;
                    qoVarA110.a(f9VarA110);
                    return;
                case 22:
                    if (this.P != 32) {
                        pc.d("MatroskaExtractor", "Unsupported floating point PCM bit depth: " + this.P + ". Setting mimeType to " + MimeTypes.AUDIO_UNKNOWN);
                        str8 = MimeTypes.AUDIO_UNKNOWN;
                        iD = -1;
                    }
                    listSingletonList = null;
                    str = str8;
                    str5 = str;
                    str6 = null;
                    str3 = str6;
                    str2 = str5;
                    i12 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                        str3 = x6VarA.f24264c;
                        str2 = "video/dolby-vision";
                    }
                    boolean z1111 = this.V;
                    if (this.U) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i2111 = (z1111 ? 1 : 0) | i13;
                    bVar = new f9.b();
                    if (Cif.g(str2)) {
                        bVar.c(this.O).n(this.Q).j(iD);
                        i18 = 1;
                    } else if (Cif.i(str2)) {
                        if (this.f24636q == 0) {
                            i16 = this.f24634o;
                            iIntValue = -1;
                            if (i16 == -1) {
                                i16 = this.f24632m;
                            }
                            this.f24634o = i16;
                            i17 = this.f24635p;
                            if (i17 == -1) {
                                i17 = this.f24633n;
                            }
                            this.f24635p = i17;
                        } else {
                            iIntValue = -1;
                        }
                        i14 = this.f24634o;
                        if (i14 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.f24643x) {
                        }
                        if (this.f24620a != null) {
                            iIntValue = ((Integer) yc.f24591g0.get(this.f24620a)).intValue();
                        }
                        if (this.f24637r == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        bVar.q(this.f24632m).g(this.f24633n).b(f11).m(i19).a(this.f24641v).p(this.f24642w).a(r3Var);
                        i18 = 2;
                    } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str2)) {
                        throw dh.a("Unexpected MIME type.", null);
                    }
                    if (this.f24620a != null) {
                        bVar.d(this.f24620a);
                    }
                    f9 f9VarA111 = bVar.h(i11).f(str2).i(i12).e(this.W).o(i2111).a(listSingletonList).a(str3).a(this.f24631l).a();
                    qo qoVarA111 = m8Var.a(this.f24622c, i18);
                    this.X = qoVarA111;
                    qoVarA111.a(f9VarA111);
                    return;
                case 23:
                    int i31 = this.P;
                    if (i31 == 8) {
                        iD = 3;
                    } else if (i31 == 16) {
                        iD = ASTNode.DEOP;
                    } else {
                        pc.d("MatroskaExtractor", "Unsupported big endian PCM bit depth: " + this.P + ". Setting mimeType to " + MimeTypes.AUDIO_UNKNOWN);
                        str8 = MimeTypes.AUDIO_UNKNOWN;
                        iD = -1;
                    }
                    listSingletonList = null;
                    str = str8;
                    str5 = str;
                    str6 = null;
                    str3 = str6;
                    str2 = str5;
                    i12 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                        str3 = x6VarA.f24264c;
                        str2 = "video/dolby-vision";
                    }
                    boolean z1112 = this.V;
                    if (this.U) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i2112 = (z1112 ? 1 : 0) | i13;
                    bVar = new f9.b();
                    if (Cif.g(str2)) {
                        bVar.c(this.O).n(this.Q).j(iD);
                        i18 = 1;
                    } else if (Cif.i(str2)) {
                        if (this.f24636q == 0) {
                            i16 = this.f24634o;
                            iIntValue = -1;
                            if (i16 == -1) {
                                i16 = this.f24632m;
                            }
                            this.f24634o = i16;
                            i17 = this.f24635p;
                            if (i17 == -1) {
                                i17 = this.f24633n;
                            }
                            this.f24635p = i17;
                        } else {
                            iIntValue = -1;
                        }
                        i14 = this.f24634o;
                        if (i14 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.f24643x) {
                        }
                        if (this.f24620a != null) {
                            iIntValue = ((Integer) yc.f24591g0.get(this.f24620a)).intValue();
                        }
                        if (this.f24637r == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        bVar.q(this.f24632m).g(this.f24633n).b(f11).m(i19).a(this.f24641v).p(this.f24642w).a(r3Var);
                        i18 = 2;
                    } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str2)) {
                        throw dh.a("Unexpected MIME type.", null);
                    }
                    if (this.f24620a != null) {
                        bVar.d(this.f24620a);
                    }
                    f9 f9VarA112 = bVar.h(i11).f(str2).i(i12).e(this.W).o(i2112).a(listSingletonList).a(str3).a(this.f24631l).a();
                    qo qoVarA112 = m8Var.a(this.f24622c, i18);
                    this.X = qoVarA112;
                    qoVarA112.a(f9VarA112);
                    return;
                case 24:
                    iD = xp.d(this.P);
                    if (iD == 0) {
                        pc.d("MatroskaExtractor", "Unsupported little endian PCM bit depth: " + this.P + ". Setting mimeType to " + MimeTypes.AUDIO_UNKNOWN);
                        str8 = MimeTypes.AUDIO_UNKNOWN;
                        iD = -1;
                    }
                    listSingletonList = null;
                    str = str8;
                    str5 = str;
                    str6 = null;
                    str3 = str6;
                    str2 = str5;
                    i12 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                        str3 = x6VarA.f24264c;
                        str2 = "video/dolby-vision";
                    }
                    boolean z1113 = this.V;
                    if (this.U) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i2113 = (z1113 ? 1 : 0) | i13;
                    bVar = new f9.b();
                    if (Cif.g(str2)) {
                        bVar.c(this.O).n(this.Q).j(iD);
                        i18 = 1;
                    } else if (Cif.i(str2)) {
                        if (this.f24636q == 0) {
                            i16 = this.f24634o;
                            iIntValue = -1;
                            if (i16 == -1) {
                                i16 = this.f24632m;
                            }
                            this.f24634o = i16;
                            i17 = this.f24635p;
                            if (i17 == -1) {
                                i17 = this.f24633n;
                            }
                            this.f24635p = i17;
                        } else {
                            iIntValue = -1;
                        }
                        i14 = this.f24634o;
                        if (i14 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.f24643x) {
                        }
                        if (this.f24620a != null) {
                            iIntValue = ((Integer) yc.f24591g0.get(this.f24620a)).intValue();
                        }
                        if (this.f24637r == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        bVar.q(this.f24632m).g(this.f24633n).b(f11).m(i19).a(this.f24641v).p(this.f24642w).a(r3Var);
                        i18 = 2;
                    } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str2)) {
                        throw dh.a("Unexpected MIME type.", null);
                    }
                    if (this.f24620a != null) {
                        bVar.d(this.f24620a);
                    }
                    f9 f9VarA113 = bVar.h(i11).f(str2).i(i12).e(this.W).o(i2113).a(listSingletonList).a(str3).a(this.f24631l).a();
                    qo qoVarA113 = m8Var.a(this.f24622c, i18);
                    this.X = qoVarA113;
                    qoVarA113.a(f9VarA113);
                    return;
                case 25:
                    listSingletonList = eb.a(yc.f24588d0, a(this.f24621b));
                    str = MimeTypes.TEXT_SSA;
                    iD = -1;
                    str5 = str;
                    str6 = null;
                    str3 = str6;
                    str2 = str5;
                    i12 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                        str3 = x6VarA.f24264c;
                        str2 = "video/dolby-vision";
                    }
                    boolean z1114 = this.V;
                    if (this.U) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i2114 = (z1114 ? 1 : 0) | i13;
                    bVar = new f9.b();
                    if (Cif.g(str2)) {
                        bVar.c(this.O).n(this.Q).j(iD);
                        i18 = 1;
                    } else if (Cif.i(str2)) {
                        if (this.f24636q == 0) {
                            i16 = this.f24634o;
                            iIntValue = -1;
                            if (i16 == -1) {
                                i16 = this.f24632m;
                            }
                            this.f24634o = i16;
                            i17 = this.f24635p;
                            if (i17 == -1) {
                                i17 = this.f24633n;
                            }
                            this.f24635p = i17;
                        } else {
                            iIntValue = -1;
                        }
                        i14 = this.f24634o;
                        if (i14 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.f24643x) {
                        }
                        if (this.f24620a != null) {
                            iIntValue = ((Integer) yc.f24591g0.get(this.f24620a)).intValue();
                        }
                        if (this.f24637r == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        bVar.q(this.f24632m).g(this.f24633n).b(f11).m(i19).a(this.f24641v).p(this.f24642w).a(r3Var);
                        i18 = 2;
                    } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str2)) {
                        throw dh.a("Unexpected MIME type.", null);
                    }
                    if (this.f24620a != null) {
                        bVar.d(this.f24620a);
                    }
                    f9 f9VarA114 = bVar.h(i11).f(str2).i(i12).e(this.W).o(i2114).a(listSingletonList).a(str3).a(this.f24631l).a();
                    qo qoVarA114 = m8Var.a(this.f24622c, i18);
                    this.X = qoVarA114;
                    qoVarA114.a(f9VarA114);
                    return;
                case 26:
                    oa oaVarA = oa.a(new bh(a(this.f24621b)));
                    list = oaVarA.f21477a;
                    this.Y = oaVarA.f21478b;
                    str4 = oaVarA.f21479c;
                    str5 = MimeTypes.VIDEO_H265;
                    iD = -1;
                    List list3 = list;
                    str6 = str4;
                    listSingletonList = list3;
                    str3 = str6;
                    str2 = str5;
                    i12 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                        str3 = x6VarA.f24264c;
                        str2 = "video/dolby-vision";
                    }
                    boolean z1115 = this.V;
                    if (this.U) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i2115 = (z1115 ? 1 : 0) | i13;
                    bVar = new f9.b();
                    if (Cif.g(str2)) {
                        bVar.c(this.O).n(this.Q).j(iD);
                        i18 = 1;
                    } else if (Cif.i(str2)) {
                        if (this.f24636q == 0) {
                            i16 = this.f24634o;
                            iIntValue = -1;
                            if (i16 == -1) {
                                i16 = this.f24632m;
                            }
                            this.f24634o = i16;
                            i17 = this.f24635p;
                            if (i17 == -1) {
                                i17 = this.f24633n;
                            }
                            this.f24635p = i17;
                        } else {
                            iIntValue = -1;
                        }
                        i14 = this.f24634o;
                        if (i14 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.f24643x) {
                        }
                        if (this.f24620a != null) {
                            iIntValue = ((Integer) yc.f24591g0.get(this.f24620a)).intValue();
                        }
                        if (this.f24637r == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        bVar.q(this.f24632m).g(this.f24633n).b(f11).m(i19).a(this.f24641v).p(this.f24642w).a(r3Var);
                        i18 = 2;
                    } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str2)) {
                        throw dh.a("Unexpected MIME type.", null);
                    }
                    if (this.f24620a != null) {
                        bVar.d(this.f24620a);
                    }
                    f9 f9VarA115 = bVar.h(i11).f(str2).i(i12).e(this.W).o(i2115).a(listSingletonList).a(str3).a(this.f24631l).a();
                    qo qoVarA115 = m8Var.a(this.f24622c, i18);
                    this.X = qoVarA115;
                    qoVarA115.a(f9VarA115);
                    return;
                case 27:
                    str8 = MimeTypes.APPLICATION_SUBRIP;
                    iD = -1;
                    listSingletonList = null;
                    str = str8;
                    str5 = str;
                    str6 = null;
                    str3 = str6;
                    str2 = str5;
                    i12 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                        str3 = x6VarA.f24264c;
                        str2 = "video/dolby-vision";
                    }
                    boolean z1116 = this.V;
                    if (this.U) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i2116 = (z1116 ? 1 : 0) | i13;
                    bVar = new f9.b();
                    if (Cif.g(str2)) {
                        bVar.c(this.O).n(this.Q).j(iD);
                        i18 = 1;
                    } else if (Cif.i(str2)) {
                        if (this.f24636q == 0) {
                            i16 = this.f24634o;
                            iIntValue = -1;
                            if (i16 == -1) {
                                i16 = this.f24632m;
                            }
                            this.f24634o = i16;
                            i17 = this.f24635p;
                            if (i17 == -1) {
                                i17 = this.f24633n;
                            }
                            this.f24635p = i17;
                        } else {
                            iIntValue = -1;
                        }
                        i14 = this.f24634o;
                        if (i14 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.f24643x) {
                        }
                        if (this.f24620a != null) {
                            iIntValue = ((Integer) yc.f24591g0.get(this.f24620a)).intValue();
                        }
                        if (this.f24637r == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        bVar.q(this.f24632m).g(this.f24633n).b(f11).m(i19).a(this.f24641v).p(this.f24642w).a(r3Var);
                        i18 = 2;
                    } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str2)) {
                        throw dh.a("Unexpected MIME type.", null);
                    }
                    if (this.f24620a != null) {
                        bVar.d(this.f24620a);
                    }
                    f9 f9VarA116 = bVar.h(i11).f(str2).i(i12).e(this.W).o(i2116).a(listSingletonList).a(str3).a(this.f24631l).a();
                    qo qoVarA116 = m8Var.a(this.f24622c, i18);
                    this.X = qoVarA116;
                    qoVarA116.a(f9VarA116);
                    return;
                case 28:
                    str8 = MimeTypes.VIDEO_MPEG2;
                    iD = -1;
                    listSingletonList = null;
                    str = str8;
                    str5 = str;
                    str6 = null;
                    str3 = str6;
                    str2 = str5;
                    i12 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                        str3 = x6VarA.f24264c;
                        str2 = "video/dolby-vision";
                    }
                    boolean z1117 = this.V;
                    if (this.U) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i2117 = (z1117 ? 1 : 0) | i13;
                    bVar = new f9.b();
                    if (Cif.g(str2)) {
                        bVar.c(this.O).n(this.Q).j(iD);
                        i18 = 1;
                    } else if (Cif.i(str2)) {
                        if (this.f24636q == 0) {
                            i16 = this.f24634o;
                            iIntValue = -1;
                            if (i16 == -1) {
                                i16 = this.f24632m;
                            }
                            this.f24634o = i16;
                            i17 = this.f24635p;
                            if (i17 == -1) {
                                i17 = this.f24633n;
                            }
                            this.f24635p = i17;
                        } else {
                            iIntValue = -1;
                        }
                        i14 = this.f24634o;
                        if (i14 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.f24643x) {
                        }
                        if (this.f24620a != null) {
                            iIntValue = ((Integer) yc.f24591g0.get(this.f24620a)).intValue();
                        }
                        if (this.f24637r == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        bVar.q(this.f24632m).g(this.f24633n).b(f11).m(i19).a(this.f24641v).p(this.f24642w).a(r3Var);
                        i18 = 2;
                    } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str2)) {
                        throw dh.a("Unexpected MIME type.", null);
                    }
                    if (this.f24620a != null) {
                        bVar.d(this.f24620a);
                    }
                    f9 f9VarA117 = bVar.h(i11).f(str2).i(i12).e(this.W).o(i2117).a(listSingletonList).a(str3).a(this.f24631l).a();
                    qo qoVarA117 = m8Var.a(this.f24622c, i18);
                    this.X = qoVarA117;
                    qoVarA117.a(f9VarA117);
                    return;
                case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                    str8 = MimeTypes.AUDIO_E_AC3;
                    iD = -1;
                    listSingletonList = null;
                    str = str8;
                    str5 = str;
                    str6 = null;
                    str3 = str6;
                    str2 = str5;
                    i12 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                        str3 = x6VarA.f24264c;
                        str2 = "video/dolby-vision";
                    }
                    boolean z1118 = this.V;
                    if (this.U) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i2118 = (z1118 ? 1 : 0) | i13;
                    bVar = new f9.b();
                    if (Cif.g(str2)) {
                        bVar.c(this.O).n(this.Q).j(iD);
                        i18 = 1;
                    } else if (Cif.i(str2)) {
                        if (this.f24636q == 0) {
                            i16 = this.f24634o;
                            iIntValue = -1;
                            if (i16 == -1) {
                                i16 = this.f24632m;
                            }
                            this.f24634o = i16;
                            i17 = this.f24635p;
                            if (i17 == -1) {
                                i17 = this.f24633n;
                            }
                            this.f24635p = i17;
                        } else {
                            iIntValue = -1;
                        }
                        i14 = this.f24634o;
                        if (i14 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.f24643x) {
                        }
                        if (this.f24620a != null) {
                            iIntValue = ((Integer) yc.f24591g0.get(this.f24620a)).intValue();
                        }
                        if (this.f24637r == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        bVar.q(this.f24632m).g(this.f24633n).b(f11).m(i19).a(this.f24641v).p(this.f24642w).a(r3Var);
                        i18 = 2;
                    } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str2)) {
                        throw dh.a("Unexpected MIME type.", null);
                    }
                    if (this.f24620a != null) {
                        bVar.d(this.f24620a);
                    }
                    f9 f9VarA118 = bVar.h(i11).f(str2).i(i12).e(this.W).o(i2118).a(listSingletonList).a(str3).a(this.f24631l).a();
                    qo qoVarA118 = m8Var.a(this.f24622c, i18);
                    this.X = qoVarA118;
                    qoVarA118.a(f9VarA118);
                    return;
                case 30:
                    listSingletonList = Collections.singletonList(a(this.f24621b));
                    str = MimeTypes.AUDIO_FLAC;
                    iD = -1;
                    str5 = str;
                    str6 = null;
                    str3 = str6;
                    str2 = str5;
                    i12 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                        str3 = x6VarA.f24264c;
                        str2 = "video/dolby-vision";
                    }
                    boolean z1119 = this.V;
                    if (this.U) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i2119 = (z1119 ? 1 : 0) | i13;
                    bVar = new f9.b();
                    if (Cif.g(str2)) {
                        bVar.c(this.O).n(this.Q).j(iD);
                        i18 = 1;
                    } else if (Cif.i(str2)) {
                        if (this.f24636q == 0) {
                            i16 = this.f24634o;
                            iIntValue = -1;
                            if (i16 == -1) {
                                i16 = this.f24632m;
                            }
                            this.f24634o = i16;
                            i17 = this.f24635p;
                            if (i17 == -1) {
                                i17 = this.f24633n;
                            }
                            this.f24635p = i17;
                        } else {
                            iIntValue = -1;
                        }
                        i14 = this.f24634o;
                        if (i14 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.f24643x) {
                        }
                        if (this.f24620a != null) {
                            iIntValue = ((Integer) yc.f24591g0.get(this.f24620a)).intValue();
                        }
                        if (this.f24637r == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        bVar.q(this.f24632m).g(this.f24633n).b(f11).m(i19).a(this.f24641v).p(this.f24642w).a(r3Var);
                        i18 = 2;
                    } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str2)) {
                        throw dh.a("Unexpected MIME type.", null);
                    }
                    if (this.f24620a != null) {
                        bVar.d(this.f24620a);
                    }
                    f9 f9VarA119 = bVar.h(i11).f(str2).i(i12).e(this.W).o(i2119).a(listSingletonList).a(str3).a(this.f24631l).a();
                    qo qoVarA119 = m8Var.a(this.f24622c, i18);
                    this.X = qoVarA119;
                    qoVarA119.a(f9VarA119);
                    return;
                case VungleException.WEB_CRASH /* 31 */:
                    listSingletonList = new ArrayList(3);
                    listSingletonList.add(a(this.f24621b));
                    ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
                    ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                    listSingletonList.add(byteBufferAllocate.order(byteOrder).putLong(this.R).array());
                    listSingletonList.add(ByteBuffer.allocate(8).order(byteOrder).putLong(this.S).array());
                    str2 = MimeTypes.AUDIO_OPUS;
                    i12 = 5760;
                    str3 = null;
                    iD = -1;
                    bArr = this.N;
                    if (bArr != null) {
                        str3 = x6VarA.f24264c;
                        str2 = "video/dolby-vision";
                    }
                    boolean z11110 = this.V;
                    if (this.U) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i21110 = (z11110 ? 1 : 0) | i13;
                    bVar = new f9.b();
                    if (Cif.g(str2)) {
                        bVar.c(this.O).n(this.Q).j(iD);
                        i18 = 1;
                    } else if (Cif.i(str2)) {
                        if (this.f24636q == 0) {
                            i16 = this.f24634o;
                            iIntValue = -1;
                            if (i16 == -1) {
                                i16 = this.f24632m;
                            }
                            this.f24634o = i16;
                            i17 = this.f24635p;
                            if (i17 == -1) {
                                i17 = this.f24633n;
                            }
                            this.f24635p = i17;
                        } else {
                            iIntValue = -1;
                        }
                        i14 = this.f24634o;
                        if (i14 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.f24643x) {
                        }
                        if (this.f24620a != null) {
                            iIntValue = ((Integer) yc.f24591g0.get(this.f24620a)).intValue();
                        }
                        if (this.f24637r == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        bVar.q(this.f24632m).g(this.f24633n).b(f11).m(i19).a(this.f24641v).p(this.f24642w).a(r3Var);
                        i18 = 2;
                    } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str2)) {
                        throw dh.a("Unexpected MIME type.", null);
                    }
                    if (this.f24620a != null) {
                        bVar.d(this.f24620a);
                    }
                    f9 f9VarA1110 = bVar.h(i11).f(str2).i(i12).e(this.W).o(i21110).a(listSingletonList).a(str3).a(this.f24631l).a();
                    qo qoVarA1110 = m8Var.a(this.f24622c, i18);
                    this.X = qoVarA1110;
                    qoVarA1110.a(f9VarA1110);
                    return;
                default:
                    throw dh.a("Unrecognized codec identifier.", null);
            }
        }

        public void c() {
            d dVar = this.T;
            if (dVar != null) {
                dVar.a(this);
            }
        }

        public void d() {
            d dVar = this.T;
            if (dVar != null) {
                dVar.a();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final byte[] f24646a = new byte[10];

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f24647b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f24648c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f24649d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f24650e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f24651f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f24652g;

        public void a() {
            this.f24647b = false;
            this.f24648c = 0;
        }

        public void a(l8 l8Var) {
            if (this.f24647b) {
                return;
            }
            l8Var.c(this.f24646a, 0, 10);
            l8Var.b();
            if (k.b(this.f24646a) == 0) {
                return;
            }
            this.f24647b = true;
        }

        public void a(c cVar) {
            if (this.f24648c > 0) {
                cVar.X.a(this.f24649d, this.f24650e, this.f24651f, this.f24652g, cVar.f24629j);
                this.f24648c = 0;
            }
        }

        public void a(c cVar, long j11, int i11, int i12, int i13) {
            if (this.f24647b) {
                int i14 = this.f24648c;
                int i15 = i14 + 1;
                this.f24648c = i15;
                if (i14 == 0) {
                    this.f24649d = j11;
                    this.f24650e = i11;
                    this.f24651f = 0;
                }
                this.f24651f += i12;
                this.f24652g = i13;
                if (i15 >= 16) {
                    a(cVar);
                }
            }
        }
    }

    static {
        HashMap map = new HashMap();
        map.put("htc_video_rotA-000", 0);
        map.put("htc_video_rotA-090", 90);
        map.put("htc_video_rotA-180", 180);
        map.put("htc_video_rotA-270", 270);
        f24591g0 = Collections.unmodifiableMap(map);
    }

    public yc() {
        this(0);
    }

    public yc(int i11) {
        this(new a6(), i11);
    }

    public yc(p7 p7Var, int i11) {
        this.f24609q = -1L;
        this.f24610r = C.TIME_UNSET;
        this.f24611s = C.TIME_UNSET;
        this.f24612t = C.TIME_UNSET;
        this.f24618z = -1L;
        this.A = -1L;
        this.B = C.TIME_UNSET;
        this.f24592a = p7Var;
        p7Var.a(new b());
        this.f24596d = (i11 & 1) == 0;
        this.f24594b = new zp();
        this.f24595c = new SparseArray();
        this.f24599g = new bh(4);
        this.f24600h = new bh(ByteBuffer.allocate(4).putInt(-1).array());
        this.f24601i = new bh(4);
        this.f24597e = new bh(zf.f24845a);
        this.f24598f = new bh(4);
        this.f24602j = new bh();
        this.f24603k = new bh();
        this.f24604l = new bh(8);
        this.f24605m = new bh();
        this.f24606n = new bh();
        this.L = new int[1];
    }

    private int a(l8 l8Var, qo qoVar, int i11) {
        int iA = this.f24602j.a();
        if (iA <= 0) {
            return qoVar.a((g5) l8Var, i11, false);
        }
        int iMin = Math.min(i11, iA);
        qoVar.a(this.f24602j, iMin);
        return iMin;
    }

    private int a(l8 l8Var, c cVar, int i11) throws dh {
        int i12;
        if ("S_TEXT/UTF8".equals(cVar.f24621b)) {
            a(l8Var, f24587c0, i11);
            return f();
        }
        if ("S_TEXT/ASS".equals(cVar.f24621b)) {
            a(l8Var, f24589e0, i11);
            return f();
        }
        qo qoVar = cVar.X;
        if (!this.U) {
            if (cVar.f24627h) {
                this.O &= -1073741825;
                if (!this.V) {
                    l8Var.d(this.f24599g.c(), 0, 1);
                    this.R++;
                    if ((this.f24599g.c()[0] & 128) == 128) {
                        throw dh.a("Extension bit is set in signal byte", null);
                    }
                    this.Y = this.f24599g.c()[0];
                    this.V = true;
                }
                byte b11 = this.Y;
                if ((b11 & 1) == 1) {
                    boolean z11 = (b11 & 2) == 2;
                    this.O |= 1073741824;
                    if (!this.Z) {
                        l8Var.d(this.f24604l.c(), 0, 8);
                        this.R += 8;
                        this.Z = true;
                        this.f24599g.c()[0] = (byte) ((z11 ? 128 : 0) | 8);
                        this.f24599g.f(0);
                        qoVar.a(this.f24599g, 1, 1);
                        this.S++;
                        this.f24604l.f(0);
                        qoVar.a(this.f24604l, 8, 1);
                        this.S += 8;
                    }
                    if (z11) {
                        if (!this.W) {
                            l8Var.d(this.f24599g.c(), 0, 1);
                            this.R++;
                            this.f24599g.f(0);
                            this.X = this.f24599g.w();
                            this.W = true;
                        }
                        int i13 = this.X * 4;
                        this.f24599g.d(i13);
                        l8Var.d(this.f24599g.c(), 0, i13);
                        this.R += i13;
                        short s11 = (short) ((this.X / 2) + 1);
                        int i14 = (s11 * 6) + 2;
                        ByteBuffer byteBuffer = this.f24607o;
                        if (byteBuffer == null || byteBuffer.capacity() < i14) {
                            this.f24607o = ByteBuffer.allocate(i14);
                        }
                        this.f24607o.position(0);
                        this.f24607o.putShort(s11);
                        int i15 = 0;
                        int i16 = 0;
                        while (true) {
                            i12 = this.X;
                            if (i15 >= i12) {
                                break;
                            }
                            int iA = this.f24599g.A();
                            if (i15 % 2 == 0) {
                                this.f24607o.putShort((short) (iA - i16));
                            } else {
                                this.f24607o.putInt(iA - i16);
                            }
                            i15++;
                            i16 = iA;
                        }
                        int i17 = (i11 - this.R) - i16;
                        if (i12 % 2 == 1) {
                            this.f24607o.putInt(i17);
                        } else {
                            this.f24607o.putShort((short) i17);
                            this.f24607o.putInt(0);
                        }
                        this.f24605m.a(this.f24607o.array(), i14);
                        qoVar.a(this.f24605m, i14, 1);
                        this.S += i14;
                    }
                }
            } else {
                byte[] bArr = cVar.f24628i;
                if (bArr != null) {
                    this.f24602j.a(bArr, bArr.length);
                }
            }
            if (cVar.f24625f > 0) {
                this.O |= ASTNode.DEOP;
                this.f24606n.d(0);
                this.f24599g.d(4);
                this.f24599g.c()[0] = (byte) ((i11 >> 24) & 255);
                this.f24599g.c()[1] = (byte) ((i11 >> 16) & 255);
                this.f24599g.c()[2] = (byte) ((i11 >> 8) & 255);
                this.f24599g.c()[3] = (byte) (i11 & 255);
                qoVar.a(this.f24599g, 4, 2);
                this.S += 4;
            }
            this.U = true;
        }
        int iE = i11 + this.f24602j.e();
        if (!"V_MPEG4/ISO/AVC".equals(cVar.f24621b) && !"V_MPEGH/ISO/HEVC".equals(cVar.f24621b)) {
            if (cVar.T != null) {
                b1.b(this.f24602j.e() == 0);
                cVar.T.a(l8Var);
            }
            while (true) {
                int i18 = this.R;
                if (i18 >= iE) {
                    break;
                }
                int iA2 = a(l8Var, qoVar, iE - i18);
                this.R += iA2;
                this.S += iA2;
            }
        } else {
            byte[] bArrC = this.f24598f.c();
            bArrC[0] = 0;
            bArrC[1] = 0;
            bArrC[2] = 0;
            int i19 = cVar.Y;
            int i21 = 4 - i19;
            while (this.R < iE) {
                int i22 = this.T;
                if (i22 == 0) {
                    a(l8Var, bArrC, i21, i19);
                    this.R += i19;
                    this.f24598f.f(0);
                    this.T = this.f24598f.A();
                    this.f24597e.f(0);
                    qoVar.a(this.f24597e, 4);
                    this.S += 4;
                } else {
                    int iA3 = a(l8Var, qoVar, i22);
                    this.R += iA3;
                    this.S += iA3;
                    this.T -= iA3;
                }
            }
        }
        if ("A_VORBIS".equals(cVar.f24621b)) {
            this.f24600h.f(0);
            qoVar.a(this.f24600h, 4);
            this.S += 4;
        }
        return f();
    }

    private long a(long j11) throws dh {
        long j12 = this.f24610r;
        if (j12 != C.TIME_UNSET) {
            return xp.c(j11, j12, 1000L);
        }
        throw dh.a("Can't scale timecode prior to timecodeScale being set.", null);
    }

    private ij a(rc rcVar, rc rcVar2) {
        int i11;
        if (this.f24609q == -1 || this.f24612t == C.TIME_UNSET || rcVar == null || rcVar.a() == 0 || rcVar2 == null || rcVar2.a() != rcVar.a()) {
            return new ij.b(this.f24612t);
        }
        int iA = rcVar.a();
        int[] iArrCopyOf = new int[iA];
        long[] jArrCopyOf = new long[iA];
        long[] jArrCopyOf2 = new long[iA];
        long[] jArrCopyOf3 = new long[iA];
        int i12 = 0;
        for (int i13 = 0; i13 < iA; i13++) {
            jArrCopyOf3[i13] = rcVar.a(i13);
            jArrCopyOf[i13] = this.f24609q + rcVar2.a(i13);
        }
        while (true) {
            i11 = iA - 1;
            if (i12 >= i11) {
                break;
            }
            int i14 = i12 + 1;
            iArrCopyOf[i12] = (int) (jArrCopyOf[i14] - jArrCopyOf[i12]);
            jArrCopyOf2[i12] = jArrCopyOf3[i14] - jArrCopyOf3[i12];
            i12 = i14;
        }
        iArrCopyOf[i11] = (int) ((this.f24609q + this.f24608p) - jArrCopyOf[i11]);
        long j11 = this.f24612t - jArrCopyOf3[i11];
        jArrCopyOf2[i11] = j11;
        if (j11 <= 0) {
            pc.d("MatroskaExtractor", "Discarding last cue point with unexpected duration: " + j11);
            iArrCopyOf = Arrays.copyOf(iArrCopyOf, i11);
            jArrCopyOf = Arrays.copyOf(jArrCopyOf, i11);
            jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i11);
            jArrCopyOf3 = Arrays.copyOf(jArrCopyOf3, i11);
        }
        return new g3(iArrCopyOf, jArrCopyOf, jArrCopyOf2, jArrCopyOf3);
    }

    private void a(int i11) throws dh {
        if (this.C == null || this.D == null) {
            throw dh.a("Element " + i11 + " must be in a Cues", null);
        }
    }

    private void a(l8 l8Var, int i11) {
        if (this.f24599g.e() >= i11) {
            return;
        }
        if (this.f24599g.b() < i11) {
            bh bhVar = this.f24599g;
            bhVar.a(Math.max(bhVar.b() * 2, i11));
        }
        l8Var.d(this.f24599g.c(), this.f24599g.e(), i11 - this.f24599g.e());
        this.f24599g.e(i11);
    }

    private void a(l8 l8Var, byte[] bArr, int i11) {
        int length = bArr.length + i11;
        if (this.f24603k.b() < length) {
            this.f24603k.a(Arrays.copyOf(bArr, length + i11));
        } else {
            System.arraycopy(bArr, 0, this.f24603k.c(), 0, bArr.length);
        }
        l8Var.d(this.f24603k.c(), bArr.length, i11);
        this.f24603k.f(0);
        this.f24603k.e(length);
    }

    private void a(l8 l8Var, byte[] bArr, int i11, int i12) {
        int iMin = Math.min(i12, this.f24602j.a());
        l8Var.d(bArr, i11 + iMin, i12 - iMin);
        if (iMin > 0) {
            this.f24602j.a(bArr, i11, iMin);
        }
    }

    private void a(c cVar, long j11, int i11, int i12, int i13) {
        d dVar = cVar.T;
        if (dVar != null) {
            dVar.a(cVar, j11, i11, i12, i13);
        } else {
            if ("S_TEXT/UTF8".equals(cVar.f24621b) || "S_TEXT/ASS".equals(cVar.f24621b)) {
                if (this.K > 1) {
                    pc.d("MatroskaExtractor", "Skipping subtitle sample in laced block.");
                } else {
                    long j12 = this.I;
                    if (j12 == C.TIME_UNSET) {
                        pc.d("MatroskaExtractor", "Skipping subtitle sample with no duration.");
                    } else {
                        a(cVar.f24621b, j12, this.f24603k.c());
                        for (int iD = this.f24603k.d(); iD < this.f24603k.e(); iD++) {
                            if (this.f24603k.c()[iD] == 0) {
                                this.f24603k.e(iD);
                                break;
                            }
                        }
                        qo qoVar = cVar.X;
                        bh bhVar = this.f24603k;
                        qoVar.a(bhVar, bhVar.e());
                        i12 += this.f24603k.e();
                    }
                }
            }
            if ((268435456 & i11) != 0) {
                if (this.K > 1) {
                    i11 &= -268435457;
                } else {
                    int iE = this.f24606n.e();
                    cVar.X.a(this.f24606n, iE, 2);
                    i12 += iE;
                }
            }
            cVar.X.a(j11, i11, i12, i13, cVar.f24629j);
        }
        this.F = true;
    }

    private static void a(String str, long j11, byte[] bArr) {
        byte[] bArrA;
        int i11;
        str.hashCode();
        if (str.equals("S_TEXT/ASS")) {
            bArrA = a(j11, "%01d:%02d:%02d:%02d", 10000L);
            i11 = 21;
        } else {
            if (!str.equals("S_TEXT/UTF8")) {
                throw new IllegalArgumentException();
            }
            bArrA = a(j11, "%02d:%02d:%02d,%03d", 1000L);
            i11 = 19;
        }
        System.arraycopy(bArrA, 0, bArr, i11, bArrA.length);
    }

    private boolean a(th thVar, long j11) {
        if (this.f24617y) {
            this.A = j11;
            thVar.f23379a = this.f24618z;
            this.f24617y = false;
            return true;
        }
        if (this.f24614v) {
            long j12 = this.A;
            if (j12 != -1) {
                thVar.f23379a = j12;
                this.A = -1L;
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static boolean a(String str) {
        str.hashCode();
        byte b11 = -1;
        switch (str.hashCode()) {
            case -2095576542:
                if (str.equals("V_MPEG4/ISO/AP")) {
                    b11 = 0;
                }
                break;
            case -2095575984:
                if (str.equals("V_MPEG4/ISO/SP")) {
                    b11 = 1;
                }
                break;
            case -1985379776:
                if (str.equals("A_MS/ACM")) {
                    b11 = 2;
                }
                break;
            case -1784763192:
                if (str.equals("A_TRUEHD")) {
                    b11 = 3;
                }
                break;
            case -1730367663:
                if (str.equals("A_VORBIS")) {
                    b11 = 4;
                }
                break;
            case -1482641358:
                if (str.equals("A_MPEG/L2")) {
                    b11 = 5;
                }
                break;
            case -1482641357:
                if (str.equals("A_MPEG/L3")) {
                    b11 = 6;
                }
                break;
            case -1373388978:
                if (str.equals("V_MS/VFW/FOURCC")) {
                    b11 = 7;
                }
                break;
            case -933872740:
                if (str.equals("S_DVBSUB")) {
                    b11 = 8;
                }
                break;
            case -538363189:
                if (str.equals("V_MPEG4/ISO/ASP")) {
                    b11 = 9;
                }
                break;
            case -538363109:
                if (str.equals("V_MPEG4/ISO/AVC")) {
                    b11 = 10;
                }
                break;
            case -425012669:
                if (str.equals("S_VOBSUB")) {
                    b11 = Ascii.VT;
                }
                break;
            case -356037306:
                if (str.equals("A_DTS/LOSSLESS")) {
                    b11 = Ascii.FF;
                }
                break;
            case 62923557:
                if (str.equals("A_AAC")) {
                    b11 = Ascii.CR;
                }
                break;
            case 62923603:
                if (str.equals("A_AC3")) {
                    b11 = Ascii.SO;
                }
                break;
            case 62927045:
                if (str.equals("A_DTS")) {
                    b11 = Ascii.SI;
                }
                break;
            case 82318131:
                if (str.equals("V_AV1")) {
                    b11 = Ascii.DLE;
                }
                break;
            case 82338133:
                if (str.equals("V_VP8")) {
                    b11 = 17;
                }
                break;
            case 82338134:
                if (str.equals("V_VP9")) {
                    b11 = Ascii.DC2;
                }
                break;
            case 99146302:
                if (str.equals("S_HDMV/PGS")) {
                    b11 = 19;
                }
                break;
            case 444813526:
                if (str.equals("V_THEORA")) {
                    b11 = Ascii.DC4;
                }
                break;
            case 542569478:
                if (str.equals("A_DTS/EXPRESS")) {
                    b11 = Ascii.NAK;
                }
                break;
            case 635596514:
                if (str.equals("A_PCM/FLOAT/IEEE")) {
                    b11 = Ascii.SYN;
                }
                break;
            case 725948237:
                if (str.equals("A_PCM/INT/BIG")) {
                    b11 = Ascii.ETB;
                }
                break;
            case 725957860:
                if (str.equals("A_PCM/INT/LIT")) {
                    b11 = Ascii.CAN;
                }
                break;
            case 738597099:
                if (str.equals("S_TEXT/ASS")) {
                    b11 = Ascii.EM;
                }
                break;
            case 855502857:
                if (str.equals("V_MPEGH/ISO/HEVC")) {
                    b11 = Ascii.SUB;
                }
                break;
            case 1422270023:
                if (str.equals("S_TEXT/UTF8")) {
                    b11 = Ascii.ESC;
                }
                break;
            case 1809237540:
                if (str.equals("V_MPEG2")) {
                    b11 = Ascii.FS;
                }
                break;
            case 1950749482:
                if (str.equals("A_EAC3")) {
                    b11 = Ascii.GS;
                }
                break;
            case 1950789798:
                if (str.equals("A_FLAC")) {
                    b11 = Ascii.RS;
                }
                break;
            case 1951062397:
                if (str.equals("A_OPUS")) {
                    b11 = Ascii.US;
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
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
            case 30:
            case VungleException.WEB_CRASH /* 31 */:
                return true;
            default:
                return false;
        }
    }

    private static byte[] a(long j11, String str, long j12) {
        b1.a(j11 != C.TIME_UNSET);
        int i11 = (int) (j11 / 3600000000L);
        long j13 = j11 - (((long) (i11 * 3600)) * 1000000);
        int i12 = (int) (j13 / 60000000);
        long j14 = j13 - (((long) (i12 * 60)) * 1000000);
        int i13 = (int) (j14 / 1000000);
        return xp.c(String.format(Locale.US, str, Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf((int) ((j14 - (((long) i13) * 1000000)) / j12))));
    }

    private static int[] a(int[] iArr, int i11) {
        if (iArr == null) {
            return new int[i11];
        }
        return iArr.length >= i11 ? iArr : new int[Math.max(iArr.length * 2, i11)];
    }

    private void b(int i11) throws dh {
        if (this.f24613u != null) {
            return;
        }
        throw dh.a("Element " + i11 + " must be in a TrackEntry", null);
    }

    private c d(int i11) throws dh {
        b(i11);
        return this.f24613u;
    }

    private void e() {
        b1.b(this.f24593a0);
    }

    private int f() {
        int i11 = this.S;
        h();
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ k8[] g() {
        return new k8[]{new yc()};
    }

    private void h() {
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.U = false;
        this.V = false;
        this.W = false;
        this.X = 0;
        this.Y = (byte) 0;
        this.Z = false;
        this.f24602j.d(0);
    }

    @Override // com.applovin.impl.k8
    public final int a(l8 l8Var, th thVar) {
        this.F = false;
        boolean zA = true;
        while (zA && !this.F) {
            zA = this.f24592a.a(l8Var);
            if (zA && a(thVar, l8Var.f())) {
                return 1;
            }
        }
        if (zA) {
            return 0;
        }
        for (int i11 = 0; i11 < this.f24595c.size(); i11++) {
            c cVar = (c) this.f24595c.valueAt(i11);
            cVar.a();
            cVar.c();
        }
        return -1;
    }

    @Override // com.applovin.impl.k8
    public final void a() {
    }

    public void a(int i11, double d11) {
        if (i11 == 181) {
            d(i11).Q = (int) d11;
        }
        if (i11 == 17545) {
            this.f24611s = (long) d11;
            return;
        }
        switch (i11) {
            case 21969:
                d(i11).D = (float) d11;
                break;
            case 21970:
                d(i11).E = (float) d11;
                break;
            case 21971:
                d(i11).F = (float) d11;
                break;
            case 21972:
                d(i11).G = (float) d11;
                break;
            case 21973:
                d(i11).H = (float) d11;
                break;
            case 21974:
                d(i11).I = (float) d11;
                break;
            case 21975:
                d(i11).J = (float) d11;
                break;
            case 21976:
                d(i11).K = (float) d11;
                break;
            case 21977:
                d(i11).L = (float) d11;
                break;
            case 21978:
                d(i11).M = (float) d11;
                break;
            default:
                switch (i11) {
                    case 30323:
                        d(i11).f24638s = (float) d11;
                        break;
                    case 30324:
                        d(i11).f24639t = (float) d11;
                        break;
                    case 30325:
                        d(i11).f24640u = (float) d11;
                        break;
                }
                break;
        }
    }

    /* JADX WARN: Code duplicated, block: B:99:0x027a  */
    public void a(int i11, int i12, l8 l8Var) throws dh {
        c cVar;
        c cVar2;
        c cVar3;
        long j11;
        int i13;
        int i14;
        int i15;
        int i16;
        Throwable th2 = null;
        int i17 = 1;
        int i18 = 0;
        if (i11 != 161 && i11 != 163) {
            if (i11 == 165) {
                if (this.G != 2) {
                    return;
                }
                a((c) this.f24595c.get(this.M), this.P, l8Var, i12);
                return;
            }
            if (i11 == 16877) {
                a(d(i11), l8Var, i12);
                return;
            }
            if (i11 == 16981) {
                b(i11);
                byte[] bArr = new byte[i12];
                this.f24613u.f24628i = bArr;
                l8Var.d(bArr, 0, i12);
                return;
            }
            if (i11 == 18402) {
                byte[] bArr2 = new byte[i12];
                l8Var.d(bArr2, 0, i12);
                d(i11).f24629j = new qo.a(1, bArr2, 0, 0);
                return;
            }
            if (i11 == 21419) {
                Arrays.fill(this.f24601i.c(), (byte) 0);
                l8Var.d(this.f24601i.c(), 4 - i12, i12);
                this.f24601i.f(0);
                this.f24615w = (int) this.f24601i.y();
                return;
            }
            if (i11 == 25506) {
                b(i11);
                byte[] bArr3 = new byte[i12];
                this.f24613u.f24630k = bArr3;
                l8Var.d(bArr3, 0, i12);
                return;
            }
            if (i11 != 30322) {
                throw dh.a("Unexpected id: " + i11, null);
            }
            b(i11);
            byte[] bArr4 = new byte[i12];
            this.f24613u.f24641v = bArr4;
            l8Var.d(bArr4, 0, i12);
            return;
        }
        if (this.G == 0) {
            this.M = (int) this.f24594b.a(l8Var, false, true, 8);
            this.N = this.f24594b.a();
            this.I = C.TIME_UNSET;
            this.G = 1;
            this.f24599g.d(0);
        }
        c cVar4 = (c) this.f24595c.get(this.M);
        if (cVar4 == null) {
            l8Var.a(i12 - this.N);
            this.G = 0;
            return;
        }
        cVar4.a();
        if (this.G == 1) {
            a(l8Var, 3);
            int i19 = (this.f24599g.c()[2] & 6) >> 1;
            if (i19 == 0) {
                this.K = 1;
                int[] iArrA = a(this.L, 1);
                this.L = iArrA;
                iArrA[0] = (i12 - this.N) - 3;
            } else {
                int i21 = 4;
                a(l8Var, 4);
                int i22 = (this.f24599g.c()[3] & 255) + 1;
                this.K = i22;
                int[] iArrA2 = a(this.L, i22);
                this.L = iArrA2;
                if (i19 == 2) {
                    int i23 = (i12 - this.N) - 4;
                    int i24 = this.K;
                    Arrays.fill(iArrA2, 0, i24, i23 / i24);
                } else {
                    if (i19 == 1) {
                        int i25 = 0;
                        int i26 = 0;
                        while (true) {
                            i13 = this.K - 1;
                            if (i25 >= i13) {
                                break;
                            }
                            this.L[i25] = 0;
                            while (true) {
                                i14 = i21 + 1;
                                a(l8Var, i14);
                                int i27 = this.f24599g.c()[i21] & 255;
                                int[] iArr = this.L;
                                i15 = iArr[i25] + i27;
                                iArr[i25] = i15;
                                if (i27 != 255) {
                                    break;
                                } else {
                                    i21 = i14;
                                }
                            }
                            i26 += i15;
                            i25++;
                            i21 = i14;
                        }
                        this.L[i13] = ((i12 - this.N) - i21) - i26;
                    } else {
                        if (i19 != 3) {
                            throw dh.a("Unexpected lacing value: " + i19, null);
                        }
                        int i28 = 0;
                        int i29 = 0;
                        while (true) {
                            int i31 = this.K - i17;
                            if (i28 >= i31) {
                                cVar2 = cVar4;
                                this.L[i31] = ((i12 - this.N) - i21) - i29;
                                break;
                            }
                            this.L[i28] = i18;
                            int i32 = i21 + 1;
                            a(l8Var, i32);
                            if (this.f24599g.c()[i21] == 0) {
                                throw dh.a("No valid varint length mask found", th2);
                            }
                            int i33 = 0;
                            while (true) {
                                if (i33 < 8) {
                                    int i34 = i17 << (7 - i33);
                                    if ((this.f24599g.c()[i21] & i34) != 0) {
                                        int i35 = i32 + i33;
                                        a(l8Var, i35);
                                        j11 = (~i34) & this.f24599g.c()[i21] & 255;
                                        while (i32 < i35) {
                                            j11 = (j11 << 8) | ((long) (this.f24599g.c()[i32] & 255));
                                            i32++;
                                            cVar4 = cVar4;
                                        }
                                        cVar3 = cVar4;
                                        if (i28 > 0) {
                                            j11 -= (1 << ((i33 * 7) + 6)) - 1;
                                            i21 = i35;
                                            break;
                                        }
                                        i32 = i35;
                                    } else {
                                        i33++;
                                        i17 = 1;
                                    }
                                } else {
                                    cVar3 = cVar4;
                                    j11 = 0;
                                }
                                i21 = i32;
                                break;
                            }
                            if (j11 < -2147483648L || j11 > 2147483647L) {
                                throw dh.a("EBML lacing sample size out of range.", null);
                            }
                            int i36 = (int) j11;
                            int[] iArr2 = this.L;
                            if (i28 != 0) {
                                i36 += iArr2[i28 - 1];
                            }
                            iArr2[i28] = i36;
                            i29 += i36;
                            i28++;
                            cVar4 = cVar3;
                            th2 = null;
                            i17 = 1;
                            i18 = 0;
                        }
                    }
                    this.H = this.B + a((this.f24599g.c()[0] << 8) | (this.f24599g.c()[1] & 255));
                    cVar = cVar2;
                    if (cVar.f24623d != 2 || (i11 == 163 && (this.f24599g.c()[2] & 128) == 128)) {
                        i16 = 1;
                    } else {
                        i16 = 0;
                    }
                    this.O = i16;
                    this.G = 2;
                    this.J = 0;
                }
            }
            cVar2 = cVar4;
            this.H = this.B + a((this.f24599g.c()[0] << 8) | (this.f24599g.c()[1] & 255));
            cVar = cVar2;
            if (cVar.f24623d != 2) {
                i16 = 1;
            } else {
                i16 = 1;
            }
            this.O = i16;
            this.G = 2;
            this.J = 0;
        } else {
            cVar = cVar4;
        }
        if (i11 == 163) {
            while (true) {
                int i37 = this.J;
                if (i37 >= this.K) {
                    this.G = 0;
                    return;
                }
                a(cVar, ((long) ((this.J * cVar.f24624e) / 1000)) + this.H, this.O, a(l8Var, cVar, this.L[i37]), 0);
                this.J++;
            }
        } else {
            while (true) {
                int i38 = this.J;
                if (i38 >= this.K) {
                    return;
                }
                int[] iArr3 = this.L;
                iArr3[i38] = a(l8Var, cVar, iArr3[i38]);
                this.J++;
            }
        }
    }

    public void a(int i11, long j11) throws dh {
        if (i11 == 20529) {
            if (j11 == 0) {
                return;
            }
            throw dh.a("ContentEncodingOrder " + j11 + " not supported", null);
        }
        if (i11 == 20530) {
            if (j11 == 1) {
                return;
            }
            throw dh.a("ContentEncodingScope " + j11 + " not supported", null);
        }
        switch (i11) {
            case 131:
                d(i11).f24623d = (int) j11;
                return;
            case 136:
                d(i11).V = j11 == 1;
                return;
            case 155:
                this.I = a(j11);
                return;
            case 159:
                d(i11).O = (int) j11;
                return;
            case 176:
                d(i11).f24632m = (int) j11;
                return;
            case 179:
                a(i11);
                this.C.a(a(j11));
                return;
            case 186:
                d(i11).f24633n = (int) j11;
                return;
            case 215:
                d(i11).f24622c = (int) j11;
                return;
            case 231:
                this.B = a(j11);
                return;
            case 238:
                this.P = (int) j11;
                return;
            case 241:
                if (this.E) {
                    return;
                }
                a(i11);
                this.D.a(j11);
                this.E = true;
                return;
            case 251:
                this.Q = true;
                return;
            case 16871:
                d(i11).f24626g = (int) j11;
                return;
            case 16980:
                if (j11 == 3) {
                    return;
                }
                throw dh.a("ContentCompAlgo " + j11 + " not supported", null);
            case 17029:
                if (j11 < 1 || j11 > 2) {
                    throw dh.a("DocTypeReadVersion " + j11 + " not supported", null);
                }
                return;
            case 17143:
                if (j11 == 1) {
                    return;
                }
                throw dh.a("EBMLReadVersion " + j11 + " not supported", null);
            case 18401:
                if (j11 == 5) {
                    return;
                }
                throw dh.a("ContentEncAlgo " + j11 + " not supported", null);
            case 18408:
                if (j11 == 1) {
                    return;
                }
                throw dh.a("AESSettingsCipherMode " + j11 + " not supported", null);
            case 21420:
                this.f24616x = j11 + this.f24609q;
                return;
            case 21432:
                int i12 = (int) j11;
                b(i11);
                if (i12 == 0) {
                    this.f24613u.f24642w = 0;
                    return;
                }
                if (i12 == 1) {
                    this.f24613u.f24642w = 2;
                    return;
                } else if (i12 == 3) {
                    this.f24613u.f24642w = 1;
                    return;
                } else {
                    if (i12 != 15) {
                        return;
                    }
                    this.f24613u.f24642w = 3;
                    return;
                }
            case 21680:
                d(i11).f24634o = (int) j11;
                return;
            case 21682:
                d(i11).f24636q = (int) j11;
                return;
            case 21690:
                d(i11).f24635p = (int) j11;
                return;
            case 21930:
                d(i11).U = j11 == 1;
                return;
            case 21998:
                d(i11).f24625f = (int) j11;
                return;
            case 22186:
                d(i11).R = j11;
                return;
            case 22203:
                d(i11).S = j11;
                return;
            case 25188:
                d(i11).P = (int) j11;
                return;
            case 30321:
                b(i11);
                int i13 = (int) j11;
                if (i13 == 0) {
                    this.f24613u.f24637r = 0;
                    return;
                }
                if (i13 == 1) {
                    this.f24613u.f24637r = 1;
                    return;
                } else if (i13 == 2) {
                    this.f24613u.f24637r = 2;
                    return;
                } else {
                    if (i13 != 3) {
                        return;
                    }
                    this.f24613u.f24637r = 3;
                    return;
                }
            case 2352003:
                d(i11).f24624e = (int) j11;
                return;
            case 2807729:
                this.f24610r = j11;
                return;
            default:
                switch (i11) {
                    case 21945:
                        b(i11);
                        int i14 = (int) j11;
                        if (i14 == 1) {
                            this.f24613u.A = 2;
                            return;
                        } else {
                            if (i14 != 2) {
                                return;
                            }
                            this.f24613u.A = 1;
                            return;
                        }
                    case 21946:
                        b(i11);
                        int iB = r3.b((int) j11);
                        if (iB != -1) {
                            this.f24613u.f24645z = iB;
                            return;
                        }
                        return;
                    case 21947:
                        b(i11);
                        this.f24613u.f24643x = true;
                        int iA = r3.a((int) j11);
                        if (iA != -1) {
                            this.f24613u.f24644y = iA;
                            return;
                        }
                        return;
                    case 21948:
                        d(i11).B = (int) j11;
                        return;
                    case 21949:
                        d(i11).C = (int) j11;
                        return;
                    default:
                        return;
                }
        }
    }

    public void a(int i11, long j11, long j12) throws dh {
        e();
        if (i11 == 160) {
            this.Q = false;
            return;
        }
        if (i11 == 174) {
            this.f24613u = new c();
            return;
        }
        if (i11 == 187) {
            this.E = false;
            return;
        }
        if (i11 == 19899) {
            this.f24615w = -1;
            this.f24616x = -1L;
            return;
        }
        if (i11 == 20533) {
            d(i11).f24627h = true;
            return;
        }
        if (i11 == 21968) {
            d(i11).f24643x = true;
            return;
        }
        if (i11 == 408125543) {
            long j13 = this.f24609q;
            if (j13 != -1 && j13 != j11) {
                throw dh.a("Multiple Segment elements not supported", null);
            }
            this.f24609q = j11;
            this.f24608p = j12;
            return;
        }
        if (i11 == 475249515) {
            this.C = new rc();
            this.D = new rc();
        } else if (i11 == 524531317 && !this.f24614v) {
            if (this.f24596d && this.f24618z != -1) {
                this.f24617y = true;
            } else {
                this.f24593a0.a(new ij.b(this.f24612t));
                this.f24614v = true;
            }
        }
    }

    public void a(int i11, String str) throws dh {
        if (i11 == 134) {
            d(i11).f24621b = str;
            return;
        }
        if (i11 != 17026) {
            if (i11 == 21358) {
                d(i11).f24620a = str;
                return;
            } else {
                if (i11 != 2274716) {
                    return;
                }
                d(i11).W = str;
                return;
            }
        }
        if ("webm".equals(str) || "matroska".equals(str)) {
            return;
        }
        throw dh.a("DocType " + str + " not supported", null);
    }

    @Override // com.applovin.impl.k8
    public void a(long j11, long j12) {
        this.B = C.TIME_UNSET;
        this.G = 0;
        this.f24592a.reset();
        this.f24594b.b();
        h();
        for (int i11 = 0; i11 < this.f24595c.size(); i11++) {
            ((c) this.f24595c.valueAt(i11)).d();
        }
    }

    @Override // com.applovin.impl.k8
    public final void a(m8 m8Var) {
        this.f24593a0 = m8Var;
    }

    public void a(c cVar, int i11, l8 l8Var, int i12) {
        if (i11 != 4 || !"V_VP9".equals(cVar.f24621b)) {
            l8Var.a(i12);
        } else {
            this.f24606n.d(i12);
            l8Var.d(this.f24606n.c(), 0, i12);
        }
    }

    public void a(c cVar, l8 l8Var, int i11) {
        if (cVar.f24626g != 1685485123 && cVar.f24626g != 1685480259) {
            l8Var.a(i11);
            return;
        }
        byte[] bArr = new byte[i11];
        cVar.N = bArr;
        l8Var.d(bArr, 0, i11);
    }

    @Override // com.applovin.impl.k8
    public final boolean a(l8 l8Var) {
        return new mk().b(l8Var);
    }

    public void c(int i11) throws dh {
        e();
        if (i11 == 160) {
            if (this.G != 2) {
                return;
            }
            int i12 = 0;
            for (int i13 = 0; i13 < this.K; i13++) {
                i12 += this.L[i13];
            }
            c cVar = (c) this.f24595c.get(this.M);
            cVar.a();
            for (int i14 = 0; i14 < this.K; i14++) {
                long j11 = ((long) ((cVar.f24624e * i14) / 1000)) + this.H;
                int i15 = this.O;
                if (i14 == 0 && !this.Q) {
                    i15 |= 1;
                }
                int i16 = this.L[i14];
                i12 -= i16;
                a(cVar, j11, i15, i16, i12);
            }
            this.G = 0;
            return;
        }
        if (i11 == 174) {
            c cVar2 = (c) b1.b(this.f24613u);
            String str = cVar2.f24621b;
            if (str == null) {
                throw dh.a("CodecId is missing in TrackEntry element", null);
            }
            if (a(str)) {
                cVar2.a(this.f24593a0, cVar2.f24622c);
                this.f24595c.put(cVar2.f24622c, cVar2);
            }
            this.f24613u = null;
            return;
        }
        if (i11 == 19899) {
            int i17 = this.f24615w;
            if (i17 != -1) {
                long j12 = this.f24616x;
                if (j12 != -1) {
                    if (i17 == 475249515) {
                        this.f24618z = j12;
                        return;
                    }
                    return;
                }
            }
            throw dh.a("Mandatory element SeekID or SeekPosition not found", null);
        }
        if (i11 == 25152) {
            b(i11);
            c cVar3 = this.f24613u;
            if (cVar3.f24627h) {
                if (cVar3.f24629j == null) {
                    throw dh.a("Encrypted Track found but ContentEncKeyID was not found", null);
                }
                cVar3.f24631l = new y6(new y6.b(t2.f23167a, MimeTypes.VIDEO_WEBM, this.f24613u.f24629j.f21968b));
                return;
            }
            return;
        }
        if (i11 == 28032) {
            b(i11);
            c cVar4 = this.f24613u;
            if (cVar4.f24627h && cVar4.f24628i != null) {
                throw dh.a("Combining encryption and compression is not supported", null);
            }
            return;
        }
        if (i11 == 357149030) {
            if (this.f24610r == C.TIME_UNSET) {
                this.f24610r = 1000000L;
            }
            long j13 = this.f24611s;
            if (j13 != C.TIME_UNSET) {
                this.f24612t = a(j13);
                return;
            }
            return;
        }
        if (i11 == 374648427) {
            if (this.f24595c.size() == 0) {
                throw dh.a("No valid tracks were found", null);
            }
            this.f24593a0.c();
        } else {
            if (i11 != 475249515) {
                return;
            }
            if (!this.f24614v) {
                this.f24593a0.a(a(this.C, this.D));
                this.f24614v = true;
            }
            this.C = null;
            this.D = null;
        }
    }

    public int e(int i11) {
        switch (i11) {
            case 131:
            case 136:
            case 155:
            case 159:
            case 176:
            case 179:
            case 186:
            case 215:
            case 231:
            case 238:
            case 241:
            case 251:
            case 16871:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 21998:
            case 22186:
            case 22203:
            case 25188:
            case 30321:
            case 2352003:
            case 2807729:
                return 2;
            case TsExtractor.TS_STREAM_TYPE_SPLICE_INFO /* 134 */:
            case 17026:
            case 21358:
            case 2274716:
                return 3;
            case 160:
            case 166:
            case 174:
            case 183:
            case 187:
            case 224:
            case 225:
            case 16868:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30113:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case 163:
            case 165:
            case 16877:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case 181:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
            case 30323:
            case 30324:
            case 30325:
                return 5;
            default:
                return 0;
        }
    }

    public boolean f(int i11) {
        return i11 == 357149030 || i11 == 524531317 || i11 == 475249515 || i11 == 374648427;
    }
}
