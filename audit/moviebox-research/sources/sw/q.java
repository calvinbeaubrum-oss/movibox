package sw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;
import com.tn.lib.view.RoomJoinAnimationView;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class q implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f76584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f76585b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final Group f76586c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f76587d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final t f76588f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final u f76589g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f76590h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final BLTextView f76591i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f76592j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f76593k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f76594l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final RoomJoinAnimationView f76595m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    public final View f76596n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NonNull
    public final BLView f76597o;

    public q(@NonNull ConstraintLayout constraintLayout, @NonNull FrameLayout frameLayout, @NonNull Group group, @NonNull ShapeableImageView shapeableImageView, @NonNull t tVar, @NonNull u uVar, @NonNull AppCompatTextView appCompatTextView, @NonNull BLTextView bLTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull AppCompatTextView appCompatTextView3, @NonNull AppCompatTextView appCompatTextView4, @NonNull RoomJoinAnimationView roomJoinAnimationView, @NonNull View view, @NonNull BLView bLView) {
        this.f76584a = constraintLayout;
        this.f76585b = frameLayout;
        this.f76586c = group;
        this.f76587d = shapeableImageView;
        this.f76588f = tVar;
        this.f76589g = uVar;
        this.f76590h = appCompatTextView;
        this.f76591i = bLTextView;
        this.f76592j = appCompatTextView2;
        this.f76593k = appCompatTextView3;
        this.f76594l = appCompatTextView4;
        this.f76595m = roomJoinAnimationView;
        this.f76596n = view;
        this.f76597o = bLView;
    }

    @NonNull
    public static q a(@NonNull View view) {
        View viewA;
        View viewA2;
        int i11 = R$id.fl_new_post_cover;
        FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
        if (frameLayout != null) {
            i11 = R$id.group_new_post;
            Group group = (Group) n6.b.a(view, i11);
            if (group != null) {
                i11 = R$id.iv_cover;
                ShapeableImageView shapeableImageView = (ShapeableImageView) n6.b.a(view, i11);
                if (shapeableImageView != null && (viewA = n6.b.a(view, (i11 = R$id.layout_new_post_image))) != null) {
                    t tVarA = t.a(viewA);
                    i11 = R$id.layout_new_post_video;
                    View viewA3 = n6.b.a(view, i11);
                    if (viewA3 != null) {
                        u uVarA = u.a(viewA3);
                        i11 = R$id.tv_member;
                        AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                        if (appCompatTextView != null) {
                            i11 = R$id.tv_new_count;
                            BLTextView bLTextView = (BLTextView) n6.b.a(view, i11);
                            if (bLTextView != null) {
                                i11 = R$id.tv_new_post_content;
                                AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                                if (appCompatTextView2 != null) {
                                    i11 = R$id.tv_tag;
                                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) n6.b.a(view, i11);
                                    if (appCompatTextView3 != null) {
                                        i11 = R$id.tv_title;
                                        AppCompatTextView appCompatTextView4 = (AppCompatTextView) n6.b.a(view, i11);
                                        if (appCompatTextView4 != null) {
                                            i11 = R$id.v_join;
                                            RoomJoinAnimationView roomJoinAnimationView = (RoomJoinAnimationView) n6.b.a(view, i11);
                                            if (roomJoinAnimationView != null && (viewA2 = n6.b.a(view, (i11 = R$id.v_line))) != null) {
                                                i11 = R$id.v_new_post_bg;
                                                BLView bLView = (BLView) n6.b.a(view, i11);
                                                if (bLView != null) {
                                                    return new q((ConstraintLayout) view, frameLayout, group, shapeableImageView, tVarA, uVarA, appCompatTextView, bLTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4, roomJoinAnimationView, viewA2, bLView);
                                                }
                                            }
                                        }
                                    }
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
    public static q c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.item_room_list, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f76584a;
    }
}
