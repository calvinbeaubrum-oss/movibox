package com.transsnet.downloader.manager;

import com.blankj.utilcode.util.n;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsnet.downloader.bean.StartRequestBean;
import com.transsnet.downloader.bean.StartResponseBean;
import com.transsnet.downloader.bean.StartlDownloadBean;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.r0;
import okhttp3.RequestBody;

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
@DebugMetadata(c = "com.transsnet.downloader.manager.StartDownloadHelper$startDownloadResource$1", f = "StartDownloadHelper.kt", l = {59}, m = "invokeSuspend")
@SourceDebugExtension
public final class StartDownloadHelper$startDownloadResource$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<DownloadBean> $beanList;
    int label;
    final /* synthetic */ StartDownloadHelper this$0;

    /* JADX INFO: renamed from: com.transsnet.downloader.manager.StartDownloadHelper$startDownloadResource$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsnet.downloader.manager.StartDownloadHelper$startDownloadResource$1$2", f = "StartDownloadHelper.kt", l = {54, 55}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.b<? super StartResponseBean>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ArrayList<StartlDownloadBean> $newlist;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ StartDownloadHelper this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(StartDownloadHelper startDownloadHelper, ArrayList<StartlDownloadBean> arrayList, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = startDownloadHelper;
            this.$newlist = arrayList;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, this.$newlist, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.flow.b<? super StartResponseBean> bVar, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(bVar, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            kotlinx.coroutines.flow.b bVar;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 != 0) {
                if (i11 == 1) {
                    bVar = (kotlinx.coroutines.flow.b) this.L$0;
                    ResultKt.b(obj);
                } else {
                    if (i11 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                return Unit.f68710a;
            }
            ResultKt.b(obj);
            bVar = (kotlinx.coroutines.flow.b) this.L$0;
            RoomAppMMKV.f51271a.a().putLong(DownloadInterceptManager.f61008a.b(), System.currentTimeMillis());
            i00.a aVarC = this.this$0.c();
            String strA = cp.a.f62775a.a();
            ip.b.a aVar = ip.b.f67591a;
            String strJ = n.j(new StartRequestBean(this.$newlist));
            Intrinsics.f(strJ, "toJson(StartRequestBean(newlist))");
            RequestBody requestBodyA = aVar.a(strJ);
            this.L$0 = bVar;
            this.label = 1;
            obj = aVarC.h(strA, requestBodyA, this);
            if (obj == objE) {
                return objE;
            }
            Object data = ((BaseDto) obj).getData();
            this.L$0 = null;
            this.label = 2;
            if (bVar.emit(data, this) == objE) {
                return objE;
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: renamed from: com.transsnet.downloader.manager.StartDownloadHelper$startDownloadResource$1$3, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsnet.downloader.manager.StartDownloadHelper$startDownloadResource$1$3", f = "StartDownloadHelper.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass3 extends SuspendLambda implements Function3<kotlinx.coroutines.flow.b<? super StartResponseBean>, Throwable, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ StartDownloadHelper this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(StartDownloadHelper startDownloadHelper, Continuation<? super AnonymousClass3> continuation) {
            super(3, continuation);
            this.this$0 = startDownloadHelper;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(kotlinx.coroutines.flow.b<? super StartResponseBean> bVar, Throwable th2, Continuation<? super Unit> continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.this$0, continuation);
            anonymousClass3.L$0 = th2;
            return anonymousClass3.invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            kotlin.coroutines.intrinsics.a.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            Throwable th2 = (Throwable) this.L$0;
            uo.b.a aVar = uo.b.f78622a;
            String str = this.this$0.f61059a;
            String message = th2.getMessage();
            if (message == null) {
                message = "";
            }
            uo.b.a.e(aVar, str, message, th2, false, 8, null);
            return Unit.f68710a;
        }
    }

    /* JADX INFO: renamed from: com.transsnet.downloader.manager.StartDownloadHelper$startDownloadResource$1$4, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class AnonymousClass4<T> implements kotlinx.coroutines.flow.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List<DownloadBean> f61061a;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass4(List<? extends DownloadBean> list) {
            this.f61061a = list;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(StartResponseBean startResponseBean, Continuation<? super Unit> continuation) throws Throwable {
            StartDownloadHelper$startDownloadResource$1$4$emit$1 startDownloadHelper$startDownloadResource$1$4$emit$1;
            if (continuation instanceof StartDownloadHelper$startDownloadResource$1$4$emit$1) {
                startDownloadHelper$startDownloadResource$1$4$emit$1 = (StartDownloadHelper$startDownloadResource$1$4$emit$1) continuation;
                int i11 = startDownloadHelper$startDownloadResource$1$4$emit$1.label;
                if ((i11 & Integer.MIN_VALUE) != 0) {
                    startDownloadHelper$startDownloadResource$1$4$emit$1.label = i11 - Integer.MIN_VALUE;
                } else {
                    startDownloadHelper$startDownloadResource$1$4$emit$1 = new StartDownloadHelper$startDownloadResource$1$4$emit$1(this, continuation);
                }
            } else {
                startDownloadHelper$startDownloadResource$1$4$emit$1 = new StartDownloadHelper$startDownloadResource$1$4$emit$1(this, continuation);
            }
            Object obj = startDownloadHelper$startDownloadResource$1$4$emit$1.result;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i12 = startDownloadHelper$startDownloadResource$1$4$emit$1.label;
            if (i12 == 0) {
                ResultKt.b(obj);
                DownloadInterceptManager.f61008a.a().f();
                List<DownloadBean> list = this.f61061a;
                if (list != null) {
                    for (DownloadBean downloadBean : list) {
                        if (downloadBean.isStartRequested()) {
                            downloadBean.setSubtitleStarted(1);
                        }
                    }
                }
                startDownloadHelper$startDownloadResource$1$4$emit$1.label = 1;
                if (r0.a(3000L, startDownloadHelper$startDownloadResource$1$4$emit$1) == objE) {
                    return objE;
                }
            } else {
                if (i12 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            DownloadInterceptManager.f61008a.a().g();
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StartDownloadHelper$startDownloadResource$1(List<? extends DownloadBean> list, StartDownloadHelper startDownloadHelper, Continuation<? super StartDownloadHelper$startDownloadResource$1> continuation) {
        super(2, continuation);
        this.$beanList = list;
        this.this$0 = startDownloadHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StartDownloadHelper$startDownloadResource$1(this.$beanList, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((StartDownloadHelper$startDownloadResource$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        String resourceId;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            ArrayList arrayList = new ArrayList();
            List<DownloadBean> list = this.$beanList;
            if (list != null && (!list.isEmpty())) {
                List<DownloadBean> list2 = this.$beanList;
                StartDownloadHelper startDownloadHelper = this.this$0;
                for (DownloadBean downloadBean : list2) {
                    if (downloadBean.getSubtitleStarted() == 1) {
                        uo.b.a.s(uo.b.f78622a, startDownloadHelper.f61059a, "onStartDownload，is started, do not try again, name =  " + downloadBean.getName() + ", subjectId = " + downloadBean.getSubjectId(), false, 4, null);
                        downloadBean.setStartRequested(true);
                    } else {
                        String resourceId2 = downloadBean.getResourceId();
                        if (resourceId2 == null || resourceId2.length() == 0 || ((resourceId = downloadBean.getResourceId()) != null && StringsKt__StringsKt.Q(resourceId, HttpHost.DEFAULT_SCHEME_NAME, false, 2, null))) {
                            uo.b.a.f(uo.b.f78622a, startDownloadHelper.f61059a, "onStartDownload fail， has no resourceId, name = " + downloadBean.getName(), false, 4, null);
                        } else {
                            arrayList.add(new StartlDownloadBean(downloadBean.getSubjectId(), downloadBean.getResourceId(), Boxing.d(downloadBean.getEpse())));
                            downloadBean.setStartRequested(true);
                            uo.b.a.f(uo.b.f78622a, startDownloadHelper.f61059a, "onStartDownload, name =  " + downloadBean.getName() + ", subjectId = " + downloadBean.getSubjectId() + ",resourceId = " + downloadBean.getResourceId() + ",episode = " + downloadBean.getEpse(), false, 4, null);
                        }
                    }
                }
            }
            kotlinx.coroutines.flow.a aVarE = kotlinx.coroutines.flow.c.e(kotlinx.coroutines.flow.c.o(new AnonymousClass2(this.this$0, arrayList, null)), new AnonymousClass3(this.this$0, null));
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(this.$beanList);
            this.label = 1;
            if (aVarE.a(anonymousClass4, this) == objE) {
                return objE;
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
