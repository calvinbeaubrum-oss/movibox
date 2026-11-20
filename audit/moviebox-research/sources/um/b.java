package um;

import com.google.android.gms.common.api.Api;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.i;
import com.google.zxing.j;
import com.google.zxing.k;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class b implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j[] f78605a = new j[0];

    public static j[] c(com.google.zxing.b bVar, Map<DecodeHintType, ?> map, boolean z11) throws NotFoundException, ChecksumException, FormatException {
        ArrayList arrayList = new ArrayList();
        xm.b bVarD = xm.a.d(bVar, map, z11);
        for (k[] kVarArr : bVarD.b()) {
            hm.d dVarI = vm.i.i(bVarD.a(), kVarArr[4], kVarArr[5], kVarArr[6], kVarArr[7], f(kVarArr), d(kVarArr));
            j jVar = new j(dVarI.k(), dVarI.g(), kVarArr, BarcodeFormat.PDF_417);
            jVar.h(ResultMetadataType.ERROR_CORRECTION_LEVEL, dVarI.b());
            jVar.h(ResultMetadataType.ERRORS_CORRECTED, dVarI.d());
            jVar.h(ResultMetadataType.ERASURES_CORRECTED, dVarI.c());
            c cVar = (c) dVarI.f();
            if (cVar != null) {
                jVar.h(ResultMetadataType.PDF417_EXTRA_METADATA, cVar);
            }
            jVar.h(ResultMetadataType.ORIENTATION, Integer.valueOf(bVarD.c()));
            jVar.h(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]L" + dVarI.j());
            arrayList.add(jVar);
        }
        return (j[]) arrayList.toArray(f78605a);
    }

    public static int d(k[] kVarArr) {
        return Math.max(Math.max(e(kVarArr[0], kVarArr[4]), (e(kVarArr[6], kVarArr[2]) * 17) / 18), Math.max(e(kVarArr[1], kVarArr[5]), (e(kVarArr[7], kVarArr[3]) * 17) / 18));
    }

    public static int e(k kVar, k kVar2) {
        if (kVar == null || kVar2 == null) {
            return 0;
        }
        return (int) Math.abs(kVar.c() - kVar2.c());
    }

    public static int f(k[] kVarArr) {
        return Math.min(Math.min(g(kVarArr[0], kVarArr[4]), (g(kVarArr[6], kVarArr[2]) * 17) / 18), Math.min(g(kVarArr[1], kVarArr[5]), (g(kVarArr[7], kVarArr[3]) * 17) / 18));
    }

    public static int g(k kVar, k kVar2) {
        return (kVar == null || kVar2 == null) ? Api.BaseClientBuilder.API_PRIORITY_OTHER : (int) Math.abs(kVar.c() - kVar2.c());
    }

    @Override // com.google.zxing.i
    public j a(com.google.zxing.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        j jVar;
        j[] jVarArrC = c(bVar, map, false);
        if (jVarArrC.length == 0 || (jVar = jVarArrC[0]) == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        return jVar;
    }

    @Override // com.google.zxing.i
    public j b(com.google.zxing.b bVar) throws NotFoundException, ChecksumException, FormatException {
        return a(bVar, null);
    }

    @Override // com.google.zxing.i
    public void reset() {
    }
}
