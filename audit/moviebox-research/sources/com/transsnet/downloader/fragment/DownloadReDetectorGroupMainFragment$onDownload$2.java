package com.transsnet.downloader.fragment;

import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.downloader.api.DownloadPageType;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.DownloadRefreshEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "com.transsnet.downloader.fragment.DownloadReDetectorGroupMainFragment$onDownload$2", f = "DownloadReDetectorGroupMainFragment.kt", l = {869}, m = "invokeSuspend")
@SourceDebugExtension
public final class DownloadReDetectorGroupMainFragment$onDownload$2 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DownloadReDetectorGroupMainFragment this$0;

    /* JADX INFO: renamed from: com.transsnet.downloader.fragment.DownloadReDetectorGroupMainFragment$onDownload$2$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsnet.downloader.fragment.DownloadReDetectorGroupMainFragment$onDownload$2$2", f = "DownloadReDetectorGroupMainFragment.kt", l = {}, m = "invokeSuspend")
    @SourceDebugExtension
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DownloadReDetectorGroupMainFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(DownloadReDetectorGroupMainFragment downloadReDetectorGroupMainFragment, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = downloadReDetectorGroupMainFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            ResourceDetectors resourceDetector;
            kotlin.coroutines.intrinsics.a.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            String str = this.this$0.f60715y;
            Subject subject = this.this$0.f60714x;
            String resourceId = (subject == null || (resourceDetector = subject.getResourceDetector()) == null) ? null : resourceDetector.getResourceId();
            Subject subject2 = this.this$0.f60714x;
            DownloadRefreshEvent downloadRefreshEvent = new DownloadRefreshEvent(str, resourceId, true, subject2 == null || subject2.isSeries());
            FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = DownloadRefreshEvent.class.getName();
            Intrinsics.f(name, "T::class.java.name");
            flowEventBus.postEvent(name, downloadRefreshEvent, 0L);
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadReDetectorGroupMainFragment$onDownload$2(DownloadReDetectorGroupMainFragment downloadReDetectorGroupMainFragment, Continuation<? super DownloadReDetectorGroupMainFragment$onDownload$2> continuation) {
        super(2, continuation);
        this.this$0 = downloadReDetectorGroupMainFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadReDetectorGroupMainFragment$onDownload$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
        return ((DownloadReDetectorGroupMainFragment$onDownload$2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            int i12 = 0;
            for (Object obj2 : this.this$0.O) {
                int i13 = i12 + 1;
                if (i12 < 0) {
                    kotlin.collections.g.u();
                }
                DownloadBean downloadBean = (DownloadBean) obj2;
                DownloadManagerApi.f60274j.a().V1(downloadBean.getSubjectId(), downloadBean.getResourceId(), downloadBean.isSeries(), downloadBean.getTotalEpisode(), downloadBean.isMultiresolution(), downloadBean.isMultiresolution());
                i12 = i13;
            }
            if (Intrinsics.b(this.this$0.f60712v, DownloadPageType.SERIES.getPageName())) {
                kotlinx.coroutines.a2 a2VarC = kotlinx.coroutines.w0.c();
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, null);
                this.label = 1;
                if (kotlinx.coroutines.h.g(a2VarC, anonymousClass2, this) == objE) {
                    return objE;
                }
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f68710a;
    }
}
