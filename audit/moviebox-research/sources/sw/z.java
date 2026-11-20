package sw;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.room.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class z implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f76630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f76631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final RecyclerView f76632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f76633d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f76634f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f76635g;

    public z(@NonNull View view, @NonNull View view2, @NonNull RecyclerView recyclerView, @NonNull TextView textView, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2) {
        this.f76630a = view;
        this.f76631b = view2;
        this.f76632c = recyclerView;
        this.f76633d = textView;
        this.f76634f = appCompatTextView;
        this.f76635g = appCompatTextView2;
    }

    @NonNull
    public static z a(@NonNull View view) {
        int i11 = R$id.all_bg;
        View viewA = n6.b.a(view, i11);
        if (viewA != null) {
            i11 = R$id.recyclerView;
            RecyclerView recyclerView = (RecyclerView) n6.b.a(view, i11);
            if (recyclerView != null) {
                i11 = R$id.tv_banner;
                TextView textView = (TextView) n6.b.a(view, i11);
                if (textView != null) {
                    i11 = R$id.tvMore;
                    AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                    if (appCompatTextView != null) {
                        i11 = R$id.tv_title;
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                        if (appCompatTextView2 != null) {
                            return new z(view, viewA, recyclerView, textView, appCompatTextView, appCompatTextView2);
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
        return this.f76630a;
    }
}
