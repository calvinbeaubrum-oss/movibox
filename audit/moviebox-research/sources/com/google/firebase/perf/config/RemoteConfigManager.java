package com.google.firebase.perf.config;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import bl.b;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.perf.provider.FirebasePerfProvider;
import com.google.firebase.perf.util.e;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import nl.d;
import nl.w;
import ql.a;
import yl.f;
import yl.i;
import yl.m;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@Keep
public class RemoteConfigManager {
    private static final long FETCH_NEVER_HAPPENED_TIMESTAMP_MS = 0;
    private static final String FIREPERF_FRC_NAMESPACE_NAME = "fireperf";
    private static final long MIN_APP_START_CONFIG_FETCH_DELAY_MS = 5000;
    private static final int RANDOM_APP_START_CONFIG_FETCH_DELAY_MS = 25000;
    private final ConcurrentHashMap<String, i> allRcConfigMap;
    private final long appStartConfigFetchDelayInMs;
    private final long appStartTimeInMs;
    private final w cache;
    private final Executor executor;

    @Nullable
    private f firebaseRemoteConfig;
    private long firebaseRemoteConfigLastFetchTimestampMs;

    @Nullable
    private b<m> firebaseRemoteConfigProvider;
    private static final a logger = a.e();
    private static final RemoteConfigManager instance = new RemoteConfigManager();
    private static final long TIME_AFTER_WHICH_A_FETCH_IS_CONSIDERED_STALE_MS = TimeUnit.HOURS.toMillis(12);

    private RemoteConfigManager() {
        this(w.e(), new ThreadPoolExecutor(0, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue()), null, ((long) new Random().nextInt(25000)) + 5000);
    }

    @VisibleForTesting
    public RemoteConfigManager(w wVar, Executor executor, f fVar, long j11) {
        this.firebaseRemoteConfigLastFetchTimestampMs = 0L;
        this.cache = wVar;
        this.executor = executor;
        this.firebaseRemoteConfig = fVar;
        this.allRcConfigMap = fVar == null ? new ConcurrentHashMap<>() : new ConcurrentHashMap<>(fVar.i());
        this.appStartTimeInMs = TimeUnit.MICROSECONDS.toMillis(FirebasePerfProvider.getAppStartTime().getMicros());
        this.appStartConfigFetchDelayInMs = j11;
    }

    public static RemoteConfigManager getInstance() {
        return instance;
    }

    private i getRemoteConfigValue(String str) {
        triggerRemoteConfigFetchIfNecessary();
        if (!isFirebaseRemoteConfigAvailable() || !this.allRcConfigMap.containsKey(str)) {
            return null;
        }
        i iVar = this.allRcConfigMap.get(str);
        if (iVar.a() != 2) {
            return null;
        }
        logger.b("Fetched value: '%s' for key: '%s' from Firebase Remote Config.", iVar.b(), str);
        return iVar;
    }

    @VisibleForTesting
    public static int getVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }

    private boolean hasAppStartConfigFetchDelayElapsed(long j11) {
        return j11 - this.appStartTimeInMs >= this.appStartConfigFetchDelayInMs;
    }

    private boolean hasLastFetchBecomeStale(long j11) {
        return j11 - this.firebaseRemoteConfigLastFetchTimestampMs > TIME_AFTER_WHICH_A_FETCH_IS_CONSIDERED_STALE_MS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$triggerFirebaseRemoteConfigFetchAndActivateOnSuccessfulFetch$0(Boolean bool) {
        syncConfigValues(this.firebaseRemoteConfig.i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$triggerFirebaseRemoteConfigFetchAndActivateOnSuccessfulFetch$1(Exception exc) {
        this.firebaseRemoteConfigLastFetchTimestampMs = 0L;
    }

    private boolean shouldFetchAndActivateRemoteConfigValues() {
        long currentSystemTimeMillis = getCurrentSystemTimeMillis();
        return hasAppStartConfigFetchDelayElapsed(currentSystemTimeMillis) && hasLastFetchBecomeStale(currentSystemTimeMillis);
    }

    private void triggerFirebaseRemoteConfigFetchAndActivateOnSuccessfulFetch() {
        this.firebaseRemoteConfigLastFetchTimestampMs = getCurrentSystemTimeMillis();
        this.firebaseRemoteConfig.h().addOnSuccessListener(this.executor, new OnSuccessListener() { // from class: nl.x
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                this.f72063a.lambda$triggerFirebaseRemoteConfigFetchAndActivateOnSuccessfulFetch$0((Boolean) obj);
            }
        }).addOnFailureListener(this.executor, new OnFailureListener() { // from class: nl.y
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                this.f72064a.lambda$triggerFirebaseRemoteConfigFetchAndActivateOnSuccessfulFetch$1(exc);
            }
        });
    }

    private void triggerRemoteConfigFetchIfNecessary() {
        if (isFirebaseRemoteConfigAvailable()) {
            if (this.allRcConfigMap.isEmpty()) {
                this.allRcConfigMap.putAll(this.firebaseRemoteConfig.i());
            }
            if (shouldFetchAndActivateRemoteConfigValues()) {
                triggerFirebaseRemoteConfigFetchAndActivateOnSuccessfulFetch();
            }
        }
    }

    public e<Boolean> getBoolean(String str) {
        if (str == null) {
            logger.a("The key to get Remote Config boolean value is null.");
            return e.a();
        }
        i remoteConfigValue = getRemoteConfigValue(str);
        if (remoteConfigValue != null) {
            try {
                return e.e(Boolean.valueOf(remoteConfigValue.e()));
            } catch (IllegalArgumentException unused) {
                if (!remoteConfigValue.b().isEmpty()) {
                    logger.b("Could not parse value: '%s' for key: '%s'.", remoteConfigValue.b(), str);
                }
            }
        }
        return e.a();
    }

    @VisibleForTesting
    public long getCurrentSystemTimeMillis() {
        return System.currentTimeMillis();
    }

    public e<Float> getFloat(String str) {
        if (str == null) {
            logger.a("The key to get Remote Config float value is null.");
            return e.a();
        }
        i remoteConfigValue = getRemoteConfigValue(str);
        if (remoteConfigValue != null) {
            try {
                return e.e(Float.valueOf(Double.valueOf(remoteConfigValue.d()).floatValue()));
            } catch (IllegalArgumentException unused) {
                if (!remoteConfigValue.b().isEmpty()) {
                    logger.b("Could not parse value: '%s' for key: '%s'.", remoteConfigValue.b(), str);
                }
            }
        }
        return e.a();
    }

    public e<Long> getLong(String str) {
        if (str == null) {
            logger.a("The key to get Remote Config long value is null.");
            return e.a();
        }
        i remoteConfigValue = getRemoteConfigValue(str);
        if (remoteConfigValue != null) {
            try {
                return e.e(Long.valueOf(remoteConfigValue.c()));
            } catch (IllegalArgumentException unused) {
                if (!remoteConfigValue.b().isEmpty()) {
                    logger.b("Could not parse value: '%s' for key: '%s'.", remoteConfigValue.b(), str);
                }
            }
        }
        return e.a();
    }

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
    public <T> T getRemoteConfigValueOrDefault(String str, T t11) {
        Object objValueOf;
        i remoteConfigValue = getRemoteConfigValue(str);
        if (remoteConfigValue == null) {
            return t11;
        }
        try {
            if (t11 instanceof Boolean) {
                objValueOf = Boolean.valueOf(remoteConfigValue.e());
            } else if (t11 instanceof Float) {
                objValueOf = Float.valueOf(Double.valueOf(remoteConfigValue.d()).floatValue());
            } else if ((t11 instanceof Long) || (t11 instanceof Integer)) {
                objValueOf = Long.valueOf(remoteConfigValue.c());
            } else {
                if (!(t11 instanceof String)) {
                    T t12 = (T) remoteConfigValue.b();
                    try {
                        logger.b("No matching type found for the defaultValue: '%s', using String.", t11);
                        return t12;
                    } catch (IllegalArgumentException unused) {
                        t11 = t12;
                        if (remoteConfigValue.b().isEmpty()) {
                            return t11;
                        }
                        logger.b("Could not parse value: '%s' for key: '%s'.", remoteConfigValue.b(), str);
                        return t11;
                    }
                }
                objValueOf = remoteConfigValue.b();
            }
            return (T) objValueOf;
        } catch (IllegalArgumentException unused2) {
        }
    }

    public e<String> getString(String str) {
        if (str == null) {
            logger.a("The key to get Remote Config String value is null.");
            return e.a();
        }
        i remoteConfigValue = getRemoteConfigValue(str);
        return remoteConfigValue != null ? e.e(remoteConfigValue.b()) : e.a();
    }

    public boolean isFirebaseRemoteConfigAvailable() {
        b<m> bVar;
        m mVar;
        if (this.firebaseRemoteConfig == null && (bVar = this.firebaseRemoteConfigProvider) != null && (mVar = bVar.get()) != null) {
            this.firebaseRemoteConfig = mVar.b(FIREPERF_FRC_NAMESPACE_NAME);
        }
        return this.firebaseRemoteConfig != null;
    }

    public boolean isLastFetchFailed() {
        f fVar = this.firebaseRemoteConfig;
        return fVar == null || fVar.j().a() == 1;
    }

    public void setFirebaseRemoteConfigProvider(@Nullable b<m> bVar) {
        this.firebaseRemoteConfigProvider = bVar;
    }

    @VisibleForTesting
    public void syncConfigValues(Map<String, i> map) {
        this.allRcConfigMap.putAll(map);
        for (String str : this.allRcConfigMap.keySet()) {
            if (!map.containsKey(str)) {
                this.allRcConfigMap.remove(str);
            }
        }
        d dVarE = d.e();
        i iVar = this.allRcConfigMap.get(dVarE.c());
        if (iVar == null) {
            logger.a("ExperimentTTID remote config flag does not exist.");
            return;
        }
        try {
            this.cache.m(dVarE.a(), iVar.e());
        } catch (Exception unused) {
            logger.a("ExperimentTTID remote config flag has invalid value, expected boolean.");
        }
    }
}
