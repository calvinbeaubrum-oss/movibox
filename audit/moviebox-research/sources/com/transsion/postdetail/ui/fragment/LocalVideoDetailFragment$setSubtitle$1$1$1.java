package com.transsion.postdetail.ui.fragment;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.subtitle.VideoSubtitleControl;
import com.transsion.subtitle.VideoSubtitleManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment$setSubtitle$1$1$1", f = "LocalVideoDetailFragment.kt", l = {}, m = "invokeSuspend")
public final class LocalVideoDetailFragment$setSubtitle$1$1$1 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ DownloadBean $dBean;
    final /* synthetic */ List<vx.a> $subtitleList;
    int label;
    final /* synthetic */ LocalVideoDetailFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalVideoDetailFragment$setSubtitle$1$1$1(List<vx.a> list, LocalVideoDetailFragment localVideoDetailFragment, DownloadBean downloadBean, Continuation<? super LocalVideoDetailFragment$setSubtitle$1$1$1> continuation) {
        super(2, continuation);
        this.$subtitleList = list;
        this.this$0 = localVideoDetailFragment;
        this.$dBean = downloadBean;
    }

    public static final void g(LocalVideoDetailFragment localVideoDetailFragment) {
        localVideoDetailFragment.O2();
    }

    public static final void h(LocalVideoDetailFragment localVideoDetailFragment) {
        localVideoDetailFragment.O2();
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocalVideoDetailFragment$setSubtitle$1$1$1(this.$subtitleList, this.this$0, this.$dBean, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
        return ((LocalVideoDetailFragment$setSubtitle$1$1$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ConstraintLayout root;
        tv.j mViewBinding;
        ConstraintLayout root2;
        com.transsion.postdetail.layer.local.o oVar;
        kotlin.coroutines.intrinsics.a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        List<vx.a> list = this.$subtitleList;
        if (list != null && (oVar = this.this$0.f55679n) != null) {
            oVar.q(list);
        }
        VideoSubtitleControl videoSubtitleControl = this.this$0.X;
        if (videoSubtitleControl != null) {
            videoSubtitleControl.e0(this.$subtitleList);
        }
        if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
            DownloadBean downloadBean = this.this$0.B;
            if (downloadBean == null || !downloadBean.isInnerRes()) {
                List<vx.a> list2 = this.$subtitleList;
                if ((list2 == null || list2.isEmpty()) && (mViewBinding = this.this$0.getMViewBinding()) != null && (root2 = mViewBinding.getRoot()) != null) {
                    final LocalVideoDetailFragment localVideoDetailFragment = this.this$0;
                    Boxing.a(root2.post(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.q
                        @Override // java.lang.Runnable
                        public final void run() {
                            LocalVideoDetailFragment$setSubtitle$1$1$1.g(localVideoDetailFragment);
                        }
                    }));
                }
            } else {
                DownloadBean downloadBean2 = this.this$0.B;
                if (downloadBean2 != null) {
                    DownloadBean downloadBean3 = this.$dBean;
                    List<vx.a> list3 = this.$subtitleList;
                    LocalVideoDetailFragment localVideoDetailFragment2 = this.this$0;
                    uo.b.f78622a.c(com.transsion.baselib.report.a.f51248a.a(), "视频播放开始检测字幕,name:" + downloadBean3.getTotalTitleName() + ", subtitleResId:" + downloadBean3.getSubtitleResId(), true);
                    VideoSubtitleManager.f58109a.a().d(downloadBean2, new LocalVideoDetailFragment$setSubtitle$1$1$1$3$1(list3, localVideoDetailFragment2));
                }
            }
        } else {
            List<vx.a> list4 = this.$subtitleList;
            if (list4 == null || list4.isEmpty()) {
                uo.b.f78622a.c(com.transsion.baselib.report.a.f51248a.a(), "展示无字幕ui,name:" + this.$dBean.getTotalTitleName() + ", subtitleResId:" + this.$dBean.getSubtitleResId(), true);
                tv.j mViewBinding2 = this.this$0.getMViewBinding();
                if (mViewBinding2 != null && (root = mViewBinding2.getRoot()) != null) {
                    final LocalVideoDetailFragment localVideoDetailFragment3 = this.this$0;
                    Boxing.a(root.post(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.r
                        @Override // java.lang.Runnable
                        public final void run() {
                            LocalVideoDetailFragment$setSubtitle$1$1$1.h(localVideoDetailFragment3);
                        }
                    }));
                }
            }
        }
        return Unit.f68710a;
    }
}
