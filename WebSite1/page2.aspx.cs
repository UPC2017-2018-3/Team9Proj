using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data.SqlClient;
using System.Data;
using System.Collections;

public partial class page2 : System.Web.UI.Page
{
    private string connStr = "Data Source=47.94.107.30;Initial Catalog=MBAMeetingRoom;User ID=admin;Password=123456";
    protected void Page_Load(object sender, EventArgs e)
    {
        string sql = "select * from tbMeetingRoom where MRStatus = 'open'";
        SqlConnection conn = new SqlConnection(connStr);
        conn.Open();
        SqlCommand cmd = new SqlCommand(sql, conn);

        Repeater1.DataSource = cmd.ExecuteReader(System.Data.CommandBehavior.CloseConnection);
        Repeater1.DataBind();
    }
    protected void Repeater1_ItemDataBound(object sender, RepeaterItemEventArgs e)
    {
        
        if (e.Item.ItemType == ListItemType.Item || e.Item.ItemType == ListItemType.AlternatingItem)
        {
            string a;
            string b;
            string[] course = { "1,2,", "3,4,", "5,6,", "7,8,", "9,10" };
            string[] course2 = { "第1、2节课", "第3、4节课", "第5、6节课", "第7、8节课", "第9、10节课" };
            switch (Session["time2"].ToString())
            {
                case "第1、2节课": b = "1,2,"; break;
                case "第3、4节课": b = "3,4,"; break;
                case "第5、6节课": b = "5,6,"; break;
                case "第7、8节课": b = "7,8,"; break;
                default: b = "9,10"; break;
            }
            Repeater rpt = (Repeater)e.Item.FindControl("Repeater2");
            HiddenField hf = (HiddenField)e.Item.FindControl("HiddenField1");
            a = hf.Value;
            
            //Session["time1"]时间1
            //Session["time2"]时间2
            if (Session["time2"] != String.Empty)
            {


                string sql1 = "select * from tbMeetingRoomUse where MRID ='" + a + "'and MRUUseTime = '" + b + "'and MRUUseDateS = '" + Session["time1"] + "'";
                SqlConnection con = new SqlConnection(connStr);
                con.Open();
                SqlDataAdapter sda = new SqlDataAdapter(sql1, con);
                DataSet ds = new DataSet();
                sda.Fill(ds, "MRUUseTime");
                string[] times = new string[5];
                for (int i = 0; i < ds.Tables[0].Rows.Count; i++)
                {
                    times[i] = ds.Tables[0].Rows[i]["MRUID"].ToString();
                }
                if (ds.Tables[0].Rows.Count != 0)
                {
                    string[] strs = { "当前时段不可借" };
                    rpt.DataSource = strs;
                    rpt.DataBind();
                }
                else
                {
                    string c;
                    string[] aa = new string[1];
                    switch (Session["time2"].ToString())
                    {
                        case "第1、2节课": c = "第1、2节课"; break;
                        case "第3、4节课": c = "第3、4节课"; break;
                        case "第5、6节课": c = "第5、6节课"; break;
                        case "第7、8节课": c = "第7、8节课"; break;
                        default: c = "第9、10节课"; break;
                    }
                    aa[0] = c;
                    rpt.DataSource = aa;
                    rpt.DataBind();
                }
                con.Close();
            }
            else
            {
                string sql2 = "select MRUUseTime from tbMeetingRoomUse where MRID ='" + a + "'and MRUUseDateS = '" + Session["time1"] + "'";
                SqlConnection conn = new SqlConnection(connStr);
                conn.Open();
                SqlDataAdapter sda = new SqlDataAdapter(sql2, conn);
                DataSet dss = new DataSet();
                sda.Fill(dss, "MRUUseTime");
                string[] times2 = new string[dss.Tables[0].Rows.Count];
                for (int i = 0; i < dss.Tables[0].Rows.Count; i++)
                {
                    times2[i] = dss.Tables[0].Rows[i]["MRUUseTime"].ToString();
                }
                if (dss.Tables[0].Rows.Count == 5)
                {
                    string[] strs = { "当前时段不可借" };
                    rpt.DataSource = strs;
                    rpt.DataBind();
                }
                else
                {
                    string[] newcourse =new string[5-dss.Tables[0].Rows.Count];
                    int k = 0;
                    for (int i = 0; i < 5; i++)
                    {
                        int what = 0;
                        for (int j = 0; j < dss.Tables[0].Rows.Count; j++)
                        {
                            
                            if (course[i] == dss.Tables[0].Rows[j]["MRUUseTime"].ToString())
                            {
                                what = 1;
                            }
                        }
                        if (what == 0)
                        {

                            newcourse[k] = course2[i];
                            k++;
                        }
                      
                    }
                    rpt.DataSource = newcourse;
                    rpt.DataBind();

                }
                conn.Close();

            }
        }
    }
    protected void Repeater1_ItemCommand(object source, RepeaterCommandEventArgs e)
    {
        //if (e.CommandName == "CommuntSelete")
        //{
        //     HiddenField hf = (HiddenField)e.Item.FindControl("HiddenField1");
        //     string Cid = hf.Value;
        //    Response.Write("<script>alert('确认选择');</script>");
        //}
    }
    protected void select_Click(object sender, CommandEventArgs e)
    {

       if ((sender as System.Web.UI.WebControls.Button).Text == "选择")
       {
            string[] estr = e.CommandArgument.ToString().Split(',');
            if (estr[0] == String.Empty || estr[0] == "当前时段不可借")
            {
                Response.Write("<script>alert('请重新选择时间');location.href='page1.aspx'</script>");
                //Response.Redirect("page1.aspx", true);
            }
            else
            {
                Session["time3"] = estr[0];
                Session["jiaoshi"] = estr[1];
                Response.Write("<script>alert('确认选择');location.href='page3.aspx'</script>");
                //Response.Redirect("page3.aspx", true);
            }
                
           
        }
    }

}