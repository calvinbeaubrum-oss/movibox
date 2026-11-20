package com.google.android.exoplayer2;

import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class u1 implements com.google.android.exoplayer2.g {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final u1 f34773j = new c().a();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final com.google.android.exoplayer2.g.a<u1> f34774k = new com.google.android.exoplayer2.g.a() { // from class: com.google.android.exoplayer2.t1
        @Override // com.google.android.exoplayer2.g.a
        public final g a(Bundle bundle) {
            return u1.c(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f34775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final h f34776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    @Deprecated
    public final i f34777c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f34778d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final z1 f34779f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d f34780g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Deprecated
    public final e f34781h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final j f34782i;

    /* JADX INFO: compiled from: source.java */
    public static final class b {
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public String f34783a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public Uri f34784b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public String f34785c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public d.a f34786d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public f.a f34787e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List<StreamKey> f34788f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        public String f34789g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public ImmutableList<l> f34790h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @Nullable
        public Object f34791i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @Nullable
        public z1 f34792j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public g.a f34793k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public j f34794l;

        public c() {
            this.f34786d = new d.a();
            this.f34787e = new f.a();
            this.f34788f = Collections.emptyList();
            this.f34790h = ImmutableList.of();
            this.f34793k = new g.a();
            this.f34794l = j.f34847d;
        }

        public c(u1 u1Var) {
            this();
            this.f34786d = u1Var.f34780g.b();
            this.f34783a = u1Var.f34775a;
            this.f34792j = u1Var.f34779f;
            this.f34793k = u1Var.f34778d.b();
            this.f34794l = u1Var.f34782i;
            h hVar = u1Var.f34776b;
            if (hVar != null) {
                this.f34789g = hVar.f34843e;
                this.f34785c = hVar.f34840b;
                this.f34784b = hVar.f34839a;
                this.f34788f = hVar.f34842d;
                this.f34790h = hVar.f34844f;
                this.f34791i = hVar.f34846h;
                f fVar = hVar.f34841c;
                this.f34787e = fVar != null ? fVar.b() : new f.a();
            }
        }

        public u1 a() {
            i iVar;
            com.google.android.exoplayer2.util.a.g(this.f34787e.f34820b == null || this.f34787e.f34819a != null);
            Uri uri = this.f34784b;
            if (uri != null) {
                iVar = new i(uri, this.f34785c, this.f34787e.f34819a != null ? this.f34787e.i() : null, null, this.f34788f, this.f34789g, this.f34790h, this.f34791i);
            } else {
                iVar = null;
            }
            String str = this.f34783a;
            if (str == null) {
                str = "";
            }
            String str2 = str;
            e eVarG = this.f34786d.g();
            g gVarF = this.f34793k.f();
            z1 z1Var = this.f34792j;
            if (z1Var == null) {
                z1Var = z1.H;
            }
            return new u1(str2, eVarG, iVar, gVarF, z1Var, this.f34794l);
        }

        public c b(@Nullable String str) {
            this.f34789g = str;
            return this;
        }

        public c c(g gVar) {
            this.f34793k = gVar.b();
            return this;
        }

        public c d(String str) {
            this.f34783a = (String) com.google.android.exoplayer2.util.a.e(str);
            return this;
        }

        public c e(@Nullable String str) {
            this.f34785c = str;
            return this;
        }

        public c f(@Nullable List<StreamKey> list) {
            this.f34788f = (list == null || list.isEmpty()) ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList(list));
            return this;
        }

        public c g(List<l> list) {
            this.f34790h = ImmutableList.copyOf((Collection) list);
            return this;
        }

        public c h(@Nullable Object obj) {
            this.f34791i = obj;
            return this;
        }

        public c i(@Nullable Uri uri) {
            this.f34784b = uri;
            return this;
        }

        public c j(@Nullable String str) {
            return i(str == null ? null : Uri.parse(str));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d implements com.google.android.exoplayer2.g {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final d f34795g = new a().f();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final com.google.android.exoplayer2.g.a<e> f34796h = new com.google.android.exoplayer2.g.a() { // from class: com.google.android.exoplayer2.v1
            @Override // com.google.android.exoplayer2.g.a
            public final g a(Bundle bundle) {
                return u1.d.d(bundle);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f34797a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f34798b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f34799c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f34800d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f34801f;

        /* JADX INFO: compiled from: source.java */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public long f34802a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public long f34803b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public boolean f34804c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public boolean f34805d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public boolean f34806e;

            public a() {
                this.f34803b = Long.MIN_VALUE;
            }

            public a(d dVar) {
                this.f34802a = dVar.f34797a;
                this.f34803b = dVar.f34798b;
                this.f34804c = dVar.f34799c;
                this.f34805d = dVar.f34800d;
                this.f34806e = dVar.f34801f;
            }

            public d f() {
                return g();
            }

            @Deprecated
            public e g() {
                return new e(this);
            }

            public a h(long j11) {
                com.google.android.exoplayer2.util.a.a(j11 == Long.MIN_VALUE || j11 >= 0);
                this.f34803b = j11;
                return this;
            }

            public a i(boolean z11) {
                this.f34805d = z11;
                return this;
            }

            public a j(boolean z11) {
                this.f34804c = z11;
                return this;
            }

            public a k(long j11) {
                com.google.android.exoplayer2.util.a.a(j11 >= 0);
                this.f34802a = j11;
                return this;
            }

            public a l(boolean z11) {
                this.f34806e = z11;
                return this;
            }
        }

        public d(a aVar) {
            this.f34797a = aVar.f34802a;
            this.f34798b = aVar.f34803b;
            this.f34799c = aVar.f34804c;
            this.f34800d = aVar.f34805d;
            this.f34801f = aVar.f34806e;
        }

        private static String c(int i11) {
            return Integer.toString(i11, 36);
        }

        public static /* synthetic */ e d(Bundle bundle) {
            return new a().k(bundle.getLong(c(0), 0L)).h(bundle.getLong(c(1), Long.MIN_VALUE)).j(bundle.getBoolean(c(2), false)).i(bundle.getBoolean(c(3), false)).l(bundle.getBoolean(c(4), false)).g();
        }

        public a b() {
            return new a();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.f34797a == dVar.f34797a && this.f34798b == dVar.f34798b && this.f34799c == dVar.f34799c && this.f34800d == dVar.f34800d && this.f34801f == dVar.f34801f;
        }

        public int hashCode() {
            long j11 = this.f34797a;
            int i11 = ((int) (j11 ^ (j11 >>> 32))) * 31;
            long j12 = this.f34798b;
            return ((((((i11 + ((int) (j12 ^ (j12 >>> 32)))) * 31) + (this.f34799c ? 1 : 0)) * 31) + (this.f34800d ? 1 : 0)) * 31) + (this.f34801f ? 1 : 0);
        }

        @Override // com.google.android.exoplayer2.g
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putLong(c(0), this.f34797a);
            bundle.putLong(c(1), this.f34798b);
            bundle.putBoolean(c(2), this.f34799c);
            bundle.putBoolean(c(3), this.f34800d);
            bundle.putBoolean(c(4), this.f34801f);
            return bundle;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Deprecated
    public static final class e extends d {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final e f34807i = new d.a().g();

        public e(d.a aVar) {
            super(aVar);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final UUID f34808a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Deprecated
        public final UUID f34809b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public final Uri f34810c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Deprecated
        public final ImmutableMap<String, String> f34811d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ImmutableMap<String, String> f34812e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f34813f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f34814g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f34815h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @Deprecated
        public final ImmutableList<Integer> f34816i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final ImmutableList<Integer> f34817j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @Nullable
        public final byte[] f34818k;

        /* JADX INFO: compiled from: source.java */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @Nullable
            public UUID f34819a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @Nullable
            public Uri f34820b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public ImmutableMap<String, String> f34821c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public boolean f34822d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public boolean f34823e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public boolean f34824f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public ImmutableList<Integer> f34825g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            @Nullable
            public byte[] f34826h;

            @Deprecated
            public a() {
                this.f34821c = ImmutableMap.of();
                this.f34825g = ImmutableList.of();
            }

            public a(f fVar) {
                this.f34819a = fVar.f34808a;
                this.f34820b = fVar.f34810c;
                this.f34821c = fVar.f34812e;
                this.f34822d = fVar.f34813f;
                this.f34823e = fVar.f34814g;
                this.f34824f = fVar.f34815h;
                this.f34825g = fVar.f34817j;
                this.f34826h = fVar.f34818k;
            }

            public f i() {
                return new f(this);
            }
        }

        public f(a aVar) {
            com.google.android.exoplayer2.util.a.g((aVar.f34824f && aVar.f34820b == null) ? false : true);
            UUID uuid = (UUID) com.google.android.exoplayer2.util.a.e(aVar.f34819a);
            this.f34808a = uuid;
            this.f34809b = uuid;
            this.f34810c = aVar.f34820b;
            this.f34811d = aVar.f34821c;
            this.f34812e = aVar.f34821c;
            this.f34813f = aVar.f34822d;
            this.f34815h = aVar.f34824f;
            this.f34814g = aVar.f34823e;
            this.f34816i = aVar.f34825g;
            this.f34817j = aVar.f34825g;
            this.f34818k = aVar.f34826h != null ? Arrays.copyOf(aVar.f34826h, aVar.f34826h.length) : null;
        }

        public a b() {
            return new a();
        }

        @Nullable
        public byte[] c() {
            byte[] bArr = this.f34818k;
            if (bArr != null) {
                return Arrays.copyOf(bArr, bArr.length);
            }
            return null;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return this.f34808a.equals(fVar.f34808a) && com.google.android.exoplayer2.util.o0.c(this.f34810c, fVar.f34810c) && com.google.android.exoplayer2.util.o0.c(this.f34812e, fVar.f34812e) && this.f34813f == fVar.f34813f && this.f34815h == fVar.f34815h && this.f34814g == fVar.f34814g && this.f34817j.equals(fVar.f34817j) && Arrays.equals(this.f34818k, fVar.f34818k);
        }

        public int hashCode() {
            int iHashCode = this.f34808a.hashCode() * 31;
            Uri uri = this.f34810c;
            return ((((((((((((iHashCode + (uri != null ? uri.hashCode() : 0)) * 31) + this.f34812e.hashCode()) * 31) + (this.f34813f ? 1 : 0)) * 31) + (this.f34815h ? 1 : 0)) * 31) + (this.f34814g ? 1 : 0)) * 31) + this.f34817j.hashCode()) * 31) + Arrays.hashCode(this.f34818k);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class g implements com.google.android.exoplayer2.g {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final g f34827g = new a().f();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final com.google.android.exoplayer2.g.a<g> f34828h = new com.google.android.exoplayer2.g.a() { // from class: com.google.android.exoplayer2.w1
            @Override // com.google.android.exoplayer2.g.a
            public final g a(Bundle bundle) {
                return u1.g.d(bundle);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f34829a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f34830b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f34831c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f34832d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final float f34833f;

        /* JADX INFO: compiled from: source.java */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public long f34834a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public long f34835b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public long f34836c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public float f34837d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public float f34838e;

            public a() {
                this.f34834a = C.TIME_UNSET;
                this.f34835b = C.TIME_UNSET;
                this.f34836c = C.TIME_UNSET;
                this.f34837d = -3.4028235E38f;
                this.f34838e = -3.4028235E38f;
            }

            public a(g gVar) {
                this.f34834a = gVar.f34829a;
                this.f34835b = gVar.f34830b;
                this.f34836c = gVar.f34831c;
                this.f34837d = gVar.f34832d;
                this.f34838e = gVar.f34833f;
            }

            public g f() {
                return new g(this);
            }

            public a g(long j11) {
                this.f34836c = j11;
                return this;
            }

            public a h(float f11) {
                this.f34838e = f11;
                return this;
            }

            public a i(long j11) {
                this.f34835b = j11;
                return this;
            }

            public a j(float f11) {
                this.f34837d = f11;
                return this;
            }

            public a k(long j11) {
                this.f34834a = j11;
                return this;
            }
        }

        @Deprecated
        public g(long j11, long j12, long j13, float f11, float f12) {
            this.f34829a = j11;
            this.f34830b = j12;
            this.f34831c = j13;
            this.f34832d = f11;
            this.f34833f = f12;
        }

        public g(a aVar) {
            this(aVar.f34834a, aVar.f34835b, aVar.f34836c, aVar.f34837d, aVar.f34838e);
        }

        private static String c(int i11) {
            return Integer.toString(i11, 36);
        }

        public static /* synthetic */ g d(Bundle bundle) {
            return new g(bundle.getLong(c(0), C.TIME_UNSET), bundle.getLong(c(1), C.TIME_UNSET), bundle.getLong(c(2), C.TIME_UNSET), bundle.getFloat(c(3), -3.4028235E38f), bundle.getFloat(c(4), -3.4028235E38f));
        }

        public a b() {
            return new a();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return this.f34829a == gVar.f34829a && this.f34830b == gVar.f34830b && this.f34831c == gVar.f34831c && this.f34832d == gVar.f34832d && this.f34833f == gVar.f34833f;
        }

        public int hashCode() {
            long j11 = this.f34829a;
            long j12 = this.f34830b;
            int i11 = ((((int) (j11 ^ (j11 >>> 32))) * 31) + ((int) (j12 ^ (j12 >>> 32)))) * 31;
            long j13 = this.f34831c;
            int i12 = (i11 + ((int) (j13 ^ (j13 >>> 32)))) * 31;
            float f11 = this.f34832d;
            int iFloatToIntBits = (i12 + (f11 != 0.0f ? Float.floatToIntBits(f11) : 0)) * 31;
            float f12 = this.f34833f;
            return iFloatToIntBits + (f12 != 0.0f ? Float.floatToIntBits(f12) : 0);
        }

        @Override // com.google.android.exoplayer2.g
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putLong(c(0), this.f34829a);
            bundle.putLong(c(1), this.f34830b);
            bundle.putLong(c(2), this.f34831c);
            bundle.putFloat(c(3), this.f34832d);
            bundle.putFloat(c(4), this.f34833f);
            return bundle;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f34839a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final String f34840b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public final f f34841c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<StreamKey> f34842d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        public final String f34843e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ImmutableList<l> f34844f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Deprecated
        public final List<k> f34845g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Nullable
        public final Object f34846h;

        public h(Uri uri, @Nullable String str, @Nullable f fVar, @Nullable b bVar, List<StreamKey> list, @Nullable String str2, ImmutableList<l> immutableList, @Nullable Object obj) {
            this.f34839a = uri;
            this.f34840b = str;
            this.f34841c = fVar;
            this.f34842d = list;
            this.f34843e = str2;
            this.f34844f = immutableList;
            ImmutableList.a aVarBuilder = ImmutableList.builder();
            for (int i11 = 0; i11 < immutableList.size(); i11++) {
                aVarBuilder.a(immutableList.get(i11).a().i());
            }
            this.f34845g = aVarBuilder.m();
            this.f34846h = obj;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return this.f34839a.equals(hVar.f34839a) && com.google.android.exoplayer2.util.o0.c(this.f34840b, hVar.f34840b) && com.google.android.exoplayer2.util.o0.c(this.f34841c, hVar.f34841c) && com.google.android.exoplayer2.util.o0.c(null, null) && this.f34842d.equals(hVar.f34842d) && com.google.android.exoplayer2.util.o0.c(this.f34843e, hVar.f34843e) && this.f34844f.equals(hVar.f34844f) && com.google.android.exoplayer2.util.o0.c(this.f34846h, hVar.f34846h);
        }

        public int hashCode() {
            int iHashCode = this.f34839a.hashCode() * 31;
            String str = this.f34840b;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            f fVar = this.f34841c;
            int iHashCode3 = (((iHashCode2 + (fVar == null ? 0 : fVar.hashCode())) * 961) + this.f34842d.hashCode()) * 31;
            String str2 = this.f34843e;
            int iHashCode4 = (((iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f34844f.hashCode()) * 31;
            Object obj = this.f34846h;
            return iHashCode4 + (obj != null ? obj.hashCode() : 0);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Deprecated
    public static final class i extends h {
        public i(Uri uri, @Nullable String str, @Nullable f fVar, @Nullable b bVar, List<StreamKey> list, @Nullable String str2, ImmutableList<l> immutableList, @Nullable Object obj) {
            super(uri, str, fVar, bVar, list, str2, immutableList, obj);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class j implements com.google.android.exoplayer2.g {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final j f34847d = new a().d();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final com.google.android.exoplayer2.g.a<j> f34848f = new com.google.android.exoplayer2.g.a() { // from class: com.google.android.exoplayer2.x1
            @Override // com.google.android.exoplayer2.g.a
            public final g a(Bundle bundle) {
                return u1.j.c(bundle);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final Uri f34849a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final String f34850b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public final Bundle f34851c;

        /* JADX INFO: compiled from: source.java */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @Nullable
            public Uri f34852a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @Nullable
            public String f34853b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            @Nullable
            public Bundle f34854c;

            public j d() {
                return new j(this);
            }

            public a e(@Nullable Bundle bundle) {
                this.f34854c = bundle;
                return this;
            }

            public a f(@Nullable Uri uri) {
                this.f34852a = uri;
                return this;
            }

            public a g(@Nullable String str) {
                this.f34853b = str;
                return this;
            }
        }

        public j(a aVar) {
            this.f34849a = aVar.f34852a;
            this.f34850b = aVar.f34853b;
            this.f34851c = aVar.f34854c;
        }

        private static String b(int i11) {
            return Integer.toString(i11, 36);
        }

        public static /* synthetic */ j c(Bundle bundle) {
            return new a().f((Uri) bundle.getParcelable(b(0))).g(bundle.getString(b(1))).e(bundle.getBundle(b(2))).d();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            return com.google.android.exoplayer2.util.o0.c(this.f34849a, jVar.f34849a) && com.google.android.exoplayer2.util.o0.c(this.f34850b, jVar.f34850b);
        }

        public int hashCode() {
            Uri uri = this.f34849a;
            int iHashCode = (uri == null ? 0 : uri.hashCode()) * 31;
            String str = this.f34850b;
            return iHashCode + (str != null ? str.hashCode() : 0);
        }

        @Override // com.google.android.exoplayer2.g
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            if (this.f34849a != null) {
                bundle.putParcelable(b(0), this.f34849a);
            }
            if (this.f34850b != null) {
                bundle.putString(b(1), this.f34850b);
            }
            if (this.f34851c != null) {
                bundle.putBundle(b(2), this.f34851c);
            }
            return bundle;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Deprecated
    public static final class k extends l {
        public k(l.a aVar) {
            super(aVar);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f34855a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final String f34856b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public final String f34857c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f34858d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f34859e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        public final String f34860f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        public final String f34861g;

        /* JADX INFO: compiled from: source.java */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Uri f34862a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @Nullable
            public String f34863b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            @Nullable
            public String f34864c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f34865d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f34866e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            @Nullable
            public String f34867f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            @Nullable
            public String f34868g;

            public a(l lVar) {
                this.f34862a = lVar.f34855a;
                this.f34863b = lVar.f34856b;
                this.f34864c = lVar.f34857c;
                this.f34865d = lVar.f34858d;
                this.f34866e = lVar.f34859e;
                this.f34867f = lVar.f34860f;
                this.f34868g = lVar.f34861g;
            }

            public final k i() {
                return new k(this);
            }
        }

        public l(a aVar) {
            this.f34855a = aVar.f34862a;
            this.f34856b = aVar.f34863b;
            this.f34857c = aVar.f34864c;
            this.f34858d = aVar.f34865d;
            this.f34859e = aVar.f34866e;
            this.f34860f = aVar.f34867f;
            this.f34861g = aVar.f34868g;
        }

        public a a() {
            return new a();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof l)) {
                return false;
            }
            l lVar = (l) obj;
            return this.f34855a.equals(lVar.f34855a) && com.google.android.exoplayer2.util.o0.c(this.f34856b, lVar.f34856b) && com.google.android.exoplayer2.util.o0.c(this.f34857c, lVar.f34857c) && this.f34858d == lVar.f34858d && this.f34859e == lVar.f34859e && com.google.android.exoplayer2.util.o0.c(this.f34860f, lVar.f34860f) && com.google.android.exoplayer2.util.o0.c(this.f34861g, lVar.f34861g);
        }

        public int hashCode() {
            int iHashCode = this.f34855a.hashCode() * 31;
            String str = this.f34856b;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f34857c;
            int iHashCode3 = (((((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f34858d) * 31) + this.f34859e) * 31;
            String str3 = this.f34860f;
            int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f34861g;
            return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
        }
    }

    public u1(String str, e eVar, @Nullable i iVar, g gVar, z1 z1Var, j jVar) {
        this.f34775a = str;
        this.f34776b = iVar;
        this.f34777c = iVar;
        this.f34778d = gVar;
        this.f34779f = z1Var;
        this.f34780g = eVar;
        this.f34781h = eVar;
        this.f34782i = jVar;
    }

    public static u1 c(Bundle bundle) {
        String str = (String) com.google.android.exoplayer2.util.a.e(bundle.getString(f(0), ""));
        Bundle bundle2 = bundle.getBundle(f(1));
        g gVar = bundle2 == null ? g.f34827g : (g) g.f34828h.a(bundle2);
        Bundle bundle3 = bundle.getBundle(f(2));
        z1 z1Var = bundle3 == null ? z1.H : (z1) z1.I.a(bundle3);
        Bundle bundle4 = bundle.getBundle(f(3));
        e eVar = bundle4 == null ? e.f34807i : (e) d.f34796h.a(bundle4);
        Bundle bundle5 = bundle.getBundle(f(4));
        return new u1(str, eVar, null, gVar, z1Var, bundle5 == null ? j.f34847d : (j) j.f34848f.a(bundle5));
    }

    public static u1 d(Uri uri) {
        return new c().i(uri).a();
    }

    public static u1 e(String str) {
        return new c().j(str).a();
    }

    private static String f(int i11) {
        return Integer.toString(i11, 36);
    }

    public c b() {
        return new c();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u1)) {
            return false;
        }
        u1 u1Var = (u1) obj;
        return com.google.android.exoplayer2.util.o0.c(this.f34775a, u1Var.f34775a) && this.f34780g.equals(u1Var.f34780g) && com.google.android.exoplayer2.util.o0.c(this.f34776b, u1Var.f34776b) && com.google.android.exoplayer2.util.o0.c(this.f34778d, u1Var.f34778d) && com.google.android.exoplayer2.util.o0.c(this.f34779f, u1Var.f34779f) && com.google.android.exoplayer2.util.o0.c(this.f34782i, u1Var.f34782i);
    }

    public int hashCode() {
        int iHashCode = this.f34775a.hashCode() * 31;
        h hVar = this.f34776b;
        return ((((((((iHashCode + (hVar != null ? hVar.hashCode() : 0)) * 31) + this.f34778d.hashCode()) * 31) + this.f34780g.hashCode()) * 31) + this.f34779f.hashCode()) * 31) + this.f34782i.hashCode();
    }

    @Override // com.google.android.exoplayer2.g
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(f(0), this.f34775a);
        bundle.putBundle(f(1), this.f34778d.toBundle());
        bundle.putBundle(f(2), this.f34779f.toBundle());
        bundle.putBundle(f(3), this.f34780g.toBundle());
        bundle.putBundle(f(4), this.f34782i.toBundle());
        return bundle;
    }
}
