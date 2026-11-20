package wx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tn.lib.view.SwitchButton;
import com.transsion.subtitle.R$id;
import com.transsion.subtitle.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class g implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f79695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f79696b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f79697c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f79698d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f79699f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final RecyclerView f79700g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final SwitchButton f79701h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final SwitchButton f79702i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f79703j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f79704k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f79705l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f79706m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    public final View f79707n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f79708o;

    public g(@NonNull ConstraintLayout constraintLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull LinearLayoutCompat linearLayoutCompat, @NonNull LinearLayoutCompat linearLayoutCompat2, @NonNull RecyclerView recyclerView, @NonNull SwitchButton switchButton, @NonNull SwitchButton switchButton2, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull AppCompatTextView appCompatTextView3, @NonNull AppCompatTextView appCompatTextView4, @NonNull View view, @NonNull LinearLayoutCompat linearLayoutCompat3) {
        this.f79695a = constraintLayout;
        this.f79696b = appCompatImageView;
        this.f79697c = appCompatImageView2;
        this.f79698d = linearLayoutCompat;
        this.f79699f = linearLayoutCompat2;
        this.f79700g = recyclerView;
        this.f79701h = switchButton;
        this.f79702i = switchButton2;
        this.f79703j = appCompatTextView;
        this.f79704k = appCompatTextView2;
        this.f79705l = appCompatTextView3;
        this.f79706m = appCompatTextView4;
        this.f79707n = view;
        this.f79708o = linearLayoutCompat3;
    }

    @NonNull
    public static g a(@NonNull View view) {
        View viewA;
        int i11 = R$id.ivOptions;
        AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.ivSync;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) n6.b.a(view, i11);
            if (appCompatImageView2 != null) {
                i11 = R$id.llOptions;
                LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) n6.b.a(view, i11);
                if (linearLayoutCompat != null) {
                    i11 = R$id.llSync;
                    LinearLayoutCompat linearLayoutCompat2 = (LinearLayoutCompat) n6.b.a(view, i11);
                    if (linearLayoutCompat2 != null) {
                        i11 = R$id.recycler_view;
                        RecyclerView recyclerView = (RecyclerView) n6.b.a(view, i11);
                        if (recyclerView != null) {
                            i11 = R$id.switchBilingual;
                            SwitchButton switchButton = (SwitchButton) n6.b.a(view, i11);
                            if (switchButton != null) {
                                i11 = R$id.switchBtn;
                                SwitchButton switchButton2 = (SwitchButton) n6.b.a(view, i11);
                                if (switchButton2 != null) {
                                    i11 = R$id.tvBilingual;
                                    AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                                    if (appCompatTextView != null) {
                                        i11 = R$id.tvOptions;
                                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                                        if (appCompatTextView2 != null) {
                                            i11 = R$id.tvSync;
                                            AppCompatTextView appCompatTextView3 = (AppCompatTextView) n6.b.a(view, i11);
                                            if (appCompatTextView3 != null) {
                                                i11 = R$id.tvTitle;
                                                AppCompatTextView appCompatTextView4 = (AppCompatTextView) n6.b.a(view, i11);
                                                if (appCompatTextView4 != null && (viewA = n6.b.a(view, (i11 = R$id.viewLine))) != null) {
                                                    i11 = R$id.viewOptionsBg;
                                                    LinearLayoutCompat linearLayoutCompat3 = (LinearLayoutCompat) n6.b.a(view, i11);
                                                    if (linearLayoutCompat3 != null) {
                                                        return new g((ConstraintLayout) view, appCompatImageView, appCompatImageView2, linearLayoutCompat, linearLayoutCompat2, recyclerView, switchButton, switchButton2, appCompatTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4, viewA, linearLayoutCompat3);
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
    public static g c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static g d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_subtitle_select_list, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f79695a;
    }
}
