package com.transsnet.downloader.manager;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.DownloadException;
import com.transsion.moviedetailapi.DownloadItem;
import com.transsnet.downloader.bean.DownloadListBean;
import com.transsnet.downloader.core.thread.DownloadBaseRunnable;
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
import kotlinx.coroutines.k0;

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
@DebugMetadata(c = "com.transsnet.downloader.manager.DownloadManagerImpl$requestNewSource$1", f = "DownloadManagerImpl.kt", l = {1514}, m = "invokeSuspend")
public final class DownloadManagerImpl$requestNewSource$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ DownloadBean $bean;
    int label;
    final /* synthetic */ DownloadManagerImpl this$0;

    /* JADX INFO: renamed from: com.transsnet.downloader.manager.DownloadManagerImpl$requestNewSource$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsnet.downloader.manager.DownloadManagerImpl$requestNewSource$1$1", f = "DownloadManagerImpl.kt", l = {1503, 1508, 1510}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.b<? super DownloadListBean>, Continuation<? super Unit>, Object> {
        final /* synthetic */ DownloadBean $bean;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DownloadManagerImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(DownloadManagerImpl downloadManagerImpl, DownloadBean downloadBean, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = downloadManagerImpl;
            this.$bean = downloadBean;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$bean, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.flow.b<? super DownloadListBean> bVar, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(bVar, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD;
            kotlinx.coroutines.flow.b bVar;
            DownloadListBean downloadListBean;
            List<DownloadItem> items;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 != 0) {
                if (i11 == 1) {
                    kotlinx.coroutines.flow.b bVar2 = (kotlinx.coroutines.flow.b) this.L$0;
                    ResultKt.b(obj);
                    bVar = bVar2;
                    objD = obj;
                } else {
                    if (i11 != 2 && i11 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                return Unit.f68710a;
            }
            ResultKt.b(obj);
            kotlinx.coroutines.flow.b bVar3 = (kotlinx.coroutines.flow.b) this.L$0;
            uo.b.a aVar = uo.b.f78622a;
            String str = this.this$0.f61020a;
            DownloadException exception = this.$bean.getException();
            aVar.c(str, "download, resource error~ request new resource， responseCode = " + (exception != null ? Boxing.d(exception.getResponseCode()) : null), true);
            String url = this.$bean.getUrl();
            DownloadException exception2 = this.$bean.getException();
            String strValueOf = String.valueOf(exception2 != null ? Boxing.d(exception2.getResponseCode()) : null);
            i00.a aVarN0 = this.this$0.n0();
            String strA = cp.a.f62775a.a();
            String subjectId = this.$bean.getSubjectId();
            if (subjectId == null) {
                subjectId = "";
            }
            String resourceId = this.$bean.getResourceId();
            String str2 = resourceId != null ? resourceId : "";
            this.L$0 = bVar3;
            this.label = 1;
            objD = i00.a.C0703a.d(aVarN0, strA, subjectId, str2, url, strValueOf, 0, this, 32, null);
            if (objD == objE) {
                return objE;
            }
            bVar = bVar3;
            BaseDto baseDto = (BaseDto) objD;
            if (Intrinsics.b(baseDto.getCode(), "0") && ((downloadListBean = (DownloadListBean) baseDto.getData()) == null || (items = downloadListBean.getItems()) == null || !items.isEmpty())) {
                Object data = baseDto.getData();
                this.L$0 = null;
                this.label = 3;
                if (bVar.emit(data, this) == objE) {
                    return objE;
                }
            } else {
                this.L$0 = null;
                this.label = 2;
                if (bVar.emit(null, this) == objE) {
                    return objE;
                }
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: renamed from: com.transsnet.downloader.manager.DownloadManagerImpl$requestNewSource$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsnet.downloader.manager.DownloadManagerImpl$requestNewSource$1$2", f = "DownloadManagerImpl.kt", l = {1513}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function3<kotlinx.coroutines.flow.b<? super DownloadListBean>, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(kotlinx.coroutines.flow.b<? super DownloadListBean> bVar, Throwable th2, Continuation<? super Unit> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
            anonymousClass2.L$0 = bVar;
            return anonymousClass2.invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                kotlinx.coroutines.flow.b bVar = (kotlinx.coroutines.flow.b) this.L$0;
                this.label = 1;
                if (bVar.emit(null, this) == objE) {
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

    /* JADX INFO: renamed from: com.transsnet.downloader.manager.DownloadManagerImpl$requestNewSource$1$3, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class AnonymousClass3<T> implements kotlinx.coroutines.flow.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DownloadManagerImpl f61045a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DownloadBean f61046b;

        public AnonymousClass3(DownloadManagerImpl downloadManagerImpl, DownloadBean downloadBean) {
            this.f61045a = downloadManagerImpl;
            this.f61046b = downloadBean;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(DownloadListBean downloadListBean, Continuation<? super Unit> continuation) throws Throwable {
            DownloadManagerImpl$requestNewSource$1$3$emit$1 downloadManagerImpl$requestNewSource$1$3$emit$1;
            List<DownloadItem> items;
            String url;
            AnonymousClass3<T> anonymousClass3;
            if (continuation instanceof DownloadManagerImpl$requestNewSource$1$3$emit$1) {
                downloadManagerImpl$requestNewSource$1$3$emit$1 = (DownloadManagerImpl$requestNewSource$1$3$emit$1) continuation;
                int i11 = downloadManagerImpl$requestNewSource$1$3$emit$1.label;
                if ((i11 & Integer.MIN_VALUE) != 0) {
                    downloadManagerImpl$requestNewSource$1$3$emit$1.label = i11 - Integer.MIN_VALUE;
                } else {
                    downloadManagerImpl$requestNewSource$1$3$emit$1 = new DownloadManagerImpl$requestNewSource$1$3$emit$1(this, continuation);
                }
            } else {
                downloadManagerImpl$requestNewSource$1$3$emit$1 = new DownloadManagerImpl$requestNewSource$1$3$emit$1(this, continuation);
            }
            Object obj = downloadManagerImpl$requestNewSource$1$3$emit$1.result;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i12 = downloadManagerImpl$requestNewSource$1$3$emit$1.label;
            if (i12 != 0) {
                if (i12 == 1) {
                    anonymousClass3 = (AnonymousClass3) downloadManagerImpl$requestNewSource$1$3$emit$1.L$0;
                    ResultKt.b(obj);
                } else {
                    if (i12 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    anonymousClass3 = (AnonymousClass3) downloadManagerImpl$requestNewSource$1$3$emit$1.L$0;
                    ResultKt.b(obj);
                }
                anonymousClass3.f61045a.K0(anonymousClass3.f61046b);
                return Unit.f68710a;
            }
            ResultKt.b(obj);
            if (downloadListBean == null || ((items = downloadListBean.getItems()) != null && items.isEmpty())) {
                uo.b.f78622a.t(DownloadBaseRunnable.TAG, "get new resource failed~~", true);
                this.f61045a.J0(this.f61046b);
            } else {
                List<DownloadItem> items2 = downloadListBean.getItems();
                DownloadItem downloadItem = items2 != null ? items2.get(0) : null;
                String url2 = this.f61046b.getUrl();
                if (Intrinsics.b(url2, downloadItem != null ? downloadItem.getUrl() : null)) {
                    uo.b.f78622a.t(DownloadBaseRunnable.TAG, "get new resource success, but url is same, download next task~~", true);
                    this.f61045a.J0(this.f61046b);
                    return Unit.f68710a;
                }
                DownloadBean downloadBean = this.f61046b;
                if (downloadItem == null || (url = downloadItem.getUrl()) == null) {
                    url = url2;
                }
                downloadBean.setUrl(url);
                this.f61046b.setUrlCreateAt(System.currentTimeMillis());
                DownloadBean downloadBean2 = this.f61046b;
                downloadBean2.setRequestNewSourceCount(downloadBean2.getRequestNewSourceCount() + 1);
                uo.b.f78622a.r(DownloadBaseRunnable.TAG, "get new resource success!!!, update url, lastUrl = " + url2 + ", newUrl = " + this.f61046b.getUrl(), true);
                DownloadEsHelper downloadEsHelperA = DownloadEsHelper.f60994m.a();
                String resourceId = this.f61046b.getResourceId();
                if (resourceId == null) {
                    resourceId = url2;
                }
                downloadManagerImpl$requestNewSource$1$3$emit$1.L$0 = this;
                downloadManagerImpl$requestNewSource$1$3$emit$1.label = 1;
                if (downloadEsHelperA.g(url2, resourceId, downloadManagerImpl$requestNewSource$1$3$emit$1) == objE) {
                    return objE;
                }
                anonymousClass3 = this;
            }
            return Unit.f68710a;
            DownloadEsHelper downloadEsHelperA2 = DownloadEsHelper.f60994m.a();
            DownloadBean downloadBean3 = anonymousClass3.f61046b;
            downloadManagerImpl$requestNewSource$1$3$emit$1.L$0 = anonymousClass3;
            downloadManagerImpl$requestNewSource$1$3$emit$1.label = 2;
            if (downloadEsHelperA2.K(downloadBean3, downloadManagerImpl$requestNewSource$1$3$emit$1) == objE) {
                return objE;
            }
            anonymousClass3.f61045a.K0(anonymousClass3.f61046b);
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadManagerImpl$requestNewSource$1(DownloadManagerImpl downloadManagerImpl, DownloadBean downloadBean, Continuation<? super DownloadManagerImpl$requestNewSource$1> continuation) {
        super(2, continuation);
        this.this$0 = downloadManagerImpl;
        this.$bean = downloadBean;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadManagerImpl$requestNewSource$1(this.this$0, this.$bean, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((DownloadManagerImpl$requestNewSource$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            kotlinx.coroutines.flow.a aVarE = kotlinx.coroutines.flow.c.e(kotlinx.coroutines.flow.c.o(new AnonymousClass1(this.this$0, this.$bean, null)), new AnonymousClass2(null));
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.this$0, this.$bean);
            this.label = 1;
            if (aVarE.a(anonymousClass3, this) == objE) {
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
