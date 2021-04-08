<template>
  <div>

    <!--搜索表单-->
    <el-form :inline="true" :model="searchForm" class="demo-form-inline">
      <el-form-item label="标签" >
        <el-select v-model="searchForm.label"  placeholder="请选择标签">
          <el-option label="空" value="空"></el-option>
          <el-option label="未跟进" value="未跟进"></el-option>
          <el-option label="正跟进" value="正跟进"></el-option>
          <el-option label="项目完成" value="项目完成"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="客户类型">
        <el-select v-model="searchForm.clientType" placeholder="请选择客户类型">
          <el-option label="空" value="空"></el-option>
          <el-option v-for="item in clientTypeList" :key="item"  :value="item" :label="item"></el-option>
        </el-select>
      </el-form-item  >
      <el-form-item label="创建时间">
        <el-date-picker
            v-model="searchForm.searchCreateTime"
            type="daterange"
            :editable ="true"
            align="right"
            unlink-panels
            range-separator="至"
            start-placeholder="开始日期"
            end-placeholder="结束日期"
            :picker-options="pickerOptionsCreateTime">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="创建人" >
        <el-select v-model="searchForm.createPerson" placeholder="请选择创建人">
          <el-option  label="空" value="空"></el-option>
          <el-option v-for="item in createPersonList" :key="item"  :value="item" :label="item"></el-option>
        </el-select>
      </el-form-item >
      <el-form-item>
        <el-button type="primary" @click="searchButtonClick">查询</el-button>
      </el-form-item>
    </el-form>

    <!--保存用户时弹出的对话框-->
    <el-dialog   title="保存用户" :visible.sync="dialogFormVisibleForSaveClient">
      <el-form :model="saveClientForm" :rules="rules" ref="saveClientForm" label-width="100px" class="demo-saveClientForm">
        <el-form-item label="客户姓名" prop="clientName">
          <el-input v-model="saveClientForm.clientName"></el-input>
        </el-form-item>
        <el-form-item label="标签"  prop="label" >
          <el-select v-model="saveClientForm.label"  >
            <el-option label="未跟进" value="未跟进"></el-option>
            <el-option label="正跟进" value="正跟进"></el-option>
            <el-option label="项目完成" value="项目完成"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="客户类型" prop="clientType">
          <el-input v-model="saveClientForm.clientType"></el-input>
        </el-form-item>
        <el-form-item label="省份" prop="province">
          <el-input v-model="saveClientForm.province"></el-input>
        </el-form-item>
        <el-form-item label="城市" prop="city">
          <el-input v-model="saveClientForm.city"></el-input>
        </el-form-item>
        <el-form-item label="下次联系时" prop="nextContactTime">
          <el-date-picker
              v-model="saveClientForm.nextContactTime"
              type="datetime"
              placeholder="选择日期"
              :editable="false"
              :picker-options="pickerOptionsNextContactTime"
          >
          </el-date-picker>
        </el-form-item>

        <el-form-item label="创建时间" prop="createTime">
          <el-date-picker
              v-model="saveClientForm.createTime"
              type="datetime"
              placeholder="选择日期"
              :editable="false"
              :picker-options="pickerOptionsCreateTime"
          >
          </el-date-picker>
        </el-form-item>
        <el-form-item label="创建人" prop="createPerson">
          <el-input v-model="saveClientForm.createPerson"></el-input>
        </el-form-item>
        <el-form-item label="分配时间" prop="clientAllocationTime">
          <el-select v-model="saveClientForm.clientAllocationTime" placeholder="请选择分配的时间">
            <el-option label="一天" value="一天"></el-option>
            <el-option label="三天" value="三天"></el-option>
            <el-option label="五天" value="五天"></el-option>
            <el-option label="一周" value="一周"></el-option>
            <el-option label="两周" value="两周"></el-option>
            <el-option label="一月" value="一月"></el-option>
            <el-option label="两月" value="两月"></el-option>
            <el-option label="一年" value="一年"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="上次联系时" prop="lastContactTime">
          <el-date-picker
              v-model="saveClientForm.lastContactTime"
              type="datetime"
              placeholder="选择日期"
              :editable="false"
              :picker-options="pickerOptionsCreateTime"
          >
          </el-date-picker>
        </el-form-item>
        <el-form-item label="最后联系人" prop="lastContactPerson">
          <el-input v-model="saveClientForm.lastContactPerson"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisibleForSaveClient = false">取 消</el-button>
        <el-button type="primary" @click="handleSaveClient">确 定</el-button>
      </div>
    </el-dialog>

    <!--编辑用户的弹出的对话框-->
    <el-dialog   title="编辑用户" :visible.sync="dialogFormVisibleForEditClient">
      <el-form :model="editClientForm" :rules="rules" ref="editClientForm" label-width="100px" class="demo-saveClientForm">
        <el-form-item label="id" prop="id">
          <el-input disabled v-model="editClientForm.id"></el-input>
        </el-form-item>
        <el-form-item label="客户姓名" prop="clientName">
          <el-input v-model="editClientForm.clientName"></el-input>
        </el-form-item>
        <el-form-item label="标签"  prop="label" >
          <el-select v-model="editClientForm.label"  >
            <el-option label="未跟进" value="未跟进"></el-option>
            <el-option label="正跟进" value="正跟进"></el-option>
            <el-option label="项目完成" value="项目完成"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="客户类型" prop="clientType">
          <el-input v-model="editClientForm.clientType"></el-input>
        </el-form-item>
        <el-form-item label="省份" prop="province">
          <el-input v-model="editClientForm.province"></el-input>
        </el-form-item>
        <el-form-item label="城市" prop="city">
          <el-input v-model="editClientForm.city"></el-input>
        </el-form-item>
        <el-form-item label="下次联系时" prop="nextContactTime">
          <el-date-picker
              v-model="editClientForm.nextContactTime"
              type="datetime"
              placeholder="选择日期"
              :editable="false"
              :picker-options="pickerOptionsNextContactTime"
          >
          </el-date-picker>
        </el-form-item>

        <el-form-item label="创建时间" prop="createTime">
          <el-date-picker
              v-model="editClientForm.createTime"
              type="datetime"
              placeholder="选择日期"
              :editable="false"
              :picker-options="pickerOptionsCreateTime"
          >
          </el-date-picker>
        </el-form-item>
        <el-form-item label="创建人" prop="createPerson">
          <el-input v-model="editClientForm.createPerson"></el-input>
        </el-form-item>
        <el-form-item label="分配时间" prop="clientAllocationTime">
          <el-select v-model="editClientForm.clientAllocationTime" placeholder="请选择分配的时间">
            <el-option label="一天" value="一天"></el-option>
            <el-option label="三天" value="三天"></el-option>
            <el-option label="五天" value="五天"></el-option>
            <el-option label="一周" value="一周"></el-option>
            <el-option label="两周" value="两周"></el-option>
            <el-option label="一月" value="一月"></el-option>
            <el-option label="两月" value="两月"></el-option>
            <el-option label="一年" value="一年"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="上次联系时" prop="lastContactTime">
          <el-date-picker
              v-model="editClientForm.lastContactTime"
              type="datetime"
              placeholder="选择日期"
              :editable="false"
              :picker-options="pickerOptionsCreateTime"
          >
          </el-date-picker>
        </el-form-item>
        <el-form-item label="最后联系人" prop="lastContactPerson">
          <el-input v-model="editClientForm.lastContactPerson"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisibleForEditClient = false">取 消</el-button>
        <el-button type="primary" @click="handleUpdateClient">确 定</el-button>
      </div>
    </el-dialog>

    <!--图表信息-->
    <el-tabs v-model="activeName" type="card">
      <el-tab-pane label="全部客户" name="allClient">
        <el-table
            height="400"
            :data="tableData.filter(data => !searchByName || data.clientName.toLowerCase().includes(searchByName.toLowerCase()))"
            style="width: 100%;font-size: 10px"
            :header-cell-style="{color:'#333',fontFamily:'MicrosoftYaHeiUI',fontSize:'11px',fontWeight:900}"
        >
          <el-table-column align="center" sortable  width="55" label="id"  prop="id">
          </el-table-column>
          <el-table-column align="center" sortable  width="88" label="客户名称"  prop="clientName">
          </el-table-column>
          <el-table-column align="center" sortable width="67"  label="标签" prop="label"  >
          </el-table-column>
          <el-table-column align="center" sortable  width="88" label="客户类型" prop="clientType">
          </el-table-column>
          <el-table-column align="center" sortable  width="67" label="省份" prop="province">
          </el-table-column>
          <el-table-column align="center" sortable  width="67" label="城市" prop="city">
          </el-table-column>
          <el-table-column align="center" sortable  width="115" label="下次联系时间" prop="nextContactTime">
          </el-table-column>
          <el-table-column align="center" sortable  width="88" label="创建时间" prop="createTime">
          </el-table-column>
          <el-table-column align="center" sortable  width="78"  label="创建人" prop="createPerson">
          </el-table-column>
          <el-table-column align="center" sortable width="115"  label="客户分配时间" prop="clientAllocationTime">
          </el-table-column>
          <el-table-column align="center" sortable width="115"  label="最后联系时间" prop="lastContactTime">
          </el-table-column>
          <el-table-column align="center" sortable width="115"  label="最后联系人" prop="lastContactPerson">
          </el-table-column>
          <el-table-column align="center">
            <template slot="header" slot-scope="scope">
              <el-input
                  v-model="searchByName"
                  size="mini"
                  placeholder="姓名模糊搜索"/>
            </template>
            <template slot-scope="scope">
              <el-button
                  size="mini"
                  @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
              <el-popconfirm
                  @confirm="handleDelete(scope.$index, scope.row)"
                  confirm-button-text='好的'
                  cancel-button-text='不用了'
                  icon="el-icon-info"
                  icon-color="red"
                  title="需要删除这一项吗">
                <el-button
                    style="margin-left: 2px"
                    size="mini"
                    slot="reference"
                    type="danger">删除</el-button>
              </el-popconfirm>

            </template>
          </el-table-column>
        </el-table>
      </el-tab-pane>
      <el-tab-pane label="我的客户" name="myClient">我的客户</el-tab-pane>
      <el-tab-pane label="共享给我的客户" name="shareToMe">共享给我的客户</el-tab-pane>
      <el-tab-pane label="我共享的客户" name="myShare">
      </el-tab-pane>
    </el-tabs>

    <!--添加用户的button-->
    <el-button id="insertClientButton"  type="success"    size="medium" @click="saveClientButtonClick">添加客户</el-button>

  </div>
</template>

<script>
export default {
  created() {
    this.updateAllData();
  },
  data() {
    return {
      createPersonList:[],  // 搜索中表单中 所有创建者的list
      clientTypeList:[], // 搜索中表单中 所有客户类型的list
      searchForm:{},    // 搜索中提交的表单
      tableData: [],  //表单数据  表格里的数据就是从这里拿的
      searchByName: null,  // 搜索后的数据
      activeName:"allClient", // 默认激活的  所有客户 我的客户 我分享的客户
      dialogFormVisibleForSaveClient: false,  // 保存用户的对话框 dialog是否展示
      dialogFormVisibleForEditClient: false,
      saveClientForm: {id:"",label:"未跟进",clientAllocationTime:"一天"},  //保存用户所传的json数据  id默认为空 label和 clientAllocationTime
      editClientForm: {},  //保存用户所传的json数据  id默认为空 label和 clientAllocationTime
      pickerOptionsNextContactTime: {
        disabledDate(time) {
          return time.getTime() < Date.now();
        },
        shortcuts: [{
          text: '今天',
          onClick(picker) {
            picker.$emit('pick', new Date());
          }
        }, {
          text: '明天',
          onClick(picker) {
            const date = new Date();
            date.setTime(date.getTime() + 3600 * 1000 * 24);
            picker.$emit('pick', date);
          }
        }, {
          text: '一周后',
          onClick(picker) {
            const date = new Date();
            date.setTime(date.getTime() + 3600 * 1000 * 24 * 7);
            picker.$emit('pick', date);
          }
        }],
      },  // 下次联系时间的快捷方式 今天 明天 一周后
      pickerOptionsCreateTime: {
        disabledDate(time) {
          return time.getTime() > Date.now();
        },
        shortcuts: [{
          text: '今天',
          onClick(picker) {
            picker.$emit('pick', new Date());
          }
        }, {
          text: '昨天',
          onClick(picker) {
            const date = new Date();
            date.setTime(date.getTime() - 3600 * 1000 * 24);
            picker.$emit('pick', date);
          }
        }, {
          text: '一周前',
          onClick(picker) {
            const date = new Date();
            date.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
            picker.$emit('pick', date);
          }
        }]
      }, // 创建时间的快捷方式 今天 昨天 一周前
      rules: {
        clientName: [
          { required: true, message: '请输入客户姓名', trigger: 'blur' },
          { min: 1, max: 30, message: '长度在 1 到 30 个字符', trigger: 'blur' }
        ],
        clientType: [
          {  required: true, message: '请填入客户类型', trigger: 'blur' },
          { min: 1, max: 30, message: '长度在 1 到 30 个字符', trigger: 'blur' }
        ],
        province: [
          {  required: true, message: '请填入省份', trigger: 'blur' },
          { min: 1, max: 30, message: '长度在 1 到 30 个字符', trigger: 'blur' }
        ],
        city: [
          { required: true, message: '请填入城市', trigger: 'blur' },
          { min: 1, max: 30, message: '长度在 1 到 30 个字符', trigger: 'blur' }
        ],
        nextContactTime: [
          { required: true, message: '请填入下次联系时间', trigger: 'blur' }
        ],
        createTime: [
          { required: true, message: '请填入创建时间', trigger: 'blur' }
        ],
        createPerson: [
          { required: true, message: '请填入创建人', trigger: 'blur' }
        ],
        lastContactTime: [
          { required: true, message: '请填入最后联系时间', trigger: 'blur' }
        ],
        lastContactPerson: [
          { required: true, message: '请填入最后联系人', trigger: 'blur' }
        ],
      }
    }
  },
  methods: {
    updateAllData(){  // 向服务器发送请求 拿到所有用户的数据
      console.log(this.searchForm.searchCreateTime);
      this.$http.get("http://localhost:8989/client/getAllClients").then(res=>{
        this.tableData = res.data;
      })
      this.getCreatePersonBeforeSelect();
      this.getClientTypeBeforeSelect();
    },
    clearSubmitForm(){
      this.editClientForm ={}
      this.saveClientForm = {}
    },
    handleEdit(index, row) {  // 处理编辑按钮的点击事件
      this.searchButtonClick();
      this.clearSubmitForm()
      this.dialogFormVisibleForEditClient=true;
      this.editClientForm = row
    },
    handleDelete(index, row) {  //处理删除按钮的点击操作
      this.$http.get("http://localhost:8989/client/deleteClientById?id=" + row.id ).then(
          res=>{
            this.searchButtonClick(); //异步的 只有删除操作执行完毕之后才能进行更新数据
            this.$message({
              message: '删除成功',
              type: 'success'
            });
            this.getCreatePersonBeforeSelect();
            this.getClientTypeBeforeSelect();
          }
      )
    },
    handleSaveClient(){  //处理saveclientform表单的提交按钮的点击事件
      this.$refs['saveClientForm'].validate((valid) => {
        if (valid) {  //验证通过
          this.dialogFormVisibleForSaveClient = false

          this.$http.post("http://localhost:8989/client/saveClient",this.saveClientForm).then(
              res=>{
                this.searchButtonClick();
                this.getCreatePersonBeforeSelect();
                this.getClientTypeBeforeSelect();
              }
          )
        } else {
          return false;
        }
      });
    },
    handleUpdateClient(){  // 更新
      this.$refs['editClientForm'].validate((valid) => {
        if (valid) {  //验证通过
          this.$http.post("http://localhost:8989/client/updateClient",this.editClientForm).then(
              res=>{
                this.searchButtonClick()
                this.$message({
                  message: '更新成功',
                  type: 'success'
                });
                this.dialogFormVisibleForEditClient =false;
                this.getCreatePersonBeforeSelect();
                this.getClientTypeBeforeSelect();
              }
          )
        } else {
          return false;
        }
      });

    },
    saveClientButtonClick(){
      this.clearSubmitForm();  //清除已经输入的内容
      this.dialogFormVisibleForSaveClient = true;
    },
    searchButtonClick(){ // 查询按钮点击
      console.log("dafasd");
      console.log(this.searchForm);
      let array = this.searchForm.searchCreateTime
      if(array!=null){
        this.searchForm.searchCreateTime = {beginTime:array[0],endTime:array[1]}
      }
      if(this.searchForm.label === "空"){ //如果为空 人为转成null
        this.searchForm.label = null;
      }
      if(this.searchForm.clientType === "空"){
        this.searchForm.clientType = null
      }
      if(this.searchForm.createPerson==="空"){
        this.searchForm.createPerson = null
      }



      // let array = this.searchForm.searchCreateTime
      // // delete this.searchForm[searchCreateTime]
      // this.searchForm[searchCreateTime] = {beginTime:array[0],endTime:array[1]}
      // console.log("更改后打印",this.searchForm);

      this.$http.post("http://localhost:8989/client/getClientsByConditions",this.searchForm).then(
          res=>{
            this.tableData = res.data;
            this.searchForm.searchCreateTime = array
            this.getCreatePersonBeforeSelect();
            this.getClientTypeBeforeSelect();
            this.$message({
              message: '搜索成功，搜出'+ this.tableData.length + "条内容",
              type: 'success'
            });
          }
      )
      this.searchForm.searchCreateTime = array

    },
    getCreatePersonBeforeSelect(){
      this.$http.get("http://localhost:8989/client/getAllCreatePerson").then(
          res=>{
            this.createPersonList =res.data;
          }
      )
      console.log("getCreatePersonBeforeSelect");
    },
    getClientTypeBeforeSelect(){
      this.$http.get("http://localhost:8989/client/getAllClientType").then(
          res=>{
            this.clientTypeList =res.data;
          }
      )
    }
  }


}
</script>

<!--添加客户的按钮位置 绝对定位-->
<style scoped>
#insertClientButton{
  right:30px;
  top:210px;
  position: absolute;
}
</style>