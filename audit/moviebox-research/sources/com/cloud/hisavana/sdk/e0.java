package com.cloud.hisavana.sdk;

import android.database.Cursor;
import com.applovin.sdk.AppLovinEventParameters;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.bean.PslinkInfo;
import com.cloud.hisavana.sdk.data.bean.inapp.DefaultAdDTO;
import com.cloud.hisavana.sdk.data.bean.inapp.PsAppInfo;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.text.StringsKt__StringsKt;

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
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e0 f29658a = new e0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, CopyOnWriteArrayList<DefaultAdDTO>> f29659b = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static AtomicBoolean f29660c = new AtomicBoolean(false);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends Lambda implements Function1<String, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List<String> f29661a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(List<String> list) {
            super(1);
            this.f29661a = list;
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(String it) {
            Intrinsics.g(it, "it");
            return Boolean.valueOf(!this.f29661a.contains(it));
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends Lambda implements Function1<DefaultAdDTO, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f29662a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str) {
            super(1);
            this.f29662a = str;
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(DefaultAdDTO defaultAdDTO) {
            return Boolean.valueOf(Intrinsics.b(defaultAdDTO.getAdCreativeId(), this.f29662a));
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends Lambda implements Function1<DefaultAdDTO, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f29663a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(int i11) {
            super(1);
            this.f29663a = i11;
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(DefaultAdDTO defaultAdDTO) {
            return Boolean.valueOf(defaultAdDTO.getAdRequestVersion() >= this.f29663a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d extends Lambda implements Function1<DefaultAdDTO, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f29664a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f29665b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str, int i11) {
            super(1);
            this.f29664a = str;
            this.f29665b = i11;
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(DefaultAdDTO defaultAdDTO) {
            return Boolean.valueOf(Intrinsics.b(defaultAdDTO.getCodeSeatId(), this.f29664a) && defaultAdDTO.getAdRequestVersion() < this.f29665b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class e extends Lambda implements Function2<Cursor, Boolean, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f29666a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Function0<Unit> function0) {
            super(2);
            this.f29666a = function0;
        }

        public static final void b(Function0 function0) {
            if (function0 != null) {
                function0.invoke();
            }
        }

        public final void a(Cursor cursor, boolean z11) {
            String string;
            String string2;
            String string3;
            String string4;
            String string5;
            String string6;
            String string7;
            String string8;
            String string9;
            String string10;
            Object objPutIfAbsent;
            String string11;
            e0.f29659b.clear();
            if (!z11) {
                e0.f29660c.set(false);
                return;
            }
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    DefaultAdDTO defaultAdDTO = new DefaultAdDTO();
                    int columnIndex = cursor.getColumnIndex("ad_creative_id");
                    String str = "";
                    if (columnIndex < 0 || (string = cursor.getString(columnIndex)) == null) {
                        string = "";
                    } else {
                        Intrinsics.f(string, "it.getString(index) ?: \"\"");
                    }
                    defaultAdDTO.setAdCreativeId(string);
                    int columnIndex2 = cursor.getColumnIndex("codeSeatId");
                    if (columnIndex2 < 0 || (string2 = cursor.getString(columnIndex2)) == null) {
                        string2 = "";
                    } else {
                        Intrinsics.f(string2, "it.getString(index) ?: \"\"");
                    }
                    defaultAdDTO.setCodeSeatId(string2);
                    int columnIndex3 = cursor.getColumnIndex("ad_type");
                    defaultAdDTO.setAdType(Integer.valueOf(columnIndex3 >= 0 ? cursor.getInt(columnIndex3) : 0));
                    int columnIndex4 = cursor.getColumnIndex(BidResponsed.KEY_PRICE);
                    defaultAdDTO.setFirstPrice(Double.valueOf(columnIndex4 >= 0 ? cursor.getDouble(columnIndex4) : 0.0d));
                    int columnIndex5 = cursor.getColumnIndex("ad_request_ver");
                    defaultAdDTO.setAdRequestVersion(Integer.valueOf(columnIndex5 >= 0 ? cursor.getInt(columnIndex5) : 0).intValue());
                    int columnIndex6 = cursor.getColumnIndex("displayed_times");
                    defaultAdDTO.setDisplayedTimes(Integer.valueOf(columnIndex6 >= 0 ? cursor.getInt(columnIndex6) : 0).intValue());
                    int columnIndex7 = cursor.getColumnIndex("displayed_date");
                    if (columnIndex7 < 0 || (string3 = cursor.getString(columnIndex7)) == null) {
                        string3 = "";
                    } else {
                        Intrinsics.f(string3, "it.getString(index) ?: \"\"");
                    }
                    defaultAdDTO.setDisplayedDate(string3);
                    int columnIndex8 = cursor.getColumnIndex(AppLovinEventParameters.RESERVATION_START_TIMESTAMP);
                    if (columnIndex8 < 0 || (string4 = cursor.getString(columnIndex8)) == null) {
                        string4 = "";
                    } else {
                        Intrinsics.f(string4, "it.getString(index) ?: \"\"");
                    }
                    defaultAdDTO.setStartDate(string4);
                    int columnIndex9 = cursor.getColumnIndex(AppLovinEventParameters.RESERVATION_END_TIMESTAMP);
                    if (columnIndex9 < 0 || (string5 = cursor.getString(columnIndex9)) == null) {
                        string5 = "";
                    } else {
                        Intrinsics.f(string5, "it.getString(index) ?: \"\"");
                    }
                    defaultAdDTO.setEndDate(string5);
                    int columnIndex10 = cursor.getColumnIndex("display_max_times");
                    defaultAdDTO.setShowMaxOfDay(Integer.valueOf(columnIndex10 >= 0 ? cursor.getInt(columnIndex10) : 0).intValue());
                    int columnIndex11 = cursor.getColumnIndex("file_path");
                    if (columnIndex11 < 0 || (string6 = cursor.getString(columnIndex11)) == null) {
                        string6 = "";
                    } else {
                        Intrinsics.f(string6, "it.getString(index) ?: \"\"");
                    }
                    defaultAdDTO.setFilePath(string6);
                    int columnIndex12 = cursor.getColumnIndex("default_country_white");
                    if (columnIndex12 < 0 || (string7 = cursor.getString(columnIndex12)) == null) {
                        string7 = "";
                    } else {
                        Intrinsics.f(string7, "it.getString(index) ?: \"\"");
                    }
                    defaultAdDTO.setCountryWhite(string7);
                    int columnIndex13 = cursor.getColumnIndex("default_country_black");
                    if (columnIndex13 < 0 || (string8 = cursor.getString(columnIndex13)) == null) {
                        string8 = "";
                    } else {
                        Intrinsics.f(string8, "it.getString(index) ?: \"\"");
                    }
                    defaultAdDTO.setCountryBlack(string8);
                    int columnIndex14 = cursor.getColumnIndex("default_brand_white");
                    if (columnIndex14 < 0 || (string9 = cursor.getString(columnIndex14)) == null) {
                        string9 = "";
                    } else {
                        Intrinsics.f(string9, "it.getString(index) ?: \"\"");
                    }
                    defaultAdDTO.setBrandWhite(string9);
                    int columnIndex15 = cursor.getColumnIndex("default_brand_black");
                    if (columnIndex15 < 0 || (string10 = cursor.getString(columnIndex15)) == null) {
                        string10 = "";
                    } else {
                        Intrinsics.f(string10, "it.getString(index) ?: \"\"");
                    }
                    defaultAdDTO.setBrandBlack(string10);
                    int columnIndex16 = cursor.getColumnIndex("ad_bean");
                    if (columnIndex16 >= 0 && (string11 = cursor.getString(columnIndex16)) != null) {
                        Intrinsics.f(string11, "it.getString(index) ?: \"\"");
                        str = string11;
                    }
                    defaultAdDTO.setAdBeanJson(str);
                    ConcurrentHashMap concurrentHashMap = e0.f29659b;
                    String codeSeatId = defaultAdDTO.getCodeSeatId();
                    Object copyOnWriteArrayList = concurrentHashMap.get(codeSeatId);
                    if (copyOnWriteArrayList == null && (objPutIfAbsent = concurrentHashMap.putIfAbsent(codeSeatId, (copyOnWriteArrayList = new CopyOnWriteArrayList()))) != null) {
                        copyOnWriteArrayList = objPutIfAbsent;
                    }
                    ((CopyOnWriteArrayList) copyOnWriteArrayList).add(defaultAdDTO);
                }
            }
            e0.f29660c.set(true);
            com.cloud.sdk.commonutil.util.i iVar = com.cloud.sdk.commonutil.util.i.f30292a;
            final Function0<Unit> function0 = this.f29666a;
            iVar.e(new Runnable() { // from class: com.cloud.hisavana.sdk.i0
                @Override // java.lang.Runnable
                public final void run() {
                    e0.e.b(function0);
                }
            });
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Cursor cursor, Boolean bool) {
            a(cursor, bool.booleanValue());
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class f extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f29667a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a0.a f29668b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f29669c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f29670d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f29671e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f29672f;

        /* JADX INFO: compiled from: source.java */
        @Metadata
        @SourceDebugExtension
        public static final class a<T> implements Comparator {
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t11, T t12) {
                return kotlin.comparisons.b.d(((DefaultAdDTO) t12).getFirstPrice(), ((DefaultAdDTO) t11).getFirstPrice());
            }
        }

        /* JADX INFO: compiled from: source.java */
        @Metadata
        @SourceDebugExtension
        public static final class b<T> implements Comparator {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Comparator f29673a;

            public b(Comparator comparator) {
                this.f29673a = comparator;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t11, T t12) {
                int iCompare = this.f29673a.compare(t11, t12);
                if (iCompare != 0) {
                    return iCompare;
                }
                return Random.Default.nextBoolean() ? 1 : -1;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, a0.a aVar, int i11, int i12, boolean z11, int i13) {
            super(0);
            this.f29667a = str;
            this.f29668b = aVar;
            this.f29669c = i11;
            this.f29670d = i12;
            this.f29671e = z11;
            this.f29672f = i13;
        }

        public final void a() {
            String str;
            a0.a aVar;
            String string;
            Object objA;
            Pair pair;
            k1 k1Var = new k1();
            ArrayList arrayList = new ArrayList();
            CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) e0.f29659b.get(this.f29667a);
            List listM0 = copyOnWriteArrayList != null ? CollectionsKt___CollectionsKt.M0(copyOnWriteArrayList) : null;
            String str2 = "defaultAdStatus.toString()";
            if (listM0 != null && !listM0.isEmpty()) {
                int i11 = this.f29669c;
                String str3 = this.f29667a;
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : listM0) {
                    DefaultAdDTO defaultAdDTO = (DefaultAdDTO) obj;
                    if (defaultAdDTO.getAdType() == i11 && Intrinsics.b(defaultAdDTO.getCodeSeatId(), str3)) {
                        String filePath = defaultAdDTO.getFilePath();
                        Intrinsics.f(filePath, "it.filePath");
                        if (filePath.length() > 0) {
                            arrayList2.add(obj);
                        }
                    }
                }
                List listE0 = CollectionsKt___CollectionsKt.E0(arrayList2, new b(new a()));
                if (listE0.isEmpty()) {
                    aVar = this.f29668b;
                    string = k1Var.toString();
                    Intrinsics.f(string, "defaultAdStatus.toString()");
                } else {
                    ArrayList<Pair> arrayList3 = new ArrayList();
                    String strJ = da.a.d().j("ad_internal_black_brands", "itel,tecno,oraimo,infinix");
                    String strD = b0.f29174a.d();
                    int i12 = this.f29670d;
                    String str4 = this.f29667a;
                    boolean z11 = this.f29671e;
                    int i13 = this.f29672f;
                    Iterator it = listE0.iterator();
                    int i14 = 0;
                    while (it.hasNext()) {
                        DefaultAdDTO it2 = (DefaultAdDTO) it.next();
                        try {
                            objA = GsonUtil.a(it2.getAdBeanJson(), AdsDTO.class);
                        } catch (Exception e11) {
                            z.a().w("DefaultDBManager", "parse ad error: " + e11.getMessage());
                            objA = null;
                        }
                        if (objA != null) {
                            if (i12 != 1 || ((AdsDTO) objA).getDefaultAdSupportNetType() == 0) {
                                b0 b0Var = b0.f29174a;
                                Intrinsics.f(it2, "it");
                                AdsDTO adsDTO = (AdsDTO) objA;
                                int iB = b0Var.b(strD, it2, adsDTO.getPackageName(), null);
                                if (iB > 0) {
                                    k1Var.put(it2.getAdCreativeId(), Integer.valueOf(iB));
                                    if (iB != 2 && iB != 3 && iB != 10) {
                                        pair = new Pair(it2.getAdCreativeId(), str4);
                                        arrayList3.add(pair);
                                    }
                                } else if (new File(it2.getFilePath()).exists()) {
                                    boolean zG = b0Var.g(adsDTO.getCampaignname(), strJ);
                                    if (z11 && zG) {
                                        k1Var.put(it2.getAdCreativeId(), 10);
                                    } else if (i14 < i13) {
                                        adsDTO.setMatchVulgarBrand(zG);
                                        adsDTO.setSource(4);
                                        adsDTO.setUuid(w9.a.f79345a.e(adsDTO, i12));
                                        PslinkInfo pslinkInfo = adsDTO.getPslinkInfo();
                                        if (pslinkInfo != null) {
                                            Intrinsics.f(pslinkInfo, "pslinkInfo");
                                            pslinkInfo.setShowId(adsDTO.getUuid());
                                        }
                                        arrayList.add(objA);
                                        i14++;
                                    }
                                } else {
                                    k1Var.put(it2.getAdCreativeId(), 4);
                                    if (adsDTO.isFromLocal()) {
                                        pair = new Pair(it2.getAdCreativeId(), str4);
                                        arrayList3.add(pair);
                                    }
                                }
                            } else {
                                k1Var.put(it2.getAdCreativeId(), 13);
                            }
                        }
                        it = it;
                        str2 = str2;
                    }
                    String str5 = str2;
                    if (!arrayList3.isEmpty()) {
                        for (Pair pair2 : arrayList3) {
                            e0.f29658a.j((String) pair2.getFirst(), (String) pair2.getSecond());
                        }
                    }
                    aVar = this.f29668b;
                    string = k1Var.toString();
                    str = str5;
                }
                aVar.a(arrayList, string);
            }
            str = "defaultAdStatus.toString()";
            aVar = this.f29668b;
            string = k1Var.toString();
            Intrinsics.f(string, str);
            aVar.a(arrayList, string);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class g extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List<PsAppInfo> f29674a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<DefaultAdDTO> f29675b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f29676c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f29677d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public g(List<? extends PsAppInfo> list, List<? extends DefaultAdDTO> list2, long j11, boolean z11) {
            super(0);
            this.f29674a = list;
            this.f29675b = list2;
            this.f29676c = j11;
            this.f29677d = z11;
        }

        public final void a() {
            Object next;
            String appInfo;
            String packageName;
            try {
                List<PsAppInfo> list = this.f29674a;
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    PsAppInfo psAppInfo = (PsAppInfo) obj;
                    if (psAppInfo != null && (packageName = psAppInfo.getPackageName()) != null && packageName.length() != 0) {
                        arrayList.add(obj);
                    }
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.a.d(kotlin.collections.r.e(kotlin.collections.h.v(arrayList, 10)), 16));
                Iterator it = arrayList.iterator();
                while (true) {
                    String str = "";
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next2 = it.next();
                    PsAppInfo psAppInfo2 = (PsAppInfo) next2;
                    String packageName2 = psAppInfo2 != null ? psAppInfo2.getPackageName() : null;
                    if (packageName2 != null) {
                        Intrinsics.f(packageName2, "it?.packageName ?: \"\"");
                        str = packageName2;
                    }
                    linkedHashMap.put(str, next2);
                }
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                String strD = b0.f29174a.d();
                Collection collectionValues = e0.f29659b.values();
                Intrinsics.f(collectionValues, "defaultDataCacheMap.values");
                Iterator it2 = kotlin.collections.h.w(collectionValues).iterator();
                if (it2.hasNext()) {
                    next = it2.next();
                    if (it2.hasNext()) {
                        int adRequestVersion = ((DefaultAdDTO) next).getAdRequestVersion();
                        do {
                            Object next3 = it2.next();
                            int adRequestVersion2 = ((DefaultAdDTO) next3).getAdRequestVersion();
                            if (adRequestVersion < adRequestVersion2) {
                                next = next3;
                                adRequestVersion = adRequestVersion2;
                            }
                        } while (it2.hasNext());
                    }
                } else {
                    next = null;
                }
                DefaultAdDTO defaultAdDTO = (DefaultAdDTO) next;
                int adRequestVersion3 = (defaultAdDTO != null ? defaultAdDTO.getAdRequestVersion() : 0) + 1;
                List<DefaultAdDTO> list2 = this.f29675b;
                boolean z11 = this.f29677d;
                for (DefaultAdDTO defaultAdDTO2 : list2) {
                    String packageName3 = defaultAdDTO2.getPackageName();
                    PsAppInfo psAppInfo3 = (packageName3 == null || packageName3.length() == 0) ? null : (PsAppInfo) linkedHashMap.get(defaultAdDTO2.getPackageName());
                    b0 b0Var = b0.f29174a;
                    int iB = b0Var.b(strD, defaultAdDTO2, defaultAdDTO2.getPackageName(), psAppInfo3);
                    if (iB <= 0 || iB == 2 || iB == 3) {
                        if (psAppInfo3 != null && (appInfo = psAppInfo3.getAppInfo()) != null) {
                            Intrinsics.f(appInfo, "appInfo");
                            defaultAdDTO2.setAppInfo(appInfo);
                        }
                        AdsDTO adsDTOC = b0Var.c(defaultAdDTO2, z11);
                        adsDTOC.setFromLocal(z11);
                        defaultAdDTO2.setAdBeanJson(GsonUtil.d(adsDTOC));
                        defaultAdDTO2.setFilePath(z11 ? b0Var.j(adsDTOC) : "");
                        defaultAdDTO2.setAdRequestVersion(adRequestVersion3);
                        e0.f29658a.e(defaultAdDTO2);
                        c0.f29205a.j(defaultAdDTO2);
                    } else {
                        arrayList2.add(Integer.valueOf(iB));
                        arrayList3.add(defaultAdDTO2.getAdCreativeId());
                        e0 e0Var = e0.f29658a;
                        String adCreativeId = defaultAdDTO2.getAdCreativeId();
                        Intrinsics.f(adCreativeId, "it.adCreativeId");
                        String codeSeatId = defaultAdDTO2.getCodeSeatId();
                        Intrinsics.f(codeSeatId, "it.codeSeatId");
                        e0Var.j(adCreativeId, codeSeatId);
                    }
                }
                da.a.d().o("default_local_version", this.f29676c);
                if ((!arrayList2.isEmpty()) && (!arrayList3.isEmpty())) {
                    AthenaTracker.y("", "", "", arrayList3, arrayList2, false, 3);
                }
                if (this.f29677d) {
                    e0.f29658a.c(adRequestVersion3);
                }
            } catch (Exception e11) {
                z.a().w("DefaultDBManager", "save default ad error: " + e11.getMessage());
            }
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.f68710a;
        }
    }

    public static final void r(Function0 function0) {
        if (!f29660c.get()) {
            c0.f29205a.p(new e(function0));
        } else if (function0 != null) {
            function0.invoke();
        }
    }

    public final void c(int i11) {
        Iterator<Map.Entry<String, CopyOnWriteArrayList<DefaultAdDTO>>> it = f29659b.entrySet().iterator();
        while (it.hasNext()) {
            kotlin.collections.k.M(it.next().getValue(), new c(i11));
        }
        c0.f29205a.h(i11);
    }

    public final void d(int i11, String codeSeatId, int i12, boolean z11, int i13, a0.a defaultAdResultListener) {
        Intrinsics.g(codeSeatId, "codeSeatId");
        Intrinsics.g(defaultAdResultListener, "defaultAdResultListener");
        z.a().d("DefaultDBManager", "take local default ad, code seat id is " + codeSeatId);
        n(new f(codeSeatId, defaultAdResultListener, i11, i13, z11, i12));
    }

    public final void e(DefaultAdDTO defaultAdDTO) {
        CopyOnWriteArrayList<DefaultAdDTO> copyOnWriteArrayListPutIfAbsent;
        ConcurrentHashMap<String, CopyOnWriteArrayList<DefaultAdDTO>> concurrentHashMap = f29659b;
        String codeSeatId = defaultAdDTO.getCodeSeatId();
        CopyOnWriteArrayList<DefaultAdDTO> copyOnWriteArrayList = concurrentHashMap.get(codeSeatId);
        if (copyOnWriteArrayList == null && (copyOnWriteArrayListPutIfAbsent = concurrentHashMap.putIfAbsent(codeSeatId, (copyOnWriteArrayList = new CopyOnWriteArrayList<>()))) != null) {
            copyOnWriteArrayList = copyOnWriteArrayListPutIfAbsent;
        }
        CopyOnWriteArrayList<DefaultAdDTO> list = copyOnWriteArrayList;
        Intrinsics.f(list, "list");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            DefaultAdDTO defaultAdDTO2 = (DefaultAdDTO) obj;
            if (Intrinsics.b(defaultAdDTO2.getCodeSeatId(), defaultAdDTO.getCodeSeatId()) && Intrinsics.b(defaultAdDTO2.getAdCreativeId(), defaultAdDTO.getAdCreativeId())) {
                arrayList.add(obj);
            }
        }
        if (!arrayList.isEmpty()) {
            list.removeAll(CollectionsKt___CollectionsKt.O0(arrayList));
            DefaultAdDTO defaultAdDTO3 = (DefaultAdDTO) CollectionsKt___CollectionsKt.e0(arrayList);
            defaultAdDTO.setDisplayedDate(defaultAdDTO3.getDisplayedDate());
            defaultAdDTO.setDisplayedTimes(defaultAdDTO3.getDisplayedTimes());
        }
        list.add(defaultAdDTO);
    }

    public final void i(String codeSeatId) {
        Intrinsics.g(codeSeatId, "codeSeatId");
        CopyOnWriteArrayList<DefaultAdDTO> copyOnWriteArrayList = f29659b.get(codeSeatId);
        if (copyOnWriteArrayList != null && (!copyOnWriteArrayList.isEmpty())) {
            Iterator<T> it = copyOnWriteArrayList.iterator();
            if (!it.hasNext()) {
                throw new NoSuchElementException();
            }
            int adRequestVersion = ((DefaultAdDTO) it.next()).getAdRequestVersion();
            while (it.hasNext()) {
                int adRequestVersion2 = ((DefaultAdDTO) it.next()).getAdRequestVersion();
                if (adRequestVersion < adRequestVersion2) {
                    adRequestVersion = adRequestVersion2;
                }
            }
            kotlin.collections.k.G(copyOnWriteArrayList, new d(codeSeatId, adRequestVersion));
        }
        c0.f29205a.k(codeSeatId);
    }

    public final void j(String str, String str2) {
        CopyOnWriteArrayList<DefaultAdDTO> copyOnWriteArrayList = f29659b.get(str2);
        if (copyOnWriteArrayList != null) {
            kotlin.collections.k.G(copyOnWriteArrayList, new b(str));
        }
        c0.f29205a.l(str, str2);
    }

    public final void k(String adCreativeId, String codeSeatId, String filepath) {
        Intrinsics.g(adCreativeId, "adCreativeId");
        Intrinsics.g(codeSeatId, "codeSeatId");
        Intrinsics.g(filepath, "filepath");
        CopyOnWriteArrayList<DefaultAdDTO> copyOnWriteArrayList = f29659b.get(codeSeatId);
        if (copyOnWriteArrayList != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : copyOnWriteArrayList) {
                if (Intrinsics.b(((DefaultAdDTO) obj).getAdCreativeId(), adCreativeId)) {
                    arrayList.add(obj);
                }
            }
            if (!arrayList.isEmpty()) {
                ((DefaultAdDTO) CollectionsKt___CollectionsKt.e0(arrayList)).setFilePath(filepath);
            }
        }
        c0.f29205a.n(adCreativeId, codeSeatId, filepath);
    }

    public final void l(List<String> codeSeatIds) {
        Intrinsics.g(codeSeatIds, "codeSeatIds");
        Set<String> setKeySet = f29659b.keySet();
        Intrinsics.f(setKeySet, "defaultDataCacheMap.keys");
        kotlin.collections.k.F(setKeySet, new a(codeSeatIds));
        c0.f29205a.o(codeSeatIds);
    }

    public final void m(List<? extends DefaultAdDTO> defaultAdList, List<? extends PsAppInfo> psAppInfoList, boolean z11, long j11) {
        Intrinsics.g(defaultAdList, "defaultAdList");
        Intrinsics.g(psAppInfoList, "psAppInfoList");
        if (defaultAdList.isEmpty()) {
            return;
        }
        n(new g(psAppInfoList, defaultAdList, j11, z11));
    }

    public final void n(final Function0<Unit> function0) {
        com.cloud.sdk.commonutil.util.i.f30292a.e(new Runnable() { // from class: com.cloud.hisavana.sdk.g0
            @Override // java.lang.Runnable
            public final void run() {
                e0.r(function0);
            }
        });
    }

    public final String o(String codeSeatId) {
        Intrinsics.g(codeSeatId, "codeSeatId");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        CopyOnWriteArrayList<DefaultAdDTO> copyOnWriteArrayList = f29659b.get(codeSeatId);
        if (copyOnWriteArrayList != null) {
            for (DefaultAdDTO defaultAdDTO : copyOnWriteArrayList) {
                String adBeanJson = defaultAdDTO.getAdBeanJson();
                Intrinsics.f(adBeanJson, "it.adBeanJson");
                if (adBeanJson.length() > 0) {
                    sb2.append(defaultAdDTO.getAdBeanJson() + ',');
                }
            }
        }
        if (sb2.length() > 1) {
            sb2.deleteCharAt(StringsKt__StringsKt.X(sb2));
            sb2.append("]");
        } else {
            kotlin.text.h.i(sb2);
        }
        String string = sb2.toString();
        Intrinsics.f(string, "adJson.toString()");
        return string;
    }

    public final void q(String adCreativeId, String codeSeatId) {
        Intrinsics.g(adCreativeId, "adCreativeId");
        Intrinsics.g(codeSeatId, "codeSeatId");
        CopyOnWriteArrayList<DefaultAdDTO> copyOnWriteArrayList = f29659b.get(codeSeatId);
        if (copyOnWriteArrayList != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : copyOnWriteArrayList) {
                if (Intrinsics.b(((DefaultAdDTO) obj).getAdCreativeId(), adCreativeId)) {
                    arrayList.add(obj);
                }
            }
            if (!arrayList.isEmpty()) {
                DefaultAdDTO defaultAdDTO = (DefaultAdDTO) CollectionsKt___CollectionsKt.e0(arrayList);
                String strD = b0.f29174a.d();
                String displayedDate = defaultAdDTO.getDisplayedDate();
                if (displayedDate == null || displayedDate.length() == 0 || Intrinsics.b(defaultAdDTO.getDisplayedDate(), strD)) {
                    defaultAdDTO.setDisplayedTimes(defaultAdDTO.getDisplayedTimes() + 1);
                } else {
                    defaultAdDTO.setDisplayedTimes(1);
                }
                defaultAdDTO.setDisplayedDate(strD);
                c0 c0Var = c0.f29205a;
                int displayedTimes = defaultAdDTO.getDisplayedTimes();
                String displayedDate2 = defaultAdDTO.getDisplayedDate();
                Intrinsics.f(displayedDate2, "displayedDate");
                c0Var.m(adCreativeId, codeSeatId, displayedTimes, displayedDate2);
            }
        }
    }

    public final List<String> s() {
        Enumeration<String> enumerationKeys = f29659b.keys();
        Intrinsics.f(enumerationKeys, "defaultDataCacheMap.keys()");
        ArrayList list = Collections.list(enumerationKeys);
        Intrinsics.f(list, "list(...)");
        return CollectionsKt___CollectionsKt.M0(list);
    }

    public final void t(String filePath) {
        Intrinsics.g(filePath, "filePath");
        Iterator<Map.Entry<String, CopyOnWriteArrayList<DefaultAdDTO>>> it = f29659b.entrySet().iterator();
        while (it.hasNext()) {
            CopyOnWriteArrayList<DefaultAdDTO> value = it.next().getValue();
            ArrayList arrayList = new ArrayList();
            for (Object obj : value) {
                String filePath2 = ((DefaultAdDTO) obj).getFilePath();
                Intrinsics.f(filePath2, "it.filePath");
                if (kotlin.text.l.u(filePath2, filePath + ".0", false, 2, null)) {
                    arrayList.add(obj);
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ((DefaultAdDTO) it2.next()).setFilePath("");
            }
        }
        c0.f29205a.v(filePath);
    }
}
