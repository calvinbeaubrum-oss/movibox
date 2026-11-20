package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
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
@PublishedApi
public final class t0<T> extends kotlinx.coroutines.internal.y<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f69605a = AtomicIntegerFieldUpdater.newUpdater(t0.class, "_decision$volatile");

    @JvmField
    private volatile /* synthetic */ int _decision$volatile;

    public t0(CoroutineContext coroutineContext, Continuation<? super T> continuation) {
        super(coroutineContext, continuation);
    }

    @Override // kotlinx.coroutines.internal.y, kotlinx.coroutines.JobSupport
    public void afterCompletion(Object obj) {
        afterResume(obj);
    }

    @Override // kotlinx.coroutines.internal.y, kotlinx.coroutines.a
    public void afterResume(Object obj) {
        if (u()) {
            return;
        }
        kotlinx.coroutines.internal.i.c(IntrinsicsKt__IntrinsicsJvmKt.c(this.uCont), e0.a(obj, this.uCont), null, 2, null);
    }

    public final Object s() {
        if (v()) {
            return kotlin.coroutines.intrinsics.a.e();
        }
        Object objH = x1.h(getState$kotlinx_coroutines_core());
        if (objH instanceof b0) {
            throw ((b0) objH).f69208a;
        }
        return objH;
    }

    public final boolean u() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f69605a;
        do {
            int i11 = atomicIntegerFieldUpdater.get(this);
            if (i11 != 0) {
                if (i11 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f69605a.compareAndSet(this, 0, 2));
        return true;
    }

    public final boolean v() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f69605a;
        do {
            int i11 = atomicIntegerFieldUpdater.get(this);
            if (i11 != 0) {
                if (i11 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f69605a.compareAndSet(this, 0, 1));
        return true;
    }
}
