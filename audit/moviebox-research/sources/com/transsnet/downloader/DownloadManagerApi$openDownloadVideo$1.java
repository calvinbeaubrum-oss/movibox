package com.transsnet.downloader;

import androidx.fragment.app.FragmentActivity;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsnet.downloader.manager.DownloadEsHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

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
@DebugMetadata(c = "com.transsnet.downloader.DownloadManagerApi$openDownloadVideo$1", f = "DownloadManagerApi.kt", l = {718}, m = "invokeSuspend")
public final class DownloadManagerApi$openDownloadVideo$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ String $pageFrom;
    final /* synthetic */ String $resourceId;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadManagerApi$openDownloadVideo$1(String str, String str2, FragmentActivity fragmentActivity, Continuation<? super DownloadManagerApi$openDownloadVideo$1> continuation) {
        super(2, continuation);
        this.$resourceId = str;
        this.$pageFrom = str2;
        this.$activity = fragmentActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadManagerApi$openDownloadVideo$1(this.$resourceId, this.$pageFrom, this.$activity, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((DownloadManagerApi$openDownloadVideo$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            DownloadEsHelper downloadEsHelperA = DownloadEsHelper.f60994m.a();
            String str = this.$resourceId;
            this.label = 1;
            obj = downloadEsHelperA.k(str, this);
            if (obj == objE) {
                return objE;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        DownloadBean downloadBean = (DownloadBean) obj;
        if (downloadBean == null) {
            return Unit.f68710a;
        }
        if (downloadBean.isOutside()) {
            com.alibaba.android.arouter.launcher.a.d().b("/video/detail").withString("extra_local_path", downloadBean.getPath()).withString("extra_url", downloadBean.getUrl()).withString("extra_resource_id", downloadBean.getResourceId()).withString("extra_name", downloadBean.getName()).withString("extra_page_from", this.$pageFrom).withInt("extra_height", downloadBean.getVideoHeight()).withInt("extra_width", downloadBean.getVideoWidth()).navigation(this.$activity);
            return Unit.f68710a;
        }
        com.transsnet.downloader.manager.a aVarA = com.transsnet.downloader.manager.b.f61062a.a(Utils.a());
        if (downloadBean.getStatus() != 5) {
            aVarA.j(downloadBean);
        }
        com.alibaba.android.arouter.launcher.a.d().b("/video/detail").withString("extra_local_path", downloadBean.getPath()).withString("extra_url", downloadBean.getUrl()).withString("extra_proxy_url", downloadBean.getStatus() == 5 ? "" : aVarA.h(downloadBean)).withString("extra_resource_id", downloadBean.getResourceId()).withString("extra_subject_id", downloadBean.getSubjectId()).withString("extra_name", downloadBean.getName()).withString("extra_post_id", downloadBean.getPostId()).withBoolean("extra_completed", downloadBean.getStatus() == 5).withBoolean("extra_is_series", downloadBean.isSeries()).withString("extra_page_from", this.$pageFrom).withInt("extra_height", downloadBean.getVideoHeight()).withInt("extra_width", downloadBean.getVideoWidth()).navigation(this.$activity);
        return Unit.f68710a;
    }
}
