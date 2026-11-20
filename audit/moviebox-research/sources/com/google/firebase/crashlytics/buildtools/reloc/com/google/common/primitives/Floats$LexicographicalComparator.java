package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.primitives;

import java.util.Comparator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
enum Floats$LexicographicalComparator implements Comparator<float[]> {
    INSTANCE;

    @Override // java.util.Comparator
    public int compare(float[] fArr, float[] fArr2) {
        int iMin = Math.min(fArr.length, fArr2.length);
        for (int i11 = 0; i11 < iMin; i11++) {
            int iCompare = Float.compare(fArr[i11], fArr2[i11]);
            if (iCompare != 0) {
                return iCompare;
            }
        }
        return fArr.length - fArr2.length;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "Floats.lexicographicalComparator()";
    }
}
