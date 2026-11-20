package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.R$attr;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends w implements DialogInterface {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AlertController f839g;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AlertController.d f840a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f841b;

        public a(@NonNull Context context) {
            this(context, c.k(context, 0));
        }

        public a(@NonNull Context context, int i11) {
            this.f840a = new AlertController.d(new ContextThemeWrapper(context, c.k(context, i11)));
            this.f841b = i11;
        }

        public a a(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.d dVar = this.f840a;
            dVar.f718w = listAdapter;
            dVar.f719x = onClickListener;
            return this;
        }

        public a b(@Nullable View view) {
            this.f840a.f702g = view;
            return this;
        }

        public a c(@Nullable Drawable drawable) {
            this.f840a.f699d = drawable;
            return this;
        }

        @NonNull
        public c create() {
            c cVar = new c(this.f840a.f696a, this.f841b);
            this.f840a.a(cVar.f839g);
            cVar.setCancelable(this.f840a.f713r);
            if (this.f840a.f713r) {
                cVar.setCanceledOnTouchOutside(true);
            }
            cVar.setOnCancelListener(this.f840a.f714s);
            cVar.setOnDismissListener(this.f840a.f715t);
            DialogInterface.OnKeyListener onKeyListener = this.f840a.f716u;
            if (onKeyListener != null) {
                cVar.setOnKeyListener(onKeyListener);
            }
            return cVar;
        }

        public a d(@Nullable CharSequence charSequence) {
            this.f840a.f703h = charSequence;
            return this;
        }

        public a e(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.d dVar = this.f840a;
            dVar.f707l = charSequence;
            dVar.f709n = onClickListener;
            return this;
        }

        public a f(DialogInterface.OnKeyListener onKeyListener) {
            this.f840a.f716u = onKeyListener;
            return this;
        }

        public a g(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.d dVar = this.f840a;
            dVar.f704i = charSequence;
            dVar.f706k = onClickListener;
            return this;
        }

        @NonNull
        public Context getContext() {
            return this.f840a.f696a;
        }

        public a h(ListAdapter listAdapter, int i11, DialogInterface.OnClickListener onClickListener) {
            AlertController.d dVar = this.f840a;
            dVar.f718w = listAdapter;
            dVar.f719x = onClickListener;
            dVar.I = i11;
            dVar.H = true;
            return this;
        }

        public a setNegativeButton(@StringRes int i11, DialogInterface.OnClickListener onClickListener) {
            AlertController.d dVar = this.f840a;
            dVar.f707l = dVar.f696a.getText(i11);
            this.f840a.f709n = onClickListener;
            return this;
        }

        public a setPositiveButton(@StringRes int i11, DialogInterface.OnClickListener onClickListener) {
            AlertController.d dVar = this.f840a;
            dVar.f704i = dVar.f696a.getText(i11);
            this.f840a.f706k = onClickListener;
            return this;
        }

        public a setTitle(@Nullable CharSequence charSequence) {
            this.f840a.f701f = charSequence;
            return this;
        }

        public a setView(View view) {
            AlertController.d dVar = this.f840a;
            dVar.f721z = view;
            dVar.f720y = 0;
            dVar.E = false;
            return this;
        }
    }

    public c(@NonNull Context context, int i11) {
        super(context, k(context, i11));
        this.f839g = new AlertController(getContext(), this, getWindow());
    }

    public static int k(@NonNull Context context, int i11) {
        if (((i11 >>> 24) & 255) >= 1) {
            return i11;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView j() {
        return this.f839g.d();
    }

    @Override // androidx.appcompat.app.w, androidx.activity.k, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f839g.e();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        if (this.f839g.g(i11, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i11, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i11, KeyEvent keyEvent) {
        if (this.f839g.h(i11, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i11, keyEvent);
    }

    @Override // androidx.appcompat.app.w, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f839g.q(charSequence);
    }
}
