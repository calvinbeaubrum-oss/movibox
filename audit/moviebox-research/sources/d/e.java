package d;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.transsion.push.PushConstants;
import com.transsion.push.config.PushRepository;
import com.transsion.push.utils.PushLogUtils;
import com.transsion.push.utils.ThreadManager;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class e {

    /* JADX INFO: compiled from: source.java */
    public class a implements OnCompleteListener<String> {
        @Override // com.google.android.gms.tasks.OnCompleteListener
        public void onComplete(@NonNull Task<String> task) {
            if (task.isSuccessful()) {
                String result = task.getResult();
                if (TextUtils.isEmpty(result)) {
                    return;
                }
                x.g(result);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f62842a;

        /* JADX INFO: compiled from: source.java */
        public class a implements OnCompleteListener<String> {
            public a() {
            }

            @Override // com.google.android.gms.tasks.OnCompleteListener
            public void onComplete(@NonNull Task<String> task) {
                if (task.isSuccessful()) {
                    String result = task.getResult();
                    if (TextUtils.isEmpty(result)) {
                        PushLogUtils.LOG.g("firebase  token is empty");
                        c cVar = b.this.f62842a;
                        if (cVar != null) {
                            cVar.a();
                            return;
                        }
                        return;
                    }
                    PushRepository.getInstance().putSpValue(PushConstants.SP_KEY_FCM_TOKEN, result);
                    c cVar2 = b.this.f62842a;
                    if (cVar2 != null) {
                        cVar2.onSuccess();
                    }
                }
            }
        }

        public b(c cVar) {
            this.f62842a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!e.c()) {
                PushLogUtils.LOG.g("firebase  is not integrated");
                return;
            }
            try {
                FirebaseMessaging.m().p().addOnCompleteListener(new a());
            } catch (Exception e11) {
                PushLogUtils.LOG.i(e11);
                c cVar = this.f62842a;
                if (cVar != null) {
                    cVar.a();
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
        void a();

        void onSuccess();
    }

    public static void a(c cVar) {
        ThreadManager.executeInBackground(new b(cVar));
    }

    public static boolean c() {
        try {
            Object obj = jj.e.f68012k;
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static void d() {
        if (!c()) {
            PushLogUtils.LOG.g("firebase not integrated");
            return;
        }
        try {
            FirebaseMessaging.m().p().addOnCompleteListener(new a());
        } catch (Exception e11) {
            PushLogUtils.LOG.i("updateToken fail" + e11);
        }
    }
}
