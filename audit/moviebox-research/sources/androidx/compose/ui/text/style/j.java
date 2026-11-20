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
public final class j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f6115b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f6116c = h(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f6117d = h(2);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f6118e = h(3);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f6119f = h(4);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f6120g = h(5);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f6121h = h(Integer.MIN_VALUE);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6122a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return j.f6118e;
        }

        public final int b() {
            return j.f6119f;
        }

        public final int c() {
            return j.f6120g;
        }

        public final int d() {
            return j.f6116c;
        }

        public final int e() {
            return j.f6117d;
        }

        public final int f() {
            return j.f6121h;
        }
    }

    public /* synthetic */ j(int i11) {
        this.f6122a = i11;
    }

    public static final /* synthetic */ j g(int i11) {
        return new j(i11);
    }

    public static int h(int i11) {
        return i11;
    }

    public static boolean i(int i11, Object obj) {
        return (obj instanceof j) && i11 == ((j) obj).m();
    }

    public static final boolean j(int i11, int i12) {
        return i11 == i12;
    }

    public static int k(int i11) {
        return i11;
    }

    public static String l(int i11) {
        if (j(i11, f6116c)) {
            return "Ltr";
        }
        if (j(i11, f6117d)) {
            return "Rtl";
        }
        if (j(i11, f6118e)) {
            return "Content";
        }
        if (j(i11, f6119f)) {
            return "ContentOrLtr";
        }
        if (j(i11, f6120g)) {
            return "ContentOrRtl";
        }
        return j(i11, f6121h) ? "Unspecified" : "Invalid";
    }

    public boolean equals(Object obj) {
        return i(this.f6122a, obj);
    }

    public int hashCode() {
        return k(this.f6122a);
    }

    public final /* synthetic */ int m() {
        return this.f6122a;
    }

    public String toString() {
        return l(this.f6122a);
    }
}
