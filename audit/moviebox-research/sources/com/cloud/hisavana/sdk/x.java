package com.cloud.hisavana.sdk;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.data.bean.response.ConfigCodeSeatDTO;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import com.hisavana.common.constant.ComConstants;
import com.hisavana.common.tracking.TrackingKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f30190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, ConfigCodeSeatDTO> f30191b;

    /* JADX INFO: compiled from: source.java */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ContentValues f30192a;

        public a(ContentValues contentValues) {
            this.f30192a = contentValues;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                int iUpdate = com.cloud.sdk.commonutil.util.f.a().getContentResolver().update(x.this.f30190a, this.f30192a, null, null);
                z.a().d("CloudProviderManager", "updateConfigData result " + iUpdate);
            } catch (Exception e11) {
                z.a().d("CloudProviderManager", "updateConfigData " + Log.getStackTraceString(e11));
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ConfigCodeSeatDTO f30194a;

        public b(ConfigCodeSeatDTO configCodeSeatDTO) {
            this.f30194a = configCodeSeatDTO;
        }

        @Override // java.lang.Runnable
        public void run() {
            AdsDTO adsDTO;
            z.a().d("CloudProviderManager", "update config offline ad count------> code seat id:" + this.f30194a.getCodeSeatId());
            Cursor cursorQuery = null;
            try {
                cursorQuery = com.cloud.sdk.commonutil.util.f.a().getContentResolver().query(x.this.f30190a, null, "SELECT * FROM adList WHERE codeSeatId = '" + this.f30194a.getCodeSeatId() + "' AND " + TrackingKey.IS_OFFLINE_AD + " = 1 AND ad_request_ver = (SELECT MAX(ad_request_ver) FROM adList);", null, null);
                int i11 = 0;
                while (cursorQuery != null && cursorQuery.moveToNext()) {
                    int columnIndex = cursorQuery.getColumnIndex("ad_bean");
                    if (columnIndex >= 0) {
                        String string = cursorQuery.getString(columnIndex);
                        if (!TextUtils.isEmpty(string) && (adsDTO = (AdsDTO) GsonUtil.a(string, AdsDTO.class)) != null && !w9.c.b(adsDTO)) {
                            i11++;
                        }
                    }
                }
                z.a().d("CloudProviderManager", "getCodeOfflineAdCount ----> offline ad count is " + i11);
                this.f30194a.setLocalOfflineAdCacheCount(i11);
                if (cursorQuery == null) {
                }
            } catch (Throwable th2) {
                try {
                    z.a().e("CloudProviderManager", "getCodeOfflineAdCount " + Log.getStackTraceString(th2));
                } finally {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final x f30196a = new x(null);
    }

    public x() {
        this.f30191b = new ConcurrentHashMap();
        this.f30190a = Uri.parse("content://" + com.cloud.sdk.commonutil.util.f.a().getPackageName() + ".HisavanaContentProvider/config");
    }

    public /* synthetic */ x(w wVar) {
        this();
    }

    public static x h() {
        return c.f30196a;
    }

    public ConfigCodeSeatDTO b(ConfigCodeSeatDTO configCodeSeatDTO) {
        ConfigCodeSeatDTO configCodeSeatDTO2 = null;
        if (configCodeSeatDTO == null) {
            return null;
        }
        if (TextUtils.isEmpty(configCodeSeatDTO.getJson())) {
            return configCodeSeatDTO;
        }
        try {
            configCodeSeatDTO2 = (ConfigCodeSeatDTO) GsonUtil.a(configCodeSeatDTO.getJson(), ConfigCodeSeatDTO.class);
        } catch (GsonUtil.GsonParseException unused) {
            z.a().e("CloudProviderManager", "");
        }
        if (configCodeSeatDTO2 != null) {
            this.f30191b.put(configCodeSeatDTO.getCodeSeatId(), configCodeSeatDTO2);
        }
        return configCodeSeatDTO2;
    }

    public ConfigCodeSeatDTO c(String str) {
        z.a().d("CloudProviderManager", "getConfigById " + str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!l()) {
            d();
            Map<String, ConfigCodeSeatDTO> map = this.f30191b;
            if (map == null || map.isEmpty()) {
                return null;
            }
        }
        try {
            ConfigCodeSeatDTO configCodeSeatDTOB = b(this.f30191b.get(str));
            e(configCodeSeatDTOB, null);
            return configCodeSeatDTOB;
        } catch (Exception e11) {
            z.a().e("CloudProviderManager", "getConfigById " + Log.getStackTraceString(e11));
            return null;
        }
    }

    public Map<String, ConfigCodeSeatDTO> d() {
        if (!l()) {
            Cursor cursorQuery = null;
            try {
                try {
                    cursorQuery = com.cloud.sdk.commonutil.util.f.a().getContentResolver().query(this.f30190a, null, "select * from cloudList", null, null);
                    if (cursorQuery != null) {
                        while (cursorQuery.moveToNext()) {
                            int columnIndex = cursorQuery.getColumnIndex("code_seat_bean");
                            String string = columnIndex >= 0 ? cursorQuery.getString(columnIndex) : "";
                            if (!TextUtils.isEmpty(string)) {
                                ConfigCodeSeatDTO configCodeSeatDTO = new ConfigCodeSeatDTO();
                                configCodeSeatDTO.setJson(string);
                                int columnIndex2 = cursorQuery.getColumnIndex("codeSeatId");
                                if (columnIndex2 >= 0) {
                                    configCodeSeatDTO.setCodeSeatId(cursorQuery.getString(columnIndex2));
                                }
                                int columnIndex3 = cursorQuery.getColumnIndex("current_codeseat_show_times");
                                if (columnIndex3 >= 0) {
                                    configCodeSeatDTO.setCurrentShowTimes(cursorQuery.getInt(columnIndex3));
                                }
                                int columnIndex4 = cursorQuery.getColumnIndex("datetime");
                                if (columnIndex4 >= 0) {
                                    configCodeSeatDTO.setDate(cursorQuery.getString(columnIndex4));
                                }
                                this.f30191b.put(configCodeSeatDTO.getCodeSeatId(), configCodeSeatDTO);
                            }
                        }
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                } catch (Exception e11) {
                    z.a().e("CloudProviderManager", Log.getStackTraceString(e11));
                    if (cursorQuery != null) {
                    }
                }
            } catch (Throwable th2) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th2;
            }
        }
        z.a().d("CloudProviderManager", "getAllConfig " + this.f30191b.size());
        return this.f30191b;
    }

    public final void e(ConfigCodeSeatDTO configCodeSeatDTO, List<ConfigCodeSeatDTO> list) {
        if (configCodeSeatDTO == null) {
            return;
        }
        long j11 = Long.parseLong(configCodeSeatDTO.getDate());
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (Math.abs(jCurrentTimeMillis - j11) > ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED) {
            configCodeSeatDTO.setDate(String.valueOf(w9.y.c(jCurrentTimeMillis)));
            configCodeSeatDTO.setCurrentShowTimes(0);
            if (list != null) {
                list.add(configCodeSeatDTO);
            }
        }
    }

    public boolean f(List<ConfigCodeSeatDTO> list) {
        Map<String, ConfigCodeSeatDTO> map;
        if (list == null || list.isEmpty()) {
            return false;
        }
        if (this.f30191b.isEmpty()) {
            d();
        }
        try {
            Collection<ConfigCodeSeatDTO> collectionValues = this.f30191b.values();
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (collectionValues != null) {
                for (ConfigCodeSeatDTO configCodeSeatDTO : list) {
                    if (configCodeSeatDTO != null) {
                        for (ConfigCodeSeatDTO configCodeSeatDTO2 : collectionValues) {
                            if (configCodeSeatDTO2 != null && TextUtils.equals(configCodeSeatDTO.getCodeSeatId(), configCodeSeatDTO2.getCodeSeatId())) {
                                ConfigCodeSeatDTO configCodeSeatDTOB = b(configCodeSeatDTO2);
                                if (Math.abs(jCurrentTimeMillis - Long.parseLong(configCodeSeatDTOB.getDate())) >= ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED) {
                                    configCodeSeatDTO.setCurrentShowTimes(0);
                                    configCodeSeatDTO.setDate(String.valueOf(w9.y.c(jCurrentTimeMillis)));
                                } else {
                                    configCodeSeatDTO.setDate(configCodeSeatDTOB.getDate());
                                    configCodeSeatDTO.setCurrentShowTimes(configCodeSeatDTOB.getCurrentShowTimes());
                                }
                                configCodeSeatDTO.setLastRequestAdTime(configCodeSeatDTOB.getLastRequestAdTime());
                                configCodeSeatDTO.setAdRequestFail(configCodeSeatDTOB.isAdRequestFail());
                                configCodeSeatDTO.setLastShowAdTime(configCodeSeatDTOB.getLastShowAdTime());
                                configCodeSeatDTO.setAdRequestVer(configCodeSeatDTOB.getAdRequestVer());
                                configCodeSeatDTO.setLocalOfflineAdCacheCount(configCodeSeatDTOB.getLocalOfflineAdCacheCount());
                                break;
                            }
                        }
                    }
                }
                this.f30191b.clear();
            }
            for (ConfigCodeSeatDTO configCodeSeatDTO3 : list) {
                if (configCodeSeatDTO3 != null && (map = this.f30191b) != null) {
                    map.put(configCodeSeatDTO3.getCodeSeatId(), configCodeSeatDTO3);
                }
            }
            ContentResolver contentResolver = com.cloud.sdk.commonutil.util.f.a().getContentResolver();
            ContentValues contentValues = new ContentValues();
            contentValues.put("CloudConfig", GsonUtil.d(list));
            return contentResolver.insert(this.f30190a, contentValues).toString().contains("true");
        } catch (Exception e11) {
            z.a().e("CloudProviderManager", Log.getStackTraceString(e11));
            return false;
        }
    }

    public ConfigCodeSeatDTO g(String str) {
        return this.f30191b.get(str);
    }

    public void i(ConfigCodeSeatDTO configCodeSeatDTO) {
        if (configCodeSeatDTO == null) {
            return;
        }
        com.cloud.sdk.commonutil.util.i.f30292a.b(new b(configCodeSeatDTO));
    }

    public void j(ConfigCodeSeatDTO configCodeSeatDTO) {
        if (configCodeSeatDTO == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        ArrayList arrayList = new ArrayList();
        arrayList.add(configCodeSeatDTO);
        contentValues.put("CloudConfig", GsonUtil.d(arrayList));
        com.cloud.sdk.commonutil.util.i.f30292a.b(new a(contentValues));
    }

    public void k(String str) {
        z.a().d("CloudProviderManager", "updateConfigShowTimes ");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ConfigCodeSeatDTO configCodeSeatDTOG = g(str);
            if (configCodeSeatDTOG != null) {
                configCodeSeatDTOG.setCurrentShowTimes(configCodeSeatDTOG.getCurrentShowTimes() + 1);
                configCodeSeatDTOG.setLastShowAdTime(System.currentTimeMillis());
                j(configCodeSeatDTOG);
            } else {
                z.a().e("CloudProviderManager", "updateConfigShowTimes,can't find codeSeatId " + str);
            }
        } catch (Exception e11) {
            z.a().e("CloudProviderManager", "updateConfigShowTimes " + Log.getStackTraceString(e11));
        }
    }

    public boolean l() {
        Map<String, ConfigCodeSeatDTO> map = this.f30191b;
        return (map == null || map.isEmpty()) ? false : true;
    }
}
