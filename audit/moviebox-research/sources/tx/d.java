package tx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.subroom.R$id;
import com.transsion.subroom.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class d implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f78067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f78068b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f78069c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f78070d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f78071f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f78072g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f78073h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f78074i;

    public d(@NonNull ConstraintLayout constraintLayout, @NonNull View view, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatTextView appCompatTextView2, @NonNull LinearLayoutCompat linearLayoutCompat, @NonNull AppCompatTextView appCompatTextView3, @NonNull AppCompatTextView appCompatTextView4) {
        this.f78067a = constraintLayout;
        this.f78068b = view;
        this.f78069c = appCompatTextView;
        this.f78070d = appCompatImageView;
        this.f78071f = appCompatTextView2;
        this.f78072g = linearLayoutCompat;
        this.f78073h = appCompatTextView3;
        this.f78074i = appCompatTextView4;
    }

    @NonNull
    public static d a(@NonNull View view) {
        int i11 = R$id.bg_transparent;
        View viewA = n6.b.a(view, i11);
        if (viewA != null) {
            i11 = R$id.guide_desc;
            AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
            if (appCompatTextView != null) {
                i11 = R$id.guide_image;
                AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
                if (appCompatImageView != null) {
                    i11 = R$id.guide_title;
                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                    if (appCompatTextView2 != null) {
                        i11 = R$id.ll_no_network;
                        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) n6.b.a(view, i11);
                        if (linearLayoutCompat != null) {
                            i11 = R$id.no_network_tip;
                            AppCompatTextView appCompatTextView3 = (AppCompatTextView) n6.b.a(view, i11);
                            if (appCompatTextView3 != null) {
                                i11 = R$id.tv_setting;
                                AppCompatTextView appCompatTextView4 = (AppCompatTextView) n6.b.a(view, i11);
                                if (appCompatTextView4 != null) {
                                    return new d((ConstraintLayout) view, viewA, appCompatTextView, appCompatImageView, appCompatTextView2, linearLayoutCompat, appCompatTextView3, appCompatTextView4);
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
    public static d c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static d d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_guide, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f78067a;
    }
}
