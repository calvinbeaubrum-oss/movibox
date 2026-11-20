package com.applovin.impl;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.MotionEventCompat;
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
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class y2 extends a3 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f24460h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f24461i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f24462j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final long f24463k;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private List f24466n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private List f24467o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f24468p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f24469q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f24470r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f24471s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private byte f24472t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private byte f24473u;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f24475w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private long f24476x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final int[] f24457y = {11, 1, 3, 12, 14, 5, 7, 9};

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final int[] f24458z = {0, 4, 8, 12, 16, 20, 24, 28};
    private static final int[] A = {-1, -16711936, -16776961, -16711681, FlowLayout.SPACING_AUTO, InputDeviceCompat.SOURCE_ANY, -65281};
    private static final int[] B = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, Worker.WHAT_SYNC_DATA, 104, 105, 106, 107, 108, 109, Worker.WHAT_QUIT, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632};
    private static final int[] C = {174, 176, PsExtractor.PRIVATE_STREAM_1, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251};
    private static final int[] D = {193, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, PsExtractor.AUDIO_STREAM, 194, 199, 200, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, 171, 187};
    private static final int[] E = {195, 227, 205, 204, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, WebSocketProtocol.PAYLOAD_SHORT, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496};
    private static final boolean[] F = {false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final bh f24459g = new bh();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final ArrayList f24464l = new ArrayList();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private a f24465m = new a(0, 4);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f24474v = 0;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f24477a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List f24478b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final StringBuilder f24479c = new StringBuilder();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f24480d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f24481e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f24482f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f24483g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f24484h;

        /* JADX INFO: renamed from: com.applovin.impl.y2$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public static class C0207a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f24485a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final boolean f24486b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f24487c;

            public C0207a(int i11, boolean z11, int i12) {
                this.f24485a = i11;
                this.f24486b = z11;
                this.f24487c = i12;
            }
        }

        public a(int i11, int i12) {
            b(i11);
            this.f24484h = i12;
        }

        private static void a(SpannableStringBuilder spannableStringBuilder, int i11, int i12) {
            spannableStringBuilder.setSpan(new StyleSpan(2), i11, i12, 33);
        }

        private static void a(SpannableStringBuilder spannableStringBuilder, int i11, int i12, int i13) {
            if (i13 == -1) {
                return;
            }
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i13), i11, i12, 33);
        }

        private SpannableString b() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f24479c);
            int length = spannableStringBuilder.length();
            int i11 = 0;
            int i12 = -1;
            int i13 = -1;
            int i14 = 0;
            int i15 = -1;
            boolean z11 = false;
            int i16 = -1;
            while (i11 < this.f24477a.size()) {
                C0207a c0207a = (C0207a) this.f24477a.get(i11);
                boolean z12 = c0207a.f24486b;
                int i17 = c0207a.f24485a;
                if (i17 != 8) {
                    boolean z13 = i17 == 7;
                    if (i17 != 7) {
                        i16 = y2.A[i17];
                    }
                    z11 = z13;
                }
                int i18 = c0207a.f24487c;
                i11++;
                if (i18 != (i11 < this.f24477a.size() ? ((C0207a) this.f24477a.get(i11)).f24487c : length)) {
                    if (i12 != -1 && !z12) {
                        b(spannableStringBuilder, i12, i18);
                        i12 = -1;
                    } else if (i12 == -1 && z12) {
                        i12 = i18;
                    }
                    if (i13 != -1 && !z11) {
                        a(spannableStringBuilder, i13, i18);
                        i13 = -1;
                    } else if (i13 == -1 && z11) {
                        i13 = i18;
                    }
                    if (i16 != i15) {
                        a(spannableStringBuilder, i14, i18, i15);
                        i15 = i16;
                        i14 = i18;
                    }
                }
            }
            if (i12 != -1 && i12 != length) {
                b(spannableStringBuilder, i12, length);
            }
            if (i13 != -1 && i13 != length) {
                a(spannableStringBuilder, i13, length);
            }
            if (i14 != length) {
                a(spannableStringBuilder, i14, length, i15);
            }
            return new SpannableString(spannableStringBuilder);
        }

        private static void b(SpannableStringBuilder spannableStringBuilder, int i11, int i12) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i11, i12, 33);
        }

        public b5 a(int i11) {
            float f11;
            int i12 = this.f24481e + this.f24482f;
            int i13 = 32 - i12;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i14 = 0; i14 < this.f24478b.size(); i14++) {
                spannableStringBuilder.append(xp.a((CharSequence) this.f24478b.get(i14), i13));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append(xp.a(b(), i13));
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int length = i13 - spannableStringBuilder.length();
            int i15 = i12 - length;
            if (i11 == Integer.MIN_VALUE) {
                i11 = (this.f24483g != 2 || (Math.abs(i15) >= 3 && length >= 0)) ? (this.f24483g != 2 || i15 <= 0) ? 0 : 2 : 1;
            }
            if (i11 != 1) {
                if (i11 == 2) {
                    i12 = 32 - length;
                }
                f11 = ((i12 / 32.0f) * 0.8f) + 0.1f;
            } else {
                f11 = 0.5f;
            }
            int i16 = this.f24480d;
            if (i16 > 7) {
                i16 -= 17;
            } else if (this.f24483g == 1) {
                i16 -= this.f24484h - 1;
            }
            return new b5.b().a(spannableStringBuilder).b(Layout.Alignment.ALIGN_NORMAL).a(i16, 1).b(f11).b(i11).a();
        }

        public void a() {
            int length = this.f24479c.length();
            if (length > 0) {
                this.f24479c.delete(length - 1, length);
                for (int size = this.f24477a.size() - 1; size >= 0; size--) {
                    C0207a c0207a = (C0207a) this.f24477a.get(size);
                    int i11 = c0207a.f24487c;
                    if (i11 != length) {
                        return;
                    }
                    c0207a.f24487c = i11 - 1;
                }
            }
        }

        public void a(char c11) {
            if (this.f24479c.length() < 32) {
                this.f24479c.append(c11);
            }
        }

        public void a(int i11, boolean z11) {
            this.f24477a.add(new C0207a(i11, z11, this.f24479c.length()));
        }

        public void b(int i11) {
            this.f24483g = i11;
            this.f24477a.clear();
            this.f24478b.clear();
            this.f24479c.setLength(0);
            this.f24480d = 15;
            this.f24481e = 0;
            this.f24482f = 0;
        }

        public void c(int i11) {
            this.f24483g = i11;
        }

        public boolean c() {
            return this.f24477a.isEmpty() && this.f24478b.isEmpty() && this.f24479c.length() == 0;
        }

        public void d() {
            this.f24478b.add(b());
            this.f24479c.setLength(0);
            this.f24477a.clear();
            int iMin = Math.min(this.f24484h, this.f24480d);
            while (this.f24478b.size() >= iMin) {
                this.f24478b.remove(0);
            }
        }

        public void d(int i11) {
            this.f24484h = i11;
        }
    }

    public y2(String str, int i11, long j11) {
        this.f24463k = j11 > 0 ? j11 * 1000 : -9223372036854775807L;
        this.f24460h = MimeTypes.APPLICATION_MP4CEA608.equals(str) ? 2 : 3;
        if (i11 == 1) {
            this.f24462j = 0;
            this.f24461i = 0;
        } else if (i11 == 2) {
            this.f24462j = 1;
            this.f24461i = 0;
        } else if (i11 == 3) {
            this.f24462j = 0;
            this.f24461i = 1;
        } else if (i11 != 4) {
            pc.d("Cea608Decoder", "Invalid channel. Defaulting to CC1.");
            this.f24462j = 0;
            this.f24461i = 0;
        } else {
            this.f24462j = 1;
            this.f24461i = 1;
        }
        a(0);
        m();
        this.f24475w = true;
        this.f24476x = C.TIME_UNSET;
    }

    private static char a(byte b11) {
        return (char) B[(b11 & Ascii.DEL) - 32];
    }

    private static char a(byte b11, byte b12) {
        return (b11 & 1) == 0 ? c(b12) : d(b12);
    }

    private void a(int i11) {
        int i12 = this.f24468p;
        if (i12 == i11) {
            return;
        }
        this.f24468p = i11;
        if (i11 == 3) {
            for (int i13 = 0; i13 < this.f24464l.size(); i13++) {
                ((a) this.f24464l.get(i13)).c(i11);
            }
            return;
        }
        m();
        if (i12 == 3 || i11 == 1 || i11 == 0) {
            this.f24466n = Collections.emptyList();
        }
    }

    private boolean a(boolean z11, byte b11, byte b12) {
        if (!z11 || !i(b11)) {
            this.f24471s = false;
        } else {
            if (this.f24471s && this.f24472t == b11 && this.f24473u == b12) {
                this.f24471s = false;
                return true;
            }
            this.f24471s = true;
            this.f24472t = b11;
            this.f24473u = b12;
        }
        return false;
    }

    private static int b(byte b11) {
        return (b11 >> 3) & 1;
    }

    private void b(byte b11, byte b12) {
        int i11 = f24457y[b11 & 7];
        if ((b12 & 32) != 0) {
            i11++;
        }
        if (i11 != this.f24465m.f24480d) {
            if (this.f24468p != 1 && !this.f24465m.c()) {
                a aVar = new a(this.f24468p, this.f24469q);
                this.f24465m = aVar;
                this.f24464l.add(aVar);
            }
            this.f24465m.f24480d = i11;
        }
        boolean z11 = (b12 & Ascii.DLE) == 16;
        boolean z12 = (b12 & 1) == 1;
        int i12 = (b12 >> 1) & 7;
        this.f24465m.a(z11 ? 8 : i12, z12);
        if (z11) {
            this.f24465m.f24481e = f24458z[i12];
        }
    }

    private void b(int i11) {
        this.f24469q = i11;
        this.f24465m.d(i11);
    }

    private static char c(byte b11) {
        return (char) D[b11 & Ascii.US];
    }

    private static boolean c(byte b11, byte b12) {
        return (b11 & 246) == 18 && (b12 & 224) == 32;
    }

    private static char d(byte b11) {
        return (char) E[b11 & Ascii.US];
    }

    private static boolean d(byte b11, byte b12) {
        return (b11 & 247) == 17 && (b12 & 240) == 32;
    }

    private static char e(byte b11) {
        return (char) C[b11 & Ascii.SI];
    }

    private static boolean e(byte b11, byte b12) {
        return (b11 & 246) == 20 && (b12 & 240) == 32;
    }

    private void f(byte b11) {
        this.f24465m.a(' ');
        this.f24465m.a((b11 >> 1) & 7, (b11 & 1) == 1);
    }

    private static boolean f(byte b11, byte b12) {
        return (b11 & 240) == 16 && (b12 & 192) == 64;
    }

    private void g(byte b11) {
        if (b11 == 32) {
            a(2);
            return;
        }
        if (b11 == 41) {
            a(3);
            return;
        }
        switch (b11) {
            case 37:
                a(1);
                b(2);
                break;
            case 38:
                a(1);
                b(3);
                break;
            case 39:
                a(1);
                b(4);
                break;
            default:
                int i11 = this.f24468p;
                if (i11 != 0) {
                    if (b11 != 33) {
                        switch (b11) {
                            case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                                this.f24466n = Collections.emptyList();
                                int i12 = this.f24468p;
                                if (i12 == 1 || i12 == 3) {
                                    m();
                                }
                                break;
                            case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                                if (i11 == 1 && !this.f24465m.c()) {
                                    this.f24465m.d();
                                    break;
                                }
                                break;
                            case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                                m();
                                break;
                            case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                                this.f24466n = l();
                                m();
                                break;
                        }
                    } else {
                        this.f24465m.a();
                        break;
                    }
                }
                break;
        }
    }

    private static boolean g(byte b11, byte b12) {
        return (b11 & 247) == 17 && (b12 & 240) == 48;
    }

    private static boolean h(byte b11) {
        return (b11 & 224) == 0;
    }

    private static boolean h(byte b11, byte b12) {
        return (b11 & 247) == 23 && b12 >= 33 && b12 <= 35;
    }

    private void i(byte b11, byte b12) {
        if (k(b11)) {
            this.f24475w = false;
            return;
        }
        if (j(b11)) {
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
                                this.f24475w = false;
                                break;
                        }
                }
            }
            this.f24475w = true;
        }
    }

    private static boolean i(byte b11) {
        return (b11 & 240) == 16;
    }

    private static boolean j(byte b11) {
        return (b11 & 247) == 20;
    }

    private static boolean k(byte b11) {
        return 1 <= b11 && b11 <= 15;
    }

    private List l() {
        int size = this.f24464l.size();
        ArrayList arrayList = new ArrayList(size);
        int iMin = 2;
        for (int i11 = 0; i11 < size; i11++) {
            b5 b5VarA = ((a) this.f24464l.get(i11)).a(Integer.MIN_VALUE);
            arrayList.add(b5VarA);
            if (b5VarA != null) {
                iMin = Math.min(iMin, b5VarA.f17840j);
            }
        }
        ArrayList arrayList2 = new ArrayList(size);
        for (int i12 = 0; i12 < size; i12++) {
            b5 b5Var = (b5) arrayList.get(i12);
            if (b5Var != null) {
                if (b5Var.f17840j != iMin) {
                    b5Var = (b5) b1.a(((a) this.f24464l.get(i12)).a(iMin));
                }
                arrayList2.add(b5Var);
            }
        }
        return arrayList2;
    }

    private boolean l(byte b11) {
        if (h(b11)) {
            this.f24474v = b(b11);
        }
        return this.f24474v == this.f24462j;
    }

    private void m() {
        this.f24465m.b(this.f24468p);
        this.f24464l.clear();
        this.f24464l.add(this.f24465m);
    }

    private boolean n() {
        return (this.f24463k == C.TIME_UNSET || this.f24476x == C.TIME_UNSET || i() - this.f24476x < this.f24463k) ? false : true;
    }

    @Override // com.applovin.impl.a3, com.applovin.impl.m5
    public void a() {
    }

    @Override // com.applovin.impl.a3, com.applovin.impl.ol
    public /* bridge */ /* synthetic */ void a(long j11) {
        super.a(j11);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0064  */
    @Override // com.applovin.impl.a3
    public void a(rl rlVar) {
        boolean z11;
        ByteBuffer byteBuffer = (ByteBuffer) b1.a(rlVar.f21655c);
        this.f24459g.a(byteBuffer.array(), byteBuffer.limit());
        boolean z12 = false;
        while (true) {
            int iA = this.f24459g.a();
            int i11 = this.f24460h;
            if (iA < i11) {
                break;
            }
            byte bW = i11 == 2 ? (byte) -4 : (byte) this.f24459g.w();
            int iW = this.f24459g.w();
            int iW2 = this.f24459g.w();
            if ((bW & 2) == 0 && (bW & 1) == this.f24461i) {
                byte b11 = (byte) (iW & 127);
                byte b12 = (byte) (iW2 & 127);
                if (b11 != 0 || b12 != 0) {
                    boolean z13 = this.f24470r;
                    if ((bW & 4) == 4) {
                        boolean[] zArr = F;
                        if (zArr[iW] && zArr[iW2]) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                    } else {
                        z11 = false;
                    }
                    this.f24470r = z11;
                    if (!a(z11, b11, b12)) {
                        if (this.f24470r) {
                            i(b11, b12);
                            if (this.f24475w && l(b11)) {
                                if (!h(b11)) {
                                    this.f24465m.a(a(b11));
                                    if ((b12 & 224) != 0) {
                                        this.f24465m.a(a(b12));
                                    }
                                } else if (g(b11, b12)) {
                                    this.f24465m.a(e(b12));
                                } else if (c(b11, b12)) {
                                    this.f24465m.a();
                                    this.f24465m.a(a(b11, b12));
                                } else if (d(b11, b12)) {
                                    f(b12);
                                } else if (f(b11, b12)) {
                                    b(b11, b12);
                                } else if (h(b11, b12)) {
                                    this.f24465m.f24482f = b12 - 32;
                                } else if (e(b11, b12)) {
                                    g(b12);
                                }
                                z12 = true;
                            }
                        } else if (z13) {
                            m();
                            z12 = true;
                        }
                    }
                }
            }
        }
        if (z12) {
            int i12 = this.f24468p;
            if (i12 == 1 || i12 == 3) {
                this.f24466n = l();
                this.f24476x = i();
            }
        }
    }

    @Override // com.applovin.impl.a3, com.applovin.impl.m5
    public void b() {
        super.b();
        this.f24466n = null;
        this.f24467o = null;
        a(0);
        b(4);
        m();
        this.f24470r = false;
        this.f24471s = false;
        this.f24472t = (byte) 0;
        this.f24473u = (byte) 0;
        this.f24474v = 0;
        this.f24475w = true;
        this.f24476x = C.TIME_UNSET;
    }

    @Override // com.applovin.impl.a3
    /* JADX INFO: renamed from: b */
    public /* bridge */ /* synthetic */ void a(rl rlVar) {
        super.a(rlVar);
    }

    @Override // com.applovin.impl.a3
    public nl e() {
        List list = this.f24466n;
        this.f24467o = list;
        return new b3((List) b1.a(list));
    }

    @Override // com.applovin.impl.a3
    /* JADX INFO: renamed from: f */
    public /* bridge */ /* synthetic */ rl d() {
        return super.d();
    }

    @Override // com.applovin.impl.a3, com.applovin.impl.m5
    /* JADX INFO: renamed from: g */
    public sl c() {
        sl slVarH;
        sl slVarC = super.c();
        if (slVarC != null) {
            return slVarC;
        }
        if (!n() || (slVarH = h()) == null) {
            return null;
        }
        this.f24466n = Collections.emptyList();
        this.f24476x = C.TIME_UNSET;
        slVarH.a(i(), e(), Long.MAX_VALUE);
        return slVarH;
    }

    @Override // com.applovin.impl.a3
    public boolean j() {
        return this.f24466n != this.f24467o;
    }
}
