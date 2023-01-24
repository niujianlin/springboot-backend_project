# springboot-backend_project
连接数据库druid+mybatisplus+分页插件

# 前端请求可以在app.vue里这样写
```
<template>
  <div>
    111
    <thead>
      <tr>
        <th>ID</th>
        <th>姓名</th>
        <th>密码</th>
        <th>生日</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="item in userlist" :key="item.id">
        <td>{{ item.id }}</td>
        <td>{{ item.username }}</td>
        <td>{{ item.password }}</td>
        <td>{{ item.birthday }}</td>
      </tr>
    </tbody>

  </div>
</template>

<script>
export default {
  data() {
    return {
      userlist:[]
    }
  },
  created() {
    this.$http.get("user/findAll").then((response) => {
      this.userlist = response.data
    })
  },
}
</script>

<style>

</style>
```
