package com.transsnet.downloader;

import android.content.Context;
import com.transsion.baselib.db.download.DownloadBean;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "com.transsnet.downloader.DownloadManagerApi$playNow$1", f = "DownloadManagerApi.kt", l = {924}, m = "invokeSuspend")
@SourceDebugExtension
public final class DownloadManagerApi$playNow$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $pageFrom;
    final /* synthetic */ String $resourceId;
    final /* synthetic */ String $subjectId;
    int label;
    final /* synthetic */ DownloadManagerApi this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadManagerApi$playNow$1(String str, DownloadManagerApi downloadManagerApi, Context context, String str2, String str3, Continuation<? super DownloadManagerApi$playNow$1> continuation) {
        super(2, continuation);
        this.$subjectId = str;
        this.this$0 = downloadManagerApi;
        this.$context = context;
        this.$pageFrom = str2;
        this.$resourceId = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadManagerApi$playNow$1(this.$subjectId, this.this$0, this.$context, this.$pageFrom, this.$resourceId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((DownloadManagerApi$playNow$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            if (this.$subjectId != null) {
                com.transsnet.downloader.manager.a aVarF2 = this.this$0.f2();
                String str = this.$subjectId;
                this.label = 1;
                obj = aVarF2.e(str, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                com.transsnet.downloader.manager.a aVarF3 = this.this$0.f2();
                String str2 = this.$resourceId;
                final DownloadManagerApi downloadManagerApi = this.this$0;
                final Context context = this.$context;
                final String str3 = this.$pageFrom;
                aVarF3.r(str2, new Function1<DownloadBean, Unit>() { // from class: com.transsnet.downloader.DownloadManagerApi$playNow$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DownloadBean downloadBean) {
                        invoke2(downloadBean);
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DownloadBean downloadBean) {
                        downloadManagerApi.f60280e = downloadBean;
                        DownloadBean downloadBean2 = downloadManagerApi.f60280e;
                        if (downloadBean2 == null || !downloadBean2.isVideo()) {
                            downloadManagerApi.l2(context);
                        } else {
                            downloadManagerApi.k2(context, str3);
                        }
                    }
                });
            }
            return Unit.f68710a;
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        List list = (List) obj;
        List listE0 = list != null ? CollectionsKt___CollectionsKt.E0(list, new Comparator() { // from class: com.transsnet.downloader.DownloadManagerApi$playNow$1$invokeSuspend$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t11, T t12) {
                return kotlin.comparisons.b.d(Integer.valueOf(((DownloadBean) t11).getEp()), Integer.valueOf(((DownloadBean) t12).getEp()));
            }
        }) : null;
        if (listE0 != null && (!listE0.isEmpty())) {
            this.this$0.f60280e = (DownloadBean) listE0.get(0);
            if (this.this$0.f60280e == null) {
                return Unit.f68710a;
            }
            DownloadBean downloadBean = this.this$0.f60280e;
            if (downloadBean == null || !downloadBean.isVideo()) {
                this.this$0.l2(this.$context);
            } else {
                this.this$0.k2(this.$context, this.$pageFrom);
            }
        }
        return Unit.f68710a;
    }
}
