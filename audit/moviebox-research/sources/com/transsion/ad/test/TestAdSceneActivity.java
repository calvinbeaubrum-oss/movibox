package com.transsion.ad.test;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import androidx.appcompat.app.AppCompatActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class TestAdSceneActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public pq.l f50633a;

    public final String L(String str) {
        Gson gsonCreate = new GsonBuilder().setPrettyPrinting().create();
        try {
            String json = gsonCreate.toJson(gsonCreate.fromJson(str, Object.class));
            Intrinsics.f(json, "gson.toJson(jsonElement)");
            return json;
        } catch (Exception e11) {
            e11.printStackTrace();
            return "Invalid JSON String";
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        pq.l lVarC = pq.l.c(getLayoutInflater());
        Intrinsics.f(lVarC, "inflate(layoutInflater)");
        this.f50633a = lVarC;
        pq.l lVar = null;
        if (lVarC == null) {
            Intrinsics.y("binding");
            lVarC = null;
        }
        setContentView(lVarC.getRoot());
        wq.d dVar = wq.d.f79584a;
        String str = "版本号 " + dVar.d();
        pq.l lVar2 = this.f50633a;
        if (lVar2 == null) {
            Intrinsics.y("binding");
            lVar2 = null;
        }
        lVar2.f74035c.setText(str);
        String strC = dVar.c();
        pq.l lVar3 = this.f50633a;
        if (lVar3 == null) {
            Intrinsics.y("binding");
            lVar3 = null;
        }
        lVar3.f74034b.setMovementMethod(new ScrollingMovementMethod());
        pq.l lVar4 = this.f50633a;
        if (lVar4 == null) {
            Intrinsics.y("binding");
        } else {
            lVar = lVar4;
        }
        lVar.f74034b.setText(L(strC));
    }
}
