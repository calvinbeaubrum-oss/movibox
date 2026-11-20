package com.transsnet.downloader.fragment;

import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.SubtitleBean;
import com.transsion.moviedetailapi.DownloadItem;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.SubtitleItem;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.bean.DownloadUrlBean;
import com.transsnet.downloader.manager.DownloadEsHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;

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
@DebugMetadata(c = "com.transsnet.downloader.fragment.DownloadBottomAnalyzeFragment$onGetUrlDownloadConfig$2", f = "DownloadBottomAnalyzeFragment.kt", l = {384}, m = "invokeSuspend")
@SourceDebugExtension
public final class DownloadBottomAnalyzeFragment$onGetUrlDownloadConfig$2 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ DownloadItem $item;
    final /* synthetic */ Ref.IntRef $totalEpisode;
    final /* synthetic */ DownloadUrlBean $urlBean;
    int label;
    final /* synthetic */ DownloadBottomAnalyzeFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadBottomAnalyzeFragment$onGetUrlDownloadConfig$2(DownloadItem downloadItem, DownloadBottomAnalyzeFragment downloadBottomAnalyzeFragment, Ref.IntRef intRef, DownloadUrlBean downloadUrlBean, Continuation<? super DownloadBottomAnalyzeFragment$onGetUrlDownloadConfig$2> continuation) {
        super(2, continuation);
        this.$item = downloadItem;
        this.this$0 = downloadBottomAnalyzeFragment;
        this.$totalEpisode = intRef;
        this.$urlBean = downloadUrlBean;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadBottomAnalyzeFragment$onGetUrlDownloadConfig$2(this.$item, this.this$0, this.$totalEpisode, this.$urlBean, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
        return ((DownloadBottomAnalyzeFragment$onGetUrlDownloadConfig$2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        String url;
        Object objK;
        List<SubtitleBean> subtitleList;
        List<SubtitleItem> extSubtitle;
        String name;
        Integer resolution;
        Integer epse;
        String sourceUrl;
        String uploadBy;
        Cover cover;
        String name2;
        String resourceId;
        String url2;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            DownloadEsHelper downloadEsHelperA = DownloadEsHelper.f60994m.a();
            DownloadItem downloadItem = this.$item;
            if (downloadItem == null || (url = downloadItem.getResourceId()) == null) {
                DownloadItem downloadItem2 = this.$item;
                url = downloadItem2 != null ? downloadItem2.getUrl() : null;
                if (url == null) {
                    url = "";
                }
            }
            this.label = 1;
            objK = downloadEsHelperA.k(url, this);
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
        if (((DownloadBean) objK) != null) {
            uo.b.a.f(uo.b.f78622a, "downloadAna", "url start download, is downloading", false, 4, null);
            this.this$0.K0(new Function0<Unit>() { // from class: com.transsnet.downloader.fragment.DownloadBottomAnalyzeFragment$onGetUrlDownloadConfig$2.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    zp.b.f82110a.d(R$string.already_in_downloads);
                }
            });
        } else {
            DownloadBottomAnalyzeFragment downloadBottomAnalyzeFragment = this.this$0;
            DownloadItem downloadItem3 = this.$item;
            String str = (downloadItem3 == null || (url2 = downloadItem3.getUrl()) == null) ? "" : url2;
            DownloadItem downloadItem4 = this.$item;
            String str2 = (downloadItem4 == null || (resourceId = downloadItem4.getResourceId()) == null) ? "" : resourceId;
            DownloadItem downloadItem5 = this.$item;
            String str3 = (downloadItem5 == null || (name2 = downloadItem5.getName()) == null) ? "" : name2;
            Subject subject = this.this$0.f60617g;
            String url3 = (subject == null || (cover = subject.getCover()) == null) ? null : cover.getUrl();
            DownloadItem downloadItem6 = this.$item;
            downloadBottomAnalyzeFragment.f60625o = new DownloadBean(str, str2, str3, url3, downloadItem6 != null ? downloadItem6.getSize() : null, null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -32, 1073741823, null);
            DownloadBean downloadBean = this.this$0.f60625o;
            if (downloadBean != null) {
                DownloadItem downloadItem7 = this.$item;
                if (downloadItem7 == null || (uploadBy = downloadItem7.getUploadBy()) == null) {
                    uploadBy = "";
                }
                downloadBean.setUploadBy(uploadBy);
            }
            DownloadBean downloadBean2 = this.this$0.f60625o;
            if (downloadBean2 != null) {
                DownloadItem downloadItem8 = this.$item;
                if (downloadItem8 == null || (sourceUrl = downloadItem8.getSourceUrl()) == null) {
                    sourceUrl = "";
                }
                downloadBean2.setSourceUrl(sourceUrl);
            }
            DownloadBean downloadBean3 = this.this$0.f60625o;
            if (downloadBean3 != null) {
                DownloadItem downloadItem9 = this.$item;
                downloadBean3.setPostId(downloadItem9 != null ? downloadItem9.getPostId() : null);
            }
            DownloadBean downloadBean4 = this.this$0.f60625o;
            if (downloadBean4 != null) {
                DownloadItem downloadItem10 = this.$item;
                downloadBean4.setEpse((downloadItem10 == null || (epse = downloadItem10.getEpse()) == null) ? 0 : epse.intValue());
            }
            DownloadBean downloadBean5 = this.this$0.f60625o;
            if (downloadBean5 != null) {
                DownloadItem downloadItem11 = this.$item;
                downloadBean5.setEp(downloadItem11 != null ? downloadItem11.getEp() : 0);
            }
            DownloadBean downloadBean6 = this.this$0.f60625o;
            if (downloadBean6 != null) {
                DownloadItem downloadItem12 = this.$item;
                downloadBean6.setSe(downloadItem12 != null ? downloadItem12.getSe() : 0);
            }
            DownloadBean downloadBean7 = this.this$0.f60625o;
            if (downloadBean7 != null) {
                DownloadItem downloadItem13 = this.$item;
                downloadBean7.setResolution((downloadItem13 == null || (resolution = downloadItem13.getResolution()) == null) ? 0 : resolution.intValue());
            }
            DownloadBean downloadBean8 = this.this$0.f60625o;
            if (downloadBean8 != null) {
                Subject subject2 = this.this$0.f60617g;
                downloadBean8.setSubjectId(subject2 != null ? subject2.getSubjectId() : null);
            }
            DownloadBean downloadBean9 = this.this$0.f60625o;
            if (downloadBean9 != null) {
                DownloadBean.a aVar = DownloadBean.Companion;
                Subject subject3 = this.this$0.f60617g;
                downloadBean9.setType(aVar.c(subject3 != null ? subject3.getSubjectType() : null));
            }
            DownloadBean downloadBean10 = this.this$0.f60625o;
            if (downloadBean10 != null) {
                downloadBean10.setTotalEpisode(this.$totalEpisode.element);
            }
            DownloadBean downloadBean11 = this.this$0.f60625o;
            if (downloadBean11 != null) {
                downloadBean11.setCreateAt(System.currentTimeMillis());
            }
            DownloadBean downloadBean12 = this.this$0.f60625o;
            if (downloadBean12 != null) {
                downloadBean12.setUpdateTimeStamp(Boxing.e(System.currentTimeMillis()));
            }
            DownloadBean downloadBean13 = this.this$0.f60625o;
            if (downloadBean13 != null) {
                Subject subject4 = this.this$0.f60617g;
                String title = subject4 != null ? subject4.getTitle() : null;
                if (title == null || title.length() == 0) {
                    name = this.$urlBean.getName();
                } else {
                    Subject subject5 = this.this$0.f60617g;
                    name = subject5 != null ? subject5.getTitle() : null;
                }
                downloadBean13.setSubjectName(name);
            }
            ArrayList arrayList = new ArrayList();
            DownloadItem downloadItem14 = this.$item;
            if (downloadItem14 != null && (extSubtitle = downloadItem14.getExtSubtitle()) != null) {
                DownloadItem downloadItem15 = this.$item;
                for (SubtitleItem subtitleItem : extSubtitle) {
                    SubtitleItem.a aVar2 = SubtitleItem.Companion;
                    String postId = downloadItem15.getPostId();
                    arrayList.add(aVar2.a(subtitleItem, (28 & 2) != 0 ? "" : (postId == null && (postId = downloadItem15.getResourceId()) == null) ? "" : postId, (28 & 4) != 0 ? "" : null, (28 & 8) != 0 ? 0 : 0, (28 & 16) != 0 ? 0 : 0));
                }
            }
            DownloadBean downloadBean14 = this.this$0.f60625o;
            if (downloadBean14 != null && (subtitleList = downloadBean14.getSubtitleList()) != null) {
                Boxing.a(subtitleList.addAll(arrayList));
            }
            DownloadBean downloadBean15 = this.this$0.f60625o;
            if (downloadBean15 != null) {
                downloadBean15.setPageFrom(this.this$0.f60615d);
            }
            DownloadBean downloadBean16 = this.this$0.f60625o;
            if (downloadBean16 != null) {
                downloadBean16.setLastPageFrom(this.this$0.f60616f);
            }
            DownloadBean downloadBean17 = this.this$0.f60625o;
            if (downloadBean17 != null) {
                this.this$0.N0(downloadBean17);
            }
            DownloadBean downloadBean18 = this.this$0.f60625o;
            if (downloadBean18 != null) {
                downloadBean18.setOps(this.this$0.f60622l);
            }
            uo.b.a aVar3 = uo.b.f78622a;
            DownloadItem downloadItem16 = this.$item;
            uo.b.a.f(aVar3, "downloadAna", "url start download, name = " + (downloadItem16 != null ? downloadItem16.getName() : null), false, 4, null);
            String string = UUID.randomUUID().toString();
            Intrinsics.f(string, "randomUUID().toString()");
            DownloadBean downloadBean19 = this.this$0.f60625o;
            if (downloadBean19 != null) {
                downloadBean19.setTaskId(string);
            }
            DownloadBean downloadBean20 = this.this$0.f60625o;
            if (downloadBean20 != null) {
                Subject subject6 = this.this$0.f60617g;
                downloadBean20.setDuration(subject6 != null ? Boxing.e(subject6.getResourceAboutDuration()) : null);
            }
            DownloadBottomAnalyzeFragment downloadBottomAnalyzeFragment2 = this.this$0;
            String str4 = downloadBottomAnalyzeFragment2.f60615d;
            String str5 = this.this$0.f60616f;
            Subject subject7 = this.this$0.f60617g;
            String subjectId = subject7 != null ? subject7.getSubjectId() : null;
            DownloadItem downloadItem17 = this.$item;
            String postId2 = downloadItem17 != null ? downloadItem17.getPostId() : null;
            String str6 = this.this$0.f60622l;
            DownloadItem downloadItem18 = this.$item;
            downloadBottomAnalyzeFragment2.F0(str4, str5, subjectId, postId2, str6, downloadItem18 != null ? downloadItem18.getResourceId() : null, string);
            com.transsnet.downloader.manager.a aVarG0 = this.this$0.G0();
            DownloadBean downloadBean21 = this.this$0.f60625o;
            Intrinsics.d(downloadBean21);
            aVarG0.p(downloadBean21);
            DownloadBean downloadBean22 = this.this$0.f60625o;
            if (downloadBean22 != null) {
                this.this$0.H0().d(kotlin.collections.g.h(downloadBean22));
            }
        }
        return Unit.f68710a;
    }
}
