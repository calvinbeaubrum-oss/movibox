package ew;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.transsion.publish.R$id;
import com.transsion.publish.R$layout;
import com.transsion.publish.view.CustomPublishHeader;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f64366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f64367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final CustomPublishHeader f64368c;

    public b(@NonNull RelativeLayout relativeLayout, @NonNull FrameLayout frameLayout, @NonNull CustomPublishHeader customPublishHeader) {
        this.f64366a = relativeLayout;
        this.f64367b = frameLayout;
        this.f64368c = customPublishHeader;
    }

    @NonNull
    public static b a(@NonNull View view) {
        int i11 = R$id.fl_content;
        FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
        if (frameLayout != null) {
            i11 = R$id.sv_title_bar;
            CustomPublishHeader customPublishHeader = (CustomPublishHeader) n6.b.a(view, i11);
            if (customPublishHeader != null) {
                return new b((RelativeLayout) view, frameLayout, customPublishHeader);
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
        View viewInflate = layoutInflater.inflate(R$layout.activity_film_review, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f64366a;
    }
}
