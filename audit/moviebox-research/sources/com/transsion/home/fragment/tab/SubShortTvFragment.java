package com.transsion.home.fragment.tab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.home.R$id;
import com.transsion.postdetail.shorttv.ShortTVDiscoverFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class SubShortTvFragment extends BaseHomeSubFragment<lt.q> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f52535h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f52536i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ShortTVDiscoverFragment f52538k;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f52537j = true;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final a f52539l = new a();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends RecyclerView.r {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            Intrinsics.g(recyclerView, "recyclerView");
            if (SubShortTvFragment.this.f52535h) {
                int iComputeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
                SubShortTvFragment subShortTvFragment = SubShortTvFragment.this;
                subShortTvFragment.I0(kotlin.ranges.a.f((iComputeVerticalScrollOffset * 1.0f) / subShortTvFragment.f52536i, 1.0f));
                if (!SubShortTvFragment.this.q0() && SubShortTvFragment.this.G0() < 0.7f) {
                    SubShortTvFragment.this.g0(true);
                } else {
                    if (!SubShortTvFragment.this.q0() || SubShortTvFragment.this.G0() < 0.7f) {
                        return;
                    }
                    SubShortTvFragment.this.g0(false);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void F0() {
        View view;
        FrameLayout frameLayout;
        lt.q qVar = (lt.q) getMViewBinding();
        ViewGroup.LayoutParams layoutParams = (qVar == null || (frameLayout = qVar.f70496b) == null) ? null : frameLayout.getLayoutParams();
        Intrinsics.e(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        if (this.f52535h) {
            layoutParams2.topMargin = 0;
            I0(0.0f);
            g0(true);
        } else {
            lt.q qVar2 = (lt.q) getMViewBinding();
            layoutParams2.topMargin = (qVar2 == null || (view = qVar2.f70497c) == null) ? 0 : view.getHeight();
            I0(1.0f);
            g0(false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final float G0() {
        View view;
        lt.q qVar = (lt.q) getMViewBinding();
        if (qVar == null || (view = qVar.f70497c) == null) {
            return 0.0f;
        }
        return view.getAlpha();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: H0, reason: merged with bridge method [inline-methods] */
    public lt.q getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        lt.q qVarC = lt.q.c(inflater);
        Intrinsics.f(qVarC, "inflate(inflater)");
        return qVarC;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void I0(float f11) {
        lt.q qVar = (lt.q) getMViewBinding();
        View view = qVar != null ? qVar.f70497c : null;
        if (view == null) {
            return;
        }
        view.setAlpha(f11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment, com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        View view2;
        Intrinsics.g(view, "view");
        this.f52538k = new ShortTVDiscoverFragment();
        this.f52536i = n0();
        lt.q qVar = (lt.q) getMViewBinding();
        ViewGroup.LayoutParams layoutParams = (qVar == null || (view2 = qVar.f70497c) == null) ? null : view2.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = this.f52536i;
        }
        ShortTVDiscoverFragment shortTVDiscoverFragment = this.f52538k;
        if (shortTVDiscoverFragment != null) {
            shortTVDiscoverFragment.i2(this.f52539l, new Function1<Boolean, Unit>() { // from class: com.transsion.home.fragment.tab.SubShortTvFragment.initView.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.f68710a;
                }

                public final void invoke(boolean z11) {
                    SubShortTvFragment.this.f52535h = z11;
                    if (SubShortTvFragment.this.f52537j) {
                        SubShortTvFragment.this.F0();
                        SubShortTvFragment.this.f52537j = false;
                    }
                }
            });
        }
    }

    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment
    public RecyclerView l0() {
        return null;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
        F0();
        ShortTVDiscoverFragment shortTVDiscoverFragment = this.f52538k;
        if (shortTVDiscoverFragment != null) {
            getChildFragmentManager().beginTransaction().replace(R$id.sub_shor_tv_container, shortTVDiscoverFragment).commit();
        }
    }

    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment
    public void s0(int i11, com.transsion.ad.bidding.nativead.c wrapperNativeManager) {
        Intrinsics.g(wrapperNativeManager, "wrapperNativeManager");
    }

    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment
    public void v0() {
        ShortTVDiscoverFragment shortTVDiscoverFragment = this.f52538k;
        if (shortTVDiscoverFragment != null) {
            shortTVDiscoverFragment.b2();
        }
    }
}
