package kotlinx.coroutines.debug.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;

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
@PublishedApi
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineContext f69287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineStackFrame f69288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f69289c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<StackTraceElement> f69290d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f69291e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Thread f69292f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CoroutineStackFrame f69293g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<StackTraceElement> f69294h;

    public b(c cVar, CoroutineContext coroutineContext) {
        this.f69287a = coroutineContext;
        cVar.c();
        this.f69288b = null;
        this.f69289c = cVar.f69295a;
        this.f69290d = cVar.d();
        this.f69291e = cVar.f();
        this.f69292f = cVar.lastObservedThread;
        this.f69293g = cVar.e();
        this.f69294h = cVar.g();
    }
}
