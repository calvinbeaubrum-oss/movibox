package tv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.tn.lib.view.TitleLayout;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.ui.view.PostDetailItemView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class n implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f77861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppBarLayout f77862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f77863c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final FrameLayout f77864d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final PostDetailItemView f77865f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final TitleLayout f77866g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77867h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77868i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final View f77869j;

    public n(@NonNull ConstraintLayout constraintLayout, @NonNull AppBarLayout appBarLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull FrameLayout frameLayout, @NonNull PostDetailItemView postDetailItemView, @NonNull TitleLayout titleLayout, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull View view) {
        this.f77861a = constraintLayout;
        this.f77862b = appBarLayout;
        this.f77863c = constraintLayout2;
        this.f77864d = frameLayout;
        this.f77865f = postDetailItemView;
        this.f77866g = titleLayout;
        this.f77867h = appCompatTextView;
        this.f77868i = appCompatTextView2;
        this.f77869j = view;
    }

    @NonNull
    public static n a(@NonNull View view) {
        View viewA;
        int i11 = R$id.app_bar_layout;
        AppBarLayout appBarLayout = (AppBarLayout) n6.b.a(view, i11);
        if (appBarLayout != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i11 = R$id.fl_comment_container;
            FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
            if (frameLayout != null) {
                i11 = R$id.postDetailItem;
                PostDetailItemView postDetailItemView = (PostDetailItemView) n6.b.a(view, i11);
                if (postDetailItemView != null) {
                    i11 = R$id.titleLayout;
                    TitleLayout titleLayout = (TitleLayout) n6.b.a(view, i11);
                    if (titleLayout != null) {
                        i11 = R$id.tv_comment;
                        AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                        if (appCompatTextView != null) {
                            i11 = R$id.tv_comment_num;
                            AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                            if (appCompatTextView2 != null && (viewA = n6.b.a(view, (i11 = R$id.v_bottom))) != null) {
                                return new n(constraintLayout, appBarLayout, constraintLayout, frameLayout, postDetailItemView, titleLayout, appCompatTextView, appCompatTextView2, viewA);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static n c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static n d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_post_detail_layout, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f77861a;
    }
}
