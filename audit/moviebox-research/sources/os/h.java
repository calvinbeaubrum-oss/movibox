package os;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.commercialization.R$id;
import com.transsion.commercialization.pslink.PsLinkDownLoadButton;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class h implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f73411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f73412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f73413c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f73414d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final PsLinkDownLoadButton f73415f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f73416g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f73417h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f73418i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final View f73419j;

    public h(@NonNull View view, @NonNull ShapeableImageView shapeableImageView, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull PsLinkDownLoadButton psLinkDownLoadButton, @NonNull AppCompatTextView appCompatTextView3, @NonNull AppCompatTextView appCompatTextView4, @NonNull AppCompatTextView appCompatTextView5, @NonNull View view2) {
        this.f73411a = view;
        this.f73412b = shapeableImageView;
        this.f73413c = appCompatTextView;
        this.f73414d = appCompatTextView2;
        this.f73415f = psLinkDownLoadButton;
        this.f73416g = appCompatTextView3;
        this.f73417h = appCompatTextView4;
        this.f73418i = appCompatTextView5;
        this.f73419j = view2;
    }

    @NonNull
    public static h a(@NonNull View view) {
        View viewA;
        int i11 = R$id.iv_cover;
        ShapeableImageView shapeableImageView = (ShapeableImageView) n6.b.a(view, i11);
        if (shapeableImageView != null) {
            i11 = R$id.tv_aha_btn;
            AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
            if (appCompatTextView != null) {
                i11 = R$id.tv_category;
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                if (appCompatTextView2 != null) {
                    i11 = R$id.tv_ps_btn;
                    PsLinkDownLoadButton psLinkDownLoadButton = (PsLinkDownLoadButton) n6.b.a(view, i11);
                    if (psLinkDownLoadButton != null) {
                        i11 = R$id.tv_size;
                        AppCompatTextView appCompatTextView3 = (AppCompatTextView) n6.b.a(view, i11);
                        if (appCompatTextView3 != null) {
                            i11 = R$id.tv_star;
                            AppCompatTextView appCompatTextView4 = (AppCompatTextView) n6.b.a(view, i11);
                            if (appCompatTextView4 != null) {
                                i11 = R$id.tv_title;
                                AppCompatTextView appCompatTextView5 = (AppCompatTextView) n6.b.a(view, i11);
                                if (appCompatTextView5 != null && (viewA = n6.b.a(view, (i11 = R$id.v_line))) != null) {
                                    return new h(view, shapeableImageView, appCompatTextView, appCompatTextView2, psLinkDownLoadButton, appCompatTextView3, appCompatTextView4, appCompatTextView5, viewA);
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
    public View getRoot() {
        return this.f73411a;
    }
}
