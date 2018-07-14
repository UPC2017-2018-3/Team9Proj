<%@ Page Language="C#" AutoEventWireup="true" CodeFile="login.aspx.cs" Inherits="login" %>

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

    <link rel="stylesheet" href="http://m.sui.taobao.org/dist/css/sm.min.css">
    <link rel="stylesheet" href="http://m.sui.taobao.org/dist/css/sm-extend.min.css">
  </header>
  <body>
  <div class="page-group">
        <div class="page page-current">
            <form id="Form1" class="form-auth-small" runat="server">
		 <div class="content">
    <div class="list-block cards-list">
        <div class="card">
          <div class="card-header"  >
		  <div class="text" style="text-align:center;">登录
		  </div>
		  </div>
    <div class="card-content">
    <ul>
      <!-- Text inputs -->
      <li>
        <div class="item-content">
          <div class="item-media"><i class="icon icon-form-name"></i></div>
          <div class="item-inner">
            <div class="item-title label">姓名</div>
            <div class="item-input">
              <asp:TextBox type="text" class="form-control" runat="server"  placeholder="Your name" ID ="account"></asp:TextBox>
            </div>
          </div>
        </div>
      </li>
      
      <li>
        <div class="item-content">
          <div class="item-media"><i class="icon icon-form-password"></i></div>
          <div class="item-inner">
            <div class="item-title label">密码</div>
            <div class="item-input">
              <asp:TextBox TextMode="Password" class="form-control"  runat="server" placeholder="Password"  ID="password"></asp:TextBox>
            </div>
          </div>
        </div>
      </li>
     
    </ul>
  </div>
 
        </div>
       
    </div>
	<div class="content-block">
    <div class="row">
      <div class="col-100">
          <asp:Button ID="Button1" runat="server" type="submit" class="button button-fill button-dark" Text="登录" OnClick="Login_Click"/>

      </div>

    </div>
	
     </div>
	 <div >	
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
	<script type="text/javascript">
      $(document).on('click', '#button', function () 
{
      string Account = document.getElementById("account").value
      string Password = document.getElementById("password").value;
	  if (Account != String.Empty && Password != String.Empty)
        {
		   if(Account =="袁绍帅"&&Password=="123456")
		   {
		     $.toast("登录成功");
		   }
		}
	  
});
      </script>
</html>
