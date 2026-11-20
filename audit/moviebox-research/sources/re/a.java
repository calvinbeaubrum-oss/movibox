package re;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.SparseArray;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.cloud.tupdate.R$style;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class a extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray<View> f75179a;

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f75180a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f75181b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f75182c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f75183d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f75184e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f75185f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f75186g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f75187h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f75188i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public DialogInterface.OnCancelListener f75189j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public DialogInterface.OnDismissListener f75190k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public DialogInterface.OnKeyListener f75191l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public DialogInterface.OnShowListener f75192m;

        public b(Context context) {
            this(context, R$style.update_style_dialog);
        }

        public b(Context context, int i11) {
            this.f75184e = true;
            this.f75186g = 17;
            this.f75187h = -2;
            this.f75188i = -2;
            this.f75180a = context;
            this.f75181b = i11;
        }

        public a a() {
            if (this.f75182c == 0) {
                throw new IllegalArgumentException("please set contentId");
            }
            a aVar = new a(this.f75180a, this.f75182c, this.f75181b);
            aVar.setCancelable(this.f75184e);
            if (this.f75184e) {
                aVar.setCanceledOnTouchOutside(this.f75185f);
            }
            aVar.setOnCancelListener(this.f75189j);
            aVar.setOnDismissListener(this.f75190k);
            aVar.setOnKeyListener(this.f75191l);
            aVar.setOnShowListener(this.f75192m);
            Window window = aVar.getWindow();
            window.setWindowAnimations(this.f75183d);
            window.setGravity(this.f75186g);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = this.f75187h;
            attributes.height = this.f75188i;
            window.setAttributes(attributes);
            return aVar;
        }

        public b b(boolean z11) {
            this.f75185f = z11;
            return this;
        }

        public b c(boolean z11) {
            this.f75184e = z11;
            return this;
        }

        public b d(int i11) {
            this.f75182c = i11;
            return this;
        }

        public b e(DialogInterface.OnDismissListener onDismissListener) {
            this.f75190k = onDismissListener;
            return this;
        }

        public b f(DialogInterface.OnShowListener onShowListener) {
            this.f75192m = onShowListener;
            return this;
        }
    }

    public a(@NonNull Context context, int i11, int i12) {
        super(context, i12);
        setContentView(i11);
        this.f75179a = new SparseArray<>();
    }
}
