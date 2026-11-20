package tu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class n implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f77544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f77545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f77546c;

    public n(@NonNull ConstraintLayout constraintLayout, @NonNull ShapeableImageView shapeableImageView, @NonNull ShapeableImageView shapeableImageView2) {
        this.f77544a = constraintLayout;
        this.f77545b = shapeableImageView;
        this.f77546c = shapeableImageView2;
    }

    @NonNull
    public static n a(@NonNull View view) {
        int i11 = R$id.ivMovieBlurCover;
        ShapeableImageView shapeableImageView = (ShapeableImageView) n6.b.a(view, i11);
        if (shapeableImageView != null) {
            i11 = R$id.ivMovieCover;
            ShapeableImageView shapeableImageView2 = (ShapeableImageView) n6.b.a(view, i11);
            if (shapeableImageView2 != null) {
                return new n((ConstraintLayout) view, shapeableImageView, shapeableImageView2);
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
        View viewInflate = layoutInflater.inflate(R$layout.fragment_stills, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f77544a;
    }
}
