package lt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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
public final class g implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f70430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f70431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f70432c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f70433d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final FrameLayout f70434f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f70435g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final TnTextView f70436h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final MagicIndicator f70437i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final BlurredSectorView f70438j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final View f70439k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final ViewPager2 f70440l;

    public g(@NonNull ConstraintLayout constraintLayout, @NonNull FrameLayout frameLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull FrameLayout frameLayout2, @NonNull ConstraintLayout constraintLayout2, @NonNull TnTextView tnTextView, @NonNull MagicIndicator magicIndicator, @NonNull BlurredSectorView blurredSectorView, @NonNull View view, @NonNull ViewPager2 viewPager2) {
        this.f70430a = constraintLayout;
        this.f70431b = frameLayout;
        this.f70432c = appCompatImageView;
        this.f70433d = appCompatImageView2;
        this.f70434f = frameLayout2;
        this.f70435g = constraintLayout2;
        this.f70436h = tnTextView;
        this.f70437i = magicIndicator;
        this.f70438j = blurredSectorView;
        this.f70439k = view;
        this.f70440l = viewPager2;
    }

    @NonNull
    public static g a(@NonNull View view) {
        View viewA;
        int i11 = R$id.bottom_op_container;
        FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
        if (frameLayout != null) {
            i11 = R$id.bottom_op_mb_logo;
            AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.bottom_op_search_appstore;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) n6.b.a(view, i11);
                if (appCompatImageView2 != null) {
                    i11 = R$id.bottom_op_search_gamestore;
                    FrameLayout frameLayout2 = (FrameLayout) n6.b.a(view, i11);
                    if (frameLayout2 != null) {
                        i11 = R$id.bottom_op_search_liner;
                        ConstraintLayout constraintLayout = (ConstraintLayout) n6.b.a(view, i11);
                        if (constraintLayout != null) {
                            i11 = R$id.bottom_op_search_text;
                            TnTextView tnTextView = (TnTextView) n6.b.a(view, i11);
                            if (tnTextView != null) {
                                i11 = R$id.magicIndicator;
                                MagicIndicator magicIndicator = (MagicIndicator) n6.b.a(view, i11);
                                if (magicIndicator != null) {
                                    i11 = R$id.trending_bottom_bg;
                                    BlurredSectorView blurredSectorView = (BlurredSectorView) n6.b.a(view, i11);
                                    if (blurredSectorView != null && (viewA = n6.b.a(view, (i11 = R$id.viewLine))) != null) {
                                        i11 = R$id.viewPager;
                                        ViewPager2 viewPager2 = (ViewPager2) n6.b.a(view, i11);
                                        if (viewPager2 != null) {
                                            return new g((ConstraintLayout) view, frameLayout, appCompatImageView, appCompatImageView2, frameLayout2, constraintLayout, tnTextView, magicIndicator, blurredSectorView, viewA, viewPager2);
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
    public static g c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static g d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_bottom_op, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f70430a;
    }
}
