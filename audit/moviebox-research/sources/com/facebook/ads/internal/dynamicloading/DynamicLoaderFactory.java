package com.facebook.ads.internal.dynamicloading;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.BuildConfig;
import com.facebook.ads.internal.settings.MultithreadedBundleWrapper;
import com.facebook.ads.internal.util.common.ANActivityLifecycleCallbacksListener;
import com.facebook.ads.internal.util.common.Preconditions;
import dalvik.system.DexClassLoader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@Keep
public class DynamicLoaderFactory {
    private static final String AUDIENCE_NETWORK_CODE_PATH = "audience_network";
    public static final String AUDIENCE_NETWORK_DEX = "audience_network.dex";
    private static final String CODE_CACHE_DIR = "code_cache";
    static final String DEX_LOADING_ERROR_MESSAGE = "Can't load Audience Network Dex. Please, check that audience_network.dex is inside of assets folder.";
    private static final int DEX_LOAD_RETRY_COUNT = 3;
    private static final int DEX_LOAD_RETRY_DELAY_MS = 200;
    private static final String OPTIMIZED_DEX_PATH = "optimized";
    private static boolean sFallbackMode;
    private static final String DYNAMIC_LOADING_BUILD_TYPE = "releaseDL";
    public static final boolean LOAD_FROM_ASSETS = DYNAMIC_LOADING_BUILD_TYPE.equals(BuildConfig.BUILD_TYPE);
    private static final AtomicReference<DynamicLoader> sDynamicLoader = new AtomicReference<>();
    private static final AtomicBoolean sInitializing = new AtomicBoolean();
    private static boolean sUseLegacyClassLoader = true;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    public interface RemoteClassLoaderFactory {
        @Nullable
        ClassLoader create(Context context);
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    public class a implements AudienceNetworkAds.InitResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Throwable f32404a;

        public a(Throwable th2) {
            this.f32404a = th2;
        }

        @Override // com.facebook.ads.AudienceNetworkAds.InitResult
        public String getMessage() {
            return DynamicLoaderFactory.createErrorMessage(this.f32404a);
        }

        @Override // com.facebook.ads.AudienceNetworkAds.InitResult
        public boolean isSuccess() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AudienceNetworkAds.InitResult createErrorInitResult(Throwable th2) {
        return new a(th2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String createErrorMessage(Throwable th2) {
        return "Can't load Audience Network Dex. Please, check that audience_network.dex is inside of assets folder.\n" + stackTraceToString(th2);
    }

    @SuppressLint({"CatchGeneralException"})
    @TargetApi(26)
    private static ClassLoader createInMemoryClassLoader(Context context) throws IOException {
        InputStream inputStreamOpen;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr;
        try {
            ClassLoader classLoaderCreate = ((RemoteClassLoaderFactory) context.getClassLoader().loadClass("com.facebook.ads.internal.dynamicloading.RemoteClassLoaderFactoryImpl").getDeclaredConstructor(new Class[0]).newInstance(new Object[0])).create(context);
            if (classLoaderCreate != null) {
                return classLoaderCreate;
            }
            while (true) {
                int i11 = inputStreamOpen.read(bArr);
                if (i11 <= 0) {
                    inputStreamOpen.close();
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    ByteBuffer byteBufferWrap = ByteBuffer.wrap(byteArrayOutputStream.toByteArray());
                    b.a();
                    return com.facebook.ads.internal.dynamicloading.a.a(byteBufferWrap, DynamicLoaderFactory.class.getClassLoader());
                }
                byteArrayOutputStream.write(bArr, 0, i11);
            }
        } catch (Exception unused) {
        }
        inputStreamOpen = context.getAssets().open(AUDIENCE_NETWORK_DEX);
        byteArrayOutputStream = new ByteArrayOutputStream();
        bArr = new byte[1024];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void doCallInitialize(Context context, @Nullable DynamicLoader dynamicLoader, @Nullable final Throwable th2, boolean z11, @Nullable MultithreadedBundleWrapper multithreadedBundleWrapper, @Nullable final AudienceNetworkAds.InitListener initListener) {
        if (th2 != null) {
            if (initListener != null) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory.2
                    @Override // java.lang.Runnable
                    public void run() {
                        initListener.onInitialized(DynamicLoaderFactory.createErrorInitResult(th2));
                    }
                }, 100L);
                return;
            } else {
                Log.e(AudienceNetworkAds.TAG, DEX_LOADING_ERROR_MESSAGE, th2);
                return;
            }
        }
        if (dynamicLoader != null) {
            if (z11) {
                dynamicLoader.createAudienceNetworkAdsApi().onContentProviderCreated(context);
            } else {
                dynamicLoader.createAudienceNetworkAdsApi().initialize(context, multithreadedBundleWrapper, initListener);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static DynamicLoader doMakeLoader(Context context, boolean z11) throws Exception {
        AtomicReference<DynamicLoader> atomicReference = sDynamicLoader;
        DynamicLoader dynamicLoader = atomicReference.get();
        if (dynamicLoader == null) {
            if (LOAD_FROM_ASSETS) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                DynamicLoader dynamicLoader2 = (DynamicLoader) makeAdsSdkClassLoader(context.getApplicationContext()).loadClass("com.facebook.ads.internal.dynamicloading.DynamicLoaderImpl").newInstance();
                long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("SDK dex loading time: ");
                sb2.append(jCurrentTimeMillis2);
                dynamicLoader = dynamicLoader2;
            } else {
                dynamicLoader = (DynamicLoader) Class.forName("com.facebook.ads.internal.dynamicloading.DynamicLoaderImpl").newInstance();
            }
            if (z11) {
                dynamicLoader.maybeInitInternally(context);
            }
            atomicReference.set(dynamicLoader);
        }
        return dynamicLoader;
    }

    @Nullable
    @SuppressLint({"PrivateApi", "CatchGeneralException"})
    private static Context getApplicationContextViaReflection() {
        try {
            return (Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null);
        } catch (Throwable th2) {
            Log.e(AudienceNetworkAds.TAG, "Failed to fetch Context from  ActivityThread. Audience Network SDK won't work unless you call AudienceNetworkAds.buildInitSettings().withListener(InitListener).initialize().", th2);
            return null;
        }
    }

    private static File getCacheCodeDirLegacy(Context context, File file) throws IOException {
        File file2 = new File(file, CODE_CACHE_DIR);
        try {
            mkdirChecked(file2);
            return file2;
        } catch (IOException unused) {
            File dir = context.getDir(CODE_CACHE_DIR, 0);
            mkdirChecked(dir);
            return dir;
        }
    }

    private static File getCodeCacheDir(Context context, File file) throws IOException {
        return context.getCodeCacheDir();
    }

    @Nullable
    public static DynamicLoader getDynamicLoader() {
        return sDynamicLoader.get();
    }

    private static File getSecondaryDir(File file) throws IOException {
        File file2 = new File(file, AUDIENCE_NETWORK_CODE_PATH);
        mkdirChecked(file2);
        return file2;
    }

    public static void initialize(final Context context, @Nullable final MultithreadedBundleWrapper multithreadedBundleWrapper, @Nullable final AudienceNetworkAds.InitListener initListener, final boolean z11) {
        if (z11 || !sInitializing.getAndSet(true)) {
            new Thread(new Runnable() { // from class: com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory.1
                @Override // java.lang.Runnable
                @SuppressLint({"CatchGeneralException"})
                public void run() {
                    Throwable th2;
                    DynamicLoader dynamicLoader;
                    ANActivityLifecycleCallbacksListener.registerActivityCallbacks(context);
                    synchronized (DynamicLoaderFactory.class) {
                        DynamicLoader dynamicLoaderDoMakeLoader = null;
                        th2 = null;
                        for (int i11 = 0; i11 < 3; i11++) {
                            try {
                                dynamicLoaderDoMakeLoader = DynamicLoaderFactory.doMakeLoader(context, false);
                                break;
                            } catch (Throwable th3) {
                                if (i11 == 2) {
                                    try {
                                        if (!z11) {
                                            DexLoadErrorReporter.reportDexLoadingIssue(context, DynamicLoaderFactory.createErrorMessage(th3), 0.1d);
                                            DynamicLoaderFactory.setFallbackMode(true);
                                        }
                                        th2 = th3;
                                    } catch (Throwable th4) {
                                        throw th4;
                                    }
                                } else {
                                    SystemClock.sleep(200L);
                                }
                            }
                        }
                        dynamicLoader = dynamicLoaderDoMakeLoader;
                    }
                    DynamicLoaderFactory.doCallInitialize(context, dynamicLoader, th2, z11, multithreadedBundleWrapper, initListener);
                    DynamicLoaderFactory.sInitializing.set(false);
                }
            }).start();
        }
    }

    public static synchronized boolean isFallbackMode() {
        return sFallbackMode;
    }

    private static ClassLoader makeAdsSdkClassLoader(Context context) throws Exception {
        if (Build.VERSION.SDK_INT >= 30) {
            return createInMemoryClassLoader(context);
        }
        if (sUseLegacyClassLoader) {
            return makeLegacyAdsSdkClassLoader(context);
        }
        File secondaryDir = getSecondaryDir(getCodeCacheDir(context, new File(context.getApplicationInfo().dataDir)));
        String str = secondaryDir.getPath() + File.separator + AUDIENCE_NETWORK_DEX;
        InputStream inputStreamOpen = context.getAssets().open(AUDIENCE_NETWORK_DEX);
        FileOutputStream fileOutputStream = new FileOutputStream(str);
        byte[] bArr = new byte[1024];
        while (true) {
            int i11 = inputStreamOpen.read(bArr);
            if (i11 <= 0) {
                inputStreamOpen.close();
                fileOutputStream.flush();
                fileOutputStream.close();
                File file = new File(secondaryDir.getPath() + File.separator + OPTIMIZED_DEX_PATH);
                mkdirChecked(file);
                return new DexClassLoader(str, file.getPath(), null, context.getClassLoader());
            }
            fileOutputStream.write(bArr, 0, i11);
        }
    }

    private static DexClassLoader makeLegacyAdsSdkClassLoader(Context context) throws Exception {
        String str = context.getFilesDir().getPath() + File.separator + AUDIENCE_NETWORK_DEX;
        InputStream inputStreamOpen = context.getAssets().open(AUDIENCE_NETWORK_DEX);
        FileOutputStream fileOutputStream = new FileOutputStream(str);
        byte[] bArr = new byte[1024];
        while (true) {
            int i11 = inputStreamOpen.read(bArr);
            if (i11 <= 0) {
                inputStreamOpen.close();
                fileOutputStream.flush();
                fileOutputStream.close();
                return new DexClassLoader(str, context.getDir(OPTIMIZED_DEX_PATH, 0).getPath(), null, DynamicLoaderFactory.class.getClassLoader());
            }
            fileOutputStream.write(bArr, 0, i11);
        }
    }

    public static synchronized DynamicLoader makeLoader(Context context) {
        return makeLoader(context, true);
    }

    @SuppressLint({"CatchGeneralException"})
    public static synchronized DynamicLoader makeLoader(Context context, boolean z11) {
        Preconditions.checkNotNull(context, "Context can not be null.");
        try {
        } catch (Throwable th2) {
            Log.e(AudienceNetworkAds.TAG, DEX_LOADING_ERROR_MESSAGE, th2);
            DexLoadErrorReporter.reportDexLoadingIssue(context, createErrorMessage(th2), 0.1d);
            DynamicLoader dynamicLoaderMakeFallbackLoader = DynamicLoaderFallback.makeFallbackLoader();
            sDynamicLoader.set(dynamicLoaderMakeFallbackLoader);
            sFallbackMode = true;
            return dynamicLoaderMakeFallbackLoader;
        }
        return doMakeLoader(context, z11);
    }

    @SuppressLint({"CatchGeneralException"})
    public static synchronized DynamicLoader makeLoaderUnsafe() {
        AtomicReference<DynamicLoader> atomicReference = sDynamicLoader;
        if (atomicReference.get() != null) {
            return atomicReference.get();
        }
        Context applicationContextViaReflection = getApplicationContextViaReflection();
        if (applicationContextViaReflection == null) {
            throw new RuntimeException("You must call AudienceNetworkAds.buildInitSettings(Context).initialize() before you can use Audience Network SDK.");
        }
        return makeLoader(applicationContextViaReflection, true);
    }

    private static void mkdirChecked(File file) throws IOException {
        String str;
        file.mkdir();
        if (file.isDirectory()) {
            return;
        }
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            str = "Failed to create dir " + file.getPath() + ". Parent file is null.";
        } else {
            str = "Failed to create dir " + file.getPath() + ". parent file is a dir " + parentFile.isDirectory() + ", a file " + parentFile.isFile() + ", exists " + parentFile.exists() + ", readable " + parentFile.canRead() + ", writable " + parentFile.canWrite();
        }
        Log.e(AudienceNetworkAds.TAG, str);
        throw new IOException("Failed to create directory " + file.getPath() + ", detailed message: " + str);
    }

    public static synchronized void setFallbackMode(boolean z11) {
        try {
            if (z11) {
                sDynamicLoader.set(DynamicLoaderFallback.makeFallbackLoader());
                sFallbackMode = true;
            } else {
                sDynamicLoader.set(null);
                sFallbackMode = false;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public static void setUseLegacyClassLoader(boolean z11) {
        sUseLegacyClassLoader = z11;
    }

    private static String stackTraceToString(Throwable th2) {
        return Log.getStackTraceString(th2);
    }
}
