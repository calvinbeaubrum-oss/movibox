package d2;

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
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0642a f62868b = new C0642a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f62869c = d(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f62870d = d(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f62871a;

    /* JADX INFO: renamed from: d2.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0642a {
        public C0642a() {
        }

        public /* synthetic */ C0642a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return a.f62870d;
        }

        public final int b() {
            return a.f62869c;
        }
    }

    public /* synthetic */ a(int i11) {
        this.f62871a = i11;
    }

    public static final /* synthetic */ a c(int i11) {
        return new a(i11);
    }

    public static int d(int i11) {
        return i11;
    }

    public static boolean e(int i11, Object obj) {
        return (obj instanceof a) && i11 == ((a) obj).i();
    }

    public static final boolean f(int i11, int i12) {
        return i11 == i12;
    }

    public static int g(int i11) {
        return i11;
    }

    public static String h(int i11) {
        if (f(i11, f62869c)) {
            return "Touch";
        }
        return f(i11, f62870d) ? "Keyboard" : "Error";
    }

    public boolean equals(Object obj) {
        return e(this.f62871a, obj);
    }

    public int hashCode() {
        return g(this.f62871a);
    }

    public final /* synthetic */ int i() {
        return this.f62871a;
    }

    public String toString() {
        return h(this.f62871a);
    }
}
