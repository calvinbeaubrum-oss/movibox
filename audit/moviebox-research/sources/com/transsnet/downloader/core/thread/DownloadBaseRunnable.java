package com.transsnet.downloader.core.thread;

import android.util.Log;
import com.tn.lib.util.networkinfo.f;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.DownloadException;
import com.transsion.baselib.db.download.DownloadRange;
import com.transsnet.downloader.config.Config;
import com.transsnet.downloader.exception.DownloadPauseException;
import com.transsnet.downloader.report.DownloadReporter;
import com.transsnet.downloader.util.DownloadUtil;
import java.util.Locale;
import java.util.Random;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;

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
public abstract class DownloadBaseRunnable implements c {
    public static final a Companion = new a(null);
    public static final int SPEED_THRESHOLD = 51200;
    public static final String TAG = "download";
    private Function0<Unit> breakCallback;
    private final Config config;
    private final DownloadBean downloadInfo;
    private final com.transsnet.downloader.core.thread.a downloadProgressListener;
    private final DownloadRange downloadRange;
    private final com.transsnet.downloader.core.a downloadResponse;
    private boolean isBreak;
    private final com.transsnet.downloader.proxy.a proxyHelper;
    private int retryDownloadCount;
    private final int threadIndex;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public DownloadBaseRunnable(DownloadRange downloadRange, com.transsnet.downloader.proxy.a proxyHelper, int i11, com.transsnet.downloader.core.a downloadResponse, Config config, DownloadBean downloadInfo, com.transsnet.downloader.core.thread.a downloadProgressListener) {
        Intrinsics.g(downloadRange, "downloadRange");
        Intrinsics.g(proxyHelper, "proxyHelper");
        Intrinsics.g(downloadResponse, "downloadResponse");
        Intrinsics.g(config, "config");
        Intrinsics.g(downloadInfo, "downloadInfo");
        Intrinsics.g(downloadProgressListener, "downloadProgressListener");
        this.downloadRange = downloadRange;
        this.proxyHelper = proxyHelper;
        this.threadIndex = i11;
        this.downloadResponse = downloadResponse;
        this.config = config;
        this.downloadInfo = downloadInfo;
        this.downloadProgressListener = downloadProgressListener;
    }

    private final void checkFileIsNeedReDownload() {
        if (DownloadUtil.f61136a.c(this.downloadInfo)) {
            int iD = this.config.d();
            if (iD <= 0) {
                DownloadReporter.f61112c.a().g(this.downloadInfo, null);
                handleReDownload();
            } else if (new Random().nextInt(iD) + 1 == 1) {
                DownloadReporter.f61112c.a().g(this.downloadInfo, new Function0<Unit>() { // from class: com.transsnet.downloader.core.thread.DownloadBaseRunnable.checkFileIsNeedReDownload.1
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
                        DownloadBaseRunnable.this.handleReDownload();
                    }
                });
            } else {
                DownloadReporter.f61112c.a().g(this.downloadInfo, null);
                handleReDownload();
            }
        }
    }

    private final void checkPause() {
        if (this.downloadInfo.isPause()) {
            throw new DownloadPauseException(7);
        }
    }

    private final void checkRangeEnd() {
        Long size = this.downloadInfo.getSize();
        long jLongValue = size != null ? size.longValue() : 0L;
        if (this.downloadRange.getEnd() >= jLongValue) {
            this.downloadRange.setEnd(jLongValue - 1);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 5 */
    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 63521. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    private final void executeDownloadOkHttp() {
        /*
            Method dump skipped, instruction units count: 6352
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.core.thread.DownloadBaseRunnable.executeDownloadOkHttp():void");
    }

    /* JADX WARN: Code duplicated, block: B:19:0x004a  */
    private final DownloadException handleException(Exception exc, int i11, int i12, Integer num, String str, String str2) {
        String str3;
        int iB = DownloadException.Companion.b(exc, i11);
        String message = exc.getMessage();
        if (message != null) {
            str = message;
        }
        if (i11 == 5 && !f.f49475a.e()) {
            iB = 9;
            str = DownloadException.EXCEPTION_MESSAGE_NO_NET;
        }
        if (i11 == 5) {
            Locale locale = Locale.ROOT;
            String lowerCase = str.toLowerCase(locale);
            Intrinsics.f(lowerCase, "toLowerCase(...)");
            if (StringsKt__StringsKt.Q(lowerCase, "ssl", false, 2, null)) {
                str3 = DownloadException.EXCEPTION_MESSAGE_SSL;
            } else {
                String lowerCase2 = str.toLowerCase(locale);
                Intrinsics.f(lowerCase2, "toLowerCase(...)");
                if (StringsKt__StringsKt.Q(lowerCase2, "failed to connect to", false, 2, null)) {
                    str3 = DownloadException.EXCEPTION_MESSAGE_FAILED_CONNECT;
                } else {
                    str3 = str;
                }
            }
        } else {
            str3 = str;
        }
        DownloadException downloadException = new DownloadException(iB, str, exc);
        if (num != null) {
            try {
                i12 = num.intValue();
            } catch (Throwable unused) {
            }
        } else {
            i12 = 0;
        }
        downloadException.setResponseCode(i12);
        downloadException.setFormatMessage(str3);
        downloadException.setRange(str2);
        return downloadException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleReDownload() {
        this.downloadInfo.setProgress(0L);
        for (DownloadRange downloadRange : this.downloadInfo.getDownloadRanges()) {
            downloadRange.setProgress(0L);
            if (downloadRange.getRangeId() != this.downloadRange.getRangeId() && downloadRange.isDownloading()) {
                downloadRange.setReDownload(true);
            }
        }
        throw new ReDownloadException();
    }

    @Override // com.transsnet.downloader.core.thread.c
    public void pause(Function0<Unit> callback) {
        Intrinsics.g(callback, "callback");
        uo.b.a.f(uo.b.f78622a, TAG, "range break current download, start new thread", false, 4, null);
        this.isBreak = true;
        this.breakCallback = callback;
    }

    @Override // com.transsnet.downloader.core.thread.c
    public void removeBreakCallback() {
        this.breakCallback = null;
    }

    public void startDownload() {
        uo.b.f78622a.c(TAG, "start thread: threadId = " + this.downloadRange.getThreadId() + ", rangeId = " + this.downloadRange.getRangeId() + ", isPause =  " + this.downloadInfo.isPause() + "   name =  " + this.downloadInfo.getName() + " , progress = " + this.downloadInfo.getProgress() + ", range.start = " + this.downloadRange.getStart() + ", range.progress = " + this.downloadRange.getProgress() + ",range.end = " + this.downloadRange.getEnd() + ", isBreak = " + this.isBreak + ", status = " + this.downloadInfo.getStatus(), true);
        this.downloadRange.setThreadIndex(this.threadIndex);
        this.isBreak = false;
        while (!this.downloadInfo.isPause() && !this.downloadRange.isRangeDownloadSuccess() && !this.isBreak) {
            try {
                checkPause();
                executeDownloadOkHttp();
            } catch (DownloadPathException e11) {
                this.downloadRange.setDownloading(false);
                this.downloadResponse.b(this.downloadInfo, e11);
            } catch (DownloadException e12) {
                if (this.retryDownloadCount >= this.config.f()) {
                    this.downloadRange.setDownloading(false);
                    this.downloadResponse.b(this.downloadInfo, e12);
                    uo.b.f78622a.h(TAG, "失败重试已满 retry thread: name = " + this.downloadInfo.getName() + ", isPause =  " + this.downloadInfo.isPause() + ", isRangeDownloadSuccess=  " + this.downloadRange.isRangeDownloadSuccess() + ", isBreak = " + this.isBreak + ", progress:  " + this.downloadInfo.getProgress() + " ,rangeId = " + this.downloadRange.getRangeId() + "  ", true);
                    return;
                }
                this.retryDownloadCount++;
            } catch (QuitDPRestartException unused) {
                this.downloadRange.setDownloading(false);
                this.downloadProgressListener.c(this, this.threadIndex, this.downloadRange);
                return;
            } catch (ReDownloadException unused2) {
                this.downloadProgressListener.a(this, this.threadIndex, this.downloadRange);
                return;
            } catch (RestartException unused3) {
                Log.e(TAG, "restart download thread, rangeId = " + this.downloadRange.getRangeId());
            } catch (DownloadPauseException unused4) {
                this.downloadRange.setDownloading(false);
            }
        }
    }
}
