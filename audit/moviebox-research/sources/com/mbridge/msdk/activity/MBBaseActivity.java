package com.mbridge.msdk.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.OrientationEventListener;
import android.view.WindowInsets;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.mbridge.msdk.foundation.d.b;
import com.mbridge.msdk.foundation.tools.ad;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class MBBaseActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Display f42638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private OrientationEventListener f42639b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f42640c = -1;

    private void a() {
        try {
            getWindow().addFlags(67108864);
            getWindow().getDecorView().setSystemUiVisibility(InputDeviceCompat.SOURCE_TOUCHSCREEN);
        } catch (Throwable th2) {
            ad.b("MBBaseActivity", th2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b() {
        if (this.f42638a == null) {
            if (Build.VERSION.SDK_INT >= 30) {
                this.f42638a = getDisplay();
            } else {
                this.f42638a = ((WindowManager) getSystemService("window")).getDefaultDisplay();
            }
        }
        Display display = this.f42638a;
        if (display != null) {
            return display.getRotation();
        }
        return -1;
    }

    public static /* synthetic */ void e(MBBaseActivity mBBaseActivity) {
        OrientationEventListener orientationEventListener = new OrientationEventListener(mBBaseActivity, 1) { // from class: com.mbridge.msdk.activity.MBBaseActivity.2
            @Override // android.view.OrientationEventListener
            public final void onOrientationChanged(int i11) {
                int rotation = MBBaseActivity.this.f42638a != null ? MBBaseActivity.this.f42638a.getRotation() : 0;
                if (rotation == 1 && MBBaseActivity.this.f42640c != 1) {
                    MBBaseActivity.this.f42640c = 1;
                    MBBaseActivity.this.getNotchParams();
                    ad.b("MBBaseActivity", "Orientation Left");
                    return;
                }
                if (rotation == 3 && MBBaseActivity.this.f42640c != 2) {
                    MBBaseActivity.this.f42640c = 2;
                    MBBaseActivity.this.getNotchParams();
                    ad.b("MBBaseActivity", "Orientation Right");
                } else if (rotation == 0 && MBBaseActivity.this.f42640c != 3) {
                    MBBaseActivity.this.f42640c = 3;
                    MBBaseActivity.this.getNotchParams();
                    ad.b("MBBaseActivity", "Orientation Top");
                } else {
                    if (rotation != 2 || MBBaseActivity.this.f42640c == 4) {
                        return;
                    }
                    MBBaseActivity.this.f42640c = 4;
                    MBBaseActivity.this.getNotchParams();
                    ad.b("MBBaseActivity", "Orientation Bottom");
                }
            }
        };
        mBBaseActivity.f42639b = orientationEventListener;
        if (orientationEventListener.canDetectOrientation()) {
            mBBaseActivity.f42639b.enable();
        } else {
            mBBaseActivity.f42639b.disable();
            mBBaseActivity.f42639b = null;
        }
    }

    public void getNotchParams() {
        getWindow().getDecorView().postDelayed(new Runnable() { // from class: com.mbridge.msdk.activity.MBBaseActivity.1
            @Override // java.lang.Runnable
            public final void run() {
                int safeInsetRight;
                int safeInsetTop;
                int i11;
                DisplayCutout displayCutout;
                int i12;
                try {
                    int i13 = Build.VERSION.SDK_INT;
                    if (i13 >= 23) {
                        WindowInsets rootWindowInsets = MBBaseActivity.this.getWindow().getDecorView().getRootWindowInsets();
                        int i14 = -1;
                        int i15 = 0;
                        if (rootWindowInsets == null || i13 < 28 || (displayCutout = rootWindowInsets.getDisplayCutout()) == null) {
                            safeInsetRight = 0;
                            safeInsetTop = 0;
                            i11 = 0;
                        } else {
                            int safeInsetLeft = displayCutout.getSafeInsetLeft();
                            safeInsetRight = displayCutout.getSafeInsetRight();
                            safeInsetTop = displayCutout.getSafeInsetTop();
                            int safeInsetBottom = displayCutout.getSafeInsetBottom();
                            ad.b("MBBaseActivity", "NOTCH Left:" + safeInsetLeft + " Right:" + safeInsetRight + " Top:" + safeInsetTop + " Bottom:" + safeInsetBottom);
                            int rotation = MBBaseActivity.this.f42638a != null ? MBBaseActivity.this.f42638a.getRotation() : MBBaseActivity.this.b();
                            if (MBBaseActivity.this.f42640c == -1) {
                                MBBaseActivity mBBaseActivity = MBBaseActivity.this;
                                if (rotation == 0) {
                                    i12 = 3;
                                } else if (rotation == 1) {
                                    i12 = 1;
                                } else if (rotation == 2) {
                                    i12 = 4;
                                } else {
                                    i12 = rotation == 3 ? 2 : -1;
                                }
                                mBBaseActivity.f42640c = i12;
                                ad.b("MBBaseActivity", MBBaseActivity.this.f42640c + "");
                            }
                            if (rotation != 0) {
                                if (rotation == 1) {
                                    i14 = 90;
                                } else if (rotation == 2) {
                                    i14 = 180;
                                } else if (rotation == 3) {
                                    i14 = 270;
                                }
                                i11 = safeInsetBottom;
                                i15 = safeInsetLeft;
                            } else {
                                i11 = safeInsetBottom;
                                i15 = safeInsetLeft;
                                i14 = 0;
                            }
                        }
                        MBBaseActivity.this.setTopControllerPadding(i14, i15, safeInsetRight, safeInsetTop, i11);
                        if (MBBaseActivity.this.f42639b == null) {
                            MBBaseActivity.e(MBBaseActivity.this);
                        }
                    }
                } catch (Exception e11) {
                    ad.b("MBBaseActivity", e11.getMessage());
                }
            }
        }, 500L);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            requestWindowFeature(1);
            getWindow().setFlags(1024, 1024);
            getWindow().addFlags(512);
            a();
            b();
            if (Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                getWindow().setAttributes(attributes);
            }
        } catch (Exception e11) {
            ad.b("MBBaseActivity", e11.getMessage());
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        OrientationEventListener orientationEventListener = this.f42639b;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
            this.f42639b = null;
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        if (b.f44150c) {
            return;
        }
        getNotchParams();
        a();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z11) {
        super.onWindowFocusChanged(z11);
        a();
    }

    public abstract void setTopControllerPadding(int i11, int i12, int i13, int i14, int i15);
}
