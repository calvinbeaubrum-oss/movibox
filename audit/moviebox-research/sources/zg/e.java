package zg;

import android.net.Uri;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.h;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.s;
import com.google.android.exoplayer2.util.t;
import com.google.android.exoplayer2.util.w;
import com.google.android.exoplayer2.util.x;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.vungle.warren.error.VungleException;
import java.io.IOException;
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
import tg.a0;
import tg.b0;
import tg.e0;
import tg.f0;
import tg.l;
import tg.m;
import tg.n;
import tg.q;
import tg.r;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class e implements l {

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final r f81981c0 = new r() { // from class: zg.d
        @Override // tg.r
        public /* synthetic */ l[] b(Uri uri, Map map) {
            return q.a(this, uri, map);
        }

        @Override // tg.r
        public final l[] createExtractors() {
            return e.z();
        }
    };

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final byte[] f81982d0 = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final byte[] f81983e0 = o0.n0("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final byte[] f81984f0 = {68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final byte[] f81985g0 = {87, 69, 66, 86, 84, 84, 10, 10, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 10};

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final UUID f81986h0 = new UUID(72057594037932032L, -9223371306706625679L);

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final Map<String, Integer> f81987i0;
    public long A;
    public long B;

    @Nullable
    public t C;

    @Nullable
    public t D;
    public boolean E;
    public boolean F;
    public int G;
    public long H;
    public long I;
    public int J;
    public int K;
    public int[] L;
    public int M;
    public int N;
    public int O;
    public int P;
    public boolean Q;
    public long R;
    public int S;
    public int T;
    public int U;
    public boolean V;
    public boolean W;
    public boolean X;
    public int Y;
    public byte Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zg.c f81988a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f81989a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f81990b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public n f81991b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SparseArray<c> f81992c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f81993d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c0 f81994e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c0 f81995f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c0 f81996g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c0 f81997h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c0 f81998i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c0 f81999j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final c0 f82000k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c0 f82001l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final c0 f82002m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final c0 f82003n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ByteBuffer f82004o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f82005p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f82006q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f82007r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f82008s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f82009t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    public c f82010u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f82011v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f82012w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f82013x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f82014y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f82015z;

    /* JADX INFO: compiled from: source.java */
    public final class b implements zg.b {
        public b() {
        }

        @Override // zg.b
        public void a(int i11, int i12, m mVar) throws IOException {
            e.this.k(i11, i12, mVar);
        }

        @Override // zg.b
        public void endMasterElement(int i11) throws ParserException {
            e.this.n(i11);
        }

        @Override // zg.b
        public void floatElement(int i11, double d11) throws ParserException {
            e.this.q(i11, d11);
        }

        @Override // zg.b
        public int getElementType(int i11) {
            return e.this.t(i11);
        }

        @Override // zg.b
        public void integerElement(int i11, long j11) throws ParserException {
            e.this.w(i11, j11);
        }

        @Override // zg.b
        public boolean isLevel1Element(int i11) {
            return e.this.y(i11);
        }

        @Override // zg.b
        public void startMasterElement(int i11, long j11, long j12) throws ParserException {
            e.this.F(i11, j11, j12);
        }

        @Override // zg.b
        public void stringElement(int i11, String str) throws ParserException {
            e.this.G(i11, str);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {
        public byte[] N;
        public f0 T;
        public boolean U;
        public e0 X;
        public int Y;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f82017a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f82018b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f82019c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f82020d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f82021e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f82022f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f82023g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f82024h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public byte[] f82025i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public e0.a f82026j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public byte[] f82027k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public DrmInitData f82028l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f82029m = -1;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f82030n = -1;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f82031o = -1;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f82032p = -1;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f82033q = 0;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f82034r = -1;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public float f82035s = 0.0f;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public float f82036t = 0.0f;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public float f82037u = 0.0f;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public byte[] f82038v = null;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f82039w = -1;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public boolean f82040x = false;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public int f82041y = -1;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public int f82042z = -1;
        public int A = -1;
        public int B = 1000;
        public int C = 200;
        public float D = -1.0f;
        public float E = -1.0f;
        public float F = -1.0f;
        public float G = -1.0f;
        public float H = -1.0f;
        public float I = -1.0f;
        public float J = -1.0f;
        public float K = -1.0f;
        public float L = -1.0f;
        public float M = -1.0f;
        public int O = 1;
        public int P = -1;
        public int Q = 8000;
        public long R = 0;
        public long S = 0;
        public boolean V = true;
        public String W = "eng";

        public static Pair<String, List<byte[]>> k(c0 c0Var) throws ParserException {
            try {
                c0Var.Q(16);
                long jT = c0Var.t();
                if (jT == 1482049860) {
                    return new Pair<>("video/divx", null);
                }
                if (jT == 859189832) {
                    return new Pair<>(MimeTypes.VIDEO_H263, null);
                }
                if (jT != 826496599) {
                    s.i("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                    return new Pair<>(MimeTypes.VIDEO_UNKNOWN, null);
                }
                byte[] bArrD = c0Var.d();
                for (int iE = c0Var.e() + 20; iE < bArrD.length - 4; iE++) {
                    if (bArrD[iE] == 0 && bArrD[iE + 1] == 0 && bArrD[iE + 2] == 1 && bArrD[iE + 3] == 15) {
                        return new Pair<>(MimeTypes.VIDEO_VC1, Collections.singletonList(Arrays.copyOfRange(bArrD, iE, bArrD.length)));
                    }
                }
                throw ParserException.createForMalformedContainer("Failed to find FourCC VC1 initialization data", null);
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw ParserException.createForMalformedContainer("Error parsing FourCC private data", null);
            }
        }

        public static boolean l(c0 c0Var) throws ParserException {
            try {
                int iV = c0Var.v();
                if (iV == 1) {
                    return true;
                }
                if (iV != 65534) {
                    return false;
                }
                c0Var.P(24);
                return c0Var.w() == e.f81986h0.getMostSignificantBits() && c0Var.w() == e.f81986h0.getLeastSignificantBits();
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw ParserException.createForMalformedContainer("Error parsing MS/ACM codec private", null);
            }
        }

        public static List<byte[]> m(byte[] bArr) throws ParserException {
            int i11;
            int i12;
            try {
                if (bArr[0] != 2) {
                    throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
                }
                int i13 = 1;
                int i14 = 0;
                while (true) {
                    i11 = bArr[i13];
                    if ((i11 & 255) != 255) {
                        break;
                    }
                    i14 += 255;
                    i13++;
                }
                int i15 = i13 + 1;
                int i16 = i14 + (i11 & 255);
                int i17 = 0;
                while (true) {
                    i12 = bArr[i15];
                    if ((i12 & 255) != 255) {
                        break;
                    }
                    i17 += 255;
                    i15++;
                }
                int i18 = i15 + 1;
                int i19 = i17 + (i12 & 255);
                if (bArr[i18] != 1) {
                    throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
                }
                byte[] bArr2 = new byte[i16];
                System.arraycopy(bArr, i18, bArr2, 0, i16);
                int i21 = i18 + i16;
                if (bArr[i21] != 3) {
                    throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
                }
                int i22 = i21 + i19;
                if (bArr[i22] != 5) {
                    throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
                }
                byte[] bArr3 = new byte[bArr.length - i22];
                System.arraycopy(bArr, i22, bArr3, 0, bArr.length - i22);
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(bArr2);
                arrayList.add(bArr3);
                return arrayList;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
            }
        }

        public final void f() {
            com.google.android.exoplayer2.util.a.e(this.X);
        }

        public final byte[] g(String str) throws ParserException {
            byte[] bArr = this.f82027k;
            if (bArr != null) {
                return bArr;
            }
            throw ParserException.createForMalformedContainer("Missing CodecPrivate for codec " + str, null);
        }

        @Nullable
        public final byte[] h() {
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
        /* JADX WARN: Code duplicated, block: B:205:0x043d  */
        /* JADX WARN: Code duplicated, block: B:210:0x0454  */
        /* JADX WARN: Code duplicated, block: B:211:0x0456  */
        /* JADX WARN: Code duplicated, block: B:214:0x0463  */
        /* JADX WARN: Code duplicated, block: B:215:0x0475  */
        /* JADX WARN: Code duplicated, block: B:217:0x047b  */
        /* JADX WARN: Code duplicated, block: B:219:0x047f  */
        /* JADX WARN: Code duplicated, block: B:221:0x0484  */
        /* JADX WARN: Code duplicated, block: B:224:0x048c  */
        /* JADX WARN: Code duplicated, block: B:226:0x0491  */
        /* JADX WARN: Code duplicated, block: B:229:0x0496  */
        /* JADX WARN: Code duplicated, block: B:232:0x04a6  */
        /* JADX WARN: Code duplicated, block: B:235:0x04ac  */
        /* JADX WARN: Code duplicated, block: B:238:0x04bf  */
        /* JADX WARN: Code duplicated, block: B:243:0x04df  */
        /* JADX WARN: Code duplicated, block: B:249:0x04f8  */
        /* JADX WARN: Code duplicated, block: B:250:0x04fa  */
        /* JADX WARN: Code duplicated, block: B:252:0x0504  */
        /* JADX WARN: Code duplicated, block: B:253:0x0507  */
        /* JADX WARN: Code duplicated, block: B:255:0x0511  */
        /* JADX WARN: Code duplicated, block: B:261:0x0529  */
        /* JADX WARN: Code duplicated, block: B:263:0x0550  */
        /* JADX WARN: Code duplicated, block: B:265:0x0556  */
        /* JADX WARN: Code duplicated, block: B:281:0x0581  */
        /* JADX WARN: Code duplicated, block: B:4:0x0015  */
        public void i(n nVar, int i11) throws ParserException {
            byte b11;
            List<byte[]> listSingletonList;
            String str;
            int i12;
            int i13;
            List<byte[]> list;
            String str2;
            byte[] bArr;
            String str3;
            int i14;
            m1.b bVar;
            int i15;
            int iIntValue;
            int i16;
            float f11;
            int i17;
            int i18;
            int i19;
            com.google.android.exoplayer2.video.d dVarA;
            String str4 = this.f82018b;
            str4.hashCode();
            switch (str4) {
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
                case "S_TEXT/WEBVTT":
                    b11 = Ascii.ESC;
                    break;
                case "S_TEXT/UTF8":
                    b11 = Ascii.FS;
                    break;
                case "V_MPEG2":
                    b11 = Ascii.GS;
                    break;
                case "A_EAC3":
                    b11 = Ascii.RS;
                    break;
                case "A_FLAC":
                    b11 = Ascii.US;
                    break;
                case "A_OPUS":
                    b11 = 32;
                    break;
                default:
                    b11 = -1;
                    break;
            }
            String str5 = MimeTypes.AUDIO_RAW;
            switch (b11) {
                case 0:
                case 1:
                case 9:
                    byte[] bArr2 = this.f82027k;
                    listSingletonList = bArr2 == null ? null : Collections.singletonList(bArr2);
                    str5 = MimeTypes.VIDEO_MP4V;
                    str = null;
                    i13 = -1;
                    i12 = -1;
                    bArr = this.N;
                    if (bArr != null && (dVarA = com.google.android.exoplayer2.video.d.a(new c0(bArr))) != null) {
                        str = dVarA.f35724c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z11 = this.V;
                    if (this.U) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i21 = i14 | (z11 ? 1 : 0);
                    bVar = new m1.b();
                    if (w.o(str3)) {
                        bVar.H(this.O).f0(this.Q).Y(i12);
                        i15 = 1;
                    } else if (w.s(str3)) {
                        if (this.f82033q == 0) {
                            i18 = this.f82031o;
                            iIntValue = -1;
                            if (i18 == -1) {
                                i18 = this.f82029m;
                            }
                            this.f82031o = i18;
                            i19 = this.f82032p;
                            if (i19 == -1) {
                                i19 = this.f82030n;
                            }
                            this.f82032p = i19;
                        } else {
                            iIntValue = -1;
                        }
                        i16 = this.f82031o;
                        if (i16 != iIntValue || (i17 = this.f82032p) == iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = (this.f82030n * i16) / (this.f82029m * i17);
                        }
                        com.google.android.exoplayer2.video.c cVar = this.f82040x ? new com.google.android.exoplayer2.video.c(this.f82041y, this.A, this.f82042z, h()) : null;
                        if (this.f82017a != null && e.f81987i0.containsKey(this.f82017a)) {
                            iIntValue = ((Integer) e.f81987i0.get(this.f82017a)).intValue();
                        }
                        if (this.f82034r == 0 && Float.compare(this.f82035s, 0.0f) == 0 && Float.compare(this.f82036t, 0.0f) == 0) {
                            if (Float.compare(this.f82037u, 0.0f) == 0) {
                                iIntValue = 0;
                            } else if (Float.compare(this.f82036t, 90.0f) == 0) {
                                iIntValue = 90;
                            } else if (Float.compare(this.f82036t, -180.0f) != 0 || Float.compare(this.f82036t, 180.0f) == 0) {
                                iIntValue = 180;
                            } else if (Float.compare(this.f82036t, -90.0f) == 0) {
                                iIntValue = 270;
                            }
                        }
                        bVar.j0(this.f82029m).Q(this.f82030n).a0(f11).d0(iIntValue).b0(this.f82038v).h0(this.f82039w).J(cVar);
                        i15 = 2;
                    } else {
                        if (MimeTypes.APPLICATION_SUBRIP.equals(str3) && !MimeTypes.TEXT_SSA.equals(str3) && !MimeTypes.TEXT_VTT.equals(str3) && !MimeTypes.APPLICATION_VOBSUB.equals(str3) && !MimeTypes.APPLICATION_PGS.equals(str3) && !MimeTypes.APPLICATION_DVBSUBS.equals(str3)) {
                            throw ParserException.createForMalformedContainer("Unexpected MIME type.", null);
                        }
                        i15 = 3;
                    }
                    if (this.f82017a != null && !e.f81987i0.containsKey(this.f82017a)) {
                        bVar.U(this.f82017a);
                    }
                    m1 m1VarE = bVar.R(i11).e0(str3).W(i13).V(this.W).g0(i21).T(listSingletonList).I(str).M(this.f82028l).E();
                    e0 e0VarTrack = nVar.track(this.f82019c, i15);
                    this.X = e0VarTrack;
                    e0VarTrack.e(m1VarE);
                    return;
                case 2:
                    if (l(new c0(g(this.f82018b)))) {
                        int iC0 = o0.c0(this.P);
                        if (iC0 == 0) {
                            s.i("MatroskaExtractor", "Unsupported PCM bit depth: " + this.P + ". Setting mimeType to " + MimeTypes.AUDIO_UNKNOWN);
                        } else {
                            i12 = iC0;
                            listSingletonList = null;
                            str = null;
                            i13 = -1;
                        }
                        bArr = this.N;
                        if (bArr != null) {
                            str = dVarA.f35724c;
                            str5 = "video/dolby-vision";
                        }
                        str3 = str5;
                        boolean z12 = this.V;
                        if (this.U) {
                            i14 = 2;
                        } else {
                            i14 = 0;
                        }
                        int i22 = i14 | (z12 ? 1 : 0);
                        bVar = new m1.b();
                        if (w.o(str3)) {
                            if (w.s(str3)) {
                                if (this.f82033q == 0) {
                                    i18 = this.f82031o;
                                    iIntValue = -1;
                                    if (i18 == -1) {
                                        i18 = this.f82029m;
                                    }
                                    this.f82031o = i18;
                                    i19 = this.f82032p;
                                    if (i19 == -1) {
                                        i19 = this.f82030n;
                                    }
                                    this.f82032p = i19;
                                } else {
                                    iIntValue = -1;
                                }
                                i16 = this.f82031o;
                                if (i16 != iIntValue) {
                                    f11 = -1.0f;
                                } else {
                                    f11 = -1.0f;
                                }
                                if (this.f82040x) {
                                }
                                if (this.f82017a != null) {
                                    iIntValue = ((Integer) e.f81987i0.get(this.f82017a)).intValue();
                                }
                                if (this.f82034r == 0) {
                                    if (Float.compare(this.f82037u, 0.0f) == 0) {
                                        iIntValue = 0;
                                    } else if (Float.compare(this.f82036t, 90.0f) == 0) {
                                        iIntValue = 90;
                                    } else if (Float.compare(this.f82036t, -180.0f) != 0) {
                                        iIntValue = 180;
                                    } else {
                                        iIntValue = 180;
                                    }
                                }
                                bVar.j0(this.f82029m).Q(this.f82030n).a0(f11).d0(iIntValue).b0(this.f82038v).h0(this.f82039w).J(cVar);
                                i15 = 2;
                            } else {
                                if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                                }
                                i15 = 3;
                            }
                            break;
                        } else {
                            bVar.H(this.O).f0(this.Q).Y(i12);
                            i15 = 1;
                        }
                        if (this.f82017a != null) {
                            bVar.U(this.f82017a);
                        }
                        m1 m1VarE2 = bVar.R(i11).e0(str3).W(i13).V(this.W).g0(i22).T(listSingletonList).I(str).M(this.f82028l).E();
                        e0 e0VarTrack2 = nVar.track(this.f82019c, i15);
                        this.X = e0VarTrack2;
                        e0VarTrack2.e(m1VarE2);
                        return;
                    }
                    s.i("MatroskaExtractor", "Non-PCM MS/ACM is unsupported. Setting mimeType to " + MimeTypes.AUDIO_UNKNOWN);
                    listSingletonList = null;
                    str = null;
                    str5 = MimeTypes.AUDIO_UNKNOWN;
                    i13 = -1;
                    i12 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                        str = dVarA.f35724c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z13 = this.V;
                    if (this.U) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i23 = i14 | (z13 ? 1 : 0);
                    bVar = new m1.b();
                    if (w.o(str3)) {
                        if (w.s(str3)) {
                            if (this.f82033q == 0) {
                                i18 = this.f82031o;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f82029m;
                                }
                                this.f82031o = i18;
                                i19 = this.f82032p;
                                if (i19 == -1) {
                                    i19 = this.f82030n;
                                }
                                this.f82032p = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f82031o;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f82040x) {
                            }
                            if (this.f82017a != null) {
                                iIntValue = ((Integer) e.f81987i0.get(this.f82017a)).intValue();
                            }
                            if (this.f82034r == 0) {
                                if (Float.compare(this.f82037u, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f82036t, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f82036t, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f82029m).Q(this.f82030n).a0(f11).d0(iIntValue).b0(this.f82038v).h0(this.f82039w).J(cVar);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.O).f0(this.Q).Y(i12);
                        i15 = 1;
                    }
                    if (this.f82017a != null) {
                        bVar.U(this.f82017a);
                    }
                    m1 m1VarE3 = bVar.R(i11).e0(str3).W(i13).V(this.W).g0(i23).T(listSingletonList).I(str).M(this.f82028l).E();
                    e0 e0VarTrack3 = nVar.track(this.f82019c, i15);
                    this.X = e0VarTrack3;
                    e0VarTrack3.e(m1VarE3);
                    return;
                case 3:
                    this.T = new f0();
                    str5 = MimeTypes.AUDIO_TRUEHD;
                    listSingletonList = null;
                    str = null;
                    i13 = -1;
                    i12 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                        str = dVarA.f35724c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z14 = this.V;
                    if (this.U) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i24 = i14 | (z14 ? 1 : 0);
                    bVar = new m1.b();
                    if (w.o(str3)) {
                        if (w.s(str3)) {
                            if (this.f82033q == 0) {
                                i18 = this.f82031o;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f82029m;
                                }
                                this.f82031o = i18;
                                i19 = this.f82032p;
                                if (i19 == -1) {
                                    i19 = this.f82030n;
                                }
                                this.f82032p = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f82031o;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f82040x) {
                            }
                            if (this.f82017a != null) {
                                iIntValue = ((Integer) e.f81987i0.get(this.f82017a)).intValue();
                            }
                            if (this.f82034r == 0) {
                                if (Float.compare(this.f82037u, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f82036t, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f82036t, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f82029m).Q(this.f82030n).a0(f11).d0(iIntValue).b0(this.f82038v).h0(this.f82039w).J(cVar);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.O).f0(this.Q).Y(i12);
                        i15 = 1;
                    }
                    if (this.f82017a != null) {
                        bVar.U(this.f82017a);
                    }
                    m1 m1VarE4 = bVar.R(i11).e0(str3).W(i13).V(this.W).g0(i24).T(listSingletonList).I(str).M(this.f82028l).E();
                    e0 e0VarTrack4 = nVar.track(this.f82019c, i15);
                    this.X = e0VarTrack4;
                    e0VarTrack4.e(m1VarE4);
                    return;
                case 4:
                    listSingletonList = m(g(this.f82018b));
                    str5 = MimeTypes.AUDIO_VORBIS;
                    str = null;
                    i13 = 8192;
                    i12 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                        str = dVarA.f35724c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z15 = this.V;
                    if (this.U) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i25 = i14 | (z15 ? 1 : 0);
                    bVar = new m1.b();
                    if (w.o(str3)) {
                        if (w.s(str3)) {
                            if (this.f82033q == 0) {
                                i18 = this.f82031o;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f82029m;
                                }
                                this.f82031o = i18;
                                i19 = this.f82032p;
                                if (i19 == -1) {
                                    i19 = this.f82030n;
                                }
                                this.f82032p = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f82031o;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f82040x) {
                            }
                            if (this.f82017a != null) {
                                iIntValue = ((Integer) e.f81987i0.get(this.f82017a)).intValue();
                            }
                            if (this.f82034r == 0) {
                                if (Float.compare(this.f82037u, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f82036t, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f82036t, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f82029m).Q(this.f82030n).a0(f11).d0(iIntValue).b0(this.f82038v).h0(this.f82039w).J(cVar);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.O).f0(this.Q).Y(i12);
                        i15 = 1;
                    }
                    if (this.f82017a != null) {
                        bVar.U(this.f82017a);
                    }
                    m1 m1VarE5 = bVar.R(i11).e0(str3).W(i13).V(this.W).g0(i25).T(listSingletonList).I(str).M(this.f82028l).E();
                    e0 e0VarTrack5 = nVar.track(this.f82019c, i15);
                    this.X = e0VarTrack5;
                    e0VarTrack5.e(m1VarE5);
                    return;
                case 5:
                    str5 = MimeTypes.AUDIO_MPEG_L2;
                    listSingletonList = null;
                    str = null;
                    i13 = 4096;
                    i12 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                        str = dVarA.f35724c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z16 = this.V;
                    if (this.U) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i26 = i14 | (z16 ? 1 : 0);
                    bVar = new m1.b();
                    if (w.o(str3)) {
                        if (w.s(str3)) {
                            if (this.f82033q == 0) {
                                i18 = this.f82031o;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f82029m;
                                }
                                this.f82031o = i18;
                                i19 = this.f82032p;
                                if (i19 == -1) {
                                    i19 = this.f82030n;
                                }
                                this.f82032p = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f82031o;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f82040x) {
                            }
                            if (this.f82017a != null) {
                                iIntValue = ((Integer) e.f81987i0.get(this.f82017a)).intValue();
                            }
                            if (this.f82034r == 0) {
                                if (Float.compare(this.f82037u, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f82036t, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f82036t, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f82029m).Q(this.f82030n).a0(f11).d0(iIntValue).b0(this.f82038v).h0(this.f82039w).J(cVar);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.O).f0(this.Q).Y(i12);
                        i15 = 1;
                    }
                    if (this.f82017a != null) {
                        bVar.U(this.f82017a);
                    }
                    m1 m1VarE6 = bVar.R(i11).e0(str3).W(i13).V(this.W).g0(i26).T(listSingletonList).I(str).M(this.f82028l).E();
                    e0 e0VarTrack6 = nVar.track(this.f82019c, i15);
                    this.X = e0VarTrack6;
                    e0VarTrack6.e(m1VarE6);
                    return;
                case 6:
                    str5 = MimeTypes.AUDIO_MPEG;
                    listSingletonList = null;
                    str = null;
                    i13 = 4096;
                    i12 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                        str = dVarA.f35724c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z17 = this.V;
                    if (this.U) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i27 = i14 | (z17 ? 1 : 0);
                    bVar = new m1.b();
                    if (w.o(str3)) {
                        if (w.s(str3)) {
                            if (this.f82033q == 0) {
                                i18 = this.f82031o;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f82029m;
                                }
                                this.f82031o = i18;
                                i19 = this.f82032p;
                                if (i19 == -1) {
                                    i19 = this.f82030n;
                                }
                                this.f82032p = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f82031o;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f82040x) {
                            }
                            if (this.f82017a != null) {
                                iIntValue = ((Integer) e.f81987i0.get(this.f82017a)).intValue();
                            }
                            if (this.f82034r == 0) {
                                if (Float.compare(this.f82037u, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f82036t, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f82036t, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f82029m).Q(this.f82030n).a0(f11).d0(iIntValue).b0(this.f82038v).h0(this.f82039w).J(cVar);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.O).f0(this.Q).Y(i12);
                        i15 = 1;
                    }
                    if (this.f82017a != null) {
                        bVar.U(this.f82017a);
                    }
                    m1 m1VarE7 = bVar.R(i11).e0(str3).W(i13).V(this.W).g0(i27).T(listSingletonList).I(str).M(this.f82028l).E();
                    e0 e0VarTrack7 = nVar.track(this.f82019c, i15);
                    this.X = e0VarTrack7;
                    e0VarTrack7.e(m1VarE7);
                    return;
                case 7:
                    Pair<String, List<byte[]>> pairK = k(new c0(g(this.f82018b)));
                    str5 = (String) pairK.first;
                    listSingletonList = (List) pairK.second;
                    str = null;
                    i13 = -1;
                    i12 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                        str = dVarA.f35724c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z18 = this.V;
                    if (this.U) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i28 = i14 | (z18 ? 1 : 0);
                    bVar = new m1.b();
                    if (w.o(str3)) {
                        if (w.s(str3)) {
                            if (this.f82033q == 0) {
                                i18 = this.f82031o;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f82029m;
                                }
                                this.f82031o = i18;
                                i19 = this.f82032p;
                                if (i19 == -1) {
                                    i19 = this.f82030n;
                                }
                                this.f82032p = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f82031o;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f82040x) {
                            }
                            if (this.f82017a != null) {
                                iIntValue = ((Integer) e.f81987i0.get(this.f82017a)).intValue();
                            }
                            if (this.f82034r == 0) {
                                if (Float.compare(this.f82037u, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f82036t, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f82036t, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f82029m).Q(this.f82030n).a0(f11).d0(iIntValue).b0(this.f82038v).h0(this.f82039w).J(cVar);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.O).f0(this.Q).Y(i12);
                        i15 = 1;
                    }
                    if (this.f82017a != null) {
                        bVar.U(this.f82017a);
                    }
                    m1 m1VarE8 = bVar.R(i11).e0(str3).W(i13).V(this.W).g0(i28).T(listSingletonList).I(str).M(this.f82028l).E();
                    e0 e0VarTrack8 = nVar.track(this.f82019c, i15);
                    this.X = e0VarTrack8;
                    e0VarTrack8.e(m1VarE8);
                    return;
                case 8:
                    byte[] bArr3 = new byte[4];
                    System.arraycopy(g(this.f82018b), 0, bArr3, 0, 4);
                    listSingletonList = ImmutableList.of(bArr3);
                    str = null;
                    str5 = MimeTypes.APPLICATION_DVBSUBS;
                    i13 = -1;
                    i12 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                        str = dVarA.f35724c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z19 = this.V;
                    if (this.U) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i29 = i14 | (z19 ? 1 : 0);
                    bVar = new m1.b();
                    if (w.o(str3)) {
                        if (w.s(str3)) {
                            if (this.f82033q == 0) {
                                i18 = this.f82031o;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f82029m;
                                }
                                this.f82031o = i18;
                                i19 = this.f82032p;
                                if (i19 == -1) {
                                    i19 = this.f82030n;
                                }
                                this.f82032p = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f82031o;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f82040x) {
                            }
                            if (this.f82017a != null) {
                                iIntValue = ((Integer) e.f81987i0.get(this.f82017a)).intValue();
                            }
                            if (this.f82034r == 0) {
                                if (Float.compare(this.f82037u, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f82036t, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f82036t, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f82029m).Q(this.f82030n).a0(f11).d0(iIntValue).b0(this.f82038v).h0(this.f82039w).J(cVar);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.O).f0(this.Q).Y(i12);
                        i15 = 1;
                    }
                    if (this.f82017a != null) {
                        bVar.U(this.f82017a);
                    }
                    m1 m1VarE9 = bVar.R(i11).e0(str3).W(i13).V(this.W).g0(i29).T(listSingletonList).I(str).M(this.f82028l).E();
                    e0 e0VarTrack9 = nVar.track(this.f82019c, i15);
                    this.X = e0VarTrack9;
                    e0VarTrack9.e(m1VarE9);
                    return;
                case 10:
                    com.google.android.exoplayer2.video.a aVarB = com.google.android.exoplayer2.video.a.b(new c0(g(this.f82018b)));
                    list = aVarB.f35710a;
                    this.Y = aVarB.f35711b;
                    str2 = aVarB.f35715f;
                    str5 = MimeTypes.VIDEO_H264;
                    i13 = -1;
                    i12 = -1;
                    List<byte[]> list2 = list;
                    str = str2;
                    listSingletonList = list2;
                    bArr = this.N;
                    if (bArr != null) {
                        str = dVarA.f35724c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z110 = this.V;
                    if (this.U) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i210 = i14 | (z110 ? 1 : 0);
                    bVar = new m1.b();
                    if (w.o(str3)) {
                        if (w.s(str3)) {
                            if (this.f82033q == 0) {
                                i18 = this.f82031o;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f82029m;
                                }
                                this.f82031o = i18;
                                i19 = this.f82032p;
                                if (i19 == -1) {
                                    i19 = this.f82030n;
                                }
                                this.f82032p = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f82031o;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f82040x) {
                            }
                            if (this.f82017a != null) {
                                iIntValue = ((Integer) e.f81987i0.get(this.f82017a)).intValue();
                            }
                            if (this.f82034r == 0) {
                                if (Float.compare(this.f82037u, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f82036t, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f82036t, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f82029m).Q(this.f82030n).a0(f11).d0(iIntValue).b0(this.f82038v).h0(this.f82039w).J(cVar);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.O).f0(this.Q).Y(i12);
                        i15 = 1;
                    }
                    if (this.f82017a != null) {
                        bVar.U(this.f82017a);
                    }
                    m1 m1VarE10 = bVar.R(i11).e0(str3).W(i13).V(this.W).g0(i210).T(listSingletonList).I(str).M(this.f82028l).E();
                    e0 e0VarTrack10 = nVar.track(this.f82019c, i15);
                    this.X = e0VarTrack10;
                    e0VarTrack10.e(m1VarE10);
                    return;
                case 11:
                    listSingletonList = ImmutableList.of(g(this.f82018b));
                    str = null;
                    str5 = MimeTypes.APPLICATION_VOBSUB;
                    i13 = -1;
                    i12 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                        str = dVarA.f35724c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z111 = this.V;
                    if (this.U) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i211 = i14 | (z111 ? 1 : 0);
                    bVar = new m1.b();
                    if (w.o(str3)) {
                        if (w.s(str3)) {
                            if (this.f82033q == 0) {
                                i18 = this.f82031o;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f82029m;
                                }
                                this.f82031o = i18;
                                i19 = this.f82032p;
                                if (i19 == -1) {
                                    i19 = this.f82030n;
                                }
                                this.f82032p = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f82031o;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f82040x) {
                            }
                            if (this.f82017a != null) {
                                iIntValue = ((Integer) e.f81987i0.get(this.f82017a)).intValue();
                            }
                            if (this.f82034r == 0) {
                                if (Float.compare(this.f82037u, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f82036t, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f82036t, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f82029m).Q(this.f82030n).a0(f11).d0(iIntValue).b0(this.f82038v).h0(this.f82039w).J(cVar);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.O).f0(this.Q).Y(i12);
                        i15 = 1;
                    }
                    if (this.f82017a != null) {
                        bVar.U(this.f82017a);
                    }
                    m1 m1VarE11 = bVar.R(i11).e0(str3).W(i13).V(this.W).g0(i211).T(listSingletonList).I(str).M(this.f82028l).E();
                    e0 e0VarTrack11 = nVar.track(this.f82019c, i15);
                    this.X = e0VarTrack11;
                    e0VarTrack11.e(m1VarE11);
                    return;
                case 12:
                    str5 = MimeTypes.AUDIO_DTS_HD;
                    listSingletonList = null;
                    str = null;
                    i13 = -1;
                    i12 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                        str = dVarA.f35724c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z112 = this.V;
                    if (this.U) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i212 = i14 | (z112 ? 1 : 0);
                    bVar = new m1.b();
                    if (w.o(str3)) {
                        if (w.s(str3)) {
                            if (this.f82033q == 0) {
                                i18 = this.f82031o;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f82029m;
                                }
                                this.f82031o = i18;
                                i19 = this.f82032p;
                                if (i19 == -1) {
                                    i19 = this.f82030n;
                                }
                                this.f82032p = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f82031o;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f82040x) {
                            }
                            if (this.f82017a != null) {
                                iIntValue = ((Integer) e.f81987i0.get(this.f82017a)).intValue();
                            }
                            if (this.f82034r == 0) {
                                if (Float.compare(this.f82037u, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f82036t, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f82036t, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f82029m).Q(this.f82030n).a0(f11).d0(iIntValue).b0(this.f82038v).h0(this.f82039w).J(cVar);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.O).f0(this.Q).Y(i12);
                        i15 = 1;
                    }
                    if (this.f82017a != null) {
                        bVar.U(this.f82017a);
                    }
                    m1 m1VarE12 = bVar.R(i11).e0(str3).W(i13).V(this.W).g0(i212).T(listSingletonList).I(str).M(this.f82028l).E();
                    e0 e0VarTrack12 = nVar.track(this.f82019c, i15);
                    this.X = e0VarTrack12;
                    e0VarTrack12.e(m1VarE12);
                    return;
                case 13:
                    listSingletonList = Collections.singletonList(g(this.f82018b));
                    com.google.android.exoplayer2.audio.a.b bVarF = com.google.android.exoplayer2.audio.a.f(this.f82027k);
                    this.Q = bVarF.f32770a;
                    this.O = bVarF.f32771b;
                    str = bVarF.f32772c;
                    str5 = MimeTypes.AUDIO_AAC;
                    i13 = -1;
                    i12 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                        str = dVarA.f35724c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z113 = this.V;
                    if (this.U) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i213 = i14 | (z113 ? 1 : 0);
                    bVar = new m1.b();
                    if (w.o(str3)) {
                        if (w.s(str3)) {
                            if (this.f82033q == 0) {
                                i18 = this.f82031o;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f82029m;
                                }
                                this.f82031o = i18;
                                i19 = this.f82032p;
                                if (i19 == -1) {
                                    i19 = this.f82030n;
                                }
                                this.f82032p = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f82031o;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f82040x) {
                            }
                            if (this.f82017a != null) {
                                iIntValue = ((Integer) e.f81987i0.get(this.f82017a)).intValue();
                            }
                            if (this.f82034r == 0) {
                                if (Float.compare(this.f82037u, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f82036t, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f82036t, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f82029m).Q(this.f82030n).a0(f11).d0(iIntValue).b0(this.f82038v).h0(this.f82039w).J(cVar);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.O).f0(this.Q).Y(i12);
                        i15 = 1;
                    }
                    if (this.f82017a != null) {
                        bVar.U(this.f82017a);
                    }
                    m1 m1VarE13 = bVar.R(i11).e0(str3).W(i13).V(this.W).g0(i213).T(listSingletonList).I(str).M(this.f82028l).E();
                    e0 e0VarTrack13 = nVar.track(this.f82019c, i15);
                    this.X = e0VarTrack13;
                    e0VarTrack13.e(m1VarE13);
                    return;
                case 14:
                    str5 = MimeTypes.AUDIO_AC3;
                    listSingletonList = null;
                    str = null;
                    i13 = -1;
                    i12 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                        str = dVarA.f35724c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z114 = this.V;
                    if (this.U) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i214 = i14 | (z114 ? 1 : 0);
                    bVar = new m1.b();
                    if (w.o(str3)) {
                        if (w.s(str3)) {
                            if (this.f82033q == 0) {
                                i18 = this.f82031o;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f82029m;
                                }
                                this.f82031o = i18;
                                i19 = this.f82032p;
                                if (i19 == -1) {
                                    i19 = this.f82030n;
                                }
                                this.f82032p = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f82031o;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f82040x) {
                            }
                            if (this.f82017a != null) {
                                iIntValue = ((Integer) e.f81987i0.get(this.f82017a)).intValue();
                            }
                            if (this.f82034r == 0) {
                                if (Float.compare(this.f82037u, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f82036t, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f82036t, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f82029m).Q(this.f82030n).a0(f11).d0(iIntValue).b0(this.f82038v).h0(this.f82039w).J(cVar);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.O).f0(this.Q).Y(i12);
                        i15 = 1;
                    }
                    if (this.f82017a != null) {
                        bVar.U(this.f82017a);
                    }
                    m1 m1VarE14 = bVar.R(i11).e0(str3).W(i13).V(this.W).g0(i214).T(listSingletonList).I(str).M(this.f82028l).E();
                    e0 e0VarTrack14 = nVar.track(this.f82019c, i15);
                    this.X = e0VarTrack14;
                    e0VarTrack14.e(m1VarE14);
                    return;
                case 15:
                case 21:
                    str5 = MimeTypes.AUDIO_DTS;
                    listSingletonList = null;
                    str = null;
                    i13 = -1;
                    i12 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                        str = dVarA.f35724c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z115 = this.V;
                    if (this.U) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i215 = i14 | (z115 ? 1 : 0);
                    bVar = new m1.b();
                    if (w.o(str3)) {
                        if (w.s(str3)) {
                            if (this.f82033q == 0) {
                                i18 = this.f82031o;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f82029m;
                                }
                                this.f82031o = i18;
                                i19 = this.f82032p;
                                if (i19 == -1) {
                                    i19 = this.f82030n;
                                }
                                this.f82032p = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f82031o;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f82040x) {
                            }
                            if (this.f82017a != null) {
                                iIntValue = ((Integer) e.f81987i0.get(this.f82017a)).intValue();
                            }
                            if (this.f82034r == 0) {
                                if (Float.compare(this.f82037u, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f82036t, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f82036t, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f82029m).Q(this.f82030n).a0(f11).d0(iIntValue).b0(this.f82038v).h0(this.f82039w).J(cVar);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.O).f0(this.Q).Y(i12);
                        i15 = 1;
                    }
                    if (this.f82017a != null) {
                        bVar.U(this.f82017a);
                    }
                    m1 m1VarE15 = bVar.R(i11).e0(str3).W(i13).V(this.W).g0(i215).T(listSingletonList).I(str).M(this.f82028l).E();
                    e0 e0VarTrack15 = nVar.track(this.f82019c, i15);
                    this.X = e0VarTrack15;
                    e0VarTrack15.e(m1VarE15);
                    return;
                case 16:
                    str5 = "video/av01";
                    listSingletonList = null;
                    str = null;
                    i13 = -1;
                    i12 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                        str = dVarA.f35724c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z116 = this.V;
                    if (this.U) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i216 = i14 | (z116 ? 1 : 0);
                    bVar = new m1.b();
                    if (w.o(str3)) {
                        if (w.s(str3)) {
                            if (this.f82033q == 0) {
                                i18 = this.f82031o;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f82029m;
                                }
                                this.f82031o = i18;
                                i19 = this.f82032p;
                                if (i19 == -1) {
                                    i19 = this.f82030n;
                                }
                                this.f82032p = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f82031o;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f82040x) {
                            }
                            if (this.f82017a != null) {
                                iIntValue = ((Integer) e.f81987i0.get(this.f82017a)).intValue();
                            }
                            if (this.f82034r == 0) {
                                if (Float.compare(this.f82037u, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f82036t, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f82036t, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f82029m).Q(this.f82030n).a0(f11).d0(iIntValue).b0(this.f82038v).h0(this.f82039w).J(cVar);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.O).f0(this.Q).Y(i12);
                        i15 = 1;
                    }
                    if (this.f82017a != null) {
                        bVar.U(this.f82017a);
                    }
                    m1 m1VarE16 = bVar.R(i11).e0(str3).W(i13).V(this.W).g0(i216).T(listSingletonList).I(str).M(this.f82028l).E();
                    e0 e0VarTrack16 = nVar.track(this.f82019c, i15);
                    this.X = e0VarTrack16;
                    e0VarTrack16.e(m1VarE16);
                    return;
                case 17:
                    str5 = MimeTypes.VIDEO_VP8;
                    listSingletonList = null;
                    str = null;
                    i13 = -1;
                    i12 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                        str = dVarA.f35724c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z117 = this.V;
                    if (this.U) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i217 = i14 | (z117 ? 1 : 0);
                    bVar = new m1.b();
                    if (w.o(str3)) {
                        if (w.s(str3)) {
                            if (this.f82033q == 0) {
                                i18 = this.f82031o;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f82029m;
                                }
                                this.f82031o = i18;
                                i19 = this.f82032p;
                                if (i19 == -1) {
                                    i19 = this.f82030n;
                                }
                                this.f82032p = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f82031o;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f82040x) {
                            }
                            if (this.f82017a != null) {
                                iIntValue = ((Integer) e.f81987i0.get(this.f82017a)).intValue();
                            }
                            if (this.f82034r == 0) {
                                if (Float.compare(this.f82037u, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f82036t, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f82036t, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f82029m).Q(this.f82030n).a0(f11).d0(iIntValue).b0(this.f82038v).h0(this.f82039w).J(cVar);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.O).f0(this.Q).Y(i12);
                        i15 = 1;
                    }
                    if (this.f82017a != null) {
                        bVar.U(this.f82017a);
                    }
                    m1 m1VarE17 = bVar.R(i11).e0(str3).W(i13).V(this.W).g0(i217).T(listSingletonList).I(str).M(this.f82028l).E();
                    e0 e0VarTrack17 = nVar.track(this.f82019c, i15);
                    this.X = e0VarTrack17;
                    e0VarTrack17.e(m1VarE17);
                    return;
                case 18:
                    str5 = MimeTypes.VIDEO_VP9;
                    listSingletonList = null;
                    str = null;
                    i13 = -1;
                    i12 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                        str = dVarA.f35724c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z118 = this.V;
                    if (this.U) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i218 = i14 | (z118 ? 1 : 0);
                    bVar = new m1.b();
                    if (w.o(str3)) {
                        if (w.s(str3)) {
                            if (this.f82033q == 0) {
                                i18 = this.f82031o;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f82029m;
                                }
                                this.f82031o = i18;
                                i19 = this.f82032p;
                                if (i19 == -1) {
                                    i19 = this.f82030n;
                                }
                                this.f82032p = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f82031o;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f82040x) {
                            }
                            if (this.f82017a != null) {
                                iIntValue = ((Integer) e.f81987i0.get(this.f82017a)).intValue();
                            }
                            if (this.f82034r == 0) {
                                if (Float.compare(this.f82037u, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f82036t, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f82036t, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f82029m).Q(this.f82030n).a0(f11).d0(iIntValue).b0(this.f82038v).h0(this.f82039w).J(cVar);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.O).f0(this.Q).Y(i12);
                        i15 = 1;
                    }
                    if (this.f82017a != null) {
                        bVar.U(this.f82017a);
                    }
                    m1 m1VarE18 = bVar.R(i11).e0(str3).W(i13).V(this.W).g0(i218).T(listSingletonList).I(str).M(this.f82028l).E();
                    e0 e0VarTrack18 = nVar.track(this.f82019c, i15);
                    this.X = e0VarTrack18;
                    e0VarTrack18.e(m1VarE18);
                    return;
                case 19:
                    listSingletonList = null;
                    str = null;
                    str5 = MimeTypes.APPLICATION_PGS;
                    i13 = -1;
                    i12 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                        str = dVarA.f35724c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z119 = this.V;
                    if (this.U) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i219 = i14 | (z119 ? 1 : 0);
                    bVar = new m1.b();
                    if (w.o(str3)) {
                        if (w.s(str3)) {
                            if (this.f82033q == 0) {
                                i18 = this.f82031o;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f82029m;
                                }
                                this.f82031o = i18;
                                i19 = this.f82032p;
                                if (i19 == -1) {
                                    i19 = this.f82030n;
                                }
                                this.f82032p = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f82031o;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f82040x) {
                            }
                            if (this.f82017a != null) {
                                iIntValue = ((Integer) e.f81987i0.get(this.f82017a)).intValue();
                            }
                            if (this.f82034r == 0) {
                                if (Float.compare(this.f82037u, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f82036t, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f82036t, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f82029m).Q(this.f82030n).a0(f11).d0(iIntValue).b0(this.f82038v).h0(this.f82039w).J(cVar);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.O).f0(this.Q).Y(i12);
                        i15 = 1;
                    }
                    if (this.f82017a != null) {
                        bVar.U(this.f82017a);
                    }
                    m1 m1VarE19 = bVar.R(i11).e0(str3).W(i13).V(this.W).g0(i219).T(listSingletonList).I(str).M(this.f82028l).E();
                    e0 e0VarTrack19 = nVar.track(this.f82019c, i15);
                    this.X = e0VarTrack19;
                    e0VarTrack19.e(m1VarE19);
                    return;
                case 20:
                    str5 = MimeTypes.VIDEO_UNKNOWN;
                    listSingletonList = null;
                    str = null;
                    i13 = -1;
                    i12 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                        str = dVarA.f35724c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z1110 = this.V;
                    if (this.U) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i2110 = i14 | (z1110 ? 1 : 0);
                    bVar = new m1.b();
                    if (w.o(str3)) {
                        if (w.s(str3)) {
                            if (this.f82033q == 0) {
                                i18 = this.f82031o;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f82029m;
                                }
                                this.f82031o = i18;
                                i19 = this.f82032p;
                                if (i19 == -1) {
                                    i19 = this.f82030n;
                                }
                                this.f82032p = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f82031o;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f82040x) {
                            }
                            if (this.f82017a != null) {
                                iIntValue = ((Integer) e.f81987i0.get(this.f82017a)).intValue();
                            }
                            if (this.f82034r == 0) {
                                if (Float.compare(this.f82037u, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f82036t, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f82036t, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f82029m).Q(this.f82030n).a0(f11).d0(iIntValue).b0(this.f82038v).h0(this.f82039w).J(cVar);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.O).f0(this.Q).Y(i12);
                        i15 = 1;
                    }
                    if (this.f82017a != null) {
                        bVar.U(this.f82017a);
                    }
                    m1 m1VarE110 = bVar.R(i11).e0(str3).W(i13).V(this.W).g0(i2110).T(listSingletonList).I(str).M(this.f82028l).E();
                    e0 e0VarTrack110 = nVar.track(this.f82019c, i15);
                    this.X = e0VarTrack110;
                    e0VarTrack110.e(m1VarE110);
                    return;
                case 22:
                    if (this.P == 32) {
                        listSingletonList = null;
                        str = null;
                        i13 = -1;
                        i12 = 4;
                    } else {
                        s.i("MatroskaExtractor", "Unsupported floating point PCM bit depth: " + this.P + ". Setting mimeType to " + MimeTypes.AUDIO_UNKNOWN);
                        listSingletonList = null;
                        str = null;
                        str5 = MimeTypes.AUDIO_UNKNOWN;
                        i13 = -1;
                        i12 = -1;
                    }
                    bArr = this.N;
                    if (bArr != null) {
                        str = dVarA.f35724c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z1111 = this.V;
                    if (this.U) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i2111 = i14 | (z1111 ? 1 : 0);
                    bVar = new m1.b();
                    if (w.o(str3)) {
                        if (w.s(str3)) {
                            if (this.f82033q == 0) {
                                i18 = this.f82031o;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f82029m;
                                }
                                this.f82031o = i18;
                                i19 = this.f82032p;
                                if (i19 == -1) {
                                    i19 = this.f82030n;
                                }
                                this.f82032p = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f82031o;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f82040x) {
                            }
                            if (this.f82017a != null) {
                                iIntValue = ((Integer) e.f81987i0.get(this.f82017a)).intValue();
                            }
                            if (this.f82034r == 0) {
                                if (Float.compare(this.f82037u, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f82036t, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f82036t, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f82029m).Q(this.f82030n).a0(f11).d0(iIntValue).b0(this.f82038v).h0(this.f82039w).J(cVar);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.O).f0(this.Q).Y(i12);
                        i15 = 1;
                    }
                    if (this.f82017a != null) {
                        bVar.U(this.f82017a);
                    }
                    m1 m1VarE111 = bVar.R(i11).e0(str3).W(i13).V(this.W).g0(i2111).T(listSingletonList).I(str).M(this.f82028l).E();
                    e0 e0VarTrack111 = nVar.track(this.f82019c, i15);
                    this.X = e0VarTrack111;
                    e0VarTrack111.e(m1VarE111);
                    return;
                case 23:
                    int i31 = this.P;
                    if (i31 == 8) {
                        listSingletonList = null;
                        str = null;
                        i13 = -1;
                        i12 = 3;
                    } else if (i31 == 16) {
                        listSingletonList = null;
                        str = null;
                        i13 = -1;
                        i12 = ASTNode.DEOP;
                    } else {
                        s.i("MatroskaExtractor", "Unsupported big endian PCM bit depth: " + this.P + ". Setting mimeType to " + MimeTypes.AUDIO_UNKNOWN);
                        listSingletonList = null;
                        str = null;
                        str5 = MimeTypes.AUDIO_UNKNOWN;
                        i13 = -1;
                        i12 = -1;
                    }
                    bArr = this.N;
                    if (bArr != null) {
                        str = dVarA.f35724c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z1112 = this.V;
                    if (this.U) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i2112 = i14 | (z1112 ? 1 : 0);
                    bVar = new m1.b();
                    if (w.o(str3)) {
                        if (w.s(str3)) {
                            if (this.f82033q == 0) {
                                i18 = this.f82031o;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f82029m;
                                }
                                this.f82031o = i18;
                                i19 = this.f82032p;
                                if (i19 == -1) {
                                    i19 = this.f82030n;
                                }
                                this.f82032p = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f82031o;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f82040x) {
                            }
                            if (this.f82017a != null) {
                                iIntValue = ((Integer) e.f81987i0.get(this.f82017a)).intValue();
                            }
                            if (this.f82034r == 0) {
                                if (Float.compare(this.f82037u, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f82036t, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f82036t, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f82029m).Q(this.f82030n).a0(f11).d0(iIntValue).b0(this.f82038v).h0(this.f82039w).J(cVar);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.O).f0(this.Q).Y(i12);
                        i15 = 1;
                    }
                    if (this.f82017a != null) {
                        bVar.U(this.f82017a);
                    }
                    m1 m1VarE112 = bVar.R(i11).e0(str3).W(i13).V(this.W).g0(i2112).T(listSingletonList).I(str).M(this.f82028l).E();
                    e0 e0VarTrack112 = nVar.track(this.f82019c, i15);
                    this.X = e0VarTrack112;
                    e0VarTrack112.e(m1VarE112);
                    return;
                case 24:
                    int iC1 = o0.c0(this.P);
                    if (iC1 == 0) {
                        s.i("MatroskaExtractor", "Unsupported little endian PCM bit depth: " + this.P + ". Setting mimeType to " + MimeTypes.AUDIO_UNKNOWN);
                        listSingletonList = null;
                        str = null;
                        str5 = MimeTypes.AUDIO_UNKNOWN;
                        i13 = -1;
                        i12 = -1;
                    } else {
                        i12 = iC1;
                        listSingletonList = null;
                        str = null;
                        i13 = -1;
                    }
                    bArr = this.N;
                    if (bArr != null) {
                        str = dVarA.f35724c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z1113 = this.V;
                    if (this.U) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i2113 = i14 | (z1113 ? 1 : 0);
                    bVar = new m1.b();
                    if (w.o(str3)) {
                        if (w.s(str3)) {
                            if (this.f82033q == 0) {
                                i18 = this.f82031o;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f82029m;
                                }
                                this.f82031o = i18;
                                i19 = this.f82032p;
                                if (i19 == -1) {
                                    i19 = this.f82030n;
                                }
                                this.f82032p = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f82031o;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f82040x) {
                            }
                            if (this.f82017a != null) {
                                iIntValue = ((Integer) e.f81987i0.get(this.f82017a)).intValue();
                            }
                            if (this.f82034r == 0) {
                                if (Float.compare(this.f82037u, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f82036t, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f82036t, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f82029m).Q(this.f82030n).a0(f11).d0(iIntValue).b0(this.f82038v).h0(this.f82039w).J(cVar);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.O).f0(this.Q).Y(i12);
                        i15 = 1;
                    }
                    if (this.f82017a != null) {
                        bVar.U(this.f82017a);
                    }
                    m1 m1VarE113 = bVar.R(i11).e0(str3).W(i13).V(this.W).g0(i2113).T(listSingletonList).I(str).M(this.f82028l).E();
                    e0 e0VarTrack113 = nVar.track(this.f82019c, i15);
                    this.X = e0VarTrack113;
                    e0VarTrack113.e(m1VarE113);
                    return;
                case 25:
                    listSingletonList = ImmutableList.of(e.f81983e0, g(this.f82018b));
                    str = null;
                    str5 = MimeTypes.TEXT_SSA;
                    i13 = -1;
                    i12 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                        str = dVarA.f35724c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z1114 = this.V;
                    if (this.U) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i2114 = i14 | (z1114 ? 1 : 0);
                    bVar = new m1.b();
                    if (w.o(str3)) {
                        if (w.s(str3)) {
                            if (this.f82033q == 0) {
                                i18 = this.f82031o;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f82029m;
                                }
                                this.f82031o = i18;
                                i19 = this.f82032p;
                                if (i19 == -1) {
                                    i19 = this.f82030n;
                                }
                                this.f82032p = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f82031o;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f82040x) {
                            }
                            if (this.f82017a != null) {
                                iIntValue = ((Integer) e.f81987i0.get(this.f82017a)).intValue();
                            }
                            if (this.f82034r == 0) {
                                if (Float.compare(this.f82037u, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f82036t, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f82036t, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f82029m).Q(this.f82030n).a0(f11).d0(iIntValue).b0(this.f82038v).h0(this.f82039w).J(cVar);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.O).f0(this.Q).Y(i12);
                        i15 = 1;
                    }
                    if (this.f82017a != null) {
                        bVar.U(this.f82017a);
                    }
                    m1 m1VarE114 = bVar.R(i11).e0(str3).W(i13).V(this.W).g0(i2114).T(listSingletonList).I(str).M(this.f82028l).E();
                    e0 e0VarTrack114 = nVar.track(this.f82019c, i15);
                    this.X = e0VarTrack114;
                    e0VarTrack114.e(m1VarE114);
                    return;
                case 26:
                    com.google.android.exoplayer2.video.f fVarA = com.google.android.exoplayer2.video.f.a(new c0(g(this.f82018b)));
                    list = fVarA.f35739a;
                    this.Y = fVarA.f35740b;
                    str2 = fVarA.f35744f;
                    str5 = MimeTypes.VIDEO_H265;
                    i13 = -1;
                    i12 = -1;
                    List<byte[]> list3 = list;
                    str = str2;
                    listSingletonList = list3;
                    bArr = this.N;
                    if (bArr != null) {
                        str = dVarA.f35724c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z1115 = this.V;
                    if (this.U) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i2115 = i14 | (z1115 ? 1 : 0);
                    bVar = new m1.b();
                    if (w.o(str3)) {
                        if (w.s(str3)) {
                            if (this.f82033q == 0) {
                                i18 = this.f82031o;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f82029m;
                                }
                                this.f82031o = i18;
                                i19 = this.f82032p;
                                if (i19 == -1) {
                                    i19 = this.f82030n;
                                }
                                this.f82032p = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f82031o;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f82040x) {
                            }
                            if (this.f82017a != null) {
                                iIntValue = ((Integer) e.f81987i0.get(this.f82017a)).intValue();
                            }
                            if (this.f82034r == 0) {
                                if (Float.compare(this.f82037u, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f82036t, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f82036t, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f82029m).Q(this.f82030n).a0(f11).d0(iIntValue).b0(this.f82038v).h0(this.f82039w).J(cVar);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.O).f0(this.Q).Y(i12);
                        i15 = 1;
                    }
                    if (this.f82017a != null) {
                        bVar.U(this.f82017a);
                    }
                    m1 m1VarE115 = bVar.R(i11).e0(str3).W(i13).V(this.W).g0(i2115).T(listSingletonList).I(str).M(this.f82028l).E();
                    e0 e0VarTrack115 = nVar.track(this.f82019c, i15);
                    this.X = e0VarTrack115;
                    e0VarTrack115.e(m1VarE115);
                    return;
                case 27:
                    str5 = MimeTypes.TEXT_VTT;
                    listSingletonList = null;
                    str = null;
                    i13 = -1;
                    i12 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                        str = dVarA.f35724c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z1116 = this.V;
                    if (this.U) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i2116 = i14 | (z1116 ? 1 : 0);
                    bVar = new m1.b();
                    if (w.o(str3)) {
                        if (w.s(str3)) {
                            if (this.f82033q == 0) {
                                i18 = this.f82031o;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f82029m;
                                }
                                this.f82031o = i18;
                                i19 = this.f82032p;
                                if (i19 == -1) {
                                    i19 = this.f82030n;
                                }
                                this.f82032p = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f82031o;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f82040x) {
                            }
                            if (this.f82017a != null) {
                                iIntValue = ((Integer) e.f81987i0.get(this.f82017a)).intValue();
                            }
                            if (this.f82034r == 0) {
                                if (Float.compare(this.f82037u, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f82036t, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f82036t, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f82029m).Q(this.f82030n).a0(f11).d0(iIntValue).b0(this.f82038v).h0(this.f82039w).J(cVar);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.O).f0(this.Q).Y(i12);
                        i15 = 1;
                    }
                    if (this.f82017a != null) {
                        bVar.U(this.f82017a);
                    }
                    m1 m1VarE116 = bVar.R(i11).e0(str3).W(i13).V(this.W).g0(i2116).T(listSingletonList).I(str).M(this.f82028l).E();
                    e0 e0VarTrack116 = nVar.track(this.f82019c, i15);
                    this.X = e0VarTrack116;
                    e0VarTrack116.e(m1VarE116);
                    return;
                case 28:
                    str5 = MimeTypes.APPLICATION_SUBRIP;
                    listSingletonList = null;
                    str = null;
                    i13 = -1;
                    i12 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                        str = dVarA.f35724c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z1117 = this.V;
                    if (this.U) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i2117 = i14 | (z1117 ? 1 : 0);
                    bVar = new m1.b();
                    if (w.o(str3)) {
                        if (w.s(str3)) {
                            if (this.f82033q == 0) {
                                i18 = this.f82031o;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f82029m;
                                }
                                this.f82031o = i18;
                                i19 = this.f82032p;
                                if (i19 == -1) {
                                    i19 = this.f82030n;
                                }
                                this.f82032p = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f82031o;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f82040x) {
                            }
                            if (this.f82017a != null) {
                                iIntValue = ((Integer) e.f81987i0.get(this.f82017a)).intValue();
                            }
                            if (this.f82034r == 0) {
                                if (Float.compare(this.f82037u, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f82036t, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f82036t, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f82029m).Q(this.f82030n).a0(f11).d0(iIntValue).b0(this.f82038v).h0(this.f82039w).J(cVar);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.O).f0(this.Q).Y(i12);
                        i15 = 1;
                    }
                    if (this.f82017a != null) {
                        bVar.U(this.f82017a);
                    }
                    m1 m1VarE117 = bVar.R(i11).e0(str3).W(i13).V(this.W).g0(i2117).T(listSingletonList).I(str).M(this.f82028l).E();
                    e0 e0VarTrack117 = nVar.track(this.f82019c, i15);
                    this.X = e0VarTrack117;
                    e0VarTrack117.e(m1VarE117);
                    return;
                case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                    str5 = MimeTypes.VIDEO_MPEG2;
                    listSingletonList = null;
                    str = null;
                    i13 = -1;
                    i12 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                        str = dVarA.f35724c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z1118 = this.V;
                    if (this.U) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i2118 = i14 | (z1118 ? 1 : 0);
                    bVar = new m1.b();
                    if (w.o(str3)) {
                        if (w.s(str3)) {
                            if (this.f82033q == 0) {
                                i18 = this.f82031o;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f82029m;
                                }
                                this.f82031o = i18;
                                i19 = this.f82032p;
                                if (i19 == -1) {
                                    i19 = this.f82030n;
                                }
                                this.f82032p = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f82031o;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f82040x) {
                            }
                            if (this.f82017a != null) {
                                iIntValue = ((Integer) e.f81987i0.get(this.f82017a)).intValue();
                            }
                            if (this.f82034r == 0) {
                                if (Float.compare(this.f82037u, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f82036t, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f82036t, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f82029m).Q(this.f82030n).a0(f11).d0(iIntValue).b0(this.f82038v).h0(this.f82039w).J(cVar);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.O).f0(this.Q).Y(i12);
                        i15 = 1;
                    }
                    if (this.f82017a != null) {
                        bVar.U(this.f82017a);
                    }
                    m1 m1VarE118 = bVar.R(i11).e0(str3).W(i13).V(this.W).g0(i2118).T(listSingletonList).I(str).M(this.f82028l).E();
                    e0 e0VarTrack118 = nVar.track(this.f82019c, i15);
                    this.X = e0VarTrack118;
                    e0VarTrack118.e(m1VarE118);
                    return;
                case 30:
                    str5 = MimeTypes.AUDIO_E_AC3;
                    listSingletonList = null;
                    str = null;
                    i13 = -1;
                    i12 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                        str = dVarA.f35724c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z1119 = this.V;
                    if (this.U) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i2119 = i14 | (z1119 ? 1 : 0);
                    bVar = new m1.b();
                    if (w.o(str3)) {
                        if (w.s(str3)) {
                            if (this.f82033q == 0) {
                                i18 = this.f82031o;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f82029m;
                                }
                                this.f82031o = i18;
                                i19 = this.f82032p;
                                if (i19 == -1) {
                                    i19 = this.f82030n;
                                }
                                this.f82032p = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f82031o;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f82040x) {
                            }
                            if (this.f82017a != null) {
                                iIntValue = ((Integer) e.f81987i0.get(this.f82017a)).intValue();
                            }
                            if (this.f82034r == 0) {
                                if (Float.compare(this.f82037u, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f82036t, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f82036t, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f82029m).Q(this.f82030n).a0(f11).d0(iIntValue).b0(this.f82038v).h0(this.f82039w).J(cVar);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.O).f0(this.Q).Y(i12);
                        i15 = 1;
                    }
                    if (this.f82017a != null) {
                        bVar.U(this.f82017a);
                    }
                    m1 m1VarE119 = bVar.R(i11).e0(str3).W(i13).V(this.W).g0(i2119).T(listSingletonList).I(str).M(this.f82028l).E();
                    e0 e0VarTrack119 = nVar.track(this.f82019c, i15);
                    this.X = e0VarTrack119;
                    e0VarTrack119.e(m1VarE119);
                    return;
                case VungleException.WEB_CRASH /* 31 */:
                    listSingletonList = Collections.singletonList(g(this.f82018b));
                    str5 = MimeTypes.AUDIO_FLAC;
                    str = null;
                    i13 = -1;
                    i12 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                        str = dVarA.f35724c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z11110 = this.V;
                    if (this.U) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i21110 = i14 | (z11110 ? 1 : 0);
                    bVar = new m1.b();
                    if (w.o(str3)) {
                        if (w.s(str3)) {
                            if (this.f82033q == 0) {
                                i18 = this.f82031o;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f82029m;
                                }
                                this.f82031o = i18;
                                i19 = this.f82032p;
                                if (i19 == -1) {
                                    i19 = this.f82030n;
                                }
                                this.f82032p = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f82031o;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f82040x) {
                            }
                            if (this.f82017a != null) {
                                iIntValue = ((Integer) e.f81987i0.get(this.f82017a)).intValue();
                            }
                            if (this.f82034r == 0) {
                                if (Float.compare(this.f82037u, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f82036t, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f82036t, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f82029m).Q(this.f82030n).a0(f11).d0(iIntValue).b0(this.f82038v).h0(this.f82039w).J(cVar);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.O).f0(this.Q).Y(i12);
                        i15 = 1;
                    }
                    if (this.f82017a != null) {
                        bVar.U(this.f82017a);
                    }
                    m1 m1VarE1110 = bVar.R(i11).e0(str3).W(i13).V(this.W).g0(i21110).T(listSingletonList).I(str).M(this.f82028l).E();
                    e0 e0VarTrack1110 = nVar.track(this.f82019c, i15);
                    this.X = e0VarTrack1110;
                    e0VarTrack1110.e(m1VarE1110);
                    return;
                case 32:
                    listSingletonList = new ArrayList<>(3);
                    listSingletonList.add(g(this.f82018b));
                    ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
                    ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                    listSingletonList.add(byteBufferAllocate.order(byteOrder).putLong(this.R).array());
                    listSingletonList.add(ByteBuffer.allocate(8).order(byteOrder).putLong(this.S).array());
                    str5 = MimeTypes.AUDIO_OPUS;
                    str = null;
                    i13 = 5760;
                    i12 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                        str = dVarA.f35724c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z11111 = this.V;
                    if (this.U) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i21111 = i14 | (z11111 ? 1 : 0);
                    bVar = new m1.b();
                    if (w.o(str3)) {
                        if (w.s(str3)) {
                            if (this.f82033q == 0) {
                                i18 = this.f82031o;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f82029m;
                                }
                                this.f82031o = i18;
                                i19 = this.f82032p;
                                if (i19 == -1) {
                                    i19 = this.f82030n;
                                }
                                this.f82032p = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f82031o;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f82040x) {
                            }
                            if (this.f82017a != null) {
                                iIntValue = ((Integer) e.f81987i0.get(this.f82017a)).intValue();
                            }
                            if (this.f82034r == 0) {
                                if (Float.compare(this.f82037u, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f82036t, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f82036t, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f82029m).Q(this.f82030n).a0(f11).d0(iIntValue).b0(this.f82038v).h0(this.f82039w).J(cVar);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.O).f0(this.Q).Y(i12);
                        i15 = 1;
                    }
                    if (this.f82017a != null) {
                        bVar.U(this.f82017a);
                    }
                    m1 m1VarE1111 = bVar.R(i11).e0(str3).W(i13).V(this.W).g0(i21111).T(listSingletonList).I(str).M(this.f82028l).E();
                    e0 e0VarTrack1111 = nVar.track(this.f82019c, i15);
                    this.X = e0VarTrack1111;
                    e0VarTrack1111.e(m1VarE1111);
                    return;
                default:
                    throw ParserException.createForMalformedContainer("Unrecognized codec identifier.", null);
            }
        }

        public void j() {
            f0 f0Var = this.T;
            if (f0Var != null) {
                f0Var.a(this.X, this.f82026j);
            }
        }

        public void n() {
            f0 f0Var = this.T;
            if (f0Var != null) {
                f0Var.b();
            }
        }

        public final boolean o(boolean z11) {
            if ("A_OPUS".equals(this.f82018b)) {
                return z11;
            }
            return this.f82022f > 0;
        }
    }

    static {
        HashMap map = new HashMap();
        map.put("htc_video_rotA-000", 0);
        map.put("htc_video_rotA-090", 90);
        map.put("htc_video_rotA-180", 180);
        map.put("htc_video_rotA-270", 270);
        f81987i0 = Collections.unmodifiableMap(map);
    }

    public e() {
        this(0);
    }

    public e(int i11) {
        this(new zg.a(), i11);
    }

    public e(zg.c cVar, int i11) {
        this.f82006q = -1L;
        this.f82007r = C.TIME_UNSET;
        this.f82008s = C.TIME_UNSET;
        this.f82009t = C.TIME_UNSET;
        this.f82015z = -1L;
        this.A = -1L;
        this.B = C.TIME_UNSET;
        this.f81988a = cVar;
        cVar.b(new b());
        this.f81993d = (i11 & 1) == 0;
        this.f81990b = new g();
        this.f81992c = new SparseArray<>();
        this.f81996g = new c0(4);
        this.f81997h = new c0(ByteBuffer.allocate(4).putInt(-1).array());
        this.f81998i = new c0(4);
        this.f81994e = new c0(x.f35652a);
        this.f81995f = new c0(4);
        this.f81999j = new c0();
        this.f82000k = new c0();
        this.f82001l = new c0(8);
        this.f82002m = new c0();
        this.f82003n = new c0();
        this.L = new int[1];
    }

    public static void E(String str, long j11, byte[] bArr) {
        byte[] bArrR;
        int i11;
        str.hashCode();
        switch (str) {
            case "S_TEXT/ASS":
                bArrR = r(j11, "%01d:%02d:%02d:%02d", 10000L);
                i11 = 21;
                break;
            case "S_TEXT/WEBVTT":
                bArrR = r(j11, "%02d:%02d:%02d.%03d", 1000L);
                i11 = 25;
                break;
            case "S_TEXT/UTF8":
                bArrR = r(j11, "%02d:%02d:%02d,%03d", 1000L);
                i11 = 19;
                break;
            default:
                throw new IllegalArgumentException();
        }
        System.arraycopy(bArrR, 0, bArr, i11, bArrR.length);
    }

    private void j() {
        com.google.android.exoplayer2.util.a.i(this.f81991b0);
    }

    public static int[] o(@Nullable int[] iArr, int i11) {
        if (iArr == null) {
            return new int[i11];
        }
        return iArr.length >= i11 ? iArr : new int[Math.max(iArr.length * 2, i11)];
    }

    public static byte[] r(long j11, String str, long j12) {
        com.google.android.exoplayer2.util.a.a(j11 != C.TIME_UNSET);
        int i11 = (int) (j11 / 3600000000L);
        long j13 = j11 - (((long) i11) * 3600000000L);
        int i12 = (int) (j13 / 60000000);
        long j14 = j13 - (((long) i12) * 60000000);
        int i13 = (int) (j14 / 1000000);
        return o0.n0(String.format(Locale.US, str, Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf((int) ((j14 - (((long) i13) * 1000000)) / j12))));
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static boolean x(String str) {
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
            case 1045209816:
                if (str.equals("S_TEXT/WEBVTT")) {
                    b11 = Ascii.ESC;
                }
                break;
            case 1422270023:
                if (str.equals("S_TEXT/UTF8")) {
                    b11 = Ascii.FS;
                }
                break;
            case 1809237540:
                if (str.equals("V_MPEG2")) {
                    b11 = Ascii.GS;
                }
                break;
            case 1950749482:
                if (str.equals("A_EAC3")) {
                    b11 = Ascii.RS;
                }
                break;
            case 1950789798:
                if (str.equals("A_FLAC")) {
                    b11 = Ascii.US;
                }
                break;
            case 1951062397:
                if (str.equals("A_OPUS")) {
                    b11 = 32;
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
            case 32:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ l[] z() {
        return new l[]{new e()};
    }

    public final boolean A(a0 a0Var, long j11) {
        if (this.f82014y) {
            this.A = j11;
            a0Var.f76990a = this.f82015z;
            this.f82014y = false;
            return true;
        }
        if (this.f82011v) {
            long j12 = this.A;
            if (j12 != -1) {
                a0Var.f76990a = j12;
                this.A = -1L;
                return true;
            }
        }
        return false;
    }

    public final void B(m mVar, int i11) throws IOException {
        if (this.f81996g.f() >= i11) {
            return;
        }
        if (this.f81996g.b() < i11) {
            c0 c0Var = this.f81996g;
            c0Var.c(Math.max(c0Var.b() * 2, i11));
        }
        mVar.readFully(this.f81996g.d(), this.f81996g.f(), i11 - this.f81996g.f());
        this.f81996g.O(i11);
    }

    public final void C() {
        this.S = 0;
        this.T = 0;
        this.U = 0;
        this.V = false;
        this.W = false;
        this.X = false;
        this.Y = 0;
        this.Z = (byte) 0;
        this.f81989a0 = false;
        this.f81999j.L(0);
    }

    public final long D(long j11) throws ParserException {
        long j12 = this.f82007r;
        if (j12 != C.TIME_UNSET) {
            return o0.O0(j11, j12, 1000L);
        }
        throw ParserException.createForMalformedContainer("Can't scale timecode prior to timecodeScale being set.", null);
    }

    @CallSuper
    public void F(int i11, long j11, long j12) throws ParserException {
        j();
        if (i11 == 160) {
            this.Q = false;
            this.R = 0L;
            return;
        }
        if (i11 == 174) {
            this.f82010u = new c();
            return;
        }
        if (i11 == 187) {
            this.E = false;
            return;
        }
        if (i11 == 19899) {
            this.f82012w = -1;
            this.f82013x = -1L;
            return;
        }
        if (i11 == 20533) {
            s(i11).f82024h = true;
            return;
        }
        if (i11 == 21968) {
            s(i11).f82040x = true;
            return;
        }
        if (i11 == 408125543) {
            long j13 = this.f82006q;
            if (j13 != -1 && j13 != j11) {
                throw ParserException.createForMalformedContainer("Multiple Segment elements not supported", null);
            }
            this.f82006q = j11;
            this.f82005p = j12;
            return;
        }
        if (i11 == 475249515) {
            this.C = new t();
            this.D = new t();
        } else if (i11 == 524531317 && !this.f82011v) {
            if (this.f81993d && this.f82015z != -1) {
                this.f82014y = true;
            } else {
                this.f81991b0.g(new b0.b(this.f82009t));
                this.f82011v = true;
            }
        }
    }

    @CallSuper
    public void G(int i11, String str) throws ParserException {
        if (i11 == 134) {
            s(i11).f82018b = str;
            return;
        }
        if (i11 != 17026) {
            if (i11 == 21358) {
                s(i11).f82017a = str;
                return;
            } else {
                if (i11 != 2274716) {
                    return;
                }
                s(i11).W = str;
                return;
            }
        }
        if ("webm".equals(str) || "matroska".equals(str)) {
            return;
        }
        throw ParserException.createForMalformedContainer("DocType " + str + " not supported", null);
    }

    public final int H(m mVar, c cVar, int i11, boolean z11) throws IOException {
        int i12;
        if ("S_TEXT/UTF8".equals(cVar.f82018b)) {
            I(mVar, f81982d0, i11);
            return p();
        }
        if ("S_TEXT/ASS".equals(cVar.f82018b)) {
            I(mVar, f81984f0, i11);
            return p();
        }
        if ("S_TEXT/WEBVTT".equals(cVar.f82018b)) {
            I(mVar, f81985g0, i11);
            return p();
        }
        e0 e0Var = cVar.X;
        if (!this.V) {
            if (cVar.f82024h) {
                this.O &= -1073741825;
                if (!this.W) {
                    mVar.readFully(this.f81996g.d(), 0, 1);
                    this.S++;
                    if ((this.f81996g.d()[0] & 128) == 128) {
                        throw ParserException.createForMalformedContainer("Extension bit is set in signal byte", null);
                    }
                    this.Z = this.f81996g.d()[0];
                    this.W = true;
                }
                byte b11 = this.Z;
                if ((b11 & 1) == 1) {
                    boolean z12 = (b11 & 2) == 2;
                    this.O |= 1073741824;
                    if (!this.f81989a0) {
                        mVar.readFully(this.f82001l.d(), 0, 8);
                        this.S += 8;
                        this.f81989a0 = true;
                        this.f81996g.d()[0] = (byte) ((z12 ? 128 : 0) | 8);
                        this.f81996g.P(0);
                        e0Var.f(this.f81996g, 1, 1);
                        this.T++;
                        this.f82001l.P(0);
                        e0Var.f(this.f82001l, 8, 1);
                        this.T += 8;
                    }
                    if (z12) {
                        if (!this.X) {
                            mVar.readFully(this.f81996g.d(), 0, 1);
                            this.S++;
                            this.f81996g.P(0);
                            this.Y = this.f81996g.D();
                            this.X = true;
                        }
                        int i13 = this.Y * 4;
                        this.f81996g.L(i13);
                        mVar.readFully(this.f81996g.d(), 0, i13);
                        this.S += i13;
                        short s11 = (short) ((this.Y / 2) + 1);
                        int i14 = (s11 * 6) + 2;
                        ByteBuffer byteBuffer = this.f82004o;
                        if (byteBuffer == null || byteBuffer.capacity() < i14) {
                            this.f82004o = ByteBuffer.allocate(i14);
                        }
                        this.f82004o.position(0);
                        this.f82004o.putShort(s11);
                        int i15 = 0;
                        int i16 = 0;
                        while (true) {
                            i12 = this.Y;
                            if (i15 >= i12) {
                                break;
                            }
                            int iH = this.f81996g.H();
                            if (i15 % 2 == 0) {
                                this.f82004o.putShort((short) (iH - i16));
                            } else {
                                this.f82004o.putInt(iH - i16);
                            }
                            i15++;
                            i16 = iH;
                        }
                        int i17 = (i11 - this.S) - i16;
                        if (i12 % 2 == 1) {
                            this.f82004o.putInt(i17);
                        } else {
                            this.f82004o.putShort((short) i17);
                            this.f82004o.putInt(0);
                        }
                        this.f82002m.N(this.f82004o.array(), i14);
                        e0Var.f(this.f82002m, i14, 1);
                        this.T += i14;
                    }
                }
            } else {
                byte[] bArr = cVar.f82025i;
                if (bArr != null) {
                    this.f81999j.N(bArr, bArr.length);
                }
            }
            if (cVar.o(z11)) {
                this.O |= ASTNode.DEOP;
                this.f82003n.L(0);
                int iF = (this.f81999j.f() + i11) - this.S;
                this.f81996g.L(4);
                this.f81996g.d()[0] = (byte) ((iF >> 24) & 255);
                this.f81996g.d()[1] = (byte) ((iF >> 16) & 255);
                this.f81996g.d()[2] = (byte) ((iF >> 8) & 255);
                this.f81996g.d()[3] = (byte) (iF & 255);
                e0Var.f(this.f81996g, 4, 2);
                this.T += 4;
            }
            this.V = true;
        }
        int iF2 = i11 + this.f81999j.f();
        if (!"V_MPEG4/ISO/AVC".equals(cVar.f82018b) && !"V_MPEGH/ISO/HEVC".equals(cVar.f82018b)) {
            if (cVar.T != null) {
                com.google.android.exoplayer2.util.a.g(this.f81999j.f() == 0);
                cVar.T.d(mVar);
            }
            while (true) {
                int i18 = this.S;
                if (i18 >= iF2) {
                    break;
                }
                int iJ = J(mVar, e0Var, iF2 - i18);
                this.S += iJ;
                this.T += iJ;
            }
        } else {
            byte[] bArrD = this.f81995f.d();
            bArrD[0] = 0;
            bArrD[1] = 0;
            bArrD[2] = 0;
            int i19 = cVar.Y;
            int i21 = 4 - i19;
            while (this.S < iF2) {
                int i22 = this.U;
                if (i22 == 0) {
                    K(mVar, bArrD, i21, i19);
                    this.S += i19;
                    this.f81995f.P(0);
                    this.U = this.f81995f.H();
                    this.f81994e.P(0);
                    e0Var.c(this.f81994e, 4);
                    this.T += 4;
                } else {
                    int iJ2 = J(mVar, e0Var, i22);
                    this.S += iJ2;
                    this.T += iJ2;
                    this.U -= iJ2;
                }
            }
        }
        if ("A_VORBIS".equals(cVar.f82018b)) {
            this.f81997h.P(0);
            e0Var.c(this.f81997h, 4);
            this.T += 4;
        }
        return p();
    }

    public final void I(m mVar, byte[] bArr, int i11) throws IOException {
        int length = bArr.length + i11;
        if (this.f82000k.b() < length) {
            this.f82000k.M(Arrays.copyOf(bArr, length + i11));
        } else {
            System.arraycopy(bArr, 0, this.f82000k.d(), 0, bArr.length);
        }
        mVar.readFully(this.f82000k.d(), bArr.length, i11);
        this.f82000k.P(0);
        this.f82000k.O(length);
    }

    public final int J(m mVar, e0 e0Var, int i11) throws IOException {
        int iA = this.f81999j.a();
        if (iA <= 0) {
            return e0Var.b(mVar, i11, false);
        }
        int iMin = Math.min(i11, iA);
        e0Var.c(this.f81999j, iMin);
        return iMin;
    }

    public final void K(m mVar, byte[] bArr, int i11, int i12) throws IOException {
        int iMin = Math.min(i12, this.f81999j.a());
        mVar.readFully(bArr, i11 + iMin, i12 - iMin);
        if (iMin > 0) {
            this.f81999j.j(bArr, i11, iMin);
        }
    }

    @Override // tg.l
    public final boolean b(m mVar) throws IOException {
        return new f().b(mVar);
    }

    @Override // tg.l
    public final int c(m mVar, a0 a0Var) throws IOException {
        this.F = false;
        boolean zA = true;
        while (zA && !this.F) {
            zA = this.f81988a.a(mVar);
            if (zA && A(a0Var, mVar.getPosition())) {
                return 1;
            }
        }
        if (zA) {
            return 0;
        }
        for (int i11 = 0; i11 < this.f81992c.size(); i11++) {
            c cVarValueAt = this.f81992c.valueAt(i11);
            cVarValueAt.f();
            cVarValueAt.j();
        }
        return -1;
    }

    @Override // tg.l
    public final void d(n nVar) {
        this.f81991b0 = nVar;
    }

    public final void h(int i11) throws ParserException {
        if (this.C == null || this.D == null) {
            throw ParserException.createForMalformedContainer("Element " + i11 + " must be in a Cues", null);
        }
    }

    public final void i(int i11) throws ParserException {
        if (this.f82010u != null) {
            return;
        }
        throw ParserException.createForMalformedContainer("Element " + i11 + " must be in a TrackEntry", null);
    }

    /* JADX WARN: Code duplicated, block: B:97:0x0282  */
    @CallSuper
    public void k(int i11, int i12, m mVar) throws IOException {
        c cVar;
        c cVar2;
        c cVar3;
        long j11;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17 = 0;
        int i18 = 1;
        if (i11 != 161 && i11 != 163) {
            if (i11 == 165) {
                if (this.G != 2) {
                    return;
                }
                v(this.f81992c.get(this.M), this.P, mVar, i12);
                return;
            }
            if (i11 == 16877) {
                u(s(i11), mVar, i12);
                return;
            }
            if (i11 == 16981) {
                i(i11);
                byte[] bArr = new byte[i12];
                this.f82010u.f82025i = bArr;
                mVar.readFully(bArr, 0, i12);
                return;
            }
            if (i11 == 18402) {
                byte[] bArr2 = new byte[i12];
                mVar.readFully(bArr2, 0, i12);
                s(i11).f82026j = new e0.a(1, bArr2, 0, 0);
                return;
            }
            if (i11 == 21419) {
                Arrays.fill(this.f81998i.d(), (byte) 0);
                mVar.readFully(this.f81998i.d(), 4 - i12, i12);
                this.f81998i.P(0);
                this.f82012w = (int) this.f81998i.F();
                return;
            }
            if (i11 == 25506) {
                i(i11);
                byte[] bArr3 = new byte[i12];
                this.f82010u.f82027k = bArr3;
                mVar.readFully(bArr3, 0, i12);
                return;
            }
            if (i11 != 30322) {
                throw ParserException.createForMalformedContainer("Unexpected id: " + i11, null);
            }
            i(i11);
            byte[] bArr4 = new byte[i12];
            this.f82010u.f82038v = bArr4;
            mVar.readFully(bArr4, 0, i12);
            return;
        }
        if (this.G == 0) {
            this.M = (int) this.f81990b.d(mVar, false, true, 8);
            this.N = this.f81990b.b();
            this.I = C.TIME_UNSET;
            this.G = 1;
            this.f81996g.L(0);
        }
        c cVar4 = this.f81992c.get(this.M);
        if (cVar4 == null) {
            mVar.skipFully(i12 - this.N);
            this.G = 0;
            return;
        }
        cVar4.f();
        if (this.G == 1) {
            B(mVar, 3);
            int i19 = (this.f81996g.d()[2] & 6) >> 1;
            byte b11 = 255;
            if (i19 == 0) {
                this.K = 1;
                int[] iArrO = o(this.L, 1);
                this.L = iArrO;
                iArrO[0] = (i12 - this.N) - 3;
            } else {
                int i21 = 4;
                B(mVar, 4);
                int i22 = (this.f81996g.d()[3] & 255) + 1;
                this.K = i22;
                int[] iArrO2 = o(this.L, i22);
                this.L = iArrO2;
                if (i19 == 2) {
                    int i23 = (i12 - this.N) - 4;
                    int i24 = this.K;
                    Arrays.fill(iArrO2, 0, i24, i23 / i24);
                } else {
                    if (i19 == 1) {
                        int i25 = 0;
                        int i26 = 0;
                        while (true) {
                            i13 = this.K;
                            if (i25 >= i13 - 1) {
                                break;
                            }
                            this.L[i25] = 0;
                            while (true) {
                                i14 = i21 + 1;
                                B(mVar, i14);
                                int i27 = this.f81996g.d()[i21] & 255;
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
                        this.L[i13 - 1] = ((i12 - this.N) - i21) - i26;
                    } else {
                        if (i19 != 3) {
                            throw ParserException.createForMalformedContainer("Unexpected lacing value: " + i19, null);
                        }
                        int i28 = 0;
                        int i29 = 0;
                        while (true) {
                            int i31 = this.K;
                            if (i28 >= i31 - 1) {
                                cVar2 = cVar4;
                                this.L[i31 - 1] = ((i12 - this.N) - i21) - i29;
                                break;
                            }
                            this.L[i28] = i17;
                            int i32 = i21 + 1;
                            B(mVar, i32);
                            if (this.f81996g.d()[i21] == 0) {
                                throw ParserException.createForMalformedContainer("No valid varint length mask found", null);
                            }
                            int i33 = 0;
                            while (true) {
                                if (i33 >= 8) {
                                    cVar3 = cVar4;
                                    j11 = 0;
                                    break;
                                }
                                int i34 = i18 << (7 - i33);
                                if ((this.f81996g.d()[i21] & i34) != 0) {
                                    i32 += i33;
                                    B(mVar, i32);
                                    cVar3 = cVar4;
                                    j11 = (~i34) & this.f81996g.d()[i21] & b11;
                                    int i35 = i21 + 1;
                                    while (i35 < i32) {
                                        j11 = (j11 << 8) | ((long) (this.f81996g.d()[i35] & b11));
                                        i35++;
                                        b11 = 255;
                                    }
                                    if (i28 <= 0) {
                                        break;
                                    }
                                    j11 -= (1 << ((i33 * 7) + 6)) - 1;
                                    break;
                                }
                                i33++;
                                i18 = 1;
                                b11 = 255;
                            }
                            i21 = i32;
                            if (j11 < -2147483648L || j11 > 2147483647L) {
                                throw ParserException.createForMalformedContainer("EBML lacing sample size out of range.", null);
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
                            i17 = 0;
                            i18 = 1;
                            b11 = 255;
                        }
                    }
                    this.H = this.B + D((this.f81996g.d()[0] << 8) | (this.f81996g.d()[1] & 255));
                    cVar = cVar2;
                    if (cVar.f82020d != 2 || (i11 == 163 && (this.f81996g.d()[2] & 128) == 128)) {
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
            this.H = this.B + D((this.f81996g.d()[0] << 8) | (this.f81996g.d()[1] & 255));
            cVar = cVar2;
            if (cVar.f82020d != 2) {
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
                m(cVar, ((long) ((this.J * cVar.f82021e) / 1000)) + this.H, this.O, H(mVar, cVar, this.L[i37], false), 0);
                this.J++;
            }
        } else {
            while (true) {
                int i38 = this.J;
                if (i38 >= this.K) {
                    return;
                }
                int[] iArr3 = this.L;
                iArr3[i38] = H(mVar, cVar, iArr3[i38], true);
                this.J++;
            }
        }
    }

    public final b0 l(@Nullable t tVar, @Nullable t tVar2) {
        int i11;
        if (this.f82006q == -1 || this.f82009t == C.TIME_UNSET || tVar == null || tVar.c() == 0 || tVar2 == null || tVar2.c() != tVar.c()) {
            return new b0.b(this.f82009t);
        }
        int iC = tVar.c();
        int[] iArrCopyOf = new int[iC];
        long[] jArrCopyOf = new long[iC];
        long[] jArrCopyOf2 = new long[iC];
        long[] jArrCopyOf3 = new long[iC];
        int i12 = 0;
        for (int i13 = 0; i13 < iC; i13++) {
            jArrCopyOf3[i13] = tVar.b(i13);
            jArrCopyOf[i13] = this.f82006q + tVar2.b(i13);
        }
        while (true) {
            i11 = iC - 1;
            if (i12 >= i11) {
                break;
            }
            int i14 = i12 + 1;
            iArrCopyOf[i12] = (int) (jArrCopyOf[i14] - jArrCopyOf[i12]);
            jArrCopyOf2[i12] = jArrCopyOf3[i14] - jArrCopyOf3[i12];
            i12 = i14;
        }
        iArrCopyOf[i11] = (int) ((this.f82006q + this.f82005p) - jArrCopyOf[i11]);
        long j11 = this.f82009t - jArrCopyOf3[i11];
        jArrCopyOf2[i11] = j11;
        if (j11 <= 0) {
            s.i("MatroskaExtractor", "Discarding last cue point with unexpected duration: " + j11);
            iArrCopyOf = Arrays.copyOf(iArrCopyOf, i11);
            jArrCopyOf = Arrays.copyOf(jArrCopyOf, i11);
            jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i11);
            jArrCopyOf3 = Arrays.copyOf(jArrCopyOf3, i11);
        }
        return new tg.d(iArrCopyOf, jArrCopyOf, jArrCopyOf2, jArrCopyOf3);
    }

    public final void m(c cVar, long j11, int i11, int i12, int i13) {
        f0 f0Var = cVar.T;
        if (f0Var != null) {
            f0Var.c(cVar.X, j11, i11, i12, i13, cVar.f82026j);
        } else {
            if ("S_TEXT/UTF8".equals(cVar.f82018b) || "S_TEXT/ASS".equals(cVar.f82018b) || "S_TEXT/WEBVTT".equals(cVar.f82018b)) {
                if (this.K > 1) {
                    s.i("MatroskaExtractor", "Skipping subtitle sample in laced block.");
                } else {
                    long j12 = this.I;
                    if (j12 == C.TIME_UNSET) {
                        s.i("MatroskaExtractor", "Skipping subtitle sample with no duration.");
                    } else {
                        E(cVar.f82018b, j12, this.f82000k.d());
                        for (int iE = this.f82000k.e(); iE < this.f82000k.f(); iE++) {
                            if (this.f82000k.d()[iE] == 0) {
                                this.f82000k.O(iE);
                                break;
                            }
                        }
                        e0 e0Var = cVar.X;
                        c0 c0Var = this.f82000k;
                        e0Var.c(c0Var, c0Var.f());
                        i12 += this.f82000k.f();
                    }
                }
            }
            if ((268435456 & i11) != 0) {
                if (this.K > 1) {
                    this.f82003n.L(0);
                } else {
                    int iF = this.f82003n.f();
                    cVar.X.f(this.f82003n, iF, 2);
                    i12 += iF;
                }
            }
            cVar.X.d(j11, i11, i12, i13, cVar.f82026j);
        }
        this.F = true;
    }

    @CallSuper
    public void n(int i11) throws ParserException {
        j();
        if (i11 == 160) {
            if (this.G != 2) {
                return;
            }
            c cVar = this.f81992c.get(this.M);
            cVar.f();
            if (this.R > 0 && "A_OPUS".equals(cVar.f82018b)) {
                this.f82003n.M(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.R).array());
            }
            int i12 = 0;
            for (int i13 = 0; i13 < this.K; i13++) {
                i12 += this.L[i13];
            }
            int i14 = 0;
            while (i14 < this.K) {
                long j11 = this.H + ((long) ((cVar.f82021e * i14) / 1000));
                int i15 = this.O;
                if (i14 == 0 && !this.Q) {
                    i15 |= 1;
                }
                int i16 = this.L[i14];
                int i17 = i12 - i16;
                m(cVar, j11, i15, i16, i17);
                i14++;
                i12 = i17;
            }
            this.G = 0;
            return;
        }
        if (i11 == 174) {
            c cVar2 = (c) com.google.android.exoplayer2.util.a.i(this.f82010u);
            String str = cVar2.f82018b;
            if (str == null) {
                throw ParserException.createForMalformedContainer("CodecId is missing in TrackEntry element", null);
            }
            if (x(str)) {
                cVar2.i(this.f81991b0, cVar2.f82019c);
                this.f81992c.put(cVar2.f82019c, cVar2);
            }
            this.f82010u = null;
            return;
        }
        if (i11 == 19899) {
            int i18 = this.f82012w;
            if (i18 != -1) {
                long j12 = this.f82013x;
                if (j12 != -1) {
                    if (i18 == 475249515) {
                        this.f82015z = j12;
                        return;
                    }
                    return;
                }
            }
            throw ParserException.createForMalformedContainer("Mandatory element SeekID or SeekPosition not found", null);
        }
        if (i11 == 25152) {
            i(i11);
            c cVar3 = this.f82010u;
            if (cVar3.f82024h) {
                if (cVar3.f82026j == null) {
                    throw ParserException.createForMalformedContainer("Encrypted Track found but ContentEncKeyID was not found", null);
                }
                cVar3.f82028l = new DrmInitData(new DrmInitData.SchemeData(h.f33253a, MimeTypes.VIDEO_WEBM, this.f82010u.f82026j.f77012b));
                return;
            }
            return;
        }
        if (i11 == 28032) {
            i(i11);
            c cVar4 = this.f82010u;
            if (cVar4.f82024h && cVar4.f82025i != null) {
                throw ParserException.createForMalformedContainer("Combining encryption and compression is not supported", null);
            }
            return;
        }
        if (i11 == 357149030) {
            if (this.f82007r == C.TIME_UNSET) {
                this.f82007r = 1000000L;
            }
            long j13 = this.f82008s;
            if (j13 != C.TIME_UNSET) {
                this.f82009t = D(j13);
                return;
            }
            return;
        }
        if (i11 == 374648427) {
            if (this.f81992c.size() == 0) {
                throw ParserException.createForMalformedContainer("No valid tracks were found", null);
            }
            this.f81991b0.endTracks();
        } else {
            if (i11 != 475249515) {
                return;
            }
            if (!this.f82011v) {
                this.f81991b0.g(l(this.C, this.D));
                this.f82011v = true;
            }
            this.C = null;
            this.D = null;
        }
    }

    public final int p() {
        int i11 = this.T;
        C();
        return i11;
    }

    @CallSuper
    public void q(int i11, double d11) throws ParserException {
        if (i11 == 181) {
            s(i11).Q = (int) d11;
        }
        if (i11 == 17545) {
            this.f82008s = (long) d11;
            return;
        }
        switch (i11) {
            case 21969:
                s(i11).D = (float) d11;
                break;
            case 21970:
                s(i11).E = (float) d11;
                break;
            case 21971:
                s(i11).F = (float) d11;
                break;
            case 21972:
                s(i11).G = (float) d11;
                break;
            case 21973:
                s(i11).H = (float) d11;
                break;
            case 21974:
                s(i11).I = (float) d11;
                break;
            case 21975:
                s(i11).J = (float) d11;
                break;
            case 21976:
                s(i11).K = (float) d11;
                break;
            case 21977:
                s(i11).L = (float) d11;
                break;
            case 21978:
                s(i11).M = (float) d11;
                break;
            default:
                switch (i11) {
                    case 30323:
                        s(i11).f82035s = (float) d11;
                        break;
                    case 30324:
                        s(i11).f82036t = (float) d11;
                        break;
                    case 30325:
                        s(i11).f82037u = (float) d11;
                        break;
                }
                break;
        }
    }

    @Override // tg.l
    public final void release() {
    }

    public c s(int i11) throws ParserException {
        i(i11);
        return this.f82010u;
    }

    @Override // tg.l
    @CallSuper
    public void seek(long j11, long j12) {
        this.B = C.TIME_UNSET;
        this.G = 0;
        this.f81988a.reset();
        this.f81990b.e();
        C();
        for (int i11 = 0; i11 < this.f81992c.size(); i11++) {
            this.f81992c.valueAt(i11).n();
        }
    }

    @CallSuper
    public int t(int i11) {
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
            case 30114:
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

    public void u(c cVar, m mVar, int i11) throws IOException {
        if (cVar.f82023g != 1685485123 && cVar.f82023g != 1685480259) {
            mVar.skipFully(i11);
            return;
        }
        byte[] bArr = new byte[i11];
        cVar.N = bArr;
        mVar.readFully(bArr, 0, i11);
    }

    public void v(c cVar, int i11, m mVar, int i12) throws IOException {
        if (i11 != 4 || !"V_VP9".equals(cVar.f82018b)) {
            mVar.skipFully(i12);
        } else {
            this.f82003n.L(i12);
            mVar.readFully(this.f82003n.d(), 0, i12);
        }
    }

    @CallSuper
    public void w(int i11, long j11) throws ParserException {
        if (i11 == 20529) {
            if (j11 == 0) {
                return;
            }
            throw ParserException.createForMalformedContainer("ContentEncodingOrder " + j11 + " not supported", null);
        }
        if (i11 == 20530) {
            if (j11 == 1) {
                return;
            }
            throw ParserException.createForMalformedContainer("ContentEncodingScope " + j11 + " not supported", null);
        }
        switch (i11) {
            case 131:
                s(i11).f82020d = (int) j11;
                return;
            case 136:
                s(i11).V = j11 == 1;
                return;
            case 155:
                this.I = D(j11);
                return;
            case 159:
                s(i11).O = (int) j11;
                return;
            case 176:
                s(i11).f82029m = (int) j11;
                return;
            case 179:
                h(i11);
                this.C.a(D(j11));
                return;
            case 186:
                s(i11).f82030n = (int) j11;
                return;
            case 215:
                s(i11).f82019c = (int) j11;
                return;
            case 231:
                this.B = D(j11);
                return;
            case 238:
                this.P = (int) j11;
                return;
            case 241:
                if (this.E) {
                    return;
                }
                h(i11);
                this.D.a(j11);
                this.E = true;
                return;
            case 251:
                this.Q = true;
                return;
            case 16871:
                s(i11).f82023g = (int) j11;
                return;
            case 16980:
                if (j11 == 3) {
                    return;
                }
                throw ParserException.createForMalformedContainer("ContentCompAlgo " + j11 + " not supported", null);
            case 17029:
                if (j11 < 1 || j11 > 2) {
                    throw ParserException.createForMalformedContainer("DocTypeReadVersion " + j11 + " not supported", null);
                }
                return;
            case 17143:
                if (j11 == 1) {
                    return;
                }
                throw ParserException.createForMalformedContainer("EBMLReadVersion " + j11 + " not supported", null);
            case 18401:
                if (j11 == 5) {
                    return;
                }
                throw ParserException.createForMalformedContainer("ContentEncAlgo " + j11 + " not supported", null);
            case 18408:
                if (j11 == 1) {
                    return;
                }
                throw ParserException.createForMalformedContainer("AESSettingsCipherMode " + j11 + " not supported", null);
            case 21420:
                this.f82013x = j11 + this.f82006q;
                return;
            case 21432:
                int i12 = (int) j11;
                i(i11);
                if (i12 == 0) {
                    this.f82010u.f82039w = 0;
                    return;
                }
                if (i12 == 1) {
                    this.f82010u.f82039w = 2;
                    return;
                } else if (i12 == 3) {
                    this.f82010u.f82039w = 1;
                    return;
                } else {
                    if (i12 != 15) {
                        return;
                    }
                    this.f82010u.f82039w = 3;
                    return;
                }
            case 21680:
                s(i11).f82031o = (int) j11;
                return;
            case 21682:
                s(i11).f82033q = (int) j11;
                return;
            case 21690:
                s(i11).f82032p = (int) j11;
                return;
            case 21930:
                s(i11).U = j11 == 1;
                return;
            case 21998:
                s(i11).f82022f = (int) j11;
                return;
            case 22186:
                s(i11).R = j11;
                return;
            case 22203:
                s(i11).S = j11;
                return;
            case 25188:
                s(i11).P = (int) j11;
                return;
            case 30114:
                this.R = j11;
                return;
            case 30321:
                i(i11);
                int i13 = (int) j11;
                if (i13 == 0) {
                    this.f82010u.f82034r = 0;
                    return;
                }
                if (i13 == 1) {
                    this.f82010u.f82034r = 1;
                    return;
                } else if (i13 == 2) {
                    this.f82010u.f82034r = 2;
                    return;
                } else {
                    if (i13 != 3) {
                        return;
                    }
                    this.f82010u.f82034r = 3;
                    return;
                }
            case 2352003:
                s(i11).f82021e = (int) j11;
                return;
            case 2807729:
                this.f82007r = j11;
                return;
            default:
                switch (i11) {
                    case 21945:
                        i(i11);
                        int i14 = (int) j11;
                        if (i14 == 1) {
                            this.f82010u.A = 2;
                            return;
                        } else {
                            if (i14 != 2) {
                                return;
                            }
                            this.f82010u.A = 1;
                            return;
                        }
                    case 21946:
                        i(i11);
                        int iC = com.google.android.exoplayer2.video.c.c((int) j11);
                        if (iC != -1) {
                            this.f82010u.f82042z = iC;
                            return;
                        }
                        return;
                    case 21947:
                        i(i11);
                        this.f82010u.f82040x = true;
                        int iB = com.google.android.exoplayer2.video.c.b((int) j11);
                        if (iB != -1) {
                            this.f82010u.f82041y = iB;
                            return;
                        }
                        return;
                    case 21948:
                        s(i11).B = (int) j11;
                        return;
                    case 21949:
                        s(i11).C = (int) j11;
                        return;
                    default:
                        return;
                }
        }
    }

    @CallSuper
    public boolean y(int i11) {
        return i11 == 357149030 || i11 == 524531317 || i11 == 475249515 || i11 == 374648427;
    }
}
