(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-8719"],{"/F/r":function(e,t,a){"use strict";a.r(t);var n=a("gC3c"),r={data:function(){return{listLoading:!0,list:null,total:0,page:1,limit:10,searchObj:{}}},created:function(){this.fetchData()},methods:{fetchData:function(){var e=this,t=arguments.length>0&&void 0!==arguments[0]?arguments[0]:1;console.log("翻页。。。"+t),this.page=t,n.a.getUserInfoList(this.page,this.limit,this.searchObj).then(function(t){e.list=t.data.records,e.total=t.data.total,e.listLoading=!1})},changeSize:function(e){console.log(e),this.limit=e,this.fetchData(1)},resetData:function(){console.log("重置查询表单"),this.searchObj={},this.fetchData()},lock:function(e,t){var a=this;this.$confirm("确定该操作吗?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){return n.a.lock(e,t)}).then(function(e){a.fetchData(a.page),e.code&&a.$message({type:"success",message:"操作成功!"})})}}},l=a("KHd+"),o=Object(l.a)(r,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"app-container"},[a("el-form",{staticClass:"demo-form-inline",attrs:{inline:!0}},[a("el-form-item",[a("el-input",{attrs:{placeholder:"姓名/手机"},model:{value:e.searchObj.keyword,callback:function(t){e.$set(e.searchObj,"keyword",t)},expression:"searchObj.keyword"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"创建时间"}},[a("el-date-picker",{attrs:{type:"datetime",placeholder:"选择开始时间","value-format":"yyyy-MM-dd HH:mm:ss","default-time":"00:00:00"},model:{value:e.searchObj.createTimeBegin,callback:function(t){e.$set(e.searchObj,"createTimeBegin",t)},expression:"searchObj.createTimeBegin"}})],1),e._v("\n        至\n        "),a("el-form-item",[a("el-date-picker",{attrs:{type:"datetime",placeholder:"选择截止时间","value-format":"yyyy-MM-dd HH:mm:ss","default-time":"00:00:00"},model:{value:e.searchObj.createTimeEnd,callback:function(t){e.$set(e.searchObj,"createTimeEnd",t)},expression:"searchObj.createTimeEnd"}})],1),e._v(" "),a("el-button",{attrs:{type:"primary",icon:"el-icon-search"},on:{click:function(t){e.fetchData()}}},[e._v("查询")]),e._v(" "),a("el-button",{attrs:{type:"default"},on:{click:function(t){e.resetData()}}},[e._v("清空")])],1),e._v(" "),a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.listLoading,expression:"listLoading"}],staticStyle:{width:"100%"},attrs:{data:e.list,stripe:""}},[a("el-table-column",{attrs:{label:"序号",width:"70",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v("\n                    "+e._s((e.page-1)*e.limit+t.$index+1)+"\n            ")]}}])}),e._v(" "),a("el-table-column",{attrs:{prop:"phoneNumber",label:"手机号"}}),e._v(" "),a("el-table-column",{attrs:{prop:"userName",label:"昵称"}}),e._v(" "),a("el-table-column",{attrs:{prop:"userName",label:"姓名"}}),e._v(" "),a("el-table-column",{attrs:{prop:"sex",label:"性别"}}),e._v(" "),a("el-table-column",{attrs:{prop:"sex",label:"年龄"}}),e._v(" "),a("el-table-column",{attrs:{prop:"userId",label:"家庭编号"}}),e._v(" "),a("el-table-column",{attrs:{prop:"email",label:"邮箱"}}),e._v(" "),a("el-table-column",{attrs:{label:"状态",prop:"param.statusString"}}),e._v(" "),a("el-table-column",{attrs:{label:"认证状态",prop:"param.authStatusString"}}),e._v(" "),a("el-table-column",{attrs:{prop:"createTime",label:"创建时间"}}),e._v(" "),a("el-table-column",{attrs:{label:"操作",width:"200",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("router-link",{attrs:{to:"/user/userInfo/show/"+t.row.id}},[a("el-button",{attrs:{type:"primary",size:"mini"}},[e._v("查看")])],1),e._v(" "),a("router-link",{attrs:{to:"/user/userInfo/"+t.row.id}},[a("el-button",{attrs:{type:"primary",size:"mini",icon:"el-icon-edit"}})],1),e._v(" "),1==t.row.status?a("el-button",{attrs:{type:"primary",size:"mini"},on:{click:function(a){e.lock(t.row.id,0)}}},[e._v("锁定")]):e._e(),e._v(" "),0==t.row.status?a("el-button",{attrs:{type:"danger",size:"mini"},on:{click:function(a){e.lock(t.row.id,1)}}},[e._v("取消锁定")]):e._e()]}}])})],1),e._v(" "),a("el-pagination",{staticStyle:{padding:"30px 0","text-align":"center"},attrs:{"current-page":e.page,total:e.total,"page-size":e.limit,"page-sizes":[5,10,20,30,40,50,100],layout:"sizes, prev, pager, next, jumper, ->, total, slot"},on:{"current-change":e.fetchData,"size-change":e.changeSize}})],1)},[],!1,null,null,null);o.options.__file="list.vue";t.default=o.exports},gC3c:function(e,t,a){"use strict";var n=a("t3Un");t.a={updateUserInfo:function(e){return Object(n.a)({url:"/admin/userInfo/updateUserInfo",method:"post",data:e})},saveUserInfo:function(e){return Object(n.a)({url:"/admin/userInfo/save",method:"post",data:e})},getUserInfoList:function(e,t,a){return Object(n.a)({url:"/admin/userInfo/findPageUserInfo/"+e+"/"+t,method:"post",data:a})},deleteUserInfoList:function(e){return Object(n.a)({url:"/admin/userInfo/"+e,method:"delete"})},batchdeleteUserInfoList:function(e){return Object(n.a)({url:"/admin/userInfo/batchRemoveUserInfo/",method:"delete",data:e})},getUserInfo:function(e){return Object(n.a)({url:"/admin/userInfo/"+e,method:"get"})}}}}]);