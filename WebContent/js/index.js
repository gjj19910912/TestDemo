 Ext.onReady(function () {
              //复选框列
             var sm = new Ext.grid.CheckboxSelectionModel();
              //数据存储器  
    var ds = new Ext.data.Store({  
        proxy : new Ext.data.HttpProxy({  
            url : "gridData",  
            method : "post"  
        }),  
        reader : new Ext.data.JsonReader({    //读取json数据   
                    root : "users",  
                    totalProperty : 'totalProperty' //总记录数  
                }, ["id", "clientId" ,"packageName"])  
    });  
    //创建列    
    var cm = new Ext.grid.ColumnModel([  
            sm,     //复选框     
            {  
                header : "编号",  
                dataIndex : "id",  
                sortable : true  
            }, {  
                header : "客户端Id",  
                dataIndex : "clientId",  
                width : 200  
            }, {  
                header : "应用包名",  
                dataIndex : "packageName",  
                width : 200  
            }]);  
    cm.defaultSortable = true;// 默认可排序  
              
              
              
              
              //添加按钮
              var tbtn = new Ext.Toolbar.Button({
                  text: '发送',
                  listeners: {
                      'click': function () {
                          var row = grid.getSelectionModel().getSelections();
                          if(row.length <= 0){
                        	  Ext.Msg.alert("提示", "请选择");
                          return;
                          }
                          var ids = "";
                          for (var i = 0; i < row.length; i++) {
                              ids += row[i].get('id') + ",";
                          }
                          Ext.Ajax.request({
                              url: 'sendInformations',
                              params: { ids:ids },
                              method: 'POST',
                              callback: function (options, success, response) {
                                  if (success) {
//                                      var responseJson = Ext.JSON.decode(response.responseText);
               
                                      Ext.Msg.alert("提示", "成功发送！");
                                  } else {
                                      Ext.Msg.confirm('失败',
                                                          '请求超时或网络故障,错误编号：[' + response.status + ']是否要重新发送？', function (btn) {
                                                              if (btn == 'yes') {
                                                                  Ext.Ajax.request(options);
                                                              }
                                                          });
                                  }
                              }
                          });
                      }
                  }
              });
             /* //分页控件
              var pager = new Ext.PagingToolbar({
                  pageSize: 2,
                  store: ds,
                  listeners: {
                      "beforechange": function (bbar, params) {
                          var grid = bbar.ownerCt;
                          var store = grid.getStore();
                          var start = params.start;
                          var limit = params.limit;
                          alert(store.getCount());
                          return false;
                      }
                  }
              });*/
              //列表
              var grid = new Ext.grid.GridPanel({
                  sm: sm,
                  title: 'GridPanel',
                  height: 200,
                  store: ds,
                  bbar: [tbtn],
                 // bbar: pager,
                  el: "grid",
                  colModel: cm
              });
               grid.render(); //组件渲染之后触发  
               ds.load();
         });