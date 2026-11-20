package androidx.compose.ui;

import androidx.media3.container.MdtaMetadataEntry;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

/* JADX INFO: Add missing generic type declarations: [R] */
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
@DebugMetadata(c = "androidx.compose.ui.SessionMutex$withSessionCancellingPrevious$2", f = "SessionMutex.kt", l = {MdtaMetadataEntry.TYPE_INDICATOR_INT32, 69}, m = "invokeSuspend")
public final class SessionMutex$withSessionCancellingPrevious$2<R> extends SuspendLambda implements Function2<k0, Continuation<? super R>, Object> {
    final /* synthetic */ AtomicReference<SessionMutex.a<T>> $arg0;
    final /* synthetic */ Function2<T, Continuation<? super R>, Object> $session;
    final /* synthetic */ Function1<k0, T> $sessionInitializer;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SessionMutex$withSessionCancellingPrevious$2(Function1<? super k0, ? extends T> function1, AtomicReference<SessionMutex.a<T>> atomicReference, Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super SessionMutex$withSessionCancellingPrevious$2> continuation) {
        super(2, continuation);
        this.$sessionInitializer = function1;
        this.$arg0 = atomicReference;
        this.$session = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SessionMutex$withSessionCancellingPrevious$2 sessionMutex$withSessionCancellingPrevious$2 = new SessionMutex$withSessionCancellingPrevious$2(this.$sessionInitializer, this.$arg0, this.$session, continuation);
        sessionMutex$withSessionCancellingPrevious$2.L$0 = obj;
        return sessionMutex$withSessionCancellingPrevious$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super R> continuation) {
        return ((SessionMutex$withSessionCancellingPrevious$2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to androidx.compose.ui.SessionMutex$withSessionCancellingPrevious$2<R> for r7v1 'this'  java.lang.Object
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.e()
            int r1 = r7.label
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L29
            if (r1 == r4) goto L21
            if (r1 != r3) goto L19
            java.lang.Object r0 = r7.L$0
            androidx.compose.ui.SessionMutex$a r0 = (androidx.compose.ui.SessionMutex.a) r0
            kotlin.ResultKt.b(r8)     // Catch: java.lang.Throwable -> L17
            goto L70
        L17:
            r8 = move-exception
            goto L78
        L19:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L21:
            java.lang.Object r1 = r7.L$0
            androidx.compose.ui.SessionMutex$a r1 = (androidx.compose.ui.SessionMutex.a) r1
            kotlin.ResultKt.b(r8)
            goto L5e
        L29:
            kotlin.ResultKt.b(r8)
            java.lang.Object r8 = r7.L$0
            kotlinx.coroutines.k0 r8 = (kotlinx.coroutines.k0) r8
            androidx.compose.ui.SessionMutex$a r1 = new androidx.compose.ui.SessionMutex$a
            kotlin.coroutines.CoroutineContext r5 = r8.getCoroutineContext()
            kotlinx.coroutines.q1 r5 = kotlinx.coroutines.t1.l(r5)
            kotlin.jvm.functions.Function1<kotlinx.coroutines.k0, T> r6 = r7.$sessionInitializer
            java.lang.Object r8 = r6.invoke(r8)
            r1.<init>(r5, r8)
            java.util.concurrent.atomic.AtomicReference<androidx.compose.ui.SessionMutex$a<T>> r8 = r7.$arg0
            java.lang.Object r8 = r8.getAndSet(r1)
            androidx.compose.ui.SessionMutex$a r8 = (androidx.compose.ui.SessionMutex.a) r8
            if (r8 == 0) goto L5e
            kotlinx.coroutines.q1 r8 = r8.a()
            if (r8 == 0) goto L5e
            r7.L$0 = r1
            r7.label = r4
            java.lang.Object r8 = kotlinx.coroutines.t1.g(r8, r7)
            if (r8 != r0) goto L5e
            return r0
        L5e:
            kotlin.jvm.functions.Function2<T, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r8 = r7.$session     // Catch: java.lang.Throwable -> L76
            java.lang.Object r4 = r1.b()     // Catch: java.lang.Throwable -> L76
            r7.L$0 = r1     // Catch: java.lang.Throwable -> L76
            r7.label = r3     // Catch: java.lang.Throwable -> L76
            java.lang.Object r8 = r8.invoke(r4, r7)     // Catch: java.lang.Throwable -> L76
            if (r8 != r0) goto L6f
            return r0
        L6f:
            r0 = r1
        L70:
            java.util.concurrent.atomic.AtomicReference<androidx.compose.ui.SessionMutex$a<T>> r1 = r7.$arg0
            androidx.compose.animation.core.j0.a(r1, r0, r2)
            return r8
        L76:
            r8 = move-exception
            r0 = r1
        L78:
            java.util.concurrent.atomic.AtomicReference<androidx.compose.ui.SessionMutex$a<T>> r1 = r7.$arg0
            androidx.compose.animation.core.j0.a(r1, r0, r2)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.SessionMutex$withSessionCancellingPrevious$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
