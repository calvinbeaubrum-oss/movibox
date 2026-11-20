package com.transsion.search.fragment.group;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.d0;
import androidx.lifecycle.v0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.facade.Postcard;
import com.applovin.sdk.AppLovinEventTypes;
import com.blankj.utilcode.util.KeyboardUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mbridge.msdk.MBridgeConstans;
import com.tn.lib.widget.R$mipmap;
import com.tn.lib.widget.dialog.TRDialog;
import com.tn.lib.widget.dialog.TRDialogListener;
import com.transsion.baseui.R$color;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.publish.api.GroupBean;
import com.transsion.search.R$drawable;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.R$string;
import com.transsion.search.SearchManager;
import com.transsion.search.bean.Pager;
import com.transsion.search.bean.PagerEntity;
import com.transsion.search.bean.SearchGroupEntity;
import com.transsion.search.bean.SearchSubject;
import com.transsion.search.bean.SearchWorkEntity;
import com.transsion.search.dialog.CheckTipsDialog;
import com.transsion.search.viewmodel.SearchViewModel;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
public final class SearchUploadGroupFragment extends BaseFragment<bx.d> implements TRDialogListener {
    public static final a Companion = new a(null);
    private boolean isRefreshing;
    private dx.a mSearchGroupAdapter;
    private dx.b mSearchKeywordAdapter;
    private SearchViewModel mSearchViewModel;
    private yw.b mSearchWorkAdapter;
    private int mType;
    private GroupBean selectGroup;
    private List<String> mHistoryList = new ArrayList();
    private int page = 1;
    private int perPage = 10;
    private String mKeyword = "";
    private final Lazy mCheckTipsDialog$delegate = LazyKt__LazyJVMKt.b(new Function0<CheckTipsDialog>() { // from class: com.transsion.search.fragment.group.SearchUploadGroupFragment$mCheckTipsDialog$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final CheckTipsDialog invoke() {
            return CheckTipsDialog.f57442h.a();
        }
    });

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SearchUploadGroupFragment a(int i11) {
            SearchUploadGroupFragment searchUploadGroupFragment = new SearchUploadGroupFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("type", i11);
            searchUploadGroupFragment.setArguments(bundle);
            return searchUploadGroupFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements com.tn.lib.util.networkinfo.g {
        public b() {
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onConnected() {
            com.tn.lib.util.networkinfo.g.a.a(this);
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
            h9.f fVarQ;
            h9.f fVarQ2;
            List<GroupBean> listD;
            List<SearchSubject> listD2;
            Intrinsics.g(network, "network");
            Intrinsics.g(networkCapabilities, "networkCapabilities");
            yw.b bVar = SearchUploadGroupFragment.this.mSearchWorkAdapter;
            if (bVar == null || (listD2 = bVar.D()) == null || !listD2.isEmpty()) {
                yw.b bVar2 = SearchUploadGroupFragment.this.mSearchWorkAdapter;
                if (bVar2 != null && (fVarQ = bVar2.Q()) != null) {
                    fVarQ.v();
                }
            } else {
                SearchUploadGroupFragment.this.searchJob();
            }
            dx.a aVar = SearchUploadGroupFragment.this.mSearchGroupAdapter;
            if (aVar != null && (listD = aVar.D()) != null && listD.isEmpty()) {
                SearchUploadGroupFragment.this.searchJob();
                return;
            }
            dx.a aVar2 = SearchUploadGroupFragment.this.mSearchGroupAdapter;
            if (aVar2 == null || (fVarQ2 = aVar2.Q()) == null) {
                return;
            }
            fVarQ2.v();
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onDisconnected() {
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements TextView.OnEditorActionListener {
        public c() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
            if (i11 != 0 && i11 != 3) {
                return false;
            }
            SearchUploadGroupFragment.this.mKeyword = String.valueOf(textView != null ? textView.getText() : null);
            SearchUploadGroupFragment.this.searchJob();
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class d implements cx.a {
        public d() {
        }

        @Override // cx.a
        public void a() {
            String groupId;
            SearchViewModel searchViewModel;
            GroupBean groupBean = SearchUploadGroupFragment.this.selectGroup;
            if (groupBean == null || (groupId = groupBean.getGroupId()) == null || (searchViewModel = SearchUploadGroupFragment.this.mSearchViewModel) == null) {
                return;
            }
            searchViewModel.s(groupId);
        }

        @Override // cx.a
        public void b() {
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class e extends RecyclerView.r {
        public e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
            FragmentActivity activity;
            bx.d mViewBinding;
            EditText editText;
            Intrinsics.g(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i11);
            if (i11 != 1 || (activity = SearchUploadGroupFragment.this.getActivity()) == null) {
                return;
            }
            SearchUploadGroupFragment searchUploadGroupFragment = SearchUploadGroupFragment.this;
            if (!KeyboardUtils.g(activity) || (mViewBinding = searchUploadGroupFragment.getMViewBinding()) == null || (editText = mViewBinding.f14461b) == null) {
                return;
            }
            KeyboardUtils.e(editText);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class f implements xw.a {
        public f() {
        }

        public static final void c(List list, SearchUploadGroupFragment this$0) {
            Intrinsics.g(list, "$list");
            Intrinsics.g(this$0, "this$0");
            List list2 = list;
            if (!(!list2.isEmpty())) {
                bx.d mViewBinding = this$0.getMViewBinding();
                RelativeLayout relativeLayout = mViewBinding != null ? mViewBinding.f14466h : null;
                if (relativeLayout == null) {
                    return;
                }
                relativeLayout.setVisibility(8);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(list2);
            kotlin.collections.m.U(arrayList);
            this$0.mHistoryList = arrayList;
            dx.b bVar = this$0.mSearchKeywordAdapter;
            if (bVar != null) {
                bVar.x0(arrayList);
            }
        }

        @Override // xw.a
        public void a(final List<String> list) {
            Intrinsics.g(list, "list");
            FragmentActivity activity = SearchUploadGroupFragment.this.getActivity();
            if (activity != null) {
                final SearchUploadGroupFragment searchUploadGroupFragment = SearchUploadGroupFragment.this;
                activity.runOnUiThread(new Runnable() { // from class: com.transsion.search.fragment.group.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        SearchUploadGroupFragment.f.c(list, searchUploadGroupFragment);
                    }
                });
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class g implements TextWatcher {
        public g() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            AppCompatImageView appCompatImageView;
            if (editable == null || editable.length() <= 0) {
                bx.d mViewBinding = SearchUploadGroupFragment.this.getMViewBinding();
                appCompatImageView = mViewBinding != null ? mViewBinding.f14463d : null;
                if (appCompatImageView != null) {
                    appCompatImageView.setVisibility(8);
                }
                SearchUploadGroupFragment.this.resetContent(true);
            } else {
                bx.d mViewBinding2 = SearchUploadGroupFragment.this.getMViewBinding();
                appCompatImageView = mViewBinding2 != null ? mViewBinding2.f14463d : null;
                if (appCompatImageView != null) {
                    appCompatImageView.setVisibility(0);
                }
            }
            SearchUploadGroupFragment.this.mKeyword = String.valueOf(editable);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            TextView textView;
            bx.d mViewBinding = SearchUploadGroupFragment.this.getMViewBinding();
            if (mViewBinding == null || (textView = mViewBinding.f14469k) == null) {
                return;
            }
            so.c.k(textView);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class h implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f57478a;

        public h(Function1 function) {
            Intrinsics.g(function, "function");
            this.f57478a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f57478a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof d0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.b(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.lifecycle.d0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f57478a.invoke(obj);
        }
    }

    private final void clearTipsDialog() {
        try {
            TRDialog.a aVar = new TRDialog.a();
            String string = getString(R$string.search_clear_title);
            Intrinsics.f(string, "getString(R.string.search_clear_title)");
            TRDialog.a aVarK = aVar.k(string);
            String string2 = getString(R$string.search_clear_des);
            Intrinsics.f(string2, "getString(R.string.search_clear_des)");
            TRDialog.a aVarG = aVarK.g(string2);
            String string3 = getString(R$string.search_clear_cancel);
            Intrinsics.f(string3, "getString(R.string.search_clear_cancel)");
            TRDialog.a aVarE = aVarG.e(string3);
            String string4 = getString(R$string.search_clear_clear);
            Intrinsics.f(string4, "getString(R.string.search_clear_clear)");
            aVarE.j(string4).h(R$drawable.btn_bg_dialog_edit_selector).c(R$drawable.btn_bg_dialog_edit_selector).i(com.blankj.utilcode.util.h.a(R$color.base_color_black)).f(this).a().m0(this, "clear_tips");
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View emptyView() {
        EditText editText;
        Editable text = null;
        View view = getLayoutInflater().inflate(R$layout.view_search_manager_empty, (ViewGroup) null);
        TextView textView = (TextView) view.findViewById(R$id.tv_empty_tips);
        ImageView imageView = (ImageView) view.findViewById(R$id.iv_tips);
        AppCompatTextView appCompatTextView = (AppCompatTextView) view.findViewById(R$id.tv_retry);
        if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
            bx.d mViewBinding = getMViewBinding();
            if (mViewBinding != null && (editText = mViewBinding.f14461b) != null) {
                text = editText.getText();
            }
            String strValueOf = String.valueOf(text);
            textView.setText(getString(R$string.user_works_empty) + " \"" + strValueOf + "\"");
            appCompatTextView.setVisibility(8);
            imageView.setImageResource(R$mipmap.ic_no_content);
        } else {
            textView.setText(com.transsion.baseui.R$string.base_net_err);
            imageView.setImageResource(R$mipmap.ic_no_network);
            appCompatTextView.setVisibility(0);
            appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search.fragment.group.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SearchUploadGroupFragment.emptyView$lambda$22(this.f57495a, view2);
                }
            });
        }
        Intrinsics.f(view, "view");
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void emptyView$lambda$22(SearchUploadGroupFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.searchJob();
    }

    private final CheckTipsDialog getMCheckTipsDialog() {
        return (CheckTipsDialog) this.mCheckTipsDialog$delegate.getValue();
    }

    @SuppressLint({"InflateParams"})
    private final void initViewModel() {
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.f(fragmentActivityRequireActivity, "requireActivity()");
        SearchViewModel searchViewModel = (SearchViewModel) new v0(fragmentActivityRequireActivity).a(SearchViewModel.class);
        searchViewModel.l().j(getViewLifecycleOwner(), new h(new Function1<SearchGroupEntity, Unit>() { // from class: com.transsion.search.fragment.group.SearchUploadGroupFragment$initViewModel$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SearchGroupEntity searchGroupEntity) {
                invoke2(searchGroupEntity);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SearchGroupEntity searchGroupEntity) {
                List<GroupBean> listD;
                RecyclerView recyclerView;
                ProgressBar progressBar;
                PagerEntity pager;
                PagerEntity pager2;
                String nextPage;
                Integer numL;
                PagerEntity pager3;
                List<GroupBean> items = searchGroupEntity != null ? searchGroupEntity.getItems() : null;
                boolean hasMore = (searchGroupEntity == null || (pager3 = searchGroupEntity.getPager()) == null) ? false : pager3.getHasMore();
                this.this$0.page = (searchGroupEntity == null || (pager2 = searchGroupEntity.getPager()) == null || (nextPage = pager2.getNextPage()) == null || (numL = kotlin.text.k.l(nextPage)) == null) ? 1 : numL.intValue();
                this.this$0.perPage = (searchGroupEntity == null || (pager = searchGroupEntity.getPager()) == null) ? 10 : pager.getPerPage();
                bx.d mViewBinding = this.this$0.getMViewBinding();
                if (mViewBinding != null && (progressBar = mViewBinding.f14465g) != null) {
                    so.c.g(progressBar);
                }
                dx.a aVar = this.this$0.mSearchGroupAdapter;
                if (aVar != null) {
                    SearchUploadGroupFragment searchUploadGroupFragment = this.this$0;
                    aVar.Q().r();
                    List<GroupBean> list = items;
                    if (list == null || list.isEmpty()) {
                        dx.a aVar2 = searchUploadGroupFragment.mSearchGroupAdapter;
                        if (aVar2 != null) {
                            aVar2.x0(new ArrayList());
                        }
                        aVar.r0(searchUploadGroupFragment.emptyView());
                        aVar.E0(true);
                    }
                    bx.d mViewBinding2 = searchUploadGroupFragment.getMViewBinding();
                    if (((mViewBinding2 == null || (recyclerView = mViewBinding2.f14467i) == null) ? null : recyclerView.getAdapter()) instanceof dx.b) {
                        bx.d mViewBinding3 = searchUploadGroupFragment.getMViewBinding();
                        RelativeLayout relativeLayout = mViewBinding3 != null ? mViewBinding3.f14466h : null;
                        if (relativeLayout != null) {
                            relativeLayout.setVisibility(8);
                        }
                        bx.d mViewBinding4 = searchUploadGroupFragment.getMViewBinding();
                        RecyclerView recyclerView2 = mViewBinding4 != null ? mViewBinding4.f14467i : null;
                        if (recyclerView2 != null) {
                            recyclerView2.setAdapter(searchUploadGroupFragment.mSearchGroupAdapter);
                        }
                    }
                    if (list != null && !list.isEmpty()) {
                        ArrayList arrayList = new ArrayList();
                        for (Object obj : items) {
                            GroupBean groupBean = (GroupBean) obj;
                            dx.a aVar3 = searchUploadGroupFragment.mSearchGroupAdapter;
                            if (aVar3 != null && (listD = aVar3.D()) != null && !listD.contains(groupBean)) {
                                arrayList.add(obj);
                            }
                        }
                        if (!(!arrayList.isEmpty())) {
                            aVar.Q().s(false);
                        } else if (searchUploadGroupFragment.isRefreshing) {
                            searchUploadGroupFragment.isRefreshing = false;
                            dx.a aVar4 = searchUploadGroupFragment.mSearchGroupAdapter;
                            if (aVar4 != null) {
                                aVar4.w0(arrayList);
                            }
                        } else {
                            dx.a aVar5 = searchUploadGroupFragment.mSearchGroupAdapter;
                            if (aVar5 != null) {
                                aVar5.m(arrayList);
                            }
                        }
                    }
                    if (!hasMore) {
                        aVar.Q().s(false);
                    }
                    if (searchGroupEntity == null) {
                        aVar.Q().u();
                    }
                }
            }
        }));
        searchViewModel.n().j(getViewLifecycleOwner(), new h(new Function1<SearchWorkEntity, Unit>() { // from class: com.transsion.search.fragment.group.SearchUploadGroupFragment$initViewModel$1$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SearchWorkEntity searchWorkEntity) {
                invoke2(searchWorkEntity);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SearchWorkEntity searchWorkEntity) {
                Pager pager;
                HashMap<String, String> mapG;
                RecyclerView recyclerView;
                List<SearchSubject> listD;
                ProgressBar progressBar;
                Pager pager2;
                Pager pager3;
                Pager pager4;
                List<SearchSubject> items = searchWorkEntity != null ? searchWorkEntity.getItems() : null;
                boolean hasMore = (searchWorkEntity == null || (pager4 = searchWorkEntity.getPager()) == null) ? false : pager4.getHasMore();
                this.this$0.page = (searchWorkEntity == null || (pager3 = searchWorkEntity.getPager()) == null) ? 1 : pager3.getNextPage();
                this.this$0.perPage = (searchWorkEntity == null || (pager2 = searchWorkEntity.getPager()) == null) ? 10 : pager2.getPerPage();
                bx.d mViewBinding = this.this$0.getMViewBinding();
                if (mViewBinding != null && (progressBar = mViewBinding.f14465g) != null) {
                    so.c.g(progressBar);
                }
                yw.b bVar = this.this$0.mSearchWorkAdapter;
                if (bVar != null) {
                    SearchUploadGroupFragment searchUploadGroupFragment = this.this$0;
                    bVar.Q().r();
                    yw.b bVar2 = searchUploadGroupFragment.mSearchWorkAdapter;
                    Boolean boolValueOf = (bVar2 == null || (listD = bVar2.D()) == null) ? null : Boolean.valueOf(listD.isEmpty());
                    List<SearchSubject> list = items;
                    if ((list == null || list.isEmpty()) && Intrinsics.b(boolValueOf, Boolean.TRUE) && (searchUploadGroupFragment.page == 1 || (searchWorkEntity != null && (pager = searchWorkEntity.getPager()) != null && pager.getPage() == 1))) {
                        yw.b bVar3 = searchUploadGroupFragment.mSearchWorkAdapter;
                        if (bVar3 != null) {
                            bVar3.x0(new ArrayList());
                        }
                        bVar.r0(searchUploadGroupFragment.emptyView());
                        bVar.E0(true);
                    }
                    bx.d mViewBinding2 = searchUploadGroupFragment.getMViewBinding();
                    if (((mViewBinding2 == null || (recyclerView = mViewBinding2.f14467i) == null) ? null : recyclerView.getAdapter()) instanceof dx.b) {
                        bx.d mViewBinding3 = searchUploadGroupFragment.getMViewBinding();
                        RelativeLayout relativeLayout = mViewBinding3 != null ? mViewBinding3.f14466h : null;
                        if (relativeLayout != null) {
                            relativeLayout.setVisibility(8);
                        }
                        bx.d mViewBinding4 = searchUploadGroupFragment.getMViewBinding();
                        RecyclerView recyclerView2 = mViewBinding4 != null ? mViewBinding4.f14467i : null;
                        if (recyclerView2 != null) {
                            recyclerView2.setAdapter(searchUploadGroupFragment.mSearchWorkAdapter);
                        }
                    }
                    if (list == null || list.isEmpty()) {
                        bVar.Q().s(false);
                    } else {
                        if (searchUploadGroupFragment.isRefreshing) {
                            searchUploadGroupFragment.isRefreshing = false;
                            yw.b bVar4 = searchUploadGroupFragment.mSearchWorkAdapter;
                            if (bVar4 != null) {
                                bVar4.w0(list);
                            }
                        } else {
                            yw.b bVar5 = searchUploadGroupFragment.mSearchWorkAdapter;
                            if (bVar5 != null) {
                                bVar5.m(list);
                            }
                        }
                        com.transsion.baselib.report.h logViewConfig = searchUploadGroupFragment.getLogViewConfig();
                        if (logViewConfig != null) {
                            logViewConfig.j(true);
                        }
                        com.transsion.baselib.report.h logViewConfig2 = searchUploadGroupFragment.getLogViewConfig();
                        if (logViewConfig2 != null && (mapG = logViewConfig2.g()) != null) {
                            mapG.put("type", String.valueOf(searchUploadGroupFragment.mType));
                        }
                    }
                    if (!hasMore) {
                        bVar.Q().s(false);
                    }
                    if (searchWorkEntity == null) {
                        bVar.Q().u();
                    }
                }
            }
        }));
        searchViewModel.j().j(getViewLifecycleOwner(), new h(new Function1<String, Unit>() { // from class: com.transsion.search.fragment.group.SearchUploadGroupFragment$initViewModel$1$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                if (TextUtils.isEmpty(str) || this.this$0.selectGroup == null) {
                    return;
                }
                this.this$0.postFinsh();
                SearchUploadGroupFragment searchUploadGroupFragment = this.this$0;
                searchUploadGroupFragment.postGroup(searchUploadGroupFragment.selectGroup);
                FragmentActivity activity = this.this$0.getActivity();
                if (activity != null) {
                    activity.finish();
                }
            }
        }));
        this.mSearchViewModel = searchViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$10(SearchUploadGroupFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.clearTipsDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$13(SearchUploadGroupFragment this$0, BaseQuickAdapter adapter, View view, int i11) {
        EditText editText;
        EditText editText2;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        if (view.getId() == R$id.tv_keyword) {
            FragmentActivity activity = this$0.getActivity();
            if (activity != null) {
                KeyboardUtils.d(activity);
            }
            dx.b bVar = this$0.mSearchKeywordAdapter;
            this$0.mKeyword = String.valueOf(bVar != null ? bVar.getItem(i11) : null);
            bx.d mViewBinding = this$0.getMViewBinding();
            if (mViewBinding != null && (editText2 = mViewBinding.f14461b) != null) {
                editText2.setText(this$0.mKeyword);
            }
            int length = this$0.mKeyword.length();
            bx.d mViewBinding2 = this$0.getMViewBinding();
            if (mViewBinding2 != null && (editText = mViewBinding2.f14461b) != null) {
                editText.setSelection(length);
            }
            bx.d mViewBinding3 = this$0.getMViewBinding();
            ProgressBar progressBar = mViewBinding3 != null ? mViewBinding3.f14465g : null;
            if (progressBar != null) {
                progressBar.setVisibility(0);
            }
            int i12 = this$0.mType;
            if (i12 == 1 || i12 == 2 || i12 == 3) {
                this$0.page = 1;
                this$0.searchJob();
            }
            SearchManager.f57422f.a().e(this$0.mKeyword);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$14(SearchUploadGroupFragment this$0, View view) {
        TextView textView;
        Intrinsics.g(this$0, "this$0");
        bx.d mViewBinding = this$0.getMViewBinding();
        if (mViewBinding == null || (textView = mViewBinding.f14469k) == null) {
            return;
        }
        so.c.k(textView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:26:0x0044  */
    /* JADX WARN: Code duplicated, block: B:34:0x005e  */
    /* JADX WARN: Code duplicated, block: B:37:0x0063  */
    /* JADX WARN: Code duplicated, block: B:40:0x006a  */
    public static final void onViewCreated$lambda$15(SearchUploadGroupFragment this$0, View view, boolean z11) {
        HashMap<String, String> mapG;
        yw.b bVar;
        List<SearchSubject> listD;
        RelativeLayout relativeLayout;
        dx.b bVar2;
        List<GroupBean> listD2;
        Intrinsics.g(this$0, "this$0");
        view.dispatchWindowFocusChanged(z11);
        if (z11) {
            int i11 = this$0.mType;
            if (i11 == 1) {
                bVar = this$0.mSearchWorkAdapter;
                if (bVar != null && (listD = bVar.D()) != null && listD.isEmpty()) {
                    bx.d mViewBinding = this$0.getMViewBinding();
                    relativeLayout = mViewBinding != null ? mViewBinding.f14466h : null;
                    if (relativeLayout != null) {
                        relativeLayout.setVisibility(0);
                    }
                    bVar2 = this$0.mSearchKeywordAdapter;
                    if (bVar2 != null) {
                        bVar2.x0(this$0.mHistoryList);
                    }
                }
            } else if (i11 == 2) {
                dx.a aVar = this$0.mSearchGroupAdapter;
                if (aVar != null && (listD2 = aVar.D()) != null && listD2.isEmpty()) {
                    bx.d mViewBinding2 = this$0.getMViewBinding();
                    relativeLayout = mViewBinding2 != null ? mViewBinding2.f14466h : null;
                    if (relativeLayout != null) {
                        relativeLayout.setVisibility(0);
                    }
                    dx.b bVar3 = this$0.mSearchKeywordAdapter;
                    if (bVar3 != null) {
                        bVar3.x0(this$0.mHistoryList);
                    }
                }
            } else if (i11 == 3) {
                bVar = this$0.mSearchWorkAdapter;
                if (bVar != null) {
                    bx.d mViewBinding3 = this$0.getMViewBinding();
                    if (mViewBinding3 != null) {
                    }
                    if (relativeLayout != null) {
                        relativeLayout.setVisibility(0);
                    }
                    bVar2 = this$0.mSearchKeywordAdapter;
                    if (bVar2 != null) {
                        bVar2.x0(this$0.mHistoryList);
                    }
                }
            }
        }
        String strJ = com.blankj.utilcode.util.n.j(this$0.mHistoryList);
        com.transsion.baselib.report.h logViewConfig = this$0.getLogViewConfig();
        if (logViewConfig == null || (mapG = logViewConfig.g()) == null) {
            return;
        }
        mapG.put("keyword", strJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$16(SearchUploadGroupFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.searchJob();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$17(SearchUploadGroupFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.resetContent(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$18(SearchUploadGroupFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.postFinsh();
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$4$lambda$1(final SearchUploadGroupFragment this$0) {
        RecyclerView recyclerView;
        Intrinsics.g(this$0, "this$0");
        if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
            SearchViewModel searchViewModel = this$0.mSearchViewModel;
            if (searchViewModel != null) {
                searchViewModel.u(this$0.page, this$0.perPage, this$0.mKeyword);
                return;
            }
            return;
        }
        zp.b.f82110a.d(com.tn.lib.widget.R$string.no_network_toast);
        bx.d mViewBinding = this$0.getMViewBinding();
        if (mViewBinding == null || (recyclerView = mViewBinding.f14467i) == null) {
            return;
        }
        recyclerView.postDelayed(new Runnable() { // from class: com.transsion.search.fragment.group.e
            @Override // java.lang.Runnable
            public final void run() {
                SearchUploadGroupFragment.onViewCreated$lambda$4$lambda$1$lambda$0(this.f57499a);
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$4$lambda$1$lambda$0(SearchUploadGroupFragment this$0) {
        h9.f fVarQ;
        Intrinsics.g(this$0, "this$0");
        yw.b bVar = this$0.mSearchWorkAdapter;
        if (bVar == null || (fVarQ = bVar.Q()) == null) {
            return;
        }
        fVarQ.u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$4$lambda$3(SearchUploadGroupFragment this$0, yw.b this_apply, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        List<SearchSubject> listD;
        SearchSubject searchSubject;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(this_apply, "$this_apply");
        Intrinsics.g(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.g(view, "view");
        yw.b bVar = this$0.mSearchWorkAdapter;
        if (bVar == null || (listD = bVar.D()) == null || (searchSubject = listD.get(i11)) == null) {
            return;
        }
        this$0.reportClick("", searchSubject.getSubjectId(), searchSubject.getOps(), i11);
        if (this$0.mType == 3) {
            Integer subjectType = searchSubject.getSubjectType();
            int value = SubjectType.SHORT_TV.getValue();
            if (subjectType == null || subjectType.intValue() != value) {
                Postcard postcardB = com.alibaba.android.arouter.launcher.a.d().b("/movie/detail");
                Integer subjectType2 = searchSubject.getSubjectType();
                postcardB.withInt("subject_type", subjectType2 != null ? subjectType2.intValue() : SubjectType.MOVIE.getValue()).withString("id", searchSubject.getSubjectId()).withString("ops", searchSubject.getOps()).navigation();
                return;
            } else {
                DownloadManagerApi downloadManagerApiA = DownloadManagerApi.f60274j.a();
                Context context = this_apply.getContext();
                Intrinsics.e(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                downloadManagerApiA.a2((FragmentActivity) context, "searchpage", (384 & 4) != 0 ? "" : "", searchSubject.getOps(), (384 & 16) != 0 ? null : "download_subject", (384 & 32) != 0 ? false : false, (384 & 64) != 0 ? null : searchSubject, (384 & 128) != 0 ? null : null, (384 & 256) != 0 ? Boolean.FALSE : null);
                return;
            }
        }
        cw.a aVar = new cw.a();
        aVar.o(3);
        aVar.n(1);
        aVar.s(searchSubject);
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = cw.a.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.postEvent(name, aVar, 0L);
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$9$lambda$6(final SearchUploadGroupFragment this$0) {
        RecyclerView recyclerView;
        Intrinsics.g(this$0, "this$0");
        if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
            SearchViewModel searchViewModel = this$0.mSearchViewModel;
            if (searchViewModel != null) {
                searchViewModel.t(this$0.page, this$0.perPage, this$0.mKeyword);
                return;
            }
            return;
        }
        zp.b.f82110a.d(com.tn.lib.widget.R$string.no_network_toast);
        bx.d mViewBinding = this$0.getMViewBinding();
        if (mViewBinding == null || (recyclerView = mViewBinding.f14467i) == null) {
            return;
        }
        recyclerView.postDelayed(new Runnable() { // from class: com.transsion.search.fragment.group.f
            @Override // java.lang.Runnable
            public final void run() {
                SearchUploadGroupFragment.onViewCreated$lambda$9$lambda$6$lambda$5(this.f57500a);
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$9$lambda$6$lambda$5(SearchUploadGroupFragment this$0) {
        h9.f fVarQ;
        Intrinsics.g(this$0, "this$0");
        yw.b bVar = this$0.mSearchWorkAdapter;
        if (bVar == null || (fVarQ = bVar.Q()) == null) {
            return;
        }
        fVarQ.u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$9$lambda$8(SearchUploadGroupFragment this$0, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        List<GroupBean> listD;
        GroupBean groupBean;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.g(view, "view");
        dx.a aVar = this$0.mSearchGroupAdapter;
        if (aVar == null || (listD = aVar.D()) == null || (groupBean = listD.get(i11)) == null) {
            return;
        }
        this$0.selectGroup = groupBean;
        this$0.reportClick(groupBean.getGroupId(), "", groupBean.getOps(), i11);
        this$0.postFinsh();
        this$0.postGroup(this$0.selectGroup);
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void postFinsh() {
        ax.a aVar = new ax.a();
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = ax.a.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.postEvent(name, aVar, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void postGroup(GroupBean groupBean) {
        cw.a aVar = new cw.a();
        aVar.o(6);
        aVar.n(1);
        aVar.m(groupBean);
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = cw.a.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.postEvent(name, aVar, 0L);
    }

    private final void reportClick(String str, String str2, String str3, int i11) {
        HashMap map = new HashMap();
        if (str == null) {
            str = "";
        }
        map.put("group_id", str);
        if (str2 == null) {
            str2 = "";
        }
        map.put("subject_id", str2);
        map.put("sequence", String.valueOf(i11));
        if (str3 == null) {
            str3 = "";
        }
        map.put("ops", str3);
        com.transsion.baselib.helper.a.f51183a.e("searchresult", map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:22:0x0037  */
    /* JADX WARN: Code duplicated, block: B:24:0x003b  */
    /* JADX WARN: Code duplicated, block: B:27:0x0047  */
    /* JADX WARN: Code duplicated, block: B:30:0x0067  */
    /* JADX WARN: Code duplicated, block: B:33:0x0073  */
    /* JADX WARN: Code duplicated, block: B:34:0x0076  */
    /* JADX WARN: Code duplicated, block: B:37:0x007a  */
    /* JADX WARN: Code duplicated, block: B:40:0x0086  */
    /* JADX WARN: Code duplicated, block: B:42:0x008e  */
    /* JADX WARN: Code duplicated, block: B:45:0x0093  */
    /* JADX WARN: Code duplicated, block: B:46:0x0098  */
    /* JADX WARN: Code duplicated, block: B:48:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a5  */
    public final void resetContent(boolean z11) {
        yw.b bVar;
        yw.b bVar2;
        ArrayList arrayList;
        dx.b bVar3;
        bx.d mViewBinding;
        RecyclerView recyclerView;
        RelativeLayout relativeLayout;
        EditText editText;
        EditText editText2;
        if (!z11) {
            bx.d mViewBinding2 = getMViewBinding();
            if (mViewBinding2 != null && (editText2 = mViewBinding2.f14461b) != null) {
                editText2.setText("");
            }
            this.mKeyword = "";
        }
        int i11 = this.mType;
        if (i11 == 1) {
            bVar = this.mSearchWorkAdapter;
            if (bVar != null) {
                bVar.x0(new ArrayList());
            }
            bVar2 = this.mSearchWorkAdapter;
            if (bVar2 != null) {
                bVar2.l0();
            }
            arrayList = new ArrayList();
            arrayList.addAll(SearchManager.f57422f.a().j());
            kotlin.collections.m.U(arrayList);
            this.mHistoryList = arrayList;
            bVar3 = this.mSearchKeywordAdapter;
            if (bVar3 != null) {
                bVar3.x0(arrayList);
            }
            mViewBinding = getMViewBinding();
            if (mViewBinding != null) {
                recyclerView = mViewBinding.f14467i;
            } else {
                recyclerView = null;
            }
            if (recyclerView != null) {
                recyclerView.setAdapter(this.mSearchKeywordAdapter);
            }
            if (!arrayList.isEmpty()) {
                bx.d mViewBinding3 = getMViewBinding();
                relativeLayout = mViewBinding3 != null ? mViewBinding3.f14466h : null;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(0);
                }
            } else {
                bx.d mViewBinding4 = getMViewBinding();
                relativeLayout = mViewBinding4 != null ? mViewBinding4.f14466h : null;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(8);
                }
            }
        } else if (i11 == 2) {
            dx.a aVar = this.mSearchGroupAdapter;
            if (aVar != null) {
                aVar.x0(new ArrayList());
            }
            yw.b bVar4 = this.mSearchWorkAdapter;
            if (bVar4 != null) {
                bVar4.l0();
            }
        } else if (i11 == 3) {
            bVar = this.mSearchWorkAdapter;
            if (bVar != null) {
                bVar.x0(new ArrayList());
            }
            bVar2 = this.mSearchWorkAdapter;
            if (bVar2 != null) {
                bVar2.l0();
            }
            arrayList = new ArrayList();
            arrayList.addAll(SearchManager.f57422f.a().j());
            kotlin.collections.m.U(arrayList);
            this.mHistoryList = arrayList;
            bVar3 = this.mSearchKeywordAdapter;
            if (bVar3 != null) {
                bVar3.x0(arrayList);
            }
            mViewBinding = getMViewBinding();
            if (mViewBinding != null) {
                recyclerView = mViewBinding.f14467i;
            } else {
                recyclerView = null;
            }
            if (recyclerView != null) {
                recyclerView.setAdapter(this.mSearchKeywordAdapter);
            }
            if (!arrayList.isEmpty()) {
                bx.d mViewBinding5 = getMViewBinding();
                if (mViewBinding5 != null) {
                }
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(0);
                }
            } else {
                bx.d mViewBinding6 = getMViewBinding();
                if (mViewBinding6 != null) {
                }
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(8);
                }
            }
        }
        bx.d mViewBinding7 = getMViewBinding();
        if (mViewBinding7 == null || (editText = mViewBinding7.f14461b) == null) {
            return;
        }
        KeyboardUtils.i(editText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:51:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:53:0x00ca  */
    public final void searchJob() {
        SearchViewModel searchViewModel;
        TextView textView;
        ProgressBar progressBar;
        if (TextUtils.isEmpty(this.mKeyword)) {
            if (this.mType == 2) {
                com.tn.lib.widget.toast.core.h hVar = com.tn.lib.widget.toast.core.h.f50034a;
                hVar.e(16);
                hVar.l(getString(R$string.tips_room));
                return;
            } else {
                com.tn.lib.widget.toast.core.h hVar2 = com.tn.lib.widget.toast.core.h.f50034a;
                hVar2.e(16);
                hVar2.l(getString(R$string.tips_movie));
                return;
            }
        }
        this.isRefreshing = true;
        SearchManager.f57422f.a().e(this.mKeyword);
        bx.d mViewBinding = getMViewBinding();
        EditText editText = mViewBinding != null ? mViewBinding.f14461b : null;
        Intrinsics.d(editText);
        KeyboardUtils.e(editText);
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            int i11 = this.mType;
            if (i11 != 1) {
                if (i11 == 2) {
                    dx.a aVar = this.mSearchGroupAdapter;
                    if (aVar != null) {
                        aVar.r0(emptyView());
                    }
                    dx.a aVar2 = this.mSearchGroupAdapter;
                    if (aVar2 != null) {
                        aVar2.x0(new ArrayList());
                        return;
                    }
                    return;
                }
                if (i11 != 3) {
                    return;
                }
            }
            yw.b bVar = this.mSearchWorkAdapter;
            if (bVar != null) {
                bVar.r0(emptyView());
            }
            yw.b bVar2 = this.mSearchWorkAdapter;
            if (bVar2 != null) {
                bVar2.x0(new ArrayList());
                return;
            }
            return;
        }
        bx.d mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (progressBar = mViewBinding2.f14465g) != null) {
            so.c.k(progressBar);
        }
        bx.d mViewBinding3 = getMViewBinding();
        if (mViewBinding3 != null && (textView = mViewBinding3.f14469k) != null) {
            so.c.g(textView);
        }
        int i12 = this.mType;
        if (i12 == 1) {
            this.page = 1;
            searchViewModel = this.mSearchViewModel;
            if (searchViewModel != null) {
                searchViewModel.u(1, this.perPage, this.mKeyword);
            }
        } else if (i12 == 2) {
            this.page = 1;
            SearchViewModel searchViewModel2 = this.mSearchViewModel;
            if (searchViewModel2 != null) {
                searchViewModel2.t(1, this.perPage, this.mKeyword);
            }
        } else if (i12 == 3) {
            this.page = 1;
            searchViewModel = this.mSearchViewModel;
            if (searchViewModel != null) {
                searchViewModel.u(1, this.perPage, this.mKeyword);
            }
        }
        HashMap map = new HashMap();
        map.put("module_name", AppLovinEventTypes.USER_EXECUTED_SEARCH);
        map.put(MBridgeConstans.KEY_WORD, this.mKeyword);
        map.put("type", String.valueOf(this.mType));
        com.transsion.baselib.helper.a.f51183a.e("searchpage", map);
    }

    private final void showCheckDialog() {
        getMCheckTipsDialog().k0(this, "mCheckTipsDialog");
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public bx.d getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        bx.d dVarC = bx.d.c(inflater);
        Intrinsics.f(dVarC, "inflate(inflater)");
        return dVarC;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        setNetListener(new b());
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h("searchpage", false, 2, null);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        ProgressBar progressBar;
        bx.d mViewBinding = getMViewBinding();
        if (mViewBinding != null && (progressBar = mViewBinding.f14465g) != null) {
            so.c.g(progressBar);
        }
        super.onDestroyView();
    }

    @Override // com.tn.lib.widget.dialog.TRDialogListener
    public void onLeftButtonClick(TRDialog dialog) {
        Intrinsics.g(dialog, "dialog");
    }

    @Override // com.tn.lib.widget.dialog.TRDialogListener
    public void onRightButtonClick(TRDialog dialog) {
        Intrinsics.g(dialog, "dialog");
        if (TextUtils.equals(dialog.getTag(), "clear_tips")) {
            SearchManager.f57422f.a().h();
            bx.d mViewBinding = getMViewBinding();
            RelativeLayout relativeLayout = mViewBinding != null ? mViewBinding.f14466h : null;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            dx.b bVar = this.mSearchKeywordAdapter;
            if (bVar != null) {
                bVar.x0(new ArrayList());
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0071  */
    /* JADX WARN: Code duplicated, block: B:29:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:30:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:33:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:36:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:37:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:40:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:47:0x00db  */
    /* JADX WARN: Code duplicated, block: B:48:0x00e0  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        bx.d mViewBinding;
        RecyclerView recyclerView;
        bx.d mViewBinding2;
        RecyclerView recyclerView2;
        bx.d mViewBinding3;
        RecyclerView recyclerView3;
        yw.b bVar;
        h9.f fVarQ;
        RecyclerView recyclerView4;
        EditText editText;
        EditText editText2;
        ImageView imageView;
        ProgressBar progressBar;
        AppCompatImageView appCompatImageView;
        EditText editText3;
        EditText editText4;
        TextView textView;
        EditText editText5;
        EditText editText6;
        TextView textView2;
        RecyclerView recyclerView5;
        EditText editText7;
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        int i11 = 1;
        int i12 = arguments != null ? arguments.getInt("type") : 1;
        this.mType = i12;
        int i13 = 0;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        if (i12 == 1) {
            Context contextRequireContext = requireContext();
            Intrinsics.f(contextRequireContext, "requireContext()");
            final yw.b bVar2 = new yw.b(contextRequireContext, new ArrayList());
            bVar2.Q().C(new f9.f() { // from class: com.transsion.search.fragment.group.g
                @Override // f9.f
                public final void a() {
                    SearchUploadGroupFragment.onViewCreated$lambda$4$lambda$1(this.f57501a);
                }
            });
            bVar2.B0(new f9.d() { // from class: com.transsion.search.fragment.group.i
                @Override // f9.d
                public final void a(BaseQuickAdapter baseQuickAdapter, View view2, int i14) {
                    SearchUploadGroupFragment.onViewCreated$lambda$4$lambda$3(this.f57503a, bVar2, baseQuickAdapter, view2, i14);
                }
            });
            this.mSearchWorkAdapter = bVar2;
            mViewBinding = getMViewBinding();
            if (mViewBinding != null) {
                recyclerView = mViewBinding.f14467i;
            } else {
                recyclerView = null;
            }
            if (recyclerView != null) {
                recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), 1, false));
            }
            mViewBinding2 = getMViewBinding();
            if (mViewBinding2 != null) {
                recyclerView2 = mViewBinding2.f14467i;
            } else {
                recyclerView2 = null;
            }
            if (recyclerView2 != null) {
                recyclerView2.setAdapter(this.mSearchWorkAdapter);
            }
            mViewBinding3 = getMViewBinding();
            if (mViewBinding3 != null && (recyclerView3 = mViewBinding3.f14467i) != null) {
                bVar = this.mSearchWorkAdapter;
                if (bVar != null) {
                    fVarQ = bVar.Q();
                } else {
                    fVarQ = null;
                }
                recyclerView3.addOnScrollListener(new hs.a(fVarQ));
            }
        } else if (i12 == 2) {
            bx.d mViewBinding4 = getMViewBinding();
            if (mViewBinding4 != null && (editText7 = mViewBinding4.f14461b) != null) {
                editText7.setHint(R$string.search_hint_input_group);
            }
            dx.a aVar = new dx.a(i13, i11, objArr == true ? 1 : 0);
            aVar.Q().C(new f9.f() { // from class: com.transsion.search.fragment.group.j
                @Override // f9.f
                public final void a() {
                    SearchUploadGroupFragment.onViewCreated$lambda$9$lambda$6(this.f57505a);
                }
            });
            aVar.B0(new f9.d() { // from class: com.transsion.search.fragment.group.k
                @Override // f9.d
                public final void a(BaseQuickAdapter baseQuickAdapter, View view2, int i14) {
                    SearchUploadGroupFragment.onViewCreated$lambda$9$lambda$8(this.f57506a, baseQuickAdapter, view2, i14);
                }
            });
            this.mSearchGroupAdapter = aVar;
            bx.d mViewBinding5 = getMViewBinding();
            if (mViewBinding5 != null && (recyclerView5 = mViewBinding5.f14467i) != null) {
                dx.a aVar2 = this.mSearchGroupAdapter;
                recyclerView5.addOnScrollListener(new hs.a(aVar2 != null ? aVar2.Q() : null));
            }
        } else if (i12 == 3) {
            Context contextRequireContext2 = requireContext();
            Intrinsics.f(contextRequireContext2, "requireContext()");
            final yw.b bVar3 = new yw.b(contextRequireContext2, new ArrayList());
            bVar3.Q().C(new f9.f() { // from class: com.transsion.search.fragment.group.g
                @Override // f9.f
                public final void a() {
                    SearchUploadGroupFragment.onViewCreated$lambda$4$lambda$1(this.f57501a);
                }
            });
            bVar3.B0(new f9.d() { // from class: com.transsion.search.fragment.group.i
                @Override // f9.d
                public final void a(BaseQuickAdapter baseQuickAdapter, View view2, int i14) {
                    SearchUploadGroupFragment.onViewCreated$lambda$4$lambda$3(this.f57503a, bVar3, baseQuickAdapter, view2, i14);
                }
            });
            this.mSearchWorkAdapter = bVar3;
            mViewBinding = getMViewBinding();
            if (mViewBinding != null) {
                recyclerView = mViewBinding.f14467i;
            } else {
                recyclerView = null;
            }
            if (recyclerView != null) {
                recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), 1, false));
            }
            mViewBinding2 = getMViewBinding();
            if (mViewBinding2 != null) {
                recyclerView2 = mViewBinding2.f14467i;
            } else {
                recyclerView2 = null;
            }
            if (recyclerView2 != null) {
                recyclerView2.setAdapter(this.mSearchWorkAdapter);
            }
            mViewBinding3 = getMViewBinding();
            if (mViewBinding3 != null) {
                bVar = this.mSearchWorkAdapter;
                if (bVar != null) {
                    fVarQ = bVar.Q();
                } else {
                    fVarQ = null;
                }
                recyclerView3.addOnScrollListener(new hs.a(fVarQ));
            }
        }
        bx.d mViewBinding6 = getMViewBinding();
        if (mViewBinding6 != null && (textView2 = mViewBinding6.f14468j) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search.fragment.group.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SearchUploadGroupFragment.onViewCreated$lambda$10(this.f57507a, view2);
                }
            });
        }
        dx.b bVar4 = new dx.b(i13, i11, objArr2 == true ? 1 : 0);
        this.mSearchKeywordAdapter = bVar4;
        bVar4.i(R$id.tv_keyword);
        dx.b bVar5 = this.mSearchKeywordAdapter;
        if (bVar5 != null) {
            bVar5.z0(new f9.b() { // from class: com.transsion.search.fragment.group.m
                @Override // f9.b
                public final void a(BaseQuickAdapter baseQuickAdapter, View view2, int i14) {
                    SearchUploadGroupFragment.onViewCreated$lambda$13(this.f57508a, baseQuickAdapter, view2, i14);
                }
            });
        }
        bx.d mViewBinding7 = getMViewBinding();
        RecyclerView recyclerView6 = mViewBinding7 != null ? mViewBinding7.f14467i : null;
        if (recyclerView6 != null) {
            recyclerView6.setLayoutManager(new LinearLayoutManager(requireContext(), 1, false));
        }
        bx.d mViewBinding8 = getMViewBinding();
        RecyclerView recyclerView7 = mViewBinding8 != null ? mViewBinding8.f14467i : null;
        if (recyclerView7 != null) {
            recyclerView7.setAdapter(this.mSearchKeywordAdapter);
        }
        SearchManager.f57422f.a().k(this.mType, new f());
        initViewModel();
        bx.d mViewBinding9 = getMViewBinding();
        if (mViewBinding9 != null && (editText6 = mViewBinding9.f14461b) != null) {
            editText6.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search.fragment.group.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SearchUploadGroupFragment.onViewCreated$lambda$14(this.f57509a, view2);
                }
            });
        }
        bx.d mViewBinding10 = getMViewBinding();
        if (mViewBinding10 != null && (editText5 = mViewBinding10.f14461b) != null) {
            editText5.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.transsion.search.fragment.group.b
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view2, boolean z11) {
                    SearchUploadGroupFragment.onViewCreated$lambda$15(this.f57496a, view2, z11);
                }
            });
        }
        bx.d mViewBinding11 = getMViewBinding();
        if (mViewBinding11 != null && (textView = mViewBinding11.f14469k) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search.fragment.group.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SearchUploadGroupFragment.onViewCreated$lambda$16(this.f57497a, view2);
                }
            });
        }
        bx.d mViewBinding12 = getMViewBinding();
        if (mViewBinding12 != null && (editText4 = mViewBinding12.f14461b) != null) {
            editText4.addTextChangedListener(new g());
        }
        bx.d mViewBinding13 = getMViewBinding();
        if (mViewBinding13 != null && (editText3 = mViewBinding13.f14461b) != null) {
            editText3.setOnEditorActionListener(new c());
        }
        bx.d mViewBinding14 = getMViewBinding();
        if (mViewBinding14 != null && (appCompatImageView = mViewBinding14.f14463d) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search.fragment.group.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SearchUploadGroupFragment.onViewCreated$lambda$17(this.f57498a, view2);
                }
            });
        }
        bx.d mViewBinding15 = getMViewBinding();
        if (mViewBinding15 != null && (progressBar = mViewBinding15.f14465g) != null) {
            so.c.g(progressBar);
        }
        getMCheckTipsDialog().r0(new d());
        bx.d mViewBinding16 = getMViewBinding();
        if (mViewBinding16 != null && (imageView = mViewBinding16.f14462c) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search.fragment.group.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SearchUploadGroupFragment.onViewCreated$lambda$18(this.f57502a, view2);
                }
            });
        }
        bx.d mViewBinding17 = getMViewBinding();
        if (mViewBinding17 != null && (editText2 = mViewBinding17.f14461b) != null) {
            editText2.requestFocus();
        }
        bx.d mViewBinding18 = getMViewBinding();
        if (mViewBinding18 != null && (editText = mViewBinding18.f14461b) != null) {
            KeyboardUtils.i(editText);
        }
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.j(true);
        }
        bx.d mViewBinding19 = getMViewBinding();
        if (mViewBinding19 == null || (recyclerView4 = mViewBinding19.f14467i) == null) {
            return;
        }
        recyclerView4.addOnScrollListener(new e());
    }
}
