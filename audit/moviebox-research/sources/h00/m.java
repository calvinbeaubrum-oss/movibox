package h00;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Group;
import com.transsnet.downloader.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class m implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f65937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final Group f65938b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final Group f65939c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f65940d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f65941f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f65942g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f65943h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final TextView f65944i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final TextView f65945j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final View f65946k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final View f65947l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final View f65948m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    public final View f65949n;

    public m(@NonNull FrameLayout frameLayout, @NonNull Group group, @NonNull Group group2, @NonNull AppCompatImageView appCompatImageView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull View view, @NonNull View view2, @NonNull View view3, @NonNull View view4) {
        this.f65937a = frameLayout;
        this.f65938b = group;
        this.f65939c = group2;
        this.f65940d = appCompatImageView;
        this.f65941f = textView;
        this.f65942g = textView2;
        this.f65943h = textView3;
        this.f65944i = textView4;
        this.f65945j = textView5;
        this.f65946k = view;
        this.f65947l = view2;
        this.f65948m = view3;
        this.f65949n = view4;
    }

    @NonNull
    public static m a(@NonNull View view) {
        View viewA;
        View viewA2;
        View viewA3;
        View viewA4;
        int i11 = R$id.groupBatteryPermission;
        Group group = (Group) n6.b.a(view, i11);
        if (group != null) {
            i11 = R$id.groupPremium;
            Group group2 = (Group) n6.b.a(view, i11);
            if (group2 != null) {
                i11 = R$id.ivPremium;
                AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
                if (appCompatImageView != null) {
                    i11 = R$id.tvBatteryPermission;
                    TextView textView = (TextView) n6.b.a(view, i11);
                    if (textView != null) {
                        i11 = R$id.tvCancel;
                        TextView textView2 = (TextView) n6.b.a(view, i11);
                        if (textView2 != null) {
                            i11 = R$id.tvDownloadXXSizeAtOnce;
                            TextView textView3 = (TextView) n6.b.a(view, i11);
                            if (textView3 != null) {
                                i11 = R$id.tvPremium;
                                TextView textView4 = (TextView) n6.b.a(view, i11);
                                if (textView4 != null) {
                                    i11 = R$id.tvResumeAll;
                                    TextView textView5 = (TextView) n6.b.a(view, i11);
                                    if (textView5 != null && (viewA = n6.b.a(view, (i11 = R$id.viewBgPremium))) != null && (viewA2 = n6.b.a(view, (i11 = R$id.viewLine1))) != null && (viewA3 = n6.b.a(view, (i11 = R$id.viewLine2))) != null && (viewA4 = n6.b.a(view, (i11 = R$id.viewLine3))) != null) {
                                        return new m((FrameLayout) view, group, group2, appCompatImageView, textView, textView2, textView3, textView4, textView5, viewA, viewA2, viewA3, viewA4);
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
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f65937a;
    }
}
