package os;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.commercialization.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class f implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f73402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f73403b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f73404c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f73405d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f73406f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f73407g;

    public f(@NonNull ConstraintLayout constraintLayout, @NonNull ShapeableImageView shapeableImageView, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f73402a = constraintLayout;
        this.f73403b = shapeableImageView;
        this.f73404c = constraintLayout2;
        this.f73405d = textView;
        this.f73406f = textView2;
        this.f73407g = textView3;
    }

    @NonNull
    public static f a(@NonNull View view) {
        int i11 = R$id.ivAdIcon;
        ShapeableImageView shapeableImageView = (ShapeableImageView) n6.b.a(view, i11);
        if (shapeableImageView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i11 = R$id.tvAdDesc;
            TextView textView = (TextView) n6.b.a(view, i11);
            if (textView != null) {
                i11 = R$id.tvAdTitle;
                TextView textView2 = (TextView) n6.b.a(view, i11);
                if (textView2 != null) {
                    i11 = R$id.tvWatch;
                    TextView textView3 = (TextView) n6.b.a(view, i11);
                    if (textView3 != null) {
                        return new f(constraintLayout, shapeableImageView, constraintLayout, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f73402a;
    }
}
