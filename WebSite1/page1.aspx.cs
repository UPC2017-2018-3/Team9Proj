using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data.SqlClient;

public partial class page1 : System.Web.UI.Page
{
    private int id = 0;
    private string connStr = "Data Source=47.94.107.30;Initial Catalog=MBAMeetingRoom;User ID=admin;Password=123456";
    protected void Page_Load(object sender, EventArgs e)
    {
        string connStr = "Data Source=47.94.107.30;Initial Catalog=MBAMeetingRoom;User ID=admin;Password=123456";
        string sql = "select * from tbMeetingRoomUse,tbMeetingRoom where UserID='" + Session["UserID"] + "'";
        SqlConnection conn = new SqlConnection(connStr);
        conn.Open();
        SqlCommand cmd = new SqlCommand(sql, conn);

        Repeater1.DataSource = cmd.ExecuteReader(System.Data.CommandBehavior.CloseConnection);
        Repeater1.DataBind();
        conn.Close();

    }
    protected void time_click(object sender, EventArgs e)
    {
        string picker1 = this.picker1.Text;
        string picker2 = this.picker2.Text;

        if (picker1 != String.Empty)
        {
            //string[] usedTimes = picker1.TrimEnd(',').Split(',');
            Session["time1"] = picker1;
            Session["time2"] = picker2;
            Response.Redirect("page2.aspx", true);
        }
        else
        {
            Response.Write("<script>alert('请选择查询日期！');</script>");
        }
        }
    protected void update_password(object sender, EventArgs e)
    {
        string password1 = this.password1.Text;
        string password2 = this.password2.Text;
        if (password1 != String.Empty && password2 != String.Empty)
        {
            try
            {
                if (password1.Equals(password2))
                {
                    string sqlStr = "UPDATE tbUser SET UserPWD='" + password2 + "'where UserID='" + Session["UserID"] + "'";
                    SqlConnection conn = new SqlConnection(connStr);
                    conn.Open();
                    SqlCommand cmd = conn.CreateCommand();
                    cmd.CommandText = sqlStr;
                    cmd.ExecuteNonQuery();
                    conn.Close();
                    Response.Write("<script>alert('密码修改成功！');</script>");
                }
                else

                {
                    Response.Write("<script>alert('对不起！密码不一致');</script>");
                }
            }
            catch
            {
                Response.Write("<script>alert('修改密码失败，请您稍后再试！');</script>");
            }
        }
        else
        {
            Response.Write("<script>alert('请确认是否输入新密码！');</script>");
        }
    }
    protected  string showNull(string a)
        {
        if (a == " ")
        {
            return "还未收到回复";
        }
        else
        {
            return a;
        }
        }
    protected void deletequestionOption_Click(object sender, CommandEventArgs e)
    {

        if ((sender as System.Web.UI.WebControls.Button).Text == "Cancel")
        {

            id = int.Parse(e.CommandArgument.ToString());
            this.DeleteRepeater(id);
            Response.Write("<script>alert('删除成功');</script>");
        }
    }
    private void DeleteRepeater(int intId)
    {
        using (SqlConnection sqlCon = new SqlConnection(connStr))
        {
            sqlCon.Open(); //打开数据库连接 

            SqlCommand sqlcom = sqlCon.CreateCommand();  //创建数据库命令对象 
            sqlcom.CommandText = "delete from tbMeetingRoomUse where MRUID=@id"; //为命令对象指定执行语句 
            sqlcom.Connection = sqlCon; //为命令对象指定连接对象 

            //创建参数集合,并向sqlcom中添加参数集合 
            SqlParameter sqlParam = new SqlParameter("@id", intId);
            sqlcom.Parameters.Add(sqlParam);

            sqlcom.ExecuteNonQuery();  //指定更新语句 
            sqlCon.Close();

        }
    }
    protected string status(string a, string b)
    {
        string[]  borrowDates,borrowTimes;
        int timeEnd, endTime;
        int[] iborrowDates = new int[3];
        borrowDates = a.ToString().Split(' ')[0].Split('/');
        borrowTimes =b.ToString().TrimEnd(',').Split(',');
        timeEnd = int.Parse(borrowTimes[borrowTimes.Length - 1]);
        for (int j = 0; j < borrowDates.Length; j++)
        {
            iborrowDates[j] = int.Parse(borrowDates[j]);
        }
        switch (timeEnd)
        {
            case 2: endTime = 10; break;
            case 4: endTime = 12; break;
            case 6: endTime = 16; break;
            case 8: endTime = 18; break;
            case 10: endTime = 21; break;
            default: endTime = 0; break;
        }
        DateTime t = new DateTime(iborrowDates[0], iborrowDates[1], iborrowDates[2], endTime, 0, 0);
        if (DateTime.Compare(t, DateTime.Now) < 0)
        {
            return "已完成";
        }
        else
        {
            return "未完成";
        }
    }
     protected string xiugai(string a)
    {
        string[] b = a.Split(' ');
        return b[0];
    }

}