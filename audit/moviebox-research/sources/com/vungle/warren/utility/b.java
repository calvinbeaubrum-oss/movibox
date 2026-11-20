package com.vungle.warren.utility;

import android.os.AsyncTask;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Executor f62591a = new p().b();

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f62592a;

        public a(@NonNull c cVar) {
            this.f62592a = cVar;
        }

        public void a() {
            this.f62592a.b();
            this.f62592a.cancel(true);
        }
    }

    /* JADX INFO: renamed from: com.vungle.warren.utility.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public interface InterfaceC0638b {
        void a(boolean z11);
    }

    /* JADX INFO: compiled from: source.java */
    public static class c extends AsyncTask<Void, Void, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final File f62593a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public InterfaceC0638b f62594b;

        public c(@Nullable File file, @NonNull InterfaceC0638b interfaceC0638b) {
            this.f62593a = file;
            this.f62594b = interfaceC0638b;
        }

        public final synchronized void b() {
            this.f62594b = null;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Void... voidArr) {
            File file = this.f62593a;
            return Boolean.valueOf(file != null && file.exists());
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            synchronized (this) {
                try {
                    InterfaceC0638b interfaceC0638b = this.f62594b;
                    if (interfaceC0638b != null) {
                        interfaceC0638b.a(bool.booleanValue());
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public static a a(@Nullable File file, @NonNull InterfaceC0638b interfaceC0638b) {
        c cVar = new c(file, interfaceC0638b);
        a aVar = new a(cVar);
        cVar.executeOnExecutor(f62591a, new Void[0]);
        return aVar;
    }
}
