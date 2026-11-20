package com.transsnet.downloader.util;

import android.content.Context;
import com.tn.lib.widget.R$string;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsnet.downloader.dialog.LocalFileErrorDialog;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
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
@DebugMetadata(c = "com.transsnet.downloader.util.LocalVideoNotExistUtil$showErrorDialog$1", f = "LocalVideoNotExistUtil.kt", l = {}, m = "invokeSuspend")
public final class LocalVideoNotExistUtil$showErrorDialog$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $contextI;
    final /* synthetic */ boolean $isSeries;
    final /* synthetic */ String $path;
    final /* synthetic */ String $resourceId;
    final /* synthetic */ boolean $seriesCollection;
    final /* synthetic */ List<DownloadBean> $seriesCollectionList;
    final /* synthetic */ int $seriesPosition;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalVideoNotExistUtil$showErrorDialog$1(Context context, boolean z11, String str, List<DownloadBean> list, String str2, boolean z12, int i11, Continuation<? super LocalVideoNotExistUtil$showErrorDialog$1> continuation) {
        super(2, continuation);
        this.$contextI = context;
        this.$seriesCollection = z11;
        this.$resourceId = str;
        this.$seriesCollectionList = list;
        this.$path = str2;
        this.$isSeries = z12;
        this.$seriesPosition = i11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocalVideoNotExistUtil$showErrorDialog$1(this.$contextI, this.$seriesCollection, this.$resourceId, this.$seriesCollectionList, this.$path, this.$isSeries, this.$seriesPosition, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((LocalVideoNotExistUtil$showErrorDialog$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlin.coroutines.intrinsics.a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        LocalFileErrorDialog localFileErrorDialog = new LocalFileErrorDialog();
        final Context context = this.$contextI;
        final boolean z11 = this.$seriesCollection;
        final String str = this.$resourceId;
        final List<DownloadBean> list = this.$seriesCollectionList;
        final String str2 = this.$path;
        final boolean z12 = this.$isSeries;
        final int i11 = this.$seriesPosition;
        localFileErrorDialog.u0(new Function1<Integer, Unit>() { // from class: com.transsnet.downloader.util.LocalVideoNotExistUtil$showErrorDialog$1$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.f68710a;
            }

            public final void invoke(int i12) {
                if (i12 == 1) {
                    if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
                        zp.b.f82110a.d(R$string.no_network_toast);
                        return;
                    }
                    if (z11) {
                        uo.b.a.f(uo.b.f78622a, "LocalVideoNotExistUtil", "合集列表, 展示路径选择弹窗", false, 4, null);
                        LocalVideoNotExistUtil.f61140a.l(context, str, list);
                        return;
                    }
                    uo.b.a.f(uo.b.f78622a, "LocalVideoNotExistUtil", "单资源, 展示路径选择弹窗", false, 4, null);
                    LocalVideoNotExistUtil localVideoNotExistUtil = LocalVideoNotExistUtil.f61140a;
                    Context context2 = context;
                    final String str3 = str;
                    final String str4 = str2;
                    final boolean z13 = z12;
                    final int i13 = i11;
                    localVideoNotExistUtil.g(context2, str3, null, new Function1<String, Unit>() { // from class: com.transsnet.downloader.util.LocalVideoNotExistUtil$showErrorDialog$1$1$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(String str5) {
                            invoke2(str5);
                            return Unit.f68710a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(String str5) {
                            uo.b.f78622a.h("long_video_play", "单资源, 本地源文件不存在，开始重新下载, resourceId = " + str3 + "，path =" + str4, true);
                            LocalVideoNotExistUtil.f61140a.j(str3, str4, z13, i13);
                        }
                    });
                    return;
                }
                if (i12 != 2) {
                    return;
                }
                if (!z11) {
                    LocalVideoNotExistUtil.i(LocalVideoNotExistUtil.f61140a, str, str2, z12, i11, null, 16, null);
                    return;
                }
                List<DownloadBean> list2 = list;
                if (list2 != null) {
                    for (DownloadBean downloadBean : list2) {
                        if (downloadBean.getStatus() < 10) {
                            LocalVideoNotExistUtil localVideoNotExistUtil2 = LocalVideoNotExistUtil.f61140a;
                            String resourceId = downloadBean.getResourceId();
                            if (resourceId == null) {
                                resourceId = downloadBean.getUrl();
                            }
                            localVideoNotExistUtil2.h(resourceId, downloadBean.getPath(), false, -1, downloadBean.getSubjectId());
                        }
                    }
                }
            }
        });
        localFileErrorDialog.j0(context, "LocalFileErrorDialog");
        return Unit.f68710a;
    }
}
