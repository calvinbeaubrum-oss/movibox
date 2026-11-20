package com.transsion.member.history;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.d0;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.baseui.fragment.BaseListFragment;
import com.transsion.member.R$string;
import com.transsion.member.bean.Pager;
import com.transsion.member.bean.PointsHistoryData;
import com.transsion.member.bean.PointsHistoryItem;
import com.transsion.member.view.HistoryStateView;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class PointsHistoryFragment extends BaseListFragment<PointsHistoryItem> {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final a f53334r = new a(null);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f53335s = 8;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f53336p = FragmentViewModelLazyKt.a(this, Reflection.b(PointsHistoryViewModel.class), new Function0<x0>() { // from class: com.transsion.member.history.PointsHistoryFragment$special$$inlined$activityViewModels$default$1
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final x0 invoke() {
            x0 viewModelStore = this.requireActivity().getViewModelStore();
            Intrinsics.f(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsion.member.history.PointsHistoryFragment$special$$inlined$activityViewModels$default$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final v0.c invoke() {
            v0.c defaultViewModelProviderFactory = this.requireActivity().getDefaultViewModelProviderFactory();
            Intrinsics.f(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    });

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f53337q;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PointsHistoryFragment a() {
            return new PointsHistoryFragment();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f53338a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f53338a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f53338a;
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
            this.f53338a.invoke(obj);
        }
    }

    private final PointsHistoryViewModel y1() {
        return (PointsHistoryViewModel) this.f53336p.getValue();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
        lazyLoadData();
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public BaseQuickAdapter<PointsHistoryItem, BaseViewHolder> T0() {
        return new ou.b(0, 1, null);
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public View X0() {
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        HistoryStateView historyStateView = new HistoryStateView(contextRequireContext);
        String string = getString(R$string.points_history_empty);
        Intrinsics.f(string, "getString(R.string.points_history_empty)");
        historyStateView.showData(4, 1, false, "", string);
        String string2 = getString(R$string.points_history_earn);
        Intrinsics.f(string2, "getString(R.string.points_history_earn)");
        historyStateView.setReTryTxt(string2);
        historyStateView.retry(new Function0<Unit>() { // from class: com.transsion.member.history.PointsHistoryFragment$getRvEmptyView$1$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                com.alibaba.android.arouter.launcher.a.d().b("/member/MemberActivity").navigation();
            }
        });
        return historyStateView;
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public String Z0() {
        String string = getString(R$string.points_history_title);
        Intrinsics.f(string, "getString(R.string.points_history_title)");
        return string;
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public void i1() {
        lazyLoadData();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        b1();
        y1().d().j(this, new b(new Function1<PointsHistoryData, Unit>() { // from class: com.transsion.member.history.PointsHistoryFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PointsHistoryData pointsHistoryData) {
                invoke2(pointsHistoryData);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PointsHistoryData pointsHistoryData) {
                Pager page;
                List<PointsHistoryItem> list;
                if (pointsHistoryData == null || (list = pointsHistoryData.getList()) == null) {
                    PointsHistoryFragment.this.v1();
                } else {
                    PointsHistoryFragment pointsHistoryFragment = PointsHistoryFragment.this;
                    if (pointsHistoryFragment.h1() || Intrinsics.b(pointsHistoryFragment.f53337q, "1")) {
                        pointsHistoryFragment.q1(false);
                        if (list.isEmpty()) {
                            BaseListFragment.s1(pointsHistoryFragment, null, 1, null);
                        } else {
                            BaseQuickAdapter<PointsHistoryItem, BaseViewHolder> baseQuickAdapterW0 = pointsHistoryFragment.W0();
                            if (baseQuickAdapterW0 != null) {
                                baseQuickAdapterW0.w0(list);
                            }
                        }
                    } else {
                        BaseQuickAdapter<PointsHistoryItem, BaseViewHolder> baseQuickAdapterW1 = pointsHistoryFragment.W0();
                        if (baseQuickAdapterW1 != null) {
                            baseQuickAdapterW1.m(list);
                        }
                    }
                }
                if (pointsHistoryData == null || (page = pointsHistoryData.getPage()) == null) {
                    return;
                }
                PointsHistoryFragment pointsHistoryFragment2 = PointsHistoryFragment.this;
                if (!page.getHasMore()) {
                    BaseListFragment.l1(pointsHistoryFragment2, false, 1, null);
                } else {
                    pointsHistoryFragment2.f53337q = page.getNextPage();
                    pointsHistoryFragment2.j1();
                }
            }
        }));
    }

    @Override // com.transsion.baseui.fragment.LazyFragment
    public void lazyLoadData() {
        PointsHistoryViewModel pointsHistoryViewModelY1 = y1();
        String str = this.f53337q;
        if (str == null) {
            str = "1";
        }
        pointsHistoryViewModelY1.c(str);
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public void o1() {
        q1(true);
        this.f53337q = "1";
        lazyLoadData();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        String string = getString(R$string.points_history_title);
        Intrinsics.f(string, "getString(R.string.points_history_title)");
        return string;
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        super.v0();
        q1(true);
    }
}
