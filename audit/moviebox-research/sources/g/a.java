package g;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cloud.tmc.miniapp.R$id;
import com.cloud.tmc.miniapp.R$layout;
import com.cloud.tmc.miniapp.widget.AddScreenView;
import com.cloud.tmc.miniapp.widget.ImmersiveTitleBarView;
import com.cloud.tmc.miniapp.widget.PageContainerView;
import com.cloud.tmc.miniapp.widget.StatusLayout;
import com.cloud.tmc.miniapp.widget.TabBarView;
import n6.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f65293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final PageContainerView f65294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final FrameLayout f65295c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f65296d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final ProgressBar f65297f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final TabBarView f65298g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final ImmersiveTitleBarView f65299h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final View f65300i;

    public a(@NonNull ConstraintLayout constraintLayout, @NonNull AddScreenView addScreenView, @NonNull PageContainerView pageContainerView, @NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ProgressBar progressBar, @NonNull StatusLayout statusLayout, @NonNull TabBarView tabBarView, @NonNull ImmersiveTitleBarView immersiveTitleBarView, @NonNull View view) {
        this.f65293a = constraintLayout;
        this.f65294b = pageContainerView;
        this.f65295c = frameLayout;
        this.f65296d = imageView;
        this.f65297f = progressBar;
        this.f65298g = tabBarView;
        this.f65299h = immersiveTitleBarView;
        this.f65300i = view;
    }

    @NonNull
    public static a a(@NonNull LayoutInflater layoutInflater) {
        View viewA;
        View viewInflate = layoutInflater.inflate(R$layout.fragment_mini, (ViewGroup) null, false);
        int i11 = R$id.addScreenView;
        AddScreenView addScreenView = (AddScreenView) b.a(viewInflate, i11);
        if (addScreenView != null) {
            i11 = R$id.f31323fl;
            PageContainerView pageContainerView = (PageContainerView) b.a(viewInflate, i11);
            if (pageContainerView != null) {
                i11 = R$id.fl_fullscreen;
                FrameLayout frameLayout = (FrameLayout) b.a(viewInflate, i11);
                if (frameLayout != null) {
                    i11 = R$id.fl_loading_mask;
                    FrameLayout frameLayout2 = (FrameLayout) b.a(viewInflate, i11);
                    if (frameLayout2 != null) {
                        i11 = R$id.iv_fullscreen_back;
                        ImageView imageView = (ImageView) b.a(viewInflate, i11);
                        if (imageView != null) {
                            i11 = R$id.iv_loading;
                            ImageView imageView2 = (ImageView) b.a(viewInflate, i11);
                            if (imageView2 != null) {
                                i11 = R$id.f31324pb;
                                ProgressBar progressBar = (ProgressBar) b.a(viewInflate, i11);
                                if (progressBar != null) {
                                    i11 = R$id.sl_status;
                                    StatusLayout statusLayout = (StatusLayout) b.a(viewInflate, i11);
                                    if (statusLayout != null) {
                                        i11 = R$id.tabBar;
                                        TabBarView tabBarView = (TabBarView) b.a(viewInflate, i11);
                                        if (tabBarView != null) {
                                            i11 = R$id.titleBar;
                                            ImmersiveTitleBarView immersiveTitleBarView = (ImmersiveTitleBarView) b.a(viewInflate, i11);
                                            if (immersiveTitleBarView != null && (viewA = b.a(viewInflate, (i11 = R$id.view_mask))) != null) {
                                                return new a((ConstraintLayout) viewInflate, addScreenView, pageContainerView, frameLayout, frameLayout2, imageView, imageView2, progressBar, statusLayout, tabBarView, immersiveTitleBarView, viewA);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i11)));
    }

    @Override // n6.a
    @NonNull
    public View getRoot() {
        return this.f65293a;
    }
}
