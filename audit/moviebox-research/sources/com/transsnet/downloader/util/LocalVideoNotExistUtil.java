package com.transsnet.downloader.util;

import android.app.Application;
import android.content.Context;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.report.RoomActivityLifecycleCallbacks;
import com.transsnet.downloader.fragment.DownloadReDetectorMainDialog;
import com.transsnet.downloader.manager.DownloadEsHelper;
import com.transsnet.downloader.viewmodel.DownloadListManager;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.DownloadRefreshEvent;
import com.transsnet.flow.event.sync.event.LocalVideoEvent;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;

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
@SourceDebugExtension
public final class LocalVideoNotExistUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LocalVideoNotExistUtil f61140a = new LocalVideoNotExistUtil();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f61141b = LazyKt__LazyJVMKt.b(new Function0<tr.h>() { // from class: com.transsnet.downloader.util.LocalVideoNotExistUtil$downloadRangeDao$2
        @Override // kotlin.jvm.functions.Function0
        public final tr.h invoke() {
            AppDatabase.v0 v0Var = AppDatabase.f51036p;
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            return v0Var.b(applicationA).F0();
        }
    });

    public static /* synthetic */ void i(LocalVideoNotExistUtil localVideoNotExistUtil, String str, String str2, boolean z11, int i11, String str3, int i12, Object obj) {
        if ((i12 & 16) != 0) {
            str3 = null;
        }
        localVideoNotExistUtil.h(str, str2, z11, i11, str3);
    }

    public final void g(Context context, String str, final DownloadBean downloadBean, final Function1<? super String, Unit> function1) {
        if (downloadBean == null) {
            downloadBean = DownloadEsHelper.f60994m.a().l(str);
        }
        if (downloadBean == null || downloadBean.getType() == 1) {
            function1.invoke(null);
            return;
        }
        DownloadReDetectorMainDialog downloadReDetectorMainDialogC = DownloadReDetectorMainDialog.f60720w.c();
        downloadReDetectorMainDialogC.j0(context, "download_anima");
        downloadReDetectorMainDialogC.w0(new Function1<f00.b, Unit>() { // from class: com.transsnet.downloader.util.LocalVideoNotExistUtil$checkShowPathSetting$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(f00.b bVar) {
                invoke2(bVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(f00.b it) {
                Intrinsics.g(it, "it");
                DownloadBean downloadBean2 = downloadBean;
                downloadBean2.setPath(DownloadUtil.f61136a.j(downloadBean2));
                function1.invoke(downloadBean.getPath());
            }
        });
    }

    public final void h(String str, String str2, final boolean z11, final int i11, String str3) {
        DownloadBean downloadBeanL = DownloadEsHelper.f60994m.a().l(str);
        if (downloadBeanL == null) {
            kotlinx.coroutines.j.d(l0.a(w0.b()), null, null, new LocalVideoNotExistUtil$delete$2(str, str2, z11, i11, str3, null), 3, null);
            return;
        }
        uo.b.a.f(uo.b.f78622a, "LocalVideoNotExistUtil", "3 delete, resourceId = " + str, false, 4, null);
        com.transsnet.downloader.manager.b.f61062a.a(Utils.a()).k(downloadBeanL, new Function1<Boolean, Unit>() { // from class: com.transsnet.downloader.util.LocalVideoNotExistUtil$delete$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.f68710a;
            }

            public final void invoke(boolean z12) {
                if (z11) {
                    LocalVideoNotExistUtil.f61140a.m(i11);
                }
                DownloadRefreshEvent downloadRefreshEvent = new DownloadRefreshEvent("", "", false, false, 12, null);
                FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
                String name = DownloadRefreshEvent.class.getName();
                Intrinsics.f(name, "T::class.java.name");
                flowEventBus.postEvent(name, downloadRefreshEvent, 0L);
            }
        });
    }

    public final void j(String str, String str2, boolean z11, int i11) {
        kotlinx.coroutines.j.d(l0.a(w0.b()), null, null, new LocalVideoNotExistUtil$download$1(str, str2, z11, i11, null), 3, null);
    }

    public final tr.h k() {
        return (tr.h) f61141b.getValue();
    }

    public final void l(Context context, final String str, final List<DownloadBean> list) {
        DownloadBean next;
        List<DownloadBean> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        Iterator<DownloadBean> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next.getStatus() < 10) {
                uo.b.a.f(uo.b.f78622a, "LocalVideoNotExistUtil", "合集列表, 展示路径选择弹窗2", false, 4, null);
                break;
            }
        }
        if (next != null) {
            f61140a.g(context, str, next, new Function1<String, Unit>() { // from class: com.transsnet.downloader.util.LocalVideoNotExistUtil$handleSeriesReDownload$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                    invoke2(str2);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String str2) {
                    List<DownloadBean> list3 = list;
                    String str3 = str;
                    for (DownloadBean downloadBean : list3) {
                        if (downloadBean.getStatus() < 10) {
                            if (str2 != null && str2.length() > 0) {
                                downloadBean.setPath(DownloadUtil.f61136a.j(downloadBean));
                            }
                            uo.b.f78622a.h("long_video_play", "剧集, 本地源文件不存在，开始重新下载, resourceId = " + str3 + ", path = " + str2, true);
                            LocalVideoNotExistUtil localVideoNotExistUtil = LocalVideoNotExistUtil.f61140a;
                            String resourceId = downloadBean.getResourceId();
                            if (resourceId == null) {
                                resourceId = downloadBean.getUrl();
                            }
                            localVideoNotExistUtil.j(resourceId, downloadBean.getPath(), false, -1);
                        }
                    }
                }
            });
        }
    }

    public final void m(int i11) {
        DownloadListManager downloadListManagerA;
        if (i11 < 0) {
            return;
        }
        DownloadListManager.a aVar = DownloadListManager.f61186m;
        DownloadBean downloadBeanF = aVar.a().z().f();
        if (downloadBeanF != null) {
            try {
                List<DownloadBean> seriesList = downloadBeanF.getSeriesList();
                if (seriesList != null) {
                    seriesList.remove(i11);
                }
            } catch (Throwable unused) {
                downloadListManagerA = DownloadListManager.f61186m.a();
            }
        }
        downloadListManagerA = aVar.a();
        downloadListManagerA.z().n(downloadBeanF);
    }

    public final void n(Context context, DownloadBean bean, int i11) {
        Intrinsics.g(context, "context");
        Intrinsics.g(bean, "bean");
        boolean z11 = bean.getStatus() == 10;
        List<DownloadBean> seriesList = bean.getSeriesList();
        String resourceId = bean.getResourceId();
        if (resourceId == null) {
            resourceId = bean.getUrl();
        }
        p(context, z11, seriesList, resourceId, bean.getPath(), bean.isSeries(), i11);
    }

    public final void o(Context context, String resourceId, String str, boolean z11, int i11) {
        Intrinsics.g(context, "context");
        Intrinsics.g(resourceId, "resourceId");
        p(context, false, null, resourceId, str, z11, i11);
    }

    public final void p(Context context, boolean z11, List<DownloadBean> list, String str, String str2, boolean z12, int i11) {
        LocalVideoEvent localVideoEvent = new LocalVideoEvent(str, 0L, 0L, false, true, 14, null);
        AppScopeVMlProvider appScopeVMlProvider = AppScopeVMlProvider.INSTANCE;
        FlowEventBus flowEventBus = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
        String name = LocalVideoEvent.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.postEvent(name, localVideoEvent, 0L);
        f00.d dVar = new f00.d(true, false);
        FlowEventBus flowEventBus2 = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
        String name2 = f00.d.class.getName();
        Intrinsics.f(name2, "T::class.java.name");
        flowEventBus2.postEvent(name2, dVar, 0L);
        Context contextG = context;
        if (contextG instanceof Application) {
            contextG = RoomActivityLifecycleCallbacks.f51239a.g();
        }
        kotlinx.coroutines.j.d(l0.a(w0.c()), null, null, new LocalVideoNotExistUtil$showErrorDialog$1(contextG, z11, str, list, str2, z12, i11, null), 3, null);
    }
}
