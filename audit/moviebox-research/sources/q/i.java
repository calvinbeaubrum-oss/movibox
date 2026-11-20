package q;

import com.cloud.tmc.kernel.proxy.performanceanalyse.WorkerAnalyseType;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f74100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WorkerAnalyseType f74101b = WorkerAnalyseType.INIT;

    /* JADX INFO: compiled from: source.java */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f74102a;

        static {
            int[] iArr = new int[WorkerAnalyseType.values().length];
            try {
                iArr[WorkerAnalyseType.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WorkerAnalyseType.CREATE_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[WorkerAnalyseType.CREATE_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[WorkerAnalyseType.LOAD_JS_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[WorkerAnalyseType.LOAD_JS_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[WorkerAnalyseType.EXECUTE_JS_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[WorkerAnalyseType.EXECUTE_JS_END_1.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[WorkerAnalyseType.EXECUTE_JS_END_2.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[WorkerAnalyseType.SEND_TO_NATIVE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[WorkerAnalyseType.ERROR.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[WorkerAnalyseType.CONSOLE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            f74102a = iArr;
        }
    }
}
