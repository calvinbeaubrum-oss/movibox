package j5;

import android.net.Uri;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.ParserException;
import androidx.media3.common.f0;
import androidx.media3.common.j;
import androidx.media3.common.k;
import com.applovin.exoplayer2.common.base.Ascii;
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
import u4.g0;
import u4.h;
import u4.l0;
import u4.m0;
import u4.n;
import u4.r;
import u4.r0;
import u4.s;
import u4.s0;
import u4.t;
import u4.u;
import u4.x;
import u4.y;
import z3.c0;
import z3.o;
import z3.p;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class e implements s {

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    @Deprecated
    public static final y f67866e0 = new y() { // from class: j5.d
        @Override // u4.y
        public /* synthetic */ y a(o5.s.a aVar) {
            return x.c(this, aVar);
        }

        @Override // u4.y
        public /* synthetic */ s[] b(Uri uri, Map map) {
            return x.a(this, uri, map);
        }

        @Override // u4.y
        public /* synthetic */ y c(boolean z11) {
            return x.b(this, z11);
        }

        @Override // u4.y
        public final s[] createExtractors() {
            return e.A();
        }
    };

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final byte[] f67867f0 = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final byte[] f67868g0 = u0.w0("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final byte[] f67869h0 = {68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final byte[] f67870i0 = {87, 69, 66, 86, 84, 84, 10, 10, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 10};

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final UUID f67871j0 = new UUID(72057594037932032L, -9223371306706625679L);

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final Map<String, Integer> f67872k0;
    public boolean A;
    public long B;
    public long C;
    public long D;

    @Nullable
    public p E;

    @Nullable
    public p F;
    public boolean G;
    public boolean H;
    public int I;
    public long J;
    public long K;
    public int L;
    public int M;
    public int[] N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public boolean S;
    public long T;
    public int U;
    public int V;
    public int W;
    public boolean X;
    public boolean Y;
    public boolean Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j5.c f67873a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f67874a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f67875b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public byte f67876b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SparseArray<c> f67877c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public boolean f67878c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f67879d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public u f67880d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f67881e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final o5.s.a f67882f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c0 f67883g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c0 f67884h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c0 f67885i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c0 f67886j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final c0 f67887k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c0 f67888l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final c0 f67889m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final c0 f67890n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c0 f67891o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final c0 f67892p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ByteBuffer f67893q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f67894r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f67895s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f67896t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f67897u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f67898v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @Nullable
    public c f67899w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f67900x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f67901y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f67902z;

    /* JADX INFO: compiled from: source.java */
    public final class b implements j5.b {
        public b() {
        }

        @Override // j5.b
        public void a(int i11, int i12, t tVar) throws IOException {
            e.this.l(i11, i12, tVar);
        }

        @Override // j5.b
        public void endMasterElement(int i11) throws ParserException {
            e.this.o(i11);
        }

        @Override // j5.b
        public void floatElement(int i11, double d11) throws ParserException {
            e.this.r(i11, d11);
        }

        @Override // j5.b
        public int getElementType(int i11) {
            return e.this.u(i11);
        }

        @Override // j5.b
        public void integerElement(int i11, long j11) throws ParserException {
            e.this.x(i11, j11);
        }

        @Override // j5.b
        public boolean isLevel1Element(int i11) {
            return e.this.z(i11);
        }

        @Override // j5.b
        public void startMasterElement(int i11, long j11, long j12) throws ParserException {
            e.this.G(i11, j11, j12);
        }

        @Override // j5.b
        public void stringElement(int i11, String str) throws ParserException {
            e.this.H(i11, str);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {
        public byte[] O;
        public s0 U;
        public boolean V;
        public r0 Y;
        public int Z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f67904a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f67905b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f67906c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f67907d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f67908e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f67909f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f67910g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f67911h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public byte[] f67912i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public r0.a f67913j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public byte[] f67914k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public DrmInitData f67915l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f67916m = -1;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f67917n = -1;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f67918o = -1;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f67919p = -1;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f67920q = -1;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f67921r = 0;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f67922s = -1;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public float f67923t = 0.0f;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public float f67924u = 0.0f;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public float f67925v = 0.0f;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public byte[] f67926w = null;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f67927x = -1;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public boolean f67928y = false;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public int f67929z = -1;
        public int A = -1;
        public int B = -1;
        public int C = 1000;
        public int D = 200;
        public float E = -1.0f;
        public float F = -1.0f;
        public float G = -1.0f;
        public float H = -1.0f;
        public float I = -1.0f;
        public float J = -1.0f;
        public float K = -1.0f;
        public float L = -1.0f;
        public float M = -1.0f;
        public float N = -1.0f;
        public int P = 1;
        public int Q = -1;
        public int R = 8000;
        public long S = 0;
        public long T = 0;
        public boolean W = true;
        public String X = "eng";

        public static Pair<String, List<byte[]>> k(c0 c0Var) throws ParserException {
            try {
                c0Var.V(16);
                long jX = c0Var.x();
                if (jX == 1482049860) {
                    return new Pair<>("video/divx", null);
                }
                if (jX == 859189832) {
                    return new Pair<>(MimeTypes.VIDEO_H263, null);
                }
                if (jX != 826496599) {
                    o.h("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                    return new Pair<>(MimeTypes.VIDEO_UNKNOWN, null);
                }
                byte[] bArrE = c0Var.e();
                for (int iF = c0Var.f() + 20; iF < bArrE.length - 4; iF++) {
                    if (bArrE[iF] == 0 && bArrE[iF + 1] == 0 && bArrE[iF + 2] == 1 && bArrE[iF + 3] == 15) {
                        return new Pair<>(MimeTypes.VIDEO_VC1, Collections.singletonList(Arrays.copyOfRange(bArrE, iF, bArrE.length)));
                    }
                }
                throw ParserException.createForMalformedContainer("Failed to find FourCC VC1 initialization data", null);
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw ParserException.createForMalformedContainer("Error parsing FourCC private data", null);
            }
        }

        public static boolean l(c0 c0Var) throws ParserException {
            try {
                int iZ = c0Var.z();
                if (iZ == 1) {
                    return true;
                }
                if (iZ != 65534) {
                    return false;
                }
                c0Var.U(24);
                return c0Var.A() == e.f67871j0.getMostSignificantBits() && c0Var.A() == e.f67871j0.getLeastSignificantBits();
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
            z3.a.e(this.Y);
        }

        public final byte[] g(String str) throws ParserException {
            byte[] bArr = this.f67914k;
            if (bArr != null) {
                return bArr;
            }
            throw ParserException.createForMalformedContainer("Missing CodecPrivate for codec " + str, null);
        }

        @Nullable
        public final byte[] h() {
            if (this.E == -1.0f || this.F == -1.0f || this.G == -1.0f || this.H == -1.0f || this.I == -1.0f || this.J == -1.0f || this.K == -1.0f || this.L == -1.0f || this.M == -1.0f || this.N == -1.0f) {
                return null;
            }
            byte[] bArr = new byte[25];
            ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            byteBufferOrder.put((byte) 0);
            byteBufferOrder.putShort((short) ((this.E * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.F * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.G * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.H * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.I * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.J * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.K * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.L * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) (this.M + 0.5f));
            byteBufferOrder.putShort((short) (this.N + 0.5f));
            byteBufferOrder.putShort((short) this.C);
            byteBufferOrder.putShort((short) this.D);
            return bArr;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:210:0x044c  */
        /* JADX WARN: Code duplicated, block: B:215:0x0465  */
        /* JADX WARN: Code duplicated, block: B:216:0x0467  */
        /* JADX WARN: Code duplicated, block: B:219:0x0474  */
        /* JADX WARN: Code duplicated, block: B:220:0x0486  */
        /* JADX WARN: Code duplicated, block: B:222:0x048c  */
        /* JADX WARN: Code duplicated, block: B:224:0x0490  */
        /* JADX WARN: Code duplicated, block: B:226:0x0495  */
        /* JADX WARN: Code duplicated, block: B:229:0x049d  */
        /* JADX WARN: Code duplicated, block: B:231:0x04a2  */
        /* JADX WARN: Code duplicated, block: B:234:0x04a7  */
        /* JADX WARN: Code duplicated, block: B:237:0x04b7  */
        /* JADX WARN: Code duplicated, block: B:240:0x04bd  */
        /* JADX WARN: Code duplicated, block: B:243:0x04f0  */
        /* JADX WARN: Code duplicated, block: B:248:0x0510  */
        /* JADX WARN: Code duplicated, block: B:254:0x0529  */
        /* JADX WARN: Code duplicated, block: B:255:0x052b  */
        /* JADX WARN: Code duplicated, block: B:257:0x0535  */
        /* JADX WARN: Code duplicated, block: B:258:0x0538  */
        /* JADX WARN: Code duplicated, block: B:260:0x0542  */
        /* JADX WARN: Code duplicated, block: B:266:0x055a  */
        /* JADX WARN: Code duplicated, block: B:268:0x0581  */
        /* JADX WARN: Code duplicated, block: B:270:0x0587  */
        /* JADX WARN: Code duplicated, block: B:286:0x05b2  */
        /* JADX WARN: Code duplicated, block: B:4:0x0015  */
        public void i(u uVar, int i11) throws ParserException {
            byte b11;
            List<byte[]> listSingletonList;
            String str;
            int i12;
            int i13;
            List<byte[]> list;
            String str2;
            String str3;
            int i14;
            androidx.media3.common.y.b bVar;
            int i15;
            int iIntValue;
            int i16;
            float f11;
            int i17;
            int i18;
            int i19;
            n nVarA;
            String str4 = this.f67905b;
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
                    byte[] bArr = this.f67914k;
                    listSingletonList = bArr == null ? null : Collections.singletonList(bArr);
                    str5 = MimeTypes.VIDEO_MP4V;
                    str = null;
                    i13 = -1;
                    i12 = -1;
                    if (this.O != null && (nVarA = n.a(new c0(this.O))) != null) {
                        str = nVarA.f78351c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z11 = this.W;
                    if (this.V) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i21 = i14 | (z11 ? 1 : 0);
                    bVar = new androidx.media3.common.y.b();
                    if (!f0.o(str3)) {
                        bVar.L(this.P).l0(this.R).e0(i12);
                        i15 = 1;
                    } else if (f0.s(str3)) {
                        if (this.f67921r == 0) {
                            i18 = this.f67919p;
                            iIntValue = -1;
                            if (i18 == -1) {
                                i18 = this.f67916m;
                            }
                            this.f67919p = i18;
                            i19 = this.f67920q;
                            if (i19 == -1) {
                                i19 = this.f67917n;
                            }
                            this.f67920q = i19;
                        } else {
                            iIntValue = -1;
                        }
                        i16 = this.f67919p;
                        if (i16 != iIntValue || (i17 = this.f67920q) == iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = (this.f67917n * i16) / (this.f67916m * i17);
                        }
                        k kVarA = this.f67928y ? new k.b().d(this.f67929z).c(this.B).e(this.A).f(h()).g(this.f67918o).b(this.f67918o).a() : null;
                        if (this.f67904a != null && e.f67872k0.containsKey(this.f67904a)) {
                            iIntValue = ((Integer) e.f67872k0.get(this.f67904a)).intValue();
                        }
                        if (this.f67922s == 0 && Float.compare(this.f67923t, 0.0f) == 0 && Float.compare(this.f67924u, 0.0f) == 0) {
                            if (Float.compare(this.f67925v, 0.0f) == 0) {
                                iIntValue = 0;
                            } else if (Float.compare(this.f67925v, 90.0f) == 0) {
                                iIntValue = 90;
                            } else if (Float.compare(this.f67925v, -180.0f) != 0 || Float.compare(this.f67925v, 180.0f) == 0) {
                                iIntValue = 180;
                            } else if (Float.compare(this.f67925v, -90.0f) == 0) {
                                iIntValue = 270;
                            }
                        }
                        bVar.r0(this.f67916m).V(this.f67917n).g0(f11).j0(iIntValue).h0(this.f67926w).n0(this.f67927x).N(kVarA);
                        i15 = 2;
                    } else {
                        if (MimeTypes.APPLICATION_SUBRIP.equals(str3) && !MimeTypes.TEXT_SSA.equals(str3) && !MimeTypes.TEXT_VTT.equals(str3) && !MimeTypes.APPLICATION_VOBSUB.equals(str3) && !MimeTypes.APPLICATION_PGS.equals(str3) && !MimeTypes.APPLICATION_DVBSUBS.equals(str3)) {
                            throw ParserException.createForMalformedContainer("Unexpected MIME type.", null);
                        }
                        i15 = 3;
                    }
                    if (this.f67904a != null && !e.f67872k0.containsKey(this.f67904a)) {
                        bVar.Z(this.f67904a);
                    }
                    androidx.media3.common.y yVarI = bVar.W(i11).k0(str3).c0(i13).b0(this.X).m0(i21).Y(listSingletonList).M(str).R(this.f67915l).I();
                    r0 r0VarTrack = uVar.track(this.f67906c, i15);
                    this.Y = r0VarTrack;
                    r0VarTrack.b(yVarI);
                    return;
                case 2:
                    if (l(new c0(g(this.f67905b)))) {
                        int iJ0 = u0.j0(this.Q);
                        if (iJ0 == 0) {
                            o.h("MatroskaExtractor", "Unsupported PCM bit depth: " + this.Q + ". Setting mimeType to " + MimeTypes.AUDIO_UNKNOWN);
                        } else {
                            i12 = iJ0;
                            listSingletonList = null;
                            str = null;
                            i13 = -1;
                        }
                        if (this.O != null) {
                            str = nVarA.f78351c;
                            str5 = "video/dolby-vision";
                        }
                        str3 = str5;
                        boolean z12 = this.W;
                        if (this.V) {
                            i14 = 2;
                        } else {
                            i14 = 0;
                        }
                        int i22 = i14 | (z12 ? 1 : 0);
                        bVar = new androidx.media3.common.y.b();
                        if (!f0.o(str3)) {
                            if (f0.s(str3)) {
                                if (this.f67921r == 0) {
                                    i18 = this.f67919p;
                                    iIntValue = -1;
                                    if (i18 == -1) {
                                        i18 = this.f67916m;
                                    }
                                    this.f67919p = i18;
                                    i19 = this.f67920q;
                                    if (i19 == -1) {
                                        i19 = this.f67917n;
                                    }
                                    this.f67920q = i19;
                                } else {
                                    iIntValue = -1;
                                }
                                i16 = this.f67919p;
                                if (i16 != iIntValue) {
                                    f11 = -1.0f;
                                } else {
                                    f11 = -1.0f;
                                }
                                if (this.f67928y) {
                                }
                                if (this.f67904a != null) {
                                    iIntValue = ((Integer) e.f67872k0.get(this.f67904a)).intValue();
                                }
                                if (this.f67922s == 0) {
                                    if (Float.compare(this.f67925v, 0.0f) == 0) {
                                        iIntValue = 0;
                                    } else if (Float.compare(this.f67925v, 90.0f) == 0) {
                                        iIntValue = 90;
                                    } else if (Float.compare(this.f67925v, -180.0f) != 0) {
                                        iIntValue = 180;
                                    } else {
                                        iIntValue = 180;
                                    }
                                }
                                bVar.r0(this.f67916m).V(this.f67917n).g0(f11).j0(iIntValue).h0(this.f67926w).n0(this.f67927x).N(kVarA);
                                i15 = 2;
                            } else {
                                if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                                }
                                i15 = 3;
                            }
                            break;
                        } else {
                            bVar.L(this.P).l0(this.R).e0(i12);
                            i15 = 1;
                        }
                        if (this.f67904a != null) {
                            bVar.Z(this.f67904a);
                        }
                        androidx.media3.common.y yVarI2 = bVar.W(i11).k0(str3).c0(i13).b0(this.X).m0(i22).Y(listSingletonList).M(str).R(this.f67915l).I();
                        r0 r0VarTrack2 = uVar.track(this.f67906c, i15);
                        this.Y = r0VarTrack2;
                        r0VarTrack2.b(yVarI2);
                        return;
                    }
                    o.h("MatroskaExtractor", "Non-PCM MS/ACM is unsupported. Setting mimeType to " + MimeTypes.AUDIO_UNKNOWN);
                    listSingletonList = null;
                    str = null;
                    str5 = MimeTypes.AUDIO_UNKNOWN;
                    i13 = -1;
                    i12 = -1;
                    if (this.O != null) {
                        str = nVarA.f78351c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z13 = this.W;
                    if (this.V) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i23 = i14 | (z13 ? 1 : 0);
                    bVar = new androidx.media3.common.y.b();
                    if (!f0.o(str3)) {
                        if (f0.s(str3)) {
                            if (this.f67921r == 0) {
                                i18 = this.f67919p;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f67916m;
                                }
                                this.f67919p = i18;
                                i19 = this.f67920q;
                                if (i19 == -1) {
                                    i19 = this.f67917n;
                                }
                                this.f67920q = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f67919p;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f67928y) {
                            }
                            if (this.f67904a != null) {
                                iIntValue = ((Integer) e.f67872k0.get(this.f67904a)).intValue();
                            }
                            if (this.f67922s == 0) {
                                if (Float.compare(this.f67925v, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f67925v, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f67925v, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.r0(this.f67916m).V(this.f67917n).g0(f11).j0(iIntValue).h0(this.f67926w).n0(this.f67927x).N(kVarA);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.L(this.P).l0(this.R).e0(i12);
                        i15 = 1;
                    }
                    if (this.f67904a != null) {
                        bVar.Z(this.f67904a);
                    }
                    androidx.media3.common.y yVarI3 = bVar.W(i11).k0(str3).c0(i13).b0(this.X).m0(i23).Y(listSingletonList).M(str).R(this.f67915l).I();
                    r0 r0VarTrack3 = uVar.track(this.f67906c, i15);
                    this.Y = r0VarTrack3;
                    r0VarTrack3.b(yVarI3);
                    return;
                case 3:
                    this.U = new s0();
                    str5 = MimeTypes.AUDIO_TRUEHD;
                    listSingletonList = null;
                    str = null;
                    i13 = -1;
                    i12 = -1;
                    if (this.O != null) {
                        str = nVarA.f78351c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z14 = this.W;
                    if (this.V) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i24 = i14 | (z14 ? 1 : 0);
                    bVar = new androidx.media3.common.y.b();
                    if (!f0.o(str3)) {
                        if (f0.s(str3)) {
                            if (this.f67921r == 0) {
                                i18 = this.f67919p;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f67916m;
                                }
                                this.f67919p = i18;
                                i19 = this.f67920q;
                                if (i19 == -1) {
                                    i19 = this.f67917n;
                                }
                                this.f67920q = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f67919p;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f67928y) {
                            }
                            if (this.f67904a != null) {
                                iIntValue = ((Integer) e.f67872k0.get(this.f67904a)).intValue();
                            }
                            if (this.f67922s == 0) {
                                if (Float.compare(this.f67925v, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f67925v, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f67925v, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.r0(this.f67916m).V(this.f67917n).g0(f11).j0(iIntValue).h0(this.f67926w).n0(this.f67927x).N(kVarA);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.L(this.P).l0(this.R).e0(i12);
                        i15 = 1;
                    }
                    if (this.f67904a != null) {
                        bVar.Z(this.f67904a);
                    }
                    androidx.media3.common.y yVarI4 = bVar.W(i11).k0(str3).c0(i13).b0(this.X).m0(i24).Y(listSingletonList).M(str).R(this.f67915l).I();
                    r0 r0VarTrack4 = uVar.track(this.f67906c, i15);
                    this.Y = r0VarTrack4;
                    r0VarTrack4.b(yVarI4);
                    return;
                case 4:
                    listSingletonList = m(g(this.f67905b));
                    str5 = MimeTypes.AUDIO_VORBIS;
                    str = null;
                    i13 = 8192;
                    i12 = -1;
                    if (this.O != null) {
                        str = nVarA.f78351c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z15 = this.W;
                    if (this.V) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i25 = i14 | (z15 ? 1 : 0);
                    bVar = new androidx.media3.common.y.b();
                    if (!f0.o(str3)) {
                        if (f0.s(str3)) {
                            if (this.f67921r == 0) {
                                i18 = this.f67919p;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f67916m;
                                }
                                this.f67919p = i18;
                                i19 = this.f67920q;
                                if (i19 == -1) {
                                    i19 = this.f67917n;
                                }
                                this.f67920q = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f67919p;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f67928y) {
                            }
                            if (this.f67904a != null) {
                                iIntValue = ((Integer) e.f67872k0.get(this.f67904a)).intValue();
                            }
                            if (this.f67922s == 0) {
                                if (Float.compare(this.f67925v, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f67925v, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f67925v, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.r0(this.f67916m).V(this.f67917n).g0(f11).j0(iIntValue).h0(this.f67926w).n0(this.f67927x).N(kVarA);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.L(this.P).l0(this.R).e0(i12);
                        i15 = 1;
                    }
                    if (this.f67904a != null) {
                        bVar.Z(this.f67904a);
                    }
                    androidx.media3.common.y yVarI5 = bVar.W(i11).k0(str3).c0(i13).b0(this.X).m0(i25).Y(listSingletonList).M(str).R(this.f67915l).I();
                    r0 r0VarTrack5 = uVar.track(this.f67906c, i15);
                    this.Y = r0VarTrack5;
                    r0VarTrack5.b(yVarI5);
                    return;
                case 5:
                    str5 = MimeTypes.AUDIO_MPEG_L2;
                    listSingletonList = null;
                    str = null;
                    i13 = 4096;
                    i12 = -1;
                    if (this.O != null) {
                        str = nVarA.f78351c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z16 = this.W;
                    if (this.V) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i26 = i14 | (z16 ? 1 : 0);
                    bVar = new androidx.media3.common.y.b();
                    if (!f0.o(str3)) {
                        if (f0.s(str3)) {
                            if (this.f67921r == 0) {
                                i18 = this.f67919p;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f67916m;
                                }
                                this.f67919p = i18;
                                i19 = this.f67920q;
                                if (i19 == -1) {
                                    i19 = this.f67917n;
                                }
                                this.f67920q = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f67919p;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f67928y) {
                            }
                            if (this.f67904a != null) {
                                iIntValue = ((Integer) e.f67872k0.get(this.f67904a)).intValue();
                            }
                            if (this.f67922s == 0) {
                                if (Float.compare(this.f67925v, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f67925v, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f67925v, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.r0(this.f67916m).V(this.f67917n).g0(f11).j0(iIntValue).h0(this.f67926w).n0(this.f67927x).N(kVarA);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.L(this.P).l0(this.R).e0(i12);
                        i15 = 1;
                    }
                    if (this.f67904a != null) {
                        bVar.Z(this.f67904a);
                    }
                    androidx.media3.common.y yVarI6 = bVar.W(i11).k0(str3).c0(i13).b0(this.X).m0(i26).Y(listSingletonList).M(str).R(this.f67915l).I();
                    r0 r0VarTrack6 = uVar.track(this.f67906c, i15);
                    this.Y = r0VarTrack6;
                    r0VarTrack6.b(yVarI6);
                    return;
                case 6:
                    str5 = MimeTypes.AUDIO_MPEG;
                    listSingletonList = null;
                    str = null;
                    i13 = 4096;
                    i12 = -1;
                    if (this.O != null) {
                        str = nVarA.f78351c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z17 = this.W;
                    if (this.V) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i27 = i14 | (z17 ? 1 : 0);
                    bVar = new androidx.media3.common.y.b();
                    if (!f0.o(str3)) {
                        if (f0.s(str3)) {
                            if (this.f67921r == 0) {
                                i18 = this.f67919p;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f67916m;
                                }
                                this.f67919p = i18;
                                i19 = this.f67920q;
                                if (i19 == -1) {
                                    i19 = this.f67917n;
                                }
                                this.f67920q = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f67919p;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f67928y) {
                            }
                            if (this.f67904a != null) {
                                iIntValue = ((Integer) e.f67872k0.get(this.f67904a)).intValue();
                            }
                            if (this.f67922s == 0) {
                                if (Float.compare(this.f67925v, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f67925v, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f67925v, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.r0(this.f67916m).V(this.f67917n).g0(f11).j0(iIntValue).h0(this.f67926w).n0(this.f67927x).N(kVarA);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.L(this.P).l0(this.R).e0(i12);
                        i15 = 1;
                    }
                    if (this.f67904a != null) {
                        bVar.Z(this.f67904a);
                    }
                    androidx.media3.common.y yVarI7 = bVar.W(i11).k0(str3).c0(i13).b0(this.X).m0(i27).Y(listSingletonList).M(str).R(this.f67915l).I();
                    r0 r0VarTrack7 = uVar.track(this.f67906c, i15);
                    this.Y = r0VarTrack7;
                    r0VarTrack7.b(yVarI7);
                    return;
                case 7:
                    Pair<String, List<byte[]>> pairK = k(new c0(g(this.f67905b)));
                    str5 = (String) pairK.first;
                    listSingletonList = (List) pairK.second;
                    str = null;
                    i13 = -1;
                    i12 = -1;
                    if (this.O != null) {
                        str = nVarA.f78351c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z18 = this.W;
                    if (this.V) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i28 = i14 | (z18 ? 1 : 0);
                    bVar = new androidx.media3.common.y.b();
                    if (!f0.o(str3)) {
                        if (f0.s(str3)) {
                            if (this.f67921r == 0) {
                                i18 = this.f67919p;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f67916m;
                                }
                                this.f67919p = i18;
                                i19 = this.f67920q;
                                if (i19 == -1) {
                                    i19 = this.f67917n;
                                }
                                this.f67920q = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f67919p;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f67928y) {
                            }
                            if (this.f67904a != null) {
                                iIntValue = ((Integer) e.f67872k0.get(this.f67904a)).intValue();
                            }
                            if (this.f67922s == 0) {
                                if (Float.compare(this.f67925v, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f67925v, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f67925v, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.r0(this.f67916m).V(this.f67917n).g0(f11).j0(iIntValue).h0(this.f67926w).n0(this.f67927x).N(kVarA);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.L(this.P).l0(this.R).e0(i12);
                        i15 = 1;
                    }
                    if (this.f67904a != null) {
                        bVar.Z(this.f67904a);
                    }
                    androidx.media3.common.y yVarI8 = bVar.W(i11).k0(str3).c0(i13).b0(this.X).m0(i28).Y(listSingletonList).M(str).R(this.f67915l).I();
                    r0 r0VarTrack8 = uVar.track(this.f67906c, i15);
                    this.Y = r0VarTrack8;
                    r0VarTrack8.b(yVarI8);
                    return;
                case 8:
                    byte[] bArr2 = new byte[4];
                    System.arraycopy(g(this.f67905b), 0, bArr2, 0, 4);
                    listSingletonList = ImmutableList.of(bArr2);
                    str5 = MimeTypes.APPLICATION_DVBSUBS;
                    str = null;
                    i13 = -1;
                    i12 = -1;
                    if (this.O != null) {
                        str = nVarA.f78351c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z19 = this.W;
                    if (this.V) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i29 = i14 | (z19 ? 1 : 0);
                    bVar = new androidx.media3.common.y.b();
                    if (!f0.o(str3)) {
                        if (f0.s(str3)) {
                            if (this.f67921r == 0) {
                                i18 = this.f67919p;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f67916m;
                                }
                                this.f67919p = i18;
                                i19 = this.f67920q;
                                if (i19 == -1) {
                                    i19 = this.f67917n;
                                }
                                this.f67920q = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f67919p;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f67928y) {
                            }
                            if (this.f67904a != null) {
                                iIntValue = ((Integer) e.f67872k0.get(this.f67904a)).intValue();
                            }
                            if (this.f67922s == 0) {
                                if (Float.compare(this.f67925v, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f67925v, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f67925v, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.r0(this.f67916m).V(this.f67917n).g0(f11).j0(iIntValue).h0(this.f67926w).n0(this.f67927x).N(kVarA);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.L(this.P).l0(this.R).e0(i12);
                        i15 = 1;
                    }
                    if (this.f67904a != null) {
                        bVar.Z(this.f67904a);
                    }
                    androidx.media3.common.y yVarI9 = bVar.W(i11).k0(str3).c0(i13).b0(this.X).m0(i29).Y(listSingletonList).M(str).R(this.f67915l).I();
                    r0 r0VarTrack9 = uVar.track(this.f67906c, i15);
                    this.Y = r0VarTrack9;
                    r0VarTrack9.b(yVarI9);
                    return;
                case 10:
                    u4.d dVarB = u4.d.b(new c0(g(this.f67905b)));
                    list = dVarB.f78233a;
                    this.Z = dVarB.f78234b;
                    str2 = dVarB.f78243k;
                    str5 = MimeTypes.VIDEO_H264;
                    i13 = -1;
                    i12 = -1;
                    List<byte[]> list2 = list;
                    str = str2;
                    listSingletonList = list2;
                    if (this.O != null) {
                        str = nVarA.f78351c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z110 = this.W;
                    if (this.V) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i210 = i14 | (z110 ? 1 : 0);
                    bVar = new androidx.media3.common.y.b();
                    if (!f0.o(str3)) {
                        if (f0.s(str3)) {
                            if (this.f67921r == 0) {
                                i18 = this.f67919p;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f67916m;
                                }
                                this.f67919p = i18;
                                i19 = this.f67920q;
                                if (i19 == -1) {
                                    i19 = this.f67917n;
                                }
                                this.f67920q = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f67919p;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f67928y) {
                            }
                            if (this.f67904a != null) {
                                iIntValue = ((Integer) e.f67872k0.get(this.f67904a)).intValue();
                            }
                            if (this.f67922s == 0) {
                                if (Float.compare(this.f67925v, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f67925v, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f67925v, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.r0(this.f67916m).V(this.f67917n).g0(f11).j0(iIntValue).h0(this.f67926w).n0(this.f67927x).N(kVarA);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.L(this.P).l0(this.R).e0(i12);
                        i15 = 1;
                    }
                    if (this.f67904a != null) {
                        bVar.Z(this.f67904a);
                    }
                    androidx.media3.common.y yVarI10 = bVar.W(i11).k0(str3).c0(i13).b0(this.X).m0(i210).Y(listSingletonList).M(str).R(this.f67915l).I();
                    r0 r0VarTrack10 = uVar.track(this.f67906c, i15);
                    this.Y = r0VarTrack10;
                    r0VarTrack10.b(yVarI10);
                    return;
                case 11:
                    listSingletonList = ImmutableList.of(g(this.f67905b));
                    str = null;
                    str5 = MimeTypes.APPLICATION_VOBSUB;
                    i13 = -1;
                    i12 = -1;
                    if (this.O != null) {
                        str = nVarA.f78351c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z111 = this.W;
                    if (this.V) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i211 = i14 | (z111 ? 1 : 0);
                    bVar = new androidx.media3.common.y.b();
                    if (!f0.o(str3)) {
                        if (f0.s(str3)) {
                            if (this.f67921r == 0) {
                                i18 = this.f67919p;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f67916m;
                                }
                                this.f67919p = i18;
                                i19 = this.f67920q;
                                if (i19 == -1) {
                                    i19 = this.f67917n;
                                }
                                this.f67920q = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f67919p;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f67928y) {
                            }
                            if (this.f67904a != null) {
                                iIntValue = ((Integer) e.f67872k0.get(this.f67904a)).intValue();
                            }
                            if (this.f67922s == 0) {
                                if (Float.compare(this.f67925v, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f67925v, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f67925v, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.r0(this.f67916m).V(this.f67917n).g0(f11).j0(iIntValue).h0(this.f67926w).n0(this.f67927x).N(kVarA);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.L(this.P).l0(this.R).e0(i12);
                        i15 = 1;
                    }
                    if (this.f67904a != null) {
                        bVar.Z(this.f67904a);
                    }
                    androidx.media3.common.y yVarI11 = bVar.W(i11).k0(str3).c0(i13).b0(this.X).m0(i211).Y(listSingletonList).M(str).R(this.f67915l).I();
                    r0 r0VarTrack11 = uVar.track(this.f67906c, i15);
                    this.Y = r0VarTrack11;
                    r0VarTrack11.b(yVarI11);
                    return;
                case 12:
                    str5 = MimeTypes.AUDIO_DTS_HD;
                    listSingletonList = null;
                    str = null;
                    i13 = -1;
                    i12 = -1;
                    if (this.O != null) {
                        str = nVarA.f78351c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z112 = this.W;
                    if (this.V) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i212 = i14 | (z112 ? 1 : 0);
                    bVar = new androidx.media3.common.y.b();
                    if (!f0.o(str3)) {
                        if (f0.s(str3)) {
                            if (this.f67921r == 0) {
                                i18 = this.f67919p;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f67916m;
                                }
                                this.f67919p = i18;
                                i19 = this.f67920q;
                                if (i19 == -1) {
                                    i19 = this.f67917n;
                                }
                                this.f67920q = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f67919p;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f67928y) {
                            }
                            if (this.f67904a != null) {
                                iIntValue = ((Integer) e.f67872k0.get(this.f67904a)).intValue();
                            }
                            if (this.f67922s == 0) {
                                if (Float.compare(this.f67925v, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f67925v, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f67925v, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.r0(this.f67916m).V(this.f67917n).g0(f11).j0(iIntValue).h0(this.f67926w).n0(this.f67927x).N(kVarA);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.L(this.P).l0(this.R).e0(i12);
                        i15 = 1;
                    }
                    if (this.f67904a != null) {
                        bVar.Z(this.f67904a);
                    }
                    androidx.media3.common.y yVarI12 = bVar.W(i11).k0(str3).c0(i13).b0(this.X).m0(i212).Y(listSingletonList).M(str).R(this.f67915l).I();
                    r0 r0VarTrack12 = uVar.track(this.f67906c, i15);
                    this.Y = r0VarTrack12;
                    r0VarTrack12.b(yVarI12);
                    return;
                case 13:
                    listSingletonList = Collections.singletonList(g(this.f67905b));
                    u4.a.b bVarE = u4.a.e(this.f67914k);
                    this.R = bVarE.f78194a;
                    this.P = bVarE.f78195b;
                    str = bVarE.f78196c;
                    str5 = MimeTypes.AUDIO_AAC;
                    i13 = -1;
                    i12 = -1;
                    if (this.O != null) {
                        str = nVarA.f78351c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z113 = this.W;
                    if (this.V) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i213 = i14 | (z113 ? 1 : 0);
                    bVar = new androidx.media3.common.y.b();
                    if (!f0.o(str3)) {
                        if (f0.s(str3)) {
                            if (this.f67921r == 0) {
                                i18 = this.f67919p;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f67916m;
                                }
                                this.f67919p = i18;
                                i19 = this.f67920q;
                                if (i19 == -1) {
                                    i19 = this.f67917n;
                                }
                                this.f67920q = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f67919p;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f67928y) {
                            }
                            if (this.f67904a != null) {
                                iIntValue = ((Integer) e.f67872k0.get(this.f67904a)).intValue();
                            }
                            if (this.f67922s == 0) {
                                if (Float.compare(this.f67925v, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f67925v, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f67925v, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.r0(this.f67916m).V(this.f67917n).g0(f11).j0(iIntValue).h0(this.f67926w).n0(this.f67927x).N(kVarA);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.L(this.P).l0(this.R).e0(i12);
                        i15 = 1;
                    }
                    if (this.f67904a != null) {
                        bVar.Z(this.f67904a);
                    }
                    androidx.media3.common.y yVarI13 = bVar.W(i11).k0(str3).c0(i13).b0(this.X).m0(i213).Y(listSingletonList).M(str).R(this.f67915l).I();
                    r0 r0VarTrack13 = uVar.track(this.f67906c, i15);
                    this.Y = r0VarTrack13;
                    r0VarTrack13.b(yVarI13);
                    return;
                case 14:
                    str5 = MimeTypes.AUDIO_AC3;
                    listSingletonList = null;
                    str = null;
                    i13 = -1;
                    i12 = -1;
                    if (this.O != null) {
                        str = nVarA.f78351c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z114 = this.W;
                    if (this.V) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i214 = i14 | (z114 ? 1 : 0);
                    bVar = new androidx.media3.common.y.b();
                    if (!f0.o(str3)) {
                        if (f0.s(str3)) {
                            if (this.f67921r == 0) {
                                i18 = this.f67919p;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f67916m;
                                }
                                this.f67919p = i18;
                                i19 = this.f67920q;
                                if (i19 == -1) {
                                    i19 = this.f67917n;
                                }
                                this.f67920q = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f67919p;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f67928y) {
                            }
                            if (this.f67904a != null) {
                                iIntValue = ((Integer) e.f67872k0.get(this.f67904a)).intValue();
                            }
                            if (this.f67922s == 0) {
                                if (Float.compare(this.f67925v, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f67925v, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f67925v, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.r0(this.f67916m).V(this.f67917n).g0(f11).j0(iIntValue).h0(this.f67926w).n0(this.f67927x).N(kVarA);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.L(this.P).l0(this.R).e0(i12);
                        i15 = 1;
                    }
                    if (this.f67904a != null) {
                        bVar.Z(this.f67904a);
                    }
                    androidx.media3.common.y yVarI14 = bVar.W(i11).k0(str3).c0(i13).b0(this.X).m0(i214).Y(listSingletonList).M(str).R(this.f67915l).I();
                    r0 r0VarTrack14 = uVar.track(this.f67906c, i15);
                    this.Y = r0VarTrack14;
                    r0VarTrack14.b(yVarI14);
                    return;
                case 15:
                case 21:
                    str5 = MimeTypes.AUDIO_DTS;
                    listSingletonList = null;
                    str = null;
                    i13 = -1;
                    i12 = -1;
                    if (this.O != null) {
                        str = nVarA.f78351c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z115 = this.W;
                    if (this.V) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i215 = i14 | (z115 ? 1 : 0);
                    bVar = new androidx.media3.common.y.b();
                    if (!f0.o(str3)) {
                        if (f0.s(str3)) {
                            if (this.f67921r == 0) {
                                i18 = this.f67919p;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f67916m;
                                }
                                this.f67919p = i18;
                                i19 = this.f67920q;
                                if (i19 == -1) {
                                    i19 = this.f67917n;
                                }
                                this.f67920q = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f67919p;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f67928y) {
                            }
                            if (this.f67904a != null) {
                                iIntValue = ((Integer) e.f67872k0.get(this.f67904a)).intValue();
                            }
                            if (this.f67922s == 0) {
                                if (Float.compare(this.f67925v, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f67925v, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f67925v, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.r0(this.f67916m).V(this.f67917n).g0(f11).j0(iIntValue).h0(this.f67926w).n0(this.f67927x).N(kVarA);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.L(this.P).l0(this.R).e0(i12);
                        i15 = 1;
                    }
                    if (this.f67904a != null) {
                        bVar.Z(this.f67904a);
                    }
                    androidx.media3.common.y yVarI15 = bVar.W(i11).k0(str3).c0(i13).b0(this.X).m0(i215).Y(listSingletonList).M(str).R(this.f67915l).I();
                    r0 r0VarTrack15 = uVar.track(this.f67906c, i15);
                    this.Y = r0VarTrack15;
                    r0VarTrack15.b(yVarI15);
                    return;
                case 16:
                    str5 = "video/av01";
                    listSingletonList = null;
                    str = null;
                    i13 = -1;
                    i12 = -1;
                    if (this.O != null) {
                        str = nVarA.f78351c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z116 = this.W;
                    if (this.V) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i216 = i14 | (z116 ? 1 : 0);
                    bVar = new androidx.media3.common.y.b();
                    if (!f0.o(str3)) {
                        if (f0.s(str3)) {
                            if (this.f67921r == 0) {
                                i18 = this.f67919p;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f67916m;
                                }
                                this.f67919p = i18;
                                i19 = this.f67920q;
                                if (i19 == -1) {
                                    i19 = this.f67917n;
                                }
                                this.f67920q = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f67919p;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f67928y) {
                            }
                            if (this.f67904a != null) {
                                iIntValue = ((Integer) e.f67872k0.get(this.f67904a)).intValue();
                            }
                            if (this.f67922s == 0) {
                                if (Float.compare(this.f67925v, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f67925v, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f67925v, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.r0(this.f67916m).V(this.f67917n).g0(f11).j0(iIntValue).h0(this.f67926w).n0(this.f67927x).N(kVarA);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.L(this.P).l0(this.R).e0(i12);
                        i15 = 1;
                    }
                    if (this.f67904a != null) {
                        bVar.Z(this.f67904a);
                    }
                    androidx.media3.common.y yVarI16 = bVar.W(i11).k0(str3).c0(i13).b0(this.X).m0(i216).Y(listSingletonList).M(str).R(this.f67915l).I();
                    r0 r0VarTrack16 = uVar.track(this.f67906c, i15);
                    this.Y = r0VarTrack16;
                    r0VarTrack16.b(yVarI16);
                    return;
                case 17:
                    str5 = MimeTypes.VIDEO_VP8;
                    listSingletonList = null;
                    str = null;
                    i13 = -1;
                    i12 = -1;
                    if (this.O != null) {
                        str = nVarA.f78351c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z117 = this.W;
                    if (this.V) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i217 = i14 | (z117 ? 1 : 0);
                    bVar = new androidx.media3.common.y.b();
                    if (!f0.o(str3)) {
                        if (f0.s(str3)) {
                            if (this.f67921r == 0) {
                                i18 = this.f67919p;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f67916m;
                                }
                                this.f67919p = i18;
                                i19 = this.f67920q;
                                if (i19 == -1) {
                                    i19 = this.f67917n;
                                }
                                this.f67920q = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f67919p;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f67928y) {
                            }
                            if (this.f67904a != null) {
                                iIntValue = ((Integer) e.f67872k0.get(this.f67904a)).intValue();
                            }
                            if (this.f67922s == 0) {
                                if (Float.compare(this.f67925v, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f67925v, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f67925v, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.r0(this.f67916m).V(this.f67917n).g0(f11).j0(iIntValue).h0(this.f67926w).n0(this.f67927x).N(kVarA);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.L(this.P).l0(this.R).e0(i12);
                        i15 = 1;
                    }
                    if (this.f67904a != null) {
                        bVar.Z(this.f67904a);
                    }
                    androidx.media3.common.y yVarI17 = bVar.W(i11).k0(str3).c0(i13).b0(this.X).m0(i217).Y(listSingletonList).M(str).R(this.f67915l).I();
                    r0 r0VarTrack17 = uVar.track(this.f67906c, i15);
                    this.Y = r0VarTrack17;
                    r0VarTrack17.b(yVarI17);
                    return;
                case 18:
                    str5 = MimeTypes.VIDEO_VP9;
                    listSingletonList = null;
                    str = null;
                    i13 = -1;
                    i12 = -1;
                    if (this.O != null) {
                        str = nVarA.f78351c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z118 = this.W;
                    if (this.V) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i218 = i14 | (z118 ? 1 : 0);
                    bVar = new androidx.media3.common.y.b();
                    if (!f0.o(str3)) {
                        if (f0.s(str3)) {
                            if (this.f67921r == 0) {
                                i18 = this.f67919p;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f67916m;
                                }
                                this.f67919p = i18;
                                i19 = this.f67920q;
                                if (i19 == -1) {
                                    i19 = this.f67917n;
                                }
                                this.f67920q = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f67919p;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f67928y) {
                            }
                            if (this.f67904a != null) {
                                iIntValue = ((Integer) e.f67872k0.get(this.f67904a)).intValue();
                            }
                            if (this.f67922s == 0) {
                                if (Float.compare(this.f67925v, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f67925v, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f67925v, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.r0(this.f67916m).V(this.f67917n).g0(f11).j0(iIntValue).h0(this.f67926w).n0(this.f67927x).N(kVarA);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.L(this.P).l0(this.R).e0(i12);
                        i15 = 1;
                    }
                    if (this.f67904a != null) {
                        bVar.Z(this.f67904a);
                    }
                    androidx.media3.common.y yVarI18 = bVar.W(i11).k0(str3).c0(i13).b0(this.X).m0(i218).Y(listSingletonList).M(str).R(this.f67915l).I();
                    r0 r0VarTrack18 = uVar.track(this.f67906c, i15);
                    this.Y = r0VarTrack18;
                    r0VarTrack18.b(yVarI18);
                    return;
                case 19:
                    listSingletonList = null;
                    str = null;
                    str5 = MimeTypes.APPLICATION_PGS;
                    i13 = -1;
                    i12 = -1;
                    if (this.O != null) {
                        str = nVarA.f78351c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z119 = this.W;
                    if (this.V) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i219 = i14 | (z119 ? 1 : 0);
                    bVar = new androidx.media3.common.y.b();
                    if (!f0.o(str3)) {
                        if (f0.s(str3)) {
                            if (this.f67921r == 0) {
                                i18 = this.f67919p;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f67916m;
                                }
                                this.f67919p = i18;
                                i19 = this.f67920q;
                                if (i19 == -1) {
                                    i19 = this.f67917n;
                                }
                                this.f67920q = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f67919p;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f67928y) {
                            }
                            if (this.f67904a != null) {
                                iIntValue = ((Integer) e.f67872k0.get(this.f67904a)).intValue();
                            }
                            if (this.f67922s == 0) {
                                if (Float.compare(this.f67925v, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f67925v, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f67925v, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.r0(this.f67916m).V(this.f67917n).g0(f11).j0(iIntValue).h0(this.f67926w).n0(this.f67927x).N(kVarA);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.L(this.P).l0(this.R).e0(i12);
                        i15 = 1;
                    }
                    if (this.f67904a != null) {
                        bVar.Z(this.f67904a);
                    }
                    androidx.media3.common.y yVarI19 = bVar.W(i11).k0(str3).c0(i13).b0(this.X).m0(i219).Y(listSingletonList).M(str).R(this.f67915l).I();
                    r0 r0VarTrack19 = uVar.track(this.f67906c, i15);
                    this.Y = r0VarTrack19;
                    r0VarTrack19.b(yVarI19);
                    return;
                case 20:
                    str5 = MimeTypes.VIDEO_UNKNOWN;
                    listSingletonList = null;
                    str = null;
                    i13 = -1;
                    i12 = -1;
                    if (this.O != null) {
                        str = nVarA.f78351c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z1110 = this.W;
                    if (this.V) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i2110 = i14 | (z1110 ? 1 : 0);
                    bVar = new androidx.media3.common.y.b();
                    if (!f0.o(str3)) {
                        if (f0.s(str3)) {
                            if (this.f67921r == 0) {
                                i18 = this.f67919p;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f67916m;
                                }
                                this.f67919p = i18;
                                i19 = this.f67920q;
                                if (i19 == -1) {
                                    i19 = this.f67917n;
                                }
                                this.f67920q = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f67919p;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f67928y) {
                            }
                            if (this.f67904a != null) {
                                iIntValue = ((Integer) e.f67872k0.get(this.f67904a)).intValue();
                            }
                            if (this.f67922s == 0) {
                                if (Float.compare(this.f67925v, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f67925v, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f67925v, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.r0(this.f67916m).V(this.f67917n).g0(f11).j0(iIntValue).h0(this.f67926w).n0(this.f67927x).N(kVarA);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.L(this.P).l0(this.R).e0(i12);
                        i15 = 1;
                    }
                    if (this.f67904a != null) {
                        bVar.Z(this.f67904a);
                    }
                    androidx.media3.common.y yVarI110 = bVar.W(i11).k0(str3).c0(i13).b0(this.X).m0(i2110).Y(listSingletonList).M(str).R(this.f67915l).I();
                    r0 r0VarTrack110 = uVar.track(this.f67906c, i15);
                    this.Y = r0VarTrack110;
                    r0VarTrack110.b(yVarI110);
                    return;
                case 22:
                    if (this.Q == 32) {
                        listSingletonList = null;
                        str = null;
                        i13 = -1;
                        i12 = 4;
                    } else {
                        o.h("MatroskaExtractor", "Unsupported floating point PCM bit depth: " + this.Q + ". Setting mimeType to " + MimeTypes.AUDIO_UNKNOWN);
                        listSingletonList = null;
                        str = null;
                        str5 = MimeTypes.AUDIO_UNKNOWN;
                        i13 = -1;
                        i12 = -1;
                    }
                    if (this.O != null) {
                        str = nVarA.f78351c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z1111 = this.W;
                    if (this.V) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i2111 = i14 | (z1111 ? 1 : 0);
                    bVar = new androidx.media3.common.y.b();
                    if (!f0.o(str3)) {
                        if (f0.s(str3)) {
                            if (this.f67921r == 0) {
                                i18 = this.f67919p;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f67916m;
                                }
                                this.f67919p = i18;
                                i19 = this.f67920q;
                                if (i19 == -1) {
                                    i19 = this.f67917n;
                                }
                                this.f67920q = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f67919p;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f67928y) {
                            }
                            if (this.f67904a != null) {
                                iIntValue = ((Integer) e.f67872k0.get(this.f67904a)).intValue();
                            }
                            if (this.f67922s == 0) {
                                if (Float.compare(this.f67925v, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f67925v, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f67925v, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.r0(this.f67916m).V(this.f67917n).g0(f11).j0(iIntValue).h0(this.f67926w).n0(this.f67927x).N(kVarA);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.L(this.P).l0(this.R).e0(i12);
                        i15 = 1;
                    }
                    if (this.f67904a != null) {
                        bVar.Z(this.f67904a);
                    }
                    androidx.media3.common.y yVarI111 = bVar.W(i11).k0(str3).c0(i13).b0(this.X).m0(i2111).Y(listSingletonList).M(str).R(this.f67915l).I();
                    r0 r0VarTrack111 = uVar.track(this.f67906c, i15);
                    this.Y = r0VarTrack111;
                    r0VarTrack111.b(yVarI111);
                    return;
                case 23:
                    int i31 = this.Q;
                    if (i31 == 8) {
                        listSingletonList = null;
                        str = null;
                        i13 = -1;
                        i12 = 3;
                    } else {
                        if (i31 == 16) {
                            i12 = ASTNode.DEOP;
                        } else if (i31 == 24) {
                            i12 = 1342177280;
                        } else if (i31 == 32) {
                            i12 = 1610612736;
                        } else {
                            o.h("MatroskaExtractor", "Unsupported big endian PCM bit depth: " + this.Q + ". Setting mimeType to " + MimeTypes.AUDIO_UNKNOWN);
                            listSingletonList = null;
                            str = null;
                            str5 = MimeTypes.AUDIO_UNKNOWN;
                            i13 = -1;
                            i12 = -1;
                        }
                        listSingletonList = null;
                        str = null;
                        i13 = -1;
                    }
                    if (this.O != null) {
                        str = nVarA.f78351c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z1112 = this.W;
                    if (this.V) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i2112 = i14 | (z1112 ? 1 : 0);
                    bVar = new androidx.media3.common.y.b();
                    if (!f0.o(str3)) {
                        if (f0.s(str3)) {
                            if (this.f67921r == 0) {
                                i18 = this.f67919p;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f67916m;
                                }
                                this.f67919p = i18;
                                i19 = this.f67920q;
                                if (i19 == -1) {
                                    i19 = this.f67917n;
                                }
                                this.f67920q = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f67919p;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f67928y) {
                            }
                            if (this.f67904a != null) {
                                iIntValue = ((Integer) e.f67872k0.get(this.f67904a)).intValue();
                            }
                            if (this.f67922s == 0) {
                                if (Float.compare(this.f67925v, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f67925v, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f67925v, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.r0(this.f67916m).V(this.f67917n).g0(f11).j0(iIntValue).h0(this.f67926w).n0(this.f67927x).N(kVarA);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.L(this.P).l0(this.R).e0(i12);
                        i15 = 1;
                    }
                    if (this.f67904a != null) {
                        bVar.Z(this.f67904a);
                    }
                    androidx.media3.common.y yVarI112 = bVar.W(i11).k0(str3).c0(i13).b0(this.X).m0(i2112).Y(listSingletonList).M(str).R(this.f67915l).I();
                    r0 r0VarTrack112 = uVar.track(this.f67906c, i15);
                    this.Y = r0VarTrack112;
                    r0VarTrack112.b(yVarI112);
                    return;
                case 24:
                    int iJ1 = u0.j0(this.Q);
                    if (iJ1 != 0) {
                        i12 = iJ1;
                        listSingletonList = null;
                        str = null;
                        i13 = -1;
                        if (this.O != null) {
                            str = nVarA.f78351c;
                            str5 = "video/dolby-vision";
                        }
                        str3 = str5;
                        boolean z1113 = this.W;
                        if (this.V) {
                            i14 = 2;
                        } else {
                            i14 = 0;
                        }
                        int i2113 = i14 | (z1113 ? 1 : 0);
                        bVar = new androidx.media3.common.y.b();
                        if (!f0.o(str3)) {
                            if (f0.s(str3)) {
                                if (this.f67921r == 0) {
                                    i18 = this.f67919p;
                                    iIntValue = -1;
                                    if (i18 == -1) {
                                        i18 = this.f67916m;
                                    }
                                    this.f67919p = i18;
                                    i19 = this.f67920q;
                                    if (i19 == -1) {
                                        i19 = this.f67917n;
                                    }
                                    this.f67920q = i19;
                                } else {
                                    iIntValue = -1;
                                }
                                i16 = this.f67919p;
                                if (i16 != iIntValue) {
                                    f11 = -1.0f;
                                } else {
                                    f11 = -1.0f;
                                }
                                if (this.f67928y) {
                                }
                                if (this.f67904a != null) {
                                    iIntValue = ((Integer) e.f67872k0.get(this.f67904a)).intValue();
                                }
                                if (this.f67922s == 0) {
                                    if (Float.compare(this.f67925v, 0.0f) == 0) {
                                        iIntValue = 0;
                                    } else if (Float.compare(this.f67925v, 90.0f) == 0) {
                                        iIntValue = 90;
                                    } else if (Float.compare(this.f67925v, -180.0f) != 0) {
                                        iIntValue = 180;
                                    } else {
                                        iIntValue = 180;
                                    }
                                }
                                bVar.r0(this.f67916m).V(this.f67917n).g0(f11).j0(iIntValue).h0(this.f67926w).n0(this.f67927x).N(kVarA);
                                i15 = 2;
                            } else {
                                if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                                }
                                i15 = 3;
                            }
                            break;
                        } else {
                            bVar.L(this.P).l0(this.R).e0(i12);
                            i15 = 1;
                        }
                        if (this.f67904a != null) {
                            bVar.Z(this.f67904a);
                        }
                        androidx.media3.common.y yVarI113 = bVar.W(i11).k0(str3).c0(i13).b0(this.X).m0(i2113).Y(listSingletonList).M(str).R(this.f67915l).I();
                        r0 r0VarTrack113 = uVar.track(this.f67906c, i15);
                        this.Y = r0VarTrack113;
                        r0VarTrack113.b(yVarI113);
                        return;
                    }
                    o.h("MatroskaExtractor", "Unsupported little endian PCM bit depth: " + this.Q + ". Setting mimeType to " + MimeTypes.AUDIO_UNKNOWN);
                    listSingletonList = null;
                    str = null;
                    str5 = MimeTypes.AUDIO_UNKNOWN;
                    i13 = -1;
                    i12 = -1;
                    if (this.O != null) {
                        str = nVarA.f78351c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z1114 = this.W;
                    if (this.V) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i2114 = i14 | (z1114 ? 1 : 0);
                    bVar = new androidx.media3.common.y.b();
                    if (!f0.o(str3)) {
                        if (f0.s(str3)) {
                            if (this.f67921r == 0) {
                                i18 = this.f67919p;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f67916m;
                                }
                                this.f67919p = i18;
                                i19 = this.f67920q;
                                if (i19 == -1) {
                                    i19 = this.f67917n;
                                }
                                this.f67920q = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f67919p;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f67928y) {
                            }
                            if (this.f67904a != null) {
                                iIntValue = ((Integer) e.f67872k0.get(this.f67904a)).intValue();
                            }
                            if (this.f67922s == 0) {
                                if (Float.compare(this.f67925v, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f67925v, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f67925v, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.r0(this.f67916m).V(this.f67917n).g0(f11).j0(iIntValue).h0(this.f67926w).n0(this.f67927x).N(kVarA);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.L(this.P).l0(this.R).e0(i12);
                        i15 = 1;
                    }
                    if (this.f67904a != null) {
                        bVar.Z(this.f67904a);
                    }
                    androidx.media3.common.y yVarI114 = bVar.W(i11).k0(str3).c0(i13).b0(this.X).m0(i2114).Y(listSingletonList).M(str).R(this.f67915l).I();
                    r0 r0VarTrack114 = uVar.track(this.f67906c, i15);
                    this.Y = r0VarTrack114;
                    r0VarTrack114.b(yVarI114);
                    return;
                case 25:
                    listSingletonList = ImmutableList.of(e.f67868g0, g(this.f67905b));
                    str = null;
                    str5 = MimeTypes.TEXT_SSA;
                    i13 = -1;
                    i12 = -1;
                    if (this.O != null) {
                        str = nVarA.f78351c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z1115 = this.W;
                    if (this.V) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i2115 = i14 | (z1115 ? 1 : 0);
                    bVar = new androidx.media3.common.y.b();
                    if (!f0.o(str3)) {
                        if (f0.s(str3)) {
                            if (this.f67921r == 0) {
                                i18 = this.f67919p;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f67916m;
                                }
                                this.f67919p = i18;
                                i19 = this.f67920q;
                                if (i19 == -1) {
                                    i19 = this.f67917n;
                                }
                                this.f67920q = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f67919p;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f67928y) {
                            }
                            if (this.f67904a != null) {
                                iIntValue = ((Integer) e.f67872k0.get(this.f67904a)).intValue();
                            }
                            if (this.f67922s == 0) {
                                if (Float.compare(this.f67925v, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f67925v, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f67925v, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.r0(this.f67916m).V(this.f67917n).g0(f11).j0(iIntValue).h0(this.f67926w).n0(this.f67927x).N(kVarA);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.L(this.P).l0(this.R).e0(i12);
                        i15 = 1;
                    }
                    if (this.f67904a != null) {
                        bVar.Z(this.f67904a);
                    }
                    androidx.media3.common.y yVarI115 = bVar.W(i11).k0(str3).c0(i13).b0(this.X).m0(i2115).Y(listSingletonList).M(str).R(this.f67915l).I();
                    r0 r0VarTrack115 = uVar.track(this.f67906c, i15);
                    this.Y = r0VarTrack115;
                    r0VarTrack115.b(yVarI115);
                    return;
                case 26:
                    g0 g0VarA = g0.a(new c0(g(this.f67905b)));
                    list = g0VarA.f78272a;
                    this.Z = g0VarA.f78273b;
                    str2 = g0VarA.f78282k;
                    str5 = MimeTypes.VIDEO_H265;
                    i13 = -1;
                    i12 = -1;
                    List<byte[]> list3 = list;
                    str = str2;
                    listSingletonList = list3;
                    if (this.O != null) {
                        str = nVarA.f78351c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z1116 = this.W;
                    if (this.V) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i2116 = i14 | (z1116 ? 1 : 0);
                    bVar = new androidx.media3.common.y.b();
                    if (!f0.o(str3)) {
                        if (f0.s(str3)) {
                            if (this.f67921r == 0) {
                                i18 = this.f67919p;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f67916m;
                                }
                                this.f67919p = i18;
                                i19 = this.f67920q;
                                if (i19 == -1) {
                                    i19 = this.f67917n;
                                }
                                this.f67920q = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f67919p;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f67928y) {
                            }
                            if (this.f67904a != null) {
                                iIntValue = ((Integer) e.f67872k0.get(this.f67904a)).intValue();
                            }
                            if (this.f67922s == 0) {
                                if (Float.compare(this.f67925v, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f67925v, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f67925v, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.r0(this.f67916m).V(this.f67917n).g0(f11).j0(iIntValue).h0(this.f67926w).n0(this.f67927x).N(kVarA);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.L(this.P).l0(this.R).e0(i12);
                        i15 = 1;
                    }
                    if (this.f67904a != null) {
                        bVar.Z(this.f67904a);
                    }
                    androidx.media3.common.y yVarI116 = bVar.W(i11).k0(str3).c0(i13).b0(this.X).m0(i2116).Y(listSingletonList).M(str).R(this.f67915l).I();
                    r0 r0VarTrack116 = uVar.track(this.f67906c, i15);
                    this.Y = r0VarTrack116;
                    r0VarTrack116.b(yVarI116);
                    return;
                case 27:
                    str5 = MimeTypes.TEXT_VTT;
                    listSingletonList = null;
                    str = null;
                    i13 = -1;
                    i12 = -1;
                    if (this.O != null) {
                        str = nVarA.f78351c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z1117 = this.W;
                    if (this.V) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i2117 = i14 | (z1117 ? 1 : 0);
                    bVar = new androidx.media3.common.y.b();
                    if (!f0.o(str3)) {
                        if (f0.s(str3)) {
                            if (this.f67921r == 0) {
                                i18 = this.f67919p;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f67916m;
                                }
                                this.f67919p = i18;
                                i19 = this.f67920q;
                                if (i19 == -1) {
                                    i19 = this.f67917n;
                                }
                                this.f67920q = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f67919p;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f67928y) {
                            }
                            if (this.f67904a != null) {
                                iIntValue = ((Integer) e.f67872k0.get(this.f67904a)).intValue();
                            }
                            if (this.f67922s == 0) {
                                if (Float.compare(this.f67925v, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f67925v, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f67925v, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.r0(this.f67916m).V(this.f67917n).g0(f11).j0(iIntValue).h0(this.f67926w).n0(this.f67927x).N(kVarA);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.L(this.P).l0(this.R).e0(i12);
                        i15 = 1;
                    }
                    if (this.f67904a != null) {
                        bVar.Z(this.f67904a);
                    }
                    androidx.media3.common.y yVarI117 = bVar.W(i11).k0(str3).c0(i13).b0(this.X).m0(i2117).Y(listSingletonList).M(str).R(this.f67915l).I();
                    r0 r0VarTrack117 = uVar.track(this.f67906c, i15);
                    this.Y = r0VarTrack117;
                    r0VarTrack117.b(yVarI117);
                    return;
                case 28:
                    listSingletonList = null;
                    str = null;
                    str5 = MimeTypes.APPLICATION_SUBRIP;
                    i13 = -1;
                    i12 = -1;
                    if (this.O != null) {
                        str = nVarA.f78351c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z1118 = this.W;
                    if (this.V) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i2118 = i14 | (z1118 ? 1 : 0);
                    bVar = new androidx.media3.common.y.b();
                    if (!f0.o(str3)) {
                        if (f0.s(str3)) {
                            if (this.f67921r == 0) {
                                i18 = this.f67919p;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f67916m;
                                }
                                this.f67919p = i18;
                                i19 = this.f67920q;
                                if (i19 == -1) {
                                    i19 = this.f67917n;
                                }
                                this.f67920q = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f67919p;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f67928y) {
                            }
                            if (this.f67904a != null) {
                                iIntValue = ((Integer) e.f67872k0.get(this.f67904a)).intValue();
                            }
                            if (this.f67922s == 0) {
                                if (Float.compare(this.f67925v, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f67925v, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f67925v, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.r0(this.f67916m).V(this.f67917n).g0(f11).j0(iIntValue).h0(this.f67926w).n0(this.f67927x).N(kVarA);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.L(this.P).l0(this.R).e0(i12);
                        i15 = 1;
                    }
                    if (this.f67904a != null) {
                        bVar.Z(this.f67904a);
                    }
                    androidx.media3.common.y yVarI118 = bVar.W(i11).k0(str3).c0(i13).b0(this.X).m0(i2118).Y(listSingletonList).M(str).R(this.f67915l).I();
                    r0 r0VarTrack118 = uVar.track(this.f67906c, i15);
                    this.Y = r0VarTrack118;
                    r0VarTrack118.b(yVarI118);
                    return;
                case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                    str5 = MimeTypes.VIDEO_MPEG2;
                    listSingletonList = null;
                    str = null;
                    i13 = -1;
                    i12 = -1;
                    if (this.O != null) {
                        str = nVarA.f78351c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z1119 = this.W;
                    if (this.V) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i2119 = i14 | (z1119 ? 1 : 0);
                    bVar = new androidx.media3.common.y.b();
                    if (!f0.o(str3)) {
                        if (f0.s(str3)) {
                            if (this.f67921r == 0) {
                                i18 = this.f67919p;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f67916m;
                                }
                                this.f67919p = i18;
                                i19 = this.f67920q;
                                if (i19 == -1) {
                                    i19 = this.f67917n;
                                }
                                this.f67920q = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f67919p;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f67928y) {
                            }
                            if (this.f67904a != null) {
                                iIntValue = ((Integer) e.f67872k0.get(this.f67904a)).intValue();
                            }
                            if (this.f67922s == 0) {
                                if (Float.compare(this.f67925v, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f67925v, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f67925v, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.r0(this.f67916m).V(this.f67917n).g0(f11).j0(iIntValue).h0(this.f67926w).n0(this.f67927x).N(kVarA);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.L(this.P).l0(this.R).e0(i12);
                        i15 = 1;
                    }
                    if (this.f67904a != null) {
                        bVar.Z(this.f67904a);
                    }
                    androidx.media3.common.y yVarI119 = bVar.W(i11).k0(str3).c0(i13).b0(this.X).m0(i2119).Y(listSingletonList).M(str).R(this.f67915l).I();
                    r0 r0VarTrack119 = uVar.track(this.f67906c, i15);
                    this.Y = r0VarTrack119;
                    r0VarTrack119.b(yVarI119);
                    return;
                case 30:
                    str5 = MimeTypes.AUDIO_E_AC3;
                    listSingletonList = null;
                    str = null;
                    i13 = -1;
                    i12 = -1;
                    if (this.O != null) {
                        str = nVarA.f78351c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z11110 = this.W;
                    if (this.V) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i21110 = i14 | (z11110 ? 1 : 0);
                    bVar = new androidx.media3.common.y.b();
                    if (!f0.o(str3)) {
                        if (f0.s(str3)) {
                            if (this.f67921r == 0) {
                                i18 = this.f67919p;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f67916m;
                                }
                                this.f67919p = i18;
                                i19 = this.f67920q;
                                if (i19 == -1) {
                                    i19 = this.f67917n;
                                }
                                this.f67920q = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f67919p;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f67928y) {
                            }
                            if (this.f67904a != null) {
                                iIntValue = ((Integer) e.f67872k0.get(this.f67904a)).intValue();
                            }
                            if (this.f67922s == 0) {
                                if (Float.compare(this.f67925v, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f67925v, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f67925v, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.r0(this.f67916m).V(this.f67917n).g0(f11).j0(iIntValue).h0(this.f67926w).n0(this.f67927x).N(kVarA);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.L(this.P).l0(this.R).e0(i12);
                        i15 = 1;
                    }
                    if (this.f67904a != null) {
                        bVar.Z(this.f67904a);
                    }
                    androidx.media3.common.y yVarI1110 = bVar.W(i11).k0(str3).c0(i13).b0(this.X).m0(i21110).Y(listSingletonList).M(str).R(this.f67915l).I();
                    r0 r0VarTrack1110 = uVar.track(this.f67906c, i15);
                    this.Y = r0VarTrack1110;
                    r0VarTrack1110.b(yVarI1110);
                    return;
                case VungleException.WEB_CRASH /* 31 */:
                    listSingletonList = Collections.singletonList(g(this.f67905b));
                    str5 = MimeTypes.AUDIO_FLAC;
                    str = null;
                    i13 = -1;
                    i12 = -1;
                    if (this.O != null) {
                        str = nVarA.f78351c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z11111 = this.W;
                    if (this.V) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i21111 = i14 | (z11111 ? 1 : 0);
                    bVar = new androidx.media3.common.y.b();
                    if (!f0.o(str3)) {
                        if (f0.s(str3)) {
                            if (this.f67921r == 0) {
                                i18 = this.f67919p;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f67916m;
                                }
                                this.f67919p = i18;
                                i19 = this.f67920q;
                                if (i19 == -1) {
                                    i19 = this.f67917n;
                                }
                                this.f67920q = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f67919p;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f67928y) {
                            }
                            if (this.f67904a != null) {
                                iIntValue = ((Integer) e.f67872k0.get(this.f67904a)).intValue();
                            }
                            if (this.f67922s == 0) {
                                if (Float.compare(this.f67925v, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f67925v, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f67925v, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.r0(this.f67916m).V(this.f67917n).g0(f11).j0(iIntValue).h0(this.f67926w).n0(this.f67927x).N(kVarA);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.L(this.P).l0(this.R).e0(i12);
                        i15 = 1;
                    }
                    if (this.f67904a != null) {
                        bVar.Z(this.f67904a);
                    }
                    androidx.media3.common.y yVarI1111 = bVar.W(i11).k0(str3).c0(i13).b0(this.X).m0(i21111).Y(listSingletonList).M(str).R(this.f67915l).I();
                    r0 r0VarTrack1111 = uVar.track(this.f67906c, i15);
                    this.Y = r0VarTrack1111;
                    r0VarTrack1111.b(yVarI1111);
                    return;
                case 32:
                    listSingletonList = new ArrayList<>(3);
                    listSingletonList.add(g(this.f67905b));
                    ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
                    ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                    listSingletonList.add(byteBufferAllocate.order(byteOrder).putLong(this.S).array());
                    listSingletonList.add(ByteBuffer.allocate(8).order(byteOrder).putLong(this.T).array());
                    str5 = MimeTypes.AUDIO_OPUS;
                    str = null;
                    i13 = 5760;
                    i12 = -1;
                    if (this.O != null) {
                        str = nVarA.f78351c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z11112 = this.W;
                    if (this.V) {
                        i14 = 2;
                    } else {
                        i14 = 0;
                    }
                    int i21112 = i14 | (z11112 ? 1 : 0);
                    bVar = new androidx.media3.common.y.b();
                    if (!f0.o(str3)) {
                        if (f0.s(str3)) {
                            if (this.f67921r == 0) {
                                i18 = this.f67919p;
                                iIntValue = -1;
                                if (i18 == -1) {
                                    i18 = this.f67916m;
                                }
                                this.f67919p = i18;
                                i19 = this.f67920q;
                                if (i19 == -1) {
                                    i19 = this.f67917n;
                                }
                                this.f67920q = i19;
                            } else {
                                iIntValue = -1;
                            }
                            i16 = this.f67919p;
                            if (i16 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.f67928y) {
                            }
                            if (this.f67904a != null) {
                                iIntValue = ((Integer) e.f67872k0.get(this.f67904a)).intValue();
                            }
                            if (this.f67922s == 0) {
                                if (Float.compare(this.f67925v, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.f67925v, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.f67925v, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.r0(this.f67916m).V(this.f67917n).g0(f11).j0(iIntValue).h0(this.f67926w).n0(this.f67927x).N(kVarA);
                            i15 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i15 = 3;
                        }
                        break;
                    } else {
                        bVar.L(this.P).l0(this.R).e0(i12);
                        i15 = 1;
                    }
                    if (this.f67904a != null) {
                        bVar.Z(this.f67904a);
                    }
                    androidx.media3.common.y yVarI1112 = bVar.W(i11).k0(str3).c0(i13).b0(this.X).m0(i21112).Y(listSingletonList).M(str).R(this.f67915l).I();
                    r0 r0VarTrack1112 = uVar.track(this.f67906c, i15);
                    this.Y = r0VarTrack1112;
                    r0VarTrack1112.b(yVarI1112);
                    return;
                default:
                    throw ParserException.createForMalformedContainer("Unrecognized codec identifier.", null);
            }
        }

        public void j() {
            s0 s0Var = this.U;
            if (s0Var != null) {
                s0Var.a(this.Y, this.f67913j);
            }
        }

        public void n() {
            s0 s0Var = this.U;
            if (s0Var != null) {
                s0Var.b();
            }
        }

        public final boolean o(boolean z11) {
            if ("A_OPUS".equals(this.f67905b)) {
                return z11;
            }
            return this.f67909f > 0;
        }
    }

    static {
        HashMap map = new HashMap();
        map.put("htc_video_rotA-000", 0);
        map.put("htc_video_rotA-090", 90);
        map.put("htc_video_rotA-180", 180);
        map.put("htc_video_rotA-270", 270);
        f67872k0 = Collections.unmodifiableMap(map);
    }

    public e(j5.c cVar, int i11, o5.s.a aVar) {
        this.f67895s = -1L;
        this.f67896t = C.TIME_UNSET;
        this.f67897u = C.TIME_UNSET;
        this.f67898v = C.TIME_UNSET;
        this.B = -1L;
        this.C = -1L;
        this.D = C.TIME_UNSET;
        this.f67873a = cVar;
        cVar.b(new b());
        this.f67882f = aVar;
        this.f67879d = (i11 & 1) == 0;
        this.f67881e = (i11 & 2) == 0;
        this.f67875b = new g();
        this.f67877c = new SparseArray<>();
        this.f67885i = new c0(4);
        this.f67886j = new c0(ByteBuffer.allocate(4).putInt(-1).array());
        this.f67887k = new c0(4);
        this.f67883g = new c0(a4.a.f366a);
        this.f67884h = new c0(4);
        this.f67888l = new c0();
        this.f67889m = new c0();
        this.f67890n = new c0(8);
        this.f67891o = new c0();
        this.f67892p = new c0();
        this.N = new int[1];
    }

    public e(o5.s.a aVar, int i11) {
        this(new j5.a(), i11, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ s[] A() {
        return new s[]{new e(o5.s.a.f72352a, 2)};
    }

    public static void F(String str, long j11, byte[] bArr) {
        byte[] bArrS;
        int i11;
        str.hashCode();
        switch (str) {
            case "S_TEXT/ASS":
                bArrS = s(j11, "%01d:%02d:%02d:%02d", 10000L);
                i11 = 21;
                break;
            case "S_TEXT/WEBVTT":
                bArrS = s(j11, "%02d:%02d:%02d.%03d", 1000L);
                i11 = 25;
                break;
            case "S_TEXT/UTF8":
                bArrS = s(j11, "%02d:%02d:%02d,%03d", 1000L);
                i11 = 19;
                break;
            default:
                throw new IllegalArgumentException();
        }
        System.arraycopy(bArrS, 0, bArr, i11, bArrS.length);
    }

    private void k() {
        z3.a.i(this.f67880d0);
    }

    public static int[] p(@Nullable int[] iArr, int i11) {
        if (iArr == null) {
            return new int[i11];
        }
        return iArr.length >= i11 ? iArr : new int[Math.max(iArr.length * 2, i11)];
    }

    public static byte[] s(long j11, String str, long j12) {
        z3.a.a(j11 != C.TIME_UNSET);
        int i11 = (int) (j11 / 3600000000L);
        long j13 = j11 - (((long) i11) * 3600000000L);
        int i12 = (int) (j13 / 60000000);
        long j14 = j13 - (((long) i12) * 60000000);
        int i13 = (int) (j14 / 1000000);
        return u0.w0(String.format(Locale.US, str, Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf((int) ((j14 - (((long) i13) * 1000000)) / j12))));
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static boolean y(String str) {
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

    public final boolean B(l0 l0Var, long j11) {
        if (this.A) {
            this.C = j11;
            l0Var.f78322a = this.B;
            this.A = false;
            return true;
        }
        if (this.f67900x) {
            long j12 = this.C;
            if (j12 != -1) {
                l0Var.f78322a = j12;
                this.C = -1L;
                return true;
            }
        }
        return false;
    }

    public final void C(t tVar, int i11) throws IOException {
        if (this.f67885i.g() >= i11) {
            return;
        }
        if (this.f67885i.b() < i11) {
            c0 c0Var = this.f67885i;
            c0Var.c(Math.max(c0Var.b() * 2, i11));
        }
        tVar.readFully(this.f67885i.e(), this.f67885i.g(), i11 - this.f67885i.g());
        this.f67885i.T(i11);
    }

    public final void D() {
        this.U = 0;
        this.V = 0;
        this.W = 0;
        this.X = false;
        this.Y = false;
        this.Z = false;
        this.f67874a0 = 0;
        this.f67876b0 = (byte) 0;
        this.f67878c0 = false;
        this.f67888l.Q(0);
    }

    public final long E(long j11) throws ParserException {
        long j12 = this.f67896t;
        if (j12 != C.TIME_UNSET) {
            return u0.f1(j11, j12, 1000L);
        }
        throw ParserException.createForMalformedContainer("Can't scale timecode prior to timecodeScale being set.", null);
    }

    @CallSuper
    public void G(int i11, long j11, long j12) throws ParserException {
        k();
        if (i11 == 160) {
            this.S = false;
            this.T = 0L;
            return;
        }
        if (i11 == 174) {
            this.f67899w = new c();
            return;
        }
        if (i11 == 187) {
            this.G = false;
            return;
        }
        if (i11 == 19899) {
            this.f67901y = -1;
            this.f67902z = -1L;
            return;
        }
        if (i11 == 20533) {
            t(i11).f67911h = true;
            return;
        }
        if (i11 == 21968) {
            t(i11).f67928y = true;
            return;
        }
        if (i11 == 408125543) {
            long j13 = this.f67895s;
            if (j13 != -1 && j13 != j11) {
                throw ParserException.createForMalformedContainer("Multiple Segment elements not supported", null);
            }
            this.f67895s = j11;
            this.f67894r = j12;
            return;
        }
        if (i11 == 475249515) {
            this.E = new p();
            this.F = new p();
        } else if (i11 == 524531317 && !this.f67900x) {
            if (this.f67879d && this.B != -1) {
                this.A = true;
            } else {
                this.f67880d0.f(new m0.b(this.f67898v));
                this.f67900x = true;
            }
        }
    }

    @CallSuper
    public void H(int i11, String str) throws ParserException {
        if (i11 == 134) {
            t(i11).f67905b = str;
            return;
        }
        if (i11 != 17026) {
            if (i11 == 21358) {
                t(i11).f67904a = str;
                return;
            } else {
                if (i11 != 2274716) {
                    return;
                }
                t(i11).X = str;
                return;
            }
        }
        if ("webm".equals(str) || "matroska".equals(str)) {
            return;
        }
        throw ParserException.createForMalformedContainer("DocType " + str + " not supported", null);
    }

    public final int I(t tVar, c cVar, int i11, boolean z11) throws IOException {
        int i12;
        if ("S_TEXT/UTF8".equals(cVar.f67905b)) {
            J(tVar, f67867f0, i11);
            return q();
        }
        if ("S_TEXT/ASS".equals(cVar.f67905b)) {
            J(tVar, f67869h0, i11);
            return q();
        }
        if ("S_TEXT/WEBVTT".equals(cVar.f67905b)) {
            J(tVar, f67870i0, i11);
            return q();
        }
        r0 r0Var = cVar.Y;
        if (!this.X) {
            if (cVar.f67911h) {
                this.Q &= -1073741825;
                if (!this.Y) {
                    tVar.readFully(this.f67885i.e(), 0, 1);
                    this.U++;
                    if ((this.f67885i.e()[0] & 128) == 128) {
                        throw ParserException.createForMalformedContainer("Extension bit is set in signal byte", null);
                    }
                    this.f67876b0 = this.f67885i.e()[0];
                    this.Y = true;
                }
                byte b11 = this.f67876b0;
                if ((b11 & 1) == 1) {
                    boolean z12 = (b11 & 2) == 2;
                    this.Q |= 1073741824;
                    if (!this.f67878c0) {
                        tVar.readFully(this.f67890n.e(), 0, 8);
                        this.U += 8;
                        this.f67878c0 = true;
                        this.f67885i.e()[0] = (byte) ((z12 ? 128 : 0) | 8);
                        this.f67885i.U(0);
                        r0Var.a(this.f67885i, 1, 1);
                        this.V++;
                        this.f67890n.U(0);
                        r0Var.a(this.f67890n, 8, 1);
                        this.V += 8;
                    }
                    if (z12) {
                        if (!this.Z) {
                            tVar.readFully(this.f67885i.e(), 0, 1);
                            this.U++;
                            this.f67885i.U(0);
                            this.f67874a0 = this.f67885i.H();
                            this.Z = true;
                        }
                        int i13 = this.f67874a0 * 4;
                        this.f67885i.Q(i13);
                        tVar.readFully(this.f67885i.e(), 0, i13);
                        this.U += i13;
                        short s11 = (short) ((this.f67874a0 / 2) + 1);
                        int i14 = (s11 * 6) + 2;
                        ByteBuffer byteBuffer = this.f67893q;
                        if (byteBuffer == null || byteBuffer.capacity() < i14) {
                            this.f67893q = ByteBuffer.allocate(i14);
                        }
                        this.f67893q.position(0);
                        this.f67893q.putShort(s11);
                        int i15 = 0;
                        int i16 = 0;
                        while (true) {
                            i12 = this.f67874a0;
                            if (i15 >= i12) {
                                break;
                            }
                            int iL = this.f67885i.L();
                            if (i15 % 2 == 0) {
                                this.f67893q.putShort((short) (iL - i16));
                            } else {
                                this.f67893q.putInt(iL - i16);
                            }
                            i15++;
                            i16 = iL;
                        }
                        int i17 = (i11 - this.U) - i16;
                        if (i12 % 2 == 1) {
                            this.f67893q.putInt(i17);
                        } else {
                            this.f67893q.putShort((short) i17);
                            this.f67893q.putInt(0);
                        }
                        this.f67891o.S(this.f67893q.array(), i14);
                        r0Var.a(this.f67891o, i14, 1);
                        this.V += i14;
                    }
                }
            } else {
                byte[] bArr = cVar.f67912i;
                if (bArr != null) {
                    this.f67888l.S(bArr, bArr.length);
                }
            }
            if (cVar.o(z11)) {
                this.Q |= ASTNode.DEOP;
                this.f67892p.Q(0);
                int iG = (this.f67888l.g() + i11) - this.U;
                this.f67885i.Q(4);
                this.f67885i.e()[0] = (byte) ((iG >> 24) & 255);
                this.f67885i.e()[1] = (byte) ((iG >> 16) & 255);
                this.f67885i.e()[2] = (byte) ((iG >> 8) & 255);
                this.f67885i.e()[3] = (byte) (iG & 255);
                r0Var.a(this.f67885i, 4, 2);
                this.V += 4;
            }
            this.X = true;
        }
        int iG2 = i11 + this.f67888l.g();
        if (!"V_MPEG4/ISO/AVC".equals(cVar.f67905b) && !"V_MPEGH/ISO/HEVC".equals(cVar.f67905b)) {
            if (cVar.U != null) {
                z3.a.g(this.f67888l.g() == 0);
                cVar.U.d(tVar);
            }
            while (true) {
                int i18 = this.U;
                if (i18 >= iG2) {
                    break;
                }
                int iK = K(tVar, r0Var, iG2 - i18);
                this.U += iK;
                this.V += iK;
            }
        } else {
            byte[] bArrE = this.f67884h.e();
            bArrE[0] = 0;
            bArrE[1] = 0;
            bArrE[2] = 0;
            int i19 = cVar.Z;
            int i21 = 4 - i19;
            while (this.U < iG2) {
                int i22 = this.W;
                if (i22 == 0) {
                    L(tVar, bArrE, i21, i19);
                    this.U += i19;
                    this.f67884h.U(0);
                    this.W = this.f67884h.L();
                    this.f67883g.U(0);
                    r0Var.c(this.f67883g, 4);
                    this.V += 4;
                } else {
                    int iK2 = K(tVar, r0Var, i22);
                    this.U += iK2;
                    this.V += iK2;
                    this.W -= iK2;
                }
            }
        }
        if ("A_VORBIS".equals(cVar.f67905b)) {
            this.f67886j.U(0);
            r0Var.c(this.f67886j, 4);
            this.V += 4;
        }
        return q();
    }

    public final void J(t tVar, byte[] bArr, int i11) throws IOException {
        int length = bArr.length + i11;
        if (this.f67889m.b() < length) {
            this.f67889m.R(Arrays.copyOf(bArr, length + i11));
        } else {
            System.arraycopy(bArr, 0, this.f67889m.e(), 0, bArr.length);
        }
        tVar.readFully(this.f67889m.e(), bArr.length, i11);
        this.f67889m.U(0);
        this.f67889m.T(length);
    }

    public final int K(t tVar, r0 r0Var, int i11) throws IOException {
        int iA = this.f67888l.a();
        if (iA <= 0) {
            return r0Var.d(tVar, i11, false);
        }
        int iMin = Math.min(i11, iA);
        r0Var.c(this.f67888l, iMin);
        return iMin;
    }

    public final void L(t tVar, byte[] bArr, int i11, int i12) throws IOException {
        int iMin = Math.min(i12, this.f67888l.a());
        tVar.readFully(bArr, i11 + iMin, i12 - iMin);
        if (iMin > 0) {
            this.f67888l.l(bArr, i11, iMin);
        }
    }

    @Override // u4.s
    public final boolean b(t tVar) throws IOException {
        return new f().b(tVar);
    }

    @Override // u4.s
    public /* synthetic */ s c() {
        return r.a(this);
    }

    @Override // u4.s
    public final int d(t tVar, l0 l0Var) throws IOException {
        this.H = false;
        boolean zA = true;
        while (zA && !this.H) {
            zA = this.f67873a.a(tVar);
            if (zA && B(l0Var, tVar.getPosition())) {
                return 1;
            }
        }
        if (zA) {
            return 0;
        }
        for (int i11 = 0; i11 < this.f67877c.size(); i11++) {
            c cVarValueAt = this.f67877c.valueAt(i11);
            cVarValueAt.f();
            cVarValueAt.j();
        }
        return -1;
    }

    @Override // u4.s
    public final void f(u uVar) {
        this.f67880d0 = uVar;
        if (this.f67881e) {
            uVar = new o5.u(uVar, this.f67882f);
        }
        this.f67880d0 = uVar;
    }

    public final void i(int i11) throws ParserException {
        if (this.E == null || this.F == null) {
            throw ParserException.createForMalformedContainer("Element " + i11 + " must be in a Cues", null);
        }
    }

    public final void j(int i11) throws ParserException {
        if (this.f67899w != null) {
            return;
        }
        throw ParserException.createForMalformedContainer("Element " + i11 + " must be in a TrackEntry", null);
    }

    /* JADX WARN: Code duplicated, block: B:97:0x0282  */
    @CallSuper
    public void l(int i11, int i12, t tVar) throws IOException {
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
                if (this.I != 2) {
                    return;
                }
                w(this.f67877c.get(this.O), this.R, tVar, i12);
                return;
            }
            if (i11 == 16877) {
                v(t(i11), tVar, i12);
                return;
            }
            if (i11 == 16981) {
                j(i11);
                byte[] bArr = new byte[i12];
                this.f67899w.f67912i = bArr;
                tVar.readFully(bArr, 0, i12);
                return;
            }
            if (i11 == 18402) {
                byte[] bArr2 = new byte[i12];
                tVar.readFully(bArr2, 0, i12);
                t(i11).f67913j = new r0.a(1, bArr2, 0, 0);
                return;
            }
            if (i11 == 21419) {
                Arrays.fill(this.f67887k.e(), (byte) 0);
                tVar.readFully(this.f67887k.e(), 4 - i12, i12);
                this.f67887k.U(0);
                this.f67901y = (int) this.f67887k.J();
                return;
            }
            if (i11 == 25506) {
                j(i11);
                byte[] bArr3 = new byte[i12];
                this.f67899w.f67914k = bArr3;
                tVar.readFully(bArr3, 0, i12);
                return;
            }
            if (i11 != 30322) {
                throw ParserException.createForMalformedContainer("Unexpected id: " + i11, null);
            }
            j(i11);
            byte[] bArr4 = new byte[i12];
            this.f67899w.f67926w = bArr4;
            tVar.readFully(bArr4, 0, i12);
            return;
        }
        if (this.I == 0) {
            this.O = (int) this.f67875b.d(tVar, false, true, 8);
            this.P = this.f67875b.b();
            this.K = C.TIME_UNSET;
            this.I = 1;
            this.f67885i.Q(0);
        }
        c cVar4 = this.f67877c.get(this.O);
        if (cVar4 == null) {
            tVar.skipFully(i12 - this.P);
            this.I = 0;
            return;
        }
        cVar4.f();
        if (this.I == 1) {
            C(tVar, 3);
            int i19 = (this.f67885i.e()[2] & 6) >> 1;
            byte b11 = 255;
            if (i19 == 0) {
                this.M = 1;
                int[] iArrP = p(this.N, 1);
                this.N = iArrP;
                iArrP[0] = (i12 - this.P) - 3;
            } else {
                int i21 = 4;
                C(tVar, 4);
                int i22 = (this.f67885i.e()[3] & 255) + 1;
                this.M = i22;
                int[] iArrP2 = p(this.N, i22);
                this.N = iArrP2;
                if (i19 == 2) {
                    int i23 = (i12 - this.P) - 4;
                    int i24 = this.M;
                    Arrays.fill(iArrP2, 0, i24, i23 / i24);
                } else {
                    if (i19 == 1) {
                        int i25 = 0;
                        int i26 = 0;
                        while (true) {
                            i13 = this.M;
                            if (i25 >= i13 - 1) {
                                break;
                            }
                            this.N[i25] = 0;
                            while (true) {
                                i14 = i21 + 1;
                                C(tVar, i14);
                                int i27 = this.f67885i.e()[i21] & 255;
                                int[] iArr = this.N;
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
                        this.N[i13 - 1] = ((i12 - this.P) - i21) - i26;
                    } else {
                        if (i19 != 3) {
                            throw ParserException.createForMalformedContainer("Unexpected lacing value: " + i19, null);
                        }
                        int i28 = 0;
                        int i29 = 0;
                        while (true) {
                            int i31 = this.M;
                            if (i28 >= i31 - 1) {
                                cVar2 = cVar4;
                                this.N[i31 - 1] = ((i12 - this.P) - i21) - i29;
                                break;
                            }
                            this.N[i28] = i17;
                            int i32 = i21 + 1;
                            C(tVar, i32);
                            if (this.f67885i.e()[i21] == 0) {
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
                                if ((this.f67885i.e()[i21] & i34) != 0) {
                                    i32 += i33;
                                    C(tVar, i32);
                                    cVar3 = cVar4;
                                    j11 = (~i34) & this.f67885i.e()[i21] & b11;
                                    int i35 = i21 + 1;
                                    while (i35 < i32) {
                                        j11 = (j11 << 8) | ((long) (this.f67885i.e()[i35] & b11));
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
                            int[] iArr2 = this.N;
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
                    this.J = this.D + E((this.f67885i.e()[0] << 8) | (this.f67885i.e()[1] & 255));
                    cVar = cVar2;
                    if (cVar.f67907d != 2 || (i11 == 163 && (this.f67885i.e()[2] & 128) == 128)) {
                        i16 = 1;
                    } else {
                        i16 = 0;
                    }
                    this.Q = i16;
                    this.I = 2;
                    this.L = 0;
                }
            }
            cVar2 = cVar4;
            this.J = this.D + E((this.f67885i.e()[0] << 8) | (this.f67885i.e()[1] & 255));
            cVar = cVar2;
            if (cVar.f67907d != 2) {
                i16 = 1;
            } else {
                i16 = 1;
            }
            this.Q = i16;
            this.I = 2;
            this.L = 0;
        } else {
            cVar = cVar4;
        }
        if (i11 == 163) {
            while (true) {
                int i37 = this.L;
                if (i37 >= this.M) {
                    this.I = 0;
                    return;
                }
                n(cVar, ((long) ((this.L * cVar.f67908e) / 1000)) + this.J, this.Q, I(tVar, cVar, this.N[i37], false), 0);
                this.L++;
            }
        } else {
            while (true) {
                int i38 = this.L;
                if (i38 >= this.M) {
                    return;
                }
                int[] iArr3 = this.N;
                iArr3[i38] = I(tVar, cVar, iArr3[i38], true);
                this.L++;
            }
        }
    }

    public final m0 m(@Nullable p pVar, @Nullable p pVar2) {
        int i11;
        if (this.f67895s == -1 || this.f67898v == C.TIME_UNSET || pVar == null || pVar.c() == 0 || pVar2 == null || pVar2.c() != pVar.c()) {
            return new m0.b(this.f67898v);
        }
        int iC = pVar.c();
        int[] iArrCopyOf = new int[iC];
        long[] jArrCopyOf = new long[iC];
        long[] jArrCopyOf2 = new long[iC];
        long[] jArrCopyOf3 = new long[iC];
        int i12 = 0;
        for (int i13 = 0; i13 < iC; i13++) {
            jArrCopyOf3[i13] = pVar.b(i13);
            jArrCopyOf[i13] = this.f67895s + pVar2.b(i13);
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
        iArrCopyOf[i11] = (int) ((this.f67895s + this.f67894r) - jArrCopyOf[i11]);
        long j11 = this.f67898v - jArrCopyOf3[i11];
        jArrCopyOf2[i11] = j11;
        if (j11 <= 0) {
            o.h("MatroskaExtractor", "Discarding last cue point with unexpected duration: " + j11);
            iArrCopyOf = Arrays.copyOf(iArrCopyOf, i11);
            jArrCopyOf = Arrays.copyOf(jArrCopyOf, i11);
            jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i11);
            jArrCopyOf3 = Arrays.copyOf(jArrCopyOf3, i11);
        }
        return new h(iArrCopyOf, jArrCopyOf, jArrCopyOf2, jArrCopyOf3);
    }

    public final void n(c cVar, long j11, int i11, int i12, int i13) {
        s0 s0Var = cVar.U;
        if (s0Var != null) {
            s0Var.c(cVar.Y, j11, i11, i12, i13, cVar.f67913j);
        } else {
            if ("S_TEXT/UTF8".equals(cVar.f67905b) || "S_TEXT/ASS".equals(cVar.f67905b) || "S_TEXT/WEBVTT".equals(cVar.f67905b)) {
                if (this.M > 1) {
                    o.h("MatroskaExtractor", "Skipping subtitle sample in laced block.");
                } else {
                    long j12 = this.K;
                    if (j12 == C.TIME_UNSET) {
                        o.h("MatroskaExtractor", "Skipping subtitle sample with no duration.");
                    } else {
                        F(cVar.f67905b, j12, this.f67889m.e());
                        for (int iF = this.f67889m.f(); iF < this.f67889m.g(); iF++) {
                            if (this.f67889m.e()[iF] == 0) {
                                this.f67889m.T(iF);
                                break;
                            }
                        }
                        r0 r0Var = cVar.Y;
                        c0 c0Var = this.f67889m;
                        r0Var.c(c0Var, c0Var.g());
                        i12 += this.f67889m.g();
                    }
                }
            }
            if ((268435456 & i11) != 0) {
                if (this.M > 1) {
                    this.f67892p.Q(0);
                } else {
                    int iG = this.f67892p.g();
                    cVar.Y.a(this.f67892p, iG, 2);
                    i12 += iG;
                }
            }
            cVar.Y.f(j11, i11, i12, i13, cVar.f67913j);
        }
        this.H = true;
    }

    @CallSuper
    public void o(int i11) throws ParserException {
        k();
        if (i11 == 160) {
            if (this.I != 2) {
                return;
            }
            c cVar = this.f67877c.get(this.O);
            cVar.f();
            if (this.T > 0 && "A_OPUS".equals(cVar.f67905b)) {
                this.f67892p.R(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.T).array());
            }
            int i12 = 0;
            for (int i13 = 0; i13 < this.M; i13++) {
                i12 += this.N[i13];
            }
            int i14 = 0;
            while (i14 < this.M) {
                long j11 = this.J + ((long) ((cVar.f67908e * i14) / 1000));
                int i15 = this.Q;
                if (i14 == 0 && !this.S) {
                    i15 |= 1;
                }
                int i16 = this.N[i14];
                int i17 = i12 - i16;
                n(cVar, j11, i15, i16, i17);
                i14++;
                i12 = i17;
            }
            this.I = 0;
            return;
        }
        if (i11 == 174) {
            c cVar2 = (c) z3.a.i(this.f67899w);
            String str = cVar2.f67905b;
            if (str == null) {
                throw ParserException.createForMalformedContainer("CodecId is missing in TrackEntry element", null);
            }
            if (y(str)) {
                cVar2.i(this.f67880d0, cVar2.f67906c);
                this.f67877c.put(cVar2.f67906c, cVar2);
            }
            this.f67899w = null;
            return;
        }
        if (i11 == 19899) {
            int i18 = this.f67901y;
            if (i18 != -1) {
                long j12 = this.f67902z;
                if (j12 != -1) {
                    if (i18 == 475249515) {
                        this.B = j12;
                        return;
                    }
                    return;
                }
            }
            throw ParserException.createForMalformedContainer("Mandatory element SeekID or SeekPosition not found", null);
        }
        if (i11 == 25152) {
            j(i11);
            c cVar3 = this.f67899w;
            if (cVar3.f67911h) {
                if (cVar3.f67913j == null) {
                    throw ParserException.createForMalformedContainer("Encrypted Track found but ContentEncKeyID was not found", null);
                }
                cVar3.f67915l = new DrmInitData(new DrmInitData.SchemeData(j.f9251a, MimeTypes.VIDEO_WEBM, this.f67899w.f67913j.f78381b));
                return;
            }
            return;
        }
        if (i11 == 28032) {
            j(i11);
            c cVar4 = this.f67899w;
            if (cVar4.f67911h && cVar4.f67912i != null) {
                throw ParserException.createForMalformedContainer("Combining encryption and compression is not supported", null);
            }
            return;
        }
        if (i11 == 357149030) {
            if (this.f67896t == C.TIME_UNSET) {
                this.f67896t = 1000000L;
            }
            long j13 = this.f67897u;
            if (j13 != C.TIME_UNSET) {
                this.f67898v = E(j13);
                return;
            }
            return;
        }
        if (i11 == 374648427) {
            if (this.f67877c.size() == 0) {
                throw ParserException.createForMalformedContainer("No valid tracks were found", null);
            }
            this.f67880d0.endTracks();
        } else {
            if (i11 != 475249515) {
                return;
            }
            if (!this.f67900x) {
                this.f67880d0.f(m(this.E, this.F));
                this.f67900x = true;
            }
            this.E = null;
            this.F = null;
        }
    }

    public final int q() {
        int i11 = this.V;
        D();
        return i11;
    }

    @CallSuper
    public void r(int i11, double d11) throws ParserException {
        if (i11 == 181) {
            t(i11).R = (int) d11;
        }
        if (i11 == 17545) {
            this.f67897u = (long) d11;
            return;
        }
        switch (i11) {
            case 21969:
                t(i11).E = (float) d11;
                break;
            case 21970:
                t(i11).F = (float) d11;
                break;
            case 21971:
                t(i11).G = (float) d11;
                break;
            case 21972:
                t(i11).H = (float) d11;
                break;
            case 21973:
                t(i11).I = (float) d11;
                break;
            case 21974:
                t(i11).J = (float) d11;
                break;
            case 21975:
                t(i11).K = (float) d11;
                break;
            case 21976:
                t(i11).L = (float) d11;
                break;
            case 21977:
                t(i11).M = (float) d11;
                break;
            case 21978:
                t(i11).N = (float) d11;
                break;
            default:
                switch (i11) {
                    case 30323:
                        t(i11).f67923t = (float) d11;
                        break;
                    case 30324:
                        t(i11).f67924u = (float) d11;
                        break;
                    case 30325:
                        t(i11).f67925v = (float) d11;
                        break;
                }
                break;
        }
    }

    @Override // u4.s
    public final void release() {
    }

    @Override // u4.s
    @CallSuper
    public void seek(long j11, long j12) {
        this.D = C.TIME_UNSET;
        this.I = 0;
        this.f67873a.reset();
        this.f67875b.e();
        D();
        for (int i11 = 0; i11 < this.f67877c.size(); i11++) {
            this.f67877c.valueAt(i11).n();
        }
    }

    public c t(int i11) throws ParserException {
        j(i11);
        return this.f67899w;
    }

    @CallSuper
    public int u(int i11) {
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
            case 21938:
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

    public void v(c cVar, t tVar, int i11) throws IOException {
        if (cVar.f67910g != 1685485123 && cVar.f67910g != 1685480259) {
            tVar.skipFully(i11);
            return;
        }
        byte[] bArr = new byte[i11];
        cVar.O = bArr;
        tVar.readFully(bArr, 0, i11);
    }

    public void w(c cVar, int i11, t tVar, int i12) throws IOException {
        if (i11 != 4 || !"V_VP9".equals(cVar.f67905b)) {
            tVar.skipFully(i12);
        } else {
            this.f67892p.Q(i12);
            tVar.readFully(this.f67892p.e(), 0, i12);
        }
    }

    @CallSuper
    public void x(int i11, long j11) throws ParserException {
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
                t(i11).f67907d = (int) j11;
                return;
            case 136:
                t(i11).W = j11 == 1;
                return;
            case 155:
                this.K = E(j11);
                return;
            case 159:
                t(i11).P = (int) j11;
                return;
            case 176:
                t(i11).f67916m = (int) j11;
                return;
            case 179:
                i(i11);
                this.E.a(E(j11));
                return;
            case 186:
                t(i11).f67917n = (int) j11;
                return;
            case 215:
                t(i11).f67906c = (int) j11;
                return;
            case 231:
                this.D = E(j11);
                return;
            case 238:
                this.R = (int) j11;
                return;
            case 241:
                if (this.G) {
                    return;
                }
                i(i11);
                this.F.a(j11);
                this.G = true;
                return;
            case 251:
                this.S = true;
                return;
            case 16871:
                t(i11).f67910g = (int) j11;
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
                this.f67902z = j11 + this.f67895s;
                return;
            case 21432:
                int i12 = (int) j11;
                j(i11);
                if (i12 == 0) {
                    this.f67899w.f67927x = 0;
                    return;
                }
                if (i12 == 1) {
                    this.f67899w.f67927x = 2;
                    return;
                } else if (i12 == 3) {
                    this.f67899w.f67927x = 1;
                    return;
                } else {
                    if (i12 != 15) {
                        return;
                    }
                    this.f67899w.f67927x = 3;
                    return;
                }
            case 21680:
                t(i11).f67919p = (int) j11;
                return;
            case 21682:
                t(i11).f67921r = (int) j11;
                return;
            case 21690:
                t(i11).f67920q = (int) j11;
                return;
            case 21930:
                t(i11).V = j11 == 1;
                return;
            case 21938:
                j(i11);
                c cVar = this.f67899w;
                cVar.f67928y = true;
                cVar.f67918o = (int) j11;
                return;
            case 21998:
                t(i11).f67909f = (int) j11;
                return;
            case 22186:
                t(i11).S = j11;
                return;
            case 22203:
                t(i11).T = j11;
                return;
            case 25188:
                t(i11).Q = (int) j11;
                return;
            case 30114:
                this.T = j11;
                return;
            case 30321:
                j(i11);
                int i13 = (int) j11;
                if (i13 == 0) {
                    this.f67899w.f67922s = 0;
                    return;
                }
                if (i13 == 1) {
                    this.f67899w.f67922s = 1;
                    return;
                } else if (i13 == 2) {
                    this.f67899w.f67922s = 2;
                    return;
                } else {
                    if (i13 != 3) {
                        return;
                    }
                    this.f67899w.f67922s = 3;
                    return;
                }
            case 2352003:
                t(i11).f67908e = (int) j11;
                return;
            case 2807729:
                this.f67896t = j11;
                return;
            default:
                switch (i11) {
                    case 21945:
                        j(i11);
                        int i14 = (int) j11;
                        if (i14 == 1) {
                            this.f67899w.B = 2;
                            return;
                        } else {
                            if (i14 != 2) {
                                return;
                            }
                            this.f67899w.B = 1;
                            return;
                        }
                    case 21946:
                        j(i11);
                        int iM = k.m((int) j11);
                        if (iM != -1) {
                            this.f67899w.A = iM;
                            return;
                        }
                        return;
                    case 21947:
                        j(i11);
                        this.f67899w.f67928y = true;
                        int iL = k.l((int) j11);
                        if (iL != -1) {
                            this.f67899w.f67929z = iL;
                            return;
                        }
                        return;
                    case 21948:
                        t(i11).C = (int) j11;
                        return;
                    case 21949:
                        t(i11).D = (int) j11;
                        return;
                    default:
                        return;
                }
        }
    }

    @CallSuper
    public boolean z(int i11) {
        return i11 == 357149030 || i11 == 524531317 || i11 == 475249515 || i11 == 374648427;
    }
}
