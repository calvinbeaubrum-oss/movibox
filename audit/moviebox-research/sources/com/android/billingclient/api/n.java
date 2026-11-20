package com.android.billingclient.api;

import androidx.annotation.NonNull;
import com.google.android.gms.internal.play_billing.zzb;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f16383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f16384b;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f16385a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f16386b = "";

        public /* synthetic */ a(o0 o0Var) {
        }

        @NonNull
        public n a() {
            n nVar = new n();
            nVar.f16383a = this.f16385a;
            nVar.f16384b = this.f16386b;
            return nVar;
        }

        @NonNull
        public a b(@NonNull String str) {
            this.f16386b = str;
            return this;
        }

        @NonNull
        public a c(int i11) {
            this.f16385a = i11;
            return this;
        }
    }

    @NonNull
    public static a c() {
        return new a(null);
    }

    @NonNull
    public String a() {
        return this.f16384b;
    }

    public int b() {
        return this.f16383a;
    }

    @NonNull
    public String toString() {
        return "Response Code: " + zzb.zzh(this.f16383a) + ", Debug Message: " + this.f16384b;
    }
}
