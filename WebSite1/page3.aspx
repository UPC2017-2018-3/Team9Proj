<%@ Page Language="C#" AutoEventWireup="true" CodeFile="page3.aspx.cs" Inherits="page3" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<header class="bar bar-nav">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>MBA教室管理系统</title>
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
             <form  name="myForm" runat="server">
		<header class="bar bar-nav">
              <a class="button button-link button-nav pull-left" href="/page2.aspx">
                  <span class="icon icon-left"></span>
                  返回
              </a>
              <h1 class="title">借用说明</h1>
          </header>
		<div class="content">
		 <div class="list-block">
    <ul>
	 <li class="align-top">
        <div class="item-content">
          <div class="item-media"><i class="icon icon-form-comment"></i></div>
          <div class="item-inner">
            <div class="item-input">
              <asp:TextBox  class="form-control"  runat="server" style="height:6rem" TextMode="MultiLine" ID="textward"></asp:TextBox>
            </div>
          </div>
        </div>
      </li>
	</ul>
  </div>
  <div class="content-block">
    <div class="row">
      <div class="col-100">
         <%-- <a href="#" class="button button-fill button-dark" id="button">确定</a>--%>
          <asp:Button ID="Button3" runat="server" type="submit" class="button button-fill button-dark" Text="确定" OnClick="Borrow_click"/>
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
	<script type="text/javascript">
       
      </script>
</html>
