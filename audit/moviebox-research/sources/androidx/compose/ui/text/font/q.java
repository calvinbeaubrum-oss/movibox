package androidx.compose.ui.text.font;

import kotlin.Deprecated;
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
public final class q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f5850b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f5851c = d(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f5852d = d(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5853a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return q.f5852d;
        }

        public final int b() {
            return q.f5851c;
        }
    }

    @Deprecated
    public /* synthetic */ q(int i11) {
        this.f5853a = i11;
    }

    public static final /* synthetic */ q c(int i11) {
        return new q(i11);
    }

    @Deprecated
    public static int d(int i11) {
        return i11;
    }

    public static boolean e(int i11, Object obj) {
        return (obj instanceof q) && i11 == ((q) obj).i();
    }

    public static final boolean f(int i11, int i12) {
        return i11 == i12;
    }

    public static int g(int i11) {
        return i11;
    }

    public static String h(int i11) {
        if (f(i11, f5851c)) {
            return "Normal";
        }
        return f(i11, f5852d) ? "Italic" : "Invalid";
    }

    public boolean equals(Object obj) {
        return e(this.f5853a, obj);
    }

    public int hashCode() {
        return g(this.f5853a);
    }

    public final /* synthetic */ int i() {
        return this.f5853a;
    }

    public String toString() {
        return h(this.f5853a);
    }
}
