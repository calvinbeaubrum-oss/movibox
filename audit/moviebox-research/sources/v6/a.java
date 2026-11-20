package v6;

import com.transsion.push.bean.PushPointInfo;
import com.transsion.push.utils.PushLogUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: v6.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0872a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f78758a = new a();
    }

    public static a a() {
        return C0872a.f78758a;
    }

    public void b(String str) {
        try {
            throw null;
        } catch (Exception e11) {
            PushLogUtils.LOG.i("insert report record fail, e:" + e11.getMessage());
        }
    }

    public void c(List<PushPointInfo> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        try {
            throw null;
        } catch (Exception e11) {
            PushLogUtils.LOG.g("delete msg fail, e:" + e11.getMessage());
        }
    }

    public List<PushPointInfo> d() {
        new ArrayList();
        throw null;
    }
}
