package ky;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.transfer.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class e implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f69687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f69688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f69689c;

    public e(@NonNull LinearLayout linearLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull ShapeableImageView shapeableImageView) {
        this.f69687a = linearLayout;
        this.f69688b = appCompatImageView;
        this.f69689c = shapeableImageView;
    }

    @NonNull
    public static e a(@NonNull View view) {
        int i11 = R$id.ivClose;
        AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.ivQrCode;
            ShapeableImageView shapeableImageView = (ShapeableImageView) n6.b.a(view, i11);
            if (shapeableImageView != null) {
                return new e((LinearLayout) view, appCompatImageView, shapeableImageView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f69687a;
    }
}
