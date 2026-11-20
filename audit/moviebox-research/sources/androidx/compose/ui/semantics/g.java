package androidx.compose.ui.semantics;

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
public final class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f5640b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f5641c = c(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f5642d = c(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5643a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return g.f5642d;
        }

        public final int b() {
            return g.f5641c;
        }
    }

    public static int c(int i11) {
        return i11;
    }

    public static boolean d(int i11, Object obj) {
        return (obj instanceof g) && i11 == ((g) obj).h();
    }

    public static final boolean e(int i11, int i12) {
        return i11 == i12;
    }

    public static int f(int i11) {
        return i11;
    }

    public static String g(int i11) {
        if (e(i11, f5641c)) {
            return "Polite";
        }
        return e(i11, f5642d) ? "Assertive" : "Unknown";
    }

    public boolean equals(Object obj) {
        return d(this.f5643a, obj);
    }

    public final /* synthetic */ int h() {
        return this.f5643a;
    }

    public int hashCode() {
        return f(this.f5643a);
    }

    public String toString() {
        return g(this.f5643a);
    }
}
