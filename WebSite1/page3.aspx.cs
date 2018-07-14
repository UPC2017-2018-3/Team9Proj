using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data.SqlClient;

public partial class page3 : System.Web.UI.Page
{
    private string connStr = "Data Source=47.94.107.30;Initial Catalog=MBAMeetingRoom;User ID=admin;Password=123456";
    protected void Page_Load(object sender, EventArgs e)
    {

    }
    protected void Borrow_click(object sender, EventArgs e)
    {
        string b;
        string ward = this.textward.Text;
        switch (Session["time3"].ToString())
        {
            case "第1、2节课": b = "1,2,"; break;
            case "第3、4节课": b = "3,4,"; break;
            case "第5、6节课": b = "5,6,"; break;
            case "第7、8节课": b = "7,8,"; break;
            default: b = "9,10"; break;
        }
        if (ward != String.Empty)
        {

            string sql = "insert into tbMeetingRoomUse(MRID,UserID,MRURecDate,MRUUseDateS,MRUUseDateE,MRUUseNote,AdminReviewStatus,MRUUseTime) values('" + Session["jiaoshi"] + "','"+ Session["UserID"] + "','"+DateTime.Now.ToString()+"','" + Session["time1"] + "','"+ Session["time1"] + "','"+ ward+ "','"+' '+"','" + b+"')";
            SqlConnection conn = new SqlConnection(connStr);
            SqlCommand cmd = new SqlCommand(sql, conn);
            conn.Open();
            if (cmd.ExecuteNonQuery()==1)
            {
                Response.Write("<script>alert('借用成功！');location.href='page1.aspx';</script>");
            }
           
            conn.Close();
            //Response.Redirect("page1.aspx", true);
        }
        else
        {
            Response.Write("<script>alert('请填写借用原因！');</script>");
        }
    }
}