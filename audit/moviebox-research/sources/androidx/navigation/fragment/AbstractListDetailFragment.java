package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.p;
import androidx.annotation.CallSuper;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.u;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;
import kotlin.Metadata;
import kotlin.Unit;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class AbstractListDetailFragment extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p f12251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public NavHostFragment f12252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12253c;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends p implements SlidingPaneLayout.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SlidingPaneLayout f12254a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SlidingPaneLayout slidingPaneLayout) {
            super(true);
            Intrinsics.g(slidingPaneLayout, "slidingPaneLayout");
            this.f12254a = slidingPaneLayout;
            slidingPaneLayout.addPanelSlideListener(this);
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.e
        public void a(View panel) {
            Intrinsics.g(panel, "panel");
            setEnabled(true);
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.e
        public void b(View panel) {
            Intrinsics.g(panel, "panel");
            setEnabled(false);
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.e
        public void c(View panel, float f11) {
            Intrinsics.g(panel, "panel");
        }

        @Override // androidx.activity.p
        public void handleOnBackPressed() {
            this.f12254a.closePane();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SlidingPaneLayout f12256b;

        public b(SlidingPaneLayout slidingPaneLayout) {
            this.f12256b = slidingPaneLayout;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
            Intrinsics.h(view, "view");
            view.removeOnLayoutChangeListener(this);
            p pVar = AbstractListDetailFragment.this.f12251a;
            Intrinsics.d(pVar);
            pVar.setEnabled(this.f12256b.isSlideable() && this.f12256b.isOpen());
        }
    }

    public final SlidingPaneLayout h0() {
        return (SlidingPaneLayout) requireView();
    }

    public NavHostFragment i0() {
        int i11 = this.f12253c;
        return i11 != 0 ? NavHostFragment.a.b(NavHostFragment.f12257g, i11, null, 2, null) : new NavHostFragment();
    }

    public abstract View j0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    public void k0(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
    }

    @Override // androidx.fragment.app.Fragment
    @CallSuper
    public final View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        NavHostFragment navHostFragmentI0;
        Intrinsics.g(inflater, "inflater");
        if (bundle != null) {
            this.f12253c = bundle.getInt("android-support-nav:fragment:graphId");
        }
        SlidingPaneLayout slidingPaneLayout = new SlidingPaneLayout(inflater.getContext());
        slidingPaneLayout.setId(R$id.sliding_pane_layout);
        View viewJ0 = j0(inflater, slidingPaneLayout, bundle);
        if (!Intrinsics.b(viewJ0, slidingPaneLayout) && !Intrinsics.b(viewJ0.getParent(), slidingPaneLayout)) {
            slidingPaneLayout.addView(viewJ0);
        }
        Context context = inflater.getContext();
        Intrinsics.f(context, "inflater.context");
        FragmentContainerView fragmentContainerView = new FragmentContainerView(context);
        fragmentContainerView.setId(R$id.sliding_pane_detail_container);
        SlidingPaneLayout.d dVar = new SlidingPaneLayout.d(inflater.getContext().getResources().getDimensionPixelSize(R$dimen.sliding_pane_detail_pane_width), -1);
        dVar.f12965a = 1.0f;
        slidingPaneLayout.addView(fragmentContainerView, dVar);
        Fragment fragmentFindFragmentById = getChildFragmentManager().findFragmentById(R$id.sliding_pane_detail_container);
        if (fragmentFindFragmentById != null) {
            navHostFragmentI0 = (NavHostFragment) fragmentFindFragmentById;
        } else {
            navHostFragmentI0 = i0();
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.f(childFragmentManager, "childFragmentManager");
            FragmentTransaction fragmentTransactionBeginTransaction = childFragmentManager.beginTransaction();
            Intrinsics.f(fragmentTransactionBeginTransaction, "beginTransaction()");
            fragmentTransactionBeginTransaction.setReorderingAllowed(true);
            fragmentTransactionBeginTransaction.add(R$id.sliding_pane_detail_container, navHostFragmentI0);
            fragmentTransactionBeginTransaction.commit();
        }
        this.f12252b = navHostFragmentI0;
        this.f12251a = new a(slidingPaneLayout);
        if (!ViewCompat.isLaidOut(slidingPaneLayout) || slidingPaneLayout.isLayoutRequested()) {
            slidingPaneLayout.addOnLayoutChangeListener(new b(slidingPaneLayout));
        } else {
            p pVar = this.f12251a;
            Intrinsics.d(pVar);
            pVar.setEnabled(slidingPaneLayout.isSlideable() && slidingPaneLayout.isOpen());
        }
        OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        u viewLifecycleOwner = getViewLifecycleOwner();
        p pVar2 = this.f12251a;
        Intrinsics.d(pVar2);
        onBackPressedDispatcher.i(viewLifecycleOwner, pVar2);
        return slidingPaneLayout;
    }

    @Override // androidx.fragment.app.Fragment
    @CallSuper
    public void onInflate(Context context, AttributeSet attrs, Bundle bundle) {
        Intrinsics.g(context, "context");
        Intrinsics.g(attrs, "attrs");
        super.onInflate(context, attrs, bundle);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, androidx.navigation.R$styleable.NavHost);
        Intrinsics.f(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…yleable.NavHost\n        )");
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(androidx.navigation.R$styleable.NavHost_navGraph, 0);
        if (resourceId != 0) {
            this.f12253c = resourceId;
        }
        Unit unit = Unit.f68710a;
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.fragment.app.Fragment
    @CallSuper
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.g(outState, "outState");
        super.onSaveInstanceState(outState);
        int i11 = this.f12253c;
        if (i11 != 0) {
            outState.putInt("android-support-nav:fragment:graphId", i11);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @CallSuper
    public final void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        View listPaneView = h0().getChildAt(0);
        Intrinsics.f(listPaneView, "listPaneView");
        k0(listPaneView, bundle);
    }

    @Override // androidx.fragment.app.Fragment
    @CallSuper
    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        p pVar = this.f12251a;
        Intrinsics.d(pVar);
        pVar.setEnabled(h0().isSlideable() && h0().isOpen());
    }
}
