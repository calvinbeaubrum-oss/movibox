package bx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class g implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f14482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f14483b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final MagicIndicator f14484c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final View f14485d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final ProgressBar f14486f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final ViewPager2 f14487g;

    public g(@NonNull ConstraintLayout constraintLayout, @NonNull FrameLayout frameLayout, @NonNull MagicIndicator magicIndicator, @NonNull View view, @NonNull ProgressBar progressBar, @NonNull ViewPager2 viewPager2) {
        this.f14482a = constraintLayout;
        this.f14483b = frameLayout;
        this.f14484c = magicIndicator;
        this.f14485d = view;
        this.f14486f = progressBar;
        this.f14487g = viewPager2;
    }

    @NonNull
    public static g a(@NonNull View view) {
        View viewA;
        int i11 = R$id.search_result_empty_view;
        FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
        if (frameLayout != null) {
            i11 = R$id.search_result_magic_indicator;
            MagicIndicator magicIndicator = (MagicIndicator) n6.b.a(view, i11);
            if (magicIndicator != null && (viewA = n6.b.a(view, (i11 = R$id.search_result_magic_indicator_divider))) != null) {
                i11 = R$id.search_result_progress_bar;
                ProgressBar progressBar = (ProgressBar) n6.b.a(view, i11);
                if (progressBar != null) {
                    i11 = R$id.search_result_view_pager;
                    ViewPager2 viewPager2 = (ViewPager2) n6.b.a(view, i11);
                    if (viewPager2 != null) {
                        return new g((ConstraintLayout) view, frameLayout, magicIndicator, viewA, progressBar, viewPager2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static g c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static g d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_search_result, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f14482a;
    }
}
