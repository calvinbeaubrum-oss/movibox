package lb;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.EntryInfo;
import com.cloud.tmc.integration.model.PrepareData;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import kotlin.text.l;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f70186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f70187b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f70188c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f70189d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f70190e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Bundle f70191f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Bundle f70192g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public gc.a f70193h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f70194i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Context f70195j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public AppModel f70196k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public AppModel f70197l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public AppModel f70198m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public EntryInfo f70199n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final PrepareData f70200o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final long f70201p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f70202q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public wa.a f70203r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Activity f70204s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public AtomicBoolean f70205t;

    public g(Context startContext, String appId, Bundle startParams, Bundle sceneParams, boolean z11, wa.a aVar, Activity activity, AtomicBoolean isWarmup) {
        Intrinsics.g(startContext, "startContext");
        Intrinsics.g(appId, "appId");
        Intrinsics.g(startParams, "startParams");
        Intrinsics.g(sceneParams, "sceneParams");
        Intrinsics.g(isWarmup, "isWarmup");
        this.f70201p = 30000L;
        this.f70205t = new AtomicBoolean(false);
        this.f70186a = appId;
        this.f70195j = startContext;
        gc.a aVar2 = new gc.a(startParams);
        this.f70193h = aVar2;
        Bundle bundleA = aVar2.a();
        Intrinsics.f(bundleA, "originStartParams.mutable()");
        this.f70191f = bundleA;
        this.f70192g = sceneParams;
        PrepareData prepareData = new PrepareData();
        this.f70200o = prepareData;
        prepareData.clear();
        this.f70202q = z11;
        this.f70203r = aVar;
        this.f70204s = activity;
        this.f70205t = isWarmup;
    }

    public /* synthetic */ g(Context context, String str, Bundle bundle, Bundle bundle2, boolean z11, wa.a aVar, Activity activity, AtomicBoolean atomicBoolean, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, bundle, bundle2, (i11 & 16) != 0 ? false : z11, (i11 & 32) != 0 ? null : aVar, (i11 & 64) != 0 ? null : activity, (i11 & 128) != 0 ? new AtomicBoolean(false) : atomicBoolean);
    }

    public final void A(AppModel appModel) {
        this.f70197l = appModel;
    }

    public final void B(boolean z11) {
        this.f70189d = z11;
    }

    public final void C(boolean z11) {
        this.f70202q = z11;
    }

    public final Activity a() {
        return this.f70204s;
    }

    public final wa.a b() {
        return this.f70203r;
    }

    public final String c() {
        return this.f70186a;
    }

    public final a d() {
        return this.f70194i;
    }

    public final AppModel e() {
        return this.f70196k;
    }

    public final String f() {
        return this.f70190e;
    }

    public final String g() {
        return this.f70187b;
    }

    public final AppModel h() {
        return this.f70198m;
    }

    public final boolean i() {
        return l.v("debug", this.f70188c, true) || l.v("dev", this.f70188c, true);
    }

    public final String j() {
        if (l.v("debug", this.f70188c, true)) {
            return "0";
        }
        if (l.v("dev", this.f70188c, true)) {
            return "1";
        }
        return l.v("develop", this.f70188c, true) ? "2" : "";
    }

    public final EntryInfo k() {
        return this.f70199n;
    }

    public final AppModel l() {
        return this.f70197l;
    }

    public final PrepareData m() {
        return this.f70200o;
    }

    public final boolean n() {
        return this.f70189d;
    }

    public final Bundle o() {
        return this.f70192g;
    }

    public final Context p() {
        return this.f70195j;
    }

    public final Bundle q() {
        return this.f70191f;
    }

    public final boolean r() {
        return this.f70202q;
    }

    public final AtomicBoolean s() {
        return this.f70205t;
    }

    public final void t(a aVar) {
        this.f70194i = aVar;
    }

    public String toString() {
        return StringsKt__IndentKt.f("\n               PrepareContext{\n               appId=" + this.f70186a + "\n               originStartParam=" + this.f70193h + "}\n               ");
    }

    public final void u(AppModel appModel) {
        this.f70196k = appModel;
    }

    public final void v(String str) {
        this.f70190e = str;
    }

    public final void w(String str) {
        this.f70188c = str;
    }

    public final void x(String str) {
        this.f70187b = str;
    }

    public final void y(AppModel appModel) {
        this.f70198m = appModel;
    }

    public final void z(EntryInfo entryInfo) {
        this.f70199n = entryInfo;
    }
}
