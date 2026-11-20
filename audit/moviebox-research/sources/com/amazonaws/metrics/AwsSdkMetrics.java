package com.amazonaws.metrics;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.regions.Regions;
import com.amazonaws.util.AWSRequestMetrics;
import com.amazonaws.util.AWSServiceMetrics;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public enum AwsSdkMetrics {
    ;

    public static final String AWS_CREDENTAIL_PROPERTIES_FILE = "credentialFile";
    public static final String CLOUDWATCH_REGION = "cloudwatchRegion";
    private static final boolean DEFAULT_METRICS_ENABLED;
    private static final String DEFAULT_METRIC_COLLECTOR_FACTORY = "com.amazonaws.metrics.internal.cloudwatch.DefaultMetricCollectorFactory";
    public static final String DEFAULT_METRIC_NAMESPACE = "AWSSDK/Java";
    public static final String EXCLUDE_MACHINE_METRICS = "excludeMachineMetrics";
    public static final String HOST_METRIC_NAME = "hostMetricName";
    public static final String INCLUDE_PER_HOST_METRICS = "includePerHostMetrics";
    public static final String JVM_METRIC_NAME = "jvmMetricName";
    private static final String MBEAN_OBJECT_NAME = "com.amazonaws.management:type=" + AwsSdkMetrics.class.getSimpleName();
    public static final String METRIC_NAME_SPACE = "metricNameSpace";
    public static final String METRIC_QUEUE_SIZE = "metricQueueSize";
    public static final String QUEUE_POLL_TIMEOUT_MILLI = "getQueuePollTimeoutMilli";
    private static final int QUEUE_POLL_TIMEOUT_MILLI_MINUMUM = 1000;
    private static final MetricRegistry REGISTRY;
    public static final String USE_SINGLE_METRIC_NAMESPACE = "useSingleMetricNamespace";
    private static volatile String credentialFile;
    private static volatile AWSCredentialsProvider credentialProvider;
    private static boolean dirtyEnabling;
    private static volatile String hostMetricName;
    private static volatile String jvmMetricName;
    private static volatile boolean machineMetricsExcluded;

    /* JADX INFO: renamed from: mc, reason: collision with root package name */
    private static volatile MetricCollector f15768mc;
    private static volatile String metricNameSpace;
    private static volatile Integer metricQueueSize;
    private static volatile boolean perHostMetricsIncluded;
    private static volatile Long queuePollTimeoutMilli;
    private static volatile Regions region;
    private static volatile boolean singleMetricNamespace;

    /* JADX INFO: compiled from: source.java */
    public static class MetricRegistry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set<MetricType> f15770a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile Set<MetricType> f15771b;

        public MetricRegistry() {
            HashSet hashSet = new HashSet();
            this.f15770a = hashSet;
            hashSet.add(AWSRequestMetrics.Field.ClientExecuteTime);
            hashSet.add(AWSRequestMetrics.Field.Exception);
            hashSet.add(AWSRequestMetrics.Field.HttpClientRetryCount);
            hashSet.add(AWSRequestMetrics.Field.HttpRequestTime);
            hashSet.add(AWSRequestMetrics.Field.RequestCount);
            hashSet.add(AWSRequestMetrics.Field.RetryCount);
            hashSet.add(AWSRequestMetrics.Field.HttpClientSendRequestTime);
            hashSet.add(AWSRequestMetrics.Field.HttpClientReceiveResponseTime);
            hashSet.add(AWSServiceMetrics.HttpClientGetConnectionTime);
            f();
        }

        public boolean a(MetricType metricType) {
            boolean zAdd;
            synchronized (this.f15770a) {
                try {
                    zAdd = this.f15770a.add(metricType);
                    if (zAdd) {
                        f();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return zAdd;
        }

        public <T extends MetricType> boolean b(Collection<T> collection) {
            boolean zAddAll;
            synchronized (this.f15770a) {
                try {
                    zAddAll = this.f15770a.addAll(collection);
                    if (zAddAll) {
                        f();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return zAddAll;
        }

        public Set<MetricType> c() {
            return this.f15771b;
        }

        public boolean d(MetricType metricType) {
            boolean zRemove;
            synchronized (this.f15770a) {
                try {
                    zRemove = this.f15770a.remove(metricType);
                    if (zRemove) {
                        f();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return zRemove;
        }

        /* JADX WARN: Code duplicated, block: B:12:0x0016 A[Catch: all -> 0x000c, DONT_GENERATE, TryCatch #0 {all -> 0x000c, blocks: (B:5:0x0005, B:16:0x001e, B:18:0x0029, B:19:0x002c, B:10:0x000e, B:12:0x0016, B:15:0x001a), top: B:23:0x0005 }] */
        /* JADX WARN: Code duplicated, block: B:14:0x0018 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:15:0x001a A[Catch: all -> 0x000c, TryCatch #0 {all -> 0x000c, blocks: (B:5:0x0005, B:16:0x001e, B:18:0x0029, B:19:0x002c, B:10:0x000e, B:12:0x0016, B:15:0x001a), top: B:23:0x0005 }] */
        public <T extends MetricType> void e(Collection<T> collection) {
            synchronized (this.f15770a) {
                if (collection != null) {
                    try {
                        if (collection.size() == 0) {
                            if (this.f15770a.size() == 0) {
                                return;
                            }
                            if (collection == null) {
                                collection = Collections.emptyList();
                            }
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                } else {
                    if (this.f15770a.size() == 0) {
                        return;
                    }
                    if (collection == null) {
                        collection = Collections.emptyList();
                    }
                }
                this.f15770a.clear();
                if (!b(collection)) {
                    f();
                }
            }
        }

        public final void f() {
            this.f15771b = Collections.unmodifiableSet(new HashSet(this.f15770a));
        }
    }

    static {
        metricNameSpace = DEFAULT_METRIC_NAMESPACE;
        String property = System.getProperty("com.amazonaws.sdk.enableDefaultMetrics");
        boolean z11 = property != null;
        DEFAULT_METRICS_ENABLED = z11;
        if (z11) {
            boolean z12 = false;
            boolean z13 = false;
            boolean z14 = false;
            for (String str : property.split(",")) {
                String strTrim = str.trim();
                if (!z12 && EXCLUDE_MACHINE_METRICS.equals(strTrim)) {
                    z12 = true;
                } else if (!z13 && INCLUDE_PER_HOST_METRICS.equals(strTrim)) {
                    z13 = true;
                } else if (z14 || !USE_SINGLE_METRIC_NAMESPACE.equals(strTrim)) {
                    String[] strArrSplit = strTrim.split("=");
                    if (strArrSplit.length == 2) {
                        String strTrim2 = strArrSplit[0].trim();
                        String strTrim3 = strArrSplit[1].trim();
                        try {
                            if (AWS_CREDENTAIL_PROPERTIES_FILE.equals(strTrim2)) {
                                setCredentialFile0(strTrim3);
                            } else if (CLOUDWATCH_REGION.equals(strTrim2)) {
                                region = Regions.fromName(strTrim3);
                            } else if (METRIC_QUEUE_SIZE.equals(strTrim2)) {
                                Integer num = new Integer(strTrim3);
                                if (num.intValue() < 1) {
                                    throw new IllegalArgumentException("metricQueueSize must be at least 1");
                                }
                                metricQueueSize = num;
                            } else if (QUEUE_POLL_TIMEOUT_MILLI.equals(strTrim2)) {
                                Long l11 = new Long(strTrim3);
                                if (l11.intValue() < 1000) {
                                    throw new IllegalArgumentException("getQueuePollTimeoutMilli must be at least 1000");
                                }
                                queuePollTimeoutMilli = l11;
                            } else if (METRIC_NAME_SPACE.equals(strTrim2)) {
                                metricNameSpace = strTrim3;
                            } else if (JVM_METRIC_NAME.equals(strTrim2)) {
                                jvmMetricName = strTrim3;
                            } else if (HOST_METRIC_NAME.equals(strTrim2)) {
                                hostMetricName = strTrim3;
                            } else {
                                LogFactory.b(AwsSdkMetrics.class).a("Ignoring unrecognized parameter: " + strTrim);
                            }
                        } catch (Exception e11) {
                            LogFactory.b(AwsSdkMetrics.class).g("Ignoring failure", e11);
                        }
                    } else {
                        continue;
                    }
                } else {
                    z14 = true;
                }
            }
            machineMetricsExcluded = z12;
            perHostMetricsIncluded = z13;
            singleMetricNamespace = z14;
        }
        REGISTRY = new MetricRegistry();
    }

    public static boolean add(MetricType metricType) {
        if (metricType == null) {
            return false;
        }
        return REGISTRY.a(metricType);
    }

    public static <T extends MetricType> boolean addAll(Collection<T> collection) {
        if (collection == null || collection.size() == 0) {
            return false;
        }
        return REGISTRY.b(collection);
    }

    public static void disableMetrics() {
        setMetricCollector(MetricCollector.f15775a);
    }

    public static synchronized boolean enableDefaultMetrics() {
        try {
            if (f15768mc == null || !f15768mc.c()) {
                if (dirtyEnabling) {
                    throw new IllegalStateException("Reentrancy is not allowed");
                }
                dirtyEnabling = true;
                try {
                    try {
                        MetricCollector metricCollectorA = ((MetricCollector.Factory) Class.forName(DEFAULT_METRIC_COLLECTOR_FACTORY).newInstance()).a();
                        if (metricCollectorA != null) {
                            setMetricCollector(metricCollectorA);
                            dirtyEnabling = false;
                            return true;
                        }
                    } catch (Exception e11) {
                        LogFactory.b(AwsSdkMetrics.class).i("Failed to enable the default metrics", e11);
                    }
                    dirtyEnabling = false;
                } catch (Throwable th2) {
                    dirtyEnabling = false;
                    throw th2;
                }
            }
            return false;
        } catch (Throwable th3) {
            throw th3;
        }
    }

    public static String getCredentailFile() {
        return credentialFile;
    }

    public static AWSCredentialsProvider getCredentialProvider() {
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            if (stackTraceElement.getClassName().equals(DEFAULT_METRIC_COLLECTOR_FACTORY)) {
                return credentialProvider;
            }
        }
        SecurityException securityException = new SecurityException();
        LogFactory.b(AwsSdkMetrics.class).i("Illegal attempt to access the credential provider", securityException);
        throw securityException;
    }

    public static String getHostMetricName() {
        return hostMetricName;
    }

    public static MetricCollector getInternalMetricCollector() {
        return f15768mc;
    }

    public static String getJvmMetricName() {
        return jvmMetricName;
    }

    public static <T extends MetricCollector> T getMetricCollector() {
        if (f15768mc == null && isDefaultMetricsEnabled()) {
            enableDefaultMetrics();
        }
        return f15768mc == null ? (T) MetricCollector.f15775a : (T) f15768mc;
    }

    public static String getMetricNameSpace() {
        return metricNameSpace;
    }

    public static Integer getMetricQueueSize() {
        return metricQueueSize;
    }

    public static Set<MetricType> getPredefinedMetrics() {
        return REGISTRY.c();
    }

    public static Long getQueuePollTimeoutMilli() {
        return queuePollTimeoutMilli;
    }

    public static Regions getRegion() {
        return region;
    }

    public static <T extends RequestMetricCollector> T getRequestMetricCollector() {
        if (f15768mc == null && isDefaultMetricsEnabled()) {
            enableDefaultMetrics();
        }
        return f15768mc == null ? (T) RequestMetricCollector.f15777a : (T) f15768mc.a();
    }

    public static <T extends ServiceMetricCollector> T getServiceMetricCollector() {
        if (f15768mc == null && isDefaultMetricsEnabled()) {
            enableDefaultMetrics();
        }
        return f15768mc == null ? (T) ServiceMetricCollector.f15778a : (T) f15768mc.b();
    }

    public static boolean isDefaultMetricsEnabled() {
        return DEFAULT_METRICS_ENABLED;
    }

    public static boolean isMachineMetricExcluded() {
        return machineMetricsExcluded;
    }

    public static boolean isMetricsEnabled() {
        MetricCollector metricCollector = f15768mc;
        return metricCollector != null && metricCollector.c();
    }

    public static boolean isPerHostMetricEnabled() {
        if (perHostMetricsIncluded) {
            return true;
        }
        String str = hostMetricName;
        return (str == null ? "" : str.trim()).length() > 0;
    }

    public static boolean isPerHostMetricIncluded() {
        return perHostMetricsIncluded;
    }

    public static boolean isSingleMetricNamespace() {
        return singleMetricNamespace;
    }

    public static boolean remove(MetricType metricType) {
        if (metricType == null) {
            return false;
        }
        return REGISTRY.d(metricType);
    }

    public static <T extends MetricType> void set(Collection<T> collection) {
        REGISTRY.e(collection);
    }

    public static void setCredentialFile(String str) throws IOException {
        setCredentialFile0(str);
    }

    private static void setCredentialFile0(String str) throws IOException {
        final PropertiesCredentials propertiesCredentials = new PropertiesCredentials(new File(str));
        synchronized (AwsSdkMetrics.class) {
            credentialProvider = new AWSCredentialsProvider() { // from class: com.amazonaws.metrics.AwsSdkMetrics.1
                @Override // com.amazonaws.auth.AWSCredentialsProvider
                public AWSCredentials getCredentials() {
                    return propertiesCredentials;
                }
            };
            credentialFile = str;
        }
    }

    public static synchronized void setCredentialProvider(AWSCredentialsProvider aWSCredentialsProvider) {
        credentialProvider = aWSCredentialsProvider;
    }

    public static void setHostMetricName(String str) {
        hostMetricName = str;
    }

    public static void setJvmMetricName(String str) {
        jvmMetricName = str;
    }

    public static void setMachineMetricsExcluded(boolean z11) {
        machineMetricsExcluded = z11;
    }

    public static synchronized void setMetricCollector(MetricCollector metricCollector) {
        MetricCollector metricCollector2 = f15768mc;
        f15768mc = metricCollector;
        if (metricCollector2 != null) {
            metricCollector2.d();
        }
    }

    public static void setMetricNameSpace(String str) {
        if (str == null || str.trim().length() == 0) {
            throw new IllegalArgumentException();
        }
        metricNameSpace = str;
    }

    public static void setMetricQueueSize(Integer num) {
        metricQueueSize = num;
    }

    public static void setPerHostMetricsIncluded(boolean z11) {
        perHostMetricsIncluded = z11;
    }

    public static void setQueuePollTimeoutMilli(Long l11) {
        queuePollTimeoutMilli = l11;
    }

    public static void setRegion(Regions regions) {
        region = regions;
    }

    public static void setSingleMetricNamespace(boolean z11) {
        singleMetricNamespace = z11;
    }
}
