package com.android.billingclient.api;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.play_billing.zzaf;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzin;
import com.google.android.gms.internal.play_billing.zzio;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class i extends h {
    public ExecutorService A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile int f16331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f16332b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f16333c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public volatile q1 f16334d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Context f16335e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public n0 f16336f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile com.google.android.gms.internal.play_billing.zzm f16337g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile f0 f16338h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f16339i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f16340j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f16341k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f16342l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f16343m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f16344n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f16345o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f16346p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f16347q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f16348r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f16349s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f16350t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f16351u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f16352v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f16353w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f16354x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @Nullable
    public x0 f16355y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f16356z;

    public i(@Nullable String str, Context context, @Nullable n0 n0Var, @Nullable ExecutorService executorService) {
        this.f16331a = 0;
        this.f16333c = new Handler(Looper.getMainLooper());
        this.f16341k = 0;
        String strJ = J();
        this.f16332b = strJ;
        this.f16335e = context.getApplicationContext();
        zzin zzinVarZzv = zzio.zzv();
        zzinVarZzv.zzj(strJ);
        zzinVarZzv.zzi(this.f16335e.getPackageName());
        this.f16336f = new q0(this.f16335e, (zzio) zzinVarZzv.zzc());
        this.f16335e.getPackageName();
    }

    public i(@Nullable String str, x0 x0Var, Context context, t0 t0Var, @Nullable n0 n0Var, @Nullable ExecutorService executorService) {
        this.f16331a = 0;
        this.f16333c = new Handler(Looper.getMainLooper());
        this.f16341k = 0;
        this.f16332b = J();
        this.f16335e = context.getApplicationContext();
        zzin zzinVarZzv = zzio.zzv();
        zzinVarZzv.zzj(J());
        zzinVarZzv.zzi(this.f16335e.getPackageName());
        this.f16336f = new q0(this.f16335e, (zzio) zzinVarZzv.zzc());
        zzb.zzk("BillingClient", "Billing client should have a valid listener but the provided is null.");
        this.f16334d = new q1(this.f16335e, null, this.f16336f);
        this.f16355y = x0Var;
        this.f16335e.getPackageName();
    }

    public i(@Nullable String str, x0 x0Var, Context context, v vVar, @Nullable c cVar, @Nullable n0 n0Var, @Nullable ExecutorService executorService) {
        String strJ = J();
        this.f16331a = 0;
        this.f16333c = new Handler(Looper.getMainLooper());
        this.f16341k = 0;
        this.f16332b = strJ;
        g(context, vVar, x0Var, cVar, strJ, null);
    }

    public static /* synthetic */ e1 E(i iVar, String str, int i11) {
        zzb.zzj("BillingClient", "Querying owned items, item type: ".concat(String.valueOf(str)));
        ArrayList arrayList = new ArrayList();
        boolean z11 = true;
        Bundle bundleZzd = zzb.zzd(iVar.f16344n, iVar.f16352v, true, false, iVar.f16332b);
        List list = null;
        String string = null;
        while (true) {
            try {
                Bundle bundleZzj = iVar.f16344n ? iVar.f16337g.zzj(z11 != iVar.f16352v ? 9 : 19, iVar.f16335e.getPackageName(), str, string, bundleZzd) : iVar.f16337g.zzi(3, iVar.f16335e.getPackageName(), str, string);
                f1 f1VarA = g1.a(bundleZzj, "BillingClient", "getPurchase()");
                n nVarA = f1VarA.a();
                if (nVarA != p0.f16398l) {
                    iVar.f16336f.a(m0.a(f1VarA.b(), 9, nVarA));
                    return new e1(nVarA, list);
                }
                ArrayList<String> stringArrayList = bundleZzj.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList<String> stringArrayList2 = bundleZzj.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList<String> stringArrayList3 = bundleZzj.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                boolean z12 = false;
                for (int i12 = 0; i12 < stringArrayList2.size(); i12++) {
                    String str2 = stringArrayList2.get(i12);
                    String str3 = stringArrayList3.get(i12);
                    zzb.zzj("BillingClient", "Sku is owned: ".concat(String.valueOf(stringArrayList.get(i12))));
                    try {
                        Purchase purchase = new Purchase(str2, str3);
                        if (TextUtils.isEmpty(purchase.g())) {
                            zzb.zzk("BillingClient", "BUG: empty/null token!");
                            z12 = true;
                        }
                        arrayList.add(purchase);
                    } catch (JSONException e11) {
                        zzb.zzl("BillingClient", "Got an exception trying to decode the purchase!", e11);
                        n0 n0Var = iVar.f16336f;
                        n nVar = p0.f16396j;
                        n0Var.a(m0.a(51, 9, nVar));
                        return new e1(nVar, null);
                    }
                }
                if (z12) {
                    iVar.f16336f.a(m0.a(26, 9, p0.f16396j));
                }
                string = bundleZzj.getString("INAPP_CONTINUATION_TOKEN");
                zzb.zzj("BillingClient", "Continuation token: ".concat(String.valueOf(string)));
                if (TextUtils.isEmpty(string)) {
                    return new e1(p0.f16398l, arrayList);
                }
                list = null;
                z11 = true;
            } catch (Exception e12) {
                n0 n0Var2 = iVar.f16336f;
                n nVar2 = p0.f16399m;
                n0Var2.a(m0.a(52, 9, nVar2));
                zzb.zzl("BillingClient", "Got exception trying to get purchasesm try to reconnect", e12);
                return new e1(nVar2, null);
            }
        }
    }

    @SuppressLint({"PrivateApi"})
    public static String J() {
        try {
            return (String) t7.a.class.getField("VERSION_NAME").get(null);
        } catch (Exception unused) {
            return "6.1.0";
        }
    }

    public final /* synthetic */ void A(t tVar) {
        n0 n0Var = this.f16336f;
        n nVar = p0.f16400n;
        n0Var.a(m0.a(24, 11, nVar));
        tVar.a(nVar, null);
    }

    public final /* synthetic */ void B(u uVar) {
        n0 n0Var = this.f16336f;
        n nVar = p0.f16400n;
        n0Var.a(m0.a(24, 9, nVar));
        uVar.a(nVar, zzaf.zzk());
    }

    public final /* synthetic */ void C(y yVar) {
        n0 n0Var = this.f16336f;
        n nVar = p0.f16400n;
        n0Var.a(m0.a(24, 8, nVar));
        yVar.a(nVar, null);
    }

    public final /* synthetic */ void D(e eVar) {
        n0 n0Var = this.f16336f;
        n nVar = p0.f16400n;
        n0Var.a(m0.a(24, 16, nVar));
        eVar.a(nVar);
    }

    public final Handler F() {
        return Looper.myLooper() == null ? this.f16333c : new Handler(Looper.myLooper());
    }

    public final n G(final n nVar) {
        if (Thread.interrupted()) {
            return nVar;
        }
        this.f16333c.post(new Runnable() { // from class: com.android.billingclient.api.zzj
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.u(nVar);
            }
        });
        return nVar;
    }

    public final n I() {
        return (this.f16331a == 0 || this.f16331a == 3) ? p0.f16399m : p0.f16396j;
    }

    @Nullable
    public final Future K(Callable callable, long j11, @Nullable final Runnable runnable, Handler handler) {
        if (this.A == null) {
            this.A = Executors.newFixedThreadPool(zzb.zza, new b0(this));
        }
        try {
            final Future futureSubmit = this.A.submit(callable);
            handler.postDelayed(new Runnable() { // from class: com.android.billingclient.api.zzn
                @Override // java.lang.Runnable
                public final void run() {
                    Future future = futureSubmit;
                    if (future.isDone() || future.isCancelled()) {
                        return;
                    }
                    Runnable runnable2 = runnable;
                    future.cancel(true);
                    zzb.zzk("BillingClient", "Async task is taking too long, cancel it!");
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                }
            }, (long) (j11 * 0.95d));
            return futureSubmit;
        } catch (Exception e11) {
            zzb.zzl("BillingClient", "Async task throws exception!", e11);
            return null;
        }
    }

    public final void L(String str, final u uVar) {
        if (!a()) {
            n0 n0Var = this.f16336f;
            n nVar = p0.f16399m;
            n0Var.a(m0.a(2, 9, nVar));
            uVar.a(nVar, zzaf.zzk());
            return;
        }
        if (TextUtils.isEmpty(str)) {
            zzb.zzk("BillingClient", "Please provide a valid product type.");
            n0 n0Var2 = this.f16336f;
            n nVar2 = p0.f16393g;
            n0Var2.a(m0.a(50, 9, nVar2));
            uVar.a(nVar2, zzaf.zzk());
            return;
        }
        if (K(new c0(this, str, uVar), 30000L, new Runnable() { // from class: com.android.billingclient.api.zzs
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.B(uVar);
            }
        }, F()) == null) {
            n nVarI = I();
            this.f16336f.a(m0.a(25, 9, nVarI));
            uVar.a(nVarI, zzaf.zzk());
        }
    }

    public final /* synthetic */ Bundle N(int i11, String str, String str2, m mVar, Bundle bundle) throws Exception {
        return this.f16337g.zzg(i11, this.f16335e.getPackageName(), str, str2, null, bundle);
    }

    public final /* synthetic */ Bundle O(String str, String str2) throws Exception {
        return this.f16337g.zzf(3, this.f16335e.getPackageName(), str, str2, null);
    }

    public final /* synthetic */ Object U(w wVar, s sVar) throws Exception {
        String strZzg;
        int iZzb;
        int i11;
        ArrayList arrayList = new ArrayList();
        String strC = wVar.c();
        zzaf zzafVarB = wVar.b();
        int size = zzafVarB.size();
        int i12 = 0;
        while (true) {
            if (i12 >= size) {
                strZzg = "";
                iZzb = 0;
                break;
            }
            int i13 = i12 + 20;
            ArrayList arrayList2 = new ArrayList(zzafVarB.subList(i12, i13 > size ? size : i13));
            ArrayList<String> arrayList3 = new ArrayList<>();
            int size2 = arrayList2.size();
            for (int i14 = 0; i14 < size2; i14++) {
                arrayList3.add(((w.b) arrayList2.get(i14)).b());
            }
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList3);
            bundle.putString("playBillingLibraryVersion", this.f16332b);
            try {
                com.google.android.gms.internal.play_billing.zzm zzmVar = this.f16337g;
                int i15 = true != this.f16353w ? 17 : 20;
                String packageName = this.f16335e.getPackageName();
                String str = this.f16332b;
                if (TextUtils.isEmpty(null)) {
                    this.f16335e.getPackageName();
                }
                Bundle bundle2 = new Bundle();
                bundle2.putString("playBillingLibraryVersion", str);
                bundle2.putBoolean("enablePendingPurchases", true);
                bundle2.putString("SKU_DETAILS_RESPONSE_FORMAT", "PRODUCT_DETAILS");
                ArrayList<String> arrayList4 = new ArrayList<>();
                ArrayList<String> arrayList5 = new ArrayList<>();
                int size3 = arrayList2.size();
                zzaf zzafVar = zzafVarB;
                int i16 = 0;
                boolean z11 = false;
                boolean z12 = false;
                while (i16 < size3) {
                    w.b bVar = (w.b) arrayList2.get(i16);
                    ArrayList arrayList6 = arrayList2;
                    arrayList4.add(null);
                    z11 |= !TextUtils.isEmpty(null);
                    String strC2 = bVar.c();
                    int i17 = size3;
                    if (strC2.equals("first_party")) {
                        com.google.android.gms.internal.play_billing.zzx.zzc(null, "Serialized DocId is required for constructing ExtraParams to query ProductDetails for all first party products.");
                        arrayList5.add(null);
                        z12 = true;
                    }
                    i16++;
                    size3 = i17;
                    arrayList2 = arrayList6;
                }
                if (z11) {
                    bundle2.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList4);
                }
                if (!arrayList5.isEmpty()) {
                    bundle2.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList5);
                }
                if (z12 && !TextUtils.isEmpty(null)) {
                    bundle2.putString("accountName", null);
                }
                i11 = 7;
                try {
                    Bundle bundleZzl = zzmVar.zzl(i15, packageName, strC, bundle, bundle2);
                    strZzg = "Item is unavailable for purchase.";
                    if (bundleZzl != null) {
                        if (bundleZzl.containsKey("DETAILS_LIST")) {
                            ArrayList<String> stringArrayList = bundleZzl.getStringArrayList("DETAILS_LIST");
                            if (stringArrayList == null) {
                                zzb.zzk("BillingClient", "queryProductDetailsAsync got null response list");
                                this.f16336f.a(m0.a(46, 7, p0.B));
                            } else {
                                for (int i18 = 0; i18 < stringArrayList.size(); i18++) {
                                    try {
                                        r rVar = new r(stringArrayList.get(i18));
                                        zzb.zzj("BillingClient", "Got product details: ".concat(rVar.toString()));
                                        arrayList.add(rVar);
                                    } catch (JSONException e11) {
                                        zzb.zzl("BillingClient", "Got a JSON exception trying to decode ProductDetails. \n Exception: ", e11);
                                        strZzg = "Error trying to decode SkuDetails.";
                                        this.f16336f.a(m0.a(47, 7, p0.a(6, "Error trying to decode SkuDetails.")));
                                    }
                                }
                                i12 = i13;
                                zzafVarB = zzafVar;
                            }
                        } else {
                            iZzb = zzb.zzb(bundleZzl, "BillingClient");
                            strZzg = zzb.zzg(bundleZzl, "BillingClient");
                            if (iZzb != 0) {
                                zzb.zzk("BillingClient", "getSkuDetails() failed for queryProductDetailsAsync. Response code: " + iZzb);
                                this.f16336f.a(m0.a(23, 7, p0.a(iZzb, strZzg)));
                                break;
                            }
                            zzb.zzk("BillingClient", "getSkuDetails() returned a bundle with neither an error nor a product detail list for queryProductDetailsAsync.");
                            this.f16336f.a(m0.a(45, 7, p0.a(6, strZzg)));
                        }
                        iZzb = 6;
                        break;
                    }
                    zzb.zzk("BillingClient", "queryProductDetailsAsync got empty product details response.");
                    this.f16336f.a(m0.a(44, 7, p0.B));
                    iZzb = 4;
                    break;
                } catch (Exception e12) {
                    e = e12;
                    zzb.zzl("BillingClient", "queryProductDetailsAsync got a remote exception (try to reconnect).", e);
                    this.f16336f.a(m0.a(43, i11, p0.f16396j));
                    strZzg = "An internal error occurred.";
                }
            } catch (Exception e13) {
                e = e13;
                i11 = 7;
            }
        }
        sVar.a(p0.a(iZzb, strZzg), arrayList);
        return null;
    }

    @Override // com.android.billingclient.api.h
    public final boolean a() {
        return (this.f16331a != 2 || this.f16337g == null || this.f16338h == null) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:152:0x03d5  */
    /* JADX WARN: Code duplicated, block: B:155:0x03e0  */
    /* JADX WARN: Code duplicated, block: B:156:0x03e8  */
    /* JADX WARN: Code duplicated, block: B:158:0x03f6  */
    /* JADX WARN: Code duplicated, block: B:170:0x0428  */
    /* JADX WARN: Code duplicated, block: B:172:0x042c A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:174:0x0433  */
    /* JADX WARN: Code duplicated, block: B:176:0x0437  */
    /* JADX WARN: Code duplicated, block: B:177:0x043a  */
    @Override // com.android.billingclient.api.h
    public final n b(Activity activity, final m mVar) {
        final String strB;
        final String strC;
        String str;
        Future futureK;
        int i11;
        boolean z11;
        String str2;
        SkuDetails skuDetails;
        m.b bVar;
        String str3;
        String str4;
        String str5;
        boolean z12;
        Intent intent;
        String str6;
        final int i12;
        final i iVar = this;
        if (iVar.f16334d == null || iVar.f16334d.d() == null) {
            n0 n0Var = iVar.f16336f;
            n nVar = p0.E;
            n0Var.a(m0.a(12, 2, nVar));
            return nVar;
        }
        if (!a()) {
            n0 n0Var2 = iVar.f16336f;
            n nVar2 = p0.f16399m;
            n0Var2.a(m0.a(2, 2, nVar2));
            iVar.G(nVar2);
            return nVar2;
        }
        ArrayList<SkuDetails> arrayListH = mVar.h();
        List listI = mVar.i();
        SkuDetails skuDetails2 = (SkuDetails) com.google.android.gms.internal.play_billing.zzak.zza(arrayListH, null);
        m.b bVar2 = (m.b) com.google.android.gms.internal.play_billing.zzak.zza(listI, null);
        if (skuDetails2 != null) {
            strB = skuDetails2.a();
            strC = skuDetails2.b();
        } else {
            strB = bVar2.b().b();
            strC = bVar2.b().c();
        }
        if (strC.equals("subs") && !iVar.f16339i) {
            zzb.zzk("BillingClient", "Current client doesn't support subscriptions.");
            n0 n0Var3 = iVar.f16336f;
            n nVar3 = p0.f16401o;
            n0Var3.a(m0.a(9, 2, nVar3));
            iVar.G(nVar3);
            return nVar3;
        }
        if (mVar.r() && !iVar.f16342l) {
            zzb.zzk("BillingClient", "Current client doesn't support extra params for buy intent.");
            n0 n0Var4 = iVar.f16336f;
            n nVar4 = p0.f16394h;
            n0Var4.a(m0.a(18, 2, nVar4));
            iVar.G(nVar4);
            return nVar4;
        }
        if (arrayListH.size() > 1 && !iVar.f16349s) {
            zzb.zzk("BillingClient", "Current client doesn't support multi-item purchases.");
            n0 n0Var5 = iVar.f16336f;
            n nVar5 = p0.f16406t;
            n0Var5.a(m0.a(19, 2, nVar5));
            iVar.G(nVar5);
            return nVar5;
        }
        if (!listI.isEmpty() && !iVar.f16350t) {
            zzb.zzk("BillingClient", "Current client doesn't support purchases with ProductDetails.");
            n0 n0Var6 = iVar.f16336f;
            n nVar6 = p0.f16408v;
            n0Var6.a(m0.a(20, 2, nVar6));
            iVar.G(nVar6);
            return nVar6;
        }
        if (iVar.f16342l) {
            boolean z13 = iVar.f16344n;
            boolean z14 = iVar.f16356z;
            String str7 = iVar.f16332b;
            final Bundle bundle = new Bundle();
            bundle.putString("playBillingLibraryVersion", str7);
            if (mVar.c() != 0) {
                bundle.putInt("prorationMode", mVar.c());
            } else if (mVar.b() != 0) {
                bundle.putInt("prorationMode", mVar.b());
            }
            if (!TextUtils.isEmpty(mVar.d())) {
                bundle.putString("accountId", mVar.d());
            }
            if (!TextUtils.isEmpty(mVar.e())) {
                bundle.putString("obfuscatedProfileId", mVar.e());
            }
            if (mVar.q()) {
                bundle.putBoolean("isOfferPersonalizedByDeveloper", true);
            }
            if (!TextUtils.isEmpty(null)) {
                bundle.putStringArrayList("skusToReplace", new ArrayList<>(Arrays.asList(null)));
            }
            if (!TextUtils.isEmpty(mVar.f())) {
                bundle.putString("oldSkuPurchaseToken", mVar.f());
            }
            String str8 = null;
            if (!TextUtils.isEmpty(null)) {
                bundle.putString("oldSkuPurchaseId", null);
            }
            if (!TextUtils.isEmpty(mVar.g())) {
                bundle.putString("originalExternalTransactionId", mVar.g());
                str8 = null;
            }
            if (!TextUtils.isEmpty(str8)) {
                bundle.putString("paymentsPurchaseParams", str8);
            }
            if (z13) {
                z11 = true;
                bundle.putBoolean("enablePendingPurchases", true);
            } else {
                z11 = true;
            }
            if (z14) {
                bundle.putBoolean("enableAlternativeBilling", z11);
            }
            final String str9 = strC;
            if (arrayListH.isEmpty()) {
                str2 = "proxyPackageVersion";
                skuDetails = skuDetails2;
                bVar = bVar2;
                str3 = strB;
                str4 = "BillingClient";
                ArrayList<String> arrayList = new ArrayList<>(listI.size() - 1);
                ArrayList<String> arrayList2 = new ArrayList<>(listI.size() - 1);
                ArrayList<String> arrayList3 = new ArrayList<>();
                ArrayList<String> arrayList4 = new ArrayList<>();
                ArrayList<String> arrayList5 = new ArrayList<>();
                for (int i13 = 0; i13 < listI.size(); i13++) {
                    m.b bVar3 = (m.b) listI.get(i13);
                    r rVarB = bVar3.b();
                    if (!rVarB.f().isEmpty()) {
                        arrayList3.add(rVarB.f());
                    }
                    arrayList4.add(bVar3.c());
                    if (!TextUtils.isEmpty(rVarB.g())) {
                        arrayList5.add(rVarB.g());
                    }
                    if (i13 > 0) {
                        arrayList.add(((m.b) listI.get(i13)).b().b());
                        arrayList2.add(((m.b) listI.get(i13)).b().c());
                    }
                }
                bundle.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList4);
                if (!arrayList3.isEmpty()) {
                    bundle.putStringArrayList("skuDetailsTokens", arrayList3);
                }
                if (!arrayList5.isEmpty()) {
                    bundle.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList5);
                }
                if (!arrayList.isEmpty()) {
                    bundle.putStringArrayList("additionalSkus", arrayList);
                    bundle.putStringArrayList("additionalSkuTypes", arrayList2);
                }
            } else {
                ArrayList<String> arrayList6 = new ArrayList<>();
                ArrayList<String> arrayList7 = new ArrayList<>();
                str3 = strB;
                ArrayList<String> arrayList8 = new ArrayList<>();
                str2 = "proxyPackageVersion";
                ArrayList<Integer> arrayList9 = new ArrayList<>();
                str4 = "BillingClient";
                ArrayList<String> arrayList10 = new ArrayList<>();
                boolean z15 = false;
                boolean z16 = false;
                boolean z17 = false;
                boolean z18 = false;
                for (SkuDetails skuDetails3 : arrayListH) {
                    if (!skuDetails3.h().isEmpty()) {
                        arrayList6.add(skuDetails3.h());
                    }
                    String strE = skuDetails3.e();
                    SkuDetails skuDetails4 = skuDetails2;
                    String strD = skuDetails3.d();
                    int iC = skuDetails3.c();
                    String strG = skuDetails3.g();
                    arrayList7.add(strE);
                    z15 |= !TextUtils.isEmpty(strE);
                    arrayList8.add(strD);
                    z16 |= !TextUtils.isEmpty(strD);
                    arrayList9.add(Integer.valueOf(iC));
                    z17 |= iC != 0;
                    z18 |= !TextUtils.isEmpty(strG);
                    arrayList10.add(strG);
                    bVar2 = bVar2;
                    skuDetails2 = skuDetails4;
                }
                skuDetails = skuDetails2;
                bVar = bVar2;
                if (!arrayList6.isEmpty()) {
                    bundle.putStringArrayList("skuDetailsTokens", arrayList6);
                }
                if (z15) {
                    bundle.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList7);
                }
                if (z16) {
                    bundle.putStringArrayList("SKU_OFFER_ID_LIST", arrayList8);
                }
                if (z17) {
                    bundle.putIntegerArrayList("SKU_OFFER_TYPE_LIST", arrayList9);
                }
                if (z18) {
                    bundle.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList10);
                }
                if (arrayListH.size() > 1) {
                    ArrayList<String> arrayList11 = new ArrayList<>(arrayListH.size() - 1);
                    ArrayList<String> arrayList12 = new ArrayList<>(arrayListH.size() - 1);
                    for (int i14 = 1; i14 < arrayListH.size(); i14++) {
                        arrayList11.add(((SkuDetails) arrayListH.get(i14)).a());
                        arrayList12.add(((SkuDetails) arrayListH.get(i14)).b());
                    }
                    bundle.putStringArrayList("additionalSkus", arrayList11);
                    bundle.putStringArrayList("additionalSkuTypes", arrayList12);
                }
            }
            iVar = this;
            if (bundle.containsKey("SKU_OFFER_ID_TOKEN_LIST") && !iVar.f16347q) {
                n0 n0Var7 = iVar.f16336f;
                n nVar7 = p0.f16407u;
                n0Var7.a(m0.a(21, 2, nVar7));
                iVar.G(nVar7);
                return nVar7;
            }
            if (skuDetails == null || TextUtils.isEmpty(skuDetails.f())) {
                if (bVar == null || TextUtils.isEmpty(bVar.b().e())) {
                    str5 = null;
                    z12 = false;
                } else {
                    bundle.putString("skuPackageName", bVar.b().e());
                }
                if (!TextUtils.isEmpty(str5)) {
                    bundle.putString("accountName", str5);
                }
                intent = activity.getIntent();
                if (intent == null) {
                    str = str4;
                    zzb.zzk(str, "Activity's intent is null.");
                } else {
                    str = str4;
                    if (!TextUtils.isEmpty(intent.getStringExtra("PROXY_PACKAGE"))) {
                        String stringExtra = intent.getStringExtra("PROXY_PACKAGE");
                        bundle.putString("proxyPackage", stringExtra);
                        try {
                            str6 = str2;
                            try {
                                bundle.putString(str6, iVar.f16335e.getPackageManager().getPackageInfo(stringExtra, 0).versionName);
                            } catch (PackageManager.NameNotFoundException unused) {
                                bundle.putString(str6, "package not found");
                            }
                        } catch (PackageManager.NameNotFoundException unused2) {
                            str6 = str2;
                        }
                    }
                }
                if (!iVar.f16350t && !listI.isEmpty()) {
                    i12 = 17;
                } else if (!iVar.f16348r && z12) {
                    i12 = 15;
                } else if (iVar.f16344n) {
                    i12 = 9;
                } else {
                    i12 = 6;
                }
                final String str10 = str3;
                futureK = K(new Callable() { // from class: com.android.billingclient.api.z
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return this.f16475a.N(i12, str10, str9, mVar, bundle);
                    }
                }, 5000L, null, iVar.f16333c);
                i11 = 78;
            } else {
                bundle.putString("skuPackageName", skuDetails.f());
            }
            str5 = null;
            z12 = true;
            if (!TextUtils.isEmpty(str5)) {
                bundle.putString("accountName", str5);
            }
            intent = activity.getIntent();
            if (intent == null) {
                str = str4;
                zzb.zzk(str, "Activity's intent is null.");
            } else {
                str = str4;
                if (!TextUtils.isEmpty(intent.getStringExtra("PROXY_PACKAGE"))) {
                    String stringExtra2 = intent.getStringExtra("PROXY_PACKAGE");
                    bundle.putString("proxyPackage", stringExtra2);
                    str6 = str2;
                    bundle.putString(str6, iVar.f16335e.getPackageManager().getPackageInfo(stringExtra2, 0).versionName);
                }
            }
            if (!iVar.f16350t) {
                if (!iVar.f16348r) {
                    if (iVar.f16344n) {
                        i12 = 9;
                    } else {
                        i12 = 6;
                    }
                } else if (iVar.f16344n) {
                    i12 = 9;
                } else {
                    i12 = 6;
                }
            } else if (!iVar.f16348r) {
                if (iVar.f16344n) {
                    i12 = 9;
                } else {
                    i12 = 6;
                }
            } else if (iVar.f16344n) {
                i12 = 9;
            } else {
                i12 = 6;
            }
            final String str11 = str3;
            futureK = K(new Callable() { // from class: com.android.billingclient.api.z
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f16475a.N(i12, str11, str9, mVar, bundle);
                }
            }, 5000L, null, iVar.f16333c);
            i11 = 78;
        } else {
            str = "BillingClient";
            futureK = K(new Callable() { // from class: com.android.billingclient.api.a0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f16309a.O(strB, strC);
                }
            }, 5000L, null, iVar.f16333c);
            i11 = 80;
        }
        try {
            if (futureK == null) {
                n0 n0Var8 = iVar.f16336f;
                n nVar8 = p0.f16399m;
                n0Var8.a(m0.a(25, 2, nVar8));
                iVar.G(nVar8);
                return nVar8;
            }
            Bundle bundle2 = (Bundle) futureK.get(5000L, TimeUnit.MILLISECONDS);
            int iZzb = zzb.zzb(bundle2, str);
            String strZzg = zzb.zzg(bundle2, str);
            if (iZzb == 0) {
                Intent intent2 = new Intent(activity, (Class<?>) ProxyBillingActivity.class);
                intent2.putExtra("BUY_INTENT", (PendingIntent) bundle2.getParcelable("BUY_INTENT"));
                activity.startActivity(intent2);
                return p0.f16398l;
            }
            zzb.zzk(str, "Unable to buy item, Error response code: " + iZzb);
            n nVarA = p0.a(iZzb, strZzg);
            n0 n0Var9 = iVar.f16336f;
            if (bundle2 != null) {
                i11 = 23;
            }
            n0Var9.a(m0.a(i11, 2, nVarA));
            iVar.G(nVarA);
            return nVarA;
        } catch (CancellationException e11) {
            e = e11;
            zzb.zzl(str, "Time out while launching billing flow. Try to reconnect", e);
            n0 n0Var10 = iVar.f16336f;
            n nVar9 = p0.f16400n;
            n0Var10.a(m0.a(4, 2, nVar9));
            iVar.G(nVar9);
            return nVar9;
        } catch (TimeoutException e12) {
            e = e12;
            zzb.zzl(str, "Time out while launching billing flow. Try to reconnect", e);
            n0 n0Var11 = iVar.f16336f;
            n nVar10 = p0.f16400n;
            n0Var11.a(m0.a(4, 2, nVar10));
            iVar.G(nVar10);
            return nVar10;
        } catch (Exception e13) {
            zzb.zzl(str, "Exception while launching billing flow. Try to reconnect", e13);
            n0 n0Var12 = iVar.f16336f;
            n nVar11 = p0.f16399m;
            n0Var12.a(m0.a(5, 2, nVar11));
            iVar.G(nVar11);
            return nVar11;
        }
    }

    @Override // com.android.billingclient.api.h
    public final void d(final w wVar, final s sVar) {
        if (!a()) {
            n0 n0Var = this.f16336f;
            n nVar = p0.f16399m;
            n0Var.a(m0.a(2, 7, nVar));
            sVar.a(nVar, new ArrayList());
            return;
        }
        if (this.f16350t) {
            if (K(new Callable() { // from class: com.android.billingclient.api.s1
                @Override // java.util.concurrent.Callable
                public final Object call() throws Exception {
                    this.f16463a.U(wVar, sVar);
                    return null;
                }
            }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzz
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.z(sVar);
                }
            }, F()) == null) {
                n nVarI = I();
                this.f16336f.a(m0.a(25, 7, nVarI));
                sVar.a(nVarI, new ArrayList());
                return;
            }
            return;
        }
        zzb.zzk("BillingClient", "Querying product details is not supported.");
        n0 n0Var2 = this.f16336f;
        n nVar2 = p0.f16408v;
        n0Var2.a(m0.a(20, 7, nVar2));
        sVar.a(nVar2, new ArrayList());
    }

    @Override // com.android.billingclient.api.h
    public final void e(x xVar, u uVar) {
        L(xVar.b(), uVar);
    }

    @Override // com.android.billingclient.api.h
    public final void f(j jVar) {
        if (a()) {
            zzb.zzj("BillingClient", "Service connection is valid. No need to re-initialize.");
            this.f16336f.c(m0.b(6));
            jVar.a(p0.f16398l);
            return;
        }
        int i11 = 1;
        if (this.f16331a == 1) {
            zzb.zzk("BillingClient", "Client is already in the process of connecting to billing service.");
            n0 n0Var = this.f16336f;
            n nVar = p0.f16390d;
            n0Var.a(m0.a(37, 6, nVar));
            jVar.a(nVar);
            return;
        }
        if (this.f16331a == 3) {
            zzb.zzk("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
            n0 n0Var2 = this.f16336f;
            n nVar2 = p0.f16399m;
            n0Var2.a(m0.a(38, 6, nVar2));
            jVar.a(nVar2);
            return;
        }
        this.f16331a = 1;
        zzb.zzj("BillingClient", "Starting in-app billing setup.");
        this.f16338h = new f0(this, jVar, null);
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        List<ResolveInfo> listQueryIntentServices = this.f16335e.getPackageManager().queryIntentServices(intent, 0);
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
            i11 = 41;
        } else {
            ServiceInfo serviceInfo = listQueryIntentServices.get(0).serviceInfo;
            if (serviceInfo != null) {
                String str = serviceInfo.packageName;
                String str2 = serviceInfo.name;
                if (!"com.android.vending".equals(str) || str2 == null) {
                    zzb.zzk("BillingClient", "The device doesn't have valid Play Store.");
                    i11 = 40;
                } else {
                    ComponentName componentName = new ComponentName(str, str2);
                    Intent intent2 = new Intent(intent);
                    intent2.setComponent(componentName);
                    intent2.putExtra("playBillingLibraryVersion", this.f16332b);
                    if (this.f16335e.bindService(intent2, this.f16338h, 1)) {
                        zzb.zzj("BillingClient", "Service was bonded successfully.");
                        return;
                    } else {
                        zzb.zzk("BillingClient", "Connection to Billing service is blocked.");
                        i11 = 39;
                    }
                }
            }
        }
        this.f16331a = 0;
        zzb.zzj("BillingClient", "Billing service unavailable on device.");
        n0 n0Var3 = this.f16336f;
        n nVar3 = p0.f16389c;
        n0Var3.a(m0.a(i11, 6, nVar3));
        jVar.a(nVar3);
    }

    public final void g(Context context, v vVar, x0 x0Var, @Nullable c cVar, String str, @Nullable n0 n0Var) {
        this.f16335e = context.getApplicationContext();
        zzin zzinVarZzv = zzio.zzv();
        zzinVarZzv.zzj(str);
        zzinVarZzv.zzi(this.f16335e.getPackageName());
        if (n0Var != null) {
            this.f16336f = n0Var;
        } else {
            this.f16336f = new q0(this.f16335e, (zzio) zzinVarZzv.zzc());
        }
        if (vVar == null) {
            zzb.zzk("BillingClient", "Billing client should have a valid listener but the provided is null.");
        }
        this.f16334d = new q1(this.f16335e, vVar, cVar, this.f16336f);
        this.f16355y = x0Var;
        this.f16356z = cVar != null;
        this.f16335e.getPackageName();
    }

    public final /* synthetic */ void t(b bVar) {
        n0 n0Var = this.f16336f;
        n nVar = p0.f16400n;
        n0Var.a(m0.a(24, 3, nVar));
        bVar.a(nVar);
    }

    public final /* synthetic */ void u(n nVar) {
        if (this.f16334d.d() != null) {
            this.f16334d.d().a(nVar, null);
        } else {
            this.f16334d.c();
            zzb.zzk("BillingClient", "No valid listener is set in BroadcastManager");
        }
    }

    public final /* synthetic */ void v(p pVar, o oVar) {
        this.f16336f.a(m0.a(24, 4, p0.f16400n));
        throw null;
    }

    public final /* synthetic */ void w(g gVar) {
        n0 n0Var = this.f16336f;
        n nVar = p0.f16400n;
        n0Var.a(m0.a(24, 15, nVar));
        gVar.a(nVar, null);
    }

    public final /* synthetic */ void x(l lVar) {
        n0 n0Var = this.f16336f;
        n nVar = p0.f16400n;
        n0Var.a(m0.a(24, 13, nVar));
        lVar.a(nVar, null);
    }

    public final /* synthetic */ void y(d dVar) {
        n0 n0Var = this.f16336f;
        n nVar = p0.f16400n;
        n0Var.a(m0.a(24, 14, nVar));
        dVar.a(nVar);
    }

    public final /* synthetic */ void z(s sVar) {
        n0 n0Var = this.f16336f;
        n nVar = p0.f16400n;
        n0Var.a(m0.a(24, 7, nVar));
        sVar.a(nVar, new ArrayList());
    }
}
