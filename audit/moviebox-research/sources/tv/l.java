package tv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.ui.view.PostDetailOperationView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class l implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f77817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f77818b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final Group f77819c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77820d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77821f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77822g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77823h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f77824i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77825j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77826k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final PostDetailOperationView f77827l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77828m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77829n;

    public l(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull Group group, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatTextView appCompatTextView3, @NonNull ShapeableImageView shapeableImageView, @NonNull AppCompatTextView appCompatTextView4, @NonNull AppCompatImageView appCompatImageView2, @NonNull PostDetailOperationView postDetailOperationView, @NonNull AppCompatTextView appCompatTextView5, @NonNull AppCompatTextView appCompatTextView6) {
        this.f77817a = constraintLayout;
        this.f77818b = constraintLayout2;
        this.f77819c = group;
        this.f77820d = appCompatTextView;
        this.f77821f = appCompatTextView2;
        this.f77822g = appCompatImageView;
        this.f77823h = appCompatTextView3;
        this.f77824i = shapeableImageView;
        this.f77825j = appCompatTextView4;
        this.f77826k = appCompatImageView2;
        this.f77827l = postDetailOperationView;
        this.f77828m = appCompatTextView5;
        this.f77829n = appCompatTextView6;
    }

    @NonNull
    public static l a(@NonNull View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i11 = R$id.groupNoCommentYet;
        Group group = (Group) n6.b.a(view, i11);
        if (group != null) {
            i11 = R$id.itemCommentContent;
            AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
            if (appCompatTextView != null) {
                i11 = R$id.itemCommentData;
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                if (appCompatTextView2 != null) {
                    i11 = R$id.itemCommentLikeIcon;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
                    if (appCompatImageView != null) {
                        i11 = R$id.itemCommentReply;
                        AppCompatTextView appCompatTextView3 = (AppCompatTextView) n6.b.a(view, i11);
                        if (appCompatTextView3 != null) {
                            i11 = R$id.itemCommentUserAvatar;
                            ShapeableImageView shapeableImageView = (ShapeableImageView) n6.b.a(view, i11);
                            if (shapeableImageView != null) {
                                i11 = R$id.itemCommentUserName;
                                AppCompatTextView appCompatTextView4 = (AppCompatTextView) n6.b.a(view, i11);
                                if (appCompatTextView4 != null) {
                                    i11 = R$id.ivRight;
                                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) n6.b.a(view, i11);
                                    if (appCompatImageView2 != null) {
                                        i11 = R$id.postDetailOperationView;
                                        PostDetailOperationView postDetailOperationView = (PostDetailOperationView) n6.b.a(view, i11);
                                        if (postDetailOperationView != null) {
                                            i11 = R$id.tvComments;
                                            AppCompatTextView appCompatTextView5 = (AppCompatTextView) n6.b.a(view, i11);
                                            if (appCompatTextView5 != null) {
                                                i11 = R$id.tvNoCommentYet;
                                                AppCompatTextView appCompatTextView6 = (AppCompatTextView) n6.b.a(view, i11);
                                                if (appCompatTextView6 != null) {
                                                    return new l(constraintLayout, constraintLayout, group, appCompatTextView, appCompatTextView2, appCompatImageView, appCompatTextView3, shapeableImageView, appCompatTextView4, appCompatImageView2, postDetailOperationView, appCompatTextView5, appCompatTextView6);
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
    public static l c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static l d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_post_detail_comments_layout, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f77817a;
    }
}
