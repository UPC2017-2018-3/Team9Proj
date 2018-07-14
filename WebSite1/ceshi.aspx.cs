using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Data.SqlClient;
using System.Web.UI.WebControls;
using System.Collections;

public partial class ceshi : System.Web.UI.Page
{
    
    protected void Page_Load(object sender, EventArgs e)
    {
        //调用绑定数组的函数  
        bindrptarry();
        //调用绑定ArrayList的函数  
        bindrptarryList();
    }
    public void bindrptarry()

    {

        string strs = "li|wen|yuan";

        string[] str = strs.Split('|');

        rptarry.DataSource = str;

        rptarry.DataBind();

    }

    public void bindrptarryList()

    {

        string strs = "li|wen|yuan";

        string[] str = strs.Split('|');

        rptarryList.DataSource = arrayList();

        rptarryList.DataBind();

    }

    public ArrayList arrayList()

    {

        ArrayList aL = new ArrayList();

        aL.Add("liceshi");

        aL.Add("wenceshi");

        aL.Add("yuanceshi");

        return aL;

    }
}

