package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class PausableMonotonicFrameClock implements u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u0 f3294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Latch f3295b = new Latch();

    public PausableMonotonicFrameClock(u0 u0Var) {
        this.f3294a = u0Var;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.compose.runtime.u0
    public <R> Object e(Function1<? super Long, ? extends R> function1, Continuation<? super R> continuation) throws Throwable {
        PausableMonotonicFrameClock$withFrameNanos$1 pausableMonotonicFrameClock$withFrameNanos$1;
        PausableMonotonicFrameClock pausableMonotonicFrameClock;
        if (continuation instanceof PausableMonotonicFrameClock$withFrameNanos$1) {
            pausableMonotonicFrameClock$withFrameNanos$1 = (PausableMonotonicFrameClock$withFrameNanos$1) continuation;
            int i11 = pausableMonotonicFrameClock$withFrameNanos$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                pausableMonotonicFrameClock$withFrameNanos$1.label = i11 - Integer.MIN_VALUE;
            } else {
                pausableMonotonicFrameClock$withFrameNanos$1 = new PausableMonotonicFrameClock$withFrameNanos$1(this, continuation);
            }
        } else {
            pausableMonotonicFrameClock$withFrameNanos$1 = new PausableMonotonicFrameClock$withFrameNanos$1(this, continuation);
        }
        Object objE = pausableMonotonicFrameClock$withFrameNanos$1.result;
        Object objE2 = kotlin.coroutines.intrinsics.a.e();
        int i12 = pausableMonotonicFrameClock$withFrameNanos$1.label;
        if (i12 != 0) {
            if (i12 == 1) {
                function1 = (Function1) pausableMonotonicFrameClock$withFrameNanos$1.L$1;
                pausableMonotonicFrameClock = (PausableMonotonicFrameClock) pausableMonotonicFrameClock$withFrameNanos$1.L$0;
                ResultKt.b(objE);
            } else {
                if (i12 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(objE);
            }
        }
        ResultKt.b(objE);
        Latch latch = this.f3295b;
        pausableMonotonicFrameClock$withFrameNanos$1.L$0 = this;
        pausableMonotonicFrameClock$withFrameNanos$1.L$1 = function1;
        pausableMonotonicFrameClock$withFrameNanos$1.label = 1;
        if (latch.c(pausableMonotonicFrameClock$withFrameNanos$1) == objE2) {
            return objE2;
        }
        pausableMonotonicFrameClock = this;
        u0 u0Var = pausableMonotonicFrameClock.f3294a;
        pausableMonotonicFrameClock$withFrameNanos$1.L$0 = null;
        pausableMonotonicFrameClock$withFrameNanos$1.L$1 = null;
        pausableMonotonicFrameClock$withFrameNanos$1.label = 2;
        objE = u0Var.e(function1, pausableMonotonicFrameClock$withFrameNanos$1);
        return objE == objE2 ? objE2 : objE;
    }

    public final void f() {
        this.f3295b.d();
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r11, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return (R) u0.a.a(this, r11, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return (E) u0.a.b(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public /* synthetic */ CoroutineContext.Key getKey() {
        return t0.a(this);
    }

    public final void k() {
        this.f3295b.f();
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return u0.a.c(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return u0.a.d(this, coroutineContext);
    }
}
