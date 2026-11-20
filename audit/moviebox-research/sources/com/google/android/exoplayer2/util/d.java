package com.google.android.exoplayer2.util;

import android.os.Bundle;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.material.internal.ParcelableSparseArray;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class d {
    public static void a(@Nullable Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader((ClassLoader) o0.j(d.class.getClassLoader()));
        }
    }

    public static <T extends com.google.android.exoplayer2.g> ImmutableList<T> b(com.google.android.exoplayer2.g.a<T> aVar, List<Bundle> list) {
        ImmutableList.a aVarBuilder = ImmutableList.builder();
        for (int i11 = 0; i11 < list.size(); i11++) {
            aVarBuilder.a(aVar.a((Bundle) a.e(list.get(i11))));
        }
        return aVarBuilder.m();
    }

    public static <T extends com.google.android.exoplayer2.g> SparseArray<T> c(com.google.android.exoplayer2.g.a<T> aVar, SparseArray<Bundle> sparseArray) {
        ParcelableSparseArray parcelableSparseArray = (SparseArray<T>) new SparseArray(sparseArray.size());
        for (int i11 = 0; i11 < sparseArray.size(); i11++) {
            parcelableSparseArray.put(sparseArray.keyAt(i11), aVar.a(sparseArray.valueAt(i11)));
        }
        return parcelableSparseArray;
    }

    public static <T extends com.google.android.exoplayer2.g> ArrayList<Bundle> d(Collection<T> collection) {
        ArrayList<Bundle> arrayList = new ArrayList<>(collection.size());
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toBundle());
        }
        return arrayList;
    }

    public static <T extends com.google.android.exoplayer2.g> SparseArray<Bundle> e(SparseArray<T> sparseArray) {
        SparseArray<Bundle> sparseArray2 = new SparseArray<>(sparseArray.size());
        for (int i11 = 0; i11 < sparseArray.size(); i11++) {
            sparseArray2.put(sparseArray.keyAt(i11), sparseArray.valueAt(i11).toBundle());
        }
        return sparseArray2;
    }
}
