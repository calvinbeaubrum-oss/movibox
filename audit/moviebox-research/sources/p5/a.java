package p5;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.MotionEventCompat;
import androidx.media3.extractor.text.SubtitleDecoderException;
import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.tn.lib.view.FlowLayout;
import com.transsion.gslb.Worker;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import o5.k;
import o5.p;
import okhttp3.internal.ws.WebSocketProtocol;
import z3.c0;
import z3.o;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends e {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f73623h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f73624i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f73625j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f73626k;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public List<y3.a> f73629n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    public List<y3.a> f73630o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f73631p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f73632q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f73633r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f73634s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public byte f73635t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public byte f73636u;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f73638w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f73639x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int[] f73620y = {11, 1, 3, 12, 14, 5, 7, 9};

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int[] f73621z = {0, 4, 8, 12, 16, 20, 24, 28};
    public static final int[] A = {-1, -16711936, -16776961, -16711681, FlowLayout.SPACING_AUTO, InputDeviceCompat.SOURCE_ANY, -65281};
    public static final int[] B = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, Worker.WHAT_SYNC_DATA, 104, 105, 106, 107, 108, 109, Worker.WHAT_QUIT, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632};
    public static final int[] C = {174, 176, PsExtractor.PRIVATE_STREAM_1, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251};
    public static final int[] D = {193, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, PsExtractor.AUDIO_STREAM, 194, 199, 200, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, 171, 187};
    public static final int[] E = {195, 227, 205, 204, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, WebSocketProtocol.PAYLOAD_SHORT, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496};
    public static final boolean[] F = {false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c0 f73622g = new c0();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList<C0797a> f73627l = new ArrayList<>();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public C0797a f73628m = new C0797a(0, 4);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f73637v = 0;

    /* JADX INFO: renamed from: p5.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0797a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<C0798a> f73640a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<SpannableString> f73641b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final StringBuilder f73642c = new StringBuilder();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f73643d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f73644e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f73645f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f73646g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f73647h;

        /* JADX INFO: renamed from: p5.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public static class C0798a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f73648a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final boolean f73649b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f73650c;

            public C0798a(int i11, boolean z11, int i12) {
                this.f73648a = i11;
                this.f73649b = z11;
                this.f73650c = i12;
            }
        }

        public C0797a(int i11, int i12) {
            j(i11);
            this.f73647h = i12;
        }

        public static void n(SpannableStringBuilder spannableStringBuilder, int i11, int i12, int i13) {
            if (i13 == -1) {
                return;
            }
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i13), i11, i12, 33);
        }

        public static void o(SpannableStringBuilder spannableStringBuilder, int i11, int i12) {
            spannableStringBuilder.setSpan(new StyleSpan(2), i11, i12, 33);
        }

        public static void q(SpannableStringBuilder spannableStringBuilder, int i11, int i12) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i11, i12, 33);
        }

        public void e(char c11) {
            if (this.f73642c.length() < 32) {
                this.f73642c.append(c11);
            }
        }

        public void f() {
            int length = this.f73642c.length();
            if (length > 0) {
                this.f73642c.delete(length - 1, length);
                for (int size = this.f73640a.size() - 1; size >= 0; size--) {
                    C0798a c0798a = this.f73640a.get(size);
                    int i11 = c0798a.f73650c;
                    if (i11 != length) {
                        return;
                    }
                    c0798a.f73650c = i11 - 1;
                }
            }
        }

        @Nullable
        public y3.a g(int i11) {
            float f11;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i12 = 0; i12 < this.f73641b.size(); i12++) {
                spannableStringBuilder.append((CharSequence) this.f73641b.get(i12));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append((CharSequence) h());
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int i13 = this.f73644e + this.f73645f;
            int length = (32 - i13) - spannableStringBuilder.length();
            int i14 = i13 - length;
            if (i11 == Integer.MIN_VALUE) {
                i11 = (this.f73646g != 2 || (Math.abs(i14) >= 3 && length >= 0)) ? (this.f73646g != 2 || i14 <= 0) ? 0 : 2 : 1;
            }
            if (i11 != 1) {
                if (i11 == 2) {
                    i13 = 32 - length;
                }
                f11 = ((i13 / 32.0f) * 0.8f) + 0.1f;
            } else {
                f11 = 0.5f;
            }
            int i15 = this.f73643d;
            if (i15 > 7) {
                i15 -= 17;
            } else if (this.f73646g == 1) {
                i15 -= this.f73647h - 1;
            }
            return new y3.a.b().o(spannableStringBuilder).p(Layout.Alignment.ALIGN_NORMAL).h(i15, 1).k(f11).l(i11).a();
        }

        public final SpannableString h() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f73642c);
            int length = spannableStringBuilder.length();
            int i11 = 0;
            int i12 = -1;
            int i13 = -1;
            int i14 = 0;
            int i15 = -1;
            int i16 = -1;
            boolean z11 = false;
            while (i11 < this.f73640a.size()) {
                C0798a c0798a = this.f73640a.get(i11);
                boolean z12 = c0798a.f73649b;
                int i17 = c0798a.f73648a;
                if (i17 != 8) {
                    boolean z13 = i17 == 7;
                    if (i17 != 7) {
                        i16 = a.A[i17];
                    }
                    z11 = z13;
                }
                int i18 = c0798a.f73650c;
                i11++;
                if (i18 != (i11 < this.f73640a.size() ? this.f73640a.get(i11).f73650c : length)) {
                    if (i12 != -1 && !z12) {
                        q(spannableStringBuilder, i12, i18);
                        i12 = -1;
                    } else if (i12 == -1 && z12) {
                        i12 = i18;
                    }
                    if (i13 != -1 && !z11) {
                        o(spannableStringBuilder, i13, i18);
                        i13 = -1;
                    } else if (i13 == -1 && z11) {
                        i13 = i18;
                    }
                    if (i16 != i15) {
                        n(spannableStringBuilder, i14, i18, i15);
                        i15 = i16;
                        i14 = i18;
                    }
                }
            }
            if (i12 != -1 && i12 != length) {
                q(spannableStringBuilder, i12, length);
            }
            if (i13 != -1 && i13 != length) {
                o(spannableStringBuilder, i13, length);
            }
            if (i14 != length) {
                n(spannableStringBuilder, i14, length, i15);
            }
            return new SpannableString(spannableStringBuilder);
        }

        public boolean i() {
            return this.f73640a.isEmpty() && this.f73641b.isEmpty() && this.f73642c.length() == 0;
        }

        public void j(int i11) {
            this.f73646g = i11;
            this.f73640a.clear();
            this.f73641b.clear();
            this.f73642c.setLength(0);
            this.f73643d = 15;
            this.f73644e = 0;
            this.f73645f = 0;
        }

        public void k() {
            this.f73641b.add(h());
            this.f73642c.setLength(0);
            this.f73640a.clear();
            int iMin = Math.min(this.f73647h, this.f73643d);
            while (this.f73641b.size() >= iMin) {
                this.f73641b.remove(0);
            }
        }

        public void l(int i11) {
            this.f73646g = i11;
        }

        public void m(int i11) {
            this.f73647h = i11;
        }

        public void p(int i11, boolean z11) {
            this.f73640a.add(new C0798a(i11, z11, this.f73642c.length()));
        }
    }

    public a(String str, int i11, long j11) {
        this.f73626k = j11 > 0 ? j11 * 1000 : -9223372036854775807L;
        this.f73623h = MimeTypes.APPLICATION_MP4CEA608.equals(str) ? 2 : 3;
        if (i11 == 1) {
            this.f73625j = 0;
            this.f73624i = 0;
        } else if (i11 == 2) {
            this.f73625j = 1;
            this.f73624i = 0;
        } else if (i11 == 3) {
            this.f73625j = 0;
            this.f73624i = 1;
        } else if (i11 != 4) {
            o.h("Cea608Decoder", "Invalid channel. Defaulting to CC1.");
            this.f73625j = 0;
            this.f73624i = 0;
        } else {
            this.f73625j = 1;
            this.f73624i = 1;
        }
        K(0);
        J();
        this.f73638w = true;
        this.f73639x = C.TIME_UNSET;
    }

    public static boolean A(byte b11, byte b12) {
        return (b11 & 246) == 20 && (b12 & 240) == 32;
    }

    public static boolean B(byte b11, byte b12) {
        return (b11 & 240) == 16 && (b12 & 192) == 64;
    }

    public static boolean C(byte b11) {
        return (b11 & 240) == 16;
    }

    public static boolean E(byte b11) {
        return (b11 & 246) == 20;
    }

    public static boolean F(byte b11, byte b12) {
        return (b11 & 247) == 17 && (b12 & 240) == 48;
    }

    public static boolean G(byte b11, byte b12) {
        return (b11 & 247) == 23 && b12 >= 33 && b12 <= 35;
    }

    public static boolean H(byte b11) {
        return 1 <= b11 && b11 <= 15;
    }

    public static char n(byte b11) {
        return (char) B[(b11 & Ascii.DEL) - 32];
    }

    public static int o(byte b11) {
        return (b11 >> 3) & 1;
    }

    public static char q(byte b11) {
        return (char) D[b11 & Ascii.US];
    }

    public static char r(byte b11) {
        return (char) E[b11 & Ascii.US];
    }

    public static char s(byte b11, byte b12) {
        return (b11 & 1) == 0 ? q(b12) : r(b12);
    }

    public static char t(byte b11) {
        return (char) C[b11 & Ascii.SI];
    }

    public static boolean x(byte b11) {
        return (b11 & 224) == 0;
    }

    public static boolean y(byte b11, byte b12) {
        return (b11 & 246) == 18 && (b12 & 224) == 32;
    }

    public static boolean z(byte b11, byte b12) {
        return (b11 & 247) == 17 && (b12 & 240) == 32;
    }

    public final boolean D(boolean z11, byte b11, byte b12) {
        if (!z11 || !C(b11)) {
            this.f73634s = false;
        } else {
            if (this.f73634s && this.f73635t == b11 && this.f73636u == b12) {
                this.f73634s = false;
                return true;
            }
            this.f73634s = true;
            this.f73635t = b11;
            this.f73636u = b12;
        }
        return false;
    }

    public final void I(byte b11, byte b12) {
        if (H(b11)) {
            this.f73638w = false;
            return;
        }
        if (E(b11)) {
            if (b12 != 32 && b12 != 47) {
                switch (b12) {
                    case 37:
                    case 38:
                    case 39:
                        break;
                    default:
                        switch (b12) {
                            case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                            case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                                this.f73638w = false;
                                break;
                        }
                }
            }
            this.f73638w = true;
        }
    }

    public final void J() {
        this.f73628m.j(this.f73631p);
        this.f73627l.clear();
        this.f73627l.add(this.f73628m);
    }

    public final void K(int i11) {
        int i12 = this.f73631p;
        if (i12 == i11) {
            return;
        }
        this.f73631p = i11;
        if (i11 == 3) {
            for (int i13 = 0; i13 < this.f73627l.size(); i13++) {
                this.f73627l.get(i13).l(i11);
            }
            return;
        }
        J();
        if (i12 == 3 || i11 == 1 || i11 == 0) {
            this.f73629n = Collections.emptyList();
        }
    }

    public final void L(int i11) {
        this.f73632q = i11;
        this.f73628m.m(i11);
    }

    public final boolean M() {
        return (this.f73626k == C.TIME_UNSET || this.f73639x == C.TIME_UNSET || h() - this.f73639x < this.f73626k) ? false : true;
    }

    public final boolean N(byte b11) {
        if (x(b11)) {
            this.f73637v = o(b11);
        }
        return this.f73637v == this.f73625j;
    }

    @Override // p5.e
    public k c() {
        List<y3.a> list = this.f73629n;
        this.f73630o = list;
        return new f((List) z3.a.e(list));
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0063  */
    @Override // p5.e
    public void d(o5.o oVar) {
        boolean z11;
        ByteBuffer byteBuffer = (ByteBuffer) z3.a.e(oVar.f9780c);
        this.f73622g.S(byteBuffer.array(), byteBuffer.limit());
        boolean z12 = false;
        while (true) {
            int iA = this.f73622g.a();
            int i11 = this.f73623h;
            if (iA < i11) {
                break;
            }
            int iH = i11 == 2 ? -4 : this.f73622g.H();
            int iH2 = this.f73622g.H();
            int iH3 = this.f73622g.H();
            if ((iH & 2) == 0 && (iH & 1) == this.f73624i) {
                byte b11 = (byte) (iH2 & 127);
                byte b12 = (byte) (iH3 & 127);
                if (b11 != 0 || b12 != 0) {
                    boolean z13 = this.f73633r;
                    if ((iH & 4) == 4) {
                        boolean[] zArr = F;
                        if (zArr[iH2] && zArr[iH3]) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                    } else {
                        z11 = false;
                    }
                    this.f73633r = z11;
                    if (!D(z11, b11, b12)) {
                        if (this.f73633r) {
                            I(b11, b12);
                            if (this.f73638w && N(b11)) {
                                if (!x(b11)) {
                                    this.f73628m.e(n(b11));
                                    if ((b12 & 224) != 0) {
                                        this.f73628m.e(n(b12));
                                    }
                                } else if (F(b11, b12)) {
                                    this.f73628m.e(t(b12));
                                } else if (y(b11, b12)) {
                                    this.f73628m.f();
                                    this.f73628m.e(s(b11, b12));
                                } else if (z(b11, b12)) {
                                    u(b12);
                                } else if (B(b11, b12)) {
                                    w(b11, b12);
                                } else if (G(b11, b12)) {
                                    this.f73628m.f73645f = b12 - 32;
                                } else if (A(b11, b12)) {
                                    v(b12);
                                }
                                z12 = true;
                            }
                        } else if (z13) {
                            J();
                            z12 = true;
                        }
                    }
                }
            }
        }
        if (z12) {
            int i12 = this.f73631p;
            if (i12 == 1 || i12 == 3) {
                this.f73629n = p();
                this.f73639x = h();
            }
        }
    }

    @Override // p5.e
    @Nullable
    /* JADX INFO: renamed from: e */
    public /* bridge */ /* synthetic */ o5.o dequeueInputBuffer() throws SubtitleDecoderException {
        return super.dequeueInputBuffer();
    }

    @Override // p5.e, androidx.media3.decoder.g
    @Nullable
    /* JADX INFO: renamed from: f */
    public p dequeueOutputBuffer() throws SubtitleDecoderException {
        p pVarG;
        p pVarDequeueOutputBuffer = super.dequeueOutputBuffer();
        if (pVarDequeueOutputBuffer != null) {
            return pVarDequeueOutputBuffer;
        }
        if (!M() || (pVarG = g()) == null) {
            return null;
        }
        this.f73629n = Collections.emptyList();
        this.f73639x = C.TIME_UNSET;
        pVarG.a(h(), c(), Long.MAX_VALUE);
        return pVarG;
    }

    @Override // p5.e, androidx.media3.decoder.g
    public void flush() {
        super.flush();
        this.f73629n = null;
        this.f73630o = null;
        K(0);
        L(4);
        J();
        this.f73633r = false;
        this.f73634s = false;
        this.f73635t = (byte) 0;
        this.f73636u = (byte) 0;
        this.f73637v = 0;
        this.f73638w = true;
        this.f73639x = C.TIME_UNSET;
    }

    @Override // androidx.media3.decoder.g
    public String getName() {
        return "Cea608Decoder";
    }

    @Override // p5.e
    public boolean i() {
        return this.f73629n != this.f73630o;
    }

    @Override // p5.e
    /* JADX INFO: renamed from: j */
    public /* bridge */ /* synthetic */ void queueInputBuffer(o5.o oVar) throws SubtitleDecoderException {
        super.queueInputBuffer(oVar);
    }

    public final List<y3.a> p() {
        int size = this.f73627l.size();
        ArrayList arrayList = new ArrayList(size);
        int iMin = 2;
        for (int i11 = 0; i11 < size; i11++) {
            y3.a aVarG = this.f73627l.get(i11).g(Integer.MIN_VALUE);
            arrayList.add(aVarG);
            if (aVarG != null) {
                iMin = Math.min(iMin, aVarG.f81117i);
            }
        }
        ArrayList arrayList2 = new ArrayList(size);
        for (int i12 = 0; i12 < size; i12++) {
            y3.a aVar = (y3.a) arrayList.get(i12);
            if (aVar != null) {
                if (aVar.f81117i != iMin) {
                    aVar = (y3.a) z3.a.e(this.f73627l.get(i12).g(iMin));
                }
                arrayList2.add(aVar);
            }
        }
        return arrayList2;
    }

    @Override // p5.e, androidx.media3.decoder.g
    public void release() {
    }

    @Override // p5.e, o5.l
    public /* bridge */ /* synthetic */ void setPositionUs(long j11) {
        super.setPositionUs(j11);
    }

    public final void u(byte b11) {
        this.f73628m.e(' ');
        this.f73628m.p((b11 >> 1) & 7, (b11 & 1) == 1);
    }

    public final void v(byte b11) {
        if (b11 == 32) {
            K(2);
            return;
        }
        if (b11 == 41) {
            K(3);
            return;
        }
        switch (b11) {
            case 37:
                K(1);
                L(2);
                break;
            case 38:
                K(1);
                L(3);
                break;
            case 39:
                K(1);
                L(4);
                break;
            default:
                int i11 = this.f73631p;
                if (i11 != 0) {
                    if (b11 != 33) {
                        switch (b11) {
                            case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                                this.f73629n = Collections.emptyList();
                                int i12 = this.f73631p;
                                if (i12 == 1 || i12 == 3) {
                                    J();
                                }
                                break;
                            case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                                if (i11 == 1 && !this.f73628m.i()) {
                                    this.f73628m.k();
                                    break;
                                }
                                break;
                            case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                                J();
                                break;
                            case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                                this.f73629n = p();
                                J();
                                break;
                        }
                    } else {
                        this.f73628m.f();
                        break;
                    }
                }
                break;
        }
    }

    public final void w(byte b11, byte b12) {
        int i11 = f73620y[b11 & 7];
        if ((b12 & 32) != 0) {
            i11++;
        }
        if (i11 != this.f73628m.f73643d) {
            if (this.f73631p != 1 && !this.f73628m.i()) {
                C0797a c0797a = new C0797a(this.f73631p, this.f73632q);
                this.f73628m = c0797a;
                this.f73627l.add(c0797a);
            }
            this.f73628m.f73643d = i11;
        }
        boolean z11 = (b12 & Ascii.DLE) == 16;
        boolean z12 = (b12 & 1) == 1;
        int i12 = (b12 >> 1) & 7;
        this.f73628m.p(z11 ? 8 : i12, z12);
        if (z11) {
            this.f73628m.f73644e = f73621z[i12];
        }
    }
}
