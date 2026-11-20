package com.cloud.tmc.integration.structure.impl;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.cloud.tmc.integration.proxy.AppFactory;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppManager;
import com.cloud.tmc.integration.structure.node.AppNode;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.node.NodeInstance;
import java.util.Iterator;
import java.util.Stack;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Keep
public final class AppManagerImpl extends NodeInstance implements AppManager {
    public static final Parcelable.Creator<AppManagerImpl> CREATOR = new a();
    private final Stack<App> mAppStack;

    /* JADX INFO: compiled from: source.java */
    public class a implements Parcelable.Creator<AppManagerImpl> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AppManagerImpl createFromParcel(Parcel parcel) {
            return new AppManagerImpl(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public AppManagerImpl[] newArray(int i11) {
            return new AppManagerImpl[i11];
        }
    }

    public AppManagerImpl() {
        this.mAppStack = new Stack<>();
    }

    public AppManagerImpl(Parcel parcel) {
        super(parcel);
        this.mAppStack = new Stack<>();
    }

    @Override // com.cloud.tmc.integration.structure.AppManager
    public synchronized void exitApp(App app) {
        if (app != null) {
            app.exit();
            this.mAppStack.remove(app);
            removeChild(app);
        }
    }

    @Override // com.cloud.tmc.integration.structure.AppManager
    public synchronized App findApp(long j11) {
        return (App) getChild(j11);
    }

    @Override // com.cloud.tmc.integration.structure.AppManager
    @Nullable
    public synchronized App findApp(String str) {
        Stack<App> appStack = getAppStack();
        for (int size = appStack.size() - 1; size >= 0; size--) {
            App app = appStack.get(size);
            if (app.getAppId().equals(str)) {
                return app;
            }
        }
        return null;
    }

    @Override // com.cloud.tmc.integration.structure.AppManager
    public synchronized App findAppByToken(long j11) {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            App app = (App) getChildAt(i11);
            if (app.getStartToken() == j11) {
                return app;
            }
        }
        return null;
    }

    @Override // com.cloud.tmc.integration.structure.AppManager
    public synchronized Stack<App> getAppStack() {
        Stack<App> stack;
        stack = new Stack<>();
        Iterator<App> it = this.mAppStack.iterator();
        while (it.hasNext()) {
            stack.push(it.next());
        }
        return stack;
    }

    @Override // com.cloud.tmc.integration.structure.AppManager
    public synchronized App startApp(String str, Bundle bundle, Bundle bundle2) {
        AppNode appNodeCreateApp;
        try {
            TmcLogger.m("App", "Start create app");
            appNodeCreateApp = ((AppFactory) tc.a.a(AppFactory.class)).createApp();
            appNodeCreateApp.init(str, bundle, bundle2);
            pushChild(appNodeCreateApp);
            if (this.mAppStack.size() > 1) {
                TmcLogger.e("mAppStack size > 1 !!!");
            }
            this.mAppStack.push(appNodeCreateApp);
        } catch (Throwable th2) {
            throw th2;
        }
        return appNodeCreateApp;
    }

    @Override // com.cloud.tmc.kernel.node.NodeInstance, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        super.writeToParcel(parcel, i11);
    }
}
