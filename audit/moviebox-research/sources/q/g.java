package q;

import com.cloud.tmc.kernel.proxy.performanceanalyse.RenderAnalyseType;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f74091a;

    /* JADX INFO: compiled from: source.java */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f74092a;

        static {
            int[] iArr = new int[RenderAnalyseType.values().length];
            try {
                iArr[RenderAnalyseType.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RenderAnalyseType.CREATE_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RenderAnalyseType.CREATE_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[RenderAnalyseType.LOAD_URL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[RenderAnalyseType.LOAD_FINISH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[RenderAnalyseType.LOAD_FAIL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[RenderAnalyseType.ERROR.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[RenderAnalyseType.CONSOLE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            f74092a = iArr;
        }
    }

    public g() {
        RenderAnalyseType renderAnalyseType = RenderAnalyseType.INIT;
    }
}
