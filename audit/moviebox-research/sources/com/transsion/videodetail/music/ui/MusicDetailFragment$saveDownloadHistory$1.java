package com.transsion.videodetail.music.ui;

import com.transsion.baselib.db.download.DownloadBean;
import com.transsnet.downloader.manager.DownloadEsHelper;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.LocalVideoEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
@DebugMetadata(c = "com.transsion.videodetail.music.ui.MusicDetailFragment$saveDownloadHistory$1", f = "MusicDetailFragment.kt", l = {1811}, m = "invokeSuspend")
@SourceDebugExtension
public final class MusicDetailFragment$saveDownloadHistory$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $progress;
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ MusicDetailFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MusicDetailFragment$saveDownloadHistory$1(MusicDetailFragment musicDetailFragment, long j11, Continuation<? super MusicDetailFragment$saveDownloadHistory$1> continuation) {
        super(2, continuation);
        this.this$0 = musicDetailFragment;
        this.$progress = j11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MusicDetailFragment$saveDownloadHistory$1(this.this$0, this.$progress, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((MusicDetailFragment$saveDownloadHistory$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        String resourceId;
        String str;
        long j11;
        MusicDetailFragment musicDetailFragment;
        Long duration;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            DownloadBean downloadBean = this.this$0.N;
            if (downloadBean != null && (resourceId = downloadBean.getResourceId()) != null) {
                long j12 = this.$progress;
                MusicDetailFragment musicDetailFragment2 = this.this$0;
                DownloadEsHelper downloadEsHelperA = DownloadEsHelper.f60994m.a();
                this.L$0 = musicDetailFragment2;
                this.L$1 = resourceId;
                this.J$0 = j12;
                this.label = 1;
                if (downloadEsHelperA.S(resourceId, j12, this) == objE) {
                    return objE;
                }
                str = resourceId;
                j11 = j12;
                musicDetailFragment = musicDetailFragment2;
            }
            return Unit.f68710a;
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        long j13 = this.J$0;
        String str2 = (String) this.L$1;
        musicDetailFragment = (MusicDetailFragment) this.L$0;
        ResultKt.b(obj);
        j11 = j13;
        str = str2;
        DownloadBean downloadBean2 = musicDetailFragment.N;
        LocalVideoEvent localVideoEvent = new LocalVideoEvent(str, j11, (downloadBean2 == null || (duration = downloadBean2.getDuration()) == null) ? 0L : duration.longValue(), false, false, 16, null);
        AppScopeVMlProvider appScopeVMlProvider = AppScopeVMlProvider.INSTANCE;
        FlowEventBus flowEventBus = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
        String name = LocalVideoEvent.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.postEvent(name, localVideoEvent, 0L);
        DownloadBean downloadBean3 = musicDetailFragment.N;
        boolean z11 = false;
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
}
