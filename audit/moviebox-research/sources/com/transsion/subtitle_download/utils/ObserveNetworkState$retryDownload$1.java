package com.transsion.subtitle_download.utils;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.tn.lib.util.networkinfo.f;
import com.transsion.subtitle_download.db.SubtitleDownloadDatabase;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import com.transsion.subtitle_download.task.SubtitleDownloadTaskManager;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.r0;

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
@DebugMetadata(c = "com.transsion.subtitle_download.utils.ObserveNetworkState$retryDownload$1", f = "ObserveNetworkState.kt", l = {59, 66}, m = "invokeSuspend")
@SourceDebugExtension
public final class ObserveNetworkState$retryDownload$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $msg;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObserveNetworkState$retryDownload$1(String str, Continuation<? super ObserveNetworkState$retryDownload$1> continuation) {
        super(2, continuation);
        this.$msg = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ObserveNetworkState$retryDownload$1(this.$msg, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((ObserveNetworkState$retryDownload$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0059  */
    /* JADX WARN: Code duplicated, block: B:25:0x0092 A[LOOP:0: B:23:0x008c->B:25:0x0092, LOOP_END] */
    /* JADX WARN: Instruction removed from duplicated block: B:22:0x0059, please report this as an issue */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        List list;
        Iterator it;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 != 0) {
            if (i11 == 1) {
                ResultKt.b(obj);
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            list = (List) obj;
            if (list != null) {
                String str = this.$msg;
                b.f58375a.a(ObserveNetworkState.f58373a.b() + " --> retryDownload() --> " + str + " --> 数据库获取到的失败的任务数量 it.size = " + list.size());
                it = list.iterator();
                while (it.hasNext()) {
                    SubtitleDownloadTaskManager.c(SubtitleDownloadTaskManager.f58369a, (SubtitleDownloadTable) it.next(), false, 2, null);
                }
            }
            return Unit.f68710a;
        }
        ResultKt.b(obj);
        this.label = 1;
        if (r0.a(5000L, this) == objE) {
            return objE;
        }
        if (!f.f49475a.e()) {
            return Unit.f68710a;
        }
        SubtitleDownloadDatabase.b bVar = SubtitleDownloadDatabase.f58352p;
        Application applicationA = Utils.a();
        Intrinsics.f(applicationA, "getApp()");
        dy.a aVarJ = bVar.b(applicationA).J();
        this.label = 2;
        obj = dy.a.C0651a.a(aVarJ, 0, this, 1, null);
        if (obj == objE) {
            return objE;
        }
        list = (List) obj;
        if (list != null) {
            String str2 = this.$msg;
            b.f58375a.a(ObserveNetworkState.f58373a.b() + " --> retryDownload() --> " + str2 + " --> 数据库获取到的失败的任务数量 it.size = " + list.size());
            it = list.iterator();
            while (it.hasNext()) {
                SubtitleDownloadTaskManager.c(SubtitleDownloadTaskManager.f58369a, (SubtitleDownloadTable) it.next(), false, 2, null);
            }
        }
        return Unit.f68710a;
    }
}
