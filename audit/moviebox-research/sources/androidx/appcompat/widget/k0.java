package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class k0 extends ContextWrapper {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f1710c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static ArrayList<WeakReference<k0>> f1711d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Resources f1712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Resources.Theme f1713b;

    public k0(@NonNull Context context) {
        super(context);
        if (!x0.c()) {
            this.f1712a = new m0(this, context.getResources());
            this.f1713b = null;
            return;
        }
        x0 x0Var = new x0(this, context.getResources());
        this.f1712a = x0Var;
        Resources.Theme themeNewTheme = x0Var.newTheme();
        this.f1713b = themeNewTheme;
        themeNewTheme.setTo(context.getTheme());
    }

    public static boolean a(@NonNull Context context) {
        if ((context instanceof k0) || (context.getResources() instanceof m0) || (context.getResources() instanceof x0)) {
            return false;
        }
        return x0.c();
    }

    public static Context b(@NonNull Context context) {
        if (!a(context)) {
            return context;
        }
        synchronized (f1710c) {
            try {
                ArrayList<WeakReference<k0>> arrayList = f1711d;
                if (arrayList == null) {
                    f1711d = new ArrayList<>();
                } else {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        WeakReference<k0> weakReference = f1711d.get(size);
                        if (weakReference == null || weakReference.get() == null) {
                            f1711d.remove(size);
                        }
                    }
                    for (int size2 = f1711d.size() - 1; size2 >= 0; size2--) {
                        WeakReference<k0> weakReference2 = f1711d.get(size2);
                        k0 k0Var = weakReference2 != null ? weakReference2.get() : null;
                        if (k0Var != null && k0Var.getBaseContext() == context) {
                            return k0Var;
                        }
                    }
                }
                k0 k0Var2 = new k0(context);
                f1711d.add(new WeakReference<>(k0Var2));
                return k0Var2;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.f1712a.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.f1712a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f1713b;
        return theme == null ? super.getTheme() : theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i11) {
        Resources.Theme theme = this.f1713b;
        if (theme == null) {
            super.setTheme(i11);
        } else {
            theme.applyStyle(i11, true);
        }
    }
}
