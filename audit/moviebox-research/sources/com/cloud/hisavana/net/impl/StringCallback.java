package com.cloud.hisavana.net.impl;

import java.io.UnsupportedEncodingException;
import okhttp3.Headers;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class StringCallback extends HttpCallbackImpl {
    public StringCallback() {
    }

    public StringCallback(boolean z11) {
        super(z11);
    }

    public static String x(byte[] bArr, String str) throws UnsupportedEncodingException {
        String str2 = bArr == null ? null : new String(bArr, str);
        if (str2 == null) {
            return str2;
        }
        try {
            return str2.startsWith("\ufeff") ? str2.substring(1) : str2;
        } catch (Exception unused) {
            return str2;
        }
    }

    @Override // com.cloud.hisavana.net.impl.HttpCallbackImpl
    public void j(final int i11, byte[] bArr, final Throwable th2) {
        try {
            final String strX = x(bArr, "UTF-8");
            r(new Runnable() { // from class: com.cloud.hisavana.net.impl.StringCallback.3
                @Override // java.lang.Runnable
                public void run() {
                    StringCallback.this.y(i11, strX, th2);
                }
            });
        } catch (Exception e11) {
            r(new Runnable() { // from class: com.cloud.hisavana.net.impl.StringCallback.4
                @Override // java.lang.Runnable
                public void run() {
                    StringCallback.this.y(i11, null, e11.getCause());
                }
            });
        }
    }

    @Override // com.cloud.hisavana.net.impl.HttpCallbackImpl
    public void m(Headers headers) {
    }

    @Override // com.cloud.hisavana.net.impl.HttpCallbackImpl
    public void o(final int i11, byte[] bArr) {
        try {
            final String strX = x(bArr, "UTF-8");
            r(new Runnable() { // from class: com.cloud.hisavana.net.impl.StringCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    StringCallback.this.z(i11, strX);
                }
            });
        } catch (Exception e11) {
            r(new Runnable() { // from class: com.cloud.hisavana.net.impl.StringCallback.2
                @Override // java.lang.Runnable
                public void run() {
                    StringCallback.this.y(i11, null, e11.getCause());
                }
            });
        }
    }

    public abstract void y(int i11, String str, Throwable th2);

    public abstract void z(int i11, String str);
}
