<%@ Page Language="C#" AutoEventWireup="true" CodeFile="page2.aspx.cs" Inherits="page2" EnableEventValidation="false"%>

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
               <form  name="myForm" runat="server">
                   <asp:Repeater ID="Repeater1" runat="server"  OnItemDataBound="Repeater1_ItemDataBound">
           <ItemTemplate>
	<div class="card">
    <div class="card-header"><%#Eval("MRName")%>
        <asp:HiddenField ID="HiddenField1" runat="server" Value='<%#Eval("MRID") %>' /> 
	</div>
    <div class="card-content">
      <div class="card-content-inner">
	  <div class="list-block">
	   <ul>
           <asp:Repeater ID="Repeater2" OnItemCommand="Repeater1_ItemCommand" runat="server"> 
                    <ItemTemplate> 
                        <li>
                         <div class="item-content">
		                 <div class="item-media"><i class="icon icon-f7"></i></div>
                         <div class="item-inner">
                         <div class="item-title">
                             <%# GetDataItem()%>
                         </div>
			             <div class="item-after">
                             <%--<a href="#" class="button button-dark">选择</a>--%>
                            <asp:Button ID="selete" class="button  button-fill button-danger" runat="server" Text="选择" OnCommand="select_Click" CommandArgument='<%# GetDataItem()+","+DataBinder.Eval(((RepeaterItem)Container.Parent.Parent).DataItem, "MRID")%>' CommandName="CommuntSelete"></asp:Button>
			             </div>
                         </div>
                         </div>
                       </li>
                    </ItemTemplate> 
                </asp:Repeater> 	   		
		 </ul>
		 </div>
	  </div>
    </div>
  
  </div>
                </ItemTemplate>
    </asp:Repeater>
                    </form>
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
