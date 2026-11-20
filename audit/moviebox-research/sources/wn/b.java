package wn;

import android.os.AsyncTask;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class b extends AsyncTask<Object, Void, String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f79563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC0893b f79564b;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(b bVar);
    }

    /* JADX INFO: renamed from: wn.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public interface InterfaceC0893b {
        void a(JSONObject jSONObject);

        JSONObject b();
    }

    public b(InterfaceC0893b interfaceC0893b) {
        this.f79564b = interfaceC0893b;
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        a aVar = this.f79563a;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void b(ThreadPoolExecutor threadPoolExecutor) {
        executeOnExecutor(threadPoolExecutor, new Object[0]);
    }

    public void c(a aVar) {
        this.f79563a = aVar;
    }
}
