package nx;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.shorttv.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class d implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f72203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f72204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f72205c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f72206d;

    public d(@NonNull View view, @NonNull ShapeableImageView shapeableImageView, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2) {
        this.f72203a = view;
        this.f72204b = shapeableImageView;
        this.f72205c = appCompatTextView;
        this.f72206d = appCompatTextView2;
    }

    @NonNull
    public static d a(@NonNull View view) {
        int i11 = R$id.ivAdAvatar;
        ShapeableImageView shapeableImageView = (ShapeableImageView) n6.b.a(view, i11);
        if (shapeableImageView != null) {
            i11 = R$id.tvBtn;
            AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
            if (appCompatTextView != null) {
                i11 = R$id.tvDes;
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                if (appCompatTextView2 != null) {
                    return new d(view, shapeableImageView, appCompatTextView, appCompatTextView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // n6.a
    @NonNull
    public View getRoot() {
        return this.f72203a;
    }
}
