package h00;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.widget.DownloadPremiumView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class o0 implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f65972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f65973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final DownloadPremiumView f65974c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f65975d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f65976f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f65977g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f65978h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final View f65979i;

    public o0(@NonNull ConstraintLayout constraintLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull DownloadPremiumView downloadPremiumView, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull AppCompatTextView appCompatTextView3, @NonNull AppCompatTextView appCompatTextView4, @NonNull View view) {
        this.f65972a = constraintLayout;
        this.f65973b = appCompatImageView;
        this.f65974c = downloadPremiumView;
        this.f65975d = appCompatTextView;
        this.f65976f = appCompatTextView2;
        this.f65977g = appCompatTextView3;
        this.f65978h = appCompatTextView4;
        this.f65979i = view;
    }

    @NonNull
    public static o0 a(@NonNull View view) {
        View viewA;
        int i11 = R$id.iv_check;
        AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.iv_premium;
            DownloadPremiumView downloadPremiumView = (DownloadPremiumView) n6.b.a(view, i11);
            if (downloadPremiumView != null) {
                i11 = R$id.tv_ep;
                AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                if (appCompatTextView != null) {
                    i11 = R$id.tv_size;
                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                    if (appCompatTextView2 != null) {
                        i11 = R$id.tv_time;
                        AppCompatTextView appCompatTextView3 = (AppCompatTextView) n6.b.a(view, i11);
                        if (appCompatTextView3 != null) {
                            i11 = R$id.tv_title;
                            AppCompatTextView appCompatTextView4 = (AppCompatTextView) n6.b.a(view, i11);
                            if (appCompatTextView4 != null && (viewA = n6.b.a(view, (i11 = R$id.v_size_line))) != null) {
                                return new o0((ConstraintLayout) view, appCompatImageView, downloadPremiumView, appCompatTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4, viewA);
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
        return this.f65972a;
    }
}
