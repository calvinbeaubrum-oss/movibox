package q2;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class i implements Comparable<i> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f74232b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final float f74233c = h(0.0f);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final float f74234d = h(Float.POSITIVE_INFINITY);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final float f74235f = h(Float.NaN);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f74236a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final float a() {
            return i.f74233c;
        }

        public final float b() {
            return i.f74235f;
        }
    }

    public /* synthetic */ i(float f11) {
        this.f74236a = f11;
    }

    public static final /* synthetic */ i c(float f11) {
        return new i(f11);
    }

    public static int e(float f11, float f12) {
        return Float.compare(f11, f12);
    }

    public static float h(float f11) {
        return f11;
    }

    public static boolean i(float f11, Object obj) {
        return (obj instanceof i) && Float.compare(f11, ((i) obj).m()) == 0;
    }

    public static final boolean j(float f11, float f12) {
        return Float.compare(f11, f12) == 0;
    }

    public static int k(float f11) {
        return Float.floatToIntBits(f11);
    }

    public static String l(float f11) {
        if (Float.isNaN(f11)) {
            return "Dp.Unspecified";
        }
        return f11 + ".dp";
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(i iVar) {
        return d(iVar.m());
    }

    public int d(float f11) {
        return e(this.f74236a, f11);
    }

    public boolean equals(Object obj) {
        return i(this.f74236a, obj);
    }

    public int hashCode() {
        return k(this.f74236a);
    }

    public final /* synthetic */ float m() {
        return this.f74236a;
    }

    public String toString() {
        return l(this.f74236a);
    }
}
