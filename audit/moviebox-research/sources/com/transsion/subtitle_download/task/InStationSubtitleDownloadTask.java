package com.transsion.subtitle_download.task;

import android.app.Application;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.blankj.utilcode.util.Utils;
import com.transsion.subtitle_download.SubtitleDownloadManager;
import com.transsion.subtitle_download.db.SubtitleDownloadDatabase;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import com.transsion.subtitle_download.utils.b;
import com.transsion.subtitle_download.utils.c;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.Response;
import okhttp3.ResponseBody;

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
public final class InStationSubtitleDownloadTask extends BaseSubtitleDownloadTask {
    @Override // com.transsion.subtitle_download.task.BaseSubtitleDownloadTask
    public void g(Response response, final SubtitleDownloadTable dbBean) {
        String str;
        String str2;
        String strV0;
        Intrinsics.g(response, "response");
        Intrinsics.g(dbBean, "dbBean");
        ResponseBody responseBodyBody = response.body();
        long jContentLength = responseBodyBody != null ? responseBodyBody.contentLength() : 0L;
        if (response.body() == null) {
            b.f58375a.b(j() + " --> disposeOnResponse() --> null == response.body --> headers = " + response.headers());
        }
        String url = dbBean.getUrl();
        String strR0 = null;
        if (url != null && (strV0 = StringsKt__StringsKt.V0(url, "?", null, 2, null)) != null) {
            strR0 = StringsKt__StringsKt.R0(strV0, InstructionFileId.DOT, null, 2, null);
        }
        String strValueOf = String.valueOf(strR0);
        if (dbBean.getEp() > 0) {
            str = dbBean.getSubjectFileName() + "_S" + dbBean.getSe() + "_E" + dbBean.getEp() + "_" + dbBean.getLanName() + InstructionFileId.DOT + strValueOf;
        } else {
            str = dbBean.getSubjectFileName() + "_" + dbBean.getLanName() + InstructionFileId.DOT + strValueOf;
        }
        if (dbBean.getEp() > 0) {
            str2 = BaseSubtitleDownloadTask.f58360a.c() + File.separatorChar + dbBean.getSubjectFileName() + "_S" + dbBean.getSe() + "_E" + dbBean.getEp();
        } else {
            str2 = BaseSubtitleDownloadTask.f58360a.c() + File.separatorChar + dbBean.getSubjectFileName();
        }
        c.f58376a.a(str2);
        final String str3 = str2 + File.separatorChar + str;
        b.f58375a.a(j() + " --> disposeOnResponse() --> 接口请求成功 开始保存数据到本 --> " + dbBean.getName() + InstructionFileId.DOT + dbBean.getResourceId() + ",文件大小 = " + jContentLength + " --> destination = " + str3);
        h(response, str3, jContentLength, dbBean, new Function1<Integer, Unit>() { // from class: com.transsion.subtitle_download.task.InStationSubtitleDownloadTask$disposeOnResponse$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.f68710a;
            }

            public final void invoke(int i11) {
                SubtitleDownloadManager.f58349a.l(i11, dbBean);
            }
        }, new Function0<Unit>() { // from class: com.transsion.subtitle_download.task.InStationSubtitleDownloadTask$disposeOnResponse$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                dbBean.setPath(str3);
                c.f58376a.i(dbBean);
                dbBean.setStatus(5);
                SubtitleDownloadDatabase.b bVar = SubtitleDownloadDatabase.f58352p;
                Application applicationA = Utils.a();
                Intrinsics.f(applicationA, "getApp()");
                bVar.b(applicationA).J().f(dbBean);
                b.f58375a.a(this.j() + " --> disposeOnResponse() --> 文件保存在 = " + str3 + " -- resourceId = " + dbBean.getResourceId() + " --> getSubtitleInfo = " + dbBean.getSubtitleInfo());
                SubtitleDownloadManager.f58349a.j(dbBean);
            }
        });
    }
}
