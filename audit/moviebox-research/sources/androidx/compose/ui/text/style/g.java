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
public final class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f6087c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g f6088d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f6089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6090b;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @JvmInline
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0065a f6091a = new C0065a(null);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final float f6092b = b(0.0f);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final float f6093c = b(0.5f);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final float f6094d = b(-1.0f);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final float f6095e = b(1.0f);

        /* JADX INFO: renamed from: androidx.compose.ui.text.style.g$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class C0065a {
            public C0065a() {
            }

            public /* synthetic */ C0065a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final float a() {
                return a.f6094d;
            }
        }

        public static float b(float f11) {
            if ((0.0f > f11 || f11 > 1.0f) && f11 != -1.0f) {
                throw new IllegalStateException("topRatio should be in [0..1] range or -1".toString());
            }
            return f11;
        }

        public static final boolean c(float f11, float f12) {
            return Float.compare(f11, f12) == 0;
        }

        public static int d(float f11) {
            return Float.floatToIntBits(f11);
        }

        public static String e(float f11) {
            if (f11 == f6092b) {
                return "LineHeightStyle.Alignment.Top";
            }
            if (f11 == f6093c) {
                return "LineHeightStyle.Alignment.Center";
            }
            if (f11 == f6094d) {
                return "LineHeightStyle.Alignment.Proportional";
            }
            if (f11 == f6095e) {
                return "LineHeightStyle.Alignment.Bottom";
            }
            return "LineHeightStyle.Alignment(topPercentage = " + f11 + ')';
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final g a() {
            return g.f6088d;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @JvmInline
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6096a = new a(null);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f6097b = b(1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f6098c = b(16);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f6099d = b(17);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f6100e = b(0);

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final int a() {
                return c.f6099d;
            }
        }

        public static int b(int i11) {
            return i11;
        }

        public static final boolean c(int i11, int i12) {
            return i11 == i12;
        }

        public static int d(int i11) {
            return i11;
        }

        public static final boolean e(int i11) {
            return (i11 & 1) > 0;
        }

        public static final boolean f(int i11) {
            return (i11 & 16) > 0;
        }

        public static String g(int i11) {
            if (i11 == f6097b) {
                return "LineHeightStyle.Trim.FirstLineTop";
            }
            if (i11 == f6098c) {
                return "LineHeightStyle.Trim.LastLineBottom";
            }
            if (i11 == f6099d) {
                return "LineHeightStyle.Trim.Both";
            }
            return i11 == f6100e ? "LineHeightStyle.Trim.None" : "Invalid";
        }
    }

    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        f6087c = new b(defaultConstructorMarker);
        f6088d = new g(a.f6091a.a(), c.f6096a.a(), defaultConstructorMarker);
    }

    public g(float f11, int i11) {
        this.f6089a = f11;
        this.f6090b = i11;
    }

    public /* synthetic */ g(float f11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11, i11);
    }

    public final float b() {
        return this.f6089a;
    }

    public final int c() {
        return this.f6090b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return a.c(this.f6089a, gVar.f6089a) && c.c(this.f6090b, gVar.f6090b);
    }

    public int hashCode() {
        return (a.d(this.f6089a) * 31) + c.d(this.f6090b);
    }

    public String toString() {
        return "LineHeightStyle(alignment=" + ((Object) a.e(this.f6089a)) + ", trim=" + ((Object) c.g(this.f6090b)) + ')';
    }
}
