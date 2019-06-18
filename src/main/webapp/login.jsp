<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <!-- import CSS -->
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
</head>
<body>
<div id="app">
    <div>
        <el-input v-model="form.username" placeholder="请输入用户名"></el-input>
        <el-input v-model="form.password" placeholder="请输入密码"></el-input>

        <el-button @click="login">登录</el-button>

    </div>

</div>
</body>
<!-- import Vue before Element -->
<script src="https://unpkg.com/vue/dist/vue.js"></script>
<!-- import JavaScript -->
<script src="https://unpkg.com/element-ui/lib/index.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>

<script>
    new Vue({
        el: '#app',
        data: function () {
            return {
                visible: false,
                form: {
                    username: '',
                    password: ''
                }
            }
        },
        methods: {
            login: function () {
                axios.post('/admin/login', this.form).then(function (res) {
                    alert(res)
                })
            }
        }
    })

</script>
</html>
