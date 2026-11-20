package e7;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface c extends Closeable {
    @NonNull
    InputStream M() throws IOException;

    @Nullable
    String error();

    boolean isSuccessful();

    @Nullable
    String z();
}
