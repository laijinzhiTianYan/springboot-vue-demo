<template>
    <div>
        <table>
            <tr>
                <td>编号</td>
                <td>封面url</td>
                <td>书名</td>
                <td>作者</td>
                <td>出版日期</td>
            </tr>
            <tr v-for="item in books">
                <td>{{item.id}}</td>
                <td>{{item.cover}}</td>
                <td>{{item.title}}</td>
                <td>{{item.author}}</td>
                <td>{{item.date}}</td>
            </tr>
        </table>
    </div>
</template>

<script>
    export default {
        name: "Book",
        data(){
            return{
                books: []
            }
        },
        created() {
            const _this = this;
            axios.get('http://localhost:8181/book/findAll').then(function (resp) {
                // console.log(resp)
                _this.books = resp.data;
            })
        }
    }
</script>

<style scoped>

</style>
