package com.cloud.hisavana.sdk;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;
import com.applovin.sdk.AppLovinEventTypes;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.ext.attr.AttrData;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.transsion.push.PushConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@SourceDebugExtension
public final class n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f29891b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f29893d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f29894e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static long f29895f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f29890a = new n();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f29892c = true;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends Lambda implements Function0<Triple<? extends List<Map<String, Object>>, ? extends String, ? extends String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f29896a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Triple<List<Map<String, Object>>, String, String> invoke() {
            return n.f29890a.S();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends Lambda implements Function1<com.cloud.sdk.commonutil.util.g<? extends Triple<? extends List<Map<String, Object>>, ? extends String, ? extends String>>, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f29897a = new b();

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class a extends Lambda implements Function0<Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.cloud.sdk.commonutil.util.g<Triple<List<Map<String, Object>>, String, String>> f29898a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(com.cloud.sdk.commonutil.util.g<? extends Triple<? extends List<Map<String, Object>>, String, String>> gVar) {
                super(0);
                this.f29898a = gVar;
            }

            public final void a() {
                n.f29890a.r((String) ((Triple) ((com.cloud.sdk.commonutil.util.g.b) this.f29898a).a()).getSecond());
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                a();
                return Unit.f68710a;
            }
        }

        public b() {
            super(1);
        }

        public final void a(com.cloud.sdk.commonutil.util.g<? extends Triple<? extends List<Map<String, Object>>, String, String>> result) throws JSONException {
            Intrinsics.g(result, "result");
            if (!(result instanceof com.cloud.sdk.commonutil.util.g.b)) {
                if (result instanceof com.cloud.sdk.commonutil.util.g.a) {
                    z.a().e("AttrDataManager", "cycleClick error: " + ((com.cloud.sdk.commonutil.util.g.a) result).a());
                    return;
                }
                return;
            }
            if (z.b()) {
                z.a().i("AttrDataManager", "cycleClick success result value : " + ((com.cloud.sdk.commonutil.util.g.b) result).a());
            }
            com.cloud.sdk.commonutil.util.g.b bVar = (com.cloud.sdk.commonutil.util.g.b) result;
            n.f29890a.q(new com.cloud.sdk.commonutil.util.g.b(new Pair((List) ((Triple) bVar.a()).getFirst(), (String) ((Triple) bVar.a()).getThird())), 1, new a(result));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.cloud.sdk.commonutil.util.g<? extends Triple<? extends List<Map<String, Object>>, ? extends String, ? extends String>> gVar) throws JSONException {
            a(gVar);
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends Lambda implements Function1<Integer, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdsDTO f29899a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(AdsDTO adsDTO) {
            super(1);
            this.f29899a = adsDTO;
        }

        public final void a(int i11) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            n nVar = n.f29890a;
            if (jCurrentTimeMillis - nVar.K() >= ((long) i11) * 3600000) {
                n.f29895f = jCurrentTimeMillis;
                da.a.d().o("attr_click_time", jCurrentTimeMillis);
                nVar.F();
            }
            nVar.w(this.f29899a);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            a(num.intValue());
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdsDTO f29900a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(AdsDTO adsDTO) {
            super(0);
            this.f29900a = adsDTO;
        }

        public final void a() {
            n.f29890a.N(this.f29900a);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class e extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f29901a = new e();

        public e() {
            super(0);
        }

        public final void a() {
            n.f29890a.v();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class f extends Lambda implements Function0<Pair<? extends List<Pair<? extends String, ? extends Long>>, ? extends List<String>>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f29902a = new f();

        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Pair<List<Pair<String, Long>>, List<String>> invoke() {
            return n.f29890a.T();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class g extends Lambda implements Function1<com.cloud.sdk.commonutil.util.g<? extends Pair<? extends List<Pair<? extends String, ? extends Long>>, ? extends List<String>>>, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f29903a = new g();

        public g() {
            super(1);
        }

        public final void a(com.cloud.sdk.commonutil.util.g<? extends Pair<? extends List<Pair<String, Long>>, ? extends List<String>>> result) throws JSONException {
            Intrinsics.g(result, "result");
            if (!(result instanceof com.cloud.sdk.commonutil.util.g.b)) {
                if (result instanceof com.cloud.sdk.commonutil.util.g.a) {
                    z.a().e("AttrDataManager", "postShowData error: " + ((com.cloud.sdk.commonutil.util.g.a) result).a());
                    return;
                }
                return;
            }
            z zVarA = z.a();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("success result value : ");
            com.cloud.sdk.commonutil.util.g.b bVar = (com.cloud.sdk.commonutil.util.g.b) result;
            sb2.append(bVar.a());
            zVarA.i("AttrDataManager", sb2.toString());
            if (!((Collection) ((Pair) bVar.a()).getFirst()).isEmpty()) {
                n.f29890a.s((Pair) bVar.a());
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.cloud.sdk.commonutil.util.g<? extends Pair<? extends List<Pair<? extends String, ? extends Long>>, ? extends List<String>>> gVar) throws JSONException {
            a(gVar);
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class h extends Lambda implements Function1<Integer, CharSequence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f29904a = new h();

        public h() {
            super(1);
        }

        public final CharSequence a(int i11) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append('\'');
            sb2.append(i11);
            sb2.append('\'');
            return sb2.toString();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CharSequence invoke(Integer num) {
            return a(num.intValue());
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class i extends Lambda implements Function0<Pair<? extends List<Map<String, Object>>, ? extends String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdsDTO f29905a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(AdsDTO adsDTO) {
            super(0);
            this.f29905a = adsDTO;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Pair<List<Map<String, Object>>, String> invoke() {
            return n.f29890a.O(this.f29905a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class j extends Lambda implements Function1<com.cloud.sdk.commonutil.util.g<? extends Pair<? extends List<Map<String, Object>>, ? extends String>>, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f29906a = new j();

        public j() {
            super(1);
        }

        public final void a(com.cloud.sdk.commonutil.util.g<? extends Pair<? extends List<Map<String, Object>>, String>> result) throws JSONException {
            Intrinsics.g(result, "result");
            if (result instanceof com.cloud.sdk.commonutil.util.g.b) {
                if (z.b()) {
                    z.a().i("AttrDataManager", "realClick success result value : " + ((com.cloud.sdk.commonutil.util.g.b) result).a());
                }
                n.n(n.f29890a, (com.cloud.sdk.commonutil.util.g.b) result, 2, null, 4, null);
                return;
            }
            if (result instanceof com.cloud.sdk.commonutil.util.g.a) {
                z.a().e("AttrDataManager", "realClick error: " + ((com.cloud.sdk.commonutil.util.g.a) result).a());
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.cloud.sdk.commonutil.util.g<? extends Pair<? extends List<Map<String, Object>>, ? extends String>> gVar) throws JSONException {
            a(gVar);
            return Unit.f68710a;
        }
    }

    public static final void D(AdsDTO adsDTO) {
        z zVarA;
        StringBuilder sb2;
        SQLiteDatabase sQLiteDatabaseA = y.f30223a.a();
        try {
            if (sQLiteDatabaseA == null) {
                z.a().d("AttrDataManager", "Database connection is null");
                return;
            }
            try {
                sQLiteDatabaseA.beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put("ac_type", adsDTO.getPullNewestLive());
                n nVar = f29890a;
                contentValues.put(PushConstants.PROVIDER_FIELD_PKG, nVar.d(adsDTO));
                ArrayList<String> storeDeeplink = adsDTO.getStoreDeeplink();
                Integer pullNewestLive = adsDTO.getPullNewestLive();
                Intrinsics.f(pullNewestLive, "ad.pullNewestLive");
                contentValues.put("dl_type", nVar.e(storeDeeplink, pullNewestLive.intValue()));
                contentValues.put("codeSeatId", adsDTO.getCodeSeatId());
                contentValues.put(TrackingKey.CLICK_TS, Long.valueOf(System.currentTimeMillis()));
                contentValues.put("ad_creative_id", adsDTO.getAdCreativeId());
                sQLiteDatabaseA.insert("attr_click", null, contentValues);
                sQLiteDatabaseA.setTransactionSuccessful();
                if (z.b()) {
                    z.a().i("AttrDataManager", "insertClick success contentValues ---> " + contentValues);
                }
                try {
                    sQLiteDatabaseA.endTransaction();
                } catch (Exception e11) {
                    e = e11;
                    zVarA = z.a();
                    sb2 = new StringBuilder();
                    sb2.append("insertClick end transaction fail: ");
                    sb2.append(e.getMessage());
                    zVarA.e("AttrDataManager", sb2.toString());
                }
            } catch (Exception e12) {
                z.a().e("AttrDataManager", "insertClick fail " + Log.getStackTraceString(e12));
                try {
                    sQLiteDatabaseA.endTransaction();
                } catch (Exception e13) {
                    e = e13;
                    zVarA = z.a();
                    sb2 = new StringBuilder();
                    sb2.append("insertClick end transaction fail: ");
                    sb2.append(e.getMessage());
                    zVarA.e("AttrDataManager", sb2.toString());
                }
            }
        } catch (Throwable th2) {
            try {
                sQLiteDatabaseA.endTransaction();
            } catch (Exception e14) {
                z.a().e("AttrDataManager", "insertClick end transaction fail: " + e14.getMessage());
            }
            throw th2;
        }
    }

    public static final void J(AdsDTO adsDTO) {
        z zVarA;
        StringBuilder sb2;
        SQLiteDatabase sQLiteDatabaseA = y.f30223a.a();
        if (sQLiteDatabaseA == null) {
            z.a().i("AttrDataManager", "Database connection is null");
            return;
        }
        if (z.b()) {
            z.a().i("AttrDataManager", "ad info : " + adsDTO);
        }
        try {
            try {
                sQLiteDatabaseA.beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put(PushConstants.PROVIDER_FIELD_PKG, f29890a.d(adsDTO));
                contentValues.put("ad_creative_id", adsDTO.getAdCreativeId());
                contentValues.put("imp_ts", Long.valueOf(System.currentTimeMillis()));
                sQLiteDatabaseA.insert("attr_impression", null, contentValues);
                sQLiteDatabaseA.setTransactionSuccessful();
                try {
                    sQLiteDatabaseA.endTransaction();
                } catch (Exception e11) {
                    e = e11;
                    zVarA = z.a();
                    sb2 = new StringBuilder();
                    sb2.append("end transaction fail: ");
                    sb2.append(e.getMessage());
                    zVarA.e("AttrDataManager", sb2.toString());
                }
            } catch (Throwable th2) {
                try {
                    sQLiteDatabaseA.endTransaction();
                } catch (Exception e12) {
                    z.a().e("AttrDataManager", "end transaction fail: " + e12.getMessage());
                }
                throw th2;
            }
        } catch (Exception e13) {
            z.a().e("AttrDataManager", "insert imp fail " + Log.getStackTraceString(e13));
            try {
                sQLiteDatabaseA.endTransaction();
            } catch (Exception e14) {
                e = e14;
                zVarA = z.a();
                sb2 = new StringBuilder();
                sb2.append("end transaction fail: ");
                sb2.append(e.getMessage());
                zVarA.e("AttrDataManager", sb2.toString());
            }
        }
    }

    @JvmStatic
    public static final void L(AdsDTO adsDTO) {
        if (f29890a.P()) {
            return;
        }
        q1.f30002a.c(new c(adsDTO), new d(adsDTO), e.f29901a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void n(n nVar, com.cloud.sdk.commonutil.util.g.b bVar, int i11, Function0 function0, int i12, Object obj) throws JSONException {
        if ((i12 & 4) != 0) {
            function0 = null;
        }
        nVar.q(bVar, i11, function0);
    }

    public static final void z(String str) {
        z zVarA;
        StringBuilder sb2;
        SQLiteDatabase sQLiteDatabaseA = y.f30223a.a();
        if (sQLiteDatabaseA == null) {
            z.a().i("AttrDataManager", "Database connection is null");
            return;
        }
        try {
            try {
                sQLiteDatabaseA.beginTransaction();
                String str2 = "DELETE FROM attr_click WHERE _id IN (" + str + "); ";
                if (z.b()) {
                    z.a().d("AttrDataManager", "deleteClicks sql----> " + str2);
                }
                sQLiteDatabaseA.execSQL(str2);
                sQLiteDatabaseA.setTransactionSuccessful();
                try {
                    sQLiteDatabaseA.endTransaction();
                } catch (Exception e11) {
                    e = e11;
                    zVarA = z.a();
                    sb2 = new StringBuilder();
                    sb2.append("deleteClicks end transaction fail: ");
                    sb2.append(e.getMessage());
                    zVarA.e("AttrDataManager", sb2.toString());
                }
            } catch (Exception e12) {
                z.a().e("AttrDataManager", "deleteClicks fail " + Log.getStackTraceString(e12));
                try {
                    sQLiteDatabaseA.endTransaction();
                } catch (Exception e13) {
                    e = e13;
                    zVarA = z.a();
                    sb2 = new StringBuilder();
                    sb2.append("deleteClicks end transaction fail: ");
                    sb2.append(e.getMessage());
                    zVarA.e("AttrDataManager", sb2.toString());
                }
            }
        } catch (Throwable th2) {
            try {
                sQLiteDatabaseA.endTransaction();
            } catch (Exception e14) {
                z.a().e("AttrDataManager", "deleteClicks end transaction fail: " + e14.getMessage());
            }
            throw th2;
        }
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "Object.hashCode()" because "this.second" is null
    	at jadx.core.utils.Pair.hashCode(Pair.java:35)
    	at java.base/java.util.HashMap.hash(HashMap.java:338)
    	at java.base/java.util.HashMap.getNode(HashMap.java:576)
    	at java.base/java.util.HashMap.containsKey(HashMap.java:602)
    	at jadx.core.dex.visitors.finaly.traverser.state.TraverserGlobalCommonState.hasBlocksBeenCached(TraverserGlobalCommonState.java:35)
    	at jadx.core.dex.visitors.finaly.traverser.handlers.MergePathActivePathTraverserHandler.handle(MergePathActivePathTraverserHandler.java:174)
    	at jadx.core.dex.visitors.finaly.traverser.handlers.AbstractActivePathTraverserHandler.process(AbstractActivePathTraverserHandler.java:19)
    	at jadx.core.dex.visitors.finaly.traverser.TraverserController.processHandlerImplementations(TraverserController.java:43)
    	at jadx.core.dex.visitors.finaly.traverser.TraverserController.advance(TraverserController.java:156)
    	at jadx.core.dex.visitors.finaly.traverser.TraverserController.process(TraverserController.java:79)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.findCommonInsns(MarkFinallyVisitor.java:404)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.extractFinally(MarkFinallyVisitor.java:284)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.processTryBlock(MarkFinallyVisitor.java:202)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:135)
     */
    public final void C() {
        z zVarA;
        StringBuilder sb2;
        SQLiteDatabase sQLiteDatabaseA = y.f30223a.a();
        if (sQLiteDatabaseA == null) {
            z.a().i("AttrDataManager", "Database connection is null");
            return;
        }
        if (z.b()) {
            z.a().i("AttrDataManager", "clear impressions");
        }
        try {
            try {
                try {
                    sQLiteDatabaseA.beginTransaction();
                    sQLiteDatabaseA.execSQL("DELETE FROM attr_impression");
                    sQLiteDatabaseA.setTransactionSuccessful();
                    try {
                        sQLiteDatabaseA.endTransaction();
                    } catch (Exception e11) {
                        e = e11;
                        zVarA = z.a();
                        sb2 = new StringBuilder();
                        sb2.append("end transaction fail: ");
                        sb2.append(e.getMessage());
                        zVarA.e("AttrDataManager", sb2.toString());
                    }
                } catch (SQLException e12) {
                    z.a().e("AttrDataManager", "SQL error executing delete query: " + e12.getMessage());
                    try {
                        sQLiteDatabaseA.endTransaction();
                    } catch (Exception e13) {
                        e = e13;
                        zVarA = z.a();
                        sb2 = new StringBuilder();
                        sb2.append("end transaction fail: ");
                        sb2.append(e.getMessage());
                        zVarA.e("AttrDataManager", sb2.toString());
                    }
                }
            } catch (Exception e14) {
                z.a().e("AttrDataManager", "Error executing delete query: " + e14.getMessage());
                try {
                    sQLiteDatabaseA.endTransaction();
                } catch (Exception e15) {
                    e = e15;
                    zVarA = z.a();
                    sb2 = new StringBuilder();
                    sb2.append("end transaction fail: ");
                    sb2.append(e.getMessage());
                    zVarA.e("AttrDataManager", sb2.toString());
                }
            }
        } catch (Throwable th2) {
            try {
                sQLiteDatabaseA.endTransaction();
            } catch (Exception e16) {
                z.a().e("AttrDataManager", "end transaction fail: " + e16.getMessage());
            }
            throw th2;
        }
    }

    public final void F() {
        com.cloud.sdk.commonutil.util.i.f30292a.c(a.f29896a, b.f29897a);
    }

    public final void G(final AdsDTO adsDTO) {
        if (adsDTO == null) {
            z.a().i("AttrDataManager", "Ad is null.");
        } else {
            if (u(adsDTO, false)) {
                return;
            }
            com.cloud.sdk.commonutil.util.i.f30292a.b(new Runnable() { // from class: com.cloud.hisavana.sdk.t1
                @Override // java.lang.Runnable
                public final void run() {
                    n.J(adsDTO);
                }
            });
        }
    }

    public final String H() {
        String string = UUID.randomUUID().toString();
        Intrinsics.f(string, "randomUUID().toString()");
        String strF = kotlin.text.l.F(string, "-", "", false, 4, null);
        long jCurrentTimeMillis = System.currentTimeMillis();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("ew_");
        String strSubstring = strF.substring(0, 6);
        Intrinsics.f(strSubstring, "substring(...)");
        sb2.append(strSubstring);
        sb2.append("_");
        sb2.append(jCurrentTimeMillis);
        String string2 = sb2.toString();
        Intrinsics.f(string2, "uniquePart.toString()");
        return string2;
    }

    public final long K() {
        long j11 = f29895f;
        return j11 > 0 ? j11 : da.a.d().g("attr_click_time");
    }

    public final void M() {
        h();
        Q();
    }

    public final void N(AdsDTO adsDTO) {
        com.cloud.sdk.commonutil.util.i.f30292a.c(new i(adsDTO), j.f29906a);
    }

    public final Pair<List<Map<String, Object>>, String> O(AdsDTO adsDTO) {
        if (adsDTO == null) {
            z.a().i("AttrDataManager", "Ad is null.");
            return new Pair<>(null, null);
        }
        if (u(adsDTO, true)) {
            return new Pair<>(null, null);
        }
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Integer pullNewestLive = adsDTO.getPullNewestLive();
        Intrinsics.f(pullNewestLive, "ad.pullNewestLive");
        linkedHashMap.put("action_type", pullNewestLive);
        linkedHashMap.put(TtmlNode.TAG_P, d(adsDTO));
        ArrayList<String> storeDeeplink = adsDTO.getStoreDeeplink();
        Integer pullNewestLive2 = adsDTO.getPullNewestLive();
        Intrinsics.f(pullNewestLive2, "ad.pullNewestLive");
        linkedHashMap.put("type", e(storeDeeplink, pullNewestLive2.intValue()));
        String codeSeatId = adsDTO.getCodeSeatId();
        Intrinsics.f(codeSeatId, "ad.codeSeatId");
        linkedHashMap.put("adId", codeSeatId);
        linkedHashMap.put("time", Long.valueOf(System.currentTimeMillis()));
        arrayList.add(linkedHashMap);
        return new Pair<>(arrayList, adsDTO.getAdCreativeId());
    }

    public final boolean P() {
        if (f29891b) {
            return false;
        }
        z.a().i("AttrDataManager", "Attr func disable.");
        return true;
    }

    public final void Q() {
        if (R()) {
            return;
        }
        com.cloud.sdk.commonutil.util.i.f30292a.c(f.f29902a, g.f29903a);
    }

    public final boolean R() {
        if (!f29891b) {
            z.a().i("AttrDataManager", "Attr func disable.");
            return true;
        }
        int iD = q1.f30002a.d();
        if (z.b()) {
            z.a().i("AttrDataManager", "Attr showConfig : " + iD);
        }
        if (iD < 0) {
            C();
            return true;
        }
        if (iD != 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - f29893d < ((long) iD) * 3600000) {
                return true;
            }
            f29893d = jCurrentTimeMillis;
            U();
        } else {
            if (!f29892c) {
                return true;
            }
            f29892c = false;
        }
        return false;
    }

    public final Triple<List<Map<String, Object>>, String, String> S() {
        z zVarA;
        StringBuilder sb2;
        String str;
        SQLiteDatabase sQLiteDatabaseA = y.f30223a.a();
        if (sQLiteDatabaseA == null) {
            z.a().i("AttrDataManager", "Database connection is null");
            return new Triple<>(null, null, null);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        try {
            Cursor cursorRawQuery = sQLiteDatabaseA.rawQuery("SELECT * FROM attr_click", null);
            while (cursorRawQuery.moveToNext()) {
                try {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    int i11 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow("_id"));
                    int i12 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow("ac_type"));
                    String pkgName = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow(PushConstants.PROVIDER_FIELD_PKG));
                    String dlType = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("dl_type"));
                    String codeSeatId = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("codeSeatId"));
                    long j11 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndexOrThrow(TrackingKey.CLICK_TS));
                    String creative = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("ad_creative_id"));
                    arrayList2.add(Integer.valueOf(i11));
                    Intrinsics.f(creative, "creative");
                    arrayList3.add(creative);
                    linkedHashMap.put("action_type", Integer.valueOf(i12));
                    Intrinsics.f(pkgName, "pkgName");
                    linkedHashMap.put(TtmlNode.TAG_P, pkgName);
                    Intrinsics.f(dlType, "dlType");
                    linkedHashMap.put("type", dlType);
                    Intrinsics.f(codeSeatId, "codeSeatId");
                    linkedHashMap.put("adId", codeSeatId);
                    linkedHashMap.put("time", Long.valueOf(j11));
                    arrayList.add(linkedHashMap);
                } catch (Throwable th2) {
                    try {
                        throw th2;
                    } catch (Throwable th3) {
                        CloseableKt.a(cursorRawQuery, th2);
                        throw th3;
                    }
                }
            }
            Unit unit = Unit.f68710a;
            CloseableKt.a(cursorRawQuery, null);
        } catch (SQLException e11) {
            e = e11;
            zVarA = z.a();
            sb2 = new StringBuilder();
            str = "queryClick SQLException fail: ";
            sb2.append(str);
            sb2.append(e.getMessage());
            zVarA.e("AttrDataManager", sb2.toString());
            return new Triple<>(arrayList, CollectionsKt___CollectionsKt.o0(arrayList2, null, null, null, 0, null, h.f29904a, 31, null), CollectionsKt___CollectionsKt.o0(arrayList3, null, null, null, 0, null, null, 63, null));
        } catch (Exception e12) {
            e = e12;
            zVarA = z.a();
            sb2 = new StringBuilder();
            str = "queryClick Exception fail: ";
            sb2.append(str);
            sb2.append(e.getMessage());
            zVarA.e("AttrDataManager", sb2.toString());
            return new Triple<>(arrayList, CollectionsKt___CollectionsKt.o0(arrayList2, null, null, null, 0, null, h.f29904a, 31, null), CollectionsKt___CollectionsKt.o0(arrayList3, null, null, null, 0, null, null, 63, null));
        }
        return new Triple<>(arrayList, CollectionsKt___CollectionsKt.o0(arrayList2, null, null, null, 0, null, h.f29904a, 31, null), CollectionsKt___CollectionsKt.o0(arrayList3, null, null, null, 0, null, null, 63, null));
    }

    public final Pair<List<Pair<String, Long>>, List<String>> T() throws Exception {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        SQLiteDatabase sQLiteDatabaseA = y.f30223a.a();
        if (sQLiteDatabaseA == null) {
            z.a().i("AttrDataManager", "Database connection is null");
            return new Pair<>(arrayList, arrayList2);
        }
        try {
            Cursor cursorRawQuery = sQLiteDatabaseA.rawQuery("SELECT * FROM attr_impression", null);
            while (cursorRawQuery.moveToNext()) {
                try {
                    String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow(PushConstants.PROVIDER_FIELD_PKG));
                    long j11 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndexOrThrow("imp_ts"));
                    String creative = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("ad_creative_id"));
                    arrayList.add(new Pair(string, Long.valueOf(j11)));
                    Intrinsics.f(creative, "creative");
                    arrayList2.add(creative);
                } catch (Throwable th2) {
                    try {
                        throw th2;
                    } catch (Throwable th3) {
                        CloseableKt.a(cursorRawQuery, th2);
                        throw th3;
                    }
                }
            }
            Unit unit = Unit.f68710a;
            CloseableKt.a(cursorRawQuery, null);
            return new Pair<>(arrayList, arrayList2);
        } catch (SQLException e11) {
            throw new SQLException(String.valueOf(e11));
        } catch (Exception e12) {
            throw new Exception(String.valueOf(e12));
        }
    }

    public final void U() {
        h();
        f29894e = 0;
    }

    public final String d(AdsDTO adsDTO) {
        String psPackageName;
        String str;
        String packageName = adsDTO.getPackageName();
        if (packageName == null || kotlin.text.l.y(packageName)) {
            psPackageName = adsDTO.getPsPackageName();
            str = "ad.psPackageName";
        } else {
            psPackageName = adsDTO.getPackageName();
            str = "ad.packageName";
        }
        Intrinsics.f(psPackageName, str);
        return psPackageName;
    }

    public final String e(List<String> list, int i11) {
        if (i11 != 2) {
            return "";
        }
        if (list == null || list.isEmpty()) {
            z.a().i("AttrDataManager", "ad store deep link is empty");
            return "OTHER";
        }
        for (String str : list) {
            if (str != null && str.length() != 0) {
                if (kotlin.text.l.L(str, "palmplay://", false, 2, null)) {
                    return "PS";
                }
                if (kotlin.text.l.L(str, "aha://", false, 2, null)) {
                    return "AHA";
                }
                return (kotlin.text.l.L(str, "market://", false, 2, null) || StringsKt__StringsKt.Q(str, "play.google.com", false, 2, null)) ? "GP" : "OTHER";
            }
        }
        return "";
    }

    public final Pair<Integer, String> f(boolean z11, int i11) throws JSONException {
        JSONObject jSONObject;
        String string;
        String str = z11 ? "successive_failures_imp" : "successive_failures_click";
        try {
            jSONObject = new JSONObject(da.a.d().j(str, ""));
        } catch (Exception unused) {
            jSONObject = new JSONObject();
            jSONObject.put("count", 0);
            jSONObject.put("error_list", "");
        }
        int iOptInt = jSONObject.optInt("count", 0);
        String errorListStr = jSONObject.optString("error_list", "");
        if (4 == i11 || 5 == i11) {
            int i12 = f29894e + 1;
            f29894e = i12;
            if (i12 > 3) {
                f29891b = false;
                C();
                v();
            }
        } else {
            iOptInt++;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(errorListStr);
            Intrinsics.f(errorListStr, "errorListStr");
            if (kotlin.text.l.y(errorListStr)) {
                string = String.valueOf(i11);
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(',');
                sb3.append(i11);
                string = sb3.toString();
            }
            sb2.append(string);
            errorListStr = sb2.toString();
            jSONObject.put("count", iOptInt);
            jSONObject.put("error_list", errorListStr);
            da.a.d().p(str, jSONObject.toString());
            if (iOptInt > 5) {
                f29891b = false;
                da.a.d().m("hs_attr_shutdown", true);
                C();
                v();
            }
        }
        if (z.b()) {
            z.a().i("AttrDataManager", "本次errorCode: " + i11 + " | 临时降级失败次数 : " + f29894e + " | 永久降级失败次数和原因 :" + str + " : " + jSONObject);
        }
        return new Pair<>(Integer.valueOf(iOptInt), errorListStr);
    }

    public final Pair<String, Integer> g(boolean z11, Object obj) {
        int i11;
        String lastPathSegment;
        int i12;
        String strH = H();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", z11 ? PushConstants.PUSH_SERVICE_TYPE_SHOW : "click");
        linkedHashMap.put("linkId", strH);
        linkedHashMap.put(AppLovinEventTypes.USER_VIEWED_CONTENT, obj);
        String strD = GsonUtil.d(linkedHashMap);
        a2.a aVar = a2.f29103d;
        String strF = a2.a.a(aVar, null, 1, null).f(strD);
        String strE = a2.a.a(aVar, null, 1, null).e(strF + "ew2913");
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            ContentResolver contentResolver = com.cloud.sdk.commonutil.util.f.a().getContentResolver();
            ContentValues contentValues = new ContentValues();
            contentValues.put("sign", strE);
            contentValues.put("data", strF);
            contentValues.put("from", "ew");
            Uri uriInsert = contentResolver.insert(Uri.parse("content://com.common.bgainfo.provider/attribute_ew"), contentValues);
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            if (uriInsert == null || (lastPathSegment = uriInsert.getLastPathSegment()) == null) {
                lastPathSegment = "";
            }
            boolean zB = Intrinsics.b(lastPathSegment, "3");
            if (uriInsert == null) {
                i12 = 1;
            } else if (zB) {
                i12 = 5;
            } else {
                i12 = jCurrentTimeMillis2 >= 5000 ? 2 : 0;
            }
            if (z.b()) {
                z.a().i("AttrDataManager", "content: " + strD + "\ninsertedUri: " + uriInsert + " \nerrorCode: " + i12);
            }
            i11 = i12;
        } catch (IllegalArgumentException e11) {
            z.a().e("AttrDataManager", "postData error: " + e11);
            String message = e11.getMessage();
            i11 = (message == null || !StringsKt__StringsKt.Q(message, "content://com.common.bgainfo.provider/attribute_ew", false, 2, null)) ? 3 : 4;
        } catch (Exception e12) {
            z.a().e("AttrDataManager", "postData error: " + e12);
        }
        return new Pair<>(strH, Integer.valueOf(i11));
    }

    public final void h() {
        boolean zF = w9.x.f(com.cloud.sdk.commonutil.util.f.a());
        boolean z11 = false;
        boolean zC = da.a.d().c("hs_attr_shutdown", false);
        q1 q1Var = q1.f30002a;
        int iD = q1Var.d();
        int iA = q1Var.a();
        if (zF && !zC && (iD >= 0 || iA >= 0)) {
            z11 = true;
        }
        f29891b = z11;
        if (z.b()) {
            z.a().i("AttrDataManager", "enableAttr: " + f29891b + "\nShowDataSyncTimeInterval : " + iD + "\nShowDataSyncTimeInterval : " + iA);
        }
    }

    public final void i(int i11) {
        z zVarA;
        StringBuilder sb2;
        if (i11 <= 0) {
            z.a().i("AttrDataManager", "Invalid limit value: " + i11);
            return;
        }
        SQLiteDatabase sQLiteDatabaseA = y.f30223a.a();
        if (sQLiteDatabaseA == null) {
            z.a().i("AttrDataManager", "Database connection is null");
            return;
        }
        if (z.b()) {
            z.a().i("AttrDataManager", "delete impressions " + i11);
        }
        try {
            try {
                sQLiteDatabaseA.beginTransaction();
                sQLiteDatabaseA.execSQL("DELETE FROM attr_impression WHERE _id IN (SELECT _id FROM attr_impression ORDER BY _id ASC LIMIT ?)", new Integer[]{Integer.valueOf(i11)});
                sQLiteDatabaseA.setTransactionSuccessful();
                try {
                    sQLiteDatabaseA.endTransaction();
                } catch (Exception e11) {
                    e = e11;
                    zVarA = z.a();
                    sb2 = new StringBuilder();
                    sb2.append("end transaction fail: ");
                    sb2.append(e.getMessage());
                    zVarA.e("AttrDataManager", sb2.toString());
                }
            } catch (Throwable th2) {
                try {
                    sQLiteDatabaseA.endTransaction();
                } catch (Exception e12) {
                    z.a().e("AttrDataManager", "end transaction fail: " + e12.getMessage());
                }
                throw th2;
            }
        } catch (SQLException e13) {
            z.a().e("AttrDataManager", "SQL error executing delete query: " + e13.getMessage());
            try {
                sQLiteDatabaseA.endTransaction();
            } catch (Exception e14) {
                e = e14;
                zVarA = z.a();
                sb2 = new StringBuilder();
                sb2.append("end transaction fail: ");
                sb2.append(e.getMessage());
                zVarA.e("AttrDataManager", sb2.toString());
            }
        } catch (Exception e15) {
            z.a().e("AttrDataManager", "Error executing delete query: " + e15.getMessage());
            try {
                sQLiteDatabaseA.endTransaction();
            } catch (Exception e16) {
                e = e16;
                zVarA = z.a();
                sb2 = new StringBuilder();
                sb2.append("end transaction fail: ");
                sb2.append(e.getMessage());
                zVarA.e("AttrDataManager", sb2.toString());
            }
        }
    }

    public final void q(com.cloud.sdk.commonutil.util.g.b<? extends Pair<? extends List<Map<String, Object>>, String>> bVar, int i11, Function0<Unit> function0) throws JSONException {
        List<Map<String, Object>> first = bVar.a().getFirst();
        if (first == null || first.isEmpty()) {
            return;
        }
        List<Map<String, Object>> first2 = bVar.a().getFirst();
        if (first2 == null) {
            first2 = new ArrayList<>();
        }
        Pair<String, Integer> pairG = g(false, first2);
        AttrData attrData = new AttrData(0, null, 0, 0L, null, 0, null, 0, 255, null);
        attrData.setType(i11);
        attrData.setLinkId(pairG.getFirst());
        List<Map<String, Object>> first3 = bVar.a().getFirst();
        attrData.setCount(first3 != null ? first3.size() : 0);
        String second = bVar.a().getSecond();
        if (second == null) {
            second = "";
        }
        attrData.setCreatives(second);
        attrData.setEventTs(System.currentTimeMillis());
        attrData.setErrorCode(pairG.getSecond().intValue());
        if (pairG.getSecond().intValue() == 0) {
            if (function0 != null) {
                function0.invoke();
            }
            t(false);
            attrData.setFailCount(0);
            attrData.setErrorList("");
        } else {
            Pair<Integer, String> pairF = f(false, pairG.getSecond().intValue());
            attrData.setFailCount(pairF.getFirst().intValue());
            attrData.setErrorList(pairF.getSecond());
        }
        AthenaTracker.I(attrData);
    }

    public final void r(final String str) {
        if (str == null || kotlin.text.l.y(str)) {
            return;
        }
        com.cloud.sdk.commonutil.util.i.f30292a.b(new Runnable() { // from class: com.cloud.hisavana.sdk.s1
            @Override // java.lang.Runnable
            public final void run() {
                n.z(str);
            }
        });
    }

    public final void s(Pair<? extends List<Pair<String, Long>>, ? extends List<String>> pair) throws JSONException {
        String second;
        List<Pair<String, Long>> first = pair.getFirst();
        ArrayList arrayList = new ArrayList(kotlin.collections.h.v(first, 10));
        Iterator<T> it = first.iterator();
        while (it.hasNext()) {
            Pair pair2 = (Pair) it.next();
            arrayList.add(kotlin.collections.s.k(TuplesKt.a(TtmlNode.TAG_P, (String) pair2.component1()), TuplesKt.a("showTime", Long.valueOf(((Number) pair2.component2()).longValue()))));
        }
        Pair<String, Integer> pairG = g(true, arrayList);
        AttrData attrData = new AttrData(0, null, 0, 0L, null, 0, null, 0, 255, null);
        attrData.setLinkId(pairG.getFirst());
        attrData.setCount(pair.getSecond().size());
        attrData.setCreatives(CollectionsKt___CollectionsKt.o0(pair.getSecond(), null, null, null, 0, null, null, 63, null));
        attrData.setEventTs(System.currentTimeMillis());
        attrData.setErrorCode(pairG.getSecond().intValue());
        if (pairG.getSecond().intValue() == 0) {
            i(pair.getSecond().size());
            t(true);
            attrData.setFailCount(0);
            second = "";
        } else {
            Pair<Integer, String> pairF = f(true, pairG.getSecond().intValue());
            attrData.setFailCount(pairF.getFirst().intValue());
            second = pairF.getSecond();
        }
        attrData.setErrorList(second);
        AthenaTracker.S(attrData);
    }

    public final void t(boolean z11) {
        f29894e = 0;
        da.a.d().p(z11 ? "successive_failures_imp" : "successive_failures_click", "");
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0043  */
    /* JADX WARN: Code duplicated, block: B:28:0x0053 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:29:0x0055 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:36:0x006b A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    public final boolean u(AdsDTO adsDTO, boolean z11) {
        z zVarA;
        String str;
        Integer pullNewestLive;
        if (!f29891b) {
            zVarA = z.a();
            str = "Attr func disable.";
        } else if (z11 || q1.f30002a.d() != -1) {
            String packageName = adsDTO != null ? adsDTO.getPackageName() : null;
            if (packageName != null && !kotlin.text.l.y(packageName)) {
                if (adsDTO == null) {
                    if (z11) {
                        return false;
                    }
                    return false;
                }
                if (z11) {
                    return false;
                }
                return false;
            }
            String psPackageName = adsDTO != null ? adsDTO.getPsPackageName() : null;
            if (psPackageName == null || kotlin.text.l.y(psPackageName)) {
                zVarA = z.a();
                str = "Ad pkg is empty.";
            } else if (adsDTO == null && adsDTO.getSource() == 4) {
                zVarA = z.a();
                str = "Filter default ad.";
            } else {
                if (z11 || adsDTO == null || (pullNewestLive = adsDTO.getPullNewestLive()) == null || pullNewestLive.intValue() != 0) {
                    return false;
                }
                zVarA = z.a();
                str = "Exclude regular ads.";
            }
        } else {
            zVarA = z.a();
            str = "Show func disable.";
        }
        zVarA.i("AttrDataManager", str);
        return true;
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "Object.hashCode()" because "this.second" is null
    	at jadx.core.utils.Pair.hashCode(Pair.java:35)
    	at java.base/java.util.HashMap.hash(HashMap.java:338)
    	at java.base/java.util.HashMap.getNode(HashMap.java:576)
    	at java.base/java.util.HashMap.containsKey(HashMap.java:602)
    	at jadx.core.dex.visitors.finaly.traverser.state.TraverserGlobalCommonState.hasBlocksBeenCached(TraverserGlobalCommonState.java:35)
    	at jadx.core.dex.visitors.finaly.traverser.handlers.MergePathActivePathTraverserHandler.handle(MergePathActivePathTraverserHandler.java:174)
    	at jadx.core.dex.visitors.finaly.traverser.handlers.AbstractActivePathTraverserHandler.process(AbstractActivePathTraverserHandler.java:19)
    	at jadx.core.dex.visitors.finaly.traverser.TraverserController.processHandlerImplementations(TraverserController.java:43)
    	at jadx.core.dex.visitors.finaly.traverser.TraverserController.advance(TraverserController.java:156)
    	at jadx.core.dex.visitors.finaly.traverser.TraverserController.process(TraverserController.java:79)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.findCommonInsns(MarkFinallyVisitor.java:404)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.extractFinally(MarkFinallyVisitor.java:284)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.processTryBlock(MarkFinallyVisitor.java:202)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:135)
     */
    public final void v() {
        z zVarA;
        StringBuilder sb2;
        SQLiteDatabase sQLiteDatabaseA = y.f30223a.a();
        if (sQLiteDatabaseA == null) {
            z.a().i("AttrDataManager", "Database connection is null");
            return;
        }
        try {
            try {
                sQLiteDatabaseA.beginTransaction();
                sQLiteDatabaseA.execSQL("DELETE FROM attr_click");
                sQLiteDatabaseA.setTransactionSuccessful();
                try {
                    sQLiteDatabaseA.endTransaction();
                } catch (Exception e11) {
                    e = e11;
                    zVarA = z.a();
                    sb2 = new StringBuilder();
                    sb2.append("clearClicks end transaction fail: ");
                    sb2.append(e.getMessage());
                    zVarA.e("AttrDataManager", sb2.toString());
                }
            } catch (Throwable th2) {
                try {
                    sQLiteDatabaseA.endTransaction();
                } catch (Exception e12) {
                    z.a().e("AttrDataManager", "clearClicks end transaction fail: " + e12.getMessage());
                }
                throw th2;
            }
        } catch (Exception e13) {
            z.a().e("AttrDataManager", "clearClicks fail " + Log.getStackTraceString(e13));
            try {
                sQLiteDatabaseA.endTransaction();
            } catch (Exception e14) {
                e = e14;
                zVarA = z.a();
                sb2 = new StringBuilder();
                sb2.append("clearClicks end transaction fail: ");
                sb2.append(e.getMessage());
                zVarA.e("AttrDataManager", sb2.toString());
            }
        }
    }

    public final void w(final AdsDTO adsDTO) {
        if (adsDTO == null) {
            z.a().i("AttrDataManager", "Ad is null.");
            return;
        }
        if (u(adsDTO, true)) {
            return;
        }
        if (z.b()) {
            z.a().i("AttrDataManager", "insertClick ad info : " + adsDTO);
        }
        com.cloud.sdk.commonutil.util.i.f30292a.b(new Runnable() { // from class: com.cloud.hisavana.sdk.r1
            @Override // java.lang.Runnable
            public final void run() {
                n.D(adsDTO);
            }
        });
    }
}
