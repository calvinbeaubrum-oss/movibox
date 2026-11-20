package androidx.compose.ui.platform;

import androidx.media3.container.MdtaMetadataEntry;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.ui.platform.GlobalSnapshotManager$ensureStarted$1", f = "GlobalSnapshotManager.android.kt", l = {MdtaMetadataEntry.TYPE_INDICATOR_INT32}, m = "invokeSuspend")
@SourceDebugExtension
public final class GlobalSnapshotManager$ensureStarted$1 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ kotlinx.coroutines.channels.a<Unit> $channel;
    Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlobalSnapshotManager$ensureStarted$1(kotlinx.coroutines.channels.a<Unit> aVar, Continuation<? super GlobalSnapshotManager$ensureStarted$1> continuation) {
        super(2, continuation);
        this.$channel = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GlobalSnapshotManager$ensureStarted$1(this.$channel, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
        return ((GlobalSnapshotManager$ensureStarted$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x003c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:17:0x003d  */
    /* JADX WARN: Code duplicated, block: B:20:0x004b A[Catch: all -> 0x0063, TryCatch #1 {all -> 0x0063, blocks: (B:18:0x0043, B:20:0x004b, B:23:0x0066), top: B:32:0x0043 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x003d -> B:32:0x0043). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.e()
            int r1 = r7.label
            r2 = 1
            if (r1 == 0) goto L25
            if (r1 != r2) goto L1d
            java.lang.Object r1 = r7.L$1
            kotlinx.coroutines.channels.c r1 = (kotlinx.coroutines.channels.c) r1
            java.lang.Object r3 = r7.L$0
            kotlinx.coroutines.channels.o r3 = (kotlinx.coroutines.channels.o) r3
            kotlin.ResultKt.b(r8)     // Catch: java.lang.Throwable -> L1b
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r7
            goto L43
        L1b:
            r8 = move-exception
            goto L6f
        L1d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L25:
            kotlin.ResultKt.b(r8)
            kotlinx.coroutines.channels.a<kotlin.Unit> r3 = r7.$channel
            kotlinx.coroutines.channels.c r8 = r3.iterator()     // Catch: java.lang.Throwable -> L1b
            r1 = r8
            r8 = r7
        L30:
            r8.L$0 = r3     // Catch: java.lang.Throwable -> L1b
            r8.L$1 = r1     // Catch: java.lang.Throwable -> L1b
            r8.label = r2     // Catch: java.lang.Throwable -> L1b
            java.lang.Object r4 = r1.a(r8)     // Catch: java.lang.Throwable -> L1b
            if (r4 != r0) goto L3d
            return r0
        L3d:
            r6 = r0
            r0 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r6
        L43:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L63
            boolean r8 = r8.booleanValue()     // Catch: java.lang.Throwable -> L63
            if (r8 == 0) goto L66
            java.lang.Object r8 = r3.next()     // Catch: java.lang.Throwable -> L63
            kotlin.Unit r8 = (kotlin.Unit) r8     // Catch: java.lang.Throwable -> L63
            java.util.concurrent.atomic.AtomicBoolean r8 = androidx.compose.ui.platform.GlobalSnapshotManager.a()     // Catch: java.lang.Throwable -> L63
            r5 = 0
            r8.set(r5)     // Catch: java.lang.Throwable -> L63
            androidx.compose.runtime.snapshots.j$a r8 = androidx.compose.runtime.snapshots.j.f3684e     // Catch: java.lang.Throwable -> L63
            r8.n()     // Catch: java.lang.Throwable -> L63
            r8 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L30
        L63:
            r8 = move-exception
            r3 = r4
            goto L6f
        L66:
            kotlin.Unit r8 = kotlin.Unit.f68710a     // Catch: java.lang.Throwable -> L63
            r8 = 0
            kotlinx.coroutines.channels.h.a(r4, r8)
            kotlin.Unit r8 = kotlin.Unit.f68710a
            return r8
        L6f:
            throw r8     // Catch: java.lang.Throwable -> L70
        L70:
            r0 = move-exception
            kotlinx.coroutines.channels.h.a(r3, r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.GlobalSnapshotManager$ensureStarted$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
