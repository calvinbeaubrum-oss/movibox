package com.transsnet.downloader.proxy;

import com.transsion.baselib.db.download.DownloadRange;
import java.util.List;
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
@DebugMetadata(c = "com.transsnet.downloader.proxy.DownloadFileCache$updateDBRanges$1", f = "DownloadFileCache.kt", l = {339}, m = "invokeSuspend")
@SourceDebugExtension
public final class DownloadFileCache$updateDBRanges$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<DownloadRange> $downloadRanges;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ DownloadFileCache this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadFileCache$updateDBRanges$1(List<DownloadRange> list, DownloadFileCache downloadFileCache, Continuation<? super DownloadFileCache$updateDBRanges$1> continuation) {
        super(2, continuation);
        this.$downloadRanges = list;
        this.this$0 = downloadFileCache;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadFileCache$updateDBRanges$1(this.$downloadRanges, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((DownloadFileCache$updateDBRanges$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0042 A[Catch: all -> 0x00a4, TryCatch #0 {all -> 0x00a4, blocks: (B:6:0x0017, B:17:0x005b, B:12:0x003c, B:14:0x0042, B:11:0x0027), top: B:22:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:16:0x005a A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0058 -> B:17:0x005b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.e()
            int r1 = r14.label
            r2 = 1
            if (r1 == 0) goto L24
            if (r1 != r2) goto L1c
            java.lang.Object r1 = r14.L$2
            com.transsion.baselib.db.download.DownloadRange r1 = (com.transsion.baselib.db.download.DownloadRange) r1
            java.lang.Object r3 = r14.L$1
            java.util.Iterator r3 = (java.util.Iterator) r3
            java.lang.Object r4 = r14.L$0
            com.transsnet.downloader.proxy.DownloadFileCache r4 = (com.transsnet.downloader.proxy.DownloadFileCache) r4
            kotlin.ResultKt.b(r15)     // Catch: java.lang.Throwable -> La4
            r15 = r14
            goto L5b
        L1c:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L24:
            kotlin.ResultKt.b(r15)
            java.util.ArrayList r15 = new java.util.ArrayList     // Catch: java.lang.Throwable -> La4
            r15.<init>()     // Catch: java.lang.Throwable -> La4
            java.util.List<com.transsion.baselib.db.download.DownloadRange> r1 = r14.$downloadRanges     // Catch: java.lang.Throwable -> La4
            java.util.Collection r1 = (java.util.Collection) r1     // Catch: java.lang.Throwable -> La4
            r15.addAll(r1)     // Catch: java.lang.Throwable -> La4
            com.transsnet.downloader.proxy.DownloadFileCache r1 = r14.this$0     // Catch: java.lang.Throwable -> La4
            java.util.Iterator r15 = r15.iterator()     // Catch: java.lang.Throwable -> La4
            r3 = r15
            r4 = r1
            r15 = r14
        L3c:
            boolean r1 = r3.hasNext()     // Catch: java.lang.Throwable -> La4
            if (r1 == 0) goto La4
            java.lang.Object r1 = r3.next()     // Catch: java.lang.Throwable -> La4
            com.transsion.baselib.db.download.DownloadRange r1 = (com.transsion.baselib.db.download.DownloadRange) r1     // Catch: java.lang.Throwable -> La4
            tr.h r5 = com.transsnet.downloader.proxy.DownloadFileCache.d(r4)     // Catch: java.lang.Throwable -> La4
            r15.L$0 = r4     // Catch: java.lang.Throwable -> La4
            r15.L$1 = r3     // Catch: java.lang.Throwable -> La4
            r15.L$2 = r1     // Catch: java.lang.Throwable -> La4
            r15.label = r2     // Catch: java.lang.Throwable -> La4
            java.lang.Object r5 = r5.c(r1, r15)     // Catch: java.lang.Throwable -> La4
            if (r5 != r0) goto L5b
            return r0
        L5b:
            int r5 = r1.getThreadId()     // Catch: java.lang.Throwable -> La4
            int r6 = r1.getRangeId()     // Catch: java.lang.Throwable -> La4
            long r7 = r1.getStart()     // Catch: java.lang.Throwable -> La4
            long r9 = r1.getEnd()     // Catch: java.lang.Throwable -> La4
            long r11 = r1.getProgress()     // Catch: java.lang.Throwable -> La4
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La4
            r1.<init>()     // Catch: java.lang.Throwable -> La4
            java.lang.String r13 = "================range,  updateDBRanges ，threadId = "
            r1.append(r13)     // Catch: java.lang.Throwable -> La4
            r1.append(r5)     // Catch: java.lang.Throwable -> La4
            java.lang.String r5 = ", rangeId = "
            r1.append(r5)     // Catch: java.lang.Throwable -> La4
            r1.append(r6)     // Catch: java.lang.Throwable -> La4
            java.lang.String r5 = ", start = "
            r1.append(r5)     // Catch: java.lang.Throwable -> La4
            r1.append(r7)     // Catch: java.lang.Throwable -> La4
            java.lang.String r5 = ", end = "
            r1.append(r5)     // Catch: java.lang.Throwable -> La4
            r1.append(r9)     // Catch: java.lang.Throwable -> La4
            java.lang.String r5 = ", progress = "
            r1.append(r5)     // Catch: java.lang.Throwable -> La4
            r1.append(r11)     // Catch: java.lang.Throwable -> La4
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> La4
            com.danikula.videocache.q.c(r1)     // Catch: java.lang.Throwable -> La4
            goto L3c
        La4:
            kotlin.Unit r15 = kotlin.Unit.f68710a
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.proxy.DownloadFileCache$updateDBRanges$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
