<template>
    <div>
        <el-table ref="multipleTable" :data="tableData" tooltip-effect="dark" border style="width: 100%" @selection-change="handleSelectionChange">
            <el-table-column type="selection" width="55"></el-table-column>

            <el-table-column fixed prop="id" label="编号" width="100"></el-table-column>

            <el-table-column fixed prop="cover" label="封面" width="150">
                <!-- 封面图片的显示 -->
                <template   slot-scope="scope">
                    <img :src="scope.row.cover"  min-width="100" height="70" />
                </template>
            </el-table-column>

            <el-table-column prop="title" label="书名" width="150"></el-table-column>

            <el-table-column prop="author" label="作者" width="150"></el-table-column>

            <el-table-column prop="press" label="出版社" width="150"></el-table-column>

            <el-table-column
                fixed="right"
                label="操作">
                <template slot-scope="scope">
                    <el-button @click="handleEdit(scope.row)" type="text" size="small">修改</el-button>
                    <el-button @click="deletes(scope.row)" type="text" size="small">删除</el-button>
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
            deletes(row){
                const _this = this;
                axios.delete('http://localhost:8181/book/delete/' + row.id).then(function (resp) {
                    if (resp.data == 'success'){
                        _this.$message({
                            showClose: true,
                            message: '编号为 ' + row.id + ' 的书删除成功',
                            type: 'success'
                        });
                    } else
                        _this.$message({
                            showClose: true,
                            message: '编号为 ' + row.id + ' 的书删除失败',
                            type: 'error'
                        });
                    // 删除之后，因为当前页面本身就是 /list，所以不能通过 push 路由的方式刷新页面
                    window.location.reload();

                })
            },

            handleEdit(row) {
                // this.$router.push('/update') // 这种方式只支持 跳转的 url
                // 我们不仅需要 目标跳转url，而且需要 传递参数id
                this.$router.push({
                    path: '/update', // 格式固定，必须是 path，query
                    query: {
                        id: row.id
                    }
                })
            },

            page(currentPage){
                // alert(currentPage)
                const _this = this;
                axios.get('http://localhost:8181/book/findAll/' + currentPage + '/5').then((resp) => {
                    _this.tableData = resp.data.content;
                    _this.totalNum = resp.data.totalElements;
                })
            },

            handleSelectionChange(val) {
                this.multipleSelection = val;
            },

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
                tableData: null,

            }
        }
    }
</script>
