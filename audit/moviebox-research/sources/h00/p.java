package h00;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewpager2.widget.ViewPager2;
import com.tn.lib.view.indicator.CircleIndicator;
import com.transsnet.downloader.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class p implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f65980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f65981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ViewPager2 f65982c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final CircleIndicator f65983d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f65984f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f65985g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f65986h;

    public p(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull ViewPager2 viewPager2, @NonNull CircleIndicator circleIndicator, @NonNull AppCompatImageView appCompatImageView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f65980a = linearLayout;
        this.f65981b = textView;
        this.f65982c = viewPager2;
        this.f65983d = circleIndicator;
        this.f65984f = appCompatImageView;
        this.f65985g = textView2;
        this.f65986h = textView3;
    }

    @NonNull
    public static p a(@NonNull View view) {
        int i11 = R$id.guide_desc;
        TextView textView = (TextView) n6.b.a(view, i11);
        if (textView != null) {
            i11 = R$id.guide_pager;
            ViewPager2 viewPager2 = (ViewPager2) n6.b.a(view, i11);
            if (viewPager2 != null) {
                i11 = R$id.indicator;
                CircleIndicator circleIndicator = (CircleIndicator) n6.b.a(view, i11);
                if (circleIndicator != null) {
                    i11 = R$id.ivClose;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
                    if (appCompatImageView != null) {
                        i11 = R$id.next;
                        TextView textView2 = (TextView) n6.b.a(view, i11);
                        if (textView2 != null) {
                            i11 = R$id.title;
                            TextView textView3 = (TextView) n6.b.a(view, i11);
                            if (textView3 != null) {
                                return new p((LinearLayout) view, textView, viewPager2, circleIndicator, appCompatImageView, textView2, textView3);
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
    public LinearLayout getRoot() {
        return this.f65980a;
    }
}
