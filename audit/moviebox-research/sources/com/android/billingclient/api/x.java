package com.android.billingclient.api;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16473a;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f16474a;

        public /* synthetic */ a(l1 l1Var) {
        }

        @NonNull
        public x a() {
            if (this.f16474a != null) {
                return new x(this, null);
            }
            throw new IllegalArgumentException("Product type must be set");
        }

        @NonNull
        public a b(@NonNull String str) {
            this.f16474a = str;
            return this;
        }
    }

    public /* synthetic */ x(a aVar, m1 m1Var) {
        this.f16473a = aVar.f16474a;
    }

    @NonNull
    public static a a() {
        return new a(null);
    }

    @NonNull
    public final String b() {
        return this.f16473a;
    }
}
