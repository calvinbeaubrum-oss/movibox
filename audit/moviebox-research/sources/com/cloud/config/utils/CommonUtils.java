package com.cloud.config.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.LocaleList;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.l;

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
public final class CommonUtils {
    private static final int MAX_QUERY_GAID_COUNT = 5;
    public static final String PARAM_CONDITIONPARAMKEYS = "conditionParamKeys";
    public static final String PARAM_KEY = "cloudConfigKey";
    private static final String PARAM_MCC = "mcc";
    private static final String PARAM_OSVERSION = "osVersion";
    private static final String PARAM_PHONEBRAND = "phoneBrand";
    private static final String PARAM_PHONELANGUAGE = "phoneLanguage";
    private static final String PARAM_PHONEMODEL = "phoneModel";
    public static final String PARAM_SHUNTTYPE = "shuntType";
    public static final String PARAM_UID = "uid";
    private static final String PREF_GAID = "device_util_ga_id";
    public static final String SHUNT_OPEN_FLAG = "shuntopen";
    private static Context context;
    private static Locale locale;
    private static int queryGaidCount;
    public static final CommonUtils INSTANCE = new CommonUtils();
    private static String mcc = "";
    private static String brand = "";
    private static String model = "";
    private static String osVersion = "";
    private static String language = "";
    private static String mGaid = "";

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class AdvertisingIdClient {
        public static final AdvertisingIdClient INSTANCE = new AdvertisingIdClient();

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class AdInfo {

            /* JADX INFO: renamed from: id, reason: collision with root package name */
            private final String f28865id;
            private final boolean isLimitAdTrackingEnabled;

            public AdInfo(String str, boolean z11) {
                this.f28865id = str;
                this.isLimitAdTrackingEnabled = z11;
            }

            public final String getId() {
                return this.f28865id;
            }

            public final boolean isLimitAdTrackingEnabled() {
                return this.isLimitAdTrackingEnabled;
            }
        }

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class AdvertisingConnection implements ServiceConnection {
            private final LinkedBlockingQueue<IBinder> queue = new LinkedBlockingQueue<>(1);
            private boolean retrieved;

            public final IBinder getBinder() throws InterruptedException {
                if (this.retrieved) {
                    throw new IllegalStateException();
                }
                this.retrieved = true;
                return this.queue.take();
            }

            public final boolean getRetrieved() {
                return this.retrieved;
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName name, IBinder service) {
                Intrinsics.g(name, "name");
                Intrinsics.g(service, "service");
                try {
                    this.queue.put(service);
                } catch (Exception e11) {
                    XLogUtil log = XLogUtil.Companion.getLog();
                    String stackTraceString = Log.getStackTraceString(e11);
                    Intrinsics.f(stackTraceString, "getStackTraceString(var4)");
                    log.e(stackTraceString);
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName name) {
                Intrinsics.g(name, "name");
            }

            public final void setRetrieved(boolean z11) {
                this.retrieved = z11;
            }
        }

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class AdvertisingInterface implements IInterface {
            private final IBinder binder;

            public AdvertisingInterface(IBinder binder) {
                Intrinsics.g(binder, "binder");
                this.binder = binder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.binder;
            }

            public final String getId() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Intrinsics.f(parcelObtain, "obtain()");
                Parcel parcelObtain2 = Parcel.obtain();
                Intrinsics.f(parcelObtain2, "obtain()");
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    this.binder.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public final boolean isLimitAdTrackingEnabled(boolean z11) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Intrinsics.f(parcelObtain, "obtain()");
                Parcel parcelObtain2 = Parcel.obtain();
                Intrinsics.f(parcelObtain2, "obtain()");
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    parcelObtain.writeInt(z11 ? 1 : 0);
                    this.binder.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        private AdvertisingIdClient() {
        }

        public final AdInfo getAdvertisingIdInfo(Context context) throws Exception {
            Intrinsics.g(context, "context");
            if (Intrinsics.b(Looper.myLooper(), Looper.getMainLooper())) {
                throw new IllegalStateException("Cannot be called from the main thread");
            }
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            AdvertisingConnection advertisingConnection = new AdvertisingConnection();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                if (!context.bindService(intent, advertisingConnection, 1)) {
                    throw new IOException("Google Play connection failed");
                }
                try {
                    IBinder binder = advertisingConnection.getBinder();
                    Intrinsics.d(binder);
                    AdvertisingInterface advertisingInterface = new AdvertisingInterface(binder);
                    AdInfo adInfo = new AdInfo(advertisingInterface.getId(), advertisingInterface.isLimitAdTrackingEnabled(true));
                    context.unbindService(advertisingConnection);
                    return adInfo;
                } catch (Exception e11) {
                    throw e11;
                }
            } catch (Throwable th2) {
                context.unbindService(advertisingConnection);
                throw th2;
            }
        }
    }

    private CommonUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getGaid$lambda-0, reason: not valid java name */
    public static final void m105getGaid$lambda0() {
        INSTANCE.queryGaid();
    }

    private final Locale getLocale() {
        if (locale == null) {
            try {
                locale = Build.VERSION.SDK_INT >= 24 ? LocaleList.getDefault().get(0) : Locale.getDefault();
            } catch (Throwable th2) {
                locale = Locale.getDefault();
                XLogUtil log = XLogUtil.Companion.getLog();
                String stackTraceString = Log.getStackTraceString(th2);
                Intrinsics.f(stackTraceString, "getStackTraceString(e)");
                log.e(stackTraceString);
            }
        }
        return locale;
    }

    private final void queryGaid() {
        try {
            if (context == null) {
                return;
            }
            AdvertisingIdClient advertisingIdClient = AdvertisingIdClient.INSTANCE;
            Context context2 = context;
            Intrinsics.d(context2);
            AdvertisingIdClient.AdInfo advertisingIdInfo = advertisingIdClient.getAdvertisingIdInfo(context2);
            if (advertisingIdInfo == null || Intrinsics.b(advertisingIdInfo.getId(), mGaid)) {
                return;
            }
            mGaid = String.valueOf(advertisingIdInfo.getId());
            SPHelper.INSTANCE.getInstance().p(PREF_GAID, mGaid);
            XLogUtil.Companion.getLog().i("CommonUtil", Intrinsics.p(" GAID is ：", mGaid));
        } catch (Throwable th2) {
            XLogUtil log = XLogUtil.Companion.getLog();
            String stackTraceString = Log.getStackTraceString(th2);
            Intrinsics.f(stackTraceString, "getStackTraceString(e)");
            log.e(stackTraceString);
        }
    }

    public final String encryptMD5(String str) {
        byte[] bytes;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            Intrinsics.f(messageDigest, "getInstance(\"MD5\")");
            if (str == null) {
                bytes = null;
            } else {
                Charset UTF_8 = StandardCharsets.UTF_8;
                Intrinsics.f(UTF_8, "UTF_8");
                bytes = str.getBytes(UTF_8);
                Intrinsics.f(bytes, "this as java.lang.String).getBytes(charset)");
            }
            byte[] bArrDigest = messageDigest.digest(bytes);
            Intrinsics.f(bArrDigest, "md.digest(inputStr?.toBy…(StandardCharsets.UTF_8))");
            StringBuilder sb2 = new StringBuilder();
            int length = bArrDigest.length;
            int i11 = 0;
            while (i11 < length) {
                byte b11 = bArrDigest[i11];
                i11++;
                String hexString = Integer.toHexString(b11 & 255);
                if (hexString.length() == 1) {
                    sb2.append('0');
                }
                sb2.append(hexString);
            }
            return sb2.toString();
        } catch (Throwable th2) {
            XLogUtil log = XLogUtil.Companion.getLog();
            String stackTraceString = Log.getStackTraceString(th2);
            Intrinsics.f(stackTraceString, "getStackTraceString(e)");
            log.e(stackTraceString);
            return null;
        }
    }

    public final String getBrand() {
        if (brand.length() == 0) {
            String BRAND = Build.BRAND;
            if (BRAND == null || l.y(BRAND)) {
                BRAND = "";
            } else {
                Intrinsics.f(BRAND, "BRAND");
            }
            brand = BRAND;
        }
        return brand;
    }

    public final String getGaid() {
        int i11;
        try {
            if (TextUtils.isEmpty(mGaid) && (i11 = queryGaidCount) < 5) {
                queryGaidCount = i11 + 1;
                XLogUtil.Companion.getLog().i(XLogUtil.TAG, Intrinsics.p("queryGaidCount ：", Integer.valueOf(queryGaidCount)));
                String strI = SPHelper.INSTANCE.getInstance().i(PREF_GAID);
                Intrinsics.f(strI, "SPHelper.instance.getString(PREF_GAID)");
                mGaid = strI;
                if (Intrinsics.b(Looper.myLooper(), Looper.getMainLooper())) {
                    ExecutorUtils.io().execute(new Runnable() { // from class: com.cloud.config.utils.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            CommonUtils.m105getGaid$lambda0();
                        }
                    });
                } else {
                    queryGaid();
                }
            }
            XLogUtil.Companion.getLog().i(XLogUtil.TAG, Intrinsics.p("mGaid ：", mGaid));
            return mGaid;
        } catch (Throwable th2) {
            XLogUtil log = XLogUtil.Companion.getLog();
            String stackTraceString = Log.getStackTraceString(th2);
            Intrinsics.f(stackTraceString, "getStackTraceString(e)");
            log.e(stackTraceString);
            return "";
        }
    }

    public final String getMcc() {
        String simOperator;
        try {
            if (mcc.length() != 0) {
                return mcc;
            }
            Context context2 = context;
            Object systemService = context2 == null ? null : context2.getSystemService("phone");
            TelephonyManager telephonyManager = systemService instanceof TelephonyManager ? (TelephonyManager) systemService : null;
            if (telephonyManager == null || (simOperator = telephonyManager.getSimOperator()) == null) {
                simOperator = "";
            }
            if (simOperator.length() < 3) {
                return "";
            }
            String strSubstring = simOperator.substring(0, 3);
            Intrinsics.f(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            return strSubstring;
        } catch (Throwable th2) {
            XLogUtil log = XLogUtil.Companion.getLog();
            String stackTraceString = Log.getStackTraceString(th2);
            Intrinsics.f(stackTraceString, "getStackTraceString(e)");
            log.e(stackTraceString);
            return "";
        }
    }

    public final String getModel() {
        if (model.length() == 0) {
            String MODEL = Build.MODEL;
            if (MODEL == null || l.y(MODEL)) {
                MODEL = "";
            } else {
                Intrinsics.f(MODEL, "MODEL");
            }
            model = MODEL;
        }
        return model;
    }

    public final String getShuntValue(String key) {
        Intrinsics.g(key, "key");
        try {
            switch (key.hashCode()) {
                case -1850780999:
                    if (key.equals(PARAM_PHONEBRAND)) {
                        return getBrand();
                    }
                case -1840709029:
                    return !key.equals(PARAM_PHONEMODEL) ? "" : getModel();
                case 107917:
                    if (key.equals(PARAM_MCC)) {
                        return getMcc();
                    }
                case 115792:
                    if (key.equals(PARAM_UID)) {
                        return Intrinsics.p("", Integer.valueOf((mGaid.hashCode() & Api.BaseClientBuilder.API_PRIORITY_OTHER) % 1000000));
                    }
                case 585295590:
                    if (key.equals(PARAM_PHONELANGUAGE)) {
                        return getSystemLanguage();
                    }
                case 1812004436:
                    if (key.equals(PARAM_OSVERSION)) {
                        return getVersion();
                    }
                default:
            }
        } catch (Throwable th2) {
            XLogUtil log = XLogUtil.Companion.getLog();
            String stackTraceString = Log.getStackTraceString(th2);
            Intrinsics.f(stackTraceString, "getStackTraceString(e)");
            log.e(stackTraceString);
            return "";
        }
    }

    public final String getSystemLanguage() {
        String language2;
        if (language.length() == 0) {
            Locale locale2 = getLocale();
            String str = "";
            if (locale2 != null && (language2 = locale2.getLanguage()) != null) {
                str = language2;
            }
            language = str;
        }
        return language;
    }

    public final String getVersion() {
        if (osVersion.length() == 0) {
            String RELEASE = Build.VERSION.RELEASE;
            if (RELEASE == null || l.y(RELEASE)) {
                RELEASE = "";
            } else {
                Intrinsics.f(RELEASE, "RELEASE");
            }
            osVersion = RELEASE;
        }
        return osVersion;
    }

    public final void setContext(Context context2) {
        context = context2;
    }
}
