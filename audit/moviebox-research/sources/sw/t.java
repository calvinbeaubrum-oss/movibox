package sw;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLView;
import com.transsion.room.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class t implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f76608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f76609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f76610c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final BLView f76611d;

    public t(@NonNull FrameLayout frameLayout, @NonNull ShapeableImageView shapeableImageView, @NonNull ShapeableImageView shapeableImageView2, @NonNull BLView bLView) {
        this.f76608a = frameLayout;
        this.f76609b = shapeableImageView;
        this.f76610c = shapeableImageView2;
        this.f76611d = bLView;
    }

    @NonNull
    public static t a(@NonNull View view) {
        int i11 = R$id.iv_post_cover_1;
        ShapeableImageView shapeableImageView = (ShapeableImageView) n6.b.a(view, i11);
        if (shapeableImageView != null) {
            i11 = R$id.iv_post_cover_2;
            ShapeableImageView shapeableImageView2 = (ShapeableImageView) n6.b.a(view, i11);
            if (shapeableImageView2 != null) {
                i11 = R$id.v_post_bg;
                BLView bLView = (BLView) n6.b.a(view, i11);
                if (bLView != null) {
                    return new t((FrameLayout) view, shapeableImageView, shapeableImageView2, bLView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f76608a;
    }
}
