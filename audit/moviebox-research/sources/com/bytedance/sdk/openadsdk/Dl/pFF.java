package com.bytedance.sdk.openadsdk.Dl;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class pFF {
    private final Context pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private SharedPreferences f27066sc;
    private final String zY;

    public pFF(Context context, String str) {
        this.pFF = context;
        this.zY = str;
    }

    private SharedPreferences pFF() {
        Context context;
        SharedPreferences sharedPreferences = this.f27066sc;
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        if (TextUtils.isEmpty(this.zY) || (context = this.pFF) == null) {
            return null;
        }
        try {
            this.f27066sc = context.getSharedPreferences(this.zY, 0);
        } catch (Throwable th2) {
            Log.e("SPUnit", th2.getMessage());
        }
        return this.f27066sc;
    }

    public long pFF(String str, long j11) {
        try {
            SharedPreferences sharedPreferencesPFF = pFF();
            if (sharedPreferencesPFF != null && sharedPreferencesPFF.contains(str)) {
                return sharedPreferencesPFF.getLong(str, j11);
            }
            return j11;
        } catch (Throwable th2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.zY);
            sb2.append(th2.getMessage());
            return j11;
        }
    }

    public int sc(String str, int i11) {
        try {
            SharedPreferences sharedPreferencesPFF = pFF();
            if (sharedPreferencesPFF != null && sharedPreferencesPFF.contains(str)) {
                return sharedPreferencesPFF.getInt(str, i11);
            }
            return i11;
        } catch (Throwable th2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.zY);
            sb2.append(th2.getMessage());
            return i11;
        }
    }

    public String sc(String str, String str2) {
        try {
            SharedPreferences sharedPreferencesPFF = pFF();
            if (sharedPreferencesPFF != null && sharedPreferencesPFF.contains(str)) {
                return sharedPreferencesPFF.getString(str, str2);
            }
            return str2;
        } catch (Throwable th2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.zY);
            sb2.append(th2.getMessage());
            return str2;
        }
    }

    public void sc() {
        SharedPreferences sharedPreferencesPFF = pFF();
        if (sharedPreferencesPFF != null) {
            SharedPreferences.Editor editorEdit = sharedPreferencesPFF.edit();
            editorEdit.clear();
            editorEdit.commit();
        }
    }

    public void sc(String str, long j11) {
        try {
            SharedPreferences sharedPreferencesPFF = pFF();
            if (sharedPreferencesPFF != null) {
                SharedPreferences.Editor editorEdit = sharedPreferencesPFF.edit();
                editorEdit.putLong(str, j11);
                editorEdit.apply();
            }
        } catch (Throwable th2) {
            Log.e("SPUnit", th2.getMessage());
        }
    }

    public void sc(JSONObject jSONObject) {
        try {
            SharedPreferences sharedPreferencesPFF = pFF();
            if (sharedPreferencesPFF != null) {
                SharedPreferences.Editor editorEdit = sharedPreferencesPFF.edit();
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    try {
                        if (!TextUtils.isEmpty(next)) {
                            Object obj = jSONObject.get(next);
                            if (obj instanceof Integer) {
                                editorEdit.putInt(next, ((Integer) obj).intValue());
                            } else if (obj instanceof Long) {
                                editorEdit.putLong(next, ((Long) obj).longValue());
                            } else if (obj instanceof String) {
                                editorEdit.putString(next, (String) obj);
                            } else if (obj instanceof Boolean) {
                                editorEdit.putBoolean(next, ((Boolean) obj).booleanValue());
                            } else if (obj instanceof Float) {
                                editorEdit.putFloat(next, ((Float) obj).floatValue());
                            } else if (obj instanceof Double) {
                                editorEdit.putFloat(next, Double.valueOf(((Double) obj).doubleValue()).floatValue());
                            }
                        }
                    } catch (Throwable th2) {
                        Log.e("SPUnit", th2.getMessage());
                    }
                }
                editorEdit.apply();
            }
        } catch (Throwable th3) {
            Log.e("SPUnit", th3.getMessage());
        }
    }

    public boolean sc(String str, boolean z11) {
        try {
            SharedPreferences sharedPreferencesPFF = pFF();
            if (sharedPreferencesPFF != null && sharedPreferencesPFF.contains(str)) {
                return sharedPreferencesPFF.getBoolean(str, z11);
            }
            return z11;
        } catch (Throwable th2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.zY);
            sb2.append(th2.getMessage());
            return z11;
        }
    }
}
