package com.android.billingclient.api;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class h {

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile x0 f16327a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Context f16328b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile v f16329c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile boolean f16330d;

        public /* synthetic */ a(Context context, r1 r1Var) {
            this.f16328b = context;
        }

        @NonNull
        public h a() {
            if (this.f16328b == null) {
                throw new IllegalArgumentException("Please provide a valid Context.");
            }
            if (this.f16329c == null) {
                if (this.f16330d) {
                    return new i(null, this.f16328b, null, null);
                }
                throw new IllegalArgumentException("Please provide a valid listener for purchases updates.");
            }
            if (this.f16327a != null) {
                return this.f16329c != null ? new i(null, this.f16327a, this.f16328b, this.f16329c, null, null, null) : new i(null, this.f16327a, this.f16328b, null, null, null);
            }
            throw new IllegalArgumentException("Pending purchases for one-time products must be supported.");
        }

        @NonNull
        public a b() {
            v0 v0Var = new v0(null);
            v0Var.a();
            this.f16327a = v0Var.b();
            return this;
        }

        @NonNull
        public a c(@NonNull v vVar) {
            this.f16329c = vVar;
            return this;
        }
    }

    @NonNull
    public static a c(@NonNull Context context) {
        return new a(context, null);
    }

    public abstract boolean a();

    @NonNull
    public abstract n b(@NonNull Activity activity, @NonNull m mVar);

    public abstract void d(@NonNull w wVar, @NonNull s sVar);

    public abstract void e(@NonNull x xVar, @NonNull u uVar);

    public abstract void f(@NonNull j jVar);
}
