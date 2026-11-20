package retrofit2;

import java.lang.reflect.Method;
import kotlin.KotlinNullPointerException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.w0;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@JvmName
public final class KotlinExtensions {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class a<T> implements d<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.n f75193a;

        public a(kotlinx.coroutines.n nVar) {
            this.f75193a = nVar;
        }

        @Override // retrofit2.d
        public void a(retrofit2.b<T> call, Throwable t11) {
            Intrinsics.h(call, "call");
            Intrinsics.h(t11, "t");
            kotlinx.coroutines.n nVar = this.f75193a;
            Result.Companion companion = Result.Companion;
            nVar.resumeWith(Result.m163constructorimpl(ResultKt.a(t11)));
        }

        @Override // retrofit2.d
        public void b(retrofit2.b<T> call, b0<T> response) {
            Intrinsics.h(call, "call");
            Intrinsics.h(response, "response");
            if (!response.e()) {
                kotlinx.coroutines.n nVar = this.f75193a;
                HttpException httpException = new HttpException(response);
                Result.Companion companion = Result.Companion;
                nVar.resumeWith(Result.m163constructorimpl(ResultKt.a(httpException)));
                return;
            }
            T tA = response.a();
            if (tA != null) {
                this.f75193a.resumeWith(Result.m163constructorimpl(tA));
                return;
            }
            Object objTag = call.request().tag(n.class);
            if (objTag == null) {
                Intrinsics.s();
            }
            Intrinsics.c(objTag, "call.request().tag(Invocation::class.java)!!");
            Method method = ((n) objTag).a();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Response from ");
            Intrinsics.c(method, "method");
            Class<?> declaringClass = method.getDeclaringClass();
            Intrinsics.c(declaringClass, "method.declaringClass");
            sb2.append(declaringClass.getName());
            sb2.append('.');
            sb2.append(method.getName());
            sb2.append(" was null but response body type was declared as non-null");
            KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException(sb2.toString());
            kotlinx.coroutines.n nVar2 = this.f75193a;
            Result.Companion companion2 = Result.Companion;
            nVar2.resumeWith(Result.m163constructorimpl(ResultKt.a(kotlinNullPointerException)));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class b<T> implements d<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.n f75194a;

        public b(kotlinx.coroutines.n nVar) {
            this.f75194a = nVar;
        }

        @Override // retrofit2.d
        public void a(retrofit2.b<T> call, Throwable t11) {
            Intrinsics.h(call, "call");
            Intrinsics.h(t11, "t");
            kotlinx.coroutines.n nVar = this.f75194a;
            Result.Companion companion = Result.Companion;
            nVar.resumeWith(Result.m163constructorimpl(ResultKt.a(t11)));
        }

        @Override // retrofit2.d
        public void b(retrofit2.b<T> call, b0<T> response) {
            Intrinsics.h(call, "call");
            Intrinsics.h(response, "response");
            if (response.e()) {
                this.f75194a.resumeWith(Result.m163constructorimpl(response.a()));
                return;
            }
            kotlinx.coroutines.n nVar = this.f75194a;
            HttpException httpException = new HttpException(response);
            Result.Companion companion = Result.Companion;
            nVar.resumeWith(Result.m163constructorimpl(ResultKt.a(httpException)));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class c<T> implements d<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.n f75195a;

        public c(kotlinx.coroutines.n nVar) {
            this.f75195a = nVar;
        }

        @Override // retrofit2.d
        public void a(retrofit2.b<T> call, Throwable t11) {
            Intrinsics.h(call, "call");
            Intrinsics.h(t11, "t");
            kotlinx.coroutines.n nVar = this.f75195a;
            Result.Companion companion = Result.Companion;
            nVar.resumeWith(Result.m163constructorimpl(ResultKt.a(t11)));
        }

        @Override // retrofit2.d
        public void b(retrofit2.b<T> call, b0<T> response) {
            Intrinsics.h(call, "call");
            Intrinsics.h(response, "response");
            this.f75195a.resumeWith(Result.m163constructorimpl(response));
        }
    }

    public static final <T> Object a(final retrofit2.b<T> bVar, Continuation<? super T> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.c(continuation), 1);
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: retrofit2.KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th2) {
                invoke2(th2);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th2) {
                bVar.cancel();
            }
        });
        bVar.e(new a(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == kotlin.coroutines.intrinsics.a.e()) {
            DebugProbesKt.c(continuation);
        }
        return result;
    }

    @JvmName
    public static final <T> Object b(final retrofit2.b<T> bVar, Continuation<? super T> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.c(continuation), 1);
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: retrofit2.KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th2) {
                invoke2(th2);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th2) {
                bVar.cancel();
            }
        });
        bVar.e(new b(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == kotlin.coroutines.intrinsics.a.e()) {
            DebugProbesKt.c(continuation);
        }
        return result;
    }

    public static final <T> Object c(final retrofit2.b<T> bVar, Continuation<? super b0<T>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.c(continuation), 1);
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: retrofit2.KotlinExtensions$awaitResponse$$inlined$suspendCancellableCoroutine$lambda$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th2) {
                invoke2(th2);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th2) {
                bVar.cancel();
            }
        });
        bVar.e(new c(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == kotlin.coroutines.intrinsics.a.e()) {
            DebugProbesKt.c(continuation);
        }
        return result;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object d(final Exception exc, Continuation<?> continuation) throws Throwable {
        final KotlinExtensions$suspendAndThrow$1 kotlinExtensions$suspendAndThrow$1;
        if (continuation instanceof KotlinExtensions$suspendAndThrow$1) {
            kotlinExtensions$suspendAndThrow$1 = (KotlinExtensions$suspendAndThrow$1) continuation;
            int i11 = kotlinExtensions$suspendAndThrow$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                kotlinExtensions$suspendAndThrow$1.label = i11 - Integer.MIN_VALUE;
            } else {
                kotlinExtensions$suspendAndThrow$1 = new KotlinExtensions$suspendAndThrow$1(continuation);
            }
        } else {
            kotlinExtensions$suspendAndThrow$1 = new KotlinExtensions$suspendAndThrow$1(continuation);
        }
        Object obj = kotlinExtensions$suspendAndThrow$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = kotlinExtensions$suspendAndThrow$1.label;
        if (i12 == 0) {
            ResultKt.b(obj);
            kotlinExtensions$suspendAndThrow$1.L$0 = exc;
            kotlinExtensions$suspendAndThrow$1.label = 1;
            w0.a().dispatch(kotlinExtensions$suspendAndThrow$1.getContext(), new Runnable() { // from class: retrofit2.KotlinExtensions$suspendAndThrow$$inlined$suspendCoroutineUninterceptedOrReturn$lambda$1
                @Override // java.lang.Runnable
                public final void run() {
                    Continuation continuationC = IntrinsicsKt__IntrinsicsJvmKt.c(kotlinExtensions$suspendAndThrow$1);
                    Exception exc2 = exc;
                    Result.Companion companion = Result.Companion;
                    continuationC.resumeWith(Result.m163constructorimpl(ResultKt.a(exc2)));
                }
            });
            Object objE2 = kotlin.coroutines.intrinsics.a.e();
            if (objE2 == kotlin.coroutines.intrinsics.a.e()) {
                DebugProbesKt.c(kotlinExtensions$suspendAndThrow$1);
            }
            if (objE2 == objE) {
                return objE;
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f68710a;
    }
}
