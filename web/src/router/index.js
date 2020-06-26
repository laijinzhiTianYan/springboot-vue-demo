import Vue from 'vue'
import VueRouter from 'vue-router'

// 引入 示例 页面
import List from "../views/BookManage/List";
import Add from "../views/BookManage/Add";
import Update from "../views/BookManage/Update";

import Home from "../views/Home";

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: '图书管理',
        component: Home,
        show: true, // 控制是否遍历这个路由
        redirect: '/list',   // 当我们访问路径是 '/' 时，会自动跳转到 /list 的路由
        children: [
            {
                path: '/list',
                name:　'查询图书',
                component: List
            },
            {
                path: '/add',
                name: '添加图书',
                component: Add
            }
        ]
    },
    {
        path: '/update',
        name: '修改图书',
        show: false,
        component: Update
    }


]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router
