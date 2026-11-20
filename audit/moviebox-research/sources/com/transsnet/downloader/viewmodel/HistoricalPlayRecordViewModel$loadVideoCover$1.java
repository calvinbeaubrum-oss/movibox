package com.transsnet.downloader.viewmodel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.k0;

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
@DebugMetadata(c = "com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel$loadVideoCover$1", f = "HistoricalPlayRecordViewModel.kt", l = {207, 211, 218}, m = "invokeSuspend")
@SourceDebugExtension
public final class HistoricalPlayRecordViewModel$loadVideoCover$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ HistoricalPlayRecordViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HistoricalPlayRecordViewModel$loadVideoCover$1(HistoricalPlayRecordViewModel historicalPlayRecordViewModel, Continuation<? super HistoricalPlayRecordViewModel$loadVideoCover$1> continuation) {
        super(2, continuation);
        this.this$0 = historicalPlayRecordViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HistoricalPlayRecordViewModel$loadVideoCover$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((HistoricalPlayRecordViewModel$loadVideoCover$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0074 A[Catch: all -> 0x002c, TryCatch #0 {all -> 0x002c, blocks: (B:8:0x0026, B:47:0x00fe, B:49:0x0104, B:51:0x010c, B:52:0x010f, B:54:0x0117, B:56:0x011d, B:58:0x0123, B:60:0x012d, B:64:0x0137, B:63:0x0134, B:22:0x006e, B:24:0x0074, B:26:0x0087, B:30:0x0090, B:34:0x00a6, B:38:0x00c3, B:40:0x00c7, B:44:0x00e1, B:46:0x00ed, B:73:0x0163, B:15:0x0043, B:18:0x0055, B:21:0x0063), top: B:82:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:29:0x008f  */
    /* JADX WARN: Code duplicated, block: B:32:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:33:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:36:0x00c0 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:37:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:40:0x00c7 A[Catch: all -> 0x002c, TryCatch #0 {all -> 0x002c, blocks: (B:8:0x0026, B:47:0x00fe, B:49:0x0104, B:51:0x010c, B:52:0x010f, B:54:0x0117, B:56:0x011d, B:58:0x0123, B:60:0x012d, B:64:0x0137, B:63:0x0134, B:22:0x006e, B:24:0x0074, B:26:0x0087, B:30:0x0090, B:34:0x00a6, B:38:0x00c3, B:40:0x00c7, B:44:0x00e1, B:46:0x00ed, B:73:0x0163, B:15:0x0043, B:18:0x0055, B:21:0x0063), top: B:82:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00de A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:43:0x00df  */
    /* JADX WARN: Code duplicated, block: B:46:0x00ed A[Catch: all -> 0x002c, TryCatch #0 {all -> 0x002c, blocks: (B:8:0x0026, B:47:0x00fe, B:49:0x0104, B:51:0x010c, B:52:0x010f, B:54:0x0117, B:56:0x011d, B:58:0x0123, B:60:0x012d, B:64:0x0137, B:63:0x0134, B:22:0x006e, B:24:0x0074, B:26:0x0087, B:30:0x0090, B:34:0x00a6, B:38:0x00c3, B:40:0x00c7, B:44:0x00e1, B:46:0x00ed, B:73:0x0163, B:15:0x0043, B:18:0x0055, B:21:0x0063), top: B:82:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:71:0x015f  */
    /* JADX WARN: Code duplicated, block: B:88:0x0087 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:? A[LOOP:1: B:22:0x006e->B:90:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00c5 -> B:72:0x0160). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00ed -> B:47:0x00fe). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x0152 -> B:68:0x0154). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x015f -> B:72:0x0160). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            Method dump skipped, instruction units count: 404
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel$loadVideoCover$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
