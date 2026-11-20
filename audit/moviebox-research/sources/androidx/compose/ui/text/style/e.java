package androidx.compose.ui.text.style;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
@JvmInline
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f6066b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f6067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f6068d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f6069e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f6070f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6071a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return e.f6067c;
        }

        public final int b() {
            return e.f6070f;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @JvmInline
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6072a = new a(null);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f6073b = d(1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f6074c = d(2);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f6075d = d(3);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f6076e = d(0);

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final int a() {
                return b.f6075d;
            }

            public final int b() {
                return b.f6074c;
            }

            public final int c() {
                return b.f6073b;
            }
        }

        public static int d(int i11) {
            return i11;
        }

        public static final boolean e(int i11, int i12) {
            return i11 == i12;
        }

        public static String f(int i11) {
            if (e(i11, f6073b)) {
                return "Strategy.Simple";
            }
            if (e(i11, f6074c)) {
                return "Strategy.HighQuality";
            }
            if (e(i11, f6075d)) {
                return "Strategy.Balanced";
            }
            return e(i11, f6076e) ? "Strategy.Unspecified" : "Invalid";
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @JvmInline
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6077a = new a(null);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f6078b = e(1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f6079c = e(2);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f6080d = e(3);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f6081e = e(4);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f6082f = e(0);

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final int a() {
                return c.f6078b;
            }

            public final int b() {
                return c.f6079c;
            }

            public final int c() {
                return c.f6080d;
            }

            public final int d() {
                return c.f6081e;
            }
        }

        public static int e(int i11) {
            return i11;
        }

        public static final boolean f(int i11, int i12) {
            return i11 == i12;
        }

        public static String g(int i11) {
            if (f(i11, f6078b)) {
                return "Strictness.None";
            }
            if (f(i11, f6079c)) {
                return "Strictness.Loose";
            }
            if (f(i11, f6080d)) {
                return "Strictness.Normal";
            }
            if (f(i11, f6081e)) {
                return "Strictness.Strict";
            }
            return f(i11, f6082f) ? "Strictness.Unspecified" : "Invalid";
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @JvmInline
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6083a = new a(null);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f6084b = c(1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f6085c = c(2);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f6086d = c(0);

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final int a() {
                return d.f6084b;
            }

            public final int b() {
                return d.f6085c;
            }
        }

        public static int c(int i11) {
            return i11;
        }

        public static final boolean d(int i11, int i12) {
            return i11 == i12;
        }

        public static String e(int i11) {
            if (d(i11, f6084b)) {
                return "WordBreak.None";
            }
            if (d(i11, f6085c)) {
                return "WordBreak.Phrase";
            }
            return d(i11, f6086d) ? "WordBreak.Unspecified" : "Invalid";
        }
    }

    static {
        b.a aVar = b.f6072a;
        int iC = aVar.c();
        c.a aVar2 = c.f6077a;
        int iC2 = aVar2.c();
        d.a aVar3 = d.f6083a;
        f6067c = d(f.e(iC, iC2, aVar3.a()));
        f6068d = d(f.e(aVar.a(), aVar2.b(), aVar3.b()));
        f6069e = d(f.e(aVar.b(), aVar2.d(), aVar3.a()));
        f6070f = d(0);
    }

    public /* synthetic */ e(int i11) {
        this.f6071a = i11;
    }

    public static final /* synthetic */ e c(int i11) {
        return new e(i11);
    }

    public static int d(int i11) {
        return i11;
    }

    public static boolean e(int i11, Object obj) {
        return (obj instanceof e) && i11 == ((e) obj).l();
    }

    public static final boolean f(int i11, int i12) {
        return i11 == i12;
    }

    public static final int g(int i11) {
        return b.d(f.f(i11));
    }

    public static final int h(int i11) {
        return c.e(f.g(i11));
    }

    public static final int i(int i11) {
        return d.c(f.h(i11));
    }

    public static int j(int i11) {
        return i11;
    }

    public static String k(int i11) {
        return "LineBreak(strategy=" + ((Object) b.f(g(i11))) + ", strictness=" + ((Object) c.g(h(i11))) + ", wordBreak=" + ((Object) d.e(i(i11))) + ')';
    }

    public boolean equals(Object obj) {
        return e(this.f6071a, obj);
    }

    public int hashCode() {
        return j(this.f6071a);
    }

    public final /* synthetic */ int l() {
        return this.f6071a;
    }

    public String toString() {
        return k(this.f6071a);
    }
}
