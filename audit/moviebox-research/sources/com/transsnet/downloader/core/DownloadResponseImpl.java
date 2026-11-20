package com.transsnet.downloader.core;

import android.app.Application;
import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.DownloadException;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.mb.config.manager.ConfigManager;
import com.transsnet.downloader.config.Config;
import com.transsnet.downloader.core.thread.DownloadBaseRunnable;
import com.transsnet.downloader.manager.DownloadEsHelper;
import com.transsnet.downloader.notification.DownloadNotificationUtils;
import java.util.Iterator;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.k;
import kotlinx.coroutines.j;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;
import tr.g;
import tr.h;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@SourceDebugExtension
public final class DownloadResponseImpl implements com.transsnet.downloader.core.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f60438j = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<g> f60439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Config f60440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f60441c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f60442d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Handler f60443e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f60444f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.transsnet.downloader.manager.a f60445g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f60446h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public k0 f60447i;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    @SourceDebugExtension
    public static final class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            DownloadBean downloadBean;
            Intrinsics.g(msg, "msg");
            super.handleMessage(msg);
            Object obj = msg.obj;
            if (obj != null) {
                Intrinsics.e(obj, "null cannot be cast to non-null type com.transsion.baselib.db.download.DownloadBean");
                downloadBean = (DownloadBean) obj;
            } else {
                downloadBean = null;
            }
            if (downloadBean == null) {
                return;
            }
            DownloadResponseImpl.this.i(downloadBean, msg.what, msg.arg1 == 1);
        }
    }

    public DownloadResponseImpl(com.transsnet.downloader.manager.a downloadManager, Set<g> downloadListeners, Config config) {
        Intrinsics.g(downloadManager, "downloadManager");
        Intrinsics.g(downloadListeners, "downloadListeners");
        this.f60439a = downloadListeners;
        this.f60440b = config;
        this.f60441c = -1;
        this.f60443e = new b(Looper.getMainLooper());
        this.f60444f = 40;
        this.f60446h = LazyKt__LazyJVMKt.b(new Function0<h>() { // from class: com.transsnet.downloader.core.DownloadResponseImpl$rangeDao$2
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                AppDatabase.v0 v0Var = AppDatabase.f51036p;
                Application applicationA = Utils.a();
                Intrinsics.f(applicationA, "getApp()");
                return v0Var.b(applicationA).F0();
            }
        });
        this.f60447i = l0.a(w0.b());
        this.f60445g = downloadManager;
    }

    @Override // com.transsnet.downloader.core.a
    public void a(DownloadBean downloadBean) {
        int status = downloadBean != null ? downloadBean.getStatus() : -1;
        if (downloadBean != null && (!downloadBean.isDownloading()) && this.f60441c == status && Intrinsics.b(this.f60442d, downloadBean.getResourceId())) {
            uo.b.f78622a.t("DownloadImp-ResponseImpl", "onStatusChanged, intercept status = " + status + " resourceId= " + downloadBean.getResourceId(), true);
            return;
        }
        this.f60441c = status;
        this.f60442d = downloadBean != null ? downloadBean.getResourceId() : null;
        if (downloadBean != null) {
            g(downloadBean);
            if (ThreadUtils.i()) {
                i(downloadBean, downloadBean.getStatus(), downloadBean.isPreDownload());
            } else {
                Message messageObtainMessage = this.f60443e.obtainMessage(downloadBean.getStatus());
                Intrinsics.f(messageObtainMessage, "handler.obtainMessage(downloadInfo.status)");
                messageObtainMessage.obj = downloadBean;
                messageObtainMessage.arg1 = downloadBean.isPreDownload() ? 1 : 0;
                messageObtainMessage.sendToTarget();
            }
        }
        uo.b.a aVar = uo.b.f78622a;
        String str = "onStatusChanged，name = " + (downloadBean != null ? downloadBean.getTotalTitleName() : null) + ",status =" + (downloadBean != null ? Integer.valueOf(downloadBean.getStatus()) : null) + ",  progress:" + (downloadBean != null ? Long.valueOf(downloadBean.getProgress()) : null) + ", size:" + (downloadBean != null ? downloadBean.getSize() : null) + ", " + downloadBean;
        boolean z11 = false;
        if (downloadBean != null && downloadBean.isDownloading()) {
            z11 = true;
        }
        aVar.c("DownloadImp-ResponseImpl", str, !z11);
    }

    @Override // com.transsnet.downloader.core.a
    public void b(DownloadBean downloadBean, DownloadException downloadException) {
        com.transsnet.downloader.manager.a aVar;
        if (downloadBean != null) {
            downloadBean.setStatus(6);
        }
        if (this.f60441c == 6) {
            if (Intrinsics.b(this.f60442d, downloadBean != null ? downloadBean.getResourceId() : null)) {
                uo.b.a.f(uo.b.f78622a, "DownloadImp-ResponseImpl", "handleException, intercept", false, 4, null);
                return;
            }
        }
        this.f60441c = 6;
        this.f60442d = downloadBean != null ? downloadBean.getResourceId() : null;
        if (downloadBean != null) {
            downloadBean.setException(downloadException);
        }
        if (downloadBean != null) {
            g(downloadBean);
            if (ThreadUtils.i()) {
                i(downloadBean, downloadBean.getStatus(), downloadBean.isPreDownload());
            } else {
                Message messageObtainMessage = this.f60443e.obtainMessage(6);
                Intrinsics.f(messageObtainMessage, "handler.obtainMessage(DownloadBean.STATUS_ERROR)");
                messageObtainMessage.obj = downloadBean;
                messageObtainMessage.arg1 = downloadBean.isPreDownload() ? 1 : 0;
                messageObtainMessage.sendToTarget();
            }
        }
        uo.b.f78622a.t(DownloadBaseRunnable.TAG, "handleException: code = " + (downloadException != null ? Integer.valueOf(downloadException.getCode()) : null) + ",responseCode = " + (downloadException != null ? Integer.valueOf(downloadException.getResponseCode()) : null) + ", msg = " + (downloadException != null ? downloadException.getLocalizedMessage() : null), true);
        if (downloadBean == null || (aVar = this.f60445g) == null) {
            return;
        }
        aVar.u(downloadBean);
    }

    public final void g(DownloadBean downloadBean) {
        if (downloadBean.getStatus() == 7) {
            return;
        }
        j.d(this.f60447i, null, null, new DownloadResponseImpl$createOrUpdateDownloadInfo$1(downloadBean, this, null), 3, null);
    }

    public final h h() {
        return (h) this.f60446h.getValue();
    }

    /* JADX WARN: Code duplicated, block: B:58:0x0151  */
    /* JADX WARN: Code duplicated, block: B:60:0x0157  */
    /* JADX WARN: Code duplicated, block: B:64:0x0168 A[LOOP:6: B:62:0x0162->B:64:0x0168, LOOP_END] */
    public final void i(DownloadBean downloadBean, int i11, boolean z11) {
        g downloadListener;
        Iterator<T> it;
        uo.b.a.f(uo.b.f78622a, "DownloadImp-ResponseImpl", "onStatusChanged, handleMessage what = " + i11 + ", status = " + downloadBean.getStatus() + ", name = " + downloadBean.getTotalTitleName() + ", code = " + System.identityHashCode(downloadBean), false, 4, null);
        if (i11 != 57) {
            switch (i11) {
                case 1:
                    g downloadListener2 = downloadBean.getDownloadListener();
                    if (downloadListener2 != null) {
                        downloadListener2.g(downloadBean);
                    }
                    Iterator<T> it2 = this.f60439a.iterator();
                    while (it2.hasNext()) {
                        ((g) it2.next()).g(downloadBean);
                    }
                    j(downloadBean);
                    break;
                case 2:
                    Long size = downloadBean.getSize();
                    long jLongValue = size != null ? size.longValue() : 0L;
                    long progress = downloadBean.getProgress();
                    g downloadListener3 = downloadBean.getDownloadListener();
                    if (downloadListener3 != null) {
                        downloadListener3.c(downloadBean, progress, jLongValue);
                    }
                    Iterator<T> it3 = this.f60439a.iterator();
                    while (it3.hasNext()) {
                        ((g) it3.next()).c(downloadBean, progress, jLongValue);
                    }
                    j(downloadBean);
                    break;
                case 3:
                    g downloadListener4 = downloadBean.getDownloadListener();
                    if (downloadListener4 != null) {
                        downloadListener4.d(downloadBean);
                    }
                    Iterator<T> it4 = this.f60439a.iterator();
                    while (it4.hasNext()) {
                        ((g) it4.next()).d(downloadBean);
                    }
                    j(downloadBean);
                    break;
                case 4:
                    g downloadListener5 = downloadBean.getDownloadListener();
                    if (downloadListener5 != null) {
                        downloadListener5.f(downloadBean);
                    }
                    Iterator<T> it5 = this.f60439a.iterator();
                    while (it5.hasNext()) {
                        ((g) it5.next()).f(downloadBean);
                    }
                    j(downloadBean);
                    break;
                case 5:
                    g downloadListener6 = downloadBean.getDownloadListener();
                    if (downloadListener6 != null) {
                        downloadListener6.e(downloadBean, downloadBean.getName());
                    }
                    Iterator<T> it6 = this.f60439a.iterator();
                    while (it6.hasNext()) {
                        ((g) it6.next()).e(downloadBean, downloadBean.getName());
                    }
                    j(downloadBean);
                    break;
                case 6:
                    g downloadListener7 = downloadBean.getDownloadListener();
                    if (downloadListener7 != null) {
                        downloadListener7.a(downloadBean, downloadBean.getException());
                    }
                    Iterator<T> it7 = this.f60439a.iterator();
                    while (it7.hasNext()) {
                        ((g) it7.next()).a(downloadBean, downloadBean.getException());
                    }
                    j(downloadBean);
                    break;
                case 7:
                    downloadListener = downloadBean.getDownloadListener();
                    if (downloadListener != null) {
                        downloadListener.b(downloadBean);
                    }
                    it = this.f60439a.iterator();
                    while (it.hasNext()) {
                        ((g) it.next()).b(downloadBean);
                    }
                    j(downloadBean);
                    break;
            }
        } else {
            downloadListener = downloadBean.getDownloadListener();
            if (downloadListener != null) {
                downloadListener.b(downloadBean);
            }
            it = this.f60439a.iterator();
            while (it.hasNext()) {
                ((g) it.next()).b(downloadBean);
            }
            j(downloadBean);
        }
        if (z11) {
            return;
        }
        l(downloadBean);
    }

    public final void j(DownloadBean downloadBean) {
        Object value;
        if (downloadBean.isPreDownload()) {
            return;
        }
        if (downloadBean.getStatus() == 6) {
            ConfigBean configBeanB = ConfigManager.f53111c.a().b("download_error_opt_off", true);
            if (configBeanB == null || (value = configBeanB.getValue()) == null) {
                value = 0;
            }
            DownloadException exception = downloadBean.getException();
            if (exception != null && exception.getCode() == downloadBean.getPreErrorCode() && Intrinsics.b(value, 0)) {
                return;
            }
            DownloadException exception2 = downloadBean.getException();
            downloadBean.setPreErrorCode(exception2 != null ? exception2.getCode() : DownloadException.Companion.a());
        }
        j.d(this.f60447i, null, null, new DownloadResponseImpl$report$1(downloadBean, this, null), 3, null);
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:44:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:63:0x0137  */
    /* JADX WARN: Code duplicated, block: B:67:0x0147  */
    /* JADX WARN: Code duplicated, block: B:70:0x015e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code duplicated, block: B:87:0x0196  */
    /* JADX WARN: Code duplicated, block: B:91:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:94:0x01bd A[RETURN] */
    public final Object k(DownloadBean downloadBean, Continuation<? super Unit> continuation) throws Throwable {
        DownloadResponseImpl$tryUpdateVideoInfo$1 downloadResponseImpl$tryUpdateVideoInfo$1;
        Ref.IntRef intRef;
        Ref.IntRef intRef2;
        DownloadBean downloadBean2;
        Ref.IntRef intRef3;
        Ref.IntRef intRef4;
        Ref.IntRef intRef5;
        Ref.IntRef intRef6;
        int iIntValue;
        long jLongValue;
        DownloadEsHelper downloadEsHelperA;
        String resourceId;
        int i11;
        int i12;
        DownloadEsHelper downloadEsHelperA2;
        String resourceId2;
        int i13;
        int i14;
        if (continuation instanceof DownloadResponseImpl$tryUpdateVideoInfo$1) {
            downloadResponseImpl$tryUpdateVideoInfo$1 = (DownloadResponseImpl$tryUpdateVideoInfo$1) continuation;
            int i15 = downloadResponseImpl$tryUpdateVideoInfo$1.label;
            if ((i15 & Integer.MIN_VALUE) != 0) {
                downloadResponseImpl$tryUpdateVideoInfo$1.label = i15 - Integer.MIN_VALUE;
            } else {
                downloadResponseImpl$tryUpdateVideoInfo$1 = new DownloadResponseImpl$tryUpdateVideoInfo$1(this, continuation);
            }
        } else {
            downloadResponseImpl$tryUpdateVideoInfo$1 = new DownloadResponseImpl$tryUpdateVideoInfo$1(this, continuation);
        }
        Object obj = downloadResponseImpl$tryUpdateVideoInfo$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        switch (downloadResponseImpl$tryUpdateVideoInfo$1.label) {
            case 0:
                ResultKt.b(obj);
                if (downloadBean.getStatus() == 5) {
                    Long duration = downloadBean.getDuration();
                    if ((duration != null ? duration.longValue() : 0L) <= 0 || downloadBean.getVideoWidth() <= 0) {
                        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                        Ref.LongRef longRef = new Ref.LongRef();
                        intRef = new Ref.IntRef();
                        intRef2 = new Ref.IntRef();
                        try {
                            try {
                                mediaMetadataRetriever.setDataSource(downloadBean.getPath());
                                try {
                                    String strExtractMetadata = mediaMetadataRetriever.extractMetadata(9);
                                    if (strExtractMetadata != null) {
                                        Intrinsics.f(strExtractMetadata, "extractMetadata(MediaMet…er.METADATA_KEY_DURATION)");
                                        Long lN = k.n(strExtractMetadata);
                                        if (lN != null) {
                                            jLongValue = lN.longValue();
                                        } else {
                                            jLongValue = 0;
                                        }
                                    } else {
                                        jLongValue = 0;
                                    }
                                    longRef.element = jLongValue;
                                    break;
                                } catch (Throwable unused) {
                                }
                                try {
                                    String strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(18);
                                    int iIntValue2 = 0;
                                    if (strExtractMetadata2 != null) {
                                        Intrinsics.f(strExtractMetadata2, "extractMetadata(MediaMet…METADATA_KEY_VIDEO_WIDTH)");
                                        Integer numL = k.l(strExtractMetadata2);
                                        if (numL != null) {
                                            iIntValue = numL.intValue();
                                        } else {
                                            iIntValue = 0;
                                        }
                                    } else {
                                        iIntValue = 0;
                                    }
                                    intRef.element = iIntValue;
                                    String strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(19);
                                    if (strExtractMetadata3 != null) {
                                        Intrinsics.f(strExtractMetadata3, "extractMetadata(MediaMet…ETADATA_KEY_VIDEO_HEIGHT)");
                                        Integer numL2 = k.l(strExtractMetadata3);
                                        if (numL2 != null) {
                                            iIntValue2 = numL2.intValue();
                                        }
                                    }
                                    intRef2.element = iIntValue2;
                                    break;
                                } catch (Throwable unused2) {
                                }
                                mediaMetadataRetriever.release();
                                if (longRef.element > 0) {
                                    DownloadEsHelper downloadEsHelperA3 = DownloadEsHelper.f60994m.a();
                                    String resourceId3 = downloadBean.getResourceId();
                                    if (resourceId3 == null) {
                                        resourceId3 = downloadBean.getUrl();
                                    }
                                    long j11 = longRef.element;
                                    downloadResponseImpl$tryUpdateVideoInfo$1.L$0 = downloadBean;
                                    downloadResponseImpl$tryUpdateVideoInfo$1.L$1 = intRef;
                                    downloadResponseImpl$tryUpdateVideoInfo$1.L$2 = intRef2;
                                    downloadResponseImpl$tryUpdateVideoInfo$1.label = 1;
                                    if (downloadEsHelperA3.Q(resourceId3, j11, downloadResponseImpl$tryUpdateVideoInfo$1) == objE) {
                                        return objE;
                                    }
                                    intRef6 = intRef;
                                    intRef = intRef6;
                                    if (intRef.element > 0 && intRef2.element > 0) {
                                        downloadEsHelperA = DownloadEsHelper.f60994m.a();
                                        resourceId = downloadBean.getResourceId();
                                        if (resourceId == null) {
                                            resourceId = downloadBean.getUrl();
                                        }
                                        i11 = intRef.element;
                                        i12 = intRef2.element;
                                        downloadResponseImpl$tryUpdateVideoInfo$1.L$0 = null;
                                        downloadResponseImpl$tryUpdateVideoInfo$1.L$1 = null;
                                        downloadResponseImpl$tryUpdateVideoInfo$1.L$2 = null;
                                        downloadResponseImpl$tryUpdateVideoInfo$1.label = 2;
                                        if (downloadEsHelperA.W(resourceId, i11, i12, downloadResponseImpl$tryUpdateVideoInfo$1) == objE) {
                                            return objE;
                                        }
                                    }
                                } else if (intRef.element > 0) {
                                    downloadEsHelperA = DownloadEsHelper.f60994m.a();
                                    resourceId = downloadBean.getResourceId();
                                    if (resourceId == null) {
                                        resourceId = downloadBean.getUrl();
                                    }
                                    i11 = intRef.element;
                                    i12 = intRef2.element;
                                    downloadResponseImpl$tryUpdateVideoInfo$1.L$0 = null;
                                    downloadResponseImpl$tryUpdateVideoInfo$1.L$1 = null;
                                    downloadResponseImpl$tryUpdateVideoInfo$1.L$2 = null;
                                    downloadResponseImpl$tryUpdateVideoInfo$1.label = 2;
                                    if (downloadEsHelperA.W(resourceId, i11, i12, downloadResponseImpl$tryUpdateVideoInfo$1) == objE) {
                                        return objE;
                                    }
                                }
                            } catch (Exception e11) {
                                e11.printStackTrace();
                                mediaMetadataRetriever.release();
                                if (longRef.element > 0) {
                                    DownloadEsHelper downloadEsHelperA4 = DownloadEsHelper.f60994m.a();
                                    String resourceId4 = downloadBean.getResourceId();
                                    if (resourceId4 == null) {
                                        resourceId4 = downloadBean.getUrl();
                                    }
                                    long j12 = longRef.element;
                                    downloadResponseImpl$tryUpdateVideoInfo$1.L$0 = downloadBean;
                                    downloadResponseImpl$tryUpdateVideoInfo$1.L$1 = intRef;
                                    downloadResponseImpl$tryUpdateVideoInfo$1.L$2 = intRef2;
                                    downloadResponseImpl$tryUpdateVideoInfo$1.label = 3;
                                    if (downloadEsHelperA4.Q(resourceId4, j12, downloadResponseImpl$tryUpdateVideoInfo$1) == objE) {
                                        return objE;
                                    }
                                    intRef5 = intRef;
                                    intRef = intRef5;
                                    if (intRef.element > 0) {
                                        downloadEsHelperA2 = DownloadEsHelper.f60994m.a();
                                        resourceId2 = downloadBean.getResourceId();
                                        if (resourceId2 == null) {
                                            resourceId2 = downloadBean.getUrl();
                                        }
                                        i13 = intRef.element;
                                        i14 = intRef2.element;
                                        downloadResponseImpl$tryUpdateVideoInfo$1.L$0 = null;
                                        downloadResponseImpl$tryUpdateVideoInfo$1.L$1 = null;
                                        downloadResponseImpl$tryUpdateVideoInfo$1.L$2 = null;
                                        downloadResponseImpl$tryUpdateVideoInfo$1.label = 4;
                                        if (downloadEsHelperA2.W(resourceId2, i13, i14, downloadResponseImpl$tryUpdateVideoInfo$1) == objE) {
                                            return objE;
                                        }
                                    }
                                } else if (intRef.element > 0) {
                                    downloadEsHelperA2 = DownloadEsHelper.f60994m.a();
                                    resourceId2 = downloadBean.getResourceId();
                                    if (resourceId2 == null) {
                                        resourceId2 = downloadBean.getUrl();
                                    }
                                    i13 = intRef.element;
                                    i14 = intRef2.element;
                                    downloadResponseImpl$tryUpdateVideoInfo$1.L$0 = null;
                                    downloadResponseImpl$tryUpdateVideoInfo$1.L$1 = null;
                                    downloadResponseImpl$tryUpdateVideoInfo$1.L$2 = null;
                                    downloadResponseImpl$tryUpdateVideoInfo$1.label = 4;
                                    if (downloadEsHelperA2.W(resourceId2, i13, i14, downloadResponseImpl$tryUpdateVideoInfo$1) == objE) {
                                        return objE;
                                    }
                                }
                                return Unit.f68710a;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            mediaMetadataRetriever.release();
                            if (longRef.element <= 0) {
                                downloadBean2 = downloadBean;
                            } else {
                                DownloadEsHelper downloadEsHelperA5 = DownloadEsHelper.f60994m.a();
                                String resourceId5 = downloadBean.getResourceId();
                                if (resourceId5 == null) {
                                    resourceId5 = downloadBean.getUrl();
                                }
                                long j13 = longRef.element;
                                downloadResponseImpl$tryUpdateVideoInfo$1.L$0 = downloadBean;
                                downloadResponseImpl$tryUpdateVideoInfo$1.L$1 = intRef;
                                downloadResponseImpl$tryUpdateVideoInfo$1.L$2 = intRef2;
                                downloadResponseImpl$tryUpdateVideoInfo$1.L$3 = th;
                                downloadResponseImpl$tryUpdateVideoInfo$1.label = 5;
                                if (downloadEsHelperA5.Q(resourceId5, j13, downloadResponseImpl$tryUpdateVideoInfo$1) == objE) {
                                    return objE;
                                }
                                intRef3 = intRef;
                                intRef4 = intRef2;
                            }
                            break;
                        }
                    }
                }
                return Unit.f68710a;
            case 1:
                Ref.IntRef intRef7 = (Ref.IntRef) downloadResponseImpl$tryUpdateVideoInfo$1.L$2;
                intRef6 = (Ref.IntRef) downloadResponseImpl$tryUpdateVideoInfo$1.L$1;
                DownloadBean downloadBean3 = (DownloadBean) downloadResponseImpl$tryUpdateVideoInfo$1.L$0;
                ResultKt.b(obj);
                intRef2 = intRef7;
                downloadBean = downloadBean3;
                intRef = intRef6;
                if (intRef.element > 0) {
                    downloadEsHelperA = DownloadEsHelper.f60994m.a();
                    resourceId = downloadBean.getResourceId();
                    if (resourceId == null) {
                        resourceId = downloadBean.getUrl();
                    }
                    i11 = intRef.element;
                    i12 = intRef2.element;
                    downloadResponseImpl$tryUpdateVideoInfo$1.L$0 = null;
                    downloadResponseImpl$tryUpdateVideoInfo$1.L$1 = null;
                    downloadResponseImpl$tryUpdateVideoInfo$1.L$2 = null;
                    downloadResponseImpl$tryUpdateVideoInfo$1.label = 2;
                    if (downloadEsHelperA.W(resourceId, i11, i12, downloadResponseImpl$tryUpdateVideoInfo$1) == objE) {
                        return objE;
                    }
                }
                return Unit.f68710a;
            case 2:
            case 4:
                ResultKt.b(obj);
                return Unit.f68710a;
            case 3:
                Ref.IntRef intRef8 = (Ref.IntRef) downloadResponseImpl$tryUpdateVideoInfo$1.L$2;
                intRef5 = (Ref.IntRef) downloadResponseImpl$tryUpdateVideoInfo$1.L$1;
                DownloadBean downloadBean4 = (DownloadBean) downloadResponseImpl$tryUpdateVideoInfo$1.L$0;
                ResultKt.b(obj);
                intRef2 = intRef8;
                downloadBean = downloadBean4;
                intRef = intRef5;
                if (intRef.element > 0 && intRef2.element > 0) {
                    downloadEsHelperA2 = DownloadEsHelper.f60994m.a();
                    resourceId2 = downloadBean.getResourceId();
                    if (resourceId2 == null) {
                        resourceId2 = downloadBean.getUrl();
                    }
                    i13 = intRef.element;
                    i14 = intRef2.element;
                    downloadResponseImpl$tryUpdateVideoInfo$1.L$0 = null;
                    downloadResponseImpl$tryUpdateVideoInfo$1.L$1 = null;
                    downloadResponseImpl$tryUpdateVideoInfo$1.L$2 = null;
                    downloadResponseImpl$tryUpdateVideoInfo$1.label = 4;
                    if (downloadEsHelperA2.W(resourceId2, i13, i14, downloadResponseImpl$tryUpdateVideoInfo$1) == objE) {
                        return objE;
                    }
                }
                return Unit.f68710a;
            case 5:
                Throwable th3 = (Throwable) downloadResponseImpl$tryUpdateVideoInfo$1.L$3;
                intRef4 = (Ref.IntRef) downloadResponseImpl$tryUpdateVideoInfo$1.L$2;
                intRef3 = (Ref.IntRef) downloadResponseImpl$tryUpdateVideoInfo$1.L$1;
                DownloadBean downloadBean5 = (DownloadBean) downloadResponseImpl$tryUpdateVideoInfo$1.L$0;
                ResultKt.b(obj);
                th = th3;
                downloadBean = downloadBean5;
                downloadBean2 = downloadBean;
                intRef2 = intRef4;
                intRef = intRef3;
                Throwable th4 = th;
                if (intRef.element <= 0 || intRef2.element <= 0) {
                    throw th4;
                }
                DownloadEsHelper downloadEsHelperA6 = DownloadEsHelper.f60994m.a();
                String resourceId6 = downloadBean2.getResourceId();
                if (resourceId6 == null) {
                    resourceId6 = downloadBean2.getUrl();
                }
                int i16 = intRef.element;
                int i17 = intRef2.element;
                downloadResponseImpl$tryUpdateVideoInfo$1.L$0 = th4;
                downloadResponseImpl$tryUpdateVideoInfo$1.L$1 = null;
                downloadResponseImpl$tryUpdateVideoInfo$1.L$2 = null;
                downloadResponseImpl$tryUpdateVideoInfo$1.L$3 = null;
                downloadResponseImpl$tryUpdateVideoInfo$1.label = 6;
                if (downloadEsHelperA6.W(resourceId6, i16, i17, downloadResponseImpl$tryUpdateVideoInfo$1) == objE) {
                    return objE;
                }
                throw th4;
            case 6:
                Throwable th5 = (Throwable) downloadResponseImpl$tryUpdateVideoInfo$1.L$0;
                ResultKt.b(obj);
                throw th5;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void l(DownloadBean downloadBean) {
        DownloadNotificationUtils.f61068a.E(downloadBean);
    }
}
