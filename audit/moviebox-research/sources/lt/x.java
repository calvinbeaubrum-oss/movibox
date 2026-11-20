package lt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLConstraintLayout;
import com.tn.lib.widget.TnTextView;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class x implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final BLConstraintLayout f70529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f70530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f70531c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final TnTextView f70532d;

    public x(@NonNull BLConstraintLayout bLConstraintLayout, @NonNull ShapeableImageView shapeableImageView, @NonNull AppCompatImageView appCompatImageView, @NonNull TnTextView tnTextView) {
        this.f70529a = bLConstraintLayout;
        this.f70530b = shapeableImageView;
        this.f70531c = appCompatImageView;
        this.f70532d = tnTextView;
    }

    @NonNull
    public static x a(@NonNull View view) {
        int i11 = R$id.ivCover;
        ShapeableImageView shapeableImageView = (ShapeableImageView) n6.b.a(view, i11);
        if (shapeableImageView != null) {
            i11 = R$id.ivVideoPlay;
            AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.tvTitle;
                TnTextView tnTextView = (TnTextView) n6.b.a(view, i11);
                if (tnTextView != null) {
                    return new x((BLConstraintLayout) view, shapeableImageView, appCompatImageView, tnTextView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static x c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.item_adapter_room_entrance_post, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public BLConstraintLayout getRoot() {
        return this.f70529a;
    }
}
