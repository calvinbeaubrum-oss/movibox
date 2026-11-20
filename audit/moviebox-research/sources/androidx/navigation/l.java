package androidx.navigation;

import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

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
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f12286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f12287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12288c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f12289d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f12290e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f12291f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f12292g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f12293h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f12294i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f12295j;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f12296a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f12297b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f12299d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f12300e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f12301f;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f12298c = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f12302g = -1;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f12303h = -1;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f12304i = -1;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f12305j = -1;

        public static /* synthetic */ a i(a aVar, int i11, boolean z11, boolean z12, int i12, Object obj) {
            if ((i12 & 4) != 0) {
                z12 = false;
            }
            return aVar.g(i11, z11, z12);
        }

        public final l a() {
            String str = this.f12299d;
            return str != null ? new l(this.f12296a, this.f12297b, str, this.f12300e, this.f12301f, this.f12302g, this.f12303h, this.f12304i, this.f12305j) : new l(this.f12296a, this.f12297b, this.f12298c, this.f12300e, this.f12301f, this.f12302g, this.f12303h, this.f12304i, this.f12305j);
        }

        public final a b(int i11) {
            this.f12302g = i11;
            return this;
        }

        public final a c(int i11) {
            this.f12303h = i11;
            return this;
        }

        public final a d(boolean z11) {
            this.f12296a = z11;
            return this;
        }

        public final a e(int i11) {
            this.f12304i = i11;
            return this;
        }

        public final a f(int i11) {
            this.f12305j = i11;
            return this;
        }

        @JvmOverloads
        public final a g(int i11, boolean z11, boolean z12) {
            this.f12298c = i11;
            this.f12299d = null;
            this.f12300e = z11;
            this.f12301f = z12;
            return this;
        }

        @JvmOverloads
        public final a h(String str, boolean z11, boolean z12) {
            this.f12299d = str;
            this.f12298c = -1;
            this.f12300e = z11;
            this.f12301f = z12;
            return this;
        }

        public final a j(boolean z11) {
            this.f12297b = z11;
            return this;
        }
    }

    public l(boolean z11, boolean z12, int i11, boolean z13, boolean z14, int i12, int i13, int i14, int i15) {
        this.f12286a = z11;
        this.f12287b = z12;
        this.f12288c = i11;
        this.f12289d = z13;
        this.f12290e = z14;
        this.f12291f = i12;
        this.f12292g = i13;
        this.f12293h = i14;
        this.f12294i = i15;
    }

    public l(boolean z11, boolean z12, String str, boolean z13, boolean z14, int i11, int i12, int i13, int i14) {
        this(z11, z12, NavDestination.f12205k.a(str).hashCode(), z13, z14, i11, i12, i13, i14);
        this.f12295j = str;
    }

    public final int a() {
        return this.f12291f;
    }

    public final int b() {
        return this.f12292g;
    }

    public final int c() {
        return this.f12293h;
    }

    public final int d() {
        return this.f12294i;
    }

    public final int e() {
        return this.f12288c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.b(l.class, obj.getClass())) {
            return false;
        }
        l lVar = (l) obj;
        return this.f12286a == lVar.f12286a && this.f12287b == lVar.f12287b && this.f12288c == lVar.f12288c && Intrinsics.b(this.f12295j, lVar.f12295j) && this.f12289d == lVar.f12289d && this.f12290e == lVar.f12290e && this.f12291f == lVar.f12291f && this.f12292g == lVar.f12292g && this.f12293h == lVar.f12293h && this.f12294i == lVar.f12294i;
    }

    public final boolean f() {
        return this.f12289d;
    }

    public final boolean g() {
        return this.f12286a;
    }

    public final boolean h() {
        return this.f12290e;
    }

    public int hashCode() {
        int i11 = (((((g() ? 1 : 0) * 31) + (i() ? 1 : 0)) * 31) + this.f12288c) * 31;
        String str = this.f12295j;
        return ((((((((((((i11 + (str == null ? 0 : str.hashCode())) * 31) + (f() ? 1 : 0)) * 31) + (h() ? 1 : 0)) * 31) + this.f12291f) * 31) + this.f12292g) * 31) + this.f12293h) * 31) + this.f12294i;
    }

    public final boolean i() {
        return this.f12287b;
    }
}
