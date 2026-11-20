package bn;

import an.f;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.transsion.gslb.Worker;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[][] f14284a = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[][] f14285b = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[][] f14286c = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, Worker.WHAT_QUIT, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, WebSocketProtocol.PAYLOAD_SHORT, -1}, new int[]{6, 26, 52, 78, 104, TsExtractor.TS_STREAM_TYPE_HDMV_DTS, -1}, new int[]{6, 30, 56, 82, 108, TsExtractor.TS_STREAM_TYPE_SPLICE_INFO, -1}, new int[]{6, 34, 60, 86, 112, TsExtractor.TS_STREAM_TYPE_DTS, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, WebSocketProtocol.PAYLOAD_SHORT, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, 132, 158}, new int[]{6, 32, 58, 84, Worker.WHAT_QUIT, 136, 162}, new int[]{6, 26, 54, 82, Worker.WHAT_QUIT, TsExtractor.TS_STREAM_TYPE_DTS, 166}, new int[]{6, 30, 58, 86, 114, 142, 170}};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[][] f14287d = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    public static void a(hm.a aVar, ErrorCorrectionLevel errorCorrectionLevel, f fVar, int i11, b bVar) throws WriterException {
        c(bVar);
        d(fVar, bVar);
        l(errorCorrectionLevel, i11, bVar);
        s(fVar, bVar);
        f(aVar, i11, bVar);
    }

    public static int b(int i11, int i12) {
        if (i12 == 0) {
            throw new IllegalArgumentException("0 polynomial");
        }
        int iN = n(i12);
        int iN2 = i11 << (iN - 1);
        while (n(iN2) >= iN) {
            iN2 ^= i12 << (n(iN2) - iN);
        }
        return iN2;
    }

    public static void c(b bVar) {
        bVar.a((byte) -1);
    }

    public static void d(f fVar, b bVar) throws WriterException {
        j(bVar);
        e(bVar);
        r(fVar, bVar);
        k(bVar);
    }

    public static void e(b bVar) throws WriterException {
        if (bVar.b(8, bVar.d() - 8) == 0) {
            throw new WriterException();
        }
        bVar.f(8, bVar.d() - 8, 1);
    }

    public static void f(hm.a aVar, int i11, b bVar) throws WriterException {
        boolean zH;
        int iE = bVar.e() - 1;
        int iD = bVar.d() - 1;
        int i12 = 0;
        int i13 = -1;
        while (iE > 0) {
            if (iE == 6) {
                iE--;
            }
            while (iD >= 0 && iD < bVar.d()) {
                for (int i14 = 0; i14 < 2; i14++) {
                    int i15 = iE - i14;
                    if (o(bVar.b(i15, iD))) {
                        if (i12 < aVar.m()) {
                            zH = aVar.h(i12);
                            i12++;
                        } else {
                            zH = false;
                        }
                        if (i11 != -1 && c.f(i11, i15, iD)) {
                            zH = !zH;
                        }
                        bVar.g(i15, iD, zH);
                    }
                }
                iD += i13;
            }
            i13 = -i13;
            iD += i13;
            iE -= 2;
        }
        if (i12 == aVar.m()) {
            return;
        }
        throw new WriterException("Not all bits consumed: " + i12 + '/' + aVar.m());
    }

    public static void g(int i11, int i12, b bVar) throws WriterException {
        for (int i13 = 0; i13 < 8; i13++) {
            int i14 = i11 + i13;
            if (!o(bVar.b(i14, i12))) {
                throw new WriterException();
            }
            bVar.f(i14, i12, 0);
        }
    }

    public static void h(int i11, int i12, b bVar) {
        for (int i13 = 0; i13 < 5; i13++) {
            int[] iArr = f14285b[i13];
            for (int i14 = 0; i14 < 5; i14++) {
                bVar.f(i11 + i14, i12 + i13, iArr[i14]);
            }
        }
    }

    public static void i(int i11, int i12, b bVar) {
        for (int i13 = 0; i13 < 7; i13++) {
            int[] iArr = f14284a[i13];
            for (int i14 = 0; i14 < 7; i14++) {
                bVar.f(i11 + i14, i12 + i13, iArr[i14]);
            }
        }
    }

    public static void j(b bVar) throws WriterException {
        int length = f14284a[0].length;
        i(0, 0, bVar);
        i(bVar.e() - length, 0, bVar);
        i(0, bVar.e() - length, bVar);
        g(0, 7, bVar);
        g(bVar.e() - 8, 7, bVar);
        g(0, bVar.e() - 8, bVar);
        m(7, 0, bVar);
        m(bVar.d() - 8, 0, bVar);
        m(7, bVar.d() - 7, bVar);
    }

    public static void k(b bVar) {
        int i11 = 8;
        while (i11 < bVar.e() - 8) {
            int i12 = i11 + 1;
            int i13 = i12 % 2;
            if (o(bVar.b(i11, 6))) {
                bVar.f(i11, 6, i13);
            }
            if (o(bVar.b(6, i11))) {
                bVar.f(6, i11, i13);
            }
            i11 = i12;
        }
    }

    public static void l(ErrorCorrectionLevel errorCorrectionLevel, int i11, b bVar) throws WriterException {
        int iD;
        hm.a aVar = new hm.a();
        p(errorCorrectionLevel, i11, aVar);
        for (int i12 = 0; i12 < aVar.m(); i12++) {
            boolean zH = aVar.h((aVar.m() - 1) - i12);
            int[] iArr = f14287d[i12];
            bVar.g(iArr[0], iArr[1], zH);
            int iE = 8;
            if (i12 < 8) {
                iE = (bVar.e() - i12) - 1;
                iD = 8;
            } else {
                iD = (bVar.d() - 7) + (i12 - 8);
            }
            bVar.g(iE, iD, zH);
        }
    }

    public static void m(int i11, int i12, b bVar) throws WriterException {
        for (int i13 = 0; i13 < 7; i13++) {
            int i14 = i12 + i13;
            if (!o(bVar.b(i11, i14))) {
                throw new WriterException();
            }
            bVar.f(i11, i14, 0);
        }
    }

    public static int n(int i11) {
        return 32 - Integer.numberOfLeadingZeros(i11);
    }

    public static boolean o(int i11) {
        return i11 == -1;
    }

    public static void p(ErrorCorrectionLevel errorCorrectionLevel, int i11, hm.a aVar) throws WriterException {
        if (!e.b(i11)) {
            throw new WriterException("Invalid mask pattern");
        }
        int bits = (errorCorrectionLevel.getBits() << 3) | i11;
        aVar.c(bits, 5);
        aVar.c(b(bits, 1335), 10);
        hm.a aVar2 = new hm.a();
        aVar2.c(21522, 15);
        aVar.v(aVar2);
        if (aVar.m() == 15) {
            return;
        }
        throw new WriterException("should not happen but we got: " + aVar.m());
    }

    public static void q(f fVar, hm.a aVar) throws WriterException {
        aVar.c(fVar.j(), 6);
        aVar.c(b(fVar.j(), 7973), 12);
        if (aVar.m() == 18) {
            return;
        }
        throw new WriterException("should not happen but we got: " + aVar.m());
    }

    public static void r(f fVar, b bVar) {
        if (fVar.j() < 2) {
            return;
        }
        int[] iArr = f14286c[fVar.j() - 1];
        for (int i11 : iArr) {
            if (i11 >= 0) {
                for (int i12 : iArr) {
                    if (i12 >= 0 && o(bVar.b(i12, i11))) {
                        h(i12 - 2, i11 - 2, bVar);
                    }
                }
            }
        }
    }

    public static void s(f fVar, b bVar) throws WriterException {
        if (fVar.j() < 7) {
            return;
        }
        hm.a aVar = new hm.a();
        q(fVar, aVar);
        int i11 = 17;
        for (int i12 = 0; i12 < 6; i12++) {
            for (int i13 = 0; i13 < 3; i13++) {
                boolean zH = aVar.h(i11);
                i11--;
                bVar.g(i12, (bVar.d() - 11) + i13, zH);
                bVar.g((bVar.d() - 11) + i13, i12, zH);
            }
        }
    }
}
