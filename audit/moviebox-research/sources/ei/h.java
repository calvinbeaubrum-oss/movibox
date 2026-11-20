package ei;

import android.text.TextUtils;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.c0;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class h extends vh.h {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c0 f64263o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final c f64264p;

    public h() {
        super("WebvttDecoder");
        this.f64263o = new c0();
        this.f64264p = new c();
    }

    public static int x(c0 c0Var) {
        int i11 = -1;
        int iE = 0;
        while (i11 == -1) {
            iE = c0Var.e();
            String strP = c0Var.p();
            if (strP == null) {
                i11 = 0;
            } else if ("STYLE".equals(strP)) {
                i11 = 2;
            } else {
                i11 = strP.startsWith("NOTE") ? 1 : 3;
            }
        }
        c0Var.P(iE);
        return i11;
    }

    public static void y(c0 c0Var) {
        while (!TextUtils.isEmpty(c0Var.p())) {
        }
    }

    @Override // vh.h
    public vh.i w(byte[] bArr, int i11, boolean z11) throws SubtitleDecoderException {
        e eVarM;
        this.f64263o.N(bArr, i11);
        ArrayList arrayList = new ArrayList();
        try {
            i.e(this.f64263o);
            while (!TextUtils.isEmpty(this.f64263o.p())) {
            }
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                int iX = x(this.f64263o);
                if (iX == 0) {
                    return new k(arrayList2);
                }
                if (iX == 1) {
                    y(this.f64263o);
                } else if (iX == 2) {
                    if (!arrayList2.isEmpty()) {
                        throw new SubtitleDecoderException("A style block was found after the first cue.");
                    }
                    this.f64263o.p();
                    arrayList.addAll(this.f64264p.d(this.f64263o));
                } else if (iX == 3 && (eVarM = f.m(this.f64263o, arrayList)) != null) {
                    arrayList2.add(eVarM);
                }
            }
        } catch (ParserException e11) {
            throw new SubtitleDecoderException(e11);
        }
    }
}
