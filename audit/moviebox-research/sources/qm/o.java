package qm;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class o extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final q[] f74837b = new q[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q[] f74838a;

    public o(Map<DecodeHintType, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
        boolean z11 = (map == null || map.get(DecodeHintType.ASSUME_CODE_39_CHECK_DIGIT) == null) ? false : true;
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(BarcodeFormat.EAN_13) || collection.contains(BarcodeFormat.UPC_A) || collection.contains(BarcodeFormat.EAN_8) || collection.contains(BarcodeFormat.UPC_E)) {
                arrayList.add(new p(map));
            }
            if (collection.contains(BarcodeFormat.CODE_39)) {
                arrayList.add(new d(z11));
            }
            if (collection.contains(BarcodeFormat.CODE_93)) {
                arrayList.add(new f());
            }
            if (collection.contains(BarcodeFormat.CODE_128)) {
                arrayList.add(new c());
            }
            if (collection.contains(BarcodeFormat.ITF)) {
                arrayList.add(new m());
            }
            if (collection.contains(BarcodeFormat.CODABAR)) {
                arrayList.add(new a());
            }
            if (collection.contains(BarcodeFormat.RSS_14)) {
                arrayList.add(new rm.e());
            }
            if (collection.contains(BarcodeFormat.RSS_EXPANDED)) {
                arrayList.add(new sm.d());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new p(map));
            arrayList.add(new d());
            arrayList.add(new a());
            arrayList.add(new f());
            arrayList.add(new c());
            arrayList.add(new m());
            arrayList.add(new rm.e());
            arrayList.add(new sm.d());
        }
        this.f74838a = (q[]) arrayList.toArray(f74837b);
    }

    @Override // qm.q
    public com.google.zxing.j c(int i11, hm.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException {
        for (q qVar : this.f74838a) {
            try {
                return qVar.c(i11, aVar, map);
            } catch (ReaderException unused) {
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // qm.q, com.google.zxing.i
    public void reset() {
        for (q qVar : this.f74838a) {
            qVar.reset();
        }
    }
}
