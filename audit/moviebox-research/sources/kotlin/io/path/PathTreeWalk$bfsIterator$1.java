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
@DebugMetadata(c = "kotlin.io.path.PathTreeWalk$bfsIterator$1", f = "PathTreeWalk.kt", l = {184, 190}, m = "invokeSuspend")
@SourceDebugExtension
public final class PathTreeWalk$bfsIterator$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Path>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ PathTreeWalk this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PathTreeWalk$bfsIterator$1(PathTreeWalk pathTreeWalk, Continuation<? super PathTreeWalk$bfsIterator$1> continuation) {
        super(2, continuation);
        this.this$0 = pathTreeWalk;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PathTreeWalk$bfsIterator$1 pathTreeWalk$bfsIterator$1 = new PathTreeWalk$bfsIterator$1(this.this$0, continuation);
        pathTreeWalk$bfsIterator$1.L$0 = obj;
        return pathTreeWalk$bfsIterator$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope<? super Path> sequenceScope, Continuation<? super Unit> continuation) {
        return ((PathTreeWalk$bfsIterator$1) create(sequenceScope, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0089  */
    /* JADX WARN: Code duplicated, block: B:17:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:19:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:21:0x00cd A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:22:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:24:0x00de A[PHI: r1 r5 r6 r7 r8 r9 r15
  0x00de: PHI (r1v3 kotlin.io.path.e) = (r1v5 kotlin.io.path.e), (r1v6 kotlin.io.path.e) binds: [B:23:0x00d6, B:18:0x00b7] A[DONT_GENERATE, DONT_INLINE]
  0x00de: PHI (r5v2 kotlin.collections.ArrayDeque) = (r5v4 kotlin.collections.ArrayDeque), (r5v5 kotlin.collections.ArrayDeque) binds: [B:23:0x00d6, B:18:0x00b7] A[DONT_GENERATE, DONT_INLINE]
  0x00de: PHI (r6v4 kotlin.sequences.SequenceScope) = (r6v6 kotlin.sequences.SequenceScope), (r6v7 kotlin.sequences.SequenceScope) binds: [B:23:0x00d6, B:18:0x00b7] A[DONT_GENERATE, DONT_INLINE]
  0x00de: PHI (r7v2 kotlin.io.path.h) = (r7v6 kotlin.io.path.h), (r7v10 kotlin.io.path.h) binds: [B:23:0x00d6, B:18:0x00b7] A[DONT_GENERATE, DONT_INLINE]
  0x00de: PHI (r8v3 kotlin.io.path.PathTreeWalk) = (r8v11 kotlin.io.path.PathTreeWalk), (r8v12 kotlin.io.path.PathTreeWalk) binds: [B:23:0x00d6, B:18:0x00b7] A[DONT_GENERATE, DONT_INLINE]
  0x00de: PHI (r9v2 java.nio.file.Path) = (r9v4 java.nio.file.Path), (r9v5 java.nio.file.Path) binds: [B:23:0x00d6, B:18:0x00b7] A[DONT_GENERATE, DONT_INLINE]
  0x00de: PHI (r15v4 kotlin.io.path.PathTreeWalk$bfsIterator$1) = (r15v5 kotlin.io.path.PathTreeWalk$bfsIterator$1), (r15v6 kotlin.io.path.PathTreeWalk$bfsIterator$1) binds: [B:23:0x00d6, B:18:0x00b7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:26:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:27:0x0100  */
    /* JADX WARN: Code duplicated, block: B:29:0x010c  */
    /* JADX WARN: Code duplicated, block: B:37:0x0121 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x00ad A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:0x0135 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:41:0x0082 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:42:0x0082 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00f4 -> B:11:0x0082). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00f6 -> B:11:0x0082). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:17:0x00b3
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            Method dump skipped, instruction units count: 313
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathTreeWalk$bfsIterator$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
