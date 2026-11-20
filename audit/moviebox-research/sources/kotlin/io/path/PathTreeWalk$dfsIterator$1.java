package kotlin.io.path;

import java.nio.file.Path;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.SequenceScope;

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
@DebugMetadata(c = "kotlin.io.path.PathTreeWalk$dfsIterator$1", f = "PathTreeWalk.kt", l = {184, 190, 199, 205}, m = "invokeSuspend")
@SourceDebugExtension
public final class PathTreeWalk$dfsIterator$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Path>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ PathTreeWalk this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PathTreeWalk$dfsIterator$1(PathTreeWalk pathTreeWalk, Continuation<? super PathTreeWalk$dfsIterator$1> continuation) {
        super(2, continuation);
        this.this$0 = pathTreeWalk;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PathTreeWalk$dfsIterator$1 pathTreeWalk$dfsIterator$1 = new PathTreeWalk$dfsIterator$1(this.this$0, continuation);
        pathTreeWalk$dfsIterator$1.L$0 = obj;
        return pathTreeWalk$dfsIterator$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope<? super Path> sequenceScope, Continuation<? super Unit> continuation) {
        return ((PathTreeWalk$dfsIterator$1) create(sequenceScope, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x014f  */
    /* JADX WARN: Code duplicated, block: B:44:0x018c  */
    /* JADX WARN: Code duplicated, block: B:46:0x0192  */
    /* JADX WARN: Code duplicated, block: B:48:0x01a6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:49:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:51:0x01bf A[PHI: r2 r6 r9 r10 r11 r12 r13
  0x01bf: PHI (r2v12 kotlin.io.path.e) = (r2v10 kotlin.io.path.e), (r2v14 kotlin.io.path.e) binds: [B:45:0x0190, B:50:0x01b3] A[DONT_GENERATE, DONT_INLINE]
  0x01bf: PHI (r6v19 kotlin.collections.ArrayDeque) = (r6v17 kotlin.collections.ArrayDeque), (r6v21 kotlin.collections.ArrayDeque) binds: [B:45:0x0190, B:50:0x01b3] A[DONT_GENERATE, DONT_INLINE]
  0x01bf: PHI (r9v10 kotlin.sequences.SequenceScope) = (r9v8 kotlin.sequences.SequenceScope), (r9v12 kotlin.sequences.SequenceScope) binds: [B:45:0x0190, B:50:0x01b3] A[DONT_GENERATE, DONT_INLINE]
  0x01bf: PHI (r10v6 kotlin.io.path.PathTreeWalk$dfsIterator$1) = (r10v5 kotlin.io.path.PathTreeWalk$dfsIterator$1), (r10v7 kotlin.io.path.PathTreeWalk$dfsIterator$1) binds: [B:45:0x0190, B:50:0x01b3] A[DONT_GENERATE, DONT_INLINE]
  0x01bf: PHI (r11v24 kotlin.io.path.h) = (r11v17 kotlin.io.path.h), (r11v26 kotlin.io.path.h) binds: [B:45:0x0190, B:50:0x01b3] A[DONT_GENERATE, DONT_INLINE]
  0x01bf: PHI (r12v14 kotlin.io.path.PathTreeWalk) = (r12v11 kotlin.io.path.PathTreeWalk), (r12v24 kotlin.io.path.PathTreeWalk) binds: [B:45:0x0190, B:50:0x01b3] A[DONT_GENERATE, DONT_INLINE]
  0x01bf: PHI (r13v8 java.nio.file.Path) = (r13v6 java.nio.file.Path), (r13v10 java.nio.file.Path) binds: [B:45:0x0190, B:50:0x01b3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:53:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:54:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:67:0x0186 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:69:0x0162 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x01d5 -> B:36:0x0148). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x01d7 -> B:36:0x0148). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            Method dump skipped, instruction units count: 548
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathTreeWalk$dfsIterator$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
