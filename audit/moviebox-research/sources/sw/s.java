package sw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class s implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f76602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f76603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f76604c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final BLTextView f76605d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final BLView f76606f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final BLView f76607g;

    public s(@NonNull ConstraintLayout constraintLayout, @NonNull ShapeableImageView shapeableImageView, @NonNull AppCompatTextView appCompatTextView, @NonNull BLTextView bLTextView, @NonNull BLView bLView, @NonNull BLView bLView2) {
        this.f76602a = constraintLayout;
        this.f76603b = shapeableImageView;
        this.f76604c = appCompatTextView;
        this.f76605d = bLTextView;
        this.f76606f = bLView;
        this.f76607g = bLView2;
    }

    @NonNull
    public static s a(@NonNull View view) {
        int i11 = R$id.iv_cover;
        ShapeableImageView shapeableImageView = (ShapeableImageView) n6.b.a(view, i11);
        if (shapeableImageView != null) {
            i11 = R$id.tv_name;
            AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
            if (appCompatTextView != null) {
                i11 = R$id.tv_new_count;
                BLTextView bLTextView = (BLTextView) n6.b.a(view, i11);
                if (bLTextView != null) {
                    i11 = R$id.v_name_bg;
                    BLView bLView = (BLView) n6.b.a(view, i11);
                    if (bLView != null) {
                        i11 = R$id.v_stroke;
                        BLView bLView2 = (BLView) n6.b.a(view, i11);
                        if (bLView2 != null) {
                            return new s((ConstraintLayout) view, shapeableImageView, appCompatTextView, bLTextView, bLView, bLView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static s c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.item_your_rooms, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f76602a;
    }
}
