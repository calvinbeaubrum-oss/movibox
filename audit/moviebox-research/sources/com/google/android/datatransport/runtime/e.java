package com.google.android.datatransport.runtime;

import android.content.Context;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import java.util.concurrent.Executor;
import mg.m0;
import mg.n0;
import mg.v0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: compiled from: source.java */
    public static final class b implements u.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f32625a;

        public b() {
        }

        @Override // com.google.android.datatransport.runtime.u.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a(Context context) {
            this.f32625a = (Context) gg.d.b(context);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.u.a
        public u build() {
            gg.d.a(this.f32625a, Context.class);
            return new c(this.f32625a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c extends u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f32626a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public u10.a<Executor> f32627b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public u10.a<Context> f32628c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public u10.a f32629d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public u10.a f32630f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public u10.a f32631g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public u10.a<String> f32632h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public u10.a<m0> f32633i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public u10.a<SchedulerConfig> f32634j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public u10.a<lg.u> f32635k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public u10.a<kg.c> f32636l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public u10.a<lg.o> f32637m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public u10.a<lg.s> f32638n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public u10.a<t> f32639o;

        public c(Context context) {
            this.f32626a = this;
            c(context);
        }

        @Override // com.google.android.datatransport.runtime.u
        public mg.d a() {
            return this.f32633i.get();
        }

        @Override // com.google.android.datatransport.runtime.u
        public t b() {
            return this.f32639o.get();
        }

        public final void c(Context context) {
            this.f32627b = gg.a.a(k.a());
            gg.b bVarA = gg.c.a(context);
            this.f32628c = bVarA;
            fg.h hVarA = fg.h.a(bVarA, og.c.a(), og.d.a());
            this.f32629d = hVarA;
            this.f32630f = gg.a.a(fg.j.a(this.f32628c, hVarA));
            this.f32631g = v0.a(this.f32628c, mg.g.a(), mg.i.a());
            this.f32632h = gg.a.a(mg.h.a(this.f32628c));
            this.f32633i = gg.a.a(n0.a(og.c.a(), og.d.a(), mg.j.a(), this.f32631g, this.f32632h));
            kg.g gVarB = kg.g.b(og.c.a());
            this.f32634j = gVarB;
            kg.i iVarA = kg.i.a(this.f32628c, this.f32633i, gVarB, og.d.a());
            this.f32635k = iVarA;
            u10.a<Executor> aVar = this.f32627b;
            u10.a aVar2 = this.f32630f;
            u10.a<m0> aVar3 = this.f32633i;
            this.f32636l = kg.d.a(aVar, aVar2, iVarA, aVar3, aVar3);
            u10.a<Context> aVar4 = this.f32628c;
            u10.a aVar5 = this.f32630f;
            u10.a<m0> aVar6 = this.f32633i;
            this.f32637m = lg.p.a(aVar4, aVar5, aVar6, this.f32635k, this.f32627b, aVar6, og.c.a(), og.d.a(), this.f32633i);
            u10.a<Executor> aVar7 = this.f32627b;
            u10.a<m0> aVar8 = this.f32633i;
            this.f32638n = lg.t.a(aVar7, aVar8, this.f32635k, aVar8);
            this.f32639o = gg.a.a(v.a(og.c.a(), og.d.a(), this.f32636l, this.f32637m, this.f32638n));
        }
    }

    public static u.a a() {
        return new b();
    }
}
