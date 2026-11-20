package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.ads.zzbgc;
import com.google.android.gms.internal.ads.zzcec;
import com.google.android.gms.internal.ads.zzfue;
import com.google.android.gms.internal.ads.zzfuf;
import com.google.android.gms.internal.ads.zzfwp;
import com.google.android.gms.internal.ads.zzfxr;
import java.io.IOException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class zzad {
    public static Bundle zza(Context context, String str, SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        if (TextUtils.isEmpty(str)) {
            return Bundle.EMPTY;
        }
        PreferenceManager.getDefaultSharedPreferences(context).registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        return zzb(context, str);
    }

    @NonNull
    public static Bundle zzb(Context context, String str) {
        JSONArray jSONArray;
        int i11;
        Object obj;
        SharedPreferences sharedPreferences;
        String str2;
        if (TextUtils.isEmpty(str)) {
            jSONArray = null;
        } else {
            try {
                jSONArray = new JSONArray(str);
            } catch (JSONException e11) {
                zzcec.zzf("JSON parsing error", e11);
                jSONArray = null;
            }
        }
        if (jSONArray == null) {
            return Bundle.EMPTY;
        }
        Bundle bundle = new Bundle();
        for (int i12 = 0; i12 < jSONArray.length(); i12++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i12);
            String strOptString = jSONObjectOptJSONObject.optString("bk");
            String strOptString2 = jSONObjectOptJSONObject.optString("sk");
            int iOptInt = jSONObjectOptJSONObject.optInt("type", -1);
            if (iOptInt == 0) {
                i11 = 1;
            } else if (iOptInt != 1) {
                i11 = iOptInt != 2 ? 0 : 3;
            } else {
                i11 = 2;
            }
            if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2) && i11 != 0) {
                List listZzf = zzfxr.zzc(zzfwp.zzc('/')).zzf(strOptString2);
                if (listZzf.size() > 2 || listZzf.isEmpty()) {
                    obj = null;
                } else {
                    if (listZzf.size() == 1) {
                        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
                        str2 = (String) listZzf.get(0);
                    } else {
                        sharedPreferences = context.getSharedPreferences((String) listZzf.get(0), 0);
                        str2 = (String) listZzf.get(1);
                    }
                    obj = sharedPreferences.getAll().get(str2);
                }
                if (obj != null) {
                    int i13 = i11 - 1;
                    if (i13 != 0) {
                        if (i13 != 1) {
                            if (obj instanceof Boolean) {
                                bundle.putBoolean(strOptString, ((Boolean) obj).booleanValue());
                            }
                        } else if (obj instanceof Integer) {
                            bundle.putInt(strOptString, ((Integer) obj).intValue());
                        } else if (obj instanceof Long) {
                            bundle.putLong(strOptString, ((Long) obj).longValue());
                        } else if (obj instanceof Float) {
                            bundle.putFloat(strOptString, ((Float) obj).floatValue());
                        }
                    } else if (obj instanceof String) {
                        bundle.putString(strOptString, (String) obj);
                    }
                }
            }
        }
        return bundle;
    }

    public static void zzc(Context context) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgj)).booleanValue() && context != null) {
            context.deleteDatabase("OfflineUpload.db");
        }
        try {
            zzfue zzfueVarZzj = zzfue.zzj(context);
            zzfuf zzfufVarZzi = zzfuf.zzi(context);
            zzfueVarZzj.zzk();
            zzfueVarZzj.zzl();
            zzfufVarZzi.zzj();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcP)).booleanValue()) {
                zzfufVarZzi.zzk();
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcQ)).booleanValue()) {
                zzfufVarZzi.zzl();
            }
        } catch (IOException e11) {
            com.google.android.gms.ads.internal.zzt.zzo().zzw(e11, "clearStorageOnIdlessMode");
        }
    }
}
