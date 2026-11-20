package sw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLView;
import com.tn.lib.view.RoomJoinAnimationView;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class p implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f76575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f76576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f76577c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f76578d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f76579f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f76580g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f76581h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final RoomJoinAnimationView f76582i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final BLView f76583j;

    public p(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull ShapeableImageView shapeableImageView, @NonNull ShapeableImageView shapeableImageView2, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull AppCompatTextView appCompatTextView3, @NonNull RoomJoinAnimationView roomJoinAnimationView, @NonNull BLView bLView) {
        this.f76575a = constraintLayout;
        this.f76576b = constraintLayout2;
        this.f76577c = shapeableImageView;
        this.f76578d = shapeableImageView2;
        this.f76579f = appCompatTextView;
        this.f76580g = appCompatTextView2;
        this.f76581h = appCompatTextView3;
        this.f76582i = roomJoinAnimationView;
        this.f76583j = bLView;
    }

    @NonNull
    public static p a(@NonNull View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i11 = R$id.iv_cover;
        ShapeableImageView shapeableImageView = (ShapeableImageView) n6.b.a(view, i11);
        if (shapeableImageView != null) {
            i11 = R$id.iv_cover_bg;
            ShapeableImageView shapeableImageView2 = (ShapeableImageView) n6.b.a(view, i11);
            if (shapeableImageView2 != null) {
                i11 = R$id.tv_members;
                AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                if (appCompatTextView != null) {
                    i11 = R$id.tv_tag;
                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                    if (appCompatTextView2 != null) {
                        i11 = R$id.tv_title;
                        AppCompatTextView appCompatTextView3 = (AppCompatTextView) n6.b.a(view, i11);
                        if (appCompatTextView3 != null) {
                            i11 = R$id.v_join;
                            RoomJoinAnimationView roomJoinAnimationView = (RoomJoinAnimationView) n6.b.a(view, i11);
                            if (roomJoinAnimationView != null) {
                                i11 = R$id.v_stroke;
                                BLView bLView = (BLView) n6.b.a(view, i11);
                                if (bLView != null) {
                                    return new p(constraintLayout, constraintLayout, shapeableImageView, shapeableImageView2, appCompatTextView, appCompatTextView2, appCompatTextView3, roomJoinAnimationView, bLView);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static p c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.item_recommend_rooms, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f76575a;
    }
}
