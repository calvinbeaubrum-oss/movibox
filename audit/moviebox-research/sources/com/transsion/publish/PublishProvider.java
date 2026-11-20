package com.transsion.publish;

import android.content.Context;
import android.content.Intent;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.publish.api.GroupBean;
import com.transsion.publish.api.IPublishApi;
import com.transsion.publish.ui.FilmReviewActivity;
import com.transsion.publish.ui.SelectImageActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.mvel2.ast.ASTNode;

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
/* JADX INFO: loaded from: classes.dex */
@Route(path = "/publish/Api")
@Metadata
public final class PublishProvider implements IPublishApi {
    @Override // com.transsion.publish.api.IPublishApi
    public void D0(Context context, String subjectId, String cover, String title, String description, int i11) {
        Subject subject;
        Intent intent;
        Intrinsics.g(context, "context");
        Intrinsics.g(subjectId, "subjectId");
        Intrinsics.g(cover, "cover");
        Intrinsics.g(title, "title");
        Intrinsics.g(description, "description");
        Intent intent2 = new Intent(context, (Class<?>) FilmReviewActivity.class);
        intent2.setFlags(ASTNode.DEOP);
        intent2.putExtra("sourceType", 1);
        intent2.putExtra("sourceMode", i11);
        Subject subject2 = new Subject(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, null, null, null, null, null, false, false, null, null, 0, false, false, 0L, null, null, 0L, null, 0, false, null, 0, null, null, null, null, null, null, null, -1, 4194303, null);
        if (subject2.getCover() == null) {
            intent = intent2;
            subject = subject2;
            subject.setCover(new Cover(0, 0, 0, cover, "", "", null, null, null, 384, null));
        } else {
            subject = subject2;
            intent = intent2;
            Cover cover2 = subject.getCover();
            if (cover2 != null) {
                cover2.setUrl(cover);
            }
        }
        subject.setSubjectId(subjectId);
        subject.setTitle(title);
        subject.setDescription(description);
        intent.putExtra("subject", subject);
        context.startActivity(intent);
    }

    @Override // com.transsion.publish.api.IPublishApi
    public void K(Context context) {
        Intrinsics.g(context, "context");
        Intent intent = new Intent(context, (Class<?>) FilmReviewActivity.class);
        intent.setFlags(ASTNode.DEOP);
        intent.putExtra("sourceType", 2);
        context.startActivity(intent);
    }

    @Override // com.transsion.publish.api.IPublishApi
    public void Q() {
        PublishManager.Companion.a().reset();
    }

    @Override // com.transsion.publish.api.IPublishApi
    public boolean a0() {
        return PublishManager.Companion.a().uploading();
    }

    @Override // com.alibaba.android.arouter.facade.template.IProvider
    public void init(Context context) {
    }

    @Override // com.transsion.publish.api.IPublishApi
    public void k0(Context context, String subjectId, String cover, String title, String description, int i11) {
        Subject subject;
        Intent intent;
        Intrinsics.g(context, "context");
        Intrinsics.g(subjectId, "subjectId");
        Intrinsics.g(cover, "cover");
        Intrinsics.g(title, "title");
        Intrinsics.g(description, "description");
        Intent intent2 = new Intent(context, (Class<?>) FilmReviewActivity.class);
        intent2.setFlags(ASTNode.DEOP);
        intent2.putExtra("sourceType", 2);
        intent2.putExtra("sourceMode", i11);
        Subject subject2 = new Subject(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, null, null, null, null, null, false, false, null, null, 0, false, false, 0L, null, null, 0L, null, 0, false, null, 0, null, null, null, null, null, null, null, -1, 4194303, null);
        if (subject2.getCover() == null) {
            intent = intent2;
            subject = subject2;
            subject.setCover(new Cover(0, 0, 0, cover, "", "", null, null, null, 384, null));
        } else {
            subject = subject2;
            intent = intent2;
            Cover cover2 = subject.getCover();
            if (cover2 != null) {
                cover2.setUrl(cover);
            }
        }
        subject.setSubjectId(subjectId);
        subject.setTitle(title);
        subject.setDescription(description);
        intent.putExtra("subject", subject);
        context.startActivity(intent);
    }

    @Override // com.transsion.publish.api.IPublishApi
    public boolean n0() {
        return PublishManager.Companion.a().isFail();
    }

    @Override // com.transsion.publish.api.IPublishApi
    public Intent u1(Context context) {
        Intrinsics.g(context, "context");
        Intent intent = new Intent(context, (Class<?>) SelectImageActivity.class);
        intent.putExtra("key_type", 7);
        return intent;
    }

    @Override // com.transsion.publish.api.IPublishApi
    public void x(Context context, String groupId, String groupName, String groupImage) {
        Intrinsics.g(context, "context");
        Intrinsics.g(groupId, "groupId");
        Intrinsics.g(groupName, "groupName");
        Intrinsics.g(groupImage, "groupImage");
        Intent intent = new Intent(context, (Class<?>) FilmReviewActivity.class);
        intent.setFlags(ASTNode.DEOP);
        intent.putExtra("sourceType", 2);
        GroupBean groupBean = new GroupBean();
        groupBean.setGroupId(groupId);
        groupBean.setName(groupName);
        groupBean.setAvatar(groupImage);
        intent.putExtra("group", groupBean);
        context.startActivity(intent);
    }
}
