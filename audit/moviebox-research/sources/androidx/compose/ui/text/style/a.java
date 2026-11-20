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
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0064a f6053b = new C0064a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final float f6054c = c(0.5f);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final float f6055d = c(-0.5f);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final float f6056e = c(0.0f);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f6057a;

    /* JADX INFO: renamed from: androidx.compose.ui.text.style.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0064a {
        public C0064a() {
        }

        public /* synthetic */ C0064a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final float a() {
            return a.f6056e;
        }
    }

    public /* synthetic */ a(float f11) {
        this.f6057a = f11;
    }

    public static final /* synthetic */ a b(float f11) {
        return new a(f11);
    }

    public static float c(float f11) {
        return f11;
    }

    public static boolean d(float f11, Object obj) {
        return (obj instanceof a) && Float.compare(f11, ((a) obj).h()) == 0;
    }

    public static final boolean e(float f11, float f12) {
        return Float.compare(f11, f12) == 0;
    }

    public static int f(float f11) {
        return Float.floatToIntBits(f11);
    }

    public static String g(float f11) {
        return "BaselineShift(multiplier=" + f11 + ')';
    }

    public boolean equals(Object obj) {
        return d(this.f6057a, obj);
    }

    public final /* synthetic */ float h() {
        return this.f6057a;
    }

    public int hashCode() {
        return f(this.f6057a);
    }

    public String toString() {
        return g(this.f6057a);
    }
}
