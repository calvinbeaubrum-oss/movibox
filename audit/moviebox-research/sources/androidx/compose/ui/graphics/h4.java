package androidx.compose.ui.graphics;

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
public final class h4 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f4148b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f4149c = g(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f4150d = g(1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f4151e = g(2);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f4152f = g(3);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f4153g = g(4);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4154a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return h4.f4150d;
        }

        public final int b() {
            return h4.f4149c;
        }

        public final int c() {
            return h4.f4152f;
        }

        public final int d() {
            return h4.f4153g;
        }

        public final int e() {
            return h4.f4151e;
        }
    }

    public /* synthetic */ h4(int i11) {
        this.f4154a = i11;
    }

    public static final /* synthetic */ h4 f(int i11) {
        return new h4(i11);
    }

    public static int g(int i11) {
        return i11;
    }

    public static boolean h(int i11, Object obj) {
        return (obj instanceof h4) && i11 == ((h4) obj).l();
    }

    public static final boolean i(int i11, int i12) {
        return i11 == i12;
    }

    public static int j(int i11) {
        return i11;
    }

    public static String k(int i11) {
        if (i(i11, f4149c)) {
            return "Argb8888";
        }
        if (i(i11, f4150d)) {
            return "Alpha8";
        }
        if (i(i11, f4151e)) {
            return "Rgb565";
        }
        if (i(i11, f4152f)) {
            return "F16";
        }
        return i(i11, f4153g) ? "Gpu" : "Unknown";
    }

    public boolean equals(Object obj) {
        return h(this.f4154a, obj);
    }

    public int hashCode() {
        return j(this.f4154a);
    }

    public final /* synthetic */ int l() {
        return this.f4154a;
    }

    public String toString() {
        return k(this.f4154a);
    }
}
