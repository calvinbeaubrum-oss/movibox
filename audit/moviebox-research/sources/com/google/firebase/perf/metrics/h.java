package com.google.firebase.perf.metrics;

import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class h {

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f40997a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f40998b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f40999c;

        public a(int i11, int i12, int i13) {
            this.f40997a = i11;
            this.f40998b = i12;
            this.f40999c = i13;
        }

        public a a(a aVar) {
            return new a(this.f40997a - aVar.d(), this.f40998b - aVar.c(), this.f40999c - aVar.b());
        }

        public int b() {
            return this.f40999c;
        }

        public int c() {
            return this.f40998b;
        }

        public int d() {
            return this.f40997a;
        }
    }

    @NonNull
    public static a a(@Nullable SparseIntArray[] sparseIntArrayArr) {
        int i11;
        int i12;
        SparseIntArray sparseIntArray;
        int i13 = 0;
        if (sparseIntArrayArr == null || (sparseIntArray = sparseIntArrayArr[0]) == null) {
            i11 = 0;
            i12 = 0;
        } else {
            int i14 = 0;
            i11 = 0;
            i12 = 0;
            while (i13 < sparseIntArray.size()) {
                int iKeyAt = sparseIntArray.keyAt(i13);
                int iValueAt = sparseIntArray.valueAt(i13);
                i14 += iValueAt;
                if (iKeyAt > 700) {
                    i12 += iValueAt;
                }
                if (iKeyAt > 16) {
                    i11 += iValueAt;
                }
                i13++;
            }
            i13 = i14;
        }
        return new a(i13, i11, i12);
    }
}
