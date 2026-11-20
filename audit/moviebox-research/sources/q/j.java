package q;

import com.cloud.tmc.kernel.proxy.performanceanalyse.V8AnalyseType;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f74103a;

    /* JADX INFO: compiled from: source.java */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f74104a;

        static {
            int[] iArr = new int[V8AnalyseType.values().length];
            try {
                iArr[V8AnalyseType.CHECK_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[V8AnalyseType.CHECK_EXIST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[V8AnalyseType.CHECK_UN_EXIST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[V8AnalyseType.DOWNLOAD_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[V8AnalyseType.DOWNLOAD_SUCCESS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[V8AnalyseType.DOWNLOAD_FAIL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[V8AnalyseType.UNZIP_START.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[V8AnalyseType.UNZIP_SUCCESS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[V8AnalyseType.UNZIP_FAIL.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            f74104a = iArr;
        }
    }

    public j() {
        V8AnalyseType v8AnalyseType = V8AnalyseType.CHECK_START;
    }
}
