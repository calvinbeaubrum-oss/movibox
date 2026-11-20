package com.android.billingclient.api;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class p0 {
    public static final n A;
    public static final n B;
    public static final n C;
    public static final n D;
    public static final n E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f16387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n f16388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final n f16389c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final n f16390d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final n f16391e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final n f16392f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final n f16393g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final n f16394h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final n f16395i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final n f16396j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final n f16397k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final n f16398l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final n f16399m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final n f16400n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final n f16401o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final n f16402p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final n f16403q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final n f16404r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final n f16405s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final n f16406t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final n f16407u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final n f16408v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final n f16409w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final n f16410x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final n f16411y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final n f16412z;

    static {
        n.a aVarC = n.c();
        aVarC.c(3);
        aVarC.b("Google Play In-app Billing API version is less than 3");
        f16387a = aVarC.a();
        n.a aVarC2 = n.c();
        aVarC2.c(3);
        aVarC2.b("Google Play In-app Billing API version is less than 9");
        f16388b = aVarC2.a();
        n.a aVarC3 = n.c();
        aVarC3.c(3);
        aVarC3.b("Billing service unavailable on device.");
        f16389c = aVarC3.a();
        n.a aVarC4 = n.c();
        aVarC4.c(5);
        aVarC4.b("Client is already in the process of connecting to billing service.");
        f16390d = aVarC4.a();
        n.a aVarC5 = n.c();
        aVarC5.c(5);
        aVarC5.b("The list of SKUs can't be empty.");
        f16391e = aVarC5.a();
        n.a aVarC6 = n.c();
        aVarC6.c(5);
        aVarC6.b("SKU type can't be empty.");
        f16392f = aVarC6.a();
        n.a aVarC7 = n.c();
        aVarC7.c(5);
        aVarC7.b("Product type can't be empty.");
        f16393g = aVarC7.a();
        n.a aVarC8 = n.c();
        aVarC8.c(-2);
        aVarC8.b("Client does not support extra params.");
        f16394h = aVarC8.a();
        n.a aVarC9 = n.c();
        aVarC9.c(5);
        aVarC9.b("Invalid purchase token.");
        f16395i = aVarC9.a();
        n.a aVarC10 = n.c();
        aVarC10.c(6);
        aVarC10.b("An internal error occurred.");
        f16396j = aVarC10.a();
        n.a aVarC11 = n.c();
        aVarC11.c(5);
        aVarC11.b("SKU can't be null.");
        f16397k = aVarC11.a();
        n.a aVarC12 = n.c();
        aVarC12.c(0);
        f16398l = aVarC12.a();
        n.a aVarC13 = n.c();
        aVarC13.c(-1);
        aVarC13.b("Service connection is disconnected.");
        f16399m = aVarC13.a();
        n.a aVarC14 = n.c();
        aVarC14.c(2);
        aVarC14.b("Timeout communicating with service.");
        f16400n = aVarC14.a();
        n.a aVarC15 = n.c();
        aVarC15.c(-2);
        aVarC15.b("Client does not support subscriptions.");
        f16401o = aVarC15.a();
        n.a aVarC16 = n.c();
        aVarC16.c(-2);
        aVarC16.b("Client does not support subscriptions update.");
        f16402p = aVarC16.a();
        n.a aVarC17 = n.c();
        aVarC17.c(-2);
        aVarC17.b("Client does not support get purchase history.");
        f16403q = aVarC17.a();
        n.a aVarC18 = n.c();
        aVarC18.c(-2);
        aVarC18.b("Client does not support price change confirmation.");
        f16404r = aVarC18.a();
        n.a aVarC19 = n.c();
        aVarC19.c(-2);
        aVarC19.b("Play Store version installed does not support cross selling products.");
        f16405s = aVarC19.a();
        n.a aVarC20 = n.c();
        aVarC20.c(-2);
        aVarC20.b("Client does not support multi-item purchases.");
        f16406t = aVarC20.a();
        n.a aVarC21 = n.c();
        aVarC21.c(-2);
        aVarC21.b("Client does not support offer_id_token.");
        f16407u = aVarC21.a();
        n.a aVarC22 = n.c();
        aVarC22.c(-2);
        aVarC22.b("Client does not support ProductDetails.");
        f16408v = aVarC22.a();
        n.a aVarC23 = n.c();
        aVarC23.c(-2);
        aVarC23.b("Client does not support in-app messages.");
        f16409w = aVarC23.a();
        n.a aVarC24 = n.c();
        aVarC24.c(-2);
        aVarC24.b("Client does not support user choice billing.");
        f16410x = aVarC24.a();
        n.a aVarC25 = n.c();
        aVarC25.c(5);
        aVarC25.b("Unknown feature");
        f16411y = aVarC25.a();
        n.a aVarC26 = n.c();
        aVarC26.c(-2);
        aVarC26.b("Play Store version installed does not support get billing config.");
        f16412z = aVarC26.a();
        n.a aVarC27 = n.c();
        aVarC27.c(-2);
        aVarC27.b("Query product details with serialized docid is not supported.");
        A = aVarC27.a();
        n.a aVarC28 = n.c();
        aVarC28.c(4);
        aVarC28.b("Item is unavailable for purchase.");
        B = aVarC28.a();
        n.a aVarC29 = n.c();
        aVarC29.c(-2);
        aVarC29.b("Query product details with developer specified account is not supported.");
        C = aVarC29.a();
        n.a aVarC30 = n.c();
        aVarC30.c(-2);
        aVarC30.b("Play Store version installed does not support alternative billing only.");
        D = aVarC30.a();
        n.a aVarC31 = n.c();
        aVarC31.c(5);
        aVarC31.b("To use this API you must specify a PurchasesUpdateListener when initializing a BillingClient.");
        E = aVarC31.a();
    }

    public static n a(int i11, String str) {
        n.a aVarC = n.c();
        aVarC.c(i11);
        aVarC.b(str);
        return aVarC.a();
    }
}
