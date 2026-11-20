package com.android.billingclient.api;

import androidx.annotation.NonNull;
import com.google.android.gms.internal.play_billing.zzaf;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zzaf f16467a;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public zzaf f16468a;

        public /* synthetic */ a(h1 h1Var) {
        }

        @NonNull
        public w a() {
            return new w(this, null);
        }

        @NonNull
        public a b(@NonNull List<b> list) {
            if (list == null || list.isEmpty()) {
                throw new IllegalArgumentException("Product list cannot be empty.");
            }
            HashSet hashSet = new HashSet();
            for (b bVar : list) {
                if (!"play_pass_subs".equals(bVar.c())) {
                    hashSet.add(bVar.c());
                }
            }
            if (hashSet.size() > 1) {
                throw new IllegalArgumentException("All products should be of the same product type.");
            }
            this.f16468a = zzaf.zzj(list);
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f16469a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f16470b;

        /* JADX INFO: compiled from: source.java */
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f16471a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f16472b;

            public /* synthetic */ a(i1 i1Var) {
            }

            @NonNull
            public b a() {
                if ("first_party".equals(this.f16472b)) {
                    throw new IllegalArgumentException("Serialized doc id must be provided for first party products.");
                }
                if (this.f16471a == null) {
                    throw new IllegalArgumentException("Product id must be provided.");
                }
                if (this.f16472b != null) {
                    return new b(this, null);
                }
                throw new IllegalArgumentException("Product type must be provided.");
            }

            @NonNull
            public a b(@NonNull String str) {
                this.f16471a = str;
                return this;
            }

            @NonNull
            public a c(@NonNull String str) {
                this.f16472b = str;
                return this;
            }
        }

        public /* synthetic */ b(a aVar, j1 j1Var) {
            this.f16469a = aVar.f16471a;
            this.f16470b = aVar.f16472b;
        }

        @NonNull
        public static a a() {
            return new a(null);
        }

        @NonNull
        public final String b() {
            return this.f16469a;
        }

        @NonNull
        public final String c() {
            return this.f16470b;
        }
    }

    public /* synthetic */ w(a aVar, k1 k1Var) {
        this.f16467a = aVar.f16468a;
    }

    @NonNull
    public static a a() {
        return new a(null);
    }

    public final zzaf b() {
        return this.f16467a;
    }

    @NonNull
    public final String c() {
        return ((b) this.f16467a.get(0)).c();
    }
}
