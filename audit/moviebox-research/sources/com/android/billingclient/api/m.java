package com.android.billingclient.api;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.play_billing.zzaf;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f16357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f16358b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f16359c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f16360d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public zzaf f16361e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList f16362f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f16363g;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f16364a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f16365b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List f16366c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ArrayList f16367d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f16368e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public c.a f16369f;

        public /* synthetic */ a(g0 g0Var) {
            c.a aVarA = c.a();
            c.a.b(aVarA);
            this.f16369f = aVarA;
        }

        @NonNull
        public m a() {
            ArrayList arrayList = this.f16367d;
            boolean z11 = true;
            boolean z12 = (arrayList == null || arrayList.isEmpty()) ? false : true;
            List list = this.f16366c;
            boolean z13 = (list == null || list.isEmpty()) ? false : true;
            if (!z12 && !z13) {
                throw new IllegalArgumentException("Details of the products must be provided.");
            }
            if (z12 && z13) {
                throw new IllegalArgumentException("Set SkuDetails or ProductDetailsParams, not both.");
            }
            l0 l0Var = null;
            if (!z12) {
                b bVar = (b) this.f16366c.get(0);
                for (int i11 = 0; i11 < this.f16366c.size(); i11++) {
                    b bVar2 = (b) this.f16366c.get(i11);
                    if (bVar2 == null) {
                        throw new IllegalArgumentException("ProductDetailsParams cannot be null.");
                    }
                    if (i11 != 0 && !bVar2.b().c().equals(bVar.b().c()) && !bVar2.b().c().equals("play_pass_subs")) {
                        throw new IllegalArgumentException("All products should have same ProductType.");
                    }
                }
                String strE = bVar.b().e();
                for (b bVar3 : this.f16366c) {
                    if (!bVar.b().c().equals("play_pass_subs") && !bVar3.b().c().equals("play_pass_subs") && !strE.equals(bVar3.b().e())) {
                        throw new IllegalArgumentException("All products must have the same package name.");
                    }
                }
            } else {
                if (this.f16367d.contains(null)) {
                    throw new IllegalArgumentException("SKU cannot be null.");
                }
                if (this.f16367d.size() > 1) {
                    SkuDetails skuDetails = (SkuDetails) this.f16367d.get(0);
                    String strB = skuDetails.b();
                    ArrayList arrayList2 = this.f16367d;
                    int size = arrayList2.size();
                    for (int i12 = 0; i12 < size; i12++) {
                        SkuDetails skuDetails2 = (SkuDetails) arrayList2.get(i12);
                        if (!strB.equals("play_pass_subs") && !skuDetails2.b().equals("play_pass_subs") && !strB.equals(skuDetails2.b())) {
                            throw new IllegalArgumentException("SKUs should have the same type.");
                        }
                    }
                    String strF = skuDetails.f();
                    ArrayList arrayList3 = this.f16367d;
                    int size2 = arrayList3.size();
                    for (int i13 = 0; i13 < size2; i13++) {
                        SkuDetails skuDetails3 = (SkuDetails) arrayList3.get(i13);
                        if (!strB.equals("play_pass_subs") && !skuDetails3.b().equals("play_pass_subs") && !strF.equals(skuDetails3.f())) {
                            throw new IllegalArgumentException("All SKUs must have the same package name.");
                        }
                    }
                }
            }
            m mVar = new m(l0Var);
            if ((!z12 || ((SkuDetails) this.f16367d.get(0)).f().isEmpty()) && (!z13 || ((b) this.f16366c.get(0)).b().e().isEmpty())) {
                z11 = false;
            }
            mVar.f16357a = z11;
            mVar.f16358b = this.f16364a;
            mVar.f16359c = this.f16365b;
            mVar.f16360d = this.f16369f.a();
            ArrayList arrayList4 = this.f16367d;
            mVar.f16362f = arrayList4 != null ? new ArrayList(arrayList4) : new ArrayList();
            mVar.f16363g = this.f16368e;
            List list2 = this.f16366c;
            mVar.f16361e = list2 != null ? zzaf.zzj(list2) : zzaf.zzk();
            return mVar;
        }

        @NonNull
        public a b(@NonNull String str) {
            this.f16364a = str;
            return this;
        }

        @NonNull
        public a c(@NonNull List<b> list) {
            this.f16366c = new ArrayList(list);
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final r f16370a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f16371b;

        /* JADX INFO: compiled from: source.java */
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public r f16372a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f16373b;

            public /* synthetic */ a(h0 h0Var) {
            }

            @NonNull
            public b a() {
                com.google.android.gms.internal.play_billing.zzx.zzc(this.f16372a, "ProductDetails is required for constructing ProductDetailsParams.");
                com.google.android.gms.internal.play_billing.zzx.zzc(this.f16373b, "offerToken is required for constructing ProductDetailsParams.");
                return new b(this, null);
            }

            @NonNull
            public a b(@NonNull String str) {
                this.f16373b = str;
                return this;
            }

            @NonNull
            public a c(@NonNull r rVar) {
                this.f16372a = rVar;
                if (rVar.a() != null) {
                    rVar.a().getClass();
                    this.f16373b = rVar.a().a();
                }
                return this;
            }
        }

        public /* synthetic */ b(a aVar, i0 i0Var) {
            this.f16370a = aVar.f16372a;
            this.f16371b = aVar.f16373b;
        }

        @NonNull
        public static a a() {
            return new a(null);
        }

        @NonNull
        public final r b() {
            return this.f16370a;
        }

        @NonNull
        public final String c() {
            return this.f16371b;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f16374a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f16375b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f16376c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f16377d = 0;

        /* JADX INFO: compiled from: source.java */
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f16378a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f16379b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public boolean f16380c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f16381d = 0;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f16382e = 0;

            public /* synthetic */ a(j0 j0Var) {
            }

            public static /* synthetic */ a b(a aVar) {
                aVar.f16380c = true;
                return aVar;
            }

            @NonNull
            public c a() {
                k0 k0Var = null;
                boolean z11 = (TextUtils.isEmpty(this.f16378a) && TextUtils.isEmpty(null)) ? false : true;
                boolean zIsEmpty = true ^ TextUtils.isEmpty(this.f16379b);
                if (z11 && zIsEmpty) {
                    throw new IllegalArgumentException("Please provide Old SKU purchase information(token/id) or original external transaction id, not both.");
                }
                if (!this.f16380c && !z11 && !zIsEmpty) {
                    throw new IllegalArgumentException("Old SKU purchase information(token/id) or original external transaction id must be provided.");
                }
                c cVar = new c(k0Var);
                cVar.f16374a = this.f16378a;
                cVar.f16376c = this.f16381d;
                cVar.f16377d = this.f16382e;
                cVar.f16375b = this.f16379b;
                return cVar;
            }
        }

        public /* synthetic */ c(k0 k0Var) {
        }

        @NonNull
        public static a a() {
            return new a(null);
        }

        @Deprecated
        public final int b() {
            return this.f16376c;
        }

        public final int c() {
            return this.f16377d;
        }

        public final String d() {
            return this.f16374a;
        }

        public final String e() {
            return this.f16375b;
        }
    }

    public /* synthetic */ m(l0 l0Var) {
    }

    @NonNull
    public static a a() {
        return new a(null);
    }

    @Deprecated
    public final int b() {
        return this.f16360d.b();
    }

    public final int c() {
        return this.f16360d.c();
    }

    @Nullable
    public final String d() {
        return this.f16358b;
    }

    @Nullable
    public final String e() {
        return this.f16359c;
    }

    @Nullable
    public final String f() {
        return this.f16360d.d();
    }

    @Nullable
    public final String g() {
        return this.f16360d.e();
    }

    @NonNull
    public final ArrayList h() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f16362f);
        return arrayList;
    }

    @NonNull
    public final List i() {
        return this.f16361e;
    }

    public final boolean q() {
        return this.f16363g;
    }

    public final boolean r() {
        return (this.f16358b == null && this.f16359c == null && this.f16360d.e() == null && this.f16360d.b() == 0 && this.f16360d.c() == 0 && !this.f16357a && !this.f16363g) ? false : true;
    }
}
