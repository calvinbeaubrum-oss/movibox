package com.transsion.postdetail.ui.fragment;

import com.transsion.baselib.db.download.DownloadBean;
import com.transsnet.downloader.manager.DownloadEsHelper;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.LocalVideoEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@DebugMetadata(c = "com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment$save$1", f = "LocalVideoDetailFragment.kt", l = {1565, 1566}, m = "invokeSuspend")
@SourceDebugExtension
public final class LocalVideoDetailFragment$save$1 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $completed;
    final /* synthetic */ DownloadBean $cvideoBean;
    final /* synthetic */ long $playProgress;
    long J$0;
    int label;
    final /* synthetic */ LocalVideoDetailFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalVideoDetailFragment$save$1(boolean z11, LocalVideoDetailFragment localVideoDetailFragment, long j11, DownloadBean downloadBean, Continuation<? super LocalVideoDetailFragment$save$1> continuation) {
        super(2, continuation);
        this.$completed = z11;
        this.this$0 = localVideoDetailFragment;
        this.$playProgress = j11;
        this.$cvideoBean = downloadBean;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocalVideoDetailFragment$save$1(this.$completed, this.this$0, this.$playProgress, this.$cvideoBean, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
        return ((LocalVideoDetailFragment$save$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:59:0x0154  */
    /* JADX WARN: Code duplicated, block: B:63:0x015d  */
    /* JADX WARN: Code duplicated, block: B:66:0x0196  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        long j11;
        long j12;
        DownloadBean downloadBean;
        long j13;
        DownloadBean downloadBean2;
        String resourceId;
        DownloadBean downloadBean3;
        boolean z11;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 != 0) {
            if (i11 == 1) {
                j11 = this.J$0;
                ResultKt.b(obj);
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j13 = this.J$0;
                ResultKt.b(obj);
            }
            this.this$0.E3(this.$cvideoBean);
            j12 = j13;
            downloadBean2 = this.$cvideoBean;
            if (downloadBean2 != null || (resourceId = downloadBean2.getResourceId()) == null) {
                resourceId = "";
            }
            LocalVideoEvent localVideoEvent = new LocalVideoEvent(resourceId, j12, this.this$0.H, this.this$0.A, false, 16, null);
            AppScopeVMlProvider appScopeVMlProvider = AppScopeVMlProvider.INSTANCE;
            FlowEventBus flowEventBus = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
            String name = LocalVideoEvent.class.getName();
            Intrinsics.f(name, "T::class.java.name");
            flowEventBus.postEvent(name, localVideoEvent, 0L);
            downloadBean3 = this.$cvideoBean;
            z11 = false;
            if (downloadBean3 != null && downloadBean3.isOutside()) {
                z11 = true;
            }
            f00.d dVar = new f00.d(true, z11);
            FlowEventBus flowEventBus2 = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
            String name2 = f00.d.class.getName();
            Intrinsics.f(name2, "T::class.java.name");
            flowEventBus2.postEvent(name2, dVar, 0L);
            return Unit.f68710a;
        }
        ResultKt.b(obj);
        j11 = (!this.$completed || this.this$0.H <= 0) ? this.$playProgress : this.this$0.H;
        uo.b.a aVar = uo.b.f78622a;
        String str = this.this$0.f55673k;
        boolean z12 = this.$completed;
        long j14 = this.this$0.H;
        long j15 = this.$playProgress;
        DownloadBean downloadBean4 = this.$cvideoBean;
        aVar.r(str, "save completed = " + z12 + ", duration = " + j14 + ", playProgress= " + j15 + ", cur epse = " + (downloadBean4 != null ? Boxing.d(downloadBean4.getEpse()) : null) + " ", true);
        DownloadBean downloadBean5 = this.$cvideoBean;
        if (downloadBean5 != null) {
            downloadBean5.setReadProgress(j11);
        }
        if (this.this$0.H > 0 && (downloadBean = this.$cvideoBean) != null) {
            downloadBean.setDuration(Boxing.e(this.this$0.H));
        }
        if (this.this$0.J > 0 && this.this$0.I > 0) {
            DownloadBean downloadBean6 = this.$cvideoBean;
            if (downloadBean6 != null) {
                downloadBean6.setVideoWidth(this.this$0.I);
            }
            DownloadBean downloadBean7 = this.$cvideoBean;
            if (downloadBean7 != null) {
                downloadBean7.setVideoHeight(this.this$0.J);
            }
        }
        DownloadBean downloadBean8 = this.$cvideoBean;
        if (downloadBean8 != null) {
            downloadBean8.setLastPlayTimeStamp(System.currentTimeMillis());
        }
        if (this.$cvideoBean != null) {
            uo.b.a.f(aVar, this.this$0.f55673k, "---------update name = " + this.$cvideoBean.getName() + " , playProgress = " + j11, false, 4, null);
            DownloadEsHelper downloadEsHelperA = DownloadEsHelper.f60994m.a();
            DownloadBean downloadBean9 = this.$cvideoBean;
            this.J$0 = j11;
            this.label = 1;
            if (downloadEsHelperA.P(downloadBean9, this) == objE) {
                return objE;
            }
        } else {
            j12 = j11;
        }
        downloadBean2 = this.$cvideoBean;
        if (downloadBean2 != null) {
            resourceId = "";
        } else {
            resourceId = "";
        }
        LocalVideoEvent localVideoEvent2 = new LocalVideoEvent(resourceId, j12, this.this$0.H, this.this$0.A, false, 16, null);
        AppScopeVMlProvider appScopeVMlProvider2 = AppScopeVMlProvider.INSTANCE;
        FlowEventBus flowEventBus3 = (FlowEventBus) appScopeVMlProvider2.getApplicationScopeViewModel(FlowEventBus.class);
        String name3 = LocalVideoEvent.class.getName();
        Intrinsics.f(name3, "T::class.java.name");
        flowEventBus3.postEvent(name3, localVideoEvent2, 0L);
        downloadBean3 = this.$cvideoBean;
        z11 = false;
        if (downloadBean3 != null) {
            z11 = true;
        }
        f00.d dVar2 = new f00.d(true, z11);
        FlowEventBus flowEventBus4 = (FlowEventBus) appScopeVMlProvider2.getApplicationScopeViewModel(FlowEventBus.class);
        String name4 = f00.d.class.getName();
        Intrinsics.f(name4, "T::class.java.name");
        flowEventBus4.postEvent(name4, dVar2, 0L);
        return Unit.f68710a;
        LocalVideoDetailFragment localVideoDetailFragment = this.this$0;
        DownloadBean downloadBean10 = this.$cvideoBean;
        this.J$0 = j11;
        this.label = 2;
        if (localVideoDetailFragment.C3(downloadBean10, this) == objE) {
            return objE;
        }
        j13 = j11;
        this.this$0.E3(this.$cvideoBean);
        j12 = j13;
        downloadBean2 = this.$cvideoBean;
        if (downloadBean2 != null) {
            resourceId = "";
        } else {
            resourceId = "";
        }
        LocalVideoEvent localVideoEvent3 = new LocalVideoEvent(resourceId, j12, this.this$0.H, this.this$0.A, false, 16, null);
        AppScopeVMlProvider appScopeVMlProvider3 = AppScopeVMlProvider.INSTANCE;
        FlowEventBus flowEventBus5 = (FlowEventBus) appScopeVMlProvider3.getApplicationScopeViewModel(FlowEventBus.class);
        String name5 = LocalVideoEvent.class.getName();
        Intrinsics.f(name5, "T::class.java.name");
        flowEventBus5.postEvent(name5, localVideoEvent3, 0L);
        downloadBean3 = this.$cvideoBean;
        z11 = false;
        if (downloadBean3 != null) {
            z11 = true;
        }
        f00.d dVar3 = new f00.d(true, z11);
        FlowEventBus flowEventBus6 = (FlowEventBus) appScopeVMlProvider3.getApplicationScopeViewModel(FlowEventBus.class);
        String name6 = f00.d.class.getName();
        Intrinsics.f(name6, "T::class.java.name");
        flowEventBus6.postEvent(name6, dVar3, 0L);
        return Unit.f68710a;
    }
}
