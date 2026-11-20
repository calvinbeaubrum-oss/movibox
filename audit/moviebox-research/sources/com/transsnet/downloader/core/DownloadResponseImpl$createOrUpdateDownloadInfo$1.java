package com.transsnet.downloader.core;

import com.blankj.utilcode.util.f0;
import com.tn.lib.util.networkinfo.f;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.DownloadRange;
import com.transsion.baseui.image.ImageHelper;
import com.transsnet.downloader.manager.DownloadEsHelper;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.k0;
import tr.h;
import uo.b;

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
@DebugMetadata(c = "com.transsnet.downloader.core.DownloadResponseImpl$createOrUpdateDownloadInfo$1", f = "DownloadResponseImpl.kt", l = {183, 184, 190, 198, 209}, m = "invokeSuspend")
@SourceDebugExtension
public final class DownloadResponseImpl$createOrUpdateDownloadInfo$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ DownloadBean $downloadInfo;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DownloadResponseImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadResponseImpl$createOrUpdateDownloadInfo$1(DownloadBean downloadBean, DownloadResponseImpl downloadResponseImpl, Continuation<? super DownloadResponseImpl$createOrUpdateDownloadInfo$1> continuation) {
        super(2, continuation);
        this.$downloadInfo = downloadBean;
        this.this$0 = downloadResponseImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadResponseImpl$createOrUpdateDownloadInfo$1(this.$downloadInfo, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((DownloadResponseImpl$createOrUpdateDownloadInfo$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:45:0x010f A[Catch: all -> 0x0126, TRY_LEAVE, TryCatch #0 {all -> 0x0126, blocks: (B:43:0x0109, B:45:0x010f), top: B:67:0x0109 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x0140  */
    /* JADX WARN: Code duplicated, block: B:53:0x0149  */
    /* JADX WARN: Code duplicated, block: B:55:0x0157  */
    /* JADX WARN: Code duplicated, block: B:58:0x0169 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:61:0x0172  */
    /* JADX WARN: Code duplicated, block: B:64:0x01a5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:72:0x0125 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:? A[LOOP:0: B:67:0x0109->B:73:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:40:0x00d5, please report this as an issue */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        DownloadResponseImpl$createOrUpdateDownloadInfo$1 downloadResponseImpl$createOrUpdateDownloadInfo$1;
        h hVarH;
        String resourceId;
        DownloadResponseImpl downloadResponseImpl;
        DownloadBean downloadBean;
        String cover;
        DownloadResponseImpl downloadResponseImpl2;
        Iterator it;
        DownloadRange downloadRange;
        h hVarH2;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        try {
            if (i11 != 0) {
                if (i11 == 1) {
                    ResultKt.b(obj);
                } else if (i11 == 2) {
                    ResultKt.b(obj);
                    if (!this.$downloadInfo.getDownloadRanges().isEmpty()) {
                        b.a.f(b.f78622a, "DownloadImp-ResponseImpl", "Response, insert ranges, size = " + this.$downloadInfo.getDownloadRanges().size(), false, 4, null);
                        List<DownloadRange> downloadRanges = this.$downloadInfo.getDownloadRanges();
                        downloadResponseImpl2 = this.this$0;
                        it = downloadRanges.iterator();
                        downloadResponseImpl$createOrUpdateDownloadInfo$1 = this;
                        while (it.hasNext()) {
                            downloadRange = (DownloadRange) it.next();
                            hVarH2 = downloadResponseImpl2.h();
                            downloadResponseImpl$createOrUpdateDownloadInfo$1.L$0 = downloadResponseImpl2;
                            downloadResponseImpl$createOrUpdateDownloadInfo$1.L$1 = it;
                            downloadResponseImpl$createOrUpdateDownloadInfo$1.label = 3;
                            if (hVarH2.c(downloadRange, downloadResponseImpl$createOrUpdateDownloadInfo$1) == objE) {
                                return objE;
                            }
                        }
                    } else {
                        downloadResponseImpl$createOrUpdateDownloadInfo$1 = this;
                    }
                    if (downloadResponseImpl$createOrUpdateDownloadInfo$1.$downloadInfo.isCompleted()) {
                        hVarH = downloadResponseImpl$createOrUpdateDownloadInfo$1.this$0.h();
                        resourceId = downloadResponseImpl$createOrUpdateDownloadInfo$1.$downloadInfo.getResourceId();
                        if (resourceId == null) {
                            resourceId = downloadResponseImpl$createOrUpdateDownloadInfo$1.$downloadInfo.getUrl();
                        }
                        downloadResponseImpl$createOrUpdateDownloadInfo$1.L$0 = null;
                        downloadResponseImpl$createOrUpdateDownloadInfo$1.L$1 = null;
                        downloadResponseImpl$createOrUpdateDownloadInfo$1.label = 4;
                        if (hVarH.b(resourceId, downloadResponseImpl$createOrUpdateDownloadInfo$1) == objE) {
                            return objE;
                        }
                        cover = downloadResponseImpl$createOrUpdateDownloadInfo$1.$downloadInfo.getCover();
                        if (cover != null) {
                            int iA = f0.a(120.0f);
                            ImageHelper.Companion companion = ImageHelper.f51371a;
                            ImageHelper.Companion.x(companion, companion.e(cover, (124 & 2) != 0 ? 0 : iA, (124 & 4) != 0 ? 0 : iA, (124 & 8) != 0, (124 & 16) != 0 ? false : true, (124 & 32) == 0 ? false : false, (124 & 64) != 0 ? 25 : 0), cover, iA, null, 8, null);
                        }
                    }
                    downloadResponseImpl = downloadResponseImpl$createOrUpdateDownloadInfo$1.this$0;
                    downloadBean = downloadResponseImpl$createOrUpdateDownloadInfo$1.$downloadInfo;
                    downloadResponseImpl$createOrUpdateDownloadInfo$1.L$0 = null;
                    downloadResponseImpl$createOrUpdateDownloadInfo$1.L$1 = null;
                    downloadResponseImpl$createOrUpdateDownloadInfo$1.label = 5;
                    if (downloadResponseImpl.k(downloadBean, downloadResponseImpl$createOrUpdateDownloadInfo$1) == objE) {
                        return objE;
                    }
                } else if (i11 == 3) {
                    it = (Iterator) this.L$1;
                    downloadResponseImpl2 = (DownloadResponseImpl) this.L$0;
                    ResultKt.b(obj);
                    downloadResponseImpl$createOrUpdateDownloadInfo$1 = this;
                    while (it.hasNext()) {
                        try {
                            downloadRange = (DownloadRange) it.next();
                            hVarH2 = downloadResponseImpl2.h();
                            downloadResponseImpl$createOrUpdateDownloadInfo$1.L$0 = downloadResponseImpl2;
                            downloadResponseImpl$createOrUpdateDownloadInfo$1.L$1 = it;
                            downloadResponseImpl$createOrUpdateDownloadInfo$1.label = 3;
                            if (hVarH2.c(downloadRange, downloadResponseImpl$createOrUpdateDownloadInfo$1) == objE) {
                                return objE;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            b.f78622a.c("DownloadImp-ResponseImpl", "createOrUpdateDownloadInfo, insert ranges error:" + th, true);
                        }
                    }
                    if (downloadResponseImpl$createOrUpdateDownloadInfo$1.$downloadInfo.isCompleted()) {
                        hVarH = downloadResponseImpl$createOrUpdateDownloadInfo$1.this$0.h();
                        resourceId = downloadResponseImpl$createOrUpdateDownloadInfo$1.$downloadInfo.getResourceId();
                        if (resourceId == null) {
                            resourceId = downloadResponseImpl$createOrUpdateDownloadInfo$1.$downloadInfo.getUrl();
                        }
                        downloadResponseImpl$createOrUpdateDownloadInfo$1.L$0 = null;
                        downloadResponseImpl$createOrUpdateDownloadInfo$1.L$1 = null;
                        downloadResponseImpl$createOrUpdateDownloadInfo$1.label = 4;
                        if (hVarH.b(resourceId, downloadResponseImpl$createOrUpdateDownloadInfo$1) == objE) {
                            return objE;
                        }
                        cover = downloadResponseImpl$createOrUpdateDownloadInfo$1.$downloadInfo.getCover();
                        if (cover != null) {
                            int iA2 = f0.a(120.0f);
                            ImageHelper.Companion companion2 = ImageHelper.f51371a;
                            ImageHelper.Companion.x(companion2, companion2.e(cover, (124 & 2) != 0 ? 0 : iA2, (124 & 4) != 0 ? 0 : iA2, (124 & 8) != 0, (124 & 16) != 0 ? false : true, (124 & 32) == 0 ? false : false, (124 & 64) != 0 ? 25 : 0), cover, iA2, null, 8, null);
                        }
                    }
                    downloadResponseImpl = downloadResponseImpl$createOrUpdateDownloadInfo$1.this$0;
                    downloadBean = downloadResponseImpl$createOrUpdateDownloadInfo$1.$downloadInfo;
                    downloadResponseImpl$createOrUpdateDownloadInfo$1.L$0 = null;
                    downloadResponseImpl$createOrUpdateDownloadInfo$1.L$1 = null;
                    downloadResponseImpl$createOrUpdateDownloadInfo$1.label = 5;
                    if (downloadResponseImpl.k(downloadBean, downloadResponseImpl$createOrUpdateDownloadInfo$1) == objE) {
                        return objE;
                    }
                } else if (i11 == 4) {
                    ResultKt.b(obj);
                    downloadResponseImpl$createOrUpdateDownloadInfo$1 = this;
                    cover = downloadResponseImpl$createOrUpdateDownloadInfo$1.$downloadInfo.getCover();
                    if (cover != null) {
                        int iA3 = f0.a(120.0f);
                        ImageHelper.Companion companion3 = ImageHelper.f51371a;
                        ImageHelper.Companion.x(companion3, companion3.e(cover, (124 & 2) != 0 ? 0 : iA3, (124 & 4) != 0 ? 0 : iA3, (124 & 8) != 0, (124 & 16) != 0 ? false : true, (124 & 32) == 0 ? false : false, (124 & 64) != 0 ? 25 : 0), cover, iA3, null, 8, null);
                    }
                    downloadResponseImpl = downloadResponseImpl$createOrUpdateDownloadInfo$1.this$0;
                    downloadBean = downloadResponseImpl$createOrUpdateDownloadInfo$1.$downloadInfo;
                    downloadResponseImpl$createOrUpdateDownloadInfo$1.L$0 = null;
                    downloadResponseImpl$createOrUpdateDownloadInfo$1.L$1 = null;
                    downloadResponseImpl$createOrUpdateDownloadInfo$1.label = 5;
                    if (downloadResponseImpl.k(downloadBean, downloadResponseImpl$createOrUpdateDownloadInfo$1) == objE) {
                        return objE;
                    }
                } else {
                    if (i11 != 5) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                return Unit.f68710a;
            }
            ResultKt.b(obj);
            if (this.$downloadInfo.getStatus() == 7) {
                return Unit.f68710a;
            }
            if (this.$downloadInfo.getStatus() == 6 && f.f49475a.e()) {
                DownloadBean downloadBean2 = this.$downloadInfo;
                downloadBean2.setDownloadErrorCount(downloadBean2.getDownloadErrorCount() + 1);
                b.a.f(b.f78622a, "DownloadImp-ResponseImpl", "download error , save error count = " + this.$downloadInfo.getDownloadErrorCount(), false, 4, null);
            }
            DownloadEsHelper downloadEsHelperA = DownloadEsHelper.f60994m.a();
            DownloadBean downloadBean3 = this.$downloadInfo;
            this.label = 1;
            if (downloadEsHelperA.K(downloadBean3, this) == objE) {
                return objE;
            }
            DownloadEsHelper downloadEsHelperA2 = DownloadEsHelper.f60994m.a();
            String resourceId2 = this.$downloadInfo.getResourceId();
            if (resourceId2 == null) {
                resourceId2 = this.$downloadInfo.getUrl();
            }
            int status = this.$downloadInfo.getStatus();
            this.label = 2;
            if (downloadEsHelperA2.T(resourceId2, status, this) == objE) {
                return objE;
            }
            if (!this.$downloadInfo.getDownloadRanges().isEmpty()) {
                b.a.f(b.f78622a, "DownloadImp-ResponseImpl", "Response, insert ranges, size = " + this.$downloadInfo.getDownloadRanges().size(), false, 4, null);
                List<DownloadRange> downloadRanges2 = this.$downloadInfo.getDownloadRanges();
                downloadResponseImpl2 = this.this$0;
                it = downloadRanges2.iterator();
                downloadResponseImpl$createOrUpdateDownloadInfo$1 = this;
                while (it.hasNext()) {
                    downloadRange = (DownloadRange) it.next();
                    hVarH2 = downloadResponseImpl2.h();
                    downloadResponseImpl$createOrUpdateDownloadInfo$1.L$0 = downloadResponseImpl2;
                    downloadResponseImpl$createOrUpdateDownloadInfo$1.L$1 = it;
                    downloadResponseImpl$createOrUpdateDownloadInfo$1.label = 3;
                    if (hVarH2.c(downloadRange, downloadResponseImpl$createOrUpdateDownloadInfo$1) == objE) {
                        return objE;
                    }
                }
            } else {
                downloadResponseImpl$createOrUpdateDownloadInfo$1 = this;
            }
        } catch (Throwable th3) {
            th = th3;
            downloadResponseImpl$createOrUpdateDownloadInfo$1 = this;
        }
        if (downloadResponseImpl$createOrUpdateDownloadInfo$1.$downloadInfo.isCompleted()) {
            hVarH = downloadResponseImpl$createOrUpdateDownloadInfo$1.this$0.h();
            resourceId = downloadResponseImpl$createOrUpdateDownloadInfo$1.$downloadInfo.getResourceId();
            if (resourceId == null) {
                resourceId = downloadResponseImpl$createOrUpdateDownloadInfo$1.$downloadInfo.getUrl();
            }
            downloadResponseImpl$createOrUpdateDownloadInfo$1.L$0 = null;
            downloadResponseImpl$createOrUpdateDownloadInfo$1.L$1 = null;
            downloadResponseImpl$createOrUpdateDownloadInfo$1.label = 4;
            if (hVarH.b(resourceId, downloadResponseImpl$createOrUpdateDownloadInfo$1) == objE) {
                return objE;
            }
            cover = downloadResponseImpl$createOrUpdateDownloadInfo$1.$downloadInfo.getCover();
            if (cover != null) {
                int iA4 = f0.a(120.0f);
                ImageHelper.Companion companion4 = ImageHelper.f51371a;
                ImageHelper.Companion.x(companion4, companion4.e(cover, (124 & 2) != 0 ? 0 : iA4, (124 & 4) != 0 ? 0 : iA4, (124 & 8) != 0, (124 & 16) != 0 ? false : true, (124 & 32) == 0 ? false : false, (124 & 64) != 0 ? 25 : 0), cover, iA4, null, 8, null);
            }
        }
        downloadResponseImpl = downloadResponseImpl$createOrUpdateDownloadInfo$1.this$0;
        downloadBean = downloadResponseImpl$createOrUpdateDownloadInfo$1.$downloadInfo;
        downloadResponseImpl$createOrUpdateDownloadInfo$1.L$0 = null;
        downloadResponseImpl$createOrUpdateDownloadInfo$1.L$1 = null;
        downloadResponseImpl$createOrUpdateDownloadInfo$1.label = 5;
        if (downloadResponseImpl.k(downloadBean, downloadResponseImpl$createOrUpdateDownloadInfo$1) == objE) {
            return objE;
        }
        return Unit.f68710a;
    }
}
