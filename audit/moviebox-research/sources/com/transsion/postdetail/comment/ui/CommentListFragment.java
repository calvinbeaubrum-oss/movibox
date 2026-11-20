package com.transsion.postdetail.comment.ui;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.d0;
import androidx.lifecycle.m;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.lifecycle.y0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.util.networkinfo.f;
import com.transsion.baselib.report.h;
import com.transsion.baseui.fragment.BaseListFragment;
import com.transsion.postdetail.bean.CommentBean;
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
public final class CommentListFragment extends BaseListFragment<CommentBean> {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final a f54972q = new a(null);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f54973p;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CommentListFragment a() {
            CommentListFragment commentListFragment = new CommentListFragment();
            commentListFragment.setArguments(new Bundle());
            return commentListFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f54974a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f54974a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f54974a;
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
            this.f54974a.invoke(obj);
        }
    }

    public CommentListFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.postdetail.comment.ui.CommentListFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        this.f54973p = FragmentViewModelLazyKt.a(this, Reflection.b(CommentListViewModel.class), new Function0<x0>() { // from class: com.transsion.postdetail.comment.ui.CommentListFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final x0 invoke() {
                x0 viewModelStore = ((y0) function0.invoke()).getViewModelStore();
                Intrinsics.f(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.postdetail.comment.ui.CommentListFragment$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final v0.c invoke() {
                Object objInvoke = function0.invoke();
                m mVar = objInvoke instanceof m ? (m) objInvoke : null;
                v0.c defaultViewModelProviderFactory = mVar != null ? mVar.getDefaultViewModelProviderFactory() : null;
                if (defaultViewModelProviderFactory == null) {
                    defaultViewModelProviderFactory = this.getDefaultViewModelProviderFactory();
                }
                Intrinsics.f(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
        n1();
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public String Z0() {
        return "My Comments";
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public void i1() {
        y1().i(false);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        z1();
    }

    @Override // com.transsion.baseui.fragment.LazyFragment
    public void lazyLoadData() {
        if (!f.f49475a.e()) {
            BaseQuickAdapter<CommentBean, BaseViewHolder> baseQuickAdapterW0 = W0();
            if (baseQuickAdapterW0 != null) {
                baseQuickAdapterW0.r0(r0(false));
                return;
            }
            return;
        }
        q1(false);
        BaseQuickAdapter<CommentBean, BaseViewHolder> baseQuickAdapterW1 = W0();
        if (baseQuickAdapterW1 != null && baseQuickAdapterW1.getItemCount() == 0) {
            K0();
        }
        y1().i(false);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public h newLogViewConfig() {
        return new h("comments", false, 2, null);
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public void o1() {
        y1().i(true);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        super.v0();
        q1(true);
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    /* JADX INFO: renamed from: x1, reason: merged with bridge method [inline-methods] */
    public com.transsion.postdetail.comment.ui.a T0() {
        return new com.transsion.postdetail.comment.ui.a();
    }

    public final CommentListViewModel y1() {
        return (CommentListViewModel) this.f54973p.getValue();
    }

    public final void z1() {
        y1().k().j(this, new b(new Function1<List<CommentBean>, Unit>() { // from class: com.transsion.postdetail.comment.ui.CommentListFragment$initSeeListLiveData$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<CommentBean> list) {
                invoke2(list);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<CommentBean> list) {
                List<CommentBean> listD;
                BaseQuickAdapter<CommentBean, BaseViewHolder> baseQuickAdapterW0;
                h9.f fVarQ;
                this.this$0.F0();
                List<CommentBean> list2 = list;
                if (list2 == null || list2.isEmpty()) {
                    BaseQuickAdapter<CommentBean, BaseViewHolder> baseQuickAdapterW1 = this.this$0.W0();
                    if (baseQuickAdapterW1 != null && (listD = baseQuickAdapterW1.D()) != null && listD.isEmpty() && (baseQuickAdapterW0 = this.this$0.W0()) != null) {
                        baseQuickAdapterW0.r0(this.this$0.l0(false));
                    }
                } else {
                    h logViewConfig = this.this$0.getLogViewConfig();
                    if (logViewConfig != null) {
                        logViewConfig.j(true);
                    }
                    BaseQuickAdapter<CommentBean, BaseViewHolder> baseQuickAdapterW2 = this.this$0.W0();
                    if (baseQuickAdapterW2 != null) {
                        baseQuickAdapterW2.w0(list2);
                    }
                }
                this.this$0.q1(false);
                BaseQuickAdapter<CommentBean, BaseViewHolder> baseQuickAdapterW3 = this.this$0.W0();
                if (baseQuickAdapterW3 != null && (fVarQ = baseQuickAdapterW3.Q()) != null && fVarQ.q()) {
                    this.this$0.j1();
                }
                if (this.this$0.y1().l()) {
                    return;
                }
                this.this$0.k1(false);
            }
        }));
    }
}
