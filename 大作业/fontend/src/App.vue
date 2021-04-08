<template>
  <div id="app">
    <el-container>
      <el-col :span="2" >
        <el-menu
            default-active="2"
            class="el-menu-vertical-demo"
            @select="sideBarHandleSelect">
          <el-menu-item
              style="font-size: 12px"
              index="/userList">
            <i class="el-icon-user"></i>
            <span slot="title">用户管理</span>
          </el-menu-item>
        </el-menu>
      </el-col>

      <el-container>
        <el-header>
          <el-menu :default-active="activeIndex"  mode="horizontal" @select="handleSelect">
            <el-submenu index="user"   style="float: right">
              <template slot="title"><i class="el-icon-user-solid"></i></template>
              <el-menu-item index="2-1">选项1</el-menu-item>
              <el-menu-item index="2-2">选项2</el-menu-item>
              <el-menu-item index="2-3">选项3</el-menu-item>
            </el-submenu>

            <el-submenu index="notification"    style="float: right;margin-right: -20px">
              <template slot="title"><i class="el-icon-message-solid"></i></template>
              <el-menu-item index="2-1">选项1</el-menu-item>
              <el-menu-item index="2-2">选项2</el-menu-item>
              <el-menu-item index="2-3">选项3</el-menu-item>
            </el-submenu>
            <el-submenu index="phone"    style="float: right;margin-right: -20px">
              <template slot="title"><i class="el-icon-phone"></i></template>
              <el-menu-item index="2-1">选项1</el-menu-item>
              <el-menu-item index="2-2">选项2</el-menu-item>
              <el-menu-item index="2-3">选项3</el-menu-item>
            </el-submenu>
          </el-menu>

        </el-header>
        <el-main>
          <router-view/>
        </el-main>
      </el-container>
    </el-container>
  </div>


</template>

<script>
export default {

  data() {
    return {
      asideBarActiveIndex: '/index',
      clientBarActiveIndex: "all",
      activeIndex:"",

    };
  },
  created() {
    // 创建流程单的时候激活的值改为当前路由 否则会出现小bug
    this.asideBarActiveIndex = this.$router.currentRoute.fullPath;
  },
  methods: {
    sideBarHandleSelect(key, keyPath) {
      // console.log(key,typeof(key));
      // console.log(this.$router.currentRoute.fullPath,
      //             typeof(this.$router.currentRoute.fullPath));
      if(!(key === this.$router.currentRoute.fullPath)  ) {
        //   console.log("dasfasdfasfd")
        this.$router.push(key)
      }
    },
    clientHandleSelect(key, keyPath) {
      console.log(key); //all
      console.log(keyPath); // 0: "all"   length: 1
    },
    handleSelect(){
      
    }
  }
}
</script>

<style>

</style>
