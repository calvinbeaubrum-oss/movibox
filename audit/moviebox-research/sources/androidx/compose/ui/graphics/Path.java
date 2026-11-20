package androidx.compose.ui.graphics;

import kotlin.Metadata;

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
public interface Path {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f3960a = a.f3961a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public enum Direction {
        CounterClockwise,
        Clockwise
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f3961a = new a();
    }

    boolean a();

    void b(float f11, float f12);

    void c(float f11, float f12, float f13, float f14, float f15, float f16);

    void close();

    void d(int i11);

    void e(float f11, float f12, float f13, float f14);

    void f(float f11, float f12, float f13, float f14);

    void g(y1.k kVar, Direction direction);

    y1.i getBounds();

    void h(y1.i iVar, Direction direction);

    int i();

    boolean isEmpty();

    void j(float f11, float f12);

    void k(float f11, float f12, float f13, float f14, float f15, float f16);

    boolean l(Path path, Path path2, int i11);

    void m(float f11, float f12);

    void n(float f11, float f12);

    void reset();

    void rewind();
}
