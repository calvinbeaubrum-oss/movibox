package lt;

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
import com.transsion.home.R$id;
import com.transsion.home.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class w implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f70523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f70524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f70525c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final BLTextView f70526d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f70527f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final BLView f70528g;

    public w(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull ShapeableImageView shapeableImageView, @NonNull BLTextView bLTextView, @NonNull AppCompatTextView appCompatTextView, @NonNull BLView bLView) {
        this.f70523a = constraintLayout;
        this.f70524b = constraintLayout2;
        this.f70525c = shapeableImageView;
        this.f70526d = bLTextView;
        this.f70527f = appCompatTextView;
        this.f70528g = bLView;
    }

    @NonNull
    public static w a(@NonNull View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i11 = R$id.ivCover;
        ShapeableImageView shapeableImageView = (ShapeableImageView) n6.b.a(view, i11);
        if (shapeableImageView != null) {
            i11 = R$id.tvMembers;
            BLTextView bLTextView = (BLTextView) n6.b.a(view, i11);
            if (bLTextView != null) {
                i11 = R$id.tvTitle;
                AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                if (appCompatTextView != null) {
                    i11 = R$id.v_stroke;
                    BLView bLView = (BLView) n6.b.a(view, i11);
                    if (bLView != null) {
                        return new w(constraintLayout, constraintLayout, shapeableImageView, bLTextView, appCompatTextView, bLView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static w c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.item_adapter_room_entrance_group, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f70523a;
    }
}
