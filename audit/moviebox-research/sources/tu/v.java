package tu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class v implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final HorizontalScrollView f77637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f77638b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77639c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77640d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77641f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77642g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f77643h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77644i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77645j;

    public v(@NonNull HorizontalScrollView horizontalScrollView, @NonNull ShapeableImageView shapeableImageView, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull AppCompatTextView appCompatTextView3, @NonNull AppCompatTextView appCompatTextView4, @NonNull ConstraintLayout constraintLayout, @NonNull AppCompatTextView appCompatTextView5, @NonNull AppCompatTextView appCompatTextView6) {
        this.f77637a = horizontalScrollView;
        this.f77638b = shapeableImageView;
        this.f77639c = appCompatTextView;
        this.f77640d = appCompatTextView2;
        this.f77641f = appCompatTextView3;
        this.f77642g = appCompatTextView4;
        this.f77643h = constraintLayout;
        this.f77644i = appCompatTextView5;
        this.f77645j = appCompatTextView6;
    }

    @NonNull
    public static v a(@NonNull View view) {
        int i11 = R$id.ivAvatar;
        ShapeableImageView shapeableImageView = (ShapeableImageView) n6.b.a(view, i11);
        if (shapeableImageView != null) {
            i11 = R$id.tv_add;
            AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
            if (appCompatTextView != null) {
                i11 = R$id.tvDes;
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                if (appCompatTextView2 != null) {
                    i11 = R$id.tv_download;
                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) n6.b.a(view, i11);
                    if (appCompatTextView3 != null) {
                        i11 = R$id.tv_download_page;
                        AppCompatTextView appCompatTextView4 = (AppCompatTextView) n6.b.a(view, i11);
                        if (appCompatTextView4 != null) {
                            i11 = R$id.tv_music_avatar;
                            ConstraintLayout constraintLayout = (ConstraintLayout) n6.b.a(view, i11);
                            if (constraintLayout != null) {
                                i11 = R$id.tv_remind;
                                AppCompatTextView appCompatTextView5 = (AppCompatTextView) n6.b.a(view, i11);
                                if (appCompatTextView5 != null) {
                                    i11 = R$id.tv_share;
                                    AppCompatTextView appCompatTextView6 = (AppCompatTextView) n6.b.a(view, i11);
                                    if (appCompatTextView6 != null) {
                                        return new v((HorizontalScrollView) view, shapeableImageView, appCompatTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4, constraintLayout, appCompatTextView5, appCompatTextView6);
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
    public static v c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static v d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.header_extension_layout, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public HorizontalScrollView getRoot() {
        return this.f77637a;
    }
}
