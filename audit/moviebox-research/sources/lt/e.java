package lt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.banner.banner.Banner;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class e implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f70413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final Banner f70414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final FrameLayout f70415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f70416d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f70417f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f70418g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f70419h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f70420i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f70421j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f70422k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f70423l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f70424m;

    public e(@NonNull ConstraintLayout constraintLayout, @NonNull Banner banner, @NonNull FrameLayout frameLayout, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull AppCompatImageView appCompatImageView3, @NonNull LinearLayoutCompat linearLayoutCompat, @NonNull AppCompatTextView appCompatTextView2, @NonNull AppCompatTextView appCompatTextView3, @NonNull AppCompatTextView appCompatTextView4, @NonNull AppCompatTextView appCompatTextView5) {
        this.f70413a = constraintLayout;
        this.f70414b = banner;
        this.f70415c = frameLayout;
        this.f70416d = appCompatTextView;
        this.f70417f = appCompatImageView;
        this.f70418g = appCompatImageView2;
        this.f70419h = appCompatImageView3;
        this.f70420i = linearLayoutCompat;
        this.f70421j = appCompatTextView2;
        this.f70422k = appCompatTextView3;
        this.f70423l = appCompatTextView4;
        this.f70424m = appCompatTextView5;
    }

    @NonNull
    public static e a(@NonNull View view) {
        int i11 = R$id.banner;
        Banner banner = (Banner) n6.b.a(view, i11);
        if (banner != null) {
            i11 = R$id.container;
            FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
            if (frameLayout != null) {
                i11 = R$id.desc;
                AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                if (appCompatTextView != null) {
                    i11 = R$id.iv_close;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
                    if (appCompatImageView != null) {
                        i11 = R$id.iv_icon;
                        AppCompatImageView appCompatImageView2 = (AppCompatImageView) n6.b.a(view, i11);
                        if (appCompatImageView2 != null) {
                            i11 = R$id.iv_top_cover;
                            AppCompatImageView appCompatImageView3 = (AppCompatImageView) n6.b.a(view, i11);
                            if (appCompatImageView3 != null) {
                                i11 = R$id.ll_download;
                                LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) n6.b.a(view, i11);
                                if (linearLayoutCompat != null) {
                                    i11 = R$id.name;
                                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                                    if (appCompatTextView2 != null) {
                                        i11 = R$id.title;
                                        AppCompatTextView appCompatTextView3 = (AppCompatTextView) n6.b.a(view, i11);
                                        if (appCompatTextView3 != null) {
                                            i11 = R$id.tv_discover;
                                            AppCompatTextView appCompatTextView4 = (AppCompatTextView) n6.b.a(view, i11);
                                            if (appCompatTextView4 != null) {
                                                i11 = R$id.tv_tips;
                                                AppCompatTextView appCompatTextView5 = (AppCompatTextView) n6.b.a(view, i11);
                                                if (appCompatTextView5 != null) {
                                                    return new e((ConstraintLayout) view, banner, frameLayout, appCompatTextView, appCompatImageView, appCompatImageView2, appCompatImageView3, linearLayoutCompat, appCompatTextView2, appCompatTextView3, appCompatTextView4, appCompatTextView5);
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
    public static e c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static e d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.dialog_one_click_download, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f70413a;
    }
}
