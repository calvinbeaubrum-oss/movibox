package pq;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.transsion.ad.R$id;
import com.transsion.ad.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class f implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f74012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final Button f74013b;

    public f(@NonNull LinearLayout linearLayout, @NonNull Button button) {
        this.f74012a = linearLayout;
        this.f74013b = button;
    }

    @NonNull
    public static f a(@NonNull View view) {
        int i11 = R$id.btnLoadInterstitialAd;
        Button button = (Button) n6.b.a(view, i11);
        if (button != null) {
            return new f((LinearLayout) view, button);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static f c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static f d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_test_ad_interstitial_layout, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f74012a;
    }
}
