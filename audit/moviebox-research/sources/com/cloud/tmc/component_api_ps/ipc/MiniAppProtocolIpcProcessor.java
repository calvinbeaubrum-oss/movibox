package com.cloud.tmc.component_api_ps.ipc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
import com.cloud.tmc.component_api_ps.async.MiniAppIpcAsyncManager;
import com.cloud.tmc.component_api_ps.ipc.MiniAppProtocolIpcProcessor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import oa.b;

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
public final class MiniAppProtocolIpcProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MiniAppProtocolIpcProcessor f30350a = new MiniAppProtocolIpcProcessor();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f30351b = LazyKt__LazyJVMKt.b(new Function0<ConcurrentHashMap<String, b>>() { // from class: com.cloud.tmc.component_api_ps.ipc.MiniAppProtocolIpcProcessor$callbackMap$2
        @Override // kotlin.jvm.functions.Function0
        public final ConcurrentHashMap<String, b> invoke() {
            return new ConcurrentHashMap<>();
        }
    });

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<String> f30352a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function2<pd.a, String, Unit> f30353b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f30354c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Context f30355d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ b f30356f;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Ref.ObjectRef<String> objectRef, Function2<? super pd.a, ? super String, Unit> function2, long j11, Context context, b bVar) {
            this.f30352a = objectRef;
            this.f30353b = function2;
            this.f30354c = j11;
            this.f30355d = context;
            this.f30356f = bVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                la.b.a("MiniAppProtocolIpcProcessor", "onServiceConnected,callbackId:" + this.f30352a.element);
                pd.a aVarE0 = pd.a.AbstractBinderC0801a.e0(iBinder);
                try {
                    Function2<pd.a, String, Unit> function2 = this.f30353b;
                    if (function2 != null) {
                        function2.invoke(aVarE0, this.f30352a.element);
                    }
                } catch (Throwable th2) {
                    la.b.c("MiniAppProtocolIpcProcessor", "", th2);
                }
                try {
                    la.b.a("MiniAppProtocolIpcProcessor", "ipc used time:" + (SystemClock.elapsedRealtime() - this.f30354c) + "ms");
                } catch (Throwable th3) {
                    la.b.c("MiniAppProtocolIpcProcessor", "", th3);
                }
                try {
                    this.f30355d.unbindService(this);
                } catch (Throwable th4) {
                    la.b.c("MiniAppProtocolIpcProcessor", "", th4);
                }
            } catch (Throwable th5) {
                MiniAppProtocolIpcProcessor.f30350a.e(this.f30352a.element, this.f30356f);
                la.b.c("MiniAppProtocolIpcProcessor", "Exception startService", th5);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            System.out.println((Object) "connect fail");
            la.b.a("MiniAppProtocolIpcProcessor", "onServiceDisconnected,callbackId:" + this.f30352a.element);
        }
    }

    public static final void f(b bVar) {
        if (bVar != null) {
            bVar.a(-199, "happened exception");
        }
    }

    public static final void h(b bVar, Bundle bundle) {
        if (bVar != null) {
            bVar.b(bundle);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.String] */
    public static final void l(b bVar, Context context, String str, Bundle bundle, Function2 function2) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (bVar != null) {
            try {
                objectRef.element = String.valueOf(SystemClock.elapsedRealtime());
                f30350a.i().put(objectRef.element, bVar);
            } catch (Throwable th2) {
                f30350a.e((String) objectRef.element, bVar);
                la.b.c("MiniAppProtocolIpcProcessor", "", th2);
                return;
            }
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(str, "com.cloud.tmc.component_api_ps.ipc.service.MiniAppProtocolMainService"));
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        CharSequence charSequence = (CharSequence) objectRef.element;
        if (charSequence != null && charSequence.length() != 0) {
            intent.putExtra("miniAppPSChannelIpcCallbackId", (String) objectRef.element);
        }
        intent.putExtra("miniAppPSChannelIpcPkg", context.getPackageName());
        la.b.a("MiniAppProtocolIpcProcessor", "startIpcInvoke,intent:" + la.a.f70162a.b(intent) + ",callbackId:" + ((String) objectRef.element));
        context.bindService(intent, new a(objectRef, function2, SystemClock.elapsedRealtime(), context, bVar), 1);
    }

    public final void e(String str, final b bVar) {
        try {
            la.b.a("MiniAppProtocolIpcProcessor", "exceptionCallback,callbackId:" + str);
            MiniAppIpcAsyncManager.f30347a.e(new Runnable() { // from class: na.d
                @Override // java.lang.Runnable
                public final void run() {
                    MiniAppProtocolIpcProcessor.f(bVar);
                }
            });
            if (str == null || str.length() == 0 || !i().containsKey(str)) {
                return;
            }
            i().remove(str);
            la.b.a("MiniAppProtocolIpcProcessor", "exceptionCallback,removed callbackId:" + str);
        } catch (Throwable th2) {
            la.b.c("MiniAppProtocolIpcProcessor", "", th2);
        }
    }

    public final boolean g(String str, final Bundle bundle) {
        try {
            la.b.a("MiniAppProtocolIpcProcessor", "executeCallback,callbackId:" + str);
            if (str != null && str.length() != 0 && i().containsKey(str)) {
                final b bVar = i().get(str);
                MiniAppIpcAsyncManager.f30347a.e(new Runnable() { // from class: na.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        MiniAppProtocolIpcProcessor.h(bVar, bundle);
                    }
                });
                i().remove(str);
                la.b.a("MiniAppProtocolIpcProcessor", "executeCallback,removed callbackId:" + str);
                return true;
            }
            return false;
        } catch (Throwable th2) {
            la.b.c("MiniAppProtocolIpcProcessor", "", th2);
            return false;
        }
    }

    public final ConcurrentHashMap<String, b> i() {
        return (ConcurrentHashMap) f30351b.getValue();
    }

    public final void j(Context context, String str, final b bVar, final Function2<? super pd.a, ? super String, Unit> function2, final Bundle bundle) {
        try {
            if (context == null) {
                la.b.a("MiniAppProtocolIpcProcessor", "startIpcInvoke context is empty");
                return;
            }
            final Context applicationContext = context.getApplicationContext();
            final String packageName = applicationContext.getPackageName();
            if (packageName == null || packageName.length() != 0) {
                MiniAppIpcAsyncManager.f30347a.d(new Runnable() { // from class: na.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        MiniAppProtocolIpcProcessor.l(bVar, applicationContext, packageName, bundle, function2);
                    }
                });
            } else {
                la.b.a("MiniAppProtocolIpcProcessor", "startIpcInvoke negativeScreenPkgName is empty");
            }
        } catch (Throwable th2) {
            la.b.c("MiniAppProtocolIpcProcessor", "", th2);
        }
    }
}
