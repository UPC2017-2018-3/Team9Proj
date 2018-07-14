<%@ Page Language="C#" AutoEventWireup="true" CodeFile="ceshi.aspx.cs" Inherits="ceshi" %>

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
		<header class="bar bar-nav">
              <a class="button button-link button-nav pull-left" href="/page1.aspx">
                  <span class="icon icon-left"></span>
                  返回
              </a>
              <h1 class="title">教室中心</h1>
          </header>
		  <div class="content">
      <asp:Repeater ID="rptarry" runat="server" >

<HeaderTemplate><table></HeaderTemplate>

<ItemTemplate>

<tr><td> <%# GetDataItem()%> </td></tr>

</ItemTemplate>

<FooterTemplate></table></FooterTemplate>

</asp:Repeater>

<asp:Repeater ID="rptarryList" runat="server">

<HeaderTemplate><table></HeaderTemplate>

<ItemTemplate>

<tr><td> <%# GetDataItem()%> </td></tr>

</ItemTemplate>

<FooterTemplate></table></FooterTemplate>

</asp:Repeater>

  </div>
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
