using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Diagnostics;
using System.Data;
using System.Data.SqlClient;
using System.Configuration;
using System.Collections;
using System.Net;

public partial class login : System.Web.UI.Page
{
    private string connStr = "Data Source=47.94.107.30;Initial Catalog=MBAMeetingRoom;User ID=admin;Password=123456";
    protected void Page_Load(object sender, EventArgs e)
    {

    }
    protected void Login_Click(object sender, EventArgs e)
    {
        string Account = this.account.Text;
        string Password = this.password.Text;
       
        if (Account != String.Empty && Password != String.Empty)
        {
            string sql = "select UserID from tbUser where UserLoginName='" + Account + "' and UserPWD='" + Password + "'";
            SqlConnection conn = new SqlConnection(connStr);
            SqlCommand cmd = new SqlCommand(sql, conn);
            conn.Open();
            string a = cmd.ExecuteScalar().ToString();
            try
            {

                
                Session["UserID"] = a;
                Response.Redirect("page1.aspx", true);

            }
            catch (Exception)
            {
                Response.Write("<script>alert('登陆失败')</script>");
            }
            finally
            {
                conn.Close();
            }

        }
        else
        {
            Response.Write("<script>alert('用户名和密码不可为空！');</script>");
        }
    }
}