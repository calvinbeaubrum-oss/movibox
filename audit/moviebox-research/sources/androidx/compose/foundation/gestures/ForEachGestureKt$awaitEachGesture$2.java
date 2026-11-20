package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
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
@DebugMetadata(c = "androidx.compose.foundation.gestures.ForEachGestureKt$awaitEachGesture$2", f = "ForEachGesture.kt", l = {104, 107, 112}, m = "invokeSuspend")
public final class ForEachGestureKt$awaitEachGesture$2 extends RestrictedSuspendLambda implements Function2<androidx.compose.ui.input.pointer.e, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<androidx.compose.ui.input.pointer.e, Continuation<? super Unit>, Object> $block;
    final /* synthetic */ CoroutineContext $currentContext;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ForEachGestureKt$awaitEachGesture$2(CoroutineContext coroutineContext, Function2<? super androidx.compose.ui.input.pointer.e, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super ForEachGestureKt$awaitEachGesture$2> continuation) {
        super(2, continuation);
        this.$currentContext = coroutineContext;
        this.$block = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ForEachGestureKt$awaitEachGesture$2 forEachGestureKt$awaitEachGesture$2 = new ForEachGestureKt$awaitEachGesture$2(this.$currentContext, this.$block, continuation);
        forEachGestureKt$awaitEachGesture$2.L$0 = obj;
        return forEachGestureKt$awaitEachGesture$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(androidx.compose.ui.input.pointer.e eVar, Continuation<? super Unit> continuation) {
        return ((ForEachGestureKt$awaitEachGesture$2) create(eVar, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0053 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:25:0x0054  */
    /* JADX WARN: Code duplicated, block: B:28:0x0061 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:29:0x0062  */
    /* JADX WARN: Code duplicated, block: B:43:0x0047 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10, types: [androidx.compose.ui.input.pointer.e, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [androidx.compose.ui.input.pointer.e, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0062 -> B:20:0x003f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0083 -> B:20:0x003f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.e()
            int r1 = r8.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L37
            if (r1 == r4) goto L2e
            if (r1 == r3) goto L21
            if (r1 != r2) goto L19
            java.lang.Object r1 = r8.L$0
            androidx.compose.ui.input.pointer.e r1 = (androidx.compose.ui.input.pointer.e) r1
            kotlin.ResultKt.b(r9)
            goto L28
        L19:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L21:
            java.lang.Object r1 = r8.L$0
            androidx.compose.ui.input.pointer.e r1 = (androidx.compose.ui.input.pointer.e) r1
            kotlin.ResultKt.b(r9)     // Catch: java.util.concurrent.CancellationException -> L2a
        L28:
            r9 = r1
            goto L3e
        L2a:
            r9 = move-exception
            r5 = r1
            r1 = r8
            goto L70
        L2e:
            java.lang.Object r1 = r8.L$0
            androidx.compose.ui.input.pointer.e r1 = (androidx.compose.ui.input.pointer.e) r1
            kotlin.ResultKt.b(r9)     // Catch: java.util.concurrent.CancellationException -> L2a
            r9 = r8
            goto L57
        L37:
            kotlin.ResultKt.b(r9)
            java.lang.Object r9 = r8.L$0
            androidx.compose.ui.input.pointer.e r9 = (androidx.compose.ui.input.pointer.e) r9
        L3e:
            r1 = r8
        L3f:
            kotlin.coroutines.CoroutineContext r5 = r1.$currentContext
            boolean r5 = kotlinx.coroutines.t1.m(r5)
            if (r5 == 0) goto L86
            kotlin.jvm.functions.Function2<androidx.compose.ui.input.pointer.e, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r5 = r1.$block     // Catch: java.util.concurrent.CancellationException -> L6c
            r1.L$0 = r9     // Catch: java.util.concurrent.CancellationException -> L6c
            r1.label = r4     // Catch: java.util.concurrent.CancellationException -> L6c
            java.lang.Object r5 = r5.invoke(r9, r1)     // Catch: java.util.concurrent.CancellationException -> L6c
            if (r5 != r0) goto L54
            return r0
        L54:
            r7 = r1
            r1 = r9
            r9 = r7
        L57:
            r9.L$0 = r1     // Catch: java.util.concurrent.CancellationException -> L66
            r9.label = r3     // Catch: java.util.concurrent.CancellationException -> L66
            java.lang.Object r5 = androidx.compose.foundation.gestures.ForEachGestureKt.b(r1, r9)     // Catch: java.util.concurrent.CancellationException -> L66
            if (r5 != r0) goto L62
            return r0
        L62:
            r7 = r1
            r1 = r9
            r9 = r7
            goto L3f
        L66:
            r5 = move-exception
            r7 = r1
            r1 = r9
            r9 = r5
            r5 = r7
            goto L70
        L6c:
            r5 = move-exception
            r7 = r5
            r5 = r9
            r9 = r7
        L70:
            kotlin.coroutines.CoroutineContext r6 = r1.$currentContext
            boolean r6 = kotlinx.coroutines.t1.m(r6)
            if (r6 == 0) goto L85
            r1.L$0 = r5
            r1.label = r2
            java.lang.Object r9 = androidx.compose.foundation.gestures.ForEachGestureKt.b(r5, r1)
            if (r9 != r0) goto L83
            return r0
        L83:
            r9 = r5
            goto L3f
        L85:
            throw r9
        L86:
            kotlin.Unit r9 = kotlin.Unit.f68710a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ForEachGestureKt$awaitEachGesture$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
