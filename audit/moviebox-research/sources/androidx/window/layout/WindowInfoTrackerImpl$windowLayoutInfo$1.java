package androidx.window.layout;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$1", f = "WindowInfoTrackerImpl.kt", l = {54, 55}, m = "invokeSuspend")
public final class WindowInfoTrackerImpl$windowLayoutInfo$1 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.b<? super a0>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ WindowInfoTrackerImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WindowInfoTrackerImpl$windowLayoutInfo$1(WindowInfoTrackerImpl windowInfoTrackerImpl, Activity activity, Continuation<? super WindowInfoTrackerImpl$windowLayoutInfo$1> continuation) {
        super(2, continuation);
        this.this$0 = windowInfoTrackerImpl;
        this.$activity = activity;
    }

    public static final void d(kotlinx.coroutines.channels.a aVar, a0 info) {
        Intrinsics.f(info, "info");
        aVar.f(info);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WindowInfoTrackerImpl$windowLayoutInfo$1 windowInfoTrackerImpl$windowLayoutInfo$1 = new WindowInfoTrackerImpl$windowLayoutInfo$1(this.this$0, this.$activity, continuation);
        windowInfoTrackerImpl$windowLayoutInfo$1.L$0 = obj;
        return windowInfoTrackerImpl$windowLayoutInfo$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.flow.b<? super a0> bVar, Continuation<? super Unit> continuation) {
        return ((WindowInfoTrackerImpl$windowLayoutInfo$1) create(bVar, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0076 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:22:0x0077  */
    /* JADX WARN: Code duplicated, block: B:25:0x0082 A[Catch: all -> 0x0099, TRY_LEAVE, TryCatch #0 {all -> 0x0099, blocks: (B:19:0x0068, B:23:0x007a, B:25:0x0082), top: B:35:0x0068 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x0096 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:28:0x0097  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0097 -> B:35:0x0068). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.e()
            int r1 = r9.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L3d
            if (r1 == r3) goto L2b
            if (r1 != r2) goto L23
            java.lang.Object r1 = r9.L$2
            kotlinx.coroutines.channels.c r1 = (kotlinx.coroutines.channels.c) r1
            java.lang.Object r4 = r9.L$1
            androidx.core.util.a r4 = (androidx.core.util.a) r4
            java.lang.Object r5 = r9.L$0
            kotlinx.coroutines.flow.b r5 = (kotlinx.coroutines.flow.b) r5
            kotlin.ResultKt.b(r10)     // Catch: java.lang.Throwable -> L1f
            r10 = r5
            goto L67
        L1f:
            r10 = move-exception
            r5 = r9
            goto La7
        L23:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L2b:
            java.lang.Object r1 = r9.L$2
            kotlinx.coroutines.channels.c r1 = (kotlinx.coroutines.channels.c) r1
            java.lang.Object r4 = r9.L$1
            androidx.core.util.a r4 = (androidx.core.util.a) r4
            java.lang.Object r5 = r9.L$0
            kotlinx.coroutines.flow.b r5 = (kotlinx.coroutines.flow.b) r5
            kotlin.ResultKt.b(r10)     // Catch: java.lang.Throwable -> L1f
            r6 = r5
            r5 = r9
            goto L7a
        L3d:
            kotlin.ResultKt.b(r10)
            java.lang.Object r10 = r9.L$0
            kotlinx.coroutines.flow.b r10 = (kotlinx.coroutines.flow.b) r10
            kotlinx.coroutines.channels.BufferOverflow r1 = kotlinx.coroutines.channels.BufferOverflow.DROP_OLDEST
            r4 = 4
            r5 = 10
            r6 = 0
            kotlinx.coroutines.channels.a r1 = kotlinx.coroutines.channels.d.b(r5, r1, r6, r4, r6)
            androidx.window.layout.z r4 = new androidx.window.layout.z
            r4.<init>()
            androidx.window.layout.WindowInfoTrackerImpl r5 = r9.this$0
            androidx.window.layout.v r5 = androidx.window.layout.WindowInfoTrackerImpl.b(r5)
            android.app.Activity r6 = r9.$activity
            c6.e r7 = new c6.e
            r7.<init>()
            r5.a(r6, r7, r4)
            kotlinx.coroutines.channels.c r1 = r1.iterator()     // Catch: java.lang.Throwable -> L1f
        L67:
            r5 = r9
        L68:
            r5.L$0 = r10     // Catch: java.lang.Throwable -> L99
            r5.L$1 = r4     // Catch: java.lang.Throwable -> L99
            r5.L$2 = r1     // Catch: java.lang.Throwable -> L99
            r5.label = r3     // Catch: java.lang.Throwable -> L99
            java.lang.Object r6 = r1.a(r5)     // Catch: java.lang.Throwable -> L99
            if (r6 != r0) goto L77
            return r0
        L77:
            r8 = r6
            r6 = r10
            r10 = r8
        L7a:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch: java.lang.Throwable -> L99
            boolean r10 = r10.booleanValue()     // Catch: java.lang.Throwable -> L99
            if (r10 == 0) goto L9b
            java.lang.Object r10 = r1.next()     // Catch: java.lang.Throwable -> L99
            androidx.window.layout.a0 r10 = (androidx.window.layout.a0) r10     // Catch: java.lang.Throwable -> L99
            r5.L$0 = r6     // Catch: java.lang.Throwable -> L99
            r5.L$1 = r4     // Catch: java.lang.Throwable -> L99
            r5.L$2 = r1     // Catch: java.lang.Throwable -> L99
            r5.label = r2     // Catch: java.lang.Throwable -> L99
            java.lang.Object r10 = r6.emit(r10, r5)     // Catch: java.lang.Throwable -> L99
            if (r10 != r0) goto L97
            return r0
        L97:
            r10 = r6
            goto L68
        L99:
            r10 = move-exception
            goto La7
        L9b:
            androidx.window.layout.WindowInfoTrackerImpl r10 = r5.this$0
            androidx.window.layout.v r10 = androidx.window.layout.WindowInfoTrackerImpl.b(r10)
            r10.b(r4)
            kotlin.Unit r10 = kotlin.Unit.f68710a
            return r10
        La7:
            androidx.window.layout.WindowInfoTrackerImpl r0 = r5.this$0
            androidx.window.layout.v r0 = androidx.window.layout.WindowInfoTrackerImpl.b(r0)
            r0.b(r4)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
