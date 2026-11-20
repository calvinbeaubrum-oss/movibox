package kotlin;

import kotlin.internal.IntrinsicConstEvaluation;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class UShort implements Comparable<UShort> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f68705b = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final short f68706a;

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
    public /* synthetic */ UShort(short s11) {
        this.f68706a = s11;
    }

    public static final /* synthetic */ UShort a(short s11) {
        return new UShort(s11);
    }

    @PublishedApi
    @IntrinsicConstEvaluation
    public static short b(short s11) {
        return s11;
    }

    public static boolean c(short s11, Object obj) {
        return (obj instanceof UShort) && s11 == ((UShort) obj).h();
    }

    public static int d(short s11) {
        return s11;
    }

    public static String e(short s11) {
        return String.valueOf(s11 & 65535);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UShort uShort) {
        return Intrinsics.i(h() & 65535, uShort.h() & 65535);
    }

    public boolean equals(Object obj) {
        return c(this.f68706a, obj);
    }

    public final /* synthetic */ short h() {
        return this.f68706a;
    }

    public int hashCode() {
        return d(this.f68706a);
    }

    public String toString() {
        return e(this.f68706a);
    }
}
