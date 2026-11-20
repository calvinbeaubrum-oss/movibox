package com.transsion.subtitle_download.task;

import android.app.Application;
import android.os.Environment;
import com.blankj.utilcode.util.Utils;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.transsion.subtitle_download.SubtitleDownloadManager;
import com.transsion.subtitle_download.db.SubtitleDownloadDatabase;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import com.transsion.subtitle_download.utils.c;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.Call;
import okhttp3.Callback;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public abstract class BaseSubtitleDownloadTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f58360a = new a(0 == true ? 1 : 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f58361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f58362c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy<OkHttpClient> f58363d;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final OkHttpClient b() {
            return (OkHttpClient) BaseSubtitleDownloadTask.f58363d.getValue();
        }

        public final String c() {
            return BaseSubtitleDownloadTask.f58361b;
        }

        public final String d() {
            return BaseSubtitleDownloadTask.f58362c;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements Callback {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SubtitleDownloadTable f58365b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f58366c;

        public b(SubtitleDownloadTable subtitleDownloadTable, Function0<Unit> function0) {
            this.f58365b = subtitleDownloadTable;
            this.f58366c = function0;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException e11) {
            Intrinsics.g(call, "call");
            Intrinsics.g(e11, "e");
            BaseSubtitleDownloadTask.this.f(this.f58365b, new RuntimeException(e11.getMessage()));
            this.f58366c.invoke();
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            int iCode;
            Intrinsics.g(call, "call");
            Intrinsics.g(response, "response");
            if (response.isSuccessful()) {
                BaseSubtitleDownloadTask.this.g(response, this.f58365b);
                this.f58366c.invoke();
            } else if (response.code() != 404 && 400 <= (iCode = response.code()) && iCode < 600) {
                BaseSubtitleDownloadTask.this.e(response, this.f58365b, this.f58366c);
            } else {
                BaseSubtitleDownloadTask.this.f(this.f58365b, new RuntimeException(response.message()));
                this.f58366c.invoke();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        File externalFilesDir = Utils.a().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        String absolutePath = externalFilesDir != null ? externalFilesDir.getAbsolutePath() : null;
        char c11 = File.separatorChar;
        f58361b = absolutePath + c11 + "subtitle";
        File externalFilesDir2 = Utils.a().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        f58362c = (externalFilesDir2 != null ? externalFilesDir2.getAbsolutePath() : null) + c11 + "subtitle_zip";
        f58363d = LazyKt__LazyJVMKt.b(new Function0<OkHttpClient>() { // from class: com.transsion.subtitle_download.task.BaseSubtitleDownloadTask$Companion$client$2
            @Override // kotlin.jvm.functions.Function0
            public final OkHttpClient invoke() {
                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                TimeUnit timeUnit = TimeUnit.SECONDS;
                return builder.connectTimeout(30L, timeUnit).writeTimeout(30L, timeUnit).readTimeout(30L, timeUnit).cache(null).build();
            }
        });
    }

    public final void e(Response response, SubtitleDownloadTable subtitleDownloadTable, Function0<Unit> function0) {
        f(subtitleDownloadTable, new RuntimeException(response.message()));
        function0.invoke();
    }

    public final void f(SubtitleDownloadTable dbBean, Exception e11) {
        Intrinsics.g(dbBean, "dbBean");
        Intrinsics.g(e11, "e");
        dbBean.setFailCount(dbBean.getFailCount() + 1);
        com.transsion.subtitle_download.utils.b bVar = com.transsion.subtitle_download.utils.b.f58375a;
        bVar.b(j() + " --> disposeOnFailure() --> e = " + e11.getMessage() + " -- getSubtitleInfo = " + dbBean.getSubtitleInfo() + " --> dbBean.failCount = " + dbBean.getFailCount());
        dbBean.setStatus(6);
        if (dbBean.getType() == 2 || dbBean.getType() == 4 || dbBean.getType() == 5 || dbBean.getFailCount() > 5) {
            bVar.b(j() + " --> disposeOnFailure() --> delete(dbBean) --> 如果是搜索字幕，下载失败就从数据库移除 --> getSubtitleInfo = " + dbBean.getSubtitleInfo() + " --> failCount = " + dbBean.getFailCount());
            SubtitleDownloadDatabase.b bVar2 = SubtitleDownloadDatabase.f58352p;
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            bVar2.b(applicationA).J().g(dbBean);
        } else {
            SubtitleDownloadDatabase.b bVar3 = SubtitleDownloadDatabase.f58352p;
            Application applicationA2 = Utils.a();
            Intrinsics.f(applicationA2, "getApp()");
            bVar3.b(applicationA2).J().f(dbBean);
        }
        SubtitleDownloadManager.f58349a.k(e11, dbBean);
    }

    public abstract void g(Response response, SubtitleDownloadTable subtitleDownloadTable);

    public boolean h(Response response, String destination, long j11, SubtitleDownloadTable dbBean, Function1<? super Integer, Unit> progressCallback, Function0<Unit> completeCallback) {
        Intrinsics.g(response, "response");
        Intrinsics.g(destination, "destination");
        Intrinsics.g(dbBean, "dbBean");
        Intrinsics.g(progressCallback, "progressCallback");
        Intrinsics.g(completeCallback, "completeCallback");
        if (j11 <= 0 && !dbBean.isOpenSbNewApi()) {
            f(dbBean, new RuntimeException(j() + " --> disposeOutputStream --> length <= 0 --> length = " + j11));
            return false;
        }
        c cVar = c.f58376a;
        cVar.a(f58361b);
        cVar.a(f58362c);
        try {
            ResponseBody responseBodyBody = response.body();
            InputStream inputStreamByteStream = responseBodyBody != null ? responseBodyBody.byteStream() : null;
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(destination);
                try {
                    byte[] bArr = new byte[102400];
                    dbBean.setStatus(2);
                    int i11 = 0;
                    int i12 = 0;
                    while (true) {
                        if (inputStreamByteStream != null && (i11 = inputStreamByteStream.read(bArr)) == -1) {
                            Unit unit = Unit.f68710a;
                            CloseableKt.a(fileOutputStream, null);
                            CloseableKt.a(inputStreamByteStream, null);
                            return true;
                        }
                        fileOutputStream.write(bArr, 0, i11);
                        i12 += i11;
                        int i13 = (int) (((i12 * 1.0f) / j11) * 100);
                        progressCallback.invoke(Integer.valueOf(i13));
                        if (i13 >= 100) {
                            completeCallback.invoke();
                        }
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
        } catch (Exception e11) {
            f(dbBean, new RuntimeException(j() + " --> disposeOutputStream --> 字幕下载出问题了,e = " + e11.getMessage()));
            return false;
        }
    }

    public final void i(SubtitleDownloadTable dbBean, Function0<Unit> callback) {
        Intrinsics.g(dbBean, "dbBean");
        Intrinsics.g(callback, "callback");
        com.transsion.subtitle_download.utils.b bVar = com.transsion.subtitle_download.utils.b.f58375a;
        bVar.a(j() + " --> download() --> 字幕下载 --> 开始执行下载任务了 --> getSubtitleInfo = " + dbBean.getSubtitleInfo());
        bVar.a("开始执行下载任务了 --> url = " + dbBean.getUrl());
        Request.Builder builder = new Request.Builder();
        String url = dbBean.getUrl();
        if (url == null) {
            url = "";
        }
        FirebasePerfOkHttpClient.enqueue(f58360a.b().newCall(builder.url(url).build()), new b(dbBean, callback));
    }

    public final String j() {
        String simpleName = getClass().getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }
}
