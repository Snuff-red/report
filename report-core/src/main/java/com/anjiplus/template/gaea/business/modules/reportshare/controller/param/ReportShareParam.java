/**/
package com.anjiplus.template.gaea.business.modules.reportshare.controller.param;

import com.anji.plus.gaea.annotation.Query;
import com.anji.plus.gaea.constant.QueryEnum;
import com.anji.plus.gaea.curd.params.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Raod
 **/
@Data
public class ReportShareParam extends PageParam implements Serializable {
    /** 分享编码，系统生成，默认UUID */
    @Query(value = QueryEnum.EQ)
    private String shareCode;

    /** 报表编码 */
    @Query(value = QueryEnum.LIKE)
    private String reportCode;

    /** 分享有效期类型 */
    @Query(value = QueryEnum.EQ)
    private String shareValidType;
}
