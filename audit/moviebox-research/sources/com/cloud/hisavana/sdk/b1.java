package com.cloud.hisavana.sdk;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.cloud.hisavana.sdk.api.config.AdManager;
import com.cloud.hisavana.sdk.common.bean.PslinkInfo;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.data.bean.response.ConfigCodeSeatDTO;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import com.google.gson.reflect.TypeToken;
import com.hisavana.common.constant.ComConstants;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f29175a;

    /* JADX INFO: compiled from: source.java */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdsDTO f29176a;

        public a(AdsDTO adsDTO) {
            this.f29176a = adsDTO;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.cloud.sdk.commonutil.util.f.a().getContentResolver().delete(b1.this.f29175a, "delete from adList where codeSeatId = '" + this.f29176a.getCodeSeatId() + "' AND ad_creative_id = '" + this.f29176a.getAdCreativeId() + "';", null);
            } catch (Exception e11) {
                z.a().e("OfflineProviderManager", "deleteOnlineShowAd error: " + e11.getMessage());
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f29178a;

        public b(List list) {
            this.f29178a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            AdsDTO adsDTO = (AdsDTO) this.f29178a.get(0);
            for (AdsDTO adsDTO2 : this.f29178a) {
                if (adsDTO2.isOfflineAd() && w9.c.e(adsDTO2, true)) {
                    b1.this.o(adsDTO2);
                    break;
                }
            }
            if (adsDTO != null) {
                try {
                    if (adsDTO.getSource() != 1 || adsDTO.isOfflineAd()) {
                        return;
                    }
                    b1.this.j(adsDTO.getCodeSeatId());
                    b1.this.m(this.f29178a);
                } catch (Exception e11) {
                    z.a().e("OfflineProviderManager", "insertLoadedAd deleteOnLineAdByConfigId error: " + e11.getMessage());
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends TypeToken<List<AdsDTO>> {
        public c() {
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdsDTO f29181a;

        public d(AdsDTO adsDTO) {
            this.f29181a = adsDTO;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                AdsDTO adsDTO = this.f29181a;
                if (adsDTO != null) {
                    int adRequestVer = adsDTO.getAdRequestVer();
                    String codeSeatId = this.f29181a.getCodeSeatId();
                    if (adRequestVer > 0) {
                        com.cloud.sdk.commonutil.util.f.a().getContentResolver().delete(b1.this.f29175a, "delete from adList where codeSeatId = '" + codeSeatId + "' and ad_request_ver < " + adRequestVer + " and " + TrackingKey.IS_OFFLINE_AD + " =1", null);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f29183a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f29184b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ i f29185c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f29186d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ List f29187e;

        public e(String str, int i11, i iVar, boolean z11, List list) {
            this.f29183a = str;
            this.f29184b = i11;
            this.f29185c = iVar;
            this.f29186d = z11;
            this.f29187e = list;
        }

        /* JADX WARN: Code duplicated, block: B:47:0x010a  */
        /* JADX WARN: Code duplicated, block: B:48:0x010c  */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // java.lang.Runnable
        public void run() {
            String adCreativeId;
            int iC;
            z.a().d("OfflineProviderManager", "getAdByCodeSeatId " + this.f29183a + " adCount " + this.f29184b);
            if (TextUtils.isEmpty(this.f29183a)) {
                return;
            }
            k1 k1Var = new k1();
            ArrayList arrayList = new ArrayList();
            try {
                ConfigCodeSeatDTO configCodeSeatDTOC = x.h().c(this.f29183a);
                if (configCodeSeatDTOC == null) {
                    i iVar = this.f29185c;
                    if (iVar != null) {
                        iVar.a(arrayList, k1Var.isEmpty() ? "" : k1Var.toString());
                        return;
                    }
                    return;
                }
                List<AdsDTO> listD = b1.this.d(this.f29183a, this.f29186d, this.f29187e);
                if (listD != null && !listD.isEmpty()) {
                    int size = listD.size();
                    ArrayList arrayList2 = new ArrayList();
                    int i11 = 0;
                    for (int i12 = 0; i12 < size; i12++) {
                        AdsDTO adsDTO = listD.get(i12);
                        if (adsDTO != null) {
                            if (w9.c.b(adsDTO)) {
                                arrayList2.add(String.valueOf(adsDTO.getTableId()));
                                k1Var.put(adsDTO.getAdCreativeId(), 1);
                            } else {
                                int iA = w9.s.a(adsDTO.getPullNewestLive().intValue(), adsDTO.getPsPackageName(), adsDTO.getPackageName());
                                if (iA == 1) {
                                    arrayList2.add(String.valueOf(adsDTO.getTableId()));
                                    adCreativeId = adsDTO.getAdCreativeId();
                                    if (iA == 1) {
                                        iC = 5;
                                    } else {
                                        iC = 6;
                                    }
                                    k1Var.put(adCreativeId, Integer.valueOf(iC));
                                } else if (iA == 2) {
                                    arrayList2.add(String.valueOf(adsDTO.getTableId()));
                                    adCreativeId = adsDTO.getAdCreativeId();
                                    if (iA == 1) {
                                        iC = 5;
                                    } else {
                                        iC = 6;
                                    }
                                    k1Var.put(adCreativeId, Integer.valueOf(iC));
                                } else if (i11 < this.f29184b) {
                                    iC = w9.c.c(adsDTO, this.f29186d);
                                    if (iC == 0) {
                                        adsDTO.setSource(adsDTO.isOfflineAd() ? 3 : 2);
                                        adsDTO.setUuid(w9.a.f79345a.e(adsDTO, this.f29186d ? 1 : 0));
                                        arrayList.add(adsDTO);
                                        i11++;
                                        b1.this.r(adsDTO);
                                    } else {
                                        adCreativeId = adsDTO.getAdCreativeId();
                                        k1Var.put(adCreativeId, Integer.valueOf(iC));
                                    }
                                }
                            }
                        }
                    }
                    ContentResolver contentResolver = com.cloud.sdk.commonutil.util.f.a().getContentResolver();
                    if (!arrayList2.isEmpty()) {
                        contentResolver.delete(b1.this.f29175a, null, (String[]) arrayList2.toArray(new String[0]));
                    }
                    if (AdManager.h()) {
                        z.a().d("OfflineProviderManager", "getAdByCodeSeatId  " + arrayList);
                    }
                    x.h().i(configCodeSeatDTOC);
                }
                i iVar2 = this.f29185c;
                if (iVar2 != null) {
                    iVar2.a(arrayList, k1Var.isEmpty() ? "" : k1Var.toString());
                }
            } catch (Exception e11) {
                z.a().e("OfflineProviderManager", Log.getStackTraceString(e11));
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f29189a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f29190b;

        public f(String str, boolean z11) {
            this.f29189a = str;
            this.f29190b = z11;
        }

        @Override // java.lang.Runnable
        public void run() {
            List<AdsDTO> listD;
            try {
                if (x.h().c(this.f29189a) == null || (listD = b1.this.d(this.f29189a, this.f29190b, null)) == null || listD.isEmpty()) {
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                for (int i11 = 0; i11 < listD.size(); i11++) {
                    AdsDTO adsDTO = listD.get(i11);
                    if (adsDTO != null) {
                        int iC = w9.c.c(adsDTO, true);
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(String.format(com.cloud.sdk.commonutil.util.f.a().getString(R$string.ssp_log_msg2), adsDTO.getAdCreativeId() + "", Boolean.valueOf(adsDTO.isOfflineAd()), Integer.valueOf(adsDTO.getAdRequestVer()), Integer.valueOf(iC), Integer.valueOf(adsDTO.getMaxShowCount()), adsDTO.getShowNum(), adsDTO.getFirstPrice().toString()));
                        sb3.append("\n");
                        sb2.append(sb3.toString());
                        z.a().d("OfflineProviderManager", "offline ad status is " + ((Object) sb2));
                    }
                }
                if (AdManager.h()) {
                    com.cloud.sdk.commonutil.util.r.b(sb2.toString(), 4);
                }
            } catch (Exception e11) {
                z.a().e("OfflineProviderManager", Log.getStackTraceString(e11));
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdsDTO f29192a;

        public g(AdsDTO adsDTO) {
            this.f29192a = adsDTO;
        }

        @Override // java.lang.Runnable
        public void run() {
            AdsDTO adsDTO = this.f29192a;
            if (adsDTO == null || adsDTO.getSource() == 1) {
                return;
            }
            z.a().d("OfflineProviderManager", "updateShowTimes getTableId " + this.f29192a.getTableId() + " showNum " + this.f29192a.getShowNum());
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f29192a);
            ContentValues contentValues = new ContentValues();
            contentValues.put("AdsData", GsonUtil.d(arrayList));
            try {
                com.cloud.sdk.commonutil.util.f.a().getContentResolver().update(b1.this.f29175a, contentValues, null, null);
            } catch (Exception e11) {
                z.a().e("OfflineProviderManager", "updateShowTimes " + Log.getStackTraceString(e11));
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f29194a;

        public h(String str) {
            this.f29194a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.cloud.sdk.commonutil.util.f.a().getContentResolver().delete(b1.this.f29175a, "delete from adList where codeSeatId = '" + this.f29194a + "' AND " + TrackingKey.IS_OFFLINE_AD + " = '0';", new String[0]);
            } catch (Exception e11) {
                z.a().e("OfflineProviderManager", Log.getStackTraceString(e11));
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface i {
        void a(List<AdsDTO> list, String str);
    }

    /* JADX INFO: compiled from: source.java */
    public static class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b1 f29196a = new b1(null);
    }

    public b1() {
        this.f29175a = Uri.parse("content://" + com.cloud.sdk.commonutil.util.f.a().getPackageName() + ".HisavanaContentProvider/ad_data");
    }

    public /* synthetic */ b1(a aVar) {
        this();
    }

    public static b1 c() {
        return j.f29196a;
    }

    public List<AdsDTO> d(String str, boolean z11, List<String> list) {
        return e(str, z11, list, false);
    }

    /* JADX WARN: Code duplicated, block: B:60:0x0194 A[Catch: all -> 0x0137, Exception -> 0x0188, TryCatch #2 {all -> 0x0137, blocks: (B:30:0x00f4, B:31:0x0103, B:33:0x0109, B:35:0x0117, B:38:0x0123, B:43:0x013e, B:45:0x0144, B:46:0x014c, B:48:0x0166, B:50:0x016c, B:52:0x0174, B:54:0x017a, B:57:0x018b, B:72:0x01e7, B:74:0x01f4, B:58:0x018e, B:60:0x0194, B:61:0x01a1, B:63:0x01a7, B:64:0x01b1, B:66:0x01cf), top: B:82:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x01a7 A[Catch: all -> 0x0137, Exception -> 0x0188, LOOP:2: B:61:0x01a1->B:63:0x01a7, LOOP_END, TryCatch #2 {all -> 0x0137, blocks: (B:30:0x00f4, B:31:0x0103, B:33:0x0109, B:35:0x0117, B:38:0x0123, B:43:0x013e, B:45:0x0144, B:46:0x014c, B:48:0x0166, B:50:0x016c, B:52:0x0174, B:54:0x017a, B:57:0x018b, B:72:0x01e7, B:74:0x01f4, B:58:0x018e, B:60:0x0194, B:61:0x01a1, B:63:0x01a7, B:64:0x01b1, B:66:0x01cf), top: B:82:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x01cf A[Catch: all -> 0x0137, Exception -> 0x0188, TRY_LEAVE, TryCatch #2 {all -> 0x0137, blocks: (B:30:0x00f4, B:31:0x0103, B:33:0x0109, B:35:0x0117, B:38:0x0123, B:43:0x013e, B:45:0x0144, B:46:0x014c, B:48:0x0166, B:50:0x016c, B:52:0x0174, B:54:0x017a, B:57:0x018b, B:72:0x01e7, B:74:0x01f4, B:58:0x018e, B:60:0x0194, B:61:0x01a1, B:63:0x01a7, B:64:0x01b1, B:66:0x01cf), top: B:82:0x00f4 }] */
    public List<AdsDTO> e(String str, boolean z11, List<String> list, boolean z12) throws Throwable {
        String strSubstring;
        Cursor cursorQuery;
        List<AdsDTO> list2;
        long jCurrentTimeMillis;
        ArrayList arrayList;
        Iterator<AdsDTO> it;
        Cursor cursor = null;
        list = null;
        List<AdsDTO> list3 = null;
        if (TextUtils.isEmpty(str)) {
            z.a().d("OfflineProviderManager", "getAdByCodeSeatId code seat id is null");
            return null;
        }
        ContentResolver contentResolver = com.cloud.sdk.commonutil.util.f.a().getContentResolver();
        if (list == null || list.size() <= 0) {
            strSubstring = null;
        } else {
            StringBuilder sb2 = new StringBuilder();
            for (String str2 : list) {
                sb2.append("'");
                sb2.append(str2);
                sb2.append("',");
            }
            strSubstring = sb2.substring(0, sb2.length() - 1);
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("SELECT * FROM ");
        sb3.append("adList");
        sb3.append(" WHERE ");
        sb3.append("codeSeatId");
        sb3.append(" = '");
        sb3.append(str);
        sb3.append("'");
        if (z11) {
            sb3.append(" AND ");
            sb3.append(TrackingKey.IS_OFFLINE_AD);
            sb3.append(" = 1");
        }
        if (z12) {
            sb3.append(" AND ");
            sb3.append("ad_request_ver");
            sb3.append(" = (SELECT MAX(");
            sb3.append("ad_request_ver");
            sb3.append(") FROM ");
            sb3.append("adList");
            sb3.append(" WHERE ");
            sb3.append("codeSeatId");
            sb3.append(" = '");
            sb3.append(str);
            sb3.append("')");
        }
        if (!TextUtils.isEmpty(strSubstring)) {
            sb3.append(" AND ");
            sb3.append("ad_creative_id");
            sb3.append(" NOT IN (");
            sb3.append(strSubstring);
            sb3.append(")");
        }
        sb3.append(" ORDER BY ");
        sb3.append(BidResponsed.KEY_PRICE);
        sb3.append(" DESC");
        try {
            cursorQuery = contentResolver.query(this.f29175a, null, sb3.toString(), null, null);
            if (cursorQuery == null) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return null;
            }
            try {
                try {
                    ArrayList arrayList2 = new ArrayList();
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("[");
                    while (cursorQuery.moveToNext()) {
                        int columnIndex = cursorQuery.getColumnIndex("ad_bean");
                        int columnIndex2 = cursorQuery.getColumnIndex("_id");
                        if (columnIndex >= 0) {
                            String string = cursorQuery.getString(columnIndex);
                            if (!TextUtils.isEmpty(string) && columnIndex2 >= 0) {
                                sb4.append(string);
                                sb4.append(",");
                                arrayList2.add(Integer.valueOf(cursorQuery.getInt(columnIndex2)));
                            }
                        }
                    }
                    if (sb4.length() > 1) {
                        sb4.deleteCharAt(sb4.length() - 1);
                    }
                    sb4.append("]");
                    list2 = (List) GsonUtil.b(sb4.toString(), new c().getType());
                    if (list2 != null) {
                        for (int i11 = 0; i11 < list2.size(); i11++) {
                            try {
                                AdsDTO adsDTO = list2.get(i11);
                                if (adsDTO != null && arrayList2.size() > i11) {
                                    adsDTO.setTableId(((Integer) arrayList2.get(i11)).intValue());
                                }
                            } catch (Exception e11) {
                                e = e11;
                                list3 = list2;
                                z.a().e("OfflineProviderManager", Log.getStackTraceString(e));
                                if (list3 != null) {
                                    list3.clear();
                                }
                                if (cursorQuery == null) {
                                    return list3;
                                }
                                list2 = list3;
                            }
                        }
                        if (!list2.isEmpty()) {
                            jCurrentTimeMillis = System.currentTimeMillis();
                            arrayList = new ArrayList();
                            it = list2.iterator();
                            while (it.hasNext()) {
                                i(it.next(), jCurrentTimeMillis, arrayList);
                            }
                            z.a().d("OfflineProviderManager", "getAdListByCodeSeatId updateList " + arrayList);
                            if (!arrayList.isEmpty()) {
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("AdsData", GsonUtil.d(arrayList));
                                contentResolver.update(this.f29175a, contentValues, null, null);
                            }
                        }
                    } else if (!list2.isEmpty()) {
                        jCurrentTimeMillis = System.currentTimeMillis();
                        arrayList = new ArrayList();
                        it = list2.iterator();
                        while (it.hasNext()) {
                            i(it.next(), jCurrentTimeMillis, arrayList);
                        }
                        z.a().d("OfflineProviderManager", "getAdListByCodeSeatId updateList " + arrayList);
                        if (!arrayList.isEmpty()) {
                            ContentValues contentValues2 = new ContentValues();
                            contentValues2.put("AdsData", GsonUtil.d(arrayList));
                            contentResolver.update(this.f29175a, contentValues2, null, null);
                        }
                    }
                } catch (Exception e12) {
                    e = e12;
                }
                cursorQuery.close();
                return list2;
            } catch (Throwable th2) {
                th = th2;
                cursor = cursorQuery;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Exception e13) {
            e = e13;
            cursorQuery = null;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public void h(AdsDTO adsDTO) {
        if (adsDTO == null) {
            return;
        }
        com.cloud.sdk.commonutil.util.i.f30292a.b(new a(adsDTO));
    }

    public final void i(AdsDTO adsDTO, long j11, List<AdsDTO> list) {
        if (adsDTO == null || list == null || j11 - adsDTO.getShowDate() < ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED) {
            return;
        }
        adsDTO.setShowDate(w9.y.c(j11));
        adsDTO.setShowNum(0);
        list.add(adsDTO);
    }

    public final void j(String str) {
        z.a().d("OfflineProviderManager", "deleteOnLineAdByConfigId codeSeatId = " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.cloud.sdk.commonutil.util.i.f30292a.b(new h(str));
    }

    public void k(String str, int i11, boolean z11, List<String> list, i iVar) {
        com.cloud.sdk.commonutil.util.i.f30292a.b(new e(str, i11, iVar, z11, list));
    }

    public void l(String str, boolean z11) {
        z.a().d("OfflineProviderManager", "getAdByCodeSeatId " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.cloud.sdk.commonutil.util.i.f30292a.b(new f(str, z11));
    }

    public void m(List<AdsDTO> list) {
        z.a().d("OfflineProviderManager", "insertAdsList");
        if (list == null || list.isEmpty()) {
            return;
        }
        final ArrayList arrayList = new ArrayList(list);
        try {
            final AdsDTO adsDTO = list.get(0);
            ListIterator listIterator = arrayList.listIterator();
            while (listIterator.hasNext()) {
                AdsDTO adsDTO2 = (AdsDTO) listIterator.next();
                if (w9.c.b(adsDTO2) || adsDTO2.isVastTypeAd() || !TextUtils.isEmpty(adsDTO2.getRtbAdm())) {
                    z.a().d("OfflineProviderManager", "current ad is not conform to insert db");
                    listIterator.remove();
                }
            }
            com.cloud.sdk.commonutil.util.i.f30292a.b(new Runnable() { // from class: com.cloud.hisavana.sdk.i
                @Override // java.lang.Runnable
                public final void run() {
                    this.f29788a.n(arrayList, adsDTO);
                }
            });
        } catch (Exception e11) {
            z.a().e("OfflineProviderManager", Log.getStackTraceString(e11));
        }
    }

    public final /* synthetic */ void n(List list, AdsDTO adsDTO) {
        try {
            ContentResolver contentResolver = com.cloud.sdk.commonutil.util.f.a().getContentResolver();
            ContentValues contentValues = new ContentValues();
            contentValues.put("AdsData", GsonUtil.d(list));
            contentResolver.insert(this.f29175a, contentValues);
            ConfigCodeSeatDTO configCodeSeatDTOC = x.h().c(adsDTO.getCodeSeatId());
            if (configCodeSeatDTOC != null) {
                x.h().i(configCodeSeatDTOC);
            }
        } catch (Exception e11) {
            z.a().e("OfflineProviderManager", "insert ad data error :" + e11.getMessage());
        }
    }

    public void o(AdsDTO adsDTO) {
        if (adsDTO == null) {
            return;
        }
        com.cloud.sdk.commonutil.util.i.f30292a.b(new d(adsDTO));
    }

    public void p(List<AdsDTO> list) {
        if (list == null || list.isEmpty()) {
            z.a().e("OfflineProviderManager", "insertLoadedAd adsDTOList is null or size is 0");
        } else {
            com.cloud.sdk.commonutil.util.i.f30292a.e(new b(new ArrayList(list)));
        }
    }

    public boolean q(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = com.cloud.sdk.commonutil.util.f.a().getContentResolver().query(this.f29175a, null, "SELECT * FROM adList WHERE file_path = '" + str + "'", null, null);
                if (cursorQuery == null) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return false;
                }
                boolean z11 = cursorQuery.getCount() > 0;
                cursorQuery.close();
                return z11;
            } catch (Exception e11) {
                z.a().e("OfflineProviderManager", Log.getStackTraceString(e11));
                if (0 != 0) {
                    cursor.close();
                }
                return false;
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                cursor.close();
            }
            throw th2;
        }
    }

    public final void r(AdsDTO adsDTO) {
        try {
            if (TextUtils.isEmpty(adsDTO.getAppInfo())) {
                return;
            }
            PslinkInfo pslinkInfo = adsDTO.getPslinkInfo();
            if (pslinkInfo != null) {
                pslinkInfo.setShowId(adsDTO.getUuid());
            }
            adsDTO.setPslinkInfo(pslinkInfo);
        } catch (Exception e11) {
            z.a().e("OfflineProviderManager", "update offline pslinkInfo err =" + Log.getStackTraceString(e11));
        }
    }

    public void s(AdsDTO adsDTO) {
        com.cloud.sdk.commonutil.util.i.f30292a.b(new g(adsDTO));
    }
}
