package tv;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLView;
import com.tn.lib.view.NoScrollRecyclerView2;
import com.transsion.postdetail.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class t implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f77928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f77929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final FrameLayout f77930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77931d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77932f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f77933g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f77934h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f77935i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final b0 f77936j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final d0 f77937k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final NoScrollRecyclerView2 f77938l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77939m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77940n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77941o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77942p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77943q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77944r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    public final View f77945s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @NonNull
    public final View f77946t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @NonNull
    public final View f77947u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @NonNull
    public final View f77948v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @NonNull
    public final View f77949w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    public final BLView f77950x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @Nullable
    public final BLView f77951y;

    public t(@NonNull View view, @NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull ShapeableImageView shapeableImageView, @NonNull ShapeableImageView shapeableImageView2, @NonNull ShapeableImageView shapeableImageView3, @NonNull b0 b0Var, @NonNull d0 d0Var, @NonNull NoScrollRecyclerView2 noScrollRecyclerView2, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull AppCompatTextView appCompatTextView3, @NonNull AppCompatTextView appCompatTextView4, @NonNull AppCompatTextView appCompatTextView5, @NonNull AppCompatTextView appCompatTextView6, @NonNull View view2, @NonNull View view3, @NonNull View view4, @NonNull View view5, @NonNull View view6, @Nullable BLView bLView, @Nullable BLView bLView2) {
        this.f77928a = view;
        this.f77929b = frameLayout;
        this.f77930c = frameLayout2;
        this.f77931d = appCompatImageView;
        this.f77932f = appCompatImageView2;
        this.f77933g = shapeableImageView;
        this.f77934h = shapeableImageView2;
        this.f77935i = shapeableImageView3;
        this.f77936j = b0Var;
        this.f77937k = d0Var;
        this.f77938l = noScrollRecyclerView2;
        this.f77939m = appCompatTextView;
        this.f77940n = appCompatTextView2;
        this.f77941o = appCompatTextView3;
        this.f77942p = appCompatTextView4;
        this.f77943q = appCompatTextView5;
        this.f77944r = appCompatTextView6;
        this.f77945s = view2;
        this.f77946t = view3;
        this.f77947u = view4;
        this.f77948v = view5;
        this.f77949w = view6;
        this.f77950x = bLView;
        this.f77951y = bLView2;
    }

    @NonNull
    public static t a(@NonNull View view) {
        View viewA;
        View viewA2;
        View viewA3;
        View viewA4;
        View viewA5;
        View viewA6;
        int i11 = R$id.fl_content;
        FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
        if (frameLayout != null) {
            i11 = R$id.fl_cover;
            FrameLayout frameLayout2 = (FrameLayout) n6.b.a(view, i11);
            if (frameLayout2 != null) {
                i11 = R$id.iv_location_icon;
                AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
                if (appCompatImageView != null) {
                    i11 = R$id.iv_post_share;
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) n6.b.a(view, i11);
                    if (appCompatImageView2 != null) {
                        i11 = R$id.iv_room_cover;
                        ShapeableImageView shapeableImageView = (ShapeableImageView) n6.b.a(view, i11);
                        if (shapeableImageView != null) {
                            i11 = R$id.iv_user_avatar;
                            ShapeableImageView shapeableImageView2 = (ShapeableImageView) n6.b.a(view, i11);
                            if (shapeableImageView2 != null) {
                                i11 = R$id.iv_user_avatar_2;
                                ShapeableImageView shapeableImageView3 = (ShapeableImageView) n6.b.a(view, i11);
                                if (shapeableImageView3 != null && (viewA = n6.b.a(view, (i11 = R$id.layout_bottom_module))) != null) {
                                    b0 b0VarA = b0.a(viewA);
                                    i11 = R$id.layout_content_video;
                                    View viewA7 = n6.b.a(view, i11);
                                    if (viewA7 != null) {
                                        d0 d0VarA = d0.a(viewA7);
                                        i11 = R$id.recycler_view_post;
                                        NoScrollRecyclerView2 noScrollRecyclerView2 = (NoScrollRecyclerView2) n6.b.a(view, i11);
                                        if (noScrollRecyclerView2 != null) {
                                            i11 = R$id.tv_post_comment;
                                            AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                                            if (appCompatTextView != null) {
                                                i11 = R$id.tv_post_content;
                                                AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                                                if (appCompatTextView2 != null) {
                                                    i11 = R$id.tv_post_date;
                                                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) n6.b.a(view, i11);
                                                    if (appCompatTextView3 != null) {
                                                        i11 = R$id.tv_post_like;
                                                        AppCompatTextView appCompatTextView4 = (AppCompatTextView) n6.b.a(view, i11);
                                                        if (appCompatTextView4 != null) {
                                                            i11 = R$id.tv_room_name;
                                                            AppCompatTextView appCompatTextView5 = (AppCompatTextView) n6.b.a(view, i11);
                                                            if (appCompatTextView5 != null) {
                                                                i11 = R$id.tv_user_name_or_location;
                                                                AppCompatTextView appCompatTextView6 = (AppCompatTextView) n6.b.a(view, i11);
                                                                if (appCompatTextView6 != null && (viewA2 = n6.b.a(view, (i11 = R$id.v_bottom_line))) != null && (viewA3 = n6.b.a(view, (i11 = R$id.v_location_line))) != null && (viewA4 = n6.b.a(view, (i11 = R$id.v_post_comment))) != null && (viewA5 = n6.b.a(view, (i11 = R$id.v_post_like))) != null && (viewA6 = n6.b.a(view, (i11 = R$id.v_post_share))) != null) {
                                                                    return new t(view, frameLayout, frameLayout2, appCompatImageView, appCompatImageView2, shapeableImageView, shapeableImageView2, shapeableImageView3, b0VarA, d0VarA, noScrollRecyclerView2, appCompatTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4, appCompatTextView5, appCompatTextView6, viewA2, viewA3, viewA4, viewA5, viewA6, (BLView) n6.b.a(view, R$id.v_room_cover_stroke), (BLView) n6.b.a(view, R$id.v_user_avatar_2_stroke));
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
    public View getRoot() {
        return this.f77928a;
    }
}
