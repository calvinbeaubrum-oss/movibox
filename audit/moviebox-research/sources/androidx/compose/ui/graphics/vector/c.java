package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.e1;
import androidx.compose.ui.graphics.l1;
import androidx.compose.ui.graphics.w1;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class c {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final b f4436k = new b(null);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static int f4437l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f4439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f4440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f4441d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f4442e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j f4443f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f4444g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f4445h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f4446i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f4447j;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f4448a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f4449b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f4450c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f4451d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f4452e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f4453f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f4454g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f4455h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final ArrayList<C0056a> f4456i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public C0056a f4457j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f4458k;

        /* JADX INFO: renamed from: androidx.compose.ui.graphics.vector.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class C0056a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f4459a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public float f4460b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public float f4461c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public float f4462d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public float f4463e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public float f4464f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public float f4465g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public float f4466h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public List<? extends e> f4467i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public List<l> f4468j;

            public C0056a() {
                this(null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, 1023, null);
            }

            public C0056a(String str, float f11, float f12, float f13, float f14, float f15, float f16, float f17, List<? extends e> list, List<l> list2) {
                this.f4459a = str;
                this.f4460b = f11;
                this.f4461c = f12;
                this.f4462d = f13;
                this.f4463e = f14;
                this.f4464f = f15;
                this.f4465g = f16;
                this.f4466h = f17;
                this.f4467i = list;
                this.f4468j = list2;
            }

            public /* synthetic */ C0056a(String str, float f11, float f12, float f13, float f14, float f15, float f16, float f17, List list, List list2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
                this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? 0.0f : f11, (i11 & 4) != 0 ? 0.0f : f12, (i11 & 8) != 0 ? 0.0f : f13, (i11 & 16) != 0 ? 1.0f : f14, (i11 & 32) == 0 ? f15 : 1.0f, (i11 & 64) != 0 ? 0.0f : f16, (i11 & 128) == 0 ? f17 : 0.0f, (i11 & 256) != 0 ? k.d() : list, (i11 & 512) != 0 ? new ArrayList() : list2);
            }

            public final List<l> a() {
                return this.f4468j;
            }

            public final List<e> b() {
                return this.f4467i;
            }

            public final String c() {
                return this.f4459a;
            }

            public final float d() {
                return this.f4461c;
            }

            public final float e() {
                return this.f4462d;
            }

            public final float f() {
                return this.f4460b;
            }

            public final float g() {
                return this.f4463e;
            }

            public final float h() {
                return this.f4464f;
            }

            public final float i() {
                return this.f4465g;
            }

            public final float j() {
                return this.f4466h;
            }
        }

        public a(String str, float f11, float f12, float f13, float f14, long j11, int i11, boolean z11) {
            this.f4448a = str;
            this.f4449b = f11;
            this.f4450c = f12;
            this.f4451d = f13;
            this.f4452e = f14;
            this.f4453f = j11;
            this.f4454g = i11;
            this.f4455h = z11;
            ArrayList<C0056a> arrayList = new ArrayList<>();
            this.f4456i = arrayList;
            C0056a c0056a = new C0056a(null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, 1023, null);
            this.f4457j = c0056a;
            d.f(arrayList, c0056a);
        }

        public /* synthetic */ a(String str, float f11, float f12, float f13, float f14, long j11, int i11, boolean z11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
            this((i12 & 1) != 0 ? "" : str, f11, f12, f13, f14, (i12 & 32) != 0 ? w1.f4564b.e() : j11, (i12 & 64) != 0 ? e1.f4102a.z() : i11, (i12 & 128) != 0 ? false : z11, null);
        }

        public /* synthetic */ a(String str, float f11, float f12, float f13, float f14, long j11, int i11, boolean z11, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, f11, f12, f13, f14, j11, i11, z11);
        }

        public final a a(String str, float f11, float f12, float f13, float f14, float f15, float f16, float f17, List<? extends e> list) {
            g();
            d.f(this.f4456i, new C0056a(str, f11, f12, f13, f14, f15, f16, f17, list, null, 512, null));
            return this;
        }

        public final a c(List<? extends e> list, int i11, String str, l1 l1Var, float f11, l1 l1Var2, float f12, float f13, int i12, int i13, float f14, float f15, float f16, float f17) {
            g();
            h().a().add(new n(str, list, i11, l1Var, f11, l1Var2, f12, f13, i12, i13, f14, f15, f16, f17, null));
            return this;
        }

        public final j d(C0056a c0056a) {
            return new j(c0056a.c(), c0056a.f(), c0056a.d(), c0056a.e(), c0056a.g(), c0056a.h(), c0056a.i(), c0056a.j(), c0056a.b(), c0056a.a());
        }

        public final c e() {
            g();
            while (this.f4456i.size() > 1) {
                f();
            }
            c cVar = new c(this.f4448a, this.f4449b, this.f4450c, this.f4451d, this.f4452e, d(this.f4457j), this.f4453f, this.f4454g, this.f4455h, 0, 512, null);
            this.f4458k = true;
            return cVar;
        }

        public final a f() {
            g();
            h().a().add(d((C0056a) d.e(this.f4456i)));
            return this;
        }

        public final void g() {
            if (!this.f4458k) {
                return;
            }
            h2.a.b("ImageVector.Builder is single use, create a new instance to create a new ImageVector");
        }

        public final C0056a h() {
            return (C0056a) d.d(this.f4456i);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            int i11;
            synchronized (this) {
                i11 = c.f4437l;
                c.f4437l = i11 + 1;
            }
            return i11;
        }
    }

    public c(String str, float f11, float f12, float f13, float f14, j jVar, long j11, int i11, boolean z11, int i12) {
        this.f4438a = str;
        this.f4439b = f11;
        this.f4440c = f12;
        this.f4441d = f13;
        this.f4442e = f14;
        this.f4443f = jVar;
        this.f4444g = j11;
        this.f4445h = i11;
        this.f4446i = z11;
        this.f4447j = i12;
    }

    public /* synthetic */ c(String str, float f11, float f12, float f13, float f14, j jVar, long j11, int i11, boolean z11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, f11, f12, f13, f14, jVar, j11, i11, z11, (i13 & 512) != 0 ? f4436k.a() : i12, null);
    }

    public /* synthetic */ c(String str, float f11, float f12, float f13, float f14, j jVar, long j11, int i11, boolean z11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, f11, f12, f13, f14, jVar, j11, i11, z11, i12);
    }

    public final boolean c() {
        return this.f4446i;
    }

    public final float d() {
        return this.f4440c;
    }

    public final float e() {
        return this.f4439b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Intrinsics.b(this.f4438a, cVar.f4438a) && q2.i.j(this.f4439b, cVar.f4439b) && q2.i.j(this.f4440c, cVar.f4440c) && this.f4441d == cVar.f4441d && this.f4442e == cVar.f4442e && Intrinsics.b(this.f4443f, cVar.f4443f) && w1.m(this.f4444g, cVar.f4444g) && e1.E(this.f4445h, cVar.f4445h) && this.f4446i == cVar.f4446i;
    }

    public final int f() {
        return this.f4447j;
    }

    public final String g() {
        return this.f4438a;
    }

    public final j h() {
        return this.f4443f;
    }

    public int hashCode() {
        return (((((((((((((((this.f4438a.hashCode() * 31) + q2.i.k(this.f4439b)) * 31) + q2.i.k(this.f4440c)) * 31) + Float.floatToIntBits(this.f4441d)) * 31) + Float.floatToIntBits(this.f4442e)) * 31) + this.f4443f.hashCode()) * 31) + w1.s(this.f4444g)) * 31) + e1.F(this.f4445h)) * 31) + androidx.compose.foundation.e.a(this.f4446i);
    }

    public final int i() {
        return this.f4445h;
    }

    public final long j() {
        return this.f4444g;
    }

    public final float k() {
        return this.f4442e;
    }

    public final float l() {
        return this.f4441d;
    }
}
