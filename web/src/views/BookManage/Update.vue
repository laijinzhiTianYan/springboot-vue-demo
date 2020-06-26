<template>
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">

        <el-form-item label="编号">
            <el-input v-model="ruleForm.id" readonly></el-input>
        </el-form-item>

        <el-form-item prop="cover" label="封面" >
            <!-- 封面图片的显示 -->
                <img :src="ruleForm.cover"  min-width="100" height="100" />
        </el-form-item>

        <el-form-item label="书名" prop="title">
            <el-input v-model="ruleForm.title"></el-input>
        </el-form-item>

        <el-form-item label="作者" prop="author">
            <el-input v-model="ruleForm.author"></el-input>
        </el-form-item>

        <el-form-item label="内容简介" prop="abs">
            <el-input v-model="ruleForm.abs"></el-input>
        </el-form-item>

        <el-form-item>
            <el-button type="primary" @click="submitUpdate('ruleForm')">修改</el-button>
            <el-button @click="cancelUpdate('ruleForm')">取消</el-button>
        </el-form-item>
    </el-form>
</template>

<script>
    export default {
        name: "Update",
        data() {
            return {
                ruleForm: {
                    id: '',
                    cover: '',
                    title: '',
                    author: '',
                    abs: ''
                },
                rules: {
                    title: [
                        {required: true, message: '请输入书名', trigger: 'blur'}
                    ],
                    author: [
                        {required: true, message: '请输入作者', trigger: 'blur'}
                    ],
                    abs: [
                        {required: true, message: '请输入内容简介', trigger: 'blur'}
                    ]
                }
            }
        },
        methods: {
            submitUpdate(formName) {
                const _this = this;
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        //
                        axios.put('http://localhost:8181/book/update', _this.ruleForm).then((resp) => {
                            if (resp.data == 'success') {
                                _this.$alert('编号为 ' + _this.ruleForm.id + ' 的书修改成功', '消息', {
                                    confirmButtonText: '确定',
                                    callback: action => {
                                        // 添加成功后，我们让页面自动跳转到 查询列表页面
                                        // 同时让 页面跳转到 查询列表界面
                                        // 先获取当前 路由，然后 push 进你的跳转目标页面
                                        // _this.$router.push('/list')
                                    }
                                });
                                _this.cancelUpdate(formName);
                            } else
                                this.$message.error('修改失败');
                        })
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            },
            cancelUpdate(formName) {
                this.$router.push('/list'); // 返回list页面
            }
        },

        created() {
            // this.$route.query.id;   // $route 是拿的参数，$router是拿的跳转的路径
            const _this = this;
            axios.get('http://localhost:8181/book/findById/' + this.$route.query.id).then(function (resp) {
                _this.ruleForm = resp.data;
            })
        }
    }
</script>

<style scoped>

</style>
