package h;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.cloud.tmc.integration.ui.fragment.TmcFragment;
import com.cloud.tmc.miniapp.widget.SwipeBackLayout;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import xb.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension
public final class h implements l0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TmcFragment f65678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SwipeBackLayout f65679b;

    @Override // l0.b
    public void OooO00o() {
        this.f65678a = null;
        this.f65679b = null;
    }

    @Override // l0.b
    public void OooO00o(boolean z11) {
        View view;
        SwipeBackLayout swipeBackLayout = this.f65679b;
        if (swipeBackLayout == null || !z11) {
            return;
        }
        swipeBackLayout.OooO00o();
        Fragment fragment = swipeBackLayout.OooO0oO;
        if (fragment == null || (view = fragment.getView()) == null) {
            return;
        }
        view.setVisibility(8);
    }

    @Override // l0.b
    public View a(View view) {
        Intrinsics.g(view, "view");
        SwipeBackLayout swipeBackLayout = this.f65679b;
        Intrinsics.d(swipeBackLayout);
        TmcFragment tmcFragment = this.f65678a;
        View view2 = swipeBackLayout.f31873OooO0o0;
        if (view2 != null) {
            swipeBackLayout.removeView(view2);
        }
        i.b(view);
        swipeBackLayout.addView(view);
        swipeBackLayout.f31872OooO0o = tmcFragment;
        swipeBackLayout.f31873OooO0o0 = view;
        return swipeBackLayout;
    }

    @Override // l0.b
    public void b() {
        SwipeBackLayout swipeBackLayout = this.f65679b;
        if (swipeBackLayout != null) {
            swipeBackLayout.OooOOOO = true;
        }
    }

    @Override // l0.b
    public void c(int i11) {
        SwipeBackLayout swipeBackLayout = this.f65679b;
        if (swipeBackLayout != null) {
            swipeBackLayout.setEdgeLevel(i11);
        }
    }

    @Override // l0.b
    public void d(float f11) {
        SwipeBackLayout swipeBackLayout = this.f65679b;
        if (swipeBackLayout != null) {
            swipeBackLayout.setParallaxOffset(f11);
        }
    }

    @Override // l0.b
    public void e(TmcFragment tmcFragment, Bundle bundle) {
        Intrinsics.g(tmcFragment, "tmcFragment");
        this.f65678a = tmcFragment;
        TmcFragment tmcFragment2 = this.f65678a;
        Intrinsics.d(tmcFragment2);
        this.f65679b = new SwipeBackLayout(tmcFragment2.getContext(), null);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        SwipeBackLayout swipeBackLayout = this.f65679b;
        Intrinsics.d(swipeBackLayout);
        swipeBackLayout.setLayoutParams(layoutParams);
        SwipeBackLayout swipeBackLayout2 = this.f65679b;
        Intrinsics.d(swipeBackLayout2);
        swipeBackLayout2.setBackgroundColor(0);
        SwipeBackLayout swipeBackLayout3 = this.f65679b;
        Intrinsics.d(swipeBackLayout3);
        swipeBackLayout3.setSwipeAlpha(0.0f);
    }
}
