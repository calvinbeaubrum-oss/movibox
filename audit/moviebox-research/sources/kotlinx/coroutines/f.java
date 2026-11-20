package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class f<T> extends a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Thread f69320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c1 f69321b;

    public f(CoroutineContext coroutineContext, Thread thread, c1 c1Var) {
        super(coroutineContext, true, true);
        this.f69320a = thread;
        this.f69321b = c1Var;
    }

    @Override // kotlinx.coroutines.JobSupport
    public void afterCompletion(Object obj) {
        if (Intrinsics.b(Thread.currentThread(), this.f69320a)) {
            return;
        }
        Thread thread = this.f69320a;
        c.a();
        LockSupport.unpark(thread);
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean isScopedCoroutine() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final T s() throws Throwable {
        c.a();
        try {
            c1 c1Var = this.f69321b;
            if (c1Var != null) {
                c1.incrementUseCount$default(c1Var, false, 1, null);
            }
            while (!Thread.interrupted()) {
                try {
                    c1 c1Var2 = this.f69321b;
                    long jProcessNextEvent = c1Var2 != null ? c1Var2.processNextEvent() : Long.MAX_VALUE;
                    if (isCompleted()) {
                        c1 c1Var3 = this.f69321b;
                        if (c1Var3 != null) {
                            c1.decrementUseCount$default(c1Var3, false, 1, null);
                        }
                        c.a();
                        T t11 = (T) x1.h(getState$kotlinx_coroutines_core());
                        b0 b0Var = t11 instanceof b0 ? (b0) t11 : null;
                        if (b0Var == null) {
                            return t11;
                        }
                        throw b0Var.f69208a;
                    }
                    c.a();
                    LockSupport.parkNanos(this, jProcessNextEvent);
                } catch (Throwable th2) {
                    c1 c1Var4 = this.f69321b;
                    if (c1Var4 != null) {
                        c1.decrementUseCount$default(c1Var4, false, 1, null);
                    }
                    throw th2;
                }
            }
            InterruptedException interruptedException = new InterruptedException();
            cancelCoroutine(interruptedException);
            throw interruptedException;
        } catch (Throwable th3) {
            c.a();
            throw th3;
        }
    }
}
