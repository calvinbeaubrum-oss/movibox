package j2;

import android.view.autofill.AutofillId;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f67815a;

    @RequiresApi(26)
    public b(@NonNull AutofillId autofillId) {
        this.f67815a = autofillId;
    }

    @NonNull
    @RequiresApi(26)
    public static b b(@NonNull AutofillId autofillId) {
        return new b(autofillId);
    }

    @NonNull
    @RequiresApi(26)
    public AutofillId a() {
        return a.a(this.f67815a);
    }
}
