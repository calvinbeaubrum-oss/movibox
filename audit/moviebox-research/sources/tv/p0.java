package tv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class p0 implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f77890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77891b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77892c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77893d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77894f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77895g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77896h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final View f77897i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final View f77898j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final View f77899k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final View f77900l;

    public p0(@NonNull ConstraintLayout constraintLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull AppCompatImageView appCompatImageView3, @NonNull AppCompatImageView appCompatImageView4, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull View view, @NonNull View view2, @NonNull View view3, @NonNull View view4) {
        this.f77890a = constraintLayout;
        this.f77891b = appCompatImageView;
        this.f77892c = appCompatImageView2;
        this.f77893d = appCompatImageView3;
        this.f77894f = appCompatImageView4;
        this.f77895g = appCompatTextView;
        this.f77896h = appCompatTextView2;
        this.f77897i = view;
        this.f77898j = view2;
        this.f77899k = view3;
        this.f77900l = view4;
    }

    @NonNull
    public static p0 a(@NonNull View view) {
        View viewA;
        View viewA2;
        View viewA3;
        View viewA4;
        int i11 = R$id.ivComment;
        AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.ivDownload;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) n6.b.a(view, i11);
            if (appCompatImageView2 != null) {
                i11 = R$id.ivLike;
                AppCompatImageView appCompatImageView3 = (AppCompatImageView) n6.b.a(view, i11);
                if (appCompatImageView3 != null) {
                    i11 = R$id.ivShare;
                    AppCompatImageView appCompatImageView4 = (AppCompatImageView) n6.b.a(view, i11);
                    if (appCompatImageView4 != null) {
                        i11 = R$id.tvComment;
                        AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                        if (appCompatTextView != null) {
                            i11 = R$id.tvLike;
                            AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                            if (appCompatTextView2 != null && (viewA = n6.b.a(view, (i11 = R$id.viewComment))) != null && (viewA2 = n6.b.a(view, (i11 = R$id.viewDownload))) != null && (viewA3 = n6.b.a(view, (i11 = R$id.viewLike))) != null && (viewA4 = n6.b.a(view, (i11 = R$id.viewShare))) != null) {
                                return new p0((ConstraintLayout) view, appCompatImageView, appCompatImageView2, appCompatImageView3, appCompatImageView4, appCompatTextView, appCompatTextView2, viewA, viewA2, viewA3, viewA4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static p0 c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static p0 d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.view_post_detail_operation_new_layout, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f77890a;
    }
}
