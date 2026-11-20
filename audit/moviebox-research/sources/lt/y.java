package lt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.widget.TnTextView;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class y implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f70533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f70534b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final TnTextView f70535c;

    public y(@NonNull LinearLayout linearLayout, @NonNull ShapeableImageView shapeableImageView, @NonNull TnTextView tnTextView) {
        this.f70533a = linearLayout;
        this.f70534b = shapeableImageView;
        this.f70535c = tnTextView;
    }

    @NonNull
    public static y a(@NonNull View view) {
        int i11 = R$id.ivCover;
        ShapeableImageView shapeableImageView = (ShapeableImageView) n6.b.a(view, i11);
        if (shapeableImageView != null) {
            i11 = R$id.tvTitle;
            TnTextView tnTextView = (TnTextView) n6.b.a(view, i11);
            if (tnTextView != null) {
                return new y((LinearLayout) view, shapeableImageView, tnTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static y c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.item_single_image, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f70533a;
    }
}
