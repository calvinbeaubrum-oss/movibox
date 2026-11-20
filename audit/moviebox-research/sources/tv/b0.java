package tv;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLLinearLayout;
import com.transsion.postdetail.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class b0 implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final BLLinearLayout f77691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f77692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f77693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f77694d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77695f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final LinearLayout f77696g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77697h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77698i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77699j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77700k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final View f77701l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final View f77702m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    public final View f77703n;

    public b0(@NonNull BLLinearLayout bLLinearLayout, @NonNull ConstraintLayout constraintLayout, @NonNull ShapeableImageView shapeableImageView, @NonNull ShapeableImageView shapeableImageView2, @NonNull AppCompatImageView appCompatImageView, @NonNull LinearLayout linearLayout, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull AppCompatTextView appCompatTextView3, @NonNull AppCompatTextView appCompatTextView4, @NonNull View view, @NonNull View view2, @NonNull View view3) {
        this.f77691a = bLLinearLayout;
        this.f77692b = constraintLayout;
        this.f77693c = shapeableImageView;
        this.f77694d = shapeableImageView2;
        this.f77695f = appCompatImageView;
        this.f77696g = linearLayout;
        this.f77697h = appCompatTextView;
        this.f77698i = appCompatTextView2;
        this.f77699j = appCompatTextView3;
        this.f77700k = appCompatTextView4;
        this.f77701l = view;
        this.f77702m = view2;
        this.f77703n = view3;
    }

    @NonNull
    public static b0 a(@NonNull View view) {
        View viewA;
        View viewA2;
        View viewA3;
        int i11 = R$id.cl_subject_content;
        ConstraintLayout constraintLayout = (ConstraintLayout) n6.b.a(view, i11);
        if (constraintLayout != null) {
            i11 = R$id.iv_room_cover;
            ShapeableImageView shapeableImageView = (ShapeableImageView) n6.b.a(view, i11);
            if (shapeableImageView != null) {
                i11 = R$id.iv_subject_cover;
                ShapeableImageView shapeableImageView2 = (ShapeableImageView) n6.b.a(view, i11);
                if (shapeableImageView2 != null) {
                    i11 = R$id.iv_subject_tag;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
                    if (appCompatImageView != null) {
                        i11 = R$id.ll_room_tag;
                        LinearLayout linearLayout = (LinearLayout) n6.b.a(view, i11);
                        if (linearLayout != null) {
                            i11 = R$id.tv_room_tag;
                            AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                            if (appCompatTextView != null) {
                                i11 = R$id.tv_subject_date;
                                AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                                if (appCompatTextView2 != null) {
                                    i11 = R$id.tv_subject_genre;
                                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) n6.b.a(view, i11);
                                    if (appCompatTextView3 != null) {
                                        i11 = R$id.tv_subject_name;
                                        AppCompatTextView appCompatTextView4 = (AppCompatTextView) n6.b.a(view, i11);
                                        if (appCompatTextView4 != null && (viewA = n6.b.a(view, (i11 = R$id.v_subject_line_1))) != null && (viewA2 = n6.b.a(view, (i11 = R$id.v_subject_line_2))) != null && (viewA3 = n6.b.a(view, (i11 = R$id.v_subject_room_line))) != null) {
                                            return new b0((BLLinearLayout) view, constraintLayout, shapeableImageView, shapeableImageView2, appCompatImageView, linearLayout, appCompatTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4, viewA, viewA2, viewA3);
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
    public BLLinearLayout getRoot() {
        return this.f77691a;
    }
}
