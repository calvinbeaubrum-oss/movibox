package com.transsnet.downloader.fragment;

import android.app.Application;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tn.lib.view.TitleLayout;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.bean.HistoricalPlayRecordBean;
import com.transsnet.downloader.bean.HistoricalPlayRecordMultipleEntity;
import com.transsnet.downloader.dialog.DownloadConfirmDialog;
import com.transsnet.downloader.dialog.DownloadMoreDialog;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

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
@Deprecated
@Metadata
public final class TransferReceivedListFragment extends LocalFileBaseFragment {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final a f60869s = new a(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends RecyclerView.l {
        @Override // androidx.recyclerview.widget.RecyclerView.l
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.x state) {
            Intrinsics.g(outRect, "outRect");
            Intrinsics.g(view, "view");
            Intrinsics.g(parent, "parent");
            Intrinsics.g(state, "state");
            super.getItemOffsets(outRect, view, parent, state);
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            if (parent.getAdapter() == null || childAdapterPosition != 0) {
                return;
            }
            outRect.top = com.blankj.utilcode.util.f0.a(12.0f);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f60870a;

        public c(Function1 function) {
            Intrinsics.g(function, "function");
            this.f60870a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f60870a;
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
            this.f60870a.invoke(obj);
        }
    }

    public static final void H1(TransferReceivedListFragment this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        Object obj = adapter.D().get(i11);
        this$0.J1(obj instanceof HistoricalPlayRecordMultipleEntity ? (HistoricalPlayRecordMultipleEntity) obj : null);
    }

    public static final void I1(TransferReceivedListFragment this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        Object obj = adapter.D().get(i11);
        this$0.s1(obj instanceof HistoricalPlayRecordMultipleEntity ? (HistoricalPlayRecordMultipleEntity) obj : null, i11, 2);
    }

    public final void G1(HistoricalPlayRecordMultipleEntity historicalPlayRecordMultipleEntity, int i11) {
        kotlinx.coroutines.j.d(androidx.lifecycle.v.a(this), kotlinx.coroutines.w0.b(), null, new TransferReceivedListFragment$deleteItem$1(historicalPlayRecordMultipleEntity, this, null), 2, null);
    }

    public final void J1(HistoricalPlayRecordMultipleEntity historicalPlayRecordMultipleEntity) {
        HistoricalPlayRecordBean historical;
        DownloadBean video;
        HistoricalPlayRecordBean historical2;
        DownloadBean video2;
        HistoricalPlayRecordBean historical3;
        DownloadBean video3;
        HistoricalPlayRecordBean historical4;
        DownloadBean video4;
        HistoricalPlayRecordBean historical5;
        DownloadBean video5;
        HistoricalPlayRecordBean historical6;
        DownloadBean video6;
        HistoricalPlayRecordBean historical7;
        DownloadBean video7;
        HistoricalPlayRecordBean historical8;
        DownloadBean video8;
        String postId = null;
        Postcard postcardWithString = com.alibaba.android.arouter.launcher.a.d().b("/video/detail").withString("extra_local_path", (historicalPlayRecordMultipleEntity == null || (historical8 = historicalPlayRecordMultipleEntity.getHistorical()) == null || (video8 = historical8.getVideo()) == null) ? null : video8.getPath()).withString("extra_url", (historicalPlayRecordMultipleEntity == null || (historical7 = historicalPlayRecordMultipleEntity.getHistorical()) == null || (video7 = historical7.getVideo()) == null) ? null : video7.getUrl()).withString("extra_resource_id", (historicalPlayRecordMultipleEntity == null || (historical6 = historicalPlayRecordMultipleEntity.getHistorical()) == null || (video6 = historical6.getVideo()) == null) ? null : video6.getResourceId()).withString("extra_subject_id", (historicalPlayRecordMultipleEntity == null || (historical5 = historicalPlayRecordMultipleEntity.getHistorical()) == null || (video5 = historical5.getVideo()) == null) ? null : video5.getSubjectId()).withString("extra_name", (historicalPlayRecordMultipleEntity == null || (historical4 = historicalPlayRecordMultipleEntity.getHistorical()) == null || (video4 = historical4.getVideo()) == null) ? null : video4.getName());
        if (historicalPlayRecordMultipleEntity != null && (historical3 = historicalPlayRecordMultipleEntity.getHistorical()) != null && (video3 = historical3.getVideo()) != null) {
            postId = video3.getPostId();
        }
        Postcard postcardWithString2 = postcardWithString.withString("extra_post_id", postId).withString("extra_page_from", getPageName());
        int videoWidth = 0;
        Postcard postcardWithInt = postcardWithString2.withInt("extra_height", (historicalPlayRecordMultipleEntity == null || (historical2 = historicalPlayRecordMultipleEntity.getHistorical()) == null || (video2 = historical2.getVideo()) == null) ? 0 : video2.getVideoHeight());
        if (historicalPlayRecordMultipleEntity != null && (historical = historicalPlayRecordMultipleEntity.getHistorical()) != null && (video = historical.getVideo()) != null) {
            videoWidth = video.getVideoWidth();
        }
        postcardWithInt.withInt("extra_width", videoWidth).navigation(getActivity());
    }

    public final void K1() {
        com.transsnet.downloader.adapter.a aVarG1 = g1();
        if (aVarG1 != null) {
            aVarG1.r0(l0(false));
        }
    }

    @Override // com.transsnet.downloader.fragment.AllHistoricalPlayRecordFragment
    public void e1() {
        h1().E();
    }

    @Override // com.transsnet.downloader.fragment.AllHistoricalPlayRecordFragment
    public String getPageName() {
        return "file_manager_tab_received";
    }

    @Override // com.transsnet.downloader.fragment.AllHistoricalPlayRecordFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        h1().F().j(this, new c(new Function1<List<HistoricalPlayRecordMultipleEntity>, Unit>() { // from class: com.transsnet.downloader.fragment.TransferReceivedListFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<HistoricalPlayRecordMultipleEntity> list) {
                invoke2(list);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<HistoricalPlayRecordMultipleEntity> list) {
                List<T> listD;
                SwipeRefreshLayout swipeRefreshLayout;
                h00.t mViewBinding = TransferReceivedListFragment.this.getMViewBinding();
                if (mViewBinding != null && (swipeRefreshLayout = mViewBinding.f66028c) != null && swipeRefreshLayout.isRefreshing()) {
                    h00.t mViewBinding2 = TransferReceivedListFragment.this.getMViewBinding();
                    SwipeRefreshLayout swipeRefreshLayout2 = mViewBinding2 != null ? mViewBinding2.f66028c : null;
                    if (swipeRefreshLayout2 != null) {
                        swipeRefreshLayout2.setRefreshing(false);
                    }
                }
                TransferReceivedListFragment.this.F0();
                List<HistoricalPlayRecordMultipleEntity> list2 = list;
                if (list2 != null && !list2.isEmpty()) {
                    com.transsnet.downloader.adapter.a aVarG1 = TransferReceivedListFragment.this.g1();
                    if (aVarG1 != null) {
                        aVarG1.w0(list2);
                        return;
                    }
                    return;
                }
                com.transsnet.downloader.adapter.a aVarG2 = TransferReceivedListFragment.this.g1();
                if (aVarG2 != null && (listD = aVarG2.D()) != 0) {
                    listD.clear();
                }
                com.transsnet.downloader.adapter.a aVarG3 = TransferReceivedListFragment.this.g1();
                if (aVarG3 != null) {
                    aVarG3.w0(list2);
                }
                TransferReceivedListFragment.this.K1();
            }
        }));
    }

    @Override // com.transsnet.downloader.fragment.AllHistoricalPlayRecordFragment, com.transsion.baseui.fragment.PageStatusFragment
    public String k0() {
        String string = getString(R$string.download_transfer_received_empty_tips);
        Intrinsics.f(string, "getString(R.string.downl…sfer_received_empty_tips)");
        return string;
    }

    @Override // com.transsnet.downloader.fragment.AllHistoricalPlayRecordFragment, com.transsion.baseui.fragment.PageStatusFragment
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h(getPageName(), false, 2, null);
    }

    @Override // com.transsnet.downloader.fragment.AllHistoricalPlayRecordFragment
    public boolean p1() {
        return true;
    }

    @Override // com.transsnet.downloader.fragment.AllHistoricalPlayRecordFragment
    public void s1(final HistoricalPlayRecordMultipleEntity historicalPlayRecordMultipleEntity, int i11, final int i12) {
        DownloadMoreDialog downloadMoreDialogA = DownloadMoreDialog.f60517i.a(kotlin.collections.g.q(new Pair(Utils.a().getString(R$string.download_transfer_tips), "transfer_file_2_mb"), new Pair(Utils.a().getString(R$string.delete), RequestParameters.SUBRESOURCE_DELETE)));
        downloadMoreDialogA.s0(new Function3<Integer, String, String, Unit>() { // from class: com.transsnet.downloader.fragment.TransferReceivedListFragment$onItemMoreClick$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, String str2) {
                invoke(num.intValue(), str, str2);
                return Unit.f68710a;
            }

            public final void invoke(final int i13, String str, String str2) {
                HistoricalPlayRecordBean historical;
                DownloadBean video;
                Intrinsics.g(str, "<anonymous parameter 1>");
                if (Intrinsics.b(str2, "transfer_file_2_mb")) {
                    this.this$0.f1().k().q(1);
                    this.this$0.f1().F().q(Integer.valueOf(i12));
                    return;
                }
                if (Intrinsics.b(str2, RequestParameters.SUBRESOURCE_DELETE)) {
                    DownloadConfirmDialog.a aVar = DownloadConfirmDialog.f60505j;
                    String string = Utils.a().getString(R$string.cancel);
                    String string2 = Utils.a().getString(R$string.delete);
                    Application applicationA = Utils.a();
                    int i14 = R$string.download_delete_tips;
                    Object[] objArr = new Object[1];
                    HistoricalPlayRecordMultipleEntity historicalPlayRecordMultipleEntity2 = historicalPlayRecordMultipleEntity;
                    objArr[0] = (historicalPlayRecordMultipleEntity2 == null || (historical = historicalPlayRecordMultipleEntity2.getHistorical()) == null || (video = historical.getVideo()) == null) ? null : video.getFileName();
                    DownloadConfirmDialog downloadConfirmDialogA = aVar.a(string, string2, applicationA.getString(i14, objArr), null);
                    final TransferReceivedListFragment transferReceivedListFragment = this.this$0;
                    final HistoricalPlayRecordMultipleEntity historicalPlayRecordMultipleEntity3 = historicalPlayRecordMultipleEntity;
                    downloadConfirmDialogA.r0(new Function1<Boolean, Unit>() { // from class: com.transsnet.downloader.fragment.TransferReceivedListFragment$onItemMoreClick$1$1$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.f68710a;
                        }

                        public final void invoke(boolean z11) {
                            if (z11) {
                                transferReceivedListFragment.G1(historicalPlayRecordMultipleEntity3, i13);
                            }
                        }
                    });
                    downloadConfirmDialogA.k0(transferReceivedListFragment, "confirm_Dialog");
                }
            }
        });
        downloadMoreDialogA.k0(this, "DownloadMoreDialog");
    }

    @Override // com.transsnet.downloader.fragment.LocalFileBaseFragment, com.transsnet.downloader.fragment.AllHistoricalPlayRecordFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        RecyclerView recyclerView;
        h00.t mViewBinding = getMViewBinding();
        TitleLayout titleLayout = mViewBinding != null ? mViewBinding.f66029d : null;
        if (titleLayout != null) {
            titleLayout.setVisibility(8);
        }
        com.transsnet.downloader.adapter.a aVarG1 = g1();
        h9.f fVarQ = aVarG1 != null ? aVarG1.Q() : null;
        if (fVarQ != null) {
            fVarQ.y(false);
        }
        h00.t mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (recyclerView = mViewBinding2.f66027b) == null) {
            return;
        }
        recyclerView.setLayoutManager(new NpaLinearLayoutManager(requireContext()));
        com.transsnet.downloader.adapter.a aVar = new com.transsnet.downloader.adapter.a(p1());
        aVar.B0(new f9.d() { // from class: com.transsnet.downloader.fragment.x1
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                TransferReceivedListFragment.H1(this.f60980a, baseQuickAdapter, view, i11);
            }
        });
        aVar.i(R$id.ivTopRightCornerPoint);
        aVar.z0(new f9.b() { // from class: com.transsnet.downloader.fragment.y1
            @Override // f9.b
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                TransferReceivedListFragment.I1(this.f60983a, baseQuickAdapter, view, i11);
            }
        });
        u1(aVar);
        recyclerView.setAdapter(g1());
        recyclerView.addItemDecoration(new b());
    }
}
