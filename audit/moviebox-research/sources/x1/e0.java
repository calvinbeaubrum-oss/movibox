package x1;

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
public final class e0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f79797b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f79798c = b(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f79799d = b(3);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f79800e = b(4);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f79801f = b(2);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f79802g = b(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f79803a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return e0.f79798c;
        }
    }

    public static int b(int i11) {
        return i11;
    }

    public static boolean c(int i11, Object obj) {
        return (obj instanceof e0) && i11 == ((e0) obj).f();
    }

    public static int d(int i11) {
        return i11;
    }

    public static String e(int i11) {
        return "ContentDataType(dataType=" + i11 + ')';
    }

    public boolean equals(Object obj) {
        return c(this.f79803a, obj);
    }

    public final /* synthetic */ int f() {
        return this.f79803a;
    }

    public int hashCode() {
        return d(this.f79803a);
    }

    public String toString() {
        return e(this.f79803a);
    }
}
