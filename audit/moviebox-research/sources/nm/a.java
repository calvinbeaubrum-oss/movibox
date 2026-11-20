package nm;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class a implements g {
    public static char b(char c11, char c12) {
        if (j.f(c11) && j.f(c12)) {
            return (char) (((c11 - '0') * 10) + (c12 - '0') + TsExtractor.TS_STREAM_TYPE_HDMV_DTS);
        }
        throw new IllegalArgumentException("not digits: " + c11 + c12);
    }

    @Override // nm.g
    public void a(h hVar) {
        if (j.a(hVar.d(), hVar.f72074f) >= 2) {
            hVar.r(b(hVar.d().charAt(hVar.f72074f), hVar.d().charAt(hVar.f72074f + 1)));
            hVar.f72074f += 2;
            return;
        }
        char c11 = hVar.c();
        int iN = j.n(hVar.d(), hVar.f72074f, c());
        if (iN == c()) {
            if (!j.g(c11)) {
                hVar.r((char) (c11 + 1));
                hVar.f72074f++;
                return;
            } else {
                hVar.r((char) 235);
                hVar.r((char) (c11 - 127));
                hVar.f72074f++;
                return;
            }
        }
        if (iN == 1) {
            hVar.r((char) 230);
            hVar.o(1);
            return;
        }
        if (iN == 2) {
            hVar.r((char) 239);
            hVar.o(2);
            return;
        }
        if (iN == 3) {
            hVar.r((char) 238);
            hVar.o(3);
            return;
        }
        if (iN == 4) {
            hVar.r((char) 240);
            hVar.o(4);
        } else if (iN == 5) {
            hVar.r((char) 231);
            hVar.o(5);
        } else {
            throw new IllegalStateException("Illegal mode: " + iN);
        }
    }

    public int c() {
        return 0;
    }
}
