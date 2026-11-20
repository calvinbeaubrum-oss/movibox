package tx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.google.android.material.tabs.TabLayout;
import com.transsion.subroom.R$id;
import com.transsion.subroom.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class b implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f78055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f78056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final FrameLayout f78057c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final Group f78058d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final View f78059f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final ImageView f78060g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final View f78061h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final ImageView f78062i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final ImageView f78063j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final TabLayout f78064k;

    public b(@NonNull ConstraintLayout constraintLayout, @NonNull View view, @NonNull FrameLayout frameLayout, @NonNull Group group, @NonNull View view2, @NonNull ImageView imageView, @NonNull View view3, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull TabLayout tabLayout) {
        this.f78055a = constraintLayout;
        this.f78056b = view;
        this.f78057c = frameLayout;
        this.f78058d = group;
        this.f78059f = view2;
        this.f78060g = imageView;
        this.f78061h = view3;
        this.f78062i = imageView2;
        this.f78063j = imageView3;
        this.f78064k = tabLayout;
    }

    @NonNull
    public static b a(@NonNull View view) {
        View viewA;
        View viewA2;
        int i11 = R$id.centerBg;
        View viewA3 = n6.b.a(view, i11);
        if (viewA3 != null) {
            i11 = R$id.container;
            FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
            if (frameLayout != null) {
                i11 = R$id.largeBottomBg;
                Group group = (Group) n6.b.a(view, i11);
                if (group != null && (viewA = n6.b.a(view, (i11 = R$id.leftBg))) != null) {
                    i11 = R$id.leftTwoBg;
                    ImageView imageView = (ImageView) n6.b.a(view, i11);
                    if (imageView != null && (viewA2 = n6.b.a(view, (i11 = R$id.rightBg))) != null) {
                        i11 = R$id.rightTwoBg;
                        ImageView imageView2 = (ImageView) n6.b.a(view, i11);
                        if (imageView2 != null) {
                            i11 = R$id.tabBg;
                            ImageView imageView3 = (ImageView) n6.b.a(view, i11);
                            if (imageView3 != null) {
                                i11 = R$id.tab_bottom;
                                TabLayout tabLayout = (TabLayout) n6.b.a(view, i11);
                                if (tabLayout != null) {
                                    return new b((ConstraintLayout) view, viewA3, frameLayout, group, viewA, imageView, viewA2, imageView2, imageView3, tabLayout);
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
    public static b c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static b d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_main, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f78055a;
    }
}
