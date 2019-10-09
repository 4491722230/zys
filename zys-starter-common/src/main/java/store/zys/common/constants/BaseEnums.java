package store.zys.common.constants;


import store.zys.common.base.BaseEnum;

public enum BaseEnums implements BaseEnum<String, String> {
    SUCCESS("request.success", "请求成功"),
    FALLURE("request.failure", "请求失败"),
    OPERATION_SUCCESS("operation.success", "操作成功"),
    OPERATION_FAILURE("operation.failure", "操作失败"),
    ERROR("system.error", "系统异常"),
    NOT_FOUND("nof_found", "资源不存在"),
    FORBIDDEN("forbidden","无权限访问"),
    VERSION_NOT_MATCJ("record_not_exists_or_version_not_match", "记录版本不存在或不匹配"),
    PARAMETER_NOT_NULL("parameter_not_be_null", "参数不能为空");

    private String code;
    private String desc;


    BaseEnums(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    BaseEnums() {
    }

    @Override
    public String code() {
        return null;
    }

    @Override
    public String desc() {
        return null;
    }
}
