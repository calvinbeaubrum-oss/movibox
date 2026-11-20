package tm;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg.DefaultOggSeeker;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class i extends h {
    public i(hm.a aVar) {
        super(aVar);
    }

    public abstract void h(StringBuilder sb2, int i11);

    public abstract int i(int i11);

    public final void j(StringBuilder sb2, int i11, int i12) {
        int iF = b().f(i11, i12);
        h(sb2, iF);
        int i13 = i(iF);
        int i14 = DefaultOggSeeker.MATCH_BYTE_RANGE;
        for (int i15 = 0; i15 < 5; i15++) {
            if (i13 / i14 == 0) {
                sb2.append('0');
            }
            i14 /= 10;
        }
        sb2.append(i13);
    }
}
