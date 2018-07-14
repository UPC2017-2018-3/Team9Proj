 <%@ Page Language="C#" AutoEventWireup="true" CodeFile="page1.aspx.cs" Inherits="page1" EnableEventValidation ="false" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<header class="bar bar-nav">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>MBA教师管理系统</title>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel="shortcut icon" href="/favicon.ico">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">

	<style type="text/css">
      .infinite-scroll-preloader {
        margin-top:-20px;
      }
      </style>
    <script type="text/javascript" runat="server">  
</script>  
    <link rel="stylesheet" href="http://m.sui.taobao.org/dist/css/sm.min.css">
    <link rel="stylesheet" href="http://m.sui.taobao.org/dist/css/sm-extend.min.css">
  </header>
  <body>
  <div class="page-group">
        <div class="page page-current">
		<header class="bar bar-nav">
  <h1 class='title' id="title">个人中心</h1>
</header>
<div class="content">
    <form  name="myForm" runat="server">
  <div class="buttons-tab">
    <a href="#tab1" class="tab-link active button">我的借用</a>
    <a href="#tab2" class="tab-link button">申请</a>
    <a href="#tab3" class="tab-link button">修改密码</a>
  </div>
  <div class="content-block">
    <div class="tabs">
      <div id="tab1" class="tab active">
        <div class="content-block">
       <asp:Repeater ID="Repeater1" runat="server">
           <ItemTemplate>
       <div class="card">
    <div class="card-header"><%#Eval("MRName")%>
	<div class="col-50"><%--<a href="#" class="button  button-fill button-danger">Cancel</a>--%>
        <asp:Button ID="delete" class="button  button-fill button-danger" runat="server" Text="Cancel"  CommandArgument='<%#Eval("MRUID")%>' OnCommand="deletequestionOption_Click"></asp:Button>
	</div>
	</div>
    <div class="card-content">
      <div class="card-content-inner"><%#showNull(Eval("AdminReviewStatus").ToString())%></div>
    </div>
    <div class="card-footer"><span><%#xiugai(Eval("MRUUseDateS").ToString())%></span>
      <span><%#status(Eval("MRUUseDateS").ToString(),Eval("MRUUseTime").ToString())%></span></div>
  </div>
       </ItemTemplate>
    </asp:Repeater>
        </div>
      </div>
      <div id="tab2" class="tab">
        <div class="content-block">
        
	  <div class="list-block">
        <ul>
          <!-- Text inputs -->
          <li>
            <div class="item-content">
              <div class="item-inner">
                <div class="item-title label" style="font-size:0.7rem">日期</div>
                <div class="item-input">
                  <%--<input  type="date" placeholder="选择日期" value="2014-04-30" id='picker1'  />--%>
                  <asp:TextBox ID="picker1" type="date" runat="server"  data-rules="required" autocomplete="off"></asp:TextBox>
                </div>
              </div>
            </div>
          </li>
        </ul>
		<ul>
          <!-- Text inputs -->
          <li>
            <div class="item-content">
              <div class="item-inner">
                <div class="item-title label" style="font-size:0.7rem">时段</div>
                <div class="item-input">
                  <%--<input type="text" placeholder="选择时段" id='picker2' />--%>
                   <asp:TextBox ID="picker2" type="text" runat="server" placeholder="选择时段" data-rules="required" autocomplete="off"></asp:TextBox>
                </div>
              </div>
            </div>
          </li>
        </ul>
		
      </div>
        </div>
		<div class="row">
      <div class="col-100">
          <asp:Button ID="Button" runat="server" type="submit" class="button button-fill button-dark" Text="确定" OnClick="time_click"/>
      </div>

    </div>
      </div>
      <div id="tab3" class="tab">
        <div class="content-block">
          <div class="list-block">
		<ul>
          <!-- Text inputs -->
          <li>
            <div class="item-content">
              <div class="item-inner">
                <div class="item-title label" style="font-size:0.7rem">输入密码</div>
                <div class="item-input">
                  <asp:TextBox TextMode="Password" class="form-control"  runat="server" placeholder="New Password"  ID="password1"></asp:TextBox>
                </div>
              </div>
            </div>
          </li>
        </ul>
		<ul>
          <!-- Text inputs -->
          <li>
            <div class="item-content">
              <div class="item-inner">
                <div class="item-title label" style="font-size:0.7rem">确认密码</div>
                <div class="item-input">
                  <asp:TextBox TextMode="Password" class="form-control"  runat="server" placeholder="New Password"  ID="password2"></asp:TextBox>
                </div>
              </div>
            </div>
          </li>
        </ul>
		
    
	

        </div>
      </div>
	  <div class="row">
      <div class="col-100">
       <asp:Button ID="Button1" runat="server" type="submit" class="button button-fill button-dark" Text="确定" OnClick="update_password"/>
      </div>
    </div>
    </div>
  </div>
</div>
        </form>
  </div>
   
  </div>
 
   <script type='text/javascript' src='http://g.alicdn.com/sj/lib/zepto/zepto.min.js' charset='utf-8'></script>
    <script type='text/javascript' src='http://m.sui.taobao.org/dist/js/sm.js' charset='utf-8'></script>
    <script type='text/javascript' src='http://m.sui.taobao.org/dist/js/sm-extend.js' charset='utf-8'></script>
    <script>
        $.init();
    </script>
  </body>
    //交互部分
	<script>
      

	  $('#picker2').picker({
  toolbarTemplate: '<header class="bar bar-nav">\
  <button class="button button-link pull-left close-picker">取消</button>\
  <button class="button button-link pull-right close-picker">确定</button>\
  <h1 class="title">周次</h1>\
  </header>',
  cols: [
    {
      textAlign: 'center',
      values: ['第1、2节课','第3、4节课', '第5、6节课', '第7、8节课', '第9、10节课']
    }
  ]
        });
        $('#picker1').datepicker({ size: "small", startDate: "<%=DateTime.Now.ToShortDateString()%>" });
      
      </script>
</html>
