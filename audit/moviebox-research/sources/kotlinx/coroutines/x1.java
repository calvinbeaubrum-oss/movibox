package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.JvmField;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class x1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final kotlinx.coroutines.internal.c0 f69616a = new kotlinx.coroutines.internal.c0("COMPLETING_ALREADY");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @JvmField
    public static final kotlinx.coroutines.internal.c0 f69617b = new kotlinx.coroutines.internal.c0("COMPLETING_WAITING_CHILDREN");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final kotlinx.coroutines.internal.c0 f69618c = new kotlinx.coroutines.internal.c0("COMPLETING_RETRY");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final kotlinx.coroutines.internal.c0 f69619d = new kotlinx.coroutines.internal.c0("TOO_LATE_TO_CANCEL");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final kotlinx.coroutines.internal.c0 f69620e = new kotlinx.coroutines.internal.c0("SEALED");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b1 f69621f = new b1(false);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b1 f69622g = new b1(true);

    public static final Object g(Object obj) {
        return obj instanceof l1 ? new m1((l1) obj) : obj;
    }

    public static final Object h(Object obj) {
        l1 l1Var;
        m1 m1Var = obj instanceof m1 ? (m1) obj : null;
        return (m1Var == null || (l1Var = m1Var.f69503a) == null) ? obj : l1Var;
    }
}
