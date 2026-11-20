package com.cloud.config.utils;

import android.text.TextUtils;
import com.transsion.core.log.ObjectLogUtils;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class XLogUtil {
    private static final int DEBUG = 3;
    private static final int ERROR = 6;
    private static final int INFO = 4;
    private static final int JSON = 9;
    public static final String TAG = "config";
    private static final int VERBOSE = 2;
    private static final int WARN = 5;
    private final ObjectLogUtils logUtils;
    private final int mLoggingLevel;
    public static final Companion Companion = new Companion(null);
    private static ObjectLogUtils NET_LOG = new ObjectLogUtils.a().p("UPDATE_N").q(false).n(false).m();
    private static final Lazy<XLogUtil> log$delegate = LazyKt__LazyJVMKt.b(new Function0<XLogUtil>() { // from class: com.cloud.config.utils.XLogUtil$Companion$log$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final XLogUtil invoke() {
            return XLogUtil.SingletonHolder.INSTANCE.getINSTANCE();
        }
    });

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final XLogUtil getLog() {
            return (XLogUtil) XLogUtil.log$delegate.getValue();
        }

        public final ObjectLogUtils getNET_LOG() {
            return XLogUtil.NET_LOG;
        }

        public final void netLog(String str) {
            getNET_LOG().o(str, new Object[0]);
        }

        public final void setNET_LOG(ObjectLogUtils objectLogUtils) {
            XLogUtil.NET_LOG = objectLogUtils;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class SingletonHolder {
        public static final SingletonHolder INSTANCE = new SingletonHolder();
        private static final XLogUtil INSTANCE$1 = new XLogUtil(null);

        private SingletonHolder() {
        }

        public final XLogUtil getINSTANCE() {
            return INSTANCE$1;
        }
    }

    private XLogUtil() {
        ObjectLogUtils objectLogUtilsM = new ObjectLogUtils.a().p("UPDATE").r(true).n(false).m();
        Intrinsics.f(objectLogUtilsM, "Builder().setGlobalTag(\"…derSwitch(false).create()");
        this.logUtils = objectLogUtilsM;
        this.mLoggingLevel = 2;
        objectLogUtilsM.x(3);
    }

    public /* synthetic */ XLogUtil(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final String getGlobalTag() {
        return "sdk";
    }

    private final void log(int i11, String str, String str2) {
        logWithThrowable(i11, str, str2, null);
    }

    private final void logWithThrowable(int i11, String str, String str2, Throwable th2) {
        try {
            if (shouldLog(i11)) {
                if (!TextUtils.isEmpty(str)) {
                    str = getGlobalTag() + '_' + str;
                }
                if (i11 == 2) {
                    if (th2 != null) {
                        this.logUtils.y(str, str2, th2);
                        return;
                    } else {
                        this.logUtils.y(str, str2);
                        return;
                    }
                }
                if (i11 == 3) {
                    if (th2 != null) {
                        this.logUtils.h(str, str2, th2);
                        return;
                    } else {
                        this.logUtils.h(str, str2);
                        return;
                    }
                }
                if (i11 == 4) {
                    if (th2 != null) {
                        this.logUtils.o(str, str2, th2);
                        return;
                    } else {
                        this.logUtils.o(str, str2);
                        return;
                    }
                }
                if (i11 == 5) {
                    if (th2 != null) {
                        this.logUtils.A(str, str2, th2);
                        return;
                    } else {
                        this.logUtils.A(str, str2);
                        return;
                    }
                }
                if (i11 != 6) {
                    if (i11 != 9) {
                        return;
                    }
                    this.logUtils.q(str, str2);
                } else if (th2 != null) {
                    this.logUtils.j(str, str2, th2);
                } else {
                    this.logUtils.j(str, str2);
                }
            }
        } catch (Exception unused) {
        }
    }

    private final boolean shouldLog(int i11) {
        return i11 >= this.mLoggingLevel;
    }

    public final void d(String tag, int i11) {
        Intrinsics.g(tag, "tag");
        String string = ws.a.a().getString(i11);
        Intrinsics.f(string, "getContext().getString(id)");
        log(3, tag, string);
    }

    public final void d(String tag, String str) {
        Intrinsics.g(tag, "tag");
        log(3, tag, str);
    }

    public final void d(String tag, String str, Throwable th2) {
        Intrinsics.g(tag, "tag");
        log(3, tag, str);
    }

    public final void e(String msg) {
        Intrinsics.g(msg, "msg");
        log(6, "", "******" + msg + "******");
    }

    public final void e(String tag, String msg) {
        Intrinsics.g(tag, "tag");
        Intrinsics.g(msg, "msg");
        log(6, tag, "******" + msg + "******");
    }

    public final void e(String tag, String msg, Throwable th2) {
        Intrinsics.g(tag, "tag");
        Intrinsics.g(msg, "msg");
        logWithThrowable(6, tag, "******" + msg + "******", null);
    }

    public final void i(String tag, String str) {
        Intrinsics.g(tag, "tag");
        log(4, tag, str);
    }

    public final void i(String tag, String str, Throwable th2) {
        Intrinsics.g(tag, "tag");
        logWithThrowable(4, tag, str, null);
    }

    public final void setLogSwitch(boolean z11) {
        this.logUtils.m().r(z11);
    }

    public final void v(String tag, String str) {
        Intrinsics.g(tag, "tag");
        log(2, tag, str);
    }

    public final void v(String tag, String str, Throwable th2) {
        Intrinsics.g(tag, "tag");
        logWithThrowable(2, tag, str, th2);
    }

    public final void w(String tag, String str) {
        Intrinsics.g(tag, "tag");
        log(5, tag, str);
    }

    public final void w(String tag, String str, Throwable th2) {
        Intrinsics.g(tag, "tag");
        logWithThrowable(5, tag, str, null);
    }
}
