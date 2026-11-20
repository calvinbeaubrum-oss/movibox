package wx;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.Space;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.subtitle.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class a implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f79659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f79660b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final FrameLayout f79661c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final FrameLayout f79662d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final FrameLayout f79663f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final Space f79664g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final Space f79665h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final View f79666i;

    public a(@NonNull ConstraintLayout constraintLayout, @NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull FrameLayout frameLayout3, @NonNull FrameLayout frameLayout4, @NonNull Space space, @NonNull Space space2, @NonNull View view) {
        this.f79659a = constraintLayout;
        this.f79660b = frameLayout;
        this.f79661c = frameLayout2;
        this.f79662d = frameLayout3;
        this.f79663f = frameLayout4;
        this.f79664g = space;
        this.f79665h = space2;
        this.f79666i = view;
    }

    @NonNull
    public static a a(@NonNull View view) {
        View viewA;
        int i11 = R$id.flSearchContainer;
        FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
        if (frameLayout != null) {
            i11 = R$id.flStyleContainer;
            FrameLayout frameLayout2 = (FrameLayout) n6.b.a(view, i11);
            if (frameLayout2 != null) {
                i11 = R$id.fl_subtitle_container;
                FrameLayout frameLayout3 = (FrameLayout) n6.b.a(view, i11);
                if (frameLayout3 != null) {
                    i11 = R$id.flSyncAdjustContainer;
                    FrameLayout frameLayout4 = (FrameLayout) n6.b.a(view, i11);
                    if (frameLayout4 != null) {
                        i11 = R$id.guideline_bottom_controller;
                        Space space = (Space) n6.b.a(view, i11);
                        if (space != null) {
                            i11 = R$id.guideline_player;
                            Space space2 = (Space) n6.b.a(view, i11);
                            if (space2 != null && (viewA = n6.b.a(view, (i11 = R$id.v_bg_start))) != null) {
                                return new a((ConstraintLayout) view, frameLayout, frameLayout2, frameLayout3, frameLayout4, space, space2, viewA);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f79659a;
    }
}
