<template>
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
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
            <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
            <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
    </el-form>

</template>

<script>
    export default {
        name: "Add",
        data() {
            return {
                ruleForm: {
                    title: '',
                    author: '',
                    abs: ''
                },
                rules: {
                    title: [
                        { required: true, message: '请输入书名', trigger: 'blur' }
                    ],
                    author: [
                        { required: true, message: '请输入作者', trigger: 'blur' }
                    ],
                    abs: [
                        { required: true, message: '请输入内容简介', trigger: 'blur' }
                    ]
                }
            };
        },
        methods: {
            submitForm(formName) {
                const _this = this;
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        //
                        axios.post('http://localhost:8181/book/save', _this.ruleForm).then( (resp) => {
                            if (resp != null){
                                _this.$message({
                                    message: '恭喜你，添加成功',
                                    type: 'success'
                                });
                                _this.resetForm(formName);
                            }else
                                this.$message.error('添加失败');
                        })
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            }
        }
    }
</script>

<style scoped>

</style>
