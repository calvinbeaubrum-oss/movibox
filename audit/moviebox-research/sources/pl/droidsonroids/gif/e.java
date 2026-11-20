package pl.droidsonroids.gif;

import android.content.res.AssetManager;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class e {

    /* JADX INFO: compiled from: source.java */
    public static final class b extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AssetManager f73926a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f73927b;

        public b(@NonNull AssetManager assetManager, @NonNull String str) {
            super();
            this.f73926a = assetManager;
            this.f73927b = str;
        }

        @Override // pl.droidsonroids.gif.e
        public GifInfoHandle a() throws IOException {
            return new GifInfoHandle(this.f73926a.openFd(this.f73927b));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Resources f73928a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f73929b;

        public c(@NonNull Resources resources, int i11) {
            super();
            this.f73928a = resources;
            this.f73929b = i11;
        }

        @Override // pl.droidsonroids.gif.e
        public GifInfoHandle a() throws IOException {
            return new GifInfoHandle(this.f73928a.openRawResourceFd(this.f73929b));
        }
    }

    public e() {
    }

    public abstract GifInfoHandle a() throws IOException;
}
