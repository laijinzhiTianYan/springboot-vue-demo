<template>
    <div id="app">
<!--        <el-container style="height: 500px; border: 1px solid #eee">-->

<!--            <el-aside width="200px" style="background-color: rgb(238, 241, 246)">-->

<!--                <el-menu :default-openeds="['1']">-->
<!--                    <el-submenu index="1">-->
<!--                        <template slot="title"><i class="el-icon-message"></i>导航一</template>-->
<!--                        <el-menu-item index="1-1">选项1</el-menu-item>-->
<!--                        <el-menu-item index="1-2">选项2</el-menu-item>-->
<!--                    </el-submenu>-->

<!--                    <el-submenu index="2">-->
<!--                        <template slot="title"><i class="el-icon-setting"></i>导航二</template>-->
<!--                        <el-menu-item index="2-1">选项3</el-menu-item>-->
<!--                        <el-menu-item index="2-2">选项4</el-menu-item>-->
<!--                    </el-submenu>-->

<!--                </el-menu>-->

<!--                动态设置 menu  注意 index 属性必须是 字符串类型的 -->
<!--                <el-menu>-->
<!--                    <el-submenu v-for="(item, index) in $router.options.routes" :index="index + ''">-->
<!--                        <template slot="title"><i class="el-icon-message"></i>{{item.name}}</template>-->
<!--                        <el-menu-item v-for="(item2, index2) in item.children" :index="index + '-' + index2">{{item2.name}}</el-menu-item>-->
<!--                    </el-submenu>-->
<!--                </el-menu>-->

<!--            </el-aside>-->

<!--            <el-container>-->
<!--                <el-header style="text-align: right; font-size: 12px">-->
<!--                    <el-dropdown>-->
<!--                        <i class="el-icon-setting" style="margin-right: 15px"></i>-->
<!--                        <el-dropdown-menu slot="dropdown">-->
<!--                            <el-dropdown-item>查看</el-dropdown-item>-->
<!--                            <el-dropdown-item>新增</el-dropdown-item>-->
<!--                            <el-dropdown-item>删除</el-dropdown-item>-->
<!--                        </el-dropdown-menu>-->
<!--                    </el-dropdown>-->
<!--                    <span>王小虎</span>-->
<!--                </el-header>-->


<!--                <el-main>-->
<!--                    <router-view/>-->
<!--                </el-main>-->
<!--            </el-container>-->

<!--        </el-container>-->

                <router-view/>
    </div>
</template>

<style>
    .el-header {
        background-color: #B3C0D1;
        color: #333;
        line-height: 60px;
    }

    .el-aside {
        color: #333;
    }
</style>

<script>
    export default {
        data() {
            return {}
        }
    };
</script>


