package com.cloud.sdk.commonutil.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@SuppressLint({"SoonBlockedPrivateApi"})
public class HSToastUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Handler f30265a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Toast f30266b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Field f30267c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Field f30268d;

    /* JADX INFO: renamed from: com.cloud.sdk.commonutil.util.HSToastUtil$3, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ Context val$context;
        final /* synthetic */ int val$resId;

        public AnonymousClass3(int i11, Context context) {
            this.val$resId = i11;
            this.val$context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (HSToastUtil.f30266b != null) {
                HSToastUtil.f30266b.setText(this.val$resId);
                HSToastUtil.f30266b.setDuration(1);
                HSToastUtil.d(HSToastUtil.f30266b);
            } else {
                Toast unused = HSToastUtil.f30266b = Toast.makeText(this.val$context.getApplicationContext(), this.val$resId, 1);
            }
            HSToastUtil.f30266b.show();
        }
    }

    /* JADX INFO: renamed from: com.cloud.sdk.commonutil.util.HSToastUtil$4, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ Context val$context;
        final /* synthetic */ String val$text;

        public AnonymousClass4(String str, Context context) {
            this.val$text = str;
            this.val$context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (HSToastUtil.f30266b != null) {
                HSToastUtil.f30266b.setText(this.val$text);
                HSToastUtil.f30266b.setDuration(1);
                HSToastUtil.d(HSToastUtil.f30266b);
            } else {
                Toast unused = HSToastUtil.f30266b = Toast.makeText(this.val$context.getApplicationContext(), this.val$text, 1);
            }
            HSToastUtil.f30266b.show();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Handler f30269a;

        public a(Handler handler) {
            this.f30269a = handler;
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            try {
                super.dispatchMessage(message);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.f30269a.handleMessage(message);
        }
    }

    static {
        try {
            Field declaredField = Toast.class.getDeclaredField("mTN");
            f30267c = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = f30267c.getType().getDeclaredField("mHandler");
            f30268d = declaredField2;
            declaredField2.setAccessible(true);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static void d(Toast toast) {
        try {
            Object obj = f30267c.get(toast);
            Handler handler = (Handler) f30268d.get(obj);
            if (handler == null || (handler instanceof a)) {
                return;
            }
            f30268d.set(obj, new a(handler));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static void e(final int i11) {
        final Context contextA = f.a();
        if (i11 > 0) {
            f30265a.post(new Runnable() { // from class: com.cloud.sdk.commonutil.util.HSToastUtil.1
                @Override // java.lang.Runnable
                public void run() {
                    if (HSToastUtil.f30266b != null) {
                        HSToastUtil.f30266b.setText(i11);
                        HSToastUtil.f30266b.setDuration(0);
                        HSToastUtil.d(HSToastUtil.f30266b);
                    } else {
                        Toast unused = HSToastUtil.f30266b = Toast.makeText(contextA.getApplicationContext(), i11, 0);
                    }
                    HSToastUtil.f30266b.show();
                }
            });
        }
    }

    public static void f(final String str) {
        final Context contextA = f.a();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f30265a.post(new Runnable() { // from class: com.cloud.sdk.commonutil.util.HSToastUtil.2
            @Override // java.lang.Runnable
            public void run() {
                if (HSToastUtil.f30266b != null) {
                    HSToastUtil.f30266b.setText(str);
                    HSToastUtil.f30266b.setDuration(0);
                    HSToastUtil.d(HSToastUtil.f30266b);
                } else {
                    Toast unused = HSToastUtil.f30266b = Toast.makeText(contextA.getApplicationContext(), str, 0);
                }
                HSToastUtil.f30266b.show();
            }
        });
    }
}
