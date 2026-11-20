package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;

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
@SourceDebugExtension
public final class BroadcastFrameClock implements u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f3228a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Throwable f3230c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f3229b = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<a<?>> f3231d = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<a<?>> f3232f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicInt f3233g = new AtomicInt(0);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function1<Long, R> f3234a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Continuation<R> f3235b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super Long, ? extends R> function1, Continuation<? super R> continuation) {
            this.f3234a = function1;
            this.f3235b = continuation;
        }

        public final Continuation<R> a() {
            return this.f3235b;
        }

        public final void b(long j11) {
            Object objM163constructorimpl;
            Continuation<R> continuation = this.f3235b;
            try {
                Result.Companion companion = Result.Companion;
                objM163constructorimpl = Result.m163constructorimpl(this.f3234a.invoke(Long.valueOf(j11)));
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
            }
            continuation.resumeWith(objM163constructorimpl);
        }
    }

    public BroadcastFrameClock(Function0<Unit> function0) {
        this.f3228a = function0;
    }

    @Override // androidx.compose.runtime.u0
    public <R> Object e(Function1<? super Long, ? extends R> function1, Continuation<? super R> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.c(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final a aVar = new a(function1, cancellableContinuationImpl);
        synchronized (this.f3229b) {
            Throwable th2 = this.f3230c;
            if (th2 != null) {
                Result.Companion companion = Result.Companion;
                cancellableContinuationImpl.resumeWith(Result.m163constructorimpl(ResultKt.a(th2)));
            } else {
                boolean z11 = !this.f3231d.isEmpty();
                this.f3231d.add(aVar);
                if (!z11) {
                    this.f3233g.set(1);
                }
                boolean z12 = true ^ z11;
                cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.compose.runtime.BroadcastFrameClock$withFrameNanos$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th3) {
                        invoke2(th3);
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable th3) {
                        Object obj = this.this$0.f3229b;
                        BroadcastFrameClock broadcastFrameClock = this.this$0;
                        Object obj2 = aVar;
                        synchronized (obj) {
                            try {
                                broadcastFrameClock.f3231d.remove(obj2);
                                if (broadcastFrameClock.f3231d.isEmpty()) {
                                    broadcastFrameClock.f3233g.set(0);
                                }
                                Unit unit = Unit.f68710a;
                            } catch (Throwable th4) {
                                throw th4;
                            }
                        }
                    }
                });
                if (z12 && this.f3228a != null) {
                    try {
                        this.f3228a.invoke();
                    } catch (Throwable th3) {
                        s(th3);
                    }
                }
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == kotlin.coroutines.intrinsics.a.e()) {
            DebugProbesKt.c(continuation);
        }
        return result;
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

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return u0.a.c(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return u0.a.d(this, coroutineContext);
    }

    public final void s(Throwable th2) {
        synchronized (this.f3229b) {
            try {
                if (this.f3230c != null) {
                    return;
                }
                this.f3230c = th2;
                List<a<?>> list = this.f3231d;
                int size = list.size();
                for (int i11 = 0; i11 < size; i11++) {
                    Continuation<?> continuationA = list.get(i11).a();
                    Result.Companion companion = Result.Companion;
                    continuationA.resumeWith(Result.m163constructorimpl(ResultKt.a(th2)));
                }
                this.f3231d.clear();
                this.f3233g.set(0);
                Unit unit = Unit.f68710a;
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public final boolean t() {
        return this.f3233g.get() != 0;
    }

    public final void u(long j11) {
        synchronized (this.f3229b) {
            try {
                List<a<?>> list = this.f3231d;
                this.f3231d = this.f3232f;
                this.f3232f = list;
                this.f3233g.set(0);
                int size = list.size();
                for (int i11 = 0; i11 < size; i11++) {
                    list.get(i11).b(j11);
                }
                list.clear();
                Unit unit = Unit.f68710a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
