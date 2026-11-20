package com.transsnet.downloader.util;

import com.transsion.player.orplayer.global.TnPlayerManager;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.downloader.manager.DownloadEsHelper;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.DownloadRefreshEvent;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.w0;

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
@DebugMetadata(c = "com.transsnet.downloader.util.LocalVideoNotExistUtil$delete$2", f = "LocalVideoNotExistUtil.kt", l = {229, 236, 237, 240}, m = "invokeSuspend")
@SourceDebugExtension
public final class LocalVideoNotExistUtil$delete$2 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isSeries;
    final /* synthetic */ String $path;
    final /* synthetic */ String $resourceId;
    final /* synthetic */ int $seriesPosition;
    final /* synthetic */ String $subjectId;
    int label;

    /* JADX INFO: renamed from: com.transsnet.downloader.util.LocalVideoNotExistUtil$delete$2$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsnet.downloader.util.LocalVideoNotExistUtil$delete$2$2", f = "LocalVideoNotExistUtil.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $resourceId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$resourceId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$resourceId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            kotlin.coroutines.intrinsics.a.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            TnPlayerManager.f54684a.o(this.$resourceId);
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalVideoNotExistUtil$delete$2(String str, String str2, boolean z11, int i11, String str3, Continuation<? super LocalVideoNotExistUtil$delete$2> continuation) {
        super(2, continuation);
        this.$resourceId = str;
        this.$path = str2;
        this.$isSeries = z11;
        this.$seriesPosition = i11;
        this.$subjectId = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocalVideoNotExistUtil$delete$2(this.$resourceId, this.$path, this.$isSeries, this.$seriesPosition, this.$subjectId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((LocalVideoNotExistUtil$delete$2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0095 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:30:0x00a0 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:33:0x00b1  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        a2 a2VarC;
        AnonymousClass2 anonymousClass2;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 != 0) {
            if (i11 == 1) {
                ResultKt.b(obj);
            } else if (i11 == 2) {
                ResultKt.b(obj);
                a2VarC = w0.c();
                anonymousClass2 = new AnonymousClass2(this.$resourceId, null);
                this.label = 3;
                if (kotlinx.coroutines.h.g(a2VarC, anonymousClass2, this) == objE) {
                    return objE;
                }
                this.label = 4;
                if (r0.a(200L, this) == objE) {
                    return objE;
                }
            } else if (i11 == 3) {
                ResultKt.b(obj);
                this.label = 4;
                if (r0.a(200L, this) == objE) {
                    return objE;
                }
            } else {
                if (i11 != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            uo.b.a.f(uo.b.f78622a, "LocalVideoNotExistUtil", "2 delete, 刷新列表", false, 4, null);
            if (this.$isSeries) {
                LocalVideoNotExistUtil.f61140a.m(this.$seriesPosition);
            }
            f00.d dVar = new f00.d(true, false);
            AppScopeVMlProvider appScopeVMlProvider = AppScopeVMlProvider.INSTANCE;
            FlowEventBus flowEventBus = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
            String name = f00.d.class.getName();
            Intrinsics.f(name, "T::class.java.name");
            flowEventBus.postEvent(name, dVar, 0L);
            DownloadRefreshEvent downloadRefreshEvent = new DownloadRefreshEvent("", "", false, false, 12, null);
            FlowEventBus flowEventBus2 = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
            String name2 = DownloadRefreshEvent.class.getName();
            Intrinsics.f(name2, "T::class.java.name");
            flowEventBus2.postEvent(name2, downloadRefreshEvent, 0L);
            DownloadManagerApi.f60274j.a().q2(this.$subjectId, this.$resourceId, this.$isSeries, (8 & 8) != 0, (8 & 16) != 0 ? false : false);
            return Unit.f68710a;
        }
        ResultKt.b(obj);
        uo.b.a.f(uo.b.f78622a, "LocalVideoNotExistUtil", "2 delete, resourceId = " + this.$resourceId, false, 4, null);
        DownloadEsHelper downloadEsHelperA = DownloadEsHelper.f60994m.a();
        String str = this.$resourceId;
        this.label = 1;
        if (downloadEsHelperA.h(str, null, this) == objE) {
            return objE;
        }
        String str2 = this.$path;
        if (str2 != null) {
            File file = new File(str2);
            if (file.exists()) {
                file.delete();
            }
        }
        tr.h hVarK = LocalVideoNotExistUtil.f61140a.k();
        String str3 = this.$resourceId;
        this.label = 2;
        if (hVarK.b(str3, this) == objE) {
            return objE;
        }
        a2VarC = w0.c();
        anonymousClass2 = new AnonymousClass2(this.$resourceId, null);
        this.label = 3;
        if (kotlinx.coroutines.h.g(a2VarC, anonymousClass2, this) == objE) {
            return objE;
        }
        this.label = 4;
        if (r0.a(200L, this) == objE) {
            return objE;
        }
        uo.b.a.f(uo.b.f78622a, "LocalVideoNotExistUtil", "2 delete, 刷新列表", false, 4, null);
        if (this.$isSeries) {
            LocalVideoNotExistUtil.f61140a.m(this.$seriesPosition);
        }
        f00.d dVar2 = new f00.d(true, false);
        AppScopeVMlProvider appScopeVMlProvider2 = AppScopeVMlProvider.INSTANCE;
        FlowEventBus flowEventBus3 = (FlowEventBus) appScopeVMlProvider2.getApplicationScopeViewModel(FlowEventBus.class);
        String name3 = f00.d.class.getName();
        Intrinsics.f(name3, "T::class.java.name");
        flowEventBus3.postEvent(name3, dVar2, 0L);
        DownloadRefreshEvent downloadRefreshEvent2 = new DownloadRefreshEvent("", "", false, false, 12, null);
        FlowEventBus flowEventBus4 = (FlowEventBus) appScopeVMlProvider2.getApplicationScopeViewModel(FlowEventBus.class);
        String name4 = DownloadRefreshEvent.class.getName();
        Intrinsics.f(name4, "T::class.java.name");
        flowEventBus4.postEvent(name4, downloadRefreshEvent2, 0L);
        DownloadManagerApi.f60274j.a().q2(this.$subjectId, this.$resourceId, this.$isSeries, (8 & 8) != 0, (8 & 16) != 0 ? false : false);
        return Unit.f68710a;
    }
}
