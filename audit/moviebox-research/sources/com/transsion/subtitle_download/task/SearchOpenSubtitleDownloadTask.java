package com.transsion.subtitle_download.task;

import android.app.Application;
import android.net.Uri;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.blankj.utilcode.util.Utils;
import com.transsion.subtitle_download.SubtitleDownloadManager;
import com.transsion.subtitle_download.db.SubtitleDownloadDatabase;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import com.transsion.subtitle_download.utils.b;
import com.transsion.subtitle_download.utils.c;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
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
public final class SearchOpenSubtitleDownloadTask extends BaseSubtitleDownloadTask {
    @Override // com.transsion.subtitle_download.task.BaseSubtitleDownloadTask
    public void g(Response response, final SubtitleDownloadTable dbBean) {
        String str;
        Intrinsics.g(response, "response");
        Intrinsics.g(dbBean, "dbBean");
        int iCode = response.code();
        if (200 > iCode || iCode >= 300) {
            f(dbBean, new RuntimeException(j() + " --> disposeOnResponse() --> 搜索字幕接口请求失败 --> response.code = " + response.code()));
            return;
        }
        String str2 = response.headers().get(HttpHeaders.CONTENT_DISPOSITION);
        List listE0 = str2 != null ? StringsKt__StringsKt.E0(str2, new String[]{"filename="}, false, 0, 6, null) : null;
        b bVar = b.f58375a;
        bVar.a(j() + " --> disposeOnResponse() --> 请求成功 --> response.code = " + response.code() + " -- list = " + listE0);
        if (listE0 == null || !(!listE0.isEmpty()) || listE0.size() <= 1) {
            str = BaseSubtitleDownloadTask.f58360a.d() + File.separatorChar + Uri.decode(dbBean.getName()).hashCode();
        } else {
            String strReplace = new Regex("[\\\\/:*?\"<>|]").replace(Uri.decode((String) listE0.get(1)).toString(), "");
            str = BaseSubtitleDownloadTask.f58360a.d() + File.separatorChar + strReplace;
        }
        final String str3 = str;
        ResponseBody responseBodyBody = response.body();
        if (h(response, str3, responseBodyBody != null ? responseBodyBody.contentLength() : 0L, dbBean, new Function1<Integer, Unit>() { // from class: com.transsion.subtitle_download.task.SearchOpenSubtitleDownloadTask$disposeOnResponse$disposeOutputStream$1
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
        }, new Function0<Unit>() { // from class: com.transsion.subtitle_download.task.SearchOpenSubtitleDownloadTask$disposeOnResponse$disposeOutputStream$2
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
                dbBean.setZipPath(str3);
                SubtitleDownloadDatabase.b bVar2 = SubtitleDownloadDatabase.f58352p;
                Application applicationA = Utils.a();
                Intrinsics.f(applicationA, "getApp()");
                bVar2.b(applicationA).J().f(dbBean);
                b.f58375a.a(this.j() + " --> disposeOnResponse() --> 压缩文件保存在 = " + str3 + " -- getSubtitleInfo = " + dbBean.getSubtitleInfo());
            }
        }) && l(dbBean) && k(dbBean)) {
            bVar.b("--------------------------------------------------------------------");
        }
    }

    public final boolean k(SubtitleDownloadTable subtitleDownloadTable) {
        if (c.f58376a.i(subtitleDownloadTable)) {
            b.f58375a.a(j() + " --> parseFileCharsetName() --> 字幕压缩包下载成功 --> 开始解析字幕文件的编码格式 --> 成功 --> 保存状态到数据库");
            subtitleDownloadTable.setStatus(5);
            SubtitleDownloadDatabase.b bVar = SubtitleDownloadDatabase.f58352p;
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            bVar.b(applicationA).J().f(subtitleDownloadTable);
            SubtitleDownloadManager.f58349a.j(subtitleDownloadTable);
            return true;
        }
        try {
            Result.Companion companion = Result.Companion;
            String path = subtitleDownloadTable.getPath();
            if (path == null) {
                path = "";
            }
            Result.m163constructorimpl(Boolean.valueOf(new File(path).delete()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
        f(subtitleDownloadTable, new RuntimeException(j() + " --> parseFileCharsetName() --> 解析字幕文件的编码格式失败 --> 删除字幕文件"));
        return false;
    }

    public final boolean l(SubtitleDownloadTable subtitleDownloadTable) {
        String str;
        boolean z11;
        SubtitleDownloadManager.f58349a.n(subtitleDownloadTable);
        String zipPath = subtitleDownloadTable.getZipPath();
        b bVar = b.f58375a;
        bVar.a(j() + " --> unGzZip() --> 字幕压缩包下载成功 --> 开始解压缩 .... zipPath = " + zipPath);
        if (subtitleDownloadTable.getEp() > 0) {
            str = BaseSubtitleDownloadTask.f58360a.c() + File.separatorChar + subtitleDownloadTable.getSubjectFileName() + "_S" + subtitleDownloadTable.getSe() + "_E" + subtitleDownloadTable.getEp();
        } else {
            str = BaseSubtitleDownloadTask.f58360a.c() + File.separatorChar + subtitleDownloadTable.getSubjectFileName();
        }
        c.f58376a.a(str);
        String str2 = str + File.separatorChar + subtitleDownloadTable.getName();
        boolean zA = com.transsion.subtitle_download.utils.a.f58374a.a(subtitleDownloadTable.getZipPath(), str2);
        if (zA) {
            bVar.a(j() + " --> unGzZip() --> 字幕压缩包下载成功 --> 开始解压缩 --> 解压缩成功");
            subtitleDownloadTable.setPath(str2);
            z11 = true;
        } else {
            f(subtitleDownloadTable, new RuntimeException(j() + " --> unGzZip() --> 字幕压缩文件解压失败"));
            z11 = false;
        }
        try {
            Result.Companion companion = Result.Companion;
            new File(zipPath).delete();
            bVar.a(j() + " --> unGzZip() --> result = " + zA + " -- 无论成功失败，都删除压缩包 -- 这里修改成删除压缩缓存文件夹里面的所有文件");
            Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
        return z11;
    }
}
