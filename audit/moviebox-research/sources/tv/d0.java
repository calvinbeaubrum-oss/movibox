package tv;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;
import com.transsion.postdetail.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class d0 implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final CardView f77714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f77715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final CardView f77716c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f77717d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77718f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final BLTextView f77719g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public final BLView f77720h;

    public d0(@NonNull CardView cardView, @NonNull FrameLayout frameLayout, @NonNull CardView cardView2, @NonNull ShapeableImageView shapeableImageView, @NonNull AppCompatImageView appCompatImageView, @NonNull BLTextView bLTextView, @Nullable BLView bLView) {
        this.f77714a = cardView;
        this.f77715b = frameLayout;
        this.f77716c = cardView2;
        this.f77717d = shapeableImageView;
        this.f77718f = appCompatImageView;
        this.f77719g = bLTextView;
        this.f77720h = bLView;
    }

    @NonNull
    public static d0 a(@NonNull View view) {
        int i11 = R$id.flPlayer;
        FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
        if (frameLayout != null) {
            CardView cardView = (CardView) view;
            i11 = R$id.iv_cover;
            ShapeableImageView shapeableImageView = (ShapeableImageView) n6.b.a(view, i11);
            if (shapeableImageView != null) {
                i11 = R$id.iv_video_play;
                AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
                if (appCompatImageView != null) {
                    i11 = R$id.tv_video_duration;
                    BLTextView bLTextView = (BLTextView) n6.b.a(view, i11);
                    if (bLTextView != null) {
                        return new d0(cardView, frameLayout, cardView, shapeableImageView, appCompatImageView, bLTextView, (BLView) n6.b.a(view, R$id.v_cover_stroke));
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public CardView getRoot() {
        return this.f77714a;
    }
}
