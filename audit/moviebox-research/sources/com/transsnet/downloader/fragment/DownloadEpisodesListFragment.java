package com.transsnet.downloader.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.blankj.utilcode.util.Utils;
import com.tn.lib.widget.R$string;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.api.DownloadPageType;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
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
@SourceDebugExtension
public final class DownloadEpisodesListFragment extends DownloadedBaseFragment {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final a f60636w = new a(null);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f60637u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f60638v = -1;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DownloadEpisodesListFragment a(String str, int i11) {
            DownloadEpisodesListFragment downloadEpisodesListFragment = new DownloadEpisodesListFragment();
            downloadEpisodesListFragment.setArguments(androidx.core.os.c.b(TuplesKt.a("extra_subject_id", str), TuplesKt.a("extra_parent_position", Integer.valueOf(i11))));
            return downloadEpisodesListFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f60639a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f60639a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f60639a;
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
            this.f60639a.invoke(obj);
        }
    }

    public final void A1() {
        Function1<f00.a, Unit> function1 = new Function1<f00.a, Unit>() { // from class: com.transsnet.downloader.fragment.DownloadEpisodesListFragment$initDeleteObserve$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(f00.a aVar) {
                invoke2(aVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(f00.a it) {
                Intrinsics.g(it, "it");
                try {
                    this.this$0.W0().t(this.this$0.f60637u);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = f00.a.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.observeEvent(this, name, Lifecycle.State.CREATED, kotlinx.coroutines.w0.c().q(), false, function1);
    }

    public final void B1() {
        List<DownloadBean> listD;
        com.transsnet.downloader.adapter.g gVarV0 = V0();
        DownloadBean downloadBean = null;
        Object obj = null;
        downloadBean = null;
        List<DownloadBean> listD2 = gVarV0 != null ? gVarV0.D() : null;
        if (listD2 == null || listD2.isEmpty()) {
            return;
        }
        com.transsnet.downloader.adapter.g gVarV1 = V0();
        if (gVarV1 != null && (listD = gVarV1.D()) != null) {
            for (Object obj2 : listD) {
                if (((DownloadBean) obj2).getStatus() <= 7) {
                    obj = obj2;
                    break;
                }
            }
            downloadBean = (DownloadBean) obj;
        }
        if (downloadBean == null) {
            zp.b.f82110a.e(Utils.a().getString(R$string.no_error_content));
            return;
        }
        Subject subject = new Subject(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, null, null, null, null, null, false, false, null, null, 0, false, false, 0L, null, null, 0L, null, 0, false, null, 0, null, null, null, null, null, null, null, -1, 4194303, null);
        subject.setSubjectId(downloadBean.getSubjectId());
        subject.setOps(downloadBean.getOps());
        subject.setTitle(downloadBean.getSubjectName());
        subject.setSubjectType(Integer.valueOf(DownloadBean.Companion.a(Integer.valueOf(downloadBean.getType()))));
        if (downloadBean.isShotTV()) {
            DownloadManagerApi downloadManagerApiA = DownloadManagerApi.f60274j.a();
            Context context = getContext();
            Intrinsics.e(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            downloadManagerApiA.a2((FragmentActivity) context, DownloadPageType.SERIES.getPageName(), (384 & 4) != 0 ? "" : "", subject.getOps(), (384 & 16) != 0 ? null : "download_subject", (384 & 32) != 0 ? false : true, (384 & 64) != 0 ? null : subject, (384 & 128) != 0 ? null : null, (384 & 256) != 0 ? Boolean.FALSE : null);
            return;
        }
        DownloadManagerApi downloadManagerApiA2 = DownloadManagerApi.f60274j.a();
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.f(fragmentActivityRequireActivity, "requireActivity()");
        String pageName = DownloadPageType.SERIES.getPageName();
        String groupId = downloadBean.getGroupId();
        String ops = downloadBean.getOps();
        String sourceUrl = downloadBean.getSourceUrl();
        if (sourceUrl == null) {
            sourceUrl = "";
        }
        downloadManagerApiA2.P1(fragmentActivityRequireActivity, subject, pageName, (960 & 8) != 0 ? "" : groupId, ops, sourceUrl, (960 & 64) != 0 ? "" : null, (960 & 128) != 0 ? null : null, (960 & 256) != 0 ? null : null, (960 & 512) != 0 ? false : false);
    }

    @Override // com.transsnet.downloader.fragment.DownloadedBaseFragment, com.transsnet.downloader.fragment.DownloadListBaseFragment
    public void T0(com.transsnet.downloader.adapter.g adapter) {
        Intrinsics.g(adapter, "adapter");
        super.T0(adapter);
        adapter.i(R$id.v_all_ep_btn);
    }

    @Override // com.transsnet.downloader.fragment.DownloadedBaseFragment, com.transsnet.downloader.fragment.DownloadListBaseFragment
    public void d1(com.transsnet.downloader.adapter.g adapter, View view, int i11) {
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        super.d1(adapter, view, i11);
        if (view.getId() == R$id.v_all_ep_btn) {
            B1();
        }
    }

    @Override // com.transsnet.downloader.fragment.DownloadListBaseFragment
    public String getPageName() {
        return DownloadPageType.SERIES.getPageName();
    }

    @Override // com.transsnet.downloader.fragment.DownloadedBaseFragment, com.transsnet.downloader.fragment.DownloadListBaseFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        super.initViewModel();
        W0().u().j(this, new b(new Function1<List<? extends DownloadBean>, Unit>() { // from class: com.transsnet.downloader.fragment.DownloadEpisodesListFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends DownloadBean> list) {
                invoke2(list);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends DownloadBean> list) {
                List<? extends DownloadBean> list2 = list;
                if (list2 == null || list2.isEmpty()) {
                    return;
                }
                DownloadEpisodesListFragment.this.g1(list);
            }
        }));
    }

    @Override // com.transsnet.downloader.fragment.DownloadedBaseFragment, com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.f60637u = arguments != null ? arguments.getString("extra_subject_id") : null;
        Bundle arguments2 = getArguments();
        this.f60638v = arguments2 != null ? arguments2.getInt("extra_parent_position") : -1;
        W0().t(this.f60637u);
        A1();
    }

    @Override // com.transsnet.downloader.fragment.DownloadedBaseFragment
    public int v1() {
        return this.f60638v;
    }
}
