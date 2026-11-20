package lt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextSwitcher;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.tn.lib.widget.TnTextView;
import com.transsion.baseui.widget.BlurredSectorView;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class k implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f70454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f70455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final FrameLayout f70456c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f70457d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f70458f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f70459g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f70460h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final MagicIndicator f70461i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final FrameLayout f70462j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final TextSwitcher f70463k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final BlurredSectorView f70464l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final TnTextView f70465m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    public final TnTextView f70466n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f70467o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NonNull
    public final ViewPager2 f70468p;

    public k(@NonNull ConstraintLayout constraintLayout, @NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull AppCompatImageView appCompatImageView3, @NonNull ConstraintLayout constraintLayout2, @NonNull MagicIndicator magicIndicator, @NonNull FrameLayout frameLayout3, @NonNull TextSwitcher textSwitcher, @NonNull BlurredSectorView blurredSectorView, @NonNull TnTextView tnTextView, @NonNull TnTextView tnTextView2, @NonNull ConstraintLayout constraintLayout3, @NonNull ViewPager2 viewPager2) {
        this.f70454a = constraintLayout;
        this.f70455b = frameLayout;
        this.f70456c = frameLayout2;
        this.f70457d = appCompatImageView;
        this.f70458f = appCompatImageView2;
        this.f70459g = appCompatImageView3;
        this.f70460h = constraintLayout2;
        this.f70461i = magicIndicator;
        this.f70462j = frameLayout3;
        this.f70463k = textSwitcher;
        this.f70464l = blurredSectorView;
        this.f70465m = tnTextView;
        this.f70466n = tnTextView2;
        this.f70467o = constraintLayout3;
        this.f70468p = viewPager2;
    }

    @NonNull
    public static k a(@NonNull View view) {
        int i11 = R$id.flGameCenter;
        FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
        if (frameLayout != null) {
            i11 = R$id.flPhoneCenter;
            FrameLayout frameLayout2 = (FrameLayout) n6.b.a(view, i11);
            if (frameLayout2 != null) {
                i11 = R$id.iv_mb_logo;
                AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
                if (appCompatImageView != null) {
                    i11 = R$id.ivNovelEnter;
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) n6.b.a(view, i11);
                    if (appCompatImageView2 != null) {
                        i11 = R$id.ivUpdateApp;
                        AppCompatImageView appCompatImageView3 = (AppCompatImageView) n6.b.a(view, i11);
                        if (appCompatImageView3 != null) {
                            i11 = R$id.ll_tab;
                            ConstraintLayout constraintLayout = (ConstraintLayout) n6.b.a(view, i11);
                            if (constraintLayout != null) {
                                i11 = R$id.magic_indicator;
                                MagicIndicator magicIndicator = (MagicIndicator) n6.b.a(view, i11);
                                if (magicIndicator != null) {
                                    i11 = R$id.search_left_container;
                                    FrameLayout frameLayout3 = (FrameLayout) n6.b.a(view, i11);
                                    if (frameLayout3 != null) {
                                        i11 = R$id.text_switcher;
                                        TextSwitcher textSwitcher = (TextSwitcher) n6.b.a(view, i11);
                                        if (textSwitcher != null) {
                                            i11 = R$id.trending_bottom_bg;
                                            BlurredSectorView blurredSectorView = (BlurredSectorView) n6.b.a(view, i11);
                                            if (blurredSectorView != null) {
                                                i11 = R$id.tv_search;
                                                TnTextView tnTextView = (TnTextView) n6.b.a(view, i11);
                                                if (tnTextView != null) {
                                                    i11 = R$id.tv_search_button;
                                                    TnTextView tnTextView2 = (TnTextView) n6.b.a(view, i11);
                                                    if (tnTextView2 != null) {
                                                        i11 = R$id.tv_search_container;
                                                        ConstraintLayout constraintLayout2 = (ConstraintLayout) n6.b.a(view, i11);
                                                        if (constraintLayout2 != null) {
                                                            i11 = R$id.view_pager;
                                                            ViewPager2 viewPager2 = (ViewPager2) n6.b.a(view, i11);
                                                            if (viewPager2 != null) {
                                                                return new k((ConstraintLayout) view, frameLayout, frameLayout2, appCompatImageView, appCompatImageView2, appCompatImageView3, constraintLayout, magicIndicator, frameLayout3, textSwitcher, blurredSectorView, tnTextView, tnTextView2, constraintLayout2, viewPager2);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static k c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static k d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_home, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f70454a;
    }
}
