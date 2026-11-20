package xh;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.exoplayer2.util.b0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final byte[] f80507h = {0, 7, 8, Ascii.SI};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final byte[] f80508i = {0, 119, -120, -1};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final byte[] f80509j = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f80510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f80511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Canvas f80512c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C0904b f80513d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f80514e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final h f80515f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Bitmap f80516g;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f80517a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f80518b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int[] f80519c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int[] f80520d;

        public a(int i11, int[] iArr, int[] iArr2, int[] iArr3) {
            this.f80517a = i11;
            this.f80518b = iArr;
            this.f80519c = iArr2;
            this.f80520d = iArr3;
        }
    }

    /* JADX INFO: renamed from: xh.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0904b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f80521a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f80522b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f80523c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f80524d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f80525e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f80526f;

        public C0904b(int i11, int i12, int i13, int i14, int i15, int i16) {
            this.f80521a = i11;
            this.f80522b = i12;
            this.f80523c = i13;
            this.f80524d = i14;
            this.f80525e = i15;
            this.f80526f = i16;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f80527a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f80528b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f80529c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final byte[] f80530d;

        public c(int i11, boolean z11, byte[] bArr, byte[] bArr2) {
            this.f80527a = i11;
            this.f80528b = z11;
            this.f80529c = bArr;
            this.f80530d = bArr2;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f80531a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f80532b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f80533c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final SparseArray<e> f80534d;

        public d(int i11, int i12, int i13, SparseArray<e> sparseArray) {
            this.f80531a = i11;
            this.f80532b = i12;
            this.f80533c = i13;
            this.f80534d = sparseArray;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f80535a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f80536b;

        public e(int i11, int i12) {
            this.f80535a = i11;
            this.f80536b = i12;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f80537a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f80538b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f80539c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f80540d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f80541e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f80542f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f80543g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f80544h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f80545i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f80546j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final SparseArray<g> f80547k;

        public f(int i11, boolean z11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, SparseArray<g> sparseArray) {
            this.f80537a = i11;
            this.f80538b = z11;
            this.f80539c = i12;
            this.f80540d = i13;
            this.f80541e = i14;
            this.f80542f = i15;
            this.f80543g = i16;
            this.f80544h = i17;
            this.f80545i = i18;
            this.f80546j = i19;
            this.f80547k = sparseArray;
        }

        public void a(f fVar) {
            SparseArray<g> sparseArray = fVar.f80547k;
            for (int i11 = 0; i11 < sparseArray.size(); i11++) {
                this.f80547k.put(sparseArray.keyAt(i11), sparseArray.valueAt(i11));
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f80548a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f80549b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f80550c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f80551d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f80552e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f80553f;

        public g(int i11, int i12, int i13, int i14, int i15, int i16) {
            this.f80548a = i11;
            this.f80549b = i12;
            this.f80550c = i13;
            this.f80551d = i14;
            this.f80552e = i15;
            this.f80553f = i16;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f80554a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f80555b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final SparseArray<f> f80556c = new SparseArray<>();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final SparseArray<a> f80557d = new SparseArray<>();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final SparseArray<c> f80558e = new SparseArray<>();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final SparseArray<a> f80559f = new SparseArray<>();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final SparseArray<c> f80560g = new SparseArray<>();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Nullable
        public C0904b f80561h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @Nullable
        public d f80562i;

        public h(int i11, int i12) {
            this.f80554a = i11;
            this.f80555b = i12;
        }

        public void a() {
            this.f80556c.clear();
            this.f80557d.clear();
            this.f80558e.clear();
            this.f80559f.clear();
            this.f80560g.clear();
            this.f80561h = null;
            this.f80562i = null;
        }
    }

    public b(int i11, int i12) {
        Paint paint = new Paint();
        this.f80510a = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.f80511b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.f80512c = new Canvas();
        this.f80513d = new C0904b(719, 575, 0, 719, 0, 575);
        this.f80514e = new a(0, c(), d(), e());
        this.f80515f = new h(i11, i12);
    }

    public static byte[] a(int i11, int i12, b0 b0Var) {
        byte[] bArr = new byte[i11];
        for (int i13 = 0; i13 < i11; i13++) {
            bArr[i13] = (byte) b0Var.h(i12);
        }
        return bArr;
    }

    public static int[] c() {
        return new int[]{0, -1, ViewCompat.MEASURED_STATE_MASK, -8421505};
    }

    public static int[] d() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i11 = 1; i11 < 16; i11++) {
            if (i11 < 8) {
                iArr[i11] = f(255, (i11 & 1) != 0 ? 255 : 0, (i11 & 2) != 0 ? 255 : 0, (i11 & 4) != 0 ? 255 : 0);
            } else {
                iArr[i11] = f(255, (i11 & 1) != 0 ? 127 : 0, (i11 & 2) != 0 ? 127 : 0, (i11 & 4) == 0 ? 0 : 127);
            }
        }
        return iArr;
    }

    public static int[] e() {
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i11 = 0; i11 < 256; i11++) {
            if (i11 < 8) {
                iArr[i11] = f(63, (i11 & 1) != 0 ? 255 : 0, (i11 & 2) != 0 ? 255 : 0, (i11 & 4) == 0 ? 0 : 255);
            } else {
                int i12 = i11 & 136;
                if (i12 == 0) {
                    iArr[i11] = f(255, ((i11 & 1) != 0 ? 85 : 0) + ((i11 & 16) != 0 ? 170 : 0), ((i11 & 2) != 0 ? 85 : 0) + ((i11 & 32) != 0 ? 170 : 0), ((i11 & 4) == 0 ? 0 : 85) + ((i11 & 64) == 0 ? 0 : 170));
                } else if (i12 == 8) {
                    iArr[i11] = f(127, ((i11 & 1) != 0 ? 85 : 0) + ((i11 & 16) != 0 ? 170 : 0), ((i11 & 2) != 0 ? 85 : 0) + ((i11 & 32) != 0 ? 170 : 0), ((i11 & 4) == 0 ? 0 : 85) + ((i11 & 64) == 0 ? 0 : 170));
                } else if (i12 == 128) {
                    iArr[i11] = f(255, ((i11 & 1) != 0 ? 43 : 0) + 127 + ((i11 & 16) != 0 ? 85 : 0), ((i11 & 2) != 0 ? 43 : 0) + 127 + ((i11 & 32) != 0 ? 85 : 0), ((i11 & 4) == 0 ? 0 : 43) + 127 + ((i11 & 64) == 0 ? 0 : 85));
                } else if (i12 == 136) {
                    iArr[i11] = f(255, ((i11 & 1) != 0 ? 43 : 0) + ((i11 & 16) != 0 ? 85 : 0), ((i11 & 2) != 0 ? 43 : 0) + ((i11 & 32) != 0 ? 85 : 0), ((i11 & 4) == 0 ? 0 : 43) + ((i11 & 64) == 0 ? 0 : 85));
                }
            }
        }
        return iArr;
    }

    public static int f(int i11, int i12, int i13, int i14) {
        return (i11 << 24) | (i12 << 16) | (i13 << 8) | i14;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0063 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:28:0x0067  */
    /* JADX WARN: Code duplicated, block: B:33:0x0083 A[LOOP:0: B:3:0x0009->B:33:0x0083, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:34:0x0082 A[SYNTHETIC] */
    public static int g(b0 b0Var, int[] iArr, @Nullable byte[] bArr, int i11, int i12, @Nullable Paint paint, Canvas canvas) {
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
    public static int h(b0 b0Var, int[] iArr, @Nullable byte[] bArr, int i11, int i12, @Nullable Paint paint, Canvas canvas) {
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

    public static int i(b0 b0Var, int[] iArr, @Nullable byte[] bArr, int i11, int i12, @Nullable Paint paint, Canvas canvas) {
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

    public static void j(byte[] bArr, int[] iArr, int i11, int i12, int i13, @Nullable Paint paint, Canvas canvas) {
        byte[] bArr2;
        byte[] bArr3;
        b0 b0Var = new b0(bArr);
        int iG = i12;
        int i14 = i13;
        byte[] bArrA = null;
        byte[] bArrA2 = null;
        byte[] bArrA3 = null;
        while (b0Var.b() != 0) {
            int iH = b0Var.h(8);
            if (iH != 240) {
                switch (iH) {
                    case 16:
                        if (i11 != 3) {
                            if (i11 == 2) {
                                bArr3 = bArrA3 == null ? f80507h : bArrA3;
                            } else {
                                bArr2 = null;
                            }
                            iG = g(b0Var, iArr, bArr2, iG, i14, paint, canvas);
                            b0Var.c();
                        } else {
                            bArr3 = bArrA == null ? f80508i : bArrA;
                        }
                        bArr2 = bArr3;
                        iG = g(b0Var, iArr, bArr2, iG, i14, paint, canvas);
                        b0Var.c();
                        break;
                    case 17:
                        iG = h(b0Var, iArr, i11 == 3 ? bArrA2 == null ? f80509j : bArrA2 : null, iG, i14, paint, canvas);
                        b0Var.c();
                        break;
                    case 18:
                        iG = i(b0Var, iArr, null, iG, i14, paint, canvas);
                        break;
                    default:
                        switch (iH) {
                            case 32:
                                bArrA3 = a(4, 4, b0Var);
                                break;
                            case 33:
                                bArrA = a(4, 8, b0Var);
                                break;
                            case 34:
                                bArrA2 = a(16, 8, b0Var);
                                break;
                        }
                        break;
                }
            } else {
                i14 += 2;
                iG = i12;
            }
        }
    }

    public static void k(c cVar, a aVar, int i11, int i12, int i13, @Nullable Paint paint, Canvas canvas) {
        int[] iArr;
        if (i11 == 3) {
            iArr = aVar.f80520d;
        } else {
            iArr = i11 == 2 ? aVar.f80519c : aVar.f80518b;
        }
        int[] iArr2 = iArr;
        j(cVar.f80529c, iArr2, i11, i12, i13, paint, canvas);
        j(cVar.f80530d, iArr2, i11, i12, i13 + 1, paint, canvas);
    }

    public static a l(b0 b0Var, int i11) {
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
        int[] iArrC = c();
        int[] iArrD = d();
        int[] iArrE = e();
        while (i15 > 0) {
            int iH6 = b0Var.h(i13);
            int iH7 = b0Var.h(i13);
            if ((iH7 & 128) != 0) {
                iArr = iArrC;
            } else {
                iArr = (iH7 & 64) != 0 ? iArrD : iArrE;
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
            iArr[iH6] = f((byte) (255 - (iH2 & 255)), o0.q((int) (d11 + (1.402d * d12)), 0, 255), o0.q((int) ((d11 - (0.34414d * d13)) - (d12 * 0.71414d)), 0, 255), o0.q((int) (d11 + (d13 * 1.772d)), 0, 255));
            i15 = i12;
            iH5 = iH5;
            i13 = 8;
            i14 = 2;
        }
        return new a(iH5, iArrC, iArrD, iArrE);
    }

    public static C0904b m(b0 b0Var) {
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
        return new C0904b(iH2, iH3, i12, i11, i13, iH);
    }

    public static c n(b0 b0Var) {
        byte[] bArr;
        int iH = b0Var.h(16);
        b0Var.r(4);
        int iH2 = b0Var.h(2);
        boolean zG = b0Var.g();
        b0Var.r(1);
        byte[] bArr2 = o0.f35613f;
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

    public static d o(b0 b0Var, int i11) {
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

    public static f p(b0 b0Var, int i11) {
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

    public static void q(b0 b0Var, h hVar) {
        f fVar;
        int iH = b0Var.h(8);
        int iH2 = b0Var.h(16);
        int iH3 = b0Var.h(16);
        int iD = b0Var.d() + iH3;
        if (iH3 * 8 > b0Var.b()) {
            s.i("DvbParser", "Data field length exceeds limit");
            b0Var.r(b0Var.b());
            return;
        }
        switch (iH) {
            case 16:
                if (iH2 == hVar.f80554a) {
                    d dVar = hVar.f80562i;
                    d dVarO = o(b0Var, iH3);
                    if (dVarO.f80533c != 0) {
                        hVar.f80562i = dVarO;
                        hVar.f80556c.clear();
                        hVar.f80557d.clear();
                        hVar.f80558e.clear();
                    } else if (dVar != null && dVar.f80532b != dVarO.f80532b) {
                        hVar.f80562i = dVarO;
                    }
                }
                break;
            case 17:
                d dVar2 = hVar.f80562i;
                if (iH2 == hVar.f80554a && dVar2 != null) {
                    f fVarP = p(b0Var, iH3);
                    if (dVar2.f80533c == 0 && (fVar = hVar.f80556c.get(fVarP.f80537a)) != null) {
                        fVarP.a(fVar);
                    }
                    hVar.f80556c.put(fVarP.f80537a, fVarP);
                }
                break;
            case 18:
                if (iH2 == hVar.f80554a) {
                    a aVarL = l(b0Var, iH3);
                    hVar.f80557d.put(aVarL.f80517a, aVarL);
                } else if (iH2 == hVar.f80555b) {
                    a aVarL2 = l(b0Var, iH3);
                    hVar.f80559f.put(aVarL2.f80517a, aVarL2);
                }
                break;
            case 19:
                if (iH2 == hVar.f80554a) {
                    c cVarN = n(b0Var);
                    hVar.f80558e.put(cVarN.f80527a, cVarN);
                } else if (iH2 == hVar.f80555b) {
                    c cVarN2 = n(b0Var);
                    hVar.f80560g.put(cVarN2.f80527a, cVarN2);
                }
                break;
            case 20:
                if (iH2 == hVar.f80554a) {
                    hVar.f80561h = m(b0Var);
                }
                break;
        }
        b0Var.s(iD - b0Var.d());
    }

    public List<vh.b> b(byte[] bArr, int i11) {
        b0 b0Var = new b0(bArr, i11);
        while (b0Var.b() >= 48 && b0Var.h(8) == 15) {
            q(b0Var, this.f80515f);
        }
        h hVar = this.f80515f;
        d dVar = hVar.f80562i;
        if (dVar == null) {
            return Collections.emptyList();
        }
        C0904b c0904b = hVar.f80561h;
        if (c0904b == null) {
            c0904b = this.f80513d;
        }
        Bitmap bitmap = this.f80516g;
        if (bitmap == null || c0904b.f80521a + 1 != bitmap.getWidth() || c0904b.f80522b + 1 != this.f80516g.getHeight()) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(c0904b.f80521a + 1, c0904b.f80522b + 1, Bitmap.Config.ARGB_8888);
            this.f80516g = bitmapCreateBitmap;
            this.f80512c.setBitmap(bitmapCreateBitmap);
        }
        ArrayList arrayList = new ArrayList();
        SparseArray<e> sparseArray = dVar.f80534d;
        for (int i12 = 0; i12 < sparseArray.size(); i12++) {
            this.f80512c.save();
            e eVarValueAt = sparseArray.valueAt(i12);
            f fVar = this.f80515f.f80556c.get(sparseArray.keyAt(i12));
            int i13 = eVarValueAt.f80535a + c0904b.f80523c;
            int i14 = eVarValueAt.f80536b + c0904b.f80525e;
            this.f80512c.clipRect(i13, i14, Math.min(fVar.f80539c + i13, c0904b.f80524d), Math.min(fVar.f80540d + i14, c0904b.f80526f));
            a aVar = this.f80515f.f80557d.get(fVar.f80543g);
            if (aVar == null && (aVar = this.f80515f.f80559f.get(fVar.f80543g)) == null) {
                aVar = this.f80514e;
            }
            int i15 = 0;
            for (SparseArray<g> sparseArray2 = fVar.f80547k; i15 < sparseArray2.size(); sparseArray2 = sparseArray2) {
                int iKeyAt = sparseArray2.keyAt(i15);
                g gVarValueAt = sparseArray2.valueAt(i15);
                c cVar = this.f80515f.f80558e.get(iKeyAt);
                c cVar2 = cVar == null ? this.f80515f.f80560g.get(iKeyAt) : cVar;
                if (cVar2 != null) {
                    k(cVar2, aVar, fVar.f80542f, gVarValueAt.f80550c + i13, i14 + gVarValueAt.f80551d, cVar2.f80528b ? null : this.f80510a, this.f80512c);
                }
                i15++;
            }
            if (fVar.f80538b) {
                int i16 = fVar.f80542f;
                this.f80511b.setColor(i16 == 3 ? aVar.f80520d[fVar.f80544h] : i16 == 2 ? aVar.f80519c[fVar.f80545i] : aVar.f80518b[fVar.f80546j]);
                this.f80512c.drawRect(i13, i14, fVar.f80539c + i13, fVar.f80540d + i14, this.f80511b);
            }
            arrayList.add(new vh.b.C0875b().f(Bitmap.createBitmap(this.f80516g, i13, i14, fVar.f80539c, fVar.f80540d)).k(i13 / c0904b.f80521a).l(0).h(i14 / c0904b.f80522b, 0).i(0).n(fVar.f80539c / c0904b.f80521a).g(fVar.f80540d / c0904b.f80522b).a());
            this.f80512c.drawColor(0, PorterDuff.Mode.CLEAR);
            this.f80512c.restore();
        }
        return Collections.unmodifiableList(arrayList);
    }

    public void r() {
        this.f80515f.a();
    }
}
