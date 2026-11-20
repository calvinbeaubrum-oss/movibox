package tm;

import com.google.zxing.NotFoundException;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg.DefaultOggSeeker;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class e extends i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f77232c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f77233d;

    public e(hm.a aVar, String str, String str2) {
        super(aVar);
        this.f77232c = str2;
        this.f77233d = str;
    }

    @Override // tm.j
    public String d() throws NotFoundException {
        if (c().m() != 84) {
            throw NotFoundException.getNotFoundInstance();
        }
        StringBuilder sb2 = new StringBuilder();
        f(sb2, 8);
        j(sb2, 48, 20);
        k(sb2, 68);
        return sb2.toString();
    }

    @Override // tm.i
    public void h(StringBuilder sb2, int i11) {
        sb2.append('(');
        sb2.append(this.f77233d);
        sb2.append(i11 / DefaultOggSeeker.MATCH_BYTE_RANGE);
        sb2.append(')');
    }

    @Override // tm.i
    public int i(int i11) {
        return i11 % DefaultOggSeeker.MATCH_BYTE_RANGE;
    }

    public final void k(StringBuilder sb2, int i11) {
        int iF = b().f(i11, 16);
        if (iF == 38400) {
            return;
        }
        sb2.append('(');
        sb2.append(this.f77232c);
        sb2.append(')');
        int i12 = iF % 32;
        int i13 = iF / 32;
        int i14 = (i13 % 12) + 1;
        int i15 = i13 / 12;
        if (i15 / 10 == 0) {
            sb2.append('0');
        }
        sb2.append(i15);
        if (i14 / 10 == 0) {
            sb2.append('0');
        }
        sb2.append(i14);
        if (i12 / 10 == 0) {
            sb2.append('0');
        }
        sb2.append(i12);
    }
}
