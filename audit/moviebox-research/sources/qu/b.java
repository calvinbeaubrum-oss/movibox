package qu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.transsion.member.R$id;
import com.transsion.member.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f74897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f74898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final j f74899c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f74900d;

    public b(@NonNull LinearLayoutCompat linearLayoutCompat, @NonNull FrameLayout frameLayout, @NonNull j jVar, @NonNull AppCompatTextView appCompatTextView) {
        this.f74897a = linearLayoutCompat;
        this.f74898b = frameLayout;
        this.f74899c = jVar;
        this.f74900d = appCompatTextView;
    }

    @NonNull
    public static b a(@NonNull View view) {
        View viewA;
        int i11 = R$id.container;
        FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
        if (frameLayout != null && (viewA = n6.b.a(view, (i11 = R$id.titleLayout))) != null) {
            j jVarA = j.a(viewA);
            int i12 = R$id.tvTotalCoin;
            AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i12);
            if (appCompatTextView != null) {
                return new b((LinearLayoutCompat) view, frameLayout, jVarA, appCompatTextView);
            }
            i11 = i12;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static b c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static b d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_points_history_layout, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.f74897a;
    }
}
