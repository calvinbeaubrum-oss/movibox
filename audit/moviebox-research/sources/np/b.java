package np;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.tn.lib.tranpay.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f72102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f72103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f72104c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatEditText f72105d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatEditText f72106f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f72107g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final FrameLayout f72108h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f72109i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f72110j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final View f72111k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f72112l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f72113m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f72114n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f72115o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f72116p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f72117q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f72118r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f72119s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f72120t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @NonNull
    public final View f72121u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f72122v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @NonNull
    public final NestedScrollView f72123w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @NonNull
    public final View f72124x;

    public b(@NonNull LinearLayoutCompat linearLayoutCompat, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull AppCompatEditText appCompatEditText, @NonNull AppCompatEditText appCompatEditText2, @NonNull AppCompatTextView appCompatTextView, @NonNull FrameLayout frameLayout, @NonNull AppCompatImageView appCompatImageView3, @NonNull ConstraintLayout constraintLayout, @NonNull View view, @NonNull AppCompatTextView appCompatTextView2, @NonNull AppCompatTextView appCompatTextView3, @NonNull AppCompatTextView appCompatTextView4, @NonNull AppCompatTextView appCompatTextView5, @NonNull AppCompatTextView appCompatTextView6, @NonNull AppCompatTextView appCompatTextView7, @NonNull AppCompatTextView appCompatTextView8, @NonNull AppCompatTextView appCompatTextView9, @NonNull ConstraintLayout constraintLayout2, @NonNull View view2, @NonNull LinearLayoutCompat linearLayoutCompat2, @NonNull NestedScrollView nestedScrollView, @NonNull View view3) {
        this.f72102a = linearLayoutCompat;
        this.f72103b = appCompatImageView;
        this.f72104c = appCompatImageView2;
        this.f72105d = appCompatEditText;
        this.f72106f = appCompatEditText2;
        this.f72107g = appCompatTextView;
        this.f72108h = frameLayout;
        this.f72109i = appCompatImageView3;
        this.f72110j = constraintLayout;
        this.f72111k = view;
        this.f72112l = appCompatTextView2;
        this.f72113m = appCompatTextView3;
        this.f72114n = appCompatTextView4;
        this.f72115o = appCompatTextView5;
        this.f72116p = appCompatTextView6;
        this.f72117q = appCompatTextView7;
        this.f72118r = appCompatTextView8;
        this.f72119s = appCompatTextView9;
        this.f72120t = constraintLayout2;
        this.f72121u = view2;
        this.f72122v = linearLayoutCompat2;
        this.f72123w = nestedScrollView;
        this.f72124x = view3;
    }

    @NonNull
    public static b a(@NonNull View view) {
        View viewA;
        View viewA2;
        View viewA3;
        int i11 = R$id.clear_cnic_button;
        AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.clear_phone_button;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) n6.b.a(view, i11);
            if (appCompatImageView2 != null) {
                i11 = R$id.input_cnic;
                AppCompatEditText appCompatEditText = (AppCompatEditText) n6.b.a(view, i11);
                if (appCompatEditText != null) {
                    i11 = R$id.input_phone;
                    AppCompatEditText appCompatEditText2 = (AppCompatEditText) n6.b.a(view, i11);
                    if (appCompatEditText2 != null) {
                        i11 = R$id.iv_amount;
                        AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                        if (appCompatTextView != null) {
                            i11 = R$id.iv_back;
                            FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
                            if (frameLayout != null) {
                                i11 = R$id.iv_close;
                                AppCompatImageView appCompatImageView3 = (AppCompatImageView) n6.b.a(view, i11);
                                if (appCompatImageView3 != null) {
                                    i11 = R$id.iv_cnic_container;
                                    ConstraintLayout constraintLayout = (ConstraintLayout) n6.b.a(view, i11);
                                    if (constraintLayout != null && (viewA = n6.b.a(view, (i11 = R$id.iv_cnic_container_line))) != null) {
                                        i11 = R$id.iv_company;
                                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                                        if (appCompatTextView2 != null) {
                                            i11 = R$id.iv_desc;
                                            AppCompatTextView appCompatTextView3 = (AppCompatTextView) n6.b.a(view, i11);
                                            if (appCompatTextView3 != null) {
                                                i11 = R$id.iv_input_cnic_error;
                                                AppCompatTextView appCompatTextView4 = (AppCompatTextView) n6.b.a(view, i11);
                                                if (appCompatTextView4 != null) {
                                                    i11 = R$id.iv_input_phone_error;
                                                    AppCompatTextView appCompatTextView5 = (AppCompatTextView) n6.b.a(view, i11);
                                                    if (appCompatTextView5 != null) {
                                                        i11 = R$id.iv_order_id;
                                                        AppCompatTextView appCompatTextView6 = (AppCompatTextView) n6.b.a(view, i11);
                                                        if (appCompatTextView6 != null) {
                                                            i11 = R$id.iv_pay_button;
                                                            AppCompatTextView appCompatTextView7 = (AppCompatTextView) n6.b.a(view, i11);
                                                            if (appCompatTextView7 != null) {
                                                                i11 = R$id.iv_payment_method;
                                                                AppCompatTextView appCompatTextView8 = (AppCompatTextView) n6.b.a(view, i11);
                                                                if (appCompatTextView8 != null) {
                                                                    i11 = R$id.iv_phone_code;
                                                                    AppCompatTextView appCompatTextView9 = (AppCompatTextView) n6.b.a(view, i11);
                                                                    if (appCompatTextView9 != null) {
                                                                        i11 = R$id.iv_phone_container;
                                                                        ConstraintLayout constraintLayout2 = (ConstraintLayout) n6.b.a(view, i11);
                                                                        if (constraintLayout2 != null && (viewA2 = n6.b.a(view, (i11 = R$id.iv_phone_container_line))) != null) {
                                                                            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view;
                                                                            i11 = R$id.scroll_view;
                                                                            NestedScrollView nestedScrollView = (NestedScrollView) n6.b.a(view, i11);
                                                                            if (nestedScrollView != null && (viewA3 = n6.b.a(view, (i11 = R$id.view))) != null) {
                                                                                return new b(linearLayoutCompat, appCompatImageView, appCompatImageView2, appCompatEditText, appCompatEditText2, appCompatTextView, frameLayout, appCompatImageView3, constraintLayout, viewA, appCompatTextView2, appCompatTextView3, appCompatTextView4, appCompatTextView5, appCompatTextView6, appCompatTextView7, appCompatTextView8, appCompatTextView9, constraintLayout2, viewA2, linearLayoutCompat, nestedScrollView, viewA3);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.f72102a;
    }
}
