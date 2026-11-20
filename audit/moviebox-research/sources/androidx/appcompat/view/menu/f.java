package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.core.view.ActionProvider;
import androidx.core.view.ViewConfigurationCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import okhttp3.internal.http2.Settings;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class f implements e3.a {
    public static final int[] A = {1, 4, 5, 3, 2, 0};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Resources f1096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1097c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1098d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f1099e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ContextMenu.ContextMenuInfo f1107m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public CharSequence f1108n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Drawable f1109o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f1110p;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public h f1118x;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f1120z;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f1106l = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f1111q = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f1112r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f1113s = false;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f1114t = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f1115u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ArrayList<h> f1116v = new ArrayList<>();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public CopyOnWriteArrayList<WeakReference<l>> f1117w = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f1119y = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList<h> f1100f = new ArrayList<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ArrayList<h> f1101g = new ArrayList<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1102h = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayList<h> f1103i = new ArrayList<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ArrayList<h> f1104j = new ArrayList<>();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f1105k = true;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        boolean a(@NonNull f fVar, @NonNull MenuItem menuItem);

        void b(@NonNull f fVar);
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        boolean invokeItem(h hVar);
    }

    public f(Context context) {
        this.f1095a = context;
        this.f1096b = context.getResources();
        g0(true);
    }

    public static int D(int i11) {
        int i12 = ((-65536) & i11) >> 16;
        if (i12 >= 0) {
            int[] iArr = A;
            if (i12 < iArr.length) {
                return (i11 & Settings.DEFAULT_INITIAL_WINDOW_SIZE) | (iArr[i12] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    public static int p(ArrayList<h> arrayList, int i11) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).f() <= i11) {
                return size + 1;
            }
        }
        return 0;
    }

    public View A() {
        return this.f1110p;
    }

    public ArrayList<h> B() {
        t();
        return this.f1104j;
    }

    public boolean C() {
        return this.f1114t;
    }

    public Resources E() {
        return this.f1096b;
    }

    public f F() {
        return this;
    }

    @NonNull
    public ArrayList<h> G() {
        if (!this.f1102h) {
            return this.f1101g;
        }
        this.f1101g.clear();
        int size = this.f1100f.size();
        for (int i11 = 0; i11 < size; i11++) {
            h hVar = this.f1100f.get(i11);
            if (hVar.isVisible()) {
                this.f1101g.add(hVar);
            }
        }
        this.f1102h = false;
        this.f1105k = true;
        return this.f1101g;
    }

    public boolean H() {
        return !this.f1111q;
    }

    public boolean I() {
        return this.f1119y;
    }

    public boolean J() {
        return this.f1097c;
    }

    public boolean K() {
        return this.f1098d;
    }

    public void L(h hVar) {
        this.f1105k = true;
        N(true);
    }

    public void M(h hVar) {
        this.f1102h = true;
        N(true);
    }

    public void N(boolean z11) {
        if (this.f1111q) {
            this.f1112r = true;
            if (z11) {
                this.f1113s = true;
                return;
            }
            return;
        }
        if (z11) {
            this.f1102h = true;
            this.f1105k = true;
        }
        i(z11);
    }

    public boolean O(MenuItem menuItem, int i11) {
        return P(menuItem, null, i11);
    }

    public boolean P(MenuItem menuItem, l lVar, int i11) {
        h hVar = (h) menuItem;
        if (hVar == null || !hVar.isEnabled()) {
            return false;
        }
        boolean zK = hVar.k();
        ActionProvider actionProviderA = hVar.a();
        boolean z11 = actionProviderA != null && actionProviderA.hasSubMenu();
        if (hVar.j()) {
            zK |= hVar.expandActionView();
            if (zK) {
                e(true);
            }
        } else if (hVar.hasSubMenu() || z11) {
            if ((i11 & 4) == 0) {
                e(false);
            }
            if (!hVar.hasSubMenu()) {
                hVar.x(new q(w(), this, hVar));
            }
            q qVar = (q) hVar.getSubMenu();
            if (z11) {
                actionProviderA.onPrepareSubMenu(qVar);
            }
            zK |= l(qVar, lVar);
            if (!zK) {
                e(true);
            }
        } else if ((i11 & 1) == 0) {
            e(true);
        }
        return zK;
    }

    public final void Q(int i11, boolean z11) {
        if (i11 < 0 || i11 >= this.f1100f.size()) {
            return;
        }
        this.f1100f.remove(i11);
        if (z11) {
            N(true);
        }
    }

    public void R(l lVar) {
        for (WeakReference<l> weakReference : this.f1117w) {
            l lVar2 = weakReference.get();
            if (lVar2 == null || lVar2 == lVar) {
                this.f1117w.remove(weakReference);
            }
        }
    }

    public void S(Bundle bundle) {
        MenuItem menuItemFindItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(v());
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            MenuItem item = getItem(i11);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((q) item.getSubMenu()).S(bundle);
            }
        }
        int i12 = bundle.getInt("android:menu:expandedactionview");
        if (i12 <= 0 || (menuItemFindItem = findItem(i12)) == null) {
            return;
        }
        menuItemFindItem.expandActionView();
    }

    public void T(Bundle bundle) {
        j(bundle);
    }

    public void U(Bundle bundle) {
        int size = size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i11 = 0; i11 < size; i11++) {
            MenuItem item = getItem(i11);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((q) item.getSubMenu()).U(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(v(), sparseArray);
        }
    }

    public void V(Bundle bundle) {
        k(bundle);
    }

    public void W(a aVar) {
        this.f1099e = aVar;
    }

    public f X(int i11) {
        this.f1106l = i11;
        return this;
    }

    public void Y(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f1100f.size();
        i0();
        for (int i11 = 0; i11 < size; i11++) {
            h hVar = this.f1100f.get(i11);
            if (hVar.getGroupId() == groupId && hVar.m() && hVar.isCheckable()) {
                hVar.s(hVar == menuItem);
            }
        }
        h0();
    }

    public f Z(int i11) {
        b0(0, null, i11, null, null);
        return this;
    }

    public MenuItem a(int i11, int i12, int i13, CharSequence charSequence) {
        int iD = D(i13);
        h hVarG = g(i11, i12, i13, iD, charSequence, this.f1106l);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.f1107m;
        if (contextMenuInfo != null) {
            hVarG.v(contextMenuInfo);
        }
        ArrayList<h> arrayList = this.f1100f;
        arrayList.add(p(arrayList, iD), hVarG);
        N(true);
        return hVarG;
    }

    public f a0(Drawable drawable) {
        b0(0, null, 0, drawable, null);
        return this;
    }

    @Override // android.view.Menu
    public MenuItem add(int i11) {
        return a(0, 0, 0, this.f1096b.getString(i11));
    }

    @Override // android.view.Menu
    public MenuItem add(int i11, int i12, int i13, int i14) {
        return a(i11, i12, i13, this.f1096b.getString(i14));
    }

    @Override // android.view.Menu
    public MenuItem add(int i11, int i12, int i13, CharSequence charSequence) {
        return a(i11, i12, i13, charSequence);
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i11, int i12, int i13, ComponentName componentName, Intent[] intentArr, Intent intent, int i14, MenuItem[] menuItemArr) {
        int i15;
        PackageManager packageManager = this.f1095a.getPackageManager();
        List<ResolveInfo> listQueryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = listQueryIntentActivityOptions != null ? listQueryIntentActivityOptions.size() : 0;
        if ((i14 & 1) == 0) {
            removeGroup(i11);
        }
        for (int i16 = 0; i16 < size; i16++) {
            ResolveInfo resolveInfo = listQueryIntentActivityOptions.get(i16);
            int i17 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i17 < 0 ? intent : intentArr[i17]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem intent3 = add(i11, i12, i13, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && (i15 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i15] = intent3;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i11) {
        return addSubMenu(0, 0, 0, this.f1096b.getString(i11));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i11, int i12, int i13, int i14) {
        return addSubMenu(i11, i12, i13, this.f1096b.getString(i14));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i11, int i12, int i13, CharSequence charSequence) {
        h hVar = (h) a(i11, i12, i13, charSequence);
        q qVar = new q(this.f1095a, this, hVar);
        hVar.x(qVar);
        return qVar;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public void b(l lVar) {
        c(lVar, this.f1095a);
    }

    public final void b0(int i11, CharSequence charSequence, int i12, Drawable drawable, View view) {
        Resources resourcesE = E();
        if (view != null) {
            this.f1110p = view;
            this.f1108n = null;
            this.f1109o = null;
        } else {
            if (i11 > 0) {
                this.f1108n = resourcesE.getText(i11);
            } else if (charSequence != null) {
                this.f1108n = charSequence;
            }
            if (i12 > 0) {
                this.f1109o = z2.a.getDrawable(w(), i12);
            } else if (drawable != null) {
                this.f1109o = drawable;
            }
            this.f1110p = null;
        }
        N(false);
    }

    public void c(l lVar, Context context) {
        this.f1117w.add(new WeakReference<>(lVar));
        lVar.k(context, this);
        this.f1105k = true;
    }

    public f c0(int i11) {
        b0(i11, null, 0, null, null);
        return this;
    }

    @Override // android.view.Menu
    public void clear() {
        h hVar = this.f1118x;
        if (hVar != null) {
            f(hVar);
        }
        this.f1100f.clear();
        N(true);
    }

    public void clearHeader() {
        this.f1109o = null;
        this.f1108n = null;
        this.f1110p = null;
        N(false);
    }

    @Override // android.view.Menu
    public void close() {
        e(true);
    }

    public void d() {
        a aVar = this.f1099e;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    public f d0(CharSequence charSequence) {
        b0(0, charSequence, 0, null, null);
        return this;
    }

    public final void e(boolean z11) {
        if (this.f1115u) {
            return;
        }
        this.f1115u = true;
        for (WeakReference<l> weakReference : this.f1117w) {
            l lVar = weakReference.get();
            if (lVar == null) {
                this.f1117w.remove(weakReference);
            } else {
                lVar.b(this, z11);
            }
        }
        this.f1115u = false;
    }

    public f e0(View view) {
        b0(0, null, 0, null, view);
        return this;
    }

    public boolean f(h hVar) {
        boolean zJ = false;
        if (!this.f1117w.isEmpty() && this.f1118x == hVar) {
            i0();
            for (WeakReference<l> weakReference : this.f1117w) {
                l lVar = weakReference.get();
                if (lVar != null) {
                    zJ = lVar.j(this, hVar);
                    if (zJ) {
                        break;
                    }
                } else {
                    this.f1117w.remove(weakReference);
                }
            }
            h0();
            if (zJ) {
                this.f1118x = null;
            }
        }
        return zJ;
    }

    public void f0(boolean z11) {
        this.f1120z = z11;
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i11) {
        MenuItem menuItemFindItem;
        int size = size();
        for (int i12 = 0; i12 < size; i12++) {
            h hVar = this.f1100f.get(i12);
            if (hVar.getItemId() == i11) {
                return hVar;
            }
            if (hVar.hasSubMenu() && (menuItemFindItem = hVar.getSubMenu().findItem(i11)) != null) {
                return menuItemFindItem;
            }
        }
        return null;
    }

    public final h g(int i11, int i12, int i13, int i14, CharSequence charSequence, int i15) {
        return new h(this, i11, i12, i13, i14, charSequence, i15);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    public final void g0(boolean z11) {
        boolean z12;
        if (z11) {
            z12 = this.f1096b.getConfiguration().keyboard != 1 && ViewConfigurationCompat.shouldShowMenuShortcutsWhenKeyboardPresent(ViewConfiguration.get(this.f1095a), this.f1095a);
        }
        this.f1098d = z12;
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i11) {
        return this.f1100f.get(i11);
    }

    public boolean h(@NonNull f fVar, @NonNull MenuItem menuItem) {
        a aVar = this.f1099e;
        return aVar != null && aVar.a(fVar, menuItem);
    }

    public void h0() {
        this.f1111q = false;
        if (this.f1112r) {
            this.f1112r = false;
            N(this.f1113s);
        }
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.f1120z) {
            return true;
        }
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            if (this.f1100f.get(i11).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public final void i(boolean z11) {
        if (this.f1117w.isEmpty()) {
            return;
        }
        i0();
        for (WeakReference<l> weakReference : this.f1117w) {
            l lVar = weakReference.get();
            if (lVar == null) {
                this.f1117w.remove(weakReference);
            } else {
                lVar.h(z11);
            }
        }
        h0();
    }

    public void i0() {
        if (this.f1111q) {
            return;
        }
        this.f1111q = true;
        this.f1112r = false;
        this.f1113s = false;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i11, KeyEvent keyEvent) {
        return r(i11, keyEvent) != null;
    }

    public final void j(Bundle bundle) {
        Parcelable parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray == null || this.f1117w.isEmpty()) {
            return;
        }
        for (WeakReference<l> weakReference : this.f1117w) {
            l lVar = weakReference.get();
            if (lVar == null) {
                this.f1117w.remove(weakReference);
            } else {
                int id2 = lVar.getId();
                if (id2 > 0 && (parcelable = (Parcelable) sparseParcelableArray.get(id2)) != null) {
                    lVar.e(parcelable);
                }
            }
        }
    }

    public final void k(Bundle bundle) {
        Parcelable parcelableG;
        if (this.f1117w.isEmpty()) {
            return;
        }
        SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
        for (WeakReference<l> weakReference : this.f1117w) {
            l lVar = weakReference.get();
            if (lVar == null) {
                this.f1117w.remove(weakReference);
            } else {
                int id2 = lVar.getId();
                if (id2 > 0 && (parcelableG = lVar.g()) != null) {
                    sparseArray.put(id2, parcelableG);
                }
            }
        }
        bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
    }

    public final boolean l(q qVar, l lVar) {
        if (this.f1117w.isEmpty()) {
            return false;
        }
        boolean zF = lVar != null ? lVar.f(qVar) : false;
        for (WeakReference<l> weakReference : this.f1117w) {
            l lVar2 = weakReference.get();
            if (lVar2 == null) {
                this.f1117w.remove(weakReference);
            } else if (!zF) {
                zF = lVar2.f(qVar);
            }
        }
        return zF;
    }

    public boolean m(h hVar) {
        boolean zC = false;
        if (this.f1117w.isEmpty()) {
            return false;
        }
        i0();
        for (WeakReference<l> weakReference : this.f1117w) {
            l lVar = weakReference.get();
            if (lVar != null) {
                zC = lVar.c(this, hVar);
                if (zC) {
                    break;
                }
            } else {
                this.f1117w.remove(weakReference);
            }
        }
        h0();
        if (zC) {
            this.f1118x = hVar;
        }
        return zC;
    }

    public int n(int i11) {
        return o(i11, 0);
    }

    public int o(int i11, int i12) {
        int size = size();
        if (i12 < 0) {
            i12 = 0;
        }
        while (i12 < size) {
            if (this.f1100f.get(i12).getGroupId() == i11) {
                return i12;
            }
            i12++;
        }
        return -1;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i11, int i12) {
        return O(findItem(i11), i12);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i11, KeyEvent keyEvent, int i12) {
        h hVarR = r(i11, keyEvent);
        boolean zO = hVarR != null ? O(hVarR, i12) : false;
        if ((i12 & 2) != 0) {
            e(true);
        }
        return zO;
    }

    public int q(int i11) {
        int size = size();
        for (int i12 = 0; i12 < size; i12++) {
            if (this.f1100f.get(i12).getItemId() == i11) {
                return i12;
            }
        }
        return -1;
    }

    public h r(int i11, KeyEvent keyEvent) {
        ArrayList<h> arrayList = this.f1116v;
        arrayList.clear();
        s(arrayList, i11, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean zJ = J();
        for (int i12 = 0; i12 < size; i12++) {
            h hVar = arrayList.get(i12);
            char alphabeticShortcut = zJ ? hVar.getAlphabeticShortcut() : hVar.getNumericShortcut();
            char[] cArr = keyData.meta;
            if ((alphabeticShortcut == cArr[0] && (metaState & 2) == 0) || ((alphabeticShortcut == cArr[2] && (metaState & 2) != 0) || (zJ && alphabeticShortcut == '\b' && i11 == 67))) {
                return hVar;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public void removeGroup(int i11) {
        int iN = n(i11);
        if (iN >= 0) {
            int size = this.f1100f.size() - iN;
            int i12 = 0;
            while (true) {
                int i13 = i12 + 1;
                if (i12 >= size || this.f1100f.get(iN).getGroupId() != i11) {
                    break;
                }
                Q(iN, false);
                i12 = i13;
            }
            N(true);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i11) {
        Q(q(i11), true);
    }

    public void s(List<h> list, int i11, KeyEvent keyEvent) {
        boolean zJ = J();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i11 == 67) {
            int size = this.f1100f.size();
            for (int i12 = 0; i12 < size; i12++) {
                h hVar = this.f1100f.get(i12);
                if (hVar.hasSubMenu()) {
                    ((f) hVar.getSubMenu()).s(list, i11, keyEvent);
                }
                char alphabeticShortcut = zJ ? hVar.getAlphabeticShortcut() : hVar.getNumericShortcut();
                if ((modifiers & 69647) == ((zJ ? hVar.getAlphabeticModifiers() : hVar.getNumericModifiers()) & 69647) && alphabeticShortcut != 0) {
                    char[] cArr = keyData.meta;
                    if ((alphabeticShortcut == cArr[0] || alphabeticShortcut == cArr[2] || (zJ && alphabeticShortcut == '\b' && i11 == 67)) && hVar.isEnabled()) {
                        list.add(hVar);
                    }
                }
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i11, boolean z11, boolean z12) {
        int size = this.f1100f.size();
        for (int i12 = 0; i12 < size; i12++) {
            h hVar = this.f1100f.get(i12);
            if (hVar.getGroupId() == i11) {
                hVar.t(z12);
                hVar.setCheckable(z11);
            }
        }
    }

    @Override // e3.a, android.view.Menu
    public void setGroupDividerEnabled(boolean z11) {
        this.f1119y = z11;
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i11, boolean z11) {
        int size = this.f1100f.size();
        for (int i12 = 0; i12 < size; i12++) {
            h hVar = this.f1100f.get(i12);
            if (hVar.getGroupId() == i11) {
                hVar.setEnabled(z11);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i11, boolean z11) {
        int size = this.f1100f.size();
        boolean z12 = false;
        for (int i12 = 0; i12 < size; i12++) {
            h hVar = this.f1100f.get(i12);
            if (hVar.getGroupId() == i11 && hVar.y(z11)) {
                z12 = true;
            }
        }
        if (z12) {
            N(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z11) {
        this.f1097c = z11;
        N(false);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f1100f.size();
    }

    public void t() {
        ArrayList<h> arrayListG = G();
        if (this.f1105k) {
            boolean zI = false;
            for (WeakReference<l> weakReference : this.f1117w) {
                l lVar = weakReference.get();
                if (lVar == null) {
                    this.f1117w.remove(weakReference);
                } else {
                    zI |= lVar.i();
                }
            }
            if (zI) {
                this.f1103i.clear();
                this.f1104j.clear();
                int size = arrayListG.size();
                for (int i11 = 0; i11 < size; i11++) {
                    h hVar = arrayListG.get(i11);
                    if (hVar.l()) {
                        this.f1103i.add(hVar);
                    } else {
                        this.f1104j.add(hVar);
                    }
                }
            } else {
                this.f1103i.clear();
                this.f1104j.clear();
                this.f1104j.addAll(G());
            }
            this.f1105k = false;
        }
    }

    public ArrayList<h> u() {
        t();
        return this.f1103i;
    }

    public String v() {
        return "android:menu:actionviewstates";
    }

    public Context w() {
        return this.f1095a;
    }

    public h x() {
        return this.f1118x;
    }

    public Drawable y() {
        return this.f1109o;
    }

    public CharSequence z() {
        return this.f1108n;
    }
}
