package ei;

import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.o0;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a extends vh.h {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c0 f64213o;

    public a() {
        super("Mp4WebvttDecoder");
        this.f64213o = new c0();
    }

    public static vh.b x(c0 c0Var, int i11) throws SubtitleDecoderException {
        CharSequence charSequenceQ = null;
        vh.b.C0875b c0875bO = null;
        while (i11 > 0) {
            if (i11 < 8) {
                throw new SubtitleDecoderException("Incomplete vtt cue box header found.");
            }
            int iN = c0Var.n();
            int iN2 = c0Var.n();
            int i12 = iN - 8;
            String strE = o0.E(c0Var.d(), c0Var.e(), i12);
            c0Var.Q(i12);
            i11 = (i11 - 8) - i12;
            if (iN2 == 1937011815) {
                c0875bO = f.o(strE);
            } else if (iN2 == 1885436268) {
                charSequenceQ = f.q(null, strE.trim(), Collections.emptyList());
            }
        }
        if (charSequenceQ == null) {
            charSequenceQ = "";
        }
        return c0875bO != null ? c0875bO.o(charSequenceQ).a() : f.l(charSequenceQ);
    }

    @Override // vh.h
    public vh.i w(byte[] bArr, int i11, boolean z11) throws SubtitleDecoderException {
        this.f64213o.N(bArr, i11);
        ArrayList arrayList = new ArrayList();
        while (this.f64213o.a() > 0) {
            if (this.f64213o.a() < 8) {
                throw new SubtitleDecoderException("Incomplete Mp4Webvtt Top Level box header found.");
            }
            int iN = this.f64213o.n();
            if (this.f64213o.n() == 1987343459) {
                arrayList.add(x(this.f64213o, iN - 8));
            } else {
                this.f64213o.Q(iN - 8);
            }
        }
        return new b(arrayList);
    }
}
