package wz;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Group;
import com.avery.subtitle.widget.SimpleSubtitleView;
import com.transsion.videofloat.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class b implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f79771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f79772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final Group f79773c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f79774d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f79775f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f79776g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f79777h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f79778i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final SimpleSubtitleView f79779j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final View f79780k;

    public b(@NonNull View view, @NonNull FrameLayout frameLayout, @NonNull Group group, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull AppCompatImageView appCompatImageView3, @NonNull AppCompatImageView appCompatImageView4, @NonNull AppCompatImageView appCompatImageView5, @NonNull SimpleSubtitleView simpleSubtitleView, @NonNull View view2) {
        this.f79771a = view;
        this.f79772b = frameLayout;
        this.f79773c = group;
        this.f79774d = appCompatImageView;
        this.f79775f = appCompatImageView2;
        this.f79776g = appCompatImageView3;
        this.f79777h = appCompatImageView4;
        this.f79778i = appCompatImageView5;
        this.f79779j = simpleSubtitleView;
        this.f79780k = view2;
    }

    @NonNull
    public static b a(@NonNull View view) {
        View viewA;
        int i11 = R$id.fl_player_container;
        FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
        if (frameLayout != null) {
            i11 = R$id.group_control;
            Group group = (Group) n6.b.a(view, i11);
            if (group != null) {
                i11 = R$id.iv_backward;
                AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
                if (appCompatImageView != null) {
                    i11 = R$id.iv_close;
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) n6.b.a(view, i11);
                    if (appCompatImageView2 != null) {
                        i11 = R$id.iv_forward;
                        AppCompatImageView appCompatImageView3 = (AppCompatImageView) n6.b.a(view, i11);
                        if (appCompatImageView3 != null) {
                            i11 = R$id.iv_full;
                            AppCompatImageView appCompatImageView4 = (AppCompatImageView) n6.b.a(view, i11);
                            if (appCompatImageView4 != null) {
                                i11 = R$id.iv_play;
                                AppCompatImageView appCompatImageView5 = (AppCompatImageView) n6.b.a(view, i11);
                                if (appCompatImageView5 != null) {
                                    i11 = R$id.v_subtitle;
                                    SimpleSubtitleView simpleSubtitleView = (SimpleSubtitleView) n6.b.a(view, i11);
                                    if (simpleSubtitleView != null && (viewA = n6.b.a(view, (i11 = R$id.v_trans_float))) != null) {
                                        return new b(view, frameLayout, group, appCompatImageView, appCompatImageView2, appCompatImageView3, appCompatImageView4, appCompatImageView5, simpleSubtitleView, viewA);
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

    @Override // n6.a
    @NonNull
    public View getRoot() {
        return this.f79771a;
    }
}
