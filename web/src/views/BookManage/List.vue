<template>
    <div>
        <el-table
            :data="tableData"
            border
            style="width: 100%">
            <el-table-column
                fixed
                prop="id"
                label="编号"
                width="150">
            </el-table-column>

            <el-table-column
                prop="title"
                label="书名"
                width="120">
            </el-table-column>
            <el-table-column
                prop="author"
                label="作者"
                width="120">
            </el-table-column>

            <el-table-column
                prop="press"
                label="出版社"
                width="120">
            </el-table-column>

            <el-table-column
                fixed="right"
                label="操作"
                width="100">
                <template slot-scope="scope">
                    <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
                    <el-button type="text" size="small">编辑</el-button>
                </template>
            </el-table-column>
        </el-table>


        <!--    添加分页 -->
        <el-pagination
            background
            layout="prev, pager, next"
            :page-size="5"
            :total="totalNum"
            @current-change="page"
        >
        </el-pagination>

    </div>
</template>

<script>
    export default {
        name: "List",
        methods: {
            handleClick(row) {
                console.log(row);
            },

            page(currentPage){
                // alert(currentPage)
                const _this = this;
                axios.get('http://localhost:8181/book/findAll/' + currentPage + '/5').then((resp) => {
                    _this.tableData = resp.data.content;
                    _this.totalNum = resp.data.totalElements;
                })
            }
        },
        created(){ // 初始化页面时就调用该函数
            const _this = this;
            axios.get('http://localhost:8181/book/findAll/1/5').then(function (resp) {
                // console.log(resp)
                _this.tableData = resp.data.content;
                _this.totalNum = resp.data.totalElements;
            })
        },
        data() {
            return {
                totalNum: null,
                tableData: null
            }
        }
    }
</script>
