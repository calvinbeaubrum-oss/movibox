package tm;

import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.transsion.baselib.db.download.DownloadBean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hm.a f77234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f77235b;

    public j(hm.a aVar) {
        this.f77234a = aVar;
        this.f77235b = new r(aVar);
    }

    public static j a(hm.a aVar) {
        if (aVar.h(1)) {
            return new g(aVar);
        }
        if (!aVar.h(2)) {
            return new k(aVar);
        }
        int iG = r.g(aVar, 1, 4);
        if (iG == 4) {
            return new a(aVar);
        }
        if (iG == 5) {
            return new b(aVar);
        }
        int iG2 = r.g(aVar, 1, 5);
        if (iG2 == 12) {
            return new c(aVar);
        }
        if (iG2 == 13) {
            return new d(aVar);
        }
        switch (r.g(aVar, 1, 7)) {
            case 56:
                return new e(aVar, "310", PrepareException.ERROR_DOWNLOAD_PACKAGE_URL_EMPTY);
            case DownloadBean.STATUS_COMPLETED_REMOVED /* 57 */:
                return new e(aVar, "320", PrepareException.ERROR_DOWNLOAD_PACKAGE_URL_EMPTY);
            case 58:
                return new e(aVar, "310", PrepareException.ERROR_WARMUP_DOWNLOAD_EXCEPTION);
            case 59:
                return new e(aVar, "320", PrepareException.ERROR_WARMUP_DOWNLOAD_EXCEPTION);
            case 60:
                return new e(aVar, "310", PrepareException.ERROR_FILE2VURL_MINIAPP_FILE_EXCEPTION);
            case 61:
                return new e(aVar, "320", PrepareException.ERROR_FILE2VURL_MINIAPP_FILE_EXCEPTION);
            case 62:
                return new e(aVar, "310", "17");
            case 63:
                return new e(aVar, "320", "17");
            default:
                throw new IllegalStateException("unknown decoder: " + aVar);
        }
    }

    public final r b() {
        return this.f77235b;
    }

    public final hm.a c() {
        return this.f77234a;
    }

    public abstract String d() throws NotFoundException, FormatException;
}
