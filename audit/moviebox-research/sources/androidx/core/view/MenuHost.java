package androidx.core.view;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public interface MenuHost {
    void addMenuProvider(@NonNull MenuProvider menuProvider);

    void addMenuProvider(@NonNull MenuProvider menuProvider, @NonNull androidx.lifecycle.u uVar);

    @SuppressLint({"LambdaLast"})
    void addMenuProvider(@NonNull MenuProvider menuProvider, @NonNull androidx.lifecycle.u uVar, @NonNull Lifecycle.State state);

    void invalidateMenu();

    void removeMenuProvider(@NonNull MenuProvider menuProvider);
}
