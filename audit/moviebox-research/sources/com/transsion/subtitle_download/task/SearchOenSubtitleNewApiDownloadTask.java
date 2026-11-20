package com.transsion.subtitle_download.task;

import android.app.Application;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.blankj.utilcode.util.Utils;
import com.transsion.subtitle_download.SubtitleDownloadManager;
import com.transsion.subtitle_download.db.SubtitleDownloadDatabase;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import com.transsion.subtitle_download.utils.b;
import com.transsion.subtitle_download.utils.c;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
@SourceDebugExtension
public final class SearchOenSubtitleNewApiDownloadTask extends BaseSubtitleDownloadTask {
    @Override // com.transsion.subtitle_download.task.BaseSubtitleDownloadTask
    public void g(Response response, final SubtitleDownloadTable dbBean) {
        String str;
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
        String strK = k(response);
        if (strK == null) {
            strK = dbBean.getName() + InstructionFileId.DOT + strValueOf;
        }
        if (dbBean.getEp() > 0) {
            str = BaseSubtitleDownloadTask.f58360a.c() + File.separatorChar + dbBean.getSubjectFileName() + "_S" + dbBean.getSe() + "_E" + dbBean.getEp();
        } else {
            str = BaseSubtitleDownloadTask.f58360a.c() + File.separatorChar + dbBean.getSubjectFileName();
        }
        c.f58376a.a(str);
        final String str2 = str + File.separatorChar + strK;
        b.f58375a.a(j() + " --> disposeOnResponse() --> 接口请求成功 开始保存数据到本 --> " + dbBean.getName() + InstructionFileId.DOT + dbBean.getResourceId() + ",文件大小 = " + jContentLength + " --> destination = " + str2);
        h(response, str2, jContentLength, dbBean, new Function1<Integer, Unit>() { // from class: com.transsion.subtitle_download.task.SearchOenSubtitleNewApiDownloadTask$disposeOnResponse$1
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
        }, new Function0<Unit>() { // from class: com.transsion.subtitle_download.task.SearchOenSubtitleNewApiDownloadTask$disposeOnResponse$2
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
                dbBean.setPath(str2);
                c.f58376a.i(dbBean);
                dbBean.setStatus(5);
                SubtitleDownloadDatabase.b bVar = SubtitleDownloadDatabase.f58352p;
                Application applicationA = Utils.a();
                Intrinsics.f(applicationA, "getApp()");
                bVar.b(applicationA).J().f(dbBean);
                b.f58375a.a(this.j() + " --> disposeOnResponse() --> 文件保存在 = " + str2 + " -- resourceId = " + dbBean.getResourceId() + " --> getSubtitleInfo = " + dbBean.getSubtitleInfo());
                SubtitleDownloadManager.f58349a.j(dbBean);
            }
        });
    }

    @Override // com.transsion.subtitle_download.task.BaseSubtitleDownloadTask
    public boolean h(Response response, String destination, long j11, SubtitleDownloadTable dbBean, Function1<? super Integer, Unit> progressCallback, Function0<Unit> completeCallback) {
        InputStream inputStreamByteStream;
        Intrinsics.g(response, "response");
        Intrinsics.g(destination, "destination");
        Intrinsics.g(dbBean, "dbBean");
        Intrinsics.g(progressCallback, "progressCallback");
        Intrinsics.g(completeCallback, "completeCallback");
        c cVar = c.f58376a;
        BaseSubtitleDownloadTask.a aVar = BaseSubtitleDownloadTask.f58360a;
        cVar.a(aVar.c());
        cVar.a(aVar.d());
        try {
            ResponseBody responseBodyBody = response.body();
            if (responseBodyBody == null || (inputStreamByteStream = responseBodyBody.byteStream()) == null) {
                return false;
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(destination);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i11 = inputStreamByteStream.read(bArr);
                        if (i11 == -1) {
                            completeCallback.invoke();
                            CloseableKt.a(fileOutputStream, null);
                            CloseableKt.a(inputStreamByteStream, null);
                            return true;
                        }
                        fileOutputStream.write(bArr, 0, i11);
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.a(inputStreamByteStream, th);
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    try {
                        throw th3;
                    } catch (Throwable th4) {
                        CloseableKt.a(fileOutputStream, th3);
                        throw th4;
                    }
                }
            } catch (Throwable th5) {
                throw th5;
            }
        } catch (Throwable unused) {
            return false;
        }
    }

    public final String k(Response response) {
        String strHeader$default = Response.header$default(response, HttpHeaders.CONTENT_DISPOSITION, null, 2, null);
        if (strHeader$default != null) {
            Matcher matcher = Pattern.compile("filename=\"?([^\";]*)\"?").matcher(strHeader$default);
            if (matcher.find()) {
                return matcher.group(1);
            }
        }
        return null;
    }
}
