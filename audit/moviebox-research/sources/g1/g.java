package g1;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.b0;
import androidx.appcompat.widget.n0;
import androidx.core.view.ActionProvider;
import androidx.core.view.MenuItemCompat;
import com.tn.lib.view.FlowLayout;
import com.transsion.web.api.WebConstants;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import okhttp3.internal.http2.Settings;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class g extends MenuInflater {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Class<?>[] f65335e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Class<?>[] f65336f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f65337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f65338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f65339c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f65340d;

    /* JADX INFO: compiled from: source.java */
    public static class a implements MenuItem.OnMenuItemClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Class<?>[] f65341c = {MenuItem.class};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f65342a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Method f65343b;

        public a(Object obj, String str) {
            this.f65342a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f65343b = cls.getMethod(str, f65341c);
            } catch (Exception e11) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e11);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f65343b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f65343b.invoke(this.f65342a, menuItem)).booleanValue();
                }
                this.f65343b.invoke(this.f65342a, menuItem);
                return true;
            } catch (Exception e11) {
                throw new RuntimeException(e11);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b {
        public ActionProvider A;
        public CharSequence B;
        public CharSequence C;
        public ColorStateList D = null;
        public PorterDuff.Mode E = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Menu f65344a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f65345b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f65346c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f65347d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f65348e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f65349f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f65350g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f65351h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f65352i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f65353j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public CharSequence f65354k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public CharSequence f65355l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f65356m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public char f65357n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f65358o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public char f65359p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f65360q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f65361r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public boolean f65362s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public boolean f65363t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public boolean f65364u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f65365v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f65366w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public String f65367x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public String f65368y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public String f65369z;

        public b(Menu menu) {
            this.f65344a = menu;
            h();
        }

        public void a() {
            this.f65351h = true;
            i(this.f65344a.add(this.f65345b, this.f65352i, this.f65353j, this.f65354k));
        }

        public SubMenu b() {
            this.f65351h = true;
            SubMenu subMenuAddSubMenu = this.f65344a.addSubMenu(this.f65345b, this.f65352i, this.f65353j, this.f65354k);
            i(subMenuAddSubMenu.getItem());
            return subMenuAddSubMenu;
        }

        public final char c(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        public boolean d() {
            return this.f65351h;
        }

        public final <T> T e(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, g.this.f65339c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e11) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e11);
                return null;
            }
        }

        public void f(AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = g.this.f65339c.obtainStyledAttributes(attributeSet, R$styleable.MenuGroup);
            this.f65345b = typedArrayObtainStyledAttributes.getResourceId(R$styleable.MenuGroup_android_id, 0);
            this.f65346c = typedArrayObtainStyledAttributes.getInt(R$styleable.MenuGroup_android_menuCategory, 0);
            this.f65347d = typedArrayObtainStyledAttributes.getInt(R$styleable.MenuGroup_android_orderInCategory, 0);
            this.f65348e = typedArrayObtainStyledAttributes.getInt(R$styleable.MenuGroup_android_checkableBehavior, 0);
            this.f65349f = typedArrayObtainStyledAttributes.getBoolean(R$styleable.MenuGroup_android_visible, true);
            this.f65350g = typedArrayObtainStyledAttributes.getBoolean(R$styleable.MenuGroup_android_enabled, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        public void g(AttributeSet attributeSet) {
            n0 n0VarU = n0.u(g.this.f65339c, attributeSet, R$styleable.MenuItem);
            this.f65352i = n0VarU.n(R$styleable.MenuItem_android_id, 0);
            this.f65353j = (n0VarU.k(R$styleable.MenuItem_android_menuCategory, this.f65346c) & FlowLayout.SPACING_AUTO) | (n0VarU.k(R$styleable.MenuItem_android_orderInCategory, this.f65347d) & Settings.DEFAULT_INITIAL_WINDOW_SIZE);
            this.f65354k = n0VarU.p(R$styleable.MenuItem_android_title);
            this.f65355l = n0VarU.p(R$styleable.MenuItem_android_titleCondensed);
            this.f65356m = n0VarU.n(R$styleable.MenuItem_android_icon, 0);
            this.f65357n = c(n0VarU.o(R$styleable.MenuItem_android_alphabeticShortcut));
            this.f65358o = n0VarU.k(R$styleable.MenuItem_alphabeticModifiers, 4096);
            this.f65359p = c(n0VarU.o(R$styleable.MenuItem_android_numericShortcut));
            this.f65360q = n0VarU.k(R$styleable.MenuItem_numericModifiers, 4096);
            if (n0VarU.s(R$styleable.MenuItem_android_checkable)) {
                this.f65361r = n0VarU.a(R$styleable.MenuItem_android_checkable, false) ? 1 : 0;
            } else {
                this.f65361r = this.f65348e;
            }
            this.f65362s = n0VarU.a(R$styleable.MenuItem_android_checked, false);
            this.f65363t = n0VarU.a(R$styleable.MenuItem_android_visible, this.f65349f);
            this.f65364u = n0VarU.a(R$styleable.MenuItem_android_enabled, this.f65350g);
            this.f65365v = n0VarU.k(R$styleable.MenuItem_showAsAction, -1);
            this.f65369z = n0VarU.o(R$styleable.MenuItem_android_onClick);
            this.f65366w = n0VarU.n(R$styleable.MenuItem_actionLayout, 0);
            this.f65367x = n0VarU.o(R$styleable.MenuItem_actionViewClass);
            String strO = n0VarU.o(R$styleable.MenuItem_actionProviderClass);
            this.f65368y = strO;
            boolean z11 = strO != null;
            if (z11 && this.f65366w == 0 && this.f65367x == null) {
                this.A = (ActionProvider) e(strO, g.f65336f, g.this.f65338b);
            } else {
                if (z11) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.A = null;
            }
            this.B = n0VarU.p(R$styleable.MenuItem_contentDescription);
            this.C = n0VarU.p(R$styleable.MenuItem_tooltipText);
            if (n0VarU.s(R$styleable.MenuItem_iconTintMode)) {
                this.E = b0.e(n0VarU.k(R$styleable.MenuItem_iconTintMode, -1), this.E);
            } else {
                this.E = null;
            }
            if (n0VarU.s(R$styleable.MenuItem_iconTint)) {
                this.D = n0VarU.c(R$styleable.MenuItem_iconTint);
            } else {
                this.D = null;
            }
            n0VarU.x();
            this.f65351h = false;
        }

        public void h() {
            this.f65345b = 0;
            this.f65346c = 0;
            this.f65347d = 0;
            this.f65348e = 0;
            this.f65349f = true;
            this.f65350g = true;
        }

        public final void i(MenuItem menuItem) {
            boolean z11 = false;
            menuItem.setChecked(this.f65362s).setVisible(this.f65363t).setEnabled(this.f65364u).setCheckable(this.f65361r >= 1).setTitleCondensed(this.f65355l).setIcon(this.f65356m);
            int i11 = this.f65365v;
            if (i11 >= 0) {
                menuItem.setShowAsAction(i11);
            }
            if (this.f65369z != null) {
                if (g.this.f65339c.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new a(g.this.b(), this.f65369z));
            }
            if (this.f65361r >= 2) {
                if (menuItem instanceof androidx.appcompat.view.menu.h) {
                    ((androidx.appcompat.view.menu.h) menuItem).t(true);
                } else if (menuItem instanceof androidx.appcompat.view.menu.i) {
                    ((androidx.appcompat.view.menu.i) menuItem).h(true);
                }
            }
            String str = this.f65367x;
            if (str != null) {
                menuItem.setActionView((View) e(str, g.f65335e, g.this.f65337a));
                z11 = true;
            }
            int i12 = this.f65366w;
            if (i12 > 0) {
                if (z11) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    menuItem.setActionView(i12);
                }
            }
            ActionProvider actionProvider = this.A;
            if (actionProvider != null) {
                MenuItemCompat.setActionProvider(menuItem, actionProvider);
            }
            MenuItemCompat.setContentDescription(menuItem, this.B);
            MenuItemCompat.setTooltipText(menuItem, this.C);
            MenuItemCompat.setAlphabeticShortcut(menuItem, this.f65357n, this.f65358o);
            MenuItemCompat.setNumericShortcut(menuItem, this.f65359p, this.f65360q);
            PorterDuff.Mode mode = this.E;
            if (mode != null) {
                MenuItemCompat.setIconTintMode(menuItem, mode);
            }
            ColorStateList colorStateList = this.D;
            if (colorStateList != null) {
                MenuItemCompat.setIconTintList(menuItem, colorStateList);
            }
        }
    }

    static {
        Class<?>[] clsArr = {Context.class};
        f65335e = clsArr;
        f65336f = clsArr;
    }

    public g(Context context) {
        super(context);
        this.f65339c = context;
        Object[] objArr = {context};
        this.f65337a = objArr;
        this.f65338b = objArr;
    }

    public final Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    public Object b() {
        if (this.f65340d == null) {
            this.f65340d = a(this.f65339c);
        }
        return this.f65340d;
    }

    public final void c(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        do {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlPullParser.next();
                    break;
                }
                throw new RuntimeException("Expecting menu, got " + name);
            }
            eventType = xmlPullParser.next();
        } while (eventType != 1);
        String str = null;
        boolean z11 = false;
        boolean z12 = false;
        while (!z11) {
            if (eventType == 1) {
                throw new RuntimeException("Unexpected end of document");
            }
            if (eventType != 2) {
                if (eventType == 3) {
                    String name2 = xmlPullParser.getName();
                    if (z12 && name2.equals(str)) {
                        str = null;
                        z12 = false;
                    } else if (name2.equals("group")) {
                        bVar.h();
                    } else if (name2.equals(WebConstants.FIELD_ITEM)) {
                        if (!bVar.d()) {
                            ActionProvider actionProvider = bVar.A;
                            if (actionProvider == null || !actionProvider.hasSubMenu()) {
                                bVar.a();
                            } else {
                                bVar.b();
                            }
                        }
                    } else if (name2.equals("menu")) {
                        z11 = true;
                    }
                }
            } else if (!z12) {
                String name3 = xmlPullParser.getName();
                if (name3.equals("group")) {
                    bVar.f(attributeSet);
                } else if (name3.equals(WebConstants.FIELD_ITEM)) {
                    bVar.g(attributeSet);
                } else if (name3.equals("menu")) {
                    c(xmlPullParser, attributeSet, bVar.b());
                } else {
                    str = name3;
                    z12 = true;
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // android.view.MenuInflater
    public void inflate(int i11, Menu menu) {
        if (!(menu instanceof e3.a)) {
            super.inflate(i11, menu);
            return;
        }
        XmlResourceParser layout = null;
        boolean z11 = false;
        try {
            try {
                layout = this.f65339c.getResources().getLayout(i11);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(layout);
                if (menu instanceof androidx.appcompat.view.menu.f) {
                    androidx.appcompat.view.menu.f fVar = (androidx.appcompat.view.menu.f) menu;
                    if (fVar.H()) {
                        fVar.i0();
                        z11 = true;
                    }
                }
                c(layout, attributeSetAsAttributeSet, menu);
                if (z11) {
                    ((androidx.appcompat.view.menu.f) menu).h0();
                }
                if (layout != null) {
                    layout.close();
                }
            } catch (IOException e11) {
                throw new InflateException("Error inflating menu XML", e11);
            } catch (XmlPullParserException e12) {
                throw new InflateException("Error inflating menu XML", e12);
            }
        } catch (Throwable th2) {
            if (z11) {
                ((androidx.appcompat.view.menu.f) menu).h0();
            }
            if (layout != null) {
                layout.close();
            }
            throw th2;
        }
    }
}
