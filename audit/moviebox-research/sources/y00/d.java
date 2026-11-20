package y00;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.cloud.tmc.integration.permission.PermissionConstant;
import com.vungle.warren.AdLoader;
import com.vungle.warren.AdRequest;
import com.vungle.warren.y;
import java.util.Collection;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class d implements e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f81037c = "y00.d";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AdLoader f81038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y f81039b;

    public d(@NonNull AdLoader adLoader, @NonNull y yVar) {
        this.f81038a = adLoader;
        this.f81039b = yVar;
    }

    public static g b(@NonNull AdRequest adRequest) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(PermissionConstant.ACTION_REQUEST, adRequest);
        return new g(f81037c + " " + adRequest).p(true).l(bundle).m(4);
    }

    @Override // y00.e
    public int a(Bundle bundle, h hVar) {
        AdRequest adRequest = (AdRequest) bundle.getSerializable(PermissionConstant.ACTION_REQUEST);
        Collection<String> collectionA = this.f81039b.a();
        if (adRequest == null || !collectionA.contains(adRequest.getPlacementId())) {
            return 1;
        }
        this.f81038a.W(adRequest);
        return 0;
    }
}
