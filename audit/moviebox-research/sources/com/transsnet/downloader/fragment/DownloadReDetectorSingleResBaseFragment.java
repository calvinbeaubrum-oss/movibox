package com.transsnet.downloader.fragment;

import android.os.Bundle;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.report.FirebaseAnalyticsManager;
import com.transsion.web.api.WebConstants;
import com.transsnet.downloader.core.thread.DownloadBaseRunnable;
import com.transsnet.downloader.manager.DownloadEsHelper;
import com.transsnet.downloader.manager.StartDownloadHelper;
import com.transsnet.downloader.viewmodel.DownloadListManager;
import com.transsnet.downloader.viewmodel.DownloadResourcesDetectorViewModel;
import java.util.HashMap;
import java.util.UUID;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import n6.a;

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
public abstract class DownloadReDetectorSingleResBaseFragment<T extends n6.a> extends DownloadReDetectorBaseFragment<T> {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public DownloadBean f60772v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f60773w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f60774x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f60775y = LazyKt__LazyJVMKt.b(new Function0<StartDownloadHelper>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorSingleResBaseFragment$startDownloadHelper$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final StartDownloadHelper invoke() {
            return new StartDownloadHelper();
        }
    });

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f60776a;

        public a(Function1 function) {
            Intrinsics.g(function, "function");
            this.f60776a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f60776a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof androidx.lifecycle.d0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.b(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.lifecycle.d0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f60776a.invoke(obj);
        }
    }

    private final void n1(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        HashMap map = new HashMap();
        map.put(WebConstants.PAGE_FROM, str2);
        map.put("subject_id", str3);
        map.put("post_id", str4);
        map.put("ops", str5);
        map.put("resource_id", str6);
        map.put("task_id", str7);
        map.put("module_name", this.f60774x);
        com.transsion.baselib.report.m mVar = com.transsion.baselib.report.m.f51277a;
        if (str == null) {
            str = "download_click";
        }
        mVar.m(str, "download_click", map);
        Bundle bundle = new Bundle();
        bundle.putString("resource_id", str6);
        bundle.putString("subject_id", str3);
        FirebaseAnalyticsManager.f51235a.n("download_click", bundle, getContext());
    }

    private final StartDownloadHelper p1() {
        return (StartDownloadHelper) this.f60775y.getValue();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        androidx.lifecycle.c0<DownloadBean> c0VarS;
        if (this.f60773w && (c0VarS = DownloadListManager.f61186m.a().s()) != null) {
            c0VarS.j(this, new a(new Function1<DownloadBean, Unit>(this) { // from class: com.transsnet.downloader.fragment.DownloadReDetectorSingleResBaseFragment.initViewModel.1
                final /* synthetic */ DownloadReDetectorSingleResBaseFragment<T> this$0;

                /* JADX INFO: renamed from: com.transsnet.downloader.fragment.DownloadReDetectorSingleResBaseFragment$initViewModel$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: source.java */
                @Metadata
                @DebugMetadata(c = "com.transsnet.downloader.fragment.DownloadReDetectorSingleResBaseFragment$initViewModel$1$1", f = "DownloadReDetectorSingleResBaseFragment.kt", l = {41}, m = "invokeSuspend")
                public static final class C06181 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
                    final /* synthetic */ DownloadBean $it;
                    int label;
                    final /* synthetic */ DownloadReDetectorSingleResBaseFragment<T> this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C06181(DownloadBean downloadBean, DownloadReDetectorSingleResBaseFragment<T> downloadReDetectorSingleResBaseFragment, Continuation<? super C06181> continuation) {
                        super(2, continuation);
                        this.$it = downloadBean;
                        this.this$0 = downloadReDetectorSingleResBaseFragment;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C06181(this.$it, this.this$0, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
                        return ((C06181) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        HashMap<String, String> mapG;
                        HashMap<String, String> mapG2;
                        HashMap<String, String> mapG3;
                        Object objE = kotlin.coroutines.intrinsics.a.e();
                        int i11 = this.label;
                        if (i11 == 0) {
                            ResultKt.b(obj);
                            DownloadEsHelper downloadEsHelperA = DownloadEsHelper.f60994m.a();
                            String resourceId = this.$it.getResourceId();
                            if (resourceId == null) {
                                resourceId = this.$it.getUrl();
                            }
                            this.label = 1;
                            obj = downloadEsHelperA.k(resourceId, this);
                            if (obj == objE) {
                                return objE;
                            }
                        } else {
                            if (i11 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.b(obj);
                        }
                        DownloadBean downloadBean = (DownloadBean) obj;
                        DownloadReDetectorSingleResBaseFragment<T> downloadReDetectorSingleResBaseFragment = this.this$0;
                        if (downloadBean != null) {
                            uo.b.a aVar = uo.b.f78622a;
                            String TAG = downloadReDetectorSingleResBaseFragment.X0();
                            Intrinsics.f(TAG, "TAG");
                            uo.b.a.f(aVar, TAG, "single， get download bean from database", false, 4, null);
                        } else {
                            uo.b.a aVar2 = uo.b.f78622a;
                            String TAG2 = downloadReDetectorSingleResBaseFragment.X0();
                            Intrinsics.f(TAG2, "TAG");
                            uo.b.a.f(aVar2, TAG2, "single， create download bean from observe", false, 4, null);
                            downloadBean = this.$it;
                        }
                        downloadReDetectorSingleResBaseFragment.q1(downloadBean);
                        DownloadBean downloadBeanO1 = this.this$0.o1();
                        if (downloadBeanO1 != null) {
                            DownloadReDetectorSingleResBaseFragment<T> downloadReDetectorSingleResBaseFragment2 = this.this$0;
                            uo.b.a aVar3 = uo.b.f78622a;
                            String TAG3 = downloadReDetectorSingleResBaseFragment2.X0();
                            Intrinsics.f(TAG3, "TAG");
                            uo.b.a.f(aVar3, TAG3, "single， add download task， " + downloadBeanO1, false, 4, null);
                            downloadReDetectorSingleResBaseFragment2.t1(downloadBeanO1);
                            downloadBeanO1.setCreateAt(System.currentTimeMillis());
                            downloadBeanO1.setUpdateTimeStamp(Boxing.e(System.currentTimeMillis()));
                            downloadBeanO1.setTaskId(UUID.randomUUID().toString());
                            com.transsion.baselib.report.h logViewConfig = downloadReDetectorSingleResBaseFragment2.getLogViewConfig();
                            if (logViewConfig != null && (mapG3 = logViewConfig.g()) != null) {
                                mapG3.put(WebConstants.PAGE_FROM, downloadBeanO1.getPageFrom());
                            }
                            com.transsion.baselib.report.h logViewConfig2 = downloadReDetectorSingleResBaseFragment2.getLogViewConfig();
                            if (logViewConfig2 != null && (mapG2 = logViewConfig2.g()) != null) {
                                mapG2.put("last_page_from", downloadBeanO1.getLastPageFrom());
                            }
                            com.transsion.baselib.report.h logViewConfig3 = downloadReDetectorSingleResBaseFragment2.getLogViewConfig();
                            if (logViewConfig3 != null && (mapG = logViewConfig3.g()) != null) {
                                mapG.put("ops", downloadBeanO1.getOps());
                            }
                        }
                        return Unit.f68710a;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DownloadBean downloadBean) {
                    invoke2(downloadBean);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(DownloadBean downloadBean) {
                    kotlinx.coroutines.j.d(androidx.lifecycle.v.a(this.this$0), null, null, new C06181(downloadBean, this.this$0, null), 3, null);
                }
            }));
        }
    }

    public final DownloadBean o1() {
        return this.f60772v;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        DownloadListManager.a aVar = DownloadListManager.f61186m;
        aVar.a().K(null);
        aVar.a().L(null);
        aVar.a().N(null);
    }

    public final void q1(DownloadBean downloadBean) {
        this.f60772v = downloadBean;
    }

    public final void r1(boolean z11) {
        this.f60773w = z11;
    }

    public final void s1(String str) {
        this.f60774x = str;
    }

    public void t1(DownloadBean item) {
        Intrinsics.g(item, "item");
    }

    public final void u1() {
        DownloadBean downloadBean;
        String strA;
        Long size;
        DownloadBean downloadBean2 = this.f60772v;
        if (a1((downloadBean2 == null || (size = downloadBean2.getSize()) == null) ? 0L : size.longValue()) || (downloadBean = this.f60772v) == null) {
            return;
        }
        uo.b.f78622a.n(DownloadBaseRunnable.TAG, new String[]{"单资源，下载点击，开始下载:subjectId = " + downloadBean.getSubjectId() + ", resourceId = " + downloadBean.getResourceId() + ", name = " + downloadBean.getTotalTitleName()}, true);
        n1(downloadBean.getPageFrom(), downloadBean.getLastPageFrom(), downloadBean.getSubjectId(), downloadBean.getPostId(), downloadBean.getOps(), downloadBean.getResourceId(), downloadBean.getTaskId());
        U0().p(downloadBean);
        p1().d(kotlin.collections.g.h(downloadBean));
        DownloadBean downloadBean3 = this.f60772v;
        if (downloadBean3 != null) {
            Long size2 = downloadBean3.getSize();
            if (size2 == null || (strA = tp.a.a(size2.longValue(), 1)) == null) {
                strA = "";
            }
            DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY0 = Y0();
            androidx.lifecycle.c0<com.transsnet.downloader.viewmodel.b> c0VarH = downloadResourcesDetectorViewModelY0 != null ? downloadResourcesDetectorViewModelY0.h() : null;
            if (c0VarH != null) {
                c0VarH.q(new com.transsnet.downloader.viewmodel.b(1, strA, downloadBean3, false));
            }
        }
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY1 = Y0();
        androidx.lifecycle.c0<Integer> c0VarO = downloadResourcesDetectorViewModelY1 != null ? downloadResourcesDetectorViewModelY1.o() : null;
        if (c0VarO == null) {
            return;
        }
        c0VarO.q(3);
    }
}
