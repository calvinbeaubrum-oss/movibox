package com.transsnet.downloader.core.task;

import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.DownloadRange;
import com.transsnet.downloader.core.DownloadOkHttpGenerator;
import com.transsnet.downloader.core.thread.DownloadBaseRunnable;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
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
public final class DownloadFileInfoTask {
    public final void b(DownloadBean bean) {
        Intrinsics.g(bean, "bean");
        j.d(l0.a(w0.b()), null, null, new DownloadFileInfoTask$checkFileInfo$1(this, bean, null), 3, null);
    }

    public final void c(DownloadBean downloadBean, long j11) {
        if (j11 <= 0) {
            return;
        }
        if (downloadBean.getProgress() == 0) {
            uo.b.a aVar = uo.b.f78622a;
            uo.b.a.f(aVar, DownloadBaseRunnable.TAG, "-------try update download size, net size = " + downloadBean.getSize() + ", real size = " + j11, false, 4, null);
            Long size = downloadBean.getSize();
            if (size == null || size.longValue() != j11) {
                uo.b.a.f(aVar, DownloadBaseRunnable.TAG, "-------update download size, net size = " + downloadBean.getSize() + ", real size = " + j11, false, 4, null);
                downloadBean.setSize(Long.valueOf(j11));
            }
        }
        Long size2 = downloadBean.getSize();
        if (size2 != null) {
            long jLongValue = size2.longValue();
            List<DownloadRange> downloadRanges = downloadBean.getDownloadRanges();
            if (downloadRanges.size() > 1) {
                kotlin.collections.j.z(downloadRanges, new Comparator() { // from class: com.transsnet.downloader.core.task.DownloadFileInfoTask$checkInfoAndUpdate$lambda$2$$inlined$sortBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t11, T t12) {
                        return kotlin.comparisons.b.d(Long.valueOf(((DownloadRange) t11).getStart()), Long.valueOf(((DownloadRange) t12).getStart()));
                    }
                });
            }
            DownloadRange downloadRange = (DownloadRange) CollectionsKt___CollectionsKt.q0(downloadBean.getDownloadRanges());
            if (jLongValue <= 0 || downloadRange.getEnd() < jLongValue) {
                return;
            }
            downloadRange.setEnd(jLongValue - 1);
        }
    }

    public final void d(DownloadBean downloadBean) {
        Call callNewCall = null;
        try {
            OkHttpClient okHttpClientB = DownloadOkHttpGenerator.f60434c.a().b();
            Request.Builder builder = new Request.Builder();
            builder.url(downloadBean.getUrl());
            builder.addHeader("Range", "bytes=0-");
            callNewCall = okHttpClientB.newCall(builder.build());
            Response responseExecute = FirebasePerfOkHttpClient.execute(callNewCall);
            int iCode = responseExecute.code();
            if (iCode == 200 || iCode == 206) {
                ResponseBody responseBodyBody = responseExecute.body();
                c(downloadBean, responseBodyBody != null ? responseBodyBody.contentLength() : 0L);
            }
            if (callNewCall == null) {
            }
        } catch (Throwable th2) {
            try {
                uo.b.f78622a.i("DownloadFileInfoTask --> checkWithOkhttp --> e = " + th2, true);
            } finally {
                if (callNewCall != null) {
                    callNewCall.cancel();
                }
            }
        }
    }
}
