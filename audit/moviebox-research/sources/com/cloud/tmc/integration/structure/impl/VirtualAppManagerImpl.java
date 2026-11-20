package com.cloud.tmc.integration.structure.impl;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.cloud.tmc.integration.proxy.AppFactory;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.VirtualAppManager;
import com.cloud.tmc.integration.structure.node.AppNode;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.node.NodeInstance;
import java.util.Iterator;
import java.util.Stack;
import kotlin.Metadata;
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
@Keep
@Metadata
public final class VirtualAppManagerImpl extends NodeInstance implements VirtualAppManager {
    public static final a CREATOR = new a(null);
    private final Stack<App> mVirtualAppStack;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<VirtualAppManagerImpl> {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VirtualAppManagerImpl createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new VirtualAppManagerImpl(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public VirtualAppManagerImpl[] newArray(int i11) {
            return new VirtualAppManagerImpl[i11];
        }
    }

    public VirtualAppManagerImpl() {
        this.mVirtualAppStack = new Stack<>();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VirtualAppManagerImpl(Parcel parcel) {
        this();
        Intrinsics.g(parcel, "parcel");
    }

    @Override // com.cloud.tmc.kernel.node.NodeInstance, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.cloud.tmc.integration.structure.AppManager
    public synchronized void exitApp(App app) {
        if (app != null) {
            this.mVirtualAppStack.remove(app);
        }
    }

    @Override // com.cloud.tmc.integration.structure.AppManager
    public synchronized App findApp(long j11) {
        return null;
    }

    @Override // com.cloud.tmc.integration.structure.AppManager
    public synchronized App findApp(String str) {
        Stack<App> appStack = getAppStack();
        int size = appStack.size() - 1;
        if (size >= 0) {
            while (true) {
                int i11 = size - 1;
                App app = appStack.get(size);
                if (Intrinsics.b(app.getAppId(), str)) {
                    return app;
                }
                if (i11 >= 0) {
                    size = i11;
                }
            }
        }
        return null;
    }

    @Override // com.cloud.tmc.integration.structure.AppManager
    public synchronized App findAppByToken(long j11) {
        return null;
    }

    @Override // com.cloud.tmc.integration.structure.AppManager
    public synchronized Stack<App> getAppStack() {
        Stack<App> stack;
        stack = new Stack<>();
        Iterator<App> it = this.mVirtualAppStack.iterator();
        while (it.hasNext()) {
            stack.push(it.next());
        }
        return stack;
    }

    @Override // com.cloud.tmc.integration.structure.AppManager
    public synchronized App startApp(String str, Bundle bundle, Bundle bundle2) {
        AppNode appNodeCreateVirtualApp;
        TmcLogger.m("VirtualApp", "Start create app");
        appNodeCreateVirtualApp = ((AppFactory) tc.a.a(AppFactory.class)).createVirtualApp();
        Intrinsics.f(appNodeCreateVirtualApp, "get(AppFactory::class.java).createVirtualApp()");
        appNodeCreateVirtualApp.init(str, bundle, bundle2);
        this.mVirtualAppStack.push(appNodeCreateVirtualApp);
        return appNodeCreateVirtualApp;
    }

    @Override // com.cloud.tmc.integration.structure.VirtualAppManager
    public synchronized void updateAppInfo(App app) {
        Intrinsics.g(app, "app");
        int size = this.mVirtualAppStack.size() - 1;
        if (size >= 0) {
            while (true) {
                int i11 = size - 1;
                if (Intrinsics.b(this.mVirtualAppStack.get(size).getAppId(), app.getAppId())) {
                    this.mVirtualAppStack.set(size, app);
                }
                if (i11 < 0) {
                    break;
                } else {
                    size = i11;
                }
            }
        }
    }

    @Override // com.cloud.tmc.kernel.node.NodeInstance, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        Intrinsics.g(parcel, "parcel");
        super.writeToParcel(parcel, i11);
    }
}
