package h00;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class i0 implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f65899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final CoordinatorLayout f65900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final FrameLayout f65901c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final FrameLayout f65902d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final FrameLayout f65903f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final MagicIndicator f65904g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f65905h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final ViewPager2 f65906i;

    public i0(@NonNull ConstraintLayout constraintLayout, @NonNull CoordinatorLayout coordinatorLayout, @NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull FrameLayout frameLayout3, @NonNull MagicIndicator magicIndicator, @NonNull AppCompatTextView appCompatTextView, @NonNull ViewPager2 viewPager2) {
        this.f65899a = constraintLayout;
        this.f65900b = coordinatorLayout;
        this.f65901c = frameLayout;
        this.f65902d = frameLayout2;
        this.f65903f = frameLayout3;
        this.f65904g = magicIndicator;
        this.f65905h = appCompatTextView;
        this.f65906i = viewPager2;
    }

    @NonNull
    public static i0 a(@NonNull View view) {
        int i11 = R$id.cl_root;
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) n6.b.a(view, i11);
        if (coordinatorLayout != null) {
            i11 = R$id.flAppDownloadAd;
            FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
            if (frameLayout != null) {
                i11 = R$id.flDownloadingContainer;
                FrameLayout frameLayout2 = (FrameLayout) n6.b.a(view, i11);
                if (frameLayout2 != null) {
                    i11 = R$id.flTopCardAd;
                    FrameLayout frameLayout3 = (FrameLayout) n6.b.a(view, i11);
                    if (frameLayout3 != null) {
                        i11 = R$id.magic_indicator;
                        MagicIndicator magicIndicator = (MagicIndicator) n6.b.a(view, i11);
                        if (magicIndicator != null) {
                            i11 = R$id.tv_available_size;
                            AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                            if (appCompatTextView != null) {
                                i11 = R$id.view_pager;
                                ViewPager2 viewPager2 = (ViewPager2) n6.b.a(view, i11);
                                if (viewPager2 != null) {
                                    return new i0((ConstraintLayout) view, coordinatorLayout, frameLayout, frameLayout2, frameLayout3, magicIndicator, appCompatTextView, viewPager2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static i0 c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static i0 d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_file_manager, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f65899a;
    }
}
