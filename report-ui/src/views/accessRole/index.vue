<!--
 * @Descripttion: 用户权限--角色管理

-->
<template>
  <anji-crud ref="listPage" :option="crudOption">
    <template v-slot:pageSection>
      <RoleAuthority
        :role-code="roleCode"
        :visib="dialogVisibleSetAuthorityForRole"
        @handleClose="dialogVisibleSetAuthorityForRole = false"
      />
    </template>
  </anji-crud>
</template>
<script>
import {
  accessRoleList,
  accessRoleAdd,
  accessRoleDeleteBatch,
  accessRoleUpdate,
  accessRoleDetail
} from "@/api/accessRole";
import RoleAuthority from "@/views/accessRole/components/RoleAuthority";
export default {
  name: "AccessRole",
  components: {
    RoleAuthority: RoleAuthority
  },
  data() {
    return {
      // 选中一个角色，点设定权限时，弹出对话框
      dialogVisibleSetAuthorityForRole: false,
      roleCode: "",

      // 页面渲染使用
      crudOption: {
        // 使用菜单做为页面标题
        title: "角色管理",
        // 详情页中输入框左边文字宽度
        labelWidth: "160px",
        // 表头按钮
        tableButtons: [
          {
            label: "新增",
            type: "", // primary、success、info、warning、danger
            permission: "roleManage:insert", // 按钮权限码
            icon: "el-icon-plus",
            plain: true,
            click: () => {
              return this.$refs.listPage.handleOpenEditView("add");
            }
          },
          {
            label: "删除",
            type: "danger",
            permission: "roleManage:delete",
            icon: "el-icon-delete",
            plain: false,
            click: () => {
              return this.$refs.listPage.handleDeleteBatch();
            }
          }
        ],
        // 表格行按钮
        rowButtons: [
          {
            label: "编辑",
            permission: "roleManage:update",
            click: row => {
              return this.$refs.listPage.handleOpenEditView("edit", row);
            }
          },
          {
            label: "分配权限",
            permission: "roleManage:grantAuthority",
            click: this.handleOpenDialogSetAuthorityForRole
          },
          {
            label: "删除",
            permission: "roleManage:delete",
            click: row => {
              return this.$refs.listPage.handleDeleteBatch(row);
            }
          }
        ],
        // 查询表单条件
        queryFormFields: [
          {
            inputType: "input",
            label: "角色编码",
            field: "roleCode"
          },
          {
            inputType: "input",
            label: "角色名称",
            field: "roleName"
          },
          {
            inputType: "anji-select", //form表单类型 input|input-number|anji-select(传递url或者dictCode)|anji-tree(左侧树)|date|datetime|datetimerange
            anjiSelectOption: {
              dictCode: "ENABLE_FLAG"
            },
            label: "启用状态",
            field: "enableFlag"
          }
        ],
        // 操作按钮
        buttons: {
          query: {
            api: accessRoleList,
            permission: "roleManage:query"
          },
          queryByPrimarykey: {
            api: accessRoleDetail,
            permission: "roleManage:query"
          },
          add: {
            api: accessRoleAdd,
            permission: "roleManage:insert"
          },
          delete: {
            api: accessRoleDeleteBatch,
            permission: "roleManage:delete"
          },
          edit: {
            api: accessRoleUpdate,
            permission: "roleManage:update"
          },
          rowButtonsWidth: 140 // row自定义按钮表格宽度
        },
        // 表格列
        columns: [
          {
            label: "",
            field: "id",
            primaryKey: true, // 根据主键查询详情或者根据主键删除时, 主键的
            tableHide: true, // 表格中不显示
            editHide: true // 编辑弹框中不显示
          },
          {
            label: "角色编码",
            placeholder: "",
            field: "roleCode",
            editField: "roleCode",
            tableHide: true, // 表格中不显示
            inputType: "input",
            rules: [
              { required: true, message: "角色编码必填", trigger: "blur" },
              { min: 1, max: 32, message: "不超过32个字符", trigger: "blur" }
            ],
            disabled: false
          },
          {
            label: "角色名称",
            placeholder: "",
            field: "roleName",
            fieldTableRowRenderer: row => {
              return `${row["roleName"]}[${row["roleCode"]}]`;
            },
            editField: "roleName",
            inputType: "input",
            rules: [
              { required: true, message: "角色名称必填", trigger: "blur" },
              { min: 1, max: 64, message: "不超过64个字符", trigger: "blur" }
            ],
            disabled: false
          },
          {
            label: "启用状态", //0--已禁用 1--已启用  DIC_NAME=ENABLE_FLAG
            placeholder: "",
            field: "enableFlag",
            fieldTableRowRenderer: row => {
              return this.getDictLabelByCode("ENABLE_FLAG", row["enableFlag"]);
            },
            editField: "enableFlag",
            inputType: "anji-select",
            anjiSelectOption: {
              dictCode: "ENABLE_FLAG" //指定数据字典
            },
            colorStyle: {
              0: "table-danger", //key为editField渲染的值（字典的提交值）'红色': 'danger','蓝色': 'primary','绿色': 'success','黄色': 'warning','灰色': 'info','白色'：''
              1: "table-success"
            },
            rules: [
              { required: true, message: "启用状态必填", trigger: "blur" }
            ],
            disabled: false
          },

          {
            label: "创建人",
            placeholder: "",
            field: "createBy",
            editField: "createBy",
            inputType: "input",
            editHide: "hideOnAdd", // 编辑弹框中不显示 true/false/'hideOnAdd hideOnView hideOnEdit'
            disabled: true
          },
          {
            label: "创建时间",
            placeholder: "",
            field: "createTime",
            editField: "createTime",
            inputType: "input",
            editHide: "hideOnAdd", // 编辑弹框中不显示 true/false/'hideOnAdd hideOnView hideOnEdit'
            disabled: true
          },
          {
            label: "修改人",
            placeholder: "",
            field: "updateBy",
            editField: "updateBy",
            inputType: "input",
            editHide: "hideOnAdd", // 编辑弹框中不显示 true/false/'hideOnAdd hideOnView hideOnEdit'
            disabled: true
          },
          {
            label: "修改时间",
            placeholder: "",
            field: "updateTime",
            editField: "updateTime",
            inputType: "input",
            editHide: "hideOnAdd", // 编辑弹框中不显示 true/false/'hideOnAdd hideOnView hideOnEdit'
            disabled: true
          }
        ]
      }
    };
  },
  methods: {
    handleOpenDialogSetAuthorityForRole(props) {
      this.roleCode = props.roleCode;
      this.dialogVisibleSetAuthorityForRole = true;
    }
  }
};
</script>
