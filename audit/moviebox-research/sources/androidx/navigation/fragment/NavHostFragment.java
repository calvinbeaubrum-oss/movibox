package androidx.navigation.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.s;
import androidx.annotation.CallSuper;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.x0;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.Navigator;
import androidx.navigation.j;
import androidx.navigation.q;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public class NavHostFragment extends Fragment {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f12257g = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f12258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f12259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f12260c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f12261d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f12262f;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ NavHostFragment b(a aVar, int i11, Bundle bundle, int i12, Object obj) {
            if ((i12 & 2) != 0) {
                bundle = null;
            }
            return aVar.a(i11, bundle);
        }

        @JvmStatic
        @JvmOverloads
        public final NavHostFragment a(int i11, Bundle bundle) {
            Bundle bundle2;
            if (i11 != 0) {
                bundle2 = new Bundle();
                bundle2.putInt("android-support-nav:fragment:graphId", i11);
            } else {
                bundle2 = null;
            }
            if (bundle != null) {
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                }
                bundle2.putBundle("android-support-nav:fragment:startDestinationArgs", bundle);
            }
            NavHostFragment navHostFragment = new NavHostFragment();
            if (bundle2 != null) {
                navHostFragment.setArguments(bundle2);
            }
            return navHostFragment;
        }

        @JvmStatic
        public final NavController c(Fragment fragment) {
            Dialog dialog;
            Window window;
            Intrinsics.g(fragment, "fragment");
            for (Fragment parentFragment = fragment; parentFragment != null; parentFragment = parentFragment.getParentFragment()) {
                if (parentFragment instanceof NavHostFragment) {
                    j jVar = ((NavHostFragment) parentFragment).f12258a;
                    if (jVar != null) {
                        return jVar;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type androidx.navigation.NavController");
                }
                Fragment primaryNavigationFragment = parentFragment.getParentFragmentManager().getPrimaryNavigationFragment();
                if (primaryNavigationFragment instanceof NavHostFragment) {
                    j jVar2 = ((NavHostFragment) primaryNavigationFragment).f12258a;
                    if (jVar2 != null) {
                        return jVar2;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type androidx.navigation.NavController");
                }
            }
            View view = fragment.getView();
            if (view != null) {
                return Navigation.b(view);
            }
            View decorView = null;
            DialogFragment dialogFragment = fragment instanceof DialogFragment ? (DialogFragment) fragment : null;
            if (dialogFragment != null && (dialog = dialogFragment.getDialog()) != null && (window = dialog.getWindow()) != null) {
                decorView = window.getDecorView();
            }
            if (decorView != null) {
                return Navigation.b(decorView);
            }
            throw new IllegalStateException("Fragment " + fragment + " does not have a NavController set");
        }
    }

    @Deprecated
    public Navigator<? extends e.b> h0() {
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.f(childFragmentManager, "childFragmentManager");
        return new e(contextRequireContext, childFragmentManager, i0());
    }

    public final int i0() {
        int id2 = getId();
        return (id2 == 0 || id2 == -1) ? R$id.nav_host_fragment_container : id2;
    }

    @Deprecated
    @CallSuper
    public void j0(NavController navController) {
        Intrinsics.g(navController, "navController");
        q qVarF = navController.F();
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.f(childFragmentManager, "childFragmentManager");
        qVarF.b(new c(contextRequireContext, childFragmentManager));
        navController.F().b(h0());
    }

    @CallSuper
    public void k0(j navHostController) {
        Intrinsics.g(navHostController, "navHostController");
        j0(navHostController);
    }

    @Override // androidx.fragment.app.Fragment
    @CallSuper
    public void onAttach(Context context) {
        Intrinsics.g(context, "context");
        super.onAttach(context);
        if (this.f12262f) {
            getParentFragmentManager().beginTransaction().setPrimaryNavigationFragment(this).commit();
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x005b  */
    @Override // androidx.fragment.app.Fragment
    @CallSuper
    public void onCreate(Bundle bundle) {
        boolean z11;
        Bundle bundle2;
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        j jVar = new j(contextRequireContext);
        this.f12258a = jVar;
        Intrinsics.d(jVar);
        jVar.d0(this);
        Object obj = contextRequireContext;
        while (obj instanceof ContextWrapper) {
            if (obj instanceof s) {
                j jVar2 = this.f12258a;
                Intrinsics.d(jVar2);
                OnBackPressedDispatcher onBackPressedDispatcher = ((s) obj).getOnBackPressedDispatcher();
                Intrinsics.f(onBackPressedDispatcher, "context as OnBackPressed…).onBackPressedDispatcher");
                jVar2.e0(onBackPressedDispatcher);
                break;
            }
            Context baseContext = ((ContextWrapper) obj).getBaseContext();
            Intrinsics.f(baseContext, "context.baseContext");
            obj = baseContext;
        }
        j jVar3 = this.f12258a;
        Intrinsics.d(jVar3);
        Boolean bool = this.f12259b;
        if (bool == null) {
            z11 = false;
        } else {
            if (bool == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            }
            if (bool.booleanValue()) {
                z11 = true;
            } else {
                z11 = false;
            }
        }
        jVar3.r(z11);
        this.f12259b = null;
        j jVar4 = this.f12258a;
        Intrinsics.d(jVar4);
        x0 viewModelStore = getViewModelStore();
        Intrinsics.f(viewModelStore, "viewModelStore");
        jVar4.f0(viewModelStore);
        j jVar5 = this.f12258a;
        Intrinsics.d(jVar5);
        k0(jVar5);
        if (bundle != null) {
            bundle2 = bundle.getBundle("android-support-nav:fragment:navControllerState");
            if (bundle.getBoolean("android-support-nav:fragment:defaultHost", false)) {
                this.f12262f = true;
                getParentFragmentManager().beginTransaction().setPrimaryNavigationFragment(this).commit();
            }
            this.f12261d = bundle.getInt("android-support-nav:fragment:graphId");
        } else {
            bundle2 = null;
        }
        if (bundle2 != null) {
            j jVar6 = this.f12258a;
            Intrinsics.d(jVar6);
            jVar6.X(bundle2);
        }
        if (this.f12261d != 0) {
            j jVar7 = this.f12258a;
            Intrinsics.d(jVar7);
            jVar7.a0(this.f12261d);
        } else {
            Bundle arguments = getArguments();
            int i11 = arguments != null ? arguments.getInt("android-support-nav:fragment:graphId") : 0;
            Bundle bundle3 = arguments != null ? arguments.getBundle("android-support-nav:fragment:startDestinationArgs") : null;
            if (i11 != 0) {
                j jVar8 = this.f12258a;
                Intrinsics.d(jVar8);
                jVar8.b0(i11, bundle3);
            }
        }
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.g(inflater, "inflater");
        Context context = inflater.getContext();
        Intrinsics.f(context, "inflater.context");
        FragmentContainerView fragmentContainerView = new FragmentContainerView(context);
        fragmentContainerView.setId(i0());
        return fragmentContainerView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        View view = this.f12260c;
        if (view != null && Navigation.b(view) == this.f12258a) {
            Navigation.e(view, null);
        }
        this.f12260c = null;
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
            this.f12261d = resourceId;
        }
        Unit unit = Unit.f68710a;
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attrs, R$styleable.NavHostFragment);
        Intrinsics.f(typedArrayObtainStyledAttributes2, "context.obtainStyledAttr…tyleable.NavHostFragment)");
        if (typedArrayObtainStyledAttributes2.getBoolean(R$styleable.NavHostFragment_defaultNavHost, false)) {
            this.f12262f = true;
        }
        typedArrayObtainStyledAttributes2.recycle();
    }

    @Override // androidx.fragment.app.Fragment
    @CallSuper
    public void onPrimaryNavigationFragmentChanged(boolean z11) {
        j jVar = this.f12258a;
        if (jVar == null) {
            this.f12259b = Boolean.valueOf(z11);
        } else {
            if (jVar == null) {
                return;
            }
            jVar.r(z11);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @CallSuper
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.g(outState, "outState");
        super.onSaveInstanceState(outState);
        j jVar = this.f12258a;
        Intrinsics.d(jVar);
        Bundle bundleZ = jVar.Z();
        if (bundleZ != null) {
            outState.putBundle("android-support-nav:fragment:navControllerState", bundleZ);
        }
        if (this.f12262f) {
            outState.putBoolean("android-support-nav:fragment:defaultHost", true);
        }
        int i11 = this.f12261d;
        if (i11 != 0) {
            outState.putInt("android-support-nav:fragment:graphId", i11);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        if (!(view instanceof ViewGroup)) {
            throw new IllegalStateException(("created host view " + view + " is not a ViewGroup").toString());
        }
        Navigation.e(view, this.f12258a);
        if (view.getParent() != null) {
            Object parent = view.getParent();
            if (parent == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.View");
            }
            View view2 = (View) parent;
            this.f12260c = view2;
            Intrinsics.d(view2);
            if (view2.getId() == getId()) {
                View view3 = this.f12260c;
                Intrinsics.d(view3);
                Navigation.e(view3, this.f12258a);
            }
        }
    }
}
