package kotlinx.coroutines;

import kotlin.Metadata;

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
public final class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w0 f69610a = new w0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineDispatcher f69611b = kotlinx.coroutines.scheduling.b.f69536h;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CoroutineDispatcher f69612c = p2.f69513a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final CoroutineDispatcher f69613d = kotlinx.coroutines.scheduling.a.f69534b;

    public static final CoroutineDispatcher a() {
        return f69611b;
    }

    public static final CoroutineDispatcher b() {
        return f69613d;
    }

    public static final a2 c() {
        return kotlinx.coroutines.internal.s.f69491c;
    }
}
