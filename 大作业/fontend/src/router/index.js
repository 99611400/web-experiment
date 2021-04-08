import Vue from 'vue'
import VueRouter from 'vue-router'
import Index from "@/components/Index";
import List from "@/components/user/List";

Vue.use(VueRouter)

const routes = [
  {path:"/",redirect:'/userList'},
  {path:"/index",component:Index},
  {
    path:"/userList",
    component:List,
    // children:[
    //   {
    //     path: 'allClient',
    //     component: Collection
    //   },
    //   {
    //     path: 'trace',
    //     component: Trace
    //   }
    // ]
  }
]

const router = new VueRouter({
  routes
})

export default router
