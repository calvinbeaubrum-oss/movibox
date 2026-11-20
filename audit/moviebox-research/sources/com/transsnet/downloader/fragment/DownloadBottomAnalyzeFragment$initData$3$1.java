package com.transsnet.downloader.fragment;

import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsnet.downloader.manager.DownloadEsHelper;
import java.util.HashMap;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

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
@DebugMetadata(c = "com.transsnet.downloader.fragment.DownloadBottomAnalyzeFragment$initData$3$1", f = "DownloadBottomAnalyzeFragment.kt", l = {227}, m = "invokeSuspend")
public final class DownloadBottomAnalyzeFragment$initData$3$1 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Subject $it;
    int label;
    final /* synthetic */ DownloadBottomAnalyzeFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadBottomAnalyzeFragment$initData$3$1(Subject subject, DownloadBottomAnalyzeFragment downloadBottomAnalyzeFragment, Continuation<? super DownloadBottomAnalyzeFragment$initData$3$1> continuation) {
        super(2, continuation);
        this.$it = subject;
        this.this$0 = downloadBottomAnalyzeFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadBottomAnalyzeFragment$initData$3$1(this.$it, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
        return ((DownloadBottomAnalyzeFragment$initData$3$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        String downloadUrl;
        Object objK;
        String resourceLink;
        String resourceId;
        String downloadUrl2;
        HashMap<String, String> mapG;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        String str = "";
        if (i11 == 0) {
            ResultKt.b(obj);
            DownloadEsHelper downloadEsHelperA = DownloadEsHelper.f60994m.a();
            ResourceDetectors resourceDetector = this.$it.getResourceDetector();
            if (resourceDetector == null || (downloadUrl = resourceDetector.getResourceId()) == null) {
                ResourceDetectors resourceDetector2 = this.$it.getResourceDetector();
                downloadUrl = resourceDetector2 != null ? resourceDetector2.getDownloadUrl() : null;
                if (downloadUrl == null) {
                    downloadUrl = "";
                }
            }
            this.label = 1;
            objK = downloadEsHelperA.k(downloadUrl, this);
            if (objK == objE) {
                return objE;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            objK = obj;
        }
        DownloadBean downloadBean = (DownloadBean) objK;
        if (downloadBean != null) {
            uo.b.a.f(uo.b.f78622a, "downloadAna", "single， get download bean from database", false, 4, null);
            this.this$0.f60625o = downloadBean;
        } else {
            DownloadBottomAnalyzeFragment downloadBottomAnalyzeFragment = this.this$0;
            ResourceDetectors resourceDetector3 = this.$it.getResourceDetector();
            String str2 = (resourceDetector3 == null || (downloadUrl2 = resourceDetector3.getDownloadUrl()) == null) ? "" : downloadUrl2;
            ResourceDetectors resourceDetector4 = this.$it.getResourceDetector();
            String str3 = (resourceDetector4 == null || (resourceId = resourceDetector4.getResourceId()) == null) ? "" : resourceId;
            String title = this.$it.getTitle();
            String str4 = title == null ? "" : title;
            Cover cover = this.$it.getCover();
            String url = cover != null ? cover.getUrl() : null;
            ResourceDetectors resourceDetector5 = this.$it.getResourceDetector();
            downloadBottomAnalyzeFragment.f60625o = new DownloadBean(str2, str3, str4, url, resourceDetector5 != null ? resourceDetector5.getTotalSize() : null, null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -32, 1073741823, null);
            DownloadBean downloadBean2 = this.this$0.f60625o;
            if (downloadBean2 != null) {
                ResourceDetectors resourceDetector6 = this.$it.getResourceDetector();
                downloadBean2.setPostId(resourceDetector6 != null ? resourceDetector6.getPostId() : null);
            }
            DownloadBean downloadBean3 = this.this$0.f60625o;
            if (downloadBean3 != null) {
                downloadBean3.setSubjectId(this.$it.getSubjectId());
            }
            DownloadBean downloadBean4 = this.this$0.f60625o;
            if (downloadBean4 != null) {
                downloadBean4.setGroupId(this.this$0.f60618h);
            }
            DownloadBean downloadBean5 = this.this$0.f60625o;
            if (downloadBean5 != null) {
                downloadBean5.setSubjectName(this.$it.getTitle());
            }
            DownloadBean downloadBean6 = this.this$0.f60625o;
            if (downloadBean6 != null) {
                downloadBean6.setType(DownloadBean.Companion.c(this.$it.getSubjectType()));
            }
            DownloadBean downloadBean7 = this.this$0.f60625o;
            if (downloadBean7 != null) {
                ResourceDetectors resourceDetector7 = this.$it.getResourceDetector();
                downloadBean7.setUploadBy(resourceDetector7 != null ? resourceDetector7.getUploadBy() : null);
            }
            DownloadBean downloadBean8 = this.this$0.f60625o;
            if (downloadBean8 != null) {
                ResourceDetectors resourceDetector8 = this.$it.getResourceDetector();
                if (resourceDetector8 != null && (resourceLink = resourceDetector8.getResourceLink()) != null) {
                    str = resourceLink;
                }
                downloadBean8.setSourceUrl(str);
            }
        }
        DownloadBean downloadBean9 = this.this$0.f60625o;
        if (downloadBean9 != null) {
            DownloadBottomAnalyzeFragment downloadBottomAnalyzeFragment2 = this.this$0;
            Subject subject = this.$it;
            uo.b.a.f(uo.b.f78622a, "downloadAna", "single， add download task， " + downloadBean9, false, 4, null);
            downloadBottomAnalyzeFragment2.N0(downloadBean9);
            downloadBean9.setCreateAt(System.currentTimeMillis());
            downloadBean9.setUpdateTimeStamp(Boxing.e(System.currentTimeMillis()));
            downloadBean9.setPageFrom(downloadBottomAnalyzeFragment2.f60615d);
            downloadBean9.setLastPageFrom(downloadBottomAnalyzeFragment2.f60616f);
            downloadBean9.setOps(downloadBottomAnalyzeFragment2.f60622l);
            String string = UUID.randomUUID().toString();
            Intrinsics.f(string, "randomUUID().toString()");
            downloadBean9.setTaskId(string);
            downloadBean9.setDuration(Boxing.e(subject.getResourceAboutDuration()));
            String str5 = downloadBottomAnalyzeFragment2.f60615d;
            String str6 = downloadBottomAnalyzeFragment2.f60616f;
            String subjectId = subject.getSubjectId();
            String postId = downloadBean9.getPostId();
            String str7 = downloadBottomAnalyzeFragment2.f60622l;
            ResourceDetectors resourceDetector9 = subject.getResourceDetector();
            downloadBottomAnalyzeFragment2.F0(str5, str6, subjectId, postId, str7, resourceDetector9 != null ? resourceDetector9.getResourceId() : null, string);
            downloadBottomAnalyzeFragment2.G0().p(downloadBean9);
            downloadBottomAnalyzeFragment2.H0().d(kotlin.collections.g.h(downloadBean9));
        }
        com.transsion.baselib.report.h logViewConfig = this.this$0.getLogViewConfig();
        if (logViewConfig != null && (mapG = logViewConfig.g()) != null) {
            mapG.put("subject_id", this.$it.getSubjectId());
        }
        return Unit.f68710a;
    }
}
