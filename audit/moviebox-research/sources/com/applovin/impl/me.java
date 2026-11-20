package com.applovin.impl;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.sdk.AppLovinPrivacySettings;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class me extends ec {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ke f20657f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List f20658g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List f20659h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List f20660i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final List f20661j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final List f20662k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private SpannedString f20663l;

    /* JADX INFO: compiled from: source.java */
    public enum a {
        INTEGRATIONS,
        PERMISSIONS,
        CONFIGURATION,
        DEPENDENCIES,
        TEST_ADS,
        COUNT
    }

    public me(ke keVar, Context context) {
        super(context);
        this.f20657f = keVar;
        if (keVar.q() == ke.a.INVALID_INTEGRATION) {
            SpannableString spannableString = new SpannableString("Tap for more information");
            spannableString.setSpan(new AbsoluteSizeSpan(12, true), 0, spannableString.length(), 33);
            this.f20663l = new SpannedString(spannableString);
        } else {
            this.f20663l = new SpannedString("");
        }
        this.f20658g = g();
        this.f20659h = b(keVar.n());
        this.f20660i = e();
        this.f20661j = a(keVar.f());
        this.f20662k = j();
        notifyDataSetChanged();
    }

    private int a(boolean z11) {
        return z11 ? R.drawable.applovin_ic_check_mark_bordered : R.drawable.applovin_ic_x_mark;
    }

    private dc a(ke.b bVar) {
        dc.b bVarA = dc.a();
        if (bVar == ke.b.READY) {
            bVarA.a(this.f18683a);
        }
        return bVarA.d("Test Mode").c(bVar.c()).c(bVar.d()).b("Restart Required").a(bVar.b()).a(true).a();
    }

    private dc a(String str, String str2, boolean z11, boolean z12) {
        return dc.a(z11 ? dc.c.RIGHT_DETAIL : dc.c.DETAIL).d(str).a(z11 ? null : this.f20663l).b("Instructions").a(str2).a(z11 ? R.drawable.applovin_ic_check_mark_bordered : c(z12)).b(z11 ? t3.a(R.color.applovin_sdk_checkmarkColor, this.f18683a) : d(z12)).a(!z11).a();
    }

    private List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        if (list.size() > 0) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                p6 p6Var = (p6) it.next();
                arrayList.add(a(p6Var.b(), p6Var.a(), p6Var.c(), true));
            }
        }
        return arrayList;
    }

    private int b(boolean z11) {
        return t3.a(z11 ? R.color.applovin_sdk_checkmarkColor : R.color.applovin_sdk_xmarkColor, this.f18683a);
    }

    private List b(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        if (list.size() > 0) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                hh hhVar = (hh) it.next();
                arrayList.add(a(hhVar.b(), hhVar.a(), hhVar.c(), true));
            }
        }
        return arrayList;
    }

    private int c(boolean z11) {
        return z11 ? R.drawable.applovin_ic_x_mark : R.drawable.applovin_ic_warning;
    }

    private dc c(List list) {
        return dc.a().d("Region/VPN Required").c(CollectionUtils.implode(list, ", ", list.size())).a();
    }

    private int d(boolean z11) {
        return t3.a(z11 ? R.color.applovin_sdk_xmarkColor : R.color.applovin_sdk_warningColor, this.f18683a);
    }

    private dc d() {
        dc.b bVarC = dc.a().d("Adapter").c(this.f20657f.c());
        if (TextUtils.isEmpty(this.f20657f.c())) {
            bVarC.a(a(this.f20657f.y())).b(b(this.f20657f.y()));
        }
        return bVarC.a();
    }

    private List e() {
        ArrayList arrayList = new ArrayList(1);
        if (this.f20657f.B()) {
            arrayList.add(a("Java 8", "For optimal performance, please enable Java 8 support. See: https://developers.applovin.com/en/android/overview/integration", com.applovin.impl.sdk.j.y0(), true));
        }
        return arrayList;
    }

    private dc f() {
        if (this.f20657f.F()) {
            return null;
        }
        return dc.a().d("Initialization Status").c(f(this.f20657f.i())).a(false).a();
    }

    private String f(int i11) {
        if (MaxAdapter.InitializationStatus.INITIALIZED_SUCCESS.getCode() == i11 || MaxAdapter.InitializationStatus.INITIALIZED_UNKNOWN.getCode() == i11 || MaxAdapter.InitializationStatus.DOES_NOT_APPLY.getCode() == i11) {
            return "Initialized";
        }
        if (MaxAdapter.InitializationStatus.INITIALIZED_FAILURE.getCode() == i11) {
            return "Failure";
        }
        return MaxAdapter.InitializationStatus.INITIALIZING.getCode() == i11 ? "Initializing..." : "Not Initialized";
    }

    private List g() {
        ArrayList arrayList = new ArrayList(3);
        CollectionUtils.addObjectIfExists(i(), arrayList);
        CollectionUtils.addObjectIfExists(d(), arrayList);
        CollectionUtils.addObjectIfExists(f(), arrayList);
        return arrayList;
    }

    private dc i() {
        dc.b bVarC = dc.a().d("SDK").c(this.f20657f.p());
        if (TextUtils.isEmpty(this.f20657f.p())) {
            bVarC.a(a(this.f20657f.C())).b(b(this.f20657f.C()));
        }
        return bVarC.a();
    }

    private List j() {
        ArrayList arrayList = new ArrayList(3);
        if (StringUtils.isValidString(this.f20657f.u())) {
            arrayList.add(dc.a(dc.c.DETAIL).d(this.f20657f.u()).a());
        }
        if (this.f20657f.x() == ke.b.NOT_SUPPORTED) {
            return arrayList;
        }
        if (this.f20657f.s() != null) {
            arrayList.add(c(this.f20657f.s()));
        }
        if (this.f20657f.D()) {
            arrayList.add(a("Not an Age Restricted User", "Test mode requires Age Restricted User (COPPA) to be set to false.", !AppLovinPrivacySettings.isAgeRestrictedUser(this.f18683a) && AppLovinPrivacySettings.isAgeRestrictedUserSet(this.f18683a), false));
        }
        arrayList.add(a(this.f20657f.x()));
        return arrayList;
    }

    public boolean a(lb lbVar) {
        return lbVar.b() == a.TEST_ADS.ordinal() && lbVar.a() == this.f20662k.size() - 1;
    }

    @Override // com.applovin.impl.ec
    public int b() {
        return a.COUNT.ordinal();
    }

    @Override // com.applovin.impl.ec
    public List c(int i11) {
        if (i11 == a.INTEGRATIONS.ordinal()) {
            return this.f20658g;
        }
        if (i11 == a.PERMISSIONS.ordinal()) {
            return this.f20659h;
        }
        if (i11 == a.CONFIGURATION.ordinal()) {
            return this.f20660i;
        }
        return i11 == a.DEPENDENCIES.ordinal() ? this.f20661j : this.f20662k;
    }

    @Override // com.applovin.impl.ec
    public int d(int i11) {
        if (i11 == a.INTEGRATIONS.ordinal()) {
            return this.f20658g.size();
        }
        if (i11 == a.PERMISSIONS.ordinal()) {
            return this.f20659h.size();
        }
        if (i11 == a.CONFIGURATION.ordinal()) {
            return this.f20660i.size();
        }
        return i11 == a.DEPENDENCIES.ordinal() ? this.f20661j.size() : this.f20662k.size();
    }

    @Override // com.applovin.impl.ec
    public dc e(int i11) {
        if (i11 == a.INTEGRATIONS.ordinal()) {
            return new fj("INTEGRATIONS");
        }
        if (i11 == a.PERMISSIONS.ordinal()) {
            return new fj("PERMISSIONS");
        }
        if (i11 == a.CONFIGURATION.ordinal()) {
            return new fj("CONFIGURATION");
        }
        return i11 == a.DEPENDENCIES.ordinal() ? new fj("DEPENDENCIES") : new fj("TEST ADS");
    }

    public ke h() {
        return this.f20657f;
    }

    public void k() {
        this.f20658g = g();
    }

    public String toString() {
        return "MediatedNetworkListAdapter{}";
    }
}
