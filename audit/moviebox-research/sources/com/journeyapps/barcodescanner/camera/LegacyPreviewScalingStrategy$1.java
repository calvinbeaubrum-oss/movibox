package com.journeyapps.barcodescanner.camera;

import java.util.Comparator;
import xn.t;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
class LegacyPreviewScalingStrategy$1 implements Comparator<t> {
    final /* synthetic */ p this$0;
    final /* synthetic */ t val$desired;

    public LegacyPreviewScalingStrategy$1(p pVar, t tVar) {
        this.val$desired = tVar;
    }

    @Override // java.util.Comparator
    public int compare(t tVar, t tVar2) {
        int i11 = p.e(tVar, this.val$desired).f80643a - tVar.f80643a;
        int i12 = p.e(tVar2, this.val$desired).f80643a - tVar2.f80643a;
        if (i11 == 0 && i12 == 0) {
            return tVar.compareTo(tVar2);
        }
        if (i11 == 0) {
            return -1;
        }
        if (i12 == 0) {
            return 1;
        }
        if (i11 < 0 && i12 < 0) {
            return tVar.compareTo(tVar2);
        }
        if (i11 <= 0 || i12 <= 0) {
            return i11 < 0 ? -1 : 1;
        }
        return -tVar.compareTo(tVar2);
    }
}
