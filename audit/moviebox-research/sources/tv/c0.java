package tv;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import com.noober.background.view.BLImageView;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;
import com.transsion.postdetail.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class c0 implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f77706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77708c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final BLTextView f77709d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final BLView f77710f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final BLImageView f77711g;

    public c0(@NonNull View view, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull BLTextView bLTextView, @NonNull BLView bLView, @NonNull BLImageView bLImageView) {
        this.f77706a = view;
        this.f77707b = appCompatImageView;
        this.f77708c = appCompatImageView2;
        this.f77709d = bLTextView;
        this.f77710f = bLView;
        this.f77711g = bLImageView;
    }

    @NonNull
    public static c0 a(@NonNull View view) {
        int i11 = R$id.iv_short_tv_guide_arrow_1;
        AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.iv_short_tv_guide_arrow_2;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) n6.b.a(view, i11);
            if (appCompatImageView2 != null) {
                i11 = R$id.tv_short_tv_guide_ep;
                BLTextView bLTextView = (BLTextView) n6.b.a(view, i11);
                if (bLTextView != null) {
                    i11 = R$id.tv_short_tv_guide_ep_bg;
                    BLView bLView = (BLView) n6.b.a(view, i11);
                    if (bLView != null) {
                        i11 = R$id.tv_short_tv_guide_list;
                        BLImageView bLImageView = (BLImageView) n6.b.a(view, i11);
                        if (bLImageView != null) {
                            return new c0(view, appCompatImageView, appCompatImageView2, bLTextView, bLView, bLImageView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // n6.a
    @NonNull
    public View getRoot() {
        return this.f77706a;
    }
}
