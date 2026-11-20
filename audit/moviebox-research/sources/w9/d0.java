package w9;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;
import android.webkit.WebResourceResponse;
import java.io.ByteArrayInputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class d0 {
    public static WebResourceResponse a(String str) {
        if (TextUtils.isEmpty(str) || !str.endsWith("_tmc_load_ok.png")) {
            return null;
        }
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAAAAAA6fptVAAAACklEQVQYV2P4DwABAQEAWk1v8QAAAABJRU5ErkJggg==".getBytes());
            MimeTypeMap.getSingleton();
            String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
            if (TextUtils.isEmpty(fileExtensionFromUrl)) {
                return null;
            }
            return new WebResourceResponse(MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl), "UTF-8", byteArrayInputStream);
        } catch (Exception e11) {
            com.cloud.hisavana.sdk.z.a().d("ssp", Log.getStackTraceString(e11));
            return null;
        }
    }
}
