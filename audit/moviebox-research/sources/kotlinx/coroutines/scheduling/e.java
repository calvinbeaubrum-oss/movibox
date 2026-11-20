package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

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
public class e extends ExecutorCoroutineDispatcher {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f69538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f69539c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f69540d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f69541f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CoroutineScheduler f69542g = o();

    public e(int i11, int i12, long j11, String str) {
        this.f69538b = i11;
        this.f69539c = i12;
        this.f69540d = j11;
        this.f69541f = str;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        CoroutineScheduler.h(this.f69542g, runnable, null, false, 6, null);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        CoroutineScheduler.h(this.f69542g, runnable, null, true, 2, null);
    }

    public final CoroutineScheduler o() {
        return new CoroutineScheduler(this.f69538b, this.f69539c, this.f69540d, this.f69541f);
    }

    public final void p(Runnable runnable, g gVar, boolean z11) {
        this.f69542g.g(runnable, gVar, z11);
    }
}
