package com.transsnet.downloader;

import com.transsnet.downloader.manager.DownloadEsHelper;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.AddToDownloadEvent;
import java.util.List;
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
@DebugMetadata(c = "com.transsnet.downloader.DownloadManagerApi$addPlayAvailable$1", f = "DownloadManagerApi.kt", l = {828}, m = "invokeSuspend")
@SourceDebugExtension
public final class DownloadManagerApi$addPlayAvailable$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $needNotify;
    final /* synthetic */ String $resourceId;
    final /* synthetic */ String $subjectId;
    final /* synthetic */ int $totalEpisode;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    final /* synthetic */ DownloadManagerApi this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadManagerApi$addPlayAvailable$1(String str, int i11, DownloadManagerApi downloadManagerApi, boolean z11, String str2, Continuation<? super DownloadManagerApi$addPlayAvailable$1> continuation) {
        super(2, continuation);
        this.$subjectId = str;
        this.$totalEpisode = i11;
        this.this$0 = downloadManagerApi;
        this.$needNotify = z11;
        this.$resourceId = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadManagerApi$addPlayAvailable$1(this.$subjectId, this.$totalEpisode, this.this$0, this.$needNotify, this.$resourceId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((DownloadManagerApi$addPlayAvailable$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        String str;
        int i11;
        DownloadManagerApi downloadManagerApi;
        String str2;
        boolean z11;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = this.label;
        if (i12 == 0) {
            ResultKt.b(obj);
            str = this.$subjectId;
            if (str == null) {
                return null;
            }
            i11 = this.$totalEpisode;
            downloadManagerApi = this.this$0;
            boolean z12 = this.$needNotify;
            str2 = this.$resourceId;
            DownloadEsHelper downloadEsHelperA = DownloadEsHelper.f60994m.a();
            this.L$0 = downloadManagerApi;
            this.L$1 = str;
            this.L$2 = str2;
            this.I$0 = i11;
            this.Z$0 = z12;
            this.label = 1;
            Object objJ = downloadEsHelperA.j(str, this);
            if (objJ == objE) {
                return objE;
            }
            z11 = z12;
            obj = objJ;
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            z11 = this.Z$0;
            i11 = this.I$0;
            str2 = (String) this.L$2;
            str = (String) this.L$1;
            downloadManagerApi = (DownloadManagerApi) this.L$0;
            ResultKt.b(obj);
        }
        List list = (List) obj;
        if (i11 <= (list != null ? list.size() : -1)) {
            downloadManagerApi.f60277b.add(str);
            if (z11) {
                AddToDownloadEvent addToDownloadEvent = new AddToDownloadEvent(str, str2, true, true);
                FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
                String name = AddToDownloadEvent.class.getName();
                Intrinsics.f(name, "T::class.java.name");
                flowEventBus.postEvent(name, addToDownloadEvent, 0L);
            }
        }
        return Unit.f68710a;
    }
}
