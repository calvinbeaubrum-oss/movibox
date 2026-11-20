package wh;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.MotionEventCompat;
import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.s;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.tn.lib.view.FlowLayout;
import com.transsion.gslb.Worker;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.internal.ws.WebSocketProtocol;
import vh.i;
import vh.m;
import vh.n;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a extends e {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f79437h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f79438i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f79439j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f79440k;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public List<vh.b> f79443n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    public List<vh.b> f79444o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f79445p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f79446q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f79447r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f79448s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public byte f79449t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public byte f79450u;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f79452w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f79453x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int[] f79434y = {11, 1, 3, 12, 14, 5, 7, 9};

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int[] f79435z = {0, 4, 8, 12, 16, 20, 24, 28};
    public static final int[] A = {-1, -16711936, -16776961, -16711681, FlowLayout.SPACING_AUTO, InputDeviceCompat.SOURCE_ANY, -65281};
    public static final int[] B = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, Worker.WHAT_SYNC_DATA, 104, 105, 106, 107, 108, 109, Worker.WHAT_QUIT, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632};
    public static final int[] C = {174, 176, PsExtractor.PRIVATE_STREAM_1, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251};
    public static final int[] D = {193, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, PsExtractor.AUDIO_STREAM, 194, 199, 200, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, 171, 187};
    public static final int[] E = {195, 227, 205, 204, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, WebSocketProtocol.PAYLOAD_SHORT, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496};
    public static final boolean[] F = {false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c0 f79436g = new c0();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList<C0889a> f79441l = new ArrayList<>();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public C0889a f79442m = new C0889a(0, 4);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f79451v = 0;

    /* JADX INFO: renamed from: wh.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0889a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<C0890a> f79454a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<SpannableString> f79455b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final StringBuilder f79456c = new StringBuilder();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f79457d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f79458e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f79459f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f79460g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f79461h;

        /* JADX INFO: renamed from: wh.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public static class C0890a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f79462a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final boolean f79463b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f79464c;

            public C0890a(int i11, boolean z11, int i12) {
                this.f79462a = i11;
                this.f79463b = z11;
                this.f79464c = i12;
            }
        }

        public C0889a(int i11, int i12) {
            j(i11);
            this.f79461h = i12;
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
            if (this.f79456c.length() < 32) {
                this.f79456c.append(c11);
            }
        }

        public void f() {
            int length = this.f79456c.length();
            if (length > 0) {
                this.f79456c.delete(length - 1, length);
                for (int size = this.f79454a.size() - 1; size >= 0; size--) {
                    C0890a c0890a = this.f79454a.get(size);
                    int i11 = c0890a.f79464c;
                    if (i11 != length) {
                        return;
                    }
                    c0890a.f79464c = i11 - 1;
                }
            }
        }

        @Nullable
        public vh.b g(int i11) {
            float f11;
            int i12 = this.f79458e + this.f79459f;
            int i13 = 32 - i12;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i14 = 0; i14 < this.f79455b.size(); i14++) {
                spannableStringBuilder.append(o0.d1(this.f79455b.get(i14), i13));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append(o0.d1(h(), i13));
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int length = i13 - spannableStringBuilder.length();
            int i15 = i12 - length;
            if (i11 == Integer.MIN_VALUE) {
                i11 = (this.f79460g != 2 || (Math.abs(i15) >= 3 && length >= 0)) ? (this.f79460g != 2 || i15 <= 0) ? 0 : 2 : 1;
            }
            if (i11 != 1) {
                if (i11 == 2) {
                    i12 = 32 - length;
                }
                f11 = ((i12 / 32.0f) * 0.8f) + 0.1f;
            } else {
                f11 = 0.5f;
            }
            int i16 = this.f79457d;
            if (i16 > 7) {
                i16 -= 17;
            } else if (this.f79460g == 1) {
                i16 -= this.f79461h - 1;
            }
            return new vh.b.C0875b().o(spannableStringBuilder).p(Layout.Alignment.ALIGN_NORMAL).h(i16, 1).k(f11).l(i11).a();
        }

        public final SpannableString h() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f79456c);
            int length = spannableStringBuilder.length();
            int i11 = 0;
            int i12 = -1;
            int i13 = -1;
            int i14 = 0;
            int i15 = -1;
            int i16 = -1;
            boolean z11 = false;
            while (i11 < this.f79454a.size()) {
                C0890a c0890a = this.f79454a.get(i11);
                boolean z12 = c0890a.f79463b;
                int i17 = c0890a.f79462a;
                if (i17 != 8) {
                    boolean z13 = i17 == 7;
                    if (i17 != 7) {
                        i16 = a.A[i17];
                    }
                    z11 = z13;
                }
                int i18 = c0890a.f79464c;
                i11++;
                if (i18 != (i11 < this.f79454a.size() ? this.f79454a.get(i11).f79464c : length)) {
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
            return this.f79454a.isEmpty() && this.f79455b.isEmpty() && this.f79456c.length() == 0;
        }

        public void j(int i11) {
            this.f79460g = i11;
            this.f79454a.clear();
            this.f79455b.clear();
            this.f79456c.setLength(0);
            this.f79457d = 15;
            this.f79458e = 0;
            this.f79459f = 0;
        }

        public void k() {
            this.f79455b.add(h());
            this.f79456c.setLength(0);
            this.f79454a.clear();
            int iMin = Math.min(this.f79461h, this.f79457d);
            while (this.f79455b.size() >= iMin) {
                this.f79455b.remove(0);
            }
        }

        public void l(int i11) {
            this.f79460g = i11;
        }

        public void m(int i11) {
            this.f79461h = i11;
        }

        public void p(int i11, boolean z11) {
            this.f79454a.add(new C0890a(i11, z11, this.f79456c.length()));
        }
    }

    public a(String str, int i11, long j11) {
        this.f79440k = j11 > 0 ? j11 * 1000 : -9223372036854775807L;
        this.f79437h = MimeTypes.APPLICATION_MP4CEA608.equals(str) ? 2 : 3;
        if (i11 == 1) {
            this.f79439j = 0;
            this.f79438i = 0;
        } else if (i11 == 2) {
            this.f79439j = 1;
            this.f79438i = 0;
        } else if (i11 == 3) {
            this.f79439j = 0;
            this.f79438i = 1;
        } else if (i11 != 4) {
            s.i("Cea608Decoder", "Invalid channel. Defaulting to CC1.");
            this.f79439j = 0;
            this.f79438i = 0;
        } else {
            this.f79439j = 1;
            this.f79438i = 1;
        }
        I(0);
        H();
        this.f79452w = true;
        this.f79453x = C.TIME_UNSET;
    }

    public static boolean A(byte b11) {
        return (b11 & 240) == 16;
    }

    public static boolean C(byte b11) {
        return (b11 & 247) == 20;
    }

    public static boolean D(byte b11, byte b12) {
        return (b11 & 247) == 17 && (b12 & 240) == 48;
    }

    public static boolean E(byte b11, byte b12) {
        return (b11 & 247) == 23 && b12 >= 33 && b12 <= 35;
    }

    public static boolean F(byte b11) {
        return 1 <= b11 && b11 <= 15;
    }

    public static char l(byte b11) {
        return (char) B[(b11 & Ascii.DEL) - 32];
    }

    public static int m(byte b11) {
        return (b11 >> 3) & 1;
    }

    public static char o(byte b11) {
        return (char) D[b11 & Ascii.US];
    }

    public static char p(byte b11) {
        return (char) E[b11 & Ascii.US];
    }

    public static char q(byte b11, byte b12) {
        return (b11 & 1) == 0 ? o(b12) : p(b12);
    }

    public static char r(byte b11) {
        return (char) C[b11 & Ascii.SI];
    }

    public static boolean v(byte b11) {
        return (b11 & 224) == 0;
    }

    public static boolean w(byte b11, byte b12) {
        return (b11 & 246) == 18 && (b12 & 224) == 32;
    }

    public static boolean x(byte b11, byte b12) {
        return (b11 & 247) == 17 && (b12 & 240) == 32;
    }

    public static boolean y(byte b11, byte b12) {
        return (b11 & 246) == 20 && (b12 & 240) == 32;
    }

    public static boolean z(byte b11, byte b12) {
        return (b11 & 240) == 16 && (b12 & 192) == 64;
    }

    public final boolean B(boolean z11, byte b11, byte b12) {
        if (!z11 || !A(b11)) {
            this.f79448s = false;
        } else {
            if (this.f79448s && this.f79449t == b11 && this.f79450u == b12) {
                this.f79448s = false;
                return true;
            }
            this.f79448s = true;
            this.f79449t = b11;
            this.f79450u = b12;
        }
        return false;
    }

    public final void G(byte b11, byte b12) {
        if (F(b11)) {
            this.f79452w = false;
            return;
        }
        if (C(b11)) {
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
                                this.f79452w = false;
                                break;
                        }
                }
            }
            this.f79452w = true;
        }
    }

    public final void H() {
        this.f79442m.j(this.f79445p);
        this.f79441l.clear();
        this.f79441l.add(this.f79442m);
    }

    public final void I(int i11) {
        int i12 = this.f79445p;
        if (i12 == i11) {
            return;
        }
        this.f79445p = i11;
        if (i11 == 3) {
            for (int i13 = 0; i13 < this.f79441l.size(); i13++) {
                this.f79441l.get(i13).l(i11);
            }
            return;
        }
        H();
        if (i12 == 3 || i11 == 1 || i11 == 0) {
            this.f79443n = Collections.emptyList();
        }
    }

    public final void J(int i11) {
        this.f79446q = i11;
        this.f79442m.m(i11);
    }

    public final boolean K() {
        return (this.f79440k == C.TIME_UNSET || this.f79453x == C.TIME_UNSET || f() - this.f79453x < this.f79440k) ? false : true;
    }

    public final boolean L(byte b11) {
        if (v(b11)) {
            this.f79451v = m(b11);
        }
        return this.f79451v == this.f79439j;
    }

    @Override // wh.e
    public i a() {
        List<vh.b> list = this.f79443n;
        this.f79444o = list;
        return new f((List) com.google.android.exoplayer2.util.a.e(list));
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0064  */
    @Override // wh.e
    public void b(m mVar) {
        boolean z11;
        ByteBuffer byteBuffer = (ByteBuffer) com.google.android.exoplayer2.util.a.e(mVar.f33030c);
        this.f79436g.N(byteBuffer.array(), byteBuffer.limit());
        boolean z12 = false;
        while (true) {
            int iA = this.f79436g.a();
            int i11 = this.f79437h;
            if (iA < i11) {
                break;
            }
            byte bD = i11 == 2 ? (byte) -4 : (byte) this.f79436g.D();
            int iD = this.f79436g.D();
            int iD2 = this.f79436g.D();
            if ((bD & 2) == 0 && (bD & 1) == this.f79438i) {
                byte b11 = (byte) (iD & 127);
                byte b12 = (byte) (iD2 & 127);
                if (b11 != 0 || b12 != 0) {
                    boolean z13 = this.f79447r;
                    if ((bD & 4) == 4) {
                        boolean[] zArr = F;
                        if (zArr[iD] && zArr[iD2]) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                    } else {
                        z11 = false;
                    }
                    this.f79447r = z11;
                    if (!B(z11, b11, b12)) {
                        if (this.f79447r) {
                            G(b11, b12);
                            if (this.f79452w && L(b11)) {
                                if (!v(b11)) {
                                    this.f79442m.e(l(b11));
                                    if ((b12 & 224) != 0) {
                                        this.f79442m.e(l(b12));
                                    }
                                } else if (D(b11, b12)) {
                                    this.f79442m.e(r(b12));
                                } else if (w(b11, b12)) {
                                    this.f79442m.f();
                                    this.f79442m.e(q(b11, b12));
                                } else if (x(b11, b12)) {
                                    s(b12);
                                } else if (z(b11, b12)) {
                                    u(b11, b12);
                                } else if (E(b11, b12)) {
                                    this.f79442m.f79459f = b12 - 32;
                                } else if (y(b11, b12)) {
                                    t(b12);
                                }
                                z12 = true;
                            }
                        } else if (z13) {
                            H();
                            z12 = true;
                        }
                    }
                }
            }
        }
        if (z12) {
            int i12 = this.f79445p;
            if (i12 == 1 || i12 == 3) {
                this.f79443n = n();
                this.f79453x = f();
            }
        }
    }

    @Override // wh.e
    @Nullable
    /* JADX INFO: renamed from: c */
    public /* bridge */ /* synthetic */ m dequeueInputBuffer() throws SubtitleDecoderException {
        return super.dequeueInputBuffer();
    }

    @Override // wh.e, com.google.android.exoplayer2.decoder.d
    @Nullable
    /* JADX INFO: renamed from: d */
    public n dequeueOutputBuffer() throws SubtitleDecoderException {
        n nVarE;
        n nVarDequeueOutputBuffer = super.dequeueOutputBuffer();
        if (nVarDequeueOutputBuffer != null) {
            return nVarDequeueOutputBuffer;
        }
        if (!K() || (nVarE = e()) == null) {
            return null;
        }
        this.f79443n = Collections.emptyList();
        this.f79453x = C.TIME_UNSET;
        nVarE.n(f(), a(), Long.MAX_VALUE);
        return nVarE;
    }

    @Override // wh.e, com.google.android.exoplayer2.decoder.d
    public void flush() {
        super.flush();
        this.f79443n = null;
        this.f79444o = null;
        I(0);
        J(4);
        H();
        this.f79447r = false;
        this.f79448s = false;
        this.f79449t = (byte) 0;
        this.f79450u = (byte) 0;
        this.f79451v = 0;
        this.f79452w = true;
        this.f79453x = C.TIME_UNSET;
    }

    @Override // wh.e
    public boolean g() {
        return this.f79443n != this.f79444o;
    }

    @Override // wh.e
    /* JADX INFO: renamed from: h */
    public /* bridge */ /* synthetic */ void queueInputBuffer(m mVar) throws SubtitleDecoderException {
        super.queueInputBuffer(mVar);
    }

    public final List<vh.b> n() {
        int size = this.f79441l.size();
        ArrayList arrayList = new ArrayList(size);
        int iMin = 2;
        for (int i11 = 0; i11 < size; i11++) {
            vh.b bVarG = this.f79441l.get(i11).g(Integer.MIN_VALUE);
            arrayList.add(bVarG);
            if (bVarG != null) {
                iMin = Math.min(iMin, bVarG.f78826j);
            }
        }
        ArrayList arrayList2 = new ArrayList(size);
        for (int i12 = 0; i12 < size; i12++) {
            vh.b bVar = (vh.b) arrayList.get(i12);
            if (bVar != null) {
                if (bVar.f78826j != iMin) {
                    bVar = (vh.b) com.google.android.exoplayer2.util.a.e(this.f79441l.get(i12).g(iMin));
                }
                arrayList2.add(bVar);
            }
        }
        return arrayList2;
    }

    @Override // wh.e, com.google.android.exoplayer2.decoder.d
    public void release() {
    }

    public final void s(byte b11) {
        this.f79442m.e(' ');
        this.f79442m.p((b11 >> 1) & 7, (b11 & 1) == 1);
    }

    @Override // wh.e, vh.j
    public /* bridge */ /* synthetic */ void setPositionUs(long j11) {
        super.setPositionUs(j11);
    }

    public final void t(byte b11) {
        if (b11 == 32) {
            I(2);
            return;
        }
        if (b11 == 41) {
            I(3);
            return;
        }
        switch (b11) {
            case 37:
                I(1);
                J(2);
                break;
            case 38:
                I(1);
                J(3);
                break;
            case 39:
                I(1);
                J(4);
                break;
            default:
                int i11 = this.f79445p;
                if (i11 != 0) {
                    if (b11 != 33) {
                        switch (b11) {
                            case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                                this.f79443n = Collections.emptyList();
                                int i12 = this.f79445p;
                                if (i12 == 1 || i12 == 3) {
                                    H();
                                }
                                break;
                            case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                                if (i11 == 1 && !this.f79442m.i()) {
                                    this.f79442m.k();
                                    break;
                                }
                                break;
                            case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                                H();
                                break;
                            case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                                this.f79443n = n();
                                H();
                                break;
                        }
                    } else {
                        this.f79442m.f();
                        break;
                    }
                }
                break;
        }
    }

    public final void u(byte b11, byte b12) {
        int i11 = f79434y[b11 & 7];
        if ((b12 & 32) != 0) {
            i11++;
        }
        if (i11 != this.f79442m.f79457d) {
            if (this.f79445p != 1 && !this.f79442m.i()) {
                C0889a c0889a = new C0889a(this.f79445p, this.f79446q);
                this.f79442m = c0889a;
                this.f79441l.add(c0889a);
            }
            this.f79442m.f79457d = i11;
        }
        boolean z11 = (b12 & Ascii.DLE) == 16;
        boolean z12 = (b12 & 1) == 1;
        int i12 = (b12 >> 1) & 7;
        this.f79442m.p(z11 ? 8 : i12, z12);
        if (z11) {
            this.f79442m.f79458e = f79435z[i12];
        }
    }
}
