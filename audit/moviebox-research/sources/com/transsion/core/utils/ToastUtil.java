package com.transsion.core.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class ToastUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Handler f51839a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Toast f51840b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Field f51841c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Field f51842d;

    /* JADX INFO: renamed from: com.transsion.core.utils.ToastUtil$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ Context val$context;
        final /* synthetic */ int val$resid;

        public AnonymousClass1(int i11, Context context) {
            this.val$resid = i11;
            this.val$context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ToastUtil.f51840b != null) {
                ToastUtil.f51840b.setText(this.val$resid);
                ToastUtil.f51840b.setDuration(0);
                ToastUtil.d(ToastUtil.f51840b);
            } else {
                Toast unused = ToastUtil.f51840b = Toast.makeText(this.val$context.getApplicationContext(), this.val$resid, 0);
            }
            ToastUtil.f51840b.show();
        }
    }

    /* JADX INFO: renamed from: com.transsion.core.utils.ToastUtil$3, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    final class AnonymousClass3 implements Runnable {
        final /* synthetic */ Context val$context;
        final /* synthetic */ int val$resid;

        public AnonymousClass3(int i11, Context context) {
            this.val$resid = i11;
            this.val$context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ToastUtil.f51840b != null) {
                ToastUtil.f51840b.setText(this.val$resid);
                ToastUtil.f51840b.setDuration(1);
                ToastUtil.d(ToastUtil.f51840b);
            } else {
                Toast unused = ToastUtil.f51840b = Toast.makeText(this.val$context.getApplicationContext(), this.val$resid, 1);
            }
            ToastUtil.f51840b.show();
        }
    }

    /* JADX INFO: renamed from: com.transsion.core.utils.ToastUtil$4, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    final class AnonymousClass4 implements Runnable {
        final /* synthetic */ Context val$context;
        final /* synthetic */ String val$msg;

        public AnonymousClass4(String str, Context context) {
            this.val$msg = str;
            this.val$context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ToastUtil.f51840b != null) {
                ToastUtil.f51840b.setText(this.val$msg);
                ToastUtil.f51840b.setDuration(1);
                ToastUtil.d(ToastUtil.f51840b);
            } else {
                Toast unused = ToastUtil.f51840b = Toast.makeText(this.val$context.getApplicationContext(), this.val$msg, 1);
            }
            ToastUtil.f51840b.show();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Handler f51843a;

        public a(Handler handler) {
            this.f51843a = handler;
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
            this.f51843a.handleMessage(message);
        }
    }

    static {
        try {
            Field declaredField = Toast.class.getDeclaredField("mTN");
            f51841c = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = f51841c.getType().getDeclaredField("mHandler");
            f51842d = declaredField2;
            declaredField2.setAccessible(true);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static void d(Toast toast) {
        try {
            Object obj = f51841c.get(toast);
            Handler handler = (Handler) f51842d.get(obj);
            if (handler == null || (handler instanceof a)) {
                return;
            }
            f51842d.set(obj, new a(handler));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static void e(final String str) {
        final Context contextA = ws.a.a();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f51839a.post(new Runnable() { // from class: com.transsion.core.utils.ToastUtil.2
            @Override // java.lang.Runnable
            public void run() {
                if (ToastUtil.f51840b != null) {
                    ToastUtil.f51840b.setText(str);
                    ToastUtil.f51840b.setDuration(0);
                    ToastUtil.d(ToastUtil.f51840b);
                } else {
                    Toast unused = ToastUtil.f51840b = Toast.makeText(contextA.getApplicationContext(), str, 0);
                }
                ToastUtil.f51840b.show();
            }
        });
    }
}
