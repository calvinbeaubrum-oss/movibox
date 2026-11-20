package qu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.baseui.widget.GradientBorderView;
import com.transsion.member.R$id;
import com.transsion.member.R$layout;
import com.transsion.member.widget.PointView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class i implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f74950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f74951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f74952c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f74953d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final GradientBorderView f74954f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final PointView f74955g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f74956h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f74957i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f74958j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f74959k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f74960l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final GradientBorderView f74961m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f74962n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f74963o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NonNull
    public final PointView f74964p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f74965q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @NonNull
    public final RecyclerView f74966r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    public final RecyclerView f74967s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f74968t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @NonNull
    public final RecyclerView f74969u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @NonNull
    public final NestedScrollView f74970v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @NonNull
    public final GradientBorderView f74971w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f74972x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f74973y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f74974z;

    public i(@NonNull LinearLayoutCompat linearLayoutCompat, @NonNull ShapeableImageView shapeableImageView, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatTextView appCompatTextView, @NonNull GradientBorderView gradientBorderView, @NonNull PointView pointView, @NonNull ConstraintLayout constraintLayout, @NonNull AppCompatTextView appCompatTextView2, @NonNull AppCompatTextView appCompatTextView3, @NonNull LinearLayoutCompat linearLayoutCompat2, @NonNull AppCompatTextView appCompatTextView4, @NonNull GradientBorderView gradientBorderView2, @NonNull AppCompatTextView appCompatTextView5, @NonNull AppCompatImageView appCompatImageView2, @NonNull PointView pointView2, @NonNull AppCompatTextView appCompatTextView6, @NonNull RecyclerView recyclerView, @NonNull RecyclerView recyclerView2, @NonNull AppCompatTextView appCompatTextView7, @NonNull RecyclerView recyclerView3, @NonNull NestedScrollView nestedScrollView, @NonNull GradientBorderView gradientBorderView3, @NonNull ConstraintLayout constraintLayout2, @NonNull ConstraintLayout constraintLayout3, @NonNull AppCompatTextView appCompatTextView8) {
        this.f74950a = linearLayoutCompat;
        this.f74951b = shapeableImageView;
        this.f74952c = appCompatImageView;
        this.f74953d = appCompatTextView;
        this.f74954f = gradientBorderView;
        this.f74955g = pointView;
        this.f74956h = constraintLayout;
        this.f74957i = appCompatTextView2;
        this.f74958j = appCompatTextView3;
        this.f74959k = linearLayoutCompat2;
        this.f74960l = appCompatTextView4;
        this.f74961m = gradientBorderView2;
        this.f74962n = appCompatTextView5;
        this.f74963o = appCompatImageView2;
        this.f74964p = pointView2;
        this.f74965q = appCompatTextView6;
        this.f74966r = recyclerView;
        this.f74967s = recyclerView2;
        this.f74968t = appCompatTextView7;
        this.f74969u = recyclerView3;
        this.f74970v = nestedScrollView;
        this.f74971w = gradientBorderView3;
        this.f74972x = constraintLayout2;
        this.f74973y = constraintLayout3;
        this.f74974z = appCompatTextView8;
    }

    @NonNull
    public static i a(@NonNull View view) {
        int i11 = R$id.iv_avatar_premium;
        ShapeableImageView shapeableImageView = (ShapeableImageView) n6.b.a(view, i11);
        if (shapeableImageView != null) {
            i11 = R$id.iv_back;
            AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.iv_detail_title;
                AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                if (appCompatTextView != null) {
                    i11 = R$id.iv_free_container;
                    GradientBorderView gradientBorderView = (GradientBorderView) n6.b.a(view, i11);
                    if (gradientBorderView != null) {
                        i11 = R$id.iv_free_points;
                        PointView pointView = (PointView) n6.b.a(view, i11);
                        if (pointView != null) {
                            i11 = R$id.iv_info;
                            ConstraintLayout constraintLayout = (ConstraintLayout) n6.b.a(view, i11);
                            if (constraintLayout != null) {
                                i11 = R$id.iv_name;
                                AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                                if (appCompatTextView2 != null) {
                                    i11 = R$id.iv_next_billing_date;
                                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) n6.b.a(view, i11);
                                    if (appCompatTextView3 != null) {
                                        i11 = R$id.iv_or;
                                        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) n6.b.a(view, i11);
                                        if (linearLayoutCompat != null) {
                                            i11 = R$id.iv_premium;
                                            AppCompatTextView appCompatTextView4 = (AppCompatTextView) n6.b.a(view, i11);
                                            if (appCompatTextView4 != null) {
                                                i11 = R$id.iv_premium_container;
                                                GradientBorderView gradientBorderView2 = (GradientBorderView) n6.b.a(view, i11);
                                                if (gradientBorderView2 != null) {
                                                    i11 = R$id.iv_premium_info;
                                                    AppCompatTextView appCompatTextView5 = (AppCompatTextView) n6.b.a(view, i11);
                                                    if (appCompatTextView5 != null) {
                                                        i11 = R$id.iv_premium_mask;
                                                        AppCompatImageView appCompatImageView2 = (AppCompatImageView) n6.b.a(view, i11);
                                                        if (appCompatImageView2 != null) {
                                                            i11 = R$id.iv_premium_points;
                                                            PointView pointView2 = (PointView) n6.b.a(view, i11);
                                                            if (pointView2 != null) {
                                                                i11 = R$id.iv_premium_title;
                                                                AppCompatTextView appCompatTextView6 = (AppCompatTextView) n6.b.a(view, i11);
                                                                if (appCompatTextView6 != null) {
                                                                    i11 = R$id.iv_redeem_list;
                                                                    RecyclerView recyclerView = (RecyclerView) n6.b.a(view, i11);
                                                                    if (recyclerView != null) {
                                                                        i11 = R$id.iv_sku_list;
                                                                        RecyclerView recyclerView2 = (RecyclerView) n6.b.a(view, i11);
                                                                        if (recyclerView2 != null) {
                                                                            i11 = R$id.iv_subscription_desc;
                                                                            AppCompatTextView appCompatTextView7 = (AppCompatTextView) n6.b.a(view, i11);
                                                                            if (appCompatTextView7 != null) {
                                                                                i11 = R$id.iv_task_list;
                                                                                RecyclerView recyclerView3 = (RecyclerView) n6.b.a(view, i11);
                                                                                if (recyclerView3 != null) {
                                                                                    i11 = R$id.scroll_view;
                                                                                    NestedScrollView nestedScrollView = (NestedScrollView) n6.b.a(view, i11);
                                                                                    if (nestedScrollView != null) {
                                                                                        i11 = R$id.task_container_bar;
                                                                                        GradientBorderView gradientBorderView3 = (GradientBorderView) n6.b.a(view, i11);
                                                                                        if (gradientBorderView3 != null) {
                                                                                            i11 = R$id.titleLayout;
                                                                                            ConstraintLayout constraintLayout2 = (ConstraintLayout) n6.b.a(view, i11);
                                                                                            if (constraintLayout2 != null) {
                                                                                                i11 = R$id.top_layout;
                                                                                                ConstraintLayout constraintLayout3 = (ConstraintLayout) n6.b.a(view, i11);
                                                                                                if (constraintLayout3 != null) {
                                                                                                    i11 = R$id.tv_promo_code;
                                                                                                    AppCompatTextView appCompatTextView8 = (AppCompatTextView) n6.b.a(view, i11);
                                                                                                    if (appCompatTextView8 != null) {
                                                                                                        return new i((LinearLayoutCompat) view, shapeableImageView, appCompatImageView, appCompatTextView, gradientBorderView, pointView, constraintLayout, appCompatTextView2, appCompatTextView3, linearLayoutCompat, appCompatTextView4, gradientBorderView2, appCompatTextView5, appCompatImageView2, pointView2, appCompatTextView6, recyclerView, recyclerView2, appCompatTextView7, recyclerView3, nestedScrollView, gradientBorderView3, constraintLayout2, constraintLayout3, appCompatTextView8);
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
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static i c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static i d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_member_layout, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.f74950a;
    }
}
