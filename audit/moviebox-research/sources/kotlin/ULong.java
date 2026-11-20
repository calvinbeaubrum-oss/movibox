package kotlin;

import kotlin.internal.IntrinsicConstEvaluation;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import l.p;

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
/* JADX INFO: loaded from: classes8.dex */
@SinceKotlin
@Metadata
@JvmInline
@WasExperimental
public final class ULong implements Comparable<ULong> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f68699b = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f68700a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @PublishedApi
    @IntrinsicConstEvaluation
    public /* synthetic */ ULong(long j11) {
        this.f68700a = j11;
    }

    public static final /* synthetic */ ULong a(long j11) {
        return new ULong(j11);
    }

    @PublishedApi
    @IntrinsicConstEvaluation
    public static long b(long j11) {
        return j11;
    }

    public static boolean c(long j11, Object obj) {
        return (obj instanceof ULong) && j11 == ((ULong) obj).i();
    }

    public static final boolean d(long j11, long j12) {
        return j11 == j12;
    }

    public static int e(long j11) {
        return p.a(j11);
    }

    public static String h(long j11) {
        return UnsignedKt.d(j11);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ULong uLong) {
        return UnsignedKt.b(i(), uLong.i());
    }

    public boolean equals(Object obj) {
        return c(this.f68700a, obj);
    }

    public int hashCode() {
        return e(this.f68700a);
    }

    public final /* synthetic */ long i() {
        return this.f68700a;
    }

    public String toString() {
        return h(this.f68700a);
    }
}
