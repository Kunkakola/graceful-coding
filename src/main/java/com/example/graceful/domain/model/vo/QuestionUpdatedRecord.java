package com.example.graceful.domain.model.vo;

import java.time.OffsetDateTime;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.springframework.data.annotation.PersistenceConstructor;

/**
 * description 问题更新记录 Value Object
 * Embeddable 注解标识 一个实体类要在多个不同的实体类中进行使用，而本身又不需要独立生成一个数据库表
 *
 * @author jiangyu-045
 * @date 2022-04-29 16:31
 **/
@Embeddable
public class QuestionUpdatedRecord {

    /**
     * 更新操作类型
     */
    @Enumerated(EnumType.STRING)
    private UpdateType updateType;

    /**
     * 更新人
     */
    private String updaterId;

    /**
     * 更新时间
     */
    private OffsetDateTime updatedAt;

    /**
     * 原因
     */
    private String reason;


    /**
     * 创建时标题
     */
    private String createdTitle;

    /**
     * 创建时详情
     */
    private String createdDetail;

    /**
     * 修改前标题
     */
    private String uneditedTitle;

    /**
     * 修改后标题
     */
    private String editedTitle;

    /**
     * 修改前详情
     */
    private String uneditedDetail;

    /**
     * 修改后详情
     */
    private String editedDetail;

    @PersistenceConstructor
    protected QuestionUpdatedRecord() {
    }

    private QuestionUpdatedRecord(UpdateType updateType, String updaterId, OffsetDateTime updatedAt, String reason,
                                  String createdTitle, String createdDetail, String uneditedTitle, String editedTitle,
                                  String uneditedDetail, String editedDetail) {
        this.updateType = updateType;
        this.updaterId = updaterId;
        this.updatedAt = updatedAt;
        this.reason = reason;
        this.createdTitle = createdTitle;
        this.createdDetail = createdDetail;
        this.uneditedTitle = uneditedTitle;
        this.editedTitle = editedTitle;
        this.uneditedDetail = uneditedDetail;
        this.editedDetail = editedDetail;
    }

    /**
     * description 生成 新建 的记录
     * OffsetDateTime.now().withNano(0) 忽略毫秒
     *
     * @param updaterId     updaterId
     * @param createdTitle  createdTitle
     * @param createdDetail createdDetail
     * @return com.example.graceful.domain.model.vo.QuestionUpdatedRecord
     * @author jiangyu-045
     * @date 2022/4/29 16:50
     */
    public static QuestionUpdatedRecord ofCreated(String updaterId, String createdTitle, String createdDetail) {
        return new QuestionUpdatedRecord(UpdateType.CREATED, updaterId, OffsetDateTime.now().withNano(0), null, createdTitle, createdDetail,
                                         null, null, null, null);
    }

    /**
     * description 生成 更新标题 的记录
     * OffsetDateTime.now().withNano(0) 忽略毫秒
     *
     * @param updaterId     updaterId
     * @param reason        reason
     * @param uneditedTitle uneditedTitle
     * @param editedTitle   editedTitle
     * @return com.example.graceful.domain.model.vo.QuestionUpdatedRecord
     * @author jiangyu-045
     * @date 2022/4/29 16:53
     */
    public static QuestionUpdatedRecord ofTitleEdited(String updaterId, String reason, String uneditedTitle, String editedTitle) {
        return new QuestionUpdatedRecord(UpdateType.TITLE_EDITED, updaterId, OffsetDateTime.now().withNano(0), reason, null, null,
                                         uneditedTitle, editedTitle, null, null);
    }

    /**
     * description 生成 更新详情 的记录
     * OffsetDateTime.now().withNano(0) 忽略毫秒
     *
     * @param updaterId      updaterId
     * @param reason         reason
     * @param uneditedDetail uneditedDetail
     * @param editedDetail   editedDetail
     * @return com.example.graceful.domain.model.vo.QuestionUpdatedRecord
     * @author jiangyu-045
     * @date 2022/4/29 16:54
     */
    public static QuestionUpdatedRecord ofDetailEdited(String updaterId, String reason, String uneditedDetail, String editedDetail) {
        return new QuestionUpdatedRecord(UpdateType.DETAIL_EDITED, updaterId, OffsetDateTime.now().withNano(0), reason, null, null, null,
                                         null, uneditedDetail, editedDetail);
    }

    public UpdateType getUpdateType() {
        return updateType;
    }

    public String getUpdaterId() {
        return updaterId;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public String getReason() {
        return reason;
    }

    public String getCreatedTitle() {
        return createdTitle;
    }

    public String getCreatedDetail() {
        return createdDetail;
    }

    public String getUneditedTitle() {
        return uneditedTitle;
    }

    public String getEditedTitle() {
        return editedTitle;
    }

    public String getUneditedDetail() {
        return uneditedDetail;
    }

    public String getEditedDetail() {
        return editedDetail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof QuestionUpdatedRecord that)) {
            return false;
        }
        return getUpdateType() == that.getUpdateType()
               && Objects.equals(getUpdaterId(), that.getUpdaterId())
               && Objects.equals(getUpdatedAt(), that.getUpdatedAt())
               && Objects.equals(getReason(), that.getReason())
               && Objects.equals(getCreatedTitle(), that.getCreatedTitle())
               && Objects.equals(getCreatedDetail(), that.getCreatedDetail())
               && Objects.equals(getUneditedTitle(), that.getUneditedTitle())
               && Objects.equals(getEditedTitle(), that.getEditedTitle())
               && Objects.equals(getUneditedDetail(), that.getUneditedDetail())
               && Objects.equals(getEditedDetail(), that.getEditedDetail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUpdateType(), getUpdaterId(), getUpdatedAt(), getReason(),
                            getCreatedTitle(), getCreatedDetail(), getUneditedTitle(),
                            getEditedTitle(), getUneditedDetail(), getEditedDetail());
    }

    public enum UpdateType {
        /**
         * 创建
         */
        CREATED,

        /**
         * 更新标题
         */
        TITLE_EDITED,

        /**
         * 更新详情
         */
        DETAIL_EDITED
    }

}
