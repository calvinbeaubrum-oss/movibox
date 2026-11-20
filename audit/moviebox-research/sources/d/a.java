package d;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.transsion.push.bean.PushMessage;
import com.transsion.push.utils.PushLogUtils;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: d.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    public class RunnableC0640a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ PushMessage f62837a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f62838b;

        /* JADX INFO: renamed from: d.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C0641a implements h.d {
            public C0641a() {
            }

            @Override // d.h.d
            public void a(HashMap<String, Bitmap> map) {
                PushLogUtils.LOG.g("images download complete");
                RunnableC0640a runnableC0640a = RunnableC0640a.this;
                b bVar = runnableC0640a.f62838b;
                if (bVar != null) {
                    bVar.a(runnableC0640a.f62837a, map);
                }
            }
        }

        public RunnableC0640a(PushMessage pushMessage, b bVar) {
            this.f62837a = pushMessage;
            this.f62838b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(this.f62837a.notiIcon)) {
                arrayList.add(this.f62837a.notiIcon);
            }
            if (!TextUtils.isEmpty(this.f62837a.notiImgEx)) {
                arrayList.add(this.f62837a.notiImgEx);
            }
            if (!TextUtils.isEmpty(this.f62837a.notiSmallIcon)) {
                arrayList.add(this.f62837a.notiSmallIcon);
            }
            if (!TextUtils.isEmpty(this.f62837a.notiOptionalIcon)) {
                arrayList.add(this.f62837a.notiOptionalIcon);
            }
            if (arrayList.size() > 0) {
                h.b(this.f62837a.notiType, arrayList, new C0641a());
                return;
            }
            b bVar = this.f62838b;
            if (bVar != null) {
                bVar.a(this.f62837a, null);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    public interface b {
        void a(PushMessage pushMessage, HashMap<String, Bitmap> map);
    }

    public static void a(PushMessage pushMessage, b bVar) {
        new Handler(Looper.getMainLooper()).post(new RunnableC0640a(pushMessage, bVar));
    }

    public static boolean b(PushMessage pushMessage) {
        return (!TextUtils.isEmpty(pushMessage.notiIcon) && URLUtil.isValidUrl(pushMessage.notiIcon)) || (!TextUtils.isEmpty(pushMessage.notiSmallIcon) && URLUtil.isValidUrl(pushMessage.notiSmallIcon)) || (!TextUtils.isEmpty(pushMessage.notiImgEx) && URLUtil.isValidUrl(pushMessage.notiImgEx));
    }
}
