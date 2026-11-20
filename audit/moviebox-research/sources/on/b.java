package on;

import android.os.AsyncTask;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class b extends AsyncTask<Object, Void, String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f72493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC0782b f72494b;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(b bVar);
    }

    /* JADX INFO: renamed from: on.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public interface InterfaceC0782b {
        JSONObject a();

        void a(JSONObject jSONObject);
    }

    public b(InterfaceC0782b interfaceC0782b) {
        this.f72494b = interfaceC0782b;
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        a aVar = this.f72493a;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void b(ThreadPoolExecutor threadPoolExecutor) {
        executeOnExecutor(threadPoolExecutor, new Object[0]);
    }

    public void c(a aVar) {
        this.f72493a = aVar;
    }
}
