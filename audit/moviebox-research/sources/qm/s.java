package qm;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class s extends x {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final x f74842i = new h();

    public static com.google.zxing.j s(com.google.zxing.j jVar) throws FormatException {
        String strF = jVar.f();
        if (strF.charAt(0) != '0') {
            throw FormatException.getFormatInstance();
        }
        com.google.zxing.j jVar2 = new com.google.zxing.j(strF.substring(1), null, jVar.e(), BarcodeFormat.UPC_A);
        if (jVar.d() != null) {
            jVar2.g(jVar.d());
        }
        return jVar2;
    }

    @Override // qm.q, com.google.zxing.i
    public com.google.zxing.j a(com.google.zxing.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        return s(this.f74842i.a(bVar, map));
    }

    @Override // qm.q, com.google.zxing.i
    public com.google.zxing.j b(com.google.zxing.b bVar) throws NotFoundException, FormatException {
        return s(this.f74842i.b(bVar));
    }

    @Override // qm.x, qm.q
    public com.google.zxing.j c(int i11, hm.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        return s(this.f74842i.c(i11, aVar, map));
    }

    @Override // qm.x
    public int l(hm.a aVar, int[] iArr, StringBuilder sb2) throws NotFoundException {
        return this.f74842i.l(aVar, iArr, sb2);
    }

    @Override // qm.x
    public com.google.zxing.j m(int i11, hm.a aVar, int[] iArr, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        return s(this.f74842i.m(i11, aVar, iArr, map));
    }

    @Override // qm.x
    public BarcodeFormat q() {
        return BarcodeFormat.UPC_A;
    }
}
