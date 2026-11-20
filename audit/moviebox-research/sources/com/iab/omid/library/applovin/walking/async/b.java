package com.iab.omid.library.applovin.walking.async;

import android.os.AsyncTask;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class b extends AsyncTask<Object, Void, String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f42202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final InterfaceC0466b f42203b;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(b bVar);
    }

    /* JADX INFO: renamed from: com.iab.omid.library.applovin.walking.async.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public interface InterfaceC0466b {
        JSONObject a();

        void a(JSONObject jSONObject);
    }

    public b(InterfaceC0466b interfaceC0466b) {
        this.f42203b = interfaceC0466b;
    }

    public void a(a aVar) {
        this.f42202a = aVar;
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        a aVar = this.f42202a;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void a(ThreadPoolExecutor threadPoolExecutor) {
        executeOnExecutor(threadPoolExecutor, new Object[0]);
    }
}
