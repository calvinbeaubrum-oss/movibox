package com.hisavana.mintegral.check;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.MBridgeSDK;
import com.mbridge.msdk.out.MBridgeSDKFactory;
import com.mbridge.msdk.out.SDKInitStatusListener;
import com.mbridge.msdk.system.MBridgeSDKImpl;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class MBridgeSDKManager {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static MBridgeSDKInitializeState f41967e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile String f41968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile String f41969b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile MBridgeSDKInitializeListener f41970c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MBridgeSDK f41971d;

    /* JADX INFO: compiled from: source.java */
    public static final class ClassHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final MBridgeSDKManager f41972a = new MBridgeSDKManager();
    }

    /* JADX INFO: compiled from: source.java */
    public static class DefaultSDKInitStatusListener implements SDKInitStatusListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f41973a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f41974b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public MBridgeSDKInitializeListener f41975c;

        public DefaultSDKInitStatusListener(String str, String str2, MBridgeSDKInitializeListener mBridgeSDKInitializeListener) {
            this.f41973a = str;
            this.f41974b = str2;
            this.f41975c = mBridgeSDKInitializeListener;
        }

        @Override // com.mbridge.msdk.out.SDKInitStatusListener
        public void onInitFail(String str) {
            MBridgeSDKInitializeState unused = MBridgeSDKManager.f41967e = MBridgeSDKInitializeState.SDK_STATE_INITIALIZE_FAILURE;
            MBridgeSDKInitializeListener mBridgeSDKInitializeListener = this.f41975c;
            if (mBridgeSDKInitializeListener != null) {
                mBridgeSDKInitializeListener.onInitializeFailure("sdk initialize failed： an exception occurs");
            }
        }

        @Override // com.mbridge.msdk.out.SDKInitStatusListener
        public void onInitSuccess() {
            MBridgeSDKInitializeState unused = MBridgeSDKManager.f41967e = MBridgeSDKInitializeState.SDK_STATE_INITIALIZE_SUCCESS;
            MBridgeSDKInitializeListener mBridgeSDKInitializeListener = this.f41975c;
            if (mBridgeSDKInitializeListener != null) {
                mBridgeSDKInitializeListener.onInitializeSuccess(this.f41973a, this.f41974b);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface MBridgeSDKInitializeListener {
        void onInitializeFailure(String str);

        void onInitializeSuccess(String str, String str2);
    }

    /* JADX INFO: compiled from: source.java */
    public enum MBridgeSDKInitializeState {
        SDK_STATE_UN_INITIALIZE,
        SDK_STATE_INITIALIZING,
        SDK_STATE_INITIALIZE_SUCCESS,
        SDK_STATE_INITIALIZE_FAILURE
    }

    public MBridgeSDKManager() {
        f41967e = MBridgeSDKInitializeState.SDK_STATE_UN_INITIALIZE;
    }

    public static MBridgeSDKManager getInstance() {
        return ClassHolder.f41972a;
    }

    public final void b(Context context, boolean z11, Map<String, String> map, MBridgeSDKInitializeListener mBridgeSDKInitializeListener) {
        try {
            MBridgeConstans.DEBUG = z11;
            MBridgeSDKImpl mBridgeSDK = MBridgeSDKFactory.getMBridgeSDK();
            this.f41971d = mBridgeSDK;
            Map<String, String> mBConfigurationMap = mBridgeSDK.getMBConfigurationMap(this.f41969b, this.f41968a, "");
            if (map != null && !map.isEmpty()) {
                mBConfigurationMap.putAll(map);
            }
            this.f41971d.init(mBConfigurationMap, context, new DefaultSDKInitStatusListener(this.f41968a, this.f41969b, this.f41970c));
        } catch (Exception e11) {
            f41967e = MBridgeSDKInitializeState.SDK_STATE_INITIALIZE_FAILURE;
            if (this.f41970c != null) {
                mBridgeSDKInitializeListener.onInitializeFailure(e11.getMessage());
            }
        }
    }

    public final boolean c(Context context, String str, String str2) {
        boolean z11;
        String str3;
        boolean z12 = false;
        if (context == null) {
            str3 = "context must not null";
            z11 = false;
        } else {
            z11 = true;
            str3 = "";
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            z12 = z11;
        } else if (TextUtils.isEmpty(str3)) {
            str3 = "appKey or appID must not null";
        } else {
            str3 = str3 + " & appKey or appID must not null";
        }
        if (!z12 && !TextUtils.isEmpty(str3) && this.f41970c != null) {
            f41967e = MBridgeSDKInitializeState.SDK_STATE_INITIALIZE_FAILURE;
            this.f41970c.onInitializeFailure(str3);
        }
        return z12;
    }

    public String getAppID() {
        return this.f41969b;
    }

    public String getAppKey() {
        return this.f41968a;
    }

    public MBridgeSDKInitializeState getCurrentState() {
        return f41967e;
    }

    public MBridgeSDK getMBridgeSDK() {
        return this.f41971d;
    }

    public synchronized void initialize(Context context, String str, String str2) {
        initialize(context, str, str2, false, null, null);
    }

    public synchronized void initialize(Context context, String str, String str2, MBridgeSDKInitializeListener mBridgeSDKInitializeListener) {
        initialize(context, str, str2, false, null, mBridgeSDKInitializeListener);
    }

    public synchronized void initialize(Context context, String str, String str2, boolean z11) {
        initialize(context, str, str2, z11, null, null);
    }

    public synchronized void initialize(Context context, String str, String str2, boolean z11, MBridgeSDKInitializeListener mBridgeSDKInitializeListener) {
        initialize(context, str, str2, z11, null, mBridgeSDKInitializeListener);
    }

    public synchronized void initialize(Context context, String str, String str2, boolean z11, Map<String, String> map) {
        initialize(context, str, str2, z11, map, null);
    }

    public synchronized void initialize(Context context, String str, String str2, boolean z11, Map<String, String> map, MBridgeSDKInitializeListener mBridgeSDKInitializeListener) {
        MBridgeSDKInitializeState mBridgeSDKInitializeState = f41967e;
        MBridgeSDKInitializeState mBridgeSDKInitializeState2 = MBridgeSDKInitializeState.SDK_STATE_INITIALIZING;
        if (mBridgeSDKInitializeState == mBridgeSDKInitializeState2) {
            if (mBridgeSDKInitializeListener != null) {
                mBridgeSDKInitializeListener.onInitializeFailure("sdk is initializing");
            }
            return;
        }
        this.f41970c = mBridgeSDKInitializeListener;
        if (c(context, str, str2)) {
            if (f41967e == MBridgeSDKInitializeState.SDK_STATE_INITIALIZE_SUCCESS && TextUtils.equals(this.f41969b, str2) && TextUtils.equals(this.f41968a, str)) {
                if (this.f41970c != null) {
                    this.f41970c.onInitializeSuccess(this.f41968a, this.f41969b);
                }
            } else {
                f41967e = mBridgeSDKInitializeState2;
                this.f41968a = str;
                this.f41969b = str2;
                b(context, z11, map, this.f41970c);
            }
        }
    }
}
