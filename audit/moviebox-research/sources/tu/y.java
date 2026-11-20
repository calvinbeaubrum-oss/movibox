package tu;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.moviedetail.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class y implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f77653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f77654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77655c;

    public y(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull AppCompatTextView appCompatTextView) {
        this.f77653a = constraintLayout;
        this.f77654b = imageView;
        this.f77655c = appCompatTextView;
    }

    @NonNull
    public static y a(@NonNull View view) {
        int i11 = R$id.closeWatchTv;
        ImageView imageView = (ImageView) n6.b.a(view, i11);
        if (imageView != null) {
            i11 = R$id.goWatchTv;
            AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
            if (appCompatTextView != null) {
                return new y((ConstraintLayout) view, imageView, appCompatTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f77653a;
    }
}
