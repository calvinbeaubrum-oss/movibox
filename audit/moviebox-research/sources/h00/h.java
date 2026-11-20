package h00;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsnet.downloader.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class h implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f65878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f65879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final View f65880c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f65881d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f65882f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f65883g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f65884h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f65885i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f65886j;

    public h(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull View view, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull AppCompatImageView appCompatImageView3, @NonNull AppCompatImageView appCompatImageView4, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2) {
        this.f65878a = constraintLayout;
        this.f65879b = textView;
        this.f65880c = view;
        this.f65881d = appCompatImageView;
        this.f65882f = appCompatImageView2;
        this.f65883g = appCompatImageView3;
        this.f65884h = appCompatImageView4;
        this.f65885i = appCompatTextView;
        this.f65886j = appCompatTextView2;
    }

    @NonNull
    public static h a(@NonNull View view) {
        View viewA;
        int i11 = R$id.btn_bottom;
        TextView textView = (TextView) n6.b.a(view, i11);
        if (textView != null && (viewA = n6.b.a(view, (i11 = R$id.btn_top))) != null) {
            i11 = R$id.ivAdIcon;
            AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.ivAdLoading;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) n6.b.a(view, i11);
                if (appCompatImageView2 != null) {
                    i11 = R$id.iv_back;
                    AppCompatImageView appCompatImageView3 = (AppCompatImageView) n6.b.a(view, i11);
                    if (appCompatImageView3 != null) {
                        i11 = R$id.iv_icon;
                        AppCompatImageView appCompatImageView4 = (AppCompatImageView) n6.b.a(view, i11);
                        if (appCompatImageView4 != null) {
                            i11 = R$id.tvAdWatchAVideo;
                            AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                            if (appCompatTextView != null) {
                                i11 = R$id.tv_tips;
                                AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                                if (appCompatTextView2 != null) {
                                    return new h((ConstraintLayout) view, textView, viewA, appCompatImageView, appCompatImageView2, appCompatImageView3, appCompatImageView4, appCompatTextView, appCompatTextView2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f65878a;
    }
}
