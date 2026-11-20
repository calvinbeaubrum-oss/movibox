package com.transsion.payment.lib.strategy;

import android.app.Activity;
import android.app.Application;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.c0;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.h;
import com.android.billingclient.api.m;
import com.android.billingclient.api.n;
import com.android.billingclient.api.r;
import com.android.billingclient.api.s;
import com.android.billingclient.api.u;
import com.android.billingclient.api.v;
import com.android.billingclient.api.w;
import com.android.billingclient.api.x;
import com.blankj.utilcode.util.Utils;
import com.tn.lib.util.networkinfo.NetWorkCallback;
import com.tn.lib.util.networkinfo.g;
import com.transsion.payment.lib.PayUtils;
import com.transsion.payment.lib.PaymentService;
import com.transsion.payment.lib.bean.CreateOrderReq;
import com.transsion.payment.lib.bean.SkuBean;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.w0;
import retrofit2.HttpException;
import retrofit2.b0;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class GoogleStrategy implements d, g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0<List<SkuBean>> f54054a = new c0<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashSet<Integer> f54055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashSet<Integer> f54056c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f54057d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f54058f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f54059g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f54060h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f54061i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public k0 f54062j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.transsion.payment.lib.b f54063k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final v f54064l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final h f54065m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f54066n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f54067o;

    public GoogleStrategy() {
        HashSet<Integer> hashSet = new HashSet<>();
        this.f54055b = hashSet;
        HashSet<Integer> hashSet2 = new HashSet<>();
        this.f54056c = hashSet2;
        NetWorkCallback.f49460g.a().C(this);
        hashSet.add(3);
        hashSet.add(5);
        hashSet.add(-2);
        hashSet.add(7);
        hashSet2.add(4);
        hashSet2.add(-3);
        hashSet2.add(6);
        hashSet2.add(-1);
        hashSet2.add(2);
        hashSet2.add(12);
        this.f54057d = 3;
        this.f54059g = 2000;
        this.f54062j = l0.a(w0.b());
        v vVar = new v() { // from class: com.transsion.payment.lib.strategy.a
            @Override // com.android.billingclient.api.v
            public final void a(n nVar, List list) {
                GoogleStrategy.B(this.f54075a, nVar, list);
            }
        };
        this.f54064l = vVar;
        h hVarA = h.c(Utils.a()).c(vVar).b().a();
        Intrinsics.f(hVarA, "newBuilder(Utils.getApp(…chases()\n        .build()");
        this.f54065m = hVarA;
        this.f54066n = LazyKt__LazyJVMKt.b(new Function0<PaymentService>() { // from class: com.transsion.payment.lib.strategy.GoogleStrategy$paymentService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PaymentService invoke() {
                return new PaymentService();
            }
        });
    }

    public static final void A(GoogleStrategy this$0, n billingResult, List purchaseList) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(billingResult, "billingResult");
        Intrinsics.g(purchaseList, "purchaseList");
        j.d(this$0.f54062j, null, null, new GoogleStrategy$orderCheck$1$1(purchaseList, this$0, null), 3, null);
    }

    public static final void B(GoogleStrategy this$0, n billingResult, List list) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(billingResult, "billingResult");
        com.transsion.payment.lib.d dVar = com.transsion.payment.lib.d.f54044a;
        dVar.a("PurchasesUpdatedListener responseCode:" + billingResult.b() + " " + (list != null ? Integer.valueOf(list.size()) : null));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("purchases: ");
        sb2.append(list);
        dVar.a(sb2.toString());
        if (billingResult.b() == 0 && list != null) {
            this$0.f54058f = 0;
            com.transsion.payment.lib.b bVar = this$0.f54063k;
            if (bVar != null) {
                bVar.b(true);
            }
            j.d(l0.a(w0.b()), null, null, new GoogleStrategy$purchasesUpdatedListener$1$1(list, this$0, null), 3, null);
            return;
        }
        if (billingResult.b() != 1) {
            com.transsion.payment.lib.b bVar2 = this$0.f54063k;
            if (bVar2 != null) {
                com.transsion.payment.lib.b.a.a(bVar2, Integer.valueOf(billingResult.b()), billingResult.a(), false, null, 8, null);
            }
            this$0.f54063k = null;
            return;
        }
        dVar.a("PurchasesUpdatedListener USER_CANCELED");
        com.transsion.payment.lib.b bVar3 = this$0.f54063k;
        if (bVar3 != null) {
            com.transsion.payment.lib.b.a.a(bVar3, 1, "User Cancelled", false, null, 8, null);
        }
        this$0.f54063k = null;
    }

    public static final void D(boolean z11, String tradingOrderId, GoogleStrategy this$0, com.transsion.payment.lib.b payCallback, Activity activity, n billingResult, List productDetailsList) {
        String strA;
        r.d dVar;
        Intrinsics.g(tradingOrderId, "$tradingOrderId");
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(payCallback, "$payCallback");
        Intrinsics.g(activity, "$activity");
        Intrinsics.g(billingResult, "billingResult");
        Intrinsics.g(productDetailsList, "productDetailsList");
        com.transsion.payment.lib.d dVar2 = com.transsion.payment.lib.d.f54044a;
        dVar2.a("queryProductDetailsAsync resultCode: " + billingResult.b() + " result size: " + productDetailsList.size());
        if (productDetailsList.size() <= 0) {
            payCallback.a(Integer.valueOf(billingResult.b()), billingResult.a(), false, tradingOrderId);
            dVar2.b("queryProductDetailsAsync failed list: " + productDetailsList + ", code: " + billingResult.b() + ", message: " + billingResult.a());
            return;
        }
        r rVar = (r) productDetailsList.get(0);
        if (rVar == null) {
            dVar2.b("billingFlowParams productDetail null");
            payCallback.a(Integer.valueOf(billingResult.b()), billingResult.a(), false, tradingOrderId);
            return;
        }
        ArrayList arrayList = new ArrayList();
        dVar2.a("productDetail is " + rVar);
        m.b.a aVarC = m.b.a().c(rVar);
        Intrinsics.f(aVarC, "newBuilder().setProductDetails(productDetail)");
        if (z11) {
            List<r.d> listD = rVar.d();
            if (listD == null || (dVar = (r.d) CollectionsKt___CollectionsKt.e0(listD)) == null || (strA = dVar.a()) == null) {
                strA = "";
            }
            aVarC.b(strA);
        }
        m.b bVarA = aVarC.a();
        Intrinsics.f(bVarA, "productDetailParam.build()");
        arrayList.add(bVarA);
        m mVarA = m.a().c(arrayList).b(tradingOrderId).a();
        Intrinsics.f(mVarA, "newBuilder().setProductD…d(tradingOrderId).build()");
        this$0.f54063k = payCallback;
        dVar2.a("Launch billing flow");
        this$0.f54065m.b(activity, mVarA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PaymentService w() {
        return (PaymentService) this.f54066n.getValue();
    }

    public final void C(final Activity activity, String str, final String str2, final boolean z11, final com.transsion.payment.lib.b bVar) {
        w.b bVarA = w.b.a().b(str).c(z11 ? "subs" : "inapp").a();
        Intrinsics.f(bVarA, "newBuilder().setProductI…Type(productType).build()");
        w wVarA = w.a().b(kotlin.collections.g.q(bVarA)).a();
        Intrinsics.f(wVarA, "newBuilder().setProductL…eListOf(product)).build()");
        this.f54065m.d(wVarA, new s() { // from class: com.transsion.payment.lib.strategy.b
            @Override // com.android.billingclient.api.s
            public final void a(n nVar, List list) {
                GoogleStrategy.D(z11, str2, this, bVar, activity, nVar, list);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0081 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x007f -> B:17:0x0050). Please report as a decompilation issue!!! */
    public final Object E(long j11, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super Unit> continuation) throws Throwable {
        GoogleStrategy$retryCheck$1 googleStrategy$retryCheck$1;
        GoogleStrategy googleStrategy;
        if (continuation instanceof GoogleStrategy$retryCheck$1) {
            googleStrategy$retryCheck$1 = (GoogleStrategy$retryCheck$1) continuation;
            int i11 = googleStrategy$retryCheck$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                googleStrategy$retryCheck$1.label = i11 - Integer.MIN_VALUE;
            } else {
                googleStrategy$retryCheck$1 = new GoogleStrategy$retryCheck$1(this, continuation);
            }
        } else {
            googleStrategy$retryCheck$1 = new GoogleStrategy$retryCheck$1(this, continuation);
        }
        Object obj = googleStrategy$retryCheck$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = googleStrategy$retryCheck$1.label;
        if (i12 == 0) {
            ResultKt.b(obj);
            googleStrategy = this;
        } else if (i12 == 1) {
            j11 = googleStrategy$retryCheck$1.J$0;
            function1 = (Function1) googleStrategy$retryCheck$1.L$1;
            googleStrategy = (GoogleStrategy) googleStrategy$retryCheck$1.L$0;
            ResultKt.b(obj);
            googleStrategy$retryCheck$1.L$0 = googleStrategy;
            googleStrategy$retryCheck$1.L$1 = function1;
            googleStrategy$retryCheck$1.J$0 = j11;
            googleStrategy$retryCheck$1.label = 2;
            if (function1.invoke(googleStrategy$retryCheck$1) == objE) {
                return objE;
            }
        } else {
            if (i12 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j11 = googleStrategy$retryCheck$1.J$0;
            function1 = (Function1) googleStrategy$retryCheck$1.L$1;
            googleStrategy = (GoogleStrategy) googleStrategy$retryCheck$1.L$0;
            ResultKt.b(obj);
        }
        int i13 = googleStrategy.f54058f;
        googleStrategy.f54058f = i13 + 1;
        if (i13 < googleStrategy.f54057d || googleStrategy.f54061i) {
            return Unit.f68710a;
        }
        if (j11 > 0) {
            googleStrategy$retryCheck$1.L$0 = googleStrategy;
            googleStrategy$retryCheck$1.L$1 = function1;
            googleStrategy$retryCheck$1.J$0 = j11;
            googleStrategy$retryCheck$1.label = 1;
            if (r0.a(j11, googleStrategy$retryCheck$1) == objE) {
                return objE;
            }
        }
        googleStrategy$retryCheck$1.L$0 = googleStrategy;
        googleStrategy$retryCheck$1.L$1 = function1;
        googleStrategy$retryCheck$1.J$0 = j11;
        googleStrategy$retryCheck$1.label = 2;
        if (function1.invoke(googleStrategy$retryCheck$1) == objE) {
            return objE;
        }
        int i14 = googleStrategy.f54058f;
        googleStrategy.f54058f = i14 + 1;
        if (i14 < googleStrategy.f54057d) {
        }
        return Unit.f68710a;
    }

    public final void F() {
        h hVar = this.f54065m;
        if (hVar == null || hVar.a()) {
            return;
        }
        d.a.b(this, null, null, new Function0<Unit>() { // from class: com.transsion.payment.lib.strategy.GoogleStrategy$retryConnectToGP$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                List list;
                if (this.this$0.f54054a.f() == 0 || ((list = (List) this.this$0.f54054a.f()) != null && list.isEmpty())) {
                    this.this$0.t();
                }
            }
        }, 3, null);
    }

    @Override // com.transsion.payment.lib.strategy.d
    public void a(final AppCompatActivity activity, final CreateOrderReq createOrderReq, final boolean z11, final com.transsion.payment.lib.b payCallback) {
        Object objM163constructorimpl;
        Intrinsics.g(activity, "activity");
        Intrinsics.g(createOrderReq, "createOrderReq");
        Intrinsics.g(payCallback, "payCallback");
        com.transsion.payment.lib.d.f54044a.a(u() + " --> requestPay() --> 请求接口创建订单....");
        payCallback.b(true);
        try {
            Result.Companion companion = Result.Companion;
            if (!this.f54065m.a()) {
                b(Boolean.FALSE, payCallback, new Function0<Unit>() { // from class: com.transsion.payment.lib.strategy.GoogleStrategy$requestPay$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        this.this$0.a(activity, createOrderReq, z11, payCallback);
                    }
                });
                return;
            }
            objM163constructorimpl = Result.m163constructorimpl(j.d(this.f54062j, null, null, new GoogleStrategy$requestPay$1$2(this, createOrderReq, activity, z11, payCallback, null), 3, null));
            Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
            if (thM166exceptionOrNullimpl == null) {
                return;
            }
            if (!(thM166exceptionOrNullimpl instanceof HttpException)) {
                com.transsion.payment.lib.b.a.a(payCallback, -10, thM166exceptionOrNullimpl.getMessage(), false, null, 8, null);
                return;
            }
            HttpException httpException = (HttpException) thM166exceptionOrNullimpl;
            b0<?> b0VarResponse = httpException.response();
            Integer numValueOf = b0VarResponse != null ? Integer.valueOf(b0VarResponse.b()) : null;
            b0<?> b0VarResponse2 = httpException.response();
            com.transsion.payment.lib.b.a.a(payCallback, numValueOf, b0VarResponse2 != null ? b0VarResponse2.f() : null, false, null, 8, null);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    @Override // com.transsion.payment.lib.strategy.d
    public void b(final Boolean bool, final com.transsion.payment.lib.b bVar, final Function0<Unit> function0) {
        if (this.f54060h) {
            return;
        }
        this.f54060h = true;
        com.transsion.payment.lib.d.f54044a.a("startBillingConnection start");
        this.f54067o = SystemClock.elapsedRealtime();
        this.f54065m.f(new com.android.billingclient.api.j() { // from class: com.transsion.payment.lib.strategy.GoogleStrategy$startConnectPlatform$1
            @Override // com.android.billingclient.api.j
            public void a(n billingResult) {
                Intrinsics.g(billingResult, "billingResult");
                this.f54068a.f54060h = false;
                this.f54068a.f54061i = true;
                this.f54068a.f54058f = 0;
                if (billingResult.b() == 0) {
                    com.transsion.payment.lib.d.f54044a.a("content Billing response OK");
                    this.f54068a.t();
                    Function0<Unit> function1 = function0;
                    if (function1 != null) {
                        function1.invoke();
                    }
                    this.f54068a.z();
                    return;
                }
                if (!this.f54068a.v().contains(Integer.valueOf(billingResult.b()))) {
                    com.transsion.payment.lib.b bVar2 = bVar;
                    if (bVar2 != null) {
                        com.transsion.payment.lib.b.a.a(bVar2, Integer.valueOf(billingResult.b()), billingResult.a(), false, null, 8, null);
                        return;
                    }
                    return;
                }
                com.transsion.payment.lib.d.f54044a.c("connect error code " + billingResult.b() + " msg " + billingResult.a());
                long jElapsedRealtime = ((long) this.f54068a.f54059g) - (SystemClock.elapsedRealtime() - this.f54068a.x());
                if (!Intrinsics.b(bool, Boolean.TRUE)) {
                    com.transsion.payment.lib.b bVar3 = bVar;
                    if (bVar3 != null) {
                        com.transsion.payment.lib.b.a.a(bVar3, Integer.valueOf(billingResult.b()), billingResult.a(), false, null, 8, null);
                        return;
                    }
                    return;
                }
                if (this.f54068a.f54058f <= this.f54068a.f54057d) {
                    j.d(this.f54068a.f54062j, null, null, new GoogleStrategy$startConnectPlatform$1$onBillingSetupFinished$1(this.f54068a, jElapsedRealtime, function0, null), 3, null);
                    return;
                }
                com.transsion.payment.lib.b bVar4 = bVar;
                if (bVar4 != null) {
                    com.transsion.payment.lib.b.a.a(bVar4, Integer.valueOf(billingResult.b()), billingResult.a(), false, null, 8, null);
                }
            }

            @Override // com.android.billingclient.api.j
            public void b() {
                this.f54068a.f54060h = false;
                this.f54068a.f54061i = false;
                com.transsion.payment.lib.d.f54044a.c("content Service disconnected");
                j.d(this.f54068a.f54062j, null, null, new GoogleStrategy$startConnectPlatform$1$onBillingServiceDisconnected$1(this.f54068a, ((long) this.f54068a.f54059g) - (SystemClock.elapsedRealtime() - this.f54068a.x()), function0, null), 3, null);
            }
        });
    }

    @Override // com.transsion.payment.lib.strategy.d
    public void init(Application application) {
        Intrinsics.g(application, "application");
        NetWorkCallback.f49460g.a().C(this);
    }

    @Override // com.tn.lib.util.networkinfo.g
    public void onConnected() {
        g.a.a(this);
    }

    @Override // com.tn.lib.util.networkinfo.g
    public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics.g(network, "network");
        Intrinsics.g(networkCapabilities, "networkCapabilities");
        F();
    }

    @Override // com.tn.lib.util.networkinfo.g
    public void onDisconnected() {
    }

    public void t() {
        j.d(this.f54062j, null, null, new GoogleStrategy$fetchSkuList$1(this, null), 3, null);
    }

    public String u() {
        return d.a.a(this);
    }

    public final HashSet<Integer> v() {
        return this.f54056c;
    }

    public final long x() {
        return this.f54067o;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0194  */
    /* JADX WARN: Code duplicated, block: B:102:0x0198  */
    /* JADX WARN: Code duplicated, block: B:64:0x0110 A[Catch: all -> 0x0114, TryCatch #0 {all -> 0x0114, blocks: (B:81:0x014b, B:62:0x010c, B:64:0x0110, B:67:0x0116, B:69:0x011a, B:70:0x0121), top: B:107:0x010c }] */
    /* JADX WARN: Code duplicated, block: B:69:0x011a A[Catch: all -> 0x0114, TryCatch #0 {all -> 0x0114, blocks: (B:81:0x014b, B:62:0x010c, B:64:0x0110, B:67:0x0116, B:69:0x011a, B:70:0x0121), top: B:107:0x010c }] */
    /* JADX WARN: Code duplicated, block: B:87:0x0163  */
    /* JADX WARN: Code duplicated, block: B:89:0x0167  */
    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    /* JADX WARN: Code duplicated, block: B:91:0x016b  */
    /* JADX WARN: Code duplicated, block: B:93:0x0174  */
    /* JADX WARN: Code duplicated, block: B:94:0x017d  */
    /* JADX WARN: Code duplicated, block: B:97:0x0184  */
    /* JADX WARN: Code duplicated, block: B:98:0x018a  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r3v14, types: [com.transsion.payment.lib.b] */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21 */
    public final Object y(Purchase purchase, Continuation<? super Unit> continuation) throws Throwable {
        GoogleStrategy$handlePurchase$1 googleStrategy$handlePurchase$1;
        String str;
        GoogleStrategy googleStrategy;
        String strG;
        com.transsion.payment.lib.b bVar;
        com.transsion.payment.lib.b bVar2;
        boolean z11;
        String str2;
        com.android.billingclient.api.a aVarA;
        List<String> listD;
        Object obj;
        com.transsion.payment.lib.b bVar3;
        com.transsion.payment.lib.b bVar4;
        com.transsion.payment.lib.b bVar5;
        Object objM163constructorimpl;
        ?? r11;
        Throwable thM166exceptionOrNullimpl;
        com.transsion.payment.lib.b bVar6;
        com.transsion.payment.lib.b bVar7;
        b0<?> b0VarResponse;
        ?? D;
        b0<?> b0VarResponse2;
        ?? F;
        if (continuation instanceof GoogleStrategy$handlePurchase$1) {
            googleStrategy$handlePurchase$1 = (GoogleStrategy$handlePurchase$1) continuation;
            int i11 = googleStrategy$handlePurchase$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                googleStrategy$handlePurchase$1.label = i11 - Integer.MIN_VALUE;
            } else {
                googleStrategy$handlePurchase$1 = new GoogleStrategy$handlePurchase$1(this, continuation);
            }
        } else {
            googleStrategy$handlePurchase$1 = new GoogleStrategy$handlePurchase$1(this, continuation);
        }
        GoogleStrategy$handlePurchase$1 googleStrategy$handlePurchase$2 = googleStrategy$handlePurchase$1;
        Object obj2 = googleStrategy$handlePurchase$2.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = googleStrategy$handlePurchase$2.label;
        String str3 = "";
        if (i12 == 0) {
            ResultKt.b(obj2);
            try {
                Result.Companion companion = Result.Companion;
                if (purchase != null) {
                    try {
                        strG = purchase.g();
                    } catch (Throwable th2) {
                        th = th2;
                        googleStrategy = this;
                        obj = null;
                        Result.Companion companion2 = Result.Companion;
                        objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th));
                        r11 = obj;
                    }
                } else {
                    strG = null;
                }
                str = (purchase == null || (listD = purchase.d()) == null) ? null : listD.get(0);
                String strA = (purchase == null || (aVarA = purchase.a()) == null) ? null : aVarA.a();
                String strB = purchase != null ? purchase.b() : null;
                try {
                    if (TextUtils.isEmpty(strG) || TextUtils.isEmpty(str) || TextUtils.isEmpty(strA) || purchase == null || purchase.e() != 1) {
                        bVar = null;
                        com.transsion.payment.lib.d.f54044a.b("handlePurchase 失败");
                        com.transsion.payment.lib.b bVar8 = this.f54063k;
                        if (bVar8 != null) {
                            bVar8.a(purchase != null ? Boxing.d(purchase.e()) : null, "", false, strA);
                        }
                        this.f54063k = null;
                    } else {
                        com.transsion.payment.lib.d.f54044a.a("handlePurchase 支付结果 orderId:" + strA + " purchaseToken " + strG + " productId " + str + " gpOrderId " + strB);
                        try {
                            PayUtils payUtils = PayUtils.f54030a;
                            GoogleStrategy$handlePurchase$2$1 googleStrategy$handlePurchase$2$1 = new GoogleStrategy$handlePurchase$2$1(this, str, strG, strA, strB, null);
                            googleStrategy$handlePurchase$2.L$0 = this;
                            googleStrategy$handlePurchase$2.L$1 = strA;
                            googleStrategy$handlePurchase$2.label = 1;
                            bVar2 = null;
                            z11 = false;
                            try {
                                bVar = bVar2;
                                if (PayUtils.b(payUtils, 0L, 0, googleStrategy$handlePurchase$2$1, googleStrategy$handlePurchase$2, 3, null) == objE) {
                                    return objE;
                                }
                            } catch (Exception unused) {
                                str2 = strA;
                                googleStrategy = this;
                                bVar3 = bVar2;
                                bVar4 = googleStrategy.f54063k;
                                if (bVar4 != null) {
                                    bVar4.b(z11);
                                }
                                bVar5 = googleStrategy.f54063k;
                                if (bVar5 != null) {
                                    bVar5.a(Boxing.d(-30), str3, z11, str2);
                                }
                                googleStrategy.f54063k = bVar3;
                                com.transsion.payment.lib.d.f54044a.b("handlePurchase 发货进行中ing");
                                bVar3 = bVar3;
                            }
                        } catch (Exception unused2) {
                            bVar2 = null;
                            z11 = false;
                        }
                    }
                    googleStrategy = this;
                    bVar3 = bVar;
                    objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
                    r11 = bVar3;
                } catch (Throwable th3) {
                    th = th3;
                    googleStrategy = this;
                    obj = str;
                    Result.Companion companion3 = Result.Companion;
                    objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th));
                    r11 = obj;
                }
            } catch (Throwable th4) {
                th = th4;
                str = null;
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str2 = (String) googleStrategy$handlePurchase$2.L$1;
            googleStrategy = (GoogleStrategy) googleStrategy$handlePurchase$2.L$0;
            try {
                ResultKt.b(obj2);
                bVar3 = null;
            } catch (Exception unused3) {
                bVar3 = null;
                str3 = "";
                z11 = false;
                try {
                    bVar4 = googleStrategy.f54063k;
                    if (bVar4 != null) {
                        bVar4.b(z11);
                    }
                    bVar5 = googleStrategy.f54063k;
                    if (bVar5 != null) {
                        bVar5.a(Boxing.d(-30), str3, z11, str2);
                    }
                    googleStrategy.f54063k = bVar3;
                    com.transsion.payment.lib.d.f54044a.b("handlePurchase 发货进行中ing");
                    bVar3 = bVar3;
                } catch (Throwable th5) {
                    th = th5;
                    obj = bVar3;
                    Result.Companion companion4 = Result.Companion;
                    objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th));
                    r11 = obj;
                }
            } catch (Throwable th6) {
                th = th6;
                obj = null;
                Result.Companion companion5 = Result.Companion;
                objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th));
                r11 = obj;
                thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
                if (thM166exceptionOrNullimpl != null) {
                    if (thM166exceptionOrNullimpl instanceof HttpException) {
                        bVar7 = googleStrategy.f54063k;
                        if (bVar7 != null) {
                            HttpException httpException = (HttpException) thM166exceptionOrNullimpl;
                            b0VarResponse = httpException.response();
                            if (b0VarResponse != null) {
                                D = Boxing.d(b0VarResponse.b());
                            } else {
                                D = r11;
                            }
                            b0VarResponse2 = httpException.response();
                            if (b0VarResponse2 != null) {
                                F = b0VarResponse2.f();
                            } else {
                                F = r11;
                            }
                            com.transsion.payment.lib.b.a.a(bVar7, D, F, false, null, 8, null);
                        }
                    } else {
                        bVar6 = googleStrategy.f54063k;
                        if (bVar6 != null) {
                            com.transsion.payment.lib.b.a.a(bVar6, Boxing.d(-30), thM166exceptionOrNullimpl.getMessage(), false, null, 8, null);
                        }
                    }
                    com.transsion.payment.lib.d.f54044a.b("throwable " + thM166exceptionOrNullimpl);
                    googleStrategy.f54063k = r11;
                }
                return Unit.f68710a;
            }
            objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
            r11 = bVar3;
        }
        thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl != null) {
            if (thM166exceptionOrNullimpl instanceof HttpException) {
                bVar7 = googleStrategy.f54063k;
                if (bVar7 != null) {
                    HttpException httpException2 = (HttpException) thM166exceptionOrNullimpl;
                    b0VarResponse = httpException2.response();
                    if (b0VarResponse != null) {
                        D = Boxing.d(b0VarResponse.b());
                    } else {
                        D = r11;
                    }
                    b0VarResponse2 = httpException2.response();
                    if (b0VarResponse2 != null) {
                        F = b0VarResponse2.f();
                    } else {
                        F = r11;
                    }
                    com.transsion.payment.lib.b.a.a(bVar7, D, F, false, null, 8, null);
                }
            } else {
                bVar6 = googleStrategy.f54063k;
                if (bVar6 != null) {
                    com.transsion.payment.lib.b.a.a(bVar6, Boxing.d(-30), thM166exceptionOrNullimpl.getMessage(), false, null, 8, null);
                }
            }
            com.transsion.payment.lib.d.f54044a.b("throwable " + thM166exceptionOrNullimpl);
            googleStrategy.f54063k = r11;
        }
        return Unit.f68710a;
    }

    public void z() {
        x.a aVarB = x.a().b("inapp");
        Intrinsics.f(aVarB, "newBuilder().setProductT…Client.ProductType.INAPP)");
        this.f54065m.e(aVarB.a(), new u() { // from class: com.transsion.payment.lib.strategy.c
            @Override // com.android.billingclient.api.u
            public final void a(n nVar, List list) {
                GoogleStrategy.A(this.f54081a, nVar, list);
            }
        });
    }
}
