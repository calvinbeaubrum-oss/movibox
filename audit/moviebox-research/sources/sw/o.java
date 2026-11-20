package sw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.view.RoomJoinAnimationView;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class o implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f76567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f76568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f76569c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f76570d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f76571f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f76572g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f76573h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final RoomJoinAnimationView f76574i;

    public o(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull ShapeableImageView shapeableImageView, @NonNull ShapeableImageView shapeableImageView2, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull AppCompatTextView appCompatTextView3, @NonNull RoomJoinAnimationView roomJoinAnimationView) {
        this.f76567a = constraintLayout;
        this.f76568b = constraintLayout2;
        this.f76569c = shapeableImageView;
        this.f76570d = shapeableImageView2;
        this.f76571f = appCompatTextView;
        this.f76572g = appCompatTextView2;
        this.f76573h = appCompatTextView3;
        this.f76574i = roomJoinAnimationView;
    }

    @NonNull
    public static o a(@NonNull View view) {
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
                                return new o(constraintLayout, constraintLayout, shapeableImageView, shapeableImageView2, appCompatTextView, appCompatTextView2, appCompatTextView3, roomJoinAnimationView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static o c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.item_community_rooms, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f76567a;
    }
}
