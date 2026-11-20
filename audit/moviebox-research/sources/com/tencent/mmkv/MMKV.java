package com.tencent.mmkv;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import android.util.Log;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class MMKV implements SharedPreferences, SharedPreferences.Editor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EnumMap<MMKVRecoverStrategic, Integer> f49335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EnumMap<MMKVLogLevel, Integer> f49336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final MMKVLogLevel[] f49337c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set<Long> f49338d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f49339e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f49340f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final HashMap<String, Parcelable.Creator<?>> f49341g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f49342h;
    private final long nativeHandle;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f49343a;

        static {
            int[] iArr = new int[MMKVLogLevel.values().length];
            f49343a = iArr;
            try {
                iArr[MMKVLogLevel.LevelDebug.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f49343a[MMKVLogLevel.LevelWarning.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f49343a[MMKVLogLevel.LevelError.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f49343a[MMKVLogLevel.LevelNone.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f49343a[MMKVLogLevel.LevelInfo.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    public interface b {
        void a(String str);
    }

    static {
        EnumMap<MMKVRecoverStrategic, Integer> enumMap = new EnumMap<>(MMKVRecoverStrategic.class);
        f49335a = enumMap;
        enumMap.put(MMKVRecoverStrategic.OnErrorDiscard, 0);
        enumMap.put(MMKVRecoverStrategic.OnErrorRecover, 1);
        EnumMap<MMKVLogLevel, Integer> enumMap2 = new EnumMap<>(MMKVLogLevel.class);
        f49336b = enumMap2;
        MMKVLogLevel mMKVLogLevel = MMKVLogLevel.LevelDebug;
        enumMap2.put(mMKVLogLevel, 0);
        MMKVLogLevel mMKVLogLevel2 = MMKVLogLevel.LevelInfo;
        enumMap2.put(mMKVLogLevel2, 1);
        MMKVLogLevel mMKVLogLevel3 = MMKVLogLevel.LevelWarning;
        enumMap2.put(mMKVLogLevel3, 2);
        MMKVLogLevel mMKVLogLevel4 = MMKVLogLevel.LevelError;
        enumMap2.put(mMKVLogLevel4, 3);
        MMKVLogLevel mMKVLogLevel5 = MMKVLogLevel.LevelNone;
        enumMap2.put(mMKVLogLevel5, 4);
        f49337c = new MMKVLogLevel[]{mMKVLogLevel, mMKVLogLevel2, mMKVLogLevel3, mMKVLogLevel4, mMKVLogLevel5};
        f49338d = new HashSet();
        f49339e = null;
        f49340f = true;
        f49341g = new HashMap<>();
        f49342h = false;
    }

    public MMKV(long j11) {
        this.nativeHandle = j11;
    }

    public static MMKV A(String str, int i11) throws RuntimeException {
        if (f49339e != null) {
            return a(getMMKVWithID(str, i11, null, null), str, i11);
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    public static MMKV B(String str, int i11, @Nullable String str2) throws RuntimeException {
        if (f49339e != null) {
            return a(getMMKVWithID(str, i11, str2, null), str, i11);
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    public static MMKV C(String str, int i11, @Nullable String str2, String str3) throws RuntimeException {
        if (f49339e != null) {
            return a(getMMKVWithID(str, i11, str2, str3), str, i11);
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    public static void E(MMKVLogLevel mMKVLogLevel, String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StackTraceElement stackTraceElement = stackTrace[stackTrace.length - 1];
        Integer num = f49336b.get(mMKVLogLevel);
        mmkvLogImp(num == null ? 0 : num.intValue(), stackTraceElement.getFileName(), stackTraceElement.getLineNumber(), stackTraceElement.getMethodName(), str);
    }

    public static MMKV a(long j11, String str, int i11) throws RuntimeException {
        String str2;
        if (j11 == 0) {
            throw new RuntimeException("Fail to create an MMKV instance [" + str + "] in JNI");
        }
        if (!f49340f) {
            return new MMKV(j11);
        }
        Set<Long> set = f49338d;
        synchronized (set) {
            try {
                if (!set.contains(Long.valueOf(j11))) {
                    if (!checkProcessMode(j11)) {
                        if (i11 == 1) {
                            str2 = "Opening a multi-process MMKV instance [" + str + "] with SINGLE_PROCESS_MODE!";
                        } else {
                            str2 = ("Opening an MMKV instance [" + str + "] with MULTI_PROCESS_MODE, ") + "while it's already been opened with SINGLE_PROCESS_MODE by someone somewhere else!";
                        }
                        throw new IllegalArgumentException(str2);
                    }
                    set.add(Long.valueOf(j11));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return new MMKV(j11);
    }

    private native long actualSize(long j11);

    public static native long backupAllToDirectory(String str);

    public static native boolean backupOneToDirectory(String str, String str2, @Nullable String str3);

    private static native boolean checkProcessMode(long j11);

    private native boolean containsKey(long j11, String str);

    private native long count(long j11);

    private static native long createNB(int i11);

    private native boolean decodeBool(long j11, String str, boolean z11);

    @Nullable
    private native byte[] decodeBytes(long j11, String str);

    private native double decodeDouble(long j11, String str, double d11);

    private native float decodeFloat(long j11, String str, float f11);

    private native int decodeInt(long j11, String str, int i11);

    private native long decodeLong(long j11, String str, long j12);

    @Nullable
    private native String decodeString(long j11, String str, @Nullable String str2);

    @Nullable
    private native String[] decodeStringSet(long j11, String str);

    private static native void destroyNB(long j11, int i11);

    private native boolean encodeBool(long j11, String str, boolean z11);

    private native boolean encodeBytes(long j11, String str, @Nullable byte[] bArr);

    private native boolean encodeDouble(long j11, String str, double d11);

    private native boolean encodeFloat(long j11, String str, float f11);

    private native boolean encodeInt(long j11, String str, int i11);

    private native boolean encodeLong(long j11, String str, long j12);

    private native boolean encodeSet(long j11, String str, @Nullable String[] strArr);

    private native boolean encodeString(long j11, String str, @Nullable String str2);

    private static native long getDefaultMMKV(int i11, @Nullable String str);

    private static native long getMMKVWithAshmemFD(String str, int i11, int i12, @Nullable String str2);

    private static native long getMMKVWithID(String str, int i11, @Nullable String str2, @Nullable String str3);

    private static native long getMMKVWithIDAndSize(String str, int i11, int i12, @Nullable String str2);

    public static native boolean isFileValid(String str, @Nullable String str2);

    public static MMKV j() throws RuntimeException {
        if (f49339e != null) {
            return a(getDefaultMMKV(1, null), "DefaultMMKV", 1);
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    private static native void jniInitialize(String str, String str2, int i11);

    public static void k() {
        synchronized (f49338d) {
            f49340f = false;
        }
    }

    public static String l(String str, String str2, b bVar, MMKVLogLevel mMKVLogLevel) {
        if (bVar != null) {
            bVar.a("mmkv");
        } else {
            System.loadLibrary("mmkv");
        }
        jniInitialize(str, str2, w(mMKVLogLevel));
        f49339e = str;
        return str;
    }

    public static void m() {
        synchronized (f49338d) {
            f49340f = true;
        }
    }

    private static void mmkvLogImp(int i11, String str, int i12, String str2, String str3) {
        int i13 = a.f49343a[f49337c[i11].ordinal()];
        if (i13 == 2) {
            Log.w("MMKV", str3);
        } else {
            if (i13 != 3) {
                return;
            }
            Log.e("MMKV", str3);
        }
    }

    private static void onContentChangedByOuterProcess(String str) {
    }

    public static native void onExit();

    private static int onMMKVCRCCheckFail(String str) {
        MMKVRecoverStrategic mMKVRecoverStrategic = MMKVRecoverStrategic.OnErrorDiscard;
        E(MMKVLogLevel.LevelInfo, "Recover strategic for " + str + " is " + mMKVRecoverStrategic);
        Integer num = f49335a.get(mMKVRecoverStrategic);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    private static int onMMKVFileLengthError(String str) {
        MMKVRecoverStrategic mMKVRecoverStrategic = MMKVRecoverStrategic.OnErrorDiscard;
        E(MMKVLogLevel.LevelInfo, "Recover strategic for " + str + " is " + mMKVRecoverStrategic);
        Integer num = f49335a.get(mMKVRecoverStrategic);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static native int pageSize();

    private native void removeValueForKey(long j11, String str);

    public static native long restoreAllFromDirectory(String str);

    public static native boolean restoreOneMMKVFromDirectory(String str, String str2, @Nullable String str3);

    private static native void setCallbackHandler(boolean z11, boolean z12);

    private static native void setLogLevel(int i11);

    private static native void setWantsContentChangeNotify(boolean z11);

    private native void sync(boolean z11);

    public static String t(Context context) {
        return v(context, context.getFilesDir().getAbsolutePath() + "/mmkv", null, MMKVLogLevel.LevelInfo);
    }

    private native long totalSize(long j11);

    public static String u(Context context, String str) {
        return v(context, str, null, MMKVLogLevel.LevelInfo);
    }

    public static String v(Context context, String str, b bVar, MMKVLogLevel mMKVLogLevel) {
        if ((context.getApplicationInfo().flags & 2) == 0) {
            k();
        } else {
            m();
        }
        return l(str, context.getCacheDir().getAbsolutePath(), bVar, mMKVLogLevel);
    }

    private native int valueSize(long j11, String str, boolean z11);

    public static native String version();

    public static int w(MMKVLogLevel mMKVLogLevel) {
        int i11 = a.f49343a[mMKVLogLevel.ordinal()];
        if (i11 == 1) {
            return 0;
        }
        if (i11 == 2) {
            return 2;
        }
        if (i11 != 3) {
            return i11 != 4 ? 1 : 4;
        }
        return 3;
    }

    private native int writeValueToNB(long j11, String str, long j12, int i11);

    public static MMKV x(String str, int i11, int i12, String str2) throws RuntimeException {
        long mMKVWithAshmemFD = getMMKVWithAshmemFD(str, i11, i12, str2);
        if (mMKVWithAshmemFD != 0) {
            return new MMKV(mMKVWithAshmemFD);
        }
        throw new RuntimeException("Fail to create an ashmem MMKV instance [" + str + "] in JNI");
    }

    public static MMKV y(Context context, String str, int i11, int i12, @Nullable String str2) throws RuntimeException {
        MMKV mmkv;
        if (f49339e == null) {
            throw new IllegalStateException("You should Call MMKV.initialize() first.");
        }
        String strB = MMKVContentProvider.b(context, Process.myPid());
        if (strB == null || strB.length() == 0) {
            E(MMKVLogLevel.LevelError, "process name detect fail, try again later");
            throw new IllegalStateException("process name detect fail, try again later");
        }
        if (strB.contains(":")) {
            Uri uriA = MMKVContentProvider.a(context);
            if (uriA == null) {
                E(MMKVLogLevel.LevelError, "MMKVContentProvider has invalid authority");
                throw new IllegalStateException("MMKVContentProvider has invalid authority");
            }
            MMKVLogLevel mMKVLogLevel = MMKVLogLevel.LevelInfo;
            E(mMKVLogLevel, "getting parcelable mmkv in process, Uri = " + uriA);
            Bundle bundle = new Bundle();
            bundle.putInt("KEY_SIZE", i11);
            bundle.putInt("KEY_MODE", i12);
            if (str2 != null) {
                bundle.putString("KEY_CRYPT", str2);
            }
            Bundle bundleCall = context.getContentResolver().call(uriA, "mmkvFromAshmemID", str, bundle);
            if (bundleCall != null) {
                bundleCall.setClassLoader(ParcelableMMKV.class.getClassLoader());
                ParcelableMMKV parcelableMMKV = (ParcelableMMKV) bundleCall.getParcelable("KEY");
                if (parcelableMMKV != null && (mmkv = parcelableMMKV.toMMKV()) != null) {
                    E(mMKVLogLevel, mmkv.mmapID() + " fd = " + mmkv.ashmemFD() + ", meta fd = " + mmkv.ashmemMetaFD());
                    return mmkv;
                }
            }
        }
        E(MMKVLogLevel.LevelInfo, "getting mmkv in main process");
        long mMKVWithIDAndSize = getMMKVWithIDAndSize(str, i11, i12 | 8, str2);
        if (mMKVWithIDAndSize != 0) {
            return new MMKV(mMKVWithIDAndSize);
        }
        throw new IllegalStateException("Fail to create an Ashmem MMKV instance [" + str + "]");
    }

    public static MMKV z(String str) throws RuntimeException {
        if (f49339e != null) {
            return a(getMMKVWithID(str, 1, null, null), str, 1);
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    public void D(String str) {
        removeValueForKey(this.nativeHandle, str);
    }

    @Nullable
    public native String[] allKeys();

    @Override // android.content.SharedPreferences.Editor
    @Deprecated
    public void apply() {
        sync(false);
    }

    public native int ashmemFD();

    public native int ashmemMetaFD();

    public boolean b(String str) {
        return containsKey(this.nativeHandle, str);
    }

    public boolean c(String str, boolean z11) {
        return decodeBool(this.nativeHandle, str, z11);
    }

    public native void checkContentChangedByOuterProcess();

    public native void checkReSetCryptKey(@Nullable String str);

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        clearAll();
        return this;
    }

    public native void clearAll();

    public native void clearMemoryCache();

    public native void close();

    @Override // android.content.SharedPreferences.Editor
    @Deprecated
    public boolean commit() {
        sync(true);
        return true;
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return b(str);
    }

    @Nullable
    public native String cryptKey();

    public int d(String str, int i11) {
        return decodeInt(this.nativeHandle, str, i11);
    }

    public long e(String str, long j11) {
        return decodeLong(this.nativeHandle, str, j11);
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this;
    }

    @Nullable
    public String f(String str) {
        return decodeString(this.nativeHandle, str, null);
    }

    @Nullable
    public String g(String str, @Nullable String str2) {
        return decodeString(this.nativeHandle, str, str2);
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        throw new UnsupportedOperationException("Intentionally Not Supported. Use allKeys() instead, getAll() not implement because type-erasure inside mmkv");
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z11) {
        return decodeBool(this.nativeHandle, str, z11);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f11) {
        return decodeFloat(this.nativeHandle, str, f11);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i11) {
        return decodeInt(this.nativeHandle, str, i11);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j11) {
        return decodeLong(this.nativeHandle, str, j11);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public String getString(String str, @Nullable String str2) {
        return decodeString(this.nativeHandle, str, str2);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        return h(str, set);
    }

    @Nullable
    public Set<String> h(String str, @Nullable Set<String> set) {
        return i(str, set, HashSet.class);
    }

    @Nullable
    public Set<String> i(String str, @Nullable Set<String> set, Class<? extends Set> cls) {
        String[] strArrDecodeStringSet = decodeStringSet(this.nativeHandle, str);
        if (strArrDecodeStringSet == null) {
            return set;
        }
        try {
            Set<String> setNewInstance = cls.newInstance();
            setNewInstance.addAll(Arrays.asList(strArrDecodeStringSet));
            return setNewInstance;
        } catch (IllegalAccessException | InstantiationException unused) {
            return set;
        }
    }

    public native void lock();

    public native String mmapID();

    public boolean n(String str, int i11) {
        return encodeInt(this.nativeHandle, str, i11);
    }

    public boolean o(String str, long j11) {
        return encodeLong(this.nativeHandle, str, j11);
    }

    public boolean p(String str, @Nullable String str2) {
        return encodeString(this.nativeHandle, str, str2);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z11) {
        encodeBool(this.nativeHandle, str, z11);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f11) {
        encodeFloat(this.nativeHandle, str, f11);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i11) {
        encodeInt(this.nativeHandle, str, i11);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j11) {
        encodeLong(this.nativeHandle, str, j11);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, @Nullable String str2) {
        encodeString(this.nativeHandle, str, str2);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putStringSet(String str, @Nullable Set<String> set) {
        q(str, set);
        return this;
    }

    public boolean q(String str, @Nullable Set<String> set) {
        return encodeSet(this.nativeHandle, str, set == null ? null : (String[]) set.toArray(new String[0]));
    }

    public boolean r(String str, boolean z11) {
        return encodeBool(this.nativeHandle, str, z11);
    }

    public native boolean reKey(@Nullable String str);

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        throw new UnsupportedOperationException("Intentionally Not implement in MMKV");
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        D(str);
        return this;
    }

    public native void removeValuesForKeys(String[] strArr);

    public int s(String str) {
        return valueSize(this.nativeHandle, str, true);
    }

    public native void trim();

    public native boolean tryLock();

    public native void unlock();

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        throw new UnsupportedOperationException("Intentionally Not implement in MMKV");
    }
}
