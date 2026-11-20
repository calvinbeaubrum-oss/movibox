package com.google.zxing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import qm.o;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class f implements i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i[] f41525c = new i[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<DecodeHintType, ?> f41526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i[] f41527b;

    @Override // com.google.zxing.i
    public j a(b bVar, Map<DecodeHintType, ?> map) throws NotFoundException {
        e(map);
        return c(bVar);
    }

    @Override // com.google.zxing.i
    public j b(b bVar) throws NotFoundException {
        e(null);
        return c(bVar);
    }

    public final j c(b bVar) throws NotFoundException {
        i[] iVarArr = this.f41527b;
        if (iVarArr != null) {
            for (i iVar : iVarArr) {
                if (Thread.currentThread().isInterrupted()) {
                    throw NotFoundException.getNotFoundInstance();
                }
                try {
                    return iVar.a(bVar, this.f41526a);
                } catch (ReaderException unused) {
                }
            }
            Map<DecodeHintType, ?> map = this.f41526a;
            if (map != null && map.containsKey(DecodeHintType.ALSO_INVERTED)) {
                bVar.a().d();
                for (i iVar2 : this.f41527b) {
                    if (Thread.currentThread().isInterrupted()) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    try {
                        return iVar2.a(bVar, this.f41526a);
                    } catch (ReaderException unused2) {
                    }
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public j d(b bVar) throws NotFoundException {
        if (this.f41527b == null) {
            e(null);
        }
        return c(bVar);
    }

    public void e(Map<DecodeHintType, ?> map) {
        this.f41526a = map;
        boolean z11 = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            boolean z12 = collection.contains(BarcodeFormat.UPC_A) || collection.contains(BarcodeFormat.UPC_E) || collection.contains(BarcodeFormat.EAN_13) || collection.contains(BarcodeFormat.EAN_8) || collection.contains(BarcodeFormat.CODABAR) || collection.contains(BarcodeFormat.CODE_39) || collection.contains(BarcodeFormat.CODE_93) || collection.contains(BarcodeFormat.CODE_128) || collection.contains(BarcodeFormat.ITF) || collection.contains(BarcodeFormat.RSS_14) || collection.contains(BarcodeFormat.RSS_EXPANDED);
            if (z12 && !z11) {
                arrayList.add(new o(map));
            }
            if (collection.contains(BarcodeFormat.QR_CODE)) {
                arrayList.add(new zm.a());
            }
            if (collection.contains(BarcodeFormat.DATA_MATRIX)) {
                arrayList.add(new km.a());
            }
            if (collection.contains(BarcodeFormat.AZTEC)) {
                arrayList.add(new dm.b());
            }
            if (collection.contains(BarcodeFormat.PDF_417)) {
                arrayList.add(new um.b());
            }
            if (collection.contains(BarcodeFormat.MAXICODE)) {
                arrayList.add(new om.a());
            }
            if (z12 && z11) {
                arrayList.add(new o(map));
            }
        }
        if (arrayList.isEmpty()) {
            if (!z11) {
                arrayList.add(new o(map));
            }
            arrayList.add(new zm.a());
            arrayList.add(new km.a());
            arrayList.add(new dm.b());
            arrayList.add(new um.b());
            arrayList.add(new om.a());
            if (z11) {
                arrayList.add(new o(map));
            }
        }
        this.f41527b = (i[]) arrayList.toArray(f41525c);
    }

    @Override // com.google.zxing.i
    public void reset() {
        i[] iVarArr = this.f41527b;
        if (iVarArr != null) {
            for (i iVar : iVarArr) {
                iVar.reset();
            }
        }
    }
}
