package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f0 implements Iterable<Intent> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<Intent> f7725a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f7726b;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        @Nullable
        Intent getSupportParentActivityIntent();
    }

    public f0(Context context) {
        this.f7726b = context;
    }

    @NonNull
    public static f0 g(@NonNull Context context) {
        return new f0(context);
    }

    @NonNull
    public f0 a(@NonNull Intent intent) {
        this.f7725a.add(intent);
        return this;
    }

    @NonNull
    public f0 b(@NonNull Intent intent) {
        ComponentName component = intent.getComponent();
        if (component == null) {
            component = intent.resolveActivity(this.f7726b.getPackageManager());
        }
        if (component != null) {
            f(component);
        }
        a(intent);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public f0 e(@NonNull Activity activity) {
        Intent supportParentActivityIntent = activity instanceof a ? ((a) activity).getSupportParentActivityIntent() : null;
        if (supportParentActivityIntent == null) {
            supportParentActivityIntent = m.a(activity);
        }
        if (supportParentActivityIntent != null) {
            ComponentName component = supportParentActivityIntent.getComponent();
            if (component == null) {
                component = supportParentActivityIntent.resolveActivity(this.f7726b.getPackageManager());
            }
            f(component);
            a(supportParentActivityIntent);
        }
        return this;
    }

    @NonNull
    public f0 f(@NonNull ComponentName componentName) {
        int size = this.f7725a.size();
        try {
            Intent intentB = m.b(this.f7726b, componentName);
            while (intentB != null) {
                this.f7725a.add(size, intentB);
                intentB = m.b(this.f7726b, intentB.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e11) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e11);
        }
    }

    public void i() {
        j(null);
    }

    @Override // java.lang.Iterable
    @NonNull
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f7725a.iterator();
    }

    public void j(@Nullable Bundle bundle) {
        if (this.f7725a.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) this.f7725a.toArray(new Intent[0]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (z2.a.startActivities(this.f7726b, intentArr, bundle)) {
            return;
        }
        Intent intent = new Intent(intentArr[intentArr.length - 1]);
        intent.addFlags(ASTNode.DEOP);
        this.f7726b.startActivity(intent);
    }
}
