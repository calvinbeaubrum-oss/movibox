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
public final class p extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final x[] f74839b = new x[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x[] f74840a;

    public p(Map<DecodeHintType, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(BarcodeFormat.EAN_13)) {
                arrayList.add(new h());
            } else if (collection.contains(BarcodeFormat.UPC_A)) {
                arrayList.add(new s());
            }
            if (collection.contains(BarcodeFormat.EAN_8)) {
                arrayList.add(new j());
            }
            if (collection.contains(BarcodeFormat.UPC_E)) {
                arrayList.add(new z());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new h());
            arrayList.add(new j());
            arrayList.add(new z());
        }
        this.f74840a = (x[]) arrayList.toArray(f74839b);
    }

    @Override // qm.q
    public com.google.zxing.j c(int i11, hm.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException {
        int[] iArrP = x.p(aVar);
        for (x xVar : this.f74840a) {
            try {
                com.google.zxing.j jVarM = xVar.m(i11, aVar, iArrP, map);
                boolean z11 = jVarM.b() == BarcodeFormat.EAN_13 && jVarM.f().charAt(0) == '0';
                Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
                boolean z12 = collection == null || collection.contains(BarcodeFormat.UPC_A);
                if (!z11 || !z12) {
                    return jVarM;
                }
                com.google.zxing.j jVar = new com.google.zxing.j(jVarM.f().substring(1), jVarM.c(), jVarM.e(), BarcodeFormat.UPC_A);
                jVar.g(jVarM.d());
                return jVar;
            } catch (ReaderException unused) {
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // qm.q, com.google.zxing.i
    public void reset() {
        for (x xVar : this.f74840a) {
            xVar.reset();
        }
    }
}
