package i6;

import android.content.Context;
import androidx.annotation.NonNull;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface b<T> {
    @NonNull
    List<Class<? extends b<?>>> a();

    @NonNull
    T create(@NonNull Context context);
}
