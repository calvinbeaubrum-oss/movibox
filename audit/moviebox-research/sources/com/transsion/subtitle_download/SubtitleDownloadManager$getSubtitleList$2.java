package com.transsion.subtitle_download;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.transsion.subtitle_download.db.SubtitleDownloadDatabase;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import com.transsion.subtitle_download.utils.c;
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
@DebugMetadata(c = "com.transsion.subtitle_download.SubtitleDownloadManager$getSubtitleList$2", f = "SubtitleDownloadManager.kt", l = {124}, m = "invokeSuspend")
@SourceDebugExtension
public final class SubtitleDownloadManager$getSubtitleList$2 extends SuspendLambda implements Function2<k0, Continuation<? super List<SubtitleDownloadTable>>, Object> {
    final /* synthetic */ String $resourceId;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubtitleDownloadManager$getSubtitleList$2(String str, Continuation<? super SubtitleDownloadManager$getSubtitleList$2> continuation) {
        super(2, continuation);
        this.$resourceId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubtitleDownloadManager$getSubtitleList$2(this.$resourceId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super List<SubtitleDownloadTable>> continuation) {
        return ((SubtitleDownloadManager$getSubtitleList$2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            SubtitleDownloadDatabase.b bVar = SubtitleDownloadDatabase.f58352p;
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            dy.a aVarJ = bVar.b(applicationA).J();
            String str = this.$resourceId;
            this.label = 1;
            obj = aVarJ.a(str, this);
            if (obj == objE) {
                return objE;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        List<SubtitleDownloadTable> list = (List) obj;
        if (list != null) {
            for (SubtitleDownloadTable subtitleDownloadTable : list) {
                if (!c.f58376a.h(subtitleDownloadTable.getPath())) {
                    subtitleDownloadTable.setStatus(0);
                }
            }
        }
        return list;
    }
}
