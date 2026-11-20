package com.transsnet.downloader.report;

import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.DownloadException;
import com.transsion.baselib.report.m;
import com.transsion.upload.bean.UploadTstTokenStorageType;
import com.transsion.upload.log.UploadLoggerManager;
import com.transsion.web.api.WebConstants;
import com.transsnet.downloader.config.Config;
import com.transsnet.downloader.core.thread.DownloadBaseRunnable;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import java.net.InetAddress;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.l;

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
public final class DownloadReporter {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f61112c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy<DownloadReporter> f61113d = LazyKt__LazyJVMKt.b(new Function0<DownloadReporter>() { // from class: com.transsnet.downloader.report.DownloadReporter$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DownloadReporter invoke() {
            return new DownloadReporter();
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, c> f61114a = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f61115b = LazyKt__LazyJVMKt.b(new Function0<ILoginApi>() { // from class: com.transsnet.downloader.report.DownloadReporter$loginApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ILoginApi invoke() {
            return (ILoginApi) com.alibaba.android.arouter.launcher.a.d().h(ILoginApi.class);
        }
    });

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DownloadReporter a() {
            return (DownloadReporter) DownloadReporter.f61113d.getValue();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements ty.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<String, Unit> f61116a;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Function1<? super String, Unit> function1) {
            this.f61116a = function1;
        }

        @Override // ty.a
        public void a(String uploadKey, long j11, long j12) {
            Intrinsics.g(uploadKey, "uploadKey");
        }

        @Override // ty.a
        public void b(String uploadKey, String url, String bucket) {
            Intrinsics.g(uploadKey, "uploadKey");
            Intrinsics.g(url, "url");
            Intrinsics.g(bucket, "bucket");
            this.f61116a.invoke(url);
        }

        @Override // ty.a
        public void c(String uploadKey, String str, String str2, UploadTstTokenStorageType uploadTstTokenStorageType) {
            Intrinsics.g(uploadKey, "uploadKey");
            this.f61116a.invoke(null);
        }
    }

    public final void c(c cVar, DownloadBean downloadBean, long j11, HashMap<String, String> map) {
        long jC = j11 - cVar.c();
        if (cVar.c() > 0 && jC > 0 && jC < TimeUnit.MINUTES.toMillis(2L)) {
            downloadBean.setSessionTime(downloadBean.getSessionTime() + jC);
        }
        cVar.f(0L);
        map.put("full_time", String.valueOf(j11 - downloadBean.getCreateAt()));
        map.put("real_time", String.valueOf(downloadBean.getSessionTime()));
    }

    public final void d(c cVar, HashMap<String, String> map) {
        map.put("fail_times", String.valueOf(cVar.a()));
        map.put("pause_times", String.valueOf(cVar.b()));
    }

    public final ILoginApi e() {
        return (ILoginApi) this.f61115b.getValue();
    }

    public final Object f(DownloadBean downloadBean, Config config, Continuation<? super Unit> continuation) {
        boolean z11;
        int i11;
        String resourceId = downloadBean.getResourceId();
        int status = downloadBean.getStatus();
        String taskId = downloadBean.getTaskId();
        if (com.transsion.baseui.util.c.f51452a.a((taskId + status).hashCode(), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS)) {
            return Unit.f68710a;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        c cVar = this.f61114a.get(taskId);
        if (cVar == null) {
            cVar = new c(downloadBean.getUrl(), taskId, status);
            this.f61114a.put(taskId, cVar);
        }
        c cVar2 = cVar;
        HashMap<String, String> map = new HashMap<>();
        if (status == 1) {
            z11 = true;
            i11 = 2;
            if (downloadBean.getReportStatus() >= 1) {
                return Unit.f68710a;
            }
            downloadBean.setReportStatus(1);
        } else if (status == 2) {
            z11 = true;
            i11 = 2;
            long jC = jElapsedRealtime - cVar2.c();
            if (cVar2.c() > 0 && jC > 0 && jC < TimeUnit.MINUTES.toMillis(2L)) {
                downloadBean.setSessionTime(downloadBean.getSessionTime() + jC);
            }
            cVar2.f(jElapsedRealtime);
            if (downloadBean.getReportStatus() >= 2) {
                return Unit.f68710a;
            }
            downloadBean.setReportStatus(2);
        } else if (status == 4) {
            z11 = true;
            i11 = 2;
            downloadBean.setReportStatus(4);
            cVar2.e(cVar2.b() + 1);
            cVar2.f(0L);
            d(cVar2, map);
        } else if (status != 5) {
            if (status == 6) {
                i11 = 2;
                cVar2.d(cVar2.a() + 1);
                cVar2.f(0L);
                downloadBean.setReportStatus(6);
                d(cVar2, map);
            } else if (status != 7) {
                z11 = true;
                i11 = 2;
            } else {
                if (downloadBean.getReportStatus() == 5) {
                    status = 57;
                }
                i11 = 2;
                c(cVar2, downloadBean, jElapsedRealtime, map);
            }
            z11 = true;
        } else {
            i11 = 2;
            z11 = true;
            c(cVar2, downloadBean, jElapsedRealtime, map);
            this.f61114a.remove(taskId);
        }
        map.put("url", downloadBean.getUrl());
        map.put("resource_id", resourceId);
        map.put("subject_id", downloadBean.getSubjectId());
        map.put("post_id", downloadBean.getPostId());
        map.put("media_type", String.valueOf(downloadBean.getType()));
        map.put(NotificationCompat.CATEGORY_STATUS, String.valueOf(status));
        map.put("size", String.valueOf(downloadBean.getSize()));
        map.put(NotificationCompat.CATEGORY_PROGRESS, String.valueOf(downloadBean.getProgress()));
        map.put(WebConstants.PAGE_FROM, downloadBean.getLastPageFrom());
        map.put("task_id", downloadBean.getTaskId());
        map.put("url_create_at", String.valueOf(downloadBean.getUrlCreateAt() == 0 ? downloadBean.getCreateAt() : downloadBean.getUrlCreateAt()));
        map.put("ops", downloadBean.getOps());
        map.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, downloadBean.getPath());
        if (downloadBean.getEp() > 0) {
            map.put("ep", String.valueOf(downloadBean.getEp()));
        }
        if (downloadBean.getSe() > 0) {
            map.put("se", String.valueOf(downloadBean.getSe()));
        }
        if (status == 7 || status == 57) {
            map.put("pre_status", String.valueOf(downloadBean.getPreStatus()));
        }
        if (status == 6) {
            DownloadException exception = downloadBean.getException();
            map.put(TrackingKey.ERROR_CODE, String.valueOf(exception != null ? Boxing.d(exception.getCode()) : null));
            DownloadException exception2 = downloadBean.getException();
            map.put("error_response_code", String.valueOf(exception2 != null ? Boxing.d(exception2.getResponseCode()) : null));
            DownloadException exception3 = downloadBean.getException();
            map.put("error_msg", exception3 != null ? exception3.getMessage() : null);
            DownloadException exception4 = downloadBean.getException();
            map.put("error_format_msg", exception4 != null ? exception4.getFormatMessage() : null);
            DownloadException exception5 = downloadBean.getException();
            map.put("download_range", exception5 != null ? exception5.getRange() : null);
            try {
                Result.Companion companion = Result.Companion;
                if (downloadBean.is4xxError() && downloadBean.getUrl() != null) {
                    if (l.L(downloadBean.getUrl(), HttpHost.DEFAULT_SCHEME_NAME, false, i11, null)) {
                        InetAddress[] ips = InetAddress.getAllByName(new URL(downloadBean.getUrl()).getHost());
                        StringBuilder sb2 = new StringBuilder("");
                        Intrinsics.f(ips, "ips");
                        for (InetAddress inetAddress : ips) {
                            if (sb2.length() > 0) {
                                sb2.append(",");
                            }
                            sb2.append(inetAddress);
                        }
                        map.put("download_ips", sb2.toString());
                    }
                }
                Result.m163constructorimpl(Unit.f68710a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m163constructorimpl(ResultKt.a(th2));
            }
        }
        m mVar = m.f51277a;
        String pageFrom = downloadBean.getPageFrom();
        if (pageFrom == null) {
            pageFrom = "download_link";
        }
        mVar.m(pageFrom, DownloadBaseRunnable.TAG, map);
        if (5 <= status && status < 58) {
            uo.b.f78622a.c(DownloadBaseRunnable.TAG, mVar.l(map), z11);
        }
        return Unit.f68710a;
    }

    public final void g(final DownloadBean bean, final Function0<Unit> function0) {
        Intrinsics.g(bean, "bean");
        if (function0 != null) {
            i(new Function1<String, Unit>() { // from class: com.transsnet.downloader.report.DownloadReporter$reportReDownload$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String str) {
                    this.this$0.h(bean, str);
                    function0.invoke();
                }
            });
        } else {
            h(bean, null);
        }
    }

    public final void h(DownloadBean downloadBean, String str) {
        String username;
        String userId;
        HashMap map = new HashMap();
        UserInfo userInfoP = e().P();
        map.put("opt_type", "re_download");
        map.put("url", downloadBean.getUrl());
        String resourceId = downloadBean.getResourceId();
        if (resourceId == null) {
            resourceId = "";
        }
        map.put("resource_id", resourceId);
        String subjectId = downloadBean.getSubjectId();
        if (subjectId == null) {
            subjectId = "";
        }
        map.put("subject_id", subjectId);
        String postId = downloadBean.getPostId();
        if (postId == null) {
            postId = "";
        }
        map.put("post_id", postId);
        map.put("media_type", String.valueOf(downloadBean.getType()));
        map.put(NotificationCompat.CATEGORY_STATUS, downloadBean.toString());
        map.put("size", String.valueOf(downloadBean.getSize()));
        map.put(NotificationCompat.CATEGORY_PROGRESS, String.valueOf(downloadBean.getProgress()));
        String lastPageFrom = downloadBean.getLastPageFrom();
        if (lastPageFrom == null) {
            lastPageFrom = "";
        }
        map.put(WebConstants.PAGE_FROM, lastPageFrom);
        String taskId = downloadBean.getTaskId();
        if (taskId == null) {
            taskId = "";
        }
        map.put("task_id", taskId);
        map.put("url_create_at", String.valueOf(downloadBean.getUrlCreateAt() == 0 ? downloadBean.getCreateAt() : downloadBean.getUrlCreateAt()));
        String ops = downloadBean.getOps();
        if (ops == null) {
            ops = "";
        }
        map.put("ops", ops);
        String path = downloadBean.getPath();
        if (path == null) {
            path = "";
        }
        map.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, path);
        if (userInfoP == null || (username = userInfoP.getUsername()) == null) {
            username = "";
        }
        map.put("user_name", username);
        if (userInfoP == null || (userId = userInfoP.getUserId()) == null) {
            userId = "";
        }
        map.put("user_id", userId);
        if (str == null) {
            str = "";
        }
        map.put("log_url", str);
        m mVar = m.f51277a;
        String pageFrom = downloadBean.getPageFrom();
        if (pageFrom == null) {
            pageFrom = "download_link";
        }
        mVar.m(pageFrom, "app_perf", map);
    }

    public final void i(Function1<? super String, Unit> function1) throws Throwable {
        UploadLoggerManager.f59261a.l(new b(function1));
    }
}
