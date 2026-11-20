package tv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Space;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import com.noober.background.view.BLTextView;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class o0 implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f77882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final BLTextView f77883b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final Space f77884c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final BLTextView f77885d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77886f;

    public o0(@NonNull View view, @NonNull BLTextView bLTextView, @NonNull Space space, @NonNull BLTextView bLTextView2, @NonNull AppCompatTextView appCompatTextView) {
        this.f77882a = view;
        this.f77883b = bLTextView;
        this.f77884c = space;
        this.f77885d = bLTextView2;
        this.f77886f = appCompatTextView;
    }

    @NonNull
    public static o0 a(@NonNull View view) {
        int i11 = R$id.go_to_setting;
        BLTextView bLTextView = (BLTextView) n6.b.a(view, i11);
        if (bLTextView != null) {
            i11 = R$id.guideline;
            Space space = (Space) n6.b.a(view, i11);
            if (space != null) {
                i11 = R$id.retry;
                BLTextView bLTextView2 = (BLTextView) n6.b.a(view, i11);
                if (bLTextView2 != null) {
                    i11 = R$id.tv_title;
                    AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                    if (appCompatTextView != null) {
                        return new o0(view, bLTextView, space, bLTextView2, appCompatTextView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static o0 b(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(R$layout.view_imm_video_not_net, viewGroup);
        return a(viewGroup);
    }

    @Override // n6.a
    @NonNull
    public View getRoot() {
        return this.f77882a;
    }
}
