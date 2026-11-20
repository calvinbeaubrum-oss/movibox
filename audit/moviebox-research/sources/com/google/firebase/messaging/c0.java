package com.google.firebase.messaging;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class c0 implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final URL f40826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public volatile Future<?> f40827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public Task<Bitmap> f40828c;

    public c0(URL url) {
        this.f40826a = url;
    }

    @Nullable
    public static c0 d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new c0(new URL(str));
        } catch (MalformedURLException unused) {
            Log.w("FirebaseMessaging", "Not downloading image, bad URL: " + str);
            return null;
        }
    }

    public Bitmap b() throws IOException {
        if (Log.isLoggable("FirebaseMessaging", 4)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Starting download of: ");
            sb2.append(this.f40826a);
        }
        byte[] bArrC = c();
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrC, 0, bArrC.length);
        if (bitmapDecodeByteArray == null) {
            throw new IOException("Failed to decode image: " + this.f40826a);
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Successfully downloaded image: ");
            sb3.append(this.f40826a);
        }
        return bitmapDecodeByteArray;
    }

    public final byte[] c() throws IOException {
        URLConnection uRLConnectionOpenConnection = this.f40826a.openConnection();
        if (uRLConnectionOpenConnection.getContentLength() > 1048576) {
            throw new IOException("Content-Length exceeds max size of 1048576");
        }
        InputStream inputStream = uRLConnectionOpenConnection.getInputStream();
        try {
            byte[] bArrD = b.d(b.b(inputStream, 1048577L));
            if (inputStream != null) {
                inputStream.close();
            }
            if (Log.isLoggable("FirebaseMessaging", 2)) {
                Log.v("FirebaseMessaging", "Downloaded " + bArrD.length + " bytes from " + this.f40826a);
            }
            if (bArrD.length <= 1048576) {
                return bArrD;
            }
            throw new IOException("Image exceeds max size of 1048576");
        } catch (Throwable th2) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f40827b.cancel(true);
    }

    public Task<Bitmap> e() {
        return (Task) Preconditions.checkNotNull(this.f40828c);
    }

    public final /* synthetic */ void g(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(b());
        } catch (Exception e11) {
            taskCompletionSource.setException(e11);
        }
    }

    public void h(ExecutorService executorService) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f40827b = executorService.submit(new Runnable() { // from class: com.google.firebase.messaging.b0
            @Override // java.lang.Runnable
            public final void run() {
                this.f40823a.g(taskCompletionSource);
            }
        });
        this.f40828c = taskCompletionSource.getTask();
    }
}
