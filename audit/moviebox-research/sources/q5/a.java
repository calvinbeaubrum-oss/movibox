package q5;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.applovin.exoplayer2.common.base.Ascii;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.List;
import o5.k;
import o5.r;
import o5.s;
import z3.b0;
import z3.c0;
import z3.o;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements s {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final byte[] f74379h = {0, 7, 8, Ascii.SI};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final byte[] f74380i = {0, 119, -120, -1};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final byte[] f74381j = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f74382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f74383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Canvas f74384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f74385d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final C0814a f74386e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final h f74387f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Bitmap f74388g;

    /* JADX INFO: renamed from: q5.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0814a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f74389a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f74390b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int[] f74391c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int[] f74392d;

        public C0814a(int i11, int[] iArr, int[] iArr2, int[] iArr3) {
            this.f74389a = i11;
            this.f74390b = iArr;
            this.f74391c = iArr2;
            this.f74392d = iArr3;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f74393a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f74394b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f74395c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f74396d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f74397e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f74398f;

        public b(int i11, int i12, int i13, int i14, int i15, int i16) {
            this.f74393a = i11;
            this.f74394b = i12;
            this.f74395c = i13;
            this.f74396d = i14;
            this.f74397e = i15;
            this.f74398f = i16;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f74399a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f74400b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f74401c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final byte[] f74402d;

        public c(int i11, boolean z11, byte[] bArr, byte[] bArr2) {
            this.f74399a = i11;
            this.f74400b = z11;
            this.f74401c = bArr;
            this.f74402d = bArr2;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f74403a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f74404b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f74405c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final SparseArray<e> f74406d;

        public d(int i11, int i12, int i13, SparseArray<e> sparseArray) {
            this.f74403a = i11;
            this.f74404b = i12;
            this.f74405c = i13;
            this.f74406d = sparseArray;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f74407a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f74408b;

        public e(int i11, int i12) {
            this.f74407a = i11;
            this.f74408b = i12;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f74409a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f74410b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f74411c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f74412d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f74413e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f74414f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f74415g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f74416h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f74417i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f74418j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final SparseArray<g> f74419k;

        public f(int i11, boolean z11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, SparseArray<g> sparseArray) {
            this.f74409a = i11;
            this.f74410b = z11;
            this.f74411c = i12;
            this.f74412d = i13;
            this.f74413e = i14;
            this.f74414f = i15;
            this.f74415g = i16;
            this.f74416h = i17;
            this.f74417i = i18;
            this.f74418j = i19;
            this.f74419k = sparseArray;
        }

        public void a(f fVar) {
            SparseArray<g> sparseArray = fVar.f74419k;
            for (int i11 = 0; i11 < sparseArray.size(); i11++) {
                this.f74419k.put(sparseArray.keyAt(i11), sparseArray.valueAt(i11));
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f74420a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f74421b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f74422c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f74423d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f74424e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f74425f;

        public g(int i11, int i12, int i13, int i14, int i15, int i16) {
            this.f74420a = i11;
            this.f74421b = i12;
            this.f74422c = i13;
            this.f74423d = i14;
            this.f74424e = i15;
            this.f74425f = i16;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f74426a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f74427b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final SparseArray<f> f74428c = new SparseArray<>();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final SparseArray<C0814a> f74429d = new SparseArray<>();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final SparseArray<c> f74430e = new SparseArray<>();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final SparseArray<C0814a> f74431f = new SparseArray<>();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final SparseArray<c> f74432g = new SparseArray<>();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Nullable
        public b f74433h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @Nullable
        public d f74434i;

        public h(int i11, int i12) {
            this.f74426a = i11;
            this.f74427b = i12;
        }

        public void a() {
            this.f74428c.clear();
            this.f74429d.clear();
            this.f74430e.clear();
            this.f74431f.clear();
            this.f74432g.clear();
            this.f74433h = null;
            this.f74434i = null;
        }
    }

    public a(List<byte[]> list) {
        c0 c0Var = new c0(list.get(0));
        int iN = c0Var.N();
        int iN2 = c0Var.N();
        Paint paint = new Paint();
        this.f74382a = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.f74383b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.f74384c = new Canvas();
        this.f74385d = new b(719, 575, 0, 719, 0, 575);
        this.f74386e = new C0814a(0, f(), g(), h());
        this.f74387f = new h(iN, iN2);
    }

    public static byte[] e(int i11, int i12, b0 b0Var) {
        byte[] bArr = new byte[i11];
        for (int i13 = 0; i13 < i11; i13++) {
            bArr[i13] = (byte) b0Var.h(i12);
        }
        return bArr;
    }

    public static int[] f() {
        return new int[]{0, -1, ViewCompat.MEASURED_STATE_MASK, -8421505};
    }

    public static int[] g() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i11 = 1; i11 < 16; i11++) {
            if (i11 < 8) {
                iArr[i11] = i(255, (i11 & 1) != 0 ? 255 : 0, (i11 & 2) != 0 ? 255 : 0, (i11 & 4) != 0 ? 255 : 0);
            } else {
                iArr[i11] = i(255, (i11 & 1) != 0 ? 127 : 0, (i11 & 2) != 0 ? 127 : 0, (i11 & 4) == 0 ? 0 : 127);
            }
        }
        return iArr;
    }

    public static int[] h() {
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i11 = 0; i11 < 256; i11++) {
            if (i11 < 8) {
                iArr[i11] = i(63, (i11 & 1) != 0 ? 255 : 0, (i11 & 2) != 0 ? 255 : 0, (i11 & 4) == 0 ? 0 : 255);
            } else {
                int i12 = i11 & 136;
                if (i12 == 0) {
                    iArr[i11] = i(255, ((i11 & 1) != 0 ? 85 : 0) + ((i11 & 16) != 0 ? 170 : 0), ((i11 & 2) != 0 ? 85 : 0) + ((i11 & 32) != 0 ? 170 : 0), ((i11 & 4) == 0 ? 0 : 85) + ((i11 & 64) == 0 ? 0 : 170));
                } else if (i12 == 8) {
                    iArr[i11] = i(127, ((i11 & 1) != 0 ? 85 : 0) + ((i11 & 16) != 0 ? 170 : 0), ((i11 & 2) != 0 ? 85 : 0) + ((i11 & 32) != 0 ? 170 : 0), ((i11 & 4) == 0 ? 0 : 85) + ((i11 & 64) == 0 ? 0 : 170));
                } else if (i12 == 128) {
                    iArr[i11] = i(255, ((i11 & 1) != 0 ? 43 : 0) + 127 + ((i11 & 16) != 0 ? 85 : 0), ((i11 & 2) != 0 ? 43 : 0) + 127 + ((i11 & 32) != 0 ? 85 : 0), ((i11 & 4) == 0 ? 0 : 43) + 127 + ((i11 & 64) == 0 ? 0 : 85));
                } else if (i12 == 136) {
                    iArr[i11] = i(255, ((i11 & 1) != 0 ? 43 : 0) + ((i11 & 16) != 0 ? 85 : 0), ((i11 & 2) != 0 ? 43 : 0) + ((i11 & 32) != 0 ? 85 : 0), ((i11 & 4) == 0 ? 0 : 43) + ((i11 & 64) == 0 ? 0 : 85));
                }
            }
        }
        return iArr;
    }

    public static int i(int i11, int i12, int i13, int i14) {
        return (i11 << 24) | (i12 << 16) | (i13 << 8) | i14;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0063 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:28:0x0067  */
    /* JADX WARN: Code duplicated, block: B:33:0x0083 A[LOOP:0: B:3:0x0009->B:33:0x0083, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:34:0x0082 A[SYNTHETIC] */
    public static int j(b0 b0Var, int[] iArr, @Nullable byte[] bArr, int i11, int i12, @Nullable Paint paint, Canvas canvas) {
        int i13;
        int iH;
        int iH2;
        int i14 = i11;
        boolean z11 = false;
        while (true) {
            int iH3 = b0Var.h(2);
            if (iH3 == 0) {
                if (b0Var.g()) {
                    iH = b0Var.h(3) + 3;
                    iH2 = b0Var.h(2);
                } else {
                    if (b0Var.g()) {
                        iH3 = 0;
                    } else {
                        int iH4 = b0Var.h(2);
                        if (iH4 == 0) {
                            iH3 = 0;
                            z11 = true;
                        } else if (iH4 == 1) {
                            z11 = z11;
                            iH3 = 0;
                            i13 = 2;
                        } else if (iH4 == 2) {
                            iH = b0Var.h(4) + 12;
                            iH2 = b0Var.h(2);
                        } else if (iH4 != 3) {
                            z11 = z11;
                            iH3 = 0;
                        } else {
                            iH = b0Var.h(8) + 29;
                            iH2 = b0Var.h(2);
                        }
                        i13 = 0;
                    }
                    if (i13 != 0 && paint != null) {
                        if (bArr != null) {
                            iH3 = bArr[iH3];
                        }
                        paint.setColor(iArr[iH3]);
                        canvas.drawRect(i14, i12, i14 + i13, i12 + 1, paint);
                    }
                    i14 += i13;
                    if (z11) {
                        return i14;
                    }
                    z11 = z11;
                }
                z11 = z11;
                i13 = iH;
                iH3 = iH2;
                if (i13 != 0) {
                    if (bArr != null) {
                        iH3 = bArr[iH3];
                    }
                    paint.setColor(iArr[iH3]);
                    canvas.drawRect(i14, i12, i14 + i13, i12 + 1, paint);
                }
                i14 += i13;
                if (z11) {
                    return i14;
                }
                z11 = z11;
            }
            i13 = 1;
            if (i13 != 0) {
                if (bArr != null) {
                    iH3 = bArr[iH3];
                }
                paint.setColor(iArr[iH3]);
                canvas.drawRect(i14, i12, i14 + i13, i12 + 1, paint);
            }
            i14 += i13;
            if (z11) {
                return i14;
            }
            z11 = z11;
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0074  */
    /* JADX WARN: Code duplicated, block: B:36:0x0090 A[LOOP:0: B:3:0x0009->B:36:0x0090, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:37:0x008f A[SYNTHETIC] */
    public static int k(b0 b0Var, int[] iArr, @Nullable byte[] bArr, int i11, int i12, @Nullable Paint paint, Canvas canvas) {
        int i13;
        int iH;
        int iH2;
        int i14 = i11;
        boolean z11 = false;
        while (true) {
            int iH3 = b0Var.h(4);
            if (iH3 == 0) {
                if (b0Var.g()) {
                    if (b0Var.g()) {
                        int iH4 = b0Var.h(2);
                        if (iH4 == 0) {
                            iH3 = 0;
                        } else if (iH4 == 1) {
                            z11 = z11;
                            iH3 = 0;
                            i13 = 2;
                        } else if (iH4 == 2) {
                            iH = b0Var.h(4) + 9;
                            iH2 = b0Var.h(4);
                        } else if (iH4 != 3) {
                            z11 = z11;
                            iH3 = 0;
                            i13 = 0;
                        } else {
                            iH = b0Var.h(8) + 25;
                            iH2 = b0Var.h(4);
                        }
                    } else {
                        iH = b0Var.h(2) + 4;
                        iH2 = b0Var.h(4);
                    }
                    z11 = z11;
                    i13 = iH;
                    iH3 = iH2;
                } else {
                    int iH5 = b0Var.h(3);
                    if (iH5 != 0) {
                        z11 = z11;
                        i13 = iH5 + 2;
                        iH3 = 0;
                    } else {
                        iH3 = 0;
                        z11 = true;
                        i13 = 0;
                    }
                }
                if (i13 != 0 && paint != null) {
                    if (bArr != null) {
                        iH3 = bArr[iH3];
                    }
                    paint.setColor(iArr[iH3]);
                    canvas.drawRect(i14, i12, i14 + i13, i12 + 1, paint);
                }
                i14 += i13;
                if (z11) {
                    return i14;
                }
                z11 = z11;
            }
            i13 = 1;
            if (i13 != 0) {
                if (bArr != null) {
                    iH3 = bArr[iH3];
                }
                paint.setColor(iArr[iH3]);
                canvas.drawRect(i14, i12, i14 + i13, i12 + 1, paint);
            }
            i14 += i13;
            if (z11) {
                return i14;
            }
            z11 = z11;
        }
    }

    public static int l(b0 b0Var, int[] iArr, @Nullable byte[] bArr, int i11, int i12, @Nullable Paint paint, Canvas canvas) {
        boolean z11;
        int iH;
        int i13 = i11;
        boolean z12 = false;
        while (true) {
            int iH2 = b0Var.h(8);
            if (iH2 != 0) {
                z11 = z12;
                iH = 1;
            } else if (b0Var.g()) {
                z11 = z12;
                iH = b0Var.h(7);
                iH2 = b0Var.h(8);
            } else {
                int iH3 = b0Var.h(7);
                if (iH3 != 0) {
                    z11 = z12;
                    iH = iH3;
                    iH2 = 0;
                } else {
                    iH2 = 0;
                    z11 = true;
                    iH = 0;
                }
            }
            if (iH != 0 && paint != null) {
                if (bArr != null) {
                    iH2 = bArr[iH2];
                }
                paint.setColor(iArr[iH2]);
                canvas.drawRect(i13, i12, i13 + iH, i12 + 1, paint);
            }
            i13 += iH;
            if (z11) {
                return i13;
            }
            z12 = z11;
        }
    }

    public static void m(byte[] bArr, int[] iArr, int i11, int i12, int i13, @Nullable Paint paint, Canvas canvas) {
        byte[] bArr2;
        byte[] bArr3;
        b0 b0Var = new b0(bArr);
        int iJ = i12;
        int i14 = i13;
        byte[] bArrE = null;
        byte[] bArrE2 = null;
        byte[] bArrE3 = null;
        while (b0Var.b() != 0) {
            int iH = b0Var.h(8);
            if (iH != 240) {
                switch (iH) {
                    case 16:
                        if (i11 != 3) {
                            if (i11 == 2) {
                                bArr3 = bArrE3 == null ? f74379h : bArrE3;
                            } else {
                                bArr2 = null;
                            }
                            iJ = j(b0Var, iArr, bArr2, iJ, i14, paint, canvas);
                            b0Var.c();
                        } else {
                            bArr3 = bArrE == null ? f74380i : bArrE;
                        }
                        bArr2 = bArr3;
                        iJ = j(b0Var, iArr, bArr2, iJ, i14, paint, canvas);
                        b0Var.c();
                        break;
                    case 17:
                        iJ = k(b0Var, iArr, i11 == 3 ? bArrE2 == null ? f74381j : bArrE2 : null, iJ, i14, paint, canvas);
                        b0Var.c();
                        break;
                    case 18:
                        iJ = l(b0Var, iArr, null, iJ, i14, paint, canvas);
                        break;
                    default:
                        switch (iH) {
                            case 32:
                                bArrE3 = e(4, 4, b0Var);
                                break;
                            case 33:
                                bArrE = e(4, 8, b0Var);
                                break;
                            case 34:
                                bArrE2 = e(16, 8, b0Var);
                                break;
                        }
                        break;
                }
            } else {
                i14 += 2;
                iJ = i12;
            }
        }
    }

    public static void n(c cVar, C0814a c0814a, int i11, int i12, int i13, @Nullable Paint paint, Canvas canvas) {
        int[] iArr;
        if (i11 == 3) {
            iArr = c0814a.f74392d;
        } else {
            iArr = i11 == 2 ? c0814a.f74391c : c0814a.f74390b;
        }
        int[] iArr2 = iArr;
        m(cVar.f74401c, iArr2, i11, i12, i13, paint, canvas);
        m(cVar.f74402d, iArr2, i11, i12, i13 + 1, paint, canvas);
    }

    public static C0814a p(b0 b0Var, int i11) {
        int[] iArr;
        int iH;
        int i12;
        int iH2;
        int iH3;
        int iH4;
        int i13 = 8;
        int iH5 = b0Var.h(8);
        b0Var.r(8);
        int i14 = 2;
        int i15 = i11 - 2;
        int[] iArrF = f();
        int[] iArrG = g();
        int[] iArrH = h();
        while (i15 > 0) {
            int iH6 = b0Var.h(i13);
            int iH7 = b0Var.h(i13);
            if ((iH7 & 128) != 0) {
                iArr = iArrF;
            } else {
                iArr = (iH7 & 64) != 0 ? iArrG : iArrH;
            }
            if ((iH7 & 1) != 0) {
                iH3 = b0Var.h(i13);
                iH4 = b0Var.h(i13);
                iH = b0Var.h(i13);
                iH2 = b0Var.h(i13);
                i12 = i15 - 6;
            } else {
                int iH8 = b0Var.h(6) << i14;
                int iH9 = b0Var.h(4) << 4;
                iH = b0Var.h(4) << 4;
                i12 = i15 - 4;
                iH2 = b0Var.h(i14) << 6;
                iH3 = iH8;
                iH4 = iH9;
            }
            if (iH3 == 0) {
                iH4 = 0;
                iH = 0;
                iH2 = 255;
            }
            double d11 = iH3;
            double d12 = iH4 - 128;
            double d13 = iH - 128;
            iArr[iH6] = i((byte) (255 - (iH2 & 255)), u0.p((int) (d11 + (1.402d * d12)), 0, 255), u0.p((int) ((d11 - (0.34414d * d13)) - (d12 * 0.71414d)), 0, 255), u0.p((int) (d11 + (d13 * 1.772d)), 0, 255));
            i15 = i12;
            iH5 = iH5;
            i13 = 8;
            i14 = 2;
        }
        return new C0814a(iH5, iArrF, iArrG, iArrH);
    }

    public static b q(b0 b0Var) {
        int i11;
        int iH;
        int i12;
        int i13;
        b0Var.r(4);
        boolean zG = b0Var.g();
        b0Var.r(3);
        int iH2 = b0Var.h(16);
        int iH3 = b0Var.h(16);
        if (zG) {
            int iH4 = b0Var.h(16);
            int iH5 = b0Var.h(16);
            int iH6 = b0Var.h(16);
            iH = b0Var.h(16);
            i11 = iH5;
            i13 = iH6;
            i12 = iH4;
        } else {
            i11 = iH2;
            iH = iH3;
            i12 = 0;
            i13 = 0;
        }
        return new b(iH2, iH3, i12, i11, i13, iH);
    }

    public static c r(b0 b0Var) {
        byte[] bArr;
        int iH = b0Var.h(16);
        b0Var.r(4);
        int iH2 = b0Var.h(2);
        boolean zG = b0Var.g();
        b0Var.r(1);
        byte[] bArr2 = u0.f81843f;
        if (iH2 != 1) {
            if (iH2 == 0) {
                int iH3 = b0Var.h(16);
                int iH4 = b0Var.h(16);
                if (iH3 > 0) {
                    bArr2 = new byte[iH3];
                    b0Var.k(bArr2, 0, iH3);
                }
                if (iH4 > 0) {
                    bArr = new byte[iH4];
                    b0Var.k(bArr, 0, iH4);
                }
            }
            return new c(iH, zG, bArr2, bArr);
        }
        b0Var.r(b0Var.h(8) * 16);
        bArr = bArr2;
        return new c(iH, zG, bArr2, bArr);
    }

    public static d s(b0 b0Var, int i11) {
        int iH = b0Var.h(8);
        int iH2 = b0Var.h(4);
        int iH3 = b0Var.h(2);
        b0Var.r(2);
        int i12 = i11 - 2;
        SparseArray sparseArray = new SparseArray();
        while (i12 > 0) {
            int iH4 = b0Var.h(8);
            b0Var.r(8);
            i12 -= 6;
            sparseArray.put(iH4, new e(b0Var.h(16), b0Var.h(16)));
        }
        return new d(iH, iH2, iH3, sparseArray);
    }

    public static f t(b0 b0Var, int i11) {
        int iH;
        int iH2;
        int iH3 = b0Var.h(8);
        b0Var.r(4);
        boolean zG = b0Var.g();
        b0Var.r(3);
        int i12 = 16;
        int iH4 = b0Var.h(16);
        int iH5 = b0Var.h(16);
        int iH6 = b0Var.h(3);
        int iH7 = b0Var.h(3);
        int i13 = 2;
        b0Var.r(2);
        int iH8 = b0Var.h(8);
        int iH9 = b0Var.h(8);
        int iH10 = b0Var.h(4);
        int iH11 = b0Var.h(2);
        b0Var.r(2);
        int i14 = i11 - 10;
        SparseArray sparseArray = new SparseArray();
        while (i14 > 0) {
            int iH12 = b0Var.h(i12);
            int iH13 = b0Var.h(i13);
            int iH14 = b0Var.h(i13);
            int iH15 = b0Var.h(12);
            int i15 = iH11;
            b0Var.r(4);
            int iH16 = b0Var.h(12);
            int i16 = i14 - 6;
            if (iH13 == 1 || iH13 == 2) {
                i14 -= 8;
                iH2 = b0Var.h(8);
                iH = b0Var.h(8);
            } else {
                i14 = i16;
                iH2 = 0;
                iH = 0;
            }
            sparseArray.put(iH12, new g(iH13, iH14, iH15, iH16, iH2, iH));
            iH11 = i15;
            i13 = 2;
            i12 = 16;
        }
        return new f(iH3, zG, iH4, iH5, iH6, iH7, iH8, iH9, iH10, iH11, sparseArray);
    }

    public static void u(b0 b0Var, h hVar) {
        f fVar;
        int iH = b0Var.h(8);
        int iH2 = b0Var.h(16);
        int iH3 = b0Var.h(16);
        int iD = b0Var.d() + iH3;
        if (iH3 * 8 > b0Var.b()) {
            o.h("DvbParser", "Data field length exceeds limit");
            b0Var.r(b0Var.b());
            return;
        }
        switch (iH) {
            case 16:
                if (iH2 == hVar.f74426a) {
                    d dVar = hVar.f74434i;
                    d dVarS = s(b0Var, iH3);
                    if (dVarS.f74405c != 0) {
                        hVar.f74434i = dVarS;
                        hVar.f74428c.clear();
                        hVar.f74429d.clear();
                        hVar.f74430e.clear();
                    } else if (dVar != null && dVar.f74404b != dVarS.f74404b) {
                        hVar.f74434i = dVarS;
                    }
                }
                break;
            case 17:
                d dVar2 = hVar.f74434i;
                if (iH2 == hVar.f74426a && dVar2 != null) {
                    f fVarT = t(b0Var, iH3);
                    if (dVar2.f74405c == 0 && (fVar = hVar.f74428c.get(fVarT.f74409a)) != null) {
                        fVarT.a(fVar);
                    }
                    hVar.f74428c.put(fVarT.f74409a, fVarT);
                }
                break;
            case 18:
                if (iH2 == hVar.f74426a) {
                    C0814a c0814aP = p(b0Var, iH3);
                    hVar.f74429d.put(c0814aP.f74389a, c0814aP);
                } else if (iH2 == hVar.f74427b) {
                    C0814a c0814aP2 = p(b0Var, iH3);
                    hVar.f74431f.put(c0814aP2.f74389a, c0814aP2);
                }
                break;
            case 19:
                if (iH2 == hVar.f74426a) {
                    c cVarR = r(b0Var);
                    hVar.f74430e.put(cVarR.f74399a, cVarR);
                } else if (iH2 == hVar.f74427b) {
                    c cVarR2 = r(b0Var);
                    hVar.f74432g.put(cVarR2.f74399a, cVarR2);
                }
                break;
            case 20:
                if (iH2 == hVar.f74426a) {
                    hVar.f74433h = q(b0Var);
                }
                break;
        }
        b0Var.s(iD - b0Var.d());
    }

    @Override // o5.s
    public /* synthetic */ void a(byte[] bArr, s.b bVar, z3.h hVar) {
        r.a(this, bArr, bVar, hVar);
    }

    @Override // o5.s
    public /* synthetic */ k b(byte[] bArr, int i11, int i12) {
        return r.b(this, bArr, i11, i12);
    }

    @Override // o5.s
    public void c(byte[] bArr, int i11, int i12, s.b bVar, z3.h<o5.e> hVar) {
        b0 b0Var = new b0(bArr, i12 + i11);
        b0Var.p(i11);
        hVar.accept(o(b0Var));
    }

    @Override // o5.s
    public int d() {
        return 2;
    }

    public final o5.e o(b0 b0Var) {
        while (b0Var.b() >= 48 && b0Var.h(8) == 15) {
            u(b0Var, this.f74387f);
        }
        h hVar = this.f74387f;
        d dVar = hVar.f74434i;
        if (dVar == null) {
            return new o5.e(ImmutableList.of(), C.TIME_UNSET, C.TIME_UNSET);
        }
        b bVar = hVar.f74433h;
        if (bVar == null) {
            bVar = this.f74385d;
        }
        Bitmap bitmap = this.f74388g;
        if (bitmap == null || bVar.f74393a + 1 != bitmap.getWidth() || bVar.f74394b + 1 != this.f74388g.getHeight()) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bVar.f74393a + 1, bVar.f74394b + 1, Bitmap.Config.ARGB_8888);
            this.f74388g = bitmapCreateBitmap;
            this.f74384c.setBitmap(bitmapCreateBitmap);
        }
        ArrayList arrayList = new ArrayList();
        SparseArray<e> sparseArray = dVar.f74406d;
        for (int i11 = 0; i11 < sparseArray.size(); i11++) {
            this.f74384c.save();
            e eVarValueAt = sparseArray.valueAt(i11);
            f fVar = this.f74387f.f74428c.get(sparseArray.keyAt(i11));
            int i12 = eVarValueAt.f74407a + bVar.f74395c;
            int i13 = eVarValueAt.f74408b + bVar.f74397e;
            this.f74384c.clipRect(i12, i13, Math.min(fVar.f74411c + i12, bVar.f74396d), Math.min(fVar.f74412d + i13, bVar.f74398f));
            C0814a c0814a = this.f74387f.f74429d.get(fVar.f74415g);
            if (c0814a == null && (c0814a = this.f74387f.f74431f.get(fVar.f74415g)) == null) {
                c0814a = this.f74386e;
            }
            int i14 = 0;
            for (SparseArray<g> sparseArray2 = fVar.f74419k; i14 < sparseArray2.size(); sparseArray2 = sparseArray2) {
                int iKeyAt = sparseArray2.keyAt(i14);
                g gVarValueAt = sparseArray2.valueAt(i14);
                c cVar = this.f74387f.f74430e.get(iKeyAt);
                c cVar2 = cVar == null ? this.f74387f.f74432g.get(iKeyAt) : cVar;
                if (cVar2 != null) {
                    n(cVar2, c0814a, fVar.f74414f, gVarValueAt.f74422c + i12, i13 + gVarValueAt.f74423d, cVar2.f74400b ? null : this.f74382a, this.f74384c);
                }
                i14++;
            }
            if (fVar.f74410b) {
                int i15 = fVar.f74414f;
                this.f74383b.setColor(i15 == 3 ? c0814a.f74392d[fVar.f74416h] : i15 == 2 ? c0814a.f74391c[fVar.f74417i] : c0814a.f74390b[fVar.f74418j]);
                this.f74384c.drawRect(i12, i13, fVar.f74411c + i12, fVar.f74412d + i13, this.f74383b);
            }
            arrayList.add(new y3.a.b().f(Bitmap.createBitmap(this.f74388g, i12, i13, fVar.f74411c, fVar.f74412d)).k(i12 / bVar.f74393a).l(0).h(i13 / bVar.f74394b, 0).i(0).n(fVar.f74411c / bVar.f74393a).g(fVar.f74412d / bVar.f74394b).a());
            this.f74384c.drawColor(0, PorterDuff.Mode.CLEAR);
            this.f74384c.restore();
        }
        return new o5.e(arrayList, C.TIME_UNSET, C.TIME_UNSET);
    }

    @Override // o5.s
    public void reset() {
        this.f74387f.a();
    }
}
