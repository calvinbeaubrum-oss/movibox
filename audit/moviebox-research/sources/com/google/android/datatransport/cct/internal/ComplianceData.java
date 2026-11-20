package com.google.android.datatransport.cct.internal;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import eg.k;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ComplianceData {

    /* JADX INFO: compiled from: source.java */
    public enum ProductIdOrigin {
        NOT_SET(0),
        EVENT_OVERRIDE(5);

        private static final SparseArray<ProductIdOrigin> valueMap;
        private final int value;

        static {
            ProductIdOrigin productIdOrigin = NOT_SET;
            ProductIdOrigin productIdOrigin2 = EVENT_OVERRIDE;
            SparseArray<ProductIdOrigin> sparseArray = new SparseArray<>();
            valueMap = sparseArray;
            sparseArray.put(0, productIdOrigin);
            sparseArray.put(5, productIdOrigin2);
        }

        ProductIdOrigin(int i11) {
            this.value = i11;
        }

        @Nullable
        public static ProductIdOrigin forNumber(int i11) {
            return valueMap.get(i11);
        }

        public int getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class a {
        @NonNull
        public abstract ComplianceData a();

        @NonNull
        public abstract a b(@Nullable k kVar);

        @NonNull
        public abstract a c(@Nullable ProductIdOrigin productIdOrigin);
    }

    @NonNull
    public static a a() {
        return new c.b();
    }

    @Nullable
    public abstract k b();

    @Nullable
    public abstract ProductIdOrigin c();
}
