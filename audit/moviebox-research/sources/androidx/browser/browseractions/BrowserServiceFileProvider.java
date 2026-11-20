package androidx.browser.browseractions;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.core.content.FileProvider;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public final class BrowserServiceFileProvider extends FileProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Object f1810a = new Object();

    /* JADX INFO: renamed from: androidx.browser.browseractions.BrowserServiceFileProvider$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ ContentResolver val$resolver;
        final /* synthetic */ androidx.concurrent.futures.b val$result;
        final /* synthetic */ Uri val$uri;

        public AnonymousClass1(ContentResolver contentResolver, Uri uri, androidx.concurrent.futures.b bVar) {
            this.val$resolver = contentResolver;
            this.val$uri = uri;
            this.val$result = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = this.val$resolver.openFileDescriptor(this.val$uri, CampaignEx.JSON_KEY_AD_R);
                if (parcelFileDescriptorOpenFileDescriptor == null) {
                    this.val$result.w(new FileNotFoundException());
                    return;
                }
                Bitmap bitmapDecodeFileDescriptor = BitmapFactory.decodeFileDescriptor(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                parcelFileDescriptorOpenFileDescriptor.close();
                if (bitmapDecodeFileDescriptor == null) {
                    this.val$result.w(new IOException("File could not be decoded."));
                } else {
                    this.val$result.v(bitmapDecodeFileDescriptor);
                }
            } catch (IOException e11) {
                this.val$result.w(e11);
            }
        }
    }
}
