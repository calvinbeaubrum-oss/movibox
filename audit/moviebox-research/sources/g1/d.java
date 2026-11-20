package g1;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import androidx.annotation.RequiresApi;
import androidx.appcompat.R$style;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends ContextWrapper {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Configuration f65316f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f65317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Resources.Theme f65318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LayoutInflater f65319c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Configuration f65320d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Resources f65321e;

    public d() {
        super(null);
    }

    public d(Context context, int i11) {
        super(context);
        this.f65317a = i11;
    }

    public d(Context context, Resources.Theme theme) {
        super(context);
        this.f65318b = theme;
    }

    @RequiresApi(26)
    public static boolean e(Configuration configuration) {
        if (configuration == null) {
            return true;
        }
        if (f65316f == null) {
            Configuration configuration2 = new Configuration();
            configuration2.fontScale = 0.0f;
            f65316f = configuration2;
        }
        return configuration.equals(f65316f);
    }

    public void a(Configuration configuration) {
        if (this.f65321e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.f65320d != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.f65320d = new Configuration(configuration);
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public final Resources b() {
        if (this.f65321e == null) {
            Configuration configuration = this.f65320d;
            if (configuration == null || (Build.VERSION.SDK_INT >= 26 && e(configuration))) {
                this.f65321e = super.getResources();
            } else {
                this.f65321e = createConfigurationContext(this.f65320d).getResources();
            }
        }
        return this.f65321e;
    }

    public int c() {
        return this.f65317a;
    }

    public final void d() {
        boolean z11 = this.f65318b == null;
        if (z11) {
            this.f65318b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f65318b.setTo(theme);
            }
        }
        f(this.f65318b, this.f65317a, z11);
    }

    public void f(Resources.Theme theme, int i11, boolean z11) {
        theme.applyStyle(i11, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return b();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f65319c == null) {
            this.f65319c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f65319c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f65318b;
        if (theme != null) {
            return theme;
        }
        if (this.f65317a == 0) {
            this.f65317a = R$style.Theme_AppCompat_Light;
        }
        d();
        return this.f65318b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i11) {
        if (this.f65317a != i11) {
            this.f65317a = i11;
            d();
        }
    }
}
