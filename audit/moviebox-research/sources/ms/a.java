package ms;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.transsion.bean.AhaGameAllGames;
import com.transsion.bean.GameLayoutType;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.g;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class a {
    public final void a(AhaGameAllGames game, int i11, long j11, GameLayoutType itemType) {
        Intrinsics.g(game, "game");
        Intrinsics.g(itemType, "itemType");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("id", String.valueOf(game.getId()));
        linkedHashMap.put("name", String.valueOf(game.getName()));
        linkedHashMap.put(RequestParameters.POSITION, String.valueOf(i11));
        linkedHashMap.put("link", String.valueOf(game.getLink()));
        linkedHashMap.put("browse_duration", String.valueOf(j11));
        linkedHashMap.put("item_type", itemType.toString());
        com.transsion.baselib.helper.a.f51183a.d("game_center", linkedHashMap);
    }

    public final void b(AhaGameAllGames game, int i11, GameLayoutType itemType) {
        Intrinsics.g(game, "game");
        Intrinsics.g(itemType, "itemType");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("id", String.valueOf(game.getId()));
        linkedHashMap.put("name", String.valueOf(game.getName()));
        linkedHashMap.put(RequestParameters.POSITION, String.valueOf(i11));
        linkedHashMap.put("link", String.valueOf(game.getLink()));
        linkedHashMap.put("item_type", itemType.toString());
        com.transsion.baselib.helper.a.f51183a.e("game_center", linkedHashMap);
    }

    public final void c(AhaGameAllGames game, long j11) {
        List listF0;
        Intrinsics.g(game, "game");
        List<AhaGameAllGames> peoplePlaying = game.getPeoplePlaying();
        if (peoplePlaying == null || (listF0 = CollectionsKt___CollectionsKt.F0(peoplePlaying, 4)) == null) {
            return;
        }
        int i11 = 0;
        for (Object obj : listF0) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                g.u();
            }
            a((AhaGameAllGames) obj, i11, j11, game.getGameLayoutType());
            i11 = i12;
        }
    }
}
