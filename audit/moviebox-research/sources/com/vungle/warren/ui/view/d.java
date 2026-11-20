package com.vungle.warren.ui.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextThemeWrapper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.vungle.warren.NativeAdLayout;
import com.vungle.warren.ui.PresenterAdOpenCallback;
import com.vungle.warren.utility.ActivityManager;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class d implements b10.f, NativeAdLayout.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f62542f = "d";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f62543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NativeAdLayout f62544b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b10.e f62545c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Dialog f62546d;

    /* JADX INFO: compiled from: source.java */
    public class a implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DialogInterface.OnClickListener f62547a;

        public a(DialogInterface.OnClickListener onClickListener) {
            this.f62547a = onClickListener;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i11) {
            d.this.f62546d = null;
            DialogInterface.OnClickListener onClickListener = this.f62547a;
            if (onClickListener != null) {
                onClickListener.onClick(dialogInterface, i11);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements DialogInterface.OnDismissListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            d.this.f62546d = null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements DialogInterface.OnDismissListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            d.this.f62546d.setOnDismissListener(d.this.j());
        }
    }

    /* JADX INFO: renamed from: com.vungle.warren.ui.view.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class DialogInterfaceOnClickListenerC0637d implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicReference<DialogInterface.OnClickListener> f62551a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicReference<DialogInterface.OnDismissListener> f62552b;

        public DialogInterfaceOnClickListenerC0637d(DialogInterface.OnClickListener onClickListener, DialogInterface.OnDismissListener onDismissListener) {
            AtomicReference<DialogInterface.OnClickListener> atomicReference = new AtomicReference<>();
            this.f62551a = atomicReference;
            AtomicReference<DialogInterface.OnDismissListener> atomicReference2 = new AtomicReference<>();
            this.f62552b = atomicReference2;
            atomicReference.set(onClickListener);
            atomicReference2.set(onDismissListener);
        }

        public final void b(Dialog dialog) {
            dialog.setOnDismissListener(this);
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i11) {
            dialogInterface.dismiss();
            DialogInterface.OnClickListener onClickListener = this.f62551a.get();
            if (onClickListener != null) {
                onClickListener.onClick(dialogInterface, i11);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            DialogInterface.OnDismissListener onDismissListener = this.f62552b.get();
            if (onDismissListener != null) {
                onDismissListener.onDismiss(dialogInterface);
            }
            this.f62552b.set(null);
            this.f62551a.set(null);
        }
    }

    public d(@NonNull Context context, @NonNull NativeAdLayout nativeAdLayout) {
        this.f62543a = context;
        this.f62544b = nativeAdLayout;
        nativeAdLayout.setOnItemClickListener(this);
    }

    @Override // com.vungle.warren.NativeAdLayout.c
    public void a(int i11) {
        if (i11 == 1) {
            this.f62545c.b();
        } else {
            if (i11 != 2) {
                return;
            }
            this.f62545c.d();
        }
    }

    public boolean b() {
        return this.f62546d != null;
    }

    @Override // b10.a
    public void close() {
    }

    @Override // b10.a
    public void destroyAdView(long j11) {
        this.f62544b.release();
    }

    @NonNull
    public DialogInterface.OnDismissListener j() {
        return new b();
    }

    @Override // b10.a
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public void setPresenter(@NonNull com.vungle.warren.ui.presenter.a aVar) {
        this.f62545c = aVar;
    }

    @Override // b10.a
    public void open(String str, @NonNull String str2, ActivityManager.d dVar, PresenterAdOpenCallback presenterAdOpenCallback) {
        if (com.vungle.warren.utility.g.b(str, str2, this.f62543a, dVar, true, presenterAdOpenCallback)) {
            return;
        }
        Log.e(f62542f, "Cannot open url " + str2);
    }

    @Override // b10.a
    public void refreshDialogIfVisible() {
        if (b()) {
            this.f62546d.setOnDismissListener(new c());
            this.f62546d.dismiss();
            this.f62546d.show();
        }
    }

    @Override // b10.a
    public void setOrientation(int i11) {
    }

    @Override // b10.a
    public void showDialog(@Nullable String str, @Nullable String str2, @NonNull String str3, @NonNull String str4, @Nullable DialogInterface.OnClickListener onClickListener) {
        Context context = this.f62543a;
        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(context, context.getApplicationInfo().theme));
        DialogInterfaceOnClickListenerC0637d dialogInterfaceOnClickListenerC0637d = new DialogInterfaceOnClickListenerC0637d(new a(onClickListener), j());
        if (!TextUtils.isEmpty(str)) {
            builder.setTitle(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            builder.setMessage(str2);
        }
        builder.setPositiveButton(str3, dialogInterfaceOnClickListenerC0637d);
        builder.setNegativeButton(str4, dialogInterfaceOnClickListenerC0637d);
        builder.setCancelable(false);
        AlertDialog alertDialogCreate = builder.create();
        this.f62546d = alertDialogCreate;
        dialogInterfaceOnClickListenerC0637d.b(alertDialogCreate);
        this.f62546d.show();
    }
}
