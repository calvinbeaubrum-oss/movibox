package com.applovin.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import androidx.core.view.ViewCompat;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class k7 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final byte[] f20131h = {0, 7, 8, Ascii.SI};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final byte[] f20132i = {0, 119, -120, -1};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final byte[] f20133j = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Paint f20134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Paint f20135b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Canvas f20136c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b f20137d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final a f20138e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final h f20139f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Bitmap f20140g;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f20141a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f20142b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int[] f20143c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int[] f20144d;

        public a(int i11, int[] iArr, int[] iArr2, int[] iArr3) {
            this.f20141a = i11;
            this.f20142b = iArr;
            this.f20143c = iArr2;
            this.f20144d = iArr3;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f20145a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f20146b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f20147c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f20148d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f20149e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f20150f;

        public b(int i11, int i12, int i13, int i14, int i15, int i16) {
            this.f20145a = i11;
            this.f20146b = i12;
            this.f20147c = i13;
            this.f20148d = i14;
            this.f20149e = i15;
            this.f20150f = i16;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f20151a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f20152b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f20153c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final byte[] f20154d;

        public c(int i11, boolean z11, byte[] bArr, byte[] bArr2) {
            this.f20151a = i11;
            this.f20152b = z11;
            this.f20153c = bArr;
            this.f20154d = bArr2;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f20155a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f20156b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f20157c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final SparseArray f20158d;

        public d(int i11, int i12, int i13, SparseArray sparseArray) {
            this.f20155a = i11;
            this.f20156b = i12;
            this.f20157c = i13;
            this.f20158d = sparseArray;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f20159a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f20160b;

        public e(int i11, int i12) {
            this.f20159a = i11;
            this.f20160b = i12;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f20161a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f20162b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f20163c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f20164d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f20165e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f20166f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f20167g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f20168h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f20169i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f20170j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final SparseArray f20171k;

        public f(int i11, boolean z11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, SparseArray sparseArray) {
            this.f20161a = i11;
            this.f20162b = z11;
            this.f20163c = i12;
            this.f20164d = i13;
            this.f20165e = i14;
            this.f20166f = i15;
            this.f20167g = i16;
            this.f20168h = i17;
            this.f20169i = i18;
            this.f20170j = i19;
            this.f20171k = sparseArray;
        }

        public void a(f fVar) {
            SparseArray sparseArray = fVar.f20171k;
            for (int i11 = 0; i11 < sparseArray.size(); i11++) {
                this.f20171k.put(sparseArray.keyAt(i11), (g) sparseArray.valueAt(i11));
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f20172a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f20173b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f20174c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f20175d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f20176e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f20177f;

        public g(int i11, int i12, int i13, int i14, int i15, int i16) {
            this.f20172a = i11;
            this.f20173b = i12;
            this.f20174c = i13;
            this.f20175d = i14;
            this.f20176e = i15;
            this.f20177f = i16;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f20178a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f20179b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final SparseArray f20180c = new SparseArray();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final SparseArray f20181d = new SparseArray();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final SparseArray f20182e = new SparseArray();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final SparseArray f20183f = new SparseArray();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final SparseArray f20184g = new SparseArray();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public b f20185h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public d f20186i;

        public h(int i11, int i12) {
            this.f20178a = i11;
            this.f20179b = i12;
        }

        public void a() {
            this.f20180c.clear();
            this.f20181d.clear();
            this.f20182e.clear();
            this.f20183f.clear();
            this.f20184g.clear();
            this.f20185h = null;
            this.f20186i = null;
        }
    }

    public k7(int i11, int i12) {
        Paint paint = new Paint();
        this.f20134a = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.f20135b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.f20136c = new Canvas();
        this.f20137d = new b(719, 575, 0, 719, 0, 575);
        this.f20138e = new a(0, a(), b(), c());
        this.f20139f = new h(i11, i12);
    }

    private static int a(int i11, int i12, int i13, int i14) {
        return (i11 << 24) | (i12 << 16) | (i13 << 8) | i14;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0063 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:28:0x0067  */
    /* JADX WARN: Code duplicated, block: B:33:0x0083 A[LOOP:0: B:3:0x0009->B:33:0x0083, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:34:0x0082 A[SYNTHETIC] */
    private static int a(ah ahVar, int[] iArr, byte[] bArr, int i11, int i12, Paint paint, Canvas canvas) {
        int i13;
        int iA;
        int iA2;
        int i14 = i11;
        boolean z11 = false;
        while (true) {
            int iA3 = ahVar.a(2);
            if (iA3 == 0) {
                if (ahVar.f()) {
                    iA = ahVar.a(3) + 3;
                    iA2 = ahVar.a(2);
                } else {
                    if (ahVar.f()) {
                        iA3 = 0;
                    } else {
                        int iA4 = ahVar.a(2);
                        if (iA4 == 0) {
                            iA3 = 0;
                            z11 = true;
                        } else if (iA4 == 1) {
                            z11 = z11;
                            iA3 = 0;
                            i13 = 2;
                        } else if (iA4 == 2) {
                            iA = ahVar.a(4) + 12;
                            iA2 = ahVar.a(2);
                        } else if (iA4 != 3) {
                            z11 = z11;
                            iA3 = 0;
                        } else {
                            iA = ahVar.a(8) + 29;
                            iA2 = ahVar.a(2);
                        }
                        i13 = 0;
                    }
                    if (i13 != 0 && paint != null) {
                        if (bArr != null) {
                            iA3 = bArr[iA3];
                        }
                        paint.setColor(iArr[iA3]);
                        canvas.drawRect(i14, i12, i14 + i13, i12 + 1, paint);
                    }
                    i14 += i13;
                    if (z11) {
                        return i14;
                    }
                    z11 = z11;
                }
                z11 = z11;
                i13 = iA;
                iA3 = iA2;
                if (i13 != 0) {
                    if (bArr != null) {
                        iA3 = bArr[iA3];
                    }
                    paint.setColor(iArr[iA3]);
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
                    iA3 = bArr[iA3];
                }
                paint.setColor(iArr[iA3]);
                canvas.drawRect(i14, i12, i14 + i13, i12 + 1, paint);
            }
            i14 += i13;
            if (z11) {
                return i14;
            }
            z11 = z11;
        }
    }

    private static a a(ah ahVar, int i11) {
        int[] iArr;
        int iA;
        int i12;
        int iA2;
        int iA3;
        int iA4;
        int i13 = 8;
        int iA5 = ahVar.a(8);
        ahVar.d(8);
        int i14 = 2;
        int i15 = i11 - 2;
        int[] iArrA = a();
        int[] iArrB = b();
        int[] iArrC = c();
        while (i15 > 0) {
            int iA6 = ahVar.a(i13);
            int iA7 = ahVar.a(i13);
            if ((iA7 & 128) != 0) {
                iArr = iArrA;
            } else {
                iArr = (iA7 & 64) != 0 ? iArrB : iArrC;
            }
            if ((iA7 & 1) != 0) {
                iA3 = ahVar.a(i13);
                iA4 = ahVar.a(i13);
                iA = ahVar.a(i13);
                iA2 = ahVar.a(i13);
                i12 = i15 - 6;
            } else {
                int iA8 = ahVar.a(6) << i14;
                int iA9 = ahVar.a(4) << 4;
                iA = ahVar.a(4) << 4;
                i12 = i15 - 4;
                iA2 = ahVar.a(i14) << 6;
                iA3 = iA8;
                iA4 = iA9;
            }
            if (iA3 == 0) {
                iA4 = 0;
                iA = 0;
                iA2 = 255;
            }
            double d11 = iA3;
            double d12 = iA4 - 128;
            double d13 = iA - 128;
            iArr[iA6] = a((byte) (255 - (iA2 & 255)), xp.a((int) (d11 + (1.402d * d12)), 0, 255), xp.a((int) ((d11 - (0.34414d * d13)) - (d12 * 0.71414d)), 0, 255), xp.a((int) (d11 + (d13 * 1.772d)), 0, 255));
            i15 = i12;
            iA5 = iA5;
            i13 = 8;
            i14 = 2;
        }
        return new a(iA5, iArrA, iArrB, iArrC);
    }

    private static b a(ah ahVar) {
        int i11;
        int iA;
        int i12;
        int i13;
        ahVar.d(4);
        boolean zF = ahVar.f();
        ahVar.d(3);
        int iA2 = ahVar.a(16);
        int iA3 = ahVar.a(16);
        if (zF) {
            int iA4 = ahVar.a(16);
            int iA5 = ahVar.a(16);
            int iA6 = ahVar.a(16);
            iA = ahVar.a(16);
            i11 = iA5;
            i13 = iA6;
            i12 = iA4;
        } else {
            i11 = iA2;
            iA = iA3;
            i12 = 0;
            i13 = 0;
        }
        return new b(iA2, iA3, i12, i11, i13, iA);
    }

    private static void a(ah ahVar, h hVar) {
        f fVar;
        int iA = ahVar.a(8);
        int iA2 = ahVar.a(16);
        int iA3 = ahVar.a(16);
        int iD = ahVar.d() + iA3;
        if (iA3 * 8 > ahVar.b()) {
            pc.d("DvbParser", "Data field length exceeds limit");
            ahVar.d(ahVar.b());
            return;
        }
        switch (iA) {
            case 16:
                if (iA2 == hVar.f20178a) {
                    d dVar = hVar.f20186i;
                    d dVarB = b(ahVar, iA3);
                    if (dVarB.f20157c != 0) {
                        hVar.f20186i = dVarB;
                        hVar.f20180c.clear();
                        hVar.f20181d.clear();
                        hVar.f20182e.clear();
                    } else if (dVar != null && dVar.f20156b != dVarB.f20156b) {
                        hVar.f20186i = dVarB;
                    }
                }
                break;
            case 17:
                d dVar2 = hVar.f20186i;
                if (iA2 == hVar.f20178a && dVar2 != null) {
                    f fVarC = c(ahVar, iA3);
                    if (dVar2.f20157c == 0 && (fVar = (f) hVar.f20180c.get(fVarC.f20161a)) != null) {
                        fVarC.a(fVar);
                    }
                    hVar.f20180c.put(fVarC.f20161a, fVarC);
                }
                break;
            case 18:
                if (iA2 == hVar.f20178a) {
                    a aVarA = a(ahVar, iA3);
                    hVar.f20181d.put(aVarA.f20141a, aVarA);
                } else if (iA2 == hVar.f20179b) {
                    a aVarA2 = a(ahVar, iA3);
                    hVar.f20183f.put(aVarA2.f20141a, aVarA2);
                }
                break;
            case 19:
                if (iA2 == hVar.f20178a) {
                    c cVarB = b(ahVar);
                    hVar.f20182e.put(cVarB.f20151a, cVarB);
                } else if (iA2 == hVar.f20179b) {
                    c cVarB2 = b(ahVar);
                    hVar.f20184g.put(cVarB2.f20151a, cVarB2);
                }
                break;
            case 20:
                if (iA2 == hVar.f20178a) {
                    hVar.f20185h = a(ahVar);
                }
                break;
        }
        ahVar.e(iD - ahVar.d());
    }

    private static void a(c cVar, a aVar, int i11, int i12, int i13, Paint paint, Canvas canvas) {
        int[] iArr;
        if (i11 == 3) {
            iArr = aVar.f20144d;
        } else {
            iArr = i11 == 2 ? aVar.f20143c : aVar.f20142b;
        }
        int[] iArr2 = iArr;
        a(cVar.f20153c, iArr2, i11, i12, i13, paint, canvas);
        a(cVar.f20154d, iArr2, i11, i12, i13 + 1, paint, canvas);
    }

    private static void a(byte[] bArr, int[] iArr, int i11, int i12, int i13, Paint paint, Canvas canvas) {
        byte[] bArr2;
        byte[] bArr3;
        byte[] bArr4;
        ah ahVar = new ah(bArr);
        int iA = i12;
        int i14 = i13;
        byte[] bArrA = null;
        byte[] bArrA2 = null;
        byte[] bArrA3 = null;
        while (ahVar.b() != 0) {
            int iA2 = ahVar.a(8);
            if (iA2 != 240) {
                switch (iA2) {
                    case 16:
                        if (i11 == 3) {
                            if (bArrA == null) {
                                bArr3 = f20132i;
                                bArr2 = bArr3;
                            } else {
                                bArr2 = bArrA;
                            }
                        } else if (i11 != 2) {
                            bArr2 = null;
                        } else if (bArrA3 == null) {
                            bArr3 = f20131h;
                            bArr2 = bArr3;
                        } else {
                            bArr2 = bArrA3;
                        }
                        iA = a(ahVar, iArr, bArr2, iA, i14, paint, canvas);
                        ahVar.c();
                        break;
                    case 17:
                        if (i11 == 3) {
                            bArr4 = bArrA2 == null ? f20133j : bArrA2;
                        } else {
                            bArr4 = null;
                        }
                        iA = b(ahVar, iArr, bArr4, iA, i14, paint, canvas);
                        ahVar.c();
                        break;
                    case 18:
                        iA = c(ahVar, iArr, null, iA, i14, paint, canvas);
                        break;
                    default:
                        switch (iA2) {
                            case 32:
                                bArrA3 = a(4, 4, ahVar);
                                break;
                            case 33:
                                bArrA = a(4, 8, ahVar);
                                break;
                            case 34:
                                bArrA2 = a(16, 8, ahVar);
                                break;
                        }
                        break;
                }
            } else {
                i14 += 2;
                iA = i12;
            }
        }
    }

    private static byte[] a(int i11, int i12, ah ahVar) {
        byte[] bArr = new byte[i11];
        for (int i13 = 0; i13 < i11; i13++) {
            bArr[i13] = (byte) ahVar.a(i12);
        }
        return bArr;
    }

    private static int[] a() {
        return new int[]{0, -1, ViewCompat.MEASURED_STATE_MASK, -8421505};
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0074  */
    /* JADX WARN: Code duplicated, block: B:36:0x0090 A[LOOP:0: B:3:0x0009->B:36:0x0090, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:37:0x008f A[SYNTHETIC] */
    private static int b(ah ahVar, int[] iArr, byte[] bArr, int i11, int i12, Paint paint, Canvas canvas) {
        int i13;
        int iA;
        int iA2;
        int i14 = i11;
        boolean z11 = false;
        while (true) {
            int iA3 = ahVar.a(4);
            if (iA3 == 0) {
                if (ahVar.f()) {
                    if (ahVar.f()) {
                        int iA4 = ahVar.a(2);
                        if (iA4 == 0) {
                            iA3 = 0;
                        } else if (iA4 == 1) {
                            z11 = z11;
                            iA3 = 0;
                            i13 = 2;
                        } else if (iA4 == 2) {
                            iA = ahVar.a(4) + 9;
                            iA2 = ahVar.a(4);
                        } else if (iA4 != 3) {
                            z11 = z11;
                            iA3 = 0;
                            i13 = 0;
                        } else {
                            iA = ahVar.a(8) + 25;
                            iA2 = ahVar.a(4);
                        }
                    } else {
                        iA = ahVar.a(2) + 4;
                        iA2 = ahVar.a(4);
                    }
                    z11 = z11;
                    i13 = iA;
                    iA3 = iA2;
                } else {
                    int iA5 = ahVar.a(3);
                    if (iA5 != 0) {
                        z11 = z11;
                        i13 = iA5 + 2;
                        iA3 = 0;
                    } else {
                        iA3 = 0;
                        z11 = true;
                        i13 = 0;
                    }
                }
                if (i13 != 0 && paint != null) {
                    if (bArr != null) {
                        iA3 = bArr[iA3];
                    }
                    paint.setColor(iArr[iA3]);
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
                    iA3 = bArr[iA3];
                }
                paint.setColor(iArr[iA3]);
                canvas.drawRect(i14, i12, i14 + i13, i12 + 1, paint);
            }
            i14 += i13;
            if (z11) {
                return i14;
            }
            z11 = z11;
        }
    }

    private static c b(ah ahVar) {
        byte[] bArr;
        int iA = ahVar.a(16);
        ahVar.d(4);
        int iA2 = ahVar.a(2);
        boolean zF = ahVar.f();
        ahVar.d(1);
        byte[] bArr2 = xp.f24377f;
        if (iA2 != 1) {
            if (iA2 == 0) {
                int iA3 = ahVar.a(16);
                int iA4 = ahVar.a(16);
                if (iA3 > 0) {
                    bArr2 = new byte[iA3];
                    ahVar.b(bArr2, 0, iA3);
                }
                if (iA4 > 0) {
                    bArr = new byte[iA4];
                    ahVar.b(bArr, 0, iA4);
                }
            }
            return new c(iA, zF, bArr2, bArr);
        }
        ahVar.d(ahVar.a(8) * 16);
        bArr = bArr2;
        return new c(iA, zF, bArr2, bArr);
    }

    private static d b(ah ahVar, int i11) {
        int iA = ahVar.a(8);
        int iA2 = ahVar.a(4);
        int iA3 = ahVar.a(2);
        ahVar.d(2);
        int i12 = i11 - 2;
        SparseArray sparseArray = new SparseArray();
        while (i12 > 0) {
            int iA4 = ahVar.a(8);
            ahVar.d(8);
            i12 -= 6;
            sparseArray.put(iA4, new e(ahVar.a(16), ahVar.a(16)));
        }
        return new d(iA, iA2, iA3, sparseArray);
    }

    private static int[] b() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i11 = 1; i11 < 16; i11++) {
            if (i11 < 8) {
                iArr[i11] = a(255, (i11 & 1) != 0 ? 255 : 0, (i11 & 2) != 0 ? 255 : 0, (i11 & 4) != 0 ? 255 : 0);
            } else {
                iArr[i11] = a(255, (i11 & 1) != 0 ? 127 : 0, (i11 & 2) != 0 ? 127 : 0, (i11 & 4) == 0 ? 0 : 127);
            }
        }
        return iArr;
    }

    private static int c(ah ahVar, int[] iArr, byte[] bArr, int i11, int i12, Paint paint, Canvas canvas) {
        boolean z11;
        int iA;
        int i13 = i11;
        boolean z12 = false;
        while (true) {
            int iA2 = ahVar.a(8);
            if (iA2 != 0) {
                z11 = z12;
                iA = 1;
            } else if (ahVar.f()) {
                z11 = z12;
                iA = ahVar.a(7);
                iA2 = ahVar.a(8);
            } else {
                int iA3 = ahVar.a(7);
                if (iA3 != 0) {
                    z11 = z12;
                    iA = iA3;
                    iA2 = 0;
                } else {
                    iA2 = 0;
                    z11 = true;
                    iA = 0;
                }
            }
            if (iA != 0 && paint != null) {
                if (bArr != null) {
                    iA2 = bArr[iA2];
                }
                paint.setColor(iArr[iA2]);
                canvas.drawRect(i13, i12, i13 + iA, i12 + 1, paint);
            }
            i13 += iA;
            if (z11) {
                return i13;
            }
            z12 = z11;
        }
    }

    private static f c(ah ahVar, int i11) {
        int iA;
        int iA2;
        int iA3 = ahVar.a(8);
        ahVar.d(4);
        boolean zF = ahVar.f();
        ahVar.d(3);
        int i12 = 16;
        int iA4 = ahVar.a(16);
        int iA5 = ahVar.a(16);
        int iA6 = ahVar.a(3);
        int iA7 = ahVar.a(3);
        int i13 = 2;
        ahVar.d(2);
        int iA8 = ahVar.a(8);
        int iA9 = ahVar.a(8);
        int iA10 = ahVar.a(4);
        int iA11 = ahVar.a(2);
        ahVar.d(2);
        int i14 = i11 - 10;
        SparseArray sparseArray = new SparseArray();
        while (i14 > 0) {
            int iA12 = ahVar.a(i12);
            int iA13 = ahVar.a(i13);
            int iA14 = ahVar.a(i13);
            int iA15 = ahVar.a(12);
            int i15 = iA11;
            ahVar.d(4);
            int iA16 = ahVar.a(12);
            int i16 = i14 - 6;
            if (iA13 == 1 || iA13 == 2) {
                i14 -= 8;
                iA2 = ahVar.a(8);
                iA = ahVar.a(8);
            } else {
                i14 = i16;
                iA2 = 0;
                iA = 0;
            }
            sparseArray.put(iA12, new g(iA13, iA14, iA15, iA16, iA2, iA));
            iA11 = i15;
            i13 = 2;
            i12 = 16;
        }
        return new f(iA3, zF, iA4, iA5, iA6, iA7, iA8, iA9, iA10, iA11, sparseArray);
    }

    private static int[] c() {
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i11 = 0; i11 < 256; i11++) {
            if (i11 < 8) {
                iArr[i11] = a(63, (i11 & 1) != 0 ? 255 : 0, (i11 & 2) != 0 ? 255 : 0, (i11 & 4) == 0 ? 0 : 255);
            } else {
                int i12 = i11 & 136;
                if (i12 == 0) {
                    iArr[i11] = a(255, ((i11 & 1) != 0 ? 85 : 0) + ((i11 & 16) != 0 ? 170 : 0), ((i11 & 2) != 0 ? 85 : 0) + ((i11 & 32) != 0 ? 170 : 0), ((i11 & 4) == 0 ? 0 : 85) + ((i11 & 64) == 0 ? 0 : 170));
                } else if (i12 == 8) {
                    iArr[i11] = a(127, ((i11 & 1) != 0 ? 85 : 0) + ((i11 & 16) != 0 ? 170 : 0), ((i11 & 2) != 0 ? 85 : 0) + ((i11 & 32) != 0 ? 170 : 0), ((i11 & 4) == 0 ? 0 : 85) + ((i11 & 64) == 0 ? 0 : 170));
                } else if (i12 == 128) {
                    iArr[i11] = a(255, ((i11 & 1) != 0 ? 43 : 0) + 127 + ((i11 & 16) != 0 ? 85 : 0), ((i11 & 2) != 0 ? 43 : 0) + 127 + ((i11 & 32) != 0 ? 85 : 0), ((i11 & 4) == 0 ? 0 : 43) + 127 + ((i11 & 64) == 0 ? 0 : 85));
                } else if (i12 == 136) {
                    iArr[i11] = a(255, ((i11 & 1) != 0 ? 43 : 0) + ((i11 & 16) != 0 ? 85 : 0), ((i11 & 2) != 0 ? 43 : 0) + ((i11 & 32) != 0 ? 85 : 0), ((i11 & 4) == 0 ? 0 : 43) + ((i11 & 64) == 0 ? 0 : 85));
                }
            }
        }
        return iArr;
    }

    public List a(byte[] bArr, int i11) {
        ah ahVar = new ah(bArr, i11);
        while (ahVar.b() >= 48 && ahVar.a(8) == 15) {
            a(ahVar, this.f20139f);
        }
        h hVar = this.f20139f;
        d dVar = hVar.f20186i;
        if (dVar == null) {
            return Collections.emptyList();
        }
        b bVar = hVar.f20185h;
        if (bVar == null) {
            bVar = this.f20137d;
        }
        Bitmap bitmap = this.f20140g;
        if (bitmap == null || bVar.f20145a + 1 != bitmap.getWidth() || bVar.f20146b + 1 != this.f20140g.getHeight()) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bVar.f20145a + 1, bVar.f20146b + 1, Bitmap.Config.ARGB_8888);
            this.f20140g = bitmapCreateBitmap;
            this.f20136c.setBitmap(bitmapCreateBitmap);
        }
        ArrayList arrayList = new ArrayList();
        SparseArray sparseArray = dVar.f20158d;
        for (int i12 = 0; i12 < sparseArray.size(); i12++) {
            this.f20136c.save();
            e eVar = (e) sparseArray.valueAt(i12);
            f fVar = (f) this.f20139f.f20180c.get(sparseArray.keyAt(i12));
            int i13 = eVar.f20159a + bVar.f20147c;
            int i14 = eVar.f20160b + bVar.f20149e;
            this.f20136c.clipRect(i13, i14, Math.min(fVar.f20163c + i13, bVar.f20148d), Math.min(fVar.f20164d + i14, bVar.f20150f));
            a aVar = (a) this.f20139f.f20181d.get(fVar.f20167g);
            if (aVar == null && (aVar = (a) this.f20139f.f20183f.get(fVar.f20167g)) == null) {
                aVar = this.f20138e;
            }
            int i15 = 0;
            for (SparseArray sparseArray2 = fVar.f20171k; i15 < sparseArray2.size(); sparseArray2 = sparseArray2) {
                int iKeyAt = sparseArray2.keyAt(i15);
                g gVar = (g) sparseArray2.valueAt(i15);
                c cVar = (c) this.f20139f.f20182e.get(iKeyAt);
                c cVar2 = cVar == null ? (c) this.f20139f.f20184g.get(iKeyAt) : cVar;
                if (cVar2 != null) {
                    a(cVar2, aVar, fVar.f20166f, gVar.f20174c + i13, i14 + gVar.f20175d, cVar2.f20152b ? null : this.f20134a, this.f20136c);
                }
                i15++;
            }
            if (fVar.f20162b) {
                int i16 = fVar.f20166f;
                this.f20135b.setColor(i16 == 3 ? aVar.f20144d[fVar.f20168h] : i16 == 2 ? aVar.f20143c[fVar.f20169i] : aVar.f20142b[fVar.f20170j]);
                this.f20136c.drawRect(i13, i14, fVar.f20163c + i13, fVar.f20164d + i14, this.f20135b);
            }
            arrayList.add(new b5.b().a(Bitmap.createBitmap(this.f20140g, i13, i14, fVar.f20163c, fVar.f20164d)).b(i13 / bVar.f20145a).b(0).a(i14 / bVar.f20146b, 0).a(0).d(fVar.f20163c / bVar.f20145a).a(fVar.f20164d / bVar.f20146b).a());
            this.f20136c.drawColor(0, PorterDuff.Mode.CLEAR);
            this.f20136c.restore();
        }
        return Collections.unmodifiableList(arrayList);
    }

    public void d() {
        this.f20139f.a();
    }
}
