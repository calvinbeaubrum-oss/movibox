package bo;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLView;
import com.permissionx.guolindev.R$id;
import n6.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final BLConstraintLayout f14293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f14294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f14295c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f14296d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f14297f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f14298g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final BLView f14299h;

    public a(@NonNull BLConstraintLayout bLConstraintLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull AppCompatTextView appCompatTextView3, @NonNull BLView bLView) {
        this.f14293a = bLConstraintLayout;
        this.f14294b = appCompatImageView;
        this.f14295c = appCompatImageView2;
        this.f14296d = appCompatTextView;
        this.f14297f = appCompatTextView2;
        this.f14298g = appCompatTextView3;
        this.f14299h = bLView;
    }

    @NonNull
    public static a a(@NonNull View view) {
        int i11 = R$id.iv_close;
        AppCompatImageView appCompatImageView = (AppCompatImageView) b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.iv_icon;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) b.a(view, i11);
            if (appCompatImageView2 != null) {
                i11 = R$id.tv_button;
                AppCompatTextView appCompatTextView = (AppCompatTextView) b.a(view, i11);
                if (appCompatTextView != null) {
                    i11 = R$id.tv_subtitle;
                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) b.a(view, i11);
                    if (appCompatTextView2 != null) {
                        i11 = R$id.tv_title;
                        AppCompatTextView appCompatTextView3 = (AppCompatTextView) b.a(view, i11);
                        if (appCompatTextView3 != null) {
                            i11 = R$id.v_icon_bg;
                            BLView bLView = (BLView) b.a(view, i11);
                            if (bLView != null) {
                                return new a((BLConstraintLayout) view, appCompatImageView, appCompatImageView2, appCompatTextView, appCompatTextView2, appCompatTextView3, bLView);
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
    public BLConstraintLayout getRoot() {
        return this.f14293a;
    }
}
