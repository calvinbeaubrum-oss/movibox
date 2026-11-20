package e0;

import android.content.Context;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.cloud.tmc.integration.R$anim;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.ui.fragment.TmcFragment;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.ui.MiniShellFragment;
import com.cloud.tmc.miniapp.ui.OooO0OO;
import com.cloud.tmc.miniapp.widget.popupview.AddHomeCustomTopTipView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import p010OooOooo.o0000;
import p010OooOooo.o0000oo;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension
public final class g0 implements com.cloud.tmc.integration.ui.fragment.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f63591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<FragmentActivity> f63592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinkedHashMap<String, TmcFragment> f63593c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TmcFragment f63594d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayMap<String, TmcFragment> f63595e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TmcFragment f63596f;

    public g0(FragmentActivity activity, int i11) {
        Intrinsics.g(activity, "activity");
        this.f63591a = i11;
        this.f63592b = new WeakReference<>(activity);
        this.f63593c = new LinkedHashMap<>();
        this.f63595e = new ArrayMap<>(5);
    }

    @Override // com.cloud.tmc.integration.ui.fragment.a
    public TmcFragment a(Page page) {
        String pageId = page != null ? page.getPageId() : null;
        if (pageId == null || !this.f63593c.containsKey(pageId)) {
            return null;
        }
        return this.f63593c.get(pageId);
    }

    @Override // com.cloud.tmc.integration.ui.fragment.a
    public synchronized void b() {
        Page pageH0;
        TmcFragment tmcFragment = this.f63596f;
        if (tmcFragment != null && (pageH0 = tmcFragment.h0()) != null) {
            if (pageH0.getPageId() == null) {
                return;
            }
            TmcLogger.c("TmcFragmentManager", "clear invalid page and remove fragment from fragment manager");
            try {
                FragmentManager fragmentManagerR = r();
                if (fragmentManagerR == null || fragmentManagerR.isStateSaved()) {
                    com.cloud.tmc.kernel.utils.p.c("Tmcintegration", "isStateSaved is true , cant popBackStack");
                    return;
                }
                FragmentManager fragmentManagerR2 = r();
                if (fragmentManagerR2 != null) {
                    fragmentManagerR2.popBackStack(pageH0.getPageId(), 1);
                }
                FragmentManager fragmentManagerR3 = r();
                if (fragmentManagerR3 != null && fragmentManagerR3.executePendingTransactions()) {
                    this.f63596f = null;
                    App app = pageH0.getApp();
                    if (app == null) {
                        return;
                    }
                    int childCount = app.getChildCount() - 1;
                    for (int i11 = childCount; -1 < i11; i11--) {
                        Page pageByIndex = app.getPageByIndex(i11);
                        if (TextUtils.equals(pageH0.getPageId(), pageByIndex != null ? pageByIndex.getPageId() : null)) {
                            ArrayList<Page> arrayList = new ArrayList();
                            while (-1 < childCount) {
                                Page pageByIndex2 = app.getPageByIndex(childCount);
                                Page.a aVar = pageByIndex2 != null ? (Page.a) pageByIndex2.getData(Page.a.class, true) : null;
                                if (aVar != null) {
                                    aVar.f30918b = true;
                                }
                                if (pageByIndex2 != null) {
                                    arrayList.add(pageByIndex2);
                                }
                                if (TextUtils.equals(pageH0.getPageId(), pageByIndex2 != null ? pageByIndex2.getPageId() : null)) {
                                    break;
                                } else {
                                    childCount--;
                                }
                            }
                            for (Page page : arrayList) {
                                boolean z11 = false;
                                page.exit(false);
                                tb.d pageContext = page.getPageContext();
                                TmcFragment tmcFragment2 = pageContext instanceof TmcFragment ? (TmcFragment) pageContext : null;
                                App app2 = page.getApp();
                                if ((app2 == null || !app2.isExited()) && !((Page.a) page.getData(Page.a.class, true)).f30918b) {
                                    z11 = true;
                                }
                                t(tmcFragment2, z11);
                            }
                            o(app);
                            return;
                        }
                    }
                    o(app);
                }
            } catch (Throwable th2) {
                TmcLogger.g("TmcFragmentManager", "checkInvalidPage is failed!", th2);
            }
        }
    }

    @Override // com.cloud.tmc.integration.ui.fragment.a
    public boolean c(Page page, boolean z11, boolean z12) {
        return q(page != null ? page.getPageId() : null, z11, z12);
    }

    @Override // com.cloud.tmc.integration.ui.fragment.a
    public TmcFragment d(Page page) {
        Iterator<Map.Entry<String, TmcFragment>> it = this.f63593c.entrySet().iterator();
        String key = "";
        while (true) {
            if (!it.hasNext()) {
                return null;
            }
            Map.Entry<String, TmcFragment> next = it.next();
            if (Intrinsics.b(next.getKey(), page != null ? page.getPageId() : null)) {
                return this.f63593c.get(key);
            }
            key = next.getKey();
        }
    }

    @Override // com.cloud.tmc.integration.ui.fragment.a
    public void e(List<Page> tabPages) {
        Intrinsics.g(tabPages, "tabPages");
        Iterator<Map.Entry<String, TmcFragment>> it = this.f63593c.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, TmcFragment> next = it.next();
            if (!(tabPages instanceof Collection) || !tabPages.isEmpty()) {
                Iterator<T> it2 = tabPages.iterator();
                while (it2.hasNext()) {
                    if (Intrinsics.b(((Page) it2.next()).getPageId(), next.getKey())) {
                        ArrayMap<String, TmcFragment> arrayMap = this.f63595e;
                        Page pageH0 = next.getValue().h0();
                        arrayMap.put(pageH0 != null ? pageH0.getPagePath() : null, next.getValue());
                        it.remove();
                        break;
                    }
                }
            }
        }
    }

    @Override // com.cloud.tmc.integration.ui.fragment.a
    public TmcFragment f(String str) {
        if (str == null || !this.f63595e.containsKey(str)) {
            return null;
        }
        return this.f63595e.get(str);
    }

    @Override // com.cloud.tmc.integration.ui.fragment.a
    public TmcFragment g(Page page) {
        App app;
        App app2;
        if (com.cloud.tmc.integration.utils.h.f31061a.l((page == null || (app2 = page.getApp()) == null) ? null : app2.getAppModel())) {
            return new MiniShellFragment();
        }
        return (page == null || (app = page.getApp()) == null || app.getPageType(page.getPagePath()) != 1) ? new o0000oo() : new o0000();
    }

    @Override // com.cloud.tmc.integration.ui.fragment.a
    public void h(Page page, TmcFragment tmcFragment) {
        FragmentTransaction fragmentTransactionBeginTransaction;
        Intrinsics.g(page, "page");
        if (this.f63595e.containsKey(page.getPagePath())) {
            this.f63595e.remove(page.getPagePath());
            String pageId = page.getPageId();
            if (pageId == null || tmcFragment == null) {
                return;
            }
            this.f63593c.put(pageId, tmcFragment);
            try {
                FragmentManager fragmentManagerR = r();
                if (fragmentManagerR != null && (fragmentTransactionBeginTransaction = fragmentManagerR.beginTransaction()) != null) {
                    TmcFragment tmcFragment2 = this.f63594d;
                    if (tmcFragment2 != null) {
                        fragmentTransactionBeginTransaction.hide(tmcFragment2);
                    }
                    fragmentTransactionBeginTransaction.show(tmcFragment);
                    fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
                }
            } catch (Throwable th2) {
                TmcLogger.g("TmcFragmentManager", "switch tab fragment failed!", th2);
            }
            TmcFragment tmcFragment3 = this.f63594d;
            if (tmcFragment3 != null) {
                tmcFragment3.onPause();
                tmcFragment3.onStop();
            }
            this.f63594d = tmcFragment;
            tmcFragment.onStart();
            tmcFragment.onResume();
        }
        n();
    }

    @Override // com.cloud.tmc.integration.ui.fragment.a
    public boolean i(Page page) {
        return a(page) != null && this.f63593c.size() == 1;
    }

    @Override // com.cloud.tmc.integration.ui.fragment.a
    public Set<TmcFragment> j() {
        Collection<TmcFragment> collectionValues = this.f63593c.values();
        Intrinsics.f(collectionValues, "fragmentMap.values");
        return CollectionsKt___CollectionsKt.O0(collectionValues);
    }

    @Override // com.cloud.tmc.integration.ui.fragment.a
    public void k(Page page, TmcFragment tmcFragment, boolean z11, boolean z12) {
        Intrinsics.g(page, "page");
        s(page, tmcFragment, this.f63591a, z11, z12);
    }

    @Override // com.cloud.tmc.integration.ui.fragment.a
    public TmcFragment l() {
        Iterator<Map.Entry<String, TmcFragment>> it = this.f63593c.entrySet().iterator();
        if (it.hasNext()) {
            return it.next().getValue();
        }
        return null;
    }

    @Override // com.cloud.tmc.integration.ui.fragment.a
    public boolean m(Page page, boolean z11) {
        TmcFragment tmcFragmentRemove;
        boolean z12;
        String pagePath = page != null ? page.getPagePath() : null;
        if (pagePath == null || pagePath.length() == 0 || !this.f63595e.containsKey(pagePath) || (tmcFragmentRemove = this.f63595e.remove(pagePath)) == null) {
            return false;
        }
        Page pageH0 = tmcFragmentRemove.h0();
        String pageId = pageH0 != null ? pageH0.getPageId() : null;
        try {
            boolean zT = t(tmcFragmentRemove, z11);
            try {
                FragmentManager fragmentManagerR = r();
                if (fragmentManagerR != null && !fragmentManagerR.isDestroyed()) {
                    if (fragmentManagerR.isStateSaved()) {
                        com.cloud.tmc.kernel.utils.p.c("Tmcintegration", "isStateSaved is true , cant popBackStack");
                        return false;
                    }
                    fragmentManagerR.popBackStack(pageId, 1);
                    fragmentManagerR.executePendingTransactions();
                }
                return zT;
            } catch (Throwable th2) {
                th = th2;
                z12 = zT;
                TmcLogger.g("TmcFragmentManager", "fragment manager error", th);
                return z12;
            }
        } catch (Throwable th3) {
            th = th3;
            z12 = true;
        }
    }

    public final void n() {
        Page pageH0;
        App app;
        tb.b appContext;
        try {
            TmcFragment tmcFragment = this.f63594d;
            Context context = (tmcFragment == null || (pageH0 = tmcFragment.h0()) == null || (app = pageH0.getApp()) == null || (appContext = app.getAppContext()) == null) ? null : appContext.getContext();
            OooO0OO oooO0OO = context instanceof OooO0OO ? (OooO0OO) context : null;
            if (oooO0OO != null) {
                try {
                    AddHomeCustomTopTipView addHomeCustomTopTipViewE0 = oooO0OO.E0();
                    if (addHomeCustomTopTipViewE0 != null) {
                        addHomeCustomTopTipViewE0.OooO00o();
                        return;
                    }
                    return;
                } catch (Throwable th2) {
                    TmcLogger.h("MiniAppActivity", th2);
                    return;
                }
                TmcLogger.h("TmcFragmentManager", th);
            }
        } catch (Throwable th3) {
            TmcLogger.h("TmcFragmentManager", th3);
        }
    }

    public final void o(App app) {
        FragmentTransaction fragmentTransactionBeginTransaction;
        FragmentTransaction fragmentTransactionShow;
        try {
            Page activePage = app.getActivePage();
            if (activePage == null) {
                ListIterator listIterator = new ArrayList(this.f63593c.entrySet()).listIterator(this.f63593c.size());
                Intrinsics.f(listIterator, "ArrayList<Map.Entry<Stri…ize\n                    )");
                if (listIterator.hasPrevious()) {
                    Object objPrevious = listIterator.previous();
                    Intrinsics.f(objPrevious, "iterator.previous()");
                    activePage = ((TmcFragment) ((Map.Entry) objPrevious).getValue()).h0();
                } else {
                    activePage = null;
                }
            }
            if (activePage != null) {
                tb.d pageContext = activePage.getPageContext();
                if (pageContext instanceof TmcFragment) {
                    TmcFragment tmcFragment = (TmcFragment) pageContext;
                    this.f63594d = tmcFragment;
                    if (tmcFragment != null) {
                        try {
                            FragmentManager fragmentManagerR = r();
                            if (fragmentManagerR != null && (fragmentTransactionBeginTransaction = fragmentManagerR.beginTransaction()) != null && (fragmentTransactionShow = fragmentTransactionBeginTransaction.show(tmcFragment)) != null) {
                                fragmentTransactionShow.commitNowAllowingStateLoss();
                            }
                            Page pageH0 = tmcFragment.h0();
                            if (pageH0 != null) {
                                pageH0.show();
                            }
                            tmcFragment.onStart();
                            tmcFragment.onResume();
                        } catch (Throwable th2) {
                            TmcLogger.g("TmcFragmentManager", "notice fragment update failed!", th2);
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            TmcLogger.g("TmcFragmentManager", "noticeTmcFragmentUpdate is failed!", th3);
        }
    }

    @Override // com.cloud.tmc.integration.ui.fragment.a
    public boolean onBackPressed() {
        FragmentManager fragmentManagerR;
        FragmentActivity fragmentActivity = this.f63592b.get();
        if (fragmentActivity == null || this.f63593c.size() == 0 || fragmentActivity.getSupportFragmentManager().getBackStackEntryCount() == 0) {
            return false;
        }
        ListIterator listIterator = new ArrayList(this.f63593c.entrySet()).listIterator(this.f63593c.size());
        Intrinsics.f(listIterator, "ArrayList<Map.Entry<Stri…ap.size\n                )");
        if (listIterator.hasPrevious()) {
            this.f63593c.remove(((Map.Entry) listIterator.previous()).getKey());
        }
        if (this.f63593c.size() == 0 || (fragmentManagerR = r()) == null || fragmentManagerR.isStateSaved()) {
            return false;
        }
        try {
            fragmentActivity.getSupportFragmentManager().popBackStack();
        } catch (Throwable th2) {
            TmcLogger.h("TmcFragmentManager", th2);
        }
        return true;
    }

    public final void p(String str, TmcFragment tmcFragment, int i11, boolean z11, boolean z12) {
        App app;
        FragmentTransaction fragmentTransactionBeginTransaction;
        Page pageH0;
        if (str == null || tmcFragment == null) {
            return;
        }
        FragmentManager fragmentManagerR = r();
        if (fragmentManagerR != null && (fragmentTransactionBeginTransaction = fragmentManagerR.beginTransaction()) != null) {
            if (z11 && this.f63594d != null) {
                fragmentTransactionBeginTransaction.setCustomAnimations(R$anim.in_from_right, R$anim.out_from_left, R$anim.in_from_left, R$anim.out_from_right);
            }
            TmcFragment tmcFragment2 = this.f63594d;
            if (tmcFragment2 != null && (!z12 || ((pageH0 = tmcFragment2.h0()) != null && pageH0.isTabPage()))) {
                fragmentTransactionBeginTransaction.hide(tmcFragment2);
                tmcFragment2.onPause();
                tmcFragment2.onStop();
            }
            try {
                fragmentTransactionBeginTransaction.add(i11, tmcFragment, str);
                fragmentTransactionBeginTransaction.addToBackStack(str);
                fragmentTransactionBeginTransaction.commitAllowingStateLoss();
            } catch (Throwable th2) {
                TmcLogger.g("TmcFragmentManager", "push fragment failed!", th2);
            }
        }
        this.f63593c.put(str, tmcFragment);
        this.f63594d = tmcFragment;
        if (this.f63593c.size() > 10) {
            int size = this.f63593c.size() - 10;
            Iterator<Map.Entry<String, TmcFragment>> it = this.f63593c.entrySet().iterator();
            TmcFragment value = null;
            while (it.hasNext() && size != 0) {
                Map.Entry<String, TmcFragment> next = it.next();
                Page pageH1 = next.getValue().h0();
                if (pageH1 == null || !pageH1.isHomePage()) {
                    if (pageH1 == null || !pageH1.isTabPage()) {
                        if (this.f63596f == null) {
                            this.f63596f = next.getValue();
                        }
                        value = next.getValue();
                        it.remove();
                        size--;
                    }
                }
            }
            Page pageH2 = value != null ? value.h0() : null;
            if (pageH2 != null && (app = pageH2.getApp()) != null) {
                for (int childCount = app.getChildCount() - 1; -1 < childCount; childCount--) {
                    App app2 = pageH2.getApp();
                    Page pageByIndex = app2 != null ? app2.getPageByIndex(childCount) : null;
                    if (Intrinsics.b(pageByIndex != null ? pageByIndex.getStringValue("prePageId") : null, pageH2.getPageId())) {
                        if (pageByIndex == null) {
                            break;
                        }
                        pageByIndex.putBooleanValue("exitPage", true);
                        break;
                    }
                }
            }
        }
        n();
    }

    public final boolean q(String str, boolean z11, boolean z12) {
        TmcFragment tmcFragment;
        View view;
        FragmentTransaction fragmentTransactionBeginTransaction;
        FragmentTransaction fragmentTransactionShow;
        Page pageH0;
        boolean z13 = false;
        if (str != null && this.f63593c.containsKey(str)) {
            ListIterator listIterator = new ArrayList(this.f63593c.entrySet()).listIterator(this.f63593c.size());
            Intrinsics.f(listIterator, "ArrayList<Map.Entry<Stri…terator(fragmentMap.size)");
            Object key = "";
            TmcFragment tmcFragmentRemove = null;
            boolean z14 = false;
            while (listIterator.hasPrevious() && !z14) {
                Object objPrevious = listIterator.previous();
                Intrinsics.f(objPrevious, "iterator.previous()");
                Map.Entry entry = (Map.Entry) objPrevious;
                tmcFragmentRemove = this.f63593c.remove(entry.getKey());
                if (Intrinsics.b(entry.getKey(), str)) {
                    key = entry.getKey();
                    z14 = true;
                }
            }
            if (this.f63593c.size() > 0) {
                ListIterator listIterator2 = new ArrayList(this.f63593c.entrySet()).listIterator(this.f63593c.size());
                Intrinsics.f(listIterator2, "ArrayList<Map.Entry<Stri…entMap.size\n            )");
                TmcFragment tmcFragment2 = this.f63594d;
                if (tmcFragment2 != null) {
                    Page pageH1 = tmcFragment2.h0();
                    if (pageH1 != null) {
                        pageH1.hide();
                    }
                    tmcFragment2.onPause();
                    tmcFragment2.onStop();
                }
                this.f63594d = (TmcFragment) ((Map.Entry) listIterator2.previous()).getValue();
                if ((tmcFragmentRemove == null || (pageH0 = tmcFragmentRemove.h0()) == null || !pageH0.getBooleanValue("exitPage")) && (tmcFragment = this.f63594d) != null) {
                    try {
                        FragmentManager fragmentManagerR = r();
                        if (fragmentManagerR != null && (fragmentTransactionBeginTransaction = fragmentManagerR.beginTransaction()) != null && (fragmentTransactionShow = fragmentTransactionBeginTransaction.show(tmcFragment)) != null) {
                            fragmentTransactionShow.commitNowAllowingStateLoss();
                        }
                        if (tmcFragment.isAdded() && !tmcFragment.isHidden() && !tmcFragment.isVisible() && (view = tmcFragment.getView()) != null) {
                            Intrinsics.f(view, "view");
                            xb.i.e(view);
                        }
                        Page pageH2 = tmcFragment.h0();
                        if (pageH2 != null) {
                            pageH2.show();
                        }
                        tmcFragment.onStart();
                        tmcFragment.onResume();
                    } catch (Throwable th2) {
                        TmcLogger.g("TmcFragmentManager", "last page resume failed!", th2);
                    }
                }
                try {
                    t(tmcFragmentRemove, z11);
                    FragmentManager fragmentManagerR2 = r();
                    if (fragmentManagerR2 == null) {
                        z13 = z14;
                    } else if (fragmentManagerR2.isStateSaved()) {
                        try {
                            com.cloud.tmc.kernel.utils.p.c("Tmcintegration", "isStateSaved is true , cant popBackStack");
                        } catch (Throwable th3) {
                            th = th3;
                            TmcLogger.g("TmcFragmentManager", "remove fragment failed!", th);
                        }
                    } else {
                        fragmentManagerR2.popBackStack((String) key, 1);
                        fragmentManagerR2.executePendingTransactions();
                        z13 = z14;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    z13 = z14;
                }
            } else {
                if (this.f63593c.size() == 0 && z12) {
                    Iterator<Map.Entry<String, TmcFragment>> it = this.f63595e.entrySet().iterator();
                    while (it.hasNext()) {
                        TmcFragment value = it.next().getValue();
                        try {
                            FragmentManager fragmentManagerR3 = r();
                            if (fragmentManagerR3 != null && !fragmentManagerR3.isDestroyed()) {
                                if (fragmentManagerR3.isStateSaved()) {
                                    com.cloud.tmc.kernel.utils.p.c("Tmcintegration", "isStateSaved is true , cant popBackStack");
                                    z14 = false;
                                } else {
                                    Page pageH3 = value.h0();
                                    fragmentManagerR3.popBackStack(pageH3 != null ? pageH3.getPageId() : null, 1);
                                    fragmentManagerR3.executePendingTransactions();
                                }
                            }
                            it.remove();
                        } catch (Throwable th5) {
                            TmcLogger.g("TmcFragmentManager", "fragment manager error", th5);
                        }
                    }
                    release();
                } else {
                    this.f63594d = null;
                    Iterator<Map.Entry<String, TmcFragment>> it2 = this.f63595e.entrySet().iterator();
                    while (it2.hasNext()) {
                        TmcFragment value2 = it2.next().getValue();
                        try {
                            FragmentManager fragmentManagerR4 = r();
                            if (fragmentManagerR4 != null) {
                                if (fragmentManagerR4.isStateSaved()) {
                                    com.cloud.tmc.kernel.utils.p.c("Tmcintegration", "isStateSaved is true , cant popBackStack");
                                    z14 = false;
                                } else {
                                    Page pageH4 = value2.h0();
                                    fragmentManagerR4.popBackStack(pageH4 != null ? pageH4.getPageId() : null, 1);
                                    fragmentManagerR4.executePendingTransactions();
                                }
                            }
                            it2.remove();
                        } catch (Throwable th6) {
                            TmcLogger.g("TmcFragmentManager", "remove tab fragment failed!", th6);
                        }
                    }
                    try {
                        FragmentManager fragmentManagerR5 = r();
                        if (fragmentManagerR5 == null || fragmentManagerR5.isStateSaved()) {
                            com.cloud.tmc.kernel.utils.p.c("Tmcintegration", "isStateSaved is true , cant popBackStack");
                        } else {
                            FragmentManager fragmentManagerR6 = r();
                            if (fragmentManagerR6 != null) {
                                fragmentManagerR6.popBackStack((String) key, 1);
                            }
                        }
                    } catch (Throwable th7) {
                        TmcLogger.g("TmcFragmentManager", "remove fragment popBackStack failed!", th7);
                    }
                }
                z13 = z14;
            }
            n();
        }
        return z13;
    }

    public FragmentManager r() {
        FragmentActivity fragmentActivity = this.f63592b.get();
        if (fragmentActivity != null) {
            return fragmentActivity.getSupportFragmentManager();
        }
        return null;
    }

    @Override // com.cloud.tmc.integration.ui.fragment.a
    public void release() {
        this.f63592b.clear();
        this.f63593c.clear();
        this.f63595e.clear();
        this.f63594d = null;
    }

    public void s(Page page, TmcFragment tmcFragment, int i11, boolean z11, boolean z12) {
        Intrinsics.g(page, "page");
        if (tmcFragment != null) {
            tmcFragment.j0(page);
        }
        p(page.getPageId(), tmcFragment, i11, z11, z12);
    }

    public boolean t(TmcFragment tmcFragment, boolean z11) {
        FragmentTransaction fragmentTransactionBeginTransaction;
        if (tmcFragment != null) {
            try {
                FragmentManager fragmentManagerR = r();
                if (fragmentManagerR != null && (fragmentTransactionBeginTransaction = fragmentManagerR.beginTransaction()) != null) {
                    if (z11) {
                        fragmentTransactionBeginTransaction.setCustomAnimations(R$anim.in_from_left, R$anim.out_from_right, R$anim.in_from_right, R$anim.out_from_left);
                    } else {
                        fragmentTransactionBeginTransaction.setCustomAnimations(0, 0, 0, 0);
                    }
                    fragmentTransactionBeginTransaction.setTransition(8194);
                    fragmentTransactionBeginTransaction.remove(tmcFragment);
                    fragmentTransactionBeginTransaction.commitAllowingStateLoss();
                    return true;
                }
            } catch (Throwable th2) {
                TmcLogger.g("TmcFragmentManager", "remove fragment error", th2);
            }
        }
        return false;
    }
}
