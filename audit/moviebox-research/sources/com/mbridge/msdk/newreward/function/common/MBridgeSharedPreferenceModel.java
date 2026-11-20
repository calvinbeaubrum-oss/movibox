package com.mbridge.msdk.newreward.function.common;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.same.b.c;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.tools.FastKV;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class MBridgeSharedPreferenceModel {
    private static final String DEFAULT_NAME = "mbridge_new_config";
    private volatile FastKV mFastKV;
    private Object mLock = new Object();
    private String mName;
    private static ConcurrentHashMap<String, String> mStringCache = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, Integer> mIntegerCache = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, Long> mLongCache = new ConcurrentHashMap<>();
    private static Map<String, MBridgeSharedPreferenceModel> mInstanceMap = new HashMap();
    private static String mPath = e.a(c.MBRIDGE_700_CONFIG) + File.separator;
    private static Executor mExecutor = Executors.newSingleThreadExecutor();

    private MBridgeSharedPreferenceModel(String str) {
        this.mName = str;
        mExecutor.execute(new Runnable() { // from class: com.mbridge.msdk.newreward.function.common.MBridgeSharedPreferenceModel.1
            @Override // java.lang.Runnable
            public void run() {
                MBridgeSharedPreferenceModel.this.initFastKV();
            }
        });
    }

    public static MBridgeSharedPreferenceModel getInstance() {
        return getInstance("");
    }

    public static MBridgeSharedPreferenceModel getInstance(String str) {
        MBridgeSharedPreferenceModel mBridgeSharedPreferenceModel;
        synchronized (mInstanceMap) {
            try {
                if (TextUtils.isEmpty(str)) {
                    str = DEFAULT_NAME;
                }
                mBridgeSharedPreferenceModel = mInstanceMap.get(str);
                if (mBridgeSharedPreferenceModel == null) {
                    mBridgeSharedPreferenceModel = new MBridgeSharedPreferenceModel(str);
                    mInstanceMap.put(str, mBridgeSharedPreferenceModel);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return mBridgeSharedPreferenceModel;
    }

    private int getIntegerValue(String str, int i11) {
        if (this.mFastKV == null) {
            initFastKV();
        }
        try {
            int i12 = this.mFastKV.getInt(str, i11);
            mIntegerCache.put(str, Integer.valueOf(i12));
            return i12;
        } catch (Exception unused) {
            return i11;
        }
    }

    private long getLongValue(String str, long j11) {
        if (this.mFastKV == null) {
            initFastKV();
        }
        try {
            long j12 = this.mFastKV.getLong(str, j11);
            mLongCache.put(str, Long.valueOf(j12));
            return j12;
        } catch (Exception unused) {
            return j11;
        }
    }

    private String getStringValue(String str, String str2) {
        if (this.mFastKV == null) {
            initFastKV();
        }
        String string = this.mFastKV.getString(str, str2);
        if (string != null) {
            mStringCache.put(str, string);
        }
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initFastKV() {
        synchronized (this.mLock) {
            if (this.mFastKV == null) {
                try {
                    this.mFastKV = new FastKV.Builder(mPath, this.mName).build();
                } catch (Exception unused) {
                }
            }
        }
    }

    private void putIntegerValue(String str, int i11) {
        try {
            mIntegerCache.put(str, Integer.valueOf(i11));
        } catch (Exception unused) {
        }
        try {
            this.mFastKV.putInt(str, i11);
        } catch (Exception unused2) {
        }
    }

    private void putLongValue(String str, long j11) {
        try {
            mLongCache.put(str, Long.valueOf(j11));
        } catch (Exception unused) {
        }
        try {
            this.mFastKV.putLong(str, j11);
        } catch (Exception unused2) {
        }
    }

    private void putStringValue(final String str, final String str2) {
        try {
            mStringCache.put(str, str2);
        } catch (Exception unused) {
        }
        mExecutor.execute(new Runnable() { // from class: com.mbridge.msdk.newreward.function.common.MBridgeSharedPreferenceModel.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    MBridgeSharedPreferenceModel.this.initFastKV();
                    MBridgeSharedPreferenceModel.this.mFastKV.putString(str, str2);
                } catch (Exception unused2) {
                }
            }
        });
    }

    public final void clear() {
        mStringCache.clear();
        mIntegerCache.clear();
        mLongCache.clear();
        if (this.mFastKV != null) {
            this.mFastKV.clear();
        }
    }

    public final int getInteger(String str, int i11) {
        Integer num;
        if (TextUtils.isEmpty(str)) {
            return i11;
        }
        return (!mIntegerCache.containsKey(str) || (num = mIntegerCache.get(str)) == null) ? getIntegerValue(str, i11) : num.intValue();
    }

    public final long getLong(String str, long j11) {
        Long l11;
        if (TextUtils.isEmpty(str)) {
            return j11;
        }
        return (!mLongCache.containsKey(str) || (l11 = mLongCache.get(str)) == null) ? getLongValue(str, j11) : l11.longValue();
    }

    public final String getString(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        return mStringCache.containsKey(str) ? mStringCache.get(str) : getStringValue(str, str2);
    }

    public final void init() {
    }

    public final void putInteger(String str, int i11) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!mIntegerCache.containsKey(str)) {
            putIntegerValue(str, i11);
            return;
        }
        Integer num = mIntegerCache.get(str);
        if (num == null || num.intValue() != i11) {
            putIntegerValue(str, i11);
        }
    }

    public final void putLong(String str, long j11) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!mLongCache.containsKey(str)) {
            putLongValue(str, j11);
            return;
        }
        Long l11 = mLongCache.get(str);
        if (l11 == null || l11.longValue() != j11) {
            putLongValue(str, j11);
        }
    }

    public final void putString(String str, String str2) {
        if (TextUtils.isEmpty(str) || str2 == null) {
            return;
        }
        if (!mStringCache.containsKey(str)) {
            putStringValue(str, str2);
        } else {
            if (TextUtils.equals(mStringCache.get(str), str2)) {
                return;
            }
            putStringValue(str, str2);
        }
    }
}
