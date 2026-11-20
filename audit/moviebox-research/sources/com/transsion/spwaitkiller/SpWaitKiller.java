package com.transsion.spwaitkiller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class SpWaitKiller {
    public static final Companion Companion = new Companion(null);
    private HiddenApiExempter hiddenApiExempter;
    private Context mContext;
    private boolean neverProcessWorkOnMainThread;
    private boolean neverWaitingFinishQueue;
    private int targetSdkVersion;
    private UnExpectExceptionCatcher unExpectExceptionCatcher;
    private boolean working;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Builder {
        private Context context;
        private HiddenApiExempter hiddenApiExempter;
        private boolean neverProcessWorkOnMainThread;
        private boolean neverWaitingFinishQueue;
        private UnExpectExceptionCatcher unExpectExceptionCatcher;

        public Builder(Context context) {
            Intrinsics.g(context, "context");
            this.context = context;
            this.neverWaitingFinishQueue = true;
            this.neverProcessWorkOnMainThread = true;
        }

        public final SpWaitKiller build() {
            return new SpWaitKiller(this);
        }

        public final Context getContext() {
            return this.context;
        }

        public final HiddenApiExempter getHiddenApiExempter() {
            return this.hiddenApiExempter;
        }

        public final boolean getNeverProcessWorkOnMainThread() {
            return this.neverProcessWorkOnMainThread;
        }

        public final boolean getNeverWaitingFinishQueue() {
            return this.neverWaitingFinishQueue;
        }

        public final UnExpectExceptionCatcher getUnExpectExceptionCatcher() {
            return this.unExpectExceptionCatcher;
        }

        public final Builder hiddenApiExempter(HiddenApiExempter hiddenApiExempter) {
            this.hiddenApiExempter = hiddenApiExempter;
            return this;
        }

        public final Builder neverProcessWorkOnMainThread(boolean z11) {
            this.neverProcessWorkOnMainThread = z11;
            return this;
        }

        public final Builder neverWaitingFinishQueue(boolean z11) {
            this.neverWaitingFinishQueue = z11;
            return this;
        }

        public final void setContext(Context context) {
            Intrinsics.g(context, "<set-?>");
            this.context = context;
        }

        public final void setHiddenApiExempter(HiddenApiExempter hiddenApiExempter) {
            this.hiddenApiExempter = hiddenApiExempter;
        }

        public final void setNeverProcessWorkOnMainThread(boolean z11) {
            this.neverProcessWorkOnMainThread = z11;
        }

        public final void setNeverWaitingFinishQueue(boolean z11) {
            this.neverWaitingFinishQueue = z11;
        }

        public final void setUnExpectExceptionCatcher(UnExpectExceptionCatcher unExpectExceptionCatcher) {
            this.unExpectExceptionCatcher = unExpectExceptionCatcher;
        }

        public final Builder unExpectExceptionCatcher(UnExpectExceptionCatcher unExpectExceptionCatcher) {
            this.unExpectExceptionCatcher = unExpectExceptionCatcher;
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Builder builder(Context context) {
            Intrinsics.g(context, "context");
            return new Builder(context);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class QueueWorksWorkFieldHooker implements ProxySWork.AboveAndroid12Processor {
        private Looper looper;
        private boolean reflectionFailed;
        private Object sLock;
        private Field sWorkField;

        @SuppressLint({"SoonBlockedPrivateApi"})
        public QueueWorksWorkFieldHooker() {
            try {
                Class<?> cls = Class.forName("android.app.QueuedWork");
                Method declaredMethod = cls.getDeclaredMethod("getHandler", new Class[0]);
                declaredMethod.setAccessible(true);
                Object objInvoke = declaredMethod.invoke(null, new Object[0]);
                Intrinsics.e(objInvoke, "null cannot be cast to non-null type android.os.Handler");
                this.looper = ((Handler) objInvoke).getLooper();
                Field declaredField = cls.getDeclaredField("sWork");
                this.sWorkField = declaredField;
                if (declaredField != null) {
                    declaredField.setAccessible(true);
                }
                Field declaredField2 = cls.getDeclaredField("sLock");
                declaredField2.setAccessible(true);
                this.sLock = declaredField2.get(null);
            } catch (ClassNotFoundException unused) {
                this.reflectionFailed = true;
            } catch (IllegalAccessException unused2) {
                this.reflectionFailed = true;
            } catch (NoSuchFieldException unused3) {
                this.reflectionFailed = true;
            } catch (NoSuchMethodException unused4) {
                this.reflectionFailed = true;
            } catch (InvocationTargetException unused5) {
                this.reflectionFailed = true;
            }
        }

        public final void proxyWork() {
            Object obj;
            Field field;
            Looper looper;
            if (this.reflectionFailed || (obj = this.sLock) == null || (field = this.sWorkField) == null || (looper = this.looper) == null) {
                return;
            }
            synchronized (obj) {
                try {
                    Object obj2 = field.get(null);
                    Intrinsics.e(obj2, "null cannot be cast to non-null type java.util.LinkedList<*>");
                    field.set(null, new ProxySWork((LinkedList) obj2, looper, this));
                } catch (IllegalAccessException unused) {
                    this.reflectionFailed = true;
                }
                Unit unit = Unit.f68710a;
            }
        }

        @Override // com.transsion.spwaitkiller.ProxySWork.AboveAndroid12Processor
        public void reProxySWork() {
            proxyWork();
        }
    }

    public SpWaitKiller(Builder builder) {
        ApplicationInfo applicationInfo;
        Intrinsics.g(builder, "builder");
        if (builder.getHiddenApiExempter() == null) {
            builder.setHiddenApiExempter(new DefaultHiddenApiExempter());
        }
        if (builder.getUnExpectExceptionCatcher() == null) {
            builder.setUnExpectExceptionCatcher(new UnExpectExceptionCatcher() { // from class: com.transsion.spwaitkiller.SpWaitKiller.1
                @Override // com.transsion.spwaitkiller.UnExpectExceptionCatcher
                public void onException(Throwable th2) {
                    Log.e("SpWaitKillerException", StringsKt__IndentKt.f("catch Exception " + Log.getStackTraceString(th2)));
                }
            });
        }
        this.hiddenApiExempter = builder.getHiddenApiExempter();
        this.neverProcessWorkOnMainThread = builder.getNeverProcessWorkOnMainThread();
        this.neverWaitingFinishQueue = builder.getNeverWaitingFinishQueue();
        this.mContext = builder.getContext();
        this.unExpectExceptionCatcher = builder.getUnExpectExceptionCatcher();
        Context context = this.mContext;
        this.targetSdkVersion = (context == null || (applicationInfo = context.getApplicationInfo()) == null) ? 0 : applicationInfo.targetSdkVersion;
    }

    private final void realWork() throws Exception {
        HiddenApiExempter hiddenApiExempter;
        try {
            Class<?> cls = Class.forName("android.app.QueuedWork");
            if (this.neverWaitingFinishQueue) {
                if (Build.VERSION.SDK_INT < 26) {
                    Field declaredField = cls.getDeclaredField("sPendingWorkFinishers");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(null);
                    Intrinsics.e(obj, "null cannot be cast to non-null type java.util.concurrent.ConcurrentLinkedQueue<*>");
                    declaredField.set(null, new ProxyFinishersLinkedList((ConcurrentLinkedQueue) obj));
                } else {
                    Field declaredField2 = cls.getDeclaredField("sFinishers");
                    declaredField2.setAccessible(true);
                    Object obj2 = declaredField2.get(null);
                    Intrinsics.e(obj2, "null cannot be cast to non-null type java.util.LinkedList<*>");
                    declaredField2.set(null, new ProxyFinishersList((LinkedList) obj2));
                }
            }
            if (!this.neverProcessWorkOnMainThread || Build.VERSION.SDK_INT < 26) {
                return;
            }
            if (this.targetSdkVersion >= 30 && (hiddenApiExempter = this.hiddenApiExempter) != null) {
                hiddenApiExempter.exempt(this.mContext);
            }
            new QueueWorksWorkFieldHooker().proxyWork();
        } catch (Exception unused) {
        }
    }

    public final void work() {
        try {
            if (this.working) {
                return;
            }
            realWork();
            this.working = true;
        } catch (Exception e11) {
            UnExpectExceptionCatcher unExpectExceptionCatcher = this.unExpectExceptionCatcher;
            if (unExpectExceptionCatcher != null) {
                unExpectExceptionCatcher.onException(e11);
            }
        }
    }
}
