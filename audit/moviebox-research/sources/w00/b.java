package w00;

import okhttp3.ResponseBody;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class b implements a<ResponseBody, Void> {
    @Override // w00.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Void a(ResponseBody responseBody) {
        responseBody.close();
        return null;
    }
}
