package com.transsnet.downloader;

import com.transsion.baselib.db.download.DownloadBean;
import com.transsnet.downloader.viewmodel.DownloadListManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
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
@DebugMetadata(c = "com.transsnet.downloader.DownloadManagerApi$fetchLatestDownloadData$2", f = "DownloadManagerApi.kt", l = {101, 102}, m = "invokeSuspend")
public final class DownloadManagerApi$fetchLatestDownloadData$2 extends SuspendLambda implements Function2<k0, Continuation<? super Pair<? extends Integer, ? extends List<? extends DownloadBean>>>, Object> {
    Object L$0;
    int label;

    public DownloadManagerApi$fetchLatestDownloadData$2(Continuation<? super DownloadManagerApi$fetchLatestDownloadData$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadManagerApi$fetchLatestDownloadData$2(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(k0 k0Var, Continuation<? super Pair<? extends Integer, ? extends List<? extends DownloadBean>>> continuation) {
        return invoke2(k0Var, (Continuation<? super Pair<Integer, ? extends List<? extends DownloadBean>>>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(k0 k0Var, Continuation<? super Pair<Integer, ? extends List<? extends DownloadBean>>> continuation) {
        return ((DownloadManagerApi$fetchLatestDownloadData$2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x004e  */
    /* JADX WARN: Code duplicated, block: B:20:0x0053  */
    /* JADX WARN: Code duplicated, block: B:23:0x005c  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        List arrayList;
        List list;
        int size;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 != 0) {
            if (i11 == 1) {
                ResultKt.b(obj);
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                arrayList = (List) this.L$0;
                ResultKt.b(obj);
            }
            list = (List) obj;
            if (list != null) {
                size = list.size();
            } else {
                size = 0;
            }
            Integer numD = Boxing.d(size);
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            return new Pair(numD, arrayList);
        }
        ResultKt.b(obj);
        DownloadListManager downloadListManagerA = DownloadListManager.f61186m.a();
        this.label = 1;
        obj = downloadListManagerA.y(3, this);
        if (obj == objE) {
            return objE;
        }
        List list2 = (List) obj;
        DownloadListManager downloadListManagerA2 = DownloadListManager.f61186m.a();
        this.L$0 = list2;
        this.label = 2;
        Object objD = downloadListManagerA2.D(this);
        if (objD == objE) {
            return objE;
        }
        arrayList = list2;
        obj = objD;
        list = (List) obj;
        if (list != null) {
            size = list.size();
        } else {
            size = 0;
        }
        Integer numD2 = Boxing.d(size);
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        return new Pair(numD2, arrayList);
    }
}
